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

/**
 * IBM OpenAPI SDK Code Generator Version: 3.37.0-a85661cd-20210802-190136
 */

import * as extend from 'extend';
import { IncomingHttpHeaders, OutgoingHttpHeaders } from 'http';
import {
  Authenticator,
  BaseService,
  getAuthenticatorFromEnvironment,
  getMissingParams,
  UserOptions,
} from 'ibm-cloud-sdk-core';
import { getSdkHeaders } from '../lib/common';

/**
 * The IAM Identity Service API allows for the management of Account Settings and Identities (Service IDs, ApiKeys).
 */

class IamIdentityV1 extends BaseService {
  static DEFAULT_SERVICE_URL: string = 'https://iam.cloud.ibm.com';

  static DEFAULT_SERVICE_NAME: string = 'iam_identity';

  /*************************
   * Factory method
   ************************/

  /**
   * Constructs an instance of IamIdentityV1 with passed in options and external configuration.
   *
   * @param {UserOptions} [options] - The parameters to send to the service.
   * @param {string} [options.serviceName] - The name of the service to configure
   * @param {Authenticator} [options.authenticator] - The Authenticator object used to authenticate requests to the service
   * @param {string} [options.serviceUrl] - The URL for the service
   * @returns {IamIdentityV1}
   */

  public static newInstance(options: UserOptions): IamIdentityV1 {
    options = options || {};

    if (!options.serviceName) {
      options.serviceName = this.DEFAULT_SERVICE_NAME;
    }
    if (!options.authenticator) {
      options.authenticator = getAuthenticatorFromEnvironment(options.serviceName);
    }
    const service = new IamIdentityV1(options);
    service.configureService(options.serviceName);
    if (options.serviceUrl) {
      service.setServiceUrl(options.serviceUrl);
    }
    return service;
  }

  /**
   * Construct a IamIdentityV1 object.
   *
   * @param {Object} options - Options for the service.
   * @param {string} [options.serviceUrl] - The base url to use when contacting the service. The base url may differ between IBM Cloud regions.
   * @param {OutgoingHttpHeaders} [options.headers] - Default headers that shall be included with every request to the service.
   * @param {Authenticator} options.authenticator - The Authenticator object used to authenticate requests to the service
   * @constructor
   * @returns {IamIdentityV1}
   */
  constructor(options: UserOptions) {
    options = options || {};

    super(options);
    if (options.serviceUrl) {
      this.setServiceUrl(options.serviceUrl);
    } else {
      this.setServiceUrl(IamIdentityV1.DEFAULT_SERVICE_URL);
    }
  }

  /*************************
   * APIKeyOperations
   ************************/

