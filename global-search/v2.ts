/**
 * (C) Copyright IBM Corp. 2023.
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
 * IBM OpenAPI SDK Code Generator Version: 3.63.0-5dae26c1-20230111-193039
 */

import * as extend from 'extend';
import { IncomingHttpHeaders, OutgoingHttpHeaders } from 'http';
import {
  Authenticator,
  BaseService,
  getAuthenticatorFromEnvironment,
  validateParams,
  UserOptions,
} from 'ibm-cloud-sdk-core';
import { getSdkHeaders } from '../lib/common';
import { getNewLogger, SDKLogger } from 'ibm-cloud-sdk-core';

/**
 * Search for resources with the global and shared resource properties repository that is integrated in the IBM Cloud
 * platform. The search repository stores and searches cloud resources attributes, which categorize or classify
 * resources. A resource is a physical or logical component that can be created or reserved for an application or
 * service instance. They are owned by resource providers, such as Cloud Foundry, IBM Kubernetes Service, or resource
 * controller in IBM Cloud. Resources are uniquely identified by a Cloud Resource Name (CRN)  or by an IMS ID. The
 * properties of a resource include tags and system properties. Both properties are defined in an IBM Cloud billing
 * account, and span across many regions.
 *
 * API Version: 2.0.1
 */

class GlobalSearchV2 extends BaseService {
  static _logger: SDKLogger = getNewLogger('GlobalSearchV2');

  static DEFAULT_SERVICE_URL: string = 'https://api.global-search-tagging.cloud.ibm.com';

  static DEFAULT_SERVICE_NAME: string = 'global_search';

  /*************************
   * Factory method
   ************************/

  /**
   * Constructs an instance of GlobalSearchV2 with passed in options and external configuration.
   *
   * @param {UserOptions} [options] - The parameters to send to the service.
   * @param {string} [options.serviceName] - The name of the service to configure
   * @param {Authenticator} [options.authenticator] - The Authenticator object used to authenticate requests to the service
   * @param {string} [options.serviceUrl] - The URL for the service
   * @returns {GlobalSearchV2}
   */

  public static newInstance(options: UserOptions): GlobalSearchV2 {
    options = options || {};

    if (!options.serviceName) {
      options.serviceName = this.DEFAULT_SERVICE_NAME;
    }
    if (!options.authenticator) {
      options.authenticator = getAuthenticatorFromEnvironment(options.serviceName);
    }
    const service = new GlobalSearchV2(options);
    service.configureService(options.serviceName);
    if (options.serviceUrl) {
      service.setServiceUrl(options.serviceUrl);
    }
    return service;
  }

  /**
   * Construct a GlobalSearchV2 object.
   *
   * @param {Object} options - Options for the service.
   * @param {string} [options.serviceUrl] - The base url to use when contacting the service. The base url may differ between IBM Cloud regions.
   * @param {OutgoingHttpHeaders} [options.headers] - Default headers that shall be included with every request to the service.
   * @param {Authenticator} options.authenticator - The Authenticator object used to authenticate requests to the service
   * @constructor
   * @returns {GlobalSearchV2}
   */
  constructor(options: UserOptions) {
    options = options || {};

    super(options);
    if (options.serviceUrl) {
      this.setServiceUrl(options.serviceUrl);
    } else {
      this.setServiceUrl(GlobalSearchV2.DEFAULT_SERVICE_URL);
    }
  }

  /*************************
   * search
   ************************/

