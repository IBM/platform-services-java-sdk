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
 * IBM OpenAPI SDK Code Generator Version: 3.33.0-caf29bd0-20210603-225214
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
 * This is the API to use for managing private catalogs for IBM Cloud. Private catalogs provide a way to centrally
 * manage access to products in the IBM Cloud catalog and your own catalogs.
 */

class CatalogManagementV1 extends BaseService {
  static DEFAULT_SERVICE_URL: string = 'https://cm.globalcatalog.cloud.ibm.com/api/v1-beta';

  static DEFAULT_SERVICE_NAME: string = 'catalog_management';

  /*************************
   * Factory method
   ************************/

  /**
   * Constructs an instance of CatalogManagementV1 with passed in options and external configuration.
   *
   * @param {UserOptions} [options] - The parameters to send to the service.
   * @param {string} [options.serviceName] - The name of the service to configure
   * @param {Authenticator} [options.authenticator] - The Authenticator object used to authenticate requests to the service
   * @param {string} [options.serviceUrl] - The URL for the service
   * @returns {CatalogManagementV1}
   */

  public static newInstance(options: UserOptions): CatalogManagementV1 {
    options = options || {};

    if (!options.serviceName) {
      options.serviceName = this.DEFAULT_SERVICE_NAME;
    }
    if (!options.authenticator) {
      options.authenticator = getAuthenticatorFromEnvironment(options.serviceName);
    }
    const service = new CatalogManagementV1(options);
    service.configureService(options.serviceName);
    if (options.serviceUrl) {
      service.setServiceUrl(options.serviceUrl);
    }
    return service;
  }

  /**
   * Construct a CatalogManagementV1 object.
   *
   * @param {Object} options - Options for the service.
   * @param {string} [options.serviceUrl] - The base url to use when contacting the service. The base url may differ between IBM Cloud regions.
   * @param {OutgoingHttpHeaders} [options.headers] - Default headers that shall be included with every request to the service.
   * @param {Authenticator} options.authenticator - The Authenticator object used to authenticate requests to the service
   * @constructor
   * @returns {CatalogManagementV1}
   */
  constructor(options: UserOptions) {
    options = options || {};

    super(options);
    if (options.serviceUrl) {
      this.setServiceUrl(options.serviceUrl);
    } else {
      this.setServiceUrl(CatalogManagementV1.DEFAULT_SERVICE_URL);
    }
  }

  /*************************
   * account
   ************************/

