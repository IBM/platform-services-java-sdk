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
const EnterpriseUsageReportsV1 = require('../../dist/enterprise-usage-reports/v1');
const authHelper = require('../resources/auth-helper.js');

// testcase timeout value (200s).
const timeout = 200000;

// Location of our config file.
const configFile = 'enterprise_usage_reports.env';

const describe = authHelper.prepareTests(configFile);

let service;
let accountId;
let accountGroupId;
let enterpriseId;
let billingMonth;

describe('EnterpriseUsageReportsV1_integration', () => {
  service = EnterpriseUsageReportsV1.newInstance({});

  const config = readExternalSources(EnterpriseUsageReportsV1.DEFAULT_SERVICE_NAME);

  expect(service).not.toBeNull();
  expect(config).not.toBeNull();

  accountId = config.accountId;
  accountGroupId = config.accountGroupId;
  enterpriseId = config.enterpriseId;
  billingMonth = config.billingMonth;
  expect(accountId).not.toBeNull();
  expect(accountGroupId).not.toBeNull();
  expect(enterpriseId).not.toBeNull();
  expect(billingMonth).not.toBeNull();

  jest.setTimeout(timeout);

  test('getResourceUsageReportEnterprise()', async (done) => {
    const results = [];
    let offset = null;
    try {
      do {
        // Retrieve the reports one at a time to test pagination.
        const params = {
          enterpriseId,
          month: billingMonth,
          limit: 1,
          offset,
        };

        const res = await service.getResourceUsageReport(params);
        expect(res.status).toEqual(200);

        const { result } = res;
        expect(result).toBeDefined();

        // Add the just-retrieved page to "results".
        expect(result.reports).toBeDefined();
        results.push(...result.reports);

        // Determine the offset to use to get the next page.
        if (result.next) {
          offset = getOffsetFromURL(result.next.href);
        } else {
          offset = null;
        }
      } while (offset != null);
    } catch (err) {
      console.log(err);
      done(err);
    }

    // Make sure we found some reports.
    const numReports = results.length;
    // console.log(`getResourceUsageReport() response contained ${numReports} total reports`);
    expect(numReports).toBeGreaterThan(0);
    done();
  });

  test('getResourceUsageReportAccount()', async (done) => {
    const results = [];
    let offset = null;
    try {
      do {
        // Retrieve the reports one at a time to test pagination.
        const params = {
          accountId,
          month: billingMonth,
          limit: 1,
          offset,
        };

        const res = await service.getResourceUsageReport(params);
        expect(res.status).toEqual(200);

        const { result } = res;
        expect(result).toBeDefined();

        // Add the just-retrieved page to "results".
        expect(result.reports).toBeDefined();
        results.push(...result.reports);

        // Determine the offset to use to get the next page.
        if (result.next) {
          offset = getOffsetFromURL(result.next.href);
        } else {
          offset = null;
        }
      } while (offset != null);
    } catch (err) {
      console.log(err);
      done(err);
    }

    // Make sure we found some reports.
    const numReports = results.length;
    // console.log(`getResourceUsageReport() response contained ${numReports} total reports`);
    expect(numReports).toBeGreaterThan(0);
    done();
  });

  test('getResourceUsageReportAccountGroup()', async (done) => {
    const results = [];
    let offset = null;
    try {
      do {
        // Retrieve the reports one at a time to test pagination.
        const params = {
          accountGroupId,
          month: billingMonth,
          limit: 1,
          offset,
        };

        const res = await service.getResourceUsageReport(params);
        expect(res.status).toEqual(200);

        const { result } = res;
        expect(result).toBeDefined();

        // Add the just-retrieved page to "results".
        expect(result.reports).toBeDefined();
        results.push(...result.reports);

        // Determine the offset to use to get the next page.
        if (result.next) {
          offset = getOffsetFromURL(result.next.href);
        } else {
          offset = null;
        }
      } while (offset != null);
    } catch (err) {
      console.log(err);
      done(err);
    }

    // Make sure we found some reports.
    const numReports = results.length;
    // console.log(`getResourceUsageReport() response contained ${numReports} total reports`);
    expect(numReports).toBeGreaterThan(0);
    done();
  });
});

function getOffsetFromURL(urlstring) {
  let offset = null;
  if (urlstring) {
    // We use a bogus "baseurl" in case "urlstring" is a relative url.
    // This is fine since we're only trying to retrieve the "offset" query parameter.
    const url = new URL(urlstring, 'https://fakehost.com');
    offset = url.searchParams.get('offset');
  }
  return offset;
}
