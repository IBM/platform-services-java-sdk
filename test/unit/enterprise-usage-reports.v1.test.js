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

const EnterpriseUsageReportsV1 = require('../../dist/enterprise-usage-reports/v1');

const {
  getOptions,
  checkUrlAndMethod,
  checkMediaHeaders,
  expectToBePromise,
  checkForSuccessfulExecution,
} = unitTestUtils;

const service = {
  authenticator: new NoAuthAuthenticator(),
  url: 'https://enterprise.cloud.ibm.com',
};

const enterpriseUsageReportsService = new EnterpriseUsageReportsV1(service);

// dont actually create a request
const createRequestMock = jest.spyOn(enterpriseUsageReportsService, 'createRequest');
createRequestMock.mockImplementation(() => Promise.resolve());

// dont actually construct an authenticator
const getAuthenticatorMock = jest.spyOn(core, 'getAuthenticatorFromEnvironment');
getAuthenticatorMock.mockImplementation(() => new NoAuthAuthenticator());

afterEach(() => {
  createRequestMock.mockClear();
  getAuthenticatorMock.mockClear();
});

describe('EnterpriseUsageReportsV1', () => {
  describe('the newInstance method', () => {
    test('should use defaults when options not provided', () => {
      const testInstance = EnterpriseUsageReportsV1.newInstance();

      expect(getAuthenticatorMock).toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceName).toBe(EnterpriseUsageReportsV1.DEFAULT_SERVICE_NAME);
      expect(testInstance.baseOptions.serviceUrl).toBe(EnterpriseUsageReportsV1.DEFAULT_SERVICE_URL);
      expect(testInstance).toBeInstanceOf(EnterpriseUsageReportsV1);
    });

    test('should set serviceName, serviceUrl, and authenticator when provided', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
        serviceName: 'my-service',
      };

      const testInstance = EnterpriseUsageReportsV1.newInstance(options);

      expect(getAuthenticatorMock).not.toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
      expect(testInstance.baseOptions.serviceName).toBe('my-service');
      expect(testInstance).toBeInstanceOf(EnterpriseUsageReportsV1);
    });
  });
  describe('the constructor', () => {
    test('use user-given service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
      };

      const testInstance = new EnterpriseUsageReportsV1(options);

      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
    });

    test('use default service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
      };

      const testInstance = new EnterpriseUsageReportsV1(options);

      expect(testInstance.baseOptions.serviceUrl).toBe(EnterpriseUsageReportsV1.DEFAULT_SERVICE_URL);
    });
  });
  describe('getResourceUsageReport', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getResourceUsageReport
        const enterpriseId = 'abc12340d4bf4e36b0423d209b286f24';
        const accountGroupId = 'def456a237b94b9a9238ef024e204c9f';
        const accountId = '987abcba31834216b8c726a7dd9eb8d6';
        const children = true;
        const month = '2019-06';
        const billingUnitId = 'testString';
        const limit = 10;
        const offset = 'testString';
        const params = {
          enterpriseId: enterpriseId,
          accountGroupId: accountGroupId,
          accountId: accountId,
          children: children,
          month: month,
          billingUnitId: billingUnitId,
          limit: limit,
          offset: offset,
        };

        const getResourceUsageReportResult = enterpriseUsageReportsService.getResourceUsageReport(params);

        // all methods should return a Promise
        expectToBePromise(getResourceUsageReportResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/resource-usage-reports', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['enterprise_id']).toEqual(enterpriseId);
        expect(options.qs['account_group_id']).toEqual(accountGroupId);
        expect(options.qs['account_id']).toEqual(accountId);
        expect(options.qs['children']).toEqual(children);
        expect(options.qs['month']).toEqual(month);
        expect(options.qs['billing_unit_id']).toEqual(billingUnitId);
        expect(options.qs['limit']).toEqual(limit);
        expect(options.qs['offset']).toEqual(offset);
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

        enterpriseUsageReportsService.getResourceUsageReport(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        enterpriseUsageReportsService.getResourceUsageReport({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
});
