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

const resourceControllerService = new ResourceControllerV2(service);

// dont actually create a request
const createRequestMock = jest.spyOn(resourceControllerService, 'createRequest');
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
        const state = 'active';
        const orderDirection = 'asc';
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
          state: state,
          orderDirection: orderDirection,
          updatedFrom: updatedFrom,
          updatedTo: updatedTo,
        };

        const listResourceInstancesResult = resourceControllerService.listResourceInstances(params);

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
        expect(options.qs['state']).toEqual(state);
        expect(options.qs['order_direction']).toEqual(orderDirection);
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

        resourceControllerService.listResourceInstances(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        resourceControllerService.listResourceInstances({});
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
        const parameters = { 'key1': 'testString' };
        const entityLock = true;
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

        const createResourceInstanceResult = resourceControllerService.createResourceInstance(params);

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

        resourceControllerService.createResourceInstance(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceControllerService.createResourceInstance({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const createResourceInstancePromise = resourceControllerService.createResourceInstance();
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

        const getResourceInstanceResult = resourceControllerService.getResourceInstance(params);

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

        resourceControllerService.getResourceInstance(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceControllerService.getResourceInstance({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getResourceInstancePromise = resourceControllerService.getResourceInstance();
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
        const recursive = true;
        const params = {
          id: id,
          recursive: recursive,
        };

        const deleteResourceInstanceResult = resourceControllerService.deleteResourceInstance(params);

        // all methods should return a Promise
        expectToBePromise(deleteResourceInstanceResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/resource_instances/{id}', 'DELETE');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['recursive']).toEqual(recursive);
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

        resourceControllerService.deleteResourceInstance(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceControllerService.deleteResourceInstance({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const deleteResourceInstancePromise = resourceControllerService.deleteResourceInstance();
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
        const parameters = { 'key1': 'testString' };
        const resourcePlanId = 'a8dff6d3-d287-4668-a81d-c87c55c2656d';
        const allowCleanup = true;
        const params = {
          id: id,
          name: name,
          parameters: parameters,
          resourcePlanId: resourcePlanId,
          allowCleanup: allowCleanup,
        };

        const updateResourceInstanceResult = resourceControllerService.updateResourceInstance(params);

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

        resourceControllerService.updateResourceInstance(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceControllerService.updateResourceInstance({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const updateResourceInstancePromise = resourceControllerService.updateResourceInstance();
        expectToBePromise(updateResourceInstancePromise);

        updateResourceInstancePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('listResourceAliasesForInstance', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listResourceAliasesForInstance
        const id = 'testString';
        const params = {
          id: id,
        };

        const listResourceAliasesForInstanceResult = resourceControllerService.listResourceAliasesForInstance(params);

        // all methods should return a Promise
        expectToBePromise(listResourceAliasesForInstanceResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/resource_instances/{id}/resource_aliases', 'GET');
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

        resourceControllerService.listResourceAliasesForInstance(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceControllerService.listResourceAliasesForInstance({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const listResourceAliasesForInstancePromise = resourceControllerService.listResourceAliasesForInstance();
        expectToBePromise(listResourceAliasesForInstancePromise);

        listResourceAliasesForInstancePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('listResourceKeysForInstance', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listResourceKeysForInstance
        const id = 'testString';
        const params = {
          id: id,
        };

        const listResourceKeysForInstanceResult = resourceControllerService.listResourceKeysForInstance(params);

        // all methods should return a Promise
        expectToBePromise(listResourceKeysForInstanceResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/resource_instances/{id}/resource_keys', 'GET');
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

        resourceControllerService.listResourceKeysForInstance(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceControllerService.listResourceKeysForInstance({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const listResourceKeysForInstancePromise = resourceControllerService.listResourceKeysForInstance();
        expectToBePromise(listResourceKeysForInstancePromise);

        listResourceKeysForInstancePromise.catch(err => {
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

        const lockResourceInstanceResult = resourceControllerService.lockResourceInstance(params);

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

        resourceControllerService.lockResourceInstance(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceControllerService.lockResourceInstance({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const lockResourceInstancePromise = resourceControllerService.lockResourceInstance();
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

        const unlockResourceInstanceResult = resourceControllerService.unlockResourceInstance(params);

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

        resourceControllerService.unlockResourceInstance(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceControllerService.unlockResourceInstance({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const unlockResourceInstancePromise = resourceControllerService.unlockResourceInstance();
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

        const listResourceKeysResult = resourceControllerService.listResourceKeys(params);

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

        resourceControllerService.listResourceKeys(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        resourceControllerService.listResourceKeys({});
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
        foo: 'testString',
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

        const createResourceKeyResult = resourceControllerService.createResourceKey(params);

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

        resourceControllerService.createResourceKey(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceControllerService.createResourceKey({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const createResourceKeyPromise = resourceControllerService.createResourceKey();
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

        const getResourceKeyResult = resourceControllerService.getResourceKey(params);

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

        resourceControllerService.getResourceKey(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceControllerService.getResourceKey({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getResourceKeyPromise = resourceControllerService.getResourceKey();
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

        const deleteResourceKeyResult = resourceControllerService.deleteResourceKey(params);

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

        resourceControllerService.deleteResourceKey(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceControllerService.deleteResourceKey({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const deleteResourceKeyPromise = resourceControllerService.deleteResourceKey();
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

        const updateResourceKeyResult = resourceControllerService.updateResourceKey(params);

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

        resourceControllerService.updateResourceKey(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceControllerService.updateResourceKey({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const updateResourceKeyPromise = resourceControllerService.updateResourceKey();
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

        const listResourceBindingsResult = resourceControllerService.listResourceBindings(params);

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

        resourceControllerService.listResourceBindings(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        resourceControllerService.listResourceBindings({});
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
        foo: 'testString',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createResourceBinding
        const source = '25eba2a9-beef-450b-82cf-f5ad5e36c6dd';
        const target = 'crn:v1:bluemix:public:cf:us-south:s/0ba4dba0-a120-4a1e-a124-5a249a904b76::cf-application:a1caa40b-2c24-4da8-8267-ac2c1a42ad0c';
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

        const createResourceBindingResult = resourceControllerService.createResourceBinding(params);

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
        const target = 'crn:v1:bluemix:public:cf:us-south:s/0ba4dba0-a120-4a1e-a124-5a249a904b76::cf-application:a1caa40b-2c24-4da8-8267-ac2c1a42ad0c';
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

        resourceControllerService.createResourceBinding(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceControllerService.createResourceBinding({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const createResourceBindingPromise = resourceControllerService.createResourceBinding();
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

        const getResourceBindingResult = resourceControllerService.getResourceBinding(params);

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

        resourceControllerService.getResourceBinding(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceControllerService.getResourceBinding({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getResourceBindingPromise = resourceControllerService.getResourceBinding();
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

        const deleteResourceBindingResult = resourceControllerService.deleteResourceBinding(params);

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

        resourceControllerService.deleteResourceBinding(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceControllerService.deleteResourceBinding({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const deleteResourceBindingPromise = resourceControllerService.deleteResourceBinding();
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

        const updateResourceBindingResult = resourceControllerService.updateResourceBinding(params);

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

        resourceControllerService.updateResourceBinding(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceControllerService.updateResourceBinding({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const updateResourceBindingPromise = resourceControllerService.updateResourceBinding();
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

        const listResourceAliasesResult = resourceControllerService.listResourceAliases(params);

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

        resourceControllerService.listResourceAliases(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        resourceControllerService.listResourceAliases({});
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
        const target = 'crn:v1:bluemix:public:cf:us-south:o/5e939cd5-6377-4383-b9e0-9db22cd11753::cf-space:66c8b915-101a-406c-a784-e6636676e4f5';
        const params = {
          name: name,
          source: source,
          target: target,
        };

        const createResourceAliasResult = resourceControllerService.createResourceAlias(params);

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
        const target = 'crn:v1:bluemix:public:cf:us-south:o/5e939cd5-6377-4383-b9e0-9db22cd11753::cf-space:66c8b915-101a-406c-a784-e6636676e4f5';
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

        resourceControllerService.createResourceAlias(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceControllerService.createResourceAlias({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const createResourceAliasPromise = resourceControllerService.createResourceAlias();
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

        const getResourceAliasResult = resourceControllerService.getResourceAlias(params);

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

        resourceControllerService.getResourceAlias(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceControllerService.getResourceAlias({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getResourceAliasPromise = resourceControllerService.getResourceAlias();
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

        const deleteResourceAliasResult = resourceControllerService.deleteResourceAlias(params);

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

        resourceControllerService.deleteResourceAlias(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceControllerService.deleteResourceAlias({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const deleteResourceAliasPromise = resourceControllerService.deleteResourceAlias();
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

        const updateResourceAliasResult = resourceControllerService.updateResourceAlias(params);

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

        resourceControllerService.updateResourceAlias(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceControllerService.updateResourceAlias({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const updateResourceAliasPromise = resourceControllerService.updateResourceAlias();
        expectToBePromise(updateResourceAliasPromise);

        updateResourceAliasPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('listResourceBindingsForAlias', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listResourceBindingsForAlias
        const id = 'testString';
        const params = {
          id: id,
        };

        const listResourceBindingsForAliasResult = resourceControllerService.listResourceBindingsForAlias(params);

        // all methods should return a Promise
        expectToBePromise(listResourceBindingsForAliasResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/resource_aliases/{id}/resource_bindings', 'GET');
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

        resourceControllerService.listResourceBindingsForAlias(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceControllerService.listResourceBindingsForAlias({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const listResourceBindingsForAliasPromise = resourceControllerService.listResourceBindingsForAlias();
        expectToBePromise(listResourceBindingsForAliasPromise);

        listResourceBindingsForAliasPromise.catch(err => {
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

        const listReclamationsResult = resourceControllerService.listReclamations(params);

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

        resourceControllerService.listReclamations(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        resourceControllerService.listReclamations({});
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

        const runReclamationActionResult = resourceControllerService.runReclamationAction(params);

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

        resourceControllerService.runReclamationAction(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await resourceControllerService.runReclamationAction({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const runReclamationActionPromise = resourceControllerService.runReclamationAction();
        expectToBePromise(runReclamationActionPromise);

        runReclamationActionPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
});
