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

const IamIdentityServicesV1 = require('../../dist/iam-identity-services/v1');

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
  url: 'https://iam.test.cloud.ibm.com',
};

const iamIdentityServices = new IamIdentityServicesV1(service);

// dont actually create a request
const createRequestMock = jest.spyOn(iamIdentityServices, 'createRequest');
createRequestMock.mockImplementation(() => Promise.resolve());

// dont actually construct an authenticator
const getAuthenticatorMock = jest.spyOn(core, 'getAuthenticatorFromEnvironment');
getAuthenticatorMock.mockImplementation(() => new NoAuthAuthenticator());

afterEach(() => {
  createRequestMock.mockClear();
  getAuthenticatorMock.mockClear();
});

describe('IamIdentityServicesV1', () => {
  describe('the newInstance method', () => {
    test('should use defaults when options not provided', () => {
      const testInstance = IamIdentityServicesV1.newInstance();

      expect(getAuthenticatorMock).toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceName).toBe(IamIdentityServicesV1.DEFAULT_SERVICE_NAME);
      expect(testInstance.baseOptions.serviceUrl).toBe(IamIdentityServicesV1.DEFAULT_SERVICE_URL);
      expect(testInstance).toBeInstanceOf(IamIdentityServicesV1);
    });

    test('should set serviceName, serviceUrl, and authenticator when provided', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
        serviceName: 'my-service',
      };

      const testInstance = IamIdentityServicesV1.newInstance(options);

      expect(getAuthenticatorMock).not.toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
      expect(testInstance.baseOptions.serviceName).toBe('my-service');
      expect(testInstance).toBeInstanceOf(IamIdentityServicesV1);
    });
  });
  describe('the constructor', () => {
    test('use user-given service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
      };

      const testInstance = new IamIdentityServicesV1(options);

      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
    });

    test('use default service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
      };

      const testInstance = new IamIdentityServicesV1(options);

      expect(testInstance.baseOptions.serviceUrl).toBe(IamIdentityServicesV1.DEFAULT_SERVICE_URL);
    });
  });
  describe('listApiKeys', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listApiKeys
        const accountId = 'testString';
        const iamId = 'testString';
        const pagesize = 'testString';
        const pagetoken = 'testString';
        const params = {
          accountId: accountId,
          iamId: iamId,
          pagesize: pagesize,
          pagetoken: pagetoken,
        };

        const listApiKeysResult = iamIdentityServices.listApiKeys(params);

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

        iamIdentityServices.listApiKeys(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        iamIdentityServices.listApiKeys({});
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
        const entityLock = 'testString';
        const params = {
          name: name,
          iamId: iamId,
          description: description,
          accountId: accountId,
          apikey: apikey,
          entityLock: entityLock,
        };

        const createApiKeyResult = iamIdentityServices.createApiKey(params);

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

        iamIdentityServices.createApiKey(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamIdentityServices.createApiKey({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const createApiKeyPromise = iamIdentityServices.createApiKey();
        expectToBePromise(createApiKeyPromise);

        createApiKeyPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getApiKeyDetails', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getApiKeyDetails
        const iamApiKey = 'testString';
        const params = {
          iamApiKey: iamApiKey,
        };

        const getApiKeyDetailsResult = iamIdentityServices.getApiKeyDetails(params);

        // all methods should return a Promise
        expectToBePromise(getApiKeyDetailsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/apikeys/details', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'IAM-ApiKey', iamApiKey);
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

        iamIdentityServices.getApiKeyDetails(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        iamIdentityServices.getApiKeyDetails({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('getApiKey', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getApiKey
        const id = 'testString';
        const params = {
          id: id,
        };

        const getApiKeyResult = iamIdentityServices.getApiKey(params);

        // all methods should return a Promise
        expectToBePromise(getApiKeyResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/apikeys/{id}', 'GET');
        const expectedAccept = 'application/json';
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

        iamIdentityServices.getApiKey(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamIdentityServices.getApiKey({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getApiKeyPromise = iamIdentityServices.getApiKey();
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

        const updateApiKeyResult = iamIdentityServices.updateApiKey(params);

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

        iamIdentityServices.updateApiKey(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamIdentityServices.updateApiKey({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const updateApiKeyPromise = iamIdentityServices.updateApiKey();
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

        const deleteApiKeyResult = iamIdentityServices.deleteApiKey(params);

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

        iamIdentityServices.deleteApiKey(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamIdentityServices.deleteApiKey({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const deleteApiKeyPromise = iamIdentityServices.deleteApiKey();
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

        const lockApiKeyResult = iamIdentityServices.lockApiKey(params);

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

        iamIdentityServices.lockApiKey(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamIdentityServices.lockApiKey({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const lockApiKeyPromise = iamIdentityServices.lockApiKey();
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

        const unlockApiKeyResult = iamIdentityServices.unlockApiKey(params);

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

        iamIdentityServices.unlockApiKey(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamIdentityServices.unlockApiKey({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const unlockApiKeyPromise = iamIdentityServices.unlockApiKey();
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
        const pagesize = 'testString';
        const pagetoken = 'testString';
        const sort = 'testString';
        const order = 'testString';
        const params = {
          accountId: accountId,
          name: name,
          pagesize: pagesize,
          pagetoken: pagetoken,
          sort: sort,
          order: order,
        };

        const listServiceIdsResult = iamIdentityServices.listServiceIds(params);

        // all methods should return a Promise
        expectToBePromise(listServiceIdsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/serviceids', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['account_id']).toEqual(accountId);
        expect(options.qs['name']).toEqual(name);
        expect(options.qs['pagesize']).toEqual(pagesize);
        expect(options.qs['pagetoken']).toEqual(pagetoken);
        expect(options.qs['sort']).toEqual(sort);
        expect(options.qs['order']).toEqual(order);
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

        iamIdentityServices.listServiceIds(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        iamIdentityServices.listServiceIds({});
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

        const createServiceIdResult = iamIdentityServices.createServiceId(params);

        // all methods should return a Promise
        expectToBePromise(createServiceIdResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/serviceids', 'POST');
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

        iamIdentityServices.createServiceId(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamIdentityServices.createServiceId({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const createServiceIdPromise = iamIdentityServices.createServiceId();
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
        const params = {
          id: id,
        };

        const getServiceIdResult = iamIdentityServices.getServiceId(params);

        // all methods should return a Promise
        expectToBePromise(getServiceIdResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/serviceids/{id}', 'GET');
        const expectedAccept = 'application/json';
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

        iamIdentityServices.getServiceId(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamIdentityServices.getServiceId({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getServiceIdPromise = iamIdentityServices.getServiceId();
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

        const updateServiceIdResult = iamIdentityServices.updateServiceId(params);

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

        iamIdentityServices.updateServiceId(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamIdentityServices.updateServiceId({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const updateServiceIdPromise = iamIdentityServices.updateServiceId();
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

        const deleteServiceIdResult = iamIdentityServices.deleteServiceId(params);

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

        iamIdentityServices.deleteServiceId(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamIdentityServices.deleteServiceId({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const deleteServiceIdPromise = iamIdentityServices.deleteServiceId();
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

        const lockServiceIdResult = iamIdentityServices.lockServiceId(params);

        // all methods should return a Promise
        expectToBePromise(lockServiceIdResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/serviceids/{id}/lock', 'POST');
        const expectedAccept = 'application/json';
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

        iamIdentityServices.lockServiceId(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamIdentityServices.lockServiceId({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const lockServiceIdPromise = iamIdentityServices.lockServiceId();
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

        const unlockServiceIdResult = iamIdentityServices.unlockServiceId(params);

        // all methods should return a Promise
        expectToBePromise(unlockServiceIdResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/serviceids/{id}/lock', 'DELETE');
        const expectedAccept = 'application/json';
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

        iamIdentityServices.unlockServiceId(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamIdentityServices.unlockServiceId({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const unlockServiceIdPromise = iamIdentityServices.unlockServiceId();
        expectToBePromise(unlockServiceIdPromise);

        unlockServiceIdPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
});
