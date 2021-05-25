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
 * IBM OpenAPI SDK Code Generator Version: 99-SNAPSHOT-629bbb97-20201207-171303
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
 * Billing units for IBM Cloud enterprises
 */

class EnterpriseBillingUnitsV1 extends BaseService {
  static DEFAULT_SERVICE_URL: string = 'https://billing.cloud.ibm.com';

  static DEFAULT_SERVICE_NAME: string = 'enterprise_billing_units';

  /*************************
   * Factory method
   ************************/

  /**
   * Constructs an instance of EnterpriseBillingUnitsV1 with passed in options and external configuration.
   *
   * @param {UserOptions} [options] - The parameters to send to the service.
   * @param {string} [options.serviceName] - The name of the service to configure
   * @param {Authenticator} [options.authenticator] - The Authenticator object used to authenticate requests to the service
   * @param {string} [options.serviceUrl] - The URL for the service
   * @returns {EnterpriseBillingUnitsV1}
   */

  public static newInstance(options: UserOptions): EnterpriseBillingUnitsV1 {
    options = options || {};

    if (!options.serviceName) {
      options.serviceName = this.DEFAULT_SERVICE_NAME;
    }
    if (!options.authenticator) {
      options.authenticator = getAuthenticatorFromEnvironment(options.serviceName);
    }
    const service = new EnterpriseBillingUnitsV1(options);
    service.configureService(options.serviceName);
    if (options.serviceUrl) {
      service.setServiceUrl(options.serviceUrl);
    }
    return service;
  }

  /**
   * Construct a EnterpriseBillingUnitsV1 object.
   *
   * @param {Object} options - Options for the service.
   * @param {string} [options.serviceUrl] - The base url to use when contacting the service. The base url may differ between IBM Cloud regions.
   * @param {OutgoingHttpHeaders} [options.headers] - Default headers that shall be included with every request to the service.
   * @param {Authenticator} options.authenticator - The Authenticator object used to authenticate requests to the service
   * @constructor
   * @returns {EnterpriseBillingUnitsV1}
   */
  constructor(options: UserOptions) {
    options = options || {};

    super(options);
    if (options.serviceUrl) {
      this.setServiceUrl(options.serviceUrl);
    } else {
      this.setServiceUrl(EnterpriseBillingUnitsV1.DEFAULT_SERVICE_URL);
    }
  }

  /*************************
   * billingUnits
   ************************/

