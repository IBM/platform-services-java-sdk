/**
* @jest-environment node
*/
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

const ConfigurationGovernanceV1 = require('../dist/configuration-governance/v1');
const { readExternalSources } = require('ibm-cloud-sdk-core');
const authHelper = require('../test/resources/auth-helper.js');
const { v4: uuidv4 } = require('uuid');

//
// This file provides an example of how to use the Configuration Governance service.
//
// The following configuration properties are assumed to be defined:
//
// CONFIGURATION_GOVERNANCE_URL=<service url>
// CONFIGURATION_GOVERNANCE_AUTHTYPE=iam
// CONFIGURATION_GOVERNANCE_APIKEY=<IAM api key of user with authority to create rules>
// CONFIGURATION_GOVERNANCE_AUTH_URL=<IAM token service URL - omit this if using the production environment>
// CONFIGURATION_GOVERNANCE_ACCOUNT_ID=<the id of the account under which rules/attachments should be created>
// CONFIGURATION_GOVERNANCE_EXAMPLE_SERVICE_NAME=<the name of the service to be associated with rule>
// CONFIGURATION_GOVERNANCE_ENTERPRISE_SCOPE_ID=<the id of the "enterprise" scope to be used in the examples>
// CONFIGURATION_GOVERNANCE_SUBACCT_SCOPE_ID=<the id of the "leaf account" scope to be used in the examples>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
const configFile = 'configuration_governance.env';

const describe = authHelper.prepareTests(configFile);

// Save original console.log and console.warn
const originalLog = console.log
const originalWarn = console.warn

// Mocks for console.log and console.warn
const consoleLogMock = jest.spyOn(console, 'log');
const consoleWarnMock = jest.spyOn(console, 'warn');

