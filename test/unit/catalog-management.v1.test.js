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
'use strict';

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

const service = {
  authenticator: new NoAuthAuthenticator(),
  url: 'https://cm.globalcatalog.cloud.ibm.com/api/v1-beta',
};

const catalogManagement = new CatalogManagementV1(service);

// dont actually create a request
const createRequestMock = jest.spyOn(catalogManagement, 'createRequest');
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

        const getCatalogAccountResult = catalogManagement.getCatalogAccount(params);

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

        catalogManagement.getCatalogAccount(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        catalogManagement.getCatalogAccount({});
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
        category_filters: { 'key1' : categoryFilterModel },
        id_filters: idFilterModel,
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation updateCatalogAccount
        const id = 'testString';
        const accountFilters = filtersModel;
        const params = {
          id: id,
          accountFilters: accountFilters,
        };

        const updateCatalogAccountResult = catalogManagement.updateCatalogAccount(params);

        // all methods should return a Promise
        expectToBePromise(updateCatalogAccountResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogaccount', 'PUT');
        const expectedAccept = undefined;
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['id']).toEqual(id);
        expect(options.body['account_filters']).toEqual(accountFilters);
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

        catalogManagement.updateCatalogAccount(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        catalogManagement.updateCatalogAccount({});
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
          catalog: catalog,
        };

        const getCatalogAccountFiltersResult = catalogManagement.getCatalogAccountFilters(params);

        // all methods should return a Promise
        expectToBePromise(getCatalogAccountFiltersResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogaccount/filters', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['catalog']).toEqual(catalog);
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

        catalogManagement.getCatalogAccountFilters(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        catalogManagement.getCatalogAccountFilters({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('listCatalogs', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listCatalogs
        const params = {};

        const listCatalogsResult = catalogManagement.listCatalogs(params);

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

        catalogManagement.listCatalogs(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        catalogManagement.listCatalogs({});
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
        category_filters: { 'key1' : categoryFilterModel },
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

      // SyndicationAuthorization
      const syndicationAuthorizationModel = {
        token: 'testString',
        last_run: '2019-01-01T12:00:00',
      };

      // SyndicationHistory
      const syndicationHistoryModel = {
        namespaces: ['testString'],
        clusters: [syndicationClusterModel],
        last_run: '2019-01-01T12:00:00',
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
        const url = 'testString';
        const crn = 'testString';
        const offeringsUrl = 'testString';
        const features = [featureModel];
        const disabled = true;
        const created = '2019-01-01T12:00:00';
        const updated = '2019-01-01T12:00:00';
        const resourceGroupId = 'testString';
        const owningAccount = 'testString';
        const catalogFilters = filtersModel;
        const syndicationSettings = syndicationResourceModel;
        const params = {
          id: id,
          rev: rev,
          label: label,
          shortDescription: shortDescription,
          catalogIconUrl: catalogIconUrl,
          tags: tags,
          url: url,
          crn: crn,
          offeringsUrl: offeringsUrl,
          features: features,
          disabled: disabled,
          created: created,
          updated: updated,
          resourceGroupId: resourceGroupId,
          owningAccount: owningAccount,
          catalogFilters: catalogFilters,
          syndicationSettings: syndicationSettings,
        };

        const createCatalogResult = catalogManagement.createCatalog(params);

        // all methods should return a Promise
        expectToBePromise(createCatalogResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogs', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['id']).toEqual(id);
        expect(options.body['_rev']).toEqual(rev);
        expect(options.body['label']).toEqual(label);
        expect(options.body['short_description']).toEqual(shortDescription);
        expect(options.body['catalog_icon_url']).toEqual(catalogIconUrl);
        expect(options.body['tags']).toEqual(tags);
        expect(options.body['url']).toEqual(url);
        expect(options.body['crn']).toEqual(crn);
        expect(options.body['offerings_url']).toEqual(offeringsUrl);
        expect(options.body['features']).toEqual(features);
        expect(options.body['disabled']).toEqual(disabled);
        expect(options.body['created']).toEqual(created);
        expect(options.body['updated']).toEqual(updated);
        expect(options.body['resource_group_id']).toEqual(resourceGroupId);
        expect(options.body['owning_account']).toEqual(owningAccount);
        expect(options.body['catalog_filters']).toEqual(catalogFilters);
        expect(options.body['syndication_settings']).toEqual(syndicationSettings);
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

        catalogManagement.createCatalog(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        catalogManagement.createCatalog({});
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
          catalogIdentifier: catalogIdentifier,
        };

        const getCatalogResult = catalogManagement.getCatalog(params);

        // all methods should return a Promise
        expectToBePromise(getCatalogResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogs/{catalog_identifier}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['catalog_identifier']).toEqual(catalogIdentifier);
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

        catalogManagement.getCatalog(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.getCatalog({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getCatalogPromise = catalogManagement.getCatalog();
        expectToBePromise(getCatalogPromise);

        getCatalogPromise.catch(err => {
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
        category_filters: { 'key1' : categoryFilterModel },
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

      // SyndicationAuthorization
      const syndicationAuthorizationModel = {
        token: 'testString',
        last_run: '2019-01-01T12:00:00',
      };

      // SyndicationHistory
      const syndicationHistoryModel = {
        namespaces: ['testString'],
        clusters: [syndicationClusterModel],
        last_run: '2019-01-01T12:00:00',
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
        const url = 'testString';
        const crn = 'testString';
        const offeringsUrl = 'testString';
        const features = [featureModel];
        const disabled = true;
        const created = '2019-01-01T12:00:00';
        const updated = '2019-01-01T12:00:00';
        const resourceGroupId = 'testString';
        const owningAccount = 'testString';
        const catalogFilters = filtersModel;
        const syndicationSettings = syndicationResourceModel;
        const params = {
          catalogIdentifier: catalogIdentifier,
          id: id,
          rev: rev,
          label: label,
          shortDescription: shortDescription,
          catalogIconUrl: catalogIconUrl,
          tags: tags,
          url: url,
          crn: crn,
          offeringsUrl: offeringsUrl,
          features: features,
          disabled: disabled,
          created: created,
          updated: updated,
          resourceGroupId: resourceGroupId,
          owningAccount: owningAccount,
          catalogFilters: catalogFilters,
          syndicationSettings: syndicationSettings,
        };

        const replaceCatalogResult = catalogManagement.replaceCatalog(params);

        // all methods should return a Promise
        expectToBePromise(replaceCatalogResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogs/{catalog_identifier}', 'PUT');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['id']).toEqual(id);
        expect(options.body['_rev']).toEqual(rev);
        expect(options.body['label']).toEqual(label);
        expect(options.body['short_description']).toEqual(shortDescription);
        expect(options.body['catalog_icon_url']).toEqual(catalogIconUrl);
        expect(options.body['tags']).toEqual(tags);
        expect(options.body['url']).toEqual(url);
        expect(options.body['crn']).toEqual(crn);
        expect(options.body['offerings_url']).toEqual(offeringsUrl);
        expect(options.body['features']).toEqual(features);
        expect(options.body['disabled']).toEqual(disabled);
        expect(options.body['created']).toEqual(created);
        expect(options.body['updated']).toEqual(updated);
        expect(options.body['resource_group_id']).toEqual(resourceGroupId);
        expect(options.body['owning_account']).toEqual(owningAccount);
        expect(options.body['catalog_filters']).toEqual(catalogFilters);
        expect(options.body['syndication_settings']).toEqual(syndicationSettings);
        expect(options.path['catalog_identifier']).toEqual(catalogIdentifier);
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

        catalogManagement.replaceCatalog(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.replaceCatalog({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const replaceCatalogPromise = catalogManagement.replaceCatalog();
        expectToBePromise(replaceCatalogPromise);

        replaceCatalogPromise.catch(err => {
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
          catalogIdentifier: catalogIdentifier,
        };

        const deleteCatalogResult = catalogManagement.deleteCatalog(params);

        // all methods should return a Promise
        expectToBePromise(deleteCatalogResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogs/{catalog_identifier}', 'DELETE');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['catalog_identifier']).toEqual(catalogIdentifier);
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

        catalogManagement.deleteCatalog(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.deleteCatalog({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const deleteCatalogPromise = catalogManagement.deleteCatalog();
        expectToBePromise(deleteCatalogPromise);

        deleteCatalogPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getEnterprise', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getEnterprise
        const enterpriseId = 'testString';
        const params = {
          enterpriseId: enterpriseId,
        };

        const getEnterpriseResult = catalogManagement.getEnterprise(params);

        // all methods should return a Promise
        expectToBePromise(getEnterpriseResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/enterprises/{enterprise_id}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['enterprise_id']).toEqual(enterpriseId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const enterpriseId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          enterpriseId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagement.getEnterprise(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.getEnterprise({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getEnterprisePromise = catalogManagement.getEnterprise();
        expectToBePromise(getEnterprisePromise);

        getEnterprisePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('replaceEnterprise', () => {
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
        category_filters: { 'key1' : categoryFilterModel },
        id_filters: idFilterModel,
      };

      // AccountGroup
      const accountGroupModel = {
        id: 'testString',
        account_filters: filtersModel,
      };

      // EnterpriseAccountGroups
      const enterpriseAccountGroupsModel = {
        keys: accountGroupModel,
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation replaceEnterprise
        const enterpriseId = 'testString';
        const id = 'testString';
        const rev = 'testString';
        const accountFilters = filtersModel;
        const accountGroups = enterpriseAccountGroupsModel;
        const params = {
          enterpriseId: enterpriseId,
          id: id,
          rev: rev,
          accountFilters: accountFilters,
          accountGroups: accountGroups,
        };

        const replaceEnterpriseResult = catalogManagement.replaceEnterprise(params);

        // all methods should return a Promise
        expectToBePromise(replaceEnterpriseResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/enterprises/{enterprise_id}', 'PUT');
        const expectedAccept = undefined;
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['id']).toEqual(id);
        expect(options.body['_rev']).toEqual(rev);
        expect(options.body['account_filters']).toEqual(accountFilters);
        expect(options.body['account_groups']).toEqual(accountGroups);
        expect(options.path['enterprise_id']).toEqual(enterpriseId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const enterpriseId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          enterpriseId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagement.replaceEnterprise(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.replaceEnterprise({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const replaceEnterprisePromise = catalogManagement.replaceEnterprise();
        expectToBePromise(replaceEnterprisePromise);

        replaceEnterprisePromise.catch(err => {
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
        const params = {
          digest: digest,
          catalog: catalog,
          select: select,
          includeHidden: includeHidden,
        };

        const getConsumptionOfferingsResult = catalogManagement.getConsumptionOfferings(params);

        // all methods should return a Promise
        expectToBePromise(getConsumptionOfferingsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/offerings', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['digest']).toEqual(digest);
        expect(options.qs['catalog']).toEqual(catalog);
        expect(options.qs['select']).toEqual(select);
        expect(options.qs['includeHidden']).toEqual(includeHidden);
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

        catalogManagement.getConsumptionOfferings(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        catalogManagement.getConsumptionOfferings({});
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
        const params = {
          catalogIdentifier: catalogIdentifier,
          digest: digest,
        };

        const listOfferingsResult = catalogManagement.listOfferings(params);

        // all methods should return a Promise
        expectToBePromise(listOfferingsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogs/{catalog_identifier}/offerings', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['digest']).toEqual(digest);
        expect(options.path['catalog_identifier']).toEqual(catalogIdentifier);
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

        catalogManagement.listOfferings(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.listOfferings({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const listOfferingsPromise = catalogManagement.listOfferings();
        expectToBePromise(listOfferingsPromise);

        listOfferingsPromise.catch(err => {
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
        default_value: 'any',
        value_constraint: 'testString',
        description: 'testString',
        required: true,
        options: [{ foo: 'bar' }],
        hidden: true,
      };

      // Deployment
      const deploymentModel = {
        id: 'testString',
        label: 'testString',
        name: 'testString',
        short_description: 'testString',
        long_description: 'testString',
        metadata: { foo: 'bar' },
        tags: ['testString'],
        created: '2019-01-01T12:00:00',
        updated: '2019-01-01T12:00:00',
      };

      // License
      const licenseModel = {
        id: 'testString',
        name: 'testString',
        type: 'testString',
        url: 'testString',
        description: 'testString',
      };

      // Resource
      const resourceModel = {
        type: 'mem',
        value: 'any',
      };

      // Script
      const scriptModel = {
        instructions: 'testString',
        script: 'testString',
        script_permission: 'testString',
        delete_script: 'testString',
        scope: 'testString',
      };

      // State
      const stateModel = {
        current: 'testString',
        current_entered: '2019-01-01T12:00:00',
        pending: 'testString',
        pending_requested: '2019-01-01T12:00:00',
        previous: 'testString',
      };

      // Validation
      const validationModel = {
        validated: '2019-01-01T12:00:00',
        requested: '2019-01-01T12:00:00',
        state: 'testString',
        last_operation: 'testString',
        target: { foo: 'bar' },
      };

      // VersionEntitlement
      const versionEntitlementModel = {
        provider_name: 'testString',
        provider_id: 'testString',
        product_id: 'testString',
        part_numbers: ['testString'],
        image_repo_name: 'testString',
      };

      // Plan
      const planModel = {
        id: 'testString',
        label: 'testString',
        name: 'testString',
        short_description: 'testString',
        long_description: 'testString',
        metadata: { foo: 'bar' },
        tags: ['testString'],
        additional_features: [featureModel],
        created: '2019-01-01T12:00:00',
        updated: '2019-01-01T12:00:00',
        deployments: [deploymentModel],
      };

      // Version
      const versionModel = {
        id: 'testString',
        _rev: 'testString',
        crn: 'testString',
        version: 'testString',
        sha: 'testString',
        created: '2019-01-01T12:00:00',
        updated: '2019-01-01T12:00:00',
        offering_id: 'testString',
        catalog_id: 'testString',
        kind_id: 'testString',
        tags: ['testString'],
        repo_url: 'testString',
        source_url: 'testString',
        tgz_url: 'testString',
        configuration: [configurationModel],
        metadata: { foo: 'bar' },
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

      // Kind
      const kindModel = {
        id: 'testString',
        format_kind: 'testString',
        target_kind: 'testString',
        metadata: { foo: 'bar' },
        install_description: 'testString',
        tags: ['testString'],
        additional_features: [featureModel],
        created: '2019-01-01T12:00:00',
        updated: '2019-01-01T12:00:00',
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
        const rating = ratingModel;
        const created = '2019-01-01T12:00:00';
        const updated = '2019-01-01T12:00:00';
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
        const metadata = { foo: 'bar' };
        const disclaimer = 'testString';
        const hidden = true;
        const provider = 'testString';
        const repoInfo = repoInfoModel;
        const params = {
          catalogIdentifier: catalogIdentifier,
          id: id,
          rev: rev,
          url: url,
          crn: crn,
          label: label,
          name: name,
          offeringIconUrl: offeringIconUrl,
          offeringDocsUrl: offeringDocsUrl,
          offeringSupportUrl: offeringSupportUrl,
          tags: tags,
          rating: rating,
          created: created,
          updated: updated,
          shortDescription: shortDescription,
          longDescription: longDescription,
          features: features,
          kinds: kinds,
          permitRequestIbmPublicPublish: permitRequestIbmPublicPublish,
          ibmPublishApproved: ibmPublishApproved,
          publicPublishApproved: publicPublishApproved,
          publicOriginalCrn: publicOriginalCrn,
          publishPublicCrn: publishPublicCrn,
          portalApprovalRecord: portalApprovalRecord,
          portalUiUrl: portalUiUrl,
          catalogId: catalogId,
          catalogName: catalogName,
          metadata: metadata,
          disclaimer: disclaimer,
          hidden: hidden,
          provider: provider,
          repoInfo: repoInfo,
        };

        const createOfferingResult = catalogManagement.createOffering(params);

        // all methods should return a Promise
        expectToBePromise(createOfferingResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogs/{catalog_identifier}/offerings', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['id']).toEqual(id);
        expect(options.body['_rev']).toEqual(rev);
        expect(options.body['url']).toEqual(url);
        expect(options.body['crn']).toEqual(crn);
        expect(options.body['label']).toEqual(label);
        expect(options.body['name']).toEqual(name);
        expect(options.body['offering_icon_url']).toEqual(offeringIconUrl);
        expect(options.body['offering_docs_url']).toEqual(offeringDocsUrl);
        expect(options.body['offering_support_url']).toEqual(offeringSupportUrl);
        expect(options.body['tags']).toEqual(tags);
        expect(options.body['rating']).toEqual(rating);
        expect(options.body['created']).toEqual(created);
        expect(options.body['updated']).toEqual(updated);
        expect(options.body['short_description']).toEqual(shortDescription);
        expect(options.body['long_description']).toEqual(longDescription);
        expect(options.body['features']).toEqual(features);
        expect(options.body['kinds']).toEqual(kinds);
        expect(options.body['permit_request_ibm_public_publish']).toEqual(permitRequestIbmPublicPublish);
        expect(options.body['ibm_publish_approved']).toEqual(ibmPublishApproved);
        expect(options.body['public_publish_approved']).toEqual(publicPublishApproved);
        expect(options.body['public_original_crn']).toEqual(publicOriginalCrn);
        expect(options.body['publish_public_crn']).toEqual(publishPublicCrn);
        expect(options.body['portal_approval_record']).toEqual(portalApprovalRecord);
        expect(options.body['portal_ui_url']).toEqual(portalUiUrl);
        expect(options.body['catalog_id']).toEqual(catalogId);
        expect(options.body['catalog_name']).toEqual(catalogName);
        expect(options.body['metadata']).toEqual(metadata);
        expect(options.body['disclaimer']).toEqual(disclaimer);
        expect(options.body['hidden']).toEqual(hidden);
        expect(options.body['provider']).toEqual(provider);
        expect(options.body['repo_info']).toEqual(repoInfo);
        expect(options.path['catalog_identifier']).toEqual(catalogIdentifier);
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

        catalogManagement.createOffering(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.createOffering({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const createOfferingPromise = catalogManagement.createOffering();
        expectToBePromise(createOfferingPromise);

        createOfferingPromise.catch(err => {
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
        const zipurl = 'testString';
        const tags = ['testString'];
        const targetKinds = ['testString'];
        const targetVersion = 'testString';
        const includeConfig = true;
        const repoType = 'testString';
        const xAuthToken = 'testString';
        const params = {
          catalogIdentifier: catalogIdentifier,
          offeringId: offeringId,
          zipurl: zipurl,
          tags: tags,
          targetKinds: targetKinds,
          targetVersion: targetVersion,
          includeConfig: includeConfig,
          repoType: repoType,
          xAuthToken: xAuthToken,
        };

        const importOfferingVersionResult = catalogManagement.importOfferingVersion(params);

        // all methods should return a Promise
        expectToBePromise(importOfferingVersionResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogs/{catalog_identifier}/offerings/{offering_id}/version', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'X-Auth-Token', xAuthToken);
        expect(options.body['tags']).toEqual(tags);
        expect(options.body['target_kinds']).toEqual(targetKinds);
        expect(options.qs['zipurl']).toEqual(zipurl);
        expect(options.qs['targetVersion']).toEqual(targetVersion);
        expect(options.qs['includeConfig']).toEqual(includeConfig);
        expect(options.qs['repoType']).toEqual(repoType);
        expect(options.path['catalog_identifier']).toEqual(catalogIdentifier);
        expect(options.path['offering_id']).toEqual(offeringId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const offeringId = 'testString';
        const zipurl = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          offeringId,
          zipurl,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagement.importOfferingVersion(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.importOfferingVersion({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const importOfferingVersionPromise = catalogManagement.importOfferingVersion();
        expectToBePromise(importOfferingVersionPromise);

        importOfferingVersionPromise.catch(err => {
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
        const zipurl = 'testString';
        const tags = ['testString'];
        const targetKinds = ['testString'];
        const offeringId = 'testString';
        const includeConfig = true;
        const repoType = 'testString';
        const xAuthToken = 'testString';
        const params = {
          catalogIdentifier: catalogIdentifier,
          zipurl: zipurl,
          tags: tags,
          targetKinds: targetKinds,
          offeringId: offeringId,
          includeConfig: includeConfig,
          repoType: repoType,
          xAuthToken: xAuthToken,
        };

        const importOfferingResult = catalogManagement.importOffering(params);

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
        expect(options.body['tags']).toEqual(tags);
        expect(options.body['target_kinds']).toEqual(targetKinds);
        expect(options.qs['zipurl']).toEqual(zipurl);
        expect(options.qs['offeringID']).toEqual(offeringId);
        expect(options.qs['includeConfig']).toEqual(includeConfig);
        expect(options.qs['repoType']).toEqual(repoType);
        expect(options.path['catalog_identifier']).toEqual(catalogIdentifier);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const zipurl = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          zipurl,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagement.importOffering(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.importOffering({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const importOfferingPromise = catalogManagement.importOffering();
        expectToBePromise(importOfferingPromise);

        importOfferingPromise.catch(err => {
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
        const zipurl = 'testString';
        const targetVersion = 'testString';
        const tags = ['testString'];
        const targetKinds = ['testString'];
        const repoType = 'testString';
        const xAuthToken = 'testString';
        const params = {
          catalogIdentifier: catalogIdentifier,
          offeringId: offeringId,
          zipurl: zipurl,
          targetVersion: targetVersion,
          tags: tags,
          targetKinds: targetKinds,
          repoType: repoType,
          xAuthToken: xAuthToken,
        };

        const reloadOfferingResult = catalogManagement.reloadOffering(params);

        // all methods should return a Promise
        expectToBePromise(reloadOfferingResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogs/{catalog_identifier}/offerings/{offering_id}/reload', 'PUT');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'X-Auth-Token', xAuthToken);
        expect(options.body['tags']).toEqual(tags);
        expect(options.body['target_kinds']).toEqual(targetKinds);
        expect(options.qs['zipurl']).toEqual(zipurl);
        expect(options.qs['targetVersion']).toEqual(targetVersion);
        expect(options.qs['repoType']).toEqual(repoType);
        expect(options.path['catalog_identifier']).toEqual(catalogIdentifier);
        expect(options.path['offering_id']).toEqual(offeringId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const offeringId = 'testString';
        const zipurl = 'testString';
        const targetVersion = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          catalogIdentifier,
          offeringId,
          zipurl,
          targetVersion,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagement.reloadOffering(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.reloadOffering({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const reloadOfferingPromise = catalogManagement.reloadOffering();
        expectToBePromise(reloadOfferingPromise);

        reloadOfferingPromise.catch(err => {
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
          catalogIdentifier: catalogIdentifier,
          offeringId: offeringId,
        };

        const getOfferingResult = catalogManagement.getOffering(params);

        // all methods should return a Promise
        expectToBePromise(getOfferingResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogs/{catalog_identifier}/offerings/{offering_id}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['catalog_identifier']).toEqual(catalogIdentifier);
        expect(options.path['offering_id']).toEqual(offeringId);
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

        catalogManagement.getOffering(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.getOffering({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getOfferingPromise = catalogManagement.getOffering();
        expectToBePromise(getOfferingPromise);

        getOfferingPromise.catch(err => {
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
        default_value: 'any',
        value_constraint: 'testString',
        description: 'testString',
        required: true,
        options: [{ foo: 'bar' }],
        hidden: true,
      };

      // Deployment
      const deploymentModel = {
        id: 'testString',
        label: 'testString',
        name: 'testString',
        short_description: 'testString',
        long_description: 'testString',
        metadata: { foo: 'bar' },
        tags: ['testString'],
        created: '2019-01-01T12:00:00',
        updated: '2019-01-01T12:00:00',
      };

      // License
      const licenseModel = {
        id: 'testString',
        name: 'testString',
        type: 'testString',
        url: 'testString',
        description: 'testString',
      };

      // Resource
      const resourceModel = {
        type: 'mem',
        value: 'any',
      };

      // Script
      const scriptModel = {
        instructions: 'testString',
        script: 'testString',
        script_permission: 'testString',
        delete_script: 'testString',
        scope: 'testString',
      };

      // State
      const stateModel = {
        current: 'testString',
        current_entered: '2019-01-01T12:00:00',
        pending: 'testString',
        pending_requested: '2019-01-01T12:00:00',
        previous: 'testString',
      };

      // Validation
      const validationModel = {
        validated: '2019-01-01T12:00:00',
        requested: '2019-01-01T12:00:00',
        state: 'testString',
        last_operation: 'testString',
        target: { foo: 'bar' },
      };

      // VersionEntitlement
      const versionEntitlementModel = {
        provider_name: 'testString',
        provider_id: 'testString',
        product_id: 'testString',
        part_numbers: ['testString'],
        image_repo_name: 'testString',
      };

      // Plan
      const planModel = {
        id: 'testString',
        label: 'testString',
        name: 'testString',
        short_description: 'testString',
        long_description: 'testString',
        metadata: { foo: 'bar' },
        tags: ['testString'],
        additional_features: [featureModel],
        created: '2019-01-01T12:00:00',
        updated: '2019-01-01T12:00:00',
        deployments: [deploymentModel],
      };

      // Version
      const versionModel = {
        id: 'testString',
        _rev: 'testString',
        crn: 'testString',
        version: 'testString',
        sha: 'testString',
        created: '2019-01-01T12:00:00',
        updated: '2019-01-01T12:00:00',
        offering_id: 'testString',
        catalog_id: 'testString',
        kind_id: 'testString',
        tags: ['testString'],
        repo_url: 'testString',
        source_url: 'testString',
        tgz_url: 'testString',
        configuration: [configurationModel],
        metadata: { foo: 'bar' },
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

      // Kind
      const kindModel = {
        id: 'testString',
        format_kind: 'testString',
        target_kind: 'testString',
        metadata: { foo: 'bar' },
        install_description: 'testString',
        tags: ['testString'],
        additional_features: [featureModel],
        created: '2019-01-01T12:00:00',
        updated: '2019-01-01T12:00:00',
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
        const rating = ratingModel;
        const created = '2019-01-01T12:00:00';
        const updated = '2019-01-01T12:00:00';
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
        const metadata = { foo: 'bar' };
        const disclaimer = 'testString';
        const hidden = true;
        const provider = 'testString';
        const repoInfo = repoInfoModel;
        const params = {
          catalogIdentifier: catalogIdentifier,
          offeringId: offeringId,
          id: id,
          rev: rev,
          url: url,
          crn: crn,
          label: label,
          name: name,
          offeringIconUrl: offeringIconUrl,
          offeringDocsUrl: offeringDocsUrl,
          offeringSupportUrl: offeringSupportUrl,
          tags: tags,
          rating: rating,
          created: created,
          updated: updated,
          shortDescription: shortDescription,
          longDescription: longDescription,
          features: features,
          kinds: kinds,
          permitRequestIbmPublicPublish: permitRequestIbmPublicPublish,
          ibmPublishApproved: ibmPublishApproved,
          publicPublishApproved: publicPublishApproved,
          publicOriginalCrn: publicOriginalCrn,
          publishPublicCrn: publishPublicCrn,
          portalApprovalRecord: portalApprovalRecord,
          portalUiUrl: portalUiUrl,
          catalogId: catalogId,
          catalogName: catalogName,
          metadata: metadata,
          disclaimer: disclaimer,
          hidden: hidden,
          provider: provider,
          repoInfo: repoInfo,
        };

        const replaceOfferingResult = catalogManagement.replaceOffering(params);

        // all methods should return a Promise
        expectToBePromise(replaceOfferingResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogs/{catalog_identifier}/offerings/{offering_id}', 'PUT');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['id']).toEqual(id);
        expect(options.body['_rev']).toEqual(rev);
        expect(options.body['url']).toEqual(url);
        expect(options.body['crn']).toEqual(crn);
        expect(options.body['label']).toEqual(label);
        expect(options.body['name']).toEqual(name);
        expect(options.body['offering_icon_url']).toEqual(offeringIconUrl);
        expect(options.body['offering_docs_url']).toEqual(offeringDocsUrl);
        expect(options.body['offering_support_url']).toEqual(offeringSupportUrl);
        expect(options.body['tags']).toEqual(tags);
        expect(options.body['rating']).toEqual(rating);
        expect(options.body['created']).toEqual(created);
        expect(options.body['updated']).toEqual(updated);
        expect(options.body['short_description']).toEqual(shortDescription);
        expect(options.body['long_description']).toEqual(longDescription);
        expect(options.body['features']).toEqual(features);
        expect(options.body['kinds']).toEqual(kinds);
        expect(options.body['permit_request_ibm_public_publish']).toEqual(permitRequestIbmPublicPublish);
        expect(options.body['ibm_publish_approved']).toEqual(ibmPublishApproved);
        expect(options.body['public_publish_approved']).toEqual(publicPublishApproved);
        expect(options.body['public_original_crn']).toEqual(publicOriginalCrn);
        expect(options.body['publish_public_crn']).toEqual(publishPublicCrn);
        expect(options.body['portal_approval_record']).toEqual(portalApprovalRecord);
        expect(options.body['portal_ui_url']).toEqual(portalUiUrl);
        expect(options.body['catalog_id']).toEqual(catalogId);
        expect(options.body['catalog_name']).toEqual(catalogName);
        expect(options.body['metadata']).toEqual(metadata);
        expect(options.body['disclaimer']).toEqual(disclaimer);
        expect(options.body['hidden']).toEqual(hidden);
        expect(options.body['provider']).toEqual(provider);
        expect(options.body['repo_info']).toEqual(repoInfo);
        expect(options.path['catalog_identifier']).toEqual(catalogIdentifier);
        expect(options.path['offering_id']).toEqual(offeringId);
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

        catalogManagement.replaceOffering(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.replaceOffering({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const replaceOfferingPromise = catalogManagement.replaceOffering();
        expectToBePromise(replaceOfferingPromise);

        replaceOfferingPromise.catch(err => {
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
          catalogIdentifier: catalogIdentifier,
          offeringId: offeringId,
        };

        const deleteOfferingResult = catalogManagement.deleteOffering(params);

        // all methods should return a Promise
        expectToBePromise(deleteOfferingResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogs/{catalog_identifier}/offerings/{offering_id}', 'DELETE');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['catalog_identifier']).toEqual(catalogIdentifier);
        expect(options.path['offering_id']).toEqual(offeringId);
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

        catalogManagement.deleteOffering(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.deleteOffering({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const deleteOfferingPromise = catalogManagement.deleteOffering();
        expectToBePromise(deleteOfferingPromise);

        deleteOfferingPromise.catch(err => {
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
          catalogIdentifier: catalogIdentifier,
          offeringId: offeringId,
          fileName: fileName,
        };

        const replaceOfferingIconResult = catalogManagement.replaceOfferingIcon(params);

        // all methods should return a Promise
        expectToBePromise(replaceOfferingIconResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogs/{catalog_identifier}/offerings/{offering_id}/icon/{file_name}', 'PUT');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['catalog_identifier']).toEqual(catalogIdentifier);
        expect(options.path['offering_id']).toEqual(offeringId);
        expect(options.path['file_name']).toEqual(fileName);
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

        catalogManagement.replaceOfferingIcon(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.replaceOfferingIcon({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const replaceOfferingIconPromise = catalogManagement.replaceOfferingIcon();
        expectToBePromise(replaceOfferingIconPromise);

        replaceOfferingIconPromise.catch(err => {
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
        const approvalType = 'ibm';
        const approved = 'true';
        const params = {
          catalogIdentifier: catalogIdentifier,
          offeringId: offeringId,
          approvalType: approvalType,
          approved: approved,
        };

        const updateOfferingIbmResult = catalogManagement.updateOfferingIbm(params);

        // all methods should return a Promise
        expectToBePromise(updateOfferingIbmResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/catalogs/{catalog_identifier}/offerings/{offering_id}/publish/{approval_type}/{approved}', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['catalog_identifier']).toEqual(catalogIdentifier);
        expect(options.path['offering_id']).toEqual(offeringId);
        expect(options.path['approval_type']).toEqual(approvalType);
        expect(options.path['approved']).toEqual(approved);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const catalogIdentifier = 'testString';
        const offeringId = 'testString';
        const approvalType = 'ibm';
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

        catalogManagement.updateOfferingIbm(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.updateOfferingIbm({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const updateOfferingIbmPromise = catalogManagement.updateOfferingIbm();
        expectToBePromise(updateOfferingIbmPromise);

        updateOfferingIbmPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getVersionAbout', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getVersionAbout
        const versionLocId = 'testString';
        const params = {
          versionLocId: versionLocId,
        };

        const getVersionAboutResult = catalogManagement.getVersionAbout(params);

        // all methods should return a Promise
        expectToBePromise(getVersionAboutResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/about', 'GET');
        const expectedAccept = 'text/markdown';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['version_loc_id']).toEqual(versionLocId);
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

        catalogManagement.getVersionAbout(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.getVersionAbout({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getVersionAboutPromise = catalogManagement.getVersionAbout();
        expectToBePromise(getVersionAboutPromise);

        getVersionAboutPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getVersionLicense', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getVersionLicense
        const versionLocId = 'testString';
        const licenseId = 'testString';
        const params = {
          versionLocId: versionLocId,
          licenseId: licenseId,
        };

        const getVersionLicenseResult = catalogManagement.getVersionLicense(params);

        // all methods should return a Promise
        expectToBePromise(getVersionLicenseResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/licenses/{license_id}', 'GET');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['version_loc_id']).toEqual(versionLocId);
        expect(options.path['license_id']).toEqual(licenseId);
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

        catalogManagement.getVersionLicense(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.getVersionLicense({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getVersionLicensePromise = catalogManagement.getVersionLicense();
        expectToBePromise(getVersionLicensePromise);

        getVersionLicensePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getVersionContainerImages', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getVersionContainerImages
        const versionLocId = 'testString';
        const params = {
          versionLocId: versionLocId,
        };

        const getVersionContainerImagesResult = catalogManagement.getVersionContainerImages(params);

        // all methods should return a Promise
        expectToBePromise(getVersionContainerImagesResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/containerImages', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['version_loc_id']).toEqual(versionLocId);
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

        catalogManagement.getVersionContainerImages(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.getVersionContainerImages({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getVersionContainerImagesPromise = catalogManagement.getVersionContainerImages();
        expectToBePromise(getVersionContainerImagesPromise);

        getVersionContainerImagesPromise.catch(err => {
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
          versionLocId: versionLocId,
        };

        const deprecateVersionResult = catalogManagement.deprecateVersion(params);

        // all methods should return a Promise
        expectToBePromise(deprecateVersionResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/deprecate', 'POST');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['version_loc_id']).toEqual(versionLocId);
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

        catalogManagement.deprecateVersion(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.deprecateVersion({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const deprecateVersionPromise = catalogManagement.deprecateVersion();
        expectToBePromise(deprecateVersionPromise);

        deprecateVersionPromise.catch(err => {
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
          versionLocId: versionLocId,
        };

        const accountPublishVersionResult = catalogManagement.accountPublishVersion(params);

        // all methods should return a Promise
        expectToBePromise(accountPublishVersionResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/account-publish', 'POST');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['version_loc_id']).toEqual(versionLocId);
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

        catalogManagement.accountPublishVersion(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.accountPublishVersion({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const accountPublishVersionPromise = catalogManagement.accountPublishVersion();
        expectToBePromise(accountPublishVersionPromise);

        accountPublishVersionPromise.catch(err => {
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
          versionLocId: versionLocId,
        };

        const ibmPublishVersionResult = catalogManagement.ibmPublishVersion(params);

        // all methods should return a Promise
        expectToBePromise(ibmPublishVersionResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/ibm-publish', 'POST');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['version_loc_id']).toEqual(versionLocId);
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

        catalogManagement.ibmPublishVersion(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.ibmPublishVersion({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const ibmPublishVersionPromise = catalogManagement.ibmPublishVersion();
        expectToBePromise(ibmPublishVersionPromise);

        ibmPublishVersionPromise.catch(err => {
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
          versionLocId: versionLocId,
        };

        const publicPublishVersionResult = catalogManagement.publicPublishVersion(params);

        // all methods should return a Promise
        expectToBePromise(publicPublishVersionResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/public-publish', 'POST');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['version_loc_id']).toEqual(versionLocId);
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

        catalogManagement.publicPublishVersion(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.publicPublishVersion({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const publicPublishVersionPromise = catalogManagement.publicPublishVersion();
        expectToBePromise(publicPublishVersionPromise);

        publicPublishVersionPromise.catch(err => {
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
          versionLocId: versionLocId,
        };

        const commitVersionResult = catalogManagement.commitVersion(params);

        // all methods should return a Promise
        expectToBePromise(commitVersionResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/commit', 'POST');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['version_loc_id']).toEqual(versionLocId);
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

        catalogManagement.commitVersion(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.commitVersion({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const commitVersionPromise = catalogManagement.commitVersion();
        expectToBePromise(commitVersionPromise);

        commitVersionPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getVersionWorkingCopy', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getVersionWorkingCopy
        const versionLocId = 'testString';
        const params = {
          versionLocId: versionLocId,
        };

        const getVersionWorkingCopyResult = catalogManagement.getVersionWorkingCopy(params);

        // all methods should return a Promise
        expectToBePromise(getVersionWorkingCopyResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/workingcopy', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['version_loc_id']).toEqual(versionLocId);
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

        catalogManagement.getVersionWorkingCopy(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.getVersionWorkingCopy({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getVersionWorkingCopyPromise = catalogManagement.getVersionWorkingCopy();
        expectToBePromise(getVersionWorkingCopyPromise);

        getVersionWorkingCopyPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getVersionUpdates', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getVersionUpdates
        const versionLocId = 'testString';
        const clusterId = 'testString';
        const region = 'testString';
        const resourceGroupId = 'testString';
        const namespace = 'testString';
        const params = {
          versionLocId: versionLocId,
          clusterId: clusterId,
          region: region,
          resourceGroupId: resourceGroupId,
          namespace: namespace,
        };

        const getVersionUpdatesResult = catalogManagement.getVersionUpdates(params);

        // all methods should return a Promise
        expectToBePromise(getVersionUpdatesResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/updates', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['cluster_id']).toEqual(clusterId);
        expect(options.qs['region']).toEqual(region);
        expect(options.qs['resource_group_id']).toEqual(resourceGroupId);
        expect(options.qs['namespace']).toEqual(namespace);
        expect(options.path['version_loc_id']).toEqual(versionLocId);
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

        catalogManagement.getVersionUpdates(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.getVersionUpdates({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getVersionUpdatesPromise = catalogManagement.getVersionUpdates();
        expectToBePromise(getVersionUpdatesPromise);

        getVersionUpdatesPromise.catch(err => {
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
          versionLocId: versionLocId,
        };

        const getVersionResult = catalogManagement.getVersion(params);

        // all methods should return a Promise
        expectToBePromise(getVersionResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['version_loc_id']).toEqual(versionLocId);
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

        catalogManagement.getVersion(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.getVersion({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getVersionPromise = catalogManagement.getVersion();
        expectToBePromise(getVersionPromise);

        getVersionPromise.catch(err => {
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
          versionLocId: versionLocId,
        };

        const deleteVersionResult = catalogManagement.deleteVersion(params);

        // all methods should return a Promise
        expectToBePromise(deleteVersionResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}', 'DELETE');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['version_loc_id']).toEqual(versionLocId);
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

        catalogManagement.deleteVersion(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.deleteVersion({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const deleteVersionPromise = catalogManagement.deleteVersion();
        expectToBePromise(deleteVersionPromise);

        deleteVersionPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('listVersions', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listVersions
        const q = 'testString';
        const params = {
          q: q,
        };

        const listVersionsResult = catalogManagement.listVersions(params);

        // all methods should return a Promise
        expectToBePromise(listVersionsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions', 'GET');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['q']).toEqual(q);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const q = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          q,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagement.listVersions(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.listVersions({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const listVersionsPromise = catalogManagement.listVersions();
        expectToBePromise(listVersionsPromise);

        listVersionsPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getRepos', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getRepos
        const type = 'testString';
        const repourl = 'testString';
        const params = {
          type: type,
          repourl: repourl,
        };

        const getReposResult = catalogManagement.getRepos(params);

        // all methods should return a Promise
        expectToBePromise(getReposResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/repo/{type}/entries', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['repourl']).toEqual(repourl);
        expect(options.path['type']).toEqual(type);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const type = 'testString';
        const repourl = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          type,
          repourl,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagement.getRepos(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.getRepos({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getReposPromise = catalogManagement.getRepos();
        expectToBePromise(getReposPromise);

        getReposPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getRepo', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getRepo
        const type = 'testString';
        const charturl = 'testString';
        const params = {
          type: type,
          charturl: charturl,
        };

        const getRepoResult = catalogManagement.getRepo(params);

        // all methods should return a Promise
        expectToBePromise(getRepoResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/repo/{type}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['charturl']).toEqual(charturl);
        expect(options.path['type']).toEqual(type);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const type = 'testString';
        const charturl = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          type,
          charturl,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagement.getRepo(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.getRepo({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getRepoPromise = catalogManagement.getRepo();
        expectToBePromise(getRepoPromise);

        getRepoPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('listClusters', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listClusters
        const limit = 38;
        const offset = 38;
        const type = 'testString';
        const params = {
          limit: limit,
          offset: offset,
          type: type,
        };

        const listClustersResult = catalogManagement.listClusters(params);

        // all methods should return a Promise
        expectToBePromise(listClustersResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/deploy/kubernetes/clusters', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['limit']).toEqual(limit);
        expect(options.qs['offset']).toEqual(offset);
        expect(options.qs['type']).toEqual(type);
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

        catalogManagement.listClusters(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        catalogManagement.listClusters({});
        checkForSuccessfulExecution(createRequestMock);
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
          clusterId: clusterId,
          region: region,
          xAuthRefreshToken: xAuthRefreshToken,
        };

        const getClusterResult = catalogManagement.getCluster(params);

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
        expect(options.qs['region']).toEqual(region);
        expect(options.path['cluster_id']).toEqual(clusterId);
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

        catalogManagement.getCluster(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.getCluster({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getClusterPromise = catalogManagement.getCluster();
        expectToBePromise(getClusterPromise);

        getClusterPromise.catch(err => {
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
        const limit = 38;
        const offset = 38;
        const params = {
          clusterId: clusterId,
          region: region,
          xAuthRefreshToken: xAuthRefreshToken,
          limit: limit,
          offset: offset,
        };

        const getNamespacesResult = catalogManagement.getNamespaces(params);

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
        expect(options.qs['region']).toEqual(region);
        expect(options.qs['limit']).toEqual(limit);
        expect(options.qs['offset']).toEqual(offset);
        expect(options.path['cluster_id']).toEqual(clusterId);
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

        catalogManagement.getNamespaces(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.getNamespaces({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getNamespacesPromise = catalogManagement.getNamespaces();
        expectToBePromise(getNamespacesPromise);

        getNamespacesPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('createOperator', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createOperator
        const xAuthRefreshToken = 'testString';
        const clusterId = 'testString';
        const region = 'testString';
        const namespaces = ['testString'];
        const versionLocatorId = 'testString';
        const params = {
          xAuthRefreshToken: xAuthRefreshToken,
          clusterId: clusterId,
          region: region,
          namespaces: namespaces,
          versionLocatorId: versionLocatorId,
        };

        const createOperatorResult = catalogManagement.createOperator(params);

        // all methods should return a Promise
        expectToBePromise(createOperatorResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/deploy/kubernetes/olm/operator', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'X-Auth-Refresh-Token', xAuthRefreshToken);
        expect(options.body['cluster_id']).toEqual(clusterId);
        expect(options.body['region']).toEqual(region);
        expect(options.body['namespaces']).toEqual(namespaces);
        expect(options.body['version_locator_id']).toEqual(versionLocatorId);
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

        catalogManagement.createOperator(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.createOperator({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const createOperatorPromise = catalogManagement.createOperator();
        expectToBePromise(createOperatorPromise);

        createOperatorPromise.catch(err => {
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
          xAuthRefreshToken: xAuthRefreshToken,
          clusterId: clusterId,
          region: region,
          versionLocatorId: versionLocatorId,
        };

        const listOperatorsResult = catalogManagement.listOperators(params);

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
        expect(options.qs['cluster_id']).toEqual(clusterId);
        expect(options.qs['region']).toEqual(region);
        expect(options.qs['version_locator_id']).toEqual(versionLocatorId);
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

        catalogManagement.listOperators(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.listOperators({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const listOperatorsPromise = catalogManagement.listOperators();
        expectToBePromise(listOperatorsPromise);

        listOperatorsPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('replaceOperator', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation replaceOperator
        const xAuthRefreshToken = 'testString';
        const clusterId = 'testString';
        const region = 'testString';
        const namespaces = ['testString'];
        const versionLocatorId = 'testString';
        const params = {
          xAuthRefreshToken: xAuthRefreshToken,
          clusterId: clusterId,
          region: region,
          namespaces: namespaces,
          versionLocatorId: versionLocatorId,
        };

        const replaceOperatorResult = catalogManagement.replaceOperator(params);

        // all methods should return a Promise
        expectToBePromise(replaceOperatorResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/deploy/kubernetes/olm/operator', 'PUT');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'X-Auth-Refresh-Token', xAuthRefreshToken);
        expect(options.body['cluster_id']).toEqual(clusterId);
        expect(options.body['region']).toEqual(region);
        expect(options.body['namespaces']).toEqual(namespaces);
        expect(options.body['version_locator_id']).toEqual(versionLocatorId);
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

        catalogManagement.replaceOperator(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.replaceOperator({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const replaceOperatorPromise = catalogManagement.replaceOperator();
        expectToBePromise(replaceOperatorPromise);

        replaceOperatorPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deleteOperator', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteOperator
        const xAuthRefreshToken = 'testString';
        const clusterId = 'testString';
        const region = 'testString';
        const versionLocatorId = 'testString';
        const params = {
          xAuthRefreshToken: xAuthRefreshToken,
          clusterId: clusterId,
          region: region,
          versionLocatorId: versionLocatorId,
        };

        const deleteOperatorResult = catalogManagement.deleteOperator(params);

        // all methods should return a Promise
        expectToBePromise(deleteOperatorResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/deploy/kubernetes/olm/operator', 'DELETE');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'X-Auth-Refresh-Token', xAuthRefreshToken);
        expect(options.qs['cluster_id']).toEqual(clusterId);
        expect(options.qs['region']).toEqual(region);
        expect(options.qs['version_locator_id']).toEqual(versionLocatorId);
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

        catalogManagement.deleteOperator(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.deleteOperator({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const deleteOperatorPromise = catalogManagement.deleteOperator();
        expectToBePromise(deleteOperatorPromise);

        deleteOperatorPromise.catch(err => {
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
        const overrideValues = { foo: 'bar' };
        const entitlementApikey = 'testString';
        const schematics = deployRequestBodySchematicsModel;
        const script = 'testString';
        const scriptId = 'testString';
        const versionLocatorId = 'testString';
        const vcenterId = 'testString';
        const vcenterPassword = 'testString';
        const vcenterLocation = 'testString';
        const params = {
          versionLocId: versionLocId,
          xAuthRefreshToken: xAuthRefreshToken,
          clusterId: clusterId,
          region: region,
          namespace: namespace,
          overrideValues: overrideValues,
          entitlementApikey: entitlementApikey,
          schematics: schematics,
          script: script,
          scriptId: scriptId,
          versionLocatorId: versionLocatorId,
          vcenterId: vcenterId,
          vcenterPassword: vcenterPassword,
          vcenterLocation: vcenterLocation,
        };

        const installVersionResult = catalogManagement.installVersion(params);

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
        expect(options.body['cluster_id']).toEqual(clusterId);
        expect(options.body['region']).toEqual(region);
        expect(options.body['namespace']).toEqual(namespace);
        expect(options.body['override_values']).toEqual(overrideValues);
        expect(options.body['entitlement_apikey']).toEqual(entitlementApikey);
        expect(options.body['schematics']).toEqual(schematics);
        expect(options.body['script']).toEqual(script);
        expect(options.body['script_id']).toEqual(scriptId);
        expect(options.body['version_locator_id']).toEqual(versionLocatorId);
        expect(options.body['vcenter_id']).toEqual(vcenterId);
        expect(options.body['vcenter_password']).toEqual(vcenterPassword);
        expect(options.body['vcenter_location']).toEqual(vcenterLocation);
        expect(options.path['version_loc_id']).toEqual(versionLocId);
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

        catalogManagement.installVersion(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.installVersion({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const installVersionPromise = catalogManagement.installVersion();
        expectToBePromise(installVersionPromise);

        installVersionPromise.catch(err => {
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
        const overrideValues = { foo: 'bar' };
        const entitlementApikey = 'testString';
        const schematics = deployRequestBodySchematicsModel;
        const script = 'testString';
        const scriptId = 'testString';
        const versionLocatorId = 'testString';
        const vcenterId = 'testString';
        const vcenterPassword = 'testString';
        const vcenterLocation = 'testString';
        const params = {
          versionLocId: versionLocId,
          xAuthRefreshToken: xAuthRefreshToken,
          clusterId: clusterId,
          region: region,
          namespace: namespace,
          overrideValues: overrideValues,
          entitlementApikey: entitlementApikey,
          schematics: schematics,
          script: script,
          scriptId: scriptId,
          versionLocatorId: versionLocatorId,
          vcenterId: vcenterId,
          vcenterPassword: vcenterPassword,
          vcenterLocation: vcenterLocation,
        };

        const preinstallVersionResult = catalogManagement.preinstallVersion(params);

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
        expect(options.body['cluster_id']).toEqual(clusterId);
        expect(options.body['region']).toEqual(region);
        expect(options.body['namespace']).toEqual(namespace);
        expect(options.body['override_values']).toEqual(overrideValues);
        expect(options.body['entitlement_apikey']).toEqual(entitlementApikey);
        expect(options.body['schematics']).toEqual(schematics);
        expect(options.body['script']).toEqual(script);
        expect(options.body['script_id']).toEqual(scriptId);
        expect(options.body['version_locator_id']).toEqual(versionLocatorId);
        expect(options.body['vcenter_id']).toEqual(vcenterId);
        expect(options.body['vcenter_password']).toEqual(vcenterPassword);
        expect(options.body['vcenter_location']).toEqual(vcenterLocation);
        expect(options.path['version_loc_id']).toEqual(versionLocId);
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

        catalogManagement.preinstallVersion(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.preinstallVersion({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const preinstallVersionPromise = catalogManagement.preinstallVersion();
        expectToBePromise(preinstallVersionPromise);

        preinstallVersionPromise.catch(err => {
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
          versionLocId: versionLocId,
          xAuthRefreshToken: xAuthRefreshToken,
          clusterId: clusterId,
          region: region,
          namespace: namespace,
        };

        const getPreinstallResult = catalogManagement.getPreinstall(params);

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
        expect(options.qs['cluster_id']).toEqual(clusterId);
        expect(options.qs['region']).toEqual(region);
        expect(options.qs['namespace']).toEqual(namespace);
        expect(options.path['version_loc_id']).toEqual(versionLocId);
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

        catalogManagement.getPreinstall(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.getPreinstall({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getPreinstallPromise = catalogManagement.getPreinstall();
        expectToBePromise(getPreinstallPromise);

        getPreinstallPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('validationInstall', () => {
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
        // Construct the params object for operation validationInstall
        const versionLocId = 'testString';
        const xAuthRefreshToken = 'testString';
        const clusterId = 'testString';
        const region = 'testString';
        const namespace = 'testString';
        const overrideValues = { foo: 'bar' };
        const entitlementApikey = 'testString';
        const schematics = deployRequestBodySchematicsModel;
        const script = 'testString';
        const scriptId = 'testString';
        const versionLocatorId = 'testString';
        const vcenterId = 'testString';
        const vcenterPassword = 'testString';
        const vcenterLocation = 'testString';
        const params = {
          versionLocId: versionLocId,
          xAuthRefreshToken: xAuthRefreshToken,
          clusterId: clusterId,
          region: region,
          namespace: namespace,
          overrideValues: overrideValues,
          entitlementApikey: entitlementApikey,
          schematics: schematics,
          script: script,
          scriptId: scriptId,
          versionLocatorId: versionLocatorId,
          vcenterId: vcenterId,
          vcenterPassword: vcenterPassword,
          vcenterLocation: vcenterLocation,
        };

        const validationInstallResult = catalogManagement.validationInstall(params);

        // all methods should return a Promise
        expectToBePromise(validationInstallResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/validation/install', 'POST');
        const expectedAccept = undefined;
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'X-Auth-Refresh-Token', xAuthRefreshToken);
        expect(options.body['cluster_id']).toEqual(clusterId);
        expect(options.body['region']).toEqual(region);
        expect(options.body['namespace']).toEqual(namespace);
        expect(options.body['override_values']).toEqual(overrideValues);
        expect(options.body['entitlement_apikey']).toEqual(entitlementApikey);
        expect(options.body['schematics']).toEqual(schematics);
        expect(options.body['script']).toEqual(script);
        expect(options.body['script_id']).toEqual(scriptId);
        expect(options.body['version_locator_id']).toEqual(versionLocatorId);
        expect(options.body['vcenter_id']).toEqual(vcenterId);
        expect(options.body['vcenter_password']).toEqual(vcenterPassword);
        expect(options.body['vcenter_location']).toEqual(vcenterLocation);
        expect(options.path['version_loc_id']).toEqual(versionLocId);
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

        catalogManagement.validationInstall(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.validationInstall({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const validationInstallPromise = catalogManagement.validationInstall();
        expectToBePromise(validationInstallPromise);

        validationInstallPromise.catch(err => {
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
          versionLocId: versionLocId,
          xAuthRefreshToken: xAuthRefreshToken,
        };

        const getValidationStatusResult = catalogManagement.getValidationStatus(params);

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
        expect(options.path['version_loc_id']).toEqual(versionLocId);
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

        catalogManagement.getValidationStatus(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.getValidationStatus({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getValidationStatusPromise = catalogManagement.getValidationStatus();
        expectToBePromise(getValidationStatusPromise);

        getValidationStatusPromise.catch(err => {
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
          versionLocId: versionLocId,
        };

        const getOverrideValuesResult = catalogManagement.getOverrideValues(params);

        // all methods should return a Promise
        expectToBePromise(getOverrideValuesResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/validation/overridevalues', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['version_loc_id']).toEqual(versionLocId);
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

        catalogManagement.getOverrideValues(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.getOverrideValues({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getOverrideValuesPromise = catalogManagement.getOverrideValues();
        expectToBePromise(getOverrideValuesPromise);

        getOverrideValuesPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getSchematicsWorkspaces', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getSchematicsWorkspaces
        const versionLocId = 'testString';
        const xAuthRefreshToken = 'testString';
        const params = {
          versionLocId: versionLocId,
          xAuthRefreshToken: xAuthRefreshToken,
        };

        const getSchematicsWorkspacesResult = catalogManagement.getSchematicsWorkspaces(params);

        // all methods should return a Promise
        expectToBePromise(getSchematicsWorkspacesResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/workspaces', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'X-Auth-Refresh-Token', xAuthRefreshToken);
        expect(options.path['version_loc_id']).toEqual(versionLocId);
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

        catalogManagement.getSchematicsWorkspaces(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.getSchematicsWorkspaces({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getSchematicsWorkspacesPromise = catalogManagement.getSchematicsWorkspaces();
        expectToBePromise(getSchematicsWorkspacesPromise);

        getSchematicsWorkspacesPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('canDeploySchematics', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation canDeploySchematics
        const versionLocId = 'testString';
        const clusterId = 'testString';
        const region = 'testString';
        const namespace = 'testString';
        const resourceGroupId = 'testString';
        const params = {
          versionLocId: versionLocId,
          clusterId: clusterId,
          region: region,
          namespace: namespace,
          resourceGroupId: resourceGroupId,
        };

        const canDeploySchematicsResult = catalogManagement.canDeploySchematics(params);

        // all methods should return a Promise
        expectToBePromise(canDeploySchematicsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/versions/{version_loc_id}/candeploy', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['cluster_id']).toEqual(clusterId);
        expect(options.qs['region']).toEqual(region);
        expect(options.qs['namespace']).toEqual(namespace);
        expect(options.qs['resource_group_id']).toEqual(resourceGroupId);
        expect(options.path['version_loc_id']).toEqual(versionLocId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const versionLocId = 'testString';
        const clusterId = 'testString';
        const region = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          versionLocId,
          clusterId,
          region,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagement.canDeploySchematics(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.canDeploySchematics({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const canDeploySchematicsPromise = catalogManagement.canDeploySchematics();
        expectToBePromise(canDeploySchematicsPromise);

        canDeploySchematicsPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getResourceGroups', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getResourceGroups
        const params = {};

        const getResourceGroupsResult = catalogManagement.getResourceGroups(params);

        // all methods should return a Promise
        expectToBePromise(getResourceGroupsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/deploy/schematics/resourcegroups', 'GET');
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

        catalogManagement.getResourceGroups(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        catalogManagement.getResourceGroups({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('getLicenseProviders', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getLicenseProviders
        const params = {};

        const getLicenseProvidersResult = catalogManagement.getLicenseProviders(params);

        // all methods should return a Promise
        expectToBePromise(getLicenseProvidersResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/license/license_providers', 'GET');
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

        catalogManagement.getLicenseProviders(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        catalogManagement.getLicenseProviders({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('listLicenseEntitlements', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listLicenseEntitlements
        const accountId = 'testString';
        const licenseProductId = 'testString';
        const versionId = 'testString';
        const state = 'testString';
        const params = {
          accountId: accountId,
          licenseProductId: licenseProductId,
          versionId: versionId,
          state: state,
        };

        const listLicenseEntitlementsResult = catalogManagement.listLicenseEntitlements(params);

        // all methods should return a Promise
        expectToBePromise(listLicenseEntitlementsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/license/entitlements', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['account_id']).toEqual(accountId);
        expect(options.qs['license_product_id']).toEqual(licenseProductId);
        expect(options.qs['version_id']).toEqual(versionId);
        expect(options.qs['state']).toEqual(state);
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

        catalogManagement.listLicenseEntitlements(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        catalogManagement.listLicenseEntitlements({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('createLicenseEntitlement', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createLicenseEntitlement
        const name = 'testString';
        const effectiveFrom = 'testString';
        const effectiveUntil = 'testString';
        const versionId = 'testString';
        const licenseId = 'testString';
        const licenseOwnerId = 'testString';
        const licenseProviderId = 'testString';
        const licenseProductId = 'testString';
        const accountId = 'testString';
        const params = {
          name: name,
          effectiveFrom: effectiveFrom,
          effectiveUntil: effectiveUntil,
          versionId: versionId,
          licenseId: licenseId,
          licenseOwnerId: licenseOwnerId,
          licenseProviderId: licenseProviderId,
          licenseProductId: licenseProductId,
          accountId: accountId,
        };

        const createLicenseEntitlementResult = catalogManagement.createLicenseEntitlement(params);

        // all methods should return a Promise
        expectToBePromise(createLicenseEntitlementResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/license/entitlements', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['name']).toEqual(name);
        expect(options.body['effective_from']).toEqual(effectiveFrom);
        expect(options.body['effective_until']).toEqual(effectiveUntil);
        expect(options.body['version_id']).toEqual(versionId);
        expect(options.body['license_id']).toEqual(licenseId);
        expect(options.body['license_owner_id']).toEqual(licenseOwnerId);
        expect(options.body['license_provider_id']).toEqual(licenseProviderId);
        expect(options.body['license_product_id']).toEqual(licenseProductId);
        expect(options.qs['account_id']).toEqual(accountId);
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

        catalogManagement.createLicenseEntitlement(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        catalogManagement.createLicenseEntitlement({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('getLicenseEntitlements', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getLicenseEntitlements
        const licenseProductId = 'testString';
        const accountId = 'testString';
        const versionId = 'testString';
        const params = {
          licenseProductId: licenseProductId,
          accountId: accountId,
          versionId: versionId,
        };

        const getLicenseEntitlementsResult = catalogManagement.getLicenseEntitlements(params);

        // all methods should return a Promise
        expectToBePromise(getLicenseEntitlementsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/license/entitlements/productID/{license_product_id}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['account_id']).toEqual(accountId);
        expect(options.qs['version_id']).toEqual(versionId);
        expect(options.path['license_product_id']).toEqual(licenseProductId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const licenseProductId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          licenseProductId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagement.getLicenseEntitlements(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.getLicenseEntitlements({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getLicenseEntitlementsPromise = catalogManagement.getLicenseEntitlements();
        expectToBePromise(getLicenseEntitlementsPromise);

        getLicenseEntitlementsPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deleteLicenseEntitlement', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteLicenseEntitlement
        const entitlementId = 'testString';
        const accountId = 'testString';
        const params = {
          entitlementId: entitlementId,
          accountId: accountId,
        };

        const deleteLicenseEntitlementResult = catalogManagement.deleteLicenseEntitlement(params);

        // all methods should return a Promise
        expectToBePromise(deleteLicenseEntitlementResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/license/entitlements/{entitlement_id}', 'DELETE');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['account_id']).toEqual(accountId);
        expect(options.path['entitlement_id']).toEqual(entitlementId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const entitlementId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          entitlementId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagement.deleteLicenseEntitlement(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.deleteLicenseEntitlement({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const deleteLicenseEntitlementPromise = catalogManagement.deleteLicenseEntitlement();
        expectToBePromise(deleteLicenseEntitlementPromise);

        deleteLicenseEntitlementPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getLicenses', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getLicenses
        const licenseProviderId = 'testString';
        const accountId = 'testString';
        const name = 'testString';
        const licenseType = 'testString';
        const licenseProductId = 'testString';
        const params = {
          licenseProviderId: licenseProviderId,
          accountId: accountId,
          name: name,
          licenseType: licenseType,
          licenseProductId: licenseProductId,
        };

        const getLicensesResult = catalogManagement.getLicenses(params);

        // all methods should return a Promise
        expectToBePromise(getLicensesResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/license/licenses', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['license_provider_id']).toEqual(licenseProviderId);
        expect(options.qs['account_id']).toEqual(accountId);
        expect(options.qs['name']).toEqual(name);
        expect(options.qs['license_type']).toEqual(licenseType);
        expect(options.qs['license_product_id']).toEqual(licenseProductId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const licenseProviderId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          licenseProviderId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagement.getLicenses(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.getLicenses({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getLicensesPromise = catalogManagement.getLicenses();
        expectToBePromise(getLicensesPromise);

        getLicensesPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('searchLicenseVersions', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation searchLicenseVersions
        const q = 'testString';
        const params = {
          q: q,
        };

        const searchLicenseVersionsResult = catalogManagement.searchLicenseVersions(params);

        // all methods should return a Promise
        expectToBePromise(searchLicenseVersionsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/search/license/versions', 'GET');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['q']).toEqual(q);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const q = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          q,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagement.searchLicenseVersions(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.searchLicenseVersions({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const searchLicenseVersionsPromise = catalogManagement.searchLicenseVersions();
        expectToBePromise(searchLicenseVersionsPromise);

        searchLicenseVersionsPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('searchLicenseOfferings', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation searchLicenseOfferings
        const q = 'testString';
        const params = {
          q: q,
        };

        const searchLicenseOfferingsResult = catalogManagement.searchLicenseOfferings(params);

        // all methods should return a Promise
        expectToBePromise(searchLicenseOfferingsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/search/license/offerings', 'GET');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['q']).toEqual(q);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const q = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          q,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        catalogManagement.searchLicenseOfferings(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await catalogManagement.searchLicenseOfferings({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const searchLicenseOfferingsPromise = catalogManagement.searchLicenseOfferings();
        expectToBePromise(searchLicenseOfferingsPromise);

        searchLicenseOfferingsPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
});
