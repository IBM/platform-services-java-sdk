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
 * IBM OpenAPI SDK Code Generator Version: 99-SNAPSHOT-ef5e13c2-20200915-144510
 */
 

import * as extend from 'extend';
import { IncomingHttpHeaders, OutgoingHttpHeaders } from 'http';
import { Authenticator, BaseService, getAuthenticatorFromEnvironment, getMissingParams, UserOptions } from 'ibm-cloud-sdk-core';
import { getSdkHeaders } from '../lib/common';

/**
 * Manage lifecycle of your Cloud resource groups using Resource Manager APIs.
 */

class ResourceManagerV2 extends BaseService {

  static DEFAULT_SERVICE_URL: string = 'https://resource-controller.cloud.ibm.com/v2';
  static DEFAULT_SERVICE_NAME: string = 'resource_manager';

  /*************************
   * Factory method
   ************************/

  /**
   * Constructs an instance of ResourceManagerV2 with passed in options and external configuration.
   *
   * @param {UserOptions} [options] - The parameters to send to the service.
   * @param {string} [options.serviceName] - The name of the service to configure
   * @param {Authenticator} [options.authenticator] - The Authenticator object used to authenticate requests to the service
   * @param {string} [options.serviceUrl] - The URL for the service
   * @returns {ResourceManagerV2}
   */

  public static newInstance(options: UserOptions): ResourceManagerV2 {
    options = options || {};

    if (!options.serviceName) {
      options.serviceName = this.DEFAULT_SERVICE_NAME;
    }
    if (!options.authenticator) {
      options.authenticator = getAuthenticatorFromEnvironment(options.serviceName);
    }
    const service = new ResourceManagerV2(options);
    service.configureService(options.serviceName);
    if (options.serviceUrl) {
      service.setServiceUrl(options.serviceUrl);
    }
    return service;
  }


  /**
   * Construct a ResourceManagerV2 object.
   *
   * @param {Object} options - Options for the service.
   * @param {string} [options.serviceUrl] - The base url to use when contacting the service (e.g. 'https://gateway.watsonplatform.net/v2'). The base url may differ between IBM Cloud regions.
   * @param {OutgoingHttpHeaders} [options.headers] - Default headers that shall be included with every request to the service.
   * @param {Authenticator} options.authenticator - The Authenticator object used to authenticate requests to the service
   * @constructor
   * @returns {ResourceManagerV2}
   */
  constructor(options: UserOptions) {
    options = options || {};

    super(options);
    if (options.serviceUrl) {
      this.setServiceUrl(options.serviceUrl);
    } else {
      this.setServiceUrl(ResourceManagerV2.DEFAULT_SERVICE_URL);
    }
  }

  /*************************
   * resourceGroup
   ************************/

