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
'use strict';

// need to import the whole package to mock getAuthenticatorFromEnvironment
const core = require('ibm-cloud-sdk-core');
const { NoAuthAuthenticator, unitTestUtils } = core;

const IbmCloudShellV1 = require('../../dist/ibm-cloud-shell/v1');

const {
  getOptions,
  checkUrlAndMethod,
  checkMediaHeaders,
  expectToBePromise,
} = unitTestUtils;

const ibmCloudShellServiceOptions = {
  authenticator: new NoAuthAuthenticator(),
  url: 'https://api.shell.cloud.ibm.com',
};

const ibmCloudShellService = new IbmCloudShellV1(ibmCloudShellServiceOptions);

// dont actually create a request
const createRequestMock = jest.spyOn(ibmCloudShellService, 'createRequest');
createRequestMock.mockImplementation(() => Promise.resolve());

// dont actually construct an authenticator
const getAuthenticatorMock = jest.spyOn(core, 'getAuthenticatorFromEnvironment');
getAuthenticatorMock.mockImplementation(() => new NoAuthAuthenticator());

afterEach(() => {
  createRequestMock.mockClear();
  getAuthenticatorMock.mockClear();
});

describe('IbmCloudShellV1', () => {
  describe('the newInstance method', () => {
    test('should use defaults when options not provided', () => {
      const testInstance = IbmCloudShellV1.newInstance();

      expect(getAuthenticatorMock).toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceName).toBe(IbmCloudShellV1.DEFAULT_SERVICE_NAME);
      expect(testInstance.baseOptions.serviceUrl).toBe(IbmCloudShellV1.DEFAULT_SERVICE_URL);
      expect(testInstance).toBeInstanceOf(IbmCloudShellV1);
    });

    test('should set serviceName, serviceUrl, and authenticator when provided', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
        serviceName: 'my-service',
      };

      const testInstance = IbmCloudShellV1.newInstance(options);

      expect(getAuthenticatorMock).not.toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
      expect(testInstance.baseOptions.serviceName).toBe('my-service');
      expect(testInstance).toBeInstanceOf(IbmCloudShellV1);
    });
  });
  describe('the constructor', () => {
    test('use user-given service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
      };

      const testInstance = new IbmCloudShellV1(options);

      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
    });

    test('use default service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
      };

      const testInstance = new IbmCloudShellV1(options);

      expect(testInstance.baseOptions.serviceUrl).toBe(IbmCloudShellV1.DEFAULT_SERVICE_URL);
    });
  });
  describe('getAccountSettings', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getAccountSettings
        const accountId = '12345678-abcd-1a2b-a1b2-1234567890ab';
        const params = {
          accountId: accountId,
        };

        const getAccountSettingsResult = ibmCloudShellService.getAccountSettings(params);

        // all methods should return a Promise
        expectToBePromise(getAccountSettingsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/api/v1/user/accounts/{account_id}/settings', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['account_id']).toEqual(accountId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountId = '12345678-abcd-1a2b-a1b2-1234567890ab';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        ibmCloudShellService.getAccountSettings(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await ibmCloudShellService.getAccountSettings({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getAccountSettingsPromise = ibmCloudShellService.getAccountSettings();
        expectToBePromise(getAccountSettingsPromise);

        getAccountSettingsPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('updateAccountSettings', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // Feature
      const featureModel = [
        {
          enabled: true,
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
          enabled: true,
          key: 'jp-tok',
        },
        {
          enabled: true,
          key: 'us-south',
        },
      ];

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation updateAccountSettings
        const accountId = '12345678-abcd-1a2b-a1b2-1234567890ab';
        const rev = '130-12345678-abcd-1a2b-a1b2-1234567890ab';
        const defaultEnableNewFeatures = true;
        const defaultEnableNewRegions = true;
        const enabled = true;
        const features = featureModel;
        const regions = regionSettingModel;
        const params = {
          accountId: accountId,
          rev: rev,
          defaultEnableNewFeatures: defaultEnableNewFeatures,
          defaultEnableNewRegions: defaultEnableNewRegions,
          enabled: enabled,
          features: features,
          regions: regions,
        };

        const updateAccountSettingsResult = ibmCloudShellService.updateAccountSettings(params);

        // all methods should return a Promise
        expectToBePromise(updateAccountSettingsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/api/v1/user/accounts/{account_id}/settings', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['_rev']).toEqual(rev);
        expect(options.body['default_enable_new_features']).toEqual(defaultEnableNewFeatures);
        expect(options.body['default_enable_new_regions']).toEqual(defaultEnableNewRegions);
        expect(options.body['enabled']).toEqual(enabled);
        expect(options.body['features']).toEqual(features);
        expect(options.body['regions']).toEqual(regions);
        expect(options.path['account_id']).toEqual(accountId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountId = '12345678-abcd-1a2b-a1b2-1234567890ab';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        ibmCloudShellService.updateAccountSettings(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await ibmCloudShellService.updateAccountSettings({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const updateAccountSettingsPromise = ibmCloudShellService.updateAccountSettings();
        expectToBePromise(updateAccountSettingsPromise);

        updateAccountSettingsPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
});