  /**
   * Get catalog account settings.
   *
   * Get the account level settings for the account for private catalog.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Account>>}
   */
  public getCatalogAccount(
    params?: CatalogManagementV1.GetCatalogAccountParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Account>> {
    const _params = { ...params };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'getCatalogAccount'
    );

    const parameters = {
      options: {
        url: '/catalogaccount',
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

  /**
   * Update account settings.
   *
   * Update the account level settings for the account for private catalog.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {string} [params.id] - Account identification.
   * @param {boolean} [params.hideIbmCloudCatalog] - Hide the public catalog in this account.
   * @param {Filters} [params.accountFilters] - Filters for account and catalog filters.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public updateCatalogAccount(
    params?: CatalogManagementV1.UpdateCatalogAccountParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = { ...params };

    const body = {
      'id': _params.id,
      'hide_IBM_cloud_catalog': _params.hideIbmCloudCatalog,
      'account_filters': _params.accountFilters,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'updateCatalogAccount'
    );

    const parameters = {
      options: {
        url: '/catalogaccount',
        method: 'PUT',
        body,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Content-Type': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Get catalog account audit log.
   *
   * Get the audit log associated with a catalog account.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.AuditLog>>}
   */
  public getCatalogAccountAudit(
    params?: CatalogManagementV1.GetCatalogAccountAuditParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.AuditLog>> {
    const _params = { ...params };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'getCatalogAccountAudit'
    );

    const parameters = {
      options: {
        url: '/catalogaccount/audit',
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

  /**
   * Get catalog account filters.
   *
   * Get the accumulated filters of the account and of the catalogs you have access to.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {string} [params.catalog] - catalog id. Narrow down filters to the account and just the one catalog.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.AccumulatedFilters>>}
   */
  public getCatalogAccountFilters(
    params?: CatalogManagementV1.GetCatalogAccountFiltersParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.AccumulatedFilters>> {
    const _params = { ...params };

    const query = {
      'catalog': _params.catalog,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'getCatalogAccountFilters'
    );

    const parameters = {
      options: {
        url: '/catalogaccount/filters',
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
   * catalogs
   ************************/

  /**
   * Get list of catalogs.
   *
   * Retrieves the available catalogs for a given account. This can be used by an unauthenticated user to retrieve the
   * public catalog.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.CatalogSearchResult>>}
   */
  public listCatalogs(
    params?: CatalogManagementV1.ListCatalogsParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.CatalogSearchResult>> {
    const _params = { ...params };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'listCatalogs'
    );

    const parameters = {
      options: {
        url: '/catalogs',
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

  /**
   * Create a catalog.
   *
   * Create a catalog for a given account.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {string} [params.id] - Unique ID.
   * @param {string} [params.rev] - Cloudant revision.
   * @param {string} [params.label] - Display Name in the requested language.
   * @param {string} [params.shortDescription] - Description in the requested language.
   * @param {string} [params.catalogIconUrl] - URL for an icon associated with this catalog.
   * @param {string[]} [params.tags] - List of tags associated with this catalog.
   * @param {Feature[]} [params.features] - List of features associated with this catalog.
   * @param {boolean} [params.disabled] - Denotes whether a catalog is disabled.
   * @param {string} [params.resourceGroupId] - Resource group id the catalog is owned by.
   * @param {string} [params.owningAccount] - Account that owns catalog.
   * @param {Filters} [params.catalogFilters] - Filters for account and catalog filters.
   * @param {SyndicationResource} [params.syndicationSettings] - Feature information.
   * @param {string} [params.kind] - Kind of catalog. Supported kinds are offering and vpe.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Catalog>>}
   */
  public createCatalog(
    params?: CatalogManagementV1.CreateCatalogParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Catalog>> {
    const _params = { ...params };

    const body = {
      'id': _params.id,
      '_rev': _params.rev,
      'label': _params.label,
      'short_description': _params.shortDescription,
      'catalog_icon_url': _params.catalogIconUrl,
      'tags': _params.tags,
      'features': _params.features,
      'disabled': _params.disabled,
      'resource_group_id': _params.resourceGroupId,
      'owning_account': _params.owningAccount,
      'catalog_filters': _params.catalogFilters,
      'syndication_settings': _params.syndicationSettings,
      'kind': _params.kind,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'createCatalog'
    );

    const parameters = {
      options: {
        url: '/catalogs',
        method: 'POST',
        body,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Get catalog.
   *
   * Get a catalog. This can also be used by an unauthenticated user to get the public catalog.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Catalog>>}
   */
  public getCatalog(
    params: CatalogManagementV1.GetCatalogParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Catalog>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
    };

    const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getCatalog');

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}',
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
   * Update catalog.
   *
   * Update a catalog.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} [params.id] - Unique ID.
   * @param {string} [params.rev] - Cloudant revision.
   * @param {string} [params.label] - Display Name in the requested language.
   * @param {string} [params.shortDescription] - Description in the requested language.
   * @param {string} [params.catalogIconUrl] - URL for an icon associated with this catalog.
   * @param {string[]} [params.tags] - List of tags associated with this catalog.
   * @param {Feature[]} [params.features] - List of features associated with this catalog.
   * @param {boolean} [params.disabled] - Denotes whether a catalog is disabled.
   * @param {string} [params.resourceGroupId] - Resource group id the catalog is owned by.
   * @param {string} [params.owningAccount] - Account that owns catalog.
   * @param {Filters} [params.catalogFilters] - Filters for account and catalog filters.
   * @param {SyndicationResource} [params.syndicationSettings] - Feature information.
   * @param {string} [params.kind] - Kind of catalog. Supported kinds are offering and vpe.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Catalog>>}
   */
  public replaceCatalog(
    params: CatalogManagementV1.ReplaceCatalogParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Catalog>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'id': _params.id,
      '_rev': _params.rev,
      'label': _params.label,
      'short_description': _params.shortDescription,
      'catalog_icon_url': _params.catalogIconUrl,
      'tags': _params.tags,
      'features': _params.features,
      'disabled': _params.disabled,
      'resource_group_id': _params.resourceGroupId,
      'owning_account': _params.owningAccount,
      'catalog_filters': _params.catalogFilters,
      'syndication_settings': _params.syndicationSettings,
      'kind': _params.kind,
    };

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'replaceCatalog'
    );

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}',
        method: 'PUT',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Delete catalog.
   *
   * Delete a catalog.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public deleteCatalog(
    params: CatalogManagementV1.DeleteCatalogParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'deleteCatalog'
    );

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}',
        method: 'DELETE',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {}, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Get catalog audit log.
   *
   * Get the audit log associated with a catalog.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.AuditLog>>}
   */
  public getCatalogAudit(
    params: CatalogManagementV1.GetCatalogAuditParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.AuditLog>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'getCatalogAudit'
    );

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}/audit',
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

  /*************************
   * offerings
   ************************/

  /**
   * Get consumption offerings.
   *
   * Retrieve the available offerings from both public and from the account that currently scoped for consumption. These
   * copies cannot be used for updating. They are not complete and only return what is visible to the caller. This can
   * be used by an unauthenticated user to retreive publicly available offerings.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {boolean} [params.digest] - true - Strip down the content of what is returned. For example don't return the
   * readme. Makes the result much smaller. Defaults to false.
   * @param {string} [params.catalog] - catalog id. Narrow search down to just a particular catalog. It will apply the
   * catalog's public filters to the public catalog offerings on the result.
   * @param {string} [params.select] - What should be selected. Default is 'all' which will return both public and
   * private offerings. 'public' returns only the public offerings and 'private' returns only the private offerings.
   * @param {boolean} [params.includeHidden] - true - include offerings which have been marked as hidden. The default is
   * false and hidden offerings are not returned.
   * @param {number} [params.limit] - number or results to return.
   * @param {number} [params.offset] - number of results to skip before returning values.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.OfferingSearchResult>>}
   */
  public getConsumptionOfferings(
    params?: CatalogManagementV1.GetConsumptionOfferingsParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.OfferingSearchResult>> {
    const _params = { ...params };

    const query = {
      'digest': _params.digest,
      'catalog': _params.catalog,
      'select': _params.select,
      'includeHidden': _params.includeHidden,
      'limit': _params.limit,
      'offset': _params.offset,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'getConsumptionOfferings'
    );

    const parameters = {
      options: {
        url: '/offerings',
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

  /**
   * Get list of offerings.
   *
   * Retrieve the available offerings in the specified catalog. This can also be used by an unauthenticated user to
   * retreive publicly available offerings.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {boolean} [params.digest] - true - Strip down the content of what is returned. For example don't return the
   * readme. Makes the result much smaller. Defaults to false.
   * @param {number} [params.limit] - The maximum number of results to return.
   * @param {number} [params.offset] - The number of results to skip before returning values.
   * @param {string} [params.name] - Only return results that contain the specified string.
   * @param {string} [params.sort] - The field on which the output is sorted. Sorts by default by **label** property.
   * Available fields are **name**, **label**, **created**, and **updated**. By adding **-** (i.e. **-label**) in front
   * of the query string, you can specify descending order. Default is ascending order.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.OfferingSearchResult>>}
   */
  public listOfferings(
    params: CatalogManagementV1.ListOfferingsParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.OfferingSearchResult>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'digest': _params.digest,
      'limit': _params.limit,
      'offset': _params.offset,
      'name': _params.name,
      'sort': _params.sort,
    };

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'listOfferings'
    );

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}/offerings',
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
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Create offering.
   *
   * Create an offering.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} [params.id] - unique id.
   * @param {string} [params.rev] - Cloudant revision.
   * @param {string} [params.url] - The url for this specific offering.
   * @param {string} [params.crn] - The crn for this specific offering.
   * @param {string} [params.label] - Display Name in the requested language.
   * @param {string} [params.name] - The programmatic name of this offering.
   * @param {string} [params.offeringIconUrl] - URL for an icon associated with this offering.
   * @param {string} [params.offeringDocsUrl] - URL for an additional docs with this offering.
   * @param {string} [params.offeringSupportUrl] - URL to be displayed in the Consumption UI for getting support on this
   * offering.
   * @param {string[]} [params.tags] - List of tags associated with this catalog.
   * @param {string[]} [params.keywords] - List of keywords associated with offering, typically used to search for it.
   * @param {Rating} [params.rating] - Repository info for offerings.
   * @param {string} [params.created] - The date and time this catalog was created.
   * @param {string} [params.updated] - The date and time this catalog was last updated.
   * @param {string} [params.shortDescription] - Short description in the requested language.
   * @param {string} [params.longDescription] - Long description in the requested language.
   * @param {Feature[]} [params.features] - list of features associated with this offering.
   * @param {Kind[]} [params.kinds] - Array of kind.
   * @param {boolean} [params.permitRequestIbmPublicPublish] - Is it permitted to request publishing to IBM or Public.
   * @param {boolean} [params.ibmPublishApproved] - Indicates if this offering has been approved for use by all IBMers.
   * @param {boolean} [params.publicPublishApproved] - Indicates if this offering has been approved for use by all IBM
   * Cloud users.
   * @param {string} [params.publicOriginalCrn] - The original offering CRN that this publish entry came from.
   * @param {string} [params.publishPublicCrn] - The crn of the public catalog entry of this offering.
   * @param {string} [params.portalApprovalRecord] - The portal's approval record ID.
   * @param {string} [params.portalUiUrl] - The portal UI URL.
   * @param {string} [params.catalogId] - The id of the catalog containing this offering.
   * @param {string} [params.catalogName] - The name of the catalog.
   * @param {JsonObject} [params.metadata] - Map of metadata values for this offering.
   * @param {string} [params.disclaimer] - A disclaimer for this offering.
   * @param {boolean} [params.hidden] - Determine if this offering should be displayed in the Consumption UI.
   * @param {string} [params.provider] - Provider of this offering.
   * @param {RepoInfo} [params.repoInfo] - Repository info for offerings.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Offering>>}
   */
  public createOffering(
    params: CatalogManagementV1.CreateOfferingParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Offering>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'id': _params.id,
      '_rev': _params.rev,
      'url': _params.url,
      'crn': _params.crn,
      'label': _params.label,
      'name': _params.name,
      'offering_icon_url': _params.offeringIconUrl,
      'offering_docs_url': _params.offeringDocsUrl,
      'offering_support_url': _params.offeringSupportUrl,
      'tags': _params.tags,
      'keywords': _params.keywords,
      'rating': _params.rating,
      'created': _params.created,
      'updated': _params.updated,
      'short_description': _params.shortDescription,
      'long_description': _params.longDescription,
      'features': _params.features,
      'kinds': _params.kinds,
      'permit_request_ibm_public_publish': _params.permitRequestIbmPublicPublish,
      'ibm_publish_approved': _params.ibmPublishApproved,
      'public_publish_approved': _params.publicPublishApproved,
      'public_original_crn': _params.publicOriginalCrn,
      'publish_public_crn': _params.publishPublicCrn,
      'portal_approval_record': _params.portalApprovalRecord,
      'portal_ui_url': _params.portalUiUrl,
      'catalog_id': _params.catalogId,
      'catalog_name': _params.catalogName,
      'metadata': _params.metadata,
      'disclaimer': _params.disclaimer,
      'hidden': _params.hidden,
      'provider': _params.provider,
      'repo_info': _params.repoInfo,
    };

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'createOffering'
    );

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}/offerings',
        method: 'POST',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Import offering version.
   *
   * Import new version to offering from a tgz.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.offeringId - Offering identification.
   * @param {string[]} [params.tags] - Tags array.
   * @param {string[]} [params.targetKinds] - Target kinds.  Current valid values are 'iks', 'roks', 'vcenter', and
   * 'terraform'.
   * @param {string} [params.content] - byte array representing the content to be imported.  Only supported for OVA
   * images at this time.
   * @param {string} [params.zipurl] - URL path to zip location.  If not specified, must provide content in the body of
   * this call.
   * @param {string} [params.targetVersion] - The semver value for this new version, if not found in the zip url package
   * content.
   * @param {boolean} [params.includeConfig] - Add all possible configuration values to this version when importing.
   * @param {boolean} [params.isVsi] - Indicates that the current terraform template is used to install a VSI Image.
   * @param {string} [params.repoType] - The type of repository containing this version.  Valid values are 'public_git'
   * or 'enterprise_git'.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Offering>>}
   */
  public importOfferingVersion(
    params: CatalogManagementV1.ImportOfferingVersionParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Offering>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier', 'offeringId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'tags': _params.tags,
      'target_kinds': _params.targetKinds,
      'content': _params.content,
    };

    const query = {
      'zipurl': _params.zipurl,
      'targetVersion': _params.targetVersion,
      'includeConfig': _params.includeConfig,
      'isVSI': _params.isVsi,
      'repoType': _params.repoType,
    };

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
      'offering_id': _params.offeringId,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'importOfferingVersion'
    );

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}/offerings/{offering_id}/version',
        method: 'POST',
        body,
        qs: query,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Import offering.
   *
   * Import a new offering from a tgz.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string[]} [params.tags] - Tags array.
   * @param {string[]} [params.targetKinds] - Target kinds.  Current valid values are 'iks', 'roks', 'vcenter', and
   * 'terraform'.
   * @param {string} [params.content] - byte array representing the content to be imported.  Only supported for OVA
   * images at this time.
   * @param {string} [params.zipurl] - URL path to zip location.  If not specified, must provide content in this post
   * body.
   * @param {string} [params.offeringId] - Re-use the specified offeringID during import.
   * @param {string} [params.targetVersion] - The semver value for this new version.
   * @param {boolean} [params.includeConfig] - Add all possible configuration items when creating this version.
   * @param {boolean} [params.isVsi] - Indicates that the current terraform template is used to install a VSI Image.
   * @param {string} [params.repoType] - The type of repository containing this version.  Valid values are 'public_git'
   * or 'enterprise_git'.
   * @param {string} [params.xAuthToken] - Authentication token used to access the specified zip file.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Offering>>}
   */
  public importOffering(
    params: CatalogManagementV1.ImportOfferingParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Offering>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'tags': _params.tags,
      'target_kinds': _params.targetKinds,
      'content': _params.content,
    };

    const query = {
      'zipurl': _params.zipurl,
      'offeringID': _params.offeringId,
      'targetVersion': _params.targetVersion,
      'includeConfig': _params.includeConfig,
      'isVSI': _params.isVsi,
      'repoType': _params.repoType,
    };

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'importOffering'
    );

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}/import/offerings',
        method: 'POST',
        body,
        qs: query,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'X-Auth-Token': _params.xAuthToken,
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Reload offering.
   *
   * Reload an existing version in offering from a tgz.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.offeringId - Offering identification.
   * @param {string} params.targetVersion - The semver value for this new version.
   * @param {string[]} [params.tags] - Tags array.
   * @param {string[]} [params.targetKinds] - Target kinds.  Current valid values are 'iks', 'roks', 'vcenter', and
   * 'terraform'.
   * @param {string} [params.content] - byte array representing the content to be imported.  Only supported for OVA
   * images at this time.
   * @param {string} [params.zipurl] - URL path to zip location.  If not specified, must provide content in this post
   * body.
   * @param {string} [params.repoType] - The type of repository containing this version.  Valid values are 'public_git'
   * or 'enterprise_git'.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Offering>>}
   */
  public reloadOffering(
    params: CatalogManagementV1.ReloadOfferingParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Offering>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier', 'offeringId', 'targetVersion'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'tags': _params.tags,
      'target_kinds': _params.targetKinds,
      'content': _params.content,
    };

    const query = {
      'targetVersion': _params.targetVersion,
      'zipurl': _params.zipurl,
      'repoType': _params.repoType,
    };

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
      'offering_id': _params.offeringId,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'reloadOffering'
    );

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}/offerings/{offering_id}/reload',
        method: 'PUT',
        body,
        qs: query,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Get offering.
   *
   * Get an offering. This can be used by an unauthenticated user for publicly available offerings.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.offeringId - Offering identification.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Offering>>}
   */
  public getOffering(
    params: CatalogManagementV1.GetOfferingParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Offering>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier', 'offeringId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
      'offering_id': _params.offeringId,
    };

    const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getOffering');

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}/offerings/{offering_id}',
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
   * Update offering.
   *
   * Update an offering.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.offeringId - Offering identification.
   * @param {string} [params.id] - unique id.
   * @param {string} [params.rev] - Cloudant revision.
   * @param {string} [params.url] - The url for this specific offering.
   * @param {string} [params.crn] - The crn for this specific offering.
   * @param {string} [params.label] - Display Name in the requested language.
   * @param {string} [params.name] - The programmatic name of this offering.
   * @param {string} [params.offeringIconUrl] - URL for an icon associated with this offering.
   * @param {string} [params.offeringDocsUrl] - URL for an additional docs with this offering.
   * @param {string} [params.offeringSupportUrl] - URL to be displayed in the Consumption UI for getting support on this
   * offering.
   * @param {string[]} [params.tags] - List of tags associated with this catalog.
   * @param {string[]} [params.keywords] - List of keywords associated with offering, typically used to search for it.
   * @param {Rating} [params.rating] - Repository info for offerings.
   * @param {string} [params.created] - The date and time this catalog was created.
   * @param {string} [params.updated] - The date and time this catalog was last updated.
   * @param {string} [params.shortDescription] - Short description in the requested language.
   * @param {string} [params.longDescription] - Long description in the requested language.
   * @param {Feature[]} [params.features] - list of features associated with this offering.
   * @param {Kind[]} [params.kinds] - Array of kind.
   * @param {boolean} [params.permitRequestIbmPublicPublish] - Is it permitted to request publishing to IBM or Public.
   * @param {boolean} [params.ibmPublishApproved] - Indicates if this offering has been approved for use by all IBMers.
   * @param {boolean} [params.publicPublishApproved] - Indicates if this offering has been approved for use by all IBM
   * Cloud users.
   * @param {string} [params.publicOriginalCrn] - The original offering CRN that this publish entry came from.
   * @param {string} [params.publishPublicCrn] - The crn of the public catalog entry of this offering.
   * @param {string} [params.portalApprovalRecord] - The portal's approval record ID.
   * @param {string} [params.portalUiUrl] - The portal UI URL.
   * @param {string} [params.catalogId] - The id of the catalog containing this offering.
   * @param {string} [params.catalogName] - The name of the catalog.
   * @param {JsonObject} [params.metadata] - Map of metadata values for this offering.
   * @param {string} [params.disclaimer] - A disclaimer for this offering.
   * @param {boolean} [params.hidden] - Determine if this offering should be displayed in the Consumption UI.
   * @param {string} [params.provider] - Provider of this offering.
   * @param {RepoInfo} [params.repoInfo] - Repository info for offerings.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Offering>>}
   */
  public replaceOffering(
    params: CatalogManagementV1.ReplaceOfferingParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Offering>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier', 'offeringId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'id': _params.id,
      '_rev': _params.rev,
      'url': _params.url,
      'crn': _params.crn,
      'label': _params.label,
      'name': _params.name,
      'offering_icon_url': _params.offeringIconUrl,
      'offering_docs_url': _params.offeringDocsUrl,
      'offering_support_url': _params.offeringSupportUrl,
      'tags': _params.tags,
      'keywords': _params.keywords,
      'rating': _params.rating,
      'created': _params.created,
      'updated': _params.updated,
      'short_description': _params.shortDescription,
      'long_description': _params.longDescription,
      'features': _params.features,
      'kinds': _params.kinds,
      'permit_request_ibm_public_publish': _params.permitRequestIbmPublicPublish,
      'ibm_publish_approved': _params.ibmPublishApproved,
      'public_publish_approved': _params.publicPublishApproved,
      'public_original_crn': _params.publicOriginalCrn,
      'publish_public_crn': _params.publishPublicCrn,
      'portal_approval_record': _params.portalApprovalRecord,
      'portal_ui_url': _params.portalUiUrl,
      'catalog_id': _params.catalogId,
      'catalog_name': _params.catalogName,
      'metadata': _params.metadata,
      'disclaimer': _params.disclaimer,
      'hidden': _params.hidden,
      'provider': _params.provider,
      'repo_info': _params.repoInfo,
    };

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
      'offering_id': _params.offeringId,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'replaceOffering'
    );

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}/offerings/{offering_id}',
        method: 'PUT',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Delete offering.
   *
   * Delete an offering.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.offeringId - Offering identification.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public deleteOffering(
    params: CatalogManagementV1.DeleteOfferingParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier', 'offeringId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
      'offering_id': _params.offeringId,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'deleteOffering'
    );

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}/offerings/{offering_id}',
        method: 'DELETE',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {}, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Get offering audit log.
   *
   * Get the audit log associated with an offering.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.offeringId - Offering identifier.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.AuditLog>>}
   */
  public getOfferingAudit(
    params: CatalogManagementV1.GetOfferingAuditParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.AuditLog>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier', 'offeringId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
      'offering_id': _params.offeringId,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'getOfferingAudit'
    );

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}/offerings/{offering_id}/audit',
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
   * Upload icon for offering.
   *
   * Upload an icon file to be stored in GC. File is uploaded as a binary payload - not as a form.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.offeringId - Offering identification.
   * @param {string} params.fileName - Name of the file name that is being uploaded.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Offering>>}
   */
  public replaceOfferingIcon(
    params: CatalogManagementV1.ReplaceOfferingIconParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Offering>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier', 'offeringId', 'fileName'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
      'offering_id': _params.offeringId,
      'file_name': _params.fileName,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'replaceOfferingIcon'
    );

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}/offerings/{offering_id}/icon/{file_name}',
        method: 'PUT',
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
   * Allow offering to be published.
   *
   * Approve or disapprove the offering to be allowed to publish to the IBM Public Catalog. Options:
   * * `allow_request` - (Allow requesting to publish to IBM)
   * * `ibm` - (Allow publishing to be visible to IBM only)
   * * `public` - (Allow publishing to be visible to everyone, including IBM)
   *
   * If disapprove `public`, then `ibm` approval will not  be changed. If disapprove `ibm` then `public` will
   * automatically be disapproved. if disapprove `allow_request` then all rights to publish will be removed. This is
   * because the process steps always go first through `allow` to `ibm` and then to `public`. `ibm` cannot be skipped.
   * Only users with Approval IAM authority can use this. Approvers should use the catalog and offering id from the
   * public catalog since they wouldn't have access to the private offering.'.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.offeringId - Offering identification.
   * @param {string} params.approvalType - Type of approval, ibm or public.
   * @param {string} params.approved - Approve (true) or disapprove (false).
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.ApprovalResult>>}
   */
  public updateOfferingIbm(
    params: CatalogManagementV1.UpdateOfferingIbmParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.ApprovalResult>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier', 'offeringId', 'approvalType', 'approved'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
      'offering_id': _params.offeringId,
      'approval_type': _params.approvalType,
      'approved': _params.approved,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'updateOfferingIbm'
    );

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}/offerings/{offering_id}/publish/{approval_type}/{approved}',
        method: 'POST',
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
   * Get version updates.
   *
   * Get available updates for the specified version.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.offeringId - Offering identification.
   * @param {string} params.kind - The kind of offering (e.g, helm, ova, terraform ...).
   * @param {string} [params.version] - optionaly provide an existing version to check updates for if one is not given,
   * all version will be returned.
   * @param {string} [params.clusterId] - The id of the cluster where this version was installed.
   * @param {string} [params.region] - The region of the cluster where this version was installed.
   * @param {string} [params.resourceGroupId] - The resource group id of the cluster where this version was installed.
   * @param {string} [params.namespace] - The namespace of the cluster where this version was installed.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.VersionUpdateDescriptor[]>>}
   */
  public getOfferingUpdates(
    params: CatalogManagementV1.GetOfferingUpdatesParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.VersionUpdateDescriptor[]>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier', 'offeringId', 'kind'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'kind': _params.kind,
      'version': _params.version,
      'cluster_id': _params.clusterId,
      'region': _params.region,
      'resource_group_id': _params.resourceGroupId,
      'namespace': _params.namespace,
    };

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
      'offering_id': _params.offeringId,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'getOfferingUpdates'
    );

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}/offerings/{offering_id}/updates',
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
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /*************************
   * versions
   ************************/

  /**
   * Get version about information.
   *
   * Get the about information, in markdown, for the current version.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<string>>}
   */
  public getOfferingAbout(
    params: CatalogManagementV1.GetOfferingAboutParams
  ): Promise<CatalogManagementV1.Response<string>> {
    const _params = { ...params };
    const requiredParams = ['versionLocId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'version_loc_id': _params.versionLocId,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'getOfferingAbout'
    );

    const parameters = {
      options: {
        url: '/versions/{version_loc_id}/about',
        method: 'GET',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'text/markdown',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Get version license content.
   *
   * Get the license content for the specified license ID in the specified version.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {string} params.licenseId - The ID of the license, which maps to the file name in the 'licenses' directory
   * of this verions tgz file.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<string>>}
   */
  public getOfferingLicense(
    params: CatalogManagementV1.GetOfferingLicenseParams
  ): Promise<CatalogManagementV1.Response<string>> {
    const _params = { ...params };
    const requiredParams = ['versionLocId', 'licenseId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'version_loc_id': _params.versionLocId,
      'license_id': _params.licenseId,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'getOfferingLicense'
    );

    const parameters = {
      options: {
        url: '/versions/{version_loc_id}/licenses/{license_id}',
        method: 'GET',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'text/plain',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Get version's container images.
   *
   * Get the list of container images associated with the specified version. The "image_manifest_url" property of the
   * version should be the URL for the image manifest, and the operation will return that content.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.ImageManifest>>}
   */
  public getOfferingContainerImages(
    params: CatalogManagementV1.GetOfferingContainerImagesParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.ImageManifest>> {
    const _params = { ...params };
    const requiredParams = ['versionLocId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'version_loc_id': _params.versionLocId,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'getOfferingContainerImages'
    );

    const parameters = {
      options: {
        url: '/versions/{version_loc_id}/containerImages',
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
   * Deprecate version.
   *
   * Deprecate the specified version.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public deprecateVersion(
    params: CatalogManagementV1.DeprecateVersionParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['versionLocId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'version_loc_id': _params.versionLocId,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'deprecateVersion'
    );

    const parameters = {
      options: {
        url: '/versions/{version_loc_id}/deprecate',
        method: 'POST',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {}, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Publish version to account members.
   *
   * Publish the specified version so it is viewable by account members.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public accountPublishVersion(
    params: CatalogManagementV1.AccountPublishVersionParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['versionLocId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'version_loc_id': _params.versionLocId,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'accountPublishVersion'
    );

    const parameters = {
      options: {
        url: '/versions/{version_loc_id}/account-publish',
        method: 'POST',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {}, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Publish version to IBMers in public catalog.
   *
   * Publish the specified version so that it is visible to IBMers in the public catalog.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public ibmPublishVersion(
    params: CatalogManagementV1.IbmPublishVersionParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['versionLocId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'version_loc_id': _params.versionLocId,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'ibmPublishVersion'
    );

    const parameters = {
      options: {
        url: '/versions/{version_loc_id}/ibm-publish',
        method: 'POST',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {}, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Publish version to all users in public catalog.
   *
   * Publish the specified version so it is visible to all users in the public catalog.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public publicPublishVersion(
    params: CatalogManagementV1.PublicPublishVersionParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['versionLocId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'version_loc_id': _params.versionLocId,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'publicPublishVersion'
    );

    const parameters = {
      options: {
        url: '/versions/{version_loc_id}/public-publish',
        method: 'POST',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {}, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Commit version.
   *
   * Commit a working copy of the specified version.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public commitVersion(
    params: CatalogManagementV1.CommitVersionParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['versionLocId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'version_loc_id': _params.versionLocId,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'commitVersion'
    );

    const parameters = {
      options: {
        url: '/versions/{version_loc_id}/commit',
        method: 'POST',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {}, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Copy version to new target kind.
   *
   * Copy the specified version to a new target kind within the same offering.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {string[]} [params.tags] - Tags array.
   * @param {string[]} [params.targetKinds] - Target kinds.  Current valid values are 'iks', 'roks', 'vcenter', and
   * 'terraform'.
   * @param {string} [params.content] - byte array representing the content to be imported.  Only supported for OVA
   * images at this time.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public copyVersion(
    params: CatalogManagementV1.CopyVersionParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['versionLocId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'tags': _params.tags,
      'target_kinds': _params.targetKinds,
      'content': _params.content,
    };

    const path = {
      'version_loc_id': _params.versionLocId,
    };

    const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'copyVersion');

    const parameters = {
      options: {
        url: '/versions/{version_loc_id}/copy',
        method: 'POST',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Content-Type': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Create working copy of version.
   *
   * Create a working copy of the specified version.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Version>>}
   */
  public getOfferingWorkingCopy(
    params: CatalogManagementV1.GetOfferingWorkingCopyParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Version>> {
    const _params = { ...params };
    const requiredParams = ['versionLocId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'version_loc_id': _params.versionLocId,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'getOfferingWorkingCopy'
    );

    const parameters = {
      options: {
        url: '/versions/{version_loc_id}/workingcopy',
        method: 'POST',
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
   * Get offering/kind/version 'branch'.
   *
   * Get the Offering/Kind/Version 'branch' for the specified locator ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Offering>>}
   */
  public getVersion(
    params: CatalogManagementV1.GetVersionParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Offering>> {
    const _params = { ...params };
    const requiredParams = ['versionLocId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'version_loc_id': _params.versionLocId,
    };

    const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getVersion');

    const parameters = {
      options: {
        url: '/versions/{version_loc_id}',
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
   * Delete version.
   *
   * Delete the specified version.  If the version is an active version with a working copy, the working copy will be
   * deleted as well.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public deleteVersion(
    params: CatalogManagementV1.DeleteVersionParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['versionLocId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'version_loc_id': _params.versionLocId,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'deleteVersion'
    );

    const parameters = {
      options: {
        url: '/versions/{version_loc_id}',
        method: 'DELETE',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {}, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  }

  /*************************
   * deploy
   ************************/

  /**
   * Get kubernetes cluster.
   *
   * Get the contents of the specified kubernetes cluster.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.clusterId - ID of the cluster.
   * @param {string} params.region - Region of the cluster.
   * @param {string} params.xAuthRefreshToken - IAM Refresh token.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.ClusterInfo>>}
   */
  public getCluster(
    params: CatalogManagementV1.GetClusterParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.ClusterInfo>> {
    const _params = { ...params };
    const requiredParams = ['clusterId', 'region', 'xAuthRefreshToken'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'region': _params.region,
    };

    const path = {
      'cluster_id': _params.clusterId,
    };

    const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getCluster');

    const parameters = {
      options: {
        url: '/deploy/kubernetes/clusters/{cluster_id}',
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
            'X-Auth-Refresh-Token': _params.xAuthRefreshToken,
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Get cluster namespaces.
   *
   * Get the namespaces associated with the specified kubernetes cluster.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.clusterId - ID of the cluster.
   * @param {string} params.region - Cluster region.
   * @param {string} params.xAuthRefreshToken - IAM Refresh token.
   * @param {number} [params.limit] - The maximum number of results to return.
   * @param {number} [params.offset] - The number of results to skip before returning values.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.NamespaceSearchResult>>}
   */
  public getNamespaces(
    params: CatalogManagementV1.GetNamespacesParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.NamespaceSearchResult>> {
    const _params = { ...params };
    const requiredParams = ['clusterId', 'region', 'xAuthRefreshToken'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'region': _params.region,
      'limit': _params.limit,
      'offset': _params.offset,
    };

    const path = {
      'cluster_id': _params.clusterId,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'getNamespaces'
    );

    const parameters = {
      options: {
        url: '/deploy/kubernetes/clusters/{cluster_id}/namespaces',
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
            'X-Auth-Refresh-Token': _params.xAuthRefreshToken,
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Deploy operators.
   *
   * Deploy operators on a kubernetes cluster.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.xAuthRefreshToken - IAM Refresh token.
   * @param {string} [params.clusterId] - Cluster ID.
   * @param {string} [params.region] - Cluster region.
   * @param {string[]} [params.namespaces] - Kube namespaces to deploy Operator(s) to.
   * @param {boolean} [params.allNamespaces] - Denotes whether to install Operator(s) globally.
   * @param {string} [params.versionLocatorId] - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.OperatorDeployResult[]>>}
   */
  public deployOperators(
    params: CatalogManagementV1.DeployOperatorsParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.OperatorDeployResult[]>> {
    const _params = { ...params };
    const requiredParams = ['xAuthRefreshToken'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'cluster_id': _params.clusterId,
      'region': _params.region,
      'namespaces': _params.namespaces,
      'all_namespaces': _params.allNamespaces,
      'version_locator_id': _params.versionLocatorId,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'deployOperators'
    );

    const parameters = {
      options: {
        url: '/deploy/kubernetes/olm/operator',
        method: 'POST',
        body,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'X-Auth-Refresh-Token': _params.xAuthRefreshToken,
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * List operators.
   *
   * List the operators from a kubernetes cluster.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.xAuthRefreshToken - IAM Refresh token.
   * @param {string} params.clusterId - Cluster identification.
   * @param {string} params.region - Cluster region.
   * @param {string} params.versionLocatorId - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.OperatorDeployResult[]>>}
   */
  public listOperators(
    params: CatalogManagementV1.ListOperatorsParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.OperatorDeployResult[]>> {
    const _params = { ...params };
    const requiredParams = ['xAuthRefreshToken', 'clusterId', 'region', 'versionLocatorId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'cluster_id': _params.clusterId,
      'region': _params.region,
      'version_locator_id': _params.versionLocatorId,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'listOperators'
    );

    const parameters = {
      options: {
        url: '/deploy/kubernetes/olm/operator',
        method: 'GET',
        qs: query,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'X-Auth-Refresh-Token': _params.xAuthRefreshToken,
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Update operators.
   *
   * Update the operators on a kubernetes cluster.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.xAuthRefreshToken - IAM Refresh token.
   * @param {string} [params.clusterId] - Cluster ID.
   * @param {string} [params.region] - Cluster region.
   * @param {string[]} [params.namespaces] - Kube namespaces to deploy Operator(s) to.
   * @param {boolean} [params.allNamespaces] - Denotes whether to install Operator(s) globally.
   * @param {string} [params.versionLocatorId] - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.OperatorDeployResult[]>>}
   */
  public replaceOperators(
    params: CatalogManagementV1.ReplaceOperatorsParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.OperatorDeployResult[]>> {
    const _params = { ...params };
    const requiredParams = ['xAuthRefreshToken'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'cluster_id': _params.clusterId,
      'region': _params.region,
      'namespaces': _params.namespaces,
      'all_namespaces': _params.allNamespaces,
      'version_locator_id': _params.versionLocatorId,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'replaceOperators'
    );

    const parameters = {
      options: {
        url: '/deploy/kubernetes/olm/operator',
        method: 'PUT',
        body,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'X-Auth-Refresh-Token': _params.xAuthRefreshToken,
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Delete operators.
   *
   * Delete operators from a kubernetes cluster.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.xAuthRefreshToken - IAM Refresh token.
   * @param {string} params.clusterId - Cluster identification.
   * @param {string} params.region - Cluster region.
   * @param {string} params.versionLocatorId - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public deleteOperators(
    params: CatalogManagementV1.DeleteOperatorsParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['xAuthRefreshToken', 'clusterId', 'region', 'versionLocatorId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'cluster_id': _params.clusterId,
      'region': _params.region,
      'version_locator_id': _params.versionLocatorId,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'deleteOperators'
    );

    const parameters = {
      options: {
        url: '/deploy/kubernetes/olm/operator',
        method: 'DELETE',
        qs: query,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'X-Auth-Refresh-Token': _params.xAuthRefreshToken,
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Install version.
   *
   * Create an install for the specified version.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {string} params.xAuthRefreshToken - IAM Refresh token.
   * @param {string} [params.clusterId] - Cluster ID.
   * @param {string} [params.region] - Cluster region.
   * @param {string} [params.namespace] - Kube namespace.
   * @param {JsonObject} [params.overrideValues] - Object containing Helm chart override values.  To use a secret for
   * items of type password, specify a JSON encoded value of $ref:#/components/schemas/SecretInstance, prefixed with
   * `cmsm_v1:`.
   * @param {string} [params.entitlementApikey] - Entitlement API Key for this offering.
   * @param {DeployRequestBodySchematics} [params.schematics] - Schematics workspace configuration.
   * @param {string} [params.script] - Script.
   * @param {string} [params.scriptId] - Script ID.
   * @param {string} [params.versionLocatorId] - A dotted value of `catalogID`.`versionID`.
   * @param {string} [params.vcenterId] - VCenter ID.
   * @param {string} [params.vcenterUser] - VCenter User.
   * @param {string} [params.vcenterPassword] - VCenter Password.
   * @param {string} [params.vcenterLocation] - VCenter Location.
   * @param {string} [params.vcenterDatastore] - VCenter Datastore.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public installVersion(
    params: CatalogManagementV1.InstallVersionParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['versionLocId', 'xAuthRefreshToken'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'cluster_id': _params.clusterId,
      'region': _params.region,
      'namespace': _params.namespace,
      'override_values': _params.overrideValues,
      'entitlement_apikey': _params.entitlementApikey,
      'schematics': _params.schematics,
      'script': _params.script,
      'script_id': _params.scriptId,
      'version_locator_id': _params.versionLocatorId,
      'vcenter_id': _params.vcenterId,
      'vcenter_user': _params.vcenterUser,
      'vcenter_password': _params.vcenterPassword,
      'vcenter_location': _params.vcenterLocation,
      'vcenter_datastore': _params.vcenterDatastore,
    };

    const path = {
      'version_loc_id': _params.versionLocId,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'installVersion'
    );

    const parameters = {
      options: {
        url: '/versions/{version_loc_id}/install',
        method: 'POST',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Content-Type': 'application/json',
            'X-Auth-Refresh-Token': _params.xAuthRefreshToken,
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Pre-install version.
   *
   * Create a pre-install for the specified version.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {string} params.xAuthRefreshToken - IAM Refresh token.
   * @param {string} [params.clusterId] - Cluster ID.
   * @param {string} [params.region] - Cluster region.
   * @param {string} [params.namespace] - Kube namespace.
   * @param {JsonObject} [params.overrideValues] - Object containing Helm chart override values.  To use a secret for
   * items of type password, specify a JSON encoded value of $ref:#/components/schemas/SecretInstance, prefixed with
   * `cmsm_v1:`.
   * @param {string} [params.entitlementApikey] - Entitlement API Key for this offering.
   * @param {DeployRequestBodySchematics} [params.schematics] - Schematics workspace configuration.
   * @param {string} [params.script] - Script.
   * @param {string} [params.scriptId] - Script ID.
   * @param {string} [params.versionLocatorId] - A dotted value of `catalogID`.`versionID`.
   * @param {string} [params.vcenterId] - VCenter ID.
   * @param {string} [params.vcenterUser] - VCenter User.
   * @param {string} [params.vcenterPassword] - VCenter Password.
   * @param {string} [params.vcenterLocation] - VCenter Location.
   * @param {string} [params.vcenterDatastore] - VCenter Datastore.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public preinstallVersion(
    params: CatalogManagementV1.PreinstallVersionParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['versionLocId', 'xAuthRefreshToken'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'cluster_id': _params.clusterId,
      'region': _params.region,
      'namespace': _params.namespace,
      'override_values': _params.overrideValues,
      'entitlement_apikey': _params.entitlementApikey,
      'schematics': _params.schematics,
      'script': _params.script,
      'script_id': _params.scriptId,
      'version_locator_id': _params.versionLocatorId,
      'vcenter_id': _params.vcenterId,
      'vcenter_user': _params.vcenterUser,
      'vcenter_password': _params.vcenterPassword,
      'vcenter_location': _params.vcenterLocation,
      'vcenter_datastore': _params.vcenterDatastore,
    };

    const path = {
      'version_loc_id': _params.versionLocId,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'preinstallVersion'
    );

    const parameters = {
      options: {
        url: '/versions/{version_loc_id}/preinstall',
        method: 'POST',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Content-Type': 'application/json',
            'X-Auth-Refresh-Token': _params.xAuthRefreshToken,
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Get version pre-install status.
   *
   * Get the pre-install status for the specified version.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {string} params.xAuthRefreshToken - IAM Refresh token.
   * @param {string} [params.clusterId] - ID of the cluster.
   * @param {string} [params.region] - Cluster region.
   * @param {string} [params.namespace] - Required if the version's pre-install scope is `namespace`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.InstallStatus>>}
   */
  public getPreinstall(
    params: CatalogManagementV1.GetPreinstallParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.InstallStatus>> {
    const _params = { ...params };
    const requiredParams = ['versionLocId', 'xAuthRefreshToken'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'cluster_id': _params.clusterId,
      'region': _params.region,
      'namespace': _params.namespace,
    };

    const path = {
      'version_loc_id': _params.versionLocId,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'getPreinstall'
    );

    const parameters = {
      options: {
        url: '/versions/{version_loc_id}/preinstall',
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
            'X-Auth-Refresh-Token': _params.xAuthRefreshToken,
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Validate offering.
   *
   * Validate the offering associated with the specified version.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {string} params.xAuthRefreshToken - IAM Refresh token.
   * @param {string} [params.clusterId] - Cluster ID.
   * @param {string} [params.region] - Cluster region.
   * @param {string} [params.namespace] - Kube namespace.
   * @param {JsonObject} [params.overrideValues] - Object containing Helm chart override values.  To use a secret for
   * items of type password, specify a JSON encoded value of $ref:#/components/schemas/SecretInstance, prefixed with
   * `cmsm_v1:`.
   * @param {string} [params.entitlementApikey] - Entitlement API Key for this offering.
   * @param {DeployRequestBodySchematics} [params.schematics] - Schematics workspace configuration.
   * @param {string} [params.script] - Script.
   * @param {string} [params.scriptId] - Script ID.
   * @param {string} [params.versionLocatorId] - A dotted value of `catalogID`.`versionID`.
   * @param {string} [params.vcenterId] - VCenter ID.
   * @param {string} [params.vcenterUser] - VCenter User.
   * @param {string} [params.vcenterPassword] - VCenter Password.
   * @param {string} [params.vcenterLocation] - VCenter Location.
   * @param {string} [params.vcenterDatastore] - VCenter Datastore.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public validateInstall(
    params: CatalogManagementV1.ValidateInstallParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['versionLocId', 'xAuthRefreshToken'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'cluster_id': _params.clusterId,
      'region': _params.region,
      'namespace': _params.namespace,
      'override_values': _params.overrideValues,
      'entitlement_apikey': _params.entitlementApikey,
      'schematics': _params.schematics,
      'script': _params.script,
      'script_id': _params.scriptId,
      'version_locator_id': _params.versionLocatorId,
      'vcenter_id': _params.vcenterId,
      'vcenter_user': _params.vcenterUser,
      'vcenter_password': _params.vcenterPassword,
      'vcenter_location': _params.vcenterLocation,
      'vcenter_datastore': _params.vcenterDatastore,
    };

    const path = {
      'version_loc_id': _params.versionLocId,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'validateInstall'
    );

    const parameters = {
      options: {
        url: '/versions/{version_loc_id}/validation/install',
        method: 'POST',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Content-Type': 'application/json',
            'X-Auth-Refresh-Token': _params.xAuthRefreshToken,
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Get offering install status.
   *
   * Returns the install status for the specified offering version.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {string} params.xAuthRefreshToken - IAM Refresh token.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Validation>>}
   */
  public getValidationStatus(
    params: CatalogManagementV1.GetValidationStatusParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Validation>> {
    const _params = { ...params };
    const requiredParams = ['versionLocId', 'xAuthRefreshToken'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'version_loc_id': _params.versionLocId,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'getValidationStatus'
    );

    const parameters = {
      options: {
        url: '/versions/{version_loc_id}/validation/install',
        method: 'GET',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'X-Auth-Refresh-Token': _params.xAuthRefreshToken,
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Get override values.
   *
   * Returns the override values that were used to validate the specified offering version.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.JsonObject>>}
   */
  public getOverrideValues(
    params: CatalogManagementV1.GetOverrideValuesParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.JsonObject>> {
    const _params = { ...params };
    const requiredParams = ['versionLocId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'version_loc_id': _params.versionLocId,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'getOverrideValues'
    );

    const parameters = {
      options: {
        url: '/versions/{version_loc_id}/validation/overridevalues',
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

  /*************************
   * objects
   ************************/

  /**
   * List objects across catalogs.
   *
   * List the available objects from both public and private catalogs. These copies cannot be used for updating. They
   * are not complete and only return what is visible to the caller.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.query - Lucene query string.
   * @param {number} [params.limit] - The maximum number of results to return.
   * @param {number} [params.offset] - The number of results to skip before returning values.
   * @param {boolean} [params.collapse] - When true, hide private objects that correspond to public or IBM published
   * objects.
   * @param {boolean} [params.digest] - Display a digests of search results, has default value of true.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.ObjectSearchResult>>}
   */
  public searchObjects(
    params: CatalogManagementV1.SearchObjectsParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.ObjectSearchResult>> {
    const _params = { ...params };
    const requiredParams = ['query'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'query': _params.query,
      'limit': _params.limit,
      'offset': _params.offset,
      'collapse': _params.collapse,
      'digest': _params.digest,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'searchObjects'
    );

    const parameters = {
      options: {
        url: '/objects',
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

  /**
   * List objects within a catalog.
   *
   * List the available objects within the specified catalog.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {number} [params.limit] - The number of results to return.
   * @param {number} [params.offset] - The number of results to skip before returning values.
   * @param {string} [params.name] - Only return results that contain the specified string.
   * @param {string} [params.sort] - The field on which the output is sorted. Sorts by default by **label** property.
   * Available fields are **name**, **label**, **created**, and **updated**. By adding **-** (i.e. **-label**) in front
   * of the query string, you can specify descending order. Default is ascending order.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.ObjectListResult>>}
   */
  public listObjects(
    params: CatalogManagementV1.ListObjectsParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.ObjectListResult>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'limit': _params.limit,
      'offset': _params.offset,
      'name': _params.name,
      'sort': _params.sort,
    };

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
    };

    const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'listObjects');

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}/objects',
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
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Create catalog object.
   *
   * Create an object with a specific catalog.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} [params.id] - unique id.
   * @param {string} [params.name] - The programmatic name of this offering.
   * @param {string} [params.rev] - Cloudant revision.
   * @param {string} [params.crn] - The crn for this specific object.
   * @param {string} [params.url] - The url for this specific object.
   * @param {string} [params.parentId] - The parent for this specific object.
   * @param {string} [params.labelI18n] - Translated display name in the requested language.
   * @param {string} [params.label] - Display name in the requested language.
   * @param {string[]} [params.tags] - List of tags associated with this catalog.
   * @param {string} [params.created] - The date and time this catalog was created.
   * @param {string} [params.updated] - The date and time this catalog was last updated.
   * @param {string} [params.shortDescription] - Short description in the requested language.
   * @param {string} [params.shortDescriptionI18n] - Short description translation.
   * @param {string} [params.kind] - Kind of object.
   * @param {PublishObject} [params.publish] - Publish information.
   * @param {State} [params.state] - Offering state.
   * @param {string} [params.catalogId] - The id of the catalog containing this offering.
   * @param {string} [params.catalogName] - The name of the catalog.
   * @param {JsonObject} [params.data] - Map of data values for this object.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.CatalogObject>>}
   */
  public createObject(
    params: CatalogManagementV1.CreateObjectParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.CatalogObject>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'id': _params.id,
      'name': _params.name,
      '_rev': _params.rev,
      'crn': _params.crn,
      'url': _params.url,
      'parent_id': _params.parentId,
      'label_i18n': _params.labelI18n,
      'label': _params.label,
      'tags': _params.tags,
      'created': _params.created,
      'updated': _params.updated,
      'short_description': _params.shortDescription,
      'short_description_i18n': _params.shortDescriptionI18n,
      'kind': _params.kind,
      'publish': _params.publish,
      'state': _params.state,
      'catalog_id': _params.catalogId,
      'catalog_name': _params.catalogName,
      'data': _params.data,
    };

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'createObject'
    );

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}/objects',
        method: 'POST',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Get catalog object.
   *
   * Get the specified object from within the specified catalog.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.objectIdentifier - Object identifier.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.CatalogObject>>}
   */
  public getObject(
    params: CatalogManagementV1.GetObjectParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.CatalogObject>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier', 'objectIdentifier'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
      'object_identifier': _params.objectIdentifier,
    };

    const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getObject');

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}/objects/{object_identifier}',
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
   * Update catalog object.
   *
   * Update an object within a specific catalog.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.objectIdentifier - Object identifier.
   * @param {string} [params.id] - unique id.
   * @param {string} [params.name] - The programmatic name of this offering.
   * @param {string} [params.rev] - Cloudant revision.
   * @param {string} [params.crn] - The crn for this specific object.
   * @param {string} [params.url] - The url for this specific object.
   * @param {string} [params.parentId] - The parent for this specific object.
   * @param {string} [params.labelI18n] - Translated display name in the requested language.
   * @param {string} [params.label] - Display name in the requested language.
   * @param {string[]} [params.tags] - List of tags associated with this catalog.
   * @param {string} [params.created] - The date and time this catalog was created.
   * @param {string} [params.updated] - The date and time this catalog was last updated.
   * @param {string} [params.shortDescription] - Short description in the requested language.
   * @param {string} [params.shortDescriptionI18n] - Short description translation.
   * @param {string} [params.kind] - Kind of object.
   * @param {PublishObject} [params.publish] - Publish information.
   * @param {State} [params.state] - Offering state.
   * @param {string} [params.catalogId] - The id of the catalog containing this offering.
   * @param {string} [params.catalogName] - The name of the catalog.
   * @param {JsonObject} [params.data] - Map of data values for this object.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.CatalogObject>>}
   */
  public replaceObject(
    params: CatalogManagementV1.ReplaceObjectParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.CatalogObject>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier', 'objectIdentifier'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'id': _params.id,
      'name': _params.name,
      '_rev': _params.rev,
      'crn': _params.crn,
      'url': _params.url,
      'parent_id': _params.parentId,
      'label_i18n': _params.labelI18n,
      'label': _params.label,
      'tags': _params.tags,
      'created': _params.created,
      'updated': _params.updated,
      'short_description': _params.shortDescription,
      'short_description_i18n': _params.shortDescriptionI18n,
      'kind': _params.kind,
      'publish': _params.publish,
      'state': _params.state,
      'catalog_id': _params.catalogId,
      'catalog_name': _params.catalogName,
      'data': _params.data,
    };

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
      'object_identifier': _params.objectIdentifier,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'replaceObject'
    );

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}/objects/{object_identifier}',
        method: 'PUT',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Delete catalog object.
   *
   * Delete a specific object within a specific catalog.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.objectIdentifier - Object identifier.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public deleteObject(
    params: CatalogManagementV1.DeleteObjectParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier', 'objectIdentifier'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
      'object_identifier': _params.objectIdentifier,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'deleteObject'
    );

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}/objects/{object_identifier}',
        method: 'DELETE',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {}, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Get catalog object audit log.
   *
   * Get the audit log associated with a specific catalog object.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.objectIdentifier - Object identifier.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.AuditLog>>}
   */
  public getObjectAudit(
    params: CatalogManagementV1.GetObjectAuditParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.AuditLog>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier', 'objectIdentifier'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
      'object_identifier': _params.objectIdentifier,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'getObjectAudit'
    );

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}/objects/{object_identifier}/audit',
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
   * Publish object to account.
   *
   * Publish a catalog object to account.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.objectIdentifier - Object identifier.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public accountPublishObject(
    params: CatalogManagementV1.AccountPublishObjectParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier', 'objectIdentifier'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
      'object_identifier': _params.objectIdentifier,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'accountPublishObject'
    );

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}/objects/{object_identifier}/account-publish',
        method: 'POST',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {}, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Publish object to share with allow list.
   *
   * Publish the specified object so that it is visible to those in the allow list.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.objectIdentifier - Object identifier.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public sharedPublishObject(
    params: CatalogManagementV1.SharedPublishObjectParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier', 'objectIdentifier'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
      'object_identifier': _params.objectIdentifier,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'sharedPublishObject'
    );

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}/objects/{object_identifier}/shared-publish',
        method: 'POST',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {}, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Publish object to share with IBMers.
   *
   * Publish the specified object so that it is visible to IBMers in the public catalog.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.objectIdentifier - Object identifier.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public ibmPublishObject(
    params: CatalogManagementV1.IbmPublishObjectParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier', 'objectIdentifier'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
      'object_identifier': _params.objectIdentifier,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'ibmPublishObject'
    );

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}/objects/{object_identifier}/ibm-publish',
        method: 'POST',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {}, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Publish object to share with all users.
   *
   * Publish the specified object so it is visible to all users in the public catalog.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.objectIdentifier - Object identifier.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public publicPublishObject(
    params: CatalogManagementV1.PublicPublishObjectParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier', 'objectIdentifier'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
      'object_identifier': _params.objectIdentifier,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'publicPublishObject'
    );

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}/objects/{object_identifier}/public-publish',
        method: 'POST',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {}, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Add account ID to object access list.
   *
   * Add an account ID to an object's access list.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.objectIdentifier - Object identifier.
   * @param {string} params.accountIdentifier - Account identifier.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public createObjectAccess(
    params: CatalogManagementV1.CreateObjectAccessParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier', 'objectIdentifier', 'accountIdentifier'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
      'object_identifier': _params.objectIdentifier,
      'account_identifier': _params.accountIdentifier,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'createObjectAccess'
    );

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}/objects/{object_identifier}/access/{account_identifier}',
        method: 'POST',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {}, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Check for account ID in object access list.
   *
   * Determine if an account ID is in an object's access list.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.objectIdentifier - Object identifier.
   * @param {string} params.accountIdentifier - Account identifier.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.ObjectAccess>>}
   */
  public getObjectAccess(
    params: CatalogManagementV1.GetObjectAccessParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.ObjectAccess>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier', 'objectIdentifier', 'accountIdentifier'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
      'object_identifier': _params.objectIdentifier,
      'account_identifier': _params.accountIdentifier,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'getObjectAccess'
    );

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}/objects/{object_identifier}/access/{account_identifier}',
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
   * Remove account ID from object access list.
   *
   * Delete the specified account ID from the specified object's access list.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.objectIdentifier - Object identifier.
   * @param {string} params.accountIdentifier - Account identifier.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public deleteObjectAccess(
    params: CatalogManagementV1.DeleteObjectAccessParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier', 'objectIdentifier', 'accountIdentifier'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
      'object_identifier': _params.objectIdentifier,
      'account_identifier': _params.accountIdentifier,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'deleteObjectAccess'
    );

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}/objects/{object_identifier}/access/{account_identifier}',
        method: 'DELETE',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {}, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Get object access list.
   *
   * Get the access list associated with the specified object.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.objectIdentifier - Object identifier.
   * @param {number} [params.limit] - The maximum number of results to return.
   * @param {number} [params.offset] - The number of results to skip before returning values.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.ObjectAccessListResult>>}
   */
  public getObjectAccessList(
    params: CatalogManagementV1.GetObjectAccessListParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.ObjectAccessListResult>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier', 'objectIdentifier'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'limit': _params.limit,
      'offset': _params.offset,
    };

    const path = {
      'catalog_identifier': _params.catalogIdentifier,
      'object_identifier': _params.objectIdentifier,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'getObjectAccessList'
    );

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}/objects/{object_identifier}/access',
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
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Delete accounts from object access list.
   *
   * Delete all or a set of accounts from an object's access list.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.objectIdentifier - Object identifier.
   * @param {string[]} params.accounts - A list of accounts to delete.  An entry with star["*"] will remove all
   * accounts.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.AccessListBulkResponse>>}
   */
  public deleteObjectAccessList(
    params: CatalogManagementV1.DeleteObjectAccessListParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.AccessListBulkResponse>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier', 'objectIdentifier', 'accounts'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = _params.accounts;
    const path = {
      'catalog_identifier': _params.catalogIdentifier,
      'object_identifier': _params.objectIdentifier,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'deleteObjectAccessList'
    );

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}/objects/{object_identifier}/access',
        method: 'DELETE',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Add accounts to object access list.
   *
   * Add one or more accounts to the specified object's access list.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.objectIdentifier - Object identifier.
   * @param {string[]} params.accounts - A list of accounts to add.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.AccessListBulkResponse>>}
   */
  public addObjectAccessList(
    params: CatalogManagementV1.AddObjectAccessListParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.AccessListBulkResponse>> {
    const _params = { ...params };
    const requiredParams = ['catalogIdentifier', 'objectIdentifier', 'accounts'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = _params.accounts;
    const path = {
      'catalog_identifier': _params.catalogIdentifier,
      'object_identifier': _params.objectIdentifier,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'addObjectAccessList'
    );

    const parameters = {
      options: {
        url: '/catalogs/{catalog_identifier}/objects/{object_identifier}/access',
        method: 'POST',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /*************************
   * instances
   ************************/

  /**
   * Create an offering resource instance.
   *
   * Provision a new offering in a given account, and return its resource instance.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.xAuthRefreshToken - IAM Refresh token.
   * @param {string} [params.id] - provisioned instance ID (part of the CRN).
   * @param {string} [params.rev] - Cloudant revision.
   * @param {string} [params.url] - url reference to this object.
   * @param {string} [params.crn] - platform CRN for this instance.
   * @param {string} [params.label] - the label for this instance.
   * @param {string} [params.catalogId] - Catalog ID this instance was created from.
   * @param {string} [params.offeringId] - Offering ID this instance was created from.
   * @param {string} [params.kindFormat] - the format this instance has (helm, operator, ova...).
   * @param {string} [params.version] - The version this instance was installed from (not version id).
   * @param {string} [params.clusterId] - Cluster ID.
   * @param {string} [params.clusterRegion] - Cluster region (e.g., us-south).
   * @param {string[]} [params.clusterNamespaces] - List of target namespaces to install into.
   * @param {boolean} [params.clusterAllNamespaces] - designate to install into all namespaces.
   * @param {string} [params.schematicsWorkspaceId] - Id of the schematics workspace, for offering instances provisioned
   * through schematics.
   * @param {string} [params.resourceGroupId] - Id of the resource group to provision the offering instance into.
   * @param {string} [params.installPlan] - Type of install plan (also known as approval strategy) for operator
   * subscriptions. Can be either automatic, which automatically upgrades operators to the latest in a channel, or
   * manual, which requires approval on the cluster.
   * @param {string} [params.channel] - Channel to pin the operator subscription to.
   * @param {JsonObject} [params.metadata] - Map of metadata values for this offering instance.
   * @param {OfferingInstanceLastOperation} [params.lastOperation] - the last operation performed and status.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.OfferingInstance>>}
   */
  public createOfferingInstance(
    params: CatalogManagementV1.CreateOfferingInstanceParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.OfferingInstance>> {
    const _params = { ...params };
    const requiredParams = ['xAuthRefreshToken'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'id': _params.id,
      '_rev': _params.rev,
      'url': _params.url,
      'crn': _params.crn,
      'label': _params.label,
      'catalog_id': _params.catalogId,
      'offering_id': _params.offeringId,
      'kind_format': _params.kindFormat,
      'version': _params.version,
      'cluster_id': _params.clusterId,
      'cluster_region': _params.clusterRegion,
      'cluster_namespaces': _params.clusterNamespaces,
      'cluster_all_namespaces': _params.clusterAllNamespaces,
      'schematics_workspace_id': _params.schematicsWorkspaceId,
      'resource_group_id': _params.resourceGroupId,
      'install_plan': _params.installPlan,
      'channel': _params.channel,
      'metadata': _params.metadata,
      'last_operation': _params.lastOperation,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'createOfferingInstance'
    );

    const parameters = {
      options: {
        url: '/instances/offerings',
        method: 'POST',
        body,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'X-Auth-Refresh-Token': _params.xAuthRefreshToken,
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Get Offering Instance.
   *
   * Get the resource associated with an installed offering instance.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.instanceIdentifier - Version Instance identifier.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.OfferingInstance>>}
   */
  public getOfferingInstance(
    params: CatalogManagementV1.GetOfferingInstanceParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.OfferingInstance>> {
    const _params = { ...params };
    const requiredParams = ['instanceIdentifier'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'instance_identifier': _params.instanceIdentifier,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'getOfferingInstance'
    );

    const parameters = {
      options: {
        url: '/instances/offerings/{instance_identifier}',
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
   * Update Offering Instance.
   *
   * Update an installed offering instance.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.instanceIdentifier - Version Instance identifier.
   * @param {string} params.xAuthRefreshToken - IAM Refresh token.
   * @param {string} [params.id] - provisioned instance ID (part of the CRN).
   * @param {string} [params.rev] - Cloudant revision.
   * @param {string} [params.url] - url reference to this object.
   * @param {string} [params.crn] - platform CRN for this instance.
   * @param {string} [params.label] - the label for this instance.
   * @param {string} [params.catalogId] - Catalog ID this instance was created from.
   * @param {string} [params.offeringId] - Offering ID this instance was created from.
   * @param {string} [params.kindFormat] - the format this instance has (helm, operator, ova...).
   * @param {string} [params.version] - The version this instance was installed from (not version id).
   * @param {string} [params.clusterId] - Cluster ID.
   * @param {string} [params.clusterRegion] - Cluster region (e.g., us-south).
   * @param {string[]} [params.clusterNamespaces] - List of target namespaces to install into.
   * @param {boolean} [params.clusterAllNamespaces] - designate to install into all namespaces.
   * @param {string} [params.schematicsWorkspaceId] - Id of the schematics workspace, for offering instances provisioned
   * through schematics.
   * @param {string} [params.resourceGroupId] - Id of the resource group to provision the offering instance into.
   * @param {string} [params.installPlan] - Type of install plan (also known as approval strategy) for operator
   * subscriptions. Can be either automatic, which automatically upgrades operators to the latest in a channel, or
   * manual, which requires approval on the cluster.
   * @param {string} [params.channel] - Channel to pin the operator subscription to.
   * @param {JsonObject} [params.metadata] - Map of metadata values for this offering instance.
   * @param {OfferingInstanceLastOperation} [params.lastOperation] - the last operation performed and status.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.OfferingInstance>>}
   */
  public putOfferingInstance(
    params: CatalogManagementV1.PutOfferingInstanceParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.OfferingInstance>> {
    const _params = { ...params };
    const requiredParams = ['instanceIdentifier', 'xAuthRefreshToken'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'id': _params.id,
      '_rev': _params.rev,
      'url': _params.url,
      'crn': _params.crn,
      'label': _params.label,
      'catalog_id': _params.catalogId,
      'offering_id': _params.offeringId,
      'kind_format': _params.kindFormat,
      'version': _params.version,
      'cluster_id': _params.clusterId,
      'cluster_region': _params.clusterRegion,
      'cluster_namespaces': _params.clusterNamespaces,
      'cluster_all_namespaces': _params.clusterAllNamespaces,
      'schematics_workspace_id': _params.schematicsWorkspaceId,
      'resource_group_id': _params.resourceGroupId,
      'install_plan': _params.installPlan,
      'channel': _params.channel,
      'metadata': _params.metadata,
      'last_operation': _params.lastOperation,
    };

    const path = {
      'instance_identifier': _params.instanceIdentifier,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'putOfferingInstance'
    );

    const parameters = {
      options: {
        url: '/instances/offerings/{instance_identifier}',
        method: 'PUT',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'X-Auth-Refresh-Token': _params.xAuthRefreshToken,
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Delete a version instance.
   *
   * Delete and instance deployed out of a product version.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.instanceIdentifier - Version Instance identifier.
   * @param {string} params.xAuthRefreshToken - IAM Refresh token.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public deleteOfferingInstance(
    params: CatalogManagementV1.DeleteOfferingInstanceParams
  ): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['instanceIdentifier', 'xAuthRefreshToken'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'instance_identifier': _params.instanceIdentifier,
    };

    const sdkHeaders = getSdkHeaders(
      CatalogManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'deleteOfferingInstance'
    );

    const parameters = {
      options: {
        url: '/instances/offerings/{instance_identifier}',
        method: 'DELETE',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'X-Auth-Refresh-Token': _params.xAuthRefreshToken,
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

namespace CatalogManagementV1 {
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

  /** Parameters for the `getCatalogAccount` operation. */
  export interface GetCatalogAccountParams {
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `updateCatalogAccount` operation. */
  export interface UpdateCatalogAccountParams {
    /** Account identification. */
    id?: string;
    /** Hide the public catalog in this account. */
    hideIbmCloudCatalog?: boolean;
    /** Filters for account and catalog filters. */
    accountFilters?: Filters;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getCatalogAccountAudit` operation. */
  export interface GetCatalogAccountAuditParams {
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getCatalogAccountFilters` operation. */
  export interface GetCatalogAccountFiltersParams {
    /** catalog id. Narrow down filters to the account and just the one catalog. */
    catalog?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listCatalogs` operation. */
  export interface ListCatalogsParams {
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `createCatalog` operation. */
  export interface CreateCatalogParams {
    /** Unique ID. */
    id?: string;
    /** Cloudant revision. */
    rev?: string;
    /** Display Name in the requested language. */
    label?: string;
    /** Description in the requested language. */
    shortDescription?: string;
    /** URL for an icon associated with this catalog. */
    catalogIconUrl?: string;
    /** List of tags associated with this catalog. */
    tags?: string[];
    /** List of features associated with this catalog. */
    features?: Feature[];
    /** Denotes whether a catalog is disabled. */
    disabled?: boolean;
    /** Resource group id the catalog is owned by. */
    resourceGroupId?: string;
    /** Account that owns catalog. */
    owningAccount?: string;
    /** Filters for account and catalog filters. */
    catalogFilters?: Filters;
    /** Feature information. */
    syndicationSettings?: SyndicationResource;
    /** Kind of catalog. Supported kinds are offering and vpe. */
    kind?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getCatalog` operation. */
  export interface GetCatalogParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `replaceCatalog` operation. */
  export interface ReplaceCatalogParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** Unique ID. */
    id?: string;
    /** Cloudant revision. */
    rev?: string;
    /** Display Name in the requested language. */
    label?: string;
    /** Description in the requested language. */
    shortDescription?: string;
    /** URL for an icon associated with this catalog. */
    catalogIconUrl?: string;
    /** List of tags associated with this catalog. */
    tags?: string[];
    /** List of features associated with this catalog. */
    features?: Feature[];
    /** Denotes whether a catalog is disabled. */
    disabled?: boolean;
    /** Resource group id the catalog is owned by. */
    resourceGroupId?: string;
    /** Account that owns catalog. */
    owningAccount?: string;
    /** Filters for account and catalog filters. */
    catalogFilters?: Filters;
    /** Feature information. */
    syndicationSettings?: SyndicationResource;
    /** Kind of catalog. Supported kinds are offering and vpe. */
    kind?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deleteCatalog` operation. */
  export interface DeleteCatalogParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getCatalogAudit` operation. */
  export interface GetCatalogAuditParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getConsumptionOfferings` operation. */
  export interface GetConsumptionOfferingsParams {
    /** true - Strip down the content of what is returned. For example don't return the readme. Makes the result
     *  much smaller. Defaults to false.
     */
    digest?: boolean;
    /** catalog id. Narrow search down to just a particular catalog. It will apply the catalog's public filters to
     *  the public catalog offerings on the result.
     */
    catalog?: string;
    /** What should be selected. Default is 'all' which will return both public and private offerings. 'public'
     *  returns only the public offerings and 'private' returns only the private offerings.
     */
    select?: GetConsumptionOfferingsConstants.Select | string;
    /** true - include offerings which have been marked as hidden. The default is false and hidden offerings are not
     *  returned.
     */
    includeHidden?: boolean;
    /** number or results to return. */
    limit?: number;
    /** number of results to skip before returning values. */
    offset?: number;
    headers?: OutgoingHttpHeaders;
  }

  /** Constants for the `getConsumptionOfferings` operation. */
  export namespace GetConsumptionOfferingsConstants {
    /** What should be selected. Default is 'all' which will return both public and private offerings. 'public' returns only the public offerings and 'private' returns only the private offerings. */
    export enum Select {
      ALL = 'all',
      PUBLIC = 'public',
      PRIVATE = 'private',
    }
  }

  /** Parameters for the `listOfferings` operation. */
  export interface ListOfferingsParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** true - Strip down the content of what is returned. For example don't return the readme. Makes the result
     *  much smaller. Defaults to false.
     */
    digest?: boolean;
    /** The maximum number of results to return. */
    limit?: number;
    /** The number of results to skip before returning values. */
    offset?: number;
    /** Only return results that contain the specified string. */
    name?: string;
    /** The field on which the output is sorted. Sorts by default by **label** property. Available fields are
     *  **name**, **label**, **created**, and **updated**. By adding **-** (i.e. **-label**) in front of the query
     *  string, you can specify descending order. Default is ascending order.
     */
    sort?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `createOffering` operation. */
  export interface CreateOfferingParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** unique id. */
    id?: string;
    /** Cloudant revision. */
    rev?: string;
    /** The url for this specific offering. */
    url?: string;
    /** The crn for this specific offering. */
    crn?: string;
    /** Display Name in the requested language. */
    label?: string;
    /** The programmatic name of this offering. */
    name?: string;
    /** URL for an icon associated with this offering. */
    offeringIconUrl?: string;
    /** URL for an additional docs with this offering. */
    offeringDocsUrl?: string;
    /** URL to be displayed in the Consumption UI for getting support on this offering. */
    offeringSupportUrl?: string;
    /** List of tags associated with this catalog. */
    tags?: string[];
    /** List of keywords associated with offering, typically used to search for it. */
    keywords?: string[];
    /** Repository info for offerings. */
    rating?: Rating;
    /** The date and time this catalog was created. */
    created?: string;
    /** The date and time this catalog was last updated. */
    updated?: string;
    /** Short description in the requested language. */
    shortDescription?: string;
    /** Long description in the requested language. */
    longDescription?: string;
    /** list of features associated with this offering. */
    features?: Feature[];
    /** Array of kind. */
    kinds?: Kind[];
    /** Is it permitted to request publishing to IBM or Public. */
    permitRequestIbmPublicPublish?: boolean;
    /** Indicates if this offering has been approved for use by all IBMers. */
    ibmPublishApproved?: boolean;
    /** Indicates if this offering has been approved for use by all IBM Cloud users. */
    publicPublishApproved?: boolean;
    /** The original offering CRN that this publish entry came from. */
    publicOriginalCrn?: string;
    /** The crn of the public catalog entry of this offering. */
    publishPublicCrn?: string;
    /** The portal's approval record ID. */
    portalApprovalRecord?: string;
    /** The portal UI URL. */
    portalUiUrl?: string;
    /** The id of the catalog containing this offering. */
    catalogId?: string;
    /** The name of the catalog. */
    catalogName?: string;
    /** Map of metadata values for this offering. */
    metadata?: JsonObject;
    /** A disclaimer for this offering. */
    disclaimer?: string;
    /** Determine if this offering should be displayed in the Consumption UI. */
    hidden?: boolean;
    /** Provider of this offering. */
    provider?: string;
    /** Repository info for offerings. */
    repoInfo?: RepoInfo;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `importOfferingVersion` operation. */
  export interface ImportOfferingVersionParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** Offering identification. */
    offeringId: string;
    /** Tags array. */
    tags?: string[];
    /** Target kinds.  Current valid values are 'iks', 'roks', 'vcenter', and 'terraform'. */
    targetKinds?: string[];
    /** byte array representing the content to be imported.  Only supported for OVA images at this time. */
    content?: string;
    /** URL path to zip location.  If not specified, must provide content in the body of this call. */
    zipurl?: string;
    /** The semver value for this new version, if not found in the zip url package content. */
    targetVersion?: string;
    /** Add all possible configuration values to this version when importing. */
    includeConfig?: boolean;
    /** Indicates that the current terraform template is used to install a VSI Image. */
    isVsi?: boolean;
    /** The type of repository containing this version.  Valid values are 'public_git' or 'enterprise_git'. */
    repoType?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `importOffering` operation. */
  export interface ImportOfferingParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** Tags array. */
    tags?: string[];
    /** Target kinds.  Current valid values are 'iks', 'roks', 'vcenter', and 'terraform'. */
    targetKinds?: string[];
    /** byte array representing the content to be imported.  Only supported for OVA images at this time. */
    content?: string;
    /** URL path to zip location.  If not specified, must provide content in this post body. */
    zipurl?: string;
    /** Re-use the specified offeringID during import. */
    offeringId?: string;
    /** The semver value for this new version. */
    targetVersion?: string;
    /** Add all possible configuration items when creating this version. */
    includeConfig?: boolean;
    /** Indicates that the current terraform template is used to install a VSI Image. */
    isVsi?: boolean;
    /** The type of repository containing this version.  Valid values are 'public_git' or 'enterprise_git'. */
    repoType?: string;
    /** Authentication token used to access the specified zip file. */
    xAuthToken?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `reloadOffering` operation. */
  export interface ReloadOfferingParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** Offering identification. */
    offeringId: string;
    /** The semver value for this new version. */
    targetVersion: string;
    /** Tags array. */
    tags?: string[];
    /** Target kinds.  Current valid values are 'iks', 'roks', 'vcenter', and 'terraform'. */
    targetKinds?: string[];
    /** byte array representing the content to be imported.  Only supported for OVA images at this time. */
    content?: string;
    /** URL path to zip location.  If not specified, must provide content in this post body. */
    zipurl?: string;
    /** The type of repository containing this version.  Valid values are 'public_git' or 'enterprise_git'. */
    repoType?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getOffering` operation. */
  export interface GetOfferingParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** Offering identification. */
    offeringId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `replaceOffering` operation. */
  export interface ReplaceOfferingParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** Offering identification. */
    offeringId: string;
    /** unique id. */
    id?: string;
    /** Cloudant revision. */
    rev?: string;
    /** The url for this specific offering. */
    url?: string;
    /** The crn for this specific offering. */
    crn?: string;
    /** Display Name in the requested language. */
    label?: string;
    /** The programmatic name of this offering. */
    name?: string;
    /** URL for an icon associated with this offering. */
    offeringIconUrl?: string;
    /** URL for an additional docs with this offering. */
    offeringDocsUrl?: string;
    /** URL to be displayed in the Consumption UI for getting support on this offering. */
    offeringSupportUrl?: string;
    /** List of tags associated with this catalog. */
    tags?: string[];
    /** List of keywords associated with offering, typically used to search for it. */
    keywords?: string[];
    /** Repository info for offerings. */
    rating?: Rating;
    /** The date and time this catalog was created. */
    created?: string;
    /** The date and time this catalog was last updated. */
    updated?: string;
    /** Short description in the requested language. */
    shortDescription?: string;
    /** Long description in the requested language. */
    longDescription?: string;
    /** list of features associated with this offering. */
    features?: Feature[];
    /** Array of kind. */
    kinds?: Kind[];
    /** Is it permitted to request publishing to IBM or Public. */
    permitRequestIbmPublicPublish?: boolean;
    /** Indicates if this offering has been approved for use by all IBMers. */
    ibmPublishApproved?: boolean;
    /** Indicates if this offering has been approved for use by all IBM Cloud users. */
    publicPublishApproved?: boolean;
    /** The original offering CRN that this publish entry came from. */
    publicOriginalCrn?: string;
    /** The crn of the public catalog entry of this offering. */
    publishPublicCrn?: string;
    /** The portal's approval record ID. */
    portalApprovalRecord?: string;
    /** The portal UI URL. */
    portalUiUrl?: string;
    /** The id of the catalog containing this offering. */
    catalogId?: string;
    /** The name of the catalog. */
    catalogName?: string;
    /** Map of metadata values for this offering. */
    metadata?: JsonObject;
    /** A disclaimer for this offering. */
    disclaimer?: string;
    /** Determine if this offering should be displayed in the Consumption UI. */
    hidden?: boolean;
    /** Provider of this offering. */
    provider?: string;
    /** Repository info for offerings. */
    repoInfo?: RepoInfo;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deleteOffering` operation. */
  export interface DeleteOfferingParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** Offering identification. */
    offeringId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getOfferingAudit` operation. */
  export interface GetOfferingAuditParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** Offering identifier. */
    offeringId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `replaceOfferingIcon` operation. */
  export interface ReplaceOfferingIconParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** Offering identification. */
    offeringId: string;
    /** Name of the file name that is being uploaded. */
    fileName: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `updateOfferingIbm` operation. */
  export interface UpdateOfferingIbmParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** Offering identification. */
    offeringId: string;
    /** Type of approval, ibm or public. */
    approvalType: UpdateOfferingIbmConstants.ApprovalType | string;
    /** Approve (true) or disapprove (false). */
    approved: UpdateOfferingIbmConstants.Approved | string;
    headers?: OutgoingHttpHeaders;
  }

  /** Constants for the `updateOfferingIbm` operation. */
  export namespace UpdateOfferingIbmConstants {
    /** Type of approval, ibm or public. */
    export enum ApprovalType {
      ALLOW_REQUEST = 'allow_request',
      IBM = 'ibm',
      PUBLIC = 'public',
    }
    /** Approve (true) or disapprove (false). */
    export enum Approved {
      TRUE = 'true',
      FALSE = 'false',
    }
  }

  /** Parameters for the `getOfferingUpdates` operation. */
  export interface GetOfferingUpdatesParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** Offering identification. */
    offeringId: string;
    /** The kind of offering (e.g, helm, ova, terraform ...). */
    kind: string;
    /** optionaly provide an existing version to check updates for if one is not given, all version will be
     *  returned.
     */
    version?: string;
    /** The id of the cluster where this version was installed. */
    clusterId?: string;
    /** The region of the cluster where this version was installed. */
    region?: string;
    /** The resource group id of the cluster where this version was installed. */
    resourceGroupId?: string;
    /** The namespace of the cluster where this version was installed. */
    namespace?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getOfferingAbout` operation. */
  export interface GetOfferingAboutParams {
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getOfferingLicense` operation. */
  export interface GetOfferingLicenseParams {
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocId: string;
    /** The ID of the license, which maps to the file name in the 'licenses' directory of this verions tgz file. */
    licenseId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getOfferingContainerImages` operation. */
  export interface GetOfferingContainerImagesParams {
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deprecateVersion` operation. */
  export interface DeprecateVersionParams {
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `accountPublishVersion` operation. */
  export interface AccountPublishVersionParams {
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `ibmPublishVersion` operation. */
  export interface IbmPublishVersionParams {
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `publicPublishVersion` operation. */
  export interface PublicPublishVersionParams {
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `commitVersion` operation. */
  export interface CommitVersionParams {
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `copyVersion` operation. */
  export interface CopyVersionParams {
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocId: string;
    /** Tags array. */
    tags?: string[];
    /** Target kinds.  Current valid values are 'iks', 'roks', 'vcenter', and 'terraform'. */
    targetKinds?: string[];
    /** byte array representing the content to be imported.  Only supported for OVA images at this time. */
    content?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getOfferingWorkingCopy` operation. */
  export interface GetOfferingWorkingCopyParams {
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getVersion` operation. */
  export interface GetVersionParams {
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deleteVersion` operation. */
  export interface DeleteVersionParams {
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getCluster` operation. */
  export interface GetClusterParams {
    /** ID of the cluster. */
    clusterId: string;
    /** Region of the cluster. */
    region: string;
    /** IAM Refresh token. */
    xAuthRefreshToken: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getNamespaces` operation. */
  export interface GetNamespacesParams {
    /** ID of the cluster. */
    clusterId: string;
    /** Cluster region. */
    region: string;
    /** IAM Refresh token. */
    xAuthRefreshToken: string;
    /** The maximum number of results to return. */
    limit?: number;
    /** The number of results to skip before returning values. */
    offset?: number;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deployOperators` operation. */
  export interface DeployOperatorsParams {
    /** IAM Refresh token. */
    xAuthRefreshToken: string;
    /** Cluster ID. */
    clusterId?: string;
    /** Cluster region. */
    region?: string;
    /** Kube namespaces to deploy Operator(s) to. */
    namespaces?: string[];
    /** Denotes whether to install Operator(s) globally. */
    allNamespaces?: boolean;
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocatorId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listOperators` operation. */
  export interface ListOperatorsParams {
    /** IAM Refresh token. */
    xAuthRefreshToken: string;
    /** Cluster identification. */
    clusterId: string;
    /** Cluster region. */
    region: string;
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocatorId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `replaceOperators` operation. */
  export interface ReplaceOperatorsParams {
    /** IAM Refresh token. */
    xAuthRefreshToken: string;
    /** Cluster ID. */
    clusterId?: string;
    /** Cluster region. */
    region?: string;
    /** Kube namespaces to deploy Operator(s) to. */
    namespaces?: string[];
    /** Denotes whether to install Operator(s) globally. */
    allNamespaces?: boolean;
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocatorId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deleteOperators` operation. */
  export interface DeleteOperatorsParams {
    /** IAM Refresh token. */
    xAuthRefreshToken: string;
    /** Cluster identification. */
    clusterId: string;
    /** Cluster region. */
    region: string;
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocatorId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `installVersion` operation. */
  export interface InstallVersionParams {
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocId: string;
    /** IAM Refresh token. */
    xAuthRefreshToken: string;
    /** Cluster ID. */
    clusterId?: string;
    /** Cluster region. */
    region?: string;
    /** Kube namespace. */
    namespace?: string;
    /** Object containing Helm chart override values.  To use a secret for items of type password, specify a JSON
     *  encoded value of $ref:#/components/schemas/SecretInstance, prefixed with `cmsm_v1:`.
     */
    overrideValues?: JsonObject;
    /** Entitlement API Key for this offering. */
    entitlementApikey?: string;
    /** Schematics workspace configuration. */
    schematics?: DeployRequestBodySchematics;
    /** Script. */
    script?: string;
    /** Script ID. */
    scriptId?: string;
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocatorId?: string;
    /** VCenter ID. */
    vcenterId?: string;
    /** VCenter User. */
    vcenterUser?: string;
    /** VCenter Password. */
    vcenterPassword?: string;
    /** VCenter Location. */
    vcenterLocation?: string;
    /** VCenter Datastore. */
    vcenterDatastore?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `preinstallVersion` operation. */
  export interface PreinstallVersionParams {
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocId: string;
    /** IAM Refresh token. */
    xAuthRefreshToken: string;
    /** Cluster ID. */
    clusterId?: string;
    /** Cluster region. */
    region?: string;
    /** Kube namespace. */
    namespace?: string;
    /** Object containing Helm chart override values.  To use a secret for items of type password, specify a JSON
     *  encoded value of $ref:#/components/schemas/SecretInstance, prefixed with `cmsm_v1:`.
     */
    overrideValues?: JsonObject;
    /** Entitlement API Key for this offering. */
    entitlementApikey?: string;
    /** Schematics workspace configuration. */
    schematics?: DeployRequestBodySchematics;
    /** Script. */
    script?: string;
    /** Script ID. */
    scriptId?: string;
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocatorId?: string;
    /** VCenter ID. */
    vcenterId?: string;
    /** VCenter User. */
    vcenterUser?: string;
    /** VCenter Password. */
    vcenterPassword?: string;
    /** VCenter Location. */
    vcenterLocation?: string;
    /** VCenter Datastore. */
    vcenterDatastore?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getPreinstall` operation. */
  export interface GetPreinstallParams {
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocId: string;
    /** IAM Refresh token. */
    xAuthRefreshToken: string;
    /** ID of the cluster. */
    clusterId?: string;
    /** Cluster region. */
    region?: string;
    /** Required if the version's pre-install scope is `namespace`. */
    namespace?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `validateInstall` operation. */
  export interface ValidateInstallParams {
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocId: string;
    /** IAM Refresh token. */
    xAuthRefreshToken: string;
    /** Cluster ID. */
    clusterId?: string;
    /** Cluster region. */
    region?: string;
    /** Kube namespace. */
    namespace?: string;
    /** Object containing Helm chart override values.  To use a secret for items of type password, specify a JSON
     *  encoded value of $ref:#/components/schemas/SecretInstance, prefixed with `cmsm_v1:`.
     */
    overrideValues?: JsonObject;
    /** Entitlement API Key for this offering. */
    entitlementApikey?: string;
    /** Schematics workspace configuration. */
    schematics?: DeployRequestBodySchematics;
    /** Script. */
    script?: string;
    /** Script ID. */
    scriptId?: string;
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocatorId?: string;
    /** VCenter ID. */
    vcenterId?: string;
    /** VCenter User. */
    vcenterUser?: string;
    /** VCenter Password. */
    vcenterPassword?: string;
    /** VCenter Location. */
    vcenterLocation?: string;
    /** VCenter Datastore. */
    vcenterDatastore?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getValidationStatus` operation. */
  export interface GetValidationStatusParams {
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocId: string;
    /** IAM Refresh token. */
    xAuthRefreshToken: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getOverrideValues` operation. */
  export interface GetOverrideValuesParams {
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `searchObjects` operation. */
  export interface SearchObjectsParams {
    /** Lucene query string. */
    query: string;
    /** The maximum number of results to return. */
    limit?: number;
    /** The number of results to skip before returning values. */
    offset?: number;
    /** When true, hide private objects that correspond to public or IBM published objects. */
    collapse?: boolean;
    /** Display a digests of search results, has default value of true. */
    digest?: boolean;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listObjects` operation. */
  export interface ListObjectsParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** The number of results to return. */
    limit?: number;
    /** The number of results to skip before returning values. */
    offset?: number;
    /** Only return results that contain the specified string. */
    name?: string;
    /** The field on which the output is sorted. Sorts by default by **label** property. Available fields are
     *  **name**, **label**, **created**, and **updated**. By adding **-** (i.e. **-label**) in front of the query
     *  string, you can specify descending order. Default is ascending order.
     */
    sort?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `createObject` operation. */
  export interface CreateObjectParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** unique id. */
    id?: string;
    /** The programmatic name of this offering. */
    name?: string;
    /** Cloudant revision. */
    rev?: string;
    /** The crn for this specific object. */
    crn?: string;
    /** The url for this specific object. */
    url?: string;
    /** The parent for this specific object. */
    parentId?: string;
    /** Translated display name in the requested language. */
    labelI18n?: string;
    /** Display name in the requested language. */
    label?: string;
    /** List of tags associated with this catalog. */
    tags?: string[];
    /** The date and time this catalog was created. */
    created?: string;
    /** The date and time this catalog was last updated. */
    updated?: string;
    /** Short description in the requested language. */
    shortDescription?: string;
    /** Short description translation. */
    shortDescriptionI18n?: string;
    /** Kind of object. */
    kind?: string;
    /** Publish information. */
    publish?: PublishObject;
    /** Offering state. */
    state?: State;
    /** The id of the catalog containing this offering. */
    catalogId?: string;
    /** The name of the catalog. */
    catalogName?: string;
    /** Map of data values for this object. */
    data?: JsonObject;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getObject` operation. */
  export interface GetObjectParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** Object identifier. */
    objectIdentifier: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `replaceObject` operation. */
  export interface ReplaceObjectParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** Object identifier. */
    objectIdentifier: string;
    /** unique id. */
    id?: string;
    /** The programmatic name of this offering. */
    name?: string;
    /** Cloudant revision. */
    rev?: string;
    /** The crn for this specific object. */
    crn?: string;
    /** The url for this specific object. */
    url?: string;
    /** The parent for this specific object. */
    parentId?: string;
    /** Translated display name in the requested language. */
    labelI18n?: string;
    /** Display name in the requested language. */
    label?: string;
    /** List of tags associated with this catalog. */
    tags?: string[];
    /** The date and time this catalog was created. */
    created?: string;
    /** The date and time this catalog was last updated. */
    updated?: string;
    /** Short description in the requested language. */
    shortDescription?: string;
    /** Short description translation. */
    shortDescriptionI18n?: string;
    /** Kind of object. */
    kind?: string;
    /** Publish information. */
    publish?: PublishObject;
    /** Offering state. */
    state?: State;
    /** The id of the catalog containing this offering. */
    catalogId?: string;
    /** The name of the catalog. */
    catalogName?: string;
    /** Map of data values for this object. */
    data?: JsonObject;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deleteObject` operation. */
  export interface DeleteObjectParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** Object identifier. */
    objectIdentifier: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getObjectAudit` operation. */
  export interface GetObjectAuditParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** Object identifier. */
    objectIdentifier: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `accountPublishObject` operation. */
  export interface AccountPublishObjectParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** Object identifier. */
    objectIdentifier: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `sharedPublishObject` operation. */
  export interface SharedPublishObjectParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** Object identifier. */
    objectIdentifier: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `ibmPublishObject` operation. */
  export interface IbmPublishObjectParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** Object identifier. */
    objectIdentifier: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `publicPublishObject` operation. */
  export interface PublicPublishObjectParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** Object identifier. */
    objectIdentifier: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `createObjectAccess` operation. */
  export interface CreateObjectAccessParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** Object identifier. */
    objectIdentifier: string;
    /** Account identifier. */
    accountIdentifier: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getObjectAccess` operation. */
  export interface GetObjectAccessParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** Object identifier. */
    objectIdentifier: string;
    /** Account identifier. */
    accountIdentifier: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deleteObjectAccess` operation. */
  export interface DeleteObjectAccessParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** Object identifier. */
    objectIdentifier: string;
    /** Account identifier. */
    accountIdentifier: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getObjectAccessList` operation. */
  export interface GetObjectAccessListParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** Object identifier. */
    objectIdentifier: string;
    /** The maximum number of results to return. */
    limit?: number;
    /** The number of results to skip before returning values. */
    offset?: number;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deleteObjectAccessList` operation. */
  export interface DeleteObjectAccessListParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** Object identifier. */
    objectIdentifier: string;
    /** A list of accounts to delete.  An entry with star["*"] will remove all accounts. */
    accounts: string[];
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `addObjectAccessList` operation. */
  export interface AddObjectAccessListParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** Object identifier. */
    objectIdentifier: string;
    /** A list of accounts to add. */
    accounts: string[];
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `createOfferingInstance` operation. */
  export interface CreateOfferingInstanceParams {
    /** IAM Refresh token. */
    xAuthRefreshToken: string;
    /** provisioned instance ID (part of the CRN). */
    id?: string;
    /** Cloudant revision. */
    rev?: string;
    /** url reference to this object. */
    url?: string;
    /** platform CRN for this instance. */
    crn?: string;
    /** the label for this instance. */
    label?: string;
    /** Catalog ID this instance was created from. */
    catalogId?: string;
    /** Offering ID this instance was created from. */
    offeringId?: string;
    /** the format this instance has (helm, operator, ova...). */
    kindFormat?: string;
    /** The version this instance was installed from (not version id). */
    version?: string;
    /** Cluster ID. */
    clusterId?: string;
    /** Cluster region (e.g., us-south). */
    clusterRegion?: string;
    /** List of target namespaces to install into. */
    clusterNamespaces?: string[];
    /** designate to install into all namespaces. */
    clusterAllNamespaces?: boolean;
    /** Id of the schematics workspace, for offering instances provisioned through schematics. */
    schematicsWorkspaceId?: string;
    /** Id of the resource group to provision the offering instance into. */
    resourceGroupId?: string;
    /** Type of install plan (also known as approval strategy) for operator subscriptions. Can be either automatic,
     *  which automatically upgrades operators to the latest in a channel, or manual, which requires approval on the
     *  cluster.
     */
    installPlan?: string;
    /** Channel to pin the operator subscription to. */
    channel?: string;
    /** Map of metadata values for this offering instance. */
    metadata?: JsonObject;
    /** the last operation performed and status. */
    lastOperation?: OfferingInstanceLastOperation;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getOfferingInstance` operation. */
  export interface GetOfferingInstanceParams {
    /** Version Instance identifier. */
    instanceIdentifier: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `putOfferingInstance` operation. */
  export interface PutOfferingInstanceParams {
    /** Version Instance identifier. */
    instanceIdentifier: string;
    /** IAM Refresh token. */
    xAuthRefreshToken: string;
    /** provisioned instance ID (part of the CRN). */
    id?: string;
    /** Cloudant revision. */
    rev?: string;
    /** url reference to this object. */
    url?: string;
    /** platform CRN for this instance. */
    crn?: string;
    /** the label for this instance. */
    label?: string;
    /** Catalog ID this instance was created from. */
    catalogId?: string;
    /** Offering ID this instance was created from. */
    offeringId?: string;
    /** the format this instance has (helm, operator, ova...). */
    kindFormat?: string;
    /** The version this instance was installed from (not version id). */
    version?: string;
    /** Cluster ID. */
    clusterId?: string;
    /** Cluster region (e.g., us-south). */
    clusterRegion?: string;
    /** List of target namespaces to install into. */
    clusterNamespaces?: string[];
    /** designate to install into all namespaces. */
    clusterAllNamespaces?: boolean;
    /** Id of the schematics workspace, for offering instances provisioned through schematics. */
    schematicsWorkspaceId?: string;
    /** Id of the resource group to provision the offering instance into. */
    resourceGroupId?: string;
    /** Type of install plan (also known as approval strategy) for operator subscriptions. Can be either automatic,
     *  which automatically upgrades operators to the latest in a channel, or manual, which requires approval on the
     *  cluster.
     */
    installPlan?: string;
    /** Channel to pin the operator subscription to. */
    channel?: string;
    /** Map of metadata values for this offering instance. */
    metadata?: JsonObject;
    /** the last operation performed and status. */
    lastOperation?: OfferingInstanceLastOperation;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deleteOfferingInstance` operation. */
  export interface DeleteOfferingInstanceParams {
    /** Version Instance identifier. */
    instanceIdentifier: string;
    /** IAM Refresh token. */
    xAuthRefreshToken: string;
    headers?: OutgoingHttpHeaders;
  }

  /*************************
   * model interfaces
   ************************/

  /** Access List Add/Remove result. */
  export interface AccessListBulkResponse {
    /** in the case of error on an account add/remove - account: error. */
    errors?: JsonObject;
  }

  /** Account information. */
  export interface Account {
    /** Account identification. */
    id?: string;
    /** Hide the public catalog in this account. */
    hide_IBM_cloud_catalog?: boolean;
    /** Filters for account and catalog filters. */
    account_filters?: Filters;
  }

  /** The accumulated filters for an account. This will return the account filters plus a filter for each catalog the user has access to. */
  export interface AccumulatedFilters {
    /** Filters for accounts (at this time this will always be just one item array). */
    account_filters?: Filters[];
    /** The filters for all of the accessible catalogs. */
    catalog_filters?: AccumulatedFiltersCatalogFiltersItem[];
  }

  /** AccumulatedFiltersCatalogFiltersItem. */
  export interface AccumulatedFiltersCatalogFiltersItem {
    /** Filters for catalog. */
    catalog?: AccumulatedFiltersCatalogFiltersItemCatalog;
    /** Filters for account and catalog filters. */
    filters?: Filters;
  }

  /** Filters for catalog. */
  export interface AccumulatedFiltersCatalogFiltersItemCatalog {
    /** The ID of the catalog. */
    id?: string;
    /** The name of the catalog. */
    name?: string;
  }

  /** Result of approval. */
  export interface ApprovalResult {
    /** Allowed to request to publish. */
    allow_request?: boolean;
    /** Visible to IBM. */
    ibm?: boolean;
    /** Visible to everyone. */
    public?: boolean;
    /** Denotes whether approval has changed. */
    changed?: boolean;
  }

  /** A collection of audit records. */
  export interface AuditLog {
    /** A list of audit records. */
    list?: AuditRecord[];
  }

  /** An audit record which describes a change made to a catalog or associated resource. */
  export interface AuditRecord {
    /** The identifier of the audit record. */
    id?: string;
    /** The time at which the change was made. */
    created?: string;
    /** The type of change described by the audit record. */
    change_type?: string;
    /** The resource type associated with the change. */
    target_type?: string;
    /** The identifier of the resource that was changed. */
    target_id?: string;
    /** The email address of the user that made the change. */
    who_delegate_email?: string;
    /** A message which describes the change. */
    message?: string;
  }

  /** Catalog information. */
  export interface Catalog {
    /** Unique ID. */
    id?: string;
    /** Cloudant revision. */
    _rev?: string;
    /** Display Name in the requested language. */
    label?: string;
    /** Description in the requested language. */
    short_description?: string;
    /** URL for an icon associated with this catalog. */
    catalog_icon_url?: string;
    /** List of tags associated with this catalog. */
    tags?: string[];
    /** The url for this specific catalog. */
    url?: string;
    /** CRN associated with the catalog. */
    crn?: string;
    /** URL path to offerings. */
    offerings_url?: string;
    /** List of features associated with this catalog. */
    features?: Feature[];
    /** Denotes whether a catalog is disabled. */
    disabled?: boolean;
    /** The date-time this catalog was created. */
    created?: string;
    /** The date-time this catalog was last updated. */
    updated?: string;
    /** Resource group id the catalog is owned by. */
    resource_group_id?: string;
    /** Account that owns catalog. */
    owning_account?: string;
    /** Filters for account and catalog filters. */
    catalog_filters?: Filters;
    /** Feature information. */
    syndication_settings?: SyndicationResource;
    /** Kind of catalog. Supported kinds are offering and vpe. */
    kind?: string;
  }

  /** object information. */
  export interface CatalogObject {
    /** unique id. */
    id?: string;
    /** The programmatic name of this offering. */
    name?: string;
    /** Cloudant revision. */
    _rev?: string;
    /** The crn for this specific object. */
    crn?: string;
    /** The url for this specific object. */
    url?: string;
    /** The parent for this specific object. */
    parent_id?: string;
    /** Translated display name in the requested language. */
    label_i18n?: string;
    /** Display name in the requested language. */
    label?: string;
    /** List of tags associated with this catalog. */
    tags?: string[];
    /** The date and time this catalog was created. */
    created?: string;
    /** The date and time this catalog was last updated. */
    updated?: string;
    /** Short description in the requested language. */
    short_description?: string;
    /** Short description translation. */
    short_description_i18n?: string;
    /** Kind of object. */
    kind?: string;
    /** Publish information. */
    publish?: PublishObject;
    /** Offering state. */
    state?: State;
    /** The id of the catalog containing this offering. */
    catalog_id?: string;
    /** The name of the catalog. */
    catalog_name?: string;
    /** Map of data values for this object. */
    data?: JsonObject;
  }

  /** Paginated catalog search result. */
  export interface CatalogSearchResult {
    /** The overall total number of resources in the search result set. */
    total_count?: number;
    /** Resulting objects. */
    resources?: Catalog[];
  }

  /** Filter on a category. The filter will match against the values of the given category with include or exclude. */
  export interface CategoryFilter {
    /** -> true - This is an include filter, false - this is an exclude filter. */
    include?: boolean;
    /** Offering filter terms. */
    filter?: FilterTerms;
  }

  /** Cluster information. */
  export interface ClusterInfo {
    /** Resource Group ID. */
    resource_group_id?: string;
    /** Resource Group name. */
    resource_group_name?: string;
    /** Cluster ID. */
    id?: string;
    /** Cluster name. */
    name?: string;
    /** Cluster region. */
    region?: string;
  }

  /** Configuration description. */
  export interface Configuration {
    /** Configuration key. */
    key?: string;
    /** Value type (string, boolean, int). */
    type?: string;
    /** The default value.  To use a secret when the type is password, specify a JSON encoded value of
     *  $ref:#/components/schemas/SecretInstance, prefixed with `cmsm_v1:`.
     */
    default_value?: any;
    /** Constraint associated with value, e.g., for string type - regx:[a-z]. */
    value_constraint?: string;
    /** Key description. */
    description?: string;
    /** Is key required to install. */
    required?: boolean;
    /** List of options of type. */
    options?: any[];
    /** Hide values. */
    hidden?: boolean;
  }

  /** Schematics workspace configuration. */
  export interface DeployRequestBodySchematics {
    /** Schematics workspace name. */
    name?: string;
    /** Schematics workspace description. */
    description?: string;
    /** Schematics workspace tags. */
    tags?: string[];
    /** Resource group to use when creating the schematics workspace. */
    resource_group_id?: string;
  }

  /** Deployment for offering. */
  export interface Deployment {
    /** unique id. */
    id?: string;
    /** Display Name in the requested language. */
    label?: string;
    /** The programmatic name of this offering. */
    name?: string;
    /** Short description in the requested language. */
    short_description?: string;
    /** Long description in the requested language. */
    long_description?: string;
    /** open ended metadata information. */
    metadata?: JsonObject;
    /** list of tags associated with this catalog. */
    tags?: string[];
    /** the date'time this catalog was created. */
    created?: string;
    /** the date'time this catalog was last updated. */
    updated?: string;
  }

  /** Feature information. */
  export interface Feature {
    /** Heading. */
    title?: string;
    /** Feature description. */
    description?: string;
  }

  /** Offering filter terms. */
  export interface FilterTerms {
    /** List of values to match against. If include is true, then if the offering has one of the values then the
     *  offering is included. If include is false, then if the offering has one of the values then the offering is
     *  excluded.
     */
    filter_terms?: string[];
  }

  /** Filters for account and catalog filters. */
  export interface Filters {
    /** -> true - Include all of the public catalog when filtering. Further settings will specifically exclude some
     *  offerings. false - Exclude all of the public catalog when filtering. Further settings will specifically include
     *  some offerings.
     */
    include_all?: boolean;
    /** Filter against offering properties. */
    category_filters?: JsonObject;
    /** Filter on offering ID's. There is an include filter and an exclule filter. Both can be set. */
    id_filters?: IDFilter;
  }

  /** Filter on offering ID's. There is an include filter and an exclule filter. Both can be set. */
  export interface IDFilter {
    /** Offering filter terms. */
    include?: FilterTerms;
    /** Offering filter terms. */
    exclude?: FilterTerms;
  }

  /** Image. */
  export interface Image {
    /** Image. */
    image?: string;
  }

  /** Image Manifest. */
  export interface ImageManifest {
    /** Image manifest description. */
    description?: string;
    /** List of images. */
    images?: Image[];
  }

  /** Installation status. */
  export interface InstallStatus {
    /** Installation status metadata. */
    metadata?: InstallStatusMetadata;
    /** Release information. */
    release?: InstallStatusRelease;
    /** Content management information. */
    content_mgmt?: InstallStatusContentMgmt;
  }

  /** Content management information. */
  export interface InstallStatusContentMgmt {
    /** Pods. */
    pods?: JsonObject[];
    /** Errors. */
    errors?: JsonObject[];
  }

  /** Installation status metadata. */
  export interface InstallStatusMetadata {
    /** Cluster ID. */
    cluster_id?: string;
    /** Cluster region. */
    region?: string;
    /** Cluster namespace. */
    namespace?: string;
    /** Workspace ID. */
    workspace_id?: string;
    /** Workspace name. */
    workspace_name?: string;
  }

  /** Release information. */
  export interface InstallStatusRelease {
    /** Kube deployments. */
    deployments?: JsonObject[];
    /** Kube replica sets. */
    replicasets?: JsonObject[];
    /** Kube stateful sets. */
    statefulsets?: JsonObject[];
    /** Kube pods. */
    pods?: JsonObject[];
    /** Kube errors. */
    errors?: JsonObject[];
  }

  /** Offering kind. */
  export interface Kind {
    /** Unique ID. */
    id?: string;
    /** content kind, e.g., helm, vm image. */
    format_kind?: string;
    /** target cloud to install, e.g., iks, open_shift_iks. */
    target_kind?: string;
    /** Open ended metadata information. */
    metadata?: JsonObject;
    /** Installation instruction. */
    install_description?: string;
    /** List of tags associated with this catalog. */
    tags?: string[];
    /** List of features associated with this offering. */
    additional_features?: Feature[];
    /** The date and time this catalog was created. */
    created?: string;
    /** The date and time this catalog was last updated. */
    updated?: string;
    /** list of versions. */
    versions?: Version[];
    /** list of plans. */
    plans?: Plan[];
  }

  /** BSS license. */
  export interface License {
    /** License ID. */
    id?: string;
    /** license name. */
    name?: string;
    /** type of license e.g., Apache xxx. */
    type?: string;
    /** URL for the license text. */
    url?: string;
    /** License description. */
    description?: string;
  }

  /** Paginated list of namespace search results. */
  export interface NamespaceSearchResult {
    /** The offset (origin 0) of the first resource in this page of search results. */
    offset: number;
    /** The maximum number of resources returned in each page of search results. */
    limit: number;
    /** The overall total number of resources in the search result set. */
    total_count?: number;
    /** The number of resources returned in this page of search results. */
    resource_count?: number;
    /** A URL for retrieving the first page of search results. */
    first?: string;
    /** A URL for retrieving the last page of search results. */
    last?: string;
    /** A URL for retrieving the previous page of search results. */
    prev?: string;
    /** A URL for retrieving the next page of search results. */
    next?: string;
    /** Resulting objects. */
    resources?: string[];
  }

  /** object access. */
  export interface ObjectAccess {
    /** unique id. */
    id?: string;
    /** account id. */
    account?: string;
    /** unique id. */
    catalog_id?: string;
    /** object id. */
    target_id?: string;
    /** date and time create. */
    create?: string;
  }

  /** Paginated object search result. */
  export interface ObjectAccessListResult {
    /** The offset (origin 0) of the first resource in this page of search results. */
    offset: number;
    /** The maximum number of resources returned in each page of search results. */
    limit: number;
    /** The overall total number of resources in the search result set. */
    total_count?: number;
    /** The number of resources returned in this page of search results. */
    resource_count?: number;
    /** A URL for retrieving the first page of search results. */
    first?: string;
    /** A URL for retrieving the last page of search results. */
    last?: string;
    /** A URL for retrieving the previous page of search results. */
    prev?: string;
    /** A URL for retrieving the next page of search results. */
    next?: string;
    /** Resulting objects. */
    resources?: ObjectAccess[];
  }

  /** Paginated object search result. */
  export interface ObjectListResult {
    /** The offset (origin 0) of the first resource in this page of search results. */
    offset: number;
    /** The maximum number of resources returned in each page of search results. */
    limit: number;
    /** The overall total number of resources in the search result set. */
    total_count?: number;
    /** The number of resources returned in this page of search results. */
    resource_count?: number;
    /** A URL for retrieving the first page of search results. */
    first?: string;
    /** A URL for retrieving the last page of search results. */
    last?: string;
    /** A URL for retrieving the previous page of search results. */
    prev?: string;
    /** A URL for retrieving the next page of search results. */
    next?: string;
    /** Resulting objects. */
    resources?: CatalogObject[];
  }

  /** Paginated object search result. */
  export interface ObjectSearchResult {
    /** The offset (origin 0) of the first resource in this page of search results. */
    offset: number;
    /** The maximum number of resources returned in each page of search results. */
    limit: number;
    /** The overall total number of resources in the search result set. */
    total_count?: number;
    /** The number of resources returned in this page of search results. */
    resource_count?: number;
    /** A URL for retrieving the first page of search results. */
    first?: string;
    /** A URL for retrieving the last page of search results. */
    last?: string;
    /** A URL for retrieving the previous page of search results. */
    prev?: string;
    /** A URL for retrieving the next page of search results. */
    next?: string;
    /** Resulting objects. */
    resources?: CatalogObject[];
  }

  /** Offering information. */
  export interface Offering {
    /** unique id. */
    id?: string;
    /** Cloudant revision. */
    _rev?: string;
    /** The url for this specific offering. */
    url?: string;
    /** The crn for this specific offering. */
    crn?: string;
    /** Display Name in the requested language. */
    label?: string;
    /** The programmatic name of this offering. */
    name?: string;
    /** URL for an icon associated with this offering. */
    offering_icon_url?: string;
    /** URL for an additional docs with this offering. */
    offering_docs_url?: string;
    /** URL to be displayed in the Consumption UI for getting support on this offering. */
    offering_support_url?: string;
    /** List of tags associated with this catalog. */
    tags?: string[];
    /** List of keywords associated with offering, typically used to search for it. */
    keywords?: string[];
    /** Repository info for offerings. */
    rating?: Rating;
    /** The date and time this catalog was created. */
    created?: string;
    /** The date and time this catalog was last updated. */
    updated?: string;
    /** Short description in the requested language. */
    short_description?: string;
    /** Long description in the requested language. */
    long_description?: string;
    /** list of features associated with this offering. */
    features?: Feature[];
    /** Array of kind. */
    kinds?: Kind[];
    /** Is it permitted to request publishing to IBM or Public. */
    permit_request_ibm_public_publish?: boolean;
    /** Indicates if this offering has been approved for use by all IBMers. */
    ibm_publish_approved?: boolean;
    /** Indicates if this offering has been approved for use by all IBM Cloud users. */
    public_publish_approved?: boolean;
    /** The original offering CRN that this publish entry came from. */
    public_original_crn?: string;
    /** The crn of the public catalog entry of this offering. */
    publish_public_crn?: string;
    /** The portal's approval record ID. */
    portal_approval_record?: string;
    /** The portal UI URL. */
    portal_ui_url?: string;
    /** The id of the catalog containing this offering. */
    catalog_id?: string;
    /** The name of the catalog. */
    catalog_name?: string;
    /** Map of metadata values for this offering. */
    metadata?: JsonObject;
    /** A disclaimer for this offering. */
    disclaimer?: string;
    /** Determine if this offering should be displayed in the Consumption UI. */
    hidden?: boolean;
    /** Provider of this offering. */
    provider?: string;
    /** Repository info for offerings. */
    repo_info?: RepoInfo;
  }

  /** A offering instance resource (provision instance of a catalog offering). */
  export interface OfferingInstance {
    /** provisioned instance ID (part of the CRN). */
    id?: string;
    /** Cloudant revision. */
    _rev?: string;
    /** url reference to this object. */
    url?: string;
    /** platform CRN for this instance. */
    crn?: string;
    /** the label for this instance. */
    label?: string;
    /** Catalog ID this instance was created from. */
    catalog_id?: string;
    /** Offering ID this instance was created from. */
    offering_id?: string;
    /** the format this instance has (helm, operator, ova...). */
    kind_format?: string;
    /** The version this instance was installed from (not version id). */
    version?: string;
    /** Cluster ID. */
    cluster_id?: string;
    /** Cluster region (e.g., us-south). */
    cluster_region?: string;
    /** List of target namespaces to install into. */
    cluster_namespaces?: string[];
    /** designate to install into all namespaces. */
    cluster_all_namespaces?: boolean;
    /** Id of the schematics workspace, for offering instances provisioned through schematics. */
    schematics_workspace_id?: string;
    /** Id of the resource group to provision the offering instance into. */
    resource_group_id?: string;
    /** Type of install plan (also known as approval strategy) for operator subscriptions. Can be either automatic,
     *  which automatically upgrades operators to the latest in a channel, or manual, which requires approval on the
     *  cluster.
     */
    install_plan?: string;
    /** Channel to pin the operator subscription to. */
    channel?: string;
    /** Map of metadata values for this offering instance. */
    metadata?: JsonObject;
    /** the last operation performed and status. */
    last_operation?: OfferingInstanceLastOperation;
  }

  /** the last operation performed and status. */
  export interface OfferingInstanceLastOperation {
    /** last operation performed. */
    operation?: string;
    /** state after the last operation performed. */
    state?: string;
    /** additional information about the last operation. */
    message?: string;
    /** transaction id from the last operation. */
    transaction_id?: string;
    /** Date and time last updated. */
    updated?: string;
  }

  /** Paginated offering search result. */
  export interface OfferingSearchResult {
    /** The offset (origin 0) of the first resource in this page of search results. */
    offset: number;
    /** The maximum number of resources returned in each page of search results. */
    limit: number;
    /** The overall total number of resources in the search result set. */
    total_count?: number;
    /** The number of resources returned in this page of search results. */
    resource_count?: number;
    /** A URL for retrieving the first page of search results. */
    first?: string;
    /** A URL for retrieving the last page of search results. */
    last?: string;
    /** A URL for retrieving the previous page of search results. */
    prev?: string;
    /** A URL for retrieving the next page of search results. */
    next?: string;
    /** Resulting objects. */
    resources?: Offering[];
  }

  /** Operator deploy result. */
  export interface OperatorDeployResult {
    /** Status phase. */
    phase?: string;
    /** Status message. */
    message?: string;
    /** Operator API path. */
    link?: string;
    /** Name of Operator. */
    name?: string;
    /** Operator version. */
    version?: string;
    /** Kube namespace. */
    namespace?: string;
    /** Package Operator exists in. */
    package_name?: string;
    /** Catalog identification. */
    catalog_id?: string;
  }

  /** Offering plan. */
  export interface Plan {
    /** unique id. */
    id?: string;
    /** Display Name in the requested language. */
    label?: string;
    /** The programmatic name of this offering. */
    name?: string;
    /** Short description in the requested language. */
    short_description?: string;
    /** Long description in the requested language. */
    long_description?: string;
    /** open ended metadata information. */
    metadata?: JsonObject;
    /** list of tags associated with this catalog. */
    tags?: string[];
    /** list of features associated with this offering. */
    additional_features?: Feature[];
    /** the date'time this catalog was created. */
    created?: string;
    /** the date'time this catalog was last updated. */
    updated?: string;
    /** list of deployments. */
    deployments?: Deployment[];
  }

  /** Publish information. */
  export interface PublishObject {
    /** Is it permitted to request publishing to IBM or Public. */
    permit_ibm_public_publish?: boolean;
    /** Indicates if this offering has been approved for use by all IBMers. */
    ibm_approved?: boolean;
    /** Indicates if this offering has been approved for use by all IBM Cloud users. */
    public_approved?: boolean;
    /** The portal's approval record ID. */
    portal_approval_record?: string;
    /** The portal UI URL. */
    portal_url?: string;
  }

  /** Repository info for offerings. */
  export interface Rating {
    /** One start rating. */
    one_star_count?: number;
    /** Two start rating. */
    two_star_count?: number;
    /** Three start rating. */
    three_star_count?: number;
    /** Four start rating. */
    four_star_count?: number;
  }

  /** Repository info for offerings. */
  export interface RepoInfo {
    /** Token for private repos. */
    token?: string;
    /** Public or enterprise GitHub. */
    type?: string;
  }

  /** Resource requirements. */
  export interface Resource {
    /** Type of requirement. */
    type?: string;
    /** mem, disk, cores, and nodes can be parsed as an int.  targetVersion will be a semver range value. */
    value?: any;
  }

  /** Script information. */
  export interface Script {
    /** Instruction on step and by whom (role) that are needed to take place to prepare the target for installing
     *  this version.
     */
    instructions?: string;
    /** Optional script that needs to be run post any pre-condition script. */
    script?: string;
    /** Optional iam permissions that are required on the target cluster to run this script. */
    script_permission?: string;
    /** Optional script that if run will remove the installed version. */
    delete_script?: string;
    /** Optional value indicating if this script is scoped to a namespace or the entire cluster. */
    scope?: string;
  }

  /** Offering state. */
  export interface State {
    /** one of: new, validated, account-published, ibm-published, public-published. */
    current?: string;
    /** Date and time of current request. */
    current_entered?: string;
    /** one of: new, validated, account-published, ibm-published, public-published. */
    pending?: string;
    /** Date and time of pending request. */
    pending_requested?: string;
    /** one of: new, validated, account-published, ibm-published, public-published. */
    previous?: string;
  }

  /** Feature information. */
  export interface SyndicationAuthorization {
    /** Array of syndicated namespaces. */
    token?: string;
    /** Date and time last updated. */
    last_run?: string;
  }

  /** Feature information. */
  export interface SyndicationCluster {
    /** Cluster region. */
    region?: string;
    /** Cluster ID. */
    id?: string;
    /** Cluster name. */
    name?: string;
    /** Resource group ID. */
    resource_group_name?: string;
    /** Syndication type. */
    type?: string;
    /** Syndicated namespaces. */
    namespaces?: string[];
    /** Syndicated to all namespaces on cluster. */
    all_namespaces?: boolean;
  }

  /** Feature information. */
  export interface SyndicationHistory {
    /** Array of syndicated namespaces. */
    namespaces?: string[];
    /** Array of syndicated namespaces. */
    clusters?: SyndicationCluster[];
    /** Date and time last syndicated. */
    last_run?: string;
  }

  /** Feature information. */
  export interface SyndicationResource {
    /** Remove related components. */
    remove_related_components?: boolean;
    /** Syndication clusters. */
    clusters?: SyndicationCluster[];
    /** Feature information. */
    history?: SyndicationHistory;
    /** Feature information. */
    authorization?: SyndicationAuthorization;
  }

  /** Validation response. */
  export interface Validation {
    /** Date and time of last successful validation. */
    validated?: string;
    /** Date and time of last validation was requested. */
    requested?: string;
    /** Current validation state - <empty>, in_progress, valid, invalid, expired. */
    state?: string;
    /** Last operation (e.g. submit_deployment, generate_installer, install_offering. */
    last_operation?: string;
    /** Validation target information (e.g. cluster_id, region, namespace, etc).  Values will vary by Content type. */
    target?: JsonObject;
  }

  /** Offering version information. */
  export interface Version {
    /** Unique ID. */
    id?: string;
    /** Cloudant revision. */
    _rev?: string;
    /** Version's CRN. */
    crn?: string;
    /** Version of content type. */
    version?: string;
    /** hash of the content. */
    sha?: string;
    /** The date and time this version was created. */
    created?: string;
    /** The date and time this version was last updated. */
    updated?: string;
    /** Offering ID. */
    offering_id?: string;
    /** Catalog ID. */
    catalog_id?: string;
    /** Kind ID. */
    kind_id?: string;
    /** List of tags associated with this catalog. */
    tags?: string[];
    /** Content's repo URL. */
    repo_url?: string;
    /** Content's source URL (e.g git repo). */
    source_url?: string;
    /** File used to on-board this version. */
    tgz_url?: string;
    /** List of user solicited overrides. */
    configuration?: Configuration[];
    /** Open ended metadata information. */
    metadata?: JsonObject;
    /** Validation response. */
    validation?: Validation;
    /** Resource requirments for installation. */
    required_resources?: Resource[];
    /** Denotes if single instance can be deployed to a given cluster. */
    single_instance?: boolean;
    /** Script information. */
    install?: Script;
    /** Optional pre-install instructions. */
    pre_install?: Script[];
    /** Entitlement license info. */
    entitlement?: VersionEntitlement;
    /** List of licenses the product was built with. */
    licenses?: License[];
    /** If set, denotes a url to a YAML file with list of container images used by this version. */
    image_manifest_url?: string;
    /** read only field, indicating if this version is deprecated. */
    deprecated?: boolean;
    /** Version of the package used to create this version. */
    package_version?: string;
    /** Offering state. */
    state?: State;
    /** A dotted value of `catalogID`.`versionID`. */
    version_locator?: string;
    /** Console URL. */
    console_url?: string;
    /** Long description for version. */
    long_description?: string;
    /** Whitelisted accounts for version. */
    whitelisted_accounts?: string[];
  }

  /** Entitlement license info. */
  export interface VersionEntitlement {
    /** Provider name. */
    provider_name?: string;
    /** Provider ID. */
    provider_id?: string;
    /** Product ID. */
    product_id?: string;
    /** list of license entitlement part numbers, eg. D1YGZLL,D1ZXILL. */
    part_numbers?: string[];
    /** Image repository name. */
    image_repo_name?: string;
  }

  /** Indicates if the current version can be upgraded to the version identified by the descriptor. */
  export interface VersionUpdateDescriptor {
    /** A dotted value of `catalogID`.`versionID`. */
    version_locator?: string;
    /** the version number of this version. */
    version?: string;
    /** Offering state. */
    state?: State;
    /** Resource requirments for installation. */
    required_resources?: Resource[];
    /** Version of package. */
    package_version?: string;
    /** true if the current version can be upgraded to this version, false otherwise. */
    can_update?: boolean;
    /** If can_update is false, this map will contain messages for each failed check, otherwise it will be omitted.
     *  Possible keys include nodes, cores, mem, disk, targetVersion, and install-permission-check.
     */
    messages?: JsonObject;
  }
}

export = CatalogManagementV1;
