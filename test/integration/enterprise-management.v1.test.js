/* eslint-disable no-console */
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

const { readExternalSources, getQueryParam } = require('ibm-cloud-sdk-core');
const EnterpriseManagementV1 = require('../../dist/enterprise-management/v1');
const authHelper = require('../resources/auth-helper.js');

// testcase timeout value (200s).
const timeout = 200000;

// Location of our config file.
const configFile = 'enterprise_management.env';

const describe = authHelper.prepareTests(configFile);

const resultPerPage = 1;

let accountId = null;
let accountGroupId = null;
let newParentAccountGroupId = null;

describe('EnterpriseManagementV1_integration', () => {
  const enterpriseManagementService = EnterpriseManagementV1.newInstance({});

  expect(enterpriseManagementService).not.toBeNull();

  const config = readExternalSources(EnterpriseManagementV1.DEFAULT_SERVICE_NAME);
  expect(config).not.toBeNull();

  const { enterpriseId } = config;
  expect(enterpriseId).not.toBeNull();
  const enterpriseAccountId = config.accountId;
  expect(enterpriseAccountId).not.toBeNull();
  const enterpriseAccountIamId = config.accountIamId;
  expect(enterpriseAccountIamId).not.toBeNull();

  jest.setTimeout(timeout);

  test('createAccountGroup()', async () => {
    const parentCrn = `crn:v1:bluemix:public:enterprise::a/${enterpriseAccountId}::enterprise:${enterpriseId}`;
    const params = {
      parent: parentCrn,
      name: 'Example Account Group',
      primaryContactIamId: enterpriseAccountIamId,
    };

    const res = await enterpriseManagementService.createAccountGroup(params);

    expect(res).toBeDefined();
    expect(res.status).toBe(201);
    expect(res.result).toBeDefined();

    accountGroupId = res.result.account_group_id;

    params.name = 'New Parent Account Group';

    const resParent = await enterpriseManagementService.createAccountGroup(params);

    expect(resParent).toBeDefined();
    expect(resParent.status).toBe(201);
    expect(resParent.result).toBeDefined();

    newParentAccountGroupId = resParent.result.account_group_id;
  });
  test('listAccountGroups()', async () => {
    let results = [];

    let nextDocid = null;

    const params = {
      enterpriseId,
      limit: resultPerPage,
    };

    do {
      params.nextDocid = nextDocid;

      const res = await enterpriseManagementService.listAccountGroups(params);
      expect(res).toBeDefined();
      expect(res.result).toBeDefined();

      results = results.concat(res.result.resources);

      if (res.result.next_url) {
        nextDocid = getQueryParam(res.result.next_url, 'next_docid');
      } else {
        nextDocid = null;
      }
    } while (nextDocid != null);

    expect(results.some((result) => result.id === accountGroupId)).toBe(true);
    expect(results.some((result) => result.id === newParentAccountGroupId)).toBe(true);

    console.log(`Received a total of ${results.length} account groups.`);
  });
  test('getAccountGroup()', async () => {
    const params = {
      accountGroupId,
    };

    const res = await enterpriseManagementService.getAccountGroup(params);
    expect(res).toBeDefined();
    expect(res.result).toBeDefined();
  });
  test('updateAccountGroup()', async () => {
    const params = {
      accountGroupId,
      name: 'Updated Example Account Group',
      primaryContactIamId: enterpriseAccountIamId,
    };

    const res = await enterpriseManagementService.updateAccountGroup(params);
    expect(res).toBeDefined();
    expect(res.result).toBeDefined();
  });
  test('createAccount()', async () => {
    const parentCrn = `crn:v1:bluemix:public:enterprise::a/${enterpriseAccountId}::account-group:${accountGroupId}`;
    const params = {
      parent: parentCrn,
      name: 'Example Account',
      ownerIamId: enterpriseAccountIamId,
    };

    const res = await enterpriseManagementService.createAccount(params);
    expect(res).toBeDefined();
    expect(res.result).toBeDefined();

    accountId = res.result.account_id;
  });
  test('listAccounts()', async () => {
    let results = [];

    let nextDocid = null;

    const params = {
      accountGroupId,
      limit: resultPerPage,
    };

    do {
      params.nextDocid = nextDocid;

      const res = await enterpriseManagementService.listAccounts(params);
      expect(res).toBeDefined();
      expect(res.result).toBeDefined();

      results = results.concat(res.result.resources);

      if (res.result.next_url) {
        nextDocid = getQueryParam(res.result.next_url, 'next_docid');
      } else {
        nextDocid = null;
      }
    } while (nextDocid != null);

    expect(results.some((result) => result.id === accountId)).toBe(true);

    console.log(`Received a total of ${results.length} accounts.`);
  });
  test('getAccount()', async () => {
    const params = {
      accountId,
    };

    const res = await enterpriseManagementService.getAccount(params);
    expect(res).toBeDefined();
    expect(res.result).toBeDefined();
  });
  test('updateAccount()', async () => {
    const newParentCrn = `crn:v1:bluemix:public:enterprise::a/${enterpriseAccountId}::account-group:${newParentAccountGroupId}`;
    const params = {
      parent: newParentCrn,
      accountId,
    };

    const res = await enterpriseManagementService.updateAccount(params);
    expect(res).toBeDefined();
    expect(res.result).toBeDefined();
  });
  test('listEnterprises()', async () => {
    let results = [];
    let nextDocid = null;

    const params = {
      accountId: enterpriseAccountId,
      limit: resultPerPage,
    };

    do {
      params.nextDocid = nextDocid;

      const res = await enterpriseManagementService.listEnterprises(params);
      expect(res).toBeDefined();
      expect(res.result).toBeDefined();

      results = results.concat(res.result.resources);

      if (res.result.next_url) {
        nextDocid = getQueryParam(res.result.next_url, 'next_docid');
      } else {
        nextDocid = null;
      }
    } while (nextDocid != null);

    expect(results.some((result) => result.id === enterpriseId)).toBe(true);

    console.log(`Received a total of ${results.length} enterprises.`);
  });
  test('getEnterprise()', async () => {
    const params = {
      enterpriseId,
    };

    const res = await enterpriseManagementService.getEnterprise(params);
    expect(res).toBeDefined();
    expect(res.result).toBeDefined();
  });
  test('updateEnterprise()', async () => {
    const params = {
      enterpriseId,
      name: 'Updated Example Enterprise',
      primaryContactIamId: enterpriseAccountIamId,
    };

    const res = await enterpriseManagementService.updateEnterprise(params);
    expect(res).toBeDefined();
    expect(res.result).toBeDefined();
  });
});
