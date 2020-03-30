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
 * Usage reports for IBM Cloud accounts
 */

class UsageReportsV4 extends BaseService {

  static DEFAULT_SERVICE_URL: string = 'https://metering-reporting.ng.bluemix.net';
  static DEFAULT_SERVICE_NAME: string = 'usage_reports';

  /*************************
   * Factory method
   ************************/

  /**
   * Constructs an instance of UsageReportsV4 with passed in options and external configuration.
   *
   * @param {UserOptions} [options] - The parameters to send to the service.
   * @param {string} [options.serviceName] - The name of the service to configure
   * @param {Authenticator} [options.authenticator] - The Authenticator object used to authenticate requests to the service
   * @param {string} [options.serviceUrl] - The URL for the service
   * @returns {UsageReportsV4}
   */

  public static newInstance(options: UserOptions): UsageReportsV4 {
    options = options || {};

    if (!options.serviceName) {
      options.serviceName = this.DEFAULT_SERVICE_NAME;
    }
    if (!options.authenticator) {
      options.authenticator = getAuthenticatorFromEnvironment(options.serviceName);
    }
    const service = new UsageReportsV4(options);
    service.configureService(options.serviceName);
    if (options.serviceUrl) {
      service.setServiceUrl(options.serviceUrl);
    }
    return service;
  }


  /**
   * Construct a UsageReportsV4 object.
   *
   * @param {Object} options - Options for the service.
   * @param {string} [options.serviceUrl] - The base url to use when contacting the service (e.g. 'https://gateway.watsonplatform.net'). The base url may differ between IBM Cloud regions.
   * @param {OutgoingHttpHeaders} [options.headers] - Default headers that shall be included with every request to the service.
   * @param {Authenticator} options.authenticator - The Authenticator object used to authenticate requests to the service
   * @constructor
   * @returns {UsageReportsV4}
   */
  constructor(options: UserOptions) {
    options = options || {};

    super(options);
    if (options.serviceUrl) {
      this.setServiceUrl(options.serviceUrl);
    } else {
      this.setServiceUrl(UsageReportsV4.DEFAULT_SERVICE_URL);
    }
  }

  /*************************
   * usageReports
   ************************/

