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

const userManagement = new UserManagementV1(service);

// dont actually create a request
const createRequestMock = jest.spyOn(userManagement, 'createRequest');
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
  describe('getUserLinkages', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getUserLinkages
        const accountId = 'testString';
        const iamId = 'testString';
        const params = {
          accountId: accountId,
          iamId: iamId,
        };

        const getUserLinkagesResult = userManagement.getUserLinkages(params);

        // all methods should return a Promise
        expectToBePromise(getUserLinkagesResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/accounts/{account_id}/users/{iam_id}/linkages', 'GET');
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

        userManagement.getUserLinkages(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await userManagement.getUserLinkages({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getUserLinkagesPromise = userManagement.getUserLinkages();
        expectToBePromise(getUserLinkagesPromise);

        getUserLinkagesPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('createUserLinkages', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createUserLinkages
        const accountId = 'testString';
        const iamId = 'testString';
        const origin = 'testString';
        const idFromOrigin = 'testString';
        const params = {
          accountId: accountId,
          iamId: iamId,
          origin: origin,
          idFromOrigin: idFromOrigin,
        };

        const createUserLinkagesResult = userManagement.createUserLinkages(params);

        // all methods should return a Promise
        expectToBePromise(createUserLinkagesResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/accounts/{account_id}/users/{iam_id}/linkages/{origin}/{id_from_origin}', 'PUT');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['account_id']).toEqual(accountId);
        expect(options.path['iam_id']).toEqual(iamId);
        expect(options.path['origin']).toEqual(origin);
        expect(options.path['id_from_origin']).toEqual(idFromOrigin);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountId = 'testString';
        const iamId = 'testString';
        const origin = 'testString';
        const idFromOrigin = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountId,
          iamId,
          origin,
          idFromOrigin,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        userManagement.createUserLinkages(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await userManagement.createUserLinkages({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const createUserLinkagesPromise = userManagement.createUserLinkages();
        expectToBePromise(createUserLinkagesPromise);

        createUserLinkagesPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('removeUserLinkages', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation removeUserLinkages
        const accountId = 'testString';
        const iamId = 'testString';
        const origin = 'testString';
        const idFromOrigin = 'testString';
        const params = {
          accountId: accountId,
          iamId: iamId,
          origin: origin,
          idFromOrigin: idFromOrigin,
        };

        const removeUserLinkagesResult = userManagement.removeUserLinkages(params);

        // all methods should return a Promise
        expectToBePromise(removeUserLinkagesResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/accounts/{account_id}/users/{iam_id}/linkages/{origin}/{id_from_origin}', 'DELETE');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['account_id']).toEqual(accountId);
        expect(options.path['iam_id']).toEqual(iamId);
        expect(options.path['origin']).toEqual(origin);
        expect(options.path['id_from_origin']).toEqual(idFromOrigin);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountId = 'testString';
        const iamId = 'testString';
        const origin = 'testString';
        const idFromOrigin = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountId,
          iamId,
          origin,
          idFromOrigin,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        userManagement.removeUserLinkages(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await userManagement.removeUserLinkages({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const removeUserLinkagesPromise = userManagement.removeUserLinkages();
        expectToBePromise(removeUserLinkagesPromise);

        removeUserLinkagesPromise.catch(err => {
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
        const includeLinkages = true;
        const params = {
          accountId: accountId,
          iamId: iamId,
          includeLinkages: includeLinkages,
        };

        const getUserProfileResult = userManagement.getUserProfile(params);

        // all methods should return a Promise
        expectToBePromise(getUserProfileResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/accounts/{account_id}/users/{iam_id}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['include_linkages']).toEqual(includeLinkages);
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

        userManagement.getUserProfile(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await userManagement.getUserProfile({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getUserProfilePromise = userManagement.getUserProfile();
        expectToBePromise(getUserProfilePromise);

        getUserProfilePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('createUserProfile', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createUserProfile
        const accountId = 'testString';
        const iamId = 'testString';
        const realm = 'IBMid';
        const userId = 'example@ibm.com';
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
          realm: realm,
          userId: userId,
          firstname: firstname,
          lastname: lastname,
          state: state,
          email: email,
          phonenumber: phonenumber,
          altphonenumber: altphonenumber,
          photo: photo,
        };

        const createUserProfileResult = userManagement.createUserProfile(params);

        // all methods should return a Promise
        expectToBePromise(createUserProfileResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/accounts/{account_id}/users/{iam_id}', 'PUT');
        const expectedAccept = undefined;
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['realm']).toEqual(realm);
        expect(options.body['user_id']).toEqual(userId);
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

        userManagement.createUserProfile(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await userManagement.createUserProfile({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const createUserProfilePromise = userManagement.createUserProfile();
        expectToBePromise(createUserProfilePromise);

        createUserProfilePromise.catch(err => {
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
        const userId = 'testString';
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
          userId: userId,
          firstname: firstname,
          lastname: lastname,
          state: state,
          email: email,
          phonenumber: phonenumber,
          altphonenumber: altphonenumber,
          photo: photo,
        };

        const updateUserProfileResult = userManagement.updateUserProfile(params);

        // all methods should return a Promise
        expectToBePromise(updateUserProfileResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/accounts/{account_id}/users/{iam_id}', 'PATCH');
        const expectedAccept = undefined;
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['user_id']).toEqual(userId);
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

        userManagement.updateUserProfile(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await userManagement.updateUserProfile({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const updateUserProfilePromise = userManagement.updateUserProfile();
        expectToBePromise(updateUserProfilePromise);

        updateUserProfilePromise.catch(err => {
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

        const getUserSettingsResult = userManagement.getUserSettings(params);

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

        userManagement.getUserSettings(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await userManagement.getUserSettings({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getUserSettingsPromise = userManagement.getUserSettings();
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

        const updateUserSettingsResult = userManagement.updateUserSettings(params);

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

        userManagement.updateUserSettings(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await userManagement.updateUserSettings({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const updateUserSettingsPromise = userManagement.updateUserSettings();
        expectToBePromise(updateUserSettingsPromise);

        updateUserSettingsPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('removeUserFromAccount', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation removeUserFromAccount
        const accountId = 'testString';
        const iamId = 'testString';
        const params = {
          accountId: accountId,
          iamId: iamId,
        };

        const removeUserFromAccountResult = userManagement.removeUserFromAccount(params);

        // all methods should return a Promise
        expectToBePromise(removeUserFromAccountResult);

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

        userManagement.removeUserFromAccount(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await userManagement.removeUserFromAccount({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const removeUserFromAccountPromise = userManagement.removeUserFromAccount();
        expectToBePromise(removeUserFromAccountPromise);

        removeUserFromAccountPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('listUsers', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listUsers
        const accountId = 'testString';
        const iaMid = 'testString';
        const firstname = 'testString';
        const lastname = 'testString';
        const email = 'testString';
        const state = 'testString';
        const realm = 'testString';
        const params = {
          accountId: accountId,
          iaMid: iaMid,
          firstname: firstname,
          lastname: lastname,
          email: email,
          state: state,
          realm: realm,
        };

        const listUsersResult = userManagement.listUsers(params);

        // all methods should return a Promise
        expectToBePromise(listUsersResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/accounts/{account_id}/users', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['IAMid']).toEqual(iaMid);
        expect(options.qs['firstname']).toEqual(firstname);
        expect(options.qs['lastname']).toEqual(lastname);
        expect(options.qs['email']).toEqual(email);
        expect(options.qs['state']).toEqual(state);
        expect(options.qs['realm']).toEqual(realm);
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

        userManagement.listUsers(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await userManagement.listUsers({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const listUsersPromise = userManagement.listUsers();
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
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation inviteUsers
        const accountId = 'testString';
        const users = [inviteUserModel];
        const params = {
          accountId: accountId,
          users: users,
        };

        const inviteUsersResult = userManagement.inviteUsers(params);

        // all methods should return a Promise
        expectToBePromise(inviteUsersResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/accounts/{account_id}/users', 'POST');
        const expectedAccept = undefined;
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['users']).toEqual(users);
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

        userManagement.inviteUsers(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await userManagement.inviteUsers({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const inviteUsersPromise = userManagement.inviteUsers();
        expectToBePromise(inviteUsersPromise);

        inviteUsersPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getImsUsers', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getImsUsers
        const accountId = 'testString';
        const iaMid = 'testString';
        const firstname = 'testString';
        const lastname = 'testString';
        const email = 'testString';
        const state = 'testString';
        const params = {
          accountId: accountId,
          iaMid: iaMid,
          firstname: firstname,
          lastname: lastname,
          email: email,
          state: state,
        };

        const getImsUsersResult = userManagement.getImsUsers(params);

        // all methods should return a Promise
        expectToBePromise(getImsUsersResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/accounts/{account_id}/ims/users', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['IAMid']).toEqual(iaMid);
        expect(options.qs['firstname']).toEqual(firstname);
        expect(options.qs['lastname']).toEqual(lastname);
        expect(options.qs['email']).toEqual(email);
        expect(options.qs['state']).toEqual(state);
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

        userManagement.getImsUsers(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await userManagement.getImsUsers({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getImsUsersPromise = userManagement.getImsUsers();
        expectToBePromise(getImsUsersPromise);

        getImsUsersPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getCfUsers', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getCfUsers
        const accountId = 'testString';
        const organizationGuid = 'testString';
        const params = {
          accountId: accountId,
          organizationGuid: organizationGuid,
        };

        const getCfUsersResult = userManagement.getCfUsers(params);

        // all methods should return a Promise
        expectToBePromise(getCfUsersResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/accounts/{account_id}/organizations/{organization_guid}/users', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['account_id']).toEqual(accountId);
        expect(options.path['organization_guid']).toEqual(organizationGuid);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountId = 'testString';
        const organizationGuid = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountId,
          organizationGuid,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        userManagement.getCfUsers(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await userManagement.getCfUsers({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getCfUsersPromise = userManagement.getCfUsers();
        expectToBePromise(getCfUsersPromise);

        getCfUsersPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
});
