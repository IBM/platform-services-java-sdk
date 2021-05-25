/* eslint-disable no-console */
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

const { readExternalSources } = require('ibm-cloud-sdk-core');
const EnterpriseBillingUnitsV1 = require('../../dist/enterprise-billing-units/v1');
const authHelper = require('../resources/auth-helper.js');

// testcase timeout value (25s).
const timeout = 25000;

// Location of our config file.
const configFile = 'enterprise_billing_units.env';

const verbose = false;

const describe = authHelper.prepareTests(configFile);

let ENTERPRISE_ID;
let ACCOUNT_ID;
let ACCOUNT_GROUP_ID;
let BILLING_UNIT_ID;

describe('EnterpriseBillingUnitsV1_integration', () => {
  jest.setTimeout(timeout);
  let enterpriseBillingUnitsService;

  beforeAll(async (done) => {
    enterpriseBillingUnitsService = EnterpriseBillingUnitsV1.newInstance({});

    const config = readExternalSources(EnterpriseBillingUnitsV1.DEFAULT_SERVICE_NAME);

    expect(enterpriseBillingUnitsService).not.toBeNull();
    expect(config).not.toBeNull();

    // Retrieve and verify some additional test-related config properties.
    ENTERPRISE_ID = config.enterpriseId;
    ACCOUNT_ID = config.accountId;
    ACCOUNT_GROUP_ID = config.accountGroupId;
    BILLING_UNIT_ID = config.billingUnitId;
    expect(ENTERPRISE_ID).not.toBeNull();
    expect(ACCOUNT_ID).not.toBeNull();
    expect(ACCOUNT_GROUP_ID).not.toBeNull();
    expect(BILLING_UNIT_ID).not.toBeNull();

    log(`Service URL: ${enterpriseBillingUnitsService.baseOptions.serviceUrl}`);
    log('Finished setup.');

    done();
  });

  test('getBillingUnit()', async () => {
    const params = {
      billingUnitId: BILLING_UNIT_ID,
    };

    const res = await enterpriseBillingUnitsService.getBillingUnit(params);
    expect(res).toBeDefined();
    expect(res.result).toBeDefined();
    log(`getBillingUnit() result: ${JSON.stringify(res.result, null, 2)}`);
  });

  test('listBillingUnits(enterprise id)', async () => {
    const params = {
      enterpriseId: ENTERPRISE_ID,
    };

    const res = await enterpriseBillingUnitsService.listBillingUnits(params);
    expect(res).toBeDefined();
    expect(res.result).toBeDefined();
    log(`listBillingUnits(enterprise id) result: ${JSON.stringify(res.result, null, 2)}`);
  });

  test('listBillingUnits(account id)', async () => {
    const params = {
      accountId: ACCOUNT_ID,
    };

    const res = await enterpriseBillingUnitsService.listBillingUnits(params);
    expect(res).toBeDefined();
    expect(res.result).toBeDefined();
    log(`listBillingUnits(account id) result: ${JSON.stringify(res.result, null, 2)}`);
  });

  test('listBillingUnits(account group id)', async () => {
    const params = {
      accountGroupId: ACCOUNT_GROUP_ID,
    };

    const res = await enterpriseBillingUnitsService.listBillingUnits(params);
    expect(res).toBeDefined();
    expect(res.result).toBeDefined();
    log(`listBillingUnits(account group id) result: ${JSON.stringify(res.result, null, 2)}`);
  });

  test('listBillingOptions()', async () => {
    const params = {
      billingUnitId: BILLING_UNIT_ID,
    };

    const res = await enterpriseBillingUnitsService.listBillingOptions(params);
    expect(res).toBeDefined();
    expect(res.result).toBeDefined();
    log(`listBillingOptions() result: ${JSON.stringify(res.result, null, 2)}`);
  });

  test('getCreditPools()', async () => {
    const params = {
      billingUnitId: BILLING_UNIT_ID,
      type: 'PLATFORM',
    };

    const res = await enterpriseBillingUnitsService.getCreditPools(params);
    expect(res).toBeDefined();
    expect(res.result).toBeDefined();
    log(`getCreditPools() result: ${JSON.stringify(res.result, null, 2)}`);
  });
});

function log(msg) {
  if (verbose) {
    console.log(msg);
  }
}
