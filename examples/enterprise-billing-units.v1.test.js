/**
* @jest-environment node
*/
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

const EnterpriseBillingUnitsV1 = require('../dist/enterprise-billing-units/v1');
const { readExternalSources } = require('ibm-cloud-sdk-core');
const authHelper = require('../test/resources/auth-helper.js');

//
// This file provides an example of how to use the Enterprise Billing Units service.
//
// The following configuration properties are assumed to be defined in the external configuration file:
// ENTERPRISE_BILLING_UNITS_URL=<service url>
// ENTERPRISE_BILLING_UNITS_AUTHTYPE=iam
// ENTERPRISE_BILLING_UNITS_APIKEY=<your iam apikey>
// ENTERPRISE_BILLING_UNITS_AUTH_URL=<IAM token service URL - omit this if using the production environment>
// ENTERPRISE_BILLING_UNITS_ENTERPRISE_ID=<id of enterprise to use for examples>
// ENTERPRISE_BILLING_UNITS_BILLING_UNIT_ID=<id of billing unit to use for examples>
//

// Location of our config file.
const configFile = 'enterprise_billing_units.env';

const describe = authHelper.prepareTests(configFile);

// Save original console.log and console.warn
const originalLog = console.log;
const originalWarn = console.warn;

// Mocks for console.log and console.warn
const consoleLogMock = jest.spyOn(console, 'log');
const consoleWarnMock = jest.spyOn(console, 'warn');

describe('EnterpriseBillingUnitsV1', () => {
  jest.setTimeout(10000);

  // begin-common

  const enterpriseBillingUnitsService = EnterpriseBillingUnitsV1.newInstance({});

  // end-common

  const config = readExternalSources(EnterpriseBillingUnitsV1.DEFAULT_SERVICE_NAME);

  let enterpriseId = config.enterpriseId;
  let billingUnitId = config.billingUnitId;

  test('getBillingUnit request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-get_billing_unit
    true
    const params = {
      billingUnitId: billingUnitId,
    };

    enterpriseBillingUnitsService.getBillingUnit(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-get_billing_unit
  });
  test('listBillingUnits request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-list_billing_units

    const params = {
      enterpriseId: enterpriseId,
    };
    enterpriseBillingUnitsService.listBillingUnits(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-list_billing_units
  });
  test('listBillingOptions request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-list_billing_options

    const params = {
      billingUnitId: billingUnitId,
    };

    enterpriseBillingUnitsService.listBillingOptions(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-list_billing_options
  });
  test('getCreditPools request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-get_credit_pools

    const params = {
      billingUnitId: billingUnitId,
    };

    enterpriseBillingUnitsService.getCreditPools(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-get_credit_pools
  });
});
