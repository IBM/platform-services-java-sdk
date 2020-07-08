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
 * Manage your tags with the Tagging API in IBM Cloud. You can attach, detach, delete a tag or list all tags in your
 * billing account with the Tagging API. The tag name must be unique within a billing account. You can create tags in
 * two formats: `key:value` or `label`.
 */

class GlobalTaggingV1 extends BaseService {

  static DEFAULT_SERVICE_URL: string = 'https://tags.global-search-tagging.cloud.ibm.com';
  static DEFAULT_SERVICE_NAME: string = 'global_tagging';

  /*************************
   * Factory method
   ************************/

  /**
   * Constructs an instance of GlobalTaggingV1 with passed in options and external configuration.
   *
   * @param {UserOptions} [options] - The parameters to send to the service.
   * @param {string} [options.serviceName] - The name of the service to configure
   * @param {Authenticator} [options.authenticator] - The Authenticator object used to authenticate requests to the service
   * @param {string} [options.serviceUrl] - The URL for the service
   * @returns {GlobalTaggingV1}
   */

  public static newInstance(options: UserOptions): GlobalTaggingV1 {
    options = options || {};

    if (!options.serviceName) {
      options.serviceName = this.DEFAULT_SERVICE_NAME;
    }
    if (!options.authenticator) {
      options.authenticator = getAuthenticatorFromEnvironment(options.serviceName);
    }
    const service = new GlobalTaggingV1(options);
    service.configureService(options.serviceName);
    if (options.serviceUrl) {
      service.setServiceUrl(options.serviceUrl);
    }
    return service;
  }


  /**
   * Construct a GlobalTaggingV1 object.
   *
   * @param {Object} options - Options for the service.
   * @param {string} [options.serviceUrl] - The base url to use when contacting the service (e.g. 'https://gateway.watsonplatform.net'). The base url may differ between IBM Cloud regions.
   * @param {OutgoingHttpHeaders} [options.headers] - Default headers that shall be included with every request to the service.
   * @param {Authenticator} options.authenticator - The Authenticator object used to authenticate requests to the service
   * @constructor
   * @returns {GlobalTaggingV1}
   */
  constructor(options: UserOptions) {
    options = options || {};

    super(options);
    if (options.serviceUrl) {
      this.setServiceUrl(options.serviceUrl);
    } else {
      this.setServiceUrl(GlobalTaggingV1.DEFAULT_SERVICE_URL);
    }
  }

  /*************************
   * tags
   ************************/

