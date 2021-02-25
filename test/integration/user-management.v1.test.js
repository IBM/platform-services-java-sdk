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
const UserManagementV1 = require('../../dist/user-management/v1');
const { readExternalSources } = require('ibm-cloud-sdk-core');
const authHelper = require('../resources/auth-helper.js');

// testcase timeout value (200s).
const timeout = 200000;

// Location of our config file.
const configFile = 'user_management.env';

const describe = authHelper.prepareTests(configFile);

const verbose = true;

describe('UserManagementV1_integration', () => {
  jest.setTimeout(timeout);

  let userManagementService;
  let userManagementAdminService;

  let userId;

  let accountId;
  let iamUserId;
  let invitedUserEmail;
  let viewerRoleId;
  let accessGroupId;

  beforeAll(async done => {
    log('Starting setup...');

    userManagementService = UserManagementV1.newInstance({ serviceName: UserManagementV1.DEFAULT_SERVICE_NAME });
    userManagementAdminService = UserManagementV1.newInstance({ serviceName: 'USER_MANAGEMENT_ADMIN' });
    expect(userManagementService).not.toBeNull();
    expect(userManagementAdminService).not.toBeNull();

    const config = readExternalSources(UserManagementV1.DEFAULT_SERVICE_NAME);
    expect(config).not.toBeNull();

    accountId = config.accountId;
    iamUserId = config.userId;
    invitedUserEmail = config.memberEmail;
    viewerRoleId = config.viewerRoleId;
    accessGroupId = config.accessGroupId;
    expect(accountId).not.toBeNull();
    expect(iamUserId).not.toBeNull();
    expect(invitedUserEmail).not.toBeNull();
    expect(viewerRoleId).not.toBeNull();
    expect(accessGroupId).not.toBeNull();

    log('Finished setup.');

    done();
  });

  test('getUserSettings()', done => {
    const params = {
      accountId: accountId,
      iamId: iamUserId,
    };

    userManagementService
      .getUserSettings(params)
      .then(res => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(200);
        expect(res.result).toBeDefined();
        console.log('getUserSettings() result: ', res.result);
        done();
      })
      .catch(err => {
        console.warn(err);
        done(err);
      });
  });
  test('updateUserSettings()', done => {
    const params = {
      accountId: accountId,
      iamId: iamUserId,
      language: 'French',
      notificationLanguage: 'English',
      allowedIpAddresses: '32.96.110.50,172.16.254.1',
      selfManage: true,
    };

    userManagementService
      .updateUserSettings(params)
      .then(res => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(204);
        done();
      })
      .catch(err => {
        console.warn(err);
        done(err);
      });
  });
  test('listUsers()', async done => {
    const results = [];
    let start = null;

    try {
      do {
        // Retrieve the users, 10 per page to test out pagination.
        const params = {
          accountId: accountId,
          limit: 10,
          start: start,
        };

        const res = await userManagementService.listUsers(params);
        expect(res).toBeDefined();
        expect(res.status).toEqual(200);

        const result = res.result;
        expect(result).toBeDefined();

        // Add the just-retrieved page to "results".
        expect(result.resources).toBeDefined();
        results.push(...result.resources);

        // Determine the offset to use to get the next page.
        if (result.next_url) {
          start = getStartTokenFromURL(result.next_url);
        } else {
          start = null;
        }
      } while (start != null);
    } catch (err) {
      console.log(err);
      done(err);
    }

    // Make sure we found some users.
    const numUsers = results.length;
    console.log(`listUsers() response contained ${numUsers} total users`);
    expect(numUsers).toBeGreaterThan(0);
    done();
  });
  test('inviteUsers()', done => {
    // Request models needed by this operation.

    // InviteUser
    const inviteUserModel = {
      email: invitedUserEmail,
      account_role: 'Member',
    };

    // Role
    const roleModel = {
      role_id: viewerRoleId,
    };

    // Attribute
    const attributeModel = {
      name: 'accountId',
      value: accountId,
    };

    // Attribute
    const attributeModel2 = {
      name: 'resourceGroupId',
      value: '*',
    };

    // Resource
    const resourceModel = {
      attributes: [attributeModel, attributeModel2],
    };

    // InviteUserIamPolicy
    const inviteUserIamPolicyModel = {
      type: 'access',
      roles: [roleModel],
      resources: [resourceModel],
    };

    const params = {
      accountId: accountId,
      users: [inviteUserModel],
      iamPolicy: [inviteUserIamPolicyModel],
      accessGroups: [accessGroupId],
    };

    userManagementAdminService
      .inviteUsers(params)
      .then(res => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(202);
        expect(res.result).toBeDefined();
        console.log('inviteUsers() result: ', res.result);

        expect(res.result.resources).toBeDefined();
        userId = res.result.resources[0].id;
        expect(userId).toBeDefined();
        done();
      })
      .catch(err => {
        console.warn(err);
        done(err);
      });
  });
  test('getUserProfile()', done => {
    const params = {
      accountId: accountId,
      iamId: iamUserId,
    };

    userManagementService
      .getUserProfile(params)
      .then(res => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(200);
        expect(res.result).toBeDefined();
        console.log('getUserProfile() result: ', res.result);
        done();
      })
      .catch(err => {
        console.warn(err);
        done(err);
      });
  });
  test('updateUserProfile()', done => {
    const params = {
      accountId: accountId,
      iamId: iamUserId,
      firstname: 'John',
      lastname: 'Doe',
      state: 'ACTIVE',
      email: 'do_not_delete_user_without_iam_policy_stage@mail.test.ibm.com',
    };

    userManagementService
      .updateUserProfile(params)
      .then(res => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(204);
        done();
      })
      .catch(err => {
        console.warn(err);
        done(err);
      });
  });
  test('removeUser()', done => {
    const params = {
      accountId: accountId,
      iamId: userId,
    };

    userManagementService
      .removeUser(params)
      .then(res => {
        expect(res).not.toBeNull();
        expect(res.status).toEqual(204);
        done();
      })
      .catch(err => {
        console.warn(err);
        done(err);
      });
  });
});

function getStartTokenFromURL(urlstring) {
  let offset = null;
  if (urlstring) {
    // We use a bogus "baseurl" in case "urlstring" is a relative url.
    // This is fine since we're only trying to retrieve the "offset" query parameter.
    const url = new URL(urlstring, 'https://fakehost.com');
    offset = url.searchParams.get('_start');
  }
  return offset;
}

function log(msg) {
  if (verbose) {
    console.log(msg);
  }
}