describe('ConfigurationGovernanceV1', () => {

  // begin-common

  const configurationGovernanceService = ConfigurationGovernanceV1.newInstance({});

  // end-common

  // Global variables to hold link values
  let attachmentEtag
  let attachmentId
  let ruleEtag
  let ruleId

  const config = readExternalSources(ConfigurationGovernanceV1.DEFAULT_SERVICE_NAME);

  // Additional configuration settings
  let testLabel = 'NodeSDKExamples';
  let accountId = config.accountId;
  let serviceName = config.exampleServiceName;
  let enterpriseScopeId = config.enterpriseScopeId;
  let subacctScopeId = config.subacctScopeId;

  beforeAll(async done => {
    // Clean any existing test rules before we start the actual tests.
    await cleanRules(testLabel, done);
  });

  test('createRules request example', done => {

    consoleLogMock.mockImplementation(output => {
      let responseBody = JSON.parse(output);
      ruleId = responseBody.rules[0].rule.rule_id;
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('createRules() result:');
    // begin-create_rules

    const params = {
      rules: [{ request_id: '3cebc877-58e7-44a5-a292-32114fa73558', rule: { account_id: accountId, name: 'Disable public access', description: 'Ensure that public access to account resources is disabled.', labels: ['Access', 'IAM'], target: { service_name: serviceName, resource_kind: 'service' }, required_config: { description: 'Public access check', and: [{ property: 'public_access_enabled', operator: 'is_false' }] }, enforcement_actions: [{ action: 'disallow' }, { action: 'audit_log' }] } }],
    };

    configurationGovernanceService.createRules(params)
      .then(res => {
        const { result, status } = res;
        if (status === 201) {
          console.log(JSON.stringify(result, null, 2));
        } else {
          // some rules may have failed
          for (rule of result.rules) {
            if (rule.errors !== undefined && rule.errors.length > 0) {
              throw new Error(rule.errors[0].message)
            }
          }
        }
      })
      .catch(err => {
        console.warn(err)
      });

    // end-create_rules
  });
  test('createAttachments request example', done => {

    consoleLogMock.mockImplementation(output => {
      let responseBody = JSON.parse(output);
      attachmentId = responseBody.attachments[0].attachment_id;
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('createAttachments() result:');
    // begin-create_attachments

    const params = {
      ruleId: ruleId,
      attachments: [{ attachment_id: 'attachment-4301178a-8028-4220-9cb6-dfb86f09da99', account_id: accountId, rule_id: 'rule-702d1db7-ca4a-414b-8464-2b517a065c14', included_scope: { note: 'My enterprise', scope_id: enterpriseScopeId, scope_type: 'enterprise' }, excluded_scopes: [{ note: 'Development account', scope_id: subacctScopeId, scope_type: 'enterprise.account' }] }],
    };

    configurationGovernanceService.createAttachments(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-create_attachments
  });
  test('getAttachment request example', done => {

    consoleLogMock.mockImplementation(output => {
      let responseBody = JSON.parse(output);
      configurationGovernanceService.getAttachment({
        ruleId: ruleId,
        attachmentId: attachmentId,
      }).then(res => {
        attachmentEtag = res.headers['etag'];
        done();
      })
        .catch(err => {
          console.warn(err)
        });
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('getAttachment() result:');
    // begin-get_attachment

    const params = {
      ruleId: ruleId,
      attachmentId: attachmentId,
    };

    configurationGovernanceService.getAttachment(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-get_attachment
  });
  test('getRule request example', done => {

    consoleLogMock.mockImplementation(output => {
      let responseBody = JSON.parse(output);
      configurationGovernanceService.getRule({
        ruleId: ruleId,
      }).then(res => {
        ruleEtag = res.headers['etag'];
        done();
      })
        .catch(err => {
          console.warn(err)
        });
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('getRule() result:');
    // begin-get_rule

    const params = {
      ruleId: ruleId,
    };

    configurationGovernanceService.getRule(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-get_rule
  });
  test('listRules request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('listRules() result:');
    // begin-list_rules

    const params = {
      accountId: accountId,
    };

    configurationGovernanceService.listRules(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-list_rules
  });
  test('updateRule request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('updateRule() result:');
    // begin-update_rule

    const params = {
      ruleId: ruleId,
      ifMatch: ruleEtag,
      name: 'Disable public access',
      description: 'Ensure that public access to account resources is disabled.',
      target: { "service_name": "iam-groups", "resource_kind": "service", "additional_target_attributes": [] },
      requiredConfig: { property: 'public_access_enabled', operator: 'is_false' },
      enforcementActions: [{ action: 'audit_log' }, { action: 'disallow' }],
      accountId: accountId,
      ruleType: 'user_defined',
      labels: ['SOC2', 'ITCS300'],
    };

    configurationGovernanceService.updateRule(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-update_rule
  });
  test('listAttachments request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('listAttachments() result:');
    // begin-list_attachments

    const params = {
      ruleId: ruleId,
    };

    configurationGovernanceService.listAttachments(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-list_attachments
  });
  test('updateAttachment request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('updateAttachment() result:');
    // begin-update_attachment

    const params = {
      ruleId: ruleId,
      attachmentId: attachmentId,
      ifMatch: attachmentEtag,
      accountId: accountId,
      includedScope: { note: 'My enterprise', scope_id: enterpriseScopeId, scope_type: 'enterprise' },
      excludedScopes: [{ note: 'Development account', scope_id: subacctScopeId, scope_type: 'enterprise.account' }],
    };

    configurationGovernanceService.updateAttachment(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-update_attachment
  });
  test('deleteAttachment request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-delete_attachment

    const params = {
      ruleId: ruleId,
      attachmentId: attachmentId,
    };

    configurationGovernanceService.deleteAttachment(params)
      .then(res => {
        done();
      })
      .catch(err => {
        console.warn(err)
      });

    // end-delete_attachment
  });
  test('deleteRule request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-delete_rule

    const params = {
      ruleId: ruleId,
    };

    configurationGovernanceService.deleteRule(params)
      .then(res => {
        done();
      })
      .catch(err => {
        console.warn(err)
      });

    // end-delete_rule
  });

  async function cleanRules(label, done) {
    console.log('Cleaning rules...');

    try {
      // List any existing rules for this account with the specified label.
      const params = {
        accountId: accountId,
        labels: label,
        limit: 1000,
        offset: 0,
      };

      const res = await configurationGovernanceService.listRules(params);
      expect(res).not.toBeNull();
      expect(res.status).toEqual(200);
      const ruleListResult = res.result;
      expect(ruleListResult).not.toBeNull();

      console.log(`Found ${ruleListResult.total_count} rule(s) to be cleaned`);

      // Now walk through the returned rules and delete each one.
      if (ruleListResult.total_count > 0) {
        for (const rule of ruleListResult.rules) {
          const deleteRuleParams = {
            ruleId: rule.rule_id,
          };

          console.log(`Deleting rule: name=${rule.name} id=${rule.rule_id}`);

          const deleteRuleRes = await configurationGovernanceService.deleteRule(deleteRuleParams);
          expect(deleteRuleRes).not.toBeNull();
          expect(deleteRuleRes.status).toEqual(204);
        }
      }
      console.log(`Finished cleaning rules...`);
      done();
    } catch (err) {
      console.log(err);
      done(err);
    }
  }

});
