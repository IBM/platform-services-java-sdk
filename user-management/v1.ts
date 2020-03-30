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

import * as extend from 'extend';
import { IncomingHttpHeaders, OutgoingHttpHeaders } from 'http';
import { Authenticator, BaseService, getAuthenticatorFromEnvironment, getMissingParams, UserOptions } from 'ibm-cloud-sdk-core';
import { getSdkHeaders } from '../lib/common';

/**
 * Manage lifecycle of your cloud users using User Management APIs.
 */

class UserManagementV1 extends BaseService {

  static DEFAULT_SERVICE_URL: string = 'https://user-management.cloud.ibm.com';
  static DEFAULT_SERVICE_NAME: string = 'user_management';

  /*************************
   * Factory method
   ************************/

  /**
   * Constructs an instance of UserManagementV1 with passed in options and external configuration.
   *
   * @param {UserOptions} [options] - The parameters to send to the service.
   * @param {string} [options.serviceName] - The name of the service to configure
   * @param {Authenticator} [options.authenticator] - The Authenticator object used to authenticate requests to the service
   * @param {string} [options.serviceUrl] - The URL for the service
   * @returns {UserManagementV1}
   */

  public static newInstance(options: UserOptions): UserManagementV1 {
    options = options || {};

    if (!options.serviceName) {
      options.serviceName = this.DEFAULT_SERVICE_NAME;
    }
    if (!options.authenticator) {
      options.authenticator = getAuthenticatorFromEnvironment(options.serviceName);
    }
    const service = new UserManagementV1(options);
    service.configureService(options.serviceName);
    if (options.serviceUrl) {
      service.setServiceUrl(options.serviceUrl);
    }
    return service;
  }


  /**
   * Construct a UserManagementV1 object.
   *
   * @param {Object} options - Options for the service.
   * @param {string} [options.serviceUrl] - The base url to use when contacting the service (e.g. 'https://gateway.watsonplatform.net'). The base url may differ between IBM Cloud regions.
   * @param {OutgoingHttpHeaders} [options.headers] - Default headers that shall be included with every request to the service.
   * @param {Authenticator} options.authenticator - The Authenticator object used to authenticate requests to the service
   * @constructor
   * @returns {UserManagementV1}
   */
  constructor(options: UserOptions) {
    options = options || {};

    super(options);
    if (options.serviceUrl) {
      this.setServiceUrl(options.serviceUrl);
    } else {
      this.setServiceUrl(UserManagementV1.DEFAULT_SERVICE_URL);
    }
  }

  /*************************
   * userLinkages
   ************************/