  /**
   * Get billing unit by ID.
   *
   * Return the billing unit information if it exists.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.billingUnitId - The ID of the requested billing unit.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<EnterpriseBillingUnitsV1.Response<EnterpriseBillingUnitsV1.BillingUnit>>}
   */
  public getBillingUnit(
    params: EnterpriseBillingUnitsV1.GetBillingUnitParams
  ): Promise<EnterpriseBillingUnitsV1.Response<EnterpriseBillingUnitsV1.BillingUnit>> {
    const _params = { ...params };
    const requiredParams = ['billingUnitId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'billing_unit_id': _params.billingUnitId,
    };

    const sdkHeaders = getSdkHeaders(
      EnterpriseBillingUnitsV1.DEFAULT_SERVICE_NAME,
      'v1',
      'getBillingUnit'
    );

    const parameters = {
      options: {
        url: '/v1/billing-units/{billing_unit_id}',
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
   * List billing units.
   *
   * Return matching billing unit information if any exists. Omits internal properties and enterprise account ID from
   * the billing unit.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {string} [params.accountId] - The enterprise account ID.
   * @param {string} [params.enterpriseId] - The enterprise ID.
   * @param {string} [params.accountGroupId] - The account group ID.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<EnterpriseBillingUnitsV1.Response<EnterpriseBillingUnitsV1.BillingUnitsList>>}
   */
  public listBillingUnits(
    params?: EnterpriseBillingUnitsV1.ListBillingUnitsParams
  ): Promise<EnterpriseBillingUnitsV1.Response<EnterpriseBillingUnitsV1.BillingUnitsList>> {
    const _params = { ...params };

    const query = {
      'account_id': _params.accountId,
      'enterprise_id': _params.enterpriseId,
      'account_group_id': _params.accountGroupId,
    };

    const sdkHeaders = getSdkHeaders(
      EnterpriseBillingUnitsV1.DEFAULT_SERVICE_NAME,
      'v1',
      'listBillingUnits'
    );

    const parameters = {
      options: {
        url: '/v1/billing-units',
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

  /*************************
   * billingOptions
   ************************/

  /**
   * List billing options.
   *
   * Return matching billing options if any exist. Show subscriptions and promotional offers that are available to a
   * billing unit.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.billingUnitId - The billing unit ID.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<EnterpriseBillingUnitsV1.Response<EnterpriseBillingUnitsV1.BillingOptionsList>>}
   */
  public listBillingOptions(
    params: EnterpriseBillingUnitsV1.ListBillingOptionsParams
  ): Promise<EnterpriseBillingUnitsV1.Response<EnterpriseBillingUnitsV1.BillingOptionsList>> {
    const _params = { ...params };
    const requiredParams = ['billingUnitId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'billing_unit_id': _params.billingUnitId,
    };

    const sdkHeaders = getSdkHeaders(
      EnterpriseBillingUnitsV1.DEFAULT_SERVICE_NAME,
      'v1',
      'listBillingOptions'
    );

    const parameters = {
      options: {
        url: '/v1/billing-options',
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

  /*************************
   * creditPools
   ************************/

  /**
   * Get credit pools.
   *
   * Get credit pools for a billing unit. Credit pools can be either platform or support credit pools. The platform
   * credit pool contains credit from platform subscriptions and promotional offers. The support credit pool contains
   * credit from support subscriptions.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.billingUnitId - The ID of the billing unit.
   * @param {string} [params.date] - The date in the format of YYYY-MM.
   * @param {string} [params.type] - Filters the credit pool by type, either `PLATFORM` or `SUPPORT`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<EnterpriseBillingUnitsV1.Response<EnterpriseBillingUnitsV1.CreditPoolsList>>}
   */
  public getCreditPools(
    params: EnterpriseBillingUnitsV1.GetCreditPoolsParams
  ): Promise<EnterpriseBillingUnitsV1.Response<EnterpriseBillingUnitsV1.CreditPoolsList>> {
    const _params = { ...params };
    const requiredParams = ['billingUnitId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'billing_unit_id': _params.billingUnitId,
      'date': _params.date,
      'type': _params.type,
    };

    const sdkHeaders = getSdkHeaders(
      EnterpriseBillingUnitsV1.DEFAULT_SERVICE_NAME,
      'v1',
      'getCreditPools'
    );

    const parameters = {
      options: {
        url: '/v1/credit-pools',
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
}

/*************************
 * interfaces
 ************************/

namespace EnterpriseBillingUnitsV1 {
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

  /** Parameters for the `getBillingUnit` operation. */
  export interface GetBillingUnitParams {
    /** The ID of the requested billing unit. */
    billingUnitId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listBillingUnits` operation. */
  export interface ListBillingUnitsParams {
    /** The enterprise account ID. */
    accountId?: string;
    /** The enterprise ID. */
    enterpriseId?: string;
    /** The account group ID. */
    accountGroupId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listBillingOptions` operation. */
  export interface ListBillingOptionsParams {
    /** The billing unit ID. */
    billingUnitId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getCreditPools` operation. */
  export interface GetCreditPoolsParams {
    /** The ID of the billing unit. */
    billingUnitId: string;
    /** The date in the format of YYYY-MM. */
    date?: string;
    /** Filters the credit pool by type, either `PLATFORM` or `SUPPORT`. */
    type?: string;
    headers?: OutgoingHttpHeaders;
  }

  /*************************
   * model interfaces
   ************************/

  /** Information about a billing option. */
  export interface BillingOption {
    /** The ID of the billing option. */
    id?: string;
    /** The ID of the billing unit that's associated with the billing option. */
    billing_unit_id?: string;
    /** The start date of billing option. */
    start_date?: string;
    /** The end date of billing option. */
    end_date?: string;
    /** The state of the billing option. The valid values include `ACTIVE, `SUSPENDED`, and `CANCELED`. */
    state?: string;
    /** The type of billing option. The valid values are `SUBSCRIPTION` and `OFFER`. */
    type?: string;
    /** The category of the billing option. The valid values are `PLATFORM`, `SERVICE`, and `SUPPORT`. */
    category?: string;
    /** The payment method for support. */
    payment_instrument?: JsonObject;
    /** The duration of the billing options in months. */
    duration_in_months?: number;
    /** The line item ID for support. */
    line_item_id?: number;
    /** The support billing system. */
    billing_system?: JsonObject;
    /** The renewal code for support. This code denotes whether the subscription automatically renews, is assessed
     *  monthly, and so on.
     */
    renewal_mode_code?: string;
    /** The date when the billing option was updated. */
    updated_at?: string;
  }

  /** A search result containing zero or more billing options. */
  export interface BillingOptionsList {
    /** A count of the billing units that were found by the query. */
    rows_count?: number;
    /** Bookmark URL to query for next batch of billing units. This returns `null` if no additional pages are
     *  required.
     */
    next_url?: string;
    /** A list of billing units found. */
    resources?: BillingOption[];
  }

  /** Information about a billing unit. */
  export interface BillingUnit {
    /** The ID of the billing unit, which is a globally unique identifier (GUID). */
    id?: string;
    /** The Cloud Resource Name (CRN) of the billing unit, scoped to the enterprise account ID. */
    crn?: string;
    /** The name of the billing unit. */
    name?: string;
    /** The ID of the enterprise to which the billing unit is associated. */
    enterprise_id?: string;
    /** The currency code for the billing unit. */
    currency_code?: string;
    /** The country code for the billing unit. */
    country_code?: string;
    /** A flag that indicates whether this billing unit is the primary billing mechanism for the enterprise. */
    master?: boolean;
    /** The creation date of the billing unit. */
    created_at?: string;
  }

  /** A search result contining zero or more billing units. */
  export interface BillingUnitsList {
    /** A count of the billing units that were found by the query. */
    rows_count?: number;
    /** Bookmark URL to query for next batch of billing units. This returns `null` if no additional pages are
     *  required.
     */
    next_url?: string;
    /** A list of billing units found. */
    resources?: BillingUnit[];
  }

  /** The credit pool for a billing unit. */
  export interface CreditPool {
    /** The type of credit, either `PLATFORM` or `SUPPORT`. */
    type?: string;
    /** The currency code of the associated billing unit. */
    currency_code?: string;
    /** The ID of the billing unit that's associated with the credit pool. This value is a globally unique
     *  identifier (GUID).
     */
    billing_unit_id?: string;
    /** A list of active subscription terms available within a credit pool. */
    term_credits?: TermCredits[];
    /** Overage that was generated on the credit pool. */
    overage?: CreditPoolOverage;
  }

  /** Overage that was generated on the credit pool. */
  export interface CreditPoolOverage {
    /** The number of credits used as overage. */
    cost?: number;
    /** A list of resources that generated overage. */
    resources?: JsonObject[];
  }

  /** A search result containing zero or more credit pools. */
  export interface CreditPoolsList {
    /** The number of credit pools that were found by the query. */
    rows_count?: number;
    /** A bookmark URL to the query for the next batch of billing units. Use a value of `null` if no additional
     *  pages are required.
     */
    next_url?: string;
    /** A list of credit pools found by the query. */
    resources?: CreditPool[];
  }

  /** The subscription term that is active in the current month. */
  export interface TermCredits {
    /** The ID of the billing option from which the subscription term is derived. */
    billing_option_id?: string;
    /** The category of the credit pool. The valid values are `PLATFORM`, `OFFER`, or `SERVICE` for platform credit
     *  and `SUPPORT` for support credit.
     */
    category?: string;
    /** The start date of the term in ISO format. */
    start_date?: string;
    /** The end date of the term in ISO format. */
    end_date?: string;
    /** The total credit available in this term. */
    total_credits?: number;
    /** The balance of available credit at the start of the current month. */
    starting_balance?: number;
    /** The amount of credit used during the current month. */
    used_credits?: number;
    /** The balance of remaining credit in the subscription term. */
    current_balance?: number;
    /** A list of resources that used credit during the month. */
    resources?: JsonObject[];
  }
}

export = EnterpriseBillingUnitsV1;
