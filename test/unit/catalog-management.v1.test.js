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

// need to import the whole package to mock getAuthenticatorFromEnvironment
const core = require('ibm-cloud-sdk-core');

const { NoAuthAuthenticator, unitTestUtils } = core;

const CatalogManagementV1 = require('../../dist/catalog-management/v1');

const {
  getOptions,
  checkUrlAndMethod,
  checkMediaHeaders,
  expectToBePromise,
  checkUserHeader,
  checkForSuccessfulExecution,
} = unitTestUtils;

const catalogManagementServiceOptions = {
  authenticator: new NoAuthAuthenticator(),
  url: 'https://cm.globalcatalog.cloud.ibm.com/api/v1-beta',
};

const catalogManagementService = new CatalogManagementV1(catalogManagementServiceOptions);

// dont actually create a request
const createRequestMock = jest.spyOn(catalogManagementService, 'createRequest');
createRequestMock.mockImplementation(() => Promise.resolve());

// dont actually construct an authenticator
const getAuthenticatorMock = jest.spyOn(core, 'getAuthenticatorFromEnvironment');
getAuthenticatorMock.mockImplementation(() => new NoAuthAuthenticator());

afterEach(() => {
  createRequestMock.mockClear();
  getAuthenticatorMock.mockClear();
});

