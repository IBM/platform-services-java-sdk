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
 * IBM OpenAPI SDK Code Generator Version: 3.36.0-6f5b0381-20210716-180747
 */


import * as extend from 'extend';
import { IncomingHttpHeaders, OutgoingHttpHeaders } from 'http';
import { Authenticator, BaseService, getAuthenticatorFromEnvironment, getMissingParams, UserOptions } from 'ibm-cloud-sdk-core';
import { getSdkHeaders } from '../lib/common';

/**
 * With the Context Based Restrictions API, you can:
 * * Create, list, get, update, and delete zones
 * * Create, list, get, update, and delete rules
 * * Get account settings
 */

class ContextBasedRestrictionsV1 extends BaseService {

  static DEFAULT_SERVICE_URL: string = 'https://context-based-restrictions.cloud.ibm.com';
  static DEFAULT_SERVICE_NAME: string = 'context_based_restrictions';

  /*************************
   * Factory method
   ************************/

  /**
   * Constructs an instance of ContextBasedRestrictionsV1 with passed in options and external configuration.
   *
   * @param {UserOptions} [options] - The parameters to send to the service.
   * @param {string} [options.serviceName] - The name of the service to configure
   * @param {Authenticator} [options.authenticator] - The Authenticator object used to authenticate requests to the service
   * @param {string} [options.serviceUrl] - The URL for the service
   * @returns {ContextBasedRestrictionsV1}
   */

  public static newInstance(options: UserOptions): ContextBasedRestrictionsV1 {
    options = options || {};

    if (!options.serviceName) {
      options.serviceName = this.DEFAULT_SERVICE_NAME;
    }
    if (!options.authenticator) {
      options.authenticator = getAuthenticatorFromEnvironment(options.serviceName);
    }
    const service = new ContextBasedRestrictionsV1(options);
    service.configureService(options.serviceName);
    if (options.serviceUrl) {
      service.setServiceUrl(options.serviceUrl);
    }
    return service;
  }


  /**
   * Construct a ContextBasedRestrictionsV1 object.
   *
   * @param {Object} options - Options for the service.
   * @param {string} [options.serviceUrl] - The base url to use when contacting the service. The base url may differ between IBM Cloud regions.
   * @param {OutgoingHttpHeaders} [options.headers] - Default headers that shall be included with every request to the service.
   * @param {Authenticator} options.authenticator - The Authenticator object used to authenticate requests to the service
   * @constructor
   * @returns {ContextBasedRestrictionsV1}
   */
  constructor(options: UserOptions) {
    options = options || {};

    super(options);
    if (options.serviceUrl) {
      this.setServiceUrl(options.serviceUrl);
    } else {
      this.setServiceUrl(ContextBasedRestrictionsV1.DEFAULT_SERVICE_URL);
    }
  }

  /*************************
   * zones
   ************************/

