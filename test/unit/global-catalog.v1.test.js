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

const GlobalCatalogV1 = require('../../dist/global-catalog/v1');

const {
  getOptions,
  checkUrlAndMethod,
  checkMediaHeaders,
  expectToBePromise,
  checkForSuccessfulExecution,
} = unitTestUtils;

const service = {
  authenticator: new NoAuthAuthenticator(),
  url: 'https://globalcatalog.cloud.ibm.com/api/v1',
};

const globalCatalog = new GlobalCatalogV1(service);

// dont actually create a request
const createRequestMock = jest.spyOn(globalCatalog, 'createRequest');
createRequestMock.mockImplementation(() => Promise.resolve());

// dont actually construct an authenticator
const getAuthenticatorMock = jest.spyOn(core, 'getAuthenticatorFromEnvironment');
getAuthenticatorMock.mockImplementation(() => new NoAuthAuthenticator());

afterEach(() => {
  createRequestMock.mockClear();
  getAuthenticatorMock.mockClear();
});

describe('GlobalCatalogV1', () => {
  describe('the newInstance method', () => {
    test('should use defaults when options not provided', () => {
      const testInstance = GlobalCatalogV1.newInstance();

      expect(getAuthenticatorMock).toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceName).toBe(GlobalCatalogV1.DEFAULT_SERVICE_NAME);
      expect(testInstance.baseOptions.serviceUrl).toBe(GlobalCatalogV1.DEFAULT_SERVICE_URL);
      expect(testInstance).toBeInstanceOf(GlobalCatalogV1);
    });

    test('should set serviceName, serviceUrl, and authenticator when provided', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
        serviceName: 'my-service',
      };

      const testInstance = GlobalCatalogV1.newInstance(options);

      expect(getAuthenticatorMock).not.toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
      expect(testInstance.baseOptions.serviceName).toBe('my-service');
      expect(testInstance).toBeInstanceOf(GlobalCatalogV1);
    });
  });
  describe('the constructor', () => {
    test('use user-given service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
      };

      const testInstance = new GlobalCatalogV1(options);

      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
    });

    test('use default service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
      };

      const testInstance = new GlobalCatalogV1(options);

      expect(testInstance.baseOptions.serviceUrl).toBe(GlobalCatalogV1.DEFAULT_SERVICE_URL);
    });
  });
  describe('listCatalogEntries', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listCatalogEntries
        const account = 'testString';
        const include = 'testString';
        const q = 'testString';
        const sortBy = 'testString';
        const descending = 'testString';
        const languages = 'testString';
        const complete = 'testString';
        const params = {
          account: account,
          include: include,
          q: q,
          sortBy: sortBy,
          descending: descending,
          languages: languages,
          complete: complete,
        };

        const listCatalogEntriesResult = globalCatalog.listCatalogEntries(params);

        // all methods should return a Promise
        expectToBePromise(listCatalogEntriesResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['account']).toEqual(account);
        expect(options.qs['include']).toEqual(include);
        expect(options.qs['q']).toEqual(q);
        expect(options.qs['sort-by']).toEqual(sortBy);
        expect(options.qs['descending']).toEqual(descending);
        expect(options.qs['languages']).toEqual(languages);
        expect(options.qs['complete']).toEqual(complete);
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

        globalCatalog.listCatalogEntries(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        globalCatalog.listCatalogEntries({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('createCatalogEntry', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // Overview
      const overviewModel = {
        display_name: 'testString',
        long_description: 'testString',
        description: 'testString',
      };

      // OverviewUI
      const overviewUiModel = {
        language: overviewModel,
      };

      // Image
      const imageModel = {
        image: 'testString',
        small_image: 'testString',
        medium_image: 'testString',
        feature_image: 'testString',
      };

      // Provider
      const providerModel = {
        email: 'testString',
        name: 'testString',
        contact: 'testString',
        support_email: 'testString',
        phone: 'testString',
      };

      // Bullets
      const bulletsModel = {
        title: 'testString',
        description: 'testString',
        icon: 'testString',
        quantity: 'testString',
      };

      // Price
      const priceModel = {
        quantity_tier: 38,
        price: 72.5,
      };

      // UIMetaMedia
      const uiMetaMediaModel = {
        caption: 'testString',
        thumbnail_url: 'testString',
        type: 'testString',
        url: 'testString',
        source: bulletsModel,
      };

      // Amount
      const amountModel = {
        counrty: 'testString',
        currency: 'testString',
        prices: [priceModel],
      };

      // ObjectMetaDataDeploymentBrokerPassword
      const objectMetaDataDeploymentBrokerPasswordModel = {
        text: 'testString',
        key: 'testString',
        iv: 'testString',
      };

      // Strings
      const stringsModel = {
        bullets: [bulletsModel],
        media: [uiMetaMediaModel],
        not_creatable_msg: 'testString',
        not_creatable_robot_msg: 'testString',
        deprecation_warning: 'testString',
        popup_warning_message: 'testString',
        instruction: 'testString',
      };

      // I18N
      const i18NModel = {
        language: stringsModel,
      };

      // Metrics
      const metricsModel = {
        metric_id: 'testString',
        tier_model: 'testString',
        charge_unit_name: 'testString',
        charge_unit_quantity: 'testString',
        resource_display_name: 'testString',
        charge_unit_display_name: 'testString',
        usage_cap_qty: 38,
        amounts: [amountModel],
      };

      // ObjectMetaDataDeploymentBroker
      const objectMetaDataDeploymentBrokerModel = {
        name: 'testString',
        guid: 'testString',
        password: objectMetaDataDeploymentBrokerPasswordModel,
      };

      // ObjectMetaDataSlaDr
      const objectMetaDataSlaDrModel = {
        dr: true,
        description: 'testString',
      };

      // ObjectMetaDataTemplateEnvironmentVariables
      const objectMetaDataTemplateEnvironmentVariablesModel = {
        key: 'testString',
      };

      // ObjectMetaDataTemplateSource
      const objectMetaDataTemplateSourceModel = {
        path: 'testString',
        type: 'testString',
        url: 'testString',
      };

      // StartingPrice
      const startingPriceModel = {
        plan_id: 'testString',
        deployment_id: 'testString',
        amount: [amountModel],
      };

      // URLS
      const urlsModel = {
        doc_url: 'testString',
        instructions_url: 'testString',
        api_url: 'testString',
        create_url: 'testString',
        sdk_download_url: 'testString',
        terms_url: 'testString',
        custom_create_page_url: 'testString',
        catalog_details_url: 'testString',
        deprecation_doc_url: 'testString',
      };

      // Callbacks
      const callbacksModel = {
        broker_utl: 'testString',
        broker_proxy_url: 'testString',
        dashboard_url: 'testString',
        dashboard_data_url: 'testString',
        dashboard_detail_tab_url: 'testString',
        dashboard_detail_tab_ext_url: 'testString',
        service_monitor_api: 'testString',
        service_monitor_app: 'testString',
        service_staging_url: 'testString',
        service_production_url: 'testString',
      };

      // ObjectMetaDataAlias
      const objectMetaDataAliasModel = {
        type: 'testString',
        plan_id: 'testString',
      };

      // ObjectMetaDataDeployment
      const objectMetaDataDeploymentModel = {
        location: 'testString',
        location_url: 'testString',
        target_crn: 'testString',
        broker: objectMetaDataDeploymentBrokerModel,
        supports_rc_migration: true,
      };

      // ObjectMetaDataPlan
      const objectMetaDataPlanModel = {
        bindable: true,
        reservable: true,
        allow_internal_users: true,
        async_provisioning_supported: true,
        async_unprovisioning_supported: true,
        test_check_interval: 38,
        single_scope_instance: 'testString',
        service_check_enabled: true,
        cf_guid: 'testString',
      };

      // ObjectMetaDataService
      const objectMetaDataServiceModel = {
        type: 'testString',
        iam_compatible: true,
        unique_api_key: true,
        provisionable: true,
        async_provisioning_supported: true,
        async_unprovisioning_supported: true,
        cf_guid: 'testString',
        bindable: true,
        requires: ['testString'],
        plan_updateable: true,
        state: 'testString',
        service_check_enabled: true,
        test_check_interval: 38,
        service_key_supported: true,
      };

      // ObjectMetaDataSla
      const objectMetaDataSlaModel = {
        terms: 'testString',
        tenancy: 'testString',
        provisioning: 'testString',
        responsiveness: 'testString',
        dr: objectMetaDataSlaDrModel,
      };

      // ObjectMetaDataTemplate
      const objectMetaDataTemplateModel = {
        services: ['testString'],
        default_memory: 38,
        start_cmd: 'testString',
        source: objectMetaDataTemplateSourceModel,
        runtime_catalog_id: 'testString',
        cf_runtime_id: 'testString',
        template_id: 'testString',
        executable_file: 'testString',
        buildpack: 'testString',
        environment_variables: objectMetaDataTemplateEnvironmentVariablesModel,
      };

      // Pricing
      const pricingModel = {
        type: 'testString',
        origin: 'testString',
        starting_price: startingPriceModel,
        metrics: [metricsModel],
      };

      // UIMetaData
      const uiMetaDataModel = {
        strings: i18NModel,
        urls: urlsModel,
        embeddable_dashboard: 'testString',
        embeddable_dashboard_full_width: true,
        navigation_order: ['testString'],
        not_creatable: true,
        reservable: true,
        primary_offering_id: 'testString',
        accessible_during_provision: true,
        side_by_side_index: 38,
        end_of_service_time: '2019-01-01T12:00:00',
      };

      // ObjectMetaData
      const objectMetaDataModel = {
        rc_compatible: true,
        ui: uiMetaDataModel,
        pricing: pricingModel,
        compliance: ['testString'],
        service: objectMetaDataServiceModel,
        plan: objectMetaDataPlanModel,
        template: objectMetaDataTemplateModel,
        deployment: objectMetaDataDeploymentModel,
        alias: objectMetaDataAliasModel,
        sla: objectMetaDataSlaModel,
        callbacks: callbacksModel,
        version: 'testString',
        origin_name: 'testString',
        other: { foo: 'bar' },
      };

      // CatalogEntry
      const catalogEntryModel = {
        id: 'testString',
        catalog_crn: 'testString',
        url: 'testString',
        name: 'testString',
        overview_ui: overviewUiModel,
        kind: 'testString',
        images: imageModel,
        parent_id: 'testString',
        children_url: 'testString',
        parent_url: 'testString',
        disabled: true,
        tags: ['testString'],
        geo_tags: ['testString'],
        pricing_tags: ['testString'],
        group: true,
        provider: providerModel,
        created: '2019-01-01T12:00:00',
        updated: '2019-01-01T12:00:00',
        metadata: objectMetaDataModel,
        active: true,
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createCatalogEntry
        const id = 'testString';
        const name = 'testString';
        const overviewUi = overviewUiModel;
        const kind = 'testString';
        const images = imageModel;
        const disabled = true;
        const tags = ['testString'];
        const geoTags = ['testString'];
        const pricingTags = ['testString'];
        const group = true;
        const provider = providerModel;
        const catalogCrn = 'testString';
        const url = 'testString';
        const parentId = 'testString';
        const childrenUrl = 'testString';
        const parentUrl = 'testString';
        const created = '2019-01-01T12:00:00';
        const updated = '2019-01-01T12:00:00';
        const metadata = objectMetaDataModel;
        const active = true;
        const children = [catalogEntryModel];
        const account = 'testString';
        const params = {
          id: id,
          name: name,
          overviewUi: overviewUi,
          kind: kind,
          images: images,
          disabled: disabled,
          tags: tags,
          geoTags: geoTags,
          pricingTags: pricingTags,
          group: group,
          provider: provider,
          catalogCrn: catalogCrn,
          url: url,
          parentId: parentId,
          childrenUrl: childrenUrl,
          parentUrl: parentUrl,
          created: created,
          updated: updated,
          metadata: metadata,
          active: active,
          children: children,
          account: account,
        };

        const createCatalogEntryResult = globalCatalog.createCatalogEntry(params);

        // all methods should return a Promise
        expectToBePromise(createCatalogEntryResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/', 'POST');
        const expectedAccept = undefined;
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['id']).toEqual(id);
        expect(options.body['name']).toEqual(name);
        expect(options.body['overview_ui']).toEqual(overviewUi);
        expect(options.body['kind']).toEqual(kind);
        expect(options.body['images']).toEqual(images);
        expect(options.body['disabled']).toEqual(disabled);
        expect(options.body['tags']).toEqual(tags);
        expect(options.body['geo_tags']).toEqual(geoTags);
        expect(options.body['pricing_tags']).toEqual(pricingTags);
        expect(options.body['group']).toEqual(group);
        expect(options.body['provider']).toEqual(provider);
        expect(options.body['catalog_crn']).toEqual(catalogCrn);
        expect(options.body['url']).toEqual(url);
        expect(options.body['parent_id']).toEqual(parentId);
        expect(options.body['children_url']).toEqual(childrenUrl);
        expect(options.body['parent_url']).toEqual(parentUrl);
        expect(options.body['created']).toEqual(created);
        expect(options.body['updated']).toEqual(updated);
        expect(options.body['metadata']).toEqual(metadata);
        expect(options.body['active']).toEqual(active);
        expect(options.body['children']).toEqual(children);
        expect(options.qs['account']).toEqual(account);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const id = 'testString';
        const name = 'testString';
        const overviewUi = overviewUiModel;
        const kind = 'testString';
        const images = imageModel;
        const disabled = true;
        const tags = ['testString'];
        const geoTags = ['testString'];
        const pricingTags = ['testString'];
        const group = true;
        const provider = providerModel;
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          id,
          name,
          overviewUi,
          kind,
          images,
          disabled,
          tags,
          geoTags,
          pricingTags,
          group,
          provider,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        globalCatalog.createCatalogEntry(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await globalCatalog.createCatalogEntry({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const createCatalogEntryPromise = globalCatalog.createCatalogEntry();
        expectToBePromise(createCatalogEntryPromise);

        createCatalogEntryPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getCatalogEntry', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getCatalogEntry
        const id = 'testString';
        const account = 'testString';
        const include = 'testString';
        const languages = 'testString';
        const complete = 'testString';
        const depth = 38;
        const params = {
          id: id,
          account: account,
          include: include,
          languages: languages,
          complete: complete,
          depth: depth,
        };

        const getCatalogEntryResult = globalCatalog.getCatalogEntry(params);

        // all methods should return a Promise
        expectToBePromise(getCatalogEntryResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/{id}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['account']).toEqual(account);
        expect(options.qs['include']).toEqual(include);
        expect(options.qs['languages']).toEqual(languages);
        expect(options.qs['complete']).toEqual(complete);
        expect(options.qs['depth']).toEqual(depth);
        expect(options.path['id']).toEqual(id);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const id = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          id,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        globalCatalog.getCatalogEntry(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await globalCatalog.getCatalogEntry({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getCatalogEntryPromise = globalCatalog.getCatalogEntry();
        expectToBePromise(getCatalogEntryPromise);

        getCatalogEntryPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('updateCatalogEntry', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // Overview
      const overviewModel = {
        display_name: 'testString',
        long_description: 'testString',
        description: 'testString',
      };

      // OverviewUI
      const overviewUiModel = {
        language: overviewModel,
      };

      // Image
      const imageModel = {
        image: 'testString',
        small_image: 'testString',
        medium_image: 'testString',
        feature_image: 'testString',
      };

      // Provider
      const providerModel = {
        email: 'testString',
        name: 'testString',
        contact: 'testString',
        support_email: 'testString',
        phone: 'testString',
      };

      // Bullets
      const bulletsModel = {
        title: 'testString',
        description: 'testString',
        icon: 'testString',
        quantity: 'testString',
      };

      // Price
      const priceModel = {
        quantity_tier: 38,
        price: 72.5,
      };

      // UIMetaMedia
      const uiMetaMediaModel = {
        caption: 'testString',
        thumbnail_url: 'testString',
        type: 'testString',
        url: 'testString',
        source: bulletsModel,
      };

      // Amount
      const amountModel = {
        counrty: 'testString',
        currency: 'testString',
        prices: [priceModel],
      };

      // ObjectMetaDataDeploymentBrokerPassword
      const objectMetaDataDeploymentBrokerPasswordModel = {
        text: 'testString',
        key: 'testString',
        iv: 'testString',
      };

      // Strings
      const stringsModel = {
        bullets: [bulletsModel],
        media: [uiMetaMediaModel],
        not_creatable_msg: 'testString',
        not_creatable_robot_msg: 'testString',
        deprecation_warning: 'testString',
        popup_warning_message: 'testString',
        instruction: 'testString',
      };

      // I18N
      const i18NModel = {
        language: stringsModel,
      };

      // Metrics
      const metricsModel = {
        metric_id: 'testString',
        tier_model: 'testString',
        charge_unit_name: 'testString',
        charge_unit_quantity: 'testString',
        resource_display_name: 'testString',
        charge_unit_display_name: 'testString',
        usage_cap_qty: 38,
        amounts: [amountModel],
      };

      // ObjectMetaDataDeploymentBroker
      const objectMetaDataDeploymentBrokerModel = {
        name: 'testString',
        guid: 'testString',
        password: objectMetaDataDeploymentBrokerPasswordModel,
      };

      // ObjectMetaDataSlaDr
      const objectMetaDataSlaDrModel = {
        dr: true,
        description: 'testString',
      };

      // ObjectMetaDataTemplateEnvironmentVariables
      const objectMetaDataTemplateEnvironmentVariablesModel = {
        key: 'testString',
      };

      // ObjectMetaDataTemplateSource
      const objectMetaDataTemplateSourceModel = {
        path: 'testString',
        type: 'testString',
        url: 'testString',
      };

      // StartingPrice
      const startingPriceModel = {
        plan_id: 'testString',
        deployment_id: 'testString',
        amount: [amountModel],
      };

      // URLS
      const urlsModel = {
        doc_url: 'testString',
        instructions_url: 'testString',
        api_url: 'testString',
        create_url: 'testString',
        sdk_download_url: 'testString',
        terms_url: 'testString',
        custom_create_page_url: 'testString',
        catalog_details_url: 'testString',
        deprecation_doc_url: 'testString',
      };

      // Callbacks
      const callbacksModel = {
        broker_utl: 'testString',
        broker_proxy_url: 'testString',
        dashboard_url: 'testString',
        dashboard_data_url: 'testString',
        dashboard_detail_tab_url: 'testString',
        dashboard_detail_tab_ext_url: 'testString',
        service_monitor_api: 'testString',
        service_monitor_app: 'testString',
        service_staging_url: 'testString',
        service_production_url: 'testString',
      };

      // ObjectMetaDataAlias
      const objectMetaDataAliasModel = {
        type: 'testString',
        plan_id: 'testString',
      };

      // ObjectMetaDataDeployment
      const objectMetaDataDeploymentModel = {
        location: 'testString',
        location_url: 'testString',
        target_crn: 'testString',
        broker: objectMetaDataDeploymentBrokerModel,
        supports_rc_migration: true,
      };

      // ObjectMetaDataPlan
      const objectMetaDataPlanModel = {
        bindable: true,
        reservable: true,
        allow_internal_users: true,
        async_provisioning_supported: true,
        async_unprovisioning_supported: true,
        test_check_interval: 38,
        single_scope_instance: 'testString',
        service_check_enabled: true,
        cf_guid: 'testString',
      };

      // ObjectMetaDataService
      const objectMetaDataServiceModel = {
        type: 'testString',
        iam_compatible: true,
        unique_api_key: true,
        provisionable: true,
        async_provisioning_supported: true,
        async_unprovisioning_supported: true,
        cf_guid: 'testString',
        bindable: true,
        requires: ['testString'],
        plan_updateable: true,
        state: 'testString',
        service_check_enabled: true,
        test_check_interval: 38,
        service_key_supported: true,
      };

      // ObjectMetaDataSla
      const objectMetaDataSlaModel = {
        terms: 'testString',
        tenancy: 'testString',
        provisioning: 'testString',
        responsiveness: 'testString',
        dr: objectMetaDataSlaDrModel,
      };

      // ObjectMetaDataTemplate
      const objectMetaDataTemplateModel = {
        services: ['testString'],
        default_memory: 38,
        start_cmd: 'testString',
        source: objectMetaDataTemplateSourceModel,
        runtime_catalog_id: 'testString',
        cf_runtime_id: 'testString',
        template_id: 'testString',
        executable_file: 'testString',
        buildpack: 'testString',
        environment_variables: objectMetaDataTemplateEnvironmentVariablesModel,
      };

      // Pricing
      const pricingModel = {
        type: 'testString',
        origin: 'testString',
        starting_price: startingPriceModel,
        metrics: [metricsModel],
      };

      // UIMetaData
      const uiMetaDataModel = {
        strings: i18NModel,
        urls: urlsModel,
        embeddable_dashboard: 'testString',
        embeddable_dashboard_full_width: true,
        navigation_order: ['testString'],
        not_creatable: true,
        reservable: true,
        primary_offering_id: 'testString',
        accessible_during_provision: true,
        side_by_side_index: 38,
        end_of_service_time: '2019-01-01T12:00:00',
      };

      // ObjectMetaData
      const objectMetaDataModel = {
        rc_compatible: true,
        ui: uiMetaDataModel,
        pricing: pricingModel,
        compliance: ['testString'],
        service: objectMetaDataServiceModel,
        plan: objectMetaDataPlanModel,
        template: objectMetaDataTemplateModel,
        deployment: objectMetaDataDeploymentModel,
        alias: objectMetaDataAliasModel,
        sla: objectMetaDataSlaModel,
        callbacks: callbacksModel,
        version: 'testString',
        origin_name: 'testString',
        other: { foo: 'bar' },
      };

      // CatalogEntry
      const catalogEntryModel = {
        id: 'testString',
        catalog_crn: 'testString',
        url: 'testString',
        name: 'testString',
        overview_ui: overviewUiModel,
        kind: 'testString',
        images: imageModel,
        parent_id: 'testString',
        children_url: 'testString',
        parent_url: 'testString',
        disabled: true,
        tags: ['testString'],
        geo_tags: ['testString'],
        pricing_tags: ['testString'],
        group: true,
        provider: providerModel,
        created: '2019-01-01T12:00:00',
        updated: '2019-01-01T12:00:00',
        metadata: objectMetaDataModel,
        active: true,
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation updateCatalogEntry
        const id = 'testString';
        const newId = 'testString';
        const newName = 'testString';
        const newOverviewUi = overviewUiModel;
        const newKind = 'testString';
        const newImages = imageModel;
        const newDisabled = true;
        const newTags = ['testString'];
        const newGeoTags = ['testString'];
        const newPricingTags = ['testString'];
        const newGroup = true;
        const newProvider = providerModel;
        const newCatalogCrn = 'testString';
        const newUrl = 'testString';
        const newParentId = 'testString';
        const newChildrenUrl = 'testString';
        const newParentUrl = 'testString';
        const newCreated = '2019-01-01T12:00:00';
        const newUpdated = '2019-01-01T12:00:00';
        const newMetadata = objectMetaDataModel;
        const newActive = true;
        const newChildren = [catalogEntryModel];
        const account = 'testString';
        const move = 'testString';
        const params = {
          id: id,
          newId: newId,
          newName: newName,
          newOverviewUi: newOverviewUi,
          newKind: newKind,
          newImages: newImages,
          newDisabled: newDisabled,
          newTags: newTags,
          newGeoTags: newGeoTags,
          newPricingTags: newPricingTags,
          newGroup: newGroup,
          newProvider: newProvider,
          newCatalogCrn: newCatalogCrn,
          newUrl: newUrl,
          newParentId: newParentId,
          newChildrenUrl: newChildrenUrl,
          newParentUrl: newParentUrl,
          newCreated: newCreated,
          newUpdated: newUpdated,
          newMetadata: newMetadata,
          newActive: newActive,
          newChildren: newChildren,
          account: account,
          move: move,
        };

        const updateCatalogEntryResult = globalCatalog.updateCatalogEntry(params);

        // all methods should return a Promise
        expectToBePromise(updateCatalogEntryResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/{id}', 'PUT');
        const expectedAccept = undefined;
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['id']).toEqual(newId);
        expect(options.body['name']).toEqual(newName);
        expect(options.body['overview_ui']).toEqual(newOverviewUi);
        expect(options.body['kind']).toEqual(newKind);
        expect(options.body['images']).toEqual(newImages);
        expect(options.body['disabled']).toEqual(newDisabled);
        expect(options.body['tags']).toEqual(newTags);
        expect(options.body['geo_tags']).toEqual(newGeoTags);
        expect(options.body['pricing_tags']).toEqual(newPricingTags);
        expect(options.body['group']).toEqual(newGroup);
        expect(options.body['provider']).toEqual(newProvider);
        expect(options.body['catalog_crn']).toEqual(newCatalogCrn);
        expect(options.body['url']).toEqual(newUrl);
        expect(options.body['parent_id']).toEqual(newParentId);
        expect(options.body['children_url']).toEqual(newChildrenUrl);
        expect(options.body['parent_url']).toEqual(newParentUrl);
        expect(options.body['created']).toEqual(newCreated);
        expect(options.body['updated']).toEqual(newUpdated);
        expect(options.body['metadata']).toEqual(newMetadata);
        expect(options.body['active']).toEqual(newActive);
        expect(options.body['children']).toEqual(newChildren);
        expect(options.qs['account']).toEqual(account);
        expect(options.qs['move']).toEqual(move);
        expect(options.path['id']).toEqual(id);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const id = 'testString';
        const newId = 'testString';
        const newName = 'testString';
        const newOverviewUi = overviewUiModel;
        const newKind = 'testString';
        const newImages = imageModel;
        const newDisabled = true;
        const newTags = ['testString'];
        const newGeoTags = ['testString'];
        const newPricingTags = ['testString'];
        const newGroup = true;
        const newProvider = providerModel;
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          id,
          newId,
          newName,
          newOverviewUi,
          newKind,
          newImages,
          newDisabled,
          newTags,
          newGeoTags,
          newPricingTags,
          newGroup,
          newProvider,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        globalCatalog.updateCatalogEntry(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await globalCatalog.updateCatalogEntry({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const updateCatalogEntryPromise = globalCatalog.updateCatalogEntry();
        expectToBePromise(updateCatalogEntryPromise);

        updateCatalogEntryPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('archiveCatalogEntry', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation archiveCatalogEntry
        const id = 'testString';
        const account = 'testString';
        const params = {
          id: id,
          account: account,
        };

        const archiveCatalogEntryResult = globalCatalog.archiveCatalogEntry(params);

        // all methods should return a Promise
        expectToBePromise(archiveCatalogEntryResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/{id}', 'DELETE');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['account']).toEqual(account);
        expect(options.path['id']).toEqual(id);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const id = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          id,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        globalCatalog.archiveCatalogEntry(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await globalCatalog.archiveCatalogEntry({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const archiveCatalogEntryPromise = globalCatalog.archiveCatalogEntry();
        expectToBePromise(archiveCatalogEntryPromise);

        archiveCatalogEntryPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getChildObjects', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getChildObjects
        const id = 'testString';
        const kind = 'testString';
        const account = 'testString';
        const include = 'testString';
        const q = 'testString';
        const sortBy = 'testString';
        const descending = 'testString';
        const languages = 'testString';
        const complete = 'testString';
        const params = {
          id: id,
          kind: kind,
          account: account,
          include: include,
          q: q,
          sortBy: sortBy,
          descending: descending,
          languages: languages,
          complete: complete,
        };

        const getChildObjectsResult = globalCatalog.getChildObjects(params);

        // all methods should return a Promise
        expectToBePromise(getChildObjectsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/{id}/{kind}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['account']).toEqual(account);
        expect(options.qs['include']).toEqual(include);
        expect(options.qs['q']).toEqual(q);
        expect(options.qs['sort-by']).toEqual(sortBy);
        expect(options.qs['descending']).toEqual(descending);
        expect(options.qs['languages']).toEqual(languages);
        expect(options.qs['complete']).toEqual(complete);
        expect(options.path['id']).toEqual(id);
        expect(options.path['kind']).toEqual(kind);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const id = 'testString';
        const kind = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          id,
          kind,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        globalCatalog.getChildObjects(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await globalCatalog.getChildObjects({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getChildObjectsPromise = globalCatalog.getChildObjects();
        expectToBePromise(getChildObjectsPromise);

        getChildObjectsPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('restoreCatalogEntry', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation restoreCatalogEntry
        const id = 'testString';
        const account = 'testString';
        const params = {
          id: id,
          account: account,
        };

        const restoreCatalogEntryResult = globalCatalog.restoreCatalogEntry(params);

        // all methods should return a Promise
        expectToBePromise(restoreCatalogEntryResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/{id}/restore', 'PUT');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['account']).toEqual(account);
        expect(options.path['id']).toEqual(id);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const id = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          id,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        globalCatalog.restoreCatalogEntry(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await globalCatalog.restoreCatalogEntry({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const restoreCatalogEntryPromise = globalCatalog.restoreCatalogEntry();
        expectToBePromise(restoreCatalogEntryPromise);

        restoreCatalogEntryPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getVisibility', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getVisibility
        const id = 'testString';
        const account = 'testString';
        const params = {
          id: id,
          account: account,
        };

        const getVisibilityResult = globalCatalog.getVisibility(params);

        // all methods should return a Promise
        expectToBePromise(getVisibilityResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/{id}/visibility', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['account']).toEqual(account);
        expect(options.path['id']).toEqual(id);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const id = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          id,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        globalCatalog.getVisibility(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await globalCatalog.getVisibility({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getVisibilityPromise = globalCatalog.getVisibility();
        expectToBePromise(getVisibilityPromise);

        getVisibilityPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('updateVisibility', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // Scope
      const scopeModel = {
        type: 'testString',
        value: 'testString',
      };

      // VisibilityDetailAccounts
      const visibilityDetailAccountsModel = {
        accountid: 'testString',
      };

      // VisibilityDetail
      const visibilityDetailModel = {
        accounts: visibilityDetailAccountsModel,
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation updateVisibility
        const id = 'testString';
        const restrictions = 'testString';
        const owner = scopeModel;
        const include = visibilityDetailModel;
        const exclude = visibilityDetailModel;
        const approved = true;
        const account = 'testString';
        const params = {
          id: id,
          restrictions: restrictions,
          owner: owner,
          include: include,
          exclude: exclude,
          approved: approved,
          account: account,
        };

        const updateVisibilityResult = globalCatalog.updateVisibility(params);

        // all methods should return a Promise
        expectToBePromise(updateVisibilityResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/{id}/visibility', 'PUT');
        const expectedAccept = undefined;
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['restrictions']).toEqual(restrictions);
        expect(options.body['owner']).toEqual(owner);
        expect(options.body['include']).toEqual(include);
        expect(options.body['exclude']).toEqual(exclude);
        expect(options.body['approved']).toEqual(approved);
        expect(options.qs['account']).toEqual(account);
        expect(options.path['id']).toEqual(id);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const id = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          id,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        globalCatalog.updateVisibility(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await globalCatalog.updateVisibility({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const updateVisibilityPromise = globalCatalog.updateVisibility();
        expectToBePromise(updateVisibilityPromise);

        updateVisibilityPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getPricing', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getPricing
        const id = 'testString';
        const account = 'testString';
        const params = {
          id: id,
          account: account,
        };

        const getPricingResult = globalCatalog.getPricing(params);

        // all methods should return a Promise
        expectToBePromise(getPricingResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/{id}/pricing', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['account']).toEqual(account);
        expect(options.path['id']).toEqual(id);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const id = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          id,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        globalCatalog.getPricing(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await globalCatalog.getPricing({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getPricingPromise = globalCatalog.getPricing();
        expectToBePromise(getPricingPromise);

        getPricingPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getAuditLogs', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getAuditLogs
        const id = 'testString';
        const account = 'testString';
        const ascending = 'testString';
        const startat = 'testString';
        const offset = 38;
        const limit = 38;
        const params = {
          id: id,
          account: account,
          ascending: ascending,
          startat: startat,
          offset: offset,
          limit: limit,
        };

        const getAuditLogsResult = globalCatalog.getAuditLogs(params);

        // all methods should return a Promise
        expectToBePromise(getAuditLogsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/{id}/logs', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['account']).toEqual(account);
        expect(options.qs['ascending']).toEqual(ascending);
        expect(options.qs['startat']).toEqual(startat);
        expect(options.qs['_offset']).toEqual(offset);
        expect(options.qs['_limit']).toEqual(limit);
        expect(options.path['id']).toEqual(id);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const id = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          id,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        globalCatalog.getAuditLogs(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await globalCatalog.getAuditLogs({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getAuditLogsPromise = globalCatalog.getAuditLogs();
        expectToBePromise(getAuditLogsPromise);

        getAuditLogsPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('listArtifacts', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listArtifacts
        const objectId = 'testString';
        const account = 'testString';
        const params = {
          objectId: objectId,
          account: account,
        };

        const listArtifactsResult = globalCatalog.listArtifacts(params);

        // all methods should return a Promise
        expectToBePromise(listArtifactsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/{object_id}/artifacts', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['account']).toEqual(account);
        expect(options.path['object_id']).toEqual(objectId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const objectId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          objectId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        globalCatalog.listArtifacts(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await globalCatalog.listArtifacts({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const listArtifactsPromise = globalCatalog.listArtifacts();
        expectToBePromise(listArtifactsPromise);

        listArtifactsPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getArtifact', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getArtifact
        const objectId = 'testString';
        const artifactId = 'testString';
        const account = 'testString';
        const params = {
          objectId: objectId,
          artifactId: artifactId,
          account: account,
        };

        const getArtifactResult = globalCatalog.getArtifact(params);

        // all methods should return a Promise
        expectToBePromise(getArtifactResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/{object_id}/artifacts/{artifact_id}', 'GET');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['account']).toEqual(account);
        expect(options.path['object_id']).toEqual(objectId);
        expect(options.path['artifact_id']).toEqual(artifactId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const objectId = 'testString';
        const artifactId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          objectId,
          artifactId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        globalCatalog.getArtifact(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await globalCatalog.getArtifact({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getArtifactPromise = globalCatalog.getArtifact();
        expectToBePromise(getArtifactPromise);

        getArtifactPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('uploadArtifact', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation uploadArtifact
        const objectId = 'testString';
        const artifactId = 'testString';
        const account = 'testString';
        const params = {
          objectId: objectId,
          artifactId: artifactId,
          account: account,
        };

        const uploadArtifactResult = globalCatalog.uploadArtifact(params);

        // all methods should return a Promise
        expectToBePromise(uploadArtifactResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/{object_id}/artifacts/{artifact_id}', 'PUT');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['account']).toEqual(account);
        expect(options.path['object_id']).toEqual(objectId);
        expect(options.path['artifact_id']).toEqual(artifactId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const objectId = 'testString';
        const artifactId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          objectId,
          artifactId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        globalCatalog.uploadArtifact(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await globalCatalog.uploadArtifact({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const uploadArtifactPromise = globalCatalog.uploadArtifact();
        expectToBePromise(uploadArtifactPromise);

        uploadArtifactPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deleteArtifact', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteArtifact
        const objectId = 'testString';
        const artifactId = 'testString';
        const account = 'testString';
        const params = {
          objectId: objectId,
          artifactId: artifactId,
          account: account,
        };

        const deleteArtifactResult = globalCatalog.deleteArtifact(params);

        // all methods should return a Promise
        expectToBePromise(deleteArtifactResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/{object_id}/artifacts/{artifact_id}', 'DELETE');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['account']).toEqual(account);
        expect(options.path['object_id']).toEqual(objectId);
        expect(options.path['artifact_id']).toEqual(artifactId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const objectId = 'testString';
        const artifactId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          objectId,
          artifactId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        globalCatalog.deleteArtifact(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await globalCatalog.deleteArtifact({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const deleteArtifactPromise = globalCatalog.deleteArtifact();
        expectToBePromise(deleteArtifactPromise);

        deleteArtifactPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
});
