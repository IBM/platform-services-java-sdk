/**
* @jest-environment node
*/
/**
 * (C) Copyright IBM Corp. 2021.
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

const EnterpriseManagementV1 = require('../dist/enterprise-management/v1');
const { readExternalSources } = require('ibm-cloud-sdk-core');
const authHelper = require('../test/resources/auth-helper.js');

//
// This file provides an example of how to use the Enterprise Management service.
//
// The following configuration properties are assumed to be defined:
// ENTERPRISE_MANAGEMENT_URL=<service base url>
// ENTERPRISE_MANAGEMENT_AUTH_TYPE=iam
// ENTERPRISE_MANAGEMENT_APIKEY=<IAM apikey>
// ENTERPRISE_MANAGEMENT_AUTH_URL=<IAM token service base URL - omit this if using the production environment>
// ENTERPRISE_MANAGEMENT_ENTERPRISE_ID=<ID of the enterprise>
// ENTERPRISE_MANAGEMENT_ACCOUNT_ID=<enterprise account ID>
// ENTERPRISE_MANAGEMENT_ACCOUNT_IAM_ID=<IAM ID of the enterprise account>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
const configFile = 'enterprise_management.env';

const describe = authHelper.prepareTests(configFile);

// Save original console.log and console.warn
const originalLog = console.log;
const originalWarn = console.warn;

// Mocks for console.log and console.warn
const consoleLogMock = jest.spyOn(console, 'log');
const consoleWarnMock = jest.spyOn(console, 'warn');

const timeout = 20000;

let accountId = null;
let accountGroupId = null;
let newParentAccountGroupId = null;

describe('EnterpriseManagementV1', () => {

  // begin-common

  const enterpriseManagementService = EnterpriseManagementV1.newInstance({});

  // end-common

  const config = readExternalSources(EnterpriseManagementV1.DEFAULT_SERVICE_NAME);

  const enterpriseId = config.enterpriseId;
  const enterpriseAccountId = config.accountId;
  const enterpriseAccountIamId = config.accountIamId;

  expect(enterpriseId).not.toBeNull();
  expect(enterpriseAccountId).not.toBeNull();
  expect(enterpriseAccountIamId).not.toBeNull();

  jest.setTimeout(timeout);

  test('createAccountGroup request example', done => {

    const parentCrn = 'crn:v1:bluemix:public:enterprise::a/' + enterpriseAccountId + '::enterprise:' + enterpriseId;

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      const responseBody = JSON.parse(output);

      accountGroupId = responseBody.account_group_id

      const params = {
        parent: parentCrn,
        name: 'New Parent Account Group',
        primaryContactIamId: enterpriseAccountIamId,
      };

      enterpriseManagementService.createAccountGroup(params)
        .then(res => {
          newParentAccountGroupId = res.result.account_group_id
          originalLog(JSON.stringify(res.result, null, 2));
          done();
        })
        .catch(err => {
          done(err)
        });
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('createAccountGroup() result:');

    // begin-create_account_group

    const params = {
      parent: parentCrn,
      name: 'Example Account Group',
      primaryContactIamId: enterpriseAccountIamId,
    };

    enterpriseManagementService.createAccountGroup(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-create_account_group
  });
  test('listAccountGroups request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('listAccountGroups() result:');

    // begin-list_account_groups

    const params = {
      enterpriseId: enterpriseId,
    };

    enterpriseManagementService.listAccountGroups(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-list_account_groups
  });
  test('getAccountGroup request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(accountGroupId).not.toBeNull();

    originalLog('getAccountGroup() result:');

    // begin-get_account_group

    const params = {
      accountGroupId: accountGroupId,
    };

    enterpriseManagementService.getAccountGroup(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-get_account_group
  });
  test('updateAccountGroup request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(accountGroupId).not.toBeNull();

    // begin-update_account_group

    const params = {
      accountGroupId: accountGroupId,
      name: 'Updated Example Account Group',
      primaryContactIamId: enterpriseAccountIamId,
    };

    enterpriseManagementService.updateAccountGroup(params)
      .then(res => {
        done();
      })
      .catch(err => {
        console.warn(err)
      });

    // end-update_account_group
  });
  test('createAccount request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      const responseBody = JSON.parse(output);
      accountId = responseBody.account_id;
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(accountGroupId).not.toBeNull();

    const parentCrn = 'crn:v1:bluemix:public:enterprise::a/' + enterpriseAccountId + '::account-group:' + accountGroupId;

    originalLog('createAccount() result:');

    // begin-create_account

    const params = {
      parent: parentCrn,
      name: 'Example Account',
      ownerIamId: enterpriseAccountIamId,
    };

    enterpriseManagementService.createAccount(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-create_account
  });
  test.skip('importAccountToEnterprise request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    const importAccountId = '<accountid_to_be_imported>';

    // begin-import_account_to_enterprise

    const params = {
      enterpriseId: enterpriseId,
      accountId: importAccountId,
    };

    enterpriseManagementService.importAccountToEnterprise(params)
      .then(res => {
        done();
      })
      .catch(err => {
        console.warn(err)
      });

    // end-import_account_to_enterprise
  });
  test('listAccounts request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('listAccounts() result:');

    // begin-list_accounts

    const params = {
      enterpriseId: enterpriseId,
    };

    enterpriseManagementService.listAccounts(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-list_accounts
  });
  test('getAccount request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(accountId).not.toBeNull();

    originalLog('getAccount() result:');

    // begin-get_account

    const params = {
      accountId: accountId,
    };

    enterpriseManagementService.getAccount(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-get_account
  });
  test('updateAccount request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(accountId).not.toBeNull();
    expect(newParentAccountGroupId).not.toBeNull();

    const newParentCrn = 'crn:v1:bluemix:public:enterprise::a/' + enterpriseAccountId + '::account-group:' + newParentAccountGroupId;

    // begin-update_account

    const params = {
      accountId: accountId,
      parent: newParentCrn,
    };

    enterpriseManagementService.updateAccount(params)
      .then(res => {
        done();
      })
      .catch(err => {
        console.warn(err)
      });

    // end-update_account
  });
  test.skip('createEnterprise request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('createEnterprise() result:');

    const srcAccountId = '<standalone_account_id>';
    const contactIamId = '<standalone_account_iam_id>';

    // begin-create_enterprise

    const params = {
      sourceAccountId: srcAccountId,
      name: 'Example Enterprise',
      primaryContactIamId: contactIamId,
    };

    enterpriseManagementService.createEnterprise(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-create_enterprise
  });
  test('listEnterprises request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('listEnterprises() result:');

    // begin-list_enterprises

    const params = {
      accountId: enterpriseAccountId,
    };

    enterpriseManagementService.listEnterprises(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-list_enterprises
  });
  test('getEnterprise request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('getEnterprise() result:');

    // begin-get_enterprise

    const params = {
      enterpriseId: enterpriseId,
    };

    enterpriseManagementService.getEnterprise(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-get_enterprise
  });
  test('updateEnterprise request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-update_enterprise

    const params = {
      enterpriseId: enterpriseId,
      name: 'Updated Example Enterprise',
      primaryContactIamId: enterpriseAccountIamId,
    };

    enterpriseManagementService.updateEnterprise(params)
      .then(res => {
        done();
      })
      .catch(err => {
        console.warn(err)
      });

    // end-update_enterprise
  });
});
