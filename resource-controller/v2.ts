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
 * IBM OpenAPI SDK Code Generator Version: 99-SNAPSHOT-77b4cbf2-20210420-134305
 */


import * as extend from 'extend';
import { IncomingHttpHeaders, OutgoingHttpHeaders } from 'http';
import { Authenticator, BaseService, getAuthenticatorFromEnvironment, getMissingParams, UserOptions } from 'ibm-cloud-sdk-core';
import { getSdkHeaders } from '../lib/common';

/**
 * Manage lifecycle of your Cloud resources using Resource Controller APIs. Resources are provisioned globally in an
 * account scope. Supports asynchronous provisioning of resources. Enables consumption of a global resource through a
 * Cloud Foundry space in any region.
 */

class ResourceControllerV2 extends BaseService {

  static DEFAULT_SERVICE_URL: string = 'https://resource-controller.cloud.ibm.com';
  static DEFAULT_SERVICE_NAME: string = 'resource_controller';

  /*************************
   * Factory method
   ************************/

  /**
   * Constructs an instance of ResourceControllerV2 with passed in options and external configuration.
   *
   * @param {UserOptions} [options] - The parameters to send to the service.
   * @param {string} [options.serviceName] - The name of the service to configure
   * @param {Authenticator} [options.authenticator] - The Authenticator object used to authenticate requests to the service
   * @param {string} [options.serviceUrl] - The URL for the service
   * @returns {ResourceControllerV2}
   */

  public static newInstance(options: UserOptions): ResourceControllerV2 {
    options = options || {};

    if (!options.serviceName) {
      options.serviceName = this.DEFAULT_SERVICE_NAME;
    }
    if (!options.authenticator) {
      options.authenticator = getAuthenticatorFromEnvironment(options.serviceName);
    }
    const service = new ResourceControllerV2(options);
    service.configureService(options.serviceName);
    if (options.serviceUrl) {
      service.setServiceUrl(options.serviceUrl);
    }
    return service;
  }


  /**
   * Construct a ResourceControllerV2 object.
   *
   * @param {Object} options - Options for the service.
   * @param {string} [options.serviceUrl] - The base url to use when contacting the service. The base url may differ between IBM Cloud regions.
   * @param {OutgoingHttpHeaders} [options.headers] - Default headers that shall be included with every request to the service.
   * @param {Authenticator} options.authenticator - The Authenticator object used to authenticate requests to the service
   * @constructor
   * @returns {ResourceControllerV2}
   */
  constructor(options: UserOptions) {
    options = options || {};

    super(options);
    if (options.serviceUrl) {
      this.setServiceUrl(options.serviceUrl);
    } else {
      this.setServiceUrl(ResourceControllerV2.DEFAULT_SERVICE_URL);
    }
  }

  /*************************
   * resourceInstances
   ************************/

