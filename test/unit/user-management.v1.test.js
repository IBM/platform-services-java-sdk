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

// need to import the whole package to mock getAuthenticatorFromEnvironment
const core = require('ibm-cloud-sdk-core');
const { NoAuthAuthenticator, unitTestUtils } = core;

const UserManagementV1 = require('../../dist/user-management/v1');

const {
  getOptions,
  checkUrlAndMethod,
  checkMediaHeaders,
  expectToBePromise,
} = unitTestUtils;

const service = {
  authenticator: new NoAuthAuthenticator(),
  url: 'https://user-management.cloud.ibm.com',
};

const userManagementService = new UserManagementV1(service);

// dont actually create a request
const createRequestMock = jest.spyOn(userManagementService, 'createRequest');
createRequestMock.mockImplementation(() => Promise.resolve());

// dont actually construct an authenticator
const getAuthenticatorMock = jest.spyOn(core, 'getAuthenticatorFromEnvironment');
getAuthenticatorMock.mockImplementation(() => new NoAuthAuthenticator());

afterEach(() => {
  createRequestMock.mockClear();
  getAuthenticatorMock.mockClear();
});

describe('UserManagementV1', () => {
  describe('the newInstance method', () => {
    test('should use defaults when options not provided', () => {
      const testInstance = UserManagementV1.newInstance();

      expect(getAuthenticatorMock).toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceName).toBe(UserManagementV1.DEFAULT_SERVICE_NAME);
      expect(testInstance.baseOptions.serviceUrl).toBe(UserManagementV1.DEFAULT_SERVICE_URL);
      expect(testInstance).toBeInstanceOf(UserManagementV1);
    });

    test('should set serviceName, serviceUrl, and authenticator when provided', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
        serviceName: 'my-service',
      };

      const testInstance = UserManagementV1.newInstance(options);

      expect(getAuthenticatorMock).not.toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
      expect(testInstance.baseOptions.serviceName).toBe('my-service');
      expect(testInstance).toBeInstanceOf(UserManagementV1);
    });
  });
  describe('the constructor', () => {
    test('use user-given service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
      };

      const testInstance = new UserManagementV1(options);

      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
    });

    test('use default service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
      };

      const testInstance = new UserManagementV1(options);

      expect(testInstance.baseOptions.serviceUrl).toBe(UserManagementV1.DEFAULT_SERVICE_URL);
    });
  });
  describe('listUsers', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listUsers
        const accountId = 'testString';
        const state = 'testString';
        const limit = 100;
        const start = 'testString';
        const params = {
          accountId: accountId,
          state: state,
          limit: limit,
          start: start,
        };

        const listUsersResult = userManagementService.listUsers(params);

        // all methods should return a Promise
        expectToBePromise(listUsersResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/accounts/{account_id}/users', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['state']).toEqual(state);
        expect(options.qs['limit']).toEqual(limit);
        expect(options.qs['_start']).toEqual(start);
        expect(options.path['account_id']).toEqual(accountId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        userManagementService.listUsers(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await userManagementService.listUsers({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const listUsersPromise = userManagementService.listUsers();
        expectToBePromise(listUsersPromise);

        listUsersPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('inviteUsers', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // InviteUser
      const inviteUserModel = {
        email: 'testString',
        account_role: 'testString',
      };

      // Role
      const roleModel = {
        role_id: 'testString',
      };

      // Attribute
      const attributeModel = {
        name: 'testString',
        value: 'testString',
      };

      // Resource
      const resourceModel = {
        attributes: [attributeModel],
      };

      // InviteUserIamPolicy
      const inviteUserIamPolicyModel = {
        type: 'testString',
        roles: [roleModel],
        resources: [resourceModel],
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation inviteUsers
        const accountId = 'testString';
        const users = [inviteUserModel];
        const iamPolicy = [inviteUserIamPolicyModel];
        const accessGroups = ['testString'];
        const params = {
          accountId: accountId,
          users: users,
          iamPolicy: iamPolicy,
          accessGroups: accessGroups,
        };

        const inviteUsersResult = userManagementService.inviteUsers(params);

        // all methods should return a Promise
        expectToBePromise(inviteUsersResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/accounts/{account_id}/users', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['users']).toEqual(users);
        expect(options.body['iam_policy']).toEqual(iamPolicy);
        expect(options.body['access_groups']).toEqual(accessGroups);
        expect(options.path['account_id']).toEqual(accountId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        userManagementService.inviteUsers(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await userManagementService.inviteUsers({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const inviteUsersPromise = userManagementService.inviteUsers();
        expectToBePromise(inviteUsersPromise);

        inviteUsersPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getUserProfile', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getUserProfile
        const accountId = 'testString';
        const iamId = 'testString';
        const params = {
          accountId: accountId,
          iamId: iamId,
        };

        const getUserProfileResult = userManagementService.getUserProfile(params);

        // all methods should return a Promise
        expectToBePromise(getUserProfileResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/accounts/{account_id}/users/{iam_id}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['account_id']).toEqual(accountId);
        expect(options.path['iam_id']).toEqual(iamId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountId = 'testString';
        const iamId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountId,
          iamId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        userManagementService.getUserProfile(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await userManagementService.getUserProfile({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getUserProfilePromise = userManagementService.getUserProfile();
        expectToBePromise(getUserProfilePromise);

        getUserProfilePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('updateUserProfile', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation updateUserProfile
        const accountId = 'testString';
        const iamId = 'testString';
        const firstname = 'testString';
        const lastname = 'testString';
        const state = 'testString';
        const email = 'testString';
        const phonenumber = 'testString';
        const altphonenumber = 'testString';
        const photo = 'testString';
        const params = {
          accountId: accountId,
          iamId: iamId,
          firstname: firstname,
          lastname: lastname,
          state: state,
          email: email,
          phonenumber: phonenumber,
          altphonenumber: altphonenumber,
          photo: photo,
        };

        const updateUserProfileResult = userManagementService.updateUserProfile(params);

        // all methods should return a Promise
        expectToBePromise(updateUserProfileResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/accounts/{account_id}/users/{iam_id}', 'PATCH');
        const expectedAccept = undefined;
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['firstname']).toEqual(firstname);
        expect(options.body['lastname']).toEqual(lastname);
        expect(options.body['state']).toEqual(state);
        expect(options.body['email']).toEqual(email);
        expect(options.body['phonenumber']).toEqual(phonenumber);
        expect(options.body['altphonenumber']).toEqual(altphonenumber);
        expect(options.body['photo']).toEqual(photo);
        expect(options.path['account_id']).toEqual(accountId);
        expect(options.path['iam_id']).toEqual(iamId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountId = 'testString';
        const iamId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountId,
          iamId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        userManagementService.updateUserProfile(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await userManagementService.updateUserProfile({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const updateUserProfilePromise = userManagementService.updateUserProfile();
        expectToBePromise(updateUserProfilePromise);

        updateUserProfilePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('removeUser', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation removeUser
        const accountId = 'testString';
        const iamId = 'testString';
        const params = {
          accountId: accountId,
          iamId: iamId,
        };

        const removeUserResult = userManagementService.removeUser(params);

        // all methods should return a Promise
        expectToBePromise(removeUserResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/accounts/{account_id}/users/{iam_id}', 'DELETE');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['account_id']).toEqual(accountId);
        expect(options.path['iam_id']).toEqual(iamId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountId = 'testString';
        const iamId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountId,
          iamId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        userManagementService.removeUser(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await userManagementService.removeUser({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const removeUserPromise = userManagementService.removeUser();
        expectToBePromise(removeUserPromise);

        removeUserPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getUserSettings', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getUserSettings
        const accountId = 'testString';
        const iamId = 'testString';
        const params = {
          accountId: accountId,
          iamId: iamId,
        };

        const getUserSettingsResult = userManagementService.getUserSettings(params);

        // all methods should return a Promise
        expectToBePromise(getUserSettingsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/accounts/{account_id}/users/{iam_id}/settings', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['account_id']).toEqual(accountId);
        expect(options.path['iam_id']).toEqual(iamId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountId = 'testString';
        const iamId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountId,
          iamId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        userManagementService.getUserSettings(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await userManagementService.getUserSettings({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getUserSettingsPromise = userManagementService.getUserSettings();
        expectToBePromise(getUserSettingsPromise);

        getUserSettingsPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('updateUserSettings', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation updateUserSettings
        const accountId = 'testString';
        const iamId = 'testString';
        const language = 'testString';
        const notificationLanguage = 'testString';
        const allowedIpAddresses = '32.96.110.50,172.16.254.1';
        const selfManage = true;
        const params = {
          accountId: accountId,
          iamId: iamId,
          language: language,
          notificationLanguage: notificationLanguage,
          allowedIpAddresses: allowedIpAddresses,
          selfManage: selfManage,
        };

        const updateUserSettingsResult = userManagementService.updateUserSettings(params);

        // all methods should return a Promise
        expectToBePromise(updateUserSettingsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/accounts/{account_id}/users/{iam_id}/settings', 'PATCH');
        const expectedAccept = undefined;
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['language']).toEqual(language);
        expect(options.body['notification_language']).toEqual(notificationLanguage);
        expect(options.body['allowed_ip_addresses']).toEqual(allowedIpAddresses);
        expect(options.body['self_manage']).toEqual(selfManage);
        expect(options.path['account_id']).toEqual(accountId);
        expect(options.path['iam_id']).toEqual(iamId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountId = 'testString';
        const iamId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountId,
          iamId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        userManagementService.updateUserSettings(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await userManagementService.updateUserSettings({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const updateUserSettingsPromise = userManagementService.updateUserSettings();
        expectToBePromise(updateUserSettingsPromise);

        updateUserSettingsPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
});
