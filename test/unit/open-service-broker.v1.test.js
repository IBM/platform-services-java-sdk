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

const OpenServiceBrokerV1 = require('../../dist/open-service-broker/v1');

const {
  getOptions,
  checkUrlAndMethod,
  checkMediaHeaders,
  expectToBePromise,
  checkForSuccessfulExecution,
} = unitTestUtils;

const service = {
  authenticator: new NoAuthAuthenticator(),
  url: 'ibm.com/123456',
};

const openServiceBrokerService = new OpenServiceBrokerV1(service);

// dont actually create a request
const createRequestMock = jest.spyOn(openServiceBrokerService, 'createRequest');
createRequestMock.mockImplementation(() => Promise.resolve());

// dont actually construct an authenticator
const getAuthenticatorMock = jest.spyOn(core, 'getAuthenticatorFromEnvironment');
getAuthenticatorMock.mockImplementation(() => new NoAuthAuthenticator());

afterEach(() => {
  createRequestMock.mockClear();
  getAuthenticatorMock.mockClear();
});

describe('OpenServiceBrokerV1', () => {
  describe('the newInstance method', () => {
    test('should use defaults when options not provided', () => {
      const testInstance = OpenServiceBrokerV1.newInstance();

      expect(getAuthenticatorMock).toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceName).toBe(OpenServiceBrokerV1.DEFAULT_SERVICE_NAME);
      expect(testInstance.baseOptions.serviceUrl).toBe(OpenServiceBrokerV1.DEFAULT_SERVICE_URL);
      expect(testInstance).toBeInstanceOf(OpenServiceBrokerV1);
    });

    test('should set serviceName, serviceUrl, and authenticator when provided', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
        serviceName: 'my-service',
      };

      const testInstance = OpenServiceBrokerV1.newInstance(options);

      expect(getAuthenticatorMock).not.toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
      expect(testInstance.baseOptions.serviceName).toBe('my-service');
      expect(testInstance).toBeInstanceOf(OpenServiceBrokerV1);
    });
  });
  describe('the constructor', () => {
    test('use user-given service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
      };

      const testInstance = new OpenServiceBrokerV1(options);

      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
    });

    test('use default service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
      };

      const testInstance = new OpenServiceBrokerV1(options);

      expect(testInstance.baseOptions.serviceUrl).toBe(OpenServiceBrokerV1.DEFAULT_SERVICE_URL);
    });
  });
  describe('getServiceInstanceState', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getServiceInstanceState
        const instanceId = 'testString';
        const params = {
          instanceId: instanceId,
        };

        const getServiceInstanceStateResult = openServiceBrokerService.getServiceInstanceState(params);

        // all methods should return a Promise
        expectToBePromise(getServiceInstanceStateResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/bluemix_v1/service_instances/{instance_id}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['instance_id']).toEqual(instanceId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const instanceId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          instanceId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        openServiceBrokerService.getServiceInstanceState(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await openServiceBrokerService.getServiceInstanceState({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getServiceInstanceStatePromise = openServiceBrokerService.getServiceInstanceState();
        expectToBePromise(getServiceInstanceStatePromise);

        getServiceInstanceStatePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('replaceServiceInstanceState', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation replaceServiceInstanceState
        const instanceId = 'testString';
        const enabled = false;
        const initiatorId = 'null';
        const reasonCode = 'null';
        const params = {
          instanceId: instanceId,
          enabled: enabled,
          initiatorId: initiatorId,
          reasonCode: reasonCode,
        };

        const replaceServiceInstanceStateResult = openServiceBrokerService.replaceServiceInstanceState(params);

        // all methods should return a Promise
        expectToBePromise(replaceServiceInstanceStateResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/bluemix_v1/service_instances/{instance_id}', 'PUT');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['enabled']).toEqual(enabled);
        expect(options.body['initiator_id']).toEqual(initiatorId);
        expect(options.body['reason_code']).toEqual(reasonCode);
        expect(options.path['instance_id']).toEqual(instanceId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const instanceId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          instanceId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        openServiceBrokerService.replaceServiceInstanceState(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await openServiceBrokerService.replaceServiceInstanceState({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const replaceServiceInstanceStatePromise = openServiceBrokerService.replaceServiceInstanceState();
        expectToBePromise(replaceServiceInstanceStatePromise);

        replaceServiceInstanceStatePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('replaceServiceInstance', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // Context
      const contextModel = {
        account_id: 'null',
        crn: 'null',
        platform: 'null',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation replaceServiceInstance
        const instanceId = 'testString';
        const organizationGuid = 'null';
        const planId = 'null';
        const serviceId = 'null';
        const spaceGuid = 'null';
        const context = contextModel;
        const parameters = { 'key1': 'null' };
        const acceptsIncomplete = true;
        const params = {
          instanceId: instanceId,
          organizationGuid: organizationGuid,
          planId: planId,
          serviceId: serviceId,
          spaceGuid: spaceGuid,
          context: context,
          parameters: parameters,
          acceptsIncomplete: acceptsIncomplete,
        };

        const replaceServiceInstanceResult = openServiceBrokerService.replaceServiceInstance(params);

        // all methods should return a Promise
        expectToBePromise(replaceServiceInstanceResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/service_instances/{instance_id}', 'PUT');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['organization_guid']).toEqual(organizationGuid);
        expect(options.body['plan_id']).toEqual(planId);
        expect(options.body['service_id']).toEqual(serviceId);
        expect(options.body['space_guid']).toEqual(spaceGuid);
        expect(options.body['context']).toEqual(context);
        expect(options.body['parameters']).toEqual(parameters);
        expect(options.qs['accepts_incomplete']).toEqual(acceptsIncomplete);
        expect(options.path['instance_id']).toEqual(instanceId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const instanceId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          instanceId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        openServiceBrokerService.replaceServiceInstance(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await openServiceBrokerService.replaceServiceInstance({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const replaceServiceInstancePromise = openServiceBrokerService.replaceServiceInstance();
        expectToBePromise(replaceServiceInstancePromise);

        replaceServiceInstancePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('updateServiceInstance', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // Context
      const contextModel = {
        account_id: 'null',
        crn: 'null',
        platform: 'null',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation updateServiceInstance
        const instanceId = 'testString';
        const serviceId = 'null';
        const context = contextModel;
        const parameters = { 'key1': 'null' };
        const planId = 'null';
        const previousValues = { 'key1': 'null' };
        const acceptsIncomplete = true;
        const params = {
          instanceId: instanceId,
          serviceId: serviceId,
          context: context,
          parameters: parameters,
          planId: planId,
          previousValues: previousValues,
          acceptsIncomplete: acceptsIncomplete,
        };

        const updateServiceInstanceResult = openServiceBrokerService.updateServiceInstance(params);

        // all methods should return a Promise
        expectToBePromise(updateServiceInstanceResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/service_instances/{instance_id}', 'PATCH');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['service_id']).toEqual(serviceId);
        expect(options.body['context']).toEqual(context);
        expect(options.body['parameters']).toEqual(parameters);
        expect(options.body['plan_id']).toEqual(planId);
        expect(options.body['previous_values']).toEqual(previousValues);
        expect(options.qs['accepts_incomplete']).toEqual(acceptsIncomplete);
        expect(options.path['instance_id']).toEqual(instanceId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const instanceId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          instanceId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        openServiceBrokerService.updateServiceInstance(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await openServiceBrokerService.updateServiceInstance({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const updateServiceInstancePromise = openServiceBrokerService.updateServiceInstance();
        expectToBePromise(updateServiceInstancePromise);

        updateServiceInstancePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deleteServiceInstance', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteServiceInstance
        const serviceId = 'testString';
        const planId = 'testString';
        const instanceId = 'testString';
        const acceptsIncomplete = true;
        const params = {
          serviceId: serviceId,
          planId: planId,
          instanceId: instanceId,
          acceptsIncomplete: acceptsIncomplete,
        };

        const deleteServiceInstanceResult = openServiceBrokerService.deleteServiceInstance(params);

        // all methods should return a Promise
        expectToBePromise(deleteServiceInstanceResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/service_instances/{instance_id}', 'DELETE');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['service_id']).toEqual(serviceId);
        expect(options.qs['plan_id']).toEqual(planId);
        expect(options.qs['accepts_incomplete']).toEqual(acceptsIncomplete);
        expect(options.path['instance_id']).toEqual(instanceId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const serviceId = 'testString';
        const planId = 'testString';
        const instanceId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          serviceId,
          planId,
          instanceId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        openServiceBrokerService.deleteServiceInstance(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await openServiceBrokerService.deleteServiceInstance({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const deleteServiceInstancePromise = openServiceBrokerService.deleteServiceInstance();
        expectToBePromise(deleteServiceInstancePromise);

        deleteServiceInstancePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('listCatalog', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listCatalog
        const params = {};

        const listCatalogResult = openServiceBrokerService.listCatalog(params);

        // all methods should return a Promise
        expectToBePromise(listCatalogResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/catalog', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
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

        openServiceBrokerService.listCatalog(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        openServiceBrokerService.listCatalog({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('getLastOperation', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getLastOperation
        const instanceId = 'testString';
        const operation = 'testString';
        const planId = 'testString';
        const serviceId = 'testString';
        const params = {
          instanceId: instanceId,
          operation: operation,
          planId: planId,
          serviceId: serviceId,
        };

        const getLastOperationResult = openServiceBrokerService.getLastOperation(params);

        // all methods should return a Promise
        expectToBePromise(getLastOperationResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/service_instances/{instance_id}/last_operation', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['operation']).toEqual(operation);
        expect(options.qs['plan_id']).toEqual(planId);
        expect(options.qs['service_id']).toEqual(serviceId);
        expect(options.path['instance_id']).toEqual(instanceId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const instanceId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          instanceId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        openServiceBrokerService.getLastOperation(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await openServiceBrokerService.getLastOperation({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getLastOperationPromise = openServiceBrokerService.getLastOperation();
        expectToBePromise(getLastOperationPromise);

        getLastOperationPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('replaceServiceBinding', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // BindResource
      const bindResourceModel = {
        account_id: 'null',
        serviceid_crn: 'null',
        target_crn: 'null',
        app_guid: 'null',
        route: 'null',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation replaceServiceBinding
        const bindingId = 'testString';
        const instanceId = 'testString';
        const planId = 'null';
        const serviceId = 'null';
        const bindResource = bindResourceModel;
        const parameters = { 'key1': 'null' };
        const params = {
          bindingId: bindingId,
          instanceId: instanceId,
          planId: planId,
          serviceId: serviceId,
          bindResource: bindResource,
          parameters: parameters,
        };

        const replaceServiceBindingResult = openServiceBrokerService.replaceServiceBinding(params);

        // all methods should return a Promise
        expectToBePromise(replaceServiceBindingResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/service_instances/{instance_id}/service_bindings/{binding_id}', 'PUT');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['plan_id']).toEqual(planId);
        expect(options.body['service_id']).toEqual(serviceId);
        expect(options.body['bind_resource']).toEqual(bindResource);
        expect(options.body['parameters']).toEqual(parameters);
        expect(options.path['binding_id']).toEqual(bindingId);
        expect(options.path['instance_id']).toEqual(instanceId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const bindingId = 'testString';
        const instanceId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          bindingId,
          instanceId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        openServiceBrokerService.replaceServiceBinding(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await openServiceBrokerService.replaceServiceBinding({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const replaceServiceBindingPromise = openServiceBrokerService.replaceServiceBinding();
        expectToBePromise(replaceServiceBindingPromise);

        replaceServiceBindingPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deleteServiceBinding', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteServiceBinding
        const bindingId = 'testString';
        const instanceId = 'testString';
        const planId = 'testString';
        const serviceId = 'testString';
        const params = {
          bindingId: bindingId,
          instanceId: instanceId,
          planId: planId,
          serviceId: serviceId,
        };

        const deleteServiceBindingResult = openServiceBrokerService.deleteServiceBinding(params);

        // all methods should return a Promise
        expectToBePromise(deleteServiceBindingResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/service_instances/{instance_id}/service_bindings/{binding_id}', 'DELETE');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['plan_id']).toEqual(planId);
        expect(options.qs['service_id']).toEqual(serviceId);
        expect(options.path['binding_id']).toEqual(bindingId);
        expect(options.path['instance_id']).toEqual(instanceId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const bindingId = 'testString';
        const instanceId = 'testString';
        const planId = 'testString';
        const serviceId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          bindingId,
          instanceId,
          planId,
          serviceId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        openServiceBrokerService.deleteServiceBinding(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await openServiceBrokerService.deleteServiceBinding({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const deleteServiceBindingPromise = openServiceBrokerService.deleteServiceBinding();
        expectToBePromise(deleteServiceBindingPromise);

        deleteServiceBindingPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
});