  /**
   * Create a zone.
   *
   * Creates a zone for the specified account.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {string} [params.name] - The name of the zone.
   * @param {string} [params.accountId] - The id of the account owning this zone.
   * @param {Address[]} [params.addresses] - The list of addresses in the zone.
   * @param {string} [params.description] - The description of the zone.
   * @param {Address[]} [params.excluded] - The list of excluded addresses in the zone.
   * @param {string} [params.transactionId] - The UUID that is used to correlate and track transactions. If you omit
   * this field, the service generates and sends a transaction ID in the response.
   * **Note:** To help with debugging, we strongly recommend that you generate and supply a `Transaction-Id` with each
   * request.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ContextBasedRestrictionsV1.Response<ContextBasedRestrictionsV1.OutZone>>}
   */
  public createZone(params?: ContextBasedRestrictionsV1.CreateZoneParams): Promise<ContextBasedRestrictionsV1.Response<ContextBasedRestrictionsV1.OutZone>> {
    const _params = Object.assign({}, params);

    const body = {
      'name': _params.name,
      'account_id': _params.accountId,
      'addresses': _params.addresses,
      'description': _params.description,
      'excluded': _params.excluded
    };

    const sdkHeaders = getSdkHeaders(ContextBasedRestrictionsV1.DEFAULT_SERVICE_NAME, 'v1', 'createZone');

    const parameters = {
      options: {
        url: '/v1/zones',
        method: 'POST',
        body,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
          'Transaction-Id': _params.transactionId
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * List zones.
   *
   * Lists zones for the specified account.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - The ID of the managing account.
   * @param {string} [params.transactionId] - The UUID that is used to correlate and track transactions. If you omit
   * this field, the service generates and sends a transaction ID in the response.
   * **Note:** To help with debugging, we strongly recommend that you generate and supply a `Transaction-Id` with each
   * request.
   * @param {string} [params.name] - The name of the zone.
   * @param {string} [params.sort] - Sorts results by using a valid sort field. To learn more, see
   * [Sorting](https://cloud.ibm.com/docs/api-handbook?topic=api-handbook-sorting).
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ContextBasedRestrictionsV1.Response<ContextBasedRestrictionsV1.OutZonePage>>}
   */
  public listZones(params: ContextBasedRestrictionsV1.ListZonesParams): Promise<ContextBasedRestrictionsV1.Response<ContextBasedRestrictionsV1.OutZonePage>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['accountId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'account_id': _params.accountId,
      'name': _params.name,
      'sort': _params.sort
    };

    const sdkHeaders = getSdkHeaders(ContextBasedRestrictionsV1.DEFAULT_SERVICE_NAME, 'v1', 'listZones');

    const parameters = {
      options: {
        url: '/v1/zones',
        method: 'GET',
        qs: query,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Transaction-Id': _params.transactionId
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Get the specified zone.
   *
   * Gets the zone for the specified ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.zoneId - The ID of a zone.
   * @param {string} [params.transactionId] - The UUID that is used to correlate and track transactions. If you omit
   * this field, the service generates and sends a transaction ID in the response.
   * **Note:** To help with debugging, we strongly recommend that you generate and supply a `Transaction-Id` with each
   * request.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ContextBasedRestrictionsV1.Response<ContextBasedRestrictionsV1.OutZone>>}
   */
  public getZone(params: ContextBasedRestrictionsV1.GetZoneParams): Promise<ContextBasedRestrictionsV1.Response<ContextBasedRestrictionsV1.OutZone>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['zoneId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'zone_id': _params.zoneId
    };

    const sdkHeaders = getSdkHeaders(ContextBasedRestrictionsV1.DEFAULT_SERVICE_NAME, 'v1', 'getZone');

    const parameters = {
      options: {
        url: '/v1/zones/{zone_id}',
        method: 'GET',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Transaction-Id': _params.transactionId
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Update the specified zone.
   *
   * Updates the zone for the specified ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.zoneId - The ID of a zone.
   * @param {string} params.ifMatch - The current revision of the resource being updated. This can be found in the
   * Create/Get/Update resource response ETag header.
   * @param {string} [params.name] - The name of the zone.
   * @param {string} [params.accountId] - The id of the account owning this zone.
   * @param {Address[]} [params.addresses] - The list of addresses in the zone.
   * @param {string} [params.description] - The description of the zone.
   * @param {Address[]} [params.excluded] - The list of excluded addresses in the zone.
   * @param {string} [params.transactionId] - The UUID that is used to correlate and track transactions. If you omit
   * this field, the service generates and sends a transaction ID in the response.
   * **Note:** To help with debugging, we strongly recommend that you generate and supply a `Transaction-Id` with each
   * request.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ContextBasedRestrictionsV1.Response<ContextBasedRestrictionsV1.OutZone>>}
   */
  public replaceZone(params: ContextBasedRestrictionsV1.ReplaceZoneParams): Promise<ContextBasedRestrictionsV1.Response<ContextBasedRestrictionsV1.OutZone>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['zoneId', 'ifMatch'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'name': _params.name,
      'account_id': _params.accountId,
      'addresses': _params.addresses,
      'description': _params.description,
      'excluded': _params.excluded
    };

    const path = {
      'zone_id': _params.zoneId
    };

    const sdkHeaders = getSdkHeaders(ContextBasedRestrictionsV1.DEFAULT_SERVICE_NAME, 'v1', 'replaceZone');

    const parameters = {
      options: {
        url: '/v1/zones/{zone_id}',
        method: 'PUT',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
          'If-Match': _params.ifMatch,
          'Transaction-Id': _params.transactionId
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Delete the specified zone.
   *
   * Deletes the zone for the specified home ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.zoneId - The ID of a zone.
   * @param {string} [params.transactionId] - The UUID that is used to correlate and track transactions. If you omit
   * this field, the service generates and sends a transaction ID in the response.
   * **Note:** To help with debugging, we strongly recommend that you generate and supply a `Transaction-Id` with each
   * request.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ContextBasedRestrictionsV1.Response<ContextBasedRestrictionsV1.Empty>>}
   */
  public deleteZone(params: ContextBasedRestrictionsV1.DeleteZoneParams): Promise<ContextBasedRestrictionsV1.Response<ContextBasedRestrictionsV1.Empty>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['zoneId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'zone_id': _params.zoneId
    };

    const sdkHeaders = getSdkHeaders(ContextBasedRestrictionsV1.DEFAULT_SERVICE_NAME, 'v1', 'deleteZone');

    const parameters = {
      options: {
        url: '/v1/zones/{zone_id}',
        method: 'DELETE',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Transaction-Id': _params.transactionId
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * List available service reference targets.
   *
   * Lists all available service reference targets.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {string} [params.type] - Specifies the types of services to retrieve.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ContextBasedRestrictionsV1.Response<ContextBasedRestrictionsV1.ServiceRefTargetPage>>}
   */
  public listAvailableServicerefTargets(params?: ContextBasedRestrictionsV1.ListAvailableServicerefTargetsParams): Promise<ContextBasedRestrictionsV1.Response<ContextBasedRestrictionsV1.ServiceRefTargetPage>> {
    const _params = Object.assign({}, params);

    const query = {
      'type': _params.type
    };

    const sdkHeaders = getSdkHeaders(ContextBasedRestrictionsV1.DEFAULT_SERVICE_NAME, 'v1', 'listAvailableServicerefTargets');

    const parameters = {
      options: {
        url: '/v1/zones/serviceref_targets',
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

  /*************************
   * rules
   ************************/

  /**
   * Create a rule.
   *
   * Creates a rule for the specified account.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {RuleContext[]} [params.contexts] - The contexts this rule applies to.
   * @param {Resource[]} [params.resources] - The resources this rule apply to.
   * @param {string} [params.description] - The description of the rule.
   * @param {string} [params.transactionId] - The UUID that is used to correlate and track transactions. If you omit
   * this field, the service generates and sends a transaction ID in the response.
   * **Note:** To help with debugging, we strongly recommend that you generate and supply a `Transaction-Id` with each
   * request.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ContextBasedRestrictionsV1.Response<ContextBasedRestrictionsV1.OutRule>>}
   */
  public createRule(params?: ContextBasedRestrictionsV1.CreateRuleParams): Promise<ContextBasedRestrictionsV1.Response<ContextBasedRestrictionsV1.OutRule>> {
    const _params = Object.assign({}, params);

    const body = {
      'contexts': _params.contexts,
      'resources': _params.resources,
      'description': _params.description
    };

    const sdkHeaders = getSdkHeaders(ContextBasedRestrictionsV1.DEFAULT_SERVICE_NAME, 'v1', 'createRule');

    const parameters = {
      options: {
        url: '/v1/rules',
        method: 'POST',
        body,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
          'Transaction-Id': _params.transactionId
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * List rules.
   *
   * Lists rules for the specified account.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - The ID of the managing account.
   * @param {string} [params.transactionId] - The UUID that is used to correlate and track transactions. If you omit
   * this field, the service generates and sends a transaction ID in the response.
   * **Note:** To help with debugging, we strongly recommend that you generate and supply a `Transaction-Id` with each
   * request.
   * @param {string} [params.region] - The `region` resource attribute.
   * @param {string} [params.resource] - The `resource` resource attribute.
   * @param {string} [params.resourceType] - The `resourceType` resource attribute.
   * @param {string} [params.serviceInstance] - The `serviceInstance` resource attribute.
   * @param {string} [params.serviceName] - The `serviceName` resource attribute.
   * @param {string} [params.serviceType] - The rule's `serviceType` resource attribute.
   * @param {string} [params.zoneId] - The globally unique ID of the zone.
   * @param {string} [params.sort] - Sorts results by using a valid sort field. To learn more, see
   * [Sorting](https://cloud.ibm.com/docs/api-handbook?topic=api-handbook-sorting).
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ContextBasedRestrictionsV1.Response<ContextBasedRestrictionsV1.OutRulePage>>}
   */
  public listRules(params: ContextBasedRestrictionsV1.ListRulesParams): Promise<ContextBasedRestrictionsV1.Response<ContextBasedRestrictionsV1.OutRulePage>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['accountId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'account_id': _params.accountId,
      'region': _params.region,
      'resource': _params.resource,
      'resource_type': _params.resourceType,
      'service_instance': _params.serviceInstance,
      'service_name': _params.serviceName,
      'service_type': _params.serviceType,
      'zone_id': _params.zoneId,
      'sort': _params.sort
    };

    const sdkHeaders = getSdkHeaders(ContextBasedRestrictionsV1.DEFAULT_SERVICE_NAME, 'v1', 'listRules');

    const parameters = {
      options: {
        url: '/v1/rules',
        method: 'GET',
        qs: query,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Transaction-Id': _params.transactionId
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Get the specified rule.
   *
   * Gets the rule for the specified ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.ruleId - The ID of a rule.
   * @param {string} [params.transactionId] - The UUID that is used to correlate and track transactions. If you omit
   * this field, the service generates and sends a transaction ID in the response.
   * **Note:** To help with debugging, we strongly recommend that you generate and supply a `Transaction-Id` with each
   * request.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ContextBasedRestrictionsV1.Response<ContextBasedRestrictionsV1.OutRule>>}
   */
  public getRule(params: ContextBasedRestrictionsV1.GetRuleParams): Promise<ContextBasedRestrictionsV1.Response<ContextBasedRestrictionsV1.OutRule>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['ruleId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'rule_id': _params.ruleId
    };

    const sdkHeaders = getSdkHeaders(ContextBasedRestrictionsV1.DEFAULT_SERVICE_NAME, 'v1', 'getRule');

    const parameters = {
      options: {
        url: '/v1/rules/{rule_id}',
        method: 'GET',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Transaction-Id': _params.transactionId
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Update the specified rule.
   *
   * Updates the rule for the specified ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.ruleId - The ID of a rule.
   * @param {string} params.ifMatch - The current revision of the resource being updated. This can be found in the
   * Create/Get/Update resource response ETag header.
   * @param {RuleContext[]} [params.contexts] - The contexts this rule applies to.
   * @param {Resource[]} [params.resources] - The resources this rule apply to.
   * @param {string} [params.description] - The description of the rule.
   * @param {string} [params.transactionId] - The UUID that is used to correlate and track transactions. If you omit
   * this field, the service generates and sends a transaction ID in the response.
   * **Note:** To help with debugging, we strongly recommend that you generate and supply a `Transaction-Id` with each
   * request.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ContextBasedRestrictionsV1.Response<ContextBasedRestrictionsV1.OutRule>>}
   */
  public replaceRule(params: ContextBasedRestrictionsV1.ReplaceRuleParams): Promise<ContextBasedRestrictionsV1.Response<ContextBasedRestrictionsV1.OutRule>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['ruleId', 'ifMatch'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'contexts': _params.contexts,
      'resources': _params.resources,
      'description': _params.description
    };

    const path = {
      'rule_id': _params.ruleId
    };

    const sdkHeaders = getSdkHeaders(ContextBasedRestrictionsV1.DEFAULT_SERVICE_NAME, 'v1', 'replaceRule');

    const parameters = {
      options: {
        url: '/v1/rules/{rule_id}',
        method: 'PUT',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
          'If-Match': _params.ifMatch,
          'Transaction-Id': _params.transactionId
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Delete the specified rule.
   *
   * Deletes the rule for the specified home ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.ruleId - The ID of a rule.
   * @param {string} [params.transactionId] - The UUID that is used to correlate and track transactions. If you omit
   * this field, the service generates and sends a transaction ID in the response.
   * **Note:** To help with debugging, we strongly recommend that you generate and supply a `Transaction-Id` with each
   * request.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ContextBasedRestrictionsV1.Response<ContextBasedRestrictionsV1.Empty>>}
   */
  public deleteRule(params: ContextBasedRestrictionsV1.DeleteRuleParams): Promise<ContextBasedRestrictionsV1.Response<ContextBasedRestrictionsV1.Empty>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['ruleId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'rule_id': _params.ruleId
    };

    const sdkHeaders = getSdkHeaders(ContextBasedRestrictionsV1.DEFAULT_SERVICE_NAME, 'v1', 'deleteRule');

    const parameters = {
      options: {
        url: '/v1/rules/{rule_id}',
        method: 'DELETE',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Transaction-Id': _params.transactionId
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /*************************
   * accountSettings
   ************************/

  /**
   * Get the specified account settings.
   *
   * Gets the settings for the specified account ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - The ID of the account the settings are for.
   * @param {string} [params.transactionId] - The UUID that is used to correlate and track transactions. If you omit
   * this field, the service generates and sends a transaction ID in the response.
   * **Note:** To help with debugging, we strongly recommend that you generate and supply a `Transaction-Id` with each
   * request.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ContextBasedRestrictionsV1.Response<ContextBasedRestrictionsV1.OutAccountSettings>>}
   */
  public getAccountSettings(params: ContextBasedRestrictionsV1.GetAccountSettingsParams): Promise<ContextBasedRestrictionsV1.Response<ContextBasedRestrictionsV1.OutAccountSettings>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['accountId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'account_id': _params.accountId
    };

    const sdkHeaders = getSdkHeaders(ContextBasedRestrictionsV1.DEFAULT_SERVICE_NAME, 'v1', 'getAccountSettings');

    const parameters = {
      options: {
        url: '/v1/account_settings/{account_id}',
        method: 'GET',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Transaction-Id': _params.transactionId
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

}

/*************************
 * interfaces
 ************************/

namespace ContextBasedRestrictionsV1 {

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

  /** Parameters for the `createZone` operation. */
  export interface CreateZoneParams {
    /** The name of the zone. */
    name?: string;
    /** The id of the account owning this zone. */
    accountId?: string;
    /** The list of addresses in the zone. */
    addresses?: Address[];
    /** The description of the zone. */
    description?: string;
    /** The list of excluded addresses in the zone. */
    excluded?: Address[];
    /** The UUID that is used to correlate and track transactions. If you omit this field, the service generates and
     *  sends a transaction ID in the response.
     *  **Note:** To help with debugging, we strongly recommend that you generate and supply a `Transaction-Id` with
     *  each request.
     */
    transactionId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listZones` operation. */
  export interface ListZonesParams {
    /** The ID of the managing account. */
    accountId: string;
    /** The UUID that is used to correlate and track transactions. If you omit this field, the service generates and
     *  sends a transaction ID in the response.
     *  **Note:** To help with debugging, we strongly recommend that you generate and supply a `Transaction-Id` with
     *  each request.
     */
    transactionId?: string;
    /** The name of the zone. */
    name?: string;
    /** Sorts results by using a valid sort field. To learn more, see
     *  [Sorting](https://cloud.ibm.com/docs/api-handbook?topic=api-handbook-sorting).
     */
    sort?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getZone` operation. */
  export interface GetZoneParams {
    /** The ID of a zone. */
    zoneId: string;
    /** The UUID that is used to correlate and track transactions. If you omit this field, the service generates and
     *  sends a transaction ID in the response.
     *  **Note:** To help with debugging, we strongly recommend that you generate and supply a `Transaction-Id` with
     *  each request.
     */
    transactionId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `replaceZone` operation. */
  export interface ReplaceZoneParams {
    /** The ID of a zone. */
    zoneId: string;
    /** The current revision of the resource being updated. This can be found in the Create/Get/Update resource
     *  response ETag header.
     */
    ifMatch: string;
    /** The name of the zone. */
    name?: string;
    /** The id of the account owning this zone. */
    accountId?: string;
    /** The list of addresses in the zone. */
    addresses?: Address[];
    /** The description of the zone. */
    description?: string;
    /** The list of excluded addresses in the zone. */
    excluded?: Address[];
    /** The UUID that is used to correlate and track transactions. If you omit this field, the service generates and
     *  sends a transaction ID in the response.
     *  **Note:** To help with debugging, we strongly recommend that you generate and supply a `Transaction-Id` with
     *  each request.
     */
    transactionId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deleteZone` operation. */
  export interface DeleteZoneParams {
    /** The ID of a zone. */
    zoneId: string;
    /** The UUID that is used to correlate and track transactions. If you omit this field, the service generates and
     *  sends a transaction ID in the response.
     *  **Note:** To help with debugging, we strongly recommend that you generate and supply a `Transaction-Id` with
     *  each request.
     */
    transactionId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listAvailableServicerefTargets` operation. */
  export interface ListAvailableServicerefTargetsParams {
    /** Specifies the types of services to retrieve. */
    type?: ListAvailableServicerefTargetsConstants.Type | string;
    headers?: OutgoingHttpHeaders;
  }

  /** Constants for the `listAvailableServicerefTargets` operation. */
  export namespace ListAvailableServicerefTargetsConstants {
    /** Specifies the types of services to retrieve. */
    export enum Type {
      ALL = 'all',
      PLATFORM_SERVICE = 'platform_service',
    }
  }

  /** Parameters for the `createRule` operation. */
  export interface CreateRuleParams {
    /** The contexts this rule applies to. */
    contexts?: RuleContext[];
    /** The resources this rule apply to. */
    resources?: Resource[];
    /** The description of the rule. */
    description?: string;
    /** The UUID that is used to correlate and track transactions. If you omit this field, the service generates and
     *  sends a transaction ID in the response.
     *  **Note:** To help with debugging, we strongly recommend that you generate and supply a `Transaction-Id` with
     *  each request.
     */
    transactionId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listRules` operation. */
  export interface ListRulesParams {
    /** The ID of the managing account. */
    accountId: string;
    /** The UUID that is used to correlate and track transactions. If you omit this field, the service generates and
     *  sends a transaction ID in the response.
     *  **Note:** To help with debugging, we strongly recommend that you generate and supply a `Transaction-Id` with
     *  each request.
     */
    transactionId?: string;
    /** The `region` resource attribute. */
    region?: string;
    /** The `resource` resource attribute. */
    resource?: string;
    /** The `resourceType` resource attribute. */
    resourceType?: string;
    /** The `serviceInstance` resource attribute. */
    serviceInstance?: string;
    /** The `serviceName` resource attribute. */
    serviceName?: string;
    /** The rule's `serviceType` resource attribute. */
    serviceType?: string;
    /** The globally unique ID of the zone. */
    zoneId?: string;
    /** Sorts results by using a valid sort field. To learn more, see
     *  [Sorting](https://cloud.ibm.com/docs/api-handbook?topic=api-handbook-sorting).
     */
    sort?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getRule` operation. */
  export interface GetRuleParams {
    /** The ID of a rule. */
    ruleId: string;
    /** The UUID that is used to correlate and track transactions. If you omit this field, the service generates and
     *  sends a transaction ID in the response.
     *  **Note:** To help with debugging, we strongly recommend that you generate and supply a `Transaction-Id` with
     *  each request.
     */
    transactionId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `replaceRule` operation. */
  export interface ReplaceRuleParams {
    /** The ID of a rule. */
    ruleId: string;
    /** The current revision of the resource being updated. This can be found in the Create/Get/Update resource
     *  response ETag header.
     */
    ifMatch: string;
    /** The contexts this rule applies to. */
    contexts?: RuleContext[];
    /** The resources this rule apply to. */
    resources?: Resource[];
    /** The description of the rule. */
    description?: string;
    /** The UUID that is used to correlate and track transactions. If you omit this field, the service generates and
     *  sends a transaction ID in the response.
     *  **Note:** To help with debugging, we strongly recommend that you generate and supply a `Transaction-Id` with
     *  each request.
     */
    transactionId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deleteRule` operation. */
  export interface DeleteRuleParams {
    /** The ID of a rule. */
    ruleId: string;
    /** The UUID that is used to correlate and track transactions. If you omit this field, the service generates and
     *  sends a transaction ID in the response.
     *  **Note:** To help with debugging, we strongly recommend that you generate and supply a `Transaction-Id` with
     *  each request.
     */
    transactionId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getAccountSettings` operation. */
  export interface GetAccountSettingsParams {
    /** The ID of the account the settings are for. */
    accountId: string;
    /** The UUID that is used to correlate and track transactions. If you omit this field, the service generates and
     *  sends a transaction ID in the response.
     *  **Note:** To help with debugging, we strongly recommend that you generate and supply a `Transaction-Id` with
     *  each request.
     */
    transactionId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /*************************
   * model interfaces
   ************************/

  /** A zone address. */
  export interface Address {
  }

  /** An output account settings. */
  export interface OutAccountSettings {
    /** The globally unique ID of the account settings. */
    id: string;
    /** The account settings CRN. */
    crn: string;
    /** the max number of rules allowed for the account. */
    rule_count_limit: number;
    /** the max number of zones allowed for the account. */
    zone_count_limit: number;
    /** the current number of rules used by the account. */
    current_rule_count: number;
    /** the current number of zones used by the account. */
    current_zone_count: number;
    /** The href link to the resource. */
    href: string;
    /** The time the resource was created. */
    created_at: string;
    /** IAM ID of the user or service which created the resource. */
    created_by_id: string;
    /** The last time the resource was modified. */
    last_modified_at: string;
    /** IAM ID of the user or service which modified the resource. */
    last_modified_by_id: string;
  }

  /** An output rule. */
  export interface OutRule {
    /** The globally unique ID of the rule. */
    id: string;
    /** The rule CRN. */
    crn: string;
    /** The description of the rule. */
    description?: string;
    /** The contexts this rule applies to. */
    contexts: RuleContext[];
    /** The resources this rule apply to. */
    resources: Resource[];
    /** The href link to the resource. */
    href: string;
    /** The time the resource was created. */
    created_at: string;
    /** IAM ID of the user or service which created the resource. */
    created_by_id: string;
    /** The last time the resource was modified. */
    last_modified_at: string;
    /** IAM ID of the user or service which modified the resource. */
    last_modified_by_id: string;
  }

  /** The response object of the ListRules operation. */
  export interface OutRulePage {
    /** The number of returned results. */
    count: number;
    /** The returned rules. */
    rules: OutRule[];
  }

  /** An output zone. */
  export interface OutZone {
    /** The globally unique ID of the zone. */
    id: string;
    /** The zone CRN. */
    crn: string;
    /** The name of the zone. */
    name: string;
    /** The id of the account owning this zone. */
    account_id: string;
    /** The description of the zone. */
    description?: string;
    /** The list of addresses in the zone. */
    addresses: Address[];
    /** The list of excluded addresses in the zone. */
    excluded?: Address[];
    /** The href link to the resource. */
    href: string;
    /** The time the resource was created. */
    created_at: string;
    /** IAM ID of the user or service which created the resource. */
    created_by_id: string;
    /** The last time the resource was modified. */
    last_modified_at: string;
    /** IAM ID of the user or service which modified the resource. */
    last_modified_by_id: string;
  }

  /** The response object of the ListZones operation. */
  export interface OutZonePage {
    /** The number of returned results. */
    count: number;
    /** The returned zones. */
    zones: OutZoneSummary[];
  }

  /** An output zone summary. */
  export interface OutZoneSummary {
    /** The globally unique ID of the zone. */
    id: string;
    /** The zone CRN. */
    crn: string;
    /** The name of the zone. */
    name: string;
    /** The description of the zone. */
    description?: string;
    /** A preview of addresses in the zone (3 addresses maximum). */
    addresses_preview: Address[];
    /** The number of addresses in the zone. */
    address_count: number;
    /** The number of excluded addresses in the zone. */
    excluded_count: number;
    /** The href link to the resource. */
    href: string;
    /** The time the resource was created. */
    created_at: string;
    /** IAM ID of the user or service which created the resource. */
    created_by_id: string;
    /** The last time the resource was modified. */
    last_modified_at: string;
    /** IAM ID of the user or service which modified the resource. */
    last_modified_by_id: string;
  }

  /** An rule resource. */
  export interface Resource {
    /** The resource attributes. */
    attributes: ResourceAttribute[];
    /** The optional resource tags. */
    tags?: ResourceTagAttribute[];
  }

  /** A rule resource attribute. */
  export interface ResourceAttribute {
    /** The attribute name. */
    name: string;
    /** The attribute value. */
    value: string;
    /** The attribute operator. */
    operator?: string;
  }

  /** A rule resource tag attribute. */
  export interface ResourceTagAttribute {
    /** The tag attribute name. */
    name: string;
    /** The tag attribute value. */
    value: string;
    /** The attribute operator. */
    operator?: string;
  }

  /** A rule context. */
  export interface RuleContext {
    /** The attributes. */
    attributes: RuleContextAttribute[];
  }

  /** An rule context attribute. */
  export interface RuleContextAttribute {
    /** The attribute name. */
    name: string;
    /** The attribute value. */
    value: string;
  }

  /** Summary information about a service reference target. */
  export interface ServiceRefTarget {
    /** The name of the service. */
    service_name?: string;
    /** The type of the service. */
    service_type?: string;
  }

  /** A page of service reference targets. */
  export interface ServiceRefTargetPage {
    /** The list of service reference targets. */
    targets?: ServiceRefTarget[];
  }

  /** A service reference value. */
  export interface ServiceRefValue {
    /** The id of the account owning the service. */
    account_id?: string;
    /** The service type. */
    service_type?: string;
    /** The service name. */
    service_name?: string;
    /** The service instance. */
    service_instance?: string;
  }

  /** A single IP address. */
  export interface AddressIPAddress extends Address {
    /** The type of address. */
    type: string;
    /** The IP address. */
    value: string;
  }

  /** An IP address range. */
  export interface AddressIPAddressRange extends Address {
    /** The type of address. */
    type: string;
    /** The ip range in <first-ip>-<last-ip> format. */
    value: string;
  }

  /** A service reference. */
  export interface AddressServiceRef extends Address {
    /** The type of address. */
    type: string;
    /** A service reference value. */
    value: ServiceRefValue;
  }

  /** A subnet in CIDR format. */
  export interface AddressSubnet extends Address {
    /** The type of address. */
    type: string;
    /** The subnet in CIDR format. */
    value: string;
  }

  /** A single VPC address. */
  export interface AddressVPC extends Address {
    /** The type of address. */
    type: string;
    /** The VPC CRN. */
    value: string;
  }

}

export = ContextBasedRestrictionsV1;
