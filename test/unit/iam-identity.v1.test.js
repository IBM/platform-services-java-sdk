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
        const includeHistory = false;
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
        expect(options.qs.account_id).toEqual(accountId);
        expect(options.qs.iam_id).toEqual(iamId);
        expect(options.qs.pagesize).toEqual(pagesize);
        expect(options.qs.pagetoken).toEqual(pagetoken);
        expect(options.qs.scope).toEqual(scope);
        expect(options.qs.type).toEqual(type);
        expect(options.qs.sort).toEqual(sort);
        expect(options.qs.order).toEqual(order);
        expect(options.qs.include_history).toEqual(includeHistory);
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
        expect(options.body.name).toEqual(name);
        expect(options.body.iam_id).toEqual(iamId);
        expect(options.body.description).toEqual(description);
        expect(options.body.account_id).toEqual(accountId);
        expect(options.body.apikey).toEqual(apikey);
        expect(options.body.store_value).toEqual(storeValue);
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
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await iamIdentityService.createApiKey({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const createApiKeyPromise = iamIdentityService.createApiKey();
        expectToBePromise(createApiKeyPromise);

        createApiKeyPromise.catch((err) => {
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
        const includeHistory = false;
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
        expect(options.qs.include_history).toEqual(includeHistory);
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
        const includeHistory = false;
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
        expect(options.qs.include_history).toEqual(includeHistory);
        expect(options.path.id).toEqual(id);
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
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await iamIdentityService.getApiKey({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const getApiKeyPromise = iamIdentityService.getApiKey();
        expectToBePromise(getApiKeyPromise);

        getApiKeyPromise.catch((err) => {
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
        expect(options.body.name).toEqual(name);
        expect(options.body.description).toEqual(description);
        expect(options.path.id).toEqual(id);
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
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await iamIdentityService.updateApiKey({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const updateApiKeyPromise = iamIdentityService.updateApiKey();
        expectToBePromise(updateApiKeyPromise);

        updateApiKeyPromise.catch((err) => {
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
        expect(options.path.id).toEqual(id);
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
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await iamIdentityService.deleteApiKey({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const deleteApiKeyPromise = iamIdentityService.deleteApiKey();
        expectToBePromise(deleteApiKeyPromise);

        deleteApiKeyPromise.catch((err) => {
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
        expect(options.path.id).toEqual(id);
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
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await iamIdentityService.lockApiKey({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const lockApiKeyPromise = iamIdentityService.lockApiKey();
        expectToBePromise(lockApiKeyPromise);

        lockApiKeyPromise.catch((err) => {
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
        expect(options.path.id).toEqual(id);
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
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await iamIdentityService.unlockApiKey({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const unlockApiKeyPromise = iamIdentityService.unlockApiKey();
        expectToBePromise(unlockApiKeyPromise);

        unlockApiKeyPromise.catch((err) => {
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
        const includeHistory = false;
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
        expect(options.qs.account_id).toEqual(accountId);
        expect(options.qs.name).toEqual(name);
        expect(options.qs.pagesize).toEqual(pagesize);
        expect(options.qs.pagetoken).toEqual(pagetoken);
        expect(options.qs.sort).toEqual(sort);
        expect(options.qs.order).toEqual(order);
        expect(options.qs.include_history).toEqual(includeHistory);
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

      // ApiKeyInsideCreateServiceIdRequest
      const apiKeyInsideCreateServiceIdRequestModel = {
        name: 'testString',
        description: 'testString',
        apikey: 'testString',
        store_value: true,
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createServiceId
        const accountId = 'testString';
        const name = 'testString';
        const description = 'testString';
        const uniqueInstanceCrns = ['testString'];
        const apikey = apiKeyInsideCreateServiceIdRequestModel;
        const entityLock = 'false';
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
        expect(options.body.account_id).toEqual(accountId);
        expect(options.body.name).toEqual(name);
        expect(options.body.description).toEqual(description);
        expect(options.body.unique_instance_crns).toEqual(uniqueInstanceCrns);
        expect(options.body.apikey).toEqual(apikey);
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
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await iamIdentityService.createServiceId({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const createServiceIdPromise = iamIdentityService.createServiceId();
        expectToBePromise(createServiceIdPromise);

        createServiceIdPromise.catch((err) => {
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
        const includeHistory = false;
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
        expect(options.qs.include_history).toEqual(includeHistory);
        expect(options.path.id).toEqual(id);
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
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await iamIdentityService.getServiceId({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const getServiceIdPromise = iamIdentityService.getServiceId();
        expectToBePromise(getServiceIdPromise);

        getServiceIdPromise.catch((err) => {
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
        expect(options.body.name).toEqual(name);
        expect(options.body.description).toEqual(description);
        expect(options.body.unique_instance_crns).toEqual(uniqueInstanceCrns);
        expect(options.path.id).toEqual(id);
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
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await iamIdentityService.updateServiceId({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const updateServiceIdPromise = iamIdentityService.updateServiceId();
        expectToBePromise(updateServiceIdPromise);

        updateServiceIdPromise.catch((err) => {
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
        expect(options.path.id).toEqual(id);
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
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await iamIdentityService.deleteServiceId({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const deleteServiceIdPromise = iamIdentityService.deleteServiceId();
        expectToBePromise(deleteServiceIdPromise);

        deleteServiceIdPromise.catch((err) => {
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
        expect(options.path.id).toEqual(id);
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
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await iamIdentityService.lockServiceId({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const lockServiceIdPromise = iamIdentityService.lockServiceId();
        expectToBePromise(lockServiceIdPromise);

        lockServiceIdPromise.catch((err) => {
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
        expect(options.path.id).toEqual(id);
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
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await iamIdentityService.unlockServiceId({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const unlockServiceIdPromise = iamIdentityService.unlockServiceId();
        expectToBePromise(unlockServiceIdPromise);

        unlockServiceIdPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('createProfile', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createProfile
        const name = 'testString';
        const accountId = 'testString';
        const description = 'testString';
        const params = {
          name: name,
          accountId: accountId,
          description: description,
        };

        const createProfileResult = iamIdentityService.createProfile(params);

        // all methods should return a Promise
        expectToBePromise(createProfileResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/profiles', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body.name).toEqual(name);
        expect(options.body.account_id).toEqual(accountId);
        expect(options.body.description).toEqual(description);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const name = 'testString';
        const accountId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          name,
          accountId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamIdentityService.createProfile(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await iamIdentityService.createProfile({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const createProfilePromise = iamIdentityService.createProfile();
        expectToBePromise(createProfilePromise);

        createProfilePromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('listProfiles', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listProfiles
        const accountId = 'testString';
        const name = 'testString';
        const pagesize = 38;
        const sort = 'testString';
        const order = 'asc';
        const includeHistory = false;
        const pagetoken = 'testString';
        const params = {
          accountId: accountId,
          name: name,
          pagesize: pagesize,
          sort: sort,
          order: order,
          includeHistory: includeHistory,
          pagetoken: pagetoken,
        };

        const listProfilesResult = iamIdentityService.listProfiles(params);

        // all methods should return a Promise
        expectToBePromise(listProfilesResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/profiles', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs.account_id).toEqual(accountId);
        expect(options.qs.name).toEqual(name);
        expect(options.qs.pagesize).toEqual(pagesize);
        expect(options.qs.sort).toEqual(sort);
        expect(options.qs.order).toEqual(order);
        expect(options.qs.include_history).toEqual(includeHistory);
        expect(options.qs.pagetoken).toEqual(pagetoken);
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

        iamIdentityService.listProfiles(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await iamIdentityService.listProfiles({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const listProfilesPromise = iamIdentityService.listProfiles();
        expectToBePromise(listProfilesPromise);

        listProfilesPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getProfile', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getProfile
        const profileId = 'testString';
        const params = {
          profileId: profileId,
        };

        const getProfileResult = iamIdentityService.getProfile(params);

        // all methods should return a Promise
        expectToBePromise(getProfileResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/profiles/{profile-id}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['profile-id']).toEqual(profileId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const profileId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          profileId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamIdentityService.getProfile(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await iamIdentityService.getProfile({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const getProfilePromise = iamIdentityService.getProfile();
        expectToBePromise(getProfilePromise);

        getProfilePromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('updateProfile', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation updateProfile
        const profileId = 'testString';
        const ifMatch = 'testString';
        const name = 'testString';
        const description = 'testString';
        const params = {
          profileId: profileId,
          ifMatch: ifMatch,
          name: name,
          description: description,
        };

        const updateProfileResult = iamIdentityService.updateProfile(params);

        // all methods should return a Promise
        expectToBePromise(updateProfileResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/profiles/{profile-id}', 'PUT');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'If-Match', ifMatch);
        expect(options.body.name).toEqual(name);
        expect(options.body.description).toEqual(description);
        expect(options.path['profile-id']).toEqual(profileId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const profileId = 'testString';
        const ifMatch = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          profileId,
          ifMatch,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamIdentityService.updateProfile(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await iamIdentityService.updateProfile({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const updateProfilePromise = iamIdentityService.updateProfile();
        expectToBePromise(updateProfilePromise);

        updateProfilePromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deleteProfile', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteProfile
        const profileId = 'testString';
        const params = {
          profileId: profileId,
        };

        const deleteProfileResult = iamIdentityService.deleteProfile(params);

        // all methods should return a Promise
        expectToBePromise(deleteProfileResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/profiles/{profile-id}', 'DELETE');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['profile-id']).toEqual(profileId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const profileId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          profileId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamIdentityService.deleteProfile(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await iamIdentityService.deleteProfile({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const deleteProfilePromise = iamIdentityService.deleteProfile();
        expectToBePromise(deleteProfilePromise);

        deleteProfilePromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('createClaimRule', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // ProfileClaimRuleConditions
      const profileClaimRuleConditionsModel = {
        claim: 'testString',
        operator: 'testString',
        value: 'testString',
      };

      // ResponseContext
      const responseContextModel = {
        transaction_id: 'testString',
        operation: 'testString',
        user_agent: 'testString',
        url: 'testString',
        instance_id: 'testString',
        thread_id: 'testString',
        host: 'testString',
        start_time: 'testString',
        end_time: 'testString',
        elapsed_time: 'testString',
        cluster_name: 'testString',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createClaimRule
        const profileId = 'testString';
        const type = 'testString';
        const conditions = [profileClaimRuleConditionsModel];
        const context = responseContextModel;
        const name = 'testString';
        const realmName = 'testString';
        const crType = 'testString';
        const expiration = 38;
        const params = {
          profileId: profileId,
          type: type,
          conditions: conditions,
          context: context,
          name: name,
          realmName: realmName,
          crType: crType,
          expiration: expiration,
        };

        const createClaimRuleResult = iamIdentityService.createClaimRule(params);

        // all methods should return a Promise
        expectToBePromise(createClaimRuleResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/profiles/{profile-id}/rules', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body.type).toEqual(type);
        expect(options.body.conditions).toEqual(conditions);
        expect(options.body.context).toEqual(context);
        expect(options.body.name).toEqual(name);
        expect(options.body.realm_name).toEqual(realmName);
        expect(options.body.cr_type).toEqual(crType);
        expect(options.body.expiration).toEqual(expiration);
        expect(options.path['profile-id']).toEqual(profileId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const profileId = 'testString';
        const type = 'testString';
        const conditions = [profileClaimRuleConditionsModel];
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          profileId,
          type,
          conditions,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamIdentityService.createClaimRule(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await iamIdentityService.createClaimRule({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const createClaimRulePromise = iamIdentityService.createClaimRule();
        expectToBePromise(createClaimRulePromise);

        createClaimRulePromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('listClaimRules', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listClaimRules
        const profileId = 'testString';
        const params = {
          profileId: profileId,
        };

        const listClaimRulesResult = iamIdentityService.listClaimRules(params);

        // all methods should return a Promise
        expectToBePromise(listClaimRulesResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/profiles/{profile-id}/rules', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['profile-id']).toEqual(profileId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const profileId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          profileId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamIdentityService.listClaimRules(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await iamIdentityService.listClaimRules({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const listClaimRulesPromise = iamIdentityService.listClaimRules();
        expectToBePromise(listClaimRulesPromise);

        listClaimRulesPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getClaimRule', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getClaimRule
        const profileId = 'testString';
        const ruleId = 'testString';
        const params = {
          profileId: profileId,
          ruleId: ruleId,
        };

        const getClaimRuleResult = iamIdentityService.getClaimRule(params);

        // all methods should return a Promise
        expectToBePromise(getClaimRuleResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/profiles/{profile-id}/rules/{rule-id}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['profile-id']).toEqual(profileId);
        expect(options.path['rule-id']).toEqual(ruleId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const profileId = 'testString';
        const ruleId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          profileId,
          ruleId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamIdentityService.getClaimRule(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await iamIdentityService.getClaimRule({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const getClaimRulePromise = iamIdentityService.getClaimRule();
        expectToBePromise(getClaimRulePromise);

        getClaimRulePromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('updateClaimRule', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // ProfileClaimRuleConditions
      const profileClaimRuleConditionsModel = {
        claim: 'testString',
        operator: 'testString',
        value: 'testString',
      };

      // ResponseContext
      const responseContextModel = {
        transaction_id: 'testString',
        operation: 'testString',
        user_agent: 'testString',
        url: 'testString',
        instance_id: 'testString',
        thread_id: 'testString',
        host: 'testString',
        start_time: 'testString',
        end_time: 'testString',
        elapsed_time: 'testString',
        cluster_name: 'testString',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation updateClaimRule
        const profileId = 'testString';
        const ruleId = 'testString';
        const ifMatch = 'testString';
        const type = 'testString';
        const conditions = [profileClaimRuleConditionsModel];
        const context = responseContextModel;
        const name = 'testString';
        const realmName = 'testString';
        const crType = 'testString';
        const expiration = 38;
        const params = {
          profileId: profileId,
          ruleId: ruleId,
          ifMatch: ifMatch,
          type: type,
          conditions: conditions,
          context: context,
          name: name,
          realmName: realmName,
          crType: crType,
          expiration: expiration,
        };

        const updateClaimRuleResult = iamIdentityService.updateClaimRule(params);

        // all methods should return a Promise
        expectToBePromise(updateClaimRuleResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/profiles/{profile-id}/rules/{rule-id}', 'PUT');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'If-Match', ifMatch);
        expect(options.body.type).toEqual(type);
        expect(options.body.conditions).toEqual(conditions);
        expect(options.body.context).toEqual(context);
        expect(options.body.name).toEqual(name);
        expect(options.body.realm_name).toEqual(realmName);
        expect(options.body.cr_type).toEqual(crType);
        expect(options.body.expiration).toEqual(expiration);
        expect(options.path['profile-id']).toEqual(profileId);
        expect(options.path['rule-id']).toEqual(ruleId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const profileId = 'testString';
        const ruleId = 'testString';
        const ifMatch = 'testString';
        const type = 'testString';
        const conditions = [profileClaimRuleConditionsModel];
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          profileId,
          ruleId,
          ifMatch,
          type,
          conditions,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamIdentityService.updateClaimRule(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await iamIdentityService.updateClaimRule({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const updateClaimRulePromise = iamIdentityService.updateClaimRule();
        expectToBePromise(updateClaimRulePromise);

        updateClaimRulePromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deleteClaimRule', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteClaimRule
        const profileId = 'testString';
        const ruleId = 'testString';
        const params = {
          profileId: profileId,
          ruleId: ruleId,
        };

        const deleteClaimRuleResult = iamIdentityService.deleteClaimRule(params);

        // all methods should return a Promise
        expectToBePromise(deleteClaimRuleResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/profiles/{profile-id}/rules/{rule-id}', 'DELETE');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['profile-id']).toEqual(profileId);
        expect(options.path['rule-id']).toEqual(ruleId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const profileId = 'testString';
        const ruleId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          profileId,
          ruleId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamIdentityService.deleteClaimRule(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await iamIdentityService.deleteClaimRule({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const deleteClaimRulePromise = iamIdentityService.deleteClaimRule();
        expectToBePromise(deleteClaimRulePromise);

        deleteClaimRulePromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('createLink', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // CreateProfileLinkRequestLink
      const createProfileLinkRequestLinkModel = {
        crn: 'testString',
        namespace: 'testString',
        name: 'testString',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createLink
        const profileId = 'testString';
        const crType = 'testString';
        const link = createProfileLinkRequestLinkModel;
        const name = 'testString';
        const params = {
          profileId: profileId,
          crType: crType,
          link: link,
          name: name,
        };

        const createLinkResult = iamIdentityService.createLink(params);

        // all methods should return a Promise
        expectToBePromise(createLinkResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/profiles/{profile-id}/links', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body.cr_type).toEqual(crType);
        expect(options.body.link).toEqual(link);
        expect(options.body.name).toEqual(name);
        expect(options.path['profile-id']).toEqual(profileId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const profileId = 'testString';
        const crType = 'testString';
        const link = createProfileLinkRequestLinkModel;
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          profileId,
          crType,
          link,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamIdentityService.createLink(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await iamIdentityService.createLink({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const createLinkPromise = iamIdentityService.createLink();
        expectToBePromise(createLinkPromise);

        createLinkPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('listLinks', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listLinks
        const profileId = 'testString';
        const params = {
          profileId: profileId,
        };

        const listLinksResult = iamIdentityService.listLinks(params);

        // all methods should return a Promise
        expectToBePromise(listLinksResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/profiles/{profile-id}/links', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['profile-id']).toEqual(profileId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const profileId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          profileId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamIdentityService.listLinks(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await iamIdentityService.listLinks({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const listLinksPromise = iamIdentityService.listLinks();
        expectToBePromise(listLinksPromise);

        listLinksPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getLink', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getLink
        const profileId = 'testString';
        const linkId = 'testString';
        const params = {
          profileId: profileId,
          linkId: linkId,
        };

        const getLinkResult = iamIdentityService.getLink(params);

        // all methods should return a Promise
        expectToBePromise(getLinkResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/profiles/{profile-id}/links/{link-id}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['profile-id']).toEqual(profileId);
        expect(options.path['link-id']).toEqual(linkId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const profileId = 'testString';
        const linkId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          profileId,
          linkId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamIdentityService.getLink(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await iamIdentityService.getLink({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const getLinkPromise = iamIdentityService.getLink();
        expectToBePromise(getLinkPromise);

        getLinkPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deleteLink', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteLink
        const profileId = 'testString';
        const linkId = 'testString';
        const params = {
          profileId: profileId,
          linkId: linkId,
        };

        const deleteLinkResult = iamIdentityService.deleteLink(params);

        // all methods should return a Promise
        expectToBePromise(deleteLinkResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/profiles/{profile-id}/links/{link-id}', 'DELETE');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['profile-id']).toEqual(profileId);
        expect(options.path['link-id']).toEqual(linkId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const profileId = 'testString';
        const linkId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          profileId,
          linkId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamIdentityService.deleteLink(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await iamIdentityService.deleteLink({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const deleteLinkPromise = iamIdentityService.deleteLink();
        expectToBePromise(deleteLinkPromise);

        deleteLinkPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getAccountSettings', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getAccountSettings
        const accountId = 'testString';
        const includeHistory = false;
        const params = {
          accountId: accountId,
          includeHistory: includeHistory,
        };

        const getAccountSettingsResult = iamIdentityService.getAccountSettings(params);

        // all methods should return a Promise
        expectToBePromise(getAccountSettingsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/accounts/{account_id}/settings/identity', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs.include_history).toEqual(includeHistory);
        expect(options.path.account_id).toEqual(accountId);
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

        iamIdentityService.getAccountSettings(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await iamIdentityService.getAccountSettings({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const getAccountSettingsPromise = iamIdentityService.getAccountSettings();
        expectToBePromise(getAccountSettingsPromise);

        getAccountSettingsPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('updateAccountSettings', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation updateAccountSettings
        const ifMatch = 'testString';
        const accountId = 'testString';
        const restrictCreateServiceId = 'RESTRICTED';
        const restrictCreatePlatformApikey = 'RESTRICTED';
        const allowedIpAddresses = 'testString';
        const mfa = 'NONE';
        const sessionExpirationInSeconds = '86400';
        const sessionInvalidationInSeconds = '7200';
        const maxSessionsPerIdentity = 'testString';
        const params = {
          ifMatch: ifMatch,
          accountId: accountId,
          restrictCreateServiceId: restrictCreateServiceId,
          restrictCreatePlatformApikey: restrictCreatePlatformApikey,
          allowedIpAddresses: allowedIpAddresses,
          mfa: mfa,
          sessionExpirationInSeconds: sessionExpirationInSeconds,
          sessionInvalidationInSeconds: sessionInvalidationInSeconds,
          maxSessionsPerIdentity: maxSessionsPerIdentity,
        };

        const updateAccountSettingsResult = iamIdentityService.updateAccountSettings(params);

        // all methods should return a Promise
        expectToBePromise(updateAccountSettingsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/accounts/{account_id}/settings/identity', 'PUT');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'If-Match', ifMatch);
        expect(options.body.restrict_create_service_id).toEqual(restrictCreateServiceId);
        expect(options.body.restrict_create_platform_apikey).toEqual(restrictCreatePlatformApikey);
        expect(options.body.allowed_ip_addresses).toEqual(allowedIpAddresses);
        expect(options.body.mfa).toEqual(mfa);
        expect(options.body.session_expiration_in_seconds).toEqual(sessionExpirationInSeconds);
        expect(options.body.session_invalidation_in_seconds).toEqual(sessionInvalidationInSeconds);
        expect(options.body.max_sessions_per_identity).toEqual(maxSessionsPerIdentity);
        expect(options.path.account_id).toEqual(accountId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const ifMatch = 'testString';
        const accountId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          ifMatch,
          accountId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamIdentityService.updateAccountSettings(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await iamIdentityService.updateAccountSettings({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const updateAccountSettingsPromise = iamIdentityService.updateAccountSettings();
        expectToBePromise(updateAccountSettingsPromise);

        updateAccountSettingsPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
});
