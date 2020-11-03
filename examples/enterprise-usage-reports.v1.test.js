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

const EnterpriseUsageReportsV1 = require('../dist/enterprise-usage-reports/v1');
const { readExternalSources } = require('ibm-cloud-sdk-core');
const authHelper = require('../test/resources/auth-helper.js');

//
// This file provides an example of how to use the Usage Reports service.
//
// The following configuration properties are assumed to be defined:
// ENTERPRISE_USAGE_REPORTS_URL=<service url>
// ENTERPRISE_USAGE_REPORTS_AUTHTYPE=iam
// ENTERPRISE_USAGE_REPORTS_APIKEY=<IAM api key of user with authority to create rules>
// ENTERPRISE_USAGE_REPORTS_AUTH_URL=<IAM token service URL - omit this if using the production environment>
// ENTERPRISE_USAGE_REPORTS_ENTERPRISE_ID=<the id of the enterprise whose usage info will be retrieved>
// ENTERPRISE_USAGE_REPORTS_ACCOUNT_ID=<the id of the account whose usage info will be retrieved>
// ENTERPRISE_USAGE_REPORTS_ACCOUNT_GROUP_ID=<the id of the account group whose usage info will be retrieved>
// ENTERPRISE_USAGE_REPORTS_BILLING_MONTH=<the billing month (yyyy-mm) for which usage info will be retrieved>
//
// These configuration properties can be exported as environment variables, or stored
// in a "credentials" file and then:
// export IBM_CREDENTIALS_FILE=<name of credentials file>
//

// Location of our config file.
const configFile = 'enterprise_usage_reports.env';

const describe = authHelper.prepareTests(configFile);

// Save original console.log and console.warn
const originalLog = console.log
const originalWarn = console.warn

// Mocks for console.log and console.warn
const consoleLogMock = jest.spyOn(console, 'log');
const consoleWarnMock = jest.spyOn(console, 'warn');

describe('EnterpriseUsageReportsV1', () => {
  jest.setTimeout(15000);

  // begin-common

  const enterpriseUsageReportsService = EnterpriseUsageReportsV1.newInstance({});

  // end-common

  const config = readExternalSources(EnterpriseUsageReportsV1.DEFAULT_SERVICE_NAME);
  let enterpriseId = config.enterpriseId;
  let billingMonth = config.billingMonth;

  test('getResourceUsageReport request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-get_resource_usage_report

    const params = {
      enterpriseId: enterpriseId,
      month: billingMonth,
      limit: 10,
    };

    enterpriseUsageReportsService.getResourceUsageReport(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-get_resource_usage_report
  });
});
