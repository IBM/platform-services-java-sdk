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

/**
 * IBM OpenAPI SDK Code Generator Version: 99-SNAPSHOT-8d569e8f-20201030-111043
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
   * @param {string} [options.serviceUrl] - The base url to use when contacting the service (e.g. 'https://gateway.watsonplatform.net'). The base url may differ between IBM Cloud regions.
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
   * Get a list of all resource instances.
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
   * @param {string} [params.type] - The type of the instance. For example, `service_instance`.
   * @param {string} [params.subType] - The sub-type of instance, e.g. `cfaas`.
   * @param {string} [params.limit] - Limit on how many items should be returned.
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
   * Provision a new resource in the specified location for the selected plan.
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
   * @param {string} [params.entityLock] - Indicates if the resource instance is locked for further update or delete
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
   * Retrieve a resource instance by ID.
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
   * Delete a resource instance by ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The short or long ID of the instance.
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

    const path = {
      'id': _params.id
    };

    const sdkHeaders = getSdkHeaders(ResourceControllerV2.DEFAULT_SERVICE_NAME, 'v2', 'deleteResourceInstance');

    const parameters = {
      options: {
        url: '/v2/resource_instances/{id}',
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
   * Update a resource instance.
   *
   * Update a resource instance by ID.
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
   * Unlocks a resource instance by ID.
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
   * @param {string} [params.limit] - Limit on how many items should be returned.
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
   * @param {string} [params.regionBindingId] - Short ID of the binding in the specific targeted environment, e.g.
   * service_binding_id in a given IBM Cloud environment.
   * @param {string} [params.limit] - Limit on how many items should be returned.
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
   * @param {string} params.target - The CRN of application to bind to in a specific environment, e.g. Dallas YP, CFEE
   * instance.
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
   * @param {string} [params.limit] - Limit on how many items should be returned.
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
   * @param {string} params.target - The CRN of target name(space) in a specific environment, e.g. space in Dallas YP,
   * CFEE instance etc.
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
    /** The type of the instance. For example, `service_instance`. */
    type?: string;
    /** The sub-type of instance, e.g. `cfaas`. */
    subType?: string;
    /** Limit on how many items should be returned. */
    limit?: string;
    /** Start date inclusive filter. */
    updatedFrom?: string;
    /** End date inclusive filter. */
    updatedTo?: string;
    headers?: OutgoingHttpHeaders;
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
    entityLock?: string;
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
    limit?: string;
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
    /** Short ID of the binding in the specific targeted environment, e.g. service_binding_id in a given IBM Cloud
     *  environment.
     */
    regionBindingId?: string;
    /** Limit on how many items should be returned. */
    limit?: string;
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
    /** The CRN of application to bind to in a specific environment, e.g. Dallas YP, CFEE instance. */
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
    limit?: string;
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
    /** The CRN of target name(space) in a specific environment, e.g. space in Dallas YP, CFEE instance etc. */
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
    /** The full Cloud Resource Name (CRN) associated with the alias. For more information about this format, see
     *  [Cloud Resource Names](https://cloud.ibm.com/docs/overview?topic=overview-crn).
     */
    crn?: string;
    /** When you created a new alias, a relative URL path is created identifying the location of the alias. */
    url?: string;
    /** The human-readable name of the alias. */
    name?: string;
    /** An alpha-numeric value identifying the account ID. */
    account_id?: string;
    /** The short ID of the resource group. */
    resource_group_id?: string;
    /** The long ID (full CRN) of the resource group. */
    resource_group_crn?: string;
    /** The CRN of the target namespace in the specific environment. */
    target_crn?: string;
    /** The state of the alias. */
    state?: string;
    /** The short ID of the resource instance that is being aliased. */
    resource_instance_id?: string;
    /** The short ID of the instance in the specific target environment, e.g. `service_instance_id` in a given IBM
     *  Cloud environment.
     */
    region_instance_id?: string;
    /** The relative path to the instance. */
    resource_instance_url?: string;
    /** The relative path to the resource bindings for the alias. */
    resource_bindings_url?: string;
    /** The relative path to the resource keys for the alias. */
    resource_keys_url?: string;
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
  }

  /** A list of resource aliases. */
  export interface ResourceAliasesList {
    /** The URL for requesting the next page of results. */
    next_url: string;
    /** A list of resource aliases. */
    resources: ResourceAlias[];
    /** The number of resource aliases in `resources`. */
    rows_count: number;
  }

  /** A resource binding. */
  export interface ResourceBinding {
    /** The ID associated with the binding. */
    id?: string;
    /** When you create a new binding, a globally unique identifier (GUID) is assigned. This GUID is a unique
     *  internal identifier managed by the resource controller that corresponds to the binding.
     */
    guid?: string;
    /** The full Cloud Resource Name (CRN) associated with the binding. For more information about this format, see
     *  [Cloud Resource Names](https://cloud.ibm.com/docs/overview?topic=overview-crn).
     */
    crn?: string;
    /** When you provision a new binding, a relative URL path is created identifying the location of the binding. */
    url?: string;
    /** The human-readable name of the binding. */
    name?: string;
    /** An alpha-numeric value identifying the account ID. */
    account_id?: string;
    /** The short ID of the resource group. */
    resource_group_id?: string;
    /** The CRN of resource alias associated to the binding. */
    source_crn?: string;
    /** The CRN of target resource, e.g. application, in a specific environment. */
    target_crn?: string;
    /** The role CRN. */
    role?: string;
    /** The short ID of the binding in specific targeted environment, e.g. `service_binding_id` in a given IBM Cloud
     *  environment.
     */
    region_binding_id?: string;
    /** The state of the binding. */
    state?: string;
    /** The credentials for the binding. Additional key-value pairs are passed through from the resource brokers.
     *  For additional details, see the service’s documentation.
     */
    credentials?: Credentials;
    /** Specifies whether the binding’s credentials support IAM. */
    iam_compatible?: boolean;
    /** The relative path to the resource alias that this binding is associated with. */
    resource_alias_url?: string;
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
  }

  /** Configuration options represented as key-value pairs. Service defined options are passed through to the target resource brokers, whereas platform defined options are not. */
  export interface ResourceBindingPostParameters {
    /** An optional platform defined option to reuse an existing IAM serviceId for the role assignment. */
    serviceid_crn?: string;
  }

  /** A list of resource bindings. */
  export interface ResourceBindingsList {
    /** The URL for requesting the next page of results. */
    next_url: string;
    /** A list of resource bindings. */
    resources: ResourceBinding[];
    /** The number of resource bindings in `resources`. */
    rows_count: number;
  }

  /** A resource instance. */
  export interface ResourceInstance {
    /** The ID associated with the instance. */
    id?: string;
    /** When you create a new resource, a globally unique identifier (GUID) is assigned. This GUID is a unique
     *  internal identifier managed by the resource controller that corresponds to the instance.
     */
    guid?: string;
    /** The full Cloud Resource Name (CRN) associated with the instance. For more information about this format, see
     *  [Cloud Resource Names](https://cloud.ibm.com/docs/overview?topic=overview-crn).
     */
    crn?: string;
    /** When you provision a new resource, a relative URL path is created identifying the location of the instance. */
    url?: string;
    /** The human-readable name of the instance. */
    name?: string;
    /** An alpha-numeric value identifying the account ID. */
    account_id?: string;
    /** The short ID of the resource group. */
    resource_group_id?: string;
    /** The long ID (full CRN) of the resource group. */
    resource_group_crn?: string;
    /** The unique ID of the offering. This value is provided by and stored in the global catalog. */
    resource_id?: string;
    /** The unique ID of the plan associated with the offering. This value is provided by and stored in the global
     *  catalog.
     */
    resource_plan_id?: string;
    /** The full deployment CRN as defined in the global catalog. The Cloud Resource Name (CRN) of the deployment
     *  location where the instance is provisioned.
     */
    target_crn?: string;
    /** The current configuration parameters of the instance. */
    parameters?: JsonObject;
    /** The current state of the instance. For example, if the instance is deleted, it will return removed. */
    state?: string;
    /** The type of the instance, e.g. `service_instance`. */
    type?: string;
    /** The sub-type of instance, e.g. `cfaas`. */
    sub_type?: string;
    /** A boolean that dictates if the resource instance should be deleted (cleaned up) during the processing of a
     *  region instance delete call.
     */
    allow_cleanup?: boolean;
    /** A boolean that dictates if the resource instance is locked or not. */
    locked?: boolean;
    /** The status of the last operation requested on the instance. */
    last_operation?: JsonObject;
    /** The resource-broker-provided URL to access administrative features of the instance. */
    dashboard_url?: string;
    /** The plan history of the instance. */
    plan_history?: PlanHistoryItem[];
    /** The relative path to the resource aliases for the instance. */
    resource_aliases_url?: string;
    /** The relative path to the resource bindings for the instance. */
    resource_bindings_url?: string;
    /** The relative path to the resource keys for the instance. */
    resource_keys_url?: string;
    /** The date when the instance was created. */
    created_at?: string;
    /** The subject who created the instance. */
    created_by?: string;
    /** The date when the instance was last updated. */
    updated_at?: string;
    /** The subject who updated the instance. */
    updated_by?: string;
    /** The date when the instance was deleted. */
    deleted_at?: string;
    /** The subject who deleted the instance. */
    deleted_by?: string;
    /** The date when the instance was scheduled for reclamation. */
    scheduled_reclaim_at?: string;
    /** The subject who initiated the instance reclamation. */
    scheduled_reclaim_by?: string;
    /** The date when the instance under reclamation was restored. */
    restored_at?: string;
    /** The subject who restored the instance back from reclamation. */
    restored_by?: string;
  }

  /** A list of resource instances. */
  export interface ResourceInstancesList {
    /** The URL for requesting the next page of results. */
    next_url: string;
    /** A list of resource instances. */
    resources: ResourceInstance[];
    /** The number of resource instances in `resources`. */
    rows_count: number;
  }

  /** A resource key. */
  export interface ResourceKey {
    /** The ID associated with the key. */
    id?: string;
    /** When you create a new key, a globally unique identifier (GUID) is assigned. This GUID is a unique internal
     *  identifier managed by the resource controller that corresponds to the key.
     */
    guid?: string;
    /** The full Cloud Resource Name (CRN) associated with the key. For more information about this format, see
     *  [Cloud Resource Names](https://cloud.ibm.com/docs/overview?topic=overview-crn).
     */
    crn?: string;
    /** When you created a new key, a relative URL path is created identifying the location of the key. */
    url?: string;
    /** The human-readable name of the key. */
    name?: string;
    /** An alpha-numeric value identifying the account ID. */
    account_id?: string;
    /** The short ID of the resource group. */
    resource_group_id?: string;
    /** The CRN of resource instance or alias associated to the key. */
    source_crn?: string;
    /** The role CRN. */
    role?: string;
    /** The state of the key. */
    state?: string;
    /** The credentials for the key. Additional key-value pairs are passed through from the resource brokers.  Refer
     *  to service’s documentation for additional details.
     */
    credentials?: Credentials;
    /** Specifies whether the key’s credentials support IAM. */
    iam_compatible?: boolean;
    /** The relative path to the resource. */
    resource_instance_url?: string;
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
  }

  /** Configuration options represented as key-value pairs. Service defined options are passed through to the target resource brokers, whereas platform defined options are not. */
  export interface ResourceKeyPostParameters {
    /** An optional platform defined option to reuse an existing IAM serviceId for the role assignment. */
    serviceid_crn?: string;
  }

  /** A list of resource keys. */
  export interface ResourceKeysList {
    /** The URL for requesting the next page of results. */
    next_url: string;
    /** A list of resource keys. */
    resources: ResourceKey[];
    /** The number of resource keys in `resources`. */
    rows_count: number;
  }

}

export = ResourceControllerV2;
