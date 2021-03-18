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
const ResourceManagerV2 = require('../../dist/resource-manager/v2');
const authHelper = require('../resources/auth-helper.js');
const { readExternalSources } = require('ibm-cloud-sdk-core');

// testcase timeout value (200s).
const timeout = 200000;

// Location of our config file.
const configFile = 'resource_manager.env';

const describe = authHelper.prepareTests(configFile);

describe('ResourceManagerV2_integration', () => {
  jest.setTimeout(timeout);

  let resourceManagerService = null;
  let deleteResourceManagerService = null;
  let newResourceGroupId = null;
  let url = null;
  let authType = null;
  let apiKey = null;
  let authUrl = null;
  let quotaId = null;
  let userAccountId = null;

  beforeAll(done => {
    resourceManagerService = ResourceManagerV2.newInstance({ serviceName: ResourceManagerV2.DEFAULT_SERVICE_NAME });
    expect(resourceManagerService).not.toBeNull();
    deleteResourceManagerService = ResourceManagerV2.newInstance({ serviceName: 'ALT_RESOURCE_MANAGER' });
    expect(deleteResourceManagerService).not.toBeNull();

    const config = readExternalSources(ResourceManagerV2.DEFAULT_SERVICE_NAME);
    expect(config).not.toBeNull();
    url = config.url;
    authType = config.authType;
    apiKey = config.apiKey;
    authUrl = config.authUrl;
    quotaId = config.quotaId;
    userAccountId = config.userAccountId;

    expect(url).not.toBeNull();
    expect(authType).not.toBeNull();
    expect(apiKey).not.toBeNull();
    expect(authUrl).not.toBeNull();
    expect(quotaId).not.toBeNull();
    expect(userAccountId).not.toBeNull();

    done();
  });

  it('should create a new resource group in an account', done => {
    const params = {
      accountId: userAccountId,
      name: 'TestGroup',
    };
    resourceManagerService
      .createResourceGroup(params)
      .then(response => {
        expect(response.hasOwnProperty('status')).toBe(true);
        expect(response.status).toBe(201);
        newResourceGroupId = response.result.id;
        done();
      })
      .catch(err => {
        done(err);
      });
  });

  it('should get a list of all resource groups in an account', done => {
    const params = {
      accountId: userAccountId,
    };
    resourceManagerService
      .listResourceGroups(params)
      .then(response => {
        expect(response.hasOwnProperty('status')).toBe(true);
        expect(response.status).toBe(200);
        done();
      })
      .catch(err => {
        done(err);
      });
  });

  it('should update a resource group by id', done => {
    const params = {
      id: newResourceGroupId,
      name: 'TestGroup2',
      state: 'ACTIVE',
    };
    resourceManagerService
      .updateResourceGroup(params)
      .then(response => {
        expect(response.hasOwnProperty('status')).toBe(true);
        expect(response.status).toBe(200);
        done();
      })
      .catch(err => {
        done(err);
      });
  });

  it('should retrieve a resource group by id', done => {
    const params = {
      id: newResourceGroupId,
    };
    resourceManagerService
      .getResourceGroup(params)
      .then(response => {
        expect(response.hasOwnProperty('status')).toBe(true);
        expect(response.status).toBe(200);
        done();
      })
      .catch(err => {
        done(err);
      });
  });

  it('should delete a resource group by id', done => {
    const params = {
      id: newResourceGroupId,
    };
    deleteResourceManagerService
      .deleteResourceGroup(params)
      .then(response => {
        expect(response.hasOwnProperty('status')).toBe(true);
        expect(response.status).toBe(204);
        done();
      })
      .catch(err => {
        done(err);
      });
  });

  it('should get a list of all quota definitions', done => {
    resourceManagerService
      .listQuotaDefinitions()
      .then(response => {
        expect(response.hasOwnProperty('status')).toBe(true);
        expect(response.status).toBe(200);
        done();
      })
      .catch(err => {
        done(err);
      });
  });

  it('should get a quota definition by quota id', done => {
    const params = {
      id: quotaId,
    };
    resourceManagerService
      .getQuotaDefinition(params)
      .then(response => {
        expect(response.hasOwnProperty('status')).toBe(true);
        expect(response.status).toBe(200);
        done();
      })
      .catch(err => {
        done(err);
      });
  });
});
