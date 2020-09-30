/**
* @jest-environment node
*/
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

const IamIdentityV1 = require('../dist/iam-identity/v1');
const { readExternalSources } = require('ibm-cloud-sdk-core');
const authHelper = require('../test/resources/auth-helper.js');
const { expectToBePromise } = require('ibm-cloud-sdk-core/lib/sdk-test-helpers');

//
// This file provides an example of how to use the IAM-IDENTITY service.
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
// in a "credentials" file and then:
// export IBM_CREDENTIALS_FILE=<name of credentials file>
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

  test('createApiKey request example', done => {

    consoleLogMock.mockImplementation(output => {
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

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
        console.log(JSON.stringify(res.result, null, 2));
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
        console.log(JSON.stringify(res.result, null, 2));
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
        console.log(JSON.stringify(res.result, null, 2));
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
        console.log(JSON.stringify(res.result, null, 2));
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
        console.log(JSON.stringify(res.result, null, 2));
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
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err);
      });

    // end-delete_service_id
  });
});