  /**
   * Get a list of all resource groups.
   *
   * Get a list of all resource groups in an account.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {string} [params.accountId] - The ID of the account that contains the resource groups that you want to get.
   * @param {string} [params.date] - The date would be in a format of YYYY-MM which returns resource groups exclude the
   * deleted ones before this month.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceManagerV2.Response<ResourceManagerV2.ResourceGroupList>>}
   */
  public listResourceGroups(params?: ResourceManagerV2.ListResourceGroupsParams): Promise<ResourceManagerV2.Response<ResourceManagerV2.ResourceGroupList>> {
    const _params = Object.assign({}, params);

    return new Promise((resolve, reject) => {
      const query = {
        'account_id': _params.accountId,
        'date': _params.date
      };

      const sdkHeaders = getSdkHeaders(ResourceManagerV2.DEFAULT_SERVICE_NAME, 'v2', 'listResourceGroups');

      const parameters = {
        options: {
          url: '/resource_groups',
          method: 'GET',
          qs: query,
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
   * Create a new resource group.
   *
   * Create a new resource group in an account.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {string} [params.name] - The new name of the resource group.
   * @param {string} [params.accountId] - The account id of the resource group.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceManagerV2.Response<ResourceManagerV2.ResCreateResourceGroup>>}
   */
  public createResourceGroup(params?: ResourceManagerV2.CreateResourceGroupParams): Promise<ResourceManagerV2.Response<ResourceManagerV2.ResCreateResourceGroup>> {
    const _params = Object.assign({}, params);

    return new Promise((resolve, reject) => {
      const body = {
        'name': _params.name,
        'account_id': _params.accountId
      };

      const sdkHeaders = getSdkHeaders(ResourceManagerV2.DEFAULT_SERVICE_NAME, 'v2', 'createResourceGroup');

      const parameters = {
        options: {
          url: '/resource_groups',
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

      return resolve(this.createRequest(parameters));
    });
  };

  /**
   * Get a resource group.
   *
   * Retrieve a resource group by ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The short or long ID of the alias.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceManagerV2.Response<ResourceManagerV2.ResourceGroup>>}
   */
  public getResourceGroup(params: ResourceManagerV2.GetResourceGroupParams): Promise<ResourceManagerV2.Response<ResourceManagerV2.ResourceGroup>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['id'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'id': _params.id
      };

      const sdkHeaders = getSdkHeaders(ResourceManagerV2.DEFAULT_SERVICE_NAME, 'v2', 'getResourceGroup');

      const parameters = {
        options: {
          url: '/resource_groups/{id}',
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
   * Update a resource group.
   *
   * Update a resource group by ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The short or long ID of the alias.
   * @param {string} [params.name] - The new name of the resource group.
   * @param {string} [params.state] - The state of the resource group.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceManagerV2.Response<ResourceManagerV2.ResourceGroup>>}
   */
  public updateResourceGroup(params: ResourceManagerV2.UpdateResourceGroupParams): Promise<ResourceManagerV2.Response<ResourceManagerV2.ResourceGroup>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['id'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const body = {
        'name': _params.name,
        'state': _params.state
      };

      const path = {
        'id': _params.id
      };

      const sdkHeaders = getSdkHeaders(ResourceManagerV2.DEFAULT_SERVICE_NAME, 'v2', 'updateResourceGroup');

      const parameters = {
        options: {
          url: '/resource_groups/{id}',
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

      return resolve(this.createRequest(parameters));
    });
  };

  /**
   * Delete a resource group.
   *
   * Delete a resource group by ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The short or long ID of the alias.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceManagerV2.Response<ResourceManagerV2.Empty>>}
   */
  public deleteResourceGroup(params: ResourceManagerV2.DeleteResourceGroupParams): Promise<ResourceManagerV2.Response<ResourceManagerV2.Empty>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['id'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'id': _params.id
      };

      const sdkHeaders = getSdkHeaders(ResourceManagerV2.DEFAULT_SERVICE_NAME, 'v2', 'deleteResourceGroup');

      const parameters = {
        options: {
          url: '/resource_groups/{id}',
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
   * quotaDefinition
   ************************/

  /**
   * List quota definitions.
   *
   * Get a list of all quota definitions.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceManagerV2.Response<ResourceManagerV2.QuotaDefinitionList>>}
   */
  public listQuotaDefinitions(params?: ResourceManagerV2.ListQuotaDefinitionsParams): Promise<ResourceManagerV2.Response<ResourceManagerV2.QuotaDefinitionList>> {
    const _params = Object.assign({}, params);

    return new Promise((resolve, reject) => {
      const sdkHeaders = getSdkHeaders(ResourceManagerV2.DEFAULT_SERVICE_NAME, 'v2', 'listQuotaDefinitions');

      const parameters = {
        options: {
          url: '/quota_definitions',
          method: 'GET',
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
   * Get a quota definition.
   *
   * Get a a quota definition.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The id of the quota.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ResourceManagerV2.Response<ResourceManagerV2.QuotaDefinition>>}
   */
  public getQuotaDefinition(params: ResourceManagerV2.GetQuotaDefinitionParams): Promise<ResourceManagerV2.Response<ResourceManagerV2.QuotaDefinition>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['id'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'id': _params.id
      };

      const sdkHeaders = getSdkHeaders(ResourceManagerV2.DEFAULT_SERVICE_NAME, 'v2', 'getQuotaDefinition');

      const parameters = {
        options: {
          url: '/quota_definitions/{id}',
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

namespace ResourceManagerV2 {

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

  /** Parameters for the `listResourceGroups` operation. */
  export interface ListResourceGroupsParams {
    /** The ID of the account that contains the resource groups that you want to get. */
    accountId?: string;
    /** The date would be in a format of YYYY-MM which returns resource groups exclude the deleted ones before this
     *  month.
     */
    date?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `createResourceGroup` operation. */
  export interface CreateResourceGroupParams {
    /** The new name of the resource group. */
    name?: string;
    /** The account id of the resource group. */
    accountId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getResourceGroup` operation. */
  export interface GetResourceGroupParams {
    /** The short or long ID of the alias. */
    id: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `updateResourceGroup` operation. */
  export interface UpdateResourceGroupParams {
    /** The short or long ID of the alias. */
    id: string;
    /** The new name of the resource group. */
    name?: string;
    /** The state of the resource group. */
    state?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deleteResourceGroup` operation. */
  export interface DeleteResourceGroupParams {
    /** The short or long ID of the alias. */
    id: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listQuotaDefinitions` operation. */
  export interface ListQuotaDefinitionsParams {
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getQuotaDefinition` operation. */
  export interface GetQuotaDefinitionParams {
    /** The id of the quota. */
    id: string;
    headers?: OutgoingHttpHeaders;
  }

  /*************************
   * model interfaces
   ************************/

  /** A returned quota definition. */
  export interface QuotaDefinition {
    /** An alpha-numeric value identifying the quota. */
    id?: string;
    /** The human-readable name of the quota. */
    name?: string;
    /** The type of the quota. */
    type?: string;
    /** The total app limit. */
    number_of_apps?: number;
    /** The total service instances limit per app. */
    number_of_service_instances?: number;
    /** Default number of instances per lite plan. */
    default_number_of_instances_per_lite_plan?: number;
    /** The total instances limit per app. */
    instances_per_app?: number;
    /** The total memory of app instance. */
    instance_memory?: string;
    /** The total app memory capacity. */
    total_app_memory?: string;
    /** The VSI limit. */
    vsi_limit?: number;
    /** The resource quotas associated with a quota definition. */
    resource_quotas?: ResourceQuota[];
    /** The date when the quota was initially created. */
    created_at?: string;
    /** The date when the quota was last updated. */
    updated_at?: string;
  }

  /** A list of quota definitions. */
  export interface QuotaDefinitionList {
    /** The list of quota definitions. */
    resources: QuotaDefinition[];
  }

  /** A newly-created resource group. */
  export interface ResCreateResourceGroup {
    /** An alpha-numeric value identifying the resource group. */
    id?: string;
    /** The full CRN (cloud resource name) associated with the resource group. For more on this format, see [Cloud
     *  Resource Names](https://cloud.ibm.com/docs/resources?topic=resources-crn).
     */
    crn?: string;
  }

  /** A resource group. */
  export interface ResourceGroup {
    /** An alpha-numeric value identifying the resource group. */
    id?: string;
    /** The full CRN (cloud resource name) associated with the resource group. For more on this format, see [Cloud
     *  Resource Names](https://cloud.ibm.com/docs/resources?topic=resources-crn).
     */
    crn?: string;
    /** An alpha-numeric value identifying the account ID. */
    account_id?: string;
    /** The human-readable name of the resource group. */
    name?: string;
    /** The state of the resource group. */
    state?: string;
    /** Identify if this resource group is default of the account or not. */
    default?: boolean;
    /** An alpha-numeric value identifying the quota ID associated with the resource group. */
    quota_id?: string;
    /** The URL to access the quota details that associated with the resource group. */
    quota_url?: string;
    /** The URL to access the payment methods details that associated with the resource group. */
    payment_methods_url?: string;
    /** An array of the resources that linked to the resource group. */
    resource_linkages?: JsonObject[];
    /** The URL to access the team details that associated with the resource group. */
    teams_url?: string;
    /** The date when the resource group was initially created. */
    created_at?: string;
    /** The date when the resource group was last updated. */
    updated_at?: string;
  }

  /** A list of resource groups. */
  export interface ResourceGroupList {
    /** The list of resource groups. */
    resources: ResourceGroup[];
  }

  /** A resource quota. */
  export interface ResourceQuota {
    /** An alpha-numeric value identifying the quota. */
    _id?: string;
    /** The human-readable name of the quota. */
    resource_id?: string;
    /** The full CRN (cloud resource name) associated with the quota. For more on this format, see
     *  https://cloud.ibm.com/docs/resources?topic=resources-crn#crn.
     */
    crn?: string;
    /** The limit number of this resource. */
    limit?: number;
  }

}

export = ResourceManagerV2;
