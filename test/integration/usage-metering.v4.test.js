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

const UsageMeteringV4 = require('../../dist/usage-metering/v4');
const authHelper = require('../resources/auth-helper.js');

// testcase timeout value (200s).
const timeout = 200000;

// Location of our config file.
const configFile = 'usage_metering.env';

const verbose = true;

const describe = authHelper.prepareTests(configFile);

describe('UsageMeteringV4_integration', () => {
  const usageMeteringService = UsageMeteringV4.newInstance({});

  expect(usageMeteringService).not.toBeNull();

  jest.setTimeout(timeout);

  test('reportResourceUsage()', async () => {
    // Request models needed by this operation.

    const startTime = Date.now();
    const endTime = startTime;

    const resourceId = 'cloudant';
    const resourceInstanceId =
      'crn:v1:staging:public:cloudantnosqldb:us-south:a/f5086e3df886495991303628d21da513:3aafbbee-88e2-4d29-b144-9d267d97064c::';
    const planId = 'cloudant-standard';
    const region = 'us-south';

    // MeasureAndQuantity
    const measures = [
      {
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
      },
    ];

    // ResourceInstanceUsage
    const resourceInstanceUsageModel = {
      resource_instance_id: resourceInstanceId,
      plan_id: planId,
      region,
      start: startTime,
      end: endTime,
      measured_usage: measures,
    };

    const params = {
      resourceId,
      resourceUsage: [resourceInstanceUsageModel],
    };

    const res = await usageMeteringService.reportResourceUsage(params);
    expect(res).toBeDefined();
    expect(res.result).toBeDefined();
    log(`reportResourceUsage() result: ${JSON.stringify(res.result, null, 2)}`);
  });
});

function log(msg) {
  if (verbose) {
    console.log(msg);
  }
}