  /**
   * Get a list of all resource instances.
   *
   * View a list of all available resource instances. Resources is a broad term that could mean anything from a service
   * instance to a virtual machine associated with the customer account.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {string} [params.guid] - When you provision a new resource in the specified location for the selected plan,
   * a GUID (globally unique identifier) is created. This is a unique internal GUID managed by Resource controller that
   * corresponds to the instance.
   * @param {string} [params.name] - The human-readable name of the instance.
   * @param {string} [params.resourceGroupId] - Short ID of a resource group.
   * @param {string} [params.resourceId] - The unique ID of the offering. This value is provided by and stored in the
   * global catalog.
   * @param {string} [params.resourcePlanId] - The unique ID of the plan associated with the offering. This value is
   * provided by and stored in the global catalog.
   * @param {string} [params.type] - The type of the instance, for example, `service_instance`.
   * @param {string} [params.subType] - The sub-type of instance, for example, `cfaas`.
   * @param {number} [params.limit] - Limit on how many items should be returned.
   * @param {string} [params.start] - An optional token that indicates the beginning of the page of results to be
   * returned. Any additional query parameters are ignored if a page token is present. If omitted, the first page of
   * results is returned. This value is obtained from the 'next_url' field of the operation response.
   * @param {string} [params.state] - The state of the instance. If not specified, instances in state `active` and
   * `provisioning` are returned.
   * @param {string} [params.orderDirection] - Order of results.
   * @param {string} [params.updatedFrom] - Start date inclusive filter.
   * @param {string} [params.updatedTo] - End date inclusive filter.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceInstancesList>>}
   */
  public listResourceInstances(params?: ResourceControllerV2.ListResourceInstancesParams): Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceInstancesList>> {
    const _params = Object.assign({}, params);

    const query = {
      'guid': _params.guid,
      'name': _params.name,
      'resource_group_id': _params.resourceGroupId,
      'resource_id': _params.resourceId,
      'resource_plan_id': _params.resourcePlanId,
      'type': _params.type,
      'sub_type': _params.subType,
      'limit': _params.limit,
      'start': _params.start,
      'state': _params.state,
      'order_direction': _params.orderDirection,
      'updated_from': _params.updatedFrom,
      'updated_to': _params.updatedTo
    };

    const sdkHeaders = getSdkHeaders(ResourceControllerV2.DEFAULT_SERVICE_NAME, 'v2', 'listResourceInstances');

    const parameters = {
      options: {
        url: '/v2/resource_instances',
        method: 'GET',
        qs: query,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Create (provision) a new resource instance.
   *
   * When you provision a service you get an instance of that service. An instance represents the resource with which
   * you create, and additionally, represents a chargeable record of which billing can occur.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.name - The name of the instance. Must be 180 characters or less and cannot include any
   * special characters other than `(space) - . _ :`.
   * @param {string} params.target - The deployment location where the instance should be hosted.
   * @param {string} params.resourceGroup - Short or long ID of resource group.
   * @param {string} params.resourcePlanId - The unique ID of the plan associated with the offering. This value is
   * provided by and stored in the global catalog.
   * @param {string[]} [params.tags] - Tags that are attached to the instance after provisioning. These tags can be
   * searched and managed through the Tagging API in IBM Cloud.
   * @param {boolean} [params.allowCleanup] - A boolean that dictates if the resource instance should be deleted
   * (cleaned up) during the processing of a region instance delete call.
   * @param {JsonObject} [params.parameters] - Configuration options represented as key-value pairs that are passed
   * through to the target resource brokers.
   * @param {boolean} [params.entityLock] - Indicates if the resource instance is locked for further update or delete
   * operations. It does not affect actions performed on child resources like aliases, bindings or keys. False by
   * default.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceInstance>>}
   */
  public createResourceInstance(params: ResourceControllerV2.CreateResourceInstanceParams): Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceInstance>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['name', 'target', 'resourceGroup', 'resourcePlanId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'name': _params.name,
      'target': _params.target,
      'resource_group': _params.resourceGroup,
      'resource_plan_id': _params.resourcePlanId,
      'tags': _params.tags,
      'allow_cleanup': _params.allowCleanup,
      'parameters': _params.parameters
    };

    const sdkHeaders = getSdkHeaders(ResourceControllerV2.DEFAULT_SERVICE_NAME, 'v2', 'createResourceInstance');

    const parameters = {
      options: {
        url: '/v2/resource_instances',
        method: 'POST',
        body,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
          'Entity-Lock': _params.entityLock
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Get a resource instance.
   *
   * Retrieve a resource instance by ID. Find more details on a particular instance, like when it was provisioned and
   * who provisioned it.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The short or long ID of the instance.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceInstance>>}
   */
  public getResourceInstance(params: ResourceControllerV2.GetResourceInstanceParams): Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceInstance>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['id'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'id': _params.id
    };

    const sdkHeaders = getSdkHeaders(ResourceControllerV2.DEFAULT_SERVICE_NAME, 'v2', 'getResourceInstance');

    const parameters = {
      options: {
        url: '/v2/resource_instances/{id}',
        method: 'GET',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Delete a resource instance.
   *
   * Delete a resource instance by ID. If the resource instance has any resource keys or aliases associated with it, use
   * the `recursive=true` parameter to delete it.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The short or long ID of the instance.
   * @param {boolean} [params.recursive] - Will delete resource bindings, keys and aliases associated with the instance.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceControllerV2.Response<ResourceControllerV2.Empty>>}
   */
  public deleteResourceInstance(params: ResourceControllerV2.DeleteResourceInstanceParams): Promise<ResourceControllerV2.Response<ResourceControllerV2.Empty>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['id'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'recursive': _params.recursive
    };

    const path = {
      'id': _params.id
    };

    const sdkHeaders = getSdkHeaders(ResourceControllerV2.DEFAULT_SERVICE_NAME, 'v2', 'deleteResourceInstance');

    const parameters = {
      options: {
        url: '/v2/resource_instances/{id}',
        method: 'DELETE',
        qs: query,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Update a resource instance.
   *
   * You can use the ID to make updates to the resource instance, like changing the name or plan.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The short or long ID of the instance.
   * @param {string} [params.name] - The new name of the instance. Must be 180 characters or less and cannot include any
   * special characters other than `(space) - . _ :`.
   * @param {JsonObject} [params.parameters] - The new configuration options for the instance.
   * @param {string} [params.resourcePlanId] - The unique ID of the plan associated with the offering. This value is
   * provided by and stored in the global catalog.
   * @param {boolean} [params.allowCleanup] - A boolean that dictates if the resource instance should be deleted
   * (cleaned up) during the processing of a region instance delete call.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceInstance>>}
   */
  public updateResourceInstance(params: ResourceControllerV2.UpdateResourceInstanceParams): Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceInstance>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['id'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'name': _params.name,
      'parameters': _params.parameters,
      'resource_plan_id': _params.resourcePlanId,
      'allow_cleanup': _params.allowCleanup
    };

    const path = {
      'id': _params.id
    };

    const sdkHeaders = getSdkHeaders(ResourceControllerV2.DEFAULT_SERVICE_NAME, 'v2', 'updateResourceInstance');

    const parameters = {
      options: {
        url: '/v2/resource_instances/{id}',
        method: 'PATCH',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Get a list of all resource aliases for the instance.
   *
   * Retrieving a list of all resource aliases can help you find out who's using the resource instance.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The short or long ID of the instance.
   * @param {number} [params.limit] - Limit on how many items should be returned.
   * @param {string} [params.start] - An optional token that indicates the beginning of the page of results to be
   * returned. Any additional query parameters are ignored if a page token is present. If omitted, the first page of
   * results is returned. This value is obtained from the 'next_url' field of the operation response.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceAliasesList>>}
   */
  public listResourceAliasesForInstance(params: ResourceControllerV2.ListResourceAliasesForInstanceParams): Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceAliasesList>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['id'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'limit': _params.limit,
      'start': _params.start
    };

    const path = {
      'id': _params.id
    };

    const sdkHeaders = getSdkHeaders(ResourceControllerV2.DEFAULT_SERVICE_NAME, 'v2', 'listResourceAliasesForInstance');

    const parameters = {
      options: {
        url: '/v2/resource_instances/{id}/resource_aliases',
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

    return this.createRequest(parameters);
  };

  /**
   * Get a list of all the resource keys for the instance.
   *
   * You may have many resource keys for one resource instance. For example, you may have a different resource key for
   * each user or each role.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The short or long ID of the instance.
   * @param {number} [params.limit] - Limit on how many items should be returned.
   * @param {string} [params.start] - An optional token that indicates the beginning of the page of results to be
   * returned. Any additional query parameters are ignored if a page token is present. If omitted, the first page of
   * results is returned. This value is obtained from the 'next_url' field of the operation response.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceKeysList>>}
   */
  public listResourceKeysForInstance(params: ResourceControllerV2.ListResourceKeysForInstanceParams): Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceKeysList>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['id'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'limit': _params.limit,
      'start': _params.start
    };

    const path = {
      'id': _params.id
    };

    const sdkHeaders = getSdkHeaders(ResourceControllerV2.DEFAULT_SERVICE_NAME, 'v2', 'listResourceKeysForInstance');

    const parameters = {
      options: {
        url: '/v2/resource_instances/{id}/resource_keys',
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

    return this.createRequest(parameters);
  };

  /**
   * Lock a resource instance.
   *
   * Locks a resource instance by ID. A locked instance can not be updated or deleted. It does not affect actions
   * performed on child resources like aliases, bindings or keys.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The short or long ID of the instance.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceInstance>>}
   */
  public lockResourceInstance(params: ResourceControllerV2.LockResourceInstanceParams): Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceInstance>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['id'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'id': _params.id
    };

    const sdkHeaders = getSdkHeaders(ResourceControllerV2.DEFAULT_SERVICE_NAME, 'v2', 'lockResourceInstance');

    const parameters = {
      options: {
        url: '/v2/resource_instances/{id}/lock',
        method: 'POST',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Unlock a resource instance.
   *
   * Unlock a resource instance to update or delete it. Unlocking a resource instance does not affect child resources
   * like aliases, bindings or keys.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The short or long ID of the instance.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceInstance>>}
   */
  public unlockResourceInstance(params: ResourceControllerV2.UnlockResourceInstanceParams): Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceInstance>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['id'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'id': _params.id
    };

    const sdkHeaders = getSdkHeaders(ResourceControllerV2.DEFAULT_SERVICE_NAME, 'v2', 'unlockResourceInstance');

    const parameters = {
      options: {
        url: '/v2/resource_instances/{id}/lock',
        method: 'DELETE',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /*************************
   * resourceKeys
   ************************/

  /**
   * Get a list of all of the resource keys.
   *
   * List all resource keys.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {string} [params.guid] - When you create a new key, a GUID (globally unique identifier) is assigned. This is
   * a unique internal GUID managed by Resource controller that corresponds to the key.
   * @param {string} [params.name] - The human-readable name of the key.
   * @param {string} [params.resourceGroupId] - The short ID of the resource group.
   * @param {string} [params.resourceId] - The unique ID of the offering. This value is provided by and stored in the
   * global catalog.
   * @param {number} [params.limit] - Limit on how many items should be returned.
   * @param {string} [params.start] - An optional token that indicates the beginning of the page of results to be
   * returned. Any additional query parameters are ignored if a page token is present. If omitted, the first page of
   * results is returned. This value is obtained from the 'next_url' field of the operation response.
   * @param {string} [params.updatedFrom] - Start date inclusive filter.
   * @param {string} [params.updatedTo] - End date inclusive filter.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceKeysList>>}
   */
  public listResourceKeys(params?: ResourceControllerV2.ListResourceKeysParams): Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceKeysList>> {
    const _params = Object.assign({}, params);

    const query = {
      'guid': _params.guid,
      'name': _params.name,
      'resource_group_id': _params.resourceGroupId,
      'resource_id': _params.resourceId,
      'limit': _params.limit,
      'start': _params.start,
      'updated_from': _params.updatedFrom,
      'updated_to': _params.updatedTo
    };

    const sdkHeaders = getSdkHeaders(ResourceControllerV2.DEFAULT_SERVICE_NAME, 'v2', 'listResourceKeys');

    const parameters = {
      options: {
        url: '/v2/resource_keys',
        method: 'GET',
        qs: query,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Create a new resource key.
   *
   * Create a new resource key.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.name - The name of the key.
   * @param {string} params.source - The short or long ID of resource instance or alias.
   * @param {ResourceKeyPostParameters} [params.parameters] - Configuration options represented as key-value pairs.
   * Service defined options are passed through to the target resource brokers, whereas platform defined options are
   * not.
   * @param {string} [params.role] - The role name or it's CRN.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceKey>>}
   */
  public createResourceKey(params: ResourceControllerV2.CreateResourceKeyParams): Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceKey>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['name', 'source'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'name': _params.name,
      'source': _params.source,
      'parameters': _params.parameters,
      'role': _params.role
    };

    const sdkHeaders = getSdkHeaders(ResourceControllerV2.DEFAULT_SERVICE_NAME, 'v2', 'createResourceKey');

    const parameters = {
      options: {
        url: '/v2/resource_keys',
        method: 'POST',
        body,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Get resource key by ID.
   *
   * Get resource key by ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The short or long ID of the key.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceKey>>}
   */
  public getResourceKey(params: ResourceControllerV2.GetResourceKeyParams): Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceKey>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['id'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'id': _params.id
    };

    const sdkHeaders = getSdkHeaders(ResourceControllerV2.DEFAULT_SERVICE_NAME, 'v2', 'getResourceKey');

    const parameters = {
      options: {
        url: '/v2/resource_keys/{id}',
        method: 'GET',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Delete a resource key by ID.
   *
   * Delete a resource key by ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The short or long ID of the key.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceControllerV2.Response<ResourceControllerV2.Empty>>}
   */
  public deleteResourceKey(params: ResourceControllerV2.DeleteResourceKeyParams): Promise<ResourceControllerV2.Response<ResourceControllerV2.Empty>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['id'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'id': _params.id
    };

    const sdkHeaders = getSdkHeaders(ResourceControllerV2.DEFAULT_SERVICE_NAME, 'v2', 'deleteResourceKey');

    const parameters = {
      options: {
        url: '/v2/resource_keys/{id}',
        method: 'DELETE',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Update a resource key.
   *
   * Update a resource key by ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The short or long ID of the key.
   * @param {string} params.name - The new name of the key. Must be 180 characters or less and cannot include any
   * special characters other than `(space) - . _ :`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceKey>>}
   */
  public updateResourceKey(params: ResourceControllerV2.UpdateResourceKeyParams): Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceKey>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['id', 'name'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'name': _params.name
    };

    const path = {
      'id': _params.id
    };

    const sdkHeaders = getSdkHeaders(ResourceControllerV2.DEFAULT_SERVICE_NAME, 'v2', 'updateResourceKey');

    const parameters = {
      options: {
        url: '/v2/resource_keys/{id}',
        method: 'PATCH',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /*************************
   * resourceBindings
   ************************/

  /**
   * Get a list of all resource bindings.
   *
   * Get a list of all resource bindings.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {string} [params.guid] - The short ID of the binding.
   * @param {string} [params.name] - The human-readable name of the binding.
   * @param {string} [params.resourceGroupId] - Short ID of the resource group.
   * @param {string} [params.resourceId] - The unique ID of the offering (service name). This value is provided by and
   * stored in the global catalog.
   * @param {string} [params.regionBindingId] - Short ID of the binding in the specific targeted environment, for
   * example, service_binding_id in a given IBM Cloud environment.
   * @param {number} [params.limit] - Limit on how many items should be returned.
   * @param {string} [params.start] - An optional token that indicates the beginning of the page of results to be
   * returned. Any additional query parameters are ignored if a page token is present. If omitted, the first page of
   * results is returned. This value is obtained from the 'next_url' field of the operation response.
   * @param {string} [params.updatedFrom] - Start date inclusive filter.
   * @param {string} [params.updatedTo] - End date inclusive filter.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceBindingsList>>}
   */
  public listResourceBindings(params?: ResourceControllerV2.ListResourceBindingsParams): Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceBindingsList>> {
    const _params = Object.assign({}, params);

    const query = {
      'guid': _params.guid,
      'name': _params.name,
      'resource_group_id': _params.resourceGroupId,
      'resource_id': _params.resourceId,
      'region_binding_id': _params.regionBindingId,
      'limit': _params.limit,
      'start': _params.start,
      'updated_from': _params.updatedFrom,
      'updated_to': _params.updatedTo
    };

    const sdkHeaders = getSdkHeaders(ResourceControllerV2.DEFAULT_SERVICE_NAME, 'v2', 'listResourceBindings');

    const parameters = {
      options: {
        url: '/v2/resource_bindings',
        method: 'GET',
        qs: query,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Create a new resource binding.
   *
   * Create a new resource binding.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.source - The short or long ID of resource alias.
   * @param {string} params.target - The CRN of application to bind to in a specific environment, for example, Dallas
   * YP, CFEE instance.
   * @param {string} [params.name] - The name of the binding. Must be 180 characters or less and cannot include any
   * special characters other than `(space) - . _ :`.
   * @param {ResourceBindingPostParameters} [params.parameters] - Configuration options represented as key-value pairs.
   * Service defined options are passed through to the target resource brokers, whereas platform defined options are
   * not.
   * @param {string} [params.role] - The role name or it's CRN.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceBinding>>}
   */
  public createResourceBinding(params: ResourceControllerV2.CreateResourceBindingParams): Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceBinding>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['source', 'target'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'source': _params.source,
      'target': _params.target,
      'name': _params.name,
      'parameters': _params.parameters,
      'role': _params.role
    };

    const sdkHeaders = getSdkHeaders(ResourceControllerV2.DEFAULT_SERVICE_NAME, 'v2', 'createResourceBinding');

    const parameters = {
      options: {
        url: '/v2/resource_bindings',
        method: 'POST',
        body,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Get a resource binding.
   *
   * Retrieve a resource binding by ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The short or long ID of the binding.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceBinding>>}
   */
  public getResourceBinding(params: ResourceControllerV2.GetResourceBindingParams): Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceBinding>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['id'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'id': _params.id
    };

    const sdkHeaders = getSdkHeaders(ResourceControllerV2.DEFAULT_SERVICE_NAME, 'v2', 'getResourceBinding');

    const parameters = {
      options: {
        url: '/v2/resource_bindings/{id}',
        method: 'GET',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Delete a resource binding.
   *
   * Delete a resource binding by ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The short or long ID of the binding.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceControllerV2.Response<ResourceControllerV2.Empty>>}
   */
  public deleteResourceBinding(params: ResourceControllerV2.DeleteResourceBindingParams): Promise<ResourceControllerV2.Response<ResourceControllerV2.Empty>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['id'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'id': _params.id
    };

    const sdkHeaders = getSdkHeaders(ResourceControllerV2.DEFAULT_SERVICE_NAME, 'v2', 'deleteResourceBinding');

    const parameters = {
      options: {
        url: '/v2/resource_bindings/{id}',
        method: 'DELETE',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Update a resource binding.
   *
   * Update a resource binding by ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The short or long ID of the binding.
   * @param {string} params.name - The new name of the binding. Must be 180 characters or less and cannot include any
   * special characters other than `(space) - . _ :`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceBinding>>}
   */
  public updateResourceBinding(params: ResourceControllerV2.UpdateResourceBindingParams): Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceBinding>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['id', 'name'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'name': _params.name
    };

    const path = {
      'id': _params.id
    };

    const sdkHeaders = getSdkHeaders(ResourceControllerV2.DEFAULT_SERVICE_NAME, 'v2', 'updateResourceBinding');

    const parameters = {
      options: {
        url: '/v2/resource_bindings/{id}',
        method: 'PATCH',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /*************************
   * resourceAliases
   ************************/

  /**
   * Get a list of all resource aliases.
   *
   * Get a list of all resource aliases.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {string} [params.guid] - Short ID of the alias.
   * @param {string} [params.name] - The human-readable name of the alias.
   * @param {string} [params.resourceInstanceId] - Resource instance short ID.
   * @param {string} [params.regionInstanceId] - Short ID of the instance in a specific targeted environment. For
   * example, `service_instance_id` in a given IBM Cloud environment.
   * @param {string} [params.resourceId] - The unique ID of the offering (service name). This value is provided by and
   * stored in the global catalog.
   * @param {string} [params.resourceGroupId] - Short ID of Resource group.
   * @param {number} [params.limit] - Limit on how many items should be returned.
   * @param {string} [params.start] - An optional token that indicates the beginning of the page of results to be
   * returned. Any additional query parameters are ignored if a page token is present. If omitted, the first page of
   * results is returned. This value is obtained from the 'next_url' field of the operation response.
   * @param {string} [params.updatedFrom] - Start date inclusive filter.
   * @param {string} [params.updatedTo] - End date inclusive filter.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceAliasesList>>}
   */
  public listResourceAliases(params?: ResourceControllerV2.ListResourceAliasesParams): Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceAliasesList>> {
    const _params = Object.assign({}, params);

    const query = {
      'guid': _params.guid,
      'name': _params.name,
      'resource_instance_id': _params.resourceInstanceId,
      'region_instance_id': _params.regionInstanceId,
      'resource_id': _params.resourceId,
      'resource_group_id': _params.resourceGroupId,
      'limit': _params.limit,
      'start': _params.start,
      'updated_from': _params.updatedFrom,
      'updated_to': _params.updatedTo
    };

    const sdkHeaders = getSdkHeaders(ResourceControllerV2.DEFAULT_SERVICE_NAME, 'v2', 'listResourceAliases');

    const parameters = {
      options: {
        url: '/v2/resource_aliases',
        method: 'GET',
        qs: query,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Create a new resource alias.
   *
   * Alias a resource instance into a targeted environment's (name)space.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.name - The name of the alias. Must be 180 characters or less and cannot include any special
   * characters other than `(space) - . _ :`.
   * @param {string} params.source - The short or long ID of resource instance.
   * @param {string} params.target - The CRN of target name(space) in a specific environment, for example, space in
   * Dallas YP, CFEE instance etc.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceAlias>>}
   */
  public createResourceAlias(params: ResourceControllerV2.CreateResourceAliasParams): Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceAlias>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['name', 'source', 'target'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'name': _params.name,
      'source': _params.source,
      'target': _params.target
    };

    const sdkHeaders = getSdkHeaders(ResourceControllerV2.DEFAULT_SERVICE_NAME, 'v2', 'createResourceAlias');

    const parameters = {
      options: {
        url: '/v2/resource_aliases',
        method: 'POST',
        body,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Get a resource alias.
   *
   * Retrieve a resource alias by ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The short or long ID of the alias.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceAlias>>}
   */
  public getResourceAlias(params: ResourceControllerV2.GetResourceAliasParams): Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceAlias>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['id'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'id': _params.id
    };

    const sdkHeaders = getSdkHeaders(ResourceControllerV2.DEFAULT_SERVICE_NAME, 'v2', 'getResourceAlias');

    const parameters = {
      options: {
        url: '/v2/resource_aliases/{id}',
        method: 'GET',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Delete a resource alias.
   *
   * Delete a resource alias by ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The short or long ID of the alias.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceControllerV2.Response<ResourceControllerV2.Empty>>}
   */
  public deleteResourceAlias(params: ResourceControllerV2.DeleteResourceAliasParams): Promise<ResourceControllerV2.Response<ResourceControllerV2.Empty>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['id'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'id': _params.id
    };

    const sdkHeaders = getSdkHeaders(ResourceControllerV2.DEFAULT_SERVICE_NAME, 'v2', 'deleteResourceAlias');

    const parameters = {
      options: {
        url: '/v2/resource_aliases/{id}',
        method: 'DELETE',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Update a resource alias.
   *
   * Update a resource alias by ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The short or long ID of the alias.
   * @param {string} params.name - The new name of the alias. Must be 180 characters or less and cannot include any
   * special characters other than `(space) - . _ :`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceAlias>>}
   */
  public updateResourceAlias(params: ResourceControllerV2.UpdateResourceAliasParams): Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceAlias>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['id', 'name'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'name': _params.name
    };

    const path = {
      'id': _params.id
    };

    const sdkHeaders = getSdkHeaders(ResourceControllerV2.DEFAULT_SERVICE_NAME, 'v2', 'updateResourceAlias');

    const parameters = {
      options: {
        url: '/v2/resource_aliases/{id}',
        method: 'PATCH',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Get a list of all resource bindings for the alias.
   *
   * Get a list of all resource bindings for the alias.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The short or long ID of the alias.
   * @param {number} [params.limit] - Limit on how many items should be returned.
   * @param {string} [params.start] - An optional token that indicates the beginning of the page of results to be
   * returned. Any additional query parameters are ignored if a page token is present. If omitted, the first page of
   * results is returned. This value is obtained from the 'next_url' field of the operation response.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceBindingsList>>}
   */
  public listResourceBindingsForAlias(params: ResourceControllerV2.ListResourceBindingsForAliasParams): Promise<ResourceControllerV2.Response<ResourceControllerV2.ResourceBindingsList>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['id'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'limit': _params.limit,
      'start': _params.start
    };

    const path = {
      'id': _params.id
    };

    const sdkHeaders = getSdkHeaders(ResourceControllerV2.DEFAULT_SERVICE_NAME, 'v2', 'listResourceBindingsForAlias');

    const parameters = {
      options: {
        url: '/v2/resource_aliases/{id}/resource_bindings',
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

    return this.createRequest(parameters);
  };

  /*************************
   * resourceReclamations
   ************************/

  /**
   * Get a list of all reclamations.
   *
   * Get a list of all reclamations.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {string} [params.accountId] - An alpha-numeric value identifying the account ID.
   * @param {string} [params.resourceInstanceId] - The short ID of the resource instance.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceControllerV2.Response<ResourceControllerV2.ReclamationsList>>}
   */
  public listReclamations(params?: ResourceControllerV2.ListReclamationsParams): Promise<ResourceControllerV2.Response<ResourceControllerV2.ReclamationsList>> {
    const _params = Object.assign({}, params);

    const query = {
      'account_id': _params.accountId,
      'resource_instance_id': _params.resourceInstanceId
    };

    const sdkHeaders = getSdkHeaders(ResourceControllerV2.DEFAULT_SERVICE_NAME, 'v2', 'listReclamations');

    const parameters = {
      options: {
        url: '/v1/reclamations',
        method: 'GET',
        qs: query,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Perform a reclamation action.
   *
   * Reclaim (provisionally delete) a resource so that it can no longer be used, or restore a resource so that it's
   * usable again.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The ID associated with the reclamation.
   * @param {string} params.actionName - The reclamation action name. Specify `reclaim` to delete a resource, or
   * `restore` to restore a resource.
   * @param {string} [params.requestBy] - The request initiator, if different from the request token.
   * @param {string} [params.comment] - A comment to describe the action.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceControllerV2.Response<ResourceControllerV2.Reclamation>>}
   */
  public runReclamationAction(params: ResourceControllerV2.RunReclamationActionParams): Promise<ResourceControllerV2.Response<ResourceControllerV2.Reclamation>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['id', 'actionName'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'request_by': _params.requestBy,
      'comment': _params.comment
    };

    const path = {
      'id': _params.id,
      'action_name': _params.actionName
    };

    const sdkHeaders = getSdkHeaders(ResourceControllerV2.DEFAULT_SERVICE_NAME, 'v2', 'runReclamationAction');

    const parameters = {
      options: {
        url: '/v1/reclamations/{id}/actions/{action_name}',
        method: 'POST',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

}

/*************************
 * interfaces
 ************************/

namespace ResourceControllerV2 {

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

  /** Parameters for the `listResourceInstances` operation. */
  export interface ListResourceInstancesParams {
    /** When you provision a new resource in the specified location for the selected plan, a GUID (globally unique
     *  identifier) is created. This is a unique internal GUID managed by Resource controller that corresponds to the
     *  instance.
     */
    guid?: string;
    /** The human-readable name of the instance. */
    name?: string;
    /** Short ID of a resource group. */
    resourceGroupId?: string;
    /** The unique ID of the offering. This value is provided by and stored in the global catalog. */
    resourceId?: string;
    /** The unique ID of the plan associated with the offering. This value is provided by and stored in the global
     *  catalog.
     */
    resourcePlanId?: string;
    /** The type of the instance, for example, `service_instance`. */
    type?: string;
    /** The sub-type of instance, for example, `cfaas`. */
    subType?: string;
    /** Limit on how many items should be returned. */
    limit?: number;
    /** An optional token that indicates the beginning of the page of results to be returned. Any additional query
     *  parameters are ignored if a page token is present. If omitted, the first page of results is returned. This value
     *  is obtained from the 'next_url' field of the operation response.
     */
    start?: string;
    /** The state of the instance. If not specified, instances in state `active` and `provisioning` are returned. */
    state?: ListResourceInstancesConstants.State | string;
    /** Order of results. */
    orderDirection?: ListResourceInstancesConstants.OrderDirection | string;
    /** Start date inclusive filter. */
    updatedFrom?: string;
    /** End date inclusive filter. */
    updatedTo?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Constants for the `listResourceInstances` operation. */
  export namespace ListResourceInstancesConstants {
    /** The state of the instance. If not specified, instances in state `active` and `provisioning` are returned. */
    export enum State {
      ACTIVE = 'active',
      PROVISIONING = 'provisioning',
      REMOVED = 'removed',
    }
    /** Order of results. */
    export enum OrderDirection {
      ASC = 'asc',
      DESC = 'desc',
    }
  }

  /** Parameters for the `createResourceInstance` operation. */
  export interface CreateResourceInstanceParams {
    /** The name of the instance. Must be 180 characters or less and cannot include any special characters other
     *  than `(space) - . _ :`.
     */
    name: string;
    /** The deployment location where the instance should be hosted. */
    target: string;
    /** Short or long ID of resource group. */
    resourceGroup: string;
    /** The unique ID of the plan associated with the offering. This value is provided by and stored in the global
     *  catalog.
     */
    resourcePlanId: string;
    /** Tags that are attached to the instance after provisioning. These tags can be searched and managed through
     *  the Tagging API in IBM Cloud.
     */
    tags?: string[];
    /** A boolean that dictates if the resource instance should be deleted (cleaned up) during the processing of a
     *  region instance delete call.
     */
    allowCleanup?: boolean;
    /** Configuration options represented as key-value pairs that are passed through to the target resource brokers. */
    parameters?: JsonObject;
    /** Indicates if the resource instance is locked for further update or delete operations. It does not affect
     *  actions performed on child resources like aliases, bindings or keys. False by default.
     */
    entityLock?: boolean;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getResourceInstance` operation. */
  export interface GetResourceInstanceParams {
    /** The short or long ID of the instance. */
    id: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deleteResourceInstance` operation. */
  export interface DeleteResourceInstanceParams {
    /** The short or long ID of the instance. */
    id: string;
    /** Will delete resource bindings, keys and aliases associated with the instance. */
    recursive?: boolean;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `updateResourceInstance` operation. */
  export interface UpdateResourceInstanceParams {
    /** The short or long ID of the instance. */
    id: string;
    /** The new name of the instance. Must be 180 characters or less and cannot include any special characters other
     *  than `(space) - . _ :`.
     */
    name?: string;
    /** The new configuration options for the instance. */
    parameters?: JsonObject;
    /** The unique ID of the plan associated with the offering. This value is provided by and stored in the global
     *  catalog.
     */
    resourcePlanId?: string;
    /** A boolean that dictates if the resource instance should be deleted (cleaned up) during the processing of a
     *  region instance delete call.
     */
    allowCleanup?: boolean;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listResourceAliasesForInstance` operation. */
  export interface ListResourceAliasesForInstanceParams {
    /** The short or long ID of the instance. */
    id: string;
    /** Limit on how many items should be returned. */
    limit?: number;
    /** An optional token that indicates the beginning of the page of results to be returned. Any additional query
     *  parameters are ignored if a page token is present. If omitted, the first page of results is returned. This value
     *  is obtained from the 'next_url' field of the operation response.
     */
    start?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listResourceKeysForInstance` operation. */
  export interface ListResourceKeysForInstanceParams {
    /** The short or long ID of the instance. */
    id: string;
    /** Limit on how many items should be returned. */
    limit?: number;
    /** An optional token that indicates the beginning of the page of results to be returned. Any additional query
     *  parameters are ignored if a page token is present. If omitted, the first page of results is returned. This value
     *  is obtained from the 'next_url' field of the operation response.
     */
    start?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `lockResourceInstance` operation. */
  export interface LockResourceInstanceParams {
    /** The short or long ID of the instance. */
    id: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `unlockResourceInstance` operation. */
  export interface UnlockResourceInstanceParams {
    /** The short or long ID of the instance. */
    id: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listResourceKeys` operation. */
  export interface ListResourceKeysParams {
    /** When you create a new key, a GUID (globally unique identifier) is assigned. This is a unique internal GUID
     *  managed by Resource controller that corresponds to the key.
     */
    guid?: string;
    /** The human-readable name of the key. */
    name?: string;
    /** The short ID of the resource group. */
    resourceGroupId?: string;
    /** The unique ID of the offering. This value is provided by and stored in the global catalog. */
    resourceId?: string;
    /** Limit on how many items should be returned. */
    limit?: number;
    /** An optional token that indicates the beginning of the page of results to be returned. Any additional query
     *  parameters are ignored if a page token is present. If omitted, the first page of results is returned. This value
     *  is obtained from the 'next_url' field of the operation response.
     */
    start?: string;
    /** Start date inclusive filter. */
    updatedFrom?: string;
    /** End date inclusive filter. */
    updatedTo?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `createResourceKey` operation. */
  export interface CreateResourceKeyParams {
    /** The name of the key. */
    name: string;
    /** The short or long ID of resource instance or alias. */
    source: string;
    /** Configuration options represented as key-value pairs. Service defined options are passed through to the
     *  target resource brokers, whereas platform defined options are not.
     */
    parameters?: ResourceKeyPostParameters;
    /** The role name or it's CRN. */
    role?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getResourceKey` operation. */
  export interface GetResourceKeyParams {
    /** The short or long ID of the key. */
    id: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deleteResourceKey` operation. */
  export interface DeleteResourceKeyParams {
    /** The short or long ID of the key. */
    id: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `updateResourceKey` operation. */
  export interface UpdateResourceKeyParams {
    /** The short or long ID of the key. */
    id: string;
    /** The new name of the key. Must be 180 characters or less and cannot include any special characters other than
     *  `(space) - . _ :`.
     */
    name: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listResourceBindings` operation. */
  export interface ListResourceBindingsParams {
    /** The short ID of the binding. */
    guid?: string;
    /** The human-readable name of the binding. */
    name?: string;
    /** Short ID of the resource group. */
    resourceGroupId?: string;
    /** The unique ID of the offering (service name). This value is provided by and stored in the global catalog. */
    resourceId?: string;
    /** Short ID of the binding in the specific targeted environment, for example, service_binding_id in a given IBM
     *  Cloud environment.
     */
    regionBindingId?: string;
    /** Limit on how many items should be returned. */
    limit?: number;
    /** An optional token that indicates the beginning of the page of results to be returned. Any additional query
     *  parameters are ignored if a page token is present. If omitted, the first page of results is returned. This value
     *  is obtained from the 'next_url' field of the operation response.
     */
    start?: string;
    /** Start date inclusive filter. */
    updatedFrom?: string;
    /** End date inclusive filter. */
    updatedTo?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `createResourceBinding` operation. */
  export interface CreateResourceBindingParams {
    /** The short or long ID of resource alias. */
    source: string;
    /** The CRN of application to bind to in a specific environment, for example, Dallas YP, CFEE instance. */
    target: string;
    /** The name of the binding. Must be 180 characters or less and cannot include any special characters other than
     *  `(space) - . _ :`.
     */
    name?: string;
    /** Configuration options represented as key-value pairs. Service defined options are passed through to the
     *  target resource brokers, whereas platform defined options are not.
     */
    parameters?: ResourceBindingPostParameters;
    /** The role name or it's CRN. */
    role?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getResourceBinding` operation. */
  export interface GetResourceBindingParams {
    /** The short or long ID of the binding. */
    id: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deleteResourceBinding` operation. */
  export interface DeleteResourceBindingParams {
    /** The short or long ID of the binding. */
    id: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `updateResourceBinding` operation. */
  export interface UpdateResourceBindingParams {
    /** The short or long ID of the binding. */
    id: string;
    /** The new name of the binding. Must be 180 characters or less and cannot include any special characters other
     *  than `(space) - . _ :`.
     */
    name: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listResourceAliases` operation. */
  export interface ListResourceAliasesParams {
    /** Short ID of the alias. */
    guid?: string;
    /** The human-readable name of the alias. */
    name?: string;
    /** Resource instance short ID. */
    resourceInstanceId?: string;
    /** Short ID of the instance in a specific targeted environment. For example, `service_instance_id` in a given
     *  IBM Cloud environment.
     */
    regionInstanceId?: string;
    /** The unique ID of the offering (service name). This value is provided by and stored in the global catalog. */
    resourceId?: string;
    /** Short ID of Resource group. */
    resourceGroupId?: string;
    /** Limit on how many items should be returned. */
    limit?: number;
    /** An optional token that indicates the beginning of the page of results to be returned. Any additional query
     *  parameters are ignored if a page token is present. If omitted, the first page of results is returned. This value
     *  is obtained from the 'next_url' field of the operation response.
     */
    start?: string;
    /** Start date inclusive filter. */
    updatedFrom?: string;
    /** End date inclusive filter. */
    updatedTo?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `createResourceAlias` operation. */
  export interface CreateResourceAliasParams {
    /** The name of the alias. Must be 180 characters or less and cannot include any special characters other than
     *  `(space) - . _ :`.
     */
    name: string;
    /** The short or long ID of resource instance. */
    source: string;
    /** The CRN of target name(space) in a specific environment, for example, space in Dallas YP, CFEE instance etc. */
    target: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getResourceAlias` operation. */
  export interface GetResourceAliasParams {
    /** The short or long ID of the alias. */
    id: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deleteResourceAlias` operation. */
  export interface DeleteResourceAliasParams {
    /** The short or long ID of the alias. */
    id: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `updateResourceAlias` operation. */
  export interface UpdateResourceAliasParams {
    /** The short or long ID of the alias. */
    id: string;
    /** The new name of the alias. Must be 180 characters or less and cannot include any special characters other
     *  than `(space) - . _ :`.
     */
    name: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listResourceBindingsForAlias` operation. */
  export interface ListResourceBindingsForAliasParams {
    /** The short or long ID of the alias. */
    id: string;
    /** Limit on how many items should be returned. */
    limit?: number;
    /** An optional token that indicates the beginning of the page of results to be returned. Any additional query
     *  parameters are ignored if a page token is present. If omitted, the first page of results is returned. This value
     *  is obtained from the 'next_url' field of the operation response.
     */
    start?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listReclamations` operation. */
  export interface ListReclamationsParams {
    /** An alpha-numeric value identifying the account ID. */
    accountId?: string;
    /** The short ID of the resource instance. */
    resourceInstanceId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `runReclamationAction` operation. */
  export interface RunReclamationActionParams {
    /** The ID associated with the reclamation. */
    id: string;
    /** The reclamation action name. Specify `reclaim` to delete a resource, or `restore` to restore a resource. */
    actionName: string;
    /** The request initiator, if different from the request token. */
    requestBy?: string;
    /** A comment to describe the action. */
    comment?: string;
    headers?: OutgoingHttpHeaders;
  }

  /*************************
   * model interfaces
   ************************/

  /** The credentials for a resource. */
  export interface Credentials {
    /** The API key for the credentials. */
    apikey?: string;
    /** The optional description of the API key. */
    iam_apikey_description?: string;
    /** The name of the API key. */
    iam_apikey_name?: string;
    /** The Cloud Resource Name for the role of the credentials. */
    iam_role_crn?: string;
    /** The Cloud Resource Name for the service ID of the credentials. */
    iam_serviceid_crn?: string;
    /** Credentials accepts additional properties. */
    [propName: string]: any;
  }

  /** An element of the plan history of the instance. */
  export interface PlanHistoryItem {
    /** The unique ID of the plan associated with the offering. This value is provided by and stored in the global
     *  catalog.
     */
    resource_plan_id: string;
    /** The date on which the plan was changed. */
    start_date: string;
    /** The subject who made the plan change. */
    requestor_id?: string;
  }

  /** A reclamation. */
  export interface Reclamation {
    /** The ID associated with the reclamation. */
    id?: string;
    /** The short ID of the entity for the reclamation. */
    entity_id?: string;
    /** The short ID of the entity type for the reclamation. */
    entity_type_id?: string;
    /** The full Cloud Resource Name (CRN) associated with the binding. For more information about this format, see
     *  [Cloud Resource Names](https://cloud.ibm.com/docs/overview?topic=overview-crn).
     */
    entity_crn?: string;
    /** The short ID of the resource instance. */
    resource_instance_id?: string;
    /** The short ID of the resource group. */
    resource_group_id?: string;
    /** An alpha-numeric value identifying the account ID. */
    account_id?: string;
    /** The short ID of policy for the reclamation. */
    policy_id?: string;
    /** The state of the reclamation. */
    state?: string;
    /** The target time that the reclamation retention period end. */
    target_time?: string;
    /** The custom properties of the reclamation. */
    custom_properties?: JsonObject;
    /** The date when the reclamation was created. */
    created_at?: string;
    /** The subject who created the reclamation. */
    created_by?: string;
    /** The date when the reclamation was last updated. */
    updated_at?: string;
    /** The subject who updated the reclamation. */
    updated_by?: string;
  }

  /** A list of reclamations. */
  export interface ReclamationsList {
    /** A list of reclamations. */
    resources?: Reclamation[];
  }

  /** A resource alias. */
  export interface ResourceAlias {
    /** The ID associated with the alias. */
    id?: string;
    /** When you create a new alias, a globally unique identifier (GUID) is assigned. This GUID is a unique internal
     *  indentifier managed by the resource controller that corresponds to the alias.
     */
    guid?: string;
    /** When you created a new alias, a relative URL path is created identifying the location of the alias. */
    url?: string;
    /** The date when the alias was created. */
    created_at?: string;
    /** The date when the alias was last updated. */
    updated_at?: string;
    /** The date when the alias was deleted. */
    deleted_at?: string;
    /** The subject who created the alias. */
    created_by?: string;
    /** The subject who updated the alias. */
    updated_by?: string;
    /** The subject who deleted the alias. */
    deleted_by?: string;
    /** The human-readable name of the alias. */
    name?: string;
    /** The ID of the resource instance that is being aliased. */
    resource_instance_id?: string;
    /** The CRN of the target namespace in the specific environment. */
    target_crn?: string;
    /** An alpha-numeric value identifying the account ID. */
    account_id?: string;
    /** The unique ID of the offering. This value is provided by and stored in the global catalog. */
    resource_id?: string;
    /** The ID of the resource group. */
    resource_group_id?: string;
    /** The CRN of the alias. For more information about this format, see [Cloud Resource
     *  Names](https://cloud.ibm.com/docs/overview?topic=overview-crn).
     */
    crn?: string;
    /** The ID of the instance in the specific target environment, for example, `service_instance_id` in a given IBM
     *  Cloud environment.
     */
    region_instance_id?: string;
    /** The CRN of the instance in the specific target environment. */
    region_instance_crn?: string;
    /** The state of the alias. */
    state?: string;
    /** A boolean that dictates if the alias was migrated from a previous CF instance. */
    migrated?: boolean;
    /** The relative path to the resource instance. */
    resource_instance_url?: string;
    /** The relative path to the resource bindings for the alias. */
    resource_bindings_url?: string;
    /** The relative path to the resource keys for the alias. */
    resource_keys_url?: string;
  }

  /** A list of resource aliases. */
  export interface ResourceAliasesList {
    /** The number of resource aliases in `resources`. */
    rows_count: number;
    /** The URL for requesting the next page of results. */
    next_url: string;
    /** A list of resource aliases. */
    resources: ResourceAlias[];
  }

  /** A resource binding. */
  export interface ResourceBinding {
    /** The ID associated with the binding. */
    id?: string;
    /** When you create a new binding, a globally unique identifier (GUID) is assigned. This GUID is a unique
     *  internal identifier managed by the resource controller that corresponds to the binding.
     */
    guid?: string;
    /** When you provision a new binding, a relative URL path is created identifying the location of the binding. */
    url?: string;
    /** The date when the binding was created. */
    created_at?: string;
    /** The date when the binding was last updated. */
    updated_at?: string;
    /** The date when the binding was deleted. */
    deleted_at?: string;
    /** The subject who created the binding. */
    created_by?: string;
    /** The subject who updated the binding. */
    updated_by?: string;
    /** The subject who deleted the binding. */
    deleted_by?: string;
    /** The CRN of resource alias associated to the binding. */
    source_crn?: string;
    /** The CRN of target resource, for example, application, in a specific environment. */
    target_crn?: string;
    /** The full Cloud Resource Name (CRN) associated with the binding. For more information about this format, see
     *  [Cloud Resource Names](https://cloud.ibm.com/docs/overview?topic=overview-crn).
     */
    crn?: string;
    /** The ID of the binding in the specific target environment, for example, `service_binding_id` in a given IBM
     *  Cloud environment.
     */
    region_binding_id?: string;
    /** The CRN of the binding in the specific target environment. */
    region_binding_crn?: string;
    /** The human-readable name of the binding. */
    name?: string;
    /** An alpha-numeric value identifying the account ID. */
    account_id?: string;
    /** The ID of the resource group. */
    resource_group_id?: string;
    /** The state of the binding. */
    state?: string;
    /** The credentials for the binding. Additional key-value pairs are passed through from the resource brokers.
     *  For additional details, see the service’s documentation.
     */
    credentials?: Credentials;
    /** Specifies whether the binding’s credentials support IAM. */
    iam_compatible?: boolean;
    /** The unique ID of the offering. This value is provided by and stored in the global catalog. */
    resource_id?: string;
    /** A boolean that dictates if the alias was migrated from a previous CF instance. */
    migrated?: boolean;
    /** The relative path to the resource alias that this binding is associated with. */
    resource_alias_url?: string;
  }

  /** Configuration options represented as key-value pairs. Service defined options are passed through to the target resource brokers, whereas platform defined options are not. */
  export interface ResourceBindingPostParameters {
    /** An optional platform defined option to reuse an existing IAM serviceId for the role assignment. */
    serviceid_crn?: string;
    /** ResourceBindingPostParameters accepts additional properties. */
    [propName: string]: any;
  }

  /** A list of resource bindings. */
  export interface ResourceBindingsList {
    /** The number of resource bindings in `resources`. */
    rows_count: number;
    /** The URL for requesting the next page of results. */
    next_url: string;
    /** A list of resource bindings. */
    resources: ResourceBinding[];
  }

  /** A resource instance. */
  export interface ResourceInstance {
    /** The ID associated with the instance. */
    id?: string;
    /** When you create a new resource, a globally unique identifier (GUID) is assigned. This GUID is a unique
     *  internal identifier managed by the resource controller that corresponds to the instance.
     */
    guid?: string;
    /** When you provision a new resource, a relative URL path is created identifying the location of the instance. */
    url?: string;
    /** The date when the instance was created. */
    created_at?: string;
    /** The date when the instance was last updated. */
    updated_at?: string;
    /** The date when the instance was deleted. */
    deleted_at?: string;
    /** The subject who created the instance. */
    created_by?: string;
    /** The subject who updated the instance. */
    updated_by?: string;
    /** The subject who deleted the instance. */
    deleted_by?: string;
    /** The date when the instance was scheduled for reclamation. */
    scheduled_reclaim_at?: string;
    /** The date when the instance under reclamation was restored. */
    restored_at?: string;
    /** The subject who restored the instance back from reclamation. */
    restored_by?: string;
    /** The subject who initiated the instance reclamation. */
    scheduled_reclaim_by?: string;
    /** The human-readable name of the instance. */
    name?: string;
    /** The deployment location where the instance was provisioned. */
    region_id?: string;
    /** An alpha-numeric value identifying the account ID. */
    account_id?: string;
    /** The unique ID of the reseller channel where the instance was provisioned from. */
    reseller_channel_id?: string;
    /** The unique ID of the plan associated with the offering. This value is provided by and stored in the global
     *  catalog.
     */
    resource_plan_id?: string;
    /** The ID of the resource group. */
    resource_group_id?: string;
    /** The CRN of the resource group. */
    resource_group_crn?: string;
    /** The deployment CRN as defined in the global catalog. The Cloud Resource Name (CRN) of the deployment
     *  location where the instance is provisioned.
     */
    target_crn?: string;
    /** The current configuration parameters of the instance. */
    parameters?: JsonObject;
    /** A boolean that dictates if the resource instance should be deleted (cleaned up) during the processing of a
     *  region instance delete call.
     */
    allow_cleanup?: boolean;
    /** The full Cloud Resource Name (CRN) associated with the instance. For more information about this format, see
     *  [Cloud Resource Names](https://cloud.ibm.com/docs/overview?topic=overview-crn).
     */
    crn?: string;
    /** The current state of the instance. For example, if the instance is deleted, it will return removed. */
    state?: string;
    /** The type of the instance, for example, `service_instance`. */
    type?: string;
    /** The sub-type of instance, for example, `cfaas`. */
    sub_type?: string;
    /** The unique ID of the offering. This value is provided by and stored in the global catalog. */
    resource_id?: string;
    /** The resource-broker-provided URL to access administrative features of the instance. */
    dashboard_url?: string;
    /** The status of the last operation requested on the instance. */
    last_operation?: JsonObject;
    /** The relative path to the resource aliases for the instance. */
    resource_aliases_url?: string;
    /** The relative path to the resource bindings for the instance. */
    resource_bindings_url?: string;
    /** The relative path to the resource keys for the instance. */
    resource_keys_url?: string;
    /** The plan history of the instance. */
    plan_history?: PlanHistoryItem[];
    /** A boolean that dictates if the resource instance was migrated from a previous CF instance. */
    migrated?: boolean;
    /** Additional instance properties, contributed by the service and/or platform, are represented as key-value
     *  pairs.
     */
    extensions?: JsonObject;
    /** The CRN of the resource that has control of the instance. */
    controlled_by?: string;
    /** A boolean that dictates if the resource instance is locked or not. */
    locked?: boolean;
  }

  /** A list of resource instances. */
  export interface ResourceInstancesList {
    /** The number of resource instances in `resources`. */
    rows_count: number;
    /** The URL for requesting the next page of results. */
    next_url: string;
    /** A list of resource instances. */
    resources: ResourceInstance[];
  }

  /** A resource key. */
  export interface ResourceKey {
    /** The ID associated with the key. */
    id?: string;
    /** When you create a new key, a globally unique identifier (GUID) is assigned. This GUID is a unique internal
     *  identifier managed by the resource controller that corresponds to the key.
     */
    guid?: string;
    /** When you created a new key, a relative URL path is created identifying the location of the key. */
    url?: string;
    /** The date when the key was created. */
    created_at?: string;
    /** The date when the key was last updated. */
    updated_at?: string;
    /** The date when the key was deleted. */
    deleted_at?: string;
    /** The subject who created the key. */
    created_by?: string;
    /** The subject who updated the key. */
    updated_by?: string;
    /** The subject who deleted the key. */
    deleted_by?: string;
    /** The CRN of resource instance or alias associated to the key. */
    source_crn?: string;
    /** The human-readable name of the key. */
    name?: string;
    /** The full Cloud Resource Name (CRN) associated with the key. For more information about this format, see
     *  [Cloud Resource Names](https://cloud.ibm.com/docs/overview?topic=overview-crn).
     */
    crn?: string;
    /** The state of the key. */
    state?: string;
    /** An alpha-numeric value identifying the account ID. */
    account_id?: string;
    /** The ID of the resource group. */
    resource_group_id?: string;
    /** The unique ID of the offering. This value is provided by and stored in the global catalog. */
    resource_id?: string;
    /** The credentials for the key. Additional key-value pairs are passed through from the resource brokers.  Refer
     *  to service’s documentation for additional details.
     */
    credentials?: Credentials;
    /** Specifies whether the key’s credentials support IAM. */
    iam_compatible?: boolean;
    /** A boolean that dictates if the alias was migrated from a previous CF instance. */
    migrated?: boolean;
    /** The relative path to the resource. */
    resource_instance_url?: string;
    /** The relative path to the resource alias that this binding is associated with. */
    resource_alias_url?: string;
  }

  /** Configuration options represented as key-value pairs. Service defined options are passed through to the target resource brokers, whereas platform defined options are not. */
  export interface ResourceKeyPostParameters {
    /** An optional platform defined option to reuse an existing IAM serviceId for the role assignment. */
    serviceid_crn?: string;
    /** ResourceKeyPostParameters accepts additional properties. */
    [propName: string]: any;
  }

  /** A list of resource keys. */
  export interface ResourceKeysList {
    /** The number of resource keys in `resources`. */
    rows_count: number;
    /** The URL for requesting the next page of results. */
    next_url: string;
    /** A list of resource keys. */
    resources: ResourceKey[];
  }

}

export = ResourceControllerV2;
