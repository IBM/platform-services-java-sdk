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
import {
  Authenticator,
  BaseService,
  getAuthenticatorFromEnvironment,
  getMissingParams,
  UserOptions,
} from 'ibm-cloud-sdk-core';
import { getSdkHeaders } from '../lib/common';

/**
 * Usage reports for IBM Cloud accounts
 */

class UsageReportsV4 extends BaseService {
  static DEFAULT_SERVICE_URL: string = 'https://billing.cloud.ibm.com';

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
   * @param {string} [options.serviceUrl] - The base url to use when contacting the service. The base url may differ between IBM Cloud regions.
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
   * accountOperations
   ************************/

  /**
   * Get account summary.
   *
   * Returns the summary for the account for a given month. Account billing managers are authorized to access this
   * report.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - Account ID for which the usage report is requested.
   * @param {string} params.billingmonth - The billing month for which the usage report is requested.  Format is
   * yyyy-mm.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<UsageReportsV4.Response<UsageReportsV4.AccountSummary>>}
   */
  public getAccountSummary(
    params: UsageReportsV4.GetAccountSummaryParams
  ): Promise<UsageReportsV4.Response<UsageReportsV4.AccountSummary>> {
    const _params = { ...params };
    const requiredParams = ['accountId', 'billingmonth'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'account_id': _params.accountId,
      'billingmonth': _params.billingmonth,
    };

    const sdkHeaders = getSdkHeaders(
      UsageReportsV4.DEFAULT_SERVICE_NAME,
      'v4',
      'getAccountSummary'
    );

    const parameters = {
      options: {
        url: '/v4/accounts/{account_id}/summary/{billingmonth}',
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
   * Get account usage.
   *
   * Usage for all the resources and plans in an account for a given month. Account billing managers are authorized to
   * access this report.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - Account ID for which the usage report is requested.
   * @param {string} params.billingmonth - The billing month for which the usage report is requested.  Format is
   * yyyy-mm.
   * @param {boolean} [params.names] - Include the name of every resource, plan, resource instance, organization, and
   * resource group.
   * @param {string} [params.acceptLanguage] - Prioritize the names returned in the order of the specified languages.
   * Language will default to English.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<UsageReportsV4.Response<UsageReportsV4.AccountUsage>>}
   */
  public getAccountUsage(
    params: UsageReportsV4.GetAccountUsageParams
  ): Promise<UsageReportsV4.Response<UsageReportsV4.AccountUsage>> {
    const _params = { ...params };
    const requiredParams = ['accountId', 'billingmonth'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      '_names': _params.names,
    };

    const path = {
      'account_id': _params.accountId,
      'billingmonth': _params.billingmonth,
    };

    const sdkHeaders = getSdkHeaders(UsageReportsV4.DEFAULT_SERVICE_NAME, 'v4', 'getAccountUsage');

    const parameters = {
      options: {
        url: '/v4/accounts/{account_id}/usage/{billingmonth}',
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
            'Accept-Language': _params.acceptLanguage,
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /*************************
   * resourceOperations
   ************************/

  /**
   * Get resource group usage.
   *
   * Usage for all the resources and plans in a resource group in a given month. Account billing managers or resource
   * group billing managers are authorized to access this report.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - Account ID for which the usage report is requested.
   * @param {string} params.resourceGroupId - Resource group for which the usage report is requested.
   * @param {string} params.billingmonth - The billing month for which the usage report is requested.  Format is
   * yyyy-mm.
   * @param {boolean} [params.names] - Include the name of every resource, plan, resource instance, organization, and
   * resource group.
   * @param {string} [params.acceptLanguage] - Prioritize the names returned in the order of the specified languages.
   * Language will default to English.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<UsageReportsV4.Response<UsageReportsV4.ResourceGroupUsage>>}
   */
  public getResourceGroupUsage(
    params: UsageReportsV4.GetResourceGroupUsageParams
  ): Promise<UsageReportsV4.Response<UsageReportsV4.ResourceGroupUsage>> {
    const _params = { ...params };
    const requiredParams = ['accountId', 'resourceGroupId', 'billingmonth'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      '_names': _params.names,
    };

    const path = {
      'account_id': _params.accountId,
      'resource_group_id': _params.resourceGroupId,
      'billingmonth': _params.billingmonth,
    };

    const sdkHeaders = getSdkHeaders(
      UsageReportsV4.DEFAULT_SERVICE_NAME,
      'v4',
      'getResourceGroupUsage'
    );

    const parameters = {
      options: {
        url: '/v4/accounts/{account_id}/resource_groups/{resource_group_id}/usage/{billingmonth}',
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
            'Accept-Language': _params.acceptLanguage,
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Get resource instance usage in an account.
   *
   * Query for resource instance usage in an account. Filter the results with query parameters. Account billing
   * administrator is authorized to access this report.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - Account ID for which the usage report is requested.
   * @param {string} params.billingmonth - The billing month for which the usage report is requested.  Format is
   * yyyy-mm.
   * @param {boolean} [params.names] - Include the name of every resource, plan, resource instance, organization, and
   * resource group.
   * @param {string} [params.acceptLanguage] - Prioritize the names returned in the order of the specified languages.
   * Language will default to English.
   * @param {number} [params.limit] - Number of usage records returned. The default value is 10. Maximum value is 20.
   * @param {string} [params.start] - The offset from which the records must be fetched. Offset information is included
   * in the response.
   * @param {string} [params.resourceGroupId] - Filter by resource group.
   * @param {string} [params.organizationId] - Filter by organization_id.
   * @param {string} [params.resourceInstanceId] - Filter by resource instance_id.
   * @param {string} [params.resourceId] - Filter by resource_id.
   * @param {string} [params.planId] - Filter by plan_id.
   * @param {string} [params.region] - Region in which the resource instance is provisioned.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<UsageReportsV4.Response<UsageReportsV4.InstancesUsage>>}
   */
  public getResourceUsageAccount(
    params: UsageReportsV4.GetResourceUsageAccountParams
  ): Promise<UsageReportsV4.Response<UsageReportsV4.InstancesUsage>> {
    const _params = { ...params };
    const requiredParams = ['accountId', 'billingmonth'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      '_names': _params.names,
      '_limit': _params.limit,
      '_start': _params.start,
      'resource_group_id': _params.resourceGroupId,
      'organization_id': _params.organizationId,
      'resource_instance_id': _params.resourceInstanceId,
      'resource_id': _params.resourceId,
      'plan_id': _params.planId,
      'region': _params.region,
    };

    const path = {
      'account_id': _params.accountId,
      'billingmonth': _params.billingmonth,
    };

    const sdkHeaders = getSdkHeaders(
      UsageReportsV4.DEFAULT_SERVICE_NAME,
      'v4',
      'getResourceUsageAccount'
    );

    const parameters = {
      options: {
        url: '/v4/accounts/{account_id}/resource_instances/usage/{billingmonth}',
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
            'Accept-Language': _params.acceptLanguage,
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Get resource instance usage in a resource group.
   *
   * Query for resource instance usage in a resource group. Filter the results with query parameters. Account billing
   * administrator and resource group billing administrators are authorized to access this report.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - Account ID for which the usage report is requested.
   * @param {string} params.resourceGroupId - Resource group for which the usage report is requested.
   * @param {string} params.billingmonth - The billing month for which the usage report is requested.  Format is
   * yyyy-mm.
   * @param {boolean} [params.names] - Include the name of every resource, plan, resource instance, organization, and
   * resource group.
   * @param {string} [params.acceptLanguage] - Prioritize the names returned in the order of the specified languages.
   * Language will default to English.
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
  public getResourceUsageResourceGroup(
    params: UsageReportsV4.GetResourceUsageResourceGroupParams
  ): Promise<UsageReportsV4.Response<UsageReportsV4.InstancesUsage>> {
    const _params = { ...params };
    const requiredParams = ['accountId', 'resourceGroupId', 'billingmonth'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      '_names': _params.names,
      '_limit': _params.limit,
      '_start': _params.start,
      'resource_instance_id': _params.resourceInstanceId,
      'resource_id': _params.resourceId,
      'plan_id': _params.planId,
      'region': _params.region,
    };

    const path = {
      'account_id': _params.accountId,
      'resource_group_id': _params.resourceGroupId,
      'billingmonth': _params.billingmonth,
    };

    const sdkHeaders = getSdkHeaders(
      UsageReportsV4.DEFAULT_SERVICE_NAME,
      'v4',
      'getResourceUsageResourceGroup'
    );

    const parameters = {
      options: {
        url: '/v4/accounts/{account_id}/resource_groups/{resource_group_id}/resource_instances/usage/{billingmonth}',
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
            'Accept-Language': _params.acceptLanguage,
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Get resource instance usage in an organization.
   *
   * Query for resource instance usage in an organization. Filter the results with query parameters. Account billing
   * administrator and organization billing administrators are authorized to access this report.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - Account ID for which the usage report is requested.
   * @param {string} params.organizationId - ID of the organization.
   * @param {string} params.billingmonth - The billing month for which the usage report is requested.  Format is
   * yyyy-mm.
   * @param {boolean} [params.names] - Include the name of every resource, plan, resource instance, organization, and
   * resource group.
   * @param {string} [params.acceptLanguage] - Prioritize the names returned in the order of the specified languages.
   * Language will default to English.
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
  public getResourceUsageOrg(
    params: UsageReportsV4.GetResourceUsageOrgParams
  ): Promise<UsageReportsV4.Response<UsageReportsV4.InstancesUsage>> {
    const _params = { ...params };
    const requiredParams = ['accountId', 'organizationId', 'billingmonth'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      '_names': _params.names,
      '_limit': _params.limit,
      '_start': _params.start,
      'resource_instance_id': _params.resourceInstanceId,
      'resource_id': _params.resourceId,
      'plan_id': _params.planId,
      'region': _params.region,
    };

    const path = {
      'account_id': _params.accountId,
      'organization_id': _params.organizationId,
      'billingmonth': _params.billingmonth,
    };

    const sdkHeaders = getSdkHeaders(
      UsageReportsV4.DEFAULT_SERVICE_NAME,
      'v4',
      'getResourceUsageOrg'
    );

    const parameters = {
      options: {
        url: '/v4/accounts/{account_id}/organizations/{organization_id}/resource_instances/usage/{billingmonth}',
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
            'Accept-Language': _params.acceptLanguage,
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /*************************
   * organizationOperations
   ************************/

  /**
   * Get organization usage.
   *
   * Usage for all the resources and plans in an organization in a given month. Account billing managers or organization
   * billing managers are authorized to access this report.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - Account ID for which the usage report is requested.
   * @param {string} params.organizationId - ID of the organization.
   * @param {string} params.billingmonth - The billing month for which the usage report is requested.  Format is
   * yyyy-mm.
   * @param {boolean} [params.names] - Include the name of every resource, plan, resource instance, organization, and
   * resource group.
   * @param {string} [params.acceptLanguage] - Prioritize the names returned in the order of the specified languages.
   * Language will default to English.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<UsageReportsV4.Response<UsageReportsV4.OrgUsage>>}
   */
  public getOrgUsage(
    params: UsageReportsV4.GetOrgUsageParams
  ): Promise<UsageReportsV4.Response<UsageReportsV4.OrgUsage>> {
    const _params = { ...params };
    const requiredParams = ['accountId', 'organizationId', 'billingmonth'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      '_names': _params.names,
    };

    const path = {
      'account_id': _params.accountId,
      'organization_id': _params.organizationId,
      'billingmonth': _params.billingmonth,
    };

    const sdkHeaders = getSdkHeaders(UsageReportsV4.DEFAULT_SERVICE_NAME, 'v4', 'getOrgUsage');

    const parameters = {
      options: {
        url: '/v4/accounts/{account_id}/organizations/{organization_id}/usage/{billingmonth}',
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
            'Accept-Language': _params.acceptLanguage,
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

namespace UsageReportsV4 {
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

  /** Parameters for the `getAccountSummary` operation. */
  export interface GetAccountSummaryParams {
    /** Account ID for which the usage report is requested. */
    accountId: string;
    /** The billing month for which the usage report is requested.  Format is yyyy-mm. */
    billingmonth: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getAccountUsage` operation. */
  export interface GetAccountUsageParams {
    /** Account ID for which the usage report is requested. */
    accountId: string;
    /** The billing month for which the usage report is requested.  Format is yyyy-mm. */
    billingmonth: string;
    /** Include the name of every resource, plan, resource instance, organization, and resource group. */
    names?: boolean;
    /** Prioritize the names returned in the order of the specified languages. Language will default to English. */
    acceptLanguage?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getResourceGroupUsage` operation. */
  export interface GetResourceGroupUsageParams {
    /** Account ID for which the usage report is requested. */
    accountId: string;
    /** Resource group for which the usage report is requested. */
    resourceGroupId: string;
    /** The billing month for which the usage report is requested.  Format is yyyy-mm. */
    billingmonth: string;
    /** Include the name of every resource, plan, resource instance, organization, and resource group. */
    names?: boolean;
    /** Prioritize the names returned in the order of the specified languages. Language will default to English. */
    acceptLanguage?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getResourceUsageAccount` operation. */
  export interface GetResourceUsageAccountParams {
    /** Account ID for which the usage report is requested. */
    accountId: string;
    /** The billing month for which the usage report is requested.  Format is yyyy-mm. */
    billingmonth: string;
    /** Include the name of every resource, plan, resource instance, organization, and resource group. */
    names?: boolean;
    /** Prioritize the names returned in the order of the specified languages. Language will default to English. */
    acceptLanguage?: string;
    /** Number of usage records returned. The default value is 10. Maximum value is 20. */
    limit?: number;
    /** The offset from which the records must be fetched. Offset information is included in the response. */
    start?: string;
    /** Filter by resource group. */
    resourceGroupId?: string;
    /** Filter by organization_id. */
    organizationId?: string;
    /** Filter by resource instance_id. */
    resourceInstanceId?: string;
    /** Filter by resource_id. */
    resourceId?: string;
    /** Filter by plan_id. */
    planId?: string;
    /** Region in which the resource instance is provisioned. */
    region?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getResourceUsageResourceGroup` operation. */
  export interface GetResourceUsageResourceGroupParams {
    /** Account ID for which the usage report is requested. */
    accountId: string;
    /** Resource group for which the usage report is requested. */
    resourceGroupId: string;
    /** The billing month for which the usage report is requested.  Format is yyyy-mm. */
    billingmonth: string;
    /** Include the name of every resource, plan, resource instance, organization, and resource group. */
    names?: boolean;
    /** Prioritize the names returned in the order of the specified languages. Language will default to English. */
    acceptLanguage?: string;
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

  /** Parameters for the `getResourceUsageOrg` operation. */
  export interface GetResourceUsageOrgParams {
    /** Account ID for which the usage report is requested. */
    accountId: string;
    /** ID of the organization. */
    organizationId: string;
    /** The billing month for which the usage report is requested.  Format is yyyy-mm. */
    billingmonth: string;
    /** Include the name of every resource, plan, resource instance, organization, and resource group. */
    names?: boolean;
    /** Prioritize the names returned in the order of the specified languages. Language will default to English. */
    acceptLanguage?: string;
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

  /** Parameters for the `getOrgUsage` operation. */
  export interface GetOrgUsageParams {
    /** Account ID for which the usage report is requested. */
    accountId: string;
    /** ID of the organization. */
    organizationId: string;
    /** The billing month for which the usage report is requested.  Format is yyyy-mm. */
    billingmonth: string;
    /** Include the name of every resource, plan, resource instance, organization, and resource group. */
    names?: boolean;
    /** Prioritize the names returned in the order of the specified languages. Language will default to English. */
    acceptLanguage?: string;
    headers?: OutgoingHttpHeaders;
  }

  /*************************
   * model interfaces
   ************************/

  /** A summary of charges and credits for an account. */
  export interface AccountSummary {
    /** The ID of the account. */
    account_id: string;
    /** The month in which usages were incurred. Represented in yyyy-mm format. */
    billing_month: string;
    /** Country. */
    billing_country_code: string;
    /** The currency in which the account is billed. */
    billing_currency_code: string;
    /** Charges related to cloud resources. */
    resources: ResourcesSummary;
    /** The list of offers applicable for the account for the month. */
    offers: Offer[];
    /** Support-related charges. */
    support: SupportSummary[];
    /** A summary of charges and credits related to a subscription. */
    subscription: SubscriptionSummary;
  }

  /** The aggregated usage and charges for all the plans in the account. */
  export interface AccountUsage {
    /** The ID of the account. */
    account_id: string;
    /** The target country pricing that should be used. */
    pricing_country: string;
    /** The currency for the cost fields in the resources, plans and metrics. */
    currency_code: string;
    /** The month. */
    month: string;
    /** All the resource used in the account. */
    resources: Resource[];
  }

  /** Information about a discount that is associated with a metric. */
  export interface Discount {
    /** The reference ID of the discount. */
    ref: string;
    /** The name of the discount indicating category. */
    name?: string;
    /** The name of the discount. */
    display_name?: string;
    /** The discount percentage. */
    discount: number;
  }

  /** The aggregated usage and charges for an instance. */
  export interface InstanceUsage {
    /** The ID of the account. */
    account_id: string;
    /** The ID of the resource instance. */
    resource_instance_id: string;
    /** The name of the resource instance. */
    resource_instance_name?: string;
    /** The ID of the resource. */
    resource_id: string;
    /** The name of the resource. */
    resource_name?: string;
    /** The ID of the resource group. */
    resource_group_id?: string;
    /** The name of the resource group. */
    resource_group_name?: string;
    /** The ID of the organization. */
    organization_id?: string;
    /** The name of the organization. */
    organization_name?: string;
    /** The ID of the space. */
    space_id?: string;
    /** The name of the space. */
    space_name?: string;
    /** The ID of the consumer. */
    consumer_id?: string;
    /** The region where instance was provisioned. */
    region?: string;
    /** The pricing region where the usage that was submitted was rated. */
    pricing_region?: string;
    /** The target country pricing that should be used. */
    pricing_country: string;
    /** The currency for the cost fields in the resources, plans and metrics. */
    currency_code: string;
    /** Is the cost charged to the account. */
    billable: boolean;
    /** The ID of the plan where the instance was provisioned and rated. */
    plan_id: string;
    /** The name of the plan where the instance was provisioned and rated. */
    plan_name?: string;
    /** The month. */
    month: string;
    /** All the resource used in the account. */
    usage: Metric[];
  }

  /** The link to the first page of the search query. */
  export interface InstancesUsageFirst {
    /** A link to a page of query results. */
    href?: string;
  }

  /** The link to the next page of the search query. */
  export interface InstancesUsageNext {
    /** A link to a page of query results. */
    href?: string;
    /** The value of the `_start` query parameter to fetch the next page. */
    offset?: string;
  }

  /** The list of instance usage reports. */
  export interface InstancesUsage {
    /** The max number of reports in the response. */
    limit?: number;
    /** The number of reports in the response. */
    count?: number;
    /** The link to the first page of the search query. */
    first?: InstancesUsageFirst;
    /** The link to the next page of the search query. */
    next?: InstancesUsageNext;
    /** The list of instance usage reports. */
    resources?: InstanceUsage[];
  }

  /** Information about a metric. */
  export interface Metric {
    /** The ID of the metric. */
    metric: string;
    /** The name of the metric. */
    metric_name?: string;
    /** The aggregated value for the metric. */
    quantity: number;
    /** The quantity that is used for calculating charges. */
    rateable_quantity?: number;
    /** The cost incurred by the metric. */
    cost: number;
    /** Pre-discounted cost incurred by the metric. */
    rated_cost: number;
    /** The price with which the cost was calculated. */
    price?: any[];
    /** The unit that qualifies the quantity. */
    unit?: string;
    /** The name of the unit. */
    unit_name?: string;
    /** When set to `true`, the cost is for informational purpose and is not included while calculating the plan
     *  charges.
     */
    non_chargeable?: boolean;
    /** All the discounts applicable to the metric. */
    discounts: Discount[];
  }

  /** Information about an individual offer. */
  export interface Offer {
    /** The ID of the offer. */
    offer_id: string;
    /** The total credits before applying the offer. */
    credits_total: number;
    /** The template with which the offer was generated. */
    offer_template: string;
    /** The date from which the offer is valid. */
    valid_from: string;
    /** The date until the offer is valid. */
    expires_on: string;
    /** Credit information related to an offer. */
    credits: OfferCredits;
  }

  /** Credit information related to an offer. */
  export interface OfferCredits {
    /** The available credits in the offer at the beginning of the month. */
    starting_balance: number;
    /** The credits used in this month. */
    used: number;
    /** The remaining credits in the offer. */
    balance: number;
  }

  /** The aggregated usage and charges for all the plans in the org. */
  export interface OrgUsage {
    /** The ID of the account. */
    account_id: string;
    /** The ID of the organization. */
    organization_id: string;
    /** The name of the organization. */
    organization_name?: string;
    /** The target country pricing that should be used. */
    pricing_country: string;
    /** The currency for the cost fields in the resources, plans and metrics. */
    currency_code: string;
    /** The month. */
    month: string;
    /** All the resource used in the account. */
    resources: Resource[];
  }

  /** The aggregated values for the plan. */
  export interface Plan {
    /** The ID of the plan. */
    plan_id: string;
    /** The name of the plan. */
    plan_name?: string;
    /** The pricing region for the plan. */
    pricing_region?: string;
    /** Indicates if the plan charges are billed to the customer. */
    billable: boolean;
    /** The total cost incurred by the plan. */
    cost: number;
    /** Total pre-discounted cost incurred by the plan. */
    rated_cost: number;
    /** All the metrics in the plan. */
    usage: Metric[];
    /** All the discounts applicable to the plan. */
    discounts: Discount[];
  }

  /** The container for all the plans in the resource. */
  export interface Resource {
    /** The ID of the resource. */
    resource_id: string;
    /** The name of the resource. */
    resource_name?: string;
    /** The billable charges for the account. */
    billable_cost: number;
    /** The pre-discounted billable charges for the account. */
    billable_rated_cost: number;
    /** The non-billable charges for the account. */
    non_billable_cost: number;
    /** The pre-discounted non-billable charges for the account. */
    non_billable_rated_cost: number;
    /** All the plans in the resource. */
    plans: Plan[];
    /** All the discounts applicable to the resource. */
    discounts: Discount[];
  }

  /** The aggregated usage and charges for all the plans in the resource group. */
  export interface ResourceGroupUsage {
    /** The ID of the account. */
    account_id: string;
    /** The ID of the resource group. */
    resource_group_id: string;
    /** The name of the resource group. */
    resource_group_name?: string;
    /** The target country pricing that should be used. */
    pricing_country: string;
    /** The currency for the cost fields in the resources, plans and metrics. */
    currency_code: string;
    /** The month. */
    month: string;
    /** All the resource used in the account. */
    resources: Resource[];
  }

  /** Charges related to cloud resources. */
  export interface ResourcesSummary {
    /** The billable charges for all cloud resources used in the account. */
    billable_cost: number;
    /** Non-billable charges for all cloud resources used in the account. */
    non_billable_cost: number;
  }

  /** Subscription. */
  export interface Subscription {
    /** The ID of the subscription. */
    subscription_id: string;
    /** The charge agreement number of the subsciption. */
    charge_agreement_number: string;
    /** Type of the subscription. */
    type: string;
    /** The credits available in the subscription for the month. */
    subscription_amount: number;
    /** The date from which the subscription was active. */
    start: string;
    /** The date until which the subscription is active. End time is unavailable for PayGO accounts. */
    end?: string;
    /** The total credits available in the subscription. */
    credits_total: number;
    /** The terms through which the subscription is split into. */
    terms: SubscriptionTerm[];
  }

  /** A summary of charges and credits related to a subscription. */
  export interface SubscriptionSummary {
    /** The charges after exhausting subscription credits and offers credits. */
    overage?: number;
    /** The list of subscriptions applicable for the month. */
    subscriptions?: Subscription[];
  }

  /** SubscriptionTerm. */
  export interface SubscriptionTerm {
    /** The start date of the term. */
    start: string;
    /** The end date of the term. */
    end: string;
    /** Information about credits related to a subscription. */
    credits: SubscriptionTermCredits;
  }

  /** Information about credits related to a subscription. */
  export interface SubscriptionTermCredits {
    /** The total credits available for the term. */
    total: number;
    /** The unused credits in the term at the beginning of the month. */
    starting_balance: number;
    /** The credits used in this month. */
    used: number;
    /** The remaining credits in this term. */
    balance: number;
  }

  /** SupportSummary. */
  export interface SupportSummary {
    /** The monthly support cost. */
    cost: number;
    /** The type of support. */
    type: string;
    /** Additional support cost for the month. */
    overage: number;
  }
}

export = UsageReportsV4;