  /**
   * Find instances of resources (v3).
   *
   * Find Cloud Foundry resources, IAM-enabled resources, or storage and network resources that run on classic
   * infrastructure in a specific account ID. You can apply query strings if necessary.
   *
   * To filter results, you can insert a string by using the Lucene syntax and the query string is parsed into a series
   * of terms and operators. A term can be a single word or a phrase, in which case the search is performed for all the
   * words, in the same order. To filter for a specific value regardless of the property that contains it, type the
   * search term without specifying a field. Only resources that belong to the account ID and that are accessible by the
   * client are returned.
   *
   * You must use `/v3/resources/search` when you need to fetch more than `10000` resource items. On the first call, the
   * operation returns a live cursor on the data that you must use on all the subsequent calls to get the next batch of
   * results until you get the empty result set. By default, the fields that are returned for every resource are "crn",
   * "name", "family", "type", and "account_id". You can specify the subset of the fields you want in your request.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {string} [params.query] - The Lucene-formatted query string. Default to '*' if not set.
   * @param {string[]} [params.fields] - The list of the fields returned by the search. By default, the returned fields
   * are the `account_id`, `name`, `type`, `family`, and `crn`. For all queries, `crn` is always returned.
   * @param {string} [params.searchCursor] - An opaque cursor that is returned on each call and that must be set on the
   * subsequent call to get the next batch of items. If the search returns no items, then the search_cursor is not
   * present in the response.
   * @param {string} [params.transactionId] - An alphanumeric string that can be used to trace a request across
   * services. If not specified, it automatically generated with the prefix "gst-".
   * @param {string} [params.accountId] - The account ID to filter resources.
   * @param {string} [params.boundary] - The boundary where the search performs. This parameter must be set only for the
   * cross-account searches.
   * @param {number} [params.limit] - The maximum number of hits to return. Defaults to 10.
   * @param {number} [params.timeout] - A search timeout in milliseconds, bounding the search request to run within the
   * specified time value and bail with the hits accumulated up to that point when expired. Defaults to the system
   * defined timeout.
   * @param {string[]} [params.sort] - Comma separated properties names that are used for sorting.
   * @param {string} [params.isDeleted] - Determines if deleted documents should be included in result set or not.
   * Possible values are false (default), true or any. If false, only existing documents are returned; if true, only
   * deleted documents are returned; If any, both existing and deleted documents are returned. (_for administrators
   * only_).
   * @param {string} [params.isReclaimed] - Determines if reclaimed documents should be included in result set or not.
   * Possible values are false (default), true or any. If false, only not reclaimed documents are returned; if true,
   * only reclaimed documents are returned; If any, both reclaimed and not reclaimed documents are returned.
   * @param {string} [params.isPublic] - Determines if public resources should be included in result set or not.
   * Possible values are false (default), true or any. If false, do not search public resources; if true, search only
   * public resources; If any, search also public resources.
   * @param {string} [params.impersonateUser] - The user on whose behalf the search must be performed. Only a GhoST
   * admin can impersonate a user, so be sure you set a GhoST admin IAM token in the Authorization header if you set
   * this parameter. (_for administrators only_).
   * @param {string} [params.canTag] - Determines if the result set must return the resources that the user can tag or
   * the resources that the user can view (only a GhoST admin can use this parameter). If false (default), only
   * resources user can view are returned; if true, only resources that user has permissions for tagging are returned
   * (_for administrators only_).
   * @param {string} [params.isHidden] - Determines if the result set must return only the visible resources or not. If
   * false (default), only visible resources are returned; if true, only hidden resources are returned; if any, all
   * resources are returned.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<GlobalSearchV2.Response<GlobalSearchV2.ScanResult>>}
   */
  public search(
    params?: GlobalSearchV2.SearchParams
  ): Promise<GlobalSearchV2.Response<GlobalSearchV2.ScanResult>> {
    const _params = { ...params };
    const _requiredParams = [];
    const _validParams = ['query', 'fields', 'searchCursor', 'transactionId', 'accountId', 'boundary', 'limit', 'timeout', 'sort', 'isDeleted', 'isReclaimed', 'isPublic', 'impersonateUser', 'canTag', 'isHidden', 'headers'];
    const _validationErrors = validateParams(_params, _requiredParams, _validParams);
    if (_validationErrors) {
      return Promise.reject(_validationErrors);
    }

    const body = {
      'query': _params.query,
      'fields': _params.fields,
      'search_cursor': _params.searchCursor,
    };

    const query = {
      'account_id': _params.accountId,
      'boundary': _params.boundary,
      'limit': _params.limit,
      'timeout': _params.timeout,
      'sort': _params.sort,
      'is_deleted': _params.isDeleted,
      'is_reclaimed': _params.isReclaimed,
      'is_public': _params.isPublic,
      'impersonate_user': _params.impersonateUser,
      'can_tag': _params.canTag,
      'is_hidden': _params.isHidden,
    };

    const sdkHeaders = getSdkHeaders(
      GlobalSearchV2.DEFAULT_SERVICE_NAME,
      'v2',
      'search'
    );

    const parameters = {
      options: {
        url: '/v3/resources/search',
        method: 'POST',
        body,
        qs: query,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'transaction-id': _params.transactionId,
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }
  /*************************
   * resourceTypes
   ************************/

  /**
   * DEPRECATED. Get all GhoST indexes.
   *
   * Retrieves a list of all GhoST indexes.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<GlobalSearchV2.Response<GlobalSearchV2.SupportedTypesList>>}
   * @deprecated this method is deprecated and may be removed in a future release
   */
  public getSupportedTypes(
    params?: GlobalSearchV2.GetSupportedTypesParams
  ): Promise<GlobalSearchV2.Response<GlobalSearchV2.SupportedTypesList>> {
    GlobalSearchV2._logger.warn('A deprecated operation has been invoked: getSupportedTypes');
    const _params = { ...params };
    const _requiredParams = [];
    const _validParams = ['headers'];
    const _validationErrors = validateParams(_params, _requiredParams, _validParams);
    if (_validationErrors) {
      return Promise.reject(_validationErrors);
    }

    const sdkHeaders = getSdkHeaders(
      GlobalSearchV2.DEFAULT_SERVICE_NAME,
      'v2',
      'getSupportedTypes'
    );

    const parameters = {
      options: {
        url: '/v2/resources/supported_types',
        method: 'GET',
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

namespace GlobalSearchV2 {
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
  export interface EmptyObject {}

  /** A standard JS object, defined to avoid the limitations of `Object` and `object` */
  export interface JsonObject {
    [key: string]: any;
  }

  /*************************
   * request interfaces
   ************************/

  /** Parameters for the `search` operation. */
  export interface SearchParams {
    /** The Lucene-formatted query string. Default to '*' if not set. */
    query?: string;
    /** The list of the fields returned by the search. By default, the returned fields are the `account_id`, `name`,
     *  `type`, `family`, and `crn`. For all queries, `crn` is always returned.
     */
    fields?: string[];
    /** An opaque cursor that is returned on each call and that must be set on the subsequent call to get the next
     *  batch of items. If the search returns no items, then the search_cursor is not present in the response.
     */
    searchCursor?: string;
    /** An alphanumeric string that can be used to trace a request across services. If not specified, it
     *  automatically generated with the prefix "gst-".
     */
    transactionId?: string;
    /** The account ID to filter resources. */
    accountId?: string;
    /** The boundary where the search performs. This parameter must be set only for the cross-account searches. */
    boundary?: SearchConstants.Boundary | string;
    /** The maximum number of hits to return. Defaults to 10. */
    limit?: number;
    /** A search timeout in milliseconds, bounding the search request to run within the specified time value and
     *  bail with the hits accumulated up to that point when expired. Defaults to the system defined timeout.
     */
    timeout?: number;
    /** Comma separated properties names that are used for sorting. */
    sort?: string[];
    /** Determines if deleted documents should be included in result set or not. Possible values are false
     *  (default), true or any. If false, only existing documents are returned; if true, only deleted documents are
     *  returned; If any, both existing and deleted documents are returned. (_for administrators only_).
     */
    isDeleted?: SearchConstants.IsDeleted | string;
    /** Determines if reclaimed documents should be included in result set or not. Possible values are false
     *  (default), true or any. If false, only not reclaimed documents are returned; if true, only reclaimed documents
     *  are returned; If any, both reclaimed and not reclaimed documents are returned.
     */
    isReclaimed?: SearchConstants.IsReclaimed | string;
    /** Determines if public resources should be included in result set or not. Possible values are false (default),
     *  true or any. If false, do not search public resources; if true, search only public resources; If any, search
     *  also public resources.
     */
    isPublic?: SearchConstants.IsPublic | string;
    /** The user on whose behalf the search must be performed. Only a GhoST admin can impersonate a user, so be sure
     *  you set a GhoST admin IAM token in the Authorization header if you set this parameter. (_for administrators
     *  only_).
     */
    impersonateUser?: string;
    /** Determines if the result set must return the resources that the user can tag or the resources that the user
     *  can view (only a GhoST admin can use this parameter). If false (default), only resources user can view are
     *  returned; if true, only resources that user has permissions for tagging are returned (_for administrators
     *  only_).
     */
    canTag?: SearchConstants.CanTag | string;
    /** Determines if the result set must return only the visible resources or not. If false (default), only visible
     *  resources are returned; if true, only hidden resources are returned; if any, all resources are returned.
     */
    isHidden?: SearchConstants.IsHidden | string;
    headers?: OutgoingHttpHeaders;
  }

  /** Constants for the `search` operation. */
  export namespace SearchConstants {
    /** The boundary where the search performs. This parameter must be set only for the cross-account searches. */
    export enum Boundary {
      GLOBAL = 'global',
      US_REGULATED = 'us-regulated',
    }
    /** Determines if deleted documents should be included in result set or not. Possible values are false (default), true or any. If false, only existing documents are returned; if true, only deleted documents are returned; If any, both existing and deleted documents are returned. (_for administrators only_). */
    export enum IsDeleted {
      TRUE = 'true',
      FALSE = 'false',
      ANY = 'any',
    }
    /** Determines if reclaimed documents should be included in result set or not. Possible values are false (default), true or any. If false, only not reclaimed documents are returned; if true, only reclaimed documents are returned; If any, both reclaimed and not reclaimed documents are returned. */
    export enum IsReclaimed {
      TRUE = 'true',
      FALSE = 'false',
      ANY = 'any',
    }
    /** Determines if public resources should be included in result set or not. Possible values are false (default), true or any. If false, do not search public resources; if true, search only public resources; If any, search also public resources. */
    export enum IsPublic {
      TRUE = 'true',
      FALSE = 'false',
      ANY = 'any',
    }
    /** Determines if the result set must return the resources that the user can tag or the resources that the user can view (only a GhoST admin can use this parameter). If false (default), only resources user can view are returned; if true, only resources that user has permissions for tagging are returned (_for administrators only_). */
    export enum CanTag {
      TRUE = 'true',
      FALSE = 'false',
    }
    /** Determines if the result set must return only the visible resources or not. If false (default), only visible resources are returned; if true, only hidden resources are returned; if any, all resources are returned. */
    export enum IsHidden {
      TRUE = 'true',
      FALSE = 'false',
      ANY = 'any',
    }
  }

  /** Parameters for the `getSupportedTypes` operation. */
  export interface GetSupportedTypesParams {
    headers?: OutgoingHttpHeaders;
  }

  /*************************
   * model interfaces
   ************************/

  /** A resource returned in a search result, which is identified by its `crn`. It contains other properties that depend on the resource type. */
  export interface ResultItem {
    /** Resource identifier in CRN format. */
    crn: string;
    /** ResultItem accepts additional properties. */
    [propName: string]: any;
  }

  /** The search scan response. */
  export interface ScanResult {
    /** The search cursor to use on all calls after the first one. */
    search_cursor?: string;
    /** Value of the limit parameter specified by the user. */
    limit: number;
    /** The array of results. Each item represents a resource. An empty array signals the end of the result set,
     *  which means there are no more results to fetch.
     */
    items: ResultItem[];
  }

  /** A list of all GhoST indexes. */
  export interface SupportedTypesList {
    /** A list of all GhoST indexes. */
    supported_types?: string[];
  }
}

export = GlobalSearchV2;
