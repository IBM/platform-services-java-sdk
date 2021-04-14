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

// need to import the whole package to mock getAuthenticatorFromEnvironment
const core = require('ibm-cloud-sdk-core');
const { NoAuthAuthenticator, unitTestUtils } = core;

const EnterpriseManagementV1 = require('../../dist/enterprise-management/v1');

const {
  getOptions,
  checkUrlAndMethod,
  checkMediaHeaders,
  expectToBePromise,
  checkForSuccessfulExecution,
} = unitTestUtils;

const service = {
  authenticator: new NoAuthAuthenticator(),
  url: 'https://enterprise.cloud.ibm.com/v1',
};

const enterpriseManagementService = new EnterpriseManagementV1(service);

// dont actually create a request
const createRequestMock = jest.spyOn(enterpriseManagementService, 'createRequest');
createRequestMock.mockImplementation(() => Promise.resolve());

// dont actually construct an authenticator
const getAuthenticatorMock = jest.spyOn(core, 'getAuthenticatorFromEnvironment');
getAuthenticatorMock.mockImplementation(() => new NoAuthAuthenticator());

afterEach(() => {
  createRequestMock.mockClear();
  getAuthenticatorMock.mockClear();
});

describe('EnterpriseManagementV1', () => {
  describe('the newInstance method', () => {
    test('should use defaults when options not provided', () => {
      const testInstance = EnterpriseManagementV1.newInstance();

      expect(getAuthenticatorMock).toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceName).toBe(EnterpriseManagementV1.DEFAULT_SERVICE_NAME);
      expect(testInstance.baseOptions.serviceUrl).toBe(EnterpriseManagementV1.DEFAULT_SERVICE_URL);
      expect(testInstance).toBeInstanceOf(EnterpriseManagementV1);
    });

    test('should set serviceName, serviceUrl, and authenticator when provided', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
        serviceName: 'my-service',
      };

      const testInstance = EnterpriseManagementV1.newInstance(options);

      expect(getAuthenticatorMock).not.toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
      expect(testInstance.baseOptions.serviceName).toBe('my-service');
      expect(testInstance).toBeInstanceOf(EnterpriseManagementV1);
    });
  });
  describe('the constructor', () => {
    test('use user-given service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
      };

      const testInstance = new EnterpriseManagementV1(options);

      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
    });

    test('use default service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
      };

      const testInstance = new EnterpriseManagementV1(options);

      expect(testInstance.baseOptions.serviceUrl).toBe(EnterpriseManagementV1.DEFAULT_SERVICE_URL);
    });
  });
  describe('createEnterprise', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createEnterprise
        const sourceAccountId = 'testString';
        const name = 'testString';
        const primaryContactIamId = 'testString';
        const domain = 'testString';
        const params = {
          sourceAccountId: sourceAccountId,
          name: name,
          primaryContactIamId: primaryContactIamId,
          domain: domain,
        };

        const createEnterpriseResult = enterpriseManagementService.createEnterprise(params);

        // all methods should return a Promise
        expectToBePromise(createEnterpriseResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/enterprises', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['source_account_id']).toEqual(sourceAccountId);
        expect(options.body['name']).toEqual(name);
        expect(options.body['primary_contact_iam_id']).toEqual(primaryContactIamId);
        expect(options.body['domain']).toEqual(domain);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const sourceAccountId = 'testString';
        const name = 'testString';
        const primaryContactIamId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          sourceAccountId,
          name,
          primaryContactIamId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        enterpriseManagementService.createEnterprise(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await enterpriseManagementService.createEnterprise({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const createEnterprisePromise = enterpriseManagementService.createEnterprise();
        expectToBePromise(createEnterprisePromise);

        createEnterprisePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('listEnterprises', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listEnterprises
        const enterpriseAccountId = 'testString';
        const accountGroupId = 'testString';
        const accountId = 'testString';
        const nextDocid = 'testString';
        const limit = 100;
        const params = {
          enterpriseAccountId: enterpriseAccountId,
          accountGroupId: accountGroupId,
          accountId: accountId,
          nextDocid: nextDocid,
          limit: limit,
        };

        const listEnterprisesResult = enterpriseManagementService.listEnterprises(params);

        // all methods should return a Promise
        expectToBePromise(listEnterprisesResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/enterprises', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['enterprise_account_id']).toEqual(enterpriseAccountId);
        expect(options.qs['account_group_id']).toEqual(accountGroupId);
        expect(options.qs['account_id']).toEqual(accountId);
        expect(options.qs['next_docid']).toEqual(nextDocid);
        expect(options.qs['limit']).toEqual(limit);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        enterpriseManagementService.listEnterprises(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        enterpriseManagementService.listEnterprises({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('getEnterprise', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getEnterprise
        const enterpriseId = 'testString';
        const params = {
          enterpriseId: enterpriseId,
        };

        const getEnterpriseResult = enterpriseManagementService.getEnterprise(params);

        // all methods should return a Promise
        expectToBePromise(getEnterpriseResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/enterprises/{enterprise_id}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['enterprise_id']).toEqual(enterpriseId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const enterpriseId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          enterpriseId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        enterpriseManagementService.getEnterprise(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await enterpriseManagementService.getEnterprise({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getEnterprisePromise = enterpriseManagementService.getEnterprise();
        expectToBePromise(getEnterprisePromise);

        getEnterprisePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('updateEnterprise', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation updateEnterprise
        const enterpriseId = 'testString';
        const name = 'testString';
        const domain = 'testString';
        const primaryContactIamId = 'testString';
        const params = {
          enterpriseId: enterpriseId,
          name: name,
          domain: domain,
          primaryContactIamId: primaryContactIamId,
        };

        const updateEnterpriseResult = enterpriseManagementService.updateEnterprise(params);

        // all methods should return a Promise
        expectToBePromise(updateEnterpriseResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/enterprises/{enterprise_id}', 'PATCH');
        const expectedAccept = undefined;
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['name']).toEqual(name);
        expect(options.body['domain']).toEqual(domain);
        expect(options.body['primary_contact_iam_id']).toEqual(primaryContactIamId);
        expect(options.path['enterprise_id']).toEqual(enterpriseId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const enterpriseId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          enterpriseId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        enterpriseManagementService.updateEnterprise(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await enterpriseManagementService.updateEnterprise({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const updateEnterprisePromise = enterpriseManagementService.updateEnterprise();
        expectToBePromise(updateEnterprisePromise);

        updateEnterprisePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('importAccountToEnterprise', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation importAccountToEnterprise
        const enterpriseId = 'testString';
        const accountId = 'testString';
        const parent = 'testString';
        const billingUnitId = 'testString';
        const params = {
          enterpriseId: enterpriseId,
          accountId: accountId,
          parent: parent,
          billingUnitId: billingUnitId,
        };

        const importAccountToEnterpriseResult = enterpriseManagementService.importAccountToEnterprise(params);

        // all methods should return a Promise
        expectToBePromise(importAccountToEnterpriseResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/enterprises/{enterprise_id}/import/accounts/{account_id}', 'PUT');
        const expectedAccept = undefined;
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['parent']).toEqual(parent);
        expect(options.body['billing_unit_id']).toEqual(billingUnitId);
        expect(options.path['enterprise_id']).toEqual(enterpriseId);
        expect(options.path['account_id']).toEqual(accountId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const enterpriseId = 'testString';
        const accountId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          enterpriseId,
          accountId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        enterpriseManagementService.importAccountToEnterprise(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await enterpriseManagementService.importAccountToEnterprise({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const importAccountToEnterprisePromise = enterpriseManagementService.importAccountToEnterprise();
        expectToBePromise(importAccountToEnterprisePromise);

        importAccountToEnterprisePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('createAccount', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createAccount
        const parent = 'testString';
        const name = 'testString';
        const ownerIamId = 'testString';
        const params = {
          parent: parent,
          name: name,
          ownerIamId: ownerIamId,
        };

        const createAccountResult = enterpriseManagementService.createAccount(params);

        // all methods should return a Promise
        expectToBePromise(createAccountResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/accounts', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['parent']).toEqual(parent);
        expect(options.body['name']).toEqual(name);
        expect(options.body['owner_iam_id']).toEqual(ownerIamId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const parent = 'testString';
        const name = 'testString';
        const ownerIamId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          parent,
          name,
          ownerIamId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        enterpriseManagementService.createAccount(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await enterpriseManagementService.createAccount({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const createAccountPromise = enterpriseManagementService.createAccount();
        expectToBePromise(createAccountPromise);

        createAccountPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('listAccounts', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listAccounts
        const enterpriseId = 'testString';
        const accountGroupId = 'testString';
        const nextDocid = 'testString';
        const parent = 'testString';
        const limit = 100;
        const params = {
          enterpriseId: enterpriseId,
          accountGroupId: accountGroupId,
          nextDocid: nextDocid,
          parent: parent,
          limit: limit,
        };

        const listAccountsResult = enterpriseManagementService.listAccounts(params);

        // all methods should return a Promise
        expectToBePromise(listAccountsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/accounts', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['enterprise_id']).toEqual(enterpriseId);
        expect(options.qs['account_group_id']).toEqual(accountGroupId);
        expect(options.qs['next_docid']).toEqual(nextDocid);
        expect(options.qs['parent']).toEqual(parent);
        expect(options.qs['limit']).toEqual(limit);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        enterpriseManagementService.listAccounts(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        enterpriseManagementService.listAccounts({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('getAccount', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getAccount
        const accountId = 'testString';
        const params = {
          accountId: accountId,
        };

        const getAccountResult = enterpriseManagementService.getAccount(params);

        // all methods should return a Promise
        expectToBePromise(getAccountResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/accounts/{account_id}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['account_id']).toEqual(accountId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        enterpriseManagementService.getAccount(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await enterpriseManagementService.getAccount({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getAccountPromise = enterpriseManagementService.getAccount();
        expectToBePromise(getAccountPromise);

        getAccountPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('updateAccount', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation updateAccount
        const accountId = 'testString';
        const parent = 'testString';
        const params = {
          accountId: accountId,
          parent: parent,
        };

        const updateAccountResult = enterpriseManagementService.updateAccount(params);

        // all methods should return a Promise
        expectToBePromise(updateAccountResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/accounts/{account_id}', 'PATCH');
        const expectedAccept = undefined;
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['parent']).toEqual(parent);
        expect(options.path['account_id']).toEqual(accountId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountId = 'testString';
        const parent = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountId,
          parent,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        enterpriseManagementService.updateAccount(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await enterpriseManagementService.updateAccount({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const updateAccountPromise = enterpriseManagementService.updateAccount();
        expectToBePromise(updateAccountPromise);

        updateAccountPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('createAccountGroup', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createAccountGroup
        const parent = 'testString';
        const name = 'testString';
        const primaryContactIamId = 'testString';
        const params = {
          parent: parent,
          name: name,
          primaryContactIamId: primaryContactIamId,
        };

        const createAccountGroupResult = enterpriseManagementService.createAccountGroup(params);

        // all methods should return a Promise
        expectToBePromise(createAccountGroupResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/account-groups', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['parent']).toEqual(parent);
        expect(options.body['name']).toEqual(name);
        expect(options.body['primary_contact_iam_id']).toEqual(primaryContactIamId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const parent = 'testString';
        const name = 'testString';
        const primaryContactIamId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          parent,
          name,
          primaryContactIamId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        enterpriseManagementService.createAccountGroup(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await enterpriseManagementService.createAccountGroup({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const createAccountGroupPromise = enterpriseManagementService.createAccountGroup();
        expectToBePromise(createAccountGroupPromise);

        createAccountGroupPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('listAccountGroups', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listAccountGroups
        const enterpriseId = 'testString';
        const parentAccountGroupId = 'testString';
        const nextDocid = 'testString';
        const parent = 'testString';
        const limit = 100;
        const params = {
          enterpriseId: enterpriseId,
          parentAccountGroupId: parentAccountGroupId,
          nextDocid: nextDocid,
          parent: parent,
          limit: limit,
        };

        const listAccountGroupsResult = enterpriseManagementService.listAccountGroups(params);

        // all methods should return a Promise
        expectToBePromise(listAccountGroupsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/account-groups', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['enterprise_id']).toEqual(enterpriseId);
        expect(options.qs['parent_account_group_id']).toEqual(parentAccountGroupId);
        expect(options.qs['next_docid']).toEqual(nextDocid);
        expect(options.qs['parent']).toEqual(parent);
        expect(options.qs['limit']).toEqual(limit);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        enterpriseManagementService.listAccountGroups(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        enterpriseManagementService.listAccountGroups({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('getAccountGroup', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getAccountGroup
        const accountGroupId = 'testString';
        const params = {
          accountGroupId: accountGroupId,
        };

        const getAccountGroupResult = enterpriseManagementService.getAccountGroup(params);

        // all methods should return a Promise
        expectToBePromise(getAccountGroupResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/account-groups/{account_group_id}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['account_group_id']).toEqual(accountGroupId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountGroupId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountGroupId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        enterpriseManagementService.getAccountGroup(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await enterpriseManagementService.getAccountGroup({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getAccountGroupPromise = enterpriseManagementService.getAccountGroup();
        expectToBePromise(getAccountGroupPromise);

        getAccountGroupPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('updateAccountGroup', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation updateAccountGroup
        const accountGroupId = 'testString';
        const name = 'testString';
        const primaryContactIamId = 'testString';
        const params = {
          accountGroupId: accountGroupId,
          name: name,
          primaryContactIamId: primaryContactIamId,
        };

        const updateAccountGroupResult = enterpriseManagementService.updateAccountGroup(params);

        // all methods should return a Promise
        expectToBePromise(updateAccountGroupResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/account-groups/{account_group_id}', 'PATCH');
        const expectedAccept = undefined;
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['name']).toEqual(name);
        expect(options.body['primary_contact_iam_id']).toEqual(primaryContactIamId);
        expect(options.path['account_group_id']).toEqual(accountGroupId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountGroupId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountGroupId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        enterpriseManagementService.updateAccountGroup(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await enterpriseManagementService.updateAccountGroup({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const updateAccountGroupPromise = enterpriseManagementService.updateAccountGroup();
        expectToBePromise(updateAccountGroupPromise);

        updateAccountGroupPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
});
