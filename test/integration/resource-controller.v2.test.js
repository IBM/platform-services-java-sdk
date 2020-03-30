/**
 * Copyright 2019 IBM All Rights Reserved.
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

const ResourceControllerV2 = require('../../dist/resource-controller/v2');
const { IamAuthenticator } = require('../../dist/auth');
const authHelper = require('../resources/auth_helper.js');
const auth = authHelper.auth;
const describe = authHelper.describe; // this runs describe.skip if there is no auth.js file :)

const timeout = 10000; // ten seconds

describe('ResourceControllerV2_integration', () => {
  jest.setTimeout(timeout);
  
  const options = authHelper.auth.resource_controller;
  options.authenticator = new IamAuthenticator({ apikey: options.apikey });
  const resourceController = new ResourceControllerV2(options);

  describe('listResourceInstances', () => {
    it('result should contain resources key', () => {
      return resourceController.listResourceInstances().then(response => {
        expect(response.data.hasOwnProperty('resources')).toBe(true);
      });
    });
  });
});
