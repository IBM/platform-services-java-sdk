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

const UsageReportsV4 = require('../dist/usage-reports/v4');
const { readExternalSources } = require('ibm-cloud-sdk-core');
const authHelper = require('../test/resources/auth-helper.js');

//
// This file provides an example of how to use the Usage Reports service.
//
// The following configuration properties are assumed to be defined:
// USAGE_REPORTS_URL=<service url>
// USAGE_REPORTS_AUTHTYPE=iam
// USAGE_REPORTS_APIKEY=<IAM api key of user with authority to create rules>
// USAGE_REPORTS_AUTH_URL=<IAM token service URL - omit this if using the production environment>
// USAGE_REPORTS_ACCOUNT_ID=<the id of the account whose usage info will be retrieved>
// USAGE_REPORTS_RESOURCE_GROUP_ID=<the id of the resource group whose usage info will be retrieved>
// USAGE_REPORTS_ORG_ID=<the id of the organization whose usage info will be retrieved>
// USAGE_REPORTS_BILLING_MONTH=<the billing month (yyyy-mm) for which usage info will be retrieved>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
const configFile = 'usage_reports.env';

const describe = authHelper.prepareTests(configFile);

// Save original console.log and console.warn
const originalLog = console.log
const originalWarn = console.warn

// Mocks for console.log and console.warn
const consoleLogMock = jest.spyOn(console, 'log');
const consoleWarnMock = jest.spyOn(console, 'warn');

describe('UsageReportsV4', () => {
  jest.setTimeout(30000);

  // begin-common

  const usageReportsService = UsageReportsV4.newInstance({});

  // end-common

  const config = readExternalSources(UsageReportsV4.DEFAULT_SERVICE_NAME);

  let accountId = config.accountId;
  let resourceGroupId = config.resourceGroupId;
  let orgId = config.orgId;
  let billingMonth = config.billingMonth;

  test('getAccountSummary request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-get_account_summary

    const params = {
      accountId: accountId,
      billingmonth: billingMonth,
    };

    usageReportsService.getAccountSummary(params)
      .then(res => {
        console.log('getAccountSummary() result:\n' + JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-get_account_summary
  });
  test('getAccountUsage request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-get_account_usage

    const params = {
      accountId: accountId,
      billingmonth: billingMonth,
    };

    usageReportsService.getAccountUsage(params)
      .then(res => {
        console.log('getAccountUsage() result:\n' + JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-get_account_usage
  });
  test('getResourceGroupUsage request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-get_resource_group_usage

    const params = {
      accountId: accountId,
      resourceGroupId: resourceGroupId,
      billingmonth: billingMonth,
    };

    usageReportsService.getResourceGroupUsage(params)
      .then(res => {
        console.log('getResourceGroupUsage() result:\n' + JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-get_resource_group_usage
  });
  test('getOrgUsage request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-get_org_usage

    const params = {
      accountId: accountId,
      organizationId: orgId,
      billingmonth: billingMonth,
    };

    usageReportsService.getOrgUsage(params)
      .then(res => {
        console.log('getOrgUsage() result:\n' + JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-get_org_usage
  });
  test('getResourceUsageAccount request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-get_resource_usage_account

    const params = {
      accountId: accountId,
      billingmonth: billingMonth,
    };

    usageReportsService.getResourceUsageAccount(params)
      .then(res => {
        console.log('getResourceUsageAccount() result:\n' + JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-get_resource_usage_account
  });
  test('getResourceUsageResourceGroup request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-get_resource_usage_resource_group

    const params = {
      accountId: accountId,
      resourceGroupId: resourceGroupId,
      billingmonth: billingMonth,
    };

    usageReportsService.getResourceUsageResourceGroup(params)
      .then(res => {
        console.log('getResourceUsageResourceGroup() result:\n' + JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-get_resource_usage_resource_group
  });
  test('getResourceUsageOrg request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-get_resource_usage_org

    const params = {
      accountId: accountId,
      organizationId: orgId,
      billingmonth: billingMonth,
    };

    usageReportsService.getResourceUsageOrg(params)
      .then(res => {
        console.log('getResourceUsageOrg() result:\n' + JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-get_resource_usage_org
  });
});