describe('CatalogManagementV1', () => {
  describe('the newInstance method', () => {
    test('should use defaults when options not provided', () => {
      const testInstance = CatalogManagementV1.newInstance();

      expect(getAuthenticatorMock).toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceName).toBe(CatalogManagementV1.DEFAULT_SERVICE_NAME);
      expect(testInstance.baseOptions.serviceUrl).toBe(CatalogManagementV1.DEFAULT_SERVICE_URL);
      expect(testInstance).toBeInstanceOf(CatalogManagementV1);
    });

    test('should set serviceName, serviceUrl, and authenticator when provided', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
        serviceName: 'my-service',
      };

      const testInstance = CatalogManagementV1.newInstance(options);

      expect(getAuthenticatorMock).not.toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
      expect(testInstance.baseOptions.serviceName).toBe('my-service');
      expect(testInstance).toBeInstanceOf(CatalogManagementV1);
    });
  });
  describe('the constructor', () => {
    test('use user-given service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
      };

      const testInstance = new CatalogManagementV1(options);

      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
    });

    test('use default service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
      };

      const testInstance = new CatalogManagementV1(options);

      expect(testInstance.baseOptions.serviceUrl).toBe(CatalogManagementV1.DEFAULT_SERVICE_URL);
    });
  });
  describe('getCatalogAccount', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getCatalogAccount
        const params = {};

        const getCatalogAccountResult = catalogManagementService.getCatalogAccount(params);

        // all methods should return a Promise
        expectToBePromise(getCatalogAccountResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogaccount', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.getCatalogAccount(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        catalogManagementService.getCatalogAccount({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('updateCatalogAccount', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // FilterTerms
      const filterTermsModel = {
        filter_terms: ['testString'],
      };

      // CategoryFilter
      const categoryFilterModel = {
        include: true,
        filter: filterTermsModel,
      };

      // IDFilter
      const idFilterModel = {
        include: filterTermsModel,
        exclude: filterTermsModel,
      };

      // Filters
      const filtersModel = {
        include_all: true,
        category_filters: { 'key1': categoryFilterModel },
        id_filters: idFilterModel,
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation updateCatalogAccount
        const id = 'testString';
        const hideIbmCloudCatalog = true;
        const accountFilters = filtersModel;
        const params = {
          id,
          hideIbmCloudCatalog,
          accountFilters,
        };

        const updateCatalogAccountResult = catalogManagementService.updateCatalogAccount(params);

        // all methods should return a Promise
        expectToBePromise(updateCatalogAccountResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogaccount', 'PUT');
        const expectedAccept = undefined;
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body.id).toEqual(id);
        expect(options.body.hide_IBM_cloud_catalog).toEqual(hideIbmCloudCatalog);
        expect(options.body.account_filters).toEqual(accountFilters);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.updateCatalogAccount(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        catalogManagementService.updateCatalogAccount({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('getCatalogAccountAudit', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getCatalogAccountAudit
        const params = {};

        const getCatalogAccountAuditResult =
          catalogManagementService.getCatalogAccountAudit(params);

        // all methods should return a Promise
        expectToBePromise(getCatalogAccountAuditResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogaccount/audit', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.getCatalogAccountAudit(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        catalogManagementService.getCatalogAccountAudit({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('getCatalogAccountFilters', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getCatalogAccountFilters
        const catalog = 'testString';
        const params = {
          catalog,
        };

        const getCatalogAccountFiltersResult =
          catalogManagementService.getCatalogAccountFilters(params);

        // all methods should return a Promise
        expectToBePromise(getCatalogAccountFiltersResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogaccount/filters', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs.catalog).toEqual(catalog);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.getCatalogAccountFilters(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        catalogManagementService.getCatalogAccountFilters({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('listCatalogs', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listCatalogs
        const params = {};

        const listCatalogsResult = catalogManagementService.listCatalogs(params);

        // all methods should return a Promise
        expectToBePromise(listCatalogsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogs', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.listCatalogs(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        catalogManagementService.listCatalogs({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('createCatalog', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // Feature
      const featureModel = {
        title: 'testString',
        description: 'testString',
      };

      // FilterTerms
      const filterTermsModel = {
        filter_terms: ['testString'],
      };

      // CategoryFilter
      const categoryFilterModel = {
        include: true,
        filter: filterTermsModel,
      };

      // IDFilter
      const idFilterModel = {
        include: filterTermsModel,
        exclude: filterTermsModel,
      };

      // Filters
      const filtersModel = {
        include_all: true,
        category_filters: { 'key1': categoryFilterModel },
        id_filters: idFilterModel,
      };

      // SyndicationCluster
      const syndicationClusterModel = {
        region: 'testString',
        id: 'testString',
        name: 'testString',
        resource_group_name: 'testString',
        type: 'testString',
        namespaces: ['testString'],
        all_namespaces: true,
      };

      // SyndicationHistory
      const syndicationHistoryModel = {
        namespaces: ['testString'],
        clusters: [syndicationClusterModel],
        last_run: '2019-01-01T12:00:00.000Z',
      };

      // SyndicationAuthorization
      const syndicationAuthorizationModel = {
        token: 'testString',
        last_run: '2019-01-01T12:00:00.000Z',
      };

      // SyndicationResource
      const syndicationResourceModel = {
        remove_related_components: true,
        clusters: [syndicationClusterModel],
        history: syndicationHistoryModel,
        authorization: syndicationAuthorizationModel,
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createCatalog
        const id = 'testString';
        const rev = 'testString';
        const label = 'testString';
        const shortDescription = 'testString';
        const catalogIconUrl = 'testString';
        const tags = ['testString'];
        const features = [featureModel];
        const disabled = true;
        const resourceGroupId = 'testString';
        const owningAccount = 'testString';
        const catalogFilters = filtersModel;
        const syndicationSettings = syndicationResourceModel;
        const kind = 'testString';
        const params = {
          id,
          rev,
          label,
          shortDescription,
          catalogIconUrl,
          tags,
          features,
          disabled,
          resourceGroupId,
          owningAccount,
          catalogFilters,
          syndicationSettings,
          kind,
        };

        const createCatalogResult = catalogManagementService.createCatalog(params);

        // all methods should return a Promise
        expectToBePromise(createCatalogResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogs', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body.id).toEqual(id);
        expect(options.body._rev).toEqual(rev);
        expect(options.body.label).toEqual(label);
        expect(options.body.short_description).toEqual(shortDescription);
        expect(options.body.catalog_icon_url).toEqual(catalogIconUrl);
        expect(options.body.tags).toEqual(tags);
        expect(options.body.features).toEqual(features);
        expect(options.body.disabled).toEqual(disabled);
        expect(options.body.resource_group_id).toEqual(resourceGroupId);
        expect(options.body.owning_account).toEqual(owningAccount);
        expect(options.body.catalog_filters).toEqual(catalogFilters);
        expect(options.body.syndication_settings).toEqual(syndicationSettings);
        expect(options.body.kind).toEqual(kind);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.createCatalog(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        catalogManagementService.createCatalog({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('getCatalog', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getCatalog
        const catalogIdentifier = 'testString';
        const params = {
          catalogIdentifier,
        };

        const getCatalogResult = catalogManagementService.getCatalog(params);

        // all methods should return a Promise
        expectToBePromise(getCatalogResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogs/{catalog_identifier}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.getCatalog(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.getCatalog({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const getCatalogPromise = catalogManagementService.getCatalog();
        expectToBePromise(getCatalogPromise);

        getCatalogPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('replaceCatalog', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // Feature
      const featureModel = {
        title: 'testString',
        description: 'testString',
      };

      // FilterTerms
      const filterTermsModel = {
        filter_terms: ['testString'],
      };

      // CategoryFilter
      const categoryFilterModel = {
        include: true,
        filter: filterTermsModel,
      };

      // IDFilter
      const idFilterModel = {
        include: filterTermsModel,
        exclude: filterTermsModel,
      };

      // Filters
      const filtersModel = {
        include_all: true,
        category_filters: { 'key1': categoryFilterModel },
        id_filters: idFilterModel,
      };

      // SyndicationCluster
      const syndicationClusterModel = {
        region: 'testString',
        id: 'testString',
        name: 'testString',
        resource_group_name: 'testString',
        type: 'testString',
        namespaces: ['testString'],
        all_namespaces: true,
      };

      // SyndicationHistory
      const syndicationHistoryModel = {
        namespaces: ['testString'],
        clusters: [syndicationClusterModel],
        last_run: '2019-01-01T12:00:00.000Z',
      };

      // SyndicationAuthorization
      const syndicationAuthorizationModel = {
        token: 'testString',
        last_run: '2019-01-01T12:00:00.000Z',
      };

      // SyndicationResource
      const syndicationResourceModel = {
        remove_related_components: true,
        clusters: [syndicationClusterModel],
        history: syndicationHistoryModel,
        authorization: syndicationAuthorizationModel,
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation replaceCatalog
        const catalogIdentifier = 'testString';
        const id = 'testString';
        const rev = 'testString';
        const label = 'testString';
        const shortDescription = 'testString';
        const catalogIconUrl = 'testString';
        const tags = ['testString'];
        const features = [featureModel];
        const disabled = true;
        const resourceGroupId = 'testString';
        const owningAccount = 'testString';
        const catalogFilters = filtersModel;
        const syndicationSettings = syndicationResourceModel;
        const kind = 'testString';
        const params = {
          catalogIdentifier,
          id,
          rev,
          label,
          shortDescription,
          catalogIconUrl,
          tags,
          features,
          disabled,
          resourceGroupId,
          owningAccount,
          catalogFilters,
          syndicationSettings,
          kind,
        };

        const replaceCatalogResult = catalogManagementService.replaceCatalog(params);

        // all methods should return a Promise
        expectToBePromise(replaceCatalogResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogs/{catalog_identifier}', 'PUT');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body.id).toEqual(id);
        expect(options.body._rev).toEqual(rev);
        expect(options.body.label).toEqual(label);
        expect(options.body.short_description).toEqual(shortDescription);
        expect(options.body.catalog_icon_url).toEqual(catalogIconUrl);
        expect(options.body.tags).toEqual(tags);
        expect(options.body.features).toEqual(features);
        expect(options.body.disabled).toEqual(disabled);
        expect(options.body.resource_group_id).toEqual(resourceGroupId);
        expect(options.body.owning_account).toEqual(owningAccount);
        expect(options.body.catalog_filters).toEqual(catalogFilters);
        expect(options.body.syndication_settings).toEqual(syndicationSettings);
        expect(options.body.kind).toEqual(kind);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.replaceCatalog(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.replaceCatalog({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const replaceCatalogPromise = catalogManagementService.replaceCatalog();
        expectToBePromise(replaceCatalogPromise);

        replaceCatalogPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deleteCatalog', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteCatalog
        const catalogIdentifier = 'testString';
        const params = {
          catalogIdentifier,
        };

        const deleteCatalogResult = catalogManagementService.deleteCatalog(params);

        // all methods should return a Promise
        expectToBePromise(deleteCatalogResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogs/{catalog_identifier}', 'DELETE');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.deleteCatalog(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.deleteCatalog({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const deleteCatalogPromise = catalogManagementService.deleteCatalog();
        expectToBePromise(deleteCatalogPromise);

        deleteCatalogPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getCatalogAudit', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getCatalogAudit
        const catalogIdentifier = 'testString';
        const params = {
          catalogIdentifier,
        };

        const getCatalogAuditResult = catalogManagementService.getCatalogAudit(params);

        // all methods should return a Promise
        expectToBePromise(getCatalogAuditResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogs/{catalog_identifier}/audit', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.getCatalogAudit(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.getCatalogAudit({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const getCatalogAuditPromise = catalogManagementService.getCatalogAudit();
        expectToBePromise(getCatalogAuditPromise);

        getCatalogAuditPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getConsumptionOfferings', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getConsumptionOfferings
        const digest = true;
        const catalog = 'testString';
        const select = 'all';
        const includeHidden = true;
        const limit = 1000;
        const offset = 38;
        const params = {
          digest,
          catalog,
          select,
          includeHidden,
          limit,
          offset,
        };

        const getConsumptionOfferingsResult =
          catalogManagementService.getConsumptionOfferings(params);

        // all methods should return a Promise
        expectToBePromise(getConsumptionOfferingsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/offerings', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs.digest).toEqual(digest);
        expect(options.qs.catalog).toEqual(catalog);
        expect(options.qs.select).toEqual(select);
        expect(options.qs.includeHidden).toEqual(includeHidden);
        expect(options.qs.limit).toEqual(limit);
        expect(options.qs.offset).toEqual(offset);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.getConsumptionOfferings(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        catalogManagementService.getConsumptionOfferings({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('listOfferings', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listOfferings
        const catalogIdentifier = 'testString';
        const digest = true;
        const limit = 1000;
        const offset = 38;
        const name = 'testString';
        const sort = 'testString';
        const params = {
          catalogIdentifier,
          digest,
          limit,
          offset,
          name,
          sort,
        };

        const listOfferingsResult = catalogManagementService.listOfferings(params);

        // all methods should return a Promise
        expectToBePromise(listOfferingsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogs/{catalog_identifier}/offerings', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs.digest).toEqual(digest);
        expect(options.qs.limit).toEqual(limit);
        expect(options.qs.offset).toEqual(offset);
        expect(options.qs.name).toEqual(name);
        expect(options.qs.sort).toEqual(sort);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.listOfferings(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.listOfferings({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const listOfferingsPromise = catalogManagementService.listOfferings();
        expectToBePromise(listOfferingsPromise);

        listOfferingsPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('createOffering', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // Rating
      const ratingModel = {
        one_star_count: 38,
        two_star_count: 38,
        three_star_count: 38,
        four_star_count: 38,
      };

      // Feature
      const featureModel = {
        title: 'testString',
        description: 'testString',
      };

      // Configuration
      const configurationModel = {
        key: 'testString',
        type: 'testString',
        default_value: 'testString',
        value_constraint: 'testString',
        description: 'testString',
        required: true,
        options: ['testString'],
        hidden: true,
      };

      // Validation
      const validationModel = {
        validated: '2019-01-01T12:00:00.000Z',
        requested: '2019-01-01T12:00:00.000Z',
        state: 'testString',
        last_operation: 'testString',
        target: { 'key1': 'testString' },
      };

      // Resource
      const resourceModel = {
        type: 'mem',
        value: 'testString',
      };

      // Script
      const scriptModel = {
        instructions: 'testString',
        script: 'testString',
        script_permission: 'testString',
        delete_script: 'testString',
        scope: 'testString',
      };

      // VersionEntitlement
      const versionEntitlementModel = {
        provider_name: 'testString',
        provider_id: 'testString',
        product_id: 'testString',
        part_numbers: ['testString'],
        image_repo_name: 'testString',
      };

      // License
      const licenseModel = {
        id: 'testString',
        name: 'testString',
        type: 'testString',
        url: 'testString',
        description: 'testString',
      };

      // State
      const stateModel = {
        current: 'testString',
        current_entered: '2019-01-01T12:00:00.000Z',
        pending: 'testString',
        pending_requested: '2019-01-01T12:00:00.000Z',
        previous: 'testString',
      };

      // Version
      const versionModel = {
        id: 'testString',
        _rev: 'testString',
        crn: 'testString',
        version: 'testString',
        sha: 'testString',
        created: '2019-01-01T12:00:00.000Z',
        updated: '2019-01-01T12:00:00.000Z',
        offering_id: 'testString',
        catalog_id: 'testString',
        kind_id: 'testString',
        tags: ['testString'],
        repo_url: 'testString',
        source_url: 'testString',
        tgz_url: 'testString',
        configuration: [configurationModel],
        metadata: { 'key1': 'testString' },
        validation: validationModel,
        required_resources: [resourceModel],
        single_instance: true,
        install: scriptModel,
        pre_install: [scriptModel],
        entitlement: versionEntitlementModel,
        licenses: [licenseModel],
        image_manifest_url: 'testString',
        deprecated: true,
        package_version: 'testString',
        state: stateModel,
        version_locator: 'testString',
        console_url: 'testString',
        long_description: 'testString',
        whitelisted_accounts: ['testString'],
      };

      // Deployment
      const deploymentModel = {
        id: 'testString',
        label: 'testString',
        name: 'testString',
        short_description: 'testString',
        long_description: 'testString',
        metadata: { 'key1': 'testString' },
        tags: ['testString'],
        created: '2019-01-01T12:00:00.000Z',
        updated: '2019-01-01T12:00:00.000Z',
      };

      // Plan
      const planModel = {
        id: 'testString',
        label: 'testString',
        name: 'testString',
        short_description: 'testString',
        long_description: 'testString',
        metadata: { 'key1': 'testString' },
        tags: ['testString'],
        additional_features: [featureModel],
        created: '2019-01-01T12:00:00.000Z',
        updated: '2019-01-01T12:00:00.000Z',
        deployments: [deploymentModel],
      };

      // Kind
      const kindModel = {
        id: 'testString',
        format_kind: 'testString',
        target_kind: 'testString',
        metadata: { 'key1': 'testString' },
        install_description: 'testString',
        tags: ['testString'],
        additional_features: [featureModel],
        created: '2019-01-01T12:00:00.000Z',
        updated: '2019-01-01T12:00:00.000Z',
        versions: [versionModel],
        plans: [planModel],
      };

      // RepoInfo
      const repoInfoModel = {
        token: 'testString',
        type: 'testString',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createOffering
        const catalogIdentifier = 'testString';
        const id = 'testString';
        const rev = 'testString';
        const url = 'testString';
        const crn = 'testString';
        const label = 'testString';
        const name = 'testString';
        const offeringIconUrl = 'testString';
        const offeringDocsUrl = 'testString';
        const offeringSupportUrl = 'testString';
        const tags = ['testString'];
        const keywords = ['testString'];
        const rating = ratingModel;
        const created = '2019-01-01T12:00:00.000Z';
        const updated = '2019-01-01T12:00:00.000Z';
        const shortDescription = 'testString';
        const longDescription = 'testString';
        const features = [featureModel];
        const kinds = [kindModel];
        const permitRequestIbmPublicPublish = true;
        const ibmPublishApproved = true;
        const publicPublishApproved = true;
        const publicOriginalCrn = 'testString';
        const publishPublicCrn = 'testString';
        const portalApprovalRecord = 'testString';
        const portalUiUrl = 'testString';
        const catalogId = 'testString';
        const catalogName = 'testString';
        const metadata = { 'key1': 'testString' };
        const disclaimer = 'testString';
        const hidden = true;
        const provider = 'testString';
        const repoInfo = repoInfoModel;
        const params = {
          catalogIdentifier,
          id,
          rev,
          url,
          crn,
          label,
          name,
          offeringIconUrl,
          offeringDocsUrl,
          offeringSupportUrl,
          tags,
          keywords,
          rating,
          created,
          updated,
          shortDescription,
          longDescription,
          features,
          kinds,
          permitRequestIbmPublicPublish,
          ibmPublishApproved,
          publicPublishApproved,
          publicOriginalCrn,
          publishPublicCrn,
          portalApprovalRecord,
          portalUiUrl,
          catalogId,
          catalogName,
          metadata,
          disclaimer,
          hidden,
          provider,
          repoInfo,
        };

        const createOfferingResult = catalogManagementService.createOffering(params);

        // all methods should return a Promise
        expectToBePromise(createOfferingResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogs/{catalog_identifier}/offerings', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body.id).toEqual(id);
        expect(options.body._rev).toEqual(rev);
        expect(options.body.url).toEqual(url);
        expect(options.body.crn).toEqual(crn);
        expect(options.body.label).toEqual(label);
        expect(options.body.name).toEqual(name);
        expect(options.body.offering_icon_url).toEqual(offeringIconUrl);
        expect(options.body.offering_docs_url).toEqual(offeringDocsUrl);
        expect(options.body.offering_support_url).toEqual(offeringSupportUrl);
        expect(options.body.tags).toEqual(tags);
        expect(options.body.keywords).toEqual(keywords);
        expect(options.body.rating).toEqual(rating);
        expect(options.body.created).toEqual(created);
        expect(options.body.updated).toEqual(updated);
        expect(options.body.short_description).toEqual(shortDescription);
        expect(options.body.long_description).toEqual(longDescription);
        expect(options.body.features).toEqual(features);
        expect(options.body.kinds).toEqual(kinds);
        expect(options.body.permit_request_ibm_public_publish).toEqual(
          permitRequestIbmPublicPublish
        );
        expect(options.body.ibm_publish_approved).toEqual(ibmPublishApproved);
        expect(options.body.public_publish_approved).toEqual(publicPublishApproved);
        expect(options.body.public_original_crn).toEqual(publicOriginalCrn);
        expect(options.body.publish_public_crn).toEqual(publishPublicCrn);
        expect(options.body.portal_approval_record).toEqual(portalApprovalRecord);
        expect(options.body.portal_ui_url).toEqual(portalUiUrl);
        expect(options.body.catalog_id).toEqual(catalogId);
        expect(options.body.catalog_name).toEqual(catalogName);
        expect(options.body.metadata).toEqual(metadata);
        expect(options.body.disclaimer).toEqual(disclaimer);
        expect(options.body.hidden).toEqual(hidden);
        expect(options.body.provider).toEqual(provider);
        expect(options.body.repo_info).toEqual(repoInfo);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.createOffering(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.createOffering({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const createOfferingPromise = catalogManagementService.createOffering();
        expectToBePromise(createOfferingPromise);

        createOfferingPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('importOfferingVersion', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation importOfferingVersion
        const catalogIdentifier = 'testString';
        const offeringId = 'testString';
        const tags = ['testString'];
        const targetKinds = ['testString'];
        const content = 'This is a mock byte array value.';
        const zipurl = 'testString';
        const targetVersion = 'testString';
        const includeConfig = true;
        const isVsi = true;
        const repoType = 'testString';
        const params = {
          catalogIdentifier,
          offeringId,
          tags,
          targetKinds,
          content,
          zipurl,
          targetVersion,
          includeConfig,
          isVsi,
          repoType,
        };

        const importOfferingVersionResult = catalogManagementService.importOfferingVersion(params);

        // all methods should return a Promise
        expectToBePromise(importOfferingVersionResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(
          options,
          '/catalogs/{catalog_identifier}/offerings/{offering_id}/version',
          'POST'
        );
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body.tags).toEqual(tags);
        expect(options.body.target_kinds).toEqual(targetKinds);
        expect(options.body.content).toEqual(content);
        expect(options.qs.zipurl).toEqual(zipurl);
        expect(options.qs.targetVersion).toEqual(targetVersion);
        expect(options.qs.includeConfig).toEqual(includeConfig);
        expect(options.qs.isVSI).toEqual(isVsi);
        expect(options.qs.repoType).toEqual(repoType);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
        expect(options.path.offering_id).toEqual(offeringId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const offeringId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          offeringId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.importOfferingVersion(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.importOfferingVersion({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const importOfferingVersionPromise = catalogManagementService.importOfferingVersion();
        expectToBePromise(importOfferingVersionPromise);

        importOfferingVersionPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('importOffering', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation importOffering
        const catalogIdentifier = 'testString';
        const tags = ['testString'];
        const targetKinds = ['testString'];
        const content = 'This is a mock byte array value.';
        const zipurl = 'testString';
        const offeringId = 'testString';
        const targetVersion = 'testString';
        const includeConfig = true;
        const isVsi = true;
        const repoType = 'testString';
        const xAuthToken = 'testString';
        const params = {
          catalogIdentifier,
          tags,
          targetKinds,
          content,
          zipurl,
          offeringId,
          targetVersion,
          includeConfig,
          isVsi,
          repoType,
          xAuthToken,
        };

        const importOfferingResult = catalogManagementService.importOffering(params);

        // all methods should return a Promise
        expectToBePromise(importOfferingResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogs/{catalog_identifier}/import/offerings', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'X-Auth-Token', xAuthToken);
        expect(options.body.tags).toEqual(tags);
        expect(options.body.target_kinds).toEqual(targetKinds);
        expect(options.body.content).toEqual(content);
        expect(options.qs.zipurl).toEqual(zipurl);
        expect(options.qs.offeringID).toEqual(offeringId);
        expect(options.qs.targetVersion).toEqual(targetVersion);
        expect(options.qs.includeConfig).toEqual(includeConfig);
        expect(options.qs.isVSI).toEqual(isVsi);
        expect(options.qs.repoType).toEqual(repoType);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.importOffering(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.importOffering({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const importOfferingPromise = catalogManagementService.importOffering();
        expectToBePromise(importOfferingPromise);

        importOfferingPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('reloadOffering', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation reloadOffering
        const catalogIdentifier = 'testString';
        const offeringId = 'testString';
        const targetVersion = 'testString';
        const tags = ['testString'];
        const targetKinds = ['testString'];
        const content = 'This is a mock byte array value.';
        const zipurl = 'testString';
        const repoType = 'testString';
        const params = {
          catalogIdentifier,
          offeringId,
          targetVersion,
          tags,
          targetKinds,
          content,
          zipurl,
          repoType,
        };

        const reloadOfferingResult = catalogManagementService.reloadOffering(params);

        // all methods should return a Promise
        expectToBePromise(reloadOfferingResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(
          options,
          '/catalogs/{catalog_identifier}/offerings/{offering_id}/reload',
          'PUT'
        );
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body.tags).toEqual(tags);
        expect(options.body.target_kinds).toEqual(targetKinds);
        expect(options.body.content).toEqual(content);
        expect(options.qs.targetVersion).toEqual(targetVersion);
        expect(options.qs.zipurl).toEqual(zipurl);
        expect(options.qs.repoType).toEqual(repoType);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
        expect(options.path.offering_id).toEqual(offeringId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const offeringId = 'testString';
        const targetVersion = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          offeringId,
          targetVersion,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.reloadOffering(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.reloadOffering({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const reloadOfferingPromise = catalogManagementService.reloadOffering();
        expectToBePromise(reloadOfferingPromise);

        reloadOfferingPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getOffering', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getOffering
        const catalogIdentifier = 'testString';
        const offeringId = 'testString';
        const params = {
          catalogIdentifier,
          offeringId,
        };

        const getOfferingResult = catalogManagementService.getOffering(params);

        // all methods should return a Promise
        expectToBePromise(getOfferingResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogs/{catalog_identifier}/offerings/{offering_id}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
        expect(options.path.offering_id).toEqual(offeringId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const offeringId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          offeringId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.getOffering(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.getOffering({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const getOfferingPromise = catalogManagementService.getOffering();
        expectToBePromise(getOfferingPromise);

        getOfferingPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('replaceOffering', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // Rating
      const ratingModel = {
        one_star_count: 38,
        two_star_count: 38,
        three_star_count: 38,
        four_star_count: 38,
      };

      // Feature
      const featureModel = {
        title: 'testString',
        description: 'testString',
      };

      // Configuration
      const configurationModel = {
        key: 'testString',
        type: 'testString',
        default_value: 'testString',
        value_constraint: 'testString',
        description: 'testString',
        required: true,
        options: ['testString'],
        hidden: true,
      };

      // Validation
      const validationModel = {
        validated: '2019-01-01T12:00:00.000Z',
        requested: '2019-01-01T12:00:00.000Z',
        state: 'testString',
        last_operation: 'testString',
        target: { 'key1': 'testString' },
      };

      // Resource
      const resourceModel = {
        type: 'mem',
        value: 'testString',
      };

      // Script
      const scriptModel = {
        instructions: 'testString',
        script: 'testString',
        script_permission: 'testString',
        delete_script: 'testString',
        scope: 'testString',
      };

      // VersionEntitlement
      const versionEntitlementModel = {
        provider_name: 'testString',
        provider_id: 'testString',
        product_id: 'testString',
        part_numbers: ['testString'],
        image_repo_name: 'testString',
      };

      // License
      const licenseModel = {
        id: 'testString',
        name: 'testString',
        type: 'testString',
        url: 'testString',
        description: 'testString',
      };

      // State
      const stateModel = {
        current: 'testString',
        current_entered: '2019-01-01T12:00:00.000Z',
        pending: 'testString',
        pending_requested: '2019-01-01T12:00:00.000Z',
        previous: 'testString',
      };

      // Version
      const versionModel = {
        id: 'testString',
        _rev: 'testString',
        crn: 'testString',
        version: 'testString',
        sha: 'testString',
        created: '2019-01-01T12:00:00.000Z',
        updated: '2019-01-01T12:00:00.000Z',
        offering_id: 'testString',
        catalog_id: 'testString',
        kind_id: 'testString',
        tags: ['testString'],
        repo_url: 'testString',
        source_url: 'testString',
        tgz_url: 'testString',
        configuration: [configurationModel],
        metadata: { 'key1': 'testString' },
        validation: validationModel,
        required_resources: [resourceModel],
        single_instance: true,
        install: scriptModel,
        pre_install: [scriptModel],
        entitlement: versionEntitlementModel,
        licenses: [licenseModel],
        image_manifest_url: 'testString',
        deprecated: true,
        package_version: 'testString',
        state: stateModel,
        version_locator: 'testString',
        console_url: 'testString',
        long_description: 'testString',
        whitelisted_accounts: ['testString'],
      };

      // Deployment
      const deploymentModel = {
        id: 'testString',
        label: 'testString',
        name: 'testString',
        short_description: 'testString',
        long_description: 'testString',
        metadata: { 'key1': 'testString' },
        tags: ['testString'],
        created: '2019-01-01T12:00:00.000Z',
        updated: '2019-01-01T12:00:00.000Z',
      };

      // Plan
      const planModel = {
        id: 'testString',
        label: 'testString',
        name: 'testString',
        short_description: 'testString',
        long_description: 'testString',
        metadata: { 'key1': 'testString' },
        tags: ['testString'],
        additional_features: [featureModel],
        created: '2019-01-01T12:00:00.000Z',
        updated: '2019-01-01T12:00:00.000Z',
        deployments: [deploymentModel],
      };

      // Kind
      const kindModel = {
        id: 'testString',
        format_kind: 'testString',
        target_kind: 'testString',
        metadata: { 'key1': 'testString' },
        install_description: 'testString',
        tags: ['testString'],
        additional_features: [featureModel],
        created: '2019-01-01T12:00:00.000Z',
        updated: '2019-01-01T12:00:00.000Z',
        versions: [versionModel],
        plans: [planModel],
      };

      // RepoInfo
      const repoInfoModel = {
        token: 'testString',
        type: 'testString',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation replaceOffering
        const catalogIdentifier = 'testString';
        const offeringId = 'testString';
        const id = 'testString';
        const rev = 'testString';
        const url = 'testString';
        const crn = 'testString';
        const label = 'testString';
        const name = 'testString';
        const offeringIconUrl = 'testString';
        const offeringDocsUrl = 'testString';
        const offeringSupportUrl = 'testString';
        const tags = ['testString'];
        const keywords = ['testString'];
        const rating = ratingModel;
        const created = '2019-01-01T12:00:00.000Z';
        const updated = '2019-01-01T12:00:00.000Z';
        const shortDescription = 'testString';
        const longDescription = 'testString';
        const features = [featureModel];
        const kinds = [kindModel];
        const permitRequestIbmPublicPublish = true;
        const ibmPublishApproved = true;
        const publicPublishApproved = true;
        const publicOriginalCrn = 'testString';
        const publishPublicCrn = 'testString';
        const portalApprovalRecord = 'testString';
        const portalUiUrl = 'testString';
        const catalogId = 'testString';
        const catalogName = 'testString';
        const metadata = { 'key1': 'testString' };
        const disclaimer = 'testString';
        const hidden = true;
        const provider = 'testString';
        const repoInfo = repoInfoModel;
        const params = {
          catalogIdentifier,
          offeringId,
          id,
          rev,
          url,
          crn,
          label,
          name,
          offeringIconUrl,
          offeringDocsUrl,
          offeringSupportUrl,
          tags,
          keywords,
          rating,
          created,
          updated,
          shortDescription,
          longDescription,
          features,
          kinds,
          permitRequestIbmPublicPublish,
          ibmPublishApproved,
          publicPublishApproved,
          publicOriginalCrn,
          publishPublicCrn,
          portalApprovalRecord,
          portalUiUrl,
          catalogId,
          catalogName,
          metadata,
          disclaimer,
          hidden,
          provider,
          repoInfo,
        };

        const replaceOfferingResult = catalogManagementService.replaceOffering(params);

        // all methods should return a Promise
        expectToBePromise(replaceOfferingResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogs/{catalog_identifier}/offerings/{offering_id}', 'PUT');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body.id).toEqual(id);
        expect(options.body._rev).toEqual(rev);
        expect(options.body.url).toEqual(url);
        expect(options.body.crn).toEqual(crn);
        expect(options.body.label).toEqual(label);
        expect(options.body.name).toEqual(name);
        expect(options.body.offering_icon_url).toEqual(offeringIconUrl);
        expect(options.body.offering_docs_url).toEqual(offeringDocsUrl);
        expect(options.body.offering_support_url).toEqual(offeringSupportUrl);
        expect(options.body.tags).toEqual(tags);
        expect(options.body.keywords).toEqual(keywords);
        expect(options.body.rating).toEqual(rating);
        expect(options.body.created).toEqual(created);
        expect(options.body.updated).toEqual(updated);
        expect(options.body.short_description).toEqual(shortDescription);
        expect(options.body.long_description).toEqual(longDescription);
        expect(options.body.features).toEqual(features);
        expect(options.body.kinds).toEqual(kinds);
        expect(options.body.permit_request_ibm_public_publish).toEqual(
          permitRequestIbmPublicPublish
        );
        expect(options.body.ibm_publish_approved).toEqual(ibmPublishApproved);
        expect(options.body.public_publish_approved).toEqual(publicPublishApproved);
        expect(options.body.public_original_crn).toEqual(publicOriginalCrn);
        expect(options.body.publish_public_crn).toEqual(publishPublicCrn);
        expect(options.body.portal_approval_record).toEqual(portalApprovalRecord);
        expect(options.body.portal_ui_url).toEqual(portalUiUrl);
        expect(options.body.catalog_id).toEqual(catalogId);
        expect(options.body.catalog_name).toEqual(catalogName);
        expect(options.body.metadata).toEqual(metadata);
        expect(options.body.disclaimer).toEqual(disclaimer);
        expect(options.body.hidden).toEqual(hidden);
        expect(options.body.provider).toEqual(provider);
        expect(options.body.repo_info).toEqual(repoInfo);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
        expect(options.path.offering_id).toEqual(offeringId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const offeringId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          offeringId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.replaceOffering(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.replaceOffering({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const replaceOfferingPromise = catalogManagementService.replaceOffering();
        expectToBePromise(replaceOfferingPromise);

        replaceOfferingPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deleteOffering', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteOffering
        const catalogIdentifier = 'testString';
        const offeringId = 'testString';
        const params = {
          catalogIdentifier,
          offeringId,
        };

        const deleteOfferingResult = catalogManagementService.deleteOffering(params);

        // all methods should return a Promise
        expectToBePromise(deleteOfferingResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(
          options,
          '/catalogs/{catalog_identifier}/offerings/{offering_id}',
          'DELETE'
        );
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
        expect(options.path.offering_id).toEqual(offeringId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const offeringId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          offeringId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.deleteOffering(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.deleteOffering({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const deleteOfferingPromise = catalogManagementService.deleteOffering();
        expectToBePromise(deleteOfferingPromise);

        deleteOfferingPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getOfferingAudit', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getOfferingAudit
        const catalogIdentifier = 'testString';
        const offeringId = 'testString';
        const params = {
          catalogIdentifier,
          offeringId,
        };

        const getOfferingAuditResult = catalogManagementService.getOfferingAudit(params);

        // all methods should return a Promise
        expectToBePromise(getOfferingAuditResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(
          options,
          '/catalogs/{catalog_identifier}/offerings/{offering_id}/audit',
          'GET'
        );
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
        expect(options.path.offering_id).toEqual(offeringId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const offeringId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          offeringId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.getOfferingAudit(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.getOfferingAudit({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const getOfferingAuditPromise = catalogManagementService.getOfferingAudit();
        expectToBePromise(getOfferingAuditPromise);

        getOfferingAuditPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('replaceOfferingIcon', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation replaceOfferingIcon
        const catalogIdentifier = 'testString';
        const offeringId = 'testString';
        const fileName = 'testString';
        const params = {
          catalogIdentifier,
          offeringId,
          fileName,
        };

        const replaceOfferingIconResult = catalogManagementService.replaceOfferingIcon(params);

        // all methods should return a Promise
        expectToBePromise(replaceOfferingIconResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(
          options,
          '/catalogs/{catalog_identifier}/offerings/{offering_id}/icon/{file_name}',
          'PUT'
        );
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
        expect(options.path.offering_id).toEqual(offeringId);
        expect(options.path.file_name).toEqual(fileName);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const offeringId = 'testString';
        const fileName = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          offeringId,
          fileName,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.replaceOfferingIcon(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.replaceOfferingIcon({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const replaceOfferingIconPromise = catalogManagementService.replaceOfferingIcon();
        expectToBePromise(replaceOfferingIconPromise);

        replaceOfferingIconPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('updateOfferingIbm', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation updateOfferingIbm
        const catalogIdentifier = 'testString';
        const offeringId = 'testString';
        const approvalType = 'allow_request';
        const approved = 'true';
        const params = {
          catalogIdentifier,
          offeringId,
          approvalType,
          approved,
        };

        const updateOfferingIbmResult = catalogManagementService.updateOfferingIbm(params);

        // all methods should return a Promise
        expectToBePromise(updateOfferingIbmResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(
          options,
          '/catalogs/{catalog_identifier}/offerings/{offering_id}/publish/{approval_type}/{approved}',
          'POST'
        );
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
        expect(options.path.offering_id).toEqual(offeringId);
        expect(options.path.approval_type).toEqual(approvalType);
        expect(options.path.approved).toEqual(approved);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const offeringId = 'testString';
        const approvalType = 'allow_request';
        const approved = 'true';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          offeringId,
          approvalType,
          approved,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.updateOfferingIbm(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.updateOfferingIbm({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const updateOfferingIbmPromise = catalogManagementService.updateOfferingIbm();
        expectToBePromise(updateOfferingIbmPromise);

        updateOfferingIbmPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getOfferingUpdates', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getOfferingUpdates
        const catalogIdentifier = 'testString';
        const offeringId = 'testString';
        const kind = 'testString';
        const version = 'testString';
        const clusterId = 'testString';
        const region = 'testString';
        const resourceGroupId = 'testString';
        const namespace = 'testString';
        const params = {
          catalogIdentifier,
          offeringId,
          kind,
          version,
          clusterId,
          region,
          resourceGroupId,
          namespace,
        };

        const getOfferingUpdatesResult = catalogManagementService.getOfferingUpdates(params);

        // all methods should return a Promise
        expectToBePromise(getOfferingUpdatesResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(
          options,
          '/catalogs/{catalog_identifier}/offerings/{offering_id}/updates',
          'GET'
        );
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs.kind).toEqual(kind);
        expect(options.qs.version).toEqual(version);
        expect(options.qs.cluster_id).toEqual(clusterId);
        expect(options.qs.region).toEqual(region);
        expect(options.qs.resource_group_id).toEqual(resourceGroupId);
        expect(options.qs.namespace).toEqual(namespace);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
        expect(options.path.offering_id).toEqual(offeringId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const offeringId = 'testString';
        const kind = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          offeringId,
          kind,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.getOfferingUpdates(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.getOfferingUpdates({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const getOfferingUpdatesPromise = catalogManagementService.getOfferingUpdates();
        expectToBePromise(getOfferingUpdatesPromise);

        getOfferingUpdatesPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getOfferingAbout', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getOfferingAbout
        const versionLocId = 'testString';
        const params = {
          versionLocId,
        };

        const getOfferingAboutResult = catalogManagementService.getOfferingAbout(params);

        // all methods should return a Promise
        expectToBePromise(getOfferingAboutResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/about', 'GET');
        const expectedAccept = 'text/markdown';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.version_loc_id).toEqual(versionLocId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const versionLocId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          versionLocId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.getOfferingAbout(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.getOfferingAbout({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const getOfferingAboutPromise = catalogManagementService.getOfferingAbout();
        expectToBePromise(getOfferingAboutPromise);

        getOfferingAboutPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getOfferingLicense', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getOfferingLicense
        const versionLocId = 'testString';
        const licenseId = 'testString';
        const params = {
          versionLocId,
          licenseId,
        };

        const getOfferingLicenseResult = catalogManagementService.getOfferingLicense(params);

        // all methods should return a Promise
        expectToBePromise(getOfferingLicenseResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/licenses/{license_id}', 'GET');
        const expectedAccept = 'text/plain';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.version_loc_id).toEqual(versionLocId);
        expect(options.path.license_id).toEqual(licenseId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const versionLocId = 'testString';
        const licenseId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          versionLocId,
          licenseId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.getOfferingLicense(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.getOfferingLicense({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const getOfferingLicensePromise = catalogManagementService.getOfferingLicense();
        expectToBePromise(getOfferingLicensePromise);

        getOfferingLicensePromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getOfferingContainerImages', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getOfferingContainerImages
        const versionLocId = 'testString';
        const params = {
          versionLocId,
        };

        const getOfferingContainerImagesResult =
          catalogManagementService.getOfferingContainerImages(params);

        // all methods should return a Promise
        expectToBePromise(getOfferingContainerImagesResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/containerImages', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.version_loc_id).toEqual(versionLocId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const versionLocId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          versionLocId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.getOfferingContainerImages(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.getOfferingContainerImages({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const getOfferingContainerImagesPromise =
          catalogManagementService.getOfferingContainerImages();
        expectToBePromise(getOfferingContainerImagesPromise);

        getOfferingContainerImagesPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deprecateVersion', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deprecateVersion
        const versionLocId = 'testString';
        const params = {
          versionLocId,
        };

        const deprecateVersionResult = catalogManagementService.deprecateVersion(params);

        // all methods should return a Promise
        expectToBePromise(deprecateVersionResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/deprecate', 'POST');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.version_loc_id).toEqual(versionLocId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const versionLocId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          versionLocId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.deprecateVersion(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.deprecateVersion({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const deprecateVersionPromise = catalogManagementService.deprecateVersion();
        expectToBePromise(deprecateVersionPromise);

        deprecateVersionPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('accountPublishVersion', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation accountPublishVersion
        const versionLocId = 'testString';
        const params = {
          versionLocId,
        };

        const accountPublishVersionResult = catalogManagementService.accountPublishVersion(params);

        // all methods should return a Promise
        expectToBePromise(accountPublishVersionResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/account-publish', 'POST');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.version_loc_id).toEqual(versionLocId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const versionLocId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          versionLocId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.accountPublishVersion(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.accountPublishVersion({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const accountPublishVersionPromise = catalogManagementService.accountPublishVersion();
        expectToBePromise(accountPublishVersionPromise);

        accountPublishVersionPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('ibmPublishVersion', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation ibmPublishVersion
        const versionLocId = 'testString';
        const params = {
          versionLocId,
        };

        const ibmPublishVersionResult = catalogManagementService.ibmPublishVersion(params);

        // all methods should return a Promise
        expectToBePromise(ibmPublishVersionResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/ibm-publish', 'POST');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.version_loc_id).toEqual(versionLocId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const versionLocId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          versionLocId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.ibmPublishVersion(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.ibmPublishVersion({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const ibmPublishVersionPromise = catalogManagementService.ibmPublishVersion();
        expectToBePromise(ibmPublishVersionPromise);

        ibmPublishVersionPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('publicPublishVersion', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation publicPublishVersion
        const versionLocId = 'testString';
        const params = {
          versionLocId,
        };

        const publicPublishVersionResult = catalogManagementService.publicPublishVersion(params);

        // all methods should return a Promise
        expectToBePromise(publicPublishVersionResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/public-publish', 'POST');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.version_loc_id).toEqual(versionLocId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const versionLocId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          versionLocId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.publicPublishVersion(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.publicPublishVersion({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const publicPublishVersionPromise = catalogManagementService.publicPublishVersion();
        expectToBePromise(publicPublishVersionPromise);

        publicPublishVersionPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('commitVersion', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation commitVersion
        const versionLocId = 'testString';
        const params = {
          versionLocId,
        };

        const commitVersionResult = catalogManagementService.commitVersion(params);

        // all methods should return a Promise
        expectToBePromise(commitVersionResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/commit', 'POST');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.version_loc_id).toEqual(versionLocId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const versionLocId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          versionLocId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.commitVersion(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.commitVersion({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const commitVersionPromise = catalogManagementService.commitVersion();
        expectToBePromise(commitVersionPromise);

        commitVersionPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('copyVersion', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation copyVersion
        const versionLocId = 'testString';
        const tags = ['testString'];
        const targetKinds = ['testString'];
        const content = 'This is a mock byte array value.';
        const params = {
          versionLocId,
          tags,
          targetKinds,
          content,
        };

        const copyVersionResult = catalogManagementService.copyVersion(params);

        // all methods should return a Promise
        expectToBePromise(copyVersionResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/copy', 'POST');
        const expectedAccept = undefined;
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body.tags).toEqual(tags);
        expect(options.body.target_kinds).toEqual(targetKinds);
        expect(options.body.content).toEqual(content);
        expect(options.path.version_loc_id).toEqual(versionLocId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const versionLocId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          versionLocId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.copyVersion(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.copyVersion({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const copyVersionPromise = catalogManagementService.copyVersion();
        expectToBePromise(copyVersionPromise);

        copyVersionPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getOfferingWorkingCopy', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getOfferingWorkingCopy
        const versionLocId = 'testString';
        const params = {
          versionLocId,
        };

        const getOfferingWorkingCopyResult =
          catalogManagementService.getOfferingWorkingCopy(params);

        // all methods should return a Promise
        expectToBePromise(getOfferingWorkingCopyResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/workingcopy', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.version_loc_id).toEqual(versionLocId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const versionLocId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          versionLocId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.getOfferingWorkingCopy(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.getOfferingWorkingCopy({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const getOfferingWorkingCopyPromise = catalogManagementService.getOfferingWorkingCopy();
        expectToBePromise(getOfferingWorkingCopyPromise);

        getOfferingWorkingCopyPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getVersion', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getVersion
        const versionLocId = 'testString';
        const params = {
          versionLocId,
        };

        const getVersionResult = catalogManagementService.getVersion(params);

        // all methods should return a Promise
        expectToBePromise(getVersionResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.version_loc_id).toEqual(versionLocId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const versionLocId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          versionLocId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.getVersion(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.getVersion({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const getVersionPromise = catalogManagementService.getVersion();
        expectToBePromise(getVersionPromise);

        getVersionPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deleteVersion', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteVersion
        const versionLocId = 'testString';
        const params = {
          versionLocId,
        };

        const deleteVersionResult = catalogManagementService.deleteVersion(params);

        // all methods should return a Promise
        expectToBePromise(deleteVersionResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}', 'DELETE');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.version_loc_id).toEqual(versionLocId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const versionLocId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          versionLocId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.deleteVersion(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.deleteVersion({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const deleteVersionPromise = catalogManagementService.deleteVersion();
        expectToBePromise(deleteVersionPromise);

        deleteVersionPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getCluster', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getCluster
        const clusterId = 'testString';
        const region = 'testString';
        const xAuthRefreshToken = 'testString';
        const params = {
          clusterId,
          region,
          xAuthRefreshToken,
        };

        const getClusterResult = catalogManagementService.getCluster(params);

        // all methods should return a Promise
        expectToBePromise(getClusterResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/deploy/kubernetes/clusters/{cluster_id}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'X-Auth-Refresh-Token', xAuthRefreshToken);
        expect(options.qs.region).toEqual(region);
        expect(options.path.cluster_id).toEqual(clusterId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const clusterId = 'testString';
        const region = 'testString';
        const xAuthRefreshToken = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          clusterId,
          region,
          xAuthRefreshToken,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.getCluster(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.getCluster({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const getClusterPromise = catalogManagementService.getCluster();
        expectToBePromise(getClusterPromise);

        getClusterPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getNamespaces', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getNamespaces
        const clusterId = 'testString';
        const region = 'testString';
        const xAuthRefreshToken = 'testString';
        const limit = 1000;
        const offset = 38;
        const params = {
          clusterId,
          region,
          xAuthRefreshToken,
          limit,
          offset,
        };

        const getNamespacesResult = catalogManagementService.getNamespaces(params);

        // all methods should return a Promise
        expectToBePromise(getNamespacesResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/deploy/kubernetes/clusters/{cluster_id}/namespaces', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'X-Auth-Refresh-Token', xAuthRefreshToken);
        expect(options.qs.region).toEqual(region);
        expect(options.qs.limit).toEqual(limit);
        expect(options.qs.offset).toEqual(offset);
        expect(options.path.cluster_id).toEqual(clusterId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const clusterId = 'testString';
        const region = 'testString';
        const xAuthRefreshToken = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          clusterId,
          region,
          xAuthRefreshToken,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.getNamespaces(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.getNamespaces({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const getNamespacesPromise = catalogManagementService.getNamespaces();
        expectToBePromise(getNamespacesPromise);

        getNamespacesPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deployOperators', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deployOperators
        const xAuthRefreshToken = 'testString';
        const clusterId = 'testString';
        const region = 'testString';
        const namespaces = ['testString'];
        const allNamespaces = true;
        const versionLocatorId = 'testString';
        const params = {
          xAuthRefreshToken,
          clusterId,
          region,
          namespaces,
          allNamespaces,
          versionLocatorId,
        };

        const deployOperatorsResult = catalogManagementService.deployOperators(params);

        // all methods should return a Promise
        expectToBePromise(deployOperatorsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/deploy/kubernetes/olm/operator', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'X-Auth-Refresh-Token', xAuthRefreshToken);
        expect(options.body.cluster_id).toEqual(clusterId);
        expect(options.body.region).toEqual(region);
        expect(options.body.namespaces).toEqual(namespaces);
        expect(options.body.all_namespaces).toEqual(allNamespaces);
        expect(options.body.version_locator_id).toEqual(versionLocatorId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const xAuthRefreshToken = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          xAuthRefreshToken,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.deployOperators(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.deployOperators({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const deployOperatorsPromise = catalogManagementService.deployOperators();
        expectToBePromise(deployOperatorsPromise);

        deployOperatorsPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('listOperators', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listOperators
        const xAuthRefreshToken = 'testString';
        const clusterId = 'testString';
        const region = 'testString';
        const versionLocatorId = 'testString';
        const params = {
          xAuthRefreshToken,
          clusterId,
          region,
          versionLocatorId,
        };

        const listOperatorsResult = catalogManagementService.listOperators(params);

        // all methods should return a Promise
        expectToBePromise(listOperatorsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/deploy/kubernetes/olm/operator', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'X-Auth-Refresh-Token', xAuthRefreshToken);
        expect(options.qs.cluster_id).toEqual(clusterId);
        expect(options.qs.region).toEqual(region);
        expect(options.qs.version_locator_id).toEqual(versionLocatorId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const xAuthRefreshToken = 'testString';
        const clusterId = 'testString';
        const region = 'testString';
        const versionLocatorId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          xAuthRefreshToken,
          clusterId,
          region,
          versionLocatorId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.listOperators(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.listOperators({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const listOperatorsPromise = catalogManagementService.listOperators();
        expectToBePromise(listOperatorsPromise);

        listOperatorsPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('replaceOperators', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation replaceOperators
        const xAuthRefreshToken = 'testString';
        const clusterId = 'testString';
        const region = 'testString';
        const namespaces = ['testString'];
        const allNamespaces = true;
        const versionLocatorId = 'testString';
        const params = {
          xAuthRefreshToken,
          clusterId,
          region,
          namespaces,
          allNamespaces,
          versionLocatorId,
        };

        const replaceOperatorsResult = catalogManagementService.replaceOperators(params);

        // all methods should return a Promise
        expectToBePromise(replaceOperatorsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/deploy/kubernetes/olm/operator', 'PUT');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'X-Auth-Refresh-Token', xAuthRefreshToken);
        expect(options.body.cluster_id).toEqual(clusterId);
        expect(options.body.region).toEqual(region);
        expect(options.body.namespaces).toEqual(namespaces);
        expect(options.body.all_namespaces).toEqual(allNamespaces);
        expect(options.body.version_locator_id).toEqual(versionLocatorId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const xAuthRefreshToken = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          xAuthRefreshToken,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.replaceOperators(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.replaceOperators({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const replaceOperatorsPromise = catalogManagementService.replaceOperators();
        expectToBePromise(replaceOperatorsPromise);

        replaceOperatorsPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deleteOperators', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteOperators
        const xAuthRefreshToken = 'testString';
        const clusterId = 'testString';
        const region = 'testString';
        const versionLocatorId = 'testString';
        const params = {
          xAuthRefreshToken,
          clusterId,
          region,
          versionLocatorId,
        };

        const deleteOperatorsResult = catalogManagementService.deleteOperators(params);

        // all methods should return a Promise
        expectToBePromise(deleteOperatorsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/deploy/kubernetes/olm/operator', 'DELETE');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'X-Auth-Refresh-Token', xAuthRefreshToken);
        expect(options.qs.cluster_id).toEqual(clusterId);
        expect(options.qs.region).toEqual(region);
        expect(options.qs.version_locator_id).toEqual(versionLocatorId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const xAuthRefreshToken = 'testString';
        const clusterId = 'testString';
        const region = 'testString';
        const versionLocatorId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          xAuthRefreshToken,
          clusterId,
          region,
          versionLocatorId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.deleteOperators(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.deleteOperators({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const deleteOperatorsPromise = catalogManagementService.deleteOperators();
        expectToBePromise(deleteOperatorsPromise);

        deleteOperatorsPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('installVersion', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // DeployRequestBodySchematics
      const deployRequestBodySchematicsModel = {
        name: 'testString',
        description: 'testString',
        tags: ['testString'],
        resource_group_id: 'testString',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation installVersion
        const versionLocId = 'testString';
        const xAuthRefreshToken = 'testString';
        const clusterId = 'testString';
        const region = 'testString';
        const namespace = 'testString';
        const overrideValues = { 'key1': 'testString' };
        const entitlementApikey = 'testString';
        const schematics = deployRequestBodySchematicsModel;
        const script = 'testString';
        const scriptId = 'testString';
        const versionLocatorId = 'testString';
        const vcenterId = 'testString';
        const vcenterUser = 'testString';
        const vcenterPassword = 'testString';
        const vcenterLocation = 'testString';
        const vcenterDatastore = 'testString';
        const params = {
          versionLocId,
          xAuthRefreshToken,
          clusterId,
          region,
          namespace,
          overrideValues,
          entitlementApikey,
          schematics,
          script,
          scriptId,
          versionLocatorId,
          vcenterId,
          vcenterUser,
          vcenterPassword,
          vcenterLocation,
          vcenterDatastore,
        };

        const installVersionResult = catalogManagementService.installVersion(params);

        // all methods should return a Promise
        expectToBePromise(installVersionResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/install', 'POST');
        const expectedAccept = undefined;
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'X-Auth-Refresh-Token', xAuthRefreshToken);
        expect(options.body.cluster_id).toEqual(clusterId);
        expect(options.body.region).toEqual(region);
        expect(options.body.namespace).toEqual(namespace);
        expect(options.body.override_values).toEqual(overrideValues);
        expect(options.body.entitlement_apikey).toEqual(entitlementApikey);
        expect(options.body.schematics).toEqual(schematics);
        expect(options.body.script).toEqual(script);
        expect(options.body.script_id).toEqual(scriptId);
        expect(options.body.version_locator_id).toEqual(versionLocatorId);
        expect(options.body.vcenter_id).toEqual(vcenterId);
        expect(options.body.vcenter_user).toEqual(vcenterUser);
        expect(options.body.vcenter_password).toEqual(vcenterPassword);
        expect(options.body.vcenter_location).toEqual(vcenterLocation);
        expect(options.body.vcenter_datastore).toEqual(vcenterDatastore);
        expect(options.path.version_loc_id).toEqual(versionLocId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const versionLocId = 'testString';
        const xAuthRefreshToken = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          versionLocId,
          xAuthRefreshToken,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.installVersion(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.installVersion({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const installVersionPromise = catalogManagementService.installVersion();
        expectToBePromise(installVersionPromise);

        installVersionPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('preinstallVersion', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // DeployRequestBodySchematics
      const deployRequestBodySchematicsModel = {
        name: 'testString',
        description: 'testString',
        tags: ['testString'],
        resource_group_id: 'testString',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation preinstallVersion
        const versionLocId = 'testString';
        const xAuthRefreshToken = 'testString';
        const clusterId = 'testString';
        const region = 'testString';
        const namespace = 'testString';
        const overrideValues = { 'key1': 'testString' };
        const entitlementApikey = 'testString';
        const schematics = deployRequestBodySchematicsModel;
        const script = 'testString';
        const scriptId = 'testString';
        const versionLocatorId = 'testString';
        const vcenterId = 'testString';
        const vcenterUser = 'testString';
        const vcenterPassword = 'testString';
        const vcenterLocation = 'testString';
        const vcenterDatastore = 'testString';
        const params = {
          versionLocId,
          xAuthRefreshToken,
          clusterId,
          region,
          namespace,
          overrideValues,
          entitlementApikey,
          schematics,
          script,
          scriptId,
          versionLocatorId,
          vcenterId,
          vcenterUser,
          vcenterPassword,
          vcenterLocation,
          vcenterDatastore,
        };

        const preinstallVersionResult = catalogManagementService.preinstallVersion(params);

        // all methods should return a Promise
        expectToBePromise(preinstallVersionResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/preinstall', 'POST');
        const expectedAccept = undefined;
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'X-Auth-Refresh-Token', xAuthRefreshToken);
        expect(options.body.cluster_id).toEqual(clusterId);
        expect(options.body.region).toEqual(region);
        expect(options.body.namespace).toEqual(namespace);
        expect(options.body.override_values).toEqual(overrideValues);
        expect(options.body.entitlement_apikey).toEqual(entitlementApikey);
        expect(options.body.schematics).toEqual(schematics);
        expect(options.body.script).toEqual(script);
        expect(options.body.script_id).toEqual(scriptId);
        expect(options.body.version_locator_id).toEqual(versionLocatorId);
        expect(options.body.vcenter_id).toEqual(vcenterId);
        expect(options.body.vcenter_user).toEqual(vcenterUser);
        expect(options.body.vcenter_password).toEqual(vcenterPassword);
        expect(options.body.vcenter_location).toEqual(vcenterLocation);
        expect(options.body.vcenter_datastore).toEqual(vcenterDatastore);
        expect(options.path.version_loc_id).toEqual(versionLocId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const versionLocId = 'testString';
        const xAuthRefreshToken = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          versionLocId,
          xAuthRefreshToken,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.preinstallVersion(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.preinstallVersion({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const preinstallVersionPromise = catalogManagementService.preinstallVersion();
        expectToBePromise(preinstallVersionPromise);

        preinstallVersionPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getPreinstall', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getPreinstall
        const versionLocId = 'testString';
        const xAuthRefreshToken = 'testString';
        const clusterId = 'testString';
        const region = 'testString';
        const namespace = 'testString';
        const params = {
          versionLocId,
          xAuthRefreshToken,
          clusterId,
          region,
          namespace,
        };

        const getPreinstallResult = catalogManagementService.getPreinstall(params);

        // all methods should return a Promise
        expectToBePromise(getPreinstallResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/preinstall', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'X-Auth-Refresh-Token', xAuthRefreshToken);
        expect(options.qs.cluster_id).toEqual(clusterId);
        expect(options.qs.region).toEqual(region);
        expect(options.qs.namespace).toEqual(namespace);
        expect(options.path.version_loc_id).toEqual(versionLocId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const versionLocId = 'testString';
        const xAuthRefreshToken = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          versionLocId,
          xAuthRefreshToken,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.getPreinstall(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.getPreinstall({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const getPreinstallPromise = catalogManagementService.getPreinstall();
        expectToBePromise(getPreinstallPromise);

        getPreinstallPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('validateInstall', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // DeployRequestBodySchematics
      const deployRequestBodySchematicsModel = {
        name: 'testString',
        description: 'testString',
        tags: ['testString'],
        resource_group_id: 'testString',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation validateInstall
        const versionLocId = 'testString';
        const xAuthRefreshToken = 'testString';
        const clusterId = 'testString';
        const region = 'testString';
        const namespace = 'testString';
        const overrideValues = { 'key1': 'testString' };
        const entitlementApikey = 'testString';
        const schematics = deployRequestBodySchematicsModel;
        const script = 'testString';
        const scriptId = 'testString';
        const versionLocatorId = 'testString';
        const vcenterId = 'testString';
        const vcenterUser = 'testString';
        const vcenterPassword = 'testString';
        const vcenterLocation = 'testString';
        const vcenterDatastore = 'testString';
        const params = {
          versionLocId,
          xAuthRefreshToken,
          clusterId,
          region,
          namespace,
          overrideValues,
          entitlementApikey,
          schematics,
          script,
          scriptId,
          versionLocatorId,
          vcenterId,
          vcenterUser,
          vcenterPassword,
          vcenterLocation,
          vcenterDatastore,
        };

        const validateInstallResult = catalogManagementService.validateInstall(params);

        // all methods should return a Promise
        expectToBePromise(validateInstallResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/validation/install', 'POST');
        const expectedAccept = undefined;
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'X-Auth-Refresh-Token', xAuthRefreshToken);
        expect(options.body.cluster_id).toEqual(clusterId);
        expect(options.body.region).toEqual(region);
        expect(options.body.namespace).toEqual(namespace);
        expect(options.body.override_values).toEqual(overrideValues);
        expect(options.body.entitlement_apikey).toEqual(entitlementApikey);
        expect(options.body.schematics).toEqual(schematics);
        expect(options.body.script).toEqual(script);
        expect(options.body.script_id).toEqual(scriptId);
        expect(options.body.version_locator_id).toEqual(versionLocatorId);
        expect(options.body.vcenter_id).toEqual(vcenterId);
        expect(options.body.vcenter_user).toEqual(vcenterUser);
        expect(options.body.vcenter_password).toEqual(vcenterPassword);
        expect(options.body.vcenter_location).toEqual(vcenterLocation);
        expect(options.body.vcenter_datastore).toEqual(vcenterDatastore);
        expect(options.path.version_loc_id).toEqual(versionLocId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const versionLocId = 'testString';
        const xAuthRefreshToken = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          versionLocId,
          xAuthRefreshToken,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.validateInstall(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.validateInstall({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const validateInstallPromise = catalogManagementService.validateInstall();
        expectToBePromise(validateInstallPromise);

        validateInstallPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getValidationStatus', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getValidationStatus
        const versionLocId = 'testString';
        const xAuthRefreshToken = 'testString';
        const params = {
          versionLocId,
          xAuthRefreshToken,
        };

        const getValidationStatusResult = catalogManagementService.getValidationStatus(params);

        // all methods should return a Promise
        expectToBePromise(getValidationStatusResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/validation/install', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'X-Auth-Refresh-Token', xAuthRefreshToken);
        expect(options.path.version_loc_id).toEqual(versionLocId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const versionLocId = 'testString';
        const xAuthRefreshToken = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          versionLocId,
          xAuthRefreshToken,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.getValidationStatus(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.getValidationStatus({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const getValidationStatusPromise = catalogManagementService.getValidationStatus();
        expectToBePromise(getValidationStatusPromise);

        getValidationStatusPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getOverrideValues', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getOverrideValues
        const versionLocId = 'testString';
        const params = {
          versionLocId,
        };

        const getOverrideValuesResult = catalogManagementService.getOverrideValues(params);

        // all methods should return a Promise
        expectToBePromise(getOverrideValuesResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/validation/overridevalues', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.version_loc_id).toEqual(versionLocId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const versionLocId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          versionLocId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.getOverrideValues(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.getOverrideValues({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const getOverrideValuesPromise = catalogManagementService.getOverrideValues();
        expectToBePromise(getOverrideValuesPromise);

        getOverrideValuesPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('searchObjects', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation searchObjects
        const query = 'testString';
        const limit = 1000;
        const offset = 38;
        const collapse = true;
        const digest = true;
        const params = {
          query,
          limit,
          offset,
          collapse,
          digest,
        };

        const searchObjectsResult = catalogManagementService.searchObjects(params);

        // all methods should return a Promise
        expectToBePromise(searchObjectsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/objects', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs.query).toEqual(query);
        expect(options.qs.limit).toEqual(limit);
        expect(options.qs.offset).toEqual(offset);
        expect(options.qs.collapse).toEqual(collapse);
        expect(options.qs.digest).toEqual(digest);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const query = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          query,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.searchObjects(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.searchObjects({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const searchObjectsPromise = catalogManagementService.searchObjects();
        expectToBePromise(searchObjectsPromise);

        searchObjectsPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('listObjects', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listObjects
        const catalogIdentifier = 'testString';
        const limit = 1000;
        const offset = 38;
        const name = 'testString';
        const sort = 'testString';
        const params = {
          catalogIdentifier,
          limit,
          offset,
          name,
          sort,
        };

        const listObjectsResult = catalogManagementService.listObjects(params);

        // all methods should return a Promise
        expectToBePromise(listObjectsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogs/{catalog_identifier}/objects', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs.limit).toEqual(limit);
        expect(options.qs.offset).toEqual(offset);
        expect(options.qs.name).toEqual(name);
        expect(options.qs.sort).toEqual(sort);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.listObjects(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.listObjects({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const listObjectsPromise = catalogManagementService.listObjects();
        expectToBePromise(listObjectsPromise);

        listObjectsPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('createObject', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // PublishObject
      const publishObjectModel = {
        permit_ibm_public_publish: true,
        ibm_approved: true,
        public_approved: true,
        portal_approval_record: 'testString',
        portal_url: 'testString',
      };

      // State
      const stateModel = {
        current: 'testString',
        current_entered: '2019-01-01T12:00:00.000Z',
        pending: 'testString',
        pending_requested: '2019-01-01T12:00:00.000Z',
        previous: 'testString',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createObject
        const catalogIdentifier = 'testString';
        const id = 'testString';
        const name = 'testString';
        const rev = 'testString';
        const crn = 'testString';
        const url = 'testString';
        const parentId = 'testString';
        const labelI18n = 'testString';
        const label = 'testString';
        const tags = ['testString'];
        const created = '2019-01-01T12:00:00.000Z';
        const updated = '2019-01-01T12:00:00.000Z';
        const shortDescription = 'testString';
        const shortDescriptionI18n = 'testString';
        const kind = 'testString';
        const publish = publishObjectModel;
        const state = stateModel;
        const catalogId = 'testString';
        const catalogName = 'testString';
        const data = { 'key1': 'testString' };
        const params = {
          catalogIdentifier,
          id,
          name,
          rev,
          crn,
          url,
          parentId,
          labelI18n,
          label,
          tags,
          created,
          updated,
          shortDescription,
          shortDescriptionI18n,
          kind,
          publish,
          state,
          catalogId,
          catalogName,
          data,
        };

        const createObjectResult = catalogManagementService.createObject(params);

        // all methods should return a Promise
        expectToBePromise(createObjectResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogs/{catalog_identifier}/objects', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body.id).toEqual(id);
        expect(options.body.name).toEqual(name);
        expect(options.body._rev).toEqual(rev);
        expect(options.body.crn).toEqual(crn);
        expect(options.body.url).toEqual(url);
        expect(options.body.parent_id).toEqual(parentId);
        expect(options.body.label_i18n).toEqual(labelI18n);
        expect(options.body.label).toEqual(label);
        expect(options.body.tags).toEqual(tags);
        expect(options.body.created).toEqual(created);
        expect(options.body.updated).toEqual(updated);
        expect(options.body.short_description).toEqual(shortDescription);
        expect(options.body.short_description_i18n).toEqual(shortDescriptionI18n);
        expect(options.body.kind).toEqual(kind);
        expect(options.body.publish).toEqual(publish);
        expect(options.body.state).toEqual(state);
        expect(options.body.catalog_id).toEqual(catalogId);
        expect(options.body.catalog_name).toEqual(catalogName);
        expect(options.body.data).toEqual(data);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.createObject(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.createObject({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const createObjectPromise = catalogManagementService.createObject();
        expectToBePromise(createObjectPromise);

        createObjectPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getObject', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getObject
        const catalogIdentifier = 'testString';
        const objectIdentifier = 'testString';
        const params = {
          catalogIdentifier,
          objectIdentifier,
        };

        const getObjectResult = catalogManagementService.getObject(params);

        // all methods should return a Promise
        expectToBePromise(getObjectResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(
          options,
          '/catalogs/{catalog_identifier}/objects/{object_identifier}',
          'GET'
        );
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
        expect(options.path.object_identifier).toEqual(objectIdentifier);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const objectIdentifier = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          objectIdentifier,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.getObject(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.getObject({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const getObjectPromise = catalogManagementService.getObject();
        expectToBePromise(getObjectPromise);

        getObjectPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('replaceObject', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // PublishObject
      const publishObjectModel = {
        permit_ibm_public_publish: true,
        ibm_approved: true,
        public_approved: true,
        portal_approval_record: 'testString',
        portal_url: 'testString',
      };

      // State
      const stateModel = {
        current: 'testString',
        current_entered: '2019-01-01T12:00:00.000Z',
        pending: 'testString',
        pending_requested: '2019-01-01T12:00:00.000Z',
        previous: 'testString',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation replaceObject
        const catalogIdentifier = 'testString';
        const objectIdentifier = 'testString';
        const id = 'testString';
        const name = 'testString';
        const rev = 'testString';
        const crn = 'testString';
        const url = 'testString';
        const parentId = 'testString';
        const labelI18n = 'testString';
        const label = 'testString';
        const tags = ['testString'];
        const created = '2019-01-01T12:00:00.000Z';
        const updated = '2019-01-01T12:00:00.000Z';
        const shortDescription = 'testString';
        const shortDescriptionI18n = 'testString';
        const kind = 'testString';
        const publish = publishObjectModel;
        const state = stateModel;
        const catalogId = 'testString';
        const catalogName = 'testString';
        const data = { 'key1': 'testString' };
        const params = {
          catalogIdentifier,
          objectIdentifier,
          id,
          name,
          rev,
          crn,
          url,
          parentId,
          labelI18n,
          label,
          tags,
          created,
          updated,
          shortDescription,
          shortDescriptionI18n,
          kind,
          publish,
          state,
          catalogId,
          catalogName,
          data,
        };

        const replaceObjectResult = catalogManagementService.replaceObject(params);

        // all methods should return a Promise
        expectToBePromise(replaceObjectResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(
          options,
          '/catalogs/{catalog_identifier}/objects/{object_identifier}',
          'PUT'
        );
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body.id).toEqual(id);
        expect(options.body.name).toEqual(name);
        expect(options.body._rev).toEqual(rev);
        expect(options.body.crn).toEqual(crn);
        expect(options.body.url).toEqual(url);
        expect(options.body.parent_id).toEqual(parentId);
        expect(options.body.label_i18n).toEqual(labelI18n);
        expect(options.body.label).toEqual(label);
        expect(options.body.tags).toEqual(tags);
        expect(options.body.created).toEqual(created);
        expect(options.body.updated).toEqual(updated);
        expect(options.body.short_description).toEqual(shortDescription);
        expect(options.body.short_description_i18n).toEqual(shortDescriptionI18n);
        expect(options.body.kind).toEqual(kind);
        expect(options.body.publish).toEqual(publish);
        expect(options.body.state).toEqual(state);
        expect(options.body.catalog_id).toEqual(catalogId);
        expect(options.body.catalog_name).toEqual(catalogName);
        expect(options.body.data).toEqual(data);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
        expect(options.path.object_identifier).toEqual(objectIdentifier);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const objectIdentifier = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          objectIdentifier,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.replaceObject(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.replaceObject({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const replaceObjectPromise = catalogManagementService.replaceObject();
        expectToBePromise(replaceObjectPromise);

        replaceObjectPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deleteObject', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteObject
        const catalogIdentifier = 'testString';
        const objectIdentifier = 'testString';
        const params = {
          catalogIdentifier,
          objectIdentifier,
        };

        const deleteObjectResult = catalogManagementService.deleteObject(params);

        // all methods should return a Promise
        expectToBePromise(deleteObjectResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(
          options,
          '/catalogs/{catalog_identifier}/objects/{object_identifier}',
          'DELETE'
        );
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
        expect(options.path.object_identifier).toEqual(objectIdentifier);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const objectIdentifier = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          objectIdentifier,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.deleteObject(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.deleteObject({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const deleteObjectPromise = catalogManagementService.deleteObject();
        expectToBePromise(deleteObjectPromise);

        deleteObjectPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getObjectAudit', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getObjectAudit
        const catalogIdentifier = 'testString';
        const objectIdentifier = 'testString';
        const params = {
          catalogIdentifier,
          objectIdentifier,
        };

        const getObjectAuditResult = catalogManagementService.getObjectAudit(params);

        // all methods should return a Promise
        expectToBePromise(getObjectAuditResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(
          options,
          '/catalogs/{catalog_identifier}/objects/{object_identifier}/audit',
          'GET'
        );
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
        expect(options.path.object_identifier).toEqual(objectIdentifier);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const objectIdentifier = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          objectIdentifier,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.getObjectAudit(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.getObjectAudit({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const getObjectAuditPromise = catalogManagementService.getObjectAudit();
        expectToBePromise(getObjectAuditPromise);

        getObjectAuditPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('accountPublishObject', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation accountPublishObject
        const catalogIdentifier = 'testString';
        const objectIdentifier = 'testString';
        const params = {
          catalogIdentifier,
          objectIdentifier,
        };

        const accountPublishObjectResult = catalogManagementService.accountPublishObject(params);

        // all methods should return a Promise
        expectToBePromise(accountPublishObjectResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(
          options,
          '/catalogs/{catalog_identifier}/objects/{object_identifier}/account-publish',
          'POST'
        );
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
        expect(options.path.object_identifier).toEqual(objectIdentifier);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const objectIdentifier = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          objectIdentifier,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.accountPublishObject(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.accountPublishObject({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const accountPublishObjectPromise = catalogManagementService.accountPublishObject();
        expectToBePromise(accountPublishObjectPromise);

        accountPublishObjectPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('sharedPublishObject', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation sharedPublishObject
        const catalogIdentifier = 'testString';
        const objectIdentifier = 'testString';
        const params = {
          catalogIdentifier,
          objectIdentifier,
        };

        const sharedPublishObjectResult = catalogManagementService.sharedPublishObject(params);

        // all methods should return a Promise
        expectToBePromise(sharedPublishObjectResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(
          options,
          '/catalogs/{catalog_identifier}/objects/{object_identifier}/shared-publish',
          'POST'
        );
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
        expect(options.path.object_identifier).toEqual(objectIdentifier);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const objectIdentifier = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          objectIdentifier,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.sharedPublishObject(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.sharedPublishObject({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const sharedPublishObjectPromise = catalogManagementService.sharedPublishObject();
        expectToBePromise(sharedPublishObjectPromise);

        sharedPublishObjectPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('ibmPublishObject', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation ibmPublishObject
        const catalogIdentifier = 'testString';
        const objectIdentifier = 'testString';
        const params = {
          catalogIdentifier,
          objectIdentifier,
        };

        const ibmPublishObjectResult = catalogManagementService.ibmPublishObject(params);

        // all methods should return a Promise
        expectToBePromise(ibmPublishObjectResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(
          options,
          '/catalogs/{catalog_identifier}/objects/{object_identifier}/ibm-publish',
          'POST'
        );
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
        expect(options.path.object_identifier).toEqual(objectIdentifier);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const objectIdentifier = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          objectIdentifier,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.ibmPublishObject(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.ibmPublishObject({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const ibmPublishObjectPromise = catalogManagementService.ibmPublishObject();
        expectToBePromise(ibmPublishObjectPromise);

        ibmPublishObjectPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('publicPublishObject', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation publicPublishObject
        const catalogIdentifier = 'testString';
        const objectIdentifier = 'testString';
        const params = {
          catalogIdentifier,
          objectIdentifier,
        };

        const publicPublishObjectResult = catalogManagementService.publicPublishObject(params);

        // all methods should return a Promise
        expectToBePromise(publicPublishObjectResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(
          options,
          '/catalogs/{catalog_identifier}/objects/{object_identifier}/public-publish',
          'POST'
        );
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
        expect(options.path.object_identifier).toEqual(objectIdentifier);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const objectIdentifier = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          objectIdentifier,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.publicPublishObject(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.publicPublishObject({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const publicPublishObjectPromise = catalogManagementService.publicPublishObject();
        expectToBePromise(publicPublishObjectPromise);

        publicPublishObjectPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('createObjectAccess', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createObjectAccess
        const catalogIdentifier = 'testString';
        const objectIdentifier = 'testString';
        const accountIdentifier = 'testString';
        const params = {
          catalogIdentifier,
          objectIdentifier,
          accountIdentifier,
        };

        const createObjectAccessResult = catalogManagementService.createObjectAccess(params);

        // all methods should return a Promise
        expectToBePromise(createObjectAccessResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(
          options,
          '/catalogs/{catalog_identifier}/objects/{object_identifier}/access/{account_identifier}',
          'POST'
        );
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
        expect(options.path.object_identifier).toEqual(objectIdentifier);
        expect(options.path.account_identifier).toEqual(accountIdentifier);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const objectIdentifier = 'testString';
        const accountIdentifier = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          objectIdentifier,
          accountIdentifier,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.createObjectAccess(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.createObjectAccess({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const createObjectAccessPromise = catalogManagementService.createObjectAccess();
        expectToBePromise(createObjectAccessPromise);

        createObjectAccessPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getObjectAccess', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getObjectAccess
        const catalogIdentifier = 'testString';
        const objectIdentifier = 'testString';
        const accountIdentifier = 'testString';
        const params = {
          catalogIdentifier,
          objectIdentifier,
          accountIdentifier,
        };

        const getObjectAccessResult = catalogManagementService.getObjectAccess(params);

        // all methods should return a Promise
        expectToBePromise(getObjectAccessResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(
          options,
          '/catalogs/{catalog_identifier}/objects/{object_identifier}/access/{account_identifier}',
          'GET'
        );
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
        expect(options.path.object_identifier).toEqual(objectIdentifier);
        expect(options.path.account_identifier).toEqual(accountIdentifier);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const objectIdentifier = 'testString';
        const accountIdentifier = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          objectIdentifier,
          accountIdentifier,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.getObjectAccess(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.getObjectAccess({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const getObjectAccessPromise = catalogManagementService.getObjectAccess();
        expectToBePromise(getObjectAccessPromise);

        getObjectAccessPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deleteObjectAccess', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteObjectAccess
        const catalogIdentifier = 'testString';
        const objectIdentifier = 'testString';
        const accountIdentifier = 'testString';
        const params = {
          catalogIdentifier,
          objectIdentifier,
          accountIdentifier,
        };

        const deleteObjectAccessResult = catalogManagementService.deleteObjectAccess(params);

        // all methods should return a Promise
        expectToBePromise(deleteObjectAccessResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(
          options,
          '/catalogs/{catalog_identifier}/objects/{object_identifier}/access/{account_identifier}',
          'DELETE'
        );
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
        expect(options.path.object_identifier).toEqual(objectIdentifier);
        expect(options.path.account_identifier).toEqual(accountIdentifier);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const objectIdentifier = 'testString';
        const accountIdentifier = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          objectIdentifier,
          accountIdentifier,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.deleteObjectAccess(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.deleteObjectAccess({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const deleteObjectAccessPromise = catalogManagementService.deleteObjectAccess();
        expectToBePromise(deleteObjectAccessPromise);

        deleteObjectAccessPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getObjectAccessList', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getObjectAccessList
        const catalogIdentifier = 'testString';
        const objectIdentifier = 'testString';
        const limit = 1000;
        const offset = 38;
        const params = {
          catalogIdentifier,
          objectIdentifier,
          limit,
          offset,
        };

        const getObjectAccessListResult = catalogManagementService.getObjectAccessList(params);

        // all methods should return a Promise
        expectToBePromise(getObjectAccessListResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(
          options,
          '/catalogs/{catalog_identifier}/objects/{object_identifier}/access',
          'GET'
        );
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs.limit).toEqual(limit);
        expect(options.qs.offset).toEqual(offset);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
        expect(options.path.object_identifier).toEqual(objectIdentifier);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const objectIdentifier = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          objectIdentifier,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.getObjectAccessList(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.getObjectAccessList({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const getObjectAccessListPromise = catalogManagementService.getObjectAccessList();
        expectToBePromise(getObjectAccessListPromise);

        getObjectAccessListPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deleteObjectAccessList', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteObjectAccessList
        const catalogIdentifier = 'testString';
        const objectIdentifier = 'testString';
        const accounts = ['testString'];
        const params = {
          catalogIdentifier,
          objectIdentifier,
          accounts,
        };

        const deleteObjectAccessListResult =
          catalogManagementService.deleteObjectAccessList(params);

        // all methods should return a Promise
        expectToBePromise(deleteObjectAccessListResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(
          options,
          '/catalogs/{catalog_identifier}/objects/{object_identifier}/access',
          'DELETE'
        );
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body).toEqual(accounts);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
        expect(options.path.object_identifier).toEqual(objectIdentifier);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const objectIdentifier = 'testString';
        const accounts = ['testString'];
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          objectIdentifier,
          accounts,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.deleteObjectAccessList(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.deleteObjectAccessList({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const deleteObjectAccessListPromise = catalogManagementService.deleteObjectAccessList();
        expectToBePromise(deleteObjectAccessListPromise);

        deleteObjectAccessListPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('addObjectAccessList', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation addObjectAccessList
        const catalogIdentifier = 'testString';
        const objectIdentifier = 'testString';
        const accounts = ['testString'];
        const params = {
          catalogIdentifier,
          objectIdentifier,
          accounts,
        };

        const addObjectAccessListResult = catalogManagementService.addObjectAccessList(params);

        // all methods should return a Promise
        expectToBePromise(addObjectAccessListResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(
          options,
          '/catalogs/{catalog_identifier}/objects/{object_identifier}/access',
          'POST'
        );
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body).toEqual(accounts);
        expect(options.path.catalog_identifier).toEqual(catalogIdentifier);
        expect(options.path.object_identifier).toEqual(objectIdentifier);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const objectIdentifier = 'testString';
        const accounts = ['testString'];
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          objectIdentifier,
          accounts,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.addObjectAccessList(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.addObjectAccessList({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const addObjectAccessListPromise = catalogManagementService.addObjectAccessList();
        expectToBePromise(addObjectAccessListPromise);

        addObjectAccessListPromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('createOfferingInstance', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // OfferingInstanceLastOperation
      const offeringInstanceLastOperationModel = {
        operation: 'testString',
        state: 'testString',
        message: 'testString',
        transaction_id: 'testString',
        updated: 'testString',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createOfferingInstance
        const xAuthRefreshToken = 'testString';
        const id = 'testString';
        const rev = 'testString';
        const url = 'testString';
        const crn = 'testString';
        const label = 'testString';
        const catalogId = 'testString';
        const offeringId = 'testString';
        const kindFormat = 'testString';
        const version = 'testString';
        const clusterId = 'testString';
        const clusterRegion = 'testString';
        const clusterNamespaces = ['testString'];
        const clusterAllNamespaces = true;
        const schematicsWorkspaceId = 'testString';
        const resourceGroupId = 'testString';
        const installPlan = 'testString';
        const channel = 'testString';
        const metadata = { 'key1': 'testString' };
        const lastOperation = offeringInstanceLastOperationModel;
        const params = {
          xAuthRefreshToken,
          id,
          rev,
          url,
          crn,
          label,
          catalogId,
          offeringId,
          kindFormat,
          version,
          clusterId,
          clusterRegion,
          clusterNamespaces,
          clusterAllNamespaces,
          schematicsWorkspaceId,
          resourceGroupId,
          installPlan,
          channel,
          metadata,
          lastOperation,
        };

        const createOfferingInstanceResult =
          catalogManagementService.createOfferingInstance(params);

        // all methods should return a Promise
        expectToBePromise(createOfferingInstanceResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/instances/offerings', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'X-Auth-Refresh-Token', xAuthRefreshToken);
        expect(options.body.id).toEqual(id);
        expect(options.body._rev).toEqual(rev);
        expect(options.body.url).toEqual(url);
        expect(options.body.crn).toEqual(crn);
        expect(options.body.label).toEqual(label);
        expect(options.body.catalog_id).toEqual(catalogId);
        expect(options.body.offering_id).toEqual(offeringId);
        expect(options.body.kind_format).toEqual(kindFormat);
        expect(options.body.version).toEqual(version);
        expect(options.body.cluster_id).toEqual(clusterId);
        expect(options.body.cluster_region).toEqual(clusterRegion);
        expect(options.body.cluster_namespaces).toEqual(clusterNamespaces);
        expect(options.body.cluster_all_namespaces).toEqual(clusterAllNamespaces);
        expect(options.body.schematics_workspace_id).toEqual(schematicsWorkspaceId);
        expect(options.body.resource_group_id).toEqual(resourceGroupId);
        expect(options.body.install_plan).toEqual(installPlan);
        expect(options.body.channel).toEqual(channel);
        expect(options.body.metadata).toEqual(metadata);
        expect(options.body.last_operation).toEqual(lastOperation);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const xAuthRefreshToken = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          xAuthRefreshToken,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.createOfferingInstance(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.createOfferingInstance({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const createOfferingInstancePromise = catalogManagementService.createOfferingInstance();
        expectToBePromise(createOfferingInstancePromise);

        createOfferingInstancePromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getOfferingInstance', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getOfferingInstance
        const instanceIdentifier = 'testString';
        const params = {
          instanceIdentifier,
        };

        const getOfferingInstanceResult = catalogManagementService.getOfferingInstance(params);

        // all methods should return a Promise
        expectToBePromise(getOfferingInstanceResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/instances/offerings/{instance_identifier}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path.instance_identifier).toEqual(instanceIdentifier);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const instanceIdentifier = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          instanceIdentifier,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.getOfferingInstance(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.getOfferingInstance({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const getOfferingInstancePromise = catalogManagementService.getOfferingInstance();
        expectToBePromise(getOfferingInstancePromise);

        getOfferingInstancePromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('putOfferingInstance', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // OfferingInstanceLastOperation
      const offeringInstanceLastOperationModel = {
        operation: 'testString',
        state: 'testString',
        message: 'testString',
        transaction_id: 'testString',
        updated: 'testString',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation putOfferingInstance
        const instanceIdentifier = 'testString';
        const xAuthRefreshToken = 'testString';
        const id = 'testString';
        const rev = 'testString';
        const url = 'testString';
        const crn = 'testString';
        const label = 'testString';
        const catalogId = 'testString';
        const offeringId = 'testString';
        const kindFormat = 'testString';
        const version = 'testString';
        const clusterId = 'testString';
        const clusterRegion = 'testString';
        const clusterNamespaces = ['testString'];
        const clusterAllNamespaces = true;
        const schematicsWorkspaceId = 'testString';
        const resourceGroupId = 'testString';
        const installPlan = 'testString';
        const channel = 'testString';
        const metadata = { 'key1': 'testString' };
        const lastOperation = offeringInstanceLastOperationModel;
        const params = {
          instanceIdentifier,
          xAuthRefreshToken,
          id,
          rev,
          url,
          crn,
          label,
          catalogId,
          offeringId,
          kindFormat,
          version,
          clusterId,
          clusterRegion,
          clusterNamespaces,
          clusterAllNamespaces,
          schematicsWorkspaceId,
          resourceGroupId,
          installPlan,
          channel,
          metadata,
          lastOperation,
        };

        const putOfferingInstanceResult = catalogManagementService.putOfferingInstance(params);

        // all methods should return a Promise
        expectToBePromise(putOfferingInstanceResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/instances/offerings/{instance_identifier}', 'PUT');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'X-Auth-Refresh-Token', xAuthRefreshToken);
        expect(options.body.id).toEqual(id);
        expect(options.body._rev).toEqual(rev);
        expect(options.body.url).toEqual(url);
        expect(options.body.crn).toEqual(crn);
        expect(options.body.label).toEqual(label);
        expect(options.body.catalog_id).toEqual(catalogId);
        expect(options.body.offering_id).toEqual(offeringId);
        expect(options.body.kind_format).toEqual(kindFormat);
        expect(options.body.version).toEqual(version);
        expect(options.body.cluster_id).toEqual(clusterId);
        expect(options.body.cluster_region).toEqual(clusterRegion);
        expect(options.body.cluster_namespaces).toEqual(clusterNamespaces);
        expect(options.body.cluster_all_namespaces).toEqual(clusterAllNamespaces);
        expect(options.body.schematics_workspace_id).toEqual(schematicsWorkspaceId);
        expect(options.body.resource_group_id).toEqual(resourceGroupId);
        expect(options.body.install_plan).toEqual(installPlan);
        expect(options.body.channel).toEqual(channel);
        expect(options.body.metadata).toEqual(metadata);
        expect(options.body.last_operation).toEqual(lastOperation);
        expect(options.path.instance_identifier).toEqual(instanceIdentifier);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const instanceIdentifier = 'testString';
        const xAuthRefreshToken = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          instanceIdentifier,
          xAuthRefreshToken,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.putOfferingInstance(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.putOfferingInstance({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const putOfferingInstancePromise = catalogManagementService.putOfferingInstance();
        expectToBePromise(putOfferingInstancePromise);

        putOfferingInstancePromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deleteOfferingInstance', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteOfferingInstance
        const instanceIdentifier = 'testString';
        const xAuthRefreshToken = 'testString';
        const params = {
          instanceIdentifier,
          xAuthRefreshToken,
        };

        const deleteOfferingInstanceResult =
          catalogManagementService.deleteOfferingInstance(params);

        // all methods should return a Promise
        expectToBePromise(deleteOfferingInstanceResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/instances/offerings/{instance_identifier}', 'DELETE');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'X-Auth-Refresh-Token', xAuthRefreshToken);
        expect(options.path.instance_identifier).toEqual(instanceIdentifier);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const instanceIdentifier = 'testString';
        const xAuthRefreshToken = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          instanceIdentifier,
          xAuthRefreshToken,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagementService.deleteOfferingInstance(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async (done) => {
        let err;
        try {
          await catalogManagementService.deleteOfferingInstance({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', (done) => {
        const deleteOfferingInstancePromise = catalogManagementService.deleteOfferingInstance();
        expectToBePromise(deleteOfferingInstancePromise);

        deleteOfferingInstancePromise.catch((err) => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
});
