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

const IamAccessGroupsV2 = require('../../dist/iam-access-groups/v2');
const { readExternalSources } = require('ibm-cloud-sdk-core');
const authHelper = require('../resources/auth-helper.js');

// testcase timeout value (10s).
const timeout = 10000;

// Location of our config file.
const configFile = 'iam_access_groups.env';

// Use authHelper to skip tests if our configFile is not available.
const describe = authHelper.prepareTests(configFile);

describe('IamAccessGroupsV2_integration', () => {
  jest.setTimeout(timeout);

  let service;
  let config;
  let testAccountId;
  
  test('should successfully complete initialization', done => {
    // Initialize the service client.
    service = IamAccessGroupsV2.newInstance();

    // Grab our test-specific config properies.
    config = readExternalSources(IamAccessGroupsV2.DEFAULT_SERVICE_NAME);

    expect(service).not.toBeNull();
    expect(config).not.toBeNull();
    expect(config).toHaveProperty('testAccountId');

    // Retrieve the test account id to be used with the tests.
    testAccountId = config.testAccountId;
    
    expect(testAccountId).not.toBeNull();
    done();
  });
  
});

