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
 * The catalog service manages offerings across geographies as the system of record. The catalog supports a RESTful API
 * where users can retrieve information about existing offerings and create, manage, and delete their offerings. Start
 * with the base URL and use the endpoints to retrieve metadata about services in the catalog and manage service
 * visbility. Depending on the kind of object, the metadata can include information about pricing, provisioning,
 * regions, and more. For more information, see the [catalog
 * documentation](https://cloud.ibm.com/docs/overview/catalog.html#global-catalog-overview).
 */

class GlobalCatalogV1 extends BaseService {

  static DEFAULT_SERVICE_URL: string = 'https://globalcatalog.cloud.ibm.com/api/v1';
  static DEFAULT_SERVICE_NAME: string = 'global_catalog';

  /*************************
   * Factory method
   ************************/

  /**
   * Constructs an instance of GlobalCatalogV1 with passed in options and external configuration.
   *
   * @param {UserOptions} [options] - The parameters to send to the service.
   * @param {string} [options.serviceName] - The name of the service to configure
   * @param {Authenticator} [options.authenticator] - The Authenticator object used to authenticate requests to the service
   * @param {string} [options.serviceUrl] - The URL for the service
   * @returns {GlobalCatalogV1}
   */

  public static newInstance(options: UserOptions): GlobalCatalogV1 {
    options = options || {};

    if (!options.serviceName) {
      options.serviceName = this.DEFAULT_SERVICE_NAME;
    }
    if (!options.authenticator) {
      options.authenticator = getAuthenticatorFromEnvironment(options.serviceName);
    }
    const service = new GlobalCatalogV1(options);
    service.configureService(options.serviceName);
    if (options.serviceUrl) {
      service.setServiceUrl(options.serviceUrl);
    }
    return service;
  }


  /**
   * Construct a GlobalCatalogV1 object.
   *
   * @param {Object} options - Options for the service.
   * @param {string} [options.serviceUrl] - The base url to use when contacting the service (e.g. 'https://gateway.watsonplatform.net/api/v1'). The base url may differ between IBM Cloud regions.
   * @param {OutgoingHttpHeaders} [options.headers] - Default headers that shall be included with every request to the service.
   * @param {Authenticator} options.authenticator - The Authenticator object used to authenticate requests to the service
   * @constructor
   * @returns {GlobalCatalogV1}
   */
  constructor(options: UserOptions) {
    options = options || {};

    super(options);
    if (options.serviceUrl) {
      this.setServiceUrl(options.serviceUrl);
    } else {
      this.setServiceUrl(GlobalCatalogV1.DEFAULT_SERVICE_URL);
    }
  }

  /*************************
   * object
   ************************/

  /**
   * Returns parent catalog entries.
   *
   * Includes key information, such as ID, name, kind, CRN, tags, and provider. This endpoint is ETag enabled.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {string} [params.account] - This changes the scope of the request regardless of the authorization header.
   * Example scopes are `account` and `global`. `account=global` is reqired if operating with a service ID that has a
   * global admin policy, for example `GET /?account=global`.
   * @param {string} [params.include] - A GET call by default returns a basic set of properties. To include other
   * properties, you must add this parameter. A wildcard (`*`) includes all properties for an object, for example `GET
   * /?include=*`. To include specific metadata fields, separate each field with a colon (:), for example `GET
   * /?include=metadata.ui:metadata.pricing`.
   * @param {string} [params.q] - Searches the catalog entries for keywords. Add filters to refine your search. A query
   * filter, for example, `q=kind:iaas service_name rc:true`, filters entries of kind iaas with
   * metadata.service.rc_compatible set to true and  have a service name is in their name, display name, or description.
   *  Valid tags are **kind**:<string>, **tag**:<strging>, **rc**:[true|false], **iam**:[true|false],
   * **active**:[true|false], **geo**:<string>, and **price**:<string>.
   * @param {string} [params.sortBy] - The field on which the output is sorted. Sorts by default by **name** property.
   * Available fields are **name**, **displayname** (overview_ui.display_name), **kind**, **provider** (provider.name),
   * **sbsindex** (metadata.ui.side_by_side_index), and the time **created**, and **updated**.
   * @param {string} [params.descending] - Sets the sort order. The default is false, which is ascending.
   * @param {string} [params.languages] - Return the data strings in a specified langauge. By default, the strings
   * returned are of the language preferred by your browser through the Accept-Langauge header, which allows an override
   * of the header. Languages are specified in standard form, such as `en-us`. To include all languages use a wildcard
   * (*).
   * @param {string} [params.complete] - Returns all available fields for all languages. Use the value `?complete=true`
   * as shortcut for ?include=*&languages=*.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<GlobalCatalogV1.Response<GlobalCatalogV1.SearchResult>>}
   */
  public listCatalogEntries(params?: GlobalCatalogV1.ListCatalogEntriesParams): Promise<GlobalCatalogV1.Response<GlobalCatalogV1.SearchResult>> {
    const _params = extend({}, params);

    return new Promise((resolve, reject) => {
      const query = {
        'account': _params.account,
        'include': _params.include,
        'q': _params.q,
        'sort-by': _params.sortBy,
        'descending': _params.descending,
        'languages': _params.languages,
        'complete': _params.complete
      };

      const sdkHeaders = getSdkHeaders(GlobalCatalogV1.DEFAULT_SERVICE_NAME, 'v1', 'listCatalogEntries');

      const parameters = {
        options: {
          url: '/',
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
   * Create a catalog entry.
   *
   * The created catalog entry is restricted by default. You must have an administrator or editor role in the scope of
   * the provided token. This API will return an ETag that can be used for standard ETag processing, except when depth
   * query is used.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.name - Programmatic name for this catalog entry, which must be formatted like a CRN segment.
   * See the display name in OverviewUI for a user-readable name.
   * @param {string} params.kind - The type of catalog entry, **service**, **template**, **dashboard**, which determines
   * the type and shape of the object.
   * @param {OverviewUI} params.overviewUi - Overview is nested in the top level. The key value pair is
   * `[_language_]overview_ui`.
   * @param {Image} params.images - Image annotation for this catalog entry. The image is a URL.
   * @param {boolean} params.disabled - Boolean value that determines the global visibility for the catalog entry, and
   * its children. If it is not enabled, all plans are disabled.
   * @param {string[]} params.tags - A list of tags. For example, IBM, 3rd Party, Beta, GA, and Single Tenant.
   * @param {Provider} params.provider - Information related to the provider associated with a catalog entry.
   * @param {string} params.id - Catalog entry's unique ID. It's the same across all catalog instances.
   * @param {string} [params.parentId] - The ID of the parent catalog entry if it exists.
   * @param {boolean} [params.group] - Boolean value that determines whether the catalog entry is a group.
   * @param {boolean} [params.active] - Boolean value that describes whether the service is active.
   * @param {ObjectMetadataSet} [params.metadata] - Model used to describe metadata object that can be set.
   * @param {string} [params.account] - This changes the scope of the request regardless of the authorization header.
   * Example scopes are `account` and `global`. `account=global` is reqired if operating with a service ID that has a
   * global admin policy, for example `GET /?account=global`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<GlobalCatalogV1.Response<GlobalCatalogV1.CatalogEntry>>}
   */
  public createCatalogEntry(params: GlobalCatalogV1.CreateCatalogEntryParams): Promise<GlobalCatalogV1.Response<GlobalCatalogV1.CatalogEntry>> {
    const _params = extend({}, params);
    const requiredParams = ['name', 'kind', 'overviewUi', 'images', 'tags', 'provider', 'id'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const body = {
        'name': _params.name,
        'kind': _params.kind,
        'overview_ui': _params.overviewUi,
        'images': _params.images,
        'disabled': _params.disabled,
        'tags': _params.tags,
        'provider': _params.provider,
        'id': _params.id,
        'parent_id': _params.parentId,
        'group': _params.group,
        'active': _params.active,
        'metadata': _params.metadata
      };

      const query = {
        'account': _params.account
      };

      const sdkHeaders = getSdkHeaders(GlobalCatalogV1.DEFAULT_SERVICE_NAME, 'v1', 'createCatalogEntry');

      const parameters = {
        options: {
          url: '/',
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
   * Get a specific catalog object.
   *
   * This endpoint returns a specific catalog entry using the object's unique identifier, for example
   * `/_*service_name*?complete=true`. This endpoint is ETag enabled.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The catalog entry's unqiue ID.
   * @param {string} [params.account] - This changes the scope of the request regardless of the authorization header.
   * Example scopes are `account` and `global`. `account=global` is reqired if operating with a service ID that has a
   * global admin policy, for example `GET /?account=global`.
   * @param {string} [params.include] - A GET call by default returns a basic set of properties. To include other
   * properties, you must add this parameter. A wildcard (`*`) includes all properties for an object, for example `GET
   * /id?include=*`. To include specific metadata fields, separate each field with a colon (:), for example `GET
   * /id?include=metadata.ui:metadata.pricing`.
   * @param {string} [params.languages] - Return the data strings in the specified langauge. By default the strings
   * returned are of the language preferred by your browser through the Accept-Langauge header, which allows an override
   * of the header. Languages are specified in standard form, such as `en-us`. To include all languages use a wildcard
   * (*).
   * @param {string} [params.complete] - Returns all available fields for all languages. Use the value `?complete=true`
   * as shortcut for ?include=*&languages=*.
   * @param {number} [params.depth] - Return the children down to the requested depth. Use * to include the entire
   * children tree. If there are more children than the maximum permitted an error will be returned. Be judicious with
   * this as it can cause a large number of database accesses and can result in a large amount of data returned.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<GlobalCatalogV1.Response<GlobalCatalogV1.CatalogEntry>>}
   */
  public getCatalogEntry(params: GlobalCatalogV1.GetCatalogEntryParams): Promise<GlobalCatalogV1.Response<GlobalCatalogV1.CatalogEntry>> {
    const _params = extend({}, params);
    const requiredParams = ['id'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'account': _params.account,
        'include': _params.include,
        'languages': _params.languages,
        'complete': _params.complete,
        'depth': _params.depth
      };

      const path = {
        'id': _params.id
      };

      const sdkHeaders = getSdkHeaders(GlobalCatalogV1.DEFAULT_SERVICE_NAME, 'v1', 'getCatalogEntry');

      const parameters = {
        options: {
          url: '/{id}',
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
   * Update a catalog entry.
   *
   * Update a catalog entry. The visibility of the catalog entry cannot be modified with this endpoint. You must be an
   * administrator or editor in the scope of the provided token. This endpoint is ETag enabled.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The object's unique ID.
   * @param {string} params.name - Programmatic name for this catalog entry, which must be formatted like a CRN segment.
   * See the display name in OverviewUI for a user-readable name.
   * @param {string} params.kind - The type of catalog entry, **service**, **template**, **dashboard**, which determines
   * the type and shape of the object.
   * @param {OverviewUI} params.overviewUi - Overview is nested in the top level. The key value pair is
   * `[_language_]overview_ui`.
   * @param {Image} params.images - Image annotation for this catalog entry. The image is a URL.
   * @param {boolean} params.disabled - Boolean value that determines the global visibility for the catalog entry, and
   * its children. If it is not enabled, all plans are disabled.
   * @param {string[]} params.tags - A list of tags. For example, IBM, 3rd Party, Beta, GA, and Single Tenant.
   * @param {Provider} params.provider - Information related to the provider associated with a catalog entry.
   * @param {string} [params.parentId] - The ID of the parent catalog entry if it exists.
   * @param {boolean} [params.group] - Boolean value that determines whether the catalog entry is a group.
   * @param {boolean} [params.active] - Boolean value that describes whether the service is active.
   * @param {ObjectMetadataSet} [params.metadata] - Model used to describe metadata object that can be set.
   * @param {string} [params.account] - This changes the scope of the request regardless of the authorization header.
   * Example scopes are `account` and `global`. `account=global` is reqired if operating with a service ID that has a
   * global admin policy, for example `GET /?account=global`.
   * @param {string} [params.move] - Reparenting object. In the body set the parent_id to a different parent. Or remove
   * the parent_id field to reparent to the root of the catalog. If this is not set to 'true' then changing the
   * parent_id in the body of the request will not be permitted. If this is 'true' and no change to parent_id then this
   * is also error. This is to prevent accidental changing of parent.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<GlobalCatalogV1.Response<GlobalCatalogV1.CatalogEntry>>}
   */
  public updateCatalogEntry(params: GlobalCatalogV1.UpdateCatalogEntryParams): Promise<GlobalCatalogV1.Response<GlobalCatalogV1.CatalogEntry>> {
    const _params = extend({}, params);
    const requiredParams = ['id', 'name', 'kind', 'overviewUi', 'images', 'tags', 'provider'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const body = {
        'name': _params.name,
        'kind': _params.kind,
        'overview_ui': _params.overviewUi,
        'images': _params.images,
        'disabled': _params.disabled,
        'tags': _params.tags,
        'provider': _params.provider,
        'parent_id': _params.parentId,
        'group': _params.group,
        'active': _params.active,
        'metadata': _params.metadata
      };

      const query = {
        'account': _params.account,
        'move': _params.move
      };

      const path = {
        'id': _params.id
      };

      const sdkHeaders = getSdkHeaders(GlobalCatalogV1.DEFAULT_SERVICE_NAME, 'v1', 'updateCatalogEntry');

      const parameters = {
        options: {
          url: '/{id}',
          method: 'PUT',
          body,
          qs: query,
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
   * Delete a catalog entry.
   *
   * Delete a catalog entry. This will archive the catalog entry for a minimum of two weeks. While archived, it can be
   * restored using the PUT restore API. After two weeks, it will be deleted and cannot be restored. You must have
   * administrator role in the scope of the provided token to modify it. This endpoint is ETag enabled.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The object's unique ID.
   * @param {string} [params.account] - This changes the scope of the request regardless of the authorization header.
   * Example scopes are `account` and `global`. `account=global` is reqired if operating with a service ID that has a
   * global admin policy, for example `GET /?account=global`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<GlobalCatalogV1.Response<GlobalCatalogV1.Empty>>}
   */
  public deleteCatalogEntry(params: GlobalCatalogV1.DeleteCatalogEntryParams): Promise<GlobalCatalogV1.Response<GlobalCatalogV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['id'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'account': _params.account
      };

      const path = {
        'id': _params.id
      };

      const sdkHeaders = getSdkHeaders(GlobalCatalogV1.DEFAULT_SERVICE_NAME, 'v1', 'deleteCatalogEntry');

      const parameters = {
        options: {
          url: '/{id}',
          method: 'DELETE',
          qs: query,
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

  /**
   * Get child catalog entries of a specific kind.
   *
   * Fetch child catalog entries for a catalog entry with a specific id. This endpoint is ETag enabled.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The parent catalog entry's ID.
   * @param {string} params.kind - The **kind** of child catalog entries to search for. A wildcard (*) includes all
   * child catalog entries for all kinds, for example `GET /service_name/_*`.
   * @param {string} [params.account] - This changes the scope of the request regardless of the authorization header.
   * Example scopes are `account` and `global`. `account=global` is reqired if operating with a service ID that has a
   * global admin policy, for example `GET /?account=global`.
   * @param {string} [params.include] - A colon (:) separated list of properties to include. A GET call by defaults
   * return a limited set of properties. To include other properties, you must add the include parameter.  A wildcard
   * (*) includes all properties.
   * @param {string} [params.q] - A query filter, for example, `q=kind:iaas IBM`  will filter on entries of **kind**
   * iaas that has `IBM` in their name, display name, or description.
   * @param {string} [params.sortBy] - The field on which to sort the output. By default by name. Available fields are
   * **name**, **kind**, and **provider**.
   * @param {string} [params.descending] - The sort order. The default is false, which is ascending.
   * @param {string} [params.languages] - Return the data strings in the specified langauge. By default the strings
   * returned are of the language preferred by your browser through the Accept-Langauge header. This allows an override
   * of the header. Languages are specified in standard form, such as `en-us`. To include all languages use the wildcard
   * (*).
   * @param {string} [params.complete] - Use the value `?complete=true` as shortcut for ?include=*&languages=*.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<GlobalCatalogV1.Response<GlobalCatalogV1.SearchResult[]>>}
   */
  public getChildObjects(params: GlobalCatalogV1.GetChildObjectsParams): Promise<GlobalCatalogV1.Response<GlobalCatalogV1.SearchResult[]>> {
    const _params = extend({}, params);
    const requiredParams = ['id', 'kind'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'account': _params.account,
        'include': _params.include,
        'q': _params.q,
        'sort-by': _params.sortBy,
        'descending': _params.descending,
        'languages': _params.languages,
        'complete': _params.complete
      };

      const path = {
        'id': _params.id,
        'kind': _params.kind
      };

      const sdkHeaders = getSdkHeaders(GlobalCatalogV1.DEFAULT_SERVICE_NAME, 'v1', 'getChildObjects');

      const parameters = {
        options: {
          url: '/{id}/{kind}',
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
   * Restore archived catalog entry.
   *
   * Restore an archived catalog entry. You must have an administrator role in the scope of the provided token.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The catalog entry's unique ID.
   * @param {string} [params.account] - This changes the scope of the request regardless of the authorization header.
   * Example scopes are `account` and `global`. `account=global` is reqired if operating with a service ID that has a
   * global admin policy, for example `GET /?account=global`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<GlobalCatalogV1.Response<GlobalCatalogV1.Empty>>}
   */
  public restoreCatalogEntry(params: GlobalCatalogV1.RestoreCatalogEntryParams): Promise<GlobalCatalogV1.Response<GlobalCatalogV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['id'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'account': _params.account
      };

      const path = {
        'id': _params.id
      };

      const sdkHeaders = getSdkHeaders(GlobalCatalogV1.DEFAULT_SERVICE_NAME, 'v1', 'restoreCatalogEntry');

      const parameters = {
        options: {
          url: '/{id}/restore',
          method: 'PUT',
          qs: query,
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
   * visibility
   ************************/

  /**
   * Get the visibility constraints for an object.
   *
   * This endpoint returns the visibility rules for this object. Overall visibility is determined by the parent objects
   * and any further restrictions on this object. You must have an administrator role in the scope of the provided
   * token. This endpoint is ETag enabled.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The object's unique ID.
   * @param {string} [params.account] - This changes the scope of the request regardless of the authorization header.
   * Example scopes are `account` and `global`. `account=global` is reqired if operating with a service ID that has a
   * global admin policy, for example `GET /?account=global`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<GlobalCatalogV1.Response<GlobalCatalogV1.Visibility>>}
   */
  public getVisibility(params: GlobalCatalogV1.GetVisibilityParams): Promise<GlobalCatalogV1.Response<GlobalCatalogV1.Visibility>> {
    const _params = extend({}, params);
    const requiredParams = ['id'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'account': _params.account
      };

      const path = {
        'id': _params.id
      };

      const sdkHeaders = getSdkHeaders(GlobalCatalogV1.DEFAULT_SERVICE_NAME, 'v1', 'getVisibility');

      const parameters = {
        options: {
          url: '/{id}/visibility',
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
   * Update visibility.
   *
   * Update an Object's Visibility. You must have an administrator role in the scope of the provided token. This
   * endpoint is ETag enabled.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The object's unique ID.
   * @param {VisibilityDetail} [params.include] - Visibility details related to a catalog entry.
   * @param {VisibilityDetail} [params.exclude] - Visibility details related to a catalog entry.
   * @param {string} [params.account] - This changes the scope of the request regardless of the authorization header.
   * Example scopes are `account` and `global`. `account=global` is reqired if operating with a service ID that has a
   * global admin policy, for example `GET /?account=global`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<GlobalCatalogV1.Response<GlobalCatalogV1.Empty>>}
   */
  public updateVisibility(params: GlobalCatalogV1.UpdateVisibilityParams): Promise<GlobalCatalogV1.Response<GlobalCatalogV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['id'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const body = {
        'include': _params.include,
        'exclude': _params.exclude
      };

      const query = {
        'account': _params.account
      };

      const path = {
        'id': _params.id
      };

      const sdkHeaders = getSdkHeaders(GlobalCatalogV1.DEFAULT_SERVICE_NAME, 'v1', 'updateVisibility');

      const parameters = {
        options: {
          url: '/{id}/visibility',
          method: 'PUT',
          body,
          qs: query,
          path,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
            'Content-Type': 'application/json',
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /*************************
   * pricing
   ************************/

  /**
   * Get the pricing for an object.
   *
   * This endpoint returns the pricing for an object. Static pricing is defined in the catalog. Dynamic pricing is
   * stored in Bluemix Pricing Catalog.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The object's unique ID.
   * @param {string} [params.account] - This changes the scope of the request regardless of the authorization header.
   * Example scopes are `account` and `global`. `account=global` is reqired if operating with a service ID that has a
   * global admin policy, for example `GET /?account=global`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<GlobalCatalogV1.Response<GlobalCatalogV1.PricingGet>>}
   */
  public getPricing(params: GlobalCatalogV1.GetPricingParams): Promise<GlobalCatalogV1.Response<GlobalCatalogV1.PricingGet>> {
    const _params = extend({}, params);
    const requiredParams = ['id'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'account': _params.account
      };

      const path = {
        'id': _params.id
      };

      const sdkHeaders = getSdkHeaders(GlobalCatalogV1.DEFAULT_SERVICE_NAME, 'v1', 'getPricing');

      const parameters = {
        options: {
          url: '/{id}/pricing',
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

  /*************************
   * audit
   ************************/

  /**
   * Get the audit logs for an object.
   *
   * This endpoint returns the audit logs for an object. Only administrators and editors can get logs.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.id - The object's unique ID.
   * @param {string} [params.account] - This changes the scope of the request regardless of the authorization header.
   * Example scopes are `account` and `global`. `account=global` is reqired if operating with a service ID that has a
   * global admin policy, for example `GET /?account=global`.
   * @param {string} [params.ascending] - Sets the sort order. False is descending.
   * @param {string} [params.startat] - Starting time for the logs. If it's descending then the entries will be equal or
   * earlier. The default is latest. For ascending it will entries equal or later. The default is earliest. It can be
   * either a number or a string. If a number then it is in the format of Unix timestamps. If it is a string then it is
   * a date in the format YYYY-MM-DDTHH:MM:SSZ  and the time is UTC. The T and the Z are required. For example:
   * 2017-12-24T12:00:00Z for Noon UTC on Dec 24, 2017.
   * @param {number} [params.offset] - Count of number of log entries to skip before returning logs. The default is
   * zero.
   * @param {number} [params.limit] - Count of number of entries to return. The default is fifty. The maximum value is
   * two hundred.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<GlobalCatalogV1.Response<GlobalCatalogV1.SearchResult>>}
   */
  public getAuditLogs(params: GlobalCatalogV1.GetAuditLogsParams): Promise<GlobalCatalogV1.Response<GlobalCatalogV1.SearchResult>> {
    const _params = extend({}, params);
    const requiredParams = ['id'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'account': _params.account,
        'ascending': _params.ascending,
        'startat': _params.startat,
        '_offset': _params.offset,
        '_limit': _params.limit
      };

      const path = {
        'id': _params.id
      };

      const sdkHeaders = getSdkHeaders(GlobalCatalogV1.DEFAULT_SERVICE_NAME, 'v1', 'getAuditLogs');

      const parameters = {
        options: {
          url: '/{id}/logs',
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

  /*************************
   * artifact
   ************************/

  /**
   * Get artifacts.
   *
   * This endpoint returns a list of artifacts for an object.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.objectId - The object's unique ID.
   * @param {string} [params.account] - This changes the scope of the request regardless of the authorization header.
   * Example scopes are `account` and `global`. `account=global` is reqired if operating with a service ID that has a
   * global admin policy, for example `GET /?account=global`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<GlobalCatalogV1.Response<GlobalCatalogV1.Artifacts>>}
   */
  public listArtifacts(params: GlobalCatalogV1.ListArtifactsParams): Promise<GlobalCatalogV1.Response<GlobalCatalogV1.Artifacts>> {
    const _params = extend({}, params);
    const requiredParams = ['objectId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'account': _params.account
      };

      const path = {
        'object_id': _params.objectId
      };

      const sdkHeaders = getSdkHeaders(GlobalCatalogV1.DEFAULT_SERVICE_NAME, 'v1', 'listArtifacts');

      const parameters = {
        options: {
          url: '/{object_id}/artifacts',
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
   * Get artifact.
   *
   * This endpoint returns the binary of an artifact.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.objectId - The object's unique ID.
   * @param {string} params.artifactId - The artifact's ID.
   * @param {string} [params.account] - This changes the scope of the request regardless of the authorization header.
   * Example scopes are `account` and `global`. `account=global` is reqired if operating with a service ID that has a
   * global admin policy, for example `GET /?account=global`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<GlobalCatalogV1.Response<GlobalCatalogV1.Empty>>}
   */
  public getArtifact(params: GlobalCatalogV1.GetArtifactParams): Promise<GlobalCatalogV1.Response<GlobalCatalogV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['objectId', 'artifactId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'account': _params.account
      };

      const path = {
        'object_id': _params.objectId,
        'artifact_id': _params.artifactId
      };

      const sdkHeaders = getSdkHeaders(GlobalCatalogV1.DEFAULT_SERVICE_NAME, 'v1', 'getArtifact');

      const parameters = {
        options: {
          url: '/{object_id}/artifacts/{artifact_id}',
          method: 'GET',
          qs: query,
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

  /**
   * Upload artifact.
   *
   * This endpoint uploads the binary for an artifact. Only administrators and editors can upload artifacts.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.objectId - The object's unique ID.
   * @param {string} params.artifactId - The artifact's ID.
   * @param {NodeJS.ReadableStream|Buffer} [params.artifact] -
   * @param {string} [params.contentType] - The type of the input.
   * @param {string} [params.account] - This changes the scope of the request regardless of the authorization header.
   * Example scopes are `account` and `global`. `account=global` is reqired if operating with a service ID that has a
   * global admin policy, for example `GET /?account=global`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<GlobalCatalogV1.Response<GlobalCatalogV1.Empty>>}
   */
  public uploadArtifact(params: GlobalCatalogV1.UploadArtifactParams): Promise<GlobalCatalogV1.Response<GlobalCatalogV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['objectId', 'artifactId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const body = _params.artifact;
      const query = {
        'account': _params.account
      };

      const path = {
        'object_id': _params.objectId,
        'artifact_id': _params.artifactId
      };

      const sdkHeaders = getSdkHeaders(GlobalCatalogV1.DEFAULT_SERVICE_NAME, 'v1', 'uploadArtifact');

      const parameters = {
        options: {
          url: '/{object_id}/artifacts/{artifact_id}',
          method: 'PUT',
          body,
          qs: query,
          path,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
            'Content-Type': _params.contentType
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /**
   * Delete artifact.
   *
   * This endpoint deletes an artifact. Only administrators and editors can delete artifacts.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.objectId - The object's unique ID.
   * @param {string} params.artifactId - The artifact's ID.
   * @param {string} [params.account] - This changes the scope of the request regardless of the authorization header.
   * Example scopes are `account` and `global`. `account=global` is reqired if operating with a service ID that has a
   * global admin policy, for example `GET /?account=global`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<GlobalCatalogV1.Response<GlobalCatalogV1.Empty>>}
   */
  public deleteArtifact(params: GlobalCatalogV1.DeleteArtifactParams): Promise<GlobalCatalogV1.Response<GlobalCatalogV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['objectId', 'artifactId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'account': _params.account
      };

      const path = {
        'object_id': _params.objectId,
        'artifact_id': _params.artifactId
      };

      const sdkHeaders = getSdkHeaders(GlobalCatalogV1.DEFAULT_SERVICE_NAME, 'v1', 'deleteArtifact');

      const parameters = {
        options: {
          url: '/{object_id}/artifacts/{artifact_id}',
          method: 'DELETE',
          qs: query,
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

}

/*************************
 * interfaces
 ************************/

namespace GlobalCatalogV1 {

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

  /** Parameters for the `listCatalogEntries` operation. */
  export interface ListCatalogEntriesParams {
    /** This changes the scope of the request regardless of the authorization header. Example scopes are `account`
     *  and `global`. `account=global` is reqired if operating with a service ID that has a global admin policy, for
     *  example `GET /?account=global`.
     */
    account?: string;
    /** A GET call by default returns a basic set of properties. To include other properties, you must add this
     *  parameter. A wildcard (`*`) includes all properties for an object, for example `GET /?include=*`. To include
     *  specific metadata fields, separate each field with a colon (:), for example `GET
     *  /?include=metadata.ui:metadata.pricing`.
     */
    include?: string;
    /** Searches the catalog entries for keywords. Add filters to refine your search. A query filter, for example,
     *  `q=kind:iaas service_name rc:true`, filters entries of kind iaas with metadata.service.rc_compatible set to true
     *  and  have a service name is in their name, display name, or description.  Valid tags are **kind**:<string>,
     *  **tag**:<strging>, **rc**:[true|false], **iam**:[true|false], **active**:[true|false], **geo**:<string>, and
     *  **price**:<string>.
     */
    q?: string;
    /** The field on which the output is sorted. Sorts by default by **name** property. Available fields are
     *  **name**, **displayname** (overview_ui.display_name), **kind**, **provider** (provider.name), **sbsindex**
     *  (metadata.ui.side_by_side_index), and the time **created**, and **updated**.
     */
    sortBy?: string;
    /** Sets the sort order. The default is false, which is ascending. */
    descending?: string;
    /** Return the data strings in a specified langauge. By default, the strings returned are of the language
     *  preferred by your browser through the Accept-Langauge header, which allows an override of the header. Languages
     *  are specified in standard form, such as `en-us`. To include all languages use a wildcard (*).
     */
    languages?: string;
    /** Returns all available fields for all languages. Use the value `?complete=true` as shortcut for
     *  ?include=*&languages=*.
     */
    complete?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `createCatalogEntry` operation. */
  export interface CreateCatalogEntryParams {
    /** Programmatic name for this catalog entry, which must be formatted like a CRN segment. See the display name
     *  in OverviewUI for a user-readable name.
     */
    name: string;
    /** The type of catalog entry, **service**, **template**, **dashboard**, which determines the type and shape of
     *  the object.
     */
    kind: CreateCatalogEntryConstants.Kind | string;
    /** Overview is nested in the top level. The key value pair is `[_language_]overview_ui`. */
    overviewUi: OverviewUI;
    /** Image annotation for this catalog entry. The image is a URL. */
    images: Image;
    /** Boolean value that determines the global visibility for the catalog entry, and its children. If it is not
     *  enabled, all plans are disabled.
     */
    disabled: boolean;
    /** A list of tags. For example, IBM, 3rd Party, Beta, GA, and Single Tenant. */
    tags: string[];
    /** Information related to the provider associated with a catalog entry. */
    provider: Provider;
    /** Catalog entry's unique ID. It's the same across all catalog instances. */
    id: string;
    /** The ID of the parent catalog entry if it exists. */
    parentId?: string;
    /** Boolean value that determines whether the catalog entry is a group. */
    group?: boolean;
    /** Boolean value that describes whether the service is active. */
    active?: boolean;
    /** Model used to describe metadata object that can be set. */
    metadata?: ObjectMetadataSet;
    /** This changes the scope of the request regardless of the authorization header. Example scopes are `account`
     *  and `global`. `account=global` is reqired if operating with a service ID that has a global admin policy, for
     *  example `GET /?account=global`.
     */
    account?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Constants for the `createCatalogEntry` operation. */
  export namespace CreateCatalogEntryConstants {
    /** The type of catalog entry, **service**, **template**, **dashboard**, which determines the type and shape of the object. */
    export enum Kind {
      SERVICE = 'service',
      TEMPLATE = 'template',
      DASHBOARD = 'dashboard',
    }
  }

  /** Parameters for the `getCatalogEntry` operation. */
  export interface GetCatalogEntryParams {
    /** The catalog entry's unqiue ID. */
    id: string;
    /** This changes the scope of the request regardless of the authorization header. Example scopes are `account`
     *  and `global`. `account=global` is reqired if operating with a service ID that has a global admin policy, for
     *  example `GET /?account=global`.
     */
    account?: string;
    /** A GET call by default returns a basic set of properties. To include other properties, you must add this
     *  parameter. A wildcard (`*`) includes all properties for an object, for example `GET /id?include=*`. To include
     *  specific metadata fields, separate each field with a colon (:), for example `GET
     *  /id?include=metadata.ui:metadata.pricing`.
     */
    include?: string;
    /** Return the data strings in the specified langauge. By default the strings returned are of the language
     *  preferred by your browser through the Accept-Langauge header, which allows an override of the header. Languages
     *  are specified in standard form, such as `en-us`. To include all languages use a wildcard (*).
     */
    languages?: string;
    /** Returns all available fields for all languages. Use the value `?complete=true` as shortcut for
     *  ?include=*&languages=*.
     */
    complete?: string;
    /** Return the children down to the requested depth. Use * to include the entire children tree. If there are
     *  more children than the maximum permitted an error will be returned. Be judicious with this as it can cause a
     *  large number of database accesses and can result in a large amount of data returned.
     */
    depth?: number;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `updateCatalogEntry` operation. */
  export interface UpdateCatalogEntryParams {
    /** The object's unique ID. */
    id: string;
    /** Programmatic name for this catalog entry, which must be formatted like a CRN segment. See the display name
     *  in OverviewUI for a user-readable name.
     */
    name: string;
    /** The type of catalog entry, **service**, **template**, **dashboard**, which determines the type and shape of
     *  the object.
     */
    kind: UpdateCatalogEntryConstants.Kind | string;
    /** Overview is nested in the top level. The key value pair is `[_language_]overview_ui`. */
    overviewUi: OverviewUI;
    /** Image annotation for this catalog entry. The image is a URL. */
    images: Image;
    /** Boolean value that determines the global visibility for the catalog entry, and its children. If it is not
     *  enabled, all plans are disabled.
     */
    disabled: boolean;
    /** A list of tags. For example, IBM, 3rd Party, Beta, GA, and Single Tenant. */
    tags: string[];
    /** Information related to the provider associated with a catalog entry. */
    provider: Provider;
    /** The ID of the parent catalog entry if it exists. */
    parentId?: string;
    /** Boolean value that determines whether the catalog entry is a group. */
    group?: boolean;
    /** Boolean value that describes whether the service is active. */
    active?: boolean;
    /** Model used to describe metadata object that can be set. */
    metadata?: ObjectMetadataSet;
    /** This changes the scope of the request regardless of the authorization header. Example scopes are `account`
     *  and `global`. `account=global` is reqired if operating with a service ID that has a global admin policy, for
     *  example `GET /?account=global`.
     */
    account?: string;
    /** Reparenting object. In the body set the parent_id to a different parent. Or remove the parent_id field to
     *  reparent to the root of the catalog. If this is not set to 'true' then changing the parent_id in the body of the
     *  request will not be permitted. If this is 'true' and no change to parent_id then this is also error. This is to
     *  prevent accidental changing of parent.
     */
    move?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Constants for the `updateCatalogEntry` operation. */
  export namespace UpdateCatalogEntryConstants {
    /** The type of catalog entry, **service**, **template**, **dashboard**, which determines the type and shape of the object. */
    export enum Kind {
      SERVICE = 'service',
      TEMPLATE = 'template',
      DASHBOARD = 'dashboard',
    }
  }

  /** Parameters for the `deleteCatalogEntry` operation. */
  export interface DeleteCatalogEntryParams {
    /** The object's unique ID. */
    id: string;
    /** This changes the scope of the request regardless of the authorization header. Example scopes are `account`
     *  and `global`. `account=global` is reqired if operating with a service ID that has a global admin policy, for
     *  example `GET /?account=global`.
     */
    account?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getChildObjects` operation. */
  export interface GetChildObjectsParams {
    /** The parent catalog entry's ID. */
    id: string;
    /** The **kind** of child catalog entries to search for. A wildcard (*) includes all child catalog entries for
     *  all kinds, for example `GET /service_name/_*`.
     */
    kind: string;
    /** This changes the scope of the request regardless of the authorization header. Example scopes are `account`
     *  and `global`. `account=global` is reqired if operating with a service ID that has a global admin policy, for
     *  example `GET /?account=global`.
     */
    account?: string;
    /** A colon (:) separated list of properties to include. A GET call by defaults return a limited set of
     *  properties. To include other properties, you must add the include parameter.  A wildcard (*) includes all
     *  properties.
     */
    include?: string;
    /** A query filter, for example, `q=kind:iaas IBM`  will filter on entries of **kind** iaas that has `IBM` in
     *  their name, display name, or description.
     */
    q?: string;
    /** The field on which to sort the output. By default by name. Available fields are **name**, **kind**, and
     *  **provider**.
     */
    sortBy?: string;
    /** The sort order. The default is false, which is ascending. */
    descending?: string;
    /** Return the data strings in the specified langauge. By default the strings returned are of the language
     *  preferred by your browser through the Accept-Langauge header. This allows an override of the header. Languages
     *  are specified in standard form, such as `en-us`. To include all languages use the wildcard (*).
     */
    languages?: string;
    /** Use the value `?complete=true` as shortcut for ?include=*&languages=*. */
    complete?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `restoreCatalogEntry` operation. */
  export interface RestoreCatalogEntryParams {
    /** The catalog entry's unique ID. */
    id: string;
    /** This changes the scope of the request regardless of the authorization header. Example scopes are `account`
     *  and `global`. `account=global` is reqired if operating with a service ID that has a global admin policy, for
     *  example `GET /?account=global`.
     */
    account?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getVisibility` operation. */
  export interface GetVisibilityParams {
    /** The object's unique ID. */
    id: string;
    /** This changes the scope of the request regardless of the authorization header. Example scopes are `account`
     *  and `global`. `account=global` is reqired if operating with a service ID that has a global admin policy, for
     *  example `GET /?account=global`.
     */
    account?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `updateVisibility` operation. */
  export interface UpdateVisibilityParams {
    /** The object's unique ID. */
    id: string;
    /** Visibility details related to a catalog entry. */
    include?: VisibilityDetail;
    /** Visibility details related to a catalog entry. */
    exclude?: VisibilityDetail;
    /** This changes the scope of the request regardless of the authorization header. Example scopes are `account`
     *  and `global`. `account=global` is reqired if operating with a service ID that has a global admin policy, for
     *  example `GET /?account=global`.
     */
    account?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getPricing` operation. */
  export interface GetPricingParams {
    /** The object's unique ID. */
    id: string;
    /** This changes the scope of the request regardless of the authorization header. Example scopes are `account`
     *  and `global`. `account=global` is reqired if operating with a service ID that has a global admin policy, for
     *  example `GET /?account=global`.
     */
    account?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getAuditLogs` operation. */
  export interface GetAuditLogsParams {
    /** The object's unique ID. */
    id: string;
    /** This changes the scope of the request regardless of the authorization header. Example scopes are `account`
     *  and `global`. `account=global` is reqired if operating with a service ID that has a global admin policy, for
     *  example `GET /?account=global`.
     */
    account?: string;
    /** Sets the sort order. False is descending. */
    ascending?: string;
    /** Starting time for the logs. If it's descending then the entries will be equal or earlier. The default is
     *  latest. For ascending it will entries equal or later. The default is earliest. It can be either a number or a
     *  string. If a number then it is in the format of Unix timestamps. If it is a string then it is a date in the
     *  format YYYY-MM-DDTHH:MM:SSZ  and the time is UTC. The T and the Z are required. For example:
     *  2017-12-24T12:00:00Z for Noon UTC on Dec 24, 2017.
     */
    startat?: string;
    /** Count of number of log entries to skip before returning logs. The default is zero. */
    offset?: number;
    /** Count of number of entries to return. The default is fifty. The maximum value is two hundred. */
    limit?: number;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listArtifacts` operation. */
  export interface ListArtifactsParams {
    /** The object's unique ID. */
    objectId: string;
    /** This changes the scope of the request regardless of the authorization header. Example scopes are `account`
     *  and `global`. `account=global` is reqired if operating with a service ID that has a global admin policy, for
     *  example `GET /?account=global`.
     */
    account?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getArtifact` operation. */
  export interface GetArtifactParams {
    /** The object's unique ID. */
    objectId: string;
    /** The artifact's ID. */
    artifactId: string;
    /** This changes the scope of the request regardless of the authorization header. Example scopes are `account`
     *  and `global`. `account=global` is reqired if operating with a service ID that has a global admin policy, for
     *  example `GET /?account=global`.
     */
    account?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `uploadArtifact` operation. */
  export interface UploadArtifactParams {
    /** The object's unique ID. */
    objectId: string;
    /** The artifact's ID. */
    artifactId: string;
    artifact?: NodeJS.ReadableStream|Buffer;
    /** The type of the input. */
    contentType?: string;
    /** This changes the scope of the request regardless of the authorization header. Example scopes are `account`
     *  and `global`. `account=global` is reqired if operating with a service ID that has a global admin policy, for
     *  example `GET /?account=global`.
     */
    account?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deleteArtifact` operation. */
  export interface DeleteArtifactParams {
    /** The object's unique ID. */
    objectId: string;
    /** The artifact's ID. */
    artifactId: string;
    /** This changes the scope of the request regardless of the authorization header. Example scopes are `account`
     *  and `global`. `account=global` is reqired if operating with a service ID that has a global admin policy, for
     *  example `GET /?account=global`.
     */
    account?: string;
    headers?: OutgoingHttpHeaders;
  }

  /*************************
   * model interfaces
   ************************/

  /** Country-specific pricing information. */
  export interface Amount {
    /** Country. */
    counrty?: string;
    /** Currency. */
    currency?: string;
    /** See Price for nested fields. */
    prices?: Price[];
  }

  /** Artifact Details. */
  export interface Artifact {
    /** The name of the artifact. */
    name?: string;
    /** The timestamp of the last update to the artifact. */
    updated?: string;
    /** The url for the artifact. */
    url?: string;
    /** The etag of the artifact. */
    etag?: string;
    /** The content length of the artifact. */
    size?: number;
  }

  /** Artifacts List. */
  export interface Artifacts {
    /** The total number of artifacts. */
    count?: number;
    /** The list of artifacts. */
    resources?: Artifact[];
  }

  /** Information related to list delimiters. */
  export interface Bullets {
    /** The bullet title. */
    title?: string;
    /** The bullet description. */
    description?: string;
    /** The icon to use for rendering the bullet. */
    icon?: string;
    /** The bullet quantity. */
    quantity?: string;
  }

  /** Callback-related information associated with a catalog entry. */
  export interface Callbacks {
    /** The URL of the deployment broker. */
    broker_utl?: string;
    /** The URL of the deployment broker SC proxy. */
    broker_proxy_url?: string;
    /** The URL of dashboard callback. */
    dashboard_url?: string;
    /** The URL of dashboard data. */
    dashboard_data_url?: string;
    /** The URL of the dashboard detail tab. */
    dashboard_detail_tab_url?: string;
    /** The URL of the dashboard detail tab extension. */
    dashboard_detail_tab_ext_url?: string;
    /** Service monitor API URL. */
    service_monitor_api?: string;
    /** Service monitor app URL. */
    service_monitor_app?: string;
    /** Service URL in staging. */
    service_staging_url?: string;
    /** Service URL in production. */
    service_production_url?: string;
  }

  /** An entry in the global catalog. */
  export interface CatalogEntry {
    /** Programmatic name for this catalog entry, which must be formatted like a CRN segment. See the display name
     *  in OverviewUI for a user-readable name.
     */
    name: string;
    /** The type of catalog entry, **service**, **template**, **dashboard**, which determines the type and shape of
     *  the object.
     */
    kind: string;
    /** Overview is nested in the top level. The key value pair is `[_language_]overview_ui`. */
    overview_ui: OverviewUI;
    /** Image annotation for this catalog entry. The image is a URL. */
    images: Image;
    /** The ID of the parent catalog entry if it exists. */
    parent_id?: string;
    /** Boolean value that determines the global visibility for the catalog entry, and its children. If it is not
     *  enabled, all plans are disabled.
     */
    disabled: boolean;
    /** A list of tags. For example, IBM, 3rd Party, Beta, GA, and Single Tenant. */
    tags: string[];
    /** Boolean value that determines whether the catalog entry is a group. */
    group?: boolean;
    /** Information related to the provider associated with a catalog entry. */
    provider: Provider;
    /** Boolean value that describes whether the service is active. */
    active?: boolean;
    /** Model used to describe metadata object that can be set. */
    metadata?: ObjectMetadataSet;
    /** Catalog entry's unique ID. It's the same across all catalog instances. */
    id?: string;
    catalog_crn?: any;
    url?: any;
    children_url?: any;
    geo_tags?: any;
    pricing_tags?: any;
    created?: any;
    updated?: any;
  }

  /** Deployment-related metadata. */
  export interface DeploymentBase {
    /** Describes the region where the service is located. */
    location?: string;
    /** A CRN that describes the deployment. crn:v1:[cname]:[ctype]:[location]:[scope]::[resource-type]:[resource]. */
    target_crn?: string;
    /** The broker associated with a catalog entry. */
    broker?: DeploymentBaseBroker;
    /** This deployment not only supports RC but is ready to migrate and support the RC broker for a location. */
    supports_rc_migration?: boolean;
    /** network to use during deployment. */
    target_network?: string;
  }

  /** The broker associated with a catalog entry. */
  export interface DeploymentBaseBroker {
    /** Broker name. */
    name?: string;
    /** Broker guid. */
    guid?: string;
  }

  /** Language specific translation of translation properties, like label and description. */
  export interface I18N {
    /** I18N accepts additional properties. */
    [propName: string]: any;
  }

  /** Image annotation for this catalog entry. The image is a URL. */
  export interface Image {
    /** URL for the large, default image. */
    image: string;
    /** URL for a small image. */
    small_image?: string;
    /** URL for a medium image. */
    medium_image?: string;
    /** URL for a featured image. */
    feature_image?: string;
  }

  /** Plan-specific cost metrics information. */
  export interface Metrics {
    /** The metric ID or part number. */
    metric_id?: string;
    /** The tier model. */
    tier_model?: string;
    /** The charge unit name. */
    charge_unit_name?: string;
    /** The charge unit quantity. */
    charge_unit_quantity?: string;
    /** Display name of the resource. */
    resource_display_name?: string;
    /** Display name of the charge unit. */
    charge_unit_display_name?: string;
    /** Usage limit for the metric. */
    usage_cap_qty?: number;
    /** The pricing per metric by country and currency. */
    amounts?: Amount[];
  }

  /** Alias-related metadata. */
  export interface ObjectMetadataBaseAlias {
    /** Type of alias. */
    type?: string;
    /** Points to the plan that this object is an alias for. */
    plan_id?: string;
  }

  /** Plan-related metadata. */
  export interface ObjectMetadataBasePlan {
    /** Boolean value that describes whether the service can be bound to an application. */
    bindable?: boolean;
    /** Boolean value that describes whether the service can be reserved. */
    reservable?: boolean;
    /** Boolean value that describes whether the service can be used internally. */
    allow_internal_users?: boolean;
    /** Boolean value that describes whether the service can be provisioned asynchronously. */
    async_provisioning_supported?: boolean;
    /** Boolean value that describes whether the service can be unprovisioned asynchronously. */
    async_unprovisioning_supported?: boolean;
    /** Test check interval. */
    test_check_interval?: number;
    /** Single scope instance. */
    single_scope_instance?: string;
    /** Boolean value that describes whether the service check is enabled. */
    service_check_enabled?: boolean;
    /** If the field is imported from Cloud Foundry, the Cloud Foundry region's GUID. This is a required field. For
     *  example, `us-south=123`.
     */
    cf_guid?: string;
  }

  /** Service-related metadata. */
  export interface ObjectMetadataBaseService {
    /** Type of service. */
    type?: string;
    /** Boolean value that describes whether the service is compatible with Identity and Access Management. */
    iam_compatible?: boolean;
    /** Boolean value that describes whether the service has a unique API key. */
    unique_api_key?: boolean;
    /** Boolean value that describes whether the service is provisionable or not. You may need sales or support to
     *  create this service.
     */
    provisionable?: boolean;
    /** Boolean value that describes whether the service supports asynchronous provisioning. */
    async_provisioning_supported?: boolean;
    /** Boolean value that describes whether the service supports asynchronous unprovisioning. */
    async_unprovisioning_supported?: boolean;
    /** If the field is imported from Cloud Foundry, the Cloud Foundry region's GUID. This is a required field. For
     *  example, `us-south=123`.
     */
    cf_guid?: string;
    /** Boolean value that describes whether you can create bindings for this service. */
    bindable?: boolean;
    /** Service dependencies. */
    requires?: string[];
    /** Boolean value that describes whether the service supports upgrade or downgrade for some plans. */
    plan_updateable?: boolean;
    /** String that describes whether the service is active or inactive. */
    state?: string;
    /** Boolean value that describes whether the service check is enabled. */
    service_check_enabled?: boolean;
    /** Test check interval. */
    test_check_interval?: number;
    /** Boolean value that describes whether the service supports service keys. */
    service_key_supported?: boolean;
  }

  /** Service Level Agreement related metadata. */
  export interface ObjectMetadataBaseSla {
    /** Required Service License Agreement Terms of Use. */
    terms?: string;
    /** Required deployment type. Valid values are dedicated, local, or public. It can be Single or Multi tennancy,
     *  more specifically on a Server, VM, Physical, or Pod.
     */
    tenancy?: string;
    /** Provisioning reliability, for example, 99.95. */
    provisioning?: string;
    /** Uptime reliability of the service, for example, 99.95. */
    responsiveness?: string;
    /** SLA Disaster Recovery-related metadata. */
    dr?: ObjectMetadataBaseSlaDr;
  }

  /** SLA Disaster Recovery-related metadata. */
  export interface ObjectMetadataBaseSlaDr {
    /** Required boolean value that describes whether disaster recovery is on. */
    dr?: boolean;
    /** Description of the disaster recovery implementation. */
    description?: string;
  }

  /** Template-related metadata. */
  export interface ObjectMetadataBaseTemplate {
    /** List of required offering or plan IDs. */
    services?: string[];
    /** Cloud Foundry instance memory value. */
    default_memory?: number;
    /** Start Command. */
    start_cmd?: string;
    /** Location of your applications source files. */
    source?: ObjectMetadataBaseTemplateSource;
    /** ID of the runtime. */
    runtime_catalog_id?: string;
    /** ID of the Cloud Foundry runtime. */
    cf_runtime_id?: string;
    /** ID of the boilerplate or template. */
    template_id?: string;
    /** File path to the executable file for the template. */
    executable_file?: string;
    /** ID of the buildpack used by the template. */
    buildpack?: string;
    /** Environment variables for the template. */
    environment_variables?: ObjectMetadataBaseTemplateEnvironmentVariables;
  }

  /** Environment variables for the template. */
  export interface ObjectMetadataBaseTemplateEnvironmentVariables {
    /** Key is the editable first string in a key:value pair of environment variables. */
    key?: string;
  }

  /** Location of your applications source files. */
  export interface ObjectMetadataBaseTemplateSource {
    /** Path to your application. */
    path?: string;
    /** Type of source, for example, git. */
    type?: string;
    /** URL to source. */
    url?: string;
  }

  /** Model used to describe metadata object that can be set. */
  export interface ObjectMetadataSet {
    /** Boolean value that describes whether the service is compatible with the Resource Controller. */
    rc_compatible?: boolean;
    /** Information related to the UI presentation associated with a catalog entry. */
    ui?: UIMetaData;
    /** Compliance information for HIPAA and PCI. */
    compliance?: string[];
    /** Service-related metadata. */
    service?: ObjectMetadataBaseService;
    /** Plan-related metadata. */
    plan?: ObjectMetadataBasePlan;
    /** Template-related metadata. */
    template?: ObjectMetadataBaseTemplate;
    /** Alias-related metadata. */
    alias?: ObjectMetadataBaseAlias;
    /** Service Level Agreement related metadata. */
    sla?: ObjectMetadataBaseSla;
    /** Callback-related information associated with a catalog entry. */
    callbacks?: Callbacks;
    /** Optional version of the object. */
    version?: string;
    /** The original name of the object. */
    original_name?: string;
    /** Additional information. */
    other?: JsonObject;
    /** Pricing-related information. */
    pricing?: PricingSet;
    /** Deployment-related metadata. */
    deployment?: DeploymentBase;
  }

  /** Overview is nested in the top level. The key value pair is `[_language_]overview_ui`. */
  export interface Overview {
    /** The translated display name. */
    display_name: string;
    /** The translated long description. */
    long_description: string;
    /** The translated description. */
    description: string;
  }

  /** Overview is nested in the top level. The key value pair is `[_language_]overview_ui`. */
  export interface OverviewUI {
    /** OverviewUI accepts additional properties. */
    [propName: string]: any;
  }

  /** Pricing-related information. */
  export interface Price {
    /** Pricing tier. */
    quantity_tier?: number;
    /** Price in the selected currency. */
    price?: number;
  }

  /** Pricing-related information. */
  export interface PricingGet {
    /** Type of plan. Valid values are `free`, `trial`, `paygo`, `bluemix-subscription`, and `ibm-subscription`. */
    type?: string;
    /** Defines where the pricing originates. */
    origin?: string;
    /** Plan-specific starting price information. */
    starting_price?: StartingPrice;
    /** Plan-specific cost metric structure. */
    metrics?: Metrics[];
  }

  /** Pricing-related information. */
  export interface PricingSet {
    /** Type of plan. Valid values are `free`, `trial`, `paygo`, `bluemix-subscription`, and `ibm-subscription`. */
    type?: string;
    /** Defines where the pricing originates. */
    origin?: string;
    /** Plan-specific starting price information. */
    starting_price?: StartingPrice;
  }

  /** Information related to the provider associated with a catalog entry. */
  export interface Provider {
    /** Provider's email address for this catalog entry. */
    email: string;
    /** Provider's name, for example, IBM. */
    name: string;
    /** Provider's contact name. */
    contact?: string;
    /** Provider's support email. */
    support_email?: string;
    /** Provider's contact phone. */
    phone?: string;
  }

  /** The results obtained by performing a search. */
  export interface SearchResult {
    /** Returned Page Number. */
    page?: string;
    /** Results Per Page – if the page is full. */
    results_per_page?: string;
    /** Total number of results. */
    total_results?: string;
    /** Resulting objects. */
    resources?: JsonObject[];
  }

  /** Plan-specific starting price information. */
  export interface StartingPrice {
    /** ID of the plan the starting price is calculated. */
    plan_id?: string;
    /** ID of the deployment the starting price is calculated. */
    deployment_id?: string;
    /** The pricing per metric by country and currency. */
    amount?: Amount[];
  }

  /** Information related to a translated text message. */
  export interface Strings {
    /** Presentation information related to list delimiters. */
    bullets?: Bullets[];
    /** Media-related metadata. */
    media?: UIMetaMedia[];
    /** Warning that a message is not creatable. */
    not_creatable_msg?: string;
    /** Warning that a robot message is not creatable. */
    not_creatable_robot_msg?: string;
    /** Warning for deprecation. */
    deprecation_warning?: string;
    /** Popup warning message. */
    popup_warning_message?: string;
    /** Instructions for UI strings. */
    instruction?: string;
  }

  /** Information related to the UI presentation associated with a catalog entry. */
  export interface UIMetaData {
    /** Language specific translation of translation properties, like label and description. */
    strings?: I18N;
    /** UI based URLs. */
    urls?: URLS;
    /** Describes how the embeddable dashboard is rendered. */
    embeddable_dashboard?: string;
    /** Describes whether the embeddable dashboard is rendered at the full width. */
    embeddable_dashboard_full_width?: boolean;
    /** Defines the order of information presented. */
    navigation_order?: string[];
    /** Describes whether this entry is able to be created from the UI element or CLI. */
    not_creatable?: boolean;
    /** Describes whether a plan or flavor is reservable. */
    reservable?: boolean;
    /** ID of the primary offering for a group. */
    primary_offering_id?: string;
    /** Alert to ACE to allow instance UI to be accessible while the provisioning state of instance is in progress. */
    accessible_during_provision?: boolean;
    /** Specifies a side by side ordering weight to the UI. */
    side_by_side_index?: number;
    /** Date and time the service will no longer be available. */
    end_of_service_time?: string;
  }

  /** Media-related metadata. */
  export interface UIMetaMedia {
    /** Caption for an image. */
    caption?: string;
    /** URL for thumbnail image. */
    thumbnail_url?: string;
    /** Type of media. */
    type?: string;
    /** URL for media. */
    url?: string;
    /** Information related to list delimiters. */
    source?: Bullets;
  }

  /** UI based URLs. */
  export interface URLS {
    /** URL for documentation. */
    doc_url?: string;
    /** URL for usage instructions. */
    instructions_url?: string;
    /** API URL. */
    api_url?: string;
    /** URL Creation UI / API. */
    create_url?: string;
    /** URL to downlaod an SDK. */
    sdk_download_url?: string;
    /** URL to the terms of use for your service. */
    terms_url?: string;
    /** URL to the custom create page for your serivce. */
    custom_create_page_url?: string;
    /** URL to the catalog details page for your serivce. */
    catalog_details_url?: string;
    /** URL for deprecation documentation. */
    deprecation_doc_url?: string;
  }

  /** Information related to the visibility of a catalog entry. */
  export interface Visibility {
    /** This controls the overall visibility. It is an enum of *public*, *ibm_only*, and *private*. public means it
     *  is visible to all. ibm_only means it is visible to all IBM unless their account is explicitly excluded. private
     *  means it is visible only to the included accounts.
     */
    restrictions?: string;
    /** IAM Scope-related information associated with a catalog entry. */
    owner?: string;
    /** Visibility details related to a catalog entry. */
    include?: VisibilityDetail;
    /** Visibility details related to a catalog entry. */
    exclude?: VisibilityDetail;
    /** Determines whether the owning account has full control over the visibility of the entry such as adding
     *  non-IBM accounts to the whitelist and making entries `private`, `ibm_only` or `public`.
     */
    approved?: boolean;
  }

  /** Visibility details related to a catalog entry. */
  export interface VisibilityDetail {
    /** Information related to the accounts for which a catalog entry is visible. */
    accounts: VisibilityDetailAccounts;
  }

  /** Information related to the accounts for which a catalog entry is visible. */
  export interface VisibilityDetailAccounts {
    /** (_accountid_) is the GUID of the account and the value is the scope of who set it. For setting visibility
     *  use "" as the value. It is replaced with the owner scope when saved.
     */
    accountid?: string;
  }

}

export = GlobalCatalogV1;
