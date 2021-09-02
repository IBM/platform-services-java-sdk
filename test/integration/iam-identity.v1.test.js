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
const profileName1 = 'Node-SDK-IT-Profile1';
const profileName2 = 'Node-SDK-IT-Profile2';
const newDescription = 'This is an updated description';
const claimRuleType = 'Profile-SAML';
const realmName = 'https://w3id.sso.ibm.com/auth/sps/samlidp2/saml20';
const invalidAccountId = 'invalid';

let iamIdentityService;
let accountId;
let iamId;
let iamApikey;

let apikeyId1;
let apikeyEtag1;
let apikeyId2;

let serviceId1;
let serviceIdEtag1;

let profileId1;
let profileId2;
let profileIamId;
let profileEtag;

let claimRuleId1;
let claimRuleId2;
let claimRuleEtag;

let linkId;

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

  test('createProfile1()', (done) => {
    const params = {
      name: profileName1,
      description: 'NodeSDK test profile #1',
      accountId,
    };

    iamIdentityService
      .createProfile(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(201);

        const { result } = res;
        expect(result).not.toBeNull();
        profileId1 = result.id;
        profileIamId = result.iam_id;
        expect(profileId1).not.toBeNull();
        done();
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('createProfile2()', (done) => {
    const params = {
      name: profileName2,
      description: 'NodeSDK test profile #2',
      accountId,
    };

    iamIdentityService
      .createProfile(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(201);

        const { result } = res;
        expect(result).not.toBeNull();
        profileId2 = result.id;
        expect(profileId2).not.toBeNull();
        done();
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('getProfile()', (done) => {
    expect(profileId1).toBeDefined();
    expect(profileId1).not.toBeNull();
    const params = {
      profileId: profileId1,
      includeHistory: true,
    };

    iamIdentityService
      .getProfile(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(200);

        const { result } = res;
        expect(result).toBeDefined();

        expect(result.id).toEqual(profileId1);
        expect(result.name).toEqual(profileName1);
        expect(result.iam_id).toEqual(profileIamId);
        expect(result.account_id).toEqual(accountId);
        expect(result.crn).not.toBeNull();

        profileEtag = result.entity_tag;
        expect(profileEtag).not.toBeNull();
        done();
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('listProfiles()', async (done) => {
    const pageSize = 1;
    let pageToken = null;
    const profiles = [];

    try {
      do {
        const params = {
          accountId,
          pagesize: pageSize,
          pagetoken: pageToken,
          includeHistory: false,
        };

        const res = await iamIdentityService.listProfile(params);
        expect(res.status).toEqual(200);

        const { result } = res;
        expect(result.limit).toEqual(pageSize);
        expect(result.profiles).toBeDefined();
        for (const elem of result.profiles) {
          if (elem.name === profileName1 || elem.name === profileName2) {
            profiles.push(elem);
          }
        }
        pageToken = getPageTokenFromURL(result.next);
      } while (pageToken != null);
    } catch (err) {
      console.log(err);
      done(err);
    }

    expect(profiles).toHaveLength(2);
    done();
  });

  test('updateProfile()', (done) => {
    expect(profileId1).toBeDefined();
    expect(profileId1).not.toBeNull();
    expect(profileEtag).toBeDefined();
    expect(profileEtag).not.toBeNull();

    const params = {
      profileId: profileId1,
      ifMatch: profileEtag,
      description: newDescription,
    };

    iamIdentityService
      .updateProfile(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(200);

        const { result } = res;
        expect(result).not.toBeNull();
        expect(result.description).toEqual(newDescription);

        done();
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('deleteProfile1()', async (done) => {
    expect(profileId1).toBeDefined();
    expect(profileId1).not.toBeNull();
    const params = {
      profileId: profileId1,
    };

    iamIdentityService
      .deleteProfile(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(204);

        getProfileById(profileId1).then((profile) => {
          expect(profile).toBeNull();
          done();
        });
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('createClaimRule1()', (done) => {
    const val = "{'cloud-docs-dev'}";
    const profileClaimRuleConditionsModel = {
      claim: 'blueGroups',
      operator: 'EQUALS',
      value: JSON.stringify(val),
    };

    const conditions = [profileClaimRuleConditionsModel];

    const params = {
      profileId: profileId2,
      type: claimRuleType,
      realmName,
      expiration: 43200,
      conditions,
    };

    iamIdentityService
      .createClaimRule(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(201);

        const { result } = res;
        expect(result).not.toBeNull();
        claimRuleId1 = result.id;
        expect(claimRuleId1).not.toBeNull();
        done();
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('createClaimRule2()', (done) => {
    const val = "{'Europe_Group'}";
    const profileClaimRuleConditionsModel = {
      claim: 'blueGroups',
      operator: 'EQUALS',
      value: JSON.stringify(val),
    };

    const conditions = [profileClaimRuleConditionsModel];

    const params = {
      profileId: profileId2,
      type: claimRuleType,
      realmName,
      expiration: 43200,
      conditions,
    };

    iamIdentityService
      .createClaimRule(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(201);

        const { result } = res;
        expect(result).not.toBeNull();
        claimRuleId2 = result.id;
        expect(claimRuleId2).not.toBeNull();
        done();
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('getClaimRule()', (done) => {
    expect(claimRuleId1).toBeDefined();
    expect(claimRuleId1).not.toBeNull();
    const params = {
      profileId: profileId2,
      ruleId: claimRuleId1,
    };

    iamIdentityService
      .getClaimRule(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(200);

        const { result } = res;
        expect(result).toBeDefined();

        expect(result.id).toEqual(claimRuleId1);
        expect(result.type).toEqual(claimRuleType);
        expect(result.realm_name).toEqual(realmName);
        expect(result.conditions).not.toBeNull();

        claimRuleEtag = result.entity_tag;
        expect(claimRuleEtag).not.toBeNull();
        done();
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('listClaimRules()', async (done) => {
    const claimRules = [];
    const params = {
      profileId: profileId2,
    };

    const res = await iamIdentityService.listClaimRules(params);
    expect(res.status).toEqual(200);

    const { result } = res;
    expect(result.rules).toBeDefined();
    for (const elem of result.rules) {
      if (elem.id === claimRuleId1 || elem.id === claimRuleId2) {
        claimRules.push(elem);
      }
    }
    expect(claimRules).toHaveLength(2);
    done();
  });

  test('updateClaimRule()', (done) => {
    expect(claimRuleId1).toBeDefined();
    expect(claimRuleId1).not.toBeNull();
    expect(claimRuleEtag).toBeDefined();
    expect(claimRuleEtag).not.toBeNull();

    const val = "{'Europe_Group'}";
    const profileClaimRuleConditionsModel = {
      claim: 'blueGroups',
      operator: 'EQUALS',
      value: JSON.stringify(val),
    };

    const conditions = [profileClaimRuleConditionsModel];

    const params = {
      profileId: profileId2,
      ruleId: claimRuleId1,
      ifMatch: claimRuleEtag,
      type: claimRuleType,
      realmName,
      expiration: 33200,
      conditions,
    };

    iamIdentityService
      .updateClaimRule(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(200);

        const { result } = res;
        expect(result).not.toBeNull();

        done();
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('deleteClaimRule1()', async (done) => {
    expect(claimRuleId1).toBeDefined();
    expect(claimRuleId1).not.toBeNull();
    const params = {
      profileId: profileId2,
      ruleId: claimRuleId1,
    };

    iamIdentityService
      .deleteClaimRule(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(204);

        getClaimRuleById(profileId2, claimRuleId1).then((claimRule) => {
          expect(claimRule).toBeNull();
          done();
        });
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('createLink()', (done) => {
    const CreateProfileLinkRequestLink = {
      crn: 'crn:v1:staging:public:iam-identity::a/18e3020749ce4744b0b472466d61fdb4::computeresource:Fake-Compute-Resource',
      namespace: 'default',
      name: 'nice name',
    };

    const params = {
      profileId: profileId2,
      name: 'nice link',
      crType: 'ROKS_SA',
      link: CreateProfileLinkRequestLink,
    };

    iamIdentityService
      .createLink(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(201);

        const { result } = res;
        expect(result).not.toBeNull();
        linkId = result.id;
        expect(linkId).not.toBeNull();
        done();
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('getLink()', (done) => {
    expect(linkId).toBeDefined();
    expect(linkId).not.toBeNull();
    const params = {
      profileId: profileId2,
      linkId,
    };

    iamIdentityService
      .getLink(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(200);

        const { result } = res;
        expect(result).toBeDefined();

        expect(result.id).toEqual(linkId);
        expect(result.name).toEqual('nice link');
        expect(result.cr_type).toEqual('ROKS_SA');
        expect(result.link).not.toBeNull();

        done();
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('listLink()', async (done) => {
    const links = [];
    const params = {
      profileId: profileId2,
    };

    const res = await iamIdentityService.listLink(params);
    expect(res.status).toEqual(200);

    const { result } = res;
    expect(result.links).toBeDefined();
    for (const elem of result.links) {
      if (elem.id === linkId) {
        links.push(elem);
      }
    }
    expect(links).toHaveLength(1);
    done();
  });

  test('deleteLink()', async (done) => {
    expect(linkId).toBeDefined();
    expect(linkId).not.toBeNull();
    const params = {
      profileId: profileId2,
      linkId,
    };

    iamIdentityService
      .deleteLink(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(204);

        getLinkById(profileId2, linkId).then((link) => {
          expect(link).toBeNull();
          done();
        });
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('deleteClaimRule2()', async (done) => {
    expect(claimRuleId2).toBeDefined();
    expect(claimRuleId2).not.toBeNull();
    const params = {
      profileId: profileId2,
      ruleId: claimRuleId2,
    };

    iamIdentityService
      .deleteClaimRule(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(204);

        getClaimRuleById(profileId2, claimRuleId2).then((claimRule) => {
          expect(claimRule).toBeNull();
          done();
        });
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('deleteProfile2()', async (done) => {
    expect(profileId2).toBeDefined();
    expect(profileId2).not.toBeNull();
    const params = {
      profileId: profileId2,
    };

    iamIdentityService
      .deleteProfile(params)
      .then((res) => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(204);

        getProfileById(profileId2).then((profile) => {
          expect(profile).toBeNull();
          done();
        });
      })
      .catch((err) => {
        console.warn(err);
        done(err);
      });
  });

  test('createProfileBadRequest()', async () => {
    const params = {
      name: profileName1,
      description: 'NodeSDK test profile #1',
      accountId: invalidAccountId,
    };

    await expect(iamIdentityService.createProfile(params)).rejects.toMatchObject({
      status: 400,
    });
  });

  test('getProfileNotFound()', async () => {
    const params = {
      profileId: 'invalid',
    };

    await expect(iamIdentityService.getProfile(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('updateProfileNotFound()', async () => {
    const params = {
      profileId: 'invalid',
      ifMatch: 'invalid',
      description: 'invalid',
    };

    await expect(iamIdentityService.updateProfile(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('deleteProfileNotFound()', async () => {
    const params = {
      profileId: 'invalid',
    };

    await expect(iamIdentityService.deleteProfile(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('createClaimRuleNotFound()', async () => {
    const val = "{'cloud-docs-dev'}";
    const profileClaimRuleConditionsModel = {
      claim: 'blueGroups',
      operator: 'EQUALS',
      value: JSON.stringify(val),
    };

    const conditions = [profileClaimRuleConditionsModel];

    const params = {
      profileId: 'invalid',
      type: claimRuleType,
      realmName,
      expiration: 43200,
      conditions,
    };

    await expect(iamIdentityService.createClaimRule(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('getClaimRuleNotFound()', async () => {
    const params = {
      profileId: 'invalid',
      ruleId: 'invalid',
    };

    await expect(iamIdentityService.getClaimRule(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('updateClaimRuleNotFound()', async () => {
    const val = "{'Europe_Group'}";
    const profileClaimRuleConditionsModel = {
      claim: 'blueGroups',
      operator: 'EQUALS',
      value: JSON.stringify(val),
    };

    const conditions = [profileClaimRuleConditionsModel];

    const params = {
      profileId: 'invalid',
      ruleId: 'invalid',
      ifMatch: 'invalid',
      type: claimRuleType,
      realmName,
      expiration: 33200,
      conditions,
    };

    await expect(iamIdentityService.updateClaimRule(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('deleteClaimRuleNotFound()', async () => {
    const params = {
      profileId: 'invalid',
      ruleId: 'invalid',
    };

    await expect(iamIdentityService.deleteClaimRule(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('createLinkNotFound()', async () => {
    const CreateProfileLinkRequestLink = {
      crn: 'crn:v1:staging:public:iam-identity::a/18e3020749ce4744b0b472466d61fdb4::computeresource:Fake-Compute-Resource',
      namespace: 'default',
      name: 'nice name',
    };

    const params = {
      profileId: 'invalid',
      name: 'nice link',
      crType: 'ROKS_SA',
      link: CreateProfileLinkRequestLink,
    };

    await expect(iamIdentityService.createLink(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('getLinkNotFound()', async () => {
    const params = {
      profileId: 'invalid',
      linkId: 'invalid',
    };

    await expect(iamIdentityService.getLink(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('deleteLinkNotFound()', async () => {
    const params = {
      profileId: 'invalid',
      linkId: 'invalid',
    };

    await expect(iamIdentityService.deleteLink(params)).rejects.toMatchObject({
      status: 404,
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

  async function getProfileById(profileId) {
    let result = null;
    try {
      const params = {
        profileId,
      };

      const res = await iamIdentityService.getProfile(params);
      if (res != null) {
        result = res.result;
      }
      return result;
    } catch (err) {
      return result;
    }
  }

  async function getClaimRuleById(profileId, claimRuleId) {
    let result = null;
    try {
      const params = {
        profileId,
        ruleId: claimRuleId,
      };

      const res = await iamIdentityService.getClaimRule(params);
      if (res != null) {
        result = res.result;
      }
      return result;
    } catch (err) {
      return result;
    }
  }

  async function getLinkById(profileId, linkId) {
    let result = null;
    try {
      const params = {
        profileId,
        linkId,
      };

      const res = await iamIdentityService.getLink(params);
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

      // list profiles
      const profileParams = {
        accountId,
      };

      const profilesResponse = await iamIdentityService.listProfile(profileParams);
      const profilesResult = profilesResponse.result;
      if (profilesResult.profiles) {
        for (const elem of profilesResult.profiles) {
          console.log('Cleaning profile: ', elem.id);
          const params = {
            profileId: elem.id,
          };
          const response = await iamIdentityService.deleteProfile(params);
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
