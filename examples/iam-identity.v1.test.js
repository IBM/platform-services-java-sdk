/**
* @jest-environment node
*/
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
'use strict';

const IamIdentityV1 = require('../dist/iam-identity/v1');
const { readExternalSources } = require('ibm-cloud-sdk-core');
const authHelper = require('../test/resources/auth-helper.js');
const { expectToBePromise } = require('ibm-cloud-sdk-core/lib/sdk-test-helpers');

//
// This file provides an example of how to use the IAM Identity service.
//
// The following configuration properties are assumed to be defined:
//
// IAM_IDENTITY_URL=<service url>
// IAM_IDENTITY_AUTHTYPE=iam
// IAM_IDENTITY_AUTH_URL=<IAM Token Service url>
// IAM_IDENTITY_APIKEY=<IAM APIKEY for the User>
// IAM_IDENTITY_ACCOUNT_ID=<AccountID which is unique to the User>
// IAM_IDENTITY_IAM_ID=<IAM ID which is unique to the User account>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
const configFile = 'iam_identity.env';

const describe = authHelper.prepareTests(configFile);

// Save original console.log and console.warn
const originalLog = console.log
const originalWarn = console.warn

// Mocks for console.log and console.warn
const consoleLogMock = jest.spyOn(console, 'log');
const consoleWarnMock = jest.spyOn(console, 'warn');

