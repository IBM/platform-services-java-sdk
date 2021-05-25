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
const { v4: uuidv4 } = require('uuid');
const GlobalSearchV2 = require('../../dist/global-search/v2');
const authHelper = require('../resources/auth-helper.js');

// testcase timeout value (120s).
const timeout = 120000;

// Location of our config file.
const configFile = 'global_search.env';

const describe = authHelper.prepareTests(configFile);

const transactionId = uuidv4();

describe('GlobalSearchV2_integration', () => {
  jest.setTimeout(timeout);

  const globalSearchService = GlobalSearchV2.newInstance({});

  const config = readExternalSources(GlobalSearchV2.DEFAULT_SERVICE_NAME);

  expect(globalSearchService).not.toBeNull();
  expect(config).not.toBeNull();

  test('search()', async () => {
    const searchResults = [];
    let searchCursor;
    let moreResults = true;

    while (moreResults) {
      const params = {
        query: 'GST-sdk-*',
        fields: ['*'],
        transactionId,
        searchCursor,
        limit: 1,
      };

      const res = await globalSearchService.search(params);
      expect(res).toBeDefined();
      expect(res.result).toBeDefined();
      expect(res.status).toEqual(200);
      console.log(`search() result: \n${JSON.stringify(res.result, null, 2)}`);

      const { result } = res;
      if (result.items && result.items.length > 0) {
        searchResults.push(...result.items);
        searchCursor = result.search_cursor;
      } else {
        moreResults = false;
      }
    }

    console.log('Total items returned by search(): ', searchResults.length);
  });
  test('getSupportedTypes()', async () => {
    const res = await globalSearchService.getSupportedTypes();
    expect(res).toBeDefined();
    expect(res.result).toBeDefined();
    expect(res.status).toEqual(200);

    console.log(`getSupportedTypes() result: \n${JSON.stringify(res.result, null, 2)}`);
  });
});
