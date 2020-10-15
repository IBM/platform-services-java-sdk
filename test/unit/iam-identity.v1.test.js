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

// need to import the whole package to mock getAuthenticatorFromEnvironment
const core = require('ibm-cloud-sdk-core');
const { NoAuthAuthenticator, unitTestUtils } = core;

const IamIdentityV1 = require('../../dist/iam-identity/v1');

const {
  getOptions,
  checkUrlAndMethod,
  checkMediaHeaders,
  expectToBePromise,
  checkUserHeader,
  checkForSuccessfulExecution,
} = unitTestUtils;

const service = {
  authenticator: new NoAuthAuthenticator(),
  url: 'https://iam.cloud.ibm.com',
};

const iamIdentityService = new IamIdentityV1(service);

// dont actually create a request
const createRequestMock = jest.spyOn(iamIdentityService, 'createRequest');
createRequestMock.mockImplementation(() => Promise.resolve());

// dont actually construct an authenticator
const getAuthenticatorMock = jest.spyOn(core, 'getAuthenticatorFromEnvironment');
getAuthenticatorMock.mockImplementation(() => new NoAuthAuthenticator());

afterEach(() => {
  createRequestMock.mockClear();
  getAuthenticatorMock.mockClear();
});

describe('IamIdentityV1', () => {
  describe('the newInstance method', () => {
    test('should use defaults when options not provided', () => {
      const testInstance = IamIdentityV1.newInstance();

      expect(getAuthenticatorMock).toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceName).toBe(IamIdentityV1.DEFAULT_SERVICE_NAME);
      expect(testInstance.baseOptions.serviceUrl).toBe(IamIdentityV1.DEFAULT_SERVICE_URL);
      expect(testInstance).toBeInstanceOf(IamIdentityV1);
    });

    test('should set serviceName, serviceUrl, and authenticator when provided', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
        serviceName: 'my-service',
      };

      const testInstance = IamIdentityV1.newInstance(options);

      expect(getAuthenticatorMock).not.toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
      expect(testInstance.baseOptions.serviceName).toBe('my-service');
      expect(testInstance).toBeInstanceOf(IamIdentityV1);
    });
  });
  describe('the constructor', () => {
    test('use user-given service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
      };

      const testInstance = new IamIdentityV1(options);

      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
    });

    test('use default service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
      };

      const testInstance = new IamIdentityV1(options);

      expect(testInstance.baseOptions.serviceUrl).toBe(IamIdentityV1.DEFAULT_SERVICE_URL);
    });
  });
  describe('listApiKeys', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listApiKeys
        const accountId = 'testString';
        const iamId = 'testString';
        const pagesize = 38;
        const pagetoken = 'testString';
        const scope = 'entity';
        const type = 'user';
        const sort = 'testString';
        const order = 'asc';
        const includeHistory = true;
        const params = {
          accountId: accountId,
          iamId: iamId,
          pagesize: pagesize,
          pagetoken: pagetoken,
          scope: scope,
          type: type,
          sort: sort,
          order: order,
          includeHistory: includeHistory,
        };

        const listApiKeysResult = iamIdentityService.listApiKeys(params);

        // all methods should return a Promise
        expectToBePromise(listApiKeysResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/apikeys', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['account_id']).toEqual(accountId);
        expect(options.qs['iam_id']).toEqual(iamId);
        expect(options.qs['pagesize']).toEqual(pagesize);
        expect(options.qs['pagetoken']).toEqual(pagetoken);
        expect(options.qs['scope']).toEqual(scope);
        expect(options.qs['type']).toEqual(type);
        expect(options.qs['sort']).toEqual(sort);
        expect(options.qs['order']).toEqual(order);
        expect(options.qs['include_history']).toEqual(includeHistory);
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

        iamIdentityService.listApiKeys(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        iamIdentityService.listApiKeys({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('createApiKey', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createApiKey
        const name = 'testString';
        const iamId = 'testString';
        const description = 'testString';
        const accountId = 'testString';
        const apikey = 'testString';
        const storeValue = true;
        const entityLock = 'testString';
        const params = {
          name: name,
          iamId: iamId,
          description: description,
          accountId: accountId,
          apikey: apikey,
          storeValue: storeValue,
          entityLock: entityLock,
        };

        const createApiKeyResult = iamIdentityService.createApiKey(params);

        // all methods should return a Promise
        expectToBePromise(createApiKeyResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/apikeys', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Entity-Lock', entityLock);
        expect(options.body['name']).toEqual(name);
        expect(options.body['iam_id']).toEqual(iamId);
        expect(options.body['description']).toEqual(description);
        expect(options.body['account_id']).toEqual(accountId);
        expect(options.body['apikey']).toEqual(apikey);
        expect(options.body['store_value']).toEqual(storeValue);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const name = 'testString';
        const iamId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          name,
          iamId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamIdentityService.createApiKey(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamIdentityService.createApiKey({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const createApiKeyPromise = iamIdentityService.createApiKey();
        expectToBePromise(createApiKeyPromise);

        createApiKeyPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getApiKeysDetails', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getApiKeysDetails
        const iamApiKey = 'testString';
        const includeHistory = true;
        const params = {
          iamApiKey: iamApiKey,
          includeHistory: includeHistory,
        };

        const getApiKeysDetailsResult = iamIdentityService.getApiKeysDetails(params);

        // all methods should return a Promise
        expectToBePromise(getApiKeysDetailsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/apikeys/details', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'IAM-ApiKey', iamApiKey);
        expect(options.qs['include_history']).toEqual(includeHistory);
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

        iamIdentityService.getApiKeysDetails(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        iamIdentityService.getApiKeysDetails({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('getApiKey', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getApiKey
        const id = 'testString';
        const includeHistory = true;
        const params = {
          id: id,
          includeHistory: includeHistory,
        };

        const getApiKeyResult = iamIdentityService.getApiKey(params);

        // all methods should return a Promise
        expectToBePromise(getApiKeyResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/apikeys/{id}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['include_history']).toEqual(includeHistory);
        expect(options.path['id']).toEqual(id);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const id = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          id,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamIdentityService.getApiKey(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamIdentityService.getApiKey({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getApiKeyPromise = iamIdentityService.getApiKey();
        expectToBePromise(getApiKeyPromise);

        getApiKeyPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('updateApiKey', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation updateApiKey
        const id = 'testString';
        const ifMatch = 'testString';
        const name = 'testString';
        const description = 'testString';
        const params = {
          id: id,
          ifMatch: ifMatch,
          name: name,
          description: description,
        };

        const updateApiKeyResult = iamIdentityService.updateApiKey(params);

        // all methods should return a Promise
        expectToBePromise(updateApiKeyResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/apikeys/{id}', 'PUT');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'If-Match', ifMatch);
        expect(options.body['name']).toEqual(name);
        expect(options.body['description']).toEqual(description);
        expect(options.path['id']).toEqual(id);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const id = 'testString';
        const ifMatch = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          id,
          ifMatch,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamIdentityService.updateApiKey(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamIdentityService.updateApiKey({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const updateApiKeyPromise = iamIdentityService.updateApiKey();
        expectToBePromise(updateApiKeyPromise);

        updateApiKeyPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deleteApiKey', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteApiKey
        const id = 'testString';
        const params = {
          id: id,
        };

        const deleteApiKeyResult = iamIdentityService.deleteApiKey(params);

        // all methods should return a Promise
        expectToBePromise(deleteApiKeyResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/apikeys/{id}', 'DELETE');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['id']).toEqual(id);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const id = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          id,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamIdentityService.deleteApiKey(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamIdentityService.deleteApiKey({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const deleteApiKeyPromise = iamIdentityService.deleteApiKey();
        expectToBePromise(deleteApiKeyPromise);

        deleteApiKeyPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('lockApiKey', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation lockApiKey
        const id = 'testString';
        const params = {
          id: id,
        };

        const lockApiKeyResult = iamIdentityService.lockApiKey(params);

        // all methods should return a Promise
        expectToBePromise(lockApiKeyResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/apikeys/{id}/lock', 'POST');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['id']).toEqual(id);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const id = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          id,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamIdentityService.lockApiKey(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamIdentityService.lockApiKey({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const lockApiKeyPromise = iamIdentityService.lockApiKey();
        expectToBePromise(lockApiKeyPromise);

        lockApiKeyPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('unlockApiKey', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation unlockApiKey
        const id = 'testString';
        const params = {
          id: id,
        };

        const unlockApiKeyResult = iamIdentityService.unlockApiKey(params);

        // all methods should return a Promise
        expectToBePromise(unlockApiKeyResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/apikeys/{id}/lock', 'DELETE');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['id']).toEqual(id);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const id = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          id,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamIdentityService.unlockApiKey(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamIdentityService.unlockApiKey({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const unlockApiKeyPromise = iamIdentityService.unlockApiKey();
        expectToBePromise(unlockApiKeyPromise);

        unlockApiKeyPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('listServiceIds', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listServiceIds
        const accountId = 'testString';
        const name = 'testString';
        const pagesize = 38;
        const pagetoken = 'testString';
        const sort = 'testString';
        const order = 'asc';
        const includeHistory = true;
        const params = {
          accountId: accountId,
          name: name,
          pagesize: pagesize,
          pagetoken: pagetoken,
          sort: sort,
          order: order,
          includeHistory: includeHistory,
        };

        const listServiceIdsResult = iamIdentityService.listServiceIds(params);

        // all methods should return a Promise
        expectToBePromise(listServiceIdsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/serviceids/', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['account_id']).toEqual(accountId);
        expect(options.qs['name']).toEqual(name);
        expect(options.qs['pagesize']).toEqual(pagesize);
        expect(options.qs['pagetoken']).toEqual(pagetoken);
        expect(options.qs['sort']).toEqual(sort);
        expect(options.qs['order']).toEqual(order);
        expect(options.qs['include_history']).toEqual(includeHistory);
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

        iamIdentityService.listServiceIds(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        iamIdentityService.listServiceIds({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('createServiceId', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // CreateApiKeyRequest
      const createApiKeyRequestModel = {
        name: 'testString',
        description: 'testString',
        iam_id: 'testString',
        account_id: 'testString',
        apikey: 'testString',
        store_value: true,
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createServiceId
        const accountId = 'testString';
        const name = 'testString';
        const description = 'testString';
        const uniqueInstanceCrns = ['testString'];
        const apikey = createApiKeyRequestModel;
        const entityLock = 'testString';
        const params = {
          accountId: accountId,
          name: name,
          description: description,
          uniqueInstanceCrns: uniqueInstanceCrns,
          apikey: apikey,
          entityLock: entityLock,
        };

        const createServiceIdResult = iamIdentityService.createServiceId(params);

        // all methods should return a Promise
        expectToBePromise(createServiceIdResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/serviceids/', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Entity-Lock', entityLock);
        expect(options.body['account_id']).toEqual(accountId);
        expect(options.body['name']).toEqual(name);
        expect(options.body['description']).toEqual(description);
        expect(options.body['unique_instance_crns']).toEqual(uniqueInstanceCrns);
        expect(options.body['apikey']).toEqual(apikey);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountId = 'testString';
        const name = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountId,
          name,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamIdentityService.createServiceId(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamIdentityService.createServiceId({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const createServiceIdPromise = iamIdentityService.createServiceId();
        expectToBePromise(createServiceIdPromise);

        createServiceIdPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getServiceId', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getServiceId
        const id = 'testString';
        const includeHistory = true;
        const params = {
          id: id,
          includeHistory: includeHistory,
        };

        const getServiceIdResult = iamIdentityService.getServiceId(params);

        // all methods should return a Promise
        expectToBePromise(getServiceIdResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/serviceids/{id}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['include_history']).toEqual(includeHistory);
        expect(options.path['id']).toEqual(id);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const id = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          id,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamIdentityService.getServiceId(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamIdentityService.getServiceId({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getServiceIdPromise = iamIdentityService.getServiceId();
        expectToBePromise(getServiceIdPromise);

        getServiceIdPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('updateServiceId', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation updateServiceId
        const id = 'testString';
        const ifMatch = 'testString';
        const name = 'testString';
        const description = 'testString';
        const uniqueInstanceCrns = ['testString'];
        const params = {
          id: id,
          ifMatch: ifMatch,
          name: name,
          description: description,
          uniqueInstanceCrns: uniqueInstanceCrns,
        };

        const updateServiceIdResult = iamIdentityService.updateServiceId(params);

        // all methods should return a Promise
        expectToBePromise(updateServiceIdResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/serviceids/{id}', 'PUT');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'If-Match', ifMatch);
        expect(options.body['name']).toEqual(name);
        expect(options.body['description']).toEqual(description);
        expect(options.body['unique_instance_crns']).toEqual(uniqueInstanceCrns);
        expect(options.path['id']).toEqual(id);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const id = 'testString';
        const ifMatch = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          id,
          ifMatch,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamIdentityService.updateServiceId(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamIdentityService.updateServiceId({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const updateServiceIdPromise = iamIdentityService.updateServiceId();
        expectToBePromise(updateServiceIdPromise);

        updateServiceIdPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deleteServiceId', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteServiceId
        const id = 'testString';
        const params = {
          id: id,
        };

        const deleteServiceIdResult = iamIdentityService.deleteServiceId(params);

        // all methods should return a Promise
        expectToBePromise(deleteServiceIdResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/serviceids/{id}', 'DELETE');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['id']).toEqual(id);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const id = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          id,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamIdentityService.deleteServiceId(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamIdentityService.deleteServiceId({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const deleteServiceIdPromise = iamIdentityService.deleteServiceId();
        expectToBePromise(deleteServiceIdPromise);

        deleteServiceIdPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('lockServiceId', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation lockServiceId
        const id = 'testString';
        const params = {
          id: id,
        };

        const lockServiceIdResult = iamIdentityService.lockServiceId(params);

        // all methods should return a Promise
        expectToBePromise(lockServiceIdResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/serviceids/{id}/lock', 'POST');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['id']).toEqual(id);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const id = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          id,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamIdentityService.lockServiceId(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamIdentityService.lockServiceId({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const lockServiceIdPromise = iamIdentityService.lockServiceId();
        expectToBePromise(lockServiceIdPromise);

        lockServiceIdPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('unlockServiceId', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation unlockServiceId
        const id = 'testString';
        const params = {
          id: id,
        };

        const unlockServiceIdResult = iamIdentityService.unlockServiceId(params);

        // all methods should return a Promise
        expectToBePromise(unlockServiceIdResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/serviceids/{id}/lock', 'DELETE');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['id']).toEqual(id);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const id = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          id,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamIdentityService.unlockServiceId(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamIdentityService.unlockServiceId({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const unlockServiceIdPromise = iamIdentityService.unlockServiceId();
        expectToBePromise(unlockServiceIdPromise);

        unlockServiceIdPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
});
