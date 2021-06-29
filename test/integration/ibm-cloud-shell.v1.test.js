/* eslint-disable no-console */
/**
 * (C) Copyright IBM Corp. 2021.
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
const IbmCloudShellV1 = require('../../dist/ibm-cloud-shell/v1');
const authHelper = require('../resources/auth-helper.js');

// testcase timeout value (200s).
const timeout = 200000;

// Location of our config file.
const configFile = 'ibm_cloud_shell_v1.env';

const describe = authHelper.prepareTests(configFile);

describe('IbmCloudShellV1_integration', () => {
  const ibmCloudShellService = IbmCloudShellV1.newInstance({});

  expect(ibmCloudShellService).not.toBeNull();

  const config = readExternalSources(IbmCloudShellV1.DEFAULT_SERVICE_NAME);
  expect(config).not.toBeNull();

  jest.setTimeout(timeout);

  const { accountId } = config;
  expect(accountId).not.toBeNull();

  test('getAccountSettings()', async () => {
    const params = {
      accountId,
    };

    const res = await ibmCloudShellService.getAccountSettings(params);
    expect(res).toBeDefined();
    expect(res.result).toBeDefined();
    expect(res.status).toEqual(200);
  });
  test('updateAccountSettings()', async () => {
    const getRes = await ibmCloudShellService.getAccountSettings({
      accountId,
    });
    const existingAccountSettings = getRes.result;
    // Request models needed by this operation.

    // Feature
    const featureModel = [
      {
        enabled: false,
        key: 'server.file_manager',
      },
      {
        enabled: true,
        key: 'server.web_preview',
      },
    ];

    // RegionSetting
    const regionSettingModel = [
      {
        enabled: true,
        key: 'eu-de',
      },
      {
        enabled: false,
        key: 'jp-tok',
      },
      {
        enabled: false,
        key: 'us-south',
      },
    ];

    const params = {
      accountId,
      rev: existingAccountSettings._rev,
      defaultEnableNewFeatures: false,
      defaultEnableNewRegions: true,
      enabled: true,
      features: featureModel,
      regions: regionSettingModel,
    };

    const res = await ibmCloudShellService.updateAccountSettings(params);
    expect(res).toBeDefined();
    expect(res.result).toBeDefined();
    expect(res.status).toEqual(200);
    expect(res.result.default_enable_new_features).toEqual(false);
    expect(res.result.default_enable_new_regions).toEqual(true);
    expect(res.result.enabled).toEqual(true);
    expect(res.result.features).toEqual(featureModel);
    expect(res.result.regions).toEqual(regionSettingModel);
  });
});
