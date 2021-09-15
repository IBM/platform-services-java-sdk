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

const ContextBasedRestrictionsV1 = require('../../dist/context-based-restrictions/v1');

const {
  getOptions,
  checkUrlAndMethod,
  checkMediaHeaders,
  expectToBePromise,
  checkUserHeader,
  checkForSuccessfulExecution,
} = unitTestUtils;

const contextBasedRestrictionsServiceOptions = {
  authenticator: new NoAuthAuthenticator(),
  url: 'https://context-based-restrictions.cloud.ibm.com',
};

const contextBasedRestrictionsService = new ContextBasedRestrictionsV1(contextBasedRestrictionsServiceOptions);

// dont actually create a request
const createRequestMock = jest.spyOn(contextBasedRestrictionsService, 'createRequest');
createRequestMock.mockImplementation(() => Promise.resolve());

// dont actually construct an authenticator
const getAuthenticatorMock = jest.spyOn(core, 'getAuthenticatorFromEnvironment');
getAuthenticatorMock.mockImplementation(() => new NoAuthAuthenticator());

afterEach(() => {
  createRequestMock.mockClear();
  getAuthenticatorMock.mockClear();
});

describe('ContextBasedRestrictionsV1', () => {
  describe('the newInstance method', () => {
    test('should use defaults when options not provided', () => {
      const testInstance = ContextBasedRestrictionsV1.newInstance();

      expect(getAuthenticatorMock).toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceName).toBe(ContextBasedRestrictionsV1.DEFAULT_SERVICE_NAME);
      expect(testInstance.baseOptions.serviceUrl).toBe(ContextBasedRestrictionsV1.DEFAULT_SERVICE_URL);
      expect(testInstance).toBeInstanceOf(ContextBasedRestrictionsV1);
    });

    test('should set serviceName, serviceUrl, and authenticator when provided', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
        serviceName: 'my-service',
      };

      const testInstance = ContextBasedRestrictionsV1.newInstance(options);

      expect(getAuthenticatorMock).not.toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
      expect(testInstance.baseOptions.serviceName).toBe('my-service');
      expect(testInstance).toBeInstanceOf(ContextBasedRestrictionsV1);
    });
  });
  describe('the constructor', () => {
    test('use user-given service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
      };

      const testInstance = new ContextBasedRestrictionsV1(options);

      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
    });

    test('use default service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
      };

      const testInstance = new ContextBasedRestrictionsV1(options);

      expect(testInstance.baseOptions.serviceUrl).toBe(ContextBasedRestrictionsV1.DEFAULT_SERVICE_URL);
    });
  });
  describe('createZone', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // AddressIPAddress
      const addressModel = {
        type: 'ipAddress',
        value: '169.23.56.234',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createZone
        const name = 'an example of zone';
        const accountId = '12ab34cd56ef78ab90cd12ef34ab56cd';
        const addresses = [addressModel];
        const description = 'this is an example of zone';
        const excluded = [addressModel];
        const transactionId = 'testString';
        const params = {
          name: name,
          accountId: accountId,
          addresses: addresses,
          description: description,
          excluded: excluded,
          transactionId: transactionId,
        };

        const createZoneResult = contextBasedRestrictionsService.createZone(params);

        // all methods should return a Promise
        expectToBePromise(createZoneResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/zones', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
        expect(options.body['name']).toEqual(name);
        expect(options.body['account_id']).toEqual(accountId);
        expect(options.body['addresses']).toEqual(addresses);
        expect(options.body['description']).toEqual(description);
        expect(options.body['excluded']).toEqual(excluded);
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

        contextBasedRestrictionsService.createZone(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        contextBasedRestrictionsService.createZone({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('listZones', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listZones
        const accountId = 'testString';
        const transactionId = 'testString';
        const name = 'testString';
        const sort = 'testString';
        const params = {
          accountId: accountId,
          transactionId: transactionId,
          name: name,
          sort: sort,
        };

        const listZonesResult = contextBasedRestrictionsService.listZones(params);

        // all methods should return a Promise
        expectToBePromise(listZonesResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/zones', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
        expect(options.qs['account_id']).toEqual(accountId);
        expect(options.qs['name']).toEqual(name);
        expect(options.qs['sort']).toEqual(sort);
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

        contextBasedRestrictionsService.listZones(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await contextBasedRestrictionsService.listZones({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const listZonesPromise = contextBasedRestrictionsService.listZones();
        expectToBePromise(listZonesPromise);

        listZonesPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getZone', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getZone
        const zoneId = 'testString';
        const transactionId = 'testString';
        const params = {
          zoneId: zoneId,
          transactionId: transactionId,
        };

        const getZoneResult = contextBasedRestrictionsService.getZone(params);

        // all methods should return a Promise
        expectToBePromise(getZoneResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/zones/{zone_id}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
        expect(options.path['zone_id']).toEqual(zoneId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const zoneId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          zoneId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        contextBasedRestrictionsService.getZone(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await contextBasedRestrictionsService.getZone({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getZonePromise = contextBasedRestrictionsService.getZone();
        expectToBePromise(getZonePromise);

        getZonePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('replaceZone', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // AddressIPAddress
      const addressModel = {
        type: 'ipAddress',
        value: '169.23.56.234',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation replaceZone
        const zoneId = 'testString';
        const ifMatch = 'testString';
        const name = 'an example of zone';
        const accountId = '12ab34cd56ef78ab90cd12ef34ab56cd';
        const addresses = [addressModel];
        const description = 'this is an example of zone';
        const excluded = [addressModel];
        const transactionId = 'testString';
        const params = {
          zoneId: zoneId,
          ifMatch: ifMatch,
          name: name,
          accountId: accountId,
          addresses: addresses,
          description: description,
          excluded: excluded,
          transactionId: transactionId,
        };

        const replaceZoneResult = contextBasedRestrictionsService.replaceZone(params);

        // all methods should return a Promise
        expectToBePromise(replaceZoneResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/zones/{zone_id}', 'PUT');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'If-Match', ifMatch);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
        expect(options.body['name']).toEqual(name);
        expect(options.body['account_id']).toEqual(accountId);
        expect(options.body['addresses']).toEqual(addresses);
        expect(options.body['description']).toEqual(description);
        expect(options.body['excluded']).toEqual(excluded);
        expect(options.path['zone_id']).toEqual(zoneId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const zoneId = 'testString';
        const ifMatch = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          zoneId,
          ifMatch,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        contextBasedRestrictionsService.replaceZone(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await contextBasedRestrictionsService.replaceZone({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const replaceZonePromise = contextBasedRestrictionsService.replaceZone();
        expectToBePromise(replaceZonePromise);

        replaceZonePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deleteZone', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteZone
        const zoneId = 'testString';
        const transactionId = 'testString';
        const params = {
          zoneId: zoneId,
          transactionId: transactionId,
        };

        const deleteZoneResult = contextBasedRestrictionsService.deleteZone(params);

        // all methods should return a Promise
        expectToBePromise(deleteZoneResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/zones/{zone_id}', 'DELETE');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
        expect(options.path['zone_id']).toEqual(zoneId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const zoneId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          zoneId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        contextBasedRestrictionsService.deleteZone(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await contextBasedRestrictionsService.deleteZone({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const deleteZonePromise = contextBasedRestrictionsService.deleteZone();
        expectToBePromise(deleteZonePromise);

        deleteZonePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('listAvailableServicerefTargets', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listAvailableServicerefTargets
        const type = 'all';
        const params = {
          type: type,
        };

        const listAvailableServicerefTargetsResult = contextBasedRestrictionsService.listAvailableServicerefTargets(params);

        // all methods should return a Promise
        expectToBePromise(listAvailableServicerefTargetsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/zones/serviceref_targets', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['type']).toEqual(type);
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

        contextBasedRestrictionsService.listAvailableServicerefTargets(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        contextBasedRestrictionsService.listAvailableServicerefTargets({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('createRule', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // RuleContextAttribute
      const ruleContextAttributeModel = {
        name: 'networkZoneId',
        value: '65810ac762004f22ac19f8f8edf70a34',
      };

      // RuleContext
      const ruleContextModel = {
        attributes: [ruleContextAttributeModel],
      };

      // ResourceAttribute
      const resourceAttributeModel = {
        name: 'accountId',
        value: '12ab34cd56ef78ab90cd12ef34ab56cd',
        operator: 'testString',
      };

      // ResourceTagAttribute
      const resourceTagAttributeModel = {
        name: 'testString',
        value: 'testString',
        operator: 'testString',
      };

      // Resource
      const resourceModel = {
        attributes: [resourceAttributeModel],
        tags: [resourceTagAttributeModel],
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createRule
        const contexts = [ruleContextModel];
        const resources = [resourceModel];
        const description = 'this is an example of rule';
        const transactionId = 'testString';
        const params = {
          contexts: contexts,
          resources: resources,
          description: description,
          transactionId: transactionId,
        };

        const createRuleResult = contextBasedRestrictionsService.createRule(params);

        // all methods should return a Promise
        expectToBePromise(createRuleResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/rules', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
        expect(options.body['contexts']).toEqual(contexts);
        expect(options.body['resources']).toEqual(resources);
        expect(options.body['description']).toEqual(description);
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

        contextBasedRestrictionsService.createRule(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        contextBasedRestrictionsService.createRule({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('listRules', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listRules
        const accountId = 'testString';
        const transactionId = 'testString';
        const region = 'testString';
        const resource = 'testString';
        const resourceType = 'testString';
        const serviceInstance = 'testString';
        const serviceName = 'testString';
        const serviceType = 'testString';
        const zoneId = 'testString';
        const sort = 'testString';
        const params = {
          accountId: accountId,
          transactionId: transactionId,
          region: region,
          resource: resource,
          resourceType: resourceType,
          serviceInstance: serviceInstance,
          serviceName: serviceName,
          serviceType: serviceType,
          zoneId: zoneId,
          sort: sort,
        };

        const listRulesResult = contextBasedRestrictionsService.listRules(params);

        // all methods should return a Promise
        expectToBePromise(listRulesResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/rules', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
        expect(options.qs['account_id']).toEqual(accountId);
        expect(options.qs['region']).toEqual(region);
        expect(options.qs['resource']).toEqual(resource);
        expect(options.qs['resource_type']).toEqual(resourceType);
        expect(options.qs['service_instance']).toEqual(serviceInstance);
        expect(options.qs['service_name']).toEqual(serviceName);
        expect(options.qs['service_type']).toEqual(serviceType);
        expect(options.qs['zone_id']).toEqual(zoneId);
        expect(options.qs['sort']).toEqual(sort);
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

        contextBasedRestrictionsService.listRules(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await contextBasedRestrictionsService.listRules({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const listRulesPromise = contextBasedRestrictionsService.listRules();
        expectToBePromise(listRulesPromise);

        listRulesPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getRule', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getRule
        const ruleId = 'testString';
        const transactionId = 'testString';
        const params = {
          ruleId: ruleId,
          transactionId: transactionId,
        };

        const getRuleResult = contextBasedRestrictionsService.getRule(params);

        // all methods should return a Promise
        expectToBePromise(getRuleResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/rules/{rule_id}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
        expect(options.path['rule_id']).toEqual(ruleId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const ruleId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          ruleId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        contextBasedRestrictionsService.getRule(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await contextBasedRestrictionsService.getRule({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getRulePromise = contextBasedRestrictionsService.getRule();
        expectToBePromise(getRulePromise);

        getRulePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('replaceRule', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // RuleContextAttribute
      const ruleContextAttributeModel = {
        name: 'networkZoneId',
        value: '76921bd873115033bd2a0909fe081b45',
      };

      // RuleContext
      const ruleContextModel = {
        attributes: [ruleContextAttributeModel],
      };

      // ResourceAttribute
      const resourceAttributeModel = {
        name: 'accountId',
        value: '12ab34cd56ef78ab90cd12ef34ab56cd',
        operator: 'testString',
      };

      // ResourceTagAttribute
      const resourceTagAttributeModel = {
        name: 'testString',
        value: 'testString',
        operator: 'testString',
      };

      // Resource
      const resourceModel = {
        attributes: [resourceAttributeModel],
        tags: [resourceTagAttributeModel],
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation replaceRule
        const ruleId = 'testString';
        const ifMatch = 'testString';
        const contexts = [ruleContextModel];
        const resources = [resourceModel];
        const description = 'this is an example of rule';
        const transactionId = 'testString';
        const params = {
          ruleId: ruleId,
          ifMatch: ifMatch,
          contexts: contexts,
          resources: resources,
          description: description,
          transactionId: transactionId,
        };

        const replaceRuleResult = contextBasedRestrictionsService.replaceRule(params);

        // all methods should return a Promise
        expectToBePromise(replaceRuleResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/rules/{rule_id}', 'PUT');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'If-Match', ifMatch);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
        expect(options.body['contexts']).toEqual(contexts);
        expect(options.body['resources']).toEqual(resources);
        expect(options.body['description']).toEqual(description);
        expect(options.path['rule_id']).toEqual(ruleId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const ruleId = 'testString';
        const ifMatch = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          ruleId,
          ifMatch,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        contextBasedRestrictionsService.replaceRule(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await contextBasedRestrictionsService.replaceRule({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const replaceRulePromise = contextBasedRestrictionsService.replaceRule();
        expectToBePromise(replaceRulePromise);

        replaceRulePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deleteRule', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteRule
        const ruleId = 'testString';
        const transactionId = 'testString';
        const params = {
          ruleId: ruleId,
          transactionId: transactionId,
        };

        const deleteRuleResult = contextBasedRestrictionsService.deleteRule(params);

        // all methods should return a Promise
        expectToBePromise(deleteRuleResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/rules/{rule_id}', 'DELETE');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
        expect(options.path['rule_id']).toEqual(ruleId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const ruleId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          ruleId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        contextBasedRestrictionsService.deleteRule(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await contextBasedRestrictionsService.deleteRule({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const deleteRulePromise = contextBasedRestrictionsService.deleteRule();
        expectToBePromise(deleteRulePromise);

        deleteRulePromise.catch(err => {
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
        const transactionId = 'testString';
        const params = {
          accountId: accountId,
          transactionId: transactionId,
        };

        const getAccountSettingsResult = contextBasedRestrictionsService.getAccountSettings(params);

        // all methods should return a Promise
        expectToBePromise(getAccountSettingsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/account_settings/{account_id}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
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

        contextBasedRestrictionsService.getAccountSettings(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await contextBasedRestrictionsService.getAccountSettings({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getAccountSettingsPromise = contextBasedRestrictionsService.getAccountSettings();
        expectToBePromise(getAccountSettingsPromise);

        getAccountSettingsPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
});
