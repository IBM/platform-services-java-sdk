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
 * IBM OpenAPI SDK Code Generator Version: 99-SNAPSHOT-6058b92b-20200924-123044
 */
 

import * as extend from 'extend';
import { IncomingHttpHeaders, OutgoingHttpHeaders } from 'http';
import { Authenticator, BaseService, getAuthenticatorFromEnvironment, getMissingParams, UserOptions } from 'ibm-cloud-sdk-core';
import { getSdkHeaders } from '../lib/common';

/**
 * Manage your tags with the Tagging API in IBM Cloud. You can attach, detach, delete a tag or list all tags in your
 * billing account with the Tagging API. The tag name must be unique within a billing account. You can create tags in
 * two formats: `key:value` or `label`. The tagging API supports two types of tag: `user` and `service`. `service` tags
 * cannot be attached to IMS resources (see `providers=ims` query parameter). `service` tags must be in the form
 * `service_prefix:tag_label` where `service_prefix` identifies the Service owning the tag.
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
   * @param {string} [params.accountId] - The ID of the billing account to list the tags for. If it is not set, then it
   * is taken from the authorization token. This parameter is required if `tag_type` is set to `service`.
   * @param {string} [params.tagType] - The type of the tag you want to list. Supported values are `user` and `service`.
   * @param {boolean} [params.fullData] - If set to `true`, this query returns the provider, `ghost`, `ims` or
   * `ghost,ims`, where the tag exists and the number of attached resources.
   * @param {string[]} [params.providers] - Select a provider. Supported values are `ghost` and `ims`. To list GhoST
   * tags and infrastructure tags use `ghost,ims`. `service` tags can only be attached to GhoST onboarded resources, so
   * you don't need to set this parameter when listing `service` tags.
   * @param {string} [params.attachedTo] - If you want to return only the list of tags attached to a specified resource,
   * pass the ID of the resource on this parameter. For GhoST onboarded resources, the resource ID is the CRN; for IMS
   * resources, it is the IMS ID. When using this parameter, you must specify the appropriate provider (`ims` or
   * `ghost`).
   * @param {number} [params.offset] - The offset is the index of the item from which you want to start returning data
   * from.
   * @param {number} [params.limit] - The number of tags to return.
   * @param {number} [params.timeout] - The search timeout bounds the search request to be executed within the specified
   * time value. It returns the hits accumulated until time runs out.
   * @param {string} [params.orderByName] - Order the output by tag name.
   * @param {boolean} [params.attachedOnly] - Filter on attached tags. If `true`, it returns only tags that are attached
   * to one or more resources. If `false`, it returns all tags.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<GlobalTaggingV1.Response<GlobalTaggingV1.TagList>>}
   */
  public listTags(params?: GlobalTaggingV1.ListTagsParams): Promise<GlobalTaggingV1.Response<GlobalTaggingV1.TagList>> {
    const _params = Object.assign({}, params);

    return new Promise((resolve, reject) => {
      const query = {
        'account_id': _params.accountId,
        'tag_type': _params.tagType,
        'full_data': _params.fullData,
        'providers': _params.providers,
        'attached_to': _params.attachedTo,
        'offset': _params.offset,
        'limit': _params.limit,
        'timeout': _params.timeout,
        'order_by_name': _params.orderByName,
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
   * Delete all unused tags.
   *
   * Delete the tags that are not attached to any resource.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {string} [params.providers] - Select a provider. Supported values are `ghost` and `ims`.
   * @param {string} [params.accountId] - The ID of the billing account to delete the tags for. If it is not set, then
   * it is taken from the authorization token. It is a required parameter if `tag_type` is set to `service`.
   * @param {string} [params.tagType] - The type of the tag. Supported values are `user` and `service`. `service` is not
   * supported if the `providers` parameter is set to `ims`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<GlobalTaggingV1.Response<GlobalTaggingV1.DeleteTagsResult>>}
   */
  public deleteTagAll(params?: GlobalTaggingV1.DeleteTagAllParams): Promise<GlobalTaggingV1.Response<GlobalTaggingV1.DeleteTagsResult>> {
    const _params = Object.assign({}, params);

    return new Promise((resolve, reject) => {
      const query = {
        'providers': _params.providers,
        'account_id': _params.accountId,
        'tag_type': _params.tagType
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
   * Delete an unused tag.
   *
   * Delete an existing tag. A tag can be deleted only if it is not attached to any resource.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.tagName - The name of tag to be deleted.
   * @param {string[]} [params.providers] - Select a provider. Supported values are `ghost` and `ims`. To delete tag
   * both in GhoST in IMS, use `ghost,ims`.
   * @param {string} [params.accountId] - The ID of the billing account to delete the tag for. It is a required
   * parameter if `tag_type` is set to `service`, otherwise it is inferred from the authorization IAM token.
   * @param {string} [params.tagType] - The type of the tag. Supported values are `user` and `service`. `service` is not
   * supported for `providers=ims`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<GlobalTaggingV1.Response<GlobalTaggingV1.DeleteTagResults>>}
   */
  public deleteTag(params: GlobalTaggingV1.DeleteTagParams): Promise<GlobalTaggingV1.Response<GlobalTaggingV1.DeleteTagResults>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['tagName'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'providers': _params.providers,
        'account_id': _params.accountId,
        'tag_type': _params.tagType
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
   * Attach tags.
   *
   * Attaches one or more tags to one or more resources. To attach a `user` tag on a resource, you must have the access
   * listed in the [Granting users access to tag resources](https://cloud.ibm.com/docs/account?topic=account-access)
   * documentation. To attach a `service` tag, you must be an authorized service. If that is the case, then you can
   * attach a `service` tag with your registered `prefix` to any resource in any account. The account ID must be set
   * through the `account_id` query parameter.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {Resource[]} params.resources - List of resources on which the tag or tags should be attached.
   * @param {string} [params.tagName] - The name of the tag to attach.
   * @param {string[]} [params.tagNames] - An array of tag names to attach.
   * @param {string} [params.accountId] - The ID of the billing account where the resources to be tagged lives. It is a
   * required parameter if `tag_type` is set to `service`. Otherwise, it is inferred from the authorization IAM token.
   * @param {string} [params.tagType] - The type of the tag. Supported values are `user` and `service`. `service` is not
   * supported if `providers` is set to `ims`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<GlobalTaggingV1.Response<GlobalTaggingV1.TagResults>>}
   */
  public attachTag(params: GlobalTaggingV1.AttachTagParams): Promise<GlobalTaggingV1.Response<GlobalTaggingV1.TagResults>> {
    const _params = Object.assign({}, params);
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

      const query = {
        'account_id': _params.accountId,
        'tag_type': _params.tagType
      };

      const sdkHeaders = getSdkHeaders(GlobalTaggingV1.DEFAULT_SERVICE_NAME, 'v1', 'attachTag');

      const parameters = {
        options: {
          url: '/v3/tags/attach',
          method: 'POST',
          body,
          qs: query,
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
   * Detach tags.
   *
   * Detaches one or more tags from one or more resources. To detach a `user` tag on a resource you must have the
   * permissions listed in the [Granting users access to tag
   * resources](https://cloud.ibm.com/docs/account?topic=account-access) documentation. To detach a `service` tag you
   * must be an authorized Service. If that is the case, then you can detach a `service` tag with your registered
   * `prefix` from any resource in any account. The account ID must be set through the `account_id` query parameter.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {Resource[]} params.resources - List of resources on which the tag or tags should be detached.
   * @param {string} [params.tagName] - The name of the tag to detach.
   * @param {string[]} [params.tagNames] - An array of tag names to detach.
   * @param {string} [params.accountId] - The ID of the billing account where the resources to be un-tagged lives. It is
   * a required parameter if `tag_type` is set to `service`, otherwise it is inferred from the authorization IAM token.
   * @param {string} [params.tagType] - The type of the tag. Supported values are `user` and `service`. `service` is not
   * supported for `providers=ims`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<GlobalTaggingV1.Response<GlobalTaggingV1.TagResults>>}
   */
  public detachTag(params: GlobalTaggingV1.DetachTagParams): Promise<GlobalTaggingV1.Response<GlobalTaggingV1.TagResults>> {
    const _params = Object.assign({}, params);
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

      const query = {
        'account_id': _params.accountId,
        'tag_type': _params.tagType
      };

      const sdkHeaders = getSdkHeaders(GlobalTaggingV1.DEFAULT_SERVICE_NAME, 'v1', 'detachTag');

      const parameters = {
        options: {
          url: '/v3/tags/detach',
          method: 'POST',
          body,
          qs: query,
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
    /** The ID of the billing account to list the tags for. If it is not set, then it is taken from the
     *  authorization token. This parameter is required if `tag_type` is set to `service`.
     */
    accountId?: string;
    /** The type of the tag you want to list. Supported values are `user` and `service`. */
    tagType?: ListTagsConstants.TagType | string;
    /** If set to `true`, this query returns the provider, `ghost`, `ims` or `ghost,ims`, where the tag exists and
     *  the number of attached resources.
     */
    fullData?: boolean;
    /** Select a provider. Supported values are `ghost` and `ims`. To list GhoST tags and infrastructure tags use
     *  `ghost,ims`. `service` tags can only be attached to GhoST onboarded resources, so you don't need to set this
     *  parameter when listing `service` tags.
     */
    providers?: ListTagsConstants.Providers[] | string[];
    /** If you want to return only the list of tags attached to a specified resource, pass the ID of the resource on
     *  this parameter. For GhoST onboarded resources, the resource ID is the CRN; for IMS resources, it is the IMS ID.
     *  When using this parameter, you must specify the appropriate provider (`ims` or `ghost`).
     */
    attachedTo?: string;
    /** The offset is the index of the item from which you want to start returning data from. */
    offset?: number;
    /** The number of tags to return. */
    limit?: number;
    /** The search timeout bounds the search request to be executed within the specified time value. It returns the
     *  hits accumulated until time runs out.
     */
    timeout?: number;
    /** Order the output by tag name. */
    orderByName?: ListTagsConstants.OrderByName | string;
    /** Filter on attached tags. If `true`, it returns only tags that are attached to one or more resources. If
     *  `false`, it returns all tags.
     */
    attachedOnly?: boolean;
    headers?: OutgoingHttpHeaders;
  }

  /** Constants for the `listTags` operation. */
  export namespace ListTagsConstants {
    /** The type of the tag you want to list. Supported values are `user` and `service`. */
    export enum TagType {
      USER = 'user',
      SERVICE = 'service',
    }
    /** Select a provider. Supported values are `ghost` and `ims`. To list GhoST tags and infrastructure tags use `ghost,ims`. `service` tags can only be attached to GhoST onboarded resources, so you don't need to set this parameter when listing `service` tags. */
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
    /** The ID of the billing account to delete the tags for. If it is not set, then it is taken from the
     *  authorization token. It is a required parameter if `tag_type` is set to `service`.
     */
    accountId?: string;
    /** The type of the tag. Supported values are `user` and `service`. `service` is not supported if the
     *  `providers` parameter is set to `ims`.
     */
    tagType?: DeleteTagAllConstants.TagType | string;
    headers?: OutgoingHttpHeaders;
  }

  /** Constants for the `deleteTagAll` operation. */
  export namespace DeleteTagAllConstants {
    /** Select a provider. Supported values are `ghost` and `ims`. */
    export enum Providers {
      GHOST = 'ghost',
      IMS = 'ims',
    }
    /** The type of the tag. Supported values are `user` and `service`. `service` is not supported if the `providers` parameter is set to `ims`. */
    export enum TagType {
      USER = 'user',
      SERVICE = 'service',
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
    /** The ID of the billing account to delete the tag for. It is a required parameter if `tag_type` is set to
     *  `service`, otherwise it is inferred from the authorization IAM token.
     */
    accountId?: string;
    /** The type of the tag. Supported values are `user` and `service`. `service` is not supported for
     *  `providers=ims`.
     */
    tagType?: DeleteTagConstants.TagType | string;
    headers?: OutgoingHttpHeaders;
  }

  /** Constants for the `deleteTag` operation. */
  export namespace DeleteTagConstants {
    /** Select a provider. Supported values are `ghost` and `ims`. To delete tag both in GhoST in IMS, use `ghost,ims`. */
    export enum Providers {
      GHOST = 'ghost',
      IMS = 'ims',
    }
    /** The type of the tag. Supported values are `user` and `service`. `service` is not supported for `providers=ims`. */
    export enum TagType {
      USER = 'user',
      SERVICE = 'service',
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
    /** The ID of the billing account where the resources to be tagged lives. It is a required parameter if
     *  `tag_type` is set to `service`. Otherwise, it is inferred from the authorization IAM token.
     */
    accountId?: string;
    /** The type of the tag. Supported values are `user` and `service`. `service` is not supported if `providers` is
     *  set to `ims`.
     */
    tagType?: AttachTagConstants.TagType | string;
    headers?: OutgoingHttpHeaders;
  }

  /** Constants for the `attachTag` operation. */
  export namespace AttachTagConstants {
    /** The type of the tag. Supported values are `user` and `service`. `service` is not supported if `providers` is set to `ims`. */
    export enum TagType {
      USER = 'user',
      SERVICE = 'service',
    }
  }

  /** Parameters for the `detachTag` operation. */
  export interface DetachTagParams {
    /** List of resources on which the tag or tags should be detached. */
    resources: Resource[];
    /** The name of the tag to detach. */
    tagName?: string;
    /** An array of tag names to detach. */
    tagNames?: string[];
    /** The ID of the billing account where the resources to be un-tagged lives. It is a required parameter if
     *  `tag_type` is set to `service`, otherwise it is inferred from the authorization IAM token.
     */
    accountId?: string;
    /** The type of the tag. Supported values are `user` and `service`. `service` is not supported for
     *  `providers=ims`.
     */
    tagType?: DetachTagConstants.TagType | string;
    headers?: OutgoingHttpHeaders;
  }

  /** Constants for the `detachTag` operation. */
  export namespace DetachTagConstants {
    /** The type of the tag. Supported values are `user` and `service`. `service` is not supported for `providers=ims`. */
    export enum TagType {
      USER = 'user',
      SERVICE = 'service',
    }
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

  /** Results of a deleting unattatched tags. */
  export interface DeleteTagsResult {
    /** The number of tags that have been deleted. */
    total_count?: number;
    /** It is set to true if there is at least one tag operation in error. */
    errors?: boolean;
    /** The list of tag operation results. */
    items?: DeleteTagsResultItem[];
  }

  /** Result of a delete_tags request. */
  export interface DeleteTagsResultItem {
    /** The name of the deleted tag. */
    tag_name?: string;
    /** true if the tag was not deleted. */
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
    /** Set the occurrencies of the total tags associated to this account. */
    total_count?: number;
    /** The offset at which tags are returned. */
    offset?: number;
    /** The number of tags requested to be returned. */
    limit?: number;
    /** Array of output results. */
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
