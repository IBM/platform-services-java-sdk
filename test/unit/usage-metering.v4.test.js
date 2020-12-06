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

const usageMeteringService = new UsageMeteringV4(service);

// dont actually create a request
const createRequestMock = jest.spyOn(usageMeteringService, 'createRequest');
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
        quantity: '1',
      };

      // ResourceInstanceUsage
      const resourceInstanceUsageModel = {
        resource_instance_id: 'crn:v1:bluemix:staging:database-service:us-south:a/1c8ae972c35e470d994b6faff9494ce1:793ff3d3-9fe3-4329-9ea0-404703a3c371::',
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
        const resourceUsage = [resourceInstanceUsageModel];
        const params = {
          resourceId: resourceId,
          resourceUsage: resourceUsage,
        };

        const reportResourceUsageResult = usageMeteringService.reportResourceUsage(params);

        // all methods should return a Promise
        expectToBePromise(reportResourceUsageResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v4/metering/resources/{resource_id}/usage', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body).toEqual(resourceUsage);
        expect(options.path['resource_id']).toEqual(resourceId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const resourceId = 'testString';
        const resourceUsage = [resourceInstanceUsageModel];
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          resourceId,
          resourceUsage,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        usageMeteringService.reportResourceUsage(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await usageMeteringService.reportResourceUsage({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const reportResourceUsagePromise = usageMeteringService.reportResourceUsage();
        expectToBePromise(reportResourceUsagePromise);

        reportResourceUsagePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
});
