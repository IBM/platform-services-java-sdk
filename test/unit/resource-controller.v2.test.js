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

const ResourceControllerV2 = require('../../dist/resource-controller/v2');

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
  url: 'https://resource-controller.cloud.ibm.com',
};

const resourceController = new ResourceControllerV2(service);

// dont actually create a request
const createRequestMock = jest.spyOn(resourceController, 'createRequest');
createRequestMock.mockImplementation(() => Promise.resolve());

// dont actually construct an authenticator
const getAuthenticatorMock = jest.spyOn(core, 'getAuthenticatorFromEnvironment');
getAuthenticatorMock.mockImplementation(() => new NoAuthAuthenticator());

afterEach(() => {
  createRequestMock.mockClear();
  getAuthenticatorMock.mockClear();
});

describe('ResourceControllerV2', () => {
  describe('the newInstance method', () => {
    test('should use defaults when options not provided', () => {
      const testInstance = ResourceControllerV2.newInstance();

      expect(getAuthenticatorMock).toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceName).toBe(ResourceControllerV2.DEFAULT_SERVICE_NAME);
      expect(testInstance.baseOptions.serviceUrl).toBe(ResourceControllerV2.DEFAULT_SERVICE_URL);
      expect(testInstance).toBeInstanceOf(ResourceControllerV2);
    });

    test('should set serviceName, serviceUrl, and authenticator when provided', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
        serviceName: 'my-service',
      };

      const testInstance = ResourceControllerV2.newInstance(options);

      expect(getAuthenticatorMock).not.toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
      expect(testInstance.baseOptions.serviceName).toBe('my-service');
      expect(testInstance).toBeInstanceOf(ResourceControllerV2);
    });
  });
  describe('the constructor', () => {
    test('use user-given service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
      };

      const testInstance = new ResourceControllerV2(options);

      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
    });

    test('use default service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
      };

      const testInstance = new ResourceControllerV2(options);

      expect(testInstance.baseOptions.serviceUrl).toBe(ResourceControllerV2.DEFAULT_SERVICE_URL);
    });
  });
  describe('listResourceInstances', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listResourceInstances
        const guid = 'testString';
        const name = 'testString';
        const resourceGroupId = 'testString';
        const resourceId = 'testString';
        const resourcePlanId = 'testString';
        const type = 'testString';
        const subType = 'testString';
        const limit = 'testString';
        const updatedFrom = '2019-01-08T00:00:00.000Z';
        const updatedTo = '2019-01-08T00:00:00.000Z';
        const params = {
          guid: guid,
          name: name,
          resourceGroupId: resourceGroupId,
          resourceId: resourceId,
          resourcePlanId: resourcePlanId,
          type: type,
          subType: subType,
          limit: limit,
          updatedFrom: updatedFrom,
          updatedTo: updatedTo,
        };

        const listResourceInstancesResult = resourceController.listResourceInstances(params);

        // all methods should return a Promise
        expectToBePromise(listResourceInstancesResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/resource_instances', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['guid']).toEqual(guid);
        expect(options.qs['name']).toEqual(name);
        expect(options.qs['resource_group_id']).toEqual(resourceGroupId);
        expect(options.qs['resource_id']).toEqual(resourceId);
        expect(options.qs['resource_plan_id']).toEqual(resourcePlanId);
        expect(options.qs['type']).toEqual(type);
        expect(options.qs['sub_type']).toEqual(subType);
        expect(options.qs['limit']).toEqual(limit);
        expect(options.qs['updated_from']).toEqual(updatedFrom);
        expect(options.qs['updated_to']).toEqual(updatedTo);
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

        resourceController.listResourceInstances(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        resourceController.listResourceInstances({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('createResourceInstance', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createResourceInstance
        const name = 'my-instance';
        const target = 'bluemix-us-south';
        const resourceGroup = '5c49eabc-f5e8-5881-a37e-2d100a33b3df';
        const resourcePlanId = 'cloudant-standard';
        const tags = ['testString'];
        const allowCleanup = true;
        const parameters = { 'key1' : 'any' };
        const entityLock = 'testString';
        const params = {
          name: name,
          target: target,
          resourceGroup: resourceGroup,
          resourcePlanId: resourcePlanId,
          tags: tags,
          allowCleanup: allowCleanup,
          parameters: parameters,
          entityLock: entityLock,
        };

        const createResourceInstanceResult = resourceController.createResourceInstance(params);

        // all methods should return a Promise
        expectToBePromise(createResourceInstanceResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/resource_instances', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Entity-Lock', entityLock);
        expect(options.body['name']).toEqual(name);
        expect(options.body['target']).toEqual(target);
        expect(options.body['resource_group']).toEqual(resourceGroup);
        expect(options.body['resource_plan_id']).toEqual(resourcePlanId);
        expect(options.body['tags']).toEqual(tags);
        expect(options.body['allow_cleanup']).toEqual(allowCleanup);
        expect(options.body['parameters']).toEqual(parameters);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const name = 'my-instance';
        const target = 'bluemix-us-south';
        const resourceGroup = '5c49eabc-f5e8-5881-a37e-2d100a33b3df';
        const resourcePlanId = 'cloudant-standard';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          name,
          target,
          resourceGroup,
          resourcePlanId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        resourceController.createResourceInstance(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceController.createResourceInstance({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const createResourceInstancePromise = resourceController.createResourceInstance();
        expectToBePromise(createResourceInstancePromise);

        createResourceInstancePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getResourceInstance', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getResourceInstance
        const id = 'testString';
        const params = {
          id: id,
        };

        const getResourceInstanceResult = resourceController.getResourceInstance(params);

        // all methods should return a Promise
        expectToBePromise(getResourceInstanceResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/resource_instances/{id}', 'GET');
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

        resourceController.getResourceInstance(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceController.getResourceInstance({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getResourceInstancePromise = resourceController.getResourceInstance();
        expectToBePromise(getResourceInstancePromise);

        getResourceInstancePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deleteResourceInstance', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteResourceInstance
        const id = 'testString';
        const params = {
          id: id,
        };

        const deleteResourceInstanceResult = resourceController.deleteResourceInstance(params);

        // all methods should return a Promise
        expectToBePromise(deleteResourceInstanceResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/resource_instances/{id}', 'DELETE');
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

        resourceController.deleteResourceInstance(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceController.deleteResourceInstance({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const deleteResourceInstancePromise = resourceController.deleteResourceInstance();
        expectToBePromise(deleteResourceInstancePromise);

        deleteResourceInstancePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('updateResourceInstance', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation updateResourceInstance
        const id = 'testString';
        const name = 'my-new-instance-name';
        const parameters = { 'key1' : 'any' };
        const resourcePlanId = 'a8dff6d3-d287-4668-a81d-c87c55c2656d';
        const allowCleanup = true;
        const params = {
          id: id,
          name: name,
          parameters: parameters,
          resourcePlanId: resourcePlanId,
          allowCleanup: allowCleanup,
        };

        const updateResourceInstanceResult = resourceController.updateResourceInstance(params);

        // all methods should return a Promise
        expectToBePromise(updateResourceInstanceResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/resource_instances/{id}', 'PATCH');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['name']).toEqual(name);
        expect(options.body['parameters']).toEqual(parameters);
        expect(options.body['resource_plan_id']).toEqual(resourcePlanId);
        expect(options.body['allow_cleanup']).toEqual(allowCleanup);
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

        resourceController.updateResourceInstance(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceController.updateResourceInstance({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const updateResourceInstancePromise = resourceController.updateResourceInstance();
        expectToBePromise(updateResourceInstancePromise);

        updateResourceInstancePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('lockResourceInstance', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation lockResourceInstance
        const id = 'testString';
        const params = {
          id: id,
        };

        const lockResourceInstanceResult = resourceController.lockResourceInstance(params);

        // all methods should return a Promise
        expectToBePromise(lockResourceInstanceResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/resource_instances/{id}/lock', 'POST');
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

        resourceController.lockResourceInstance(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceController.lockResourceInstance({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const lockResourceInstancePromise = resourceController.lockResourceInstance();
        expectToBePromise(lockResourceInstancePromise);

        lockResourceInstancePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('unlockResourceInstance', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation unlockResourceInstance
        const id = 'testString';
        const params = {
          id: id,
        };

        const unlockResourceInstanceResult = resourceController.unlockResourceInstance(params);

        // all methods should return a Promise
        expectToBePromise(unlockResourceInstanceResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/resource_instances/{id}/lock', 'DELETE');
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

        resourceController.unlockResourceInstance(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceController.unlockResourceInstance({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const unlockResourceInstancePromise = resourceController.unlockResourceInstance();
        expectToBePromise(unlockResourceInstancePromise);

        unlockResourceInstancePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('listResourceKeys', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listResourceKeys
        const guid = 'testString';
        const name = 'testString';
        const resourceGroupId = 'testString';
        const resourceId = 'testString';
        const limit = 'testString';
        const updatedFrom = '2019-01-08T00:00:00.000Z';
        const updatedTo = '2019-01-08T00:00:00.000Z';
        const params = {
          guid: guid,
          name: name,
          resourceGroupId: resourceGroupId,
          resourceId: resourceId,
          limit: limit,
          updatedFrom: updatedFrom,
          updatedTo: updatedTo,
        };

        const listResourceKeysResult = resourceController.listResourceKeys(params);

        // all methods should return a Promise
        expectToBePromise(listResourceKeysResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/resource_keys', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['guid']).toEqual(guid);
        expect(options.qs['name']).toEqual(name);
        expect(options.qs['resource_group_id']).toEqual(resourceGroupId);
        expect(options.qs['resource_id']).toEqual(resourceId);
        expect(options.qs['limit']).toEqual(limit);
        expect(options.qs['updated_from']).toEqual(updatedFrom);
        expect(options.qs['updated_to']).toEqual(updatedTo);
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

        resourceController.listResourceKeys(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        resourceController.listResourceKeys({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('createResourceKey', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // ResourceKeyPostParameters
      const resourceKeyPostParametersModel = {
        serviceid_crn: 'crn:v1:bluemix:public:iam-identity::a/9fceaa56d1ab84893af6b9eec5ab81bb::serviceid:ServiceId-fe4c29b5-db13-410a-bacc-b5779a03d393',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createResourceKey
        const name = 'my-key';
        const source = '25eba2a9-beef-450b-82cf-f5ad5e36c6dd';
        const parameters = resourceKeyPostParametersModel;
        const role = 'Writer';
        const params = {
          name: name,
          source: source,
          parameters: parameters,
          role: role,
        };

        const createResourceKeyResult = resourceController.createResourceKey(params);

        // all methods should return a Promise
        expectToBePromise(createResourceKeyResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/resource_keys', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['name']).toEqual(name);
        expect(options.body['source']).toEqual(source);
        expect(options.body['parameters']).toEqual(parameters);
        expect(options.body['role']).toEqual(role);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const name = 'my-key';
        const source = '25eba2a9-beef-450b-82cf-f5ad5e36c6dd';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          name,
          source,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        resourceController.createResourceKey(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceController.createResourceKey({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const createResourceKeyPromise = resourceController.createResourceKey();
        expectToBePromise(createResourceKeyPromise);

        createResourceKeyPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getResourceKey', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getResourceKey
        const id = 'testString';
        const params = {
          id: id,
        };

        const getResourceKeyResult = resourceController.getResourceKey(params);

        // all methods should return a Promise
        expectToBePromise(getResourceKeyResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/resource_keys/{id}', 'GET');
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

        resourceController.getResourceKey(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceController.getResourceKey({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getResourceKeyPromise = resourceController.getResourceKey();
        expectToBePromise(getResourceKeyPromise);

        getResourceKeyPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deleteResourceKey', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteResourceKey
        const id = 'testString';
        const params = {
          id: id,
        };

        const deleteResourceKeyResult = resourceController.deleteResourceKey(params);

        // all methods should return a Promise
        expectToBePromise(deleteResourceKeyResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/resource_keys/{id}', 'DELETE');
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

        resourceController.deleteResourceKey(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceController.deleteResourceKey({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const deleteResourceKeyPromise = resourceController.deleteResourceKey();
        expectToBePromise(deleteResourceKeyPromise);

        deleteResourceKeyPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('updateResourceKey', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation updateResourceKey
        const id = 'testString';
        const name = 'my-new-key-name';
        const params = {
          id: id,
          name: name,
        };

        const updateResourceKeyResult = resourceController.updateResourceKey(params);

        // all methods should return a Promise
        expectToBePromise(updateResourceKeyResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/resource_keys/{id}', 'PATCH');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['name']).toEqual(name);
        expect(options.path['id']).toEqual(id);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const id = 'testString';
        const name = 'my-new-key-name';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          id,
          name,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        resourceController.updateResourceKey(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceController.updateResourceKey({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const updateResourceKeyPromise = resourceController.updateResourceKey();
        expectToBePromise(updateResourceKeyPromise);

        updateResourceKeyPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('listResourceBindings', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listResourceBindings
        const guid = 'testString';
        const name = 'testString';
        const resourceGroupId = 'testString';
        const resourceId = 'testString';
        const regionBindingId = 'testString';
        const limit = 'testString';
        const updatedFrom = '2019-01-08T00:00:00.000Z';
        const updatedTo = '2019-01-08T00:00:00.000Z';
        const params = {
          guid: guid,
          name: name,
          resourceGroupId: resourceGroupId,
          resourceId: resourceId,
          regionBindingId: regionBindingId,
          limit: limit,
          updatedFrom: updatedFrom,
          updatedTo: updatedTo,
        };

        const listResourceBindingsResult = resourceController.listResourceBindings(params);

        // all methods should return a Promise
        expectToBePromise(listResourceBindingsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/resource_bindings', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['guid']).toEqual(guid);
        expect(options.qs['name']).toEqual(name);
        expect(options.qs['resource_group_id']).toEqual(resourceGroupId);
        expect(options.qs['resource_id']).toEqual(resourceId);
        expect(options.qs['region_binding_id']).toEqual(regionBindingId);
        expect(options.qs['limit']).toEqual(limit);
        expect(options.qs['updated_from']).toEqual(updatedFrom);
        expect(options.qs['updated_to']).toEqual(updatedTo);
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

        resourceController.listResourceBindings(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        resourceController.listResourceBindings({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('createResourceBinding', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // ResourceBindingPostParameters
      const resourceBindingPostParametersModel = {
        serviceid_crn: 'crn:v1:bluemix:public:iam-identity::a/9fceaa56d1ab84893af6b9eec5ab81bb::serviceid:ServiceId-fe4c29b5-db13-410a-bacc-b5779a03d393',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createResourceBinding
        const source = '25eba2a9-beef-450b-82cf-f5ad5e36c6dd';
        const target = 'crn:v1:cf:public:cf:us-south:s/0ba4dba0-a120-4a1e-a124-5a249a904b76::cf-application:a1caa40b-2c24-4da8-8267-ac2c1a42ad0c';
        const name = 'my-binding';
        const parameters = resourceBindingPostParametersModel;
        const role = 'Writer';
        const params = {
          source: source,
          target: target,
          name: name,
          parameters: parameters,
          role: role,
        };

        const createResourceBindingResult = resourceController.createResourceBinding(params);

        // all methods should return a Promise
        expectToBePromise(createResourceBindingResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/resource_bindings', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['source']).toEqual(source);
        expect(options.body['target']).toEqual(target);
        expect(options.body['name']).toEqual(name);
        expect(options.body['parameters']).toEqual(parameters);
        expect(options.body['role']).toEqual(role);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const source = '25eba2a9-beef-450b-82cf-f5ad5e36c6dd';
        const target = 'crn:v1:cf:public:cf:us-south:s/0ba4dba0-a120-4a1e-a124-5a249a904b76::cf-application:a1caa40b-2c24-4da8-8267-ac2c1a42ad0c';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          source,
          target,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        resourceController.createResourceBinding(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceController.createResourceBinding({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const createResourceBindingPromise = resourceController.createResourceBinding();
        expectToBePromise(createResourceBindingPromise);

        createResourceBindingPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getResourceBinding', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getResourceBinding
        const id = 'testString';
        const params = {
          id: id,
        };

        const getResourceBindingResult = resourceController.getResourceBinding(params);

        // all methods should return a Promise
        expectToBePromise(getResourceBindingResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/resource_bindings/{id}', 'GET');
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

        resourceController.getResourceBinding(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceController.getResourceBinding({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getResourceBindingPromise = resourceController.getResourceBinding();
        expectToBePromise(getResourceBindingPromise);

        getResourceBindingPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deleteResourceBinding', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteResourceBinding
        const id = 'testString';
        const params = {
          id: id,
        };

        const deleteResourceBindingResult = resourceController.deleteResourceBinding(params);

        // all methods should return a Promise
        expectToBePromise(deleteResourceBindingResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/resource_bindings/{id}', 'DELETE');
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

        resourceController.deleteResourceBinding(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceController.deleteResourceBinding({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const deleteResourceBindingPromise = resourceController.deleteResourceBinding();
        expectToBePromise(deleteResourceBindingPromise);

        deleteResourceBindingPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('updateResourceBinding', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation updateResourceBinding
        const id = 'testString';
        const name = 'my-new-binding-name';
        const params = {
          id: id,
          name: name,
        };

        const updateResourceBindingResult = resourceController.updateResourceBinding(params);

        // all methods should return a Promise
        expectToBePromise(updateResourceBindingResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/resource_bindings/{id}', 'PATCH');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['name']).toEqual(name);
        expect(options.path['id']).toEqual(id);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const id = 'testString';
        const name = 'my-new-binding-name';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          id,
          name,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        resourceController.updateResourceBinding(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceController.updateResourceBinding({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const updateResourceBindingPromise = resourceController.updateResourceBinding();
        expectToBePromise(updateResourceBindingPromise);

        updateResourceBindingPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('listResourceAliases', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listResourceAliases
        const guid = 'testString';
        const name = 'testString';
        const resourceInstanceId = 'testString';
        const regionInstanceId = 'testString';
        const resourceId = 'testString';
        const resourceGroupId = 'testString';
        const limit = 'testString';
        const updatedFrom = '2019-01-08T00:00:00.000Z';
        const updatedTo = '2019-01-08T00:00:00.000Z';
        const params = {
          guid: guid,
          name: name,
          resourceInstanceId: resourceInstanceId,
          regionInstanceId: regionInstanceId,
          resourceId: resourceId,
          resourceGroupId: resourceGroupId,
          limit: limit,
          updatedFrom: updatedFrom,
          updatedTo: updatedTo,
        };

        const listResourceAliasesResult = resourceController.listResourceAliases(params);

        // all methods should return a Promise
        expectToBePromise(listResourceAliasesResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/resource_aliases', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['guid']).toEqual(guid);
        expect(options.qs['name']).toEqual(name);
        expect(options.qs['resource_instance_id']).toEqual(resourceInstanceId);
        expect(options.qs['region_instance_id']).toEqual(regionInstanceId);
        expect(options.qs['resource_id']).toEqual(resourceId);
        expect(options.qs['resource_group_id']).toEqual(resourceGroupId);
        expect(options.qs['limit']).toEqual(limit);
        expect(options.qs['updated_from']).toEqual(updatedFrom);
        expect(options.qs['updated_to']).toEqual(updatedTo);
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

        resourceController.listResourceAliases(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        resourceController.listResourceAliases({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('createResourceAlias', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createResourceAlias
        const name = 'my-alias';
        const source = 'a8dff6d3-d287-4668-a81d-c87c55c2656d';
        const target = 'crn:v1:cf:public:cf:us-south:o/5e939cd5-6377-4383-b9e0-9db22cd11753::cf-space:66c8b915-101a-406c-a784-e6636676e4f5';
        const params = {
          name: name,
          source: source,
          target: target,
        };

        const createResourceAliasResult = resourceController.createResourceAlias(params);

        // all methods should return a Promise
        expectToBePromise(createResourceAliasResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/resource_aliases', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['name']).toEqual(name);
        expect(options.body['source']).toEqual(source);
        expect(options.body['target']).toEqual(target);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const name = 'my-alias';
        const source = 'a8dff6d3-d287-4668-a81d-c87c55c2656d';
        const target = 'crn:v1:cf:public:cf:us-south:o/5e939cd5-6377-4383-b9e0-9db22cd11753::cf-space:66c8b915-101a-406c-a784-e6636676e4f5';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          name,
          source,
          target,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        resourceController.createResourceAlias(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceController.createResourceAlias({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const createResourceAliasPromise = resourceController.createResourceAlias();
        expectToBePromise(createResourceAliasPromise);

        createResourceAliasPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getResourceAlias', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getResourceAlias
        const id = 'testString';
        const params = {
          id: id,
        };

        const getResourceAliasResult = resourceController.getResourceAlias(params);

        // all methods should return a Promise
        expectToBePromise(getResourceAliasResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/resource_aliases/{id}', 'GET');
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

        resourceController.getResourceAlias(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceController.getResourceAlias({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getResourceAliasPromise = resourceController.getResourceAlias();
        expectToBePromise(getResourceAliasPromise);

        getResourceAliasPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deleteResourceAlias', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteResourceAlias
        const id = 'testString';
        const params = {
          id: id,
        };

        const deleteResourceAliasResult = resourceController.deleteResourceAlias(params);

        // all methods should return a Promise
        expectToBePromise(deleteResourceAliasResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/resource_aliases/{id}', 'DELETE');
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

        resourceController.deleteResourceAlias(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceController.deleteResourceAlias({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const deleteResourceAliasPromise = resourceController.deleteResourceAlias();
        expectToBePromise(deleteResourceAliasPromise);

        deleteResourceAliasPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('updateResourceAlias', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation updateResourceAlias
        const id = 'testString';
        const name = 'my-new-alias-name';
        const params = {
          id: id,
          name: name,
        };

        const updateResourceAliasResult = resourceController.updateResourceAlias(params);

        // all methods should return a Promise
        expectToBePromise(updateResourceAliasResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/resource_aliases/{id}', 'PATCH');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['name']).toEqual(name);
        expect(options.path['id']).toEqual(id);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const id = 'testString';
        const name = 'my-new-alias-name';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          id,
          name,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        resourceController.updateResourceAlias(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceController.updateResourceAlias({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const updateResourceAliasPromise = resourceController.updateResourceAlias();
        expectToBePromise(updateResourceAliasPromise);

        updateResourceAliasPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('listReclamations', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listReclamations
        const accountId = 'testString';
        const resourceInstanceId = 'testString';
        const params = {
          accountId: accountId,
          resourceInstanceId: resourceInstanceId,
        };

        const listReclamationsResult = resourceController.listReclamations(params);

        // all methods should return a Promise
        expectToBePromise(listReclamationsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/reclamations', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['account_id']).toEqual(accountId);
        expect(options.qs['resource_instance_id']).toEqual(resourceInstanceId);
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

        resourceController.listReclamations(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        resourceController.listReclamations({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('runReclamationAction', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation runReclamationAction
        const id = 'testString';
        const actionName = 'testString';
        const requestBy = 'testString';
        const comment = 'testString';
        const params = {
          id: id,
          actionName: actionName,
          requestBy: requestBy,
          comment: comment,
        };

        const runReclamationActionResult = resourceController.runReclamationAction(params);

        // all methods should return a Promise
        expectToBePromise(runReclamationActionResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/reclamations/{id}/actions/{action_name}', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['request_by']).toEqual(requestBy);
        expect(options.body['comment']).toEqual(comment);
        expect(options.path['id']).toEqual(id);
        expect(options.path['action_name']).toEqual(actionName);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const id = 'testString';
        const actionName = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          id,
          actionName,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        resourceController.runReclamationAction(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceController.runReclamationAction({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const runReclamationActionPromise = resourceController.runReclamationAction();
        expectToBePromise(runReclamationActionPromise);

        runReclamationActionPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
});
