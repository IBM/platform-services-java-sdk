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

const UsageMeteringV4 = require('../../dist/usage-metering/v4');

const {
  getOptions,
  checkUrlAndMethod,
  checkMediaHeaders,
  expectToBePromise,
} = unitTestUtils;

const service = {
  authenticator: new NoAuthAuthenticator(),
  url: 'https://billing.cloud.ibm.com',
};

const usageMetering = new UsageMeteringV4(service);

// dont actually create a request
const createRequestMock = jest.spyOn(usageMetering, 'createRequest');
createRequestMock.mockImplementation(() => Promise.resolve());

// dont actually construct an authenticator
const getAuthenticatorMock = jest.spyOn(core, 'getAuthenticatorFromEnvironment');
getAuthenticatorMock.mockImplementation(() => new NoAuthAuthenticator());

afterEach(() => {
  createRequestMock.mockClear();
  getAuthenticatorMock.mockClear();
});

describe('UsageMeteringV4', () => {
  describe('the newInstance method', () => {
    test('should use defaults when options not provided', () => {
      const testInstance = UsageMeteringV4.newInstance();

      expect(getAuthenticatorMock).toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceName).toBe(UsageMeteringV4.DEFAULT_SERVICE_NAME);
      expect(testInstance.baseOptions.serviceUrl).toBe(UsageMeteringV4.DEFAULT_SERVICE_URL);
      expect(testInstance).toBeInstanceOf(UsageMeteringV4);
    });

    test('should set serviceName, serviceUrl, and authenticator when provided', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
        serviceName: 'my-service',
      };

      const testInstance = UsageMeteringV4.newInstance(options);

      expect(getAuthenticatorMock).not.toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
      expect(testInstance.baseOptions.serviceName).toBe('my-service');
      expect(testInstance).toBeInstanceOf(UsageMeteringV4);
    });
  });
  describe('the constructor', () => {
    test('use user-given service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
      };

      const testInstance = new UsageMeteringV4(options);

      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
    });

    test('use default service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
      };

      const testInstance = new UsageMeteringV4(options);

      expect(testInstance.baseOptions.serviceUrl).toBe(UsageMeteringV4.DEFAULT_SERVICE_URL);
    });
  });
  describe('reportResourceUsage', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // MeasureAndQuantity
      const measureAndQuantityModel = {
        measure: 'STORAGE',
        quantity: { foo: 'bar' },
      };

      // ResourceInstanceUsage
      const resourceInstanceUsageModel = {
        resource_instance_id: 'crn:v1:bluemix:public:database-service:us-south:a/1c8ae972c35e470d994b6faff9494ce1:793ff3d3-9fe3-4329-9ea0-404703a3c371::',
        plan_id: 'database-lite',
        region: 'us-south',
        start: 1485907200000,
        end: 1485907200000,
        measured_usage: [measureAndQuantityModel],
        consumer_id: 'cf-application:ed20abbe-8870-44e6-90f7-56d764c21127',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation reportResourceUsage
        const resourceId = 'testString';
        const resourceInstanceUsage = [resourceInstanceUsageModel];
        const params = {
          resourceId: resourceId,
          resourceInstanceUsage: resourceInstanceUsage,
        };

        const reportResourceUsageResult = usageMetering.reportResourceUsage(params);

        // all methods should return a Promise
        expectToBePromise(reportResourceUsageResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v4/metering/resources/{resource_id}/usage', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body).toEqual(resourceInstanceUsage);
        expect(options.path['resource_id']).toEqual(resourceId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const resourceId = 'testString';
        const resourceInstanceUsage = [resourceInstanceUsageModel];
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          resourceId,
          resourceInstanceUsage,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        usageMetering.reportResourceUsage(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await usageMetering.reportResourceUsage({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const reportResourceUsagePromise = usageMetering.reportResourceUsage();
        expectToBePromise(reportResourceUsagePromise);

        reportResourceUsagePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('reportCfresourceUsage', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // MeasureAndQuantity
      const measureAndQuantityModel = {
        measure: 'STORAGE',
        quantity: { foo: 'bar' },
      };

      // CfResourceInstanceUsage
      const cfResourceInstanceUsageModel = {
        organization_id: 'Public: us-south:102d9527-315a-4a71-afc2-068b1db6d68e Syndicated: ibm:dys0:us-south:e2566380-89cf-4c38-9290-7eb48cfca8f9',
        space_id: '89f0839a-812c-4180-8494-a453514c55e6',
        resource_instance_id: '5ca426de-5091-4f2f-8d87-28d37e7ff711',
        plan_id: 'database-lite',
        region: 'us-south',
        start: 1485907200000,
        end: 1485907200000,
        measured_usage: [measureAndQuantityModel],
        consumer_id: 'cf-application:ed20abbe-8870-44e6-90f7-56d764c21127',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation reportCfresourceUsage
        const resourceId = 'testString';
        const cfResourceInstanceUsage = [cfResourceInstanceUsageModel];
        const params = {
          resourceId: resourceId,
          cfResourceInstanceUsage: cfResourceInstanceUsage,
        };

        const reportCfresourceUsageResult = usageMetering.reportCfresourceUsage(params);

        // all methods should return a Promise
        expectToBePromise(reportCfresourceUsageResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/metering/resources/{resource_id}/usage', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body).toEqual(cfResourceInstanceUsage);
        expect(options.path['resource_id']).toEqual(resourceId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const resourceId = 'testString';
        const cfResourceInstanceUsage = [cfResourceInstanceUsageModel];
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          resourceId,
          cfResourceInstanceUsage,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        usageMetering.reportCfresourceUsage(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await usageMetering.reportCfresourceUsage({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const reportCfresourceUsagePromise = usageMetering.reportCfresourceUsage();
        expectToBePromise(reportCfresourceUsagePromise);

        reportCfresourceUsagePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
});
