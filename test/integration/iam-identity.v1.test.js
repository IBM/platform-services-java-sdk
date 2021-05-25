/* eslint-disable no-console */
/**
 * (C) Copyright IBM Corp. 2020, 2021.
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
const IamIdentityV1 = require('../../dist/iam-identity/v1');
const authHelper = require('../resources/auth-helper.js');

// testcase timeout value (200s).
const timeout = 30000;

// Location of our config file.
const configFile = 'iam_identity.env';

const describe = authHelper.prepareTests(configFile);

const apikeyName = 'Node-SDK-IT-ApiKey';
const serviceIdName = 'Node-SDK-IT-ServiceId';
const newDescription = 'This is an updated description';

let iamIdentityService;
let accountId;
let iamId;
let iamApikey;

let apikeyId1;
let apikeyEtag1;
let apikeyId2;

let serviceId1;
let serviceIdEtag1;

let accountSettingsEtag;

describe('IamIdentityV1_integration', () => {
  jest.setTimeout(timeout);

  beforeAll(async () => {
    console.log('Starting setup...');
    iamIdentityService = IamIdentityV1.newInstance({});
    const config = readExternalSources(IamIdentityV1.DEFAULT_SERVICE_NAME);

    expect(iamIdentityService).not.toBeNull();
    expect(config).not.toBeNull();

    accountId = config.accountId;
    iamId = config.iamId;
    iamApikey = config.apikey;
    expect(accountId).not.toBeNull();
    expect(accountId).toBeDefined();
    expect(iamId).not.toBeNull();
    expect(iamId).toBeDefined();
    expect(iamApikey).not.toBeNull();
    expect(iamApikey).toBeDefined();

    await cleanupResources();

    console.log('Finished setup.');
  });

  afterAll(async () => {
    console.log('Starting teardown...');
    await cleanupResources();
    console.log('Finished teardown!');
  });

  test('createApiKey1()', (done) => {
    const params = {
      name: apikeyName,
      iamId,
      description: 'NodeSDK test apikey #1',
    };

    iamIdentityService
      .createApiKey(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(201);

        const { result } = res;
        expect(result).not.toBeNull();
        // console.log('createApiKey() #1 result: ', result);
        apikeyId1 = result.id;
        expect(apikeyId1).not.toBeNull();
        done();
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('createApiKey2()', (done) => {
    const params = {
      name: apikeyName,
      iamId,
      description: 'NodeSDK test apikey #2',
    };

    iamIdentityService
      .createApiKey(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(201);

        const { result } = res;
        expect(result).not.toBeNull();
        // console.log('createApiKey() #2 result: ', result);

        apikeyId2 = result.id;
        expect(apikeyId2).not.toBeNull();
        done();
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('getApiKey()', (done) => {
    expect(apikeyId1).toBeDefined();
    expect(apikeyId1).not.toBeNull();
    const params = {
      id: apikeyId1,
      includeHistory: true,
    };

    iamIdentityService
      .getApiKey(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(200);

        const { result } = res;
        expect(result).toBeDefined();

        // console.log('getApiKey() result: ', result);
        expect(result.id).toEqual(apikeyId1);
        expect(result.name).toEqual(apikeyName);
        expect(result.iam_id).toEqual(iamId);
        expect(result.account_id).toEqual(accountId);
        expect(result.created_by).toEqual(iamId);
        expect(result.created_at).not.toBeNull();
        expect(result.locked).toEqual(false);
        expect(result.crn).not.toBeNull();

        apikeyEtag1 = result.entity_tag;
        expect(apikeyEtag1).not.toBeNull();
        done();
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('getApiKeysDetails()', (done) => {
    const params = {
      iamApiKey: iamApikey,
      includeHistory: true,
    };

    iamIdentityService
      .getApiKeysDetails(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(200);

        const { result } = res;
        // console.log('getApikeysDetails() result: ', result);

        expect(result.iam_id).toEqual(iamId);
        expect(result.account_id).toEqual(accountId);
        expect(result.created_by).toEqual(iamId);
        expect(result.created_at).not.toBeNull();
        expect(result.locked).toEqual(false);

        done();
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('listApiKeys()', async (done) => {
    const pageSize = 1;
    let pageToken = null;
    const apikeys = [];

    try {
      // Retrieve 1 apikey at a time to test the pagination.
      do {
        const params = {
          accountId,
          iamId,
          pagesize: pageSize,
          pagetoken: pageToken,
          includeHistory: true,
        };

        const res = await iamIdentityService.listApiKeys(params);
        expect(res.status).toEqual(200);

        const { result } = res;
        // console.log('listApiKeys() result: ', result);
        expect(result.limit).toEqual(pageSize);
        expect(result.apikeys).toBeDefined();
        for (const elem of result.apikeys) {
          if (elem.name === apikeyName) {
            apikeys.push(elem);
          }
        }
        pageToken = getPageTokenFromURL(result.next);
      } while (pageToken != null);
    } catch (err) {
      console.log(err);
      done(err);
    }

    // Make sure we found the two apikeys that we created previously.
    expect(apikeys).toHaveLength(2);
    done();
  });

  test('updateApiKey()', (done) => {
    expect(apikeyId1).toBeDefined();
    expect(apikeyId1).not.toBeNull();
    expect(apikeyEtag1).toBeDefined();
    expect(apikeyEtag1).not.toBeNull();

    const params = {
      id: apikeyId1,
      ifMatch: apikeyEtag1,
      description: newDescription,
    };

    iamIdentityService
      .updateApiKey(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(200);

        const { result } = res;
        // console.log('updateApiKey() result: ', result);
        expect(result).not.toBeNull();
        expect(result.description).toEqual(newDescription);

        done();
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('lockApiKey()', async (done) => {
    expect(apikeyId2).toBeDefined();
    expect(apikeyId2).not.toBeNull();
    const params = {
      id: apikeyId2,
    };

    iamIdentityService
      .lockApiKey(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(204);

        getApiKeyById(apikeyId2).then((apikey) => {
          expect(apikey.locked).toBe(true);
          done();
        });
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('unlockApiKey()', async (done) => {
    expect(apikeyId2).toBeDefined();
    expect(apikeyId2).not.toBeNull();
    const params = {
      id: apikeyId2,
    };

    iamIdentityService
      .unlockApiKey(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(204);

        getApiKeyById(apikeyId2).then((apikey) => {
          expect(apikey.locked).toBe(false);
          done();
        });
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('deleteApiKey1()', async (done) => {
    expect(apikeyId1).toBeDefined();
    expect(apikeyId1).not.toBeNull();
    const params = {
      id: apikeyId1,
    };

    iamIdentityService
      .deleteApiKey(params)
      .then((res) => {
        expect(res).not.toBeNull();
        // console.log('deleteApiKey() #1 response: ', res);
        expect(res.status).toEqual(204);

        getApiKeyById(apikeyId1).then((apikey) => {
          expect(apikey).toBeNull();
          done();
        });
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('deleteApiKey2()', async (done) => {
    expect(apikeyId2).toBeDefined();
    expect(apikeyId2).not.toBeNull();
    const params = {
      id: apikeyId2,
    };

    iamIdentityService
      .deleteApiKey(params)
      .then((res) => {
        expect(res).not.toBeNull();
        // console.log('deleteApiKey() #2 response: ', res);
        expect(res.status).toEqual(204);

        getApiKeyById(apikeyId1).then((apikey) => {
          expect(apikey).toBeNull();
          done();
        });
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('createServiceId()', (done) => {
    const params = {
      accountId,
      name: serviceIdName,
      description: 'NodeSDK ServiceId desc',
    };

    iamIdentityService
      .createServiceId(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(201);

        const { result } = res;
        expect(result).not.toBeNull();
        // console.log('createServiceId() result: ', result);
        expect(result.id).not.toBeNull();
        serviceId1 = result.id;
        expect(serviceId1).not.toBeNull();
        done();
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('getServiceId()', (done) => {
    expect(serviceId1).toBeDefined();
    expect(serviceId1).not.toBeNull();
    const params = {
      id: serviceId1,
      includeHistory: true,
    };

    iamIdentityService
      .getServiceId(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(200);

        const { result } = res;
        // console.log('getServiceId() result: ', result);
        expect(result).not.toBeNull();
        expect(result.id).toEqual(serviceId1);
        expect(result.name).toEqual(serviceIdName);
        expect(result.description).toEqual('NodeSDK ServiceId desc');

        serviceIdEtag1 = result.entity_tag;
        expect(serviceIdEtag1).not.toBeNull();
        done();
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('listServiceIds()', (done) => {
    const params = {
      accountId,
      name: serviceIdName,
      pagesize: 100,
    };

    iamIdentityService
      .listServiceIds(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(200);

        const { result } = res;
        expect(result).not.toBeNull();
        // console.log('listServiceIds() result: ', result);

        expect(result.serviceids).toHaveLength(1);
        expect(result.offset).not.toBeNull();
        expect(result.offset).toEqual(0);
        expect(result.next).toBeUndefined();

        done();
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('updateServiceId()', (done) => {
    expect(serviceId1).toBeDefined();
    expect(serviceId1).not.toBeNull();
    const params = {
      id: serviceId1,
      ifMatch: serviceIdEtag1,
      description: newDescription,
    };

    iamIdentityService
      .updateServiceId(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(200);

        const { result } = res;
        expect(result).not.toBeNull();
        // console.log('updateServiceId() result: ', result);

        expect(result.description).toEqual(newDescription);
        done();
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('lockServiceId()', (done) => {
    expect(serviceId1).toBeDefined();
    expect(serviceId1).not.toBeNull();
    const params = {
      id: serviceId1,
    };

    iamIdentityService
      .lockServiceId(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(204);

        getServiceId(serviceId1).then((serviceId) => {
          expect(serviceId.locked).toBe(true);
          done();
        });
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('unlockServiceId()', (done) => {
    expect(serviceId1).toBeDefined();
    expect(serviceId1).not.toBeNull();
    const params = {
      id: serviceId1,
    };

    iamIdentityService
      .unlockServiceId(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(204);

        getServiceId(serviceId1).then((serviceId) => {
          expect(serviceId.locked).toBe(false);
          done();
        });
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('deleteServiceId()', async (done) => {
    expect(serviceId1).toBeDefined();
    expect(serviceId1).not.toBeNull();
    const params = {
      id: serviceId1,
    };

    iamIdentityService
      .deleteServiceId(params)
      .then((res) => {
        expect(res).not.toBeNull();
        // console.log('deleteServiceId() response: ', res);
        expect(res.status).toEqual(204);

        getServiceId(serviceId1).then((serviceId) => {
          expect(serviceId).toBeNull();
          done();
        });
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });
  test('getAccountSettings()', (done) => {
    expect(accountSettingsEtag).toBeUndefined();
    const params = {
      accountId,
      includeHistory: false,
    };

    iamIdentityService
      .getAccountSettings(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(200);
        expect(res).toBeDefined();

        const { result } = res;
        expect(result).toBeDefined();

        // console.log('getAccountSettings() result: ', result);
        expect(result.account_id).toEqual(accountId);
        expect(result.restrict_create_service_id).toBeDefined();
        expect(result.restrict_create_platform_apikey).toBeDefined();
        expect(result.entity_tag).toBeDefined();
        expect(result.mfa).toBeDefined();
        expect(result.history).toBeDefined();
        expect(result.session_expiration_in_seconds).toBeDefined();
        expect(result.session_invalidation_in_seconds).toBeDefined();

        accountSettingsEtag = result.entity_tag;
        expect(accountSettingsEtag).not.toBeNull();
        done();
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });
  test('updateAccountSettings()', (done) => {
    expect(accountSettingsEtag).toBeDefined();
    const params = {
      ifMatch: accountSettingsEtag,
      accountId,
      restrict_create_service_id: 'NOT_RESTRICTED',
      restrict_create_platform_apikey: 'NOT_RESTRICTED',
      // allowedIpAddresses: 'testString',
      mfa: 'NONE',
      session_expiration_in_seconds: '86400',
      session_invalidation_in_seconds: '7200',
      maxSessionPerIdentity: '10',
    };

    iamIdentityService
      .updateAccountSettings(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(200);

        const { result } = res;
        expect(res).toBeDefined();
        expect(res.result).toBeDefined();

        // console.log('updateAccountSettings() result: ', result);
        expect(result.account_id).toEqual(accountId);
        expect(result.entity_tag).toEqual(res.headers.etag);
        expect(result.restrict_create_service_id).toEqual(params.restrict_create_service_id);
        expect(result.restrict_create_platform_apikey).toEqual(
          params.restrict_create_platform_apikey
        );
        expect(result.mfa).toEqual(params.mfa);
        expect(result.session_expiration_in_seconds).toEqual(params.session_expiration_in_seconds);
        expect(result.session_invalidation_in_seconds).toEqual(
          params.session_invalidation_in_seconds
        );
        done();
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  function getPageTokenFromURL(urlstring) {
    let pageToken = null;
    if (urlstring) {
      // We use a bogus "baseurl" in case "urlstring" is a relative url.
      // This is fine since we're only trying to retrieve the "offset" query parameter.
      const url = new URL(urlstring, 'https://fakehost.com');
      pageToken = url.searchParams.get('pagetoken');
    }
    return pageToken;
  }

  async function getApiKeyById(apikeyId) {
    let result = null;
    try {
      const params = {
        id: apikeyId,
      };

      const res = await iamIdentityService.getApiKey(params);
      if (res != null) {
        result = res.result;
      }
      return result;
    } catch (err) {
      return result;
    }
  }

  async function getServiceId(serviceId) {
    let result = null;
    try {
      const params = {
        id: serviceId,
      };

      const res = await iamIdentityService.getServiceId(params);
      if (res != null) {
        result = res.result;
      }
      return result;
    } catch (err) {
      return result;
    }
  }

  async function cleanupResources() {
    console.log('Cleaning resources...');

    try {
      // list apikeys
      const apikeyParams = {
        accountId,
        iamId,
        pagesize: 100,
      };

      const apikeyResponse = await iamIdentityService.listApiKeys(apikeyParams);
      const apikeyResult = apikeyResponse.result;
      if (apikeyResult.apikeys) {
        for (const elem of apikeyResult.apikeys) {
          if (elem.name === apikeyName) {
            console.log('>>> Cleaning apikey: ', elem.id);
            const params = {
              id: elem.id,
            };
            const response = await iamIdentityService.deleteApiKey(params);
            expect(response).not.toBeNull();
            expect(response.status).toEqual(204);
          }
        }
      }

      // list serviceIds
      const serviceidParams = {
        accountId,
        name: serviceIdName,
        pagesize: 100,
      };

      const serviceidResponse = await iamIdentityService.listServiceIds(serviceidParams);
      const serviceidResult = serviceidResponse.result;
      if (serviceidResult.serviceids) {
        for (const elem of serviceidResult.serviceids) {
          console.log('Cleaning serviceId: ', elem.id);
          const params = {
            id: elem.id,
          };
          const response = await iamIdentityService.deleteServiceId(params);
          expect(response).not.toBeNull();
          expect(response.status).toEqual(204);
        }
      }
      console.log('Finished cleaning resources!');
    } catch (err) {
      console.log(err);
      throw err;
    }
  }
});
