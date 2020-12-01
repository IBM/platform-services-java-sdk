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

const EnterpriseBillingUnitsV1 = require('../../dist/enterprise-billing-units/v1');

const {
  getOptions,
  checkUrlAndMethod,
  checkMediaHeaders,
  expectToBePromise,
  checkForSuccessfulExecution,
} = unitTestUtils;

const service = {
  authenticator: new NoAuthAuthenticator(),
  url: 'https://billing.cloud.ibm.com',
};

const enterpriseBillingUnitsService = new EnterpriseBillingUnitsV1(service);

// dont actually create a request
const createRequestMock = jest.spyOn(enterpriseBillingUnitsService, 'createRequest');
createRequestMock.mockImplementation(() => Promise.resolve());

// dont actually construct an authenticator
const getAuthenticatorMock = jest.spyOn(core, 'getAuthenticatorFromEnvironment');
getAuthenticatorMock.mockImplementation(() => new NoAuthAuthenticator());

afterEach(() => {
  createRequestMock.mockClear();
  getAuthenticatorMock.mockClear();
});

describe('EnterpriseBillingUnitsV1', () => {
  describe('the newInstance method', () => {
    test('should use defaults when options not provided', () => {
      const testInstance = EnterpriseBillingUnitsV1.newInstance();

      expect(getAuthenticatorMock).toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceName).toBe(EnterpriseBillingUnitsV1.DEFAULT_SERVICE_NAME);
      expect(testInstance.baseOptions.serviceUrl).toBe(EnterpriseBillingUnitsV1.DEFAULT_SERVICE_URL);
      expect(testInstance).toBeInstanceOf(EnterpriseBillingUnitsV1);
    });

    test('should set serviceName, serviceUrl, and authenticator when provided', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
        serviceName: 'my-service',
      };

      const testInstance = EnterpriseBillingUnitsV1.newInstance(options);

      expect(getAuthenticatorMock).not.toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
      expect(testInstance.baseOptions.serviceName).toBe('my-service');
      expect(testInstance).toBeInstanceOf(EnterpriseBillingUnitsV1);
    });
  });
  describe('the constructor', () => {
    test('use user-given service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
      };

      const testInstance = new EnterpriseBillingUnitsV1(options);

      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
    });

    test('use default service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
      };

      const testInstance = new EnterpriseBillingUnitsV1(options);

      expect(testInstance.baseOptions.serviceUrl).toBe(EnterpriseBillingUnitsV1.DEFAULT_SERVICE_URL);
    });
  });
  describe('getBillingUnit', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getBillingUnit
        const billingUnitId = 'testString';
        const params = {
          billingUnitId: billingUnitId,
        };

        const getBillingUnitResult = enterpriseBillingUnitsService.getBillingUnit(params);

        // all methods should return a Promise
        expectToBePromise(getBillingUnitResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/billing-units/{billing_unit_id}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['billing_unit_id']).toEqual(billingUnitId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const billingUnitId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          billingUnitId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        enterpriseBillingUnitsService.getBillingUnit(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await enterpriseBillingUnitsService.getBillingUnit({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getBillingUnitPromise = enterpriseBillingUnitsService.getBillingUnit();
        expectToBePromise(getBillingUnitPromise);

        getBillingUnitPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('listBillingUnits', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listBillingUnits
        const accountId = 'testString';
        const enterpriseId = 'testString';
        const accountGroupId = 'testString';
        const params = {
          accountId: accountId,
          enterpriseId: enterpriseId,
          accountGroupId: accountGroupId,
        };

        const listBillingUnitsResult = enterpriseBillingUnitsService.listBillingUnits(params);

        // all methods should return a Promise
        expectToBePromise(listBillingUnitsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/billing-units', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['account_id']).toEqual(accountId);
        expect(options.qs['enterprise_id']).toEqual(enterpriseId);
        expect(options.qs['account_group_id']).toEqual(accountGroupId);
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

        enterpriseBillingUnitsService.listBillingUnits(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        enterpriseBillingUnitsService.listBillingUnits({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('listBillingOptions', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listBillingOptions
        const billingUnitId = 'testString';
        const params = {
          billingUnitId: billingUnitId,
        };

        const listBillingOptionsResult = enterpriseBillingUnitsService.listBillingOptions(params);

        // all methods should return a Promise
        expectToBePromise(listBillingOptionsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/billing-options', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['billing_unit_id']).toEqual(billingUnitId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const billingUnitId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          billingUnitId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        enterpriseBillingUnitsService.listBillingOptions(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await enterpriseBillingUnitsService.listBillingOptions({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const listBillingOptionsPromise = enterpriseBillingUnitsService.listBillingOptions();
        expectToBePromise(listBillingOptionsPromise);

        listBillingOptionsPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getCreditPools', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getCreditPools
        const billingUnitId = 'testString';
        const date = 'testString';
        const type = 'testString';
        const params = {
          billingUnitId: billingUnitId,
          date: date,
          type: type,
        };

        const getCreditPoolsResult = enterpriseBillingUnitsService.getCreditPools(params);

        // all methods should return a Promise
        expectToBePromise(getCreditPoolsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/credit-pools', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['billing_unit_id']).toEqual(billingUnitId);
        expect(options.qs['date']).toEqual(date);
        expect(options.qs['type']).toEqual(type);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const billingUnitId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          billingUnitId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        enterpriseBillingUnitsService.getCreditPools(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await enterpriseBillingUnitsService.getCreditPools({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getCreditPoolsPromise = enterpriseBillingUnitsService.getCreditPools();
        expectToBePromise(getCreditPoolsPromise);

        getCreditPoolsPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
});
