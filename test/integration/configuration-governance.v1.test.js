/* eslint-disable no-console */
/**
 * (C) Copyright IBM Corp. 2020.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

'use strict';
const ConfigurationGovernanceV1 = require('../../dist/configuration-governance/v1');
const { readExternalSources } = require('ibm-cloud-sdk-core');
const authHelper = require('../resources/auth-helper.js');
const { v4: uuidv4 } = require('uuid');

// testcase timeout value (25s).
const timeout = 25000;

// Location of our config file.
const configFile = 'configuration_governance.env';

const describe = authHelper.prepareTests(configFile);

const verbose = true;
let configurationGovernanceService;
let configurationGovernanceServiceNoAccess;

let TEST_LABEL;
let ACCOUNT_ID;
let TEST_SERVICE_NAME;
let ENTERPRISE_SCOPE_ID;
let SUBACCT_SCOPE_ID;

// Generate a txn-id to be used during this test run.
const transactionId = uuidv4();

// Variables to hold various id's and object instances (these could perhaps be configured via links).
let ruleId1;
let rule1;
let ruleEtag1;
let ruleId2;

let sampleRule1;
let sampleRule2;
let badSampleRule;

let enterpriseScope;
let accountScope;
let badScope;

let attachmentId1;
let attachment1;
let attachmentEtag1;
let attachmentId2;

describe('ConfigurationGovernanceV1_integration', () => {
  jest.setTimeout(timeout);

  beforeAll(async done => {
    log('Starting setup...');
    configurationGovernanceService = ConfigurationGovernanceV1.newInstance({});
    expect(configurationGovernanceService).not.toBeNull();
    expect(configurationGovernanceService.baseOptions.serviceUrl).not.toBeNull();

    // Construct a separate service client for some negative tests.
    // This service has an apikey that lacks the necessary access to create or list rules, etc.
    configurationGovernanceServiceNoAccess = ConfigurationGovernanceV1.newInstance({ serviceName: 'NO_ACCESS' });
    expect(configurationGovernanceServiceNoAccess).not.toBeNull();
    expect(configurationGovernanceServiceNoAccess.baseOptions.serviceUrl).not.toBeNull();

    // Load up our test-specific config properties.
    const config = readExternalSources(ConfigurationGovernanceV1.DEFAULT_SERVICE_NAME);
    expect(config).not.toBeNull();
    expect(config.length).not.toBe(0);
    expect(configurationGovernanceService.baseOptions.serviceUrl).toEqual(config.url);

    // Retrieve and verify some additional test-related config properties.
    ACCOUNT_ID = config.accountId;
    TEST_SERVICE_NAME = config.testServiceName;
    ENTERPRISE_SCOPE_ID = config.enterpriseScopeId;
    SUBACCT_SCOPE_ID = config.subacctScopeId;
    expect(ACCOUNT_ID).not.toBeNull();
    expect(ACCOUNT_ID).not.toBeUndefined();
    expect(TEST_SERVICE_NAME).not.toBeNull();
    expect(TEST_SERVICE_NAME).not.toBeUndefined();
    expect(ENTERPRISE_SCOPE_ID).not.toBeNull();
    expect(ENTERPRISE_SCOPE_ID).not.toBeUndefined();
    expect(SUBACCT_SCOPE_ID).not.toBeNull();
    expect(SUBACCT_SCOPE_ID).not.toBeUndefined();

    log(`Service URL: ${configurationGovernanceService.baseOptions.serviceUrl}`);
    log(`Transaction ID: ${transactionId}`);

    // Clean any existing test rules before we start the actual tests.
    await cleanRules(TEST_LABEL, done);

    // Create some sample model instances that we'll use when invoking the operations.
    initSampleData();

    log('Finished setup.');

    done();
  });

  test('createRule1', done => {
    const ruleRequest1 = {
      request_id: 'request-0',
      rule: sampleRule1,
    };

    const params = {
      rules: [ruleRequest1],
      transactionId: transactionId,
    };

    configurationGovernanceService
      .createRules(params)
      .then(res => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(201);

        const result = res.result;
        expect(result).not.toBeNull();
        expect(result.rules.length).toEqual(1);

        const ruleResponse1 = result.rules[0];
        expect(ruleResponse1.request_id).toEqual('request-0');
        expect(ruleResponse1.status_code).toEqual(201);
        ruleId1 = ruleResponse1.rule.rule_id;
        expect(ruleId1).not.toBeNull();
        expect(ruleId1 != '').toBe(true);
        done();
      })
      .catch(err => {
        log(err);
        done(err);
      });
  });

  test('createRule2', done => {
    // CreateRuleRequest
    const ruleRequest2 = {
      rule: sampleRule2,
    };

    const params = {
      rules: [ruleRequest2],
      transactionId: transactionId,
    };

    configurationGovernanceService
      .createRules(params)
      .then(res => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(201);

        const result = res.result;
        expect(result).not.toBeNull();
        expect(result.rules.length).toEqual(1);

        const ruleResponse2 = result.rules[0];
        expect(ruleResponse2.request_id.length).toBeGreaterThan(0);
        expect(ruleResponse2.status_code).toEqual(201);
        ruleId2 = ruleResponse2.rule.rule_id;
        expect(ruleId2).not.toBeNull();
        expect(ruleId2 != '').toBe(true);
        expect(ruleId1).not.toEqual(ruleId2);
        done();
      })
      .catch(err => {
        log(err);
        done(err);
      });
  });

  test('createRuleInvalidRule', done => {
    // CreateRuleRequest
    const ruleRequestBad = {
      request_id: 'request-1',
      rule: badSampleRule,
    };

    const params = {
      rules: [ruleRequestBad],
      transactionId: transactionId,
    };

    // An error will be reported within the resultentry, but the operation itself will
    // return a 207 status code.
    configurationGovernanceService
      .createRules(params)
      .then(res => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(207);

        const result = res.result;
        expect(result).not.toBeNull();
        expect(result.rules.length).toEqual(1);

        // Verify the response entry indicates an error.
        const ruleResponse = result.rules[0];
        expect(ruleResponse.request_id).toEqual('request-1');
        expect(ruleResponse.status_code).toEqual(400);
        expect(ruleResponse.trace).toEqual(transactionId);
        expect(ruleResponse.errors.length).toBeGreaterThan(0);
        expect(ruleResponse.errors[0].code).toEqual('rule_error');
        done();
      })
      .catch(err => {
        log(err);
        done(err);
      });
  });

  test('createRuleNoAccess', done => {
    const ruleRequest1 = {
      request_id: 'request-1',
      rule: sampleRule1,
    };

    const params = {
      rules: [ruleRequest1],
      transactionId: transactionId,
    };

    configurationGovernanceServiceNoAccess
      .createRules(params)
      .then(res => {
        done(`Using a no-access apikey should not have succeeded!`);
      })
      .catch(err => {
        expect(err.status).toEqual(403);
        expect(err.message).toContain('Access is denied');
        done();
      });
  });
  test('listRules', done => {
    const params = {
      accountId: ACCOUNT_ID,
      transactionId: transactionId,
      labels: TEST_LABEL,
      limit: 1000,
      offset: 0,
    };

    configurationGovernanceService
      .listRules(params)
      .then(res => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(200);

        const result = res.result;
        expect(result).not.toBeNull();
        expect(result.total_count).toEqual(2);
        expect(result.offset).toEqual(0);
        expect(result.limit).toEqual(1000);
        expect(result.first).not.toBeNull();
        expect(result.last).not.toBeNull();
        done();
      })
      .catch(err => {
        log(err);
        done(err);
      });
  });

  test('listRulesNoAccess', done => {
    const params = {
      accountId: ACCOUNT_ID,
      transactionId: transactionId,
      labels: TEST_LABEL,
      limit: 1000,
      offset: 0,
    };

    configurationGovernanceServiceNoAccess
      .listRules(params)
      .then(res => {
        log(res);
        done(`Using a no-access apikey should not have succeeded!`);
      })
      .catch(err => {
        expect(err.status).toEqual(403);
        expect(err.message).toContain('Access is denied');
        done();
      });
  });

  test('getRule', done => {
    expect(ruleId1).not.toBeNull();
    expect(ruleId1).not.toBeUndefined();

    const params = {
      ruleId: ruleId1,
      transactionId: transactionId,
    };

    configurationGovernanceService
      .getRule(params)
      .then(res => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(200);

        const result = res.result;
        expect(result).not.toBeNull();
        rule1 = result;

        // Grab the Etag value from the response for use in the update operation.
        expect(res.headers.etag).not.toBeNull();
        expect(res.headers.etag.length).not.toBe(0);
        ruleEtag1 = res.headers.etag;
        expect(ruleEtag1).not.toBeNull();
        done();
      })
      .catch(err => {
        log(err);
        done(err);
      });
  });

  test('getRuleInvalidRuleId', done => {
    const params = {
      ruleId: 'BOGUS_ID',
      transactionId: transactionId,
    };

    configurationGovernanceService
      .getRule(params)
      .then(res => {
        log(res);
        done('Invalid get should not have succeeded!');
      })
      .catch(err => {
        expect(err.status).toEqual(404);
        expect(err.message).toContain('not found');
        done();
      });
  });

  test('updateRule', done => {
    expect(rule1).not.toBeNull();
    expect(rule1).not.toBeUndefined();

    expect(ruleId1).not.toBeNull();
    expect(ruleId1).not.toBeUndefined();

    expect(ruleEtag1).not.toBeNull();
    expect(ruleEtag1).not.toBeUndefined();

    // Starting with "rule1" (result of a get), modify the description, then call the update operation.
    const params = {
      ruleId: ruleId1,
      ifMatch: ruleEtag1,
      name: rule1.name,
      description: `Updated: ${rule1.description}`,
      target: rule1.target,
      requiredConfig: rule1.required_config,
      enforcementActions: rule1.enforcement_actions,
      accountId: rule1.account_id,
      ruleType: rule1.rule_type,
      labels: rule1.labels,
      transactionId: transactionId,
    };

    configurationGovernanceService
      .updateRule(params)
      .then(res => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(200);

        const result = res.result;
        expect(result).not.toBeNull();
        expect(result.description.startsWith('Updated:')).toBe(true);
        done();
      })
      .catch(err => {
        log(err);
        done(err);
      });
  });

  test('updateRuleInvalidEtag', done => {
    expect(rule1).not.toBeNull();
    expect(rule1).not.toBeUndefined();

    expect(ruleId1).not.toBeNull();
    expect(ruleId1).not.toBeUndefined();

    expect(ruleEtag1).not.toBeNull();
    expect(ruleEtag1).not.toBeUndefined();

    // Starting with "rule1" (result of a get), modify the description, then call the update operation.
    const params = {
      ruleId: ruleId1,
      ifMatch: `${ruleEtag1} just-foolin`,
      name: rule1.name,
      description: `Updated: ${rule1.description}`,
      target: rule1.target,
      requiredConfig: rule1.required_config,
      enforcementActions: rule1.enforcement_actions,
      accountId: rule1.account_id,
      ruleType: rule1.rule_type,
      labels: rule1.labels,
      transactionId: transactionId,
    };

    configurationGovernanceService
      .updateRule(params)
      .then(res => {
        log(res);
        done('Invalid update should not have succeeded!');
      })
      .catch(err => {
        expect(err.status).toEqual(400);
        expect(err.message).toContain('If-Match');
        done();
      });
  });

  test('deleteRule', async done => {
    expect(ruleId2).not.toBeNull();
    expect(ruleId2).not.toBeUndefined();

    const params = {
      ruleId: ruleId2,
      transactionId: transactionId,
    };

    let deleteRuleResp;
    let listRulesResp;
    try {
      deleteRuleResp = await configurationGovernanceService.deleteRule(params);

      // Now check to make sure listRules() returns only 1 rule.
      const listRuleParams = {
        accountId: ACCOUNT_ID,
        transactionId: transactionId,
        labels: TEST_LABEL,
        limit: 1000,
        offset: 0,
      };

      listRulesResp = await configurationGovernanceService.listRules(listRuleParams);
    } catch (err) {
      log(err);
      done(err);
    }

    expect(deleteRuleResp).not.toBeNull();
    expect(deleteRuleResp.status).toEqual(204);

    expect(listRulesResp).not.toBeNull();
    expect(listRulesResp.status).toEqual(200);

    const result = listRulesResp.result;
    expect(result).not.toBeNull();
    expect(result.total_count).toEqual(1);

    // Next, make sure we can not do a get on the deleted rule.
    const rule = await getRule(ruleId2);
    expect(rule).toBeNull();
    done();
  });

  test('deleteRuleInvalidRuleId', done => {
    const params = {
      ruleId: 'BOGUS_RULE_ID',
      transactionId: transactionId,
    };

    configurationGovernanceService
      .deleteRule(params)
      .then(res => {
        log(res);
        done('Invalid delete should not have succeeded!');
      })
      .catch(err => {
        expect(err.status).toEqual(404);
        expect(err.message).toContain('not found');
        done();
      });
  });

  test('createAttachment1', async done => {
    expect(ruleId1).not.toBeNull();
    expect(ruleId1).not.toBeUndefined();

    const attachmentRequestModel = {
      account_id: ACCOUNT_ID,
      included_scope: enterpriseScope,
      excluded_scopes: [accountScope],
    };

    const params = {
      ruleId: ruleId1,
      attachments: [attachmentRequestModel],
      transactionId: transactionId,
    };

    let createAttachmentsResp;
    try {
      createAttachmentsResp = await configurationGovernanceService.createAttachments(params);
    } catch (err) {
      log(err);
      done(err);
    }

    expect(createAttachmentsResp).not.toBeNull();
    expect(createAttachmentsResp.status).toEqual(201);

    const result = createAttachmentsResp.result;
    expect(result).not.toBeNull();
    expect(result.attachments).not.toBeNull();
    expect(result.attachments.length).toEqual(1);
    expect(result.attachments[0]).not.toBeNull();
    attachmentId1 = result.attachments[0].attachment_id;
    expect(attachmentId1).not.toBeNull();

    // Now retrieve the rule and make sure the num_attachments is 1.
    const rule = await getRule(ruleId1);
    expect(rule).not.toBeNull();
    expect(rule.number_of_attachments).not.toBeNull();
    expect(rule.number_of_attachments).toEqual(1);
    done();
  });

  test('createAttachment2', async done => {
    expect(ruleId1).not.toBeNull();
    expect(ruleId1).not.toBeUndefined();

    const attachmentRequestModel = {
      account_id: ACCOUNT_ID,
      included_scope: accountScope,
    };

    const params = {
      ruleId: ruleId1,
      attachments: [attachmentRequestModel],
      transactionId: transactionId,
    };

    let createAttachmentsResp;
    try {
      createAttachmentsResp = await configurationGovernanceService.createAttachments(params);
    } catch (err) {
      log(err);
      done(err);
    }

    expect(createAttachmentsResp).not.toBeNull();
    expect(createAttachmentsResp.status).toEqual(201);

    const result = createAttachmentsResp.result;
    expect(result).not.toBeNull();
    expect(result.attachments).not.toBeNull();
    expect(result.attachments.length).toEqual(1);
    expect(result.attachments[0]).not.toBeNull();
    attachmentId2 = result.attachments[0].attachment_id;
    expect(attachmentId2).not.toBeNull();

    // Now retrieve the rule and make sure the num_attachments is 2.
    const rule = await getRule(ruleId1);
    expect(rule).not.toBeNull();
    expect(rule.number_of_attachments).not.toBeNull();
    expect(rule.number_of_attachments).toEqual(2);
    done();
  });

  test('createAttachmentInvalidScopeType', done => {
    expect(ruleId1).not.toBeNull();
    expect(ruleId1).not.toBeUndefined();

    const attachmentRequestModel = {
      account_id: ACCOUNT_ID,
      included_scope: accountScope,
      excluded_scopes: [badScope],
    };

    const params = {
      ruleId: ruleId1,
      attachments: [attachmentRequestModel],
      transactionId: transactionId,
    };

    configurationGovernanceService
      .createAttachments(params)
      .then(res => {
        log(res);
        done('Invalid attachment should not have succeeded!');
      })
      .catch(err => {
        expect(err.status).toEqual(400);
        expect(err.message).toContain('not a descendant');
        done();
      });
  });

  test('getAttachment', done => {
    expect(ruleId1).not.toBeNull();
    expect(ruleId1).not.toBeUndefined();

    expect(attachmentId1).not.toBeNull();
    expect(attachmentId1).not.toBeUndefined();

    const params = {
      ruleId: ruleId1,
      attachmentId: attachmentId1,
      transactionId: transactionId,
    };

    configurationGovernanceService
      .getAttachment(params)
      .then(res => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(200);

        const result = res.result;
        expect(result).not.toBeNull();
        attachment1 = result;

        expect(result.account_id).toEqual(ACCOUNT_ID);
        expect(result.rule_id).toEqual(ruleId1);
        expect(result.attachment_id).toEqual(attachmentId1);
        expect(result.included_scope.note).toEqual('enterprise');
        expect(result.excluded_scopes.length).toEqual(1);

        // Grab the Etag value from the response for use in the update operation.
        expect(res.headers.etag).not.toBeNull();
        expect(res.headers.etag.length).not.toBe(0);
        attachmentEtag1 = res.headers.etag;
        expect(attachmentEtag1).not.toBeNull();
        done();
      })
      .catch(err => {
        log(err);
        done(err);
      });
    done();
  });

  test('getAttachmentInvalidAttachmentId', done => {
    expect(ruleId1).not.toBeNull();
    expect(ruleId1).not.toBeUndefined();

    expect(attachmentId1).not.toBeNull();
    expect(attachmentId1).not.toBeUndefined();

    const params = {
      ruleId: ruleId1,
      attachmentId: 'BOGUS_ID',
      transactionId: transactionId,
    };

    configurationGovernanceService
      .getAttachment(params)
      .then(res => {
        log(res);
        done('Invalid attachment id should not have succeeded!');
      })
      .catch(err => {
        expect(err.status).toEqual(404);
        expect(err.message).toContain('not found');
        done();
      });
  });

  test('listAttachments', done => {
    const params = {
      ruleId: ruleId1,
      transactionId: transactionId,
      limit: 1000,
      offset: 0,
    };

    configurationGovernanceService
      .listAttachments(params)
      .then(res => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(200);

        const result = res.result;
        expect(result).not.toBeNull();

        expect(result.offset).toEqual(0);
        expect(result.limit).toEqual(1000);
        expect(result.total_count).toEqual(2);
        expect(result.first).not.toBeNull();
        expect(result.last).not.toBeNull();
        result.attachments.forEach(att => {
          if (attachmentId1 === att.attachment_id) {
            expect(att.included_scope.note).toEqual('enterprise');
            expect(att.excluded_scopes.length).toEqual(1);
          } else if (attachmentId2 === att.attachment_id) {
            expect(att.included_scope.note).toEqual('leaf account');
            expect(att.excluded_scopes == null || att.excluded_scopes.length == 0).toBe(true);
          } else {
            done(`Unrecognized attachmentId: ${att.attachment_id}`);
          }
        });
        done();
      })
      .catch(err => {
        log(err);
        done(err);
      });
  });

  test('updateAttachment', done => {
    expect(ruleId1).not.toBeNull();
    expect(ruleId1).not.toBeUndefined();

    expect(attachment1).not.toBeNull();
    expect(attachment1).not.toBeUndefined();

    expect(attachmentEtag1).not.toBeNull();
    expect(attachmentEtag1).not.toBeUndefined();

    const updatedScope = attachment1.included_scope;
    updatedScope.note = `Updated: ${attachment1.included_scope.note}`;

    const params = {
      ruleId: attachment1.rule_id,
      attachmentId: attachment1.attachment_id,
      ifMatch: attachmentEtag1,
      accountId: attachment1.account_id,
      includedScope: updatedScope,
      excludedScopes: attachment1.excluded_scopes,
      transactionId: transactionId,
    };

    configurationGovernanceService
      .updateAttachment(params)
      .then(res => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(200);

        const result = res.result;
        expect(result).not.toBeNull();
        expect(result.included_scope).not.toBeNull();
        expect(result.included_scope.note.startsWith('Updated:')).toBe(true);
        done();
      })
      .catch(err => {
        log(err);
        done(err);
      });
  });

  test('updateAttachmentInvalidEtag', done => {
    expect(ruleId1).not.toBeNull();
    expect(ruleId1).not.toBeUndefined();

    expect(attachment1).not.toBeNull();
    expect(attachment1).not.toBeUndefined();

    expect(attachmentEtag1).not.toBeNull();
    expect(attachmentEtag1).not.toBeUndefined();

    const updatedScope = attachment1.included_scope;
    updatedScope.note = `Updated: ${attachment1.included_scope.note}`;

    const params = {
      ruleId: attachment1.rule_id,
      attachmentId: attachment1.attachment_id,
      ifMatch: 'BOGUS_TAG',
      accountId: attachment1.account_id,
      includedScope: updatedScope,
      excludedScopes: attachment1.excluded_scopes,
      transactionId: transactionId,
    };

    configurationGovernanceService
      .updateAttachment(params)
      .then(res => {
        log(res);
        done('Invalid update should not have succeeded!');
      })
      .catch(err => {
        expect(err.status).toEqual(400);
        expect(err.message).toContain('If-Match');
        done();
      });
  });

  test('deleteAttachment', async done => {
    expect(ruleId1).not.toBeNull();
    expect(ruleId1).not.toBeUndefined();

    expect(attachmentId2).not.toBeNull();
    expect(attachmentId2).not.toBeUndefined();

    const params = {
      ruleId: ruleId1,
      attachmentId: attachmentId2,
      transactionId: transactionId,
    };

    let deleteAttachmentResp;
    let listAttachmentsResp;
    try {
      deleteAttachmentResp = await configurationGovernanceService.deleteAttachment(params);

      // Now verify that listAttachments() returns only 1.
      const listAttachmentsParams = {
        ruleId: ruleId1,
        transactionId: transactionId,
        limit: 1000,
        offset: 0,
      };

      listAttachmentsResp = await configurationGovernanceService.listAttachments(listAttachmentsParams);
    } catch (err) {
      log(err);
      done(err);
    }

    expect(deleteAttachmentResp).not.toBeNull();
    expect(deleteAttachmentResp.status).toEqual(204);

    expect(listAttachmentsResp).not.toBeNull();
    expect(listAttachmentsResp.status).toEqual(200);

    const result = listAttachmentsResp.result;
    expect(result).not.toBeNull();
    expect(result.total_count).toEqual(1);

    // Next, make sure we cannot retrieve the deleted attachment via a get.
    const attachment = await getAttachment(ruleId1, attachmentId2);
    expect(attachment).toBeNull();
    done();
  });

  test('deleteAttachmentInvalidAttachmentId', done => {
    expect(ruleId1).not.toBeNull();
    expect(ruleId1).not.toBeUndefined();

    const params = {
      ruleId: ruleId1,
      attachmentId: 'BOGUS_ID',
      transactionId: transactionId,
    };

    configurationGovernanceService
      .deleteAttachment(params)
      .then(res => {
        log(res);
        done('Invalid delete should not have succeeded!');
      })
      .catch(err => {
        expect(err.status).toEqual(404);
        expect(err.message).toContain('not found');
        done();
      });
  });

  // cleanup resources
  afterAll(async done => {
    log('Starting post clean up...');
    await cleanRules(TEST_LABEL, done);
    log('Post clean up complete.');
    done();
  });
});

function log(msg) {
  if (verbose) {
    console.log(msg);
  }
}

async function cleanRules(label, done) {
  log('Cleaning rules...');

  try {
    // List any existing rules for this account with the specified label.
    const params = {
      accountId: ACCOUNT_ID,
      labels: label,
      limit: 1000,
      offset: 0,
      transactionId: transactionId,
    };

    const res = await configurationGovernanceService.listRules(params);
    expect(res).not.toBeNull();
    expect(res.status).toEqual(200);
    const ruleListResult = res.result;
    expect(ruleListResult).not.toBeNull();

    log(`Found ${ruleListResult.total_count} rule(s) to be cleaned`);

    // Now walk through the returned rules and delete each one.
    if (ruleListResult.total_count > 0) {
      for (const rule of ruleListResult.rules) {
        const deleteRuleParams = {
          ruleId: rule.rule_id,
          transactionId: transactionId,
        };

        log(`Deleting rule: name=${rule.name} id=${rule.rule_id}`);

        const deleteRuleRes = await configurationGovernanceService.deleteRule(deleteRuleParams);
        expect(deleteRuleRes).not.toBeNull();
        expect(deleteRuleRes.status).toEqual(204);
      }
    }
    log(`Finished cleaning rules...`);
    done();
  } catch (err) {
    log(err);
    done(err);
  }
}

function initSampleData() {
  const ruleTargetAttributeModel = {
    name: 'resource_id',
    operator: 'is_not_empty',
  };

  const targetResourceModel = {
    service_name: TEST_SERVICE_NAME,
    resource_kind: 'bucket',
    additional_target_attributes: [ruleTargetAttributeModel],
  };

  const allowedGBCondition = {
    property: 'allowed_gb',
    operator: 'num_less_than_equals',
    value: '20',
  };

  const locationCondition = {
    property: 'location',
    operator: 'string_equals',
    value: 'us-east"',
  };

  // Used in sampleRule1.
  const ruleRequiredConfigModel1 = {
    description: "allowed_gb==20 && location=='us-east'",
    and: [allowedGBCondition, locationCondition],
  };

  // Used in sampleRule2.
  const ruleRequiredConfigModel2 = {
    description: 'allowed_gb<=30',
    property: 'allowed_gb',
    operator: 'num_less_than_equals',
    value: '30',
  };

  const enforcementActionModel = {
    action: 'disallow',
  };

  // Sample rules.
  sampleRule1 = {
    account_id: ACCOUNT_ID,
    name: 'Node Test Rule #1',
    description: 'This is the description for Node Test Rule #1.',
    rule_type: 'user_defined',
    target: targetResourceModel,
    required_config: ruleRequiredConfigModel1,
    enforcement_actions: [enforcementActionModel],
    labels: [TEST_LABEL],
  };

  sampleRule2 = {
    account_id: ACCOUNT_ID,
    name: 'Node Test Rule #2',
    description: 'This is the description for Node Test Rule #2.',
    rule_type: 'user_defined',
    target: targetResourceModel,
    required_config: ruleRequiredConfigModel2,
    enforcement_actions: [enforcementActionModel],
    labels: [TEST_LABEL],
  };

  badSampleRule = {
    account_id: ACCOUNT_ID,
    name: 'Node Test Rule #2',
    description: 'This is the description for Node Test Rule #2.',
    rule_type: 'service_defined',
    target: targetResourceModel,
    required_config: ruleRequiredConfigModel2,
    enforcement_actions: [enforcementActionModel],
    labels: [TEST_LABEL],
  };

  // Sample rule scopes.
  enterpriseScope = {
    note: 'enterprise',
    scope_id: ENTERPRISE_SCOPE_ID,
    scope_type: 'enterprise',
  };

  accountScope = {
    note: 'leaf account',
    scope_id: SUBACCT_SCOPE_ID,
    scope_type: 'enterprise.account',
  };

  badScope = {
    note: 'leaf account',
    scope_id: SUBACCT_SCOPE_ID,
    scope_type: 'enterprise.BOGUS',
  };
}

async function getRule(ruleId) {
  let result = null;
  try {
    const params = {
      ruleId: ruleId,
      transactionId: transactionId,
    };

    const res = await configurationGovernanceService.getRule(params);

    if (res != null) {
      result = res.result;
    }
    return result;
  } catch (err) {
    return result;
  }
}

async function getAttachment(ruleId, attachmentId) {
  let result = null;
  try {
    const params = {
      ruleId: ruleId,
      attachmentId: attachmentId,
      transactionId: transactionId,
    };

    const res = await configurationGovernanceService.getAttachment(params);

    if (res != null) {
      result = res.result;
    }
    return result;
  } catch (err) {
    return result;
  }
}
