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
const authHelper = require('../resources/auth-helper.js');

// testcase timeout value (200s).
const timeout = 200000;

// Location of our config file.
const configFile = 'user_management.env';

const describe = authHelper.prepareTests(configFile);

let userId;

describe('UserManagementV1_integration', () => {
  const userManagementService = UserManagementV1.newInstance({ serviceName: 'USERMGMT1' });
  const alternateUserManagementService = UserManagementV1.newInstance({ serviceName: 'USERMGMT2' });

  jest.setTimeout(timeout);

  test('getUserSettings()', done => {
    const params = {
      accountId: '1aa434630b594b8a88b961a44c9eb2a9',
      iamId: 'IBMid-550008BJPR',
    };

    userManagementService
      .getUserSettings(params)
      .then(res => {
        done();
      })
      .catch(err => {
        console.warn(err);
        done(err);
      });
  });
  test('updateUserSettings()', done => {
    const params = {
      accountId: '1aa434630b594b8a88b961a44c9eb2a9',
      iamId: 'IBMid-550008BJPR',
      language: 'testString',
      notificationLanguage: 'testString',
      allowedIpAddresses: '32.96.110.50,172.16.254.1',
      selfManage: true,
    };

    userManagementService
      .updateUserSettings(params)
      .then(res => {
        done();
      })
      .catch(err => {
        console.warn(err);
        done(err);
      });
  });
  test('listUsers()', done => {
    const params = {
      accountId: '1aa434630b594b8a88b961a44c9eb2a9',
      state: 'ACTIVE',
    };

    userManagementService
      .listUsers(params)
      .then(res => {
        done();
      })
      .catch(err => {
        console.warn(err);
        done(err);
      });
  });
  test('inviteUsers()', done => {
    // Request models needed by this operation.

    // InviteUser
    const inviteUserModel = {
      email: 'aminttest+linked_account_owner_11@mail.test.ibm.com',
      account_role: 'Member',
    };

    // Role
    const roleModel = {
      role_id: 'crn:v1:bluemix:public:iam::::role:Viewer',
    };

    // Attribute
    const attributeModel = {
      name: 'accountId',
      value: '1aa434630b594b8a88b961a44c9eb2a9',
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
      accountId: '1aa434630b594b8a88b961a44c9eb2a9',
      users: [inviteUserModel],
      iamPolicy: [inviteUserIamPolicyModel],
      accessGroups: ['AccessGroupId-51675919-2bd7-4ce3-86e4-5faff8065574'],
    };

    alternateUserManagementService
      .inviteUsers(params)
      .then(res => {
        userId = res.result.resources[0].id;
        done();
      })
      .catch(err => {
        console.warn(err);
        done(err);
      });
  });
  test('getUserProfile()', done => {
    const params = {
      accountId: '1aa434630b594b8a88b961a44c9eb2a9',
      iamId: 'IBMid-550008BJPR',
    };

    userManagementService
      .getUserProfile(params)
      .then(res => {
        done();
      })
      .catch(err => {
        console.warn(err);
        done(err);
      });
  });
  test('updateUserProfiles()', done => {
    const params = {
      accountId: '1aa434630b594b8a88b961a44c9eb2a9',
      iamId: 'IBMid-550008BJPR',
      firstname: 'testString',
      lastname: 'testString',
      state: 'ACTIVE',
      email: 'do_not_delete_user_without_iam_policy_stage@mail.test.ibm.com',
      phonenumber: 'testString',
      altphonenumber: 'testString',
      photo: 'testString',
    };

    userManagementService
      .updateUserProfiles(params)
      .then(res => {
        done();
      })
      .catch(err => {
        console.warn(err);
        done(err);
      });
  });
  test('removeUsers()', done => {
    const params = {
      accountId: '1aa434630b594b8a88b961a44c9eb2a9',
      iamId: userId,
    };

    userManagementService
      .removeUsers(params)
      .then(res => {
        done();
      })
      .catch(err => {
        console.warn(err);
        done(err);
      });
  });
});