  /**
   * Get all tags.
   *
   * Lists all tags in a billing account. Use the `attached_to` parameter to return the list of tags attached to the
   * specified resource.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {string[]} [params.providers] - Select a provider. Supported values are `ghost` and `ims`. To list GhoST
   * tags and infrastructure tags use `ghost,ims`.
   * @param {string} [params.attachedTo] - If you want to return only the list of tags attached to a specified resource,
   * pass here the ID of the resource. For GhoST onboarded resources, the resource ID is the CRN; for IMS resources, it
   * is the IMS ID. When using this parameter it is mandatory to specify the appropriate provider (`ims` or `ghost`).
   * @param {boolean} [params.fullData] - If set to `true`, this query returns the provider, `ghost`, `ims` or
   * `ghost,ims`, where the tag exists and the number of attached resources.
   * @param {number} [params.offset] - The offset is the index of the item from which you want to start returning data
   * from.
   * @param {number} [params.limit] - The number of tags to return.
   * @param {string} [params.orderByName] - Order the output by tag name.
   * @param {number} [params.timeout] - The search timeout bounds the search request to be executed within the specified
   * time value. It returns the hits accumulated until time runs out.
   * @param {boolean} [params.attachedOnly] - Filter on attached tags. If true, returns only tags that are attached to
   * one or more resources. If false returns all tags.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<GlobalTaggingV1.Response<GlobalTaggingV1.TagList>>}
   */
  public listTags(params?: GlobalTaggingV1.ListTagsParams): Promise<GlobalTaggingV1.Response<GlobalTaggingV1.TagList>> {
    const _params = extend({}, params);

    return new Promise((resolve, reject) => {
      const query = {
        'providers': _params.providers,
        'attached_to': _params.attachedTo,
        'full_data': _params.fullData,
        'offset': _params.offset,
        'limit': _params.limit,
        'order_by_name': _params.orderByName,
        'timeout': _params.timeout,
        'attached_only': _params.attachedOnly
      };

      const sdkHeaders = getSdkHeaders(GlobalTaggingV1.DEFAULT_SERVICE_NAME, 'v1', 'listTags');

      const parameters = {
        options: {
          url: '/v3/tags',
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
   * Delete unused tags.
   *
   * Delete the tags that are not attatched to any resource.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {string} [params.providers] - Select a provider. Supported values are `ghost` and `ims`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<GlobalTaggingV1.Response<GlobalTaggingV1.DeleteTagsResult>>}
   */
  public deleteTagAll(params?: GlobalTaggingV1.DeleteTagAllParams): Promise<GlobalTaggingV1.Response<GlobalTaggingV1.DeleteTagsResult>> {
    const _params = extend({}, params);

    return new Promise((resolve, reject) => {
      const query = {
        'providers': _params.providers
      };

      const sdkHeaders = getSdkHeaders(GlobalTaggingV1.DEFAULT_SERVICE_NAME, 'v1', 'deleteTagAll');

      const parameters = {
        options: {
          url: '/v3/tags',
          method: 'DELETE',
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
   * Delete a tag.
   *
   * Delete an existing tag. A tag can be deleted only if it is not attached to any resource.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.tagName - The name of tag to be deleted.
   * @param {string[]} [params.providers] - Select a provider. Supported values are `ghost` and `ims`. To delete tag
   * both in GhoST in IMS, use `ghost,ims`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<GlobalTaggingV1.Response<GlobalTaggingV1.DeleteTagResults>>}
   */
  public deleteTag(params: GlobalTaggingV1.DeleteTagParams): Promise<GlobalTaggingV1.Response<GlobalTaggingV1.DeleteTagResults>> {
    const _params = extend({}, params);
    const requiredParams = ['tagName'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'providers': _params.providers
      };

      const path = {
        'tag_name': _params.tagName
      };

      const sdkHeaders = getSdkHeaders(GlobalTaggingV1.DEFAULT_SERVICE_NAME, 'v1', 'deleteTag');

      const parameters = {
        options: {
          url: '/v3/tags/{tag_name}',
          method: 'DELETE',
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
   * Attach one or more tags.
   *
   * Attaches one or more tags to one or more resources. To attach a tag to a resource managed by the Resource
   * Controller, you must be an editor on the resource. To attach a tag to a Cloud Foundry resource, you must have space
   * developer role. To attach a tag to IMS resources, depending on the resource, you need either `view hardware
   * details`, `view virtual server details` or `manage storage` permission.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {Resource[]} params.resources - List of resources on which the tag or tags should be attached.
   * @param {string} [params.tagName] - The name of the tag to attach.
   * @param {string[]} [params.tagNames] - An array of tag names to attach.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<GlobalTaggingV1.Response<GlobalTaggingV1.TagResults>>}
   */
  public attachTag(params: GlobalTaggingV1.AttachTagParams): Promise<GlobalTaggingV1.Response<GlobalTaggingV1.TagResults>> {
    const _params = extend({}, params);
    const requiredParams = ['resources'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const body = {
        'resources': _params.resources,
        'tag_name': _params.tagName,
        'tag_names': _params.tagNames
      };

      const sdkHeaders = getSdkHeaders(GlobalTaggingV1.DEFAULT_SERVICE_NAME, 'v1', 'attachTag');

      const parameters = {
        options: {
          url: '/v3/tags/attach',
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
   * Detach one or more tags.
   *
   * Detach one or more tags from one or more resources. To detach a tag from a Resource Controller managed resource,
   * you must be an editor on the resource. To detach a tag to a Cloud Foundry resource, you must have `space developer`
   * role.
   *   To detach a tag to IMS resources, depending on the resource, you need either `view hardware details`, `view
   * virtual server details` or `storage manage` permission.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {Resource[]} params.resources - List of resources on which the tag or tags should be detached.
   * @param {string} [params.tagName] - The name of the tag to detach.
   * @param {string[]} [params.tagNames] - An array of tag names to detach.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<GlobalTaggingV1.Response<GlobalTaggingV1.TagResults>>}
   */
  public detachTag(params: GlobalTaggingV1.DetachTagParams): Promise<GlobalTaggingV1.Response<GlobalTaggingV1.TagResults>> {
    const _params = extend({}, params);
    const requiredParams = ['resources'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const body = {
        'resources': _params.resources,
        'tag_name': _params.tagName,
        'tag_names': _params.tagNames
      };

      const sdkHeaders = getSdkHeaders(GlobalTaggingV1.DEFAULT_SERVICE_NAME, 'v1', 'detachTag');

      const parameters = {
        options: {
          url: '/v3/tags/detach',
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

}

/*************************
 * interfaces
 ************************/

namespace GlobalTaggingV1 {

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

  /** Parameters for the `listTags` operation. */
  export interface ListTagsParams {
    /** Select a provider. Supported values are `ghost` and `ims`. To list GhoST tags and infrastructure tags use
     *  `ghost,ims`.
     */
    providers?: ListTagsConstants.Providers[] | string[];
    /** If you want to return only the list of tags attached to a specified resource, pass here the ID of the
     *  resource. For GhoST onboarded resources, the resource ID is the CRN; for IMS resources, it is the IMS ID. When
     *  using this parameter it is mandatory to specify the appropriate provider (`ims` or `ghost`).
     */
    attachedTo?: string;
    /** If set to `true`, this query returns the provider, `ghost`, `ims` or `ghost,ims`, where the tag exists and
     *  the number of attached resources.
     */
    fullData?: boolean;
    /** The offset is the index of the item from which you want to start returning data from. */
    offset?: number;
    /** The number of tags to return. */
    limit?: number;
    /** Order the output by tag name. */
    orderByName?: ListTagsConstants.OrderByName | string;
    /** The search timeout bounds the search request to be executed within the specified time value. It returns the
     *  hits accumulated until time runs out.
     */
    timeout?: number;
    /** Filter on attached tags. If true, returns only tags that are attached to one or more resources. If false
     *  returns all tags.
     */
    attachedOnly?: boolean;
    headers?: OutgoingHttpHeaders;
  }

  /** Constants for the `listTags` operation. */
  export namespace ListTagsConstants {
    /** Select a provider. Supported values are `ghost` and `ims`. To list GhoST tags and infrastructure tags use `ghost,ims`. */
    export enum Providers {
      GHOST = 'ghost',
      IMS = 'ims',
    }
    /** Order the output by tag name. */
    export enum OrderByName {
      ASC = 'asc',
      DESC = 'desc',
    }
  }

  /** Parameters for the `deleteTagAll` operation. */
  export interface DeleteTagAllParams {
    /** Select a provider. Supported values are `ghost` and `ims`. */
    providers?: DeleteTagAllConstants.Providers | string;
    headers?: OutgoingHttpHeaders;
  }

  /** Constants for the `deleteTagAll` operation. */
  export namespace DeleteTagAllConstants {
    /** Select a provider. Supported values are `ghost` and `ims`. */
    export enum Providers {
      GHOST = 'ghost',
      IMS = 'ims',
    }
  }

  /** Parameters for the `deleteTag` operation. */
  export interface DeleteTagParams {
    /** The name of tag to be deleted. */
    tagName: string;
    /** Select a provider. Supported values are `ghost` and `ims`. To delete tag both in GhoST in IMS, use
     *  `ghost,ims`.
     */
    providers?: DeleteTagConstants.Providers[] | string[];
    headers?: OutgoingHttpHeaders;
  }

  /** Constants for the `deleteTag` operation. */
  export namespace DeleteTagConstants {
    /** Select a provider. Supported values are `ghost` and `ims`. To delete tag both in GhoST in IMS, use `ghost,ims`. */
    export enum Providers {
      GHOST = 'ghost',
      IMS = 'ims',
    }
  }

  /** Parameters for the `attachTag` operation. */
  export interface AttachTagParams {
    /** List of resources on which the tag or tags should be attached. */
    resources: Resource[];
    /** The name of the tag to attach. */
    tagName?: string;
    /** An array of tag names to attach. */
    tagNames?: string[];
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `detachTag` operation. */
  export interface DetachTagParams {
    /** List of resources on which the tag or tags should be detached. */
    resources: Resource[];
    /** The name of the tag to detach. */
    tagName?: string;
    /** An array of tag names to detach. */
    tagNames?: string[];
    headers?: OutgoingHttpHeaders;
  }

  /*************************
   * model interfaces
   ************************/

  /** Results of a delete_tag request. */
  export interface DeleteTagResults {
    /** Array of results of a delete_tag request. */
    results?: DeleteTagResultsItem[];
  }

  /** Result of a delete_tag request. */
  export interface DeleteTagResultsItem {
    /** The provider of the tag. */
    provider?: string;
    /** It is `true` if the operation exits with an error. */
    is_error?: boolean;
    /** DeleteTagResultsItem accepts additional properties. */
    [propName: string]: any;
  }

  /** The results of a deleting unattatched tags. */
  export interface DeleteTagsResult {
    /** The number of tags deleted in the account. */
    total_count?: number;
    /** An indicator that is set to true if there was an error deleting some of the tags. */
    errors?: boolean;
    items?: DeleteTagsResultItem[];
  }

  /** Result of deleting one unattached tag. */
  export interface DeleteTagsResultItem {
    /** The name of the tag that was deleted. */
    tag_name?: string;
    /** An indicator that is set to true if there was an error deleting the tag. */
    is_error?: boolean;
  }

  /** A resource that may have attached tags. */
  export interface Resource {
    /** The CRN or IMS ID of the resource. */
    resource_id: string;
    /** The IMS resource type of the resource. */
    resource_type?: string;
  }

  /** A tag. */
  export interface Tag {
    /** This is the name of the tag. */
    name: string;
  }

  /** A list of tags. */
  export interface TagList {
    /** The number of tags defined in the account. */
    total_count?: number;
    /** The offset specific at input time. */
    offset?: number;
    /** The limit specified at input time. */
    limit?: number;
    /** This is an array of output results. */
    items?: Tag[];
  }

  /** Results of an attach_tag or detach_tag request. */
  export interface TagResults {
    /** Array of results of an attach_tag or detach_tag request. */
    results?: TagResultsItem[];
  }

  /** Result of an attach_tag or detach_tag request for a tagged resource. */
  export interface TagResultsItem {
    /** The CRN or IMS ID of the resource. */
    resource_id: string;
    /** It is `true` if the operation exits with an error. */
    is_error?: boolean;
  }

}

export = GlobalTaggingV1;