  /**
   * Get API keys for a given service or user IAM ID and account ID.
   *
   * Returns the list of API key details for a given service or user IAM ID and account ID. Users can manage user API
   * keys for themself, or service ID API keys for  service IDs that are bound to an entity they have access to. In case
   * of  service IDs and their API keys, a user must be either an account owner,  a IBM Cloud org manager or IBM Cloud
   * space developer in order to manage  service IDs of the entity.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {string} [params.accountId] - Account ID of the API keys(s) to query. If a service IAM ID is specified in
   * iam_id then account_id must match the account of the IAM ID. If a user IAM ID is specified in iam_id then then
   * account_id must match the account of the Authorization token.
   * @param {string} [params.iamId] - IAM ID of the API key(s) to be queried. The IAM ID may be that of a user or a
   * service. For a user IAM ID iam_id must match the Authorization token.
   * @param {number} [params.pagesize] - Optional size of a single page. Default is 20 items per page. Valid range is 1
   * to 100.
   * @param {string} [params.pagetoken] - Optional Prev or Next page token returned from a previous query execution.
   * Default is start with first page.
   * @param {string} [params.scope] - Optional parameter to define the scope of the queried API Keys. Can be 'entity'
   * (default) or 'account'.
   * @param {string} [params.type] - Optional parameter to filter the type of the queried API Keys. Can be 'user' or
   * 'serviceid'.
   * @param {string} [params.sort] - Optional sort property, valid values are name, description, created_at and
   * created_by. If specified, the items are sorted by the value of this property.
   * @param {string} [params.order] - Optional sort order, valid values are asc and desc. Default: asc.
   * @param {boolean} [params.includeHistory] - Defines if the entity history is included in the response.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.ApiKeyList>>}
   */
  public listApiKeys(
    params?: IamIdentityV1.ListApiKeysParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.ApiKeyList>> {
    const _params = { ...params };

    const query = {
      'account_id': _params.accountId,
      'iam_id': _params.iamId,
      'pagesize': _params.pagesize,
      'pagetoken': _params.pagetoken,
      'scope': _params.scope,
      'type': _params.type,
      'sort': _params.sort,
      'order': _params.order,
      'include_history': _params.includeHistory,
    };

    const sdkHeaders = getSdkHeaders(IamIdentityV1.DEFAULT_SERVICE_NAME, 'v1', 'listApiKeys');

    const parameters = {
      options: {
        url: '/v1/apikeys',
        method: 'GET',
        qs: query,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Create an API key.
   *
   * Creates an API key for a UserID or service ID. Users can manage user API keys for themself, or service ID API keys
   * for  service IDs that are bound to an entity they have access to.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.name - Name of the API key. The name is not checked for uniqueness. Therefore multiple names
   * with the same value can exist. Access is done via the UUID of the API key.
   * @param {string} params.iamId - The iam_id that this API key authenticates.
   * @param {string} [params.description] - The optional description of the API key. The 'description' property is only
   * available if a description was provided during a create of an API key.
   * @param {string} [params.accountId] - The account ID of the API key.
   * @param {string} [params.apikey] - You can optionally passthrough the API key value for this API key. If passed, NO
   * validation of that apiKey value is done, i.e. the value can be non-URL safe. If omitted, the API key management
   * will create an URL safe opaque API key value. The value of the API key is checked for uniqueness. Please ensure
   * enough variations when passing in this value.
   * @param {boolean} [params.storeValue] - Send true or false to set whether the API key value is retrievable in the
   * future by using the Get details of an API key request. If you create an API key for a user, you must specify
   * `false` or omit the value. We don't allow storing of API keys for users.
   * @param {string} [params.entityLock] - Indicates if the API key is locked for further write operations. False by
   * default.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.ApiKey>>}
   */
  public createApiKey(
    params: IamIdentityV1.CreateApiKeyParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.ApiKey>> {
    const _params = { ...params };
    const requiredParams = ['name', 'iamId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'name': _params.name,
      'iam_id': _params.iamId,
      'description': _params.description,
      'account_id': _params.accountId,
      'apikey': _params.apikey,
      'store_value': _params.storeValue,
    };

    const sdkHeaders = getSdkHeaders(IamIdentityV1.DEFAULT_SERVICE_NAME, 'v1', 'createApiKey');

    const parameters = {
      options: {
        url: '/v1/apikeys',
        method: 'POST',
        body,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Entity-Lock': _params.entityLock,
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Get details of an API key by its value.
   *
   * Returns the details of an API key by its value. Users can manage user API keys for themself, or service ID API keys
   *  for service IDs that are bound to an entity they have access to.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {string} [params.iamApiKey] - API key value.
   * @param {boolean} [params.includeHistory] - Defines if the entity history is included in the response.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.ApiKey>>}
   */
  public getApiKeysDetails(
    params?: IamIdentityV1.GetApiKeysDetailsParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.ApiKey>> {
    const _params = { ...params };

    const query = {
      'include_history': _params.includeHistory,
    };

    const sdkHeaders = getSdkHeaders(IamIdentityV1.DEFAULT_SERVICE_NAME, 'v1', 'getApiKeysDetails');

    const parameters = {
      options: {
        url: '/v1/apikeys/details',
        method: 'GET',
        qs: query,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'IAM-ApiKey': _params.iamApiKey,
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Get details of an API key.
   *
   * Returns the details of an API key. Users can manage user API keys for themself, or service ID API keys for  service
   * IDs that are bound to an entity they have access to. In case of  service IDs and their API keys, a user must be
   * either an account owner,  a IBM Cloud org manager or IBM Cloud space developer in order to manage  service IDs of
   * the entity.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - Unique ID of the API key.
   * @param {boolean} [params.includeHistory] - Defines if the entity history is included in the response.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.ApiKey>>}
   */
  public getApiKey(
    params: IamIdentityV1.GetApiKeyParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.ApiKey>> {
    const _params = { ...params };
    const requiredParams = ['id'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'include_history': _params.includeHistory,
    };

    const path = {
      'id': _params.id,
    };

    const sdkHeaders = getSdkHeaders(IamIdentityV1.DEFAULT_SERVICE_NAME, 'v1', 'getApiKey');

    const parameters = {
      options: {
        url: '/v1/apikeys/{id}',
        method: 'GET',
        qs: query,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Updates an API key.
   *
   * Updates properties of an API key. This does NOT affect existing access tokens. Their token content will stay
   * unchanged until the access token is refreshed. To update an API key, pass the property to be modified. To delete
   * one property's value, pass the property with an empty value "".Users can manage user API keys for themself, or
   * service ID API keys for service IDs that are bound to an entity they have access to.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - Unique ID of the API key to be updated.
   * @param {string} params.ifMatch - Version of the API key to be updated. Specify the version that you retrieved when
   * reading the API key. This value  helps identifying parallel usage of this API. Pass * to indicate to update any
   * version available. This might result in stale updates.
   * @param {string} [params.name] - The name of the API key to update. If specified in the request the parameter must
   * not be empty. The name is not checked for uniqueness. Failure to this will result in an Error condition.
   * @param {string} [params.description] - The description of the API key to update. If specified an empty description
   * will clear the description of the API key. If a non empty value is provided the API key will be updated.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.ApiKey>>}
   */
  public updateApiKey(
    params: IamIdentityV1.UpdateApiKeyParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.ApiKey>> {
    const _params = { ...params };
    const requiredParams = ['id', 'ifMatch'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'name': _params.name,
      'description': _params.description,
    };

    const path = {
      'id': _params.id,
    };

    const sdkHeaders = getSdkHeaders(IamIdentityV1.DEFAULT_SERVICE_NAME, 'v1', 'updateApiKey');

    const parameters = {
      options: {
        url: '/v1/apikeys/{id}',
        method: 'PUT',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'If-Match': _params.ifMatch,
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Deletes an API key.
   *
   * Deletes an API key. Existing tokens will remain valid until expired. Users can manage user API keys for themself,
   * or service ID API  keys for service IDs that are bound to an entity they have access  to.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - Unique ID of the API key.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.Empty>>}
   */
  public deleteApiKey(
    params: IamIdentityV1.DeleteApiKeyParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['id'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'id': _params.id,
    };

    const sdkHeaders = getSdkHeaders(IamIdentityV1.DEFAULT_SERVICE_NAME, 'v1', 'deleteApiKey');

    const parameters = {
      options: {
        url: '/v1/apikeys/{id}',
        method: 'DELETE',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {}, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Lock the API key.
   *
   * Locks an API key by ID. Users can manage user API keys for themself, or service ID API keys for service IDs that
   * are bound to an entity they have access to. In case of service IDs and their API keys, a user must be either an
   * account owner, a IBM Cloud org manager or IBM Cloud space developer in order to manage service IDs of the entity.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - Unique ID of the API key.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.Empty>>}
   */
  public lockApiKey(
    params: IamIdentityV1.LockApiKeyParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['id'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'id': _params.id,
    };

    const sdkHeaders = getSdkHeaders(IamIdentityV1.DEFAULT_SERVICE_NAME, 'v1', 'lockApiKey');

    const parameters = {
      options: {
        url: '/v1/apikeys/{id}/lock',
        method: 'POST',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {}, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Unlock the API key.
   *
   * Unlocks an API key by ID. Users can manage user API keys for themself, or service ID API keys for service IDs that
   * are bound to an entity they have access to. In case of service IDs and their API keys, a user must be either an
   * account owner, a IBM Cloud org manager or IBM Cloud space developer in order to manage service IDs of the entity.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - Unique ID of the API key.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.Empty>>}
   */
  public unlockApiKey(
    params: IamIdentityV1.UnlockApiKeyParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['id'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'id': _params.id,
    };

    const sdkHeaders = getSdkHeaders(IamIdentityV1.DEFAULT_SERVICE_NAME, 'v1', 'unlockApiKey');

    const parameters = {
      options: {
        url: '/v1/apikeys/{id}/lock',
        method: 'DELETE',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {}, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  }
  /*************************
   * serviceIDOperations
   ************************/

  /**
   * List service IDs.
   *
   * Returns a list of service IDs. Users can manage user API keys for themself, or service ID API keys for service IDs
   * that are bound to an entity they have access to. Note: apikey details are only included in the response when
   * creating a Service ID with an api key.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {string} [params.accountId] - Account ID of the service ID(s) to query. This parameter is required (unless
   * using a pagetoken).
   * @param {string} [params.name] - Name of the service ID(s) to query. Optional.20 items per page. Valid range is 1 to
   * 100.
   * @param {number} [params.pagesize] - Optional size of a single page. Default is 20 items per page. Valid range is 1
   * to 100.
   * @param {string} [params.pagetoken] - Optional Prev or Next page token returned from a previous query execution.
   * Default is start with first page.
   * @param {string} [params.sort] - Optional sort property, valid values are name, description, created_at and
   * modified_at. If specified, the items are sorted by the value of this property.
   * @param {string} [params.order] - Optional sort order, valid values are asc and desc. Default: asc.
   * @param {boolean} [params.includeHistory] - Defines if the entity history is included in the response.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.ServiceIdList>>}
   */
  public listServiceIds(
    params?: IamIdentityV1.ListServiceIdsParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.ServiceIdList>> {
    const _params = { ...params };

    const query = {
      'account_id': _params.accountId,
      'name': _params.name,
      'pagesize': _params.pagesize,
      'pagetoken': _params.pagetoken,
      'sort': _params.sort,
      'order': _params.order,
      'include_history': _params.includeHistory,
    };

    const sdkHeaders = getSdkHeaders(IamIdentityV1.DEFAULT_SERVICE_NAME, 'v1', 'listServiceIds');

    const parameters = {
      options: {
        url: '/v1/serviceids/',
        method: 'GET',
        qs: query,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Create a service ID.
   *
   * Creates a service ID for an IBM Cloud account. Users can manage user API keys for themself, or service ID API keys
   * for service IDs that are bound to an entity they have access to.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - ID of the account the service ID belongs to.
   * @param {string} params.name - Name of the Service Id. The name is not checked for uniqueness. Therefore multiple
   * names with the same value can exist. Access is done via the UUID of the Service Id.
   * @param {string} [params.description] - The optional description of the Service Id. The 'description' property is
   * only available if a description was provided during a create of a Service Id.
   * @param {string[]} [params.uniqueInstanceCrns] - Optional list of CRNs (string array) which point to the services
   * connected to the service ID.
   * @param {ApiKeyInsideCreateServiceIdRequest} [params.apikey] - Parameters for the API key in the Create service Id
   * V1 REST request.
   * @param {string} [params.entityLock] - Indicates if the service ID is locked for further write operations. False by
   * default.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.ServiceId>>}
   */
  public createServiceId(
    params: IamIdentityV1.CreateServiceIdParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.ServiceId>> {
    const _params = { ...params };
    const requiredParams = ['accountId', 'name'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'account_id': _params.accountId,
      'name': _params.name,
      'description': _params.description,
      'unique_instance_crns': _params.uniqueInstanceCrns,
      'apikey': _params.apikey,
    };

    const sdkHeaders = getSdkHeaders(IamIdentityV1.DEFAULT_SERVICE_NAME, 'v1', 'createServiceId');

    const parameters = {
      options: {
        url: '/v1/serviceids/',
        method: 'POST',
        body,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Entity-Lock': _params.entityLock,
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Get details of a service ID.
   *
   * Returns the details of a service ID. Users can manage user API keys for themself, or service ID API keys for
   * service IDs that are bound to an entity they have access to. Note: apikey details are only included in the response
   * when  creating a Service ID with an api key.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - Unique ID of the service ID.
   * @param {boolean} [params.includeHistory] - Defines if the entity history is included in the response.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.ServiceId>>}
   */
  public getServiceId(
    params: IamIdentityV1.GetServiceIdParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.ServiceId>> {
    const _params = { ...params };
    const requiredParams = ['id'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'include_history': _params.includeHistory,
    };

    const path = {
      'id': _params.id,
    };

    const sdkHeaders = getSdkHeaders(IamIdentityV1.DEFAULT_SERVICE_NAME, 'v1', 'getServiceId');

    const parameters = {
      options: {
        url: '/v1/serviceids/{id}',
        method: 'GET',
        qs: query,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Update service ID.
   *
   * Updates properties of a service ID. This does NOT affect existing access tokens. Their token content will stay
   * unchanged until the access token is refreshed. To update a service ID, pass the property to be modified. To delete
   * one property's value, pass the property with an empty value "".Users can manage user API keys for themself, or
   * service ID API keys for service IDs that are bound to an entity they have access to.   Note: apikey details are
   * only included in the response when creating a  Service ID with an apikey.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - Unique ID of the service ID to be updated.
   * @param {string} params.ifMatch - Version of the service ID to be updated. Specify the version that you retrieved as
   * entity_tag (ETag header) when reading the service ID. This value helps identifying parallel usage of this API. Pass
   * * to indicate to update any version available. This might result in stale updates.
   * @param {string} [params.name] - The name of the service ID to update. If specified in the request the parameter
   * must not be empty. The name is not checked for uniqueness. Failure to this will result in an Error condition.
   * @param {string} [params.description] - The description of the service ID to update. If specified an empty
   * description will clear the description of the service ID. If an non empty value is provided the service ID will be
   * updated.
   * @param {string[]} [params.uniqueInstanceCrns] - List of CRNs which point to the services connected to this service
   * ID. If specified an empty list will clear all existing unique instance crns of the service ID.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.ServiceId>>}
   */
  public updateServiceId(
    params: IamIdentityV1.UpdateServiceIdParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.ServiceId>> {
    const _params = { ...params };
    const requiredParams = ['id', 'ifMatch'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'name': _params.name,
      'description': _params.description,
      'unique_instance_crns': _params.uniqueInstanceCrns,
    };

    const path = {
      'id': _params.id,
    };

    const sdkHeaders = getSdkHeaders(IamIdentityV1.DEFAULT_SERVICE_NAME, 'v1', 'updateServiceId');

    const parameters = {
      options: {
        url: '/v1/serviceids/{id}',
        method: 'PUT',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'If-Match': _params.ifMatch,
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Deletes a service ID and associated API keys.
   *
   * Deletes a service ID and all API keys associated to it. Before deleting the service ID, all associated API keys are
   * deleted. In case a Delete Conflict (status code 409) a retry of the request may help as the service ID is only
   * deleted if the associated API keys were successfully deleted before. Users can manage user API keys for themself,
   * or service ID API keys for service IDs that are bound to an entity they have access to.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - Unique ID of the service ID.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.Empty>>}
   */
  public deleteServiceId(
    params: IamIdentityV1.DeleteServiceIdParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['id'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'id': _params.id,
    };

    const sdkHeaders = getSdkHeaders(IamIdentityV1.DEFAULT_SERVICE_NAME, 'v1', 'deleteServiceId');

    const parameters = {
      options: {
        url: '/v1/serviceids/{id}',
        method: 'DELETE',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {}, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Lock the service ID.
   *
   * Locks a service ID by ID. Users can manage user API keys for themself, or service ID API keys for service IDs that
   * are bound to an entity they have access to. In case of service IDs and their API keys, a user must be either an
   * account owner, a IBM Cloud org manager or IBM Cloud space developer in order to manage service IDs of the entity.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - Unique ID of the service ID.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.Empty>>}
   */
  public lockServiceId(
    params: IamIdentityV1.LockServiceIdParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['id'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'id': _params.id,
    };

    const sdkHeaders = getSdkHeaders(IamIdentityV1.DEFAULT_SERVICE_NAME, 'v1', 'lockServiceId');

    const parameters = {
      options: {
        url: '/v1/serviceids/{id}/lock',
        method: 'POST',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {}, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Unlock the service ID.
   *
   * Unlocks a service ID by ID. Users can manage user API keys for themself, or service ID API keys for service IDs
   * that are bound to an entity they have access to. In case of service IDs and their API keys, a user must be either
   * an account owner, a IBM Cloud org manager or IBM Cloud space developer in order to manage service IDs of the
   * entity.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - Unique ID of the service ID.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.Empty>>}
   */
  public unlockServiceId(
    params: IamIdentityV1.UnlockServiceIdParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['id'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'id': _params.id,
    };

    const sdkHeaders = getSdkHeaders(IamIdentityV1.DEFAULT_SERVICE_NAME, 'v1', 'unlockServiceId');

    const parameters = {
      options: {
        url: '/v1/serviceids/{id}/lock',
        method: 'DELETE',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {}, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  }
  /*************************
   * trustedProfilesOperations
   ************************/

  /**
   * Create a trusted profile.
   *
   * Creates a trusted profile for a given account ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.name - Name of the trusted profile. The name is checked for uniqueness. Therefore trusted
   * profiles with the same names can not exist in the same account.
   * @param {string} params.accountId - The account ID of the trusted profile.
   * @param {string} [params.description] - The optional description of the trusted profile. The 'description' property
   * is only available if a description was provided during creation of trusted profile.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.TrustedProfile>>}
   */
  public createProfile(
    params: IamIdentityV1.CreateProfileParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.TrustedProfile>> {
    const _params = { ...params };
    const requiredParams = ['name', 'accountId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'name': _params.name,
      'account_id': _params.accountId,
      'description': _params.description,
    };

    const sdkHeaders = getSdkHeaders(IamIdentityV1.DEFAULT_SERVICE_NAME, 'v1', 'createProfile');

    const parameters = {
      options: {
        url: '/v1/profiles',
        method: 'POST',
        body,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Get list of trusted profiles for a given account ID.
   *
   * Returns the list of trusted profiles for a given account ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - Account ID to query for trusted profiles.
   * @param {string} [params.name] - Name of the trusted profile to query.
   * @param {number} [params.pagesize] - Optional size of a single page. Default is 20 items per page. Valid range is 1
   * to 100.
   * @param {string} [params.sort] - Optional sort property, valid values are name, description, created_at and
   * modified_at. If specified, the items are sorted by the value of this property.
   * @param {string} [params.order] - Optional sort order, valid values are asc and desc. Default: asc.
   * @param {boolean} [params.includeHistory] - Defines if the entity history is included in the response.
   * @param {string} [params.pagetoken] - Optional Prev or Next page token returned from a previous query execution.
   * Default is start with first page.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.TrustedProfilesList>>}
   */
  public listProfile(
    params: IamIdentityV1.ListProfileParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.TrustedProfilesList>> {
    const _params = { ...params };
    const requiredParams = ['accountId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'account_id': _params.accountId,
      'name': _params.name,
      'pagesize': _params.pagesize,
      'sort': _params.sort,
      'order': _params.order,
      'include_history': _params.includeHistory,
      'pagetoken': _params.pagetoken,
    };

    const sdkHeaders = getSdkHeaders(IamIdentityV1.DEFAULT_SERVICE_NAME, 'v1', 'listProfile');

    const parameters = {
      options: {
        url: '/v1/profiles',
        method: 'GET',
        qs: query,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Get a trusted profile.
   *
   * Get a trusted profile.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.profileId - ID of the trusted profile to get.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.TrustedProfile>>}
   */
  public getProfile(
    params: IamIdentityV1.GetProfileParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.TrustedProfile>> {
    const _params = { ...params };
    const requiredParams = ['profileId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'profile-id': _params.profileId,
    };

    const sdkHeaders = getSdkHeaders(IamIdentityV1.DEFAULT_SERVICE_NAME, 'v1', 'getProfile');

    const parameters = {
      options: {
        url: '/v1/profiles/{profile-id}',
        method: 'GET',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Update a trusted profile.
   *
   * Updates a trusted profile.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.profileId - ID of the trusted profile to be updated.
   * @param {string} params.ifMatch - Version of the trusted profile to be updated.  Specify the version that you
   * retrived when reading list of trusted profiles. This value helps to identify any parallel usage of trusted profile.
   * Pass * to indicate to update any version available. This might result in stale updates.
   * @param {string} [params.name] - The name of the trusted profile to update. If specified in the request the
   * parameter must not be empty. The name is checked for uniqueness. Failure to this will result in an Error condition.
   * @param {string} [params.description] - The description of the trusted profile to update. If specified an empty
   * description will clear the description of the trusted profile. If a non empty value is provided the trusted profile
   * will be updated.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.TrustedProfile>>}
   */
  public updateProfile(
    params: IamIdentityV1.UpdateProfileParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.TrustedProfile>> {
    const _params = { ...params };
    const requiredParams = ['profileId', 'ifMatch'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'name': _params.name,
      'description': _params.description,
    };

    const path = {
      'profile-id': _params.profileId,
    };

    const sdkHeaders = getSdkHeaders(IamIdentityV1.DEFAULT_SERVICE_NAME, 'v1', 'updateProfile');

    const parameters = {
      options: {
        url: '/v1/profiles/{profile-id}',
        method: 'PUT',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'If-Match': _params.ifMatch,
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Delete a trusted profile.
   *
   * Deletes a trusted profile.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.profileId - ID of the trusted profile.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.Empty>>}
   */
  public deleteProfile(
    params: IamIdentityV1.DeleteProfileParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['profileId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'profile-id': _params.profileId,
    };

    const sdkHeaders = getSdkHeaders(IamIdentityV1.DEFAULT_SERVICE_NAME, 'v1', 'deleteProfile');

    const parameters = {
      options: {
        url: '/v1/profiles/{profile-id}',
        method: 'DELETE',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {}, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Create claim rule for a trusted profile.
   *
   * Claim rule can be created for a given trusted profile, There is a limit of 20 rules allowed per trusted profile.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.profileId - ID of the trusted profile to create a claim rule.
   * @param {string} params.type - Type of the calim rule, either 'Profile-SAML' or 'Profile-CR'.
   * @param {ProfileClaimRuleConditions[]} params.conditions - Conditions of this claim rule.
   * @param {ResponseContext} [params.context] - Context with key properties for problem determination.
   * @param {string} [params.name] - Name of the claim rule to be created or updated.
   * @param {string} [params.realmName] - The realm name of the Idp this claim rule applies to. This field is required
   * only if the type is specified as 'Profile-SAML'.
   * @param {string} [params.crType] - The compute resource type the rule applies to, required only if type is specified
   * as 'Profile-CR'. Valid values are VSI, IKS_SA, ROKS_SA.
   * @param {number} [params.expiration] - Session expiration in seconds, only required if type is 'Profile-SAML'.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.ProfileClaimRule>>}
   */
  public createClaimRule(
    params: IamIdentityV1.CreateClaimRuleParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.ProfileClaimRule>> {
    const _params = { ...params };
    const requiredParams = ['profileId', 'type', 'conditions'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'type': _params.type,
      'conditions': _params.conditions,
      'context': _params.context,
      'name': _params.name,
      'realm_name': _params.realmName,
      'cr_type': _params.crType,
      'expiration': _params.expiration,
    };

    const path = {
      'profile-id': _params.profileId,
    };

    const sdkHeaders = getSdkHeaders(IamIdentityV1.DEFAULT_SERVICE_NAME, 'v1', 'createClaimRule');

    const parameters = {
      options: {
        url: '/v1/profiles/{profile-id}/rules',
        method: 'POST',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Get all claim rules for a given trusted profile.
   *
   * Returns list of claim rules for a trusted profile.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.profileId - ID of the trusted profile.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.ProfileClaimRuleList>>}
   */
  public listClaimRules(
    params: IamIdentityV1.ListClaimRulesParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.ProfileClaimRuleList>> {
    const _params = { ...params };
    const requiredParams = ['profileId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'profile-id': _params.profileId,
    };

    const sdkHeaders = getSdkHeaders(IamIdentityV1.DEFAULT_SERVICE_NAME, 'v1', 'listClaimRules');

    const parameters = {
      options: {
        url: '/v1/profiles/{profile-id}/rules',
        method: 'GET',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Get claim rule for a trusted profile.
   *
   * Claim rule can be fetched for a given trusted profile ID and rule ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.profileId - ID of the trusted profile.
   * @param {string} params.ruleId - ID of the claim rule to get.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.ProfileClaimRule>>}
   */
  public getClaimRule(
    params: IamIdentityV1.GetClaimRuleParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.ProfileClaimRule>> {
    const _params = { ...params };
    const requiredParams = ['profileId', 'ruleId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'profile-id': _params.profileId,
      'rule-id': _params.ruleId,
    };

    const sdkHeaders = getSdkHeaders(IamIdentityV1.DEFAULT_SERVICE_NAME, 'v1', 'getClaimRule');

    const parameters = {
      options: {
        url: '/v1/profiles/{profile-id}/rules/{rule-id}',
        method: 'GET',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Update claim rule for a trusted profile.
   *
   * Claim rule can be updated for a given trusted profile ID and rule ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.profileId - ID of the trusted profile.
   * @param {string} params.ruleId - ID of the claim rule to update.
   * @param {string} params.ifMatch - Version of the claim rule to be updated.  Specify the version that you retrived
   * when reading list of claim rules. This value helps to identify any parallel usage of claim rule. Pass * to indicate
   * to update any version available. This might result in stale updates.
   * @param {string} params.type - Type of the calim rule, either 'Profile-SAML' or 'Profile-CR'.
   * @param {ProfileClaimRuleConditions[]} params.conditions - Conditions of this claim rule.
   * @param {ResponseContext} [params.context] - Context with key properties for problem determination.
   * @param {string} [params.name] - Name of the claim rule to be created or updated.
   * @param {string} [params.realmName] - The realm name of the Idp this claim rule applies to. This field is required
   * only if the type is specified as 'Profile-SAML'.
   * @param {string} [params.crType] - The compute resource type the rule applies to, required only if type is specified
   * as 'Profile-CR'. Valid values are VSI, IKS_SA, ROKS_SA.
   * @param {number} [params.expiration] - Session expiration in seconds, only required if type is 'Profile-SAML'.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.ProfileClaimRule>>}
   */
  public updateClaimRule(
    params: IamIdentityV1.UpdateClaimRuleParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.ProfileClaimRule>> {
    const _params = { ...params };
    const requiredParams = ['profileId', 'ruleId', 'ifMatch', 'type', 'conditions'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'type': _params.type,
      'conditions': _params.conditions,
      'context': _params.context,
      'name': _params.name,
      'realm_name': _params.realmName,
      'cr_type': _params.crType,
      'expiration': _params.expiration,
    };

    const path = {
      'profile-id': _params.profileId,
      'rule-id': _params.ruleId,
    };

    const sdkHeaders = getSdkHeaders(IamIdentityV1.DEFAULT_SERVICE_NAME, 'v1', 'updateClaimRule');

    const parameters = {
      options: {
        url: '/v1/profiles/{profile-id}/rules/{rule-id}',
        method: 'PUT',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'If-Match': _params.ifMatch,
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Delete a claim rule.
   *
   * Deletes a claim rule.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.profileId - ID of the trusted profile.
   * @param {string} params.ruleId - ID of the claim rule to delete.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.Empty>>}
   */
  public deleteClaimRule(
    params: IamIdentityV1.DeleteClaimRuleParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['profileId', 'ruleId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'profile-id': _params.profileId,
      'rule-id': _params.ruleId,
    };

    const sdkHeaders = getSdkHeaders(IamIdentityV1.DEFAULT_SERVICE_NAME, 'v1', 'deleteClaimRule');

    const parameters = {
      options: {
        url: '/v1/profiles/{profile-id}/rules/{rule-id}',
        method: 'DELETE',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {}, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Create link to a trusted profile.
   *
   * Link compute resource to a trusted profile.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.profileId - ID of the trusted profile.
   * @param {string} params.crType - The compute resource type. Valid values are VSI, IKS_SA, ROKS_SA.
   * @param {CreateProfileLinkRequestLink} params.link - Link details.
   * @param {string} [params.name] - Optional name of the Link.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.ProfileLink>>}
   */
  public createLink(
    params: IamIdentityV1.CreateLinkParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.ProfileLink>> {
    const _params = { ...params };
    const requiredParams = ['profileId', 'crType', 'link'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'cr_type': _params.crType,
      'link': _params.link,
      'name': _params.name,
    };

    const path = {
      'profile-id': _params.profileId,
    };

    const sdkHeaders = getSdkHeaders(IamIdentityV1.DEFAULT_SERVICE_NAME, 'v1', 'createLink');

    const parameters = {
      options: {
        url: '/v1/profiles/{profile-id}/links',
        method: 'POST',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Get list of links to a trusted profile.
   *
   * Gets list of link to a trusted profile.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.profileId - ID of the trusted profile.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.ProfileLinkList>>}
   */
  public listLink(
    params: IamIdentityV1.ListLinkParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.ProfileLinkList>> {
    const _params = { ...params };
    const requiredParams = ['profileId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'profile-id': _params.profileId,
    };

    const sdkHeaders = getSdkHeaders(IamIdentityV1.DEFAULT_SERVICE_NAME, 'v1', 'listLink');

    const parameters = {
      options: {
        url: '/v1/profiles/{profile-id}/links',
        method: 'GET',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Get link to a trusted profile.
   *
   * Gets link to a trusted profile.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.profileId - ID of the trusted profile.
   * @param {string} params.linkId - ID of the link.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.ProfileLink>>}
   */
  public getLink(
    params: IamIdentityV1.GetLinkParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.ProfileLink>> {
    const _params = { ...params };
    const requiredParams = ['profileId', 'linkId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'profile-id': _params.profileId,
      'link-id': _params.linkId,
    };

    const sdkHeaders = getSdkHeaders(IamIdentityV1.DEFAULT_SERVICE_NAME, 'v1', 'getLink');

    const parameters = {
      options: {
        url: '/v1/profiles/{profile-id}/links/{link-id}',
        method: 'GET',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Delete link to a trusted profile.
   *
   * Deletes link to a trusted profile.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.profileId - ID of the trusted profile.
   * @param {string} params.linkId - ID of the link.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.Empty>>}
   */
  public deleteLink(
    params: IamIdentityV1.DeleteLinkParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['profileId', 'linkId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'profile-id': _params.profileId,
      'link-id': _params.linkId,
    };

    const sdkHeaders = getSdkHeaders(IamIdentityV1.DEFAULT_SERVICE_NAME, 'v1', 'deleteLink');

    const parameters = {
      options: {
        url: '/v1/profiles/{profile-id}/links/{link-id}',
        method: 'DELETE',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {}, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  }
  /*************************
   * accountSettings
   ************************/

  /**
   * Get account configurations.
   *
   * Returns the details of an account's configuration.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - Unique ID of the account.
   * @param {boolean} [params.includeHistory] - Defines if the entity history is included in the response.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.AccountSettingsResponse>>}
   */
  public getAccountSettings(
    params: IamIdentityV1.GetAccountSettingsParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.AccountSettingsResponse>> {
    const _params = { ...params };
    const requiredParams = ['accountId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'include_history': _params.includeHistory,
    };

    const path = {
      'account_id': _params.accountId,
    };

    const sdkHeaders = getSdkHeaders(
      IamIdentityV1.DEFAULT_SERVICE_NAME,
      'v1',
      'getAccountSettings'
    );

    const parameters = {
      options: {
        url: '/v1/accounts/{account_id}/settings/identity',
        method: 'GET',
        qs: query,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Update account configurations.
   *
   * Allows a user to configure settings on their account with regards to MFA, session lifetimes,  access control for
   * creating new identities, and enforcing IP restrictions on  token creation.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.ifMatch - Version of the account settings to be updated. Specify the version that you
   * retrieved as entity_tag (ETag header) when reading the account. This value helps  identifying parallel usage of
   * this API. Pass * to indicate to update any version  available. This might result in stale updates.
   * @param {string} params.accountId - The id of the account to update the settings for.
   * @param {string} [params.restrictCreateServiceId] - Defines whether or not creating a Service Id is access
   * controlled. Valid values:
   *   * RESTRICTED - to apply access control
   *   * NOT_RESTRICTED - to remove access control
   *   * NOT_SET - to unset a previously set value.
   * @param {string} [params.restrictCreatePlatformApikey] - Defines whether or not creating platform API keys is access
   * controlled. Valid values:
   *   * RESTRICTED - to apply access control
   *   * NOT_RESTRICTED - to remove access control
   *   * NOT_SET - to 'unset' a previous set value.
   * @param {string} [params.allowedIpAddresses] - Defines the IP addresses and subnets from which IAM tokens can be
   * created for the account.
   * @param {string} [params.mfa] - Defines the MFA trait for the account. Valid values:
   *   * NONE - No MFA trait set
   *   * TOTP - For all non-federated IBMId users
   *   * TOTP4ALL - For all users
   *   * LEVEL1 - Email-based MFA for all users
   *   * LEVEL2 - TOTP-based MFA for all users
   *   * LEVEL3 - U2F MFA for all users.
   * @param {string} [params.sessionExpirationInSeconds] - Defines the session expiration in seconds for the account.
   * Valid values:
   *   * Any whole number between between '900' and '86400'
   *   * NOT_SET - To unset account setting and use service default.
   * @param {string} [params.sessionInvalidationInSeconds] - Defines the period of time in seconds in which a session
   * will be invalidated due  to inactivity. Valid values:
   *   * Any whole number between '900' and '7200'
   *   * NOT_SET - To unset account setting and use service default.
   * @param {string} [params.maxSessionsPerIdentity] - Defines the max allowed sessions per identity required by the
   * account. Value values:
   *   * Any whole number greater than 0
   *   * NOT_SET - To unset account setting and use service default.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamIdentityV1.Response<IamIdentityV1.AccountSettingsResponse>>}
   */
  public updateAccountSettings(
    params: IamIdentityV1.UpdateAccountSettingsParams
  ): Promise<IamIdentityV1.Response<IamIdentityV1.AccountSettingsResponse>> {
    const _params = { ...params };
    const requiredParams = ['ifMatch', 'accountId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'restrict_create_service_id': _params.restrictCreateServiceId,
      'restrict_create_platform_apikey': _params.restrictCreatePlatformApikey,
      'allowed_ip_addresses': _params.allowedIpAddresses,
      'mfa': _params.mfa,
      'session_expiration_in_seconds': _params.sessionExpirationInSeconds,
      'session_invalidation_in_seconds': _params.sessionInvalidationInSeconds,
      'max_sessions_per_identity': _params.maxSessionsPerIdentity,
    };

    const path = {
      'account_id': _params.accountId,
    };

    const sdkHeaders = getSdkHeaders(
      IamIdentityV1.DEFAULT_SERVICE_NAME,
      'v1',
      'updateAccountSettings'
    );

    const parameters = {
      options: {
        url: '/v1/accounts/{account_id}/settings/identity',
        method: 'PUT',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'If-Match': _params.ifMatch,
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }
}

/*************************
 * interfaces
 ************************/

namespace IamIdentityV1 {
  /** An operation response. */
  export interface Response<T = any> {
    result: T;
    status: number;
    statusText: string;
    headers: IncomingHttpHeaders;
  }

  /** The callback for a service request. */
  export type Callback<T> = (error: any, response?: Response<T>) => void;

  /** The body of a service request that returns no response data. */
  export interface Empty {}

  /** A standard JS object, defined to avoid the limitations of `Object` and `object` */
  export interface JsonObject {
    [key: string]: any;
  }

  /*************************
   * request interfaces
   ************************/

  /** Parameters for the `listApiKeys` operation. */
  export interface ListApiKeysParams {
    /** Account ID of the API keys(s) to query. If a service IAM ID is specified in iam_id then account_id must
     *  match the account of the IAM ID. If a user IAM ID is specified in iam_id then then account_id must match the
     *  account of the Authorization token.
     */
    accountId?: string;
    /** IAM ID of the API key(s) to be queried. The IAM ID may be that of a user or a service. For a user IAM ID
     *  iam_id must match the Authorization token.
     */
    iamId?: string;
    /** Optional size of a single page. Default is 20 items per page. Valid range is 1 to 100. */
    pagesize?: number;
    /** Optional Prev or Next page token returned from a previous query execution. Default is start with first page. */
    pagetoken?: string;
    /** Optional parameter to define the scope of the queried API Keys. Can be 'entity' (default) or 'account'. */
    scope?: ListApiKeysConstants.Scope | string;
    /** Optional parameter to filter the type of the queried API Keys. Can be 'user' or 'serviceid'. */
    type?: ListApiKeysConstants.Type | string;
    /** Optional sort property, valid values are name, description, created_at and created_by. If specified, the
     *  items are sorted by the value of this property.
     */
    sort?: string;
    /** Optional sort order, valid values are asc and desc. Default: asc. */
    order?: ListApiKeysConstants.Order | string;
    /** Defines if the entity history is included in the response. */
    includeHistory?: boolean;
    headers?: OutgoingHttpHeaders;
  }

  /** Constants for the `listApiKeys` operation. */
  export namespace ListApiKeysConstants {
    /** Optional parameter to define the scope of the queried API Keys. Can be 'entity' (default) or 'account'. */
    export enum Scope {
      ENTITY = 'entity',
      ACCOUNT = 'account',
    }
    /** Optional parameter to filter the type of the queried API Keys. Can be 'user' or 'serviceid'. */
    export enum Type {
      USER = 'user',
      SERVICEID = 'serviceid',
    }
    /** Optional sort order, valid values are asc and desc. Default: asc. */
    export enum Order {
      ASC = 'asc',
      DESC = 'desc',
    }
  }

  /** Parameters for the `createApiKey` operation. */
  export interface CreateApiKeyParams {
    /** Name of the API key. The name is not checked for uniqueness. Therefore multiple names with the same value
     *  can exist. Access is done via the UUID of the API key.
     */
    name: string;
    /** The iam_id that this API key authenticates. */
    iamId: string;
    /** The optional description of the API key. The 'description' property is only available if a description was
     *  provided during a create of an API key.
     */
    description?: string;
    /** The account ID of the API key. */
    accountId?: string;
    /** You can optionally passthrough the API key value for this API key. If passed, NO validation of that apiKey
     *  value is done, i.e. the value can be non-URL safe. If omitted, the API key management will create an URL safe
     *  opaque API key value. The value of the API key is checked for uniqueness. Please ensure enough variations when
     *  passing in this value.
     */
    apikey?: string;
    /** Send true or false to set whether the API key value is retrievable in the future by using the Get details of
     *  an API key request. If you create an API key for a user, you must specify `false` or omit the value. We don't
     *  allow storing of API keys for users.
     */
    storeValue?: boolean;
    /** Indicates if the API key is locked for further write operations. False by default. */
    entityLock?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getApiKeysDetails` operation. */
  export interface GetApiKeysDetailsParams {
    /** API key value. */
    iamApiKey?: string;
    /** Defines if the entity history is included in the response. */
    includeHistory?: boolean;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getApiKey` operation. */
  export interface GetApiKeyParams {
    /** Unique ID of the API key. */
    id: string;
    /** Defines if the entity history is included in the response. */
    includeHistory?: boolean;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `updateApiKey` operation. */
  export interface UpdateApiKeyParams {
    /** Unique ID of the API key to be updated. */
    id: string;
    /** Version of the API key to be updated. Specify the version that you retrieved when reading the API key. This
     *  value  helps identifying parallel usage of this API. Pass * to indicate to update any version available. This
     *  might result in stale updates.
     */
    ifMatch: string;
    /** The name of the API key to update. If specified in the request the parameter must not be empty. The name is
     *  not checked for uniqueness. Failure to this will result in an Error condition.
     */
    name?: string;
    /** The description of the API key to update. If specified an empty description will clear the description of
     *  the API key. If a non empty value is provided the API key will be updated.
     */
    description?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deleteApiKey` operation. */
  export interface DeleteApiKeyParams {
    /** Unique ID of the API key. */
    id: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `lockApiKey` operation. */
  export interface LockApiKeyParams {
    /** Unique ID of the API key. */
    id: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `unlockApiKey` operation. */
  export interface UnlockApiKeyParams {
    /** Unique ID of the API key. */
    id: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listServiceIds` operation. */
  export interface ListServiceIdsParams {
    /** Account ID of the service ID(s) to query. This parameter is required (unless using a pagetoken). */
    accountId?: string;
    /** Name of the service ID(s) to query. Optional.20 items per page. Valid range is 1 to 100. */
    name?: string;
    /** Optional size of a single page. Default is 20 items per page. Valid range is 1 to 100. */
    pagesize?: number;
    /** Optional Prev or Next page token returned from a previous query execution. Default is start with first page. */
    pagetoken?: string;
    /** Optional sort property, valid values are name, description, created_at and modified_at. If specified, the
     *  items are sorted by the value of this property.
     */
    sort?: string;
    /** Optional sort order, valid values are asc and desc. Default: asc. */
    order?: ListServiceIdsConstants.Order | string;
    /** Defines if the entity history is included in the response. */
    includeHistory?: boolean;
    headers?: OutgoingHttpHeaders;
  }

  /** Constants for the `listServiceIds` operation. */
  export namespace ListServiceIdsConstants {
    /** Optional sort order, valid values are asc and desc. Default: asc. */
    export enum Order {
      ASC = 'asc',
      DESC = 'desc',
    }
  }

  /** Parameters for the `createServiceId` operation. */
  export interface CreateServiceIdParams {
    /** ID of the account the service ID belongs to. */
    accountId: string;
    /** Name of the Service Id. The name is not checked for uniqueness. Therefore multiple names with the same value
     *  can exist. Access is done via the UUID of the Service Id.
     */
    name: string;
    /** The optional description of the Service Id. The 'description' property is only available if a description
     *  was provided during a create of a Service Id.
     */
    description?: string;
    /** Optional list of CRNs (string array) which point to the services connected to the service ID. */
    uniqueInstanceCrns?: string[];
    /** Parameters for the API key in the Create service Id V1 REST request. */
    apikey?: ApiKeyInsideCreateServiceIdRequest;
    /** Indicates if the service ID is locked for further write operations. False by default. */
    entityLock?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getServiceId` operation. */
  export interface GetServiceIdParams {
    /** Unique ID of the service ID. */
    id: string;
    /** Defines if the entity history is included in the response. */
    includeHistory?: boolean;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `updateServiceId` operation. */
  export interface UpdateServiceIdParams {
    /** Unique ID of the service ID to be updated. */
    id: string;
    /** Version of the service ID to be updated. Specify the version that you retrieved as entity_tag (ETag header)
     *  when reading the service ID. This value helps identifying parallel usage of this API. Pass * to indicate to
     *  update any version available. This might result in stale updates.
     */
    ifMatch: string;
    /** The name of the service ID to update. If specified in the request the parameter must not be empty. The name
     *  is not checked for uniqueness. Failure to this will result in an Error condition.
     */
    name?: string;
    /** The description of the service ID to update. If specified an empty description will clear the description of
     *  the service ID. If an non empty value is provided the service ID will be updated.
     */
    description?: string;
    /** List of CRNs which point to the services connected to this service ID. If specified an empty list will clear
     *  all existing unique instance crns of the service ID.
     */
    uniqueInstanceCrns?: string[];
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deleteServiceId` operation. */
  export interface DeleteServiceIdParams {
    /** Unique ID of the service ID. */
    id: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `lockServiceId` operation. */
  export interface LockServiceIdParams {
    /** Unique ID of the service ID. */
    id: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `unlockServiceId` operation. */
  export interface UnlockServiceIdParams {
    /** Unique ID of the service ID. */
    id: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `createProfile` operation. */
  export interface CreateProfileParams {
    /** Name of the trusted profile. The name is checked for uniqueness. Therefore trusted profiles with the same
     *  names can not exist in the same account.
     */
    name: string;
    /** The account ID of the trusted profile. */
    accountId: string;
    /** The optional description of the trusted profile. The 'description' property is only available if a
     *  description was provided during creation of trusted profile.
     */
    description?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listProfile` operation. */
  export interface ListProfileParams {
    /** Account ID to query for trusted profiles. */
    accountId: string;
    /** Name of the trusted profile to query. */
    name?: string;
    /** Optional size of a single page. Default is 20 items per page. Valid range is 1 to 100. */
    pagesize?: number;
    /** Optional sort property, valid values are name, description, created_at and modified_at. If specified, the
     *  items are sorted by the value of this property.
     */
    sort?: string;
    /** Optional sort order, valid values are asc and desc. Default: asc. */
    order?: ListProfileConstants.Order | string;
    /** Defines if the entity history is included in the response. */
    includeHistory?: boolean;
    /** Optional Prev or Next page token returned from a previous query execution. Default is start with first page. */
    pagetoken?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Constants for the `listProfile` operation. */
  export namespace ListProfileConstants {
    /** Optional sort order, valid values are asc and desc. Default: asc. */
    export enum Order {
      ASC = 'asc',
      DESC = 'desc',
    }
  }

  /** Parameters for the `getProfile` operation. */
  export interface GetProfileParams {
    /** ID of the trusted profile to get. */
    profileId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `updateProfile` operation. */
  export interface UpdateProfileParams {
    /** ID of the trusted profile to be updated. */
    profileId: string;
    /** Version of the trusted profile to be updated.  Specify the version that you retrived when reading list of
     *  trusted profiles. This value helps to identify any parallel usage of trusted profile. Pass * to indicate to
     *  update any version available. This might result in stale updates.
     */
    ifMatch: string;
    /** The name of the trusted profile to update. If specified in the request the parameter must not be empty. The
     *  name is checked for uniqueness. Failure to this will result in an Error condition.
     */
    name?: string;
    /** The description of the trusted profile to update. If specified an empty description will clear the
     *  description of the trusted profile. If a non empty value is provided the trusted profile will be updated.
     */
    description?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deleteProfile` operation. */
  export interface DeleteProfileParams {
    /** ID of the trusted profile. */
    profileId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `createClaimRule` operation. */
  export interface CreateClaimRuleParams {
    /** ID of the trusted profile to create a claim rule. */
    profileId: string;
    /** Type of the calim rule, either 'Profile-SAML' or 'Profile-CR'. */
    type: string;
    /** Conditions of this claim rule. */
    conditions: ProfileClaimRuleConditions[];
    /** Context with key properties for problem determination. */
    context?: ResponseContext;
    /** Name of the claim rule to be created or updated. */
    name?: string;
    /** The realm name of the Idp this claim rule applies to. This field is required only if the type is specified
     *  as 'Profile-SAML'.
     */
    realmName?: string;
    /** The compute resource type the rule applies to, required only if type is specified as 'Profile-CR'. Valid
     *  values are VSI, IKS_SA, ROKS_SA.
     */
    crType?: string;
    /** Session expiration in seconds, only required if type is 'Profile-SAML'. */
    expiration?: number;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listClaimRules` operation. */
  export interface ListClaimRulesParams {
    /** ID of the trusted profile. */
    profileId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getClaimRule` operation. */
  export interface GetClaimRuleParams {
    /** ID of the trusted profile. */
    profileId: string;
    /** ID of the claim rule to get. */
    ruleId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `updateClaimRule` operation. */
  export interface UpdateClaimRuleParams {
    /** ID of the trusted profile. */
    profileId: string;
    /** ID of the claim rule to update. */
    ruleId: string;
    /** Version of the claim rule to be updated.  Specify the version that you retrived when reading list of claim
     *  rules. This value helps to identify any parallel usage of claim rule. Pass * to indicate to update any version
     *  available. This might result in stale updates.
     */
    ifMatch: string;
    /** Type of the calim rule, either 'Profile-SAML' or 'Profile-CR'. */
    type: string;
    /** Conditions of this claim rule. */
    conditions: ProfileClaimRuleConditions[];
    /** Context with key properties for problem determination. */
    context?: ResponseContext;
    /** Name of the claim rule to be created or updated. */
    name?: string;
    /** The realm name of the Idp this claim rule applies to. This field is required only if the type is specified
     *  as 'Profile-SAML'.
     */
    realmName?: string;
    /** The compute resource type the rule applies to, required only if type is specified as 'Profile-CR'. Valid
     *  values are VSI, IKS_SA, ROKS_SA.
     */
    crType?: string;
    /** Session expiration in seconds, only required if type is 'Profile-SAML'. */
    expiration?: number;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deleteClaimRule` operation. */
  export interface DeleteClaimRuleParams {
    /** ID of the trusted profile. */
    profileId: string;
    /** ID of the claim rule to delete. */
    ruleId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `createLink` operation. */
  export interface CreateLinkParams {
    /** ID of the trusted profile. */
    profileId: string;
    /** The compute resource type. Valid values are VSI, IKS_SA, ROKS_SA. */
    crType: string;
    /** Link details. */
    link: CreateProfileLinkRequestLink;
    /** Optional name of the Link. */
    name?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listLink` operation. */
  export interface ListLinkParams {
    /** ID of the trusted profile. */
    profileId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getLink` operation. */
  export interface GetLinkParams {
    /** ID of the trusted profile. */
    profileId: string;
    /** ID of the link. */
    linkId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deleteLink` operation. */
  export interface DeleteLinkParams {
    /** ID of the trusted profile. */
    profileId: string;
    /** ID of the link. */
    linkId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getAccountSettings` operation. */
  export interface GetAccountSettingsParams {
    /** Unique ID of the account. */
    accountId: string;
    /** Defines if the entity history is included in the response. */
    includeHistory?: boolean;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `updateAccountSettings` operation. */
  export interface UpdateAccountSettingsParams {
    /** Version of the account settings to be updated. Specify the version that you  retrieved as entity_tag (ETag
     *  header) when reading the account. This value helps  identifying parallel usage of this API. Pass * to indicate
     *  to update any version  available. This might result in stale updates.
     */
    ifMatch: string;
    /** The id of the account to update the settings for. */
    accountId: string;
    /** Defines whether or not creating a Service Id is access controlled. Valid values:
     *    * RESTRICTED - to apply access control
     *    * NOT_RESTRICTED - to remove access control
     *    * NOT_SET - to unset a previously set value.
     */
    restrictCreateServiceId?: UpdateAccountSettingsConstants.RestrictCreateServiceId | string;
    /** Defines whether or not creating platform API keys is access controlled. Valid values:
     *    * RESTRICTED - to apply access control
     *    * NOT_RESTRICTED - to remove access control
     *    * NOT_SET - to 'unset' a previous set value.
     */
    restrictCreatePlatformApikey?:
      | UpdateAccountSettingsConstants.RestrictCreatePlatformApikey
      | string;
    /** Defines the IP addresses and subnets from which IAM tokens can be created for the account. */
    allowedIpAddresses?: string;
    /** Defines the MFA trait for the account. Valid values:
     *    * NONE - No MFA trait set
     *    * TOTP - For all non-federated IBMId users
     *    * TOTP4ALL - For all users
     *    * LEVEL1 - Email-based MFA for all users
     *    * LEVEL2 - TOTP-based MFA for all users
     *    * LEVEL3 - U2F MFA for all users.
     */
    mfa?: UpdateAccountSettingsConstants.Mfa | string;
    /** Defines the session expiration in seconds for the account. Valid values:
     *    * Any whole number between between '900' and '86400'
     *    * NOT_SET - To unset account setting and use service default.
     */
    sessionExpirationInSeconds?: string;
    /** Defines the period of time in seconds in which a session will be invalidated due  to inactivity. Valid
     *  values:
     *    * Any whole number between '900' and '7200'
     *    * NOT_SET - To unset account setting and use service default.
     */
    sessionInvalidationInSeconds?: string;
    /** Defines the max allowed sessions per identity required by the account. Value values:
     *    * Any whole number greater than 0
     *    * NOT_SET - To unset account setting and use service default.
     */
    maxSessionsPerIdentity?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Constants for the `updateAccountSettings` operation. */
  export namespace UpdateAccountSettingsConstants {
    /** Defines whether or not creating a Service Id is access controlled. Valid values: * RESTRICTED - to apply access control * NOT_RESTRICTED - to remove access control * NOT_SET - to unset a previously set value. */
    export enum RestrictCreateServiceId {
      RESTRICTED = 'RESTRICTED',
      NOT_RESTRICTED = 'NOT_RESTRICTED',
      NOT_SET = 'NOT_SET',
    }
    /** Defines whether or not creating platform API keys is access controlled. Valid values: * RESTRICTED - to apply access control * NOT_RESTRICTED - to remove access control * NOT_SET - to 'unset' a previous set value. */
    export enum RestrictCreatePlatformApikey {
      RESTRICTED = 'RESTRICTED',
      NOT_RESTRICTED = 'NOT_RESTRICTED',
      NOT_SET = 'NOT_SET',
    }
    /** Defines the MFA trait for the account. Valid values: * NONE - No MFA trait set * TOTP - For all non-federated IBMId users * TOTP4ALL - For all users * LEVEL1 - Email-based MFA for all users * LEVEL2 - TOTP-based MFA for all users * LEVEL3 - U2F MFA for all users. */
    export enum Mfa {
      NONE = 'NONE',
      TOTP = 'TOTP',
      TOTP4ALL = 'TOTP4ALL',
      LEVEL1 = 'LEVEL1',
      LEVEL2 = 'LEVEL2',
      LEVEL3 = 'LEVEL3',
    }
  }

  /*************************
   * model interfaces
   ************************/

  /** Response body format for Account Settings REST requests. */
  export interface AccountSettingsResponse {
    /** Context with key properties for problem determination. */
    context?: ResponseContext;
    /** Unique ID of the account. */
    account_id: string;
    /** Defines whether or not creating a Service Id is access controlled. Valid values:
     *    * RESTRICTED - to apply access control
     *    * NOT_RESTRICTED - to remove access control
     *    * NOT_SET - to 'unset' a previous set value.
     */
    restrict_create_service_id: string;
    /** Defines whether or not creating platform API keys is access controlled. Valid values:
     *    * RESTRICTED - to apply access control
     *    * NOT_RESTRICTED - to remove access control
     *    * NOT_SET - to 'unset' a previous set value.
     */
    restrict_create_platform_apikey: string;
    /** Defines the IP addresses and subnets from which IAM tokens can be created for the account. */
    allowed_ip_addresses: string;
    /** Version of the account settings. */
    entity_tag: string;
    /** Defines the MFA trait for the account. Valid values:
     *    * NONE - No MFA trait set
     *    * TOTP - For all non-federated IBMId users
     *    * TOTP4ALL - For all users
     *    * LEVEL1 - Email-based MFA for all users
     *    * LEVEL2 - TOTP-based MFA for all users
     *    * LEVEL3 - U2F MFA for all users.
     */
    mfa: string;
    /** History of the Account Settings. */
    history?: EnityHistoryRecord[];
    /** Defines the session expiration in seconds for the account. Valid values:
     *    * Any whole number between between '900' and '86400'
     *    * NOT_SET - To unset account setting and use service default.
     */
    session_expiration_in_seconds: string;
    /** Defines the period of time in seconds in which a session will be invalidated due  to inactivity. Valid
     *  values:
     *    * Any whole number between '900' and '7200'
     *    * NOT_SET - To unset account setting and use service default.
     */
    session_invalidation_in_seconds: string;
    /** Defines the max allowed sessions per identity required by the account. Valid values:
     *    * Any whole number greater than 0
     *    * NOT_SET - To unset account setting and use service default.
     */
    max_sessions_per_identity: string;
  }

  /** Response body format for API key V1 REST requests. */
  export interface ApiKey {
    /** Context with key properties for problem determination. */
    context?: ResponseContext;
    /** Unique identifier of this API Key. */
    id: string;
    /** Version of the API Key details object. You need to specify this value when updating the API key to avoid
     *  stale updates.
     */
    entity_tag?: string;
    /** Cloud Resource Name of the item. Example Cloud Resource Name:
     *  'crn:v1:bluemix:public:iam-identity:us-south:a/myaccount::apikey:1234-9012-5678'.
     */
    crn: string;
    /** The API key cannot be changed if set to true. */
    locked: boolean;
    /** If set contains a date time string of the creation date in ISO format. */
    created_at?: string;
    /** IAM ID of the user or service which created the API key. */
    created_by: string;
    /** If set contains a date time string of the last modification date in ISO format. */
    modified_at?: string;
    /** Name of the API key. The name is not checked for uniqueness. Therefore multiple names with the same value
     *  can exist. Access is done via the UUID of the API key.
     */
    name: string;
    /** The optional description of the API key. The 'description' property is only available if a description was
     *  provided during a create of an API key.
     */
    description?: string;
    /** The iam_id that this API key authenticates. */
    iam_id: string;
    /** ID of the account that this API key authenticates for. */
    account_id: string;
    /** The API key value. This property only contains the API key value for the following cases: create an API key,
     *  update a service ID API key that stores the API key value as retrievable, or get a service ID API key that
     *  stores the API key value as retrievable. All other operations don't return the API key value, for example all
     *  user API key related operations, except for create, don't contain the API key value.
     */
    apikey: string;
    /** History of the API key. */
    history?: EnityHistoryRecord[];
  }

  /** Parameters for the API key in the Create service Id V1 REST request. */
  export interface ApiKeyInsideCreateServiceIdRequest {
    /** Name of the API key. The name is not checked for uniqueness. Therefore multiple names with the same value
     *  can exist. Access is done via the UUID of the API key.
     */
    name: string;
    /** The optional description of the API key. The 'description' property is only available if a description was
     *  provided during a create of an API key.
     */
    description?: string;
    /** You can optionally passthrough the API key value for this API key. If passed, NO validation of that apiKey
     *  value is done, i.e. the value can be non-URL safe. If omitted, the API key management will create an URL safe
     *  opaque API key value. The value of the API key is checked for uniqueness. Please ensure enough variations when
     *  passing in this value.
     */
    apikey?: string;
    /** Send true or false to set whether the API key value is retrievable in the future by using the Get details of
     *  an API key request. If you create an API key for a user, you must specify `false` or omit the value. We don't
     *  allow storing of API keys for users.
     */
    store_value?: boolean;
  }

  /** Response body format for the List API keys V1 REST request. */
  export interface ApiKeyList {
    /** Context with key properties for problem determination. */
    context?: ResponseContext;
    /** The offset of the current page. */
    offset?: number;
    /** Optional size of a single page. Default is 20 items per page. Valid range is 1 to 100. */
    limit?: number;
    /** Link to the first page. */
    first?: string;
    /** Link to the previous available page. If 'previous' property is not part of the response no previous page is
     *  available.
     */
    previous?: string;
    /** Link to the next available page. If 'next' property is not part of the response no next page is available. */
    next?: string;
    /** List of API keys based on the query paramters and the page size. The apikeys array is always part of the
     *  response but might be empty depending on the query parameters values provided.
     */
    apikeys: ApiKey[];
  }

  /** Link details. */
  export interface CreateProfileLinkRequestLink {
    /** The CRN of the compute resource. */
    crn: string;
    /** The compute resource namespace, only required if cr_type is IKS_SA or ROKS_SA. */
    namespace: string;
    /** Name of the compute resource, only required if cr_type is IKS_SA or ROKS_SA. */
    name?: string;
  }

  /** Response body format for an entity history record. */
  export interface EnityHistoryRecord {
    /** Timestamp when the action was triggered. */
    timestamp: string;
    /** IAM ID of the identity which triggered the action. */
    iam_id: string;
    /** Account of the identity which triggered the action. */
    iam_id_account: string;
    /** Action of the history entry. */
    action: string;
    /** Params of the history entry. */
    params: string[];
    /** Message which summarizes the executed action. */
    message: string;
  }

  /** ProfileClaimRule. */
  export interface ProfileClaimRule {
    /** the unique identifier of the claim rule. */
    id: string;
    /** version of the claim rule. */
    entity_tag: string;
    /** If set contains a date time string of the creation date in ISO format. */
    created_at: string;
    /** If set contains a date time string of the last modification date in ISO format. */
    modified_at?: string;
    /** The optional claim rule name. */
    name?: string;
    /** Type of the Calim rule, either 'Profile-SAML' or 'Profile-CR'. */
    type: string;
    /** The realm name of the Idp this claim rule applies to. */
    realm_name?: string;
    /** Session expiration in seconds. */
    expiration: number;
    /** The compute resource type. Not required if type is Profile-SAML. Valid values are VSI, IKS_SA, ROKS_SA. */
    cr_type?: string;
    /** Conditions of this claim rule. */
    conditions: ProfileClaimRuleConditions[];
  }

  /** ProfileClaimRuleConditions. */
  export interface ProfileClaimRuleConditions {
    /** The claim to valuate againt. */
    claim: string;
    /** The operation to perform on the claim. valid values are EQUALS, NOT_EQUALS, EQUALS_IGNORE_CASE,
     *  NOT_EQUALS_IGNORE_CASE, CONTAINS, IN.
     */
    operator: string;
    /** The stringified JSON value that the claim is compared to using the operator. */
    value: string;
  }

  /** ProfileClaimRuleList. */
  export interface ProfileClaimRuleList {
    /** Context with key properties for problem determination. */
    context?: ResponseContext;
    /** List of claim rules. */
    rules: ProfileClaimRule[];
  }

  /** Link details. */
  export interface ProfileLink {
    /** the unique identifier of the claim rule. */
    id: string;
    /** version of the claim rule. */
    entity_tag: string;
    /** If set contains a date time string of the creation date in ISO format. */
    created_at: string;
    /** If set contains a date time string of the last modification date in ISO format. */
    modified_at: string;
    /** Optional name of the Link. */
    name?: string;
    /** The compute resource type. Valid values are VSI, IKS_SA, ROKS_SA. */
    cr_type: string;
    link: ProfileLinkLink;
  }

  /** ProfileLinkLink. */
  export interface ProfileLinkLink {
    /** The CRN of the compute resource. */
    crn?: string;
    /** The compute resource namespace, only required if cr_type is IKS_SA or ROKS_SA. */
    namespace?: string;
    /** Name of the compute resource, only required if cr_type is IKS_SA or ROKS_SA. */
    name?: string;
  }

  /** ProfileLinkList. */
  export interface ProfileLinkList {
    /** List of links to a trusted profile. */
    links: ProfileLink[];
  }

  /** Context with key properties for problem determination. */
  export interface ResponseContext {
    /** The transaction ID of the inbound REST request. */
    transaction_id?: string;
    /** The operation of the inbound REST request. */
    operation?: string;
    /** The user agent of the inbound REST request. */
    user_agent?: string;
    /** The URL of that cluster. */
    url?: string;
    /** The instance ID of the server instance processing the request. */
    instance_id?: string;
    /** The thread ID of the server instance processing the request. */
    thread_id?: string;
    /** The host of the server instance processing the request. */
    host?: string;
    /** The start time of the request. */
    start_time?: string;
    /** The finish time of the request. */
    end_time?: string;
    /** The elapsed time in msec. */
    elapsed_time?: string;
    /** The cluster name. */
    cluster_name?: string;
  }

  /** Response body format for service ID V1 REST requests. */
  export interface ServiceId {
    /** Context with key properties for problem determination. */
    context?: ResponseContext;
    /** Unique identifier of this Service Id. */
    id: string;
    /** Cloud wide identifier for identities of this service ID. */
    iam_id: string;
    /** Version of the service ID details object. You need to specify this value when updating the service ID to
     *  avoid stale updates.
     */
    entity_tag?: string;
    /** Cloud Resource Name of the item. Example Cloud Resource Name:
     *  'crn:v1:bluemix:public:iam-identity:us-south:a/myaccount::serviceid:1234-5678-9012'.
     */
    crn: string;
    /** The service ID cannot be changed if set to true. */
    locked: boolean;
    /** If set contains a date time string of the creation date in ISO format. */
    created_at?: string;
    /** If set contains a date time string of the last modification date in ISO format. */
    modified_at?: string;
    /** ID of the account the service ID belongs to. */
    account_id: string;
    /** Name of the Service Id. The name is not checked for uniqueness. Therefore multiple names with the same value
     *  can exist. Access is done via the UUID of the Service Id.
     */
    name: string;
    /** The optional description of the Service Id. The 'description' property is only available if a description
     *  was provided during a create of a Service Id.
     */
    description?: string;
    /** Optional list of CRNs (string array) which point to the services connected to the service ID. */
    unique_instance_crns?: string[];
    /** History of the Service ID. */
    history?: EnityHistoryRecord[];
    /** Response body format for API key V1 REST requests. */
    apikey?: ApiKey;
  }

  /** Response body format for the list service ID V1 REST request. */
  export interface ServiceIdList {
    /** Context with key properties for problem determination. */
    context?: ResponseContext;
    /** The offset of the current page. */
    offset?: number;
    /** Optional size of a single page. Default is 20 items per page. Valid range is 1 to 100. */
    limit?: number;
    /** Link to the first page. */
    first?: string;
    /** Link to the previous available page. If 'previous' property is not part of the response no previous page is
     *  available.
     */
    previous?: string;
    /** Link to the next available page. If 'next' property is not part of the response no next page is available. */
    next?: string;
    /** List of service IDs based on the query paramters and the page size. The service IDs array is always part of
     *  the response but might be empty depending on the query parameter values provided.
     */
    serviceids: ServiceId[];
  }

  /** Response body format for trusted profile V1 REST requests. */
  export interface TrustedProfile {
    /** Context with key properties for problem determination. */
    context?: ResponseContext;
    /** the unique identifier of the trusted profile. Example:'Profile-94497d0d-2ac3-41bf-a993-a49d1b14627c'. */
    id: string;
    /** Version of the trusted profile details object. You need to specify this value when updating the trusted
     *  profile to avoid stale updates.
     */
    entity_tag: string;
    /** Cloud Resource Name of the item. Example Cloud Resource Name:
     *  'crn:v1:bluemix:public:iam-identity:us-south:a/myaccount::profile:Profile-94497d0d-2ac3-41bf-a993-a49d1b14627c'.
     */
    crn: string;
    /** Name of the trusted profile. The name is checked for uniqueness. Therefore trusted profiles with the same
     *  names can not exist in the same account.
     */
    name: string;
    /** The optional description of the trusted profile. The 'description' property is only available if a
     *  description was provided during a create of a trusted profile.
     */
    description?: string;
    /** If set contains a date time string of the creation date in ISO format. */
    created_at?: string;
    /** If set contains a date time string of the last modification date in ISO format. */
    modified_at?: string;
    /** The iam_id of this trusted profile. */
    iam_id: string;
    /** ID of the account that this trusted profile belong to. */
    account_id: string;
    /** IMS acount ID of the trusted profile. */
    ims_account_id?: number;
    /** IMS user ID of the trusted profile. */
    ims_user_id?: number;
    /** History of the trusted profile. */
    history?: EnityHistoryRecord[];
  }

  /** Response body format for the List trusted profiles V1 REST request. */
  export interface TrustedProfilesList {
    /** Context with key properties for problem determination. */
    context?: ResponseContext;
    /** The offset of the current page. */
    offset?: number;
    /** Optional size of a single page. Default is 20 items per page. Valid range is 1 to 100. */
    limit?: number;
    /** Link to the first page. */
    first?: string;
    /** Link to the previous available page. If 'previous' property is not part of the response no previous page is
     *  available.
     */
    previous?: string;
    /** Link to the next available page. If 'next' property is not part of the response no next page is available. */
    next?: string;
    /** List of trusted profiles. */
    profiles: TrustedProfile[];
  }
}

export = IamIdentityV1;
