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

'use strict';

const GlobalSearchV2 = require('../../dist/global-search/v2');
const {IamAuthenticator} = require('ibm-cloud-sdk-core');
const authHelper = require('../resources/auth-helper.js');

const timeout = 10000; // ten seconds

// Location of our config file.
const configFile = 'ghost.env';

// Use authHelper to skip tests if our configFile is not available.
const describe = authHelper.prepareTests(configFile);

// Retrieve the config file as an object.
// We do this because we're going to directly use the
// config properties, rather than let the SDK do it for us.
const config = authHelper.loadConfig();

describe('GlobalSearchV2_integration', () => {
  jest.setTimeout(timeout);

  // add query and other mandatory parameters.
  const query = config.GST_QUERY;
  const fields = ['crn', 'name'];
  const transactionId = 'testString';
  const limit = 100;
  const limit1 = 1;

  // Initialize the service client.
  const options = {
    authenticator: new IamAuthenticator({
      apikey: config.GST_IINTERNA_APIKEY,
    }),
    serviceUrl: config.GST_API_URL,
  };
  const globalSearch = new GlobalSearchV2(options);
  
  test('should search resources', done => {
    const params = {
      query: query,
      transactionId: transactionId,
      limit: limit,
      timeout: timeout,
    };        
    return globalSearch.search(params).then(response => {
      expect(response.hasOwnProperty('status')).toBe(true);
      expect(response.status).toBe(200);
      done();
    });
  });

  test('should search resources with cursor', done => {
    let searchCursor;

    const paramsCursor0 = {
      query: query,
      fields: fields,
      transactionId: transactionId,
      limit: limit1,
      timeout: timeout,
    };
    globalSearch.search(paramsCursor0).then(response => {
      searchCursor = response.result.search_cursor;
      expect(response.hasOwnProperty('status')).toBe(true);
      expect(response.status).toBe(200);

      const paramsCursor = {
        query: query,
        fields: fields,
        searchCursor: searchCursor,
        transactionId: transactionId,
        limit: limit1,
        timeout: timeout,
      };

      return globalSearch.search(paramsCursor).then(response => {
        expect(response.hasOwnProperty('status')).toBe(true);
        expect(response.status).toBe(200);
        done();
      });
    });
  });


  test('should get supported types', done => {
    const params3 = {};
    return globalSearch.getSupportedTypes(params3).then(response => {
      expect(response.hasOwnProperty('status')).toBe(true);
      expect(response.status).toBe(200);
      expect(Array.isArray(response.result.supported_types)).toBe(true);
      done();
    });
  });
});

