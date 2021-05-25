/* eslint-disable no-console */
/**
 * (C) Copyright IBM Corp. 2020.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

const { v4: uuidv4 } = require('uuid');
const OpenServiceBrokerV1 = require('../../dist/open-service-broker/v1');
const authHelper = require('../resources/auth-helper.js');

// testcase timeout value (40s).
const timeout = 60000;

// Location of our config file.
const configFile = 'open_service_broker.env';

// Use authHelper to skip tests if our configFile is not available.
const describe = authHelper.prepareTests(configFile);

const testAccountId = 'bc2b2fca0af84354a916dc1de6eee42e';
const testOrgGuid = 'd35d4f0e-5076-4c89-9361-2522894b6548';
const testSpaceGuid = '336ba5f3-f185-488e-ac8d-02195eebb2f3';
const testAppGuid = 'bf692181-1f0e-46be-9faf-eb0857f4d1d5';
const testPlanId1 = 'a10e4820-3685-11e9-b210-d663bd873d93';
const testPlanId3 = 'a10e4960-3685-11e9-b210-d663bd873d93';
const testInstanceId =
  'crn:v1:staging:public:bss-monitor:global:a/bc2b2fca0af84354a916dc1de6eee42e:sdkTestInstance::';
const testInstanceId2 =
  'crn:v1:staging:public:bss-monitor:us-south:a/bc2b2fca0af84354a916dc1de6eee42e:osb-sdk-test00:resource-binding:osb-sdk-binding-test00';
const testBindingId2 =
  'crnL:v1:staging:public:bss-monitor:global:a/bc2b2fca0af84354a916dc1de6eee42e:osb-sdk-test00::';

const testPlatform = 'ibmcloud';
const testReasonCode = 'test_reason';
const testInitiatorId = 'test_initiator';
const transactionId = uuidv4();
const testServiceId = 'a10e46ae-3685-11e9-b210-d663bd873d93';

let service;

describe('OpenServiceBrokerV1_integration', () => {
  jest.setTimeout(timeout);

  test('should successfully complete initialization', (done) => {
    // Initialize the service client.
    service = OpenServiceBrokerV1.newInstance();
    expect(service).not.toBeNull();

    console.log('Transaction-Id for Test Run:', transactionId);
    done();
  });

  test('00 - Create A Service Instance', async (done) => {
    const customHeader = {
      'Transaction-Id': `osb-sdk-node-test00-${transactionId}`,
    };

    const testContext = {
      account_id: testAccountId,
      crn: testInstanceId,
      platform: testPlatform,
    };

    const testPars = { hello: 'bye' };

    const params = {
      instanceId: testInstanceId,
      organizationGuid: testOrgGuid,
      planId: testPlanId1,
      serviceId: testServiceId,
      spaceGuid: testSpaceGuid,
      context: testContext,
      parameters: testPars,
      acceptsIncomplete: true,
      headers: customHeader,
    };

    let response;
    try {
      response = await service.replaceServiceInstance(params);
    } catch (err) {
      done(err);
    }

    expect(response).toBeDefined();
    expect(response.status).toEqual(201);
    expect(response.result).toBeDefined();

    const { result } = response;
    expect(result.dashboard_url).toBeDefined();

    done();
  });

  test('01 - Update Service Instance', async (done) => {
    const customHeader = {
      'Transaction-Id': `osb-sdk-node-test01-${transactionId}`,
    };

    const testContext = {
      account_id: testAccountId,
      crn: testInstanceId,
      platform: testPlatform,
    };

    const testPars = { hello: 'bye' };
    const testPrevValues = { hello: 'bye' };

    const params = {
      instanceId: testInstanceId,
      serviceId: testServiceId,
      context: testContext,
      parameters: testPars,
      planId: testPlanId1,
      previousValues: testPrevValues,
      acceptsIncomplete: true,
      headers: customHeader,
    };

    let response;
    try {
      response = await service.updateServiceInstance(params);
    } catch (err) {
      done(err);
    }

    expect(response).toBeDefined();
    expect(response.status).toEqual(200);
    expect(response.result).toBeDefined();

    const { result } = response;
    expect(result.service_instance_id).toEqual(testInstanceId);
    expect(result.plan_id).toEqual(testPlanId1);

    done();
  });

  test('02 - Disable Service Instance State', async (done) => {
    const customHeader = {
      'Transaction-Id': `osb-sdk-node-test02-${transactionId}`,
    };

    const params = {
      instanceId: testInstanceId,
      enabled: false,
      initiatorId: testInitiatorId,
      reasonCode: testReasonCode,
      headers: customHeader,
    };

    let response;
    try {
      response = await service.replaceServiceInstanceState(params);
    } catch (err) {
      done(err);
    }

    expect(response).toBeDefined();
    expect(response.status).toEqual(200);
    expect(response.result).toBeDefined();

    const { result } = response;
    expect(result.active).toBeDefined();
    expect(result.enabled).toBeDefined();

    done();
  });

  test('03 - Enable Service Instance State', async (done) => {
    const customHeader = {
      'Transaction-Id': `osb-sdk-node-test03-${transactionId}`,
    };

    const params = {
      instanceId: testInstanceId,
      enabled: true,
      initiatorId: testInitiatorId,
      reasonCode: testReasonCode,
      headers: customHeader,
    };

    let response;
    try {
      response = await service.replaceServiceInstanceState(params);
    } catch (err) {
      done(err);
    }

    expect(response).toBeDefined();
    expect(response.status).toEqual(200);
    expect(response.result).toBeDefined();

    const { result } = response;
    expect(result.active).toBeDefined();
    expect(result.enabled).toBeDefined();

    done();
  });

  test('04 - Bind Service Instance', async (done) => {
    const customHeader = {
      'Transaction-Id': `osb-sdk-node-test04-${transactionId}`,
    };
    const testParams = { hello: 'bye' };
    const testBindResource = {
      account_id: testAccountId,
      serviceid_crn: testAppGuid,
    };

    const params = {
      bindingId: testBindingId2,
      instanceId: testInstanceId2,
      planId: testPlanId3,
      serviceId: testServiceId,
      bindResource: testBindResource,
      parameters: testParams,
      headers: customHeader,
    };

    let response;
    try {
      response = await service.replaceServiceBinding(params);
    } catch (err) {
      done(err);
    }

    expect(response).toBeDefined();
    expect(response.status).toEqual(201);
    expect(response.result).toBeDefined();

    const { result } = response;
    expect(result.credentials).toBeDefined();
    done();
  });

  test('05 - Get Service Instance State', async (done) => {
    const customHeader = {
      'Transaction-Id': `osb-sdk-node-test05-${transactionId}`,
    };

    const params = {
      instanceId: testInstanceId,
      headers: customHeader,
    };

    let response;
    try {
      response = await service.getServiceInstanceState(params);
    } catch (err) {
      done(err);
    }

    expect(response).toBeDefined();
    expect(response.status).toEqual(200);
    expect(response.result).toBeDefined();

    const { result } = response;
    console.log(`Result-defined!: ${JSON.stringify(result)}`);
    expect(result.active).toBeDefined();
    expect(result.enabled).toBeDefined();
    done();
  });

  test('06 - Get Catalog Metadata', async (done) => {
    const customHeader = {
      'Transaction-Id': `osb-sdk-node-test06-${transactionId}`,
    };

    const params = {
      headers: customHeader,
    };

    let response;
    try {
      response = await service.listCatalog(params);
    } catch (err) {
      done(err);
    }

    expect(response).toBeDefined();
    expect(response.status).toEqual(200);
    expect(response.result).toBeDefined();

    const { result } = response;
    expect(result.services[0].id).toBeDefined();
    expect(result.services[0].name).toBeDefined();
    expect(result.services[0].bindable).toBeDefined();
    expect(result.services[0].plan_updateable).toBeDefined();

    done();
  });

  test('07 - Delete Service Binding', async (done) => {
    const customHeader = {
      'Transaction-Id': `osb-sdk-node-test07-${transactionId}`,
    };

    const params = {
      bindingId: testBindingId2,
      instanceId: testInstanceId2,
      planId: testPlanId3,
      serviceId: testServiceId,
      headers: customHeader,
    };

    let response;
    try {
      response = await service.deleteServiceBinding(params);
    } catch (err) {
      done(err);
    }

    expect(response).toBeDefined();
    expect(response.status).toEqual(200);
    done();
  });

  test('08 - Delete Service Instance', async (done) => {
    const customHeader = {
      'Transaction-Id': `osb-sdk-node-test08-${transactionId}`,
    };

    const params = {
      serviceId: testServiceId,
      planId: testPlanId3,
      instanceId: testInstanceId2,
      headers: customHeader,
    };

    let response;
    try {
      response = await service.deleteServiceInstance(params);
    } catch (err) {
      done(err);
    }

    expect(response).toBeDefined();
    expect(response.status).toEqual(200);
    expect(response.result).toBeDefined();
    done();
  });
});
