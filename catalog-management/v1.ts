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
   * @param {string} [options.serviceUrl] - The base url to use when contacting the service (e.g. 'https://gateway.watsonplatform.net/api/v1-beta'). The base url may differ between IBM Cloud regions.
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
   * Get the account settings.
   *
   * Get the account level settings for the account for private catalog.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Account>>}
   */
  public getCatalogAccount(params?: CatalogManagementV1.GetCatalogAccountParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Account>> {
    const _params = extend({}, params);

    return new Promise((resolve, reject) => {
      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getCatalogAccount');

      const parameters = {
        options: {
          url: '/catalogaccount',
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
   * Set the account settings.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {string} [params.id] - Account identification.
   * @param {Filters} [params.accountFilters] - Filters for account and catalog filters.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public updateCatalogAccount(params?: CatalogManagementV1.UpdateCatalogAccountParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = extend({}, params);

    return new Promise((resolve, reject) => {
      const body = {
        'id': _params.id,
        'account_filters': _params.accountFilters
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'updateCatalogAccount');

      const parameters = {
        options: {
          url: '/catalogaccount',
          method: 'PUT',
          body,
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

  /**
   * Get the accumulated filters of the account and of the catalogs you have access to.
   *
   * Get the accumulated filters of the account and of the catalogs you have access to.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {string} [params.catalog] - catalog id. Narrow down filters to the account and just the one catalog.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.AccumulatedFilters>>}
   */
  public getCatalogAccountFilters(params?: CatalogManagementV1.GetCatalogAccountFiltersParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.AccumulatedFilters>> {
    const _params = extend({}, params);

    return new Promise((resolve, reject) => {
      const query = {
        'catalog': _params.catalog
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getCatalogAccountFilters');

      const parameters = {
        options: {
          url: '/catalogaccount/filters',
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

  /*************************
   * catalogs
   ************************/

  /**
   * Get list of catalogs.
   *
   * List the available catalogs for a given account.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.CatalogSearchResult>>}
   */
  public listCatalogs(params?: CatalogManagementV1.ListCatalogsParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.CatalogSearchResult>> {
    const _params = extend({}, params);

    return new Promise((resolve, reject) => {
      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'listCatalogs');

      const parameters = {
        options: {
          url: '/catalogs',
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
   * @param {string} [params.url] - The url for this specific catalog.
   * @param {string} [params.crn] - CRN associated with the catalog.
   * @param {string} [params.offeringsUrl] - URL path to offerings.
   * @param {Feature[]} [params.features] - List of features associated with this catalog.
   * @param {boolean} [params.disabled] - Denotes whether a catalog is disabled.
   * @param {string} [params.created] - The date'time this catalog was created.
   * @param {string} [params.updated] - The date'time this catalog was last updated.
   * @param {string} [params.resourceGroupId] - Resource group id the catalog is owned by.
   * @param {string} [params.owningAccount] - Account that owns catalog.
   * @param {Filters} [params.catalogFilters] - Filters for account and catalog filters.
   * @param {SyndicationResource} [params.syndicationSettings] - Feature information.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Catalog>>}
   */
  public createCatalog(params?: CatalogManagementV1.CreateCatalogParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Catalog>> {
    const _params = extend({}, params);

    return new Promise((resolve, reject) => {
      const body = {
        'id': _params.id,
        '_rev': _params.rev,
        'label': _params.label,
        'short_description': _params.shortDescription,
        'catalog_icon_url': _params.catalogIconUrl,
        'tags': _params.tags,
        'url': _params.url,
        'crn': _params.crn,
        'offerings_url': _params.offeringsUrl,
        'features': _params.features,
        'disabled': _params.disabled,
        'created': _params.created,
        'updated': _params.updated,
        'resource_group_id': _params.resourceGroupId,
        'owning_account': _params.owningAccount,
        'catalog_filters': _params.catalogFilters,
        'syndication_settings': _params.syndicationSettings
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'createCatalog');

      const parameters = {
        options: {
          url: '/catalogs',
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
   * Get a catalog.
   *
   * Get a catalog.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Catalog>>}
   */
  public getCatalog(params: CatalogManagementV1.GetCatalogParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Catalog>> {
    const _params = extend({}, params);
    const requiredParams = ['catalogIdentifier'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'catalog_identifier': _params.catalogIdentifier
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getCatalog');

      const parameters = {
        options: {
          url: '/catalogs/{catalog_identifier}',
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
   * Update a catalog.
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
   * @param {string} [params.url] - The url for this specific catalog.
   * @param {string} [params.crn] - CRN associated with the catalog.
   * @param {string} [params.offeringsUrl] - URL path to offerings.
   * @param {Feature[]} [params.features] - List of features associated with this catalog.
   * @param {boolean} [params.disabled] - Denotes whether a catalog is disabled.
   * @param {string} [params.created] - The date'time this catalog was created.
   * @param {string} [params.updated] - The date'time this catalog was last updated.
   * @param {string} [params.resourceGroupId] - Resource group id the catalog is owned by.
   * @param {string} [params.owningAccount] - Account that owns catalog.
   * @param {Filters} [params.catalogFilters] - Filters for account and catalog filters.
   * @param {SyndicationResource} [params.syndicationSettings] - Feature information.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Catalog>>}
   */
  public replaceCatalog(params: CatalogManagementV1.ReplaceCatalogParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Catalog>> {
    const _params = extend({}, params);
    const requiredParams = ['catalogIdentifier'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const body = {
        'id': _params.id,
        '_rev': _params.rev,
        'label': _params.label,
        'short_description': _params.shortDescription,
        'catalog_icon_url': _params.catalogIconUrl,
        'tags': _params.tags,
        'url': _params.url,
        'crn': _params.crn,
        'offerings_url': _params.offeringsUrl,
        'features': _params.features,
        'disabled': _params.disabled,
        'created': _params.created,
        'updated': _params.updated,
        'resource_group_id': _params.resourceGroupId,
        'owning_account': _params.owningAccount,
        'catalog_filters': _params.catalogFilters,
        'syndication_settings': _params.syndicationSettings
      };

      const path = {
        'catalog_identifier': _params.catalogIdentifier
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'replaceCatalog');

      const parameters = {
        options: {
          url: '/catalogs/{catalog_identifier}',
          method: 'PUT',
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
   * Delete a catalog.
   *
   * Delete a catalog.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public deleteCatalog(params: CatalogManagementV1.DeleteCatalogParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['catalogIdentifier'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'catalog_identifier': _params.catalogIdentifier
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'deleteCatalog');

      const parameters = {
        options: {
          url: '/catalogs/{catalog_identifier}',
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
   * enterprise
   ************************/

  /**
   * Get the enterprise settings for the specified enterprise ID.
   *
   * Get the enterprise settings for the specified enterprise ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.enterpriseId - Enterprise identification.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Enterprise>>}
   */
  public getEnterprise(params: CatalogManagementV1.GetEnterpriseParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Enterprise>> {
    const _params = extend({}, params);
    const requiredParams = ['enterpriseId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'enterprise_id': _params.enterpriseId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getEnterprise');

      const parameters = {
        options: {
          url: '/enterprises/{enterprise_id}',
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
   * Set the enterprise settings.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.enterpriseId - Enterprise identification.
   * @param {string} [params.id] - Enterprise identification.
   * @param {string} [params.rev] - Cloudant revision.
   * @param {Filters} [params.accountFilters] - Filters for account and catalog filters.
   * @param {EnterpriseAccountGroups} [params.accountGroups] - Map of account group ids to AccountGroup objects.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public replaceEnterprise(params: CatalogManagementV1.ReplaceEnterpriseParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['enterpriseId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const body = {
        'id': _params.id,
        '_rev': _params.rev,
        'account_filters': _params.accountFilters,
        'account_groups': _params.accountGroups
      };

      const path = {
        'enterprise_id': _params.enterpriseId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'replaceEnterprise');

      const parameters = {
        options: {
          url: '/enterprises/{enterprise_id}',
          method: 'PUT',
          body,
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
   * offerings
   ************************/

  /**
   * Get list of offerings for consumption.
   *
   * List the available offerings from both public and from the account that currently scoped for consumption. These
   * copies cannot be used updating. They are not complete and only return what is visible to the caller.
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
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.OfferingSearchResult>>}
   */
  public getConsumptionOfferings(params?: CatalogManagementV1.GetConsumptionOfferingsParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.OfferingSearchResult>> {
    const _params = extend({}, params);

    return new Promise((resolve, reject) => {
      const query = {
        'digest': _params.digest,
        'catalog': _params.catalog,
        'select': _params.select,
        'includeHidden': _params.includeHidden
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getConsumptionOfferings');

      const parameters = {
        options: {
          url: '/offerings',
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
   * Get list of offerings.
   *
   * List the available offerings in the specified catalog.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {boolean} [params.digest] - true - Strip down the content of what is returned. For example don't return the
   * readme. Makes the result much smaller. Defaults to false.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.OfferingSearchResult>>}
   */
  public listOfferings(params: CatalogManagementV1.ListOfferingsParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.OfferingSearchResult>> {
    const _params = extend({}, params);
    const requiredParams = ['catalogIdentifier'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'digest': _params.digest
      };

      const path = {
        'catalog_identifier': _params.catalogIdentifier
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'listOfferings');

      const parameters = {
        options: {
          url: '/catalogs/{catalog_identifier}/offerings',
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
   * Create an offering.
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
  public createOffering(params: CatalogManagementV1.CreateOfferingParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Offering>> {
    const _params = extend({}, params);
    const requiredParams = ['catalogIdentifier'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
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
        'repo_info': _params.repoInfo
      };

      const path = {
        'catalog_identifier': _params.catalogIdentifier
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'createOffering');

      const parameters = {
        options: {
          url: '/catalogs/{catalog_identifier}/offerings',
          method: 'POST',
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
   * Import new version to offering from a tgz.
   *
   * Import new version to offering from a tgz.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.offeringId - Offering identification.
   * @param {string} params.zipurl - URL path to zip location.
   * @param {string[]} [params.tags] - Tags array.
   * @param {string[]} [params.targetKinds] - Target kinds.  Current valid values are 'iks', 'roks', 'vcenter', and
   * 'terraform'.
   * @param {string} [params.targetVersion] - The semver value for this new version, if not found in the zip url package
   * content.
   * @param {boolean} [params.includeConfig] - Add all possible configuration values to this version when importing.
   * @param {string} [params.repoType] - The type of repository containing this version.  Valid values are 'public_git'
   * or 'enterprise_git'.
   * @param {string} [params.xAuthToken] - Authentication token used to access the specified zip file.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Offering>>}
   */
  public importOfferingVersion(params: CatalogManagementV1.ImportOfferingVersionParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Offering>> {
    const _params = extend({}, params);
    const requiredParams = ['catalogIdentifier', 'offeringId', 'zipurl'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const body = {
        'tags': _params.tags,
        'target_kinds': _params.targetKinds
      };

      const query = {
        'zipurl': _params.zipurl,
        'targetVersion': _params.targetVersion,
        'includeConfig': _params.includeConfig,
        'repoType': _params.repoType
      };

      const path = {
        'catalog_identifier': _params.catalogIdentifier,
        'offering_id': _params.offeringId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'importOfferingVersion');

      const parameters = {
        options: {
          url: '/catalogs/{catalog_identifier}/offerings/{offering_id}/version',
          method: 'POST',
          body,
          qs: query,
          path,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'X-Auth-Token': _params.xAuthToken
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /**
   * Import a new offering from a tgz.
   *
   * Import a new offering from a tgz.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.zipurl - URL path to zip location.
   * @param {string[]} [params.tags] - Tags array.
   * @param {string[]} [params.targetKinds] - Target kinds.  Current valid values are 'iks', 'roks', 'vcenter', and
   * 'terraform'.
   * @param {string} [params.offeringId] - Re-use the specified offeringID during import.
   * @param {boolean} [params.includeConfig] - Add all possible configuration items when creating this version.
   * @param {string} [params.repoType] - The type of repository containing this version.  Valid values are 'public_git'
   * or 'enterprise_git'.
   * @param {string} [params.xAuthToken] - Authentication token used to access the specified zip file.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Offering>>}
   */
  public importOffering(params: CatalogManagementV1.ImportOfferingParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Offering>> {
    const _params = extend({}, params);
    const requiredParams = ['catalogIdentifier', 'zipurl'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const body = {
        'tags': _params.tags,
        'target_kinds': _params.targetKinds
      };

      const query = {
        'zipurl': _params.zipurl,
        'offeringID': _params.offeringId,
        'includeConfig': _params.includeConfig,
        'repoType': _params.repoType
      };

      const path = {
        'catalog_identifier': _params.catalogIdentifier
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'importOffering');

      const parameters = {
        options: {
          url: '/catalogs/{catalog_identifier}/import/offerings',
          method: 'POST',
          body,
          qs: query,
          path,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'X-Auth-Token': _params.xAuthToken
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /**
   * Reload existing version in offering from a tgz.
   *
   * Reload existing version in offering from a tgz.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.offeringId - Offering identification.
   * @param {string} params.zipurl - URL path to zip location.
   * @param {string} params.targetVersion - The semver value for this new version.
   * @param {string[]} [params.tags] - Tags array.
   * @param {string[]} [params.targetKinds] - Target kinds.  Current valid values are 'iks', 'roks', 'vcenter', and
   * 'terraform'.
   * @param {string} [params.repoType] - The type of repository containing this version.  Valid values are 'public_git'
   * or 'enterprise_git'.
   * @param {string} [params.xAuthToken] - Authentication token used to access the specified zip file.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Offering>>}
   */
  public reloadOffering(params: CatalogManagementV1.ReloadOfferingParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Offering>> {
    const _params = extend({}, params);
    const requiredParams = ['catalogIdentifier', 'offeringId', 'zipurl', 'targetVersion'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const body = {
        'tags': _params.tags,
        'target_kinds': _params.targetKinds
      };

      const query = {
        'zipurl': _params.zipurl,
        'targetVersion': _params.targetVersion,
        'repoType': _params.repoType
      };

      const path = {
        'catalog_identifier': _params.catalogIdentifier,
        'offering_id': _params.offeringId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'reloadOffering');

      const parameters = {
        options: {
          url: '/catalogs/{catalog_identifier}/offerings/{offering_id}/reload',
          method: 'PUT',
          body,
          qs: query,
          path,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'X-Auth-Token': _params.xAuthToken
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /**
   * Get an offering.
   *
   * Get an offering.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.offeringId - Offering identification.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Offering>>}
   */
  public getOffering(params: CatalogManagementV1.GetOfferingParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Offering>> {
    const _params = extend({}, params);
    const requiredParams = ['catalogIdentifier', 'offeringId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'catalog_identifier': _params.catalogIdentifier,
        'offering_id': _params.offeringId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getOffering');

      const parameters = {
        options: {
          url: '/catalogs/{catalog_identifier}/offerings/{offering_id}',
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
   * Update an offering.
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
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Catalog>>}
   */
  public replaceOffering(params: CatalogManagementV1.ReplaceOfferingParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Catalog>> {
    const _params = extend({}, params);
    const requiredParams = ['catalogIdentifier', 'offeringId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
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
        'repo_info': _params.repoInfo
      };

      const path = {
        'catalog_identifier': _params.catalogIdentifier,
        'offering_id': _params.offeringId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'replaceOffering');

      const parameters = {
        options: {
          url: '/catalogs/{catalog_identifier}/offerings/{offering_id}',
          method: 'PUT',
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
   * Delete an offering.
   *
   * Delete an offering.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.offeringId - Offering identification.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public deleteOffering(params: CatalogManagementV1.DeleteOfferingParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['catalogIdentifier', 'offeringId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'catalog_identifier': _params.catalogIdentifier,
        'offering_id': _params.offeringId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'deleteOffering');

      const parameters = {
        options: {
          url: '/catalogs/{catalog_identifier}/offerings/{offering_id}',
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

  /**
   * upload an icon for the offering.
   *
   * upload an icon file to be stored in GC. File is uploaded as a binary payload - not as a form.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.offeringId - Offering identification.
   * @param {string} params.fileName - Name of the file name that is being uploaded.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Offering>>}
   */
  public replaceOfferingIcon(params: CatalogManagementV1.ReplaceOfferingIconParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Offering>> {
    const _params = extend({}, params);
    const requiredParams = ['catalogIdentifier', 'offeringId', 'fileName'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'catalog_identifier': _params.catalogIdentifier,
        'offering_id': _params.offeringId,
        'file_name': _params.fileName
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'replaceOfferingIcon');

      const parameters = {
        options: {
          url: '/catalogs/{catalog_identifier}/offerings/{offering_id}/icon/{file_name}',
          method: 'PUT',
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
   * Approve offering to be permitted to publish to IBM Public Catalog (IBMers only or Everyone).
   *
   * Approve or disapprove the offering to be allowed to publish to the IBM Public Catalog in `ibm` (visible to IBM
   * only) or `public` (visible to everyone). Can approve to only `ibm`, or it can be extended to `public`. If extended
   * to `public` then `ibm` is automatically approved too. If disapprove `public`, then `ibm` approval will not  be
   * changed. If disapprove `ibm` then `public` will automatically be disapproved. This is because the process steps
   * always go first through `ibm` and then to `public`. `ibm` cannot be skipped. Only users with Approval IAM authority
   * can use this.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.catalogIdentifier - Catalog identifier.
   * @param {string} params.offeringId - Offering identification.
   * @param {string} params.approvalType - Type of approval, ibm or public.
   * @param {string} params.approved - Approve (true) or disapprove (false).
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.ApprovalResult>>}
   */
  public updateOfferingIbm(params: CatalogManagementV1.UpdateOfferingIbmParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.ApprovalResult>> {
    const _params = extend({}, params);
    const requiredParams = ['catalogIdentifier', 'offeringId', 'approvalType', 'approved'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'catalog_identifier': _params.catalogIdentifier,
        'offering_id': _params.offeringId,
        'approval_type': _params.approvalType,
        'approved': _params.approved
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'updateOfferingIbm');

      const parameters = {
        options: {
          url: '/catalogs/{catalog_identifier}/offerings/{offering_id}/publish/{approval_type}/{approved}',
          method: 'POST',
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
   * versions
   ************************/

  /**
   * Get the about information, in markdown, for the current version.
   *
   * Get the about information, in markdown, for the current version.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<string>>}
   */
  public getVersionAbout(params: CatalogManagementV1.GetVersionAboutParams): Promise<CatalogManagementV1.Response<string>> {
    const _params = extend({}, params);
    const requiredParams = ['versionLocId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'version_loc_id': _params.versionLocId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getVersionAbout');

      const parameters = {
        options: {
          url: '/versions/{version_loc_id}/about',
          method: 'GET',
          path,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
            'Accept': 'text/markdown',
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /**
   * Get the license content for the specified license ID in the specified version.
   *
   * Get the license content for the specified license ID in the specified version.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {string} params.licenseId - The ID of the license, which maps to the file name in the 'licenses' directory
   * of this verions tgz file.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public getVersionLicense(params: CatalogManagementV1.GetVersionLicenseParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['versionLocId', 'licenseId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'version_loc_id': _params.versionLocId,
        'license_id': _params.licenseId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getVersionLicense');

      const parameters = {
        options: {
          url: '/versions/{version_loc_id}/licenses/{license_id}',
          method: 'GET',
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
   * Get get the list of container images associated with this version.
   *
   * The "image_manifest_url" property of the version should be pointing the a URL for the image manifest, this api
   * reflects that content.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.ImageManifest>>}
   */
  public getVersionContainerImages(params: CatalogManagementV1.GetVersionContainerImagesParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.ImageManifest>> {
    const _params = extend({}, params);
    const requiredParams = ['versionLocId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'version_loc_id': _params.versionLocId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getVersionContainerImages');

      const parameters = {
        options: {
          url: '/versions/{version_loc_id}/containerImages',
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
   * Deprecate the specified version.
   *
   * Deprecate the specified version.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public deprecateVersion(params: CatalogManagementV1.DeprecateVersionParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['versionLocId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'version_loc_id': _params.versionLocId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'deprecateVersion');

      const parameters = {
        options: {
          url: '/versions/{version_loc_id}/deprecate',
          method: 'POST',
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
   * Publish the specified version so it is viewable by account members.
   *
   * Publish the specified version so it is viewable by account members.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public accountPublishVersion(params: CatalogManagementV1.AccountPublishVersionParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['versionLocId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'version_loc_id': _params.versionLocId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'accountPublishVersion');

      const parameters = {
        options: {
          url: '/versions/{version_loc_id}/account-publish',
          method: 'POST',
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
   * Publish the specified version so that it is visible to IBMers in the public catalog.
   *
   * Publish the specified version so that it is visible to IBMers in the public catalog.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public ibmPublishVersion(params: CatalogManagementV1.IbmPublishVersionParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['versionLocId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'version_loc_id': _params.versionLocId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'ibmPublishVersion');

      const parameters = {
        options: {
          url: '/versions/{version_loc_id}/ibm-publish',
          method: 'POST',
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
   * Publish the specified version so it is visible to all users in the public catalog.
   *
   * Publish the specified version so it is visible to all users in the public catalog.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public publicPublishVersion(params: CatalogManagementV1.PublicPublishVersionParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['versionLocId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'version_loc_id': _params.versionLocId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'publicPublishVersion');

      const parameters = {
        options: {
          url: '/versions/{version_loc_id}/public-publish',
          method: 'POST',
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
   * Commit a working copy of the specified version.
   *
   * Commit a working copy of the specified version.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public commitVersion(params: CatalogManagementV1.CommitVersionParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['versionLocId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'version_loc_id': _params.versionLocId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'commitVersion');

      const parameters = {
        options: {
          url: '/versions/{version_loc_id}/commit',
          method: 'POST',
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
   * Create a working copy of the specified version.
   *
   * Create a working copy of the specified version.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Version>>}
   */
  public getVersionWorkingCopy(params: CatalogManagementV1.GetVersionWorkingCopyParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Version>> {
    const _params = extend({}, params);
    const requiredParams = ['versionLocId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'version_loc_id': _params.versionLocId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getVersionWorkingCopy');

      const parameters = {
        options: {
          url: '/versions/{version_loc_id}/workingcopy',
          method: 'POST',
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
   * Get available updates for the specified version.
   *
   * Get available updates for the specified version.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {string} [params.clusterId] - The id of the cluster where this version was installed.
   * @param {string} [params.region] - The region of the cluster where this version was installed.
   * @param {string} [params.resourceGroupId] - The resource group id of the cluster where this version was installed.
   * @param {string} [params.namespace] - The namespace of the cluster where this version was installed.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.VersionUpdateDescriptor[]>>}
   */
  public getVersionUpdates(params: CatalogManagementV1.GetVersionUpdatesParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.VersionUpdateDescriptor[]>> {
    const _params = extend({}, params);
    const requiredParams = ['versionLocId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'cluster_id': _params.clusterId,
        'region': _params.region,
        'resource_group_id': _params.resourceGroupId,
        'namespace': _params.namespace
      };

      const path = {
        'version_loc_id': _params.versionLocId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getVersionUpdates');

      const parameters = {
        options: {
          url: '/versions/{version_loc_id}/updates',
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
   * Get the Offering/Kind/Version 'branch' for the specified locator ID.
   *
   * Get the Offering/Kind/Version 'branch' for the specified locator ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Offering>>}
   */
  public getVersion(params: CatalogManagementV1.GetVersionParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Offering>> {
    const _params = extend({}, params);
    const requiredParams = ['versionLocId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'version_loc_id': _params.versionLocId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getVersion');

      const parameters = {
        options: {
          url: '/versions/{version_loc_id}',
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
   * Delete a version.
   *
   * Delete a the specified version.  If the version is an active version with a working copy, the working copy will be
   * deleted as well.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public deleteVersion(params: CatalogManagementV1.DeleteVersionParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['versionLocId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'version_loc_id': _params.versionLocId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'deleteVersion');

      const parameters = {
        options: {
          url: '/versions/{version_loc_id}',
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

  /**
   * Search for versions.
   *
   * [deprecated] use /search/license/versions api instead.   Search across all accounts for versions, requires global
   * admin permission.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.q - query, for now only "q=entitlement_key:<some-key>" is supported.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public listVersions(params: CatalogManagementV1.ListVersionsParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['q'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'q': _params.q
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'listVersions');

      const parameters = {
        options: {
          url: '/versions',
          method: 'GET',
          qs: query,
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
   * repo
   ************************/

  /**
   * List a repo's entries.
   *
   * List the available entries from a given repo.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.type - The type of repo (valid repo types: helm).
   * @param {string} params.repourl - The URL for the repo's root (e.g
   * https://kubernetes-charts-incubator.storage.googleapis.com).
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.HelmRepoList>>}
   */
  public getRepos(params: CatalogManagementV1.GetReposParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.HelmRepoList>> {
    const _params = extend({}, params);
    const requiredParams = ['type', 'repourl'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'repourl': _params.repourl
      };

      const path = {
        'type': _params.type
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getRepos');

      const parameters = {
        options: {
          url: '/repo/{type}/entries',
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
   * Get contents of a repo.
   *
   * Get the contents of a given repo.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.type - The type of repo (valid repo types: helm).
   * @param {string} params.charturl - The URL for the repo's chart zip file (e.g
   * https://registry.bluemix.net/helm/ibm-charts/charts/ibm-redis-ha-dev-1.0.0.tgz).
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.HelmPackage>>}
   */
  public getRepo(params: CatalogManagementV1.GetRepoParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.HelmPackage>> {
    const _params = extend({}, params);
    const requiredParams = ['type', 'charturl'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'charturl': _params.charturl
      };

      const path = {
        'type': _params.type
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getRepo');

      const parameters = {
        options: {
          url: '/repo/{type}',
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
   * deploy
   ************************/

  /**
   * List Kube clusters.
   *
   * List Kube clusters.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {number} [params.limit] - number or results to return.
   * @param {number} [params.offset] - number of results to skip before returning values.
   * @param {string} [params.type] - Kubernetes or OpenShift.  Default is kubernetes.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.ClusterSearchResult>>}
   */
  public listClusters(params?: CatalogManagementV1.ListClustersParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.ClusterSearchResult>> {
    const _params = extend({}, params);

    return new Promise((resolve, reject) => {
      const query = {
        'limit': _params.limit,
        'offset': _params.offset,
        'type': _params.type
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'listClusters');

      const parameters = {
        options: {
          url: '/deploy/kubernetes/clusters',
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
   * Get Kube cluster.
   *
   * Get Kube cluster.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.clusterId - ID of the cluster.
   * @param {string} params.region - Region of the cluster.
   * @param {string} params.xAuthRefreshToken - IAM Refresh token.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.ClusterInfo>>}
   */
  public getCluster(params: CatalogManagementV1.GetClusterParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.ClusterInfo>> {
    const _params = extend({}, params);
    const requiredParams = ['clusterId', 'region', 'xAuthRefreshToken'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'region': _params.region
      };

      const path = {
        'cluster_id': _params.clusterId
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
          headers: extend(true, sdkHeaders, {
            'Accept': 'application/json',
            'X-Auth-Refresh-Token': _params.xAuthRefreshToken
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /**
   * Get cluster namespaces.
   *
   * Get cluster namespaces.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.clusterId - ID of the cluster.
   * @param {string} params.region - Cluster region.
   * @param {string} params.xAuthRefreshToken - IAM Refresh token.
   * @param {number} [params.limit] - number or results to return.
   * @param {number} [params.offset] - number of results to skip before returning values.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.NamespaceSearchResult>>}
   */
  public getNamespaces(params: CatalogManagementV1.GetNamespacesParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.NamespaceSearchResult>> {
    const _params = extend({}, params);
    const requiredParams = ['clusterId', 'region', 'xAuthRefreshToken'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'region': _params.region,
        'limit': _params.limit,
        'offset': _params.offset
      };

      const path = {
        'cluster_id': _params.clusterId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getNamespaces');

      const parameters = {
        options: {
          url: '/deploy/kubernetes/clusters/{cluster_id}/namespaces',
          method: 'GET',
          qs: query,
          path,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
            'Accept': 'application/json',
            'X-Auth-Refresh-Token': _params.xAuthRefreshToken
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /**
   * Deploy Operator(s) on a Kube cluster.
   *
   * Deploy Operator(s) on a Kube cluster.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.xAuthRefreshToken - IAM Refresh token.
   * @param {string} [params.clusterId] - Cluster ID.
   * @param {string} [params.region] - Cluster region.
   * @param {string[]} [params.namespaces] - Kube namespaces to deploy Operator(s) to.
   * @param {string} [params.versionLocatorId] - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.OperatorDeployResult[]>>}
   */
  public createOperator(params: CatalogManagementV1.CreateOperatorParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.OperatorDeployResult[]>> {
    const _params = extend({}, params);
    const requiredParams = ['xAuthRefreshToken'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const body = {
        'cluster_id': _params.clusterId,
        'region': _params.region,
        'namespaces': _params.namespaces,
        'version_locator_id': _params.versionLocatorId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'createOperator');

      const parameters = {
        options: {
          url: '/deploy/kubernetes/olm/operator',
          method: 'POST',
          body,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'X-Auth-Refresh-Token': _params.xAuthRefreshToken
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /**
   * Get Operator(s) from a Kube cluster.
   *
   * Get Operator(s) from a Kube cluster.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.xAuthRefreshToken - IAM Refresh token.
   * @param {string} params.clusterId - Cluster identification.
   * @param {string} params.region - Cluster region.
   * @param {string} params.versionLocatorId - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.OperatorDeployResult[]>>}
   */
  public listOperators(params: CatalogManagementV1.ListOperatorsParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.OperatorDeployResult[]>> {
    const _params = extend({}, params);
    const requiredParams = ['xAuthRefreshToken', 'clusterId', 'region', 'versionLocatorId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'cluster_id': _params.clusterId,
        'region': _params.region,
        'version_locator_id': _params.versionLocatorId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'listOperators');

      const parameters = {
        options: {
          url: '/deploy/kubernetes/olm/operator',
          method: 'GET',
          qs: query,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
            'Accept': 'application/json',
            'X-Auth-Refresh-Token': _params.xAuthRefreshToken
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /**
   * Update Operator(s) on a Kube cluster.
   *
   * Update Operator(s) on a Kube cluster.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.xAuthRefreshToken - IAM Refresh token.
   * @param {string} [params.clusterId] - Cluster ID.
   * @param {string} [params.region] - Cluster region.
   * @param {string[]} [params.namespaces] - Kube namespaces to deploy Operator(s) to.
   * @param {string} [params.versionLocatorId] - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.OperatorDeployResult[]>>}
   */
  public replaceOperator(params: CatalogManagementV1.ReplaceOperatorParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.OperatorDeployResult[]>> {
    const _params = extend({}, params);
    const requiredParams = ['xAuthRefreshToken'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const body = {
        'cluster_id': _params.clusterId,
        'region': _params.region,
        'namespaces': _params.namespaces,
        'version_locator_id': _params.versionLocatorId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'replaceOperator');

      const parameters = {
        options: {
          url: '/deploy/kubernetes/olm/operator',
          method: 'PUT',
          body,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'X-Auth-Refresh-Token': _params.xAuthRefreshToken
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /**
   * Delete Operator(s) from a Kube cluster.
   *
   * Delete Operator(s) from a Kube cluster.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.xAuthRefreshToken - IAM Refresh token.
   * @param {string} params.clusterId - Cluster identification.
   * @param {string} params.region - Cluster region.
   * @param {string} params.versionLocatorId - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public deleteOperator(params: CatalogManagementV1.DeleteOperatorParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['xAuthRefreshToken', 'clusterId', 'region', 'versionLocatorId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'cluster_id': _params.clusterId,
        'region': _params.region,
        'version_locator_id': _params.versionLocatorId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'deleteOperator');

      const parameters = {
        options: {
          url: '/deploy/kubernetes/olm/operator',
          method: 'DELETE',
          qs: query,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
            'X-Auth-Refresh-Token': _params.xAuthRefreshToken
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /**
   * Create an install.
   *
   * Create an install.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {string} params.xAuthRefreshToken - IAM Refresh token.
   * @param {string} [params.clusterId] - Cluster ID.
   * @param {string} [params.region] - Cluster region.
   * @param {string} [params.namespace] - Kube namespace.
   * @param {JsonObject} [params.overrideValues] - Object containing Helm chart override values.
   * @param {string} [params.entitlementApikey] - Entitlement API Key for this offering.
   * @param {DeployRequestBodySchematics} [params.schematics] - Schematics workspace configuration.
   * @param {string} [params.script] - Script.
   * @param {string} [params.scriptId] - Script ID.
   * @param {string} [params.versionLocatorId] - A dotted value of `catalogID`.`versionID`.
   * @param {string} [params.vcenterId] - VCenter ID.
   * @param {string} [params.vcenterPassword] - VCenter Password.
   * @param {string} [params.vcenterLocation] - VCenter Location.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public installVersion(params: CatalogManagementV1.InstallVersionParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['versionLocId', 'xAuthRefreshToken'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
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
        'vcenter_password': _params.vcenterPassword,
        'vcenter_location': _params.vcenterLocation
      };

      const path = {
        'version_loc_id': _params.versionLocId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'installVersion');

      const parameters = {
        options: {
          url: '/versions/{version_loc_id}/install',
          method: 'POST',
          body,
          path,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
            'Content-Type': 'application/json',
            'X-Auth-Refresh-Token': _params.xAuthRefreshToken
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /**
   * Create a preinstall.
   *
   * Create a preinstall.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {string} params.xAuthRefreshToken - IAM Refresh token.
   * @param {string} [params.clusterId] - Cluster ID.
   * @param {string} [params.region] - Cluster region.
   * @param {string} [params.namespace] - Kube namespace.
   * @param {JsonObject} [params.overrideValues] - Object containing Helm chart override values.
   * @param {string} [params.entitlementApikey] - Entitlement API Key for this offering.
   * @param {DeployRequestBodySchematics} [params.schematics] - Schematics workspace configuration.
   * @param {string} [params.script] - Script.
   * @param {string} [params.scriptId] - Script ID.
   * @param {string} [params.versionLocatorId] - A dotted value of `catalogID`.`versionID`.
   * @param {string} [params.vcenterId] - VCenter ID.
   * @param {string} [params.vcenterPassword] - VCenter Password.
   * @param {string} [params.vcenterLocation] - VCenter Location.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public preinstallVersion(params: CatalogManagementV1.PreinstallVersionParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['versionLocId', 'xAuthRefreshToken'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
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
        'vcenter_password': _params.vcenterPassword,
        'vcenter_location': _params.vcenterLocation
      };

      const path = {
        'version_loc_id': _params.versionLocId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'preinstallVersion');

      const parameters = {
        options: {
          url: '/versions/{version_loc_id}/preinstall',
          method: 'POST',
          body,
          path,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
            'Content-Type': 'application/json',
            'X-Auth-Refresh-Token': _params.xAuthRefreshToken
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /**
   * Get a preinstall.
   *
   * Get a preinstall.
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
  public getPreinstall(params: CatalogManagementV1.GetPreinstallParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.InstallStatus>> {
    const _params = extend({}, params);
    const requiredParams = ['versionLocId', 'xAuthRefreshToken'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'cluster_id': _params.clusterId,
        'region': _params.region,
        'namespace': _params.namespace
      };

      const path = {
        'version_loc_id': _params.versionLocId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getPreinstall');

      const parameters = {
        options: {
          url: '/versions/{version_loc_id}/preinstall',
          method: 'GET',
          qs: query,
          path,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
            'Accept': 'application/json',
            'X-Auth-Refresh-Token': _params.xAuthRefreshToken
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /**
   * Validate a offering.
   *
   * Validate a offering.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {string} params.xAuthRefreshToken - IAM Refresh token.
   * @param {string} [params.clusterId] - Cluster ID.
   * @param {string} [params.region] - Cluster region.
   * @param {string} [params.namespace] - Kube namespace.
   * @param {JsonObject} [params.overrideValues] - Object containing Helm chart override values.
   * @param {string} [params.entitlementApikey] - Entitlement API Key for this offering.
   * @param {DeployRequestBodySchematics} [params.schematics] - Schematics workspace configuration.
   * @param {string} [params.script] - Script.
   * @param {string} [params.scriptId] - Script ID.
   * @param {string} [params.versionLocatorId] - A dotted value of `catalogID`.`versionID`.
   * @param {string} [params.vcenterId] - VCenter ID.
   * @param {string} [params.vcenterPassword] - VCenter Password.
   * @param {string} [params.vcenterLocation] - VCenter Location.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public validationInstall(params: CatalogManagementV1.ValidationInstallParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['versionLocId', 'xAuthRefreshToken'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
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
        'vcenter_password': _params.vcenterPassword,
        'vcenter_location': _params.vcenterLocation
      };

      const path = {
        'version_loc_id': _params.versionLocId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'validationInstall');

      const parameters = {
        options: {
          url: '/versions/{version_loc_id}/validation/install',
          method: 'POST',
          body,
          path,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
            'Content-Type': 'application/json',
            'X-Auth-Refresh-Token': _params.xAuthRefreshToken
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /**
   * Returns the install status for the specified offering version.
   *
   * Returns the install status for the specified offering version.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {string} params.xAuthRefreshToken - IAM Refresh token.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Validation>>}
   */
  public getValidationStatus(params: CatalogManagementV1.GetValidationStatusParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Validation>> {
    const _params = extend({}, params);
    const requiredParams = ['versionLocId', 'xAuthRefreshToken'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'version_loc_id': _params.versionLocId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getValidationStatus');

      const parameters = {
        options: {
          url: '/versions/{version_loc_id}/validation/install',
          method: 'GET',
          path,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
            'Accept': 'application/json',
            'X-Auth-Refresh-Token': _params.xAuthRefreshToken
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /**
   * Returns the override values that were used to validate the specified offering version.
   *
   * Returns the override values that were used to validate the specified offering version.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.JsonObject>>}
   */
  public getOverrideValues(params: CatalogManagementV1.GetOverrideValuesParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.JsonObject>> {
    const _params = extend({}, params);
    const requiredParams = ['versionLocId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'version_loc_id': _params.versionLocId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getOverrideValues');

      const parameters = {
        options: {
          url: '/versions/{version_loc_id}/validation/overridevalues',
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
   * Returns the schematics workspaces for the specified offering version.
   *
   * Returns the schematics workspaces for the specified offering version.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {string} params.xAuthRefreshToken - IAM Refresh token.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.SchematicsWorkspaceSearchResult>>}
   */
  public getSchematicsWorkspaces(params: CatalogManagementV1.GetSchematicsWorkspacesParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.SchematicsWorkspaceSearchResult>> {
    const _params = extend({}, params);
    const requiredParams = ['versionLocId', 'xAuthRefreshToken'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const path = {
        'version_loc_id': _params.versionLocId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getSchematicsWorkspaces');

      const parameters = {
        options: {
          url: '/versions/{version_loc_id}/workspaces',
          method: 'GET',
          path,
        },
        defaultOptions: extend(true, {}, this.baseOptions, {
          headers: extend(true, sdkHeaders, {
            'Accept': 'application/json',
            'X-Auth-Refresh-Token': _params.xAuthRefreshToken
          }, _params.headers),
        }),
      };

      return resolve(this.createRequest(parameters));
    });
  };

  /**
   * Returns the schematics permissions for the specified user.
   *
   * Returns the schematics permissions for the specified user.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.versionLocId - A dotted value of `catalogID`.`versionID`.
   * @param {string} params.clusterId - ID of the cluster.
   * @param {string} params.region - Cluster region.
   * @param {string} [params.namespace] - Required if the version's pre-install scope is `namespace`.
   * @param {string} [params.resourceGroupId] - Resource group identification.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.DeployRequirementsCheck>>}
   */
  public canDeploySchematics(params: CatalogManagementV1.CanDeploySchematicsParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.DeployRequirementsCheck>> {
    const _params = extend({}, params);
    const requiredParams = ['versionLocId', 'clusterId', 'region'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'cluster_id': _params.clusterId,
        'region': _params.region,
        'namespace': _params.namespace,
        'resource_group_id': _params.resourceGroupId
      };

      const path = {
        'version_loc_id': _params.versionLocId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'canDeploySchematics');

      const parameters = {
        options: {
          url: '/versions/{version_loc_id}/candeploy',
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
   * Returns all active resource groups in the current account, where the current user has permission to create schematics workspaces.
   *
   * Returns all active resource groups in the current account, where the current user has permission to create
   * schematics workspaces.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.ResourceGroups>>}
   */
  public getResourceGroups(params?: CatalogManagementV1.GetResourceGroupsParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.ResourceGroups>> {
    const _params = extend({}, params);

    return new Promise((resolve, reject) => {
      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getResourceGroups');

      const parameters = {
        options: {
          url: '/deploy/schematics/resourcegroups',
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

  /*************************
   * licensing
   ************************/

  /**
   * Get license providers.
   *
   * Get license providers.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.LicenseProviders>>}
   */
  public getLicenseProviders(params?: CatalogManagementV1.GetLicenseProvidersParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.LicenseProviders>> {
    const _params = extend({}, params);

    return new Promise((resolve, reject) => {
      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getLicenseProviders');

      const parameters = {
        options: {
          url: '/license/license_providers',
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
   * Get license entitlements.
   *
   * Get license entitlements bound to an account.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {string} [params.accountId] - The account ID to query for the entitlement. Default is the account from the
   * user's token.
   * @param {string} [params.licenseProductId] - The license product ID. If from PPA (Passport Advantage) this is the
   * product Part number(s) which can be one or more IDs, eg. D1YGZLL,5737L09.
   * @param {string} [params.versionId] - The GC ID of the specific offering version.
   * @param {string} [params.state] - The state of the license entitlement. eg. usually 'active', or if it's been
   * deleted will show as 'removed'.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.LicenseEntitlements>>}
   */
  public listLicenseEntitlements(params?: CatalogManagementV1.ListLicenseEntitlementsParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.LicenseEntitlements>> {
    const _params = extend({}, params);

    return new Promise((resolve, reject) => {
      const query = {
        'account_id': _params.accountId,
        'license_product_id': _params.licenseProductId,
        'version_id': _params.versionId,
        'state': _params.state
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'listLicenseEntitlements');

      const parameters = {
        options: {
          url: '/license/entitlements',
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
   * Create a license entitlement.
   *
   * Create an entitlement for a Cloud account.  This is used to give an account an entitlement to a license.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {string} [params.name] - Entitlement name.
   * @param {string} [params.effectiveFrom] - Entitlement is good from this starting date. eg.
   * '2019-07-17T21:21:47.6794935Z'.
   * @param {string} [params.effectiveUntil] - Entitlement is good until this ending date. eg.
   * '2019-07-17T21:21:47.6794935Z'.
   * @param {string} [params.versionId] - Global Catalog ID of the version.
   * @param {string} [params.licenseId] - Specific license entitlement ID from the license provider, eg. D1W3R4.
   * @param {string} [params.licenseOwnerId] - IBM ID of the owner of this license entitlement.
   * @param {string} [params.licenseProviderId] - License provider ID.
   * @param {string} [params.licenseProductId] - License product ID.
   * @param {string} [params.accountId] - if not specified the token's account will be used.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.LicenseEntitlement>>}
   */
  public createLicenseEntitlement(params?: CatalogManagementV1.CreateLicenseEntitlementParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.LicenseEntitlement>> {
    const _params = extend({}, params);

    return new Promise((resolve, reject) => {
      const body = {
        'name': _params.name,
        'effective_from': _params.effectiveFrom,
        'effective_until': _params.effectiveUntil,
        'version_id': _params.versionId,
        'license_id': _params.licenseId,
        'license_owner_id': _params.licenseOwnerId,
        'license_provider_id': _params.licenseProviderId,
        'license_product_id': _params.licenseProductId
      };

      const query = {
        'account_id': _params.accountId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'createLicenseEntitlement');

      const parameters = {
        options: {
          url: '/license/entitlements',
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
   * Get entitlements for a specific license product ID.
   *
   * Get an entitlements for a specific license product ID bound to an account.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.licenseProductId - The license product ID. If from PPA (Passport Advantage) this is a
   * specific product Part number, eg. D1YGZLL.
   * @param {string} [params.accountId] - The account ID to query for the entitlement. Default is the account from the
   * user's token.
   * @param {string} [params.versionId] - The GC ID of the specific offering version.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.LicenseEntitlements>>}
   */
  public getLicenseEntitlements(params: CatalogManagementV1.GetLicenseEntitlementsParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.LicenseEntitlements>> {
    const _params = extend({}, params);
    const requiredParams = ['licenseProductId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'account_id': _params.accountId,
        'version_id': _params.versionId
      };

      const path = {
        'license_product_id': _params.licenseProductId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getLicenseEntitlements');

      const parameters = {
        options: {
          url: '/license/entitlements/productID/{license_product_id}',
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
   * Delete license entitlement.
   *
   * Delete a license entitlement that is bound to an account. Note that BSS will mark the entitlement field "state":
   * "removed".
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.entitlementId - The specific entitlement ID (can be obtained from one of the license
   * entitlement queries).
   * @param {string} [params.accountId] - The account ID to query for the entitlement. Default is the account from the
   * user's token.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public deleteLicenseEntitlement(params: CatalogManagementV1.DeleteLicenseEntitlementParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['entitlementId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'account_id': _params.accountId
      };

      const path = {
        'entitlement_id': _params.entitlementId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'deleteLicenseEntitlement');

      const parameters = {
        options: {
          url: '/license/entitlements/{entitlement_id}',
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
   * Get licenses.
   *
   * Retrieve available licenses from supported license subsystems.  This is used to get the list of available licenses
   * that the user has.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.licenseProviderId - ID of the license provider, ie. retrieved from GET license_providers.
   * @param {string} [params.accountId] - If not specified the token's account will be used.
   * @param {string} [params.name] - License name.
   * @param {string} [params.licenseType] - Type of license, if not specified, default is ibm-ppa.
   * @param {string} [params.licenseProductId] - The license product ID. If from PPA (Passport Advantage) this is the
   * product Part number, eg. D1YGZLL.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Licenses>>}
   */
  public getLicenses(params: CatalogManagementV1.GetLicensesParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Licenses>> {
    const _params = extend({}, params);
    const requiredParams = ['licenseProviderId'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'license_provider_id': _params.licenseProviderId,
        'account_id': _params.accountId,
        'name': _params.name,
        'license_type': _params.licenseType,
        'license_product_id': _params.licenseProductId
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getLicenses');

      const parameters = {
        options: {
          url: '/license/licenses',
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

  /*************************
   * crossAccountSearch
   ************************/

  /**
   * Search for versions.
   *
   * Search across accounts for all versions usig a particular license, requires global admin permission.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.q - query, for now only "q=entitlement_key:<some-key>" is supported.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public searchLicenseVersions(params: CatalogManagementV1.SearchLicenseVersionsParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['q'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'q': _params.q
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'searchLicenseVersions');

      const parameters = {
        options: {
          url: '/search/license/versions',
          method: 'GET',
          qs: query,
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
   * Search for Offerings.
   *
   * Search across accounts for all offerings using a particular license, requires global admin permission.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.q - query, for now only "q=entitlement_key:<some-key>" is supported.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>>}
   */
  public searchLicenseOfferings(params: CatalogManagementV1.SearchLicenseOfferingsParams): Promise<CatalogManagementV1.Response<CatalogManagementV1.Empty>> {
    const _params = extend({}, params);
    const requiredParams = ['q'];

    return new Promise((resolve, reject) => {
      const missingParams = getMissingParams(_params, requiredParams);
      if (missingParams) {
        return reject(missingParams);
      }

      const query = {
        'q': _params.q
      };

      const sdkHeaders = getSdkHeaders(CatalogManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'searchLicenseOfferings');

      const parameters = {
        options: {
          url: '/search/license/offerings',
          method: 'GET',
          qs: query,
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

namespace CatalogManagementV1 {

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

  /** Parameters for the `getCatalogAccount` operation. */
  export interface GetCatalogAccountParams {
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `updateCatalogAccount` operation. */
  export interface UpdateCatalogAccountParams {
    /** Account identification. */
    id?: string;
    /** Filters for account and catalog filters. */
    accountFilters?: Filters;
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
    /** The url for this specific catalog. */
    url?: string;
    /** CRN associated with the catalog. */
    crn?: string;
    /** URL path to offerings. */
    offeringsUrl?: string;
    /** List of features associated with this catalog. */
    features?: Feature[];
    /** Denotes whether a catalog is disabled. */
    disabled?: boolean;
    /** The date'time this catalog was created. */
    created?: string;
    /** The date'time this catalog was last updated. */
    updated?: string;
    /** Resource group id the catalog is owned by. */
    resourceGroupId?: string;
    /** Account that owns catalog. */
    owningAccount?: string;
    /** Filters for account and catalog filters. */
    catalogFilters?: Filters;
    /** Feature information. */
    syndicationSettings?: SyndicationResource;
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
    /** The url for this specific catalog. */
    url?: string;
    /** CRN associated with the catalog. */
    crn?: string;
    /** URL path to offerings. */
    offeringsUrl?: string;
    /** List of features associated with this catalog. */
    features?: Feature[];
    /** Denotes whether a catalog is disabled. */
    disabled?: boolean;
    /** The date'time this catalog was created. */
    created?: string;
    /** The date'time this catalog was last updated. */
    updated?: string;
    /** Resource group id the catalog is owned by. */
    resourceGroupId?: string;
    /** Account that owns catalog. */
    owningAccount?: string;
    /** Filters for account and catalog filters. */
    catalogFilters?: Filters;
    /** Feature information. */
    syndicationSettings?: SyndicationResource;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deleteCatalog` operation. */
  export interface DeleteCatalogParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getEnterprise` operation. */
  export interface GetEnterpriseParams {
    /** Enterprise identification. */
    enterpriseId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `replaceEnterprise` operation. */
  export interface ReplaceEnterpriseParams {
    /** Enterprise identification. */
    enterpriseId: string;
    /** Enterprise identification. */
    id?: string;
    /** Cloudant revision. */
    rev?: string;
    /** Filters for account and catalog filters. */
    accountFilters?: Filters;
    /** Map of account group ids to AccountGroup objects. */
    accountGroups?: EnterpriseAccountGroups;
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
    /** URL path to zip location. */
    zipurl: string;
    /** Tags array. */
    tags?: string[];
    /** Target kinds.  Current valid values are 'iks', 'roks', 'vcenter', and 'terraform'. */
    targetKinds?: string[];
    /** The semver value for this new version, if not found in the zip url package content. */
    targetVersion?: string;
    /** Add all possible configuration values to this version when importing. */
    includeConfig?: boolean;
    /** The type of repository containing this version.  Valid values are 'public_git' or 'enterprise_git'. */
    repoType?: string;
    /** Authentication token used to access the specified zip file. */
    xAuthToken?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `importOffering` operation. */
  export interface ImportOfferingParams {
    /** Catalog identifier. */
    catalogIdentifier: string;
    /** URL path to zip location. */
    zipurl: string;
    /** Tags array. */
    tags?: string[];
    /** Target kinds.  Current valid values are 'iks', 'roks', 'vcenter', and 'terraform'. */
    targetKinds?: string[];
    /** Re-use the specified offeringID during import. */
    offeringId?: string;
    /** Add all possible configuration items when creating this version. */
    includeConfig?: boolean;
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
    /** URL path to zip location. */
    zipurl: string;
    /** The semver value for this new version. */
    targetVersion: string;
    /** Tags array. */
    tags?: string[];
    /** Target kinds.  Current valid values are 'iks', 'roks', 'vcenter', and 'terraform'. */
    targetKinds?: string[];
    /** The type of repository containing this version.  Valid values are 'public_git' or 'enterprise_git'. */
    repoType?: string;
    /** Authentication token used to access the specified zip file. */
    xAuthToken?: string;
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
      IBM = 'ibm',
      PUBLIC = 'public',
    }
    /** Approve (true) or disapprove (false). */
    export enum Approved {
      TRUE = 'true',
      FALSE = 'false',
    }
  }

  /** Parameters for the `getVersionAbout` operation. */
  export interface GetVersionAboutParams {
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getVersionLicense` operation. */
  export interface GetVersionLicenseParams {
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocId: string;
    /** The ID of the license, which maps to the file name in the 'licenses' directory of this verions tgz file. */
    licenseId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getVersionContainerImages` operation. */
  export interface GetVersionContainerImagesParams {
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

  /** Parameters for the `getVersionWorkingCopy` operation. */
  export interface GetVersionWorkingCopyParams {
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getVersionUpdates` operation. */
  export interface GetVersionUpdatesParams {
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocId: string;
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

  /** Parameters for the `listVersions` operation. */
  export interface ListVersionsParams {
    /** query, for now only "q=entitlement_key:<some-key>" is supported. */
    q: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getRepos` operation. */
  export interface GetReposParams {
    /** The type of repo (valid repo types: helm). */
    type: string;
    /** The URL for the repo's root (e.g https://kubernetes-charts-incubator.storage.googleapis.com). */
    repourl: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getRepo` operation. */
  export interface GetRepoParams {
    /** The type of repo (valid repo types: helm). */
    type: string;
    /** The URL for the repo's chart zip file (e.g
     *  https://registry.bluemix.net/helm/ibm-charts/charts/ibm-redis-ha-dev-1.0.0.tgz).
     */
    charturl: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listClusters` operation. */
  export interface ListClustersParams {
    /** number or results to return. */
    limit?: number;
    /** number of results to skip before returning values. */
    offset?: number;
    /** Kubernetes or OpenShift.  Default is kubernetes. */
    type?: string;
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
    /** number or results to return. */
    limit?: number;
    /** number of results to skip before returning values. */
    offset?: number;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `createOperator` operation. */
  export interface CreateOperatorParams {
    /** IAM Refresh token. */
    xAuthRefreshToken: string;
    /** Cluster ID. */
    clusterId?: string;
    /** Cluster region. */
    region?: string;
    /** Kube namespaces to deploy Operator(s) to. */
    namespaces?: string[];
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

  /** Parameters for the `replaceOperator` operation. */
  export interface ReplaceOperatorParams {
    /** IAM Refresh token. */
    xAuthRefreshToken: string;
    /** Cluster ID. */
    clusterId?: string;
    /** Cluster region. */
    region?: string;
    /** Kube namespaces to deploy Operator(s) to. */
    namespaces?: string[];
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocatorId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deleteOperator` operation. */
  export interface DeleteOperatorParams {
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
    /** Object containing Helm chart override values. */
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
    /** VCenter Password. */
    vcenterPassword?: string;
    /** VCenter Location. */
    vcenterLocation?: string;
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
    /** Object containing Helm chart override values. */
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
    /** VCenter Password. */
    vcenterPassword?: string;
    /** VCenter Location. */
    vcenterLocation?: string;
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

  /** Parameters for the `validationInstall` operation. */
  export interface ValidationInstallParams {
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
    /** Object containing Helm chart override values. */
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
    /** VCenter Password. */
    vcenterPassword?: string;
    /** VCenter Location. */
    vcenterLocation?: string;
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

  /** Parameters for the `getSchematicsWorkspaces` operation. */
  export interface GetSchematicsWorkspacesParams {
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocId: string;
    /** IAM Refresh token. */
    xAuthRefreshToken: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `canDeploySchematics` operation. */
  export interface CanDeploySchematicsParams {
    /** A dotted value of `catalogID`.`versionID`. */
    versionLocId: string;
    /** ID of the cluster. */
    clusterId: string;
    /** Cluster region. */
    region: string;
    /** Required if the version's pre-install scope is `namespace`. */
    namespace?: string;
    /** Resource group identification. */
    resourceGroupId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getResourceGroups` operation. */
  export interface GetResourceGroupsParams {
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getLicenseProviders` operation. */
  export interface GetLicenseProvidersParams {
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listLicenseEntitlements` operation. */
  export interface ListLicenseEntitlementsParams {
    /** The account ID to query for the entitlement. Default is the account from the user's token. */
    accountId?: string;
    /** The license product ID. If from PPA (Passport Advantage) this is the product Part number(s) which can be one
     *  or more IDs, eg. D1YGZLL,5737L09.
     */
    licenseProductId?: string;
    /** The GC ID of the specific offering version. */
    versionId?: string;
    /** The state of the license entitlement. eg. usually 'active', or if it's been deleted will show as 'removed'. */
    state?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `createLicenseEntitlement` operation. */
  export interface CreateLicenseEntitlementParams {
    /** Entitlement name. */
    name?: string;
    /** Entitlement is good from this starting date. eg. '2019-07-17T21:21:47.6794935Z'. */
    effectiveFrom?: string;
    /** Entitlement is good until this ending date. eg. '2019-07-17T21:21:47.6794935Z'. */
    effectiveUntil?: string;
    /** Global Catalog ID of the version. */
    versionId?: string;
    /** Specific license entitlement ID from the license provider, eg. D1W3R4. */
    licenseId?: string;
    /** IBM ID of the owner of this license entitlement. */
    licenseOwnerId?: string;
    /** License provider ID. */
    licenseProviderId?: string;
    /** License product ID. */
    licenseProductId?: string;
    /** if not specified the token's account will be used. */
    accountId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getLicenseEntitlements` operation. */
  export interface GetLicenseEntitlementsParams {
    /** The license product ID. If from PPA (Passport Advantage) this is a specific product Part number, eg.
     *  D1YGZLL.
     */
    licenseProductId: string;
    /** The account ID to query for the entitlement. Default is the account from the user's token. */
    accountId?: string;
    /** The GC ID of the specific offering version. */
    versionId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deleteLicenseEntitlement` operation. */
  export interface DeleteLicenseEntitlementParams {
    /** The specific entitlement ID (can be obtained from one of the license entitlement queries). */
    entitlementId: string;
    /** The account ID to query for the entitlement. Default is the account from the user's token. */
    accountId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getLicenses` operation. */
  export interface GetLicensesParams {
    /** ID of the license provider, ie. retrieved from GET license_providers. */
    licenseProviderId: string;
    /** If not specified the token's account will be used. */
    accountId?: string;
    /** License name. */
    name?: string;
    /** Type of license, if not specified, default is ibm-ppa. */
    licenseType?: string;
    /** The license product ID. If from PPA (Passport Advantage) this is the product Part number, eg. D1YGZLL. */
    licenseProductId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `searchLicenseVersions` operation. */
  export interface SearchLicenseVersionsParams {
    /** query, for now only "q=entitlement_key:<some-key>" is supported. */
    q: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `searchLicenseOfferings` operation. */
  export interface SearchLicenseOfferingsParams {
    /** query, for now only "q=entitlement_key:<some-key>" is supported. */
    q: string;
    headers?: OutgoingHttpHeaders;
  }

  /*************************
   * model interfaces
   ************************/

  /** Account information. */
  export interface Account {
    /** Account identification. */
    id?: string;
    /** Filters for account and catalog filters. */
    account_filters?: Filters;
  }

  /** Filters for an Account Group. */
  export interface AccountGroup {
    /** Account group identification. */
    id?: string;
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
    /** Visible to IBM. */
    ibm?: boolean;
    /** Visible to everyone. */
    public?: boolean;
    /** Denotes whether approval has changed. */
    changed?: boolean;
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
    /** The date'time this catalog was created. */
    created?: string;
    /** The date'time this catalog was last updated. */
    updated?: string;
    /** Resource group id the catalog is owned by. */
    resource_group_id?: string;
    /** Account that owns catalog. */
    owning_account?: string;
    /** Filters for account and catalog filters. */
    catalog_filters?: Filters;
    /** Feature information. */
    syndication_settings?: SyndicationResource;
  }

  /** Paginated catalog search result. */
  export interface CatalogSearchResult {
    /** The offset (origin 0) of the first resource in this page of search results. */
    offset?: number;
    /** The maximum number of resources returned in each page of search results. */
    limit?: number;
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

  /** Paginated cluster search result. */
  export interface ClusterSearchResult {
    /** The offset (origin 0) of the first resource in this page of search results. */
    offset?: number;
    /** The maximum number of resources returned in each page of search results. */
    limit?: number;
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
    resources?: ClusterInfo[];
  }

  /** Configuration description. */
  export interface Configuration {
    /** Configuration key. */
    key?: string;
    /** Value type (string, boolean, int). */
    type?: string;
    /** The default value. */
    default_value?: any;
    /** Constraint associated with value, e.g., for string type - regx:[a-z]. */
    value_constraint?: string;
    /** Key description. */
    description?: string;
    /** Is key required to install. */
    required?: boolean;
    /** List of options of type. */
    options?: JsonObject[];
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

  /** Failed deployment requirements. */
  export interface DeployRequirementsCheck {
    /** Failed during pre-install. */
    pre_install?: JsonObject;
    /** Failed during install. */
    install?: JsonObject;
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

  /** Enterprise account information. */
  export interface Enterprise {
    /** Enterprise identification. */
    id?: string;
    /** Cloudant revision. */
    _rev?: string;
    /** Filters for account and catalog filters. */
    account_filters?: Filters;
    /** Map of account group ids to AccountGroup objects. */
    account_groups?: EnterpriseAccountGroups;
  }

  /** Map of account group ids to AccountGroup objects. */
  export interface EnterpriseAccountGroups {
    /** Filters for an Account Group. */
    keys?: AccountGroup;
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

  /** Helm chart. */
  export interface HelmChart {
    /** Chart name. */
    name?: string;
    /** Chart description. */
    description?: string;
    /** Chart icon. */
    icon?: string;
    /** Chart version. */
    version?: string;
    /** Chart app version. */
    appVersion?: string;
  }

  /** Helm package. */
  export interface HelmPackage {
    /** The name of the requested chart, or the name of a nested chart within the requested chart. */
    chart?: HelmPackageChart;
  }

  /** The name of the requested chart, or the name of a nested chart within the requested chart. */
  export interface HelmPackageChart {
    /** Helm chart. */
    'Chart.yaml'?: HelmChart;
    /** Project SHA. */
    sha?: JsonObject;
    /** Helm chart description. */
    'README.md'?: string;
    /** Values metadata. */
    'values-metadata'?: JsonObject;
    /** License metadata. */
    'license-metadata'?: JsonObject;
  }

  /** Helm repository metadata. */
  export interface HelmRepoList {
    /** A chart entry in the repo. This response will contain many chart names. */
    chart?: HelmRepoListChart;
  }

  /** A chart entry in the repo. This response will contain many chart names. */
  export interface HelmRepoListChart {
    /** API version. */
    api_version?: string;
    /** Date and time created. */
    created?: string;
    /** Description of Helm repo entry. */
    description?: string;
    /** Denotes whether repo entry is deprecated. */
    deprecated?: boolean;
    /** Digest of entry. */
    digest?: string;
    /** Location of repo entry. */
    home?: string;
    /** Entry icon. */
    icon?: string;
    /** List of keywords. */
    keywords?: string[];
    /** Emails and names of repo maintainers. */
    maintainers?: Maintainers[];
    /** Entry name. */
    name?: string;
    /** Helm server version. */
    tiller_version?: string;
    /** Array of URLs. */
    urls?: string[];
    /** Array of sources. */
    sources?: string[];
    /** Entry version. */
    version?: string;
    /** Application version. */
    appVersion?: string;
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

  /** License entitlement. */
  export interface LicenseEntitlement {
    /** Entitlement name. */
    name?: string;
    /** Entitlement ID. */
    id?: string;
    /** Entitlement CRN. */
    crn?: string;
    /** URL for the BSS entitlement, e.g. /v1/licensing/entitlements/:id. */
    url?: string;
    /** Entitlement offering type. */
    offering_type?: string;
    /** State of the BSS entitlement, e.g. 'active' or if it's been deleted, 'removed'. */
    state?: string;
    /** Entitlement is good from this starting date. eg. '2019-07-17T21:21:47.6794935Z'. */
    effective_from?: string;
    /** Entitlement is good until this ending date. eg. '2019-07-17T21:21:47.6794935Z'. */
    effective_until?: string;
    /** Account ID where this entitlement is bound to. */
    account_id?: string;
    /** Account ID of owner. */
    owner_id?: string;
    /** GC ID of the specific offering version. */
    version_id?: string;
    /** Marketplace offering ID for this license entitlement. */
    license_offering_id?: string;
    /** Specific license entitlement ID from the license provider, eg. D1W3R4. */
    license_id?: string;
    /** IBM ID of the owner of this license entitlement. */
    license_owner_id?: string;
    /** Type of license entitlement, e.g. ibm-ppa. */
    license_type?: string;
    /** ID of the license provider. */
    license_provider_id?: string;
    /** URL for the BSS license provider, e.g. /v1/licensing/license_providers/:license_provider_id. */
    license_provider_url?: string;
    /** Specific license entitlement ID from the license provider, eg. D1W3R4. */
    license_product_id?: string;
    /** Location of the registry images, eg. cp/cp4d. */
    namespace_repository?: string;
    /** API key for access to the license entitlement. */
    apikey?: string;
    /** IBM ID. */
    create_by?: string;
    /** IBM ID. */
    update_by?: string;
    /** Creation date, eg. '2019-07-17T21:21:47.6794935Z'. */
    create_at?: string;
    /** Date last updated, eg. '2019-07-17T21:21:47.6794935Z'. */
    updated_at?: string;
    /** Entitlement history. */
    history?: LicenseEntitlementHistoryItem[];
    /** Array of license offering references. */
    offering_list?: LicenseOfferingReference[];
  }

  /** LicenseEntitlementHistoryItem. */
  export interface LicenseEntitlementHistoryItem {
    /** Eg. create. */
    action?: string;
    /** Eg. IBM ID of user. */
    user?: string;
    /** Date of action, eg. '2019-07-17T21:21:47.6794935Z'. */
    date?: string;
  }

  /** Paginated list of license entitlements. */
  export interface LicenseEntitlements {
    /** Total number of results. */
    total_results?: number;
    /** Total number of pages. */
    total_pages?: number;
    /** Previous URL. */
    prev_url?: string;
    /** Next URL. */
    next_url?: string;
    /** Resulting Entitlement objects. */
    resources?: LicenseEntitlement[];
  }

  /** License information. */
  export interface LicenseObject {
    /** License name. */
    name?: string;
    /** Type of offering. */
    offering_type?: string;
    /** Number of seats allowed for license. */
    seats_allowed?: string;
    /** Number of seats used for license. */
    seats_used?: string;
    /** ID of license owner. */
    owner_id?: string;
    /** Marketplace offering ID for this license. */
    license_offering_id?: string;
    /** specific license entitlement ID from the license provider, eg. D1W3R4. */
    license_id?: string;
    /** IBM ID of the owner of this license entitlement. */
    license_owner_id?: string;
    /** type of license entitlement, e.g. ibm-ppa. */
    license_type?: string;
    /** ID of the license provider. */
    license_provider_id?: string;
    /** specific license entitlement ID from the license provider, eg. D1W3R4. */
    license_product_id?: string;
    /** URL for the BSS license provider, e.g. /v1/licensing/license_providers/:license_provider_id. */
    license_provider_url?: string;
    /** license is good from this starting date. eg. '2019-07-17T21:21:47.6794935Z'. */
    effective_from?: string;
    /** license is good until this ending date. eg. '2019-07-17T21:21:47.6794935Z'. */
    effective_until?: string;
    /** If true, this will allow use of this license by all IBMers. */
    internal?: boolean;
    /** Array of license offering references. */
    offering_list?: LicenseOfferingReference[];
  }

  /** License offering reference. */
  export interface LicenseOfferingReference {
    /** Offering ID. */
    id?: string;
    /** Offering name. */
    name?: string;
    /** Offering label'. */
    label?: string;
    /** URL to offering icon. */
    offering_icon_url?: string;
    /** Account ID associated with offering. */
    account_id?: string;
    /** Catalog ID associated with offering. */
    catalog_id?: string;
  }

  /** BSS License provider. */
  export interface LicenseProvider {
    /** Provider name, eg. IBM Passport Advantage. */
    name?: string;
    /** Short description of license provider. */
    short_description?: string;
    /** Provider ID. */
    id?: string;
    /** Type of license entitlement, e.g. ibm-ppa. */
    licence_type?: string;
    /** Type of offering. */
    offering_type?: string;
    /** URL of the license provider for where to create/get a license, e.g.
     *  https://www.ibm.com/software/passportadvantage/aboutpassport.html.
     */
    create_url?: string;
    /** URL of the license provider for additional info, e.g. https://www.ibm.com/software/passportadvantage. */
    info_url?: string;
    /** URL for the BSS license provider, e.g. /v1/licensing/license_providers/:id. */
    url?: string;
    /** Provider CRN. */
    crn?: string;
    /** State of license provider. */
    state?: string;
  }

  /** Paginated list of license providers. */
  export interface LicenseProviders {
    /** Total number of results. */
    total_results?: number;
    /** Total number of pages. */
    total_pages?: number;
    /** Previous URL. */
    prev_url?: string;
    /** Next URL. */
    next_url?: string;
    /** Resulting License Provider objects. */
    resources?: LicenseProvider[];
  }

  /** Paginated list of licenses. */
  export interface Licenses {
    /** Total number of results. */
    total_results?: number;
    /** Total number of pages. */
    total_pages?: number;
    /** Previous URL. */
    prev_url?: string;
    /** Next URL. */
    next_url?: string;
    /** Resulting License objects. */
    resources?: LicenseObject[];
  }

  /** Repo maintainers. */
  export interface Maintainers {
    /** Maintainer email address. */
    email?: string;
    /** Name of maintainer. */
    name?: string;
  }

  /** Paginated list of namespace search results. */
  export interface NamespaceSearchResult {
    /** The offset (origin 0) of the first resource in this page of search results. */
    offset?: number;
    /** The maximum number of resources returned in each page of search results. */
    limit?: number;
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

  /** Paginated offering search result. */
  export interface OfferingSearchResult {
    /** The offset (origin 0) of the first resource in this page of search results. */
    offset?: number;
    /** The maximum number of resources returned in each page of search results. */
    limit?: number;
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

  /** Resource group details. */
  export interface ResourceGroup {
    /** Resource Group ID. */
    id?: string;
    /** Provider name, eg. IBM Passport Advantage. */
    name?: string;
    /** Provider CRN. */
    crn?: string;
    /** Account ID for this Resource Group. */
    account_id?: string;
    /** State of this Resource Group. */
    state?: string;
    /** Indicates if this Resource Group is active or not. */
    default?: boolean;
  }

  /** Resource groups details. */
  export interface ResourceGroups {
    /** The offset (origin 0) of the first resource in this page of search results. */
    offset?: number;
    /** The maximum number of resources returned in each page of search results. */
    limit?: number;
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
    /** Resulting Resource Group objects. */
    resources?: ResourceGroup[];
  }

  /** Schematics workspace information. */
  export interface SchematicsWorkspace {
    /** Workspace ID. */
    id?: string;
    /** Workspace name. */
    name?: string;
    /** Workspace types. */
    type?: string[];
    /** Workspace description. */
    description?: string;
    /** Workspace tags. */
    tags?: string[];
    /** Workspace creation date and time. */
    created_at?: string;
    /** Email address of user that created the ID. */
    created_by?: string;
    /** Workspace apply status. */
    status?: string;
    /** Workspace frozen/locked status. */
    workspace_status?: SchematicsWorkspaceWorkspaceStatus;
    /** Template reference. */
    template_ref?: string;
    /** Template repository. */
    template_repo?: SchematicsWorkspaceTemplateRepo;
    /** Map of template data. */
    template_data?: JsonObject[];
    /** Data describing runtime. */
    runtime_data?: SchematicsWorkspaceRuntimeData;
    /** Map of shared data. */
    shared_data?: JsonObject;
    /** Catalog reference. */
    catalog_ref?: SchematicsWorkspaceCatalogRef;
  }

  /** Catalog reference. */
  export interface SchematicsWorkspaceCatalogRef {
    /** Version locator ID. */
    item_id?: string;
    /** The name of the offering that generated this Blueprint. */
    item_name?: string;
    /** Relative Dashboard URL for content that generated this Blueprint. */
    item_url?: string;
  }

  /** Data describing runtime. */
  export interface SchematicsWorkspaceRuntimeData {
    /** Runtime ID. */
    id?: string;
    /** Engine name. */
    engine_name?: string;
    /** Engine version. */
    engine_version?: string;
    /** URL path to state store. */
    state_store_url?: string;
    /** URL path to log store. */
    log_store_url?: string;
  }

  /** Result of schematics workspace search. */
  export interface SchematicsWorkspaceSearchResult {
    /** The offset (origin 0) of the first resource in this page of search results. */
    offset?: number;
    /** The maximum number of resources returned in each page of search results. */
    limit?: number;
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
    resources?: SchematicsWorkspace[];
  }

  /** Template repository. */
  export interface SchematicsWorkspaceTemplateRepo {
    /** The fully qualified path of the tgz used in the deploy. */
    repo_url?: string;
    /** Name of chart. */
    chart_name?: string;
    /** Name of script. */
    script_name?: string;
    /** Name of uninstall script. */
    uninstall_script_name?: string;
    /** Name of folder. */
    folder_name?: string;
    /** Digest of project. */
    repo_sha_value?: string;
  }

  /** Workspace frozen/locked status. */
  export interface SchematicsWorkspaceWorkspaceStatus {
    /** Workspace frozen state. */
    frozen?: boolean;
    /** Workspace locked state. */
    locked?: boolean;
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
