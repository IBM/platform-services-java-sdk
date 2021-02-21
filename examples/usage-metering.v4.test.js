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

const UsageMeteringV4 = require('../dist/usage-metering/v4');
const authHelper = require('../test/resources/auth-helper.js');

//
// This file provides an example of how to use the Usage Metering service.
//
// The following configuration properties are assumed to be defined:
//
// USAGE_METERING_URL=<service url>
// USAGE_METERING_AUTHTYPE=iam
// USAGE_METERING_APIKEY=<your iam apikey>
// USAGE_METERING_AUTH_URL=<IAM token service URL - omit this if using the production environment>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
const configFile = 'usage_metering.env';

const describe = authHelper.prepareTests(configFile);

// Save original console.log and console.warn
const originalLog = console.log;
const originalWarn = console.warn;

// Mocks for console.log and console.warn
const consoleLogMock = jest.spyOn(console, 'log');
const consoleWarnMock = jest.spyOn(console, 'warn');

describe('UsageMeteringV4', () => {

  // begin-common

  const usageMeteringService = UsageMeteringV4.newInstance({});

  // end-common

  test('reportResourceUsage request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    const startTime = Date.now();
    const endTime = startTime;

    const resourceId = "cloudant";
    const resourceInstanceId = "crn:v1:staging:public:cloudantnosqldb:us-south:a/f5086e3df886495991303628d21da513:3aafbbee-88e2-4d29-b144-9d267d97064c::";
    const planId = "cloudant-standard";
    const region = "us-south";

    // begin-report_resource_usage

    // Report usage for a mythical resource.
    // Use zero for quantities since this is only an example.
    const measures = [{
      measure: 'LOOKUP',
      quantity: 0,
    },
    {
      measure: 'WRITE',
      quantity: 0,
    },
    {
      measure: 'QUERY',
      quantity: 0,
    },
    {
      measure: 'GIGABYTE',
      quantity: 0,
    }];

    const resourceInstanceUsageModel = {
      resource_instance_id: resourceInstanceId,
      plan_id: planId,
      region: region,
      start: startTime,
      end: endTime,
      measured_usage: measures,
    };

    const params = {
      resourceId: resourceId,
      resourceUsage: [resourceInstanceUsageModel],
    };

    usageMeteringService.reportResourceUsage(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-report_resource_usage
  });
});