  /**
   * Get account billing summary.
   *
   * Returns the billing summary for the account for a given month. Users with the Administrator role on the Billing
   * service can access this report.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - Account ID for which the summary is requested.
   * @param {string} params.billingmonth - Billing month for which the summary is requested in `yyyy-mm` format.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<UsageReportsV4.Response<UsageReportsV4.AccountSummary>>}
   */
  public getAccountSummary(params: UsageReportsV4.GetAccountSummaryParams): Promise<UsageReportsV4.Response<UsageReportsV4.AccountSummary>> {
    const _params = extend({}, params);
    const requiredParams = ['accountId', 'billingmonth'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'account_id': _params.accountId,
        'billingmonth': _params.billingmonth
      };

      const sdkHeaders = getSdkHeaders(UsageReportsV4.DEFAULT_SERVICE_NAME, 'v4', 'getAccountSummary');

      const parameters = {
        options: {
          url: '/v4/accounts/{account_id}/summary/{billingmonth}',
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
   * Get account usage.
   *
   * Returns aggregated usage for all of the resources and plans in an account in a given month. Users with the
   * Administrator role on the Billing service can access this report.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - Account ID for which the usage is requested.
   * @param {string} params.billingmonth - Month for which the usage is requested.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<UsageReportsV4.Response<UsageReportsV4.AccountUsage>>}
   */
  public getAccountUsage(params: UsageReportsV4.GetAccountUsageParams): Promise<UsageReportsV4.Response<UsageReportsV4.AccountUsage>> {
    const _params = extend({}, params);
    const requiredParams = ['accountId', 'billingmonth'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'account_id': _params.accountId,
        'billingmonth': _params.billingmonth
      };

      const sdkHeaders = getSdkHeaders(UsageReportsV4.DEFAULT_SERVICE_NAME, 'v4', 'getAccountUsage');

      const parameters = {
        options: {
          url: '/v4/accounts/{account_id}/usage/{billingmonth}',
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
   * Get resource group usage.
   *
   * Returns aggregated usage for all of the resources and plans in a resource group in a given month. Users with the
   * Administrator role on the Billing service can access this report.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - Account ID containing the resource group.
   * @param {string} params.resourceGroupId - Resource group for which the usage is requested.
   * @param {string} params.billingmonth - Month for which the usage is requested.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<UsageReportsV4.Response<UsageReportsV4.ResourceGroupUsage>>}
   */
  public getResourceGroupUsage(params: UsageReportsV4.GetResourceGroupUsageParams): Promise<UsageReportsV4.Response<UsageReportsV4.ResourceGroupUsage>> {
    const _params = extend({}, params);
    const requiredParams = ['accountId', 'resourceGroupId', 'billingmonth'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'account_id': _params.accountId,
        'resource_group_id': _params.resourceGroupId,
        'billingmonth': _params.billingmonth
      };

      const sdkHeaders = getSdkHeaders(UsageReportsV4.DEFAULT_SERVICE_NAME, 'v4', 'getResourceGroupUsage');

      const parameters = {
        options: {
          url: '/v4/accounts/{account_id}/resource_groups/{resource_group_id}/usage/{billingmonth}',
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
   * Get Cloud Foundry org usage.
   *
   * Returns aggregated usage for all the resources and plans in a Cloud Foundry organization in a given month. Users
   * with the Administrator role on the Billing service or the Billing Manager role on the Cloud Foundry org can access
   * this report.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - ID of the account containing the organization.
   * @param {string} params.organizationId - ID of the organization.
   * @param {string} params.billingmonth - Month for which the usage is requested.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<UsageReportsV4.Response<UsageReportsV4.OrganizationUsage>>}
   */
  public getOrganizationUsage(params: UsageReportsV4.GetOrganizationUsageParams): Promise<UsageReportsV4.Response<UsageReportsV4.OrganizationUsage>> {
    const _params = extend({}, params);
    const requiredParams = ['accountId', 'organizationId', 'billingmonth'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'account_id': _params.accountId,
        'organization_id': _params.organizationId,
        'billingmonth': _params.billingmonth
      };

      const sdkHeaders = getSdkHeaders(UsageReportsV4.DEFAULT_SERVICE_NAME, 'v4', 'getOrganizationUsage');

      const parameters = {
        options: {
          url: '/v4/accounts/{account_id}/organizations/{organization_id}/usage/{billingmonth}',
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
   * Get resource instance usage in an account.
   *
   * Returns instance-level usage for resources in an account. Filter the results with query parameters. Users with the
   * Administrator role on the Billing service can access this report.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - Account ID to which the resource instances belong to.
   * @param {string} params.billingmonth - Month for which the usage is requested.
   * @param {number} [params.limit] - Number of usage records returned. The default value is 10. Maximum value is 20.
   * @param {string} [params.start] - The offset from which the records must be fetched. Offset information is included
   * in the response.
   * @param {string} [params.resourceGroupId] - Filter by resource group.
   * @param {string} [params.organizationId] - Filter by organization_id.
   * @param {string} [params.resourceInstanceId] - Filter by resource instance id.
   * @param {string} [params.resourceId] - Filter by resource_id.
   * @param {string} [params.planId] - Filter by plan_id.
   * @param {string} [params.region] - Region in which the resource instance is provisioned.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<UsageReportsV4.Response<UsageReportsV4.InstancesUsage>>}
   */
  public getAccountInstancesUsage(params: UsageReportsV4.GetAccountInstancesUsageParams): Promise<UsageReportsV4.Response<UsageReportsV4.InstancesUsage>> {
    const _params = extend({}, params);
    const requiredParams = ['accountId', 'billingmonth'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        '_limit': _params.limit,
        '_start': _params.start,
        'resource_group_id': _params.resourceGroupId,
        'organization_id': _params.organizationId,
        'resource_instance_id': _params.resourceInstanceId,
        'resource_id': _params.resourceId,
        'plan_id': _params.planId,
        'region': _params.region
      };

      const path = {
        'account_id': _params.accountId,
        'billingmonth': _params.billingmonth
      };

      const sdkHeaders = getSdkHeaders(UsageReportsV4.DEFAULT_SERVICE_NAME, 'v4', 'getAccountInstancesUsage');

      const parameters = {
        options: {
          url: '/v4/accounts/{account_id}/resource_instances/usage/{billingmonth}',
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
   * Get resource instance usage in a resource group.
   *
   * Returns instance-level usage for resources in a resource group. Filter the results with query parameters. Users
   * with the Administrator role on the  Billing service can access this report.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - ID of the account in which the resource group is present.
   * @param {string} params.resourceGroupId - ID of the resource group.
   * @param {string} params.billingmonth - Month for which the usage is requested.
   * @param {number} [params.limit] - Number of usage records returned. The default value is 10. Maximum value is 20.
   * @param {string} [params.start] - The offset from which the records must be fetched. Offset information is included
   * in the response.
   * @param {string} [params.resourceInstanceId] - Filter by resource instance id.
   * @param {string} [params.resourceId] - Filter by resource_id.
   * @param {string} [params.planId] - Filter by plan_id.
   * @param {string} [params.region] - Region in which the resource instance is provisioned.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<UsageReportsV4.Response<UsageReportsV4.InstancesUsage>>}
   */
  public getResourceGroupInstancesUsage(params: UsageReportsV4.GetResourceGroupInstancesUsageParams): Promise<UsageReportsV4.Response<UsageReportsV4.InstancesUsage>> {
    const _params = extend({}, params);
    const requiredParams = ['accountId', 'resourceGroupId', 'billingmonth'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        '_limit': _params.limit,
        '_start': _params.start,
        'resource_instance_id': _params.resourceInstanceId,
        'resource_id': _params.resourceId,
        'plan_id': _params.planId,
        'region': _params.region
      };

      const path = {
        'account_id': _params.accountId,
        'resource_group_id': _params.resourceGroupId,
        'billingmonth': _params.billingmonth
      };

      const sdkHeaders = getSdkHeaders(UsageReportsV4.DEFAULT_SERVICE_NAME, 'v4', 'getResourceGroupInstancesUsage');

      const parameters = {
        options: {
          url: '/v4/accounts/{account_id}/resource_groups/{resource_group_id}/resource_instances/usage/{billingmonth}',
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
   * Get resource instance usage in a Cloud Foundry org.
   *
   * Returns instance-level usage for resources in a Cloud Foundry organization. Filter the results with query
   * parameters. Users with the Administrator role on the Billing service or the Billing Manager role on the Cloud
   * Foundry org can access this report.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - ID of the account under which the organization is present.
   * @param {string} params.organizationId - ID of the organization.
   * @param {string} params.billingmonth - Month for which the usage is requested.
   * @param {number} [params.limit] - Number of usage records returned. The default value is 10. Maximum value is 20.
   * @param {string} [params.start] - The offset from which the records must be fetched. Offset information is included
   * in the response.
   * @param {string} [params.resourceInstanceId] - Filter by resource instance id.
   * @param {string} [params.resourceId] - Filter by resource_id.
   * @param {string} [params.planId] - Filter by plan_id.
   * @param {string} [params.region] - Region in which the resource instance is provisioned.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<UsageReportsV4.Response<UsageReportsV4.InstancesUsage>>}
   */
  public getOrganizationInstancesUsage(params: UsageReportsV4.GetOrganizationInstancesUsageParams): Promise<UsageReportsV4.Response<UsageReportsV4.InstancesUsage>> {
    const _params = extend({}, params);
    const requiredParams = ['accountId', 'organizationId', 'billingmonth'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        '_limit': _params.limit,
        '_start': _params.start,
        'resource_instance_id': _params.resourceInstanceId,
        'resource_id': _params.resourceId,
        'plan_id': _params.planId,
        'region': _params.region
      };

      const path = {
        'account_id': _params.accountId,
        'organization_id': _params.organizationId,
        'billingmonth': _params.billingmonth
      };

      const sdkHeaders = getSdkHeaders(UsageReportsV4.DEFAULT_SERVICE_NAME, 'v4', 'getOrganizationInstancesUsage');

      const parameters = {
        options: {
          url: '/v4/accounts/{account_id}/organizations/{organization_id}/resource_instances/usage/{billingmonth}',
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

}

/*************************
 * interfaces
 ************************/

namespace UsageReportsV4 {

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

  /** Parameters for the `getAccountSummary` operation. */
  export interface GetAccountSummaryParams {
    /** Account ID for which the summary is requested. */
    accountId: string;
    /** Billing month for which the summary is requested in `yyyy-mm` format. */
    billingmonth: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getAccountUsage` operation. */
  export interface GetAccountUsageParams {
    /** Account ID for which the usage is requested. */
    accountId: string;
    /** Month for which the usage is requested. */
    billingmonth: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getResourceGroupUsage` operation. */
  export interface GetResourceGroupUsageParams {
    /** Account ID containing the resource group. */
    accountId: string;
    /** Resource group for which the usage is requested. */
    resourceGroupId: string;
    /** Month for which the usage is requested. */
    billingmonth: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getOrganizationUsage` operation. */
  export interface GetOrganizationUsageParams {
    /** ID of the account containing the organization. */
    accountId: string;
    /** ID of the organization. */
    organizationId: string;
    /** Month for which the usage is requested. */
    billingmonth: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getAccountInstancesUsage` operation. */
  export interface GetAccountInstancesUsageParams {
    /** Account ID to which the resource instances belong to. */
    accountId: string;
    /** Month for which the usage is requested. */
    billingmonth: string;
    /** Number of usage records returned. The default value is 10. Maximum value is 20. */
    limit?: number;
    /** The offset from which the records must be fetched. Offset information is included in the response. */
    start?: string;
    /** Filter by resource group. */
    resourceGroupId?: string;
    /** Filter by organization_id. */
    organizationId?: string;
    /** Filter by resource instance id. */
    resourceInstanceId?: string;
    /** Filter by resource_id. */
    resourceId?: string;
    /** Filter by plan_id. */
    planId?: string;
    /** Region in which the resource instance is provisioned. */
    region?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getResourceGroupInstancesUsage` operation. */
  export interface GetResourceGroupInstancesUsageParams {
    /** ID of the account in which the resource group is present. */
    accountId: string;
    /** ID of the resource group. */
    resourceGroupId: string;
    /** Month for which the usage is requested. */
    billingmonth: string;
    /** Number of usage records returned. The default value is 10. Maximum value is 20. */
    limit?: number;
    /** The offset from which the records must be fetched. Offset information is included in the response. */
    start?: string;
    /** Filter by resource instance id. */
    resourceInstanceId?: string;
    /** Filter by resource_id. */
    resourceId?: string;
    /** Filter by plan_id. */
    planId?: string;
    /** Region in which the resource instance is provisioned. */
    region?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getOrganizationInstancesUsage` operation. */
  export interface GetOrganizationInstancesUsageParams {
    /** ID of the account under which the organization is present. */
    accountId: string;
    /** ID of the organization. */
    organizationId: string;
    /** Month for which the usage is requested. */
    billingmonth: string;
    /** Number of usage records returned. The default value is 10. Maximum value is 20. */
    limit?: number;
    /** The offset from which the records must be fetched. Offset information is included in the response. */
    start?: string;
    /** Filter by resource instance id. */
    resourceInstanceId?: string;
    /** Filter by resource_id. */
    resourceId?: string;
    /** Filter by plan_id. */
    planId?: string;
    /** Region in which the resource instance is provisioned. */
    region?: string;
    headers?: OutgoingHttpHeaders;
  }

  /*************************
   * model interfaces
   ************************/

  /** A summary of resource usage. */
  export interface AccountResources {
    /** Billable charges for all cloud resources used in the account. */
    billable_cost: number;
    /** Non-billable charges for all cloud resources used in the account. */
    non_billable_cost: number;
  }

  /** Summary for the account for a given month. */
  export interface AccountSummary {
    /** The ID of the account. */
    account_id: string;
    /** Month in which usages were incurred in `yyyy-mm` format. */
    billing_month: string;
    /** Country. */
    billing_country_code: string;
    /** Currency in which the account is billed. */
    billing_currency_code: string;
    /** A summary of resource usage. */
    resources: AccountResources;
    /** List of offers applicable for the account for the month. */
    offers: Offer[];
    /** Subscription information for an account. */
    subscription: SubscriptionInfo;
    /** Account support information. */
    support: SupportInfo[];
  }

  /** Aggregated usage and charges for all the plans in the account. */
  export interface AccountUsage {
    /** ID of the account. */
    account_id: string;
    /** The country to use for pricing. */
    pricing_country: string;
    /** The currency for the cost fields in the resources, plans, and metrics. */
    currency_code: string;
    /** The month of the reported usage and charges in `yyyy-mm` format. */
    month: string;
    /** All the resource used in the account. */
    resources: Resource[];
  }

  /** Credits. */
  export interface Credits {
    /** Total credit available for the term. */
    total?: number;
    /** Credit available in the offer at the beginning of the month. */
    starting_balance: number;
    /** Credit used in this month. */
    used: number;
    /** Remaining credit in the offer. */
    balance: number;
  }

  /** Aggregated usage and charges for an instance. */
  export interface InstanceUsage {
    /** ID of the account. */
    account_id: string;
    /** The ID of the resource instance. */
    resource_instance_id: string;
    /** The ID of the resource. */
    resource_id: string;
    /** ID of the resource group. */
    resource_group_id?: string;
    /** The ID of the organization. */
    organization_id?: string;
    /** The ID of the space. */
    space?: string;
    /** The ID of the consumer. */
    consumer_id?: string;
    /** The region in which the instance was provisioned. */
    region?: string;
    /** The pricing region in which the usage submitted was rated. */
    pricing_region?: string;
    /** The country to use for pricing. */
    pricing_country: string;
    /** The currency for the cost fields in the resources, plans, and metrics. */
    currency_code: string;
    /** Whether the cost is charged to the account. */
    billable: boolean;
    /** The ID of the plan with which the instance was provisioned and rated. */
    plan_id: string;
    /** The month of the reported usage and charges in `yyyy-mm` format. */
    month: string;
    /** All of the resources used in the account. */
    usage: Metric[];
  }

  /** List of instnace usage reports. */
  export interface InstancesUsage {
    /** The maximum number of reports in the response. */
    limit?: number;
    /** The number of reports in the response. */
    count?: number;
    /** Link to the first page of the search query. */
    first?: PageLink;
    /** Link to the next page of the search query. */
    next?: PageLink;
    /** The list of instance usage reports. */
    resources?: InstanceUsage[];
  }

  /** Metric for reporting usage. */
  export interface Metric {
    /** Name of the metric. */
    metric: string;
    /** Aggregated value for the metric. */
    quantity: number;
    /** Quantity that is used for calculating charges. */
    rateable_quantity?: number;
    /** Cost incurred by the metric. */
    cost: number;
    /** The price with which cost was calculated. */
    price?: JsonObject[];
    /** Unit qualifying the quantity. */
    unit?: string;
    /** When set to `true`, the cost is for informational purpose and is not included while calculating the plan
     *  charges.
     */
    non_chargeable?: boolean;
  }

  /** Offer. */
  export interface Offer {
    /** ID of the offer. */
    offer_id: string;
    /** Total credits before applying the offer. */
    credits_total: number;
    /** Template with which the offer was generated. */
    offer_template: string;
    /** Date from which the offer is valid. */
    valid_from: string;
    /** Date until which the offer is valid. */
    expires_on: string;
    /** Credits. */
    credits: Credits;
  }

  /** Aggregated usage and charges for all the plans in the org. */
  export interface OrganizationUsage {
    /** ID of the account. */
    account_id: string;
    /** ID of the organization. */
    organization_id: string;
    /** The country to use for pricing. */
    pricing_country: string;
    /** The currency for the cost fields in the resources, plans, and metrics. */
    currency_code: string;
    /** The month of the reported usage and charges in `yyyy-mm` format. */
    month: string;
    /** All the resource used in the account. */
    resources: Resource[];
  }

  /** Link to a page of a paginated list. */
  export interface PageLink {
    /** The URL for the page. */
    href?: string;
    /** The value of the `_start` query parameter to fetch the page. */
    offset?: string;
  }

  /** Aggregated values for the plan. */
  export interface Plan {
    /** The ID of the plan. */
    plan_id: string;
    /** The pricing region for the plan. */
    pricing_region?: string;
    /** Whether the plan charges are billed to the customer. */
    billable: boolean;
    /** Total cost incurred by the plan. */
    cost: number;
    /** All of the metrics in the plan. */
    usage: Metric[];
  }

  /** Container for all the plans in the resource. */
  export interface Resource {
    /** ID of the resource. */
    resource_id: string;
    /** The billable charges for the account. */
    billable_cost: number;
    /** The non billable charges for the account. */
    non_billable_cost: number;
    /** All the plans in the resource. */
    plans: Plan[];
  }

  /** Aggregated usage and charges for all the plans in the resource group. */
  export interface ResourceGroupUsage {
    /** ID of the account. */
    account_id: string;
    /** ID of the resource group. */
    resource_group_id: string;
    /** The country to use for pricing. */
    pricing_country: string;
    /** The currency for the cost fields in the resources, plans, and metrics. */
    currency_code: string;
    /** The month of the reported usage and charges in `yyyy-mm` format. */
    month: string;
    /** All of the resources used in the account. */
    resources: Resource[];
  }

  /** Subscription information. */
  export interface Subscription {
    /** ID of the subscription. */
    subscription_id: string;
    /** Charge agreement number of the subsciption. */
    charge_agreement_number: string;
    /** Type of the subscription. */
    type: string;
    /** Credit available in the subscription for the month. */
    subscription_amount: number;
    /** Date from which the subscription was active. */
    start: string;
    /** The date until which the subscription is active. This date does not apply to Pay-As-You-Go accounts. */
    end?: string;
    /** Total credit available in the subscription. */
    credits_total: number;
    /** Separate periods of time within the overall subscription term. Longer subscriptions might be divided into
     *  multiple terms.
     */
    terms: Terms[];
  }

  /** Subscription information for an account. */
  export interface SubscriptionInfo {
    /** Charges for usage that exceeds the available credit from subscriptions or offers. */
    overage?: number;
    /** List of subscriptions that applied to the month. */
    subscriptions?: Subscription[];
  }

  /** Account support information. */
  export interface SupportInfo {
    /** Monthly support cost. */
    cost: number;
    /** Type of support. */
    type: string;
    /** Additional support cost for the month. */
    overage: number;
  }

  /** Terms. */
  export interface Terms {
    /** Start date of the term. */
    start: string;
    /** End date of the term. */
    end: string;
    /** Credits. */
    credits: Credits;
  }

}

export = UsageReportsV4;
