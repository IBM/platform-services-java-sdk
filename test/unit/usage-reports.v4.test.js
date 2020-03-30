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

const UsageReportsV4 = require('../../dist/usage-reports/v4');

const {
  getOptions,
  checkUrlAndMethod,
  checkMediaHeaders,
  expectToBePromise,
} = unitTestUtils;

const service = {
  authenticator: new NoAuthAuthenticator(),
  url: 'https://metering-reporting.ng.bluemix.net',
};

const usageReports = new UsageReportsV4(service);

// dont actually create a request
const createRequestMock = jest.spyOn(usageReports, 'createRequest');
createRequestMock.mockImplementation(() => Promise.resolve());

// dont actually construct an authenticator
const getAuthenticatorMock = jest.spyOn(core, 'getAuthenticatorFromEnvironment');
getAuthenticatorMock.mockImplementation(() => new NoAuthAuthenticator());

afterEach(() => {
  createRequestMock.mockClear();
  getAuthenticatorMock.mockClear();
});

describe('UsageReportsV4', () => {
  describe('the newInstance method', () => {
    test('should use defaults when options not provided', () => {
      const testInstance = UsageReportsV4.newInstance();

      expect(getAuthenticatorMock).toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceName).toBe(UsageReportsV4.DEFAULT_SERVICE_NAME);
      expect(testInstance.baseOptions.serviceUrl).toBe(UsageReportsV4.DEFAULT_SERVICE_URL);
      expect(testInstance).toBeInstanceOf(UsageReportsV4);
    });

    test('should set serviceName, serviceUrl, and authenticator when provided', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
        serviceName: 'my-service',
      };

      const testInstance = UsageReportsV4.newInstance(options);

      expect(getAuthenticatorMock).not.toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
      expect(testInstance.baseOptions.serviceName).toBe('my-service');
      expect(testInstance).toBeInstanceOf(UsageReportsV4);
    });
  });
  describe('the constructor', () => {
    test('use user-given service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
      };

      const testInstance = new UsageReportsV4(options);

      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
    });

    test('use default service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
      };

      const testInstance = new UsageReportsV4(options);

      expect(testInstance.baseOptions.serviceUrl).toBe(UsageReportsV4.DEFAULT_SERVICE_URL);
    });
  });
  describe('getAccountSummary', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getAccountSummary
        const accountId = 'testString';
        const billingmonth = 'testString';
        const params = {
          accountId: accountId,
          billingmonth: billingmonth,
        };

        const getAccountSummaryResult = usageReports.getAccountSummary(params);

        // all methods should return a Promise
        expectToBePromise(getAccountSummaryResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v4/accounts/{account_id}/summary/{billingmonth}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['account_id']).toEqual(accountId);
        expect(options.path['billingmonth']).toEqual(billingmonth);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountId = 'testString';
        const billingmonth = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountId,
          billingmonth,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        usageReports.getAccountSummary(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await usageReports.getAccountSummary({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getAccountSummaryPromise = usageReports.getAccountSummary();
        expectToBePromise(getAccountSummaryPromise);

        getAccountSummaryPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getAccountUsage', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getAccountUsage
        const accountId = 'testString';
        const billingmonth = 'testString';
        const params = {
          accountId: accountId,
          billingmonth: billingmonth,
        };

        const getAccountUsageResult = usageReports.getAccountUsage(params);

        // all methods should return a Promise
        expectToBePromise(getAccountUsageResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v4/accounts/{account_id}/usage/{billingmonth}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['account_id']).toEqual(accountId);
        expect(options.path['billingmonth']).toEqual(billingmonth);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountId = 'testString';
        const billingmonth = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountId,
          billingmonth,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        usageReports.getAccountUsage(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await usageReports.getAccountUsage({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getAccountUsagePromise = usageReports.getAccountUsage();
        expectToBePromise(getAccountUsagePromise);

        getAccountUsagePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getResourceGroupUsage', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getResourceGroupUsage
        const accountId = 'testString';
        const resourceGroupId = 'testString';
        const billingmonth = 'testString';
        const params = {
          accountId: accountId,
          resourceGroupId: resourceGroupId,
          billingmonth: billingmonth,
        };

        const getResourceGroupUsageResult = usageReports.getResourceGroupUsage(params);

        // all methods should return a Promise
        expectToBePromise(getResourceGroupUsageResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v4/accounts/{account_id}/resource_groups/{resource_group_id}/usage/{billingmonth}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['account_id']).toEqual(accountId);
        expect(options.path['resource_group_id']).toEqual(resourceGroupId);
        expect(options.path['billingmonth']).toEqual(billingmonth);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountId = 'testString';
        const resourceGroupId = 'testString';
        const billingmonth = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountId,
          resourceGroupId,
          billingmonth,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        usageReports.getResourceGroupUsage(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await usageReports.getResourceGroupUsage({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getResourceGroupUsagePromise = usageReports.getResourceGroupUsage();
        expectToBePromise(getResourceGroupUsagePromise);

        getResourceGroupUsagePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getOrganizationUsage', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getOrganizationUsage
        const accountId = 'testString';
        const organizationId = 'testString';
        const billingmonth = 'testString';
        const params = {
          accountId: accountId,
          organizationId: organizationId,
          billingmonth: billingmonth,
        };

        const getOrganizationUsageResult = usageReports.getOrganizationUsage(params);

        // all methods should return a Promise
        expectToBePromise(getOrganizationUsageResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v4/accounts/{account_id}/organizations/{organization_id}/usage/{billingmonth}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['account_id']).toEqual(accountId);
        expect(options.path['organization_id']).toEqual(organizationId);
        expect(options.path['billingmonth']).toEqual(billingmonth);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountId = 'testString';
        const organizationId = 'testString';
        const billingmonth = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountId,
          organizationId,
          billingmonth,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        usageReports.getOrganizationUsage(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await usageReports.getOrganizationUsage({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getOrganizationUsagePromise = usageReports.getOrganizationUsage();
        expectToBePromise(getOrganizationUsagePromise);

        getOrganizationUsagePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getAccountInstancesUsage', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getAccountInstancesUsage
        const accountId = 'testString';
        const billingmonth = 'testString';
        const limit = 38;
        const start = 'testString';
        const resourceGroupId = 'testString';
        const organizationId = 'testString';
        const resourceInstanceId = 'testString';
        const resourceId = 'testString';
        const planId = 'testString';
        const region = 'testString';
        const params = {
          accountId: accountId,
          billingmonth: billingmonth,
          limit: limit,
          start: start,
          resourceGroupId: resourceGroupId,
          organizationId: organizationId,
          resourceInstanceId: resourceInstanceId,
          resourceId: resourceId,
          planId: planId,
          region: region,
        };

        const getAccountInstancesUsageResult = usageReports.getAccountInstancesUsage(params);

        // all methods should return a Promise
        expectToBePromise(getAccountInstancesUsageResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v4/accounts/{account_id}/resource_instances/usage/{billingmonth}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['_limit']).toEqual(limit);
        expect(options.qs['_start']).toEqual(start);
        expect(options.qs['resource_group_id']).toEqual(resourceGroupId);
        expect(options.qs['organization_id']).toEqual(organizationId);
        expect(options.qs['resource_instance_id']).toEqual(resourceInstanceId);
        expect(options.qs['resource_id']).toEqual(resourceId);
        expect(options.qs['plan_id']).toEqual(planId);
        expect(options.qs['region']).toEqual(region);
        expect(options.path['account_id']).toEqual(accountId);
        expect(options.path['billingmonth']).toEqual(billingmonth);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountId = 'testString';
        const billingmonth = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountId,
          billingmonth,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        usageReports.getAccountInstancesUsage(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await usageReports.getAccountInstancesUsage({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getAccountInstancesUsagePromise = usageReports.getAccountInstancesUsage();
        expectToBePromise(getAccountInstancesUsagePromise);

        getAccountInstancesUsagePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getResourceGroupInstancesUsage', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getResourceGroupInstancesUsage
        const accountId = 'testString';
        const resourceGroupId = 'testString';
        const billingmonth = 'testString';
        const limit = 38;
        const start = 'testString';
        const resourceInstanceId = 'testString';
        const resourceId = 'testString';
        const planId = 'testString';
        const region = 'testString';
        const params = {
          accountId: accountId,
          resourceGroupId: resourceGroupId,
          billingmonth: billingmonth,
          limit: limit,
          start: start,
          resourceInstanceId: resourceInstanceId,
          resourceId: resourceId,
          planId: planId,
          region: region,
        };

        const getResourceGroupInstancesUsageResult = usageReports.getResourceGroupInstancesUsage(params);

        // all methods should return a Promise
        expectToBePromise(getResourceGroupInstancesUsageResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v4/accounts/{account_id}/resource_groups/{resource_group_id}/resource_instances/usage/{billingmonth}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['_limit']).toEqual(limit);
        expect(options.qs['_start']).toEqual(start);
        expect(options.qs['resource_instance_id']).toEqual(resourceInstanceId);
        expect(options.qs['resource_id']).toEqual(resourceId);
        expect(options.qs['plan_id']).toEqual(planId);
        expect(options.qs['region']).toEqual(region);
        expect(options.path['account_id']).toEqual(accountId);
        expect(options.path['resource_group_id']).toEqual(resourceGroupId);
        expect(options.path['billingmonth']).toEqual(billingmonth);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountId = 'testString';
        const resourceGroupId = 'testString';
        const billingmonth = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountId,
          resourceGroupId,
          billingmonth,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        usageReports.getResourceGroupInstancesUsage(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await usageReports.getResourceGroupInstancesUsage({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getResourceGroupInstancesUsagePromise = usageReports.getResourceGroupInstancesUsage();
        expectToBePromise(getResourceGroupInstancesUsagePromise);

        getResourceGroupInstancesUsagePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getOrganizationInstancesUsage', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getOrganizationInstancesUsage
        const accountId = 'testString';
        const organizationId = 'testString';
        const billingmonth = 'testString';
        const limit = 38;
        const start = 'testString';
        const resourceInstanceId = 'testString';
        const resourceId = 'testString';
        const planId = 'testString';
        const region = 'testString';
        const params = {
          accountId: accountId,
          organizationId: organizationId,
          billingmonth: billingmonth,
          limit: limit,
          start: start,
          resourceInstanceId: resourceInstanceId,
          resourceId: resourceId,
          planId: planId,
          region: region,
        };

        const getOrganizationInstancesUsageResult = usageReports.getOrganizationInstancesUsage(params);

        // all methods should return a Promise
        expectToBePromise(getOrganizationInstancesUsageResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v4/accounts/{account_id}/organizations/{organization_id}/resource_instances/usage/{billingmonth}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['_limit']).toEqual(limit);
        expect(options.qs['_start']).toEqual(start);
        expect(options.qs['resource_instance_id']).toEqual(resourceInstanceId);
        expect(options.qs['resource_id']).toEqual(resourceId);
        expect(options.qs['plan_id']).toEqual(planId);
        expect(options.qs['region']).toEqual(region);
        expect(options.path['account_id']).toEqual(accountId);
        expect(options.path['organization_id']).toEqual(organizationId);
        expect(options.path['billingmonth']).toEqual(billingmonth);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountId = 'testString';
        const organizationId = 'testString';
        const billingmonth = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountId,
          organizationId,
          billingmonth,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        usageReports.getOrganizationInstancesUsage(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await usageReports.getOrganizationInstancesUsage({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getOrganizationInstancesUsagePromise = usageReports.getOrganizationInstancesUsage();
        expectToBePromise(getOrganizationInstancesUsagePromise);

        getOrganizationInstancesUsagePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
});