describe('IamIdentityV1', () => {
  jest.setTimeout(30000);

  // begin-common

  const iamIdentityService = IamIdentityV1.newInstance({});

  // end-common

  const config = readExternalSources(IamIdentityV1.DEFAULT_SERVICE_NAME);
  const apikeyName = 'Example-ApiKey';
  const serviceIdName = 'Example-ServiceId';

  let accountId = config.accountId;
  let iamId = config.iamId;
  let iamApikey = config.apikey;

  let apikeyId = null;
  let apikeyEtag = null;

  let svcId = null;
  let svcIdEtag = null;

  let profileId= null;
  let profileEtag = null;

  let claimRuleId = null;
  let claimRuleEtag = null;

  let linkId =null;

  let accountSettingsEtag = null;

  test('createApiKey request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });
  
    originalLog('createApiKey() result:');
    // begin-create_api_key

    const params = {
      name: apikeyName,
      iamId: iamId,
      description: 'Example ApiKey',
    };

    iamIdentityService.createApiKey(params)
      .then(res => {
        apikeyId = res.result.id
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err);
      });

    // end-create_api_key
  });
  test('listApiKeys request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });
  
    originalLog('listApiKeys() result:');
    // begin-list_api_keys

    const params = {
      accountId: accountId,
      iamId: iamId,
      includeHistory: true,
    };

    iamIdentityService.listApiKeys(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err);
      });

    // end-list_api_keys
  });
  test('getApiKeysDetails request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });
  
    originalLog('getApiKeysDetails() result:');
    // begin-get_api_keys_details

    const params = {
      iamApiKey: iamApikey,
      includeHistory: false,
    };

    iamIdentityService.getApiKeysDetails(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err);
      });

    // end-get_api_keys_details
  });
  test('getApiKey request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(apikeyId).not.toBeNull();
  
    originalLog('getApiKey() result:');
    // begin-get_api_key

    const params = {
      id: apikeyId,
    };

    iamIdentityService.getApiKey(params)
      .then(res => {
        apikeyEtag = res.headers['etag'];
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err);
      });

    // end-get_api_key
  });
  test('updateApiKey request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(apikeyId).not.toBeNull();
    expect(apikeyEtag).not.toBeNull();
  
    originalLog('updateApiKey() result:');
    // begin-update_api_key

    const params = {
      id: apikeyId,
      ifMatch: apikeyEtag,
      description: 'This is an updated description',
    };

    iamIdentityService.updateApiKey(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err);
      });

    // end-update_api_key
  });
  test('lockApiKey request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(apikeyId).not.toBeNull();

    // begin-lock_api_key

    const params = {
      id: apikeyId,
    };

    iamIdentityService.lockApiKey(params)
      .then(res => {
        done();
      })
      .catch(err => {
        console.warn(err);
      });

    // end-lock_api_key
  });
  test('unlockApiKey request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(apikeyId).not.toBeNull();

    // begin-unlock_api_key

    const params = {
      id: apikeyId,
    };

    iamIdentityService.unlockApiKey(params)
      .then(res => {
        done();
      })
      .catch(err => {
        console.warn(err);
      });

    // end-unlock_api_key
  });
  test('deleteApiKey request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(apikeyId).not.toBeNull();

    // begin-delete_api_key

    const params = {
      id: apikeyId,
    };

    iamIdentityService.deleteApiKey(params)
      .then(res => {
        done();
      })
      .catch(err => {
        console.warn(err);
      });

    // end-delete_api_key
  });
  test('createServiceId request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });
  
    originalLog('createServiceId() result:');
    // begin-create_service_id

    const params = {
      accountId: accountId,
      name: serviceIdName,
      description: 'Example ServiceId',
    };

    iamIdentityService.createServiceId(params)
      .then(res => {
        svcId = res.result.id;
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err);
      });

    // end-create_service_id
  });
  test('getServiceId request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(svcId).not.toBeNull();
  
    originalLog('getServiceId() result:');
    // begin-get_service_id

    const params = {
      id: svcId,
    };

    iamIdentityService.getServiceId(params)
      .then(res => {
        svcIdEtag = res.headers['etag'];
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err);
      });

    // end-get_service_id
  });
  test('listServiceIds request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });
  
    originalLog('listServiceIds() result:');
    // begin-list_service_ids

    const params = {
      accountId: accountId,
      name: serviceIdName,
    };

    iamIdentityService.listServiceIds(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err);
      });

    // end-list_service_ids
  });
  test('updateServiceId request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(svcId).not.toBeNull();
    expect(svcIdEtag).not.toBeNull();
  
    originalLog('updateServiceId() result:');
    // begin-update_service_id

    const params = {
      id: svcId,
      ifMatch: svcIdEtag,
      description: 'This is an updated description',
    };

    iamIdentityService.updateServiceId(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err);
      });

    // end-update_service_id
  });
  test('lockServiceId request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(svcId).not.toBeNull();

    // begin-lock_service_id

    const params = {
      id: svcId,
    };

    iamIdentityService.lockServiceId(params)
      .then(res => {
        done();
      })
      .catch(err => {
        console.warn(err);
      });

    // end-lock_service_id
  });
  test('unlockServiceId request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(svcId).not.toBeNull();

    // begin-unlock_service_id

    const params = {
      id: svcId,
    };

    iamIdentityService.unlockServiceId(params)
      .then(res => {
        done();
      })
      .catch(err => {
        console.warn(err);
        done(err);
      });

    // end-unlock_service_id
  });
  test('deleteServiceId request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(svcId).not.toBeNull();

    // begin-delete_service_id

    const params = {
      id: svcId,
    };

    iamIdentityService.deleteServiceId(params)
      .then(res => {
        done();
      })
      .catch(err => {
        console.warn(err);
      });

    // end-delete_service_id
  });
  test('createProfile request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });
  
    originalLog('createProfile() result:');
    // begin-create_profile

    const params = {
      name: 'profileName',
      description: 'Example Profile',
      accountId,
    };

    iamIdentityService.createProfile(params)
      .then(res => {
        profileId = res.result.id
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err);
      });

    // end-create_profile
  });
  test('getProfile request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });
  
    originalLog('getProfile() result:');
    // begin-get_profile

    const params = {
      profileId,
    };

    iamIdentityService.getProfile(params)
      .then(res => {
        profileEtag = res.headers['etag'];
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err);
      });

    // end-get_profile
  });
  test('listProfiles request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });
  
    originalLog('listProfiles() result:');
    // begin-list_profiles

    const params = {
      accountId: accountId,
      includeHistory: false,
    };

    iamIdentityService.listProfile(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err);
      });

    // end-list_profiles
  });
  test('updateProfile request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(apikeyId).not.toBeNull();
    expect(apikeyEtag).not.toBeNull();
  
    originalLog('updateProfile() result:');
    // begin-update_profile

    const params = {
      profileId: profileId,
      ifMatch: profileEtag,
      description: 'This is an updated description',
    };

    iamIdentityService.updateProfile(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err);
      });

    // end-update_profile
  });
  test('createClaimRule request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });
  
    originalLog('createClaimRule() result:');
    // begin-create_claimRule

    const val = "{'Europe_Group'}";
    const profileClaimRuleConditionsModel = {
      claim: 'blueGroups',
      operator: 'EQUALS',
      value: JSON.stringify(val),
    };

    const conditions = [profileClaimRuleConditionsModel];

    const params = {
      profileId: profileId,
      type: 'Profile-SAML',
      realmName: 'https://w3id.sso.ibm.com/auth/sps/samlidp2/saml20',
      expiration: 43200,
      conditions,
    };

    iamIdentityService.createClaimRule(params)
      .then(res => {
        claimRuleId = res.result.id
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err);
      });

    // end-create_claimRule
  });
  test('getClaimRule request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });
  
    originalLog('getClaimRule() result:');
    // begin-get_claimRule

    const params = {
      profileId,
      ruleId: claimRuleId,
    };

    iamIdentityService.getClaimRule(params)
      .then(res => {
        claimRuleEtag = res.headers['etag'];
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err);
      });

    // end-get_claimRule
  });
  test('listClaimRules request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });
  
    originalLog('listClaimRules() result:');
    // begin-list_claimRules

    const params = {
      profileId,
    };

    iamIdentityService.listClaimRules(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err);
      });

    // end-list_claimRules
  });
  test('updateClaimRule request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(apikeyId).not.toBeNull();
    expect(apikeyEtag).not.toBeNull();
  
    originalLog('updateClaimRule() result:');
    // begin-update_claimRule

    const val = "{'Europe_Group'}";
    const profileClaimRuleConditionsModel = {
      claim: 'blueGroups',
      operator: 'EQUALS',
      value: JSON.stringify(val),
    };

    const conditions = [profileClaimRuleConditionsModel];

    const params = {
      profileId,
      ruleId: claimRuleId,
      ifMatch: claimRuleEtag,
      type: 'Profile-SAML',
      realmName:'https://w3id.sso.ibm.com/auth/sps/samlidp2/saml20',
      expiration: 33200,
      conditions,
    };

    iamIdentityService.updateClaimRule(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err);
      });

    // end-update_claimRule
  });
  test('deleteClaimRule request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(profileId).not.toBeNull();
    expect(claimRuleId).not.toBeNull();

    // begin-delete_claimRule

    const params = {
      profileId,
      ruleId: claimRuleId,
    };

    iamIdentityService.deleteClaimRule(params)
      .then(res => {
        done();
      })
      .catch(err => {
        console.warn(err);
      });

    // end-delete_claimRule
  });
  test('createLink request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });
  
    originalLog('createLink() result:');
    // begin-create_link

    const CreateProfileLinkRequestLink = {
      crn: 'crn:v1:staging:public:iam-identity::a/18e3020749ce4744b0b472466d61fdb4::computeresource:Fake-Compute-Resource',
      namespace: 'default',
      name: 'nice name',
    };

    const params = {
      profileId: profileId,
      name: 'nice link',
      crType: 'ROKS_SA',
      link: CreateProfileLinkRequestLink,
    };

    iamIdentityService.createLink(params)
      .then(res => {
        linkId = res.result.id
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err);
      });

    // end-create_link
  });
  test('getLink request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });
  
    originalLog('getLink() result:');
    // begin-get_link

    const params = {
      profileId: profileId,
      linkId,
    };

    iamIdentityService.getLink(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err);
      });

    // end-get_link
  });
  test('listLinks request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });
  
    originalLog('listLinks() result:');
    // begin-list_links

    const params = {
      profileId,
    };

    iamIdentityService.listLink(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err);
      });

    // end-list_links
  });
  test('deleteLink request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(profileId).not.toBeNull();
    expect(linkId).not.toBeNull();

    // begin-delete_link

    const params = {
      profileId,
      linkId,
    };

    iamIdentityService.deleteLink(params)
      .then(res => {
        done();
      })
      .catch(err => {
        console.warn(err);
      });

    // end-delete_link
  });
  test('deleteProfile request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(profileId).not.toBeNull();

    // begin-delete_profile

    const params = {
      profileId
    };

    iamIdentityService.deleteProfile(params)
      .then(res => {
        done();
      })
      .catch(err => {
        console.warn(err);
      });

    // end-delete_profile
  });
  test('getAccountSettings request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(accountSettingsEtag).toBeNull();
  
    originalLog('getAccountSettings() result:');
    // begin-getAccountSettings

    const params = {
      accountId: accountId,
    };

    iamIdentityService.getAccountSettings(params)
      .then(res => {
        accountSettingsEtag = res.headers['etag'];
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-getAccountSettings
  });
  test('updateAccountSettings request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(accountSettingsEtag).not.toBeNull();
  
    originalLog('updateAccountSettings() result:');
    // begin-updateAccountSettings

    const params = {
      ifMatch: accountSettingsEtag,
      accountId: accountId,
      restrict_create_service_id: "NOT_RESTRICTED",
      restrict_create_platform_apikey: "NOT_RESTRICTED",
      mfa: "NONE",
      session_expiration_in_seconds: "86400",
      session_invalidation_in_seconds: "7200",
    };

    iamIdentityService.updateAccountSettings(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-updateAccountSettings
  });
});
