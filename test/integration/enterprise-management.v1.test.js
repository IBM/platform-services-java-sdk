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

const EnterpriseManagementV1 = require('../../dist/enterprise-management/v1');
const { readExternalSources } = require('ibm-cloud-sdk-core');
const authHelper = require('../resources/auth-helper.js');
const am_coe_v2_account_apis_helper = require('../integration/am_coe_v2_account_apis.js');
const async = require('async');

// testcase timeout value (200s).
const timeout = 250000;

// Location of our config file.
const configFile = 'enterprise-management.env';

const describe = authHelper.prepareTests(configFile);

let parent;
const limit = 100;
let enterpriseId;
let enterpriseAccountId;
let parentAccountGroupId;
let am_service_iam_token;
let owner_iam_id;
const retry_params = { times: 12, interval: 10000 };
let activation_token;
let account_id;
let subscription_id;
let crn;
let iEmail;
let iAccountId;

describe('EnterpriseManagementV1_integration', () => {
  jest.setTimeout(timeout);
  const account_info = am_coe_v2_account_apis_helper.get_default_account_info();
  let service;
  let config;

  it('should successfully complete initialization', done => {
    service = EnterpriseManagementV1.newInstance({});
    expect(service).not.toBeNull();

    // Grab our test-specific config properties.
    config = readExternalSources('EMTEST_CONFIG');
    expect(config).not.toBeNull();
    expect(config).toHaveProperty('amHost');
    expect(config).toHaveProperty('dbUrl');
    expect(config).toHaveProperty('dbUser');
    expect(config).toHaveProperty('dbPass');
    expect(config).toHaveProperty('activationDbName');
    expect(config).toHaveProperty('iamHost');
    expect(config).toHaveProperty('iamBasicAuth');
    expect(config).toHaveProperty('iamApiKey');
    done();
  });

  it('Create a Subscription Account - should generate IAM service token', done => {
    am_coe_v2_account_apis_helper.generate_iam_service_token(config.iamHost, config.iamBasicAuth, config.iamApiKey, (e, token) => {
      am_service_iam_token = `Bearer ${token}`;
      done();
    });
  });

  account_info.email = `aminttest+${new Date().getTime()}_${Math.floor(Math.random() * 10000)}@mail.test.ibm.com`;

  it('Create a Subscription Account - calls POST /coe/v2/accounts with BSS token', done => {
    const payload = am_coe_v2_account_apis_helper.get_account_payload(account_info.email, 'STANDARD', 'ACTIVE');
    am_coe_v2_account_apis_helper.post_am_coe_v2_accounts(config.amHost, payload, am_service_iam_token, (e, r, b) => {
      account_info.account_id = r.id;
      done();
    });
  });

  it('Create a Subscription Account - waits until activation token is generated', done => {
    const db_activation_token = am_coe_v2_account_apis_helper.fetch_db_activation_token(config.dbUrl, config.activationDbName, config.dbUser, config.dbPass, account_info.email);
    async.retry(retry_params, db_activation_token, (e, token) => {
      activation_token = token;
      done();
    });
  });

  it('Create a Subscription Account - waits until create process is done', done => {
    const db_activation_token = am_coe_v2_account_apis_helper.fetch_db_activation_token(config.dbUrl, config.activationDbName, config.dbUser, config.dbPass, account_info.email);
    async.retry(retry_params, db_activation_token, (e, end_record) => {
      done();
    });
  });

  it('Create a Subscription Account - calls GET /coe/v2/accounts/:account_id with BSS token', done => {
    am_coe_v2_account_apis_helper.get_am_coe_v2_account_by_id(config.amHost, account_info.account_id, am_service_iam_token, (e, r, b) => {
      done();
    });
  });

  it('Create a Subscription Account - calls GET /coe/v2/accounts/verify?email=******&token=****** to activate the account', done => {
    am_coe_v2_account_apis_helper.get_am_coe_v2_accounts_verify(config.amHost, account_info.email, activation_token, (e, r, b) => {
      done();
    });
  });

  it('Create a Subscription Account - calls GET /coe/v2/accounts/:account_id with BSS token', done => {
    am_coe_v2_account_apis_helper.get_am_coe_v2_account_by_id(config.amHost, account_info.account_id, am_service_iam_token, (e, r, b) => {
      owner_iam_id = b.entity.owner_iam_id;
      subscription_id = b.entity.subscription_id;
      done();
    });
  });

  it('Create a Subscription Account - convert account to subscription', done => {
    const payload_to_convert = am_coe_v2_account_apis_helper.get_activate_subscription_payload('2020-03-01T07:00:00.000Z', '2020-11-30T08:00:00.000', 10);
    delete payload_to_convert['softlayer_account_id'];
    am_coe_v2_account_apis_helper.patch_am_coe_v2_account_subscription(config.amHost, account_info.account_id, subscription_id, payload_to_convert, am_service_iam_token, null, (e, r, b) => {
      done();
    });
  });

  it('Create a Subscription Account - calls GET /coe/v2/accounts/:account_id with BSS token', done => {
    am_coe_v2_account_apis_helper.get_am_coe_v2_account_by_id(config.amHost, account_info.account_id, am_service_iam_token, (e, r, b) => {
      owner_iam_id = b.entity.owner_iam_id;
      subscription_id = b.entity.subscription_id;

      done();
    });
  });

  it('should create an enterprise using this Subscription Account', done => {
    const params = {
      name: `IBM-${new Date().getTime()}`,
      domain: `IBM-${new Date().getTime()}.com`,
      primaryContactIamId: owner_iam_id,
      sourceAccountId: account_info.account_id,
    };
    return service
      .createEnterprise(params)
      .then(response => {
        expect(response.hasOwnProperty('status')).toBe(true);
        expect(response.status).toBe(202);
        enterpriseId = response.result.enterprise_id;
        enterpriseAccountId = response.result.enterprise_account_id;
        done();
      })
      .catch(err => {
        done(err);
      });
  });

  it('Create a Subscription Account - calls GET /coe/v2/accounts/:account_id with BSS token', done => {
    am_coe_v2_account_apis_helper.get_am_coe_v2_account_by_id(config.amHost, account_info.account_id, am_service_iam_token, (e, r, b) => {
      parent = b.entity.parent;
      done();
    });
  });

  it('should create an account group', done => {
    const params = {
      parent: parent,
      name: `IBM-${new Date().getTime()}`,
      primaryContactIamId: owner_iam_id,
    };
    return service
      .createAccountGroup(params)
      .then(response => {
        expect(response.hasOwnProperty('status')).toBe(true);
        expect(response.status).toBe(201);

        parentAccountGroupId = response.result.account_group_id;
        done();
      })
      .catch(err => {
        done(err);
      });
  });

  it('should get account groups by query parameter', done => {
    const params = {
      enterpriseId: enterpriseId,
      parentAccountGroupId: parentAccountGroupId,
      parent: parent,
      limit: limit,
    };
    service
      .listAccountGroups(params)
      .then(response => {
        expect(response.hasOwnProperty('status')).toBe(true);
        expect(response.status).toBe(200);
        done();
      })
      .catch(err => {
        done(err);
      });
  });

  it('should get account group by id', done => {
    const params = {
      accountGroupId: parentAccountGroupId,
    };
    return service
      .getAccountGroup(params)
      .then(response => {
        crn = response.result.crn;
        expect(response.hasOwnProperty('status')).toBe(true);
        expect(response.status).toBe(200);
        done();
      })
      .catch(err => {
        done(err);
      });
  });

  it('should update an account group', done => {
    const params = {
      name: `IBM-${new Date().getTime()}`,
      accountGroupId: parentAccountGroupId,
    };
    return service
      .updateAccountGroup(params)
      .then(response => {
        expect(response.hasOwnProperty('status')).toBe(true);
        expect(response.status).toBe(204);
        done();
      })
      .catch(err => {
        done(err);
      });
  });

  iEmail = `aminttest+${new Date().getTime()}_${Math.floor(Math.random() * 10000)}@mail.test.ibm.com`;

  it('Create a Standard Account - calls POST /coe/v2/accounts with BSS token', done => {
    const payload = am_coe_v2_account_apis_helper.get_account_payload(iEmail, 'STANDARD', 'ACTIVE');
    am_coe_v2_account_apis_helper.post_am_coe_v2_accounts(config.amHost, payload, am_service_iam_token, (e, r, b) => {
      iAccountId = r.id;
      done();
    });
  });

  it('Create a Standard Account - waits until activation token is generated', done => {
    const db_activation_token = am_coe_v2_account_apis_helper.fetch_db_activation_token(config.dbUrl, config.activationDbName, config.dbUser, config.dbPass, iEmail);
    async.retry(retry_params, db_activation_token, (e, token) => {
      activation_token = token;
      done();
    });
  });

  it('Create a Standard Account - waits until create process is done', done => {
    const db_activation_token = am_coe_v2_account_apis_helper.fetch_db_activation_token(config.dbUrl, config.activationDbName, config.dbUser, config.dbPass, iEmail);
    async.retry(retry_params, db_activation_token, (e, end_record) => {
      done();
    });
  });

  it('Create a Standard Account - calls GET /coe/v2/accounts/:account_id with BSS token', done => {
    am_coe_v2_account_apis_helper.get_am_coe_v2_account_by_id(config.amHost, iAccountId, am_service_iam_token, (e, r, b) => {
      done();
    });
  });

  it('Create a Standard Account - calls GET /coe/v2/accounts/verify?email=******&token=****** to activate the account', done => {
    am_coe_v2_account_apis_helper.get_am_coe_v2_accounts_verify(config.amHost, iEmail, activation_token, (e, r, b) => {
      done();
    });
  });

  it('Create a Standard Account - calls GET /coe/v2/accounts/:account_id with BSS token', done => {
    am_coe_v2_account_apis_helper.get_am_coe_v2_account_by_id(config.amHost, iAccountId, am_service_iam_token, (e, r, b) => {
      done();
    });
  });

  it('should import this Standard account into an enterprise', done => {
    const params = {
      enterpriseId: enterpriseId,
      accountId: iAccountId,
    };
    return service
      .importAccountToEnterprise(params)
      .then(response => {
        expect(response.hasOwnProperty('status')).toBe(true);
        expect(response.status).toBe(202);
        done();
      })
      .catch(err => {
        done(err);
      });
  });

  it('should get account by id', done => {
    const params = {
      accountId: enterpriseAccountId,
    };
    return service
      .getAccount(params)
      .then(response => {
        expect(response.hasOwnProperty('status')).toBe(true);
        expect(response.status).toBe(200);
        done();
      })
      .catch(err => {
        done(err);
      });
  });

  it('should create a new account in an enterprise', done => {
    const params = {
      parent: parent,
      name: `IBM-${new Date().getTime()}`,
      ownerIamId: 'IBMid-550006JKXX',
    };
    return service
      .createAccount(params)
      .then(response => {
        expect(response.hasOwnProperty('status')).toBe(true);
        account_id = response.result.account_id;
        expect(response.status).toBe(202);
        done();
      })
      .catch(err => {
        done(err);
      });
  });

  it('should get account by id', done => {
    const params = {
      accountId: account_id,
    };
    return service
      .getAccount(params)
      .then(response => {
        expect(response.hasOwnProperty('status')).toBe(true);
        expect(response.status).toBe(200);
        done();
      })
      .catch(err => {
        done(err);
      });
  });

  it('should get accounts by query parameter', done => {
    const params = {
      enterpriseId: enterpriseId,
      accountGroupId: parentAccountGroupId,
      parent: parent,
      limit: limit,
    };
    return service
      .listAccounts(params)
      .then(response => {
        expect(response.hasOwnProperty('status')).toBe(true);
        expect(response.status).toBe(200);
        done();
      })
      .catch(err => {
        done(err);
      });
  });

  it('should create an account group', done => {
    const params = {
      parent: parent,
      name: `IBM-${new Date().getTime()}`,
      primaryContactIamId: owner_iam_id,
    };
    return service
      .createAccountGroup(params)
      .then(response => {
        expect(response.hasOwnProperty('status')).toBe(true);
        expect(response.status).toBe(201);
        parentAccountGroupId = response.result.account_group_id;
        done();
      })
      .catch(err => {
        done(err);
      });
  });

  it('should get account groups by query parameter', done => {
    const params = {
      enterpriseId: enterpriseId,
      parentAccountGroupId: parentAccountGroupId,
      parent: parent,
      limit: limit,
    };
    service
      .listAccountGroups(params)
      .then(response => {
        expect(response.hasOwnProperty('status')).toBe(true);
        expect(response.status).toBe(200);
        done();
      })
      .catch(err => {
        done(err);
      });
  });

  it('should move an account with the enterprise', done => {
    const params = {
      parent: crn,
      accountId: account_id,
    };
    return service
      .updateAccount(params)
      .then(response => {
        expect(response.hasOwnProperty('status')).toBe(true);
        expect(response.status).toBe(202);
        done();
      })
      .catch(err => {
        done(err);
      });
  });
});