  /**
   * Get user linkages.
   *
   * Retrieve a user's linkages by user's iam id.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - The account id.
   * @param {string} params.iamId - The user's iam id.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<UserManagementV1.Response<UserManagementV1.UserLinkages>>}
   */
  public getUserLinkages(params: UserManagementV1.GetUserLinkagesParams): Promise<UserManagementV1.Response<UserManagementV1.UserLinkages>> {
    const _params = extend({}, params);
    const requiredParams = ['accountId', 'iamId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'account_id': _params.accountId,
        'iam_id': _params.iamId
      };

      const sdkHeaders = getSdkHeaders(UserManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getUserLinkages');

      const parameters = {
        options: {
          url: '/v2/accounts/{account_id}/users/{iam_id}/linkages',
          method: 'GET',
          path,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
            'Accept': 'application/json',
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /**
   * create user linkages.
   *
   * create a linakge for user by user's iam id.It's a system operation, only with System role/policy can invoke this
   * api.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - The account id.
   * @param {string} params.iamId - The user's iam id.
   * @param {string} params.origin - origin is "IMS" OR "UAA".
   * @param {string} params.idFromOrigin - An alpha-numeric value identifying the origin.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<UserManagementV1.Response<UserManagementV1.Empty>>}
   */
  public createUserLinkages(params: UserManagementV1.CreateUserLinkagesParams): Promise<UserManagementV1.Response<UserManagementV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['accountId', 'iamId', 'origin', 'idFromOrigin'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'account_id': _params.accountId,
        'iam_id': _params.iamId,
        'origin': _params.origin,
        'id_from_origin': _params.idFromOrigin
      };

      const sdkHeaders = getSdkHeaders(UserManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'createUserLinkages');

      const parameters = {
        options: {
          url: '/v2/accounts/{account_id}/users/{iam_id}/linkages/{origin}/{id_from_origin}',
          method: 'PUT',
          path,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /**
   * remove a user linkages.
   *
   * remove a user's linkage by user's iam id.It's a system operation, only with System role/policy can invoke this api.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - The account id.
   * @param {string} params.iamId - The user's iam id.
   * @param {string} params.origin - origin is "IMS" OR "UAA".
   * @param {string} params.idFromOrigin - An alpha-numeric value identifying the origin.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<UserManagementV1.Response<UserManagementV1.Empty>>}
   */
  public removeUserLinkages(params: UserManagementV1.RemoveUserLinkagesParams): Promise<UserManagementV1.Response<UserManagementV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['accountId', 'iamId', 'origin', 'idFromOrigin'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'account_id': _params.accountId,
        'iam_id': _params.iamId,
        'origin': _params.origin,
        'id_from_origin': _params.idFromOrigin
      };

      const sdkHeaders = getSdkHeaders(UserManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'removeUserLinkages');

      const parameters = {
        options: {
          url: '/v2/accounts/{account_id}/users/{iam_id}/linkages/{origin}/{id_from_origin}',
          method: 'DELETE',
          path,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /*************************
   * userProfile
   ************************/

  /**
   * Get user profile.
   *
   * Retrieve a user profile by user's iam id or cloudant guid.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - The account id.
   * @param {string} params.iamId - The user's iam id.
   * @param {boolean} [params.includeLinkages] - Indicate include linkages.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<UserManagementV1.Response<UserManagementV1.UserProfile>>}
   */
  public getUserProfile(params: UserManagementV1.GetUserProfileParams): Promise<UserManagementV1.Response<UserManagementV1.UserProfile>> {
    const _params = extend({}, params);
    const requiredParams = ['accountId', 'iamId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'include_linkages': _params.includeLinkages
      };

      const path = {
        'account_id': _params.accountId,
        'iam_id': _params.iamId
      };

      const sdkHeaders = getSdkHeaders(UserManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getUserProfile');

      const parameters = {
        options: {
          url: '/v2/accounts/{account_id}/users/{iam_id}',
          method: 'GET',
          qs: query,
          path,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
            'Accept': 'application/json',
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /**
   * create or replace user profile.
   *
   * Create a new user or replace user if user already exist by user's iam id.We enforce schema validation, some fields
   * are required.Only allow System to call to create user and sync user as a whole object. User update need to use
   * Partial update user profile.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - The account id.
   * @param {string} params.iamId - The user's iam id.
   * @param {string} [params.realm] - The real of the user, only for new user, this field can not be updated.
   * @param {string} [params.userId] - The user id of the user.
   * @param {string} [params.firstname] - The first name of the user.
   * @param {string} [params.lastname] - The last name of the user.
   * @param {string} [params.state] - The state of the user,Possible values "PROCESSING" | "PENDING" | "ACTIVE" |
   * "DISABLED" | "VPN_ONLY".
   * @param {string} [params.email] - The email of the user.
   * @param {string} [params.phonenumber] - The phone number of the user.
   * @param {string} [params.altphonenumber] - The altphonenumber of the user, new field to add (optional).
   * @param {string} [params.photo] - The phone link of the user.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<UserManagementV1.Response<UserManagementV1.Empty>>}
   */
  public createUserProfile(params: UserManagementV1.CreateUserProfileParams): Promise<UserManagementV1.Response<UserManagementV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['accountId', 'iamId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const body = {
        'realm': _params.realm,
        'user_id': _params.userId,
        'firstname': _params.firstname,
        'lastname': _params.lastname,
        'state': _params.state,
        'email': _params.email,
        'phonenumber': _params.phonenumber,
        'altphonenumber': _params.altphonenumber,
        'photo': _params.photo
      };

      const path = {
        'account_id': _params.accountId,
        'iam_id': _params.iamId
      };

      const sdkHeaders = getSdkHeaders(UserManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'createUserProfile');

      const parameters = {
        options: {
          url: '/v2/accounts/{account_id}/users/{iam_id}',
          method: 'PUT',
          body,
          path,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
            'Content-Type': 'application/json',
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /**
   * partial update user profile.
   *
   * Partial update a user's profile by user's iam id.We enforce schema validations.User can disable/activate another
   * user, as long as the user has user-management access, but user can not change state to "PROCESSING" or "PENDING",
   * which are system states.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - The account id.
   * @param {string} params.iamId - The user's iam id.
   * @param {string} [params.userId] - The user id of the user.
   * @param {string} [params.firstname] - The first name of the user.
   * @param {string} [params.lastname] - The last name of the user.
   * @param {string} [params.state] - The state of the user,Possible values "PROCESSING" | "PENDING" | "ACTIVE" |
   * "DISABLED" | "VPN_ONLY".
   * @param {string} [params.email] - The email of the user.
   * @param {string} [params.phonenumber] - The phone number of the user.
   * @param {string} [params.altphonenumber] - The altphonenumber of the user, new field to add (optional).
   * @param {string} [params.photo] - The phone link of the user.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<UserManagementV1.Response<UserManagementV1.Empty>>}
   */
  public updateUserProfile(params: UserManagementV1.UpdateUserProfileParams): Promise<UserManagementV1.Response<UserManagementV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['accountId', 'iamId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const body = {
        'user_id': _params.userId,
        'firstname': _params.firstname,
        'lastname': _params.lastname,
        'state': _params.state,
        'email': _params.email,
        'phonenumber': _params.phonenumber,
        'altphonenumber': _params.altphonenumber,
        'photo': _params.photo
      };

      const path = {
        'account_id': _params.accountId,
        'iam_id': _params.iamId
      };

      const sdkHeaders = getSdkHeaders(UserManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'updateUserProfile');

      const parameters = {
        options: {
          url: '/v2/accounts/{account_id}/users/{iam_id}',
          method: 'PATCH',
          body,
          path,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
            'Content-Type': 'application/json',
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /*************************
   * userSettings
   ************************/

  /**
   * Get user settings.
   *
   * Retrieve a user's settings by user's iam id.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - The account id.
   * @param {string} params.iamId - The user's iam id.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<UserManagementV1.Response<UserManagementV1.UserSettings>>}
   */
  public getUserSettings(params: UserManagementV1.GetUserSettingsParams): Promise<UserManagementV1.Response<UserManagementV1.UserSettings>> {
    const _params = extend({}, params);
    const requiredParams = ['accountId', 'iamId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'account_id': _params.accountId,
        'iam_id': _params.iamId
      };

      const sdkHeaders = getSdkHeaders(UserManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getUserSettings');

      const parameters = {
        options: {
          url: '/v2/accounts/{account_id}/users/{iam_id}/settings',
          method: 'GET',
          path,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
            'Accept': 'application/json',
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /**
   * Partial update user settings.
   *
   * Update a user's settings by user's iam id.User can update "language", "notification_language" and can update
   * "allowed_ip_addresses" if "self_manage" is true, but user can not update "allowed_ip_addresses" if "self_manage" is
   * false.And Update "self_manage" requires user-management policy.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - The account id.
   * @param {string} params.iamId - The user's iam id.
   * @param {string} [params.language] - UI language, default value empty.
   * @param {string} [params.notificationLanguage] - For email, phone notification, default value empty.
   * @param {string} [params.allowedIpAddresses] - Ip address string use comma to separate string.
   * @param {boolean} [params.selfManage] - a field set for user be able to self manage or not, default false.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<UserManagementV1.Response<UserManagementV1.Empty>>}
   */
  public updateUserSettings(params: UserManagementV1.UpdateUserSettingsParams): Promise<UserManagementV1.Response<UserManagementV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['accountId', 'iamId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const body = {
        'language': _params.language,
        'notification_language': _params.notificationLanguage,
        'allowed_ip_addresses': _params.allowedIpAddresses,
        'self_manage': _params.selfManage
      };

      const path = {
        'account_id': _params.accountId,
        'iam_id': _params.iamId
      };

      const sdkHeaders = getSdkHeaders(UserManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'updateUserSettings');

      const parameters = {
        options: {
          url: '/v2/accounts/{account_id}/users/{iam_id}/settings',
          method: 'PATCH',
          body,
          path,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
            'Content-Type': 'application/json',
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /*************************
   * users
   ************************/

  /**
   * remove user from account.
   *
   * IAM user management policy is required to perform this action.If the caller does not have proper IAM user
   * management policy, then if the user is a decendent of the caller in IMS heirarchy, then allow as well.Do not
   * support self delete.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - The account id.
   * @param {string} params.iamId - The user's iam id.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<UserManagementV1.Response<UserManagementV1.Empty>>}
   */
  public removeUserFromAccount(params: UserManagementV1.RemoveUserFromAccountParams): Promise<UserManagementV1.Response<UserManagementV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['accountId', 'iamId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'account_id': _params.accountId,
        'iam_id': _params.iamId
      };

      const sdkHeaders = getSdkHeaders(UserManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'removeUserFromAccount');

      const parameters = {
        options: {
          url: '/v2/accounts/{account_id}/users/{iam_id}',
          method: 'DELETE',
          path,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /**
   * Get users.
   *
   * Retrieve users in the account.If team directory enabled, return all users in the account.If team directory
   * disbaled, and user has IAM viewer role on user-management service, then return all users in the account.If team
   * directory disabled, and user does not have IAM viewer role on user-management service, then return only current
   * user.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - The account id.
   * @param {string} [params.iaMid] - The realm of the user.
   * @param {string} [params.firstname] - The firstname of user.
   * @param {string} [params.lastname] - The lastname of user.
   * @param {string} [params.email] - The email of user.
   * @param {string} [params.state] - The state.
   * @param {string} [params.realm] - The realm of the user.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<UserManagementV1.Response<UserManagementV1.UserList>>}
   */
  public listUsers(params: UserManagementV1.ListUsersParams): Promise<UserManagementV1.Response<UserManagementV1.UserList>> {
    const _params = extend({}, params);
    const requiredParams = ['accountId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'IAMid': _params.iaMid,
        'firstname': _params.firstname,
        'lastname': _params.lastname,
        'email': _params.email,
        'state': _params.state,
        'realm': _params.realm
      };

      const path = {
        'account_id': _params.accountId
      };

      const sdkHeaders = getSdkHeaders(UserManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'listUsers');

      const parameters = {
        options: {
          url: '/v2/accounts/{account_id}/users',
          method: 'GET',
          qs: query,
          path,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
            'Accept': 'application/json',
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /**
   * Invite users.
   *
   * Invite users to the account.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - The account id.
   * @param {InviteUser[]} [params.users] - list of users to be invited.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<UserManagementV1.Response<UserManagementV1.Empty>>}
   */
  public inviteUsers(params: UserManagementV1.InviteUsersParams): Promise<UserManagementV1.Response<UserManagementV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['accountId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const body = {
        'users': _params.users
      };

      const path = {
        'account_id': _params.accountId
      };

      const sdkHeaders = getSdkHeaders(UserManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'inviteUsers');

      const parameters = {
        options: {
          url: '/v2/accounts/{account_id}/users',
          method: 'POST',
          body,
          path,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
            'Content-Type': 'application/json',
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /**
   * Get users in account and filtering results based on IMS user heirarchy.
   *
   * Retrieve a user profile by user's iam id or cloudant guid.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - The account id.
   * @param {string} [params.iaMid] - The realm of the user.
   * @param {string} [params.firstname] - The firstname of user.
   * @param {string} [params.lastname] - The lastname of user.
   * @param {string} [params.email] - The email of user.
   * @param {string} [params.state] - The state.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<UserManagementV1.Response<UserManagementV1.UserList>>}
   */
  public getImsUsers(params: UserManagementV1.GetImsUsersParams): Promise<UserManagementV1.Response<UserManagementV1.UserList>> {
    const _params = extend({}, params);
    const requiredParams = ['accountId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'IAMid': _params.iaMid,
        'firstname': _params.firstname,
        'lastname': _params.lastname,
        'email': _params.email,
        'state': _params.state
      };

      const path = {
        'account_id': _params.accountId
      };

      const sdkHeaders = getSdkHeaders(UserManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getImsUsers');

      const parameters = {
        options: {
          url: '/v2/accounts/{account_id}/ims/users',
          method: 'GET',
          qs: query,
          path,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
            'Accept': 'application/json',
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /**
   * Get users.
   *
   * Get CF organizations Users in account organization.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - The account id.
   * @param {string} params.organizationGuid - The organization id.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<UserManagementV1.Response<UserManagementV1.UserList>>}
   */
  public getCfUsers(params: UserManagementV1.GetCfUsersParams): Promise<UserManagementV1.Response<UserManagementV1.UserList>> {
    const _params = extend({}, params);
    const requiredParams = ['accountId', 'organizationGuid'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'account_id': _params.accountId,
        'organization_guid': _params.organizationGuid
      };

      const sdkHeaders = getSdkHeaders(UserManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getCfUsers');

      const parameters = {
        options: {
          url: '/v2/accounts/{account_id}/organizations/{organization_guid}/users',
          method: 'GET',
          path,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
            'Accept': 'application/json',
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

}

/*************************
 * interfaces
 ************************/

namespace UserManagementV1 {

  /** An operation response. */
  export interface Response<T = any>  {
    result: T;
    status: number;
    statusText: string;
    headers: IncomingHttpHeaders;
  }

  /** The callback for a service request. */
  export type Callback<T> = (error: any, response?: Response<T>) => void;

  /** The body of a service request that returns no response data. */
  export interface Empty { }

  /** A standard JS object, defined to avoid the limitations of `Object` and `object` */
  export interface JsonObject {
    [key: string]: any;
  }

  /*************************
   * request interfaces
   ************************/

  /** Parameters for the `getUserLinkages` operation. */
  export interface GetUserLinkagesParams {
    /** The account id. */
    accountId: string;
    /** The user's iam id. */
    iamId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `createUserLinkages` operation. */
  export interface CreateUserLinkagesParams {
    /** The account id. */
    accountId: string;
    /** The user's iam id. */
    iamId: string;
    /** origin is "IMS" OR "UAA". */
    origin: string;
    /** An alpha-numeric value identifying the origin. */
    idFromOrigin: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `removeUserLinkages` operation. */
  export interface RemoveUserLinkagesParams {
    /** The account id. */
    accountId: string;
    /** The user's iam id. */
    iamId: string;
    /** origin is "IMS" OR "UAA". */
    origin: string;
    /** An alpha-numeric value identifying the origin. */
    idFromOrigin: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getUserProfile` operation. */
  export interface GetUserProfileParams {
    /** The account id. */
    accountId: string;
    /** The user's iam id. */
    iamId: string;
    /** Indicate include linkages. */
    includeLinkages?: boolean;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `createUserProfile` operation. */
  export interface CreateUserProfileParams {
    /** The account id. */
    accountId: string;
    /** The user's iam id. */
    iamId: string;
    /** The real of the user, only for new user, this field can not be updated. */
    realm?: string;
    /** The user id of the user. */
    userId?: string;
    /** The first name of the user. */
    firstname?: string;
    /** The last name of the user. */
    lastname?: string;
    /** The state of the user,Possible values "PROCESSING" | "PENDING" | "ACTIVE" | "DISABLED" | "VPN_ONLY". */
    state?: string;
    /** The email of the user. */
    email?: string;
    /** The phone number of the user. */
    phonenumber?: string;
    /** The altphonenumber of the user, new field to add (optional). */
    altphonenumber?: string;
    /** The phone link of the user. */
    photo?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `updateUserProfile` operation. */
  export interface UpdateUserProfileParams {
    /** The account id. */
    accountId: string;
    /** The user's iam id. */
    iamId: string;
    /** The user id of the user. */
    userId?: string;
    /** The first name of the user. */
    firstname?: string;
    /** The last name of the user. */
    lastname?: string;
    /** The state of the user,Possible values "PROCESSING" | "PENDING" | "ACTIVE" | "DISABLED" | "VPN_ONLY". */
    state?: string;
    /** The email of the user. */
    email?: string;
    /** The phone number of the user. */
    phonenumber?: string;
    /** The altphonenumber of the user, new field to add (optional). */
    altphonenumber?: string;
    /** The phone link of the user. */
    photo?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getUserSettings` operation. */
  export interface GetUserSettingsParams {
    /** The account id. */
    accountId: string;
    /** The user's iam id. */
    iamId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `updateUserSettings` operation. */
  export interface UpdateUserSettingsParams {
    /** The account id. */
    accountId: string;
    /** The user's iam id. */
    iamId: string;
    /** UI language, default value empty. */
    language?: string;
    /** For email, phone notification, default value empty. */
    notificationLanguage?: string;
    /** Ip address string use comma to separate string. */
    allowedIpAddresses?: string;
    /** a field set for user be able to self manage or not, default false. */
    selfManage?: boolean;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `removeUserFromAccount` operation. */
  export interface RemoveUserFromAccountParams {
    /** The account id. */
    accountId: string;
    /** The user's iam id. */
    iamId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listUsers` operation. */
  export interface ListUsersParams {
    /** The account id. */
    accountId: string;
    /** The realm of the user. */
    iaMid?: string;
    /** The firstname of user. */
    firstname?: string;
    /** The lastname of user. */
    lastname?: string;
    /** The email of user. */
    email?: string;
    /** The state. */
    state?: string;
    /** The realm of the user. */
    realm?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `inviteUsers` operation. */
  export interface InviteUsersParams {
    /** The account id. */
    accountId: string;
    /** list of users to be invited. */
    users?: InviteUser[];
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getImsUsers` operation. */
  export interface GetImsUsersParams {
    /** The account id. */
    accountId: string;
    /** The realm of the user. */
    iaMid?: string;
    /** The firstname of user. */
    firstname?: string;
    /** The lastname of user. */
    lastname?: string;
    /** The email of user. */
    email?: string;
    /** The state. */
    state?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getCfUsers` operation. */
  export interface GetCfUsersParams {
    /** The account id. */
    accountId: string;
    /** The organization id. */
    organizationGuid: string;
    headers?: OutgoingHttpHeaders;
  }

  /*************************
   * model interfaces
   ************************/

  /** The returned list of user linkages. */
  export interface UserLinkages {
    /** shows the origin of the user and id of that origin. */
    linkages?: Linkage[];
  }

  /** The returned list of users. */
  export interface UserList {
    /** the number of users returned. */
    total_results?: number;
    /** limit of the users returned in a page. */
    limit?: number;
    /** the first url of the get users api. */
    first_url?: string;
    /** the next url of the get users api. */
    next_url?: string;
    /** shows the users in the account. */
    resources?: UserProfile[];
  }

  /** The returned user profile. */
  export interface UserProfile {
    /** An alpha-numeric value identifying the user profile. */
    id?: string;
    /** An alpha-numeric value identifying the user's iam id. */
    iam_id?: string;
    /** The value would be IBMid or SL. */
    realm?: string;
    /** The user id used for login. */
    user_id?: string;
    /** The first name of the user. */
    firstname?: string;
    /** The last name of the user. */
    lastname?: string;
    /** The state of the user, Possible value:"PROCESSING" | "PENDING" | "ACTIVE" | "DISABLED" | "VPN_ONLY". */
    state?: string;
    /** The email of the user. */
    email?: string;
    /** The phone for the user. */
    phonenumber?: string;
    /** The altphonenumber of the user. */
    altphonenumber?: string;
    /** The link of the photo of user. */
    photo?: string;
    /** An alpha-numeric value identifying the account ID. */
    account_id?: string;
    /** shows the origin of the user and id of that origin. */
    linkages?: Linkage[];
  }

  /** The returned user settings. */
  export interface UserSettings {
    /** UI language, default value empty. */
    language?: string;
    /** For email, phone notification, default value empty. */
    notification_language?: string;
    /** Ip address string use comma to separate string. */
    allowed_ip_addresses?: string;
    /** a field set for user be able to self manage or not, default false. */
    self_manage?: boolean;
  }

  /** Invite a user. */
  export interface InviteUser {
    /** An email of the user to be invited. */
    email?: string;
  }

  /** Origin of the user and its id. */
  export interface Linkage {
    /** A string shows the name of the origin. */
    origin?: string;
    /** An alpha-numeric value identifying the origin. */
    id?: string;
  }

}

export = UserManagementV1;
