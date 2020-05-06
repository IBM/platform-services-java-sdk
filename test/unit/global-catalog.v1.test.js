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
  checkUserHeader,
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
        featured_description: 'testString',
      };

      // OverviewUI
      const overviewUiModel = {
        foo: overviewModel,
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
        quantity: 38,
      };

      // Price
      const priceModel = {
        quantity_tier: 38,
        Price: 72.5,
      };

      // UIMetaMedia
      const uiMetaMediaModel = {
        caption: 'testString',
        thumbnail_url: 'testString',
        type: 'testString',
        URL: 'testString',
        source: bulletsModel,
      };

      // Amount
      const amountModel = {
        country: 'testString',
        currency: 'testString',
        prices: [priceModel],
      };

      // Strings
      const stringsModel = {
        bullets: [bulletsModel],
        media: [uiMetaMediaModel],
        not_creatable_msg: 'testString',
        not_creatable__robot_msg: 'testString',
        deprecation_warning: 'testString',
        popup_warning_message: 'testString',
        instruction: 'testString',
      };

      // Broker
      const brokerModel = {
        name: 'testString',
        guid: 'testString',
      };

      // DRMetaData
      const drMetaDataModel = {
        dr: true,
        description: 'testString',
      };

      // I18N
      const i18NModel = {
        foo: stringsModel,
      };

      // SourceMetaData
      const sourceMetaDataModel = {
        path: 'testString',
        type: 'testString',
        url: 'testString',
      };

      // StartingPrice
      const startingPriceModel = {
        plan_id: 'testString',
        deployment_id: 'testString',
        unit: 'testString',
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
        dashboard_url: 'testString',
        registration_url: 'testString',
        apidocsurl: 'testString',
      };

      // AliasMetaData
      const aliasMetaDataModel = {
        type: 'testString',
        plan_id: 'testString',
      };

      // CFMetaData
      const cfMetaDataModel = {
        type: 'testString',
        iam_compatible: true,
        unique_api_key: true,
        provisionable: true,
        bindable: true,
        async_provisioning_supported: true,
        async_unprovisioning_supported: true,
        requires: ['testString'],
        plan_updateable: true,
        state: 'testString',
        service_check_enabled: true,
        test_check_interval: 38,
        service_key_supported: true,
        cf_guid: { 'key1' : 'testString' },
      };

      // Callbacks
      const callbacksModel = {
        controller_url: 'testString',
        broker_url: 'testString',
        broker_proxy_url: 'testString',
        dashboard_url: 'testString',
        dashboard_data_url: 'testString',
        dashboard_detail_tab_url: 'testString',
        dashboard_detail_tab_ext_url: 'testString',
        service_monitor_api: 'testString',
        service_monitor_app: 'testString',
        api_endpoint: { 'key1' : 'testString' },
      };

      // DeploymentBase
      const deploymentBaseModel = {
        location: 'testString',
        location_url: 'testString',
        original_location: 'testString',
        target_crn: 'testString',
        service_crn: 'testString',
        mccp_id: 'testString',
        broker: brokerModel,
        supports_rc_migration: true,
        target_network: 'testString',
      };

      // PlanMetaData
      const planMetaDataModel = {
        bindable: true,
        reservable: true,
        allow_internal_users: true,
        async_provisioning_supported: true,
        async_unprovisioning_supported: true,
        test_check_interval: 38,
        single_scope_instance: 'testString',
        service_check_enabled: true,
        cf_guid: { 'key1' : 'testString' },
      };

      // PricingSet
      const pricingSetModel = {
        type: 'testString',
        origin: 'testString',
        starting_price: startingPriceModel,
      };

      // SLAMetaData
      const slaMetaDataModel = {
        terms: 'testString',
        tenancy: 'testString',
        provisioning: 'testString',
        responsiveness: 'testString',
        dr: drMetaDataModel,
      };

      // TemplateMetaData
      const templateMetaDataModel = {
        services: ['testString'],
        default_memory: 38,
        start_cmd: 'testString',
        source: sourceMetaDataModel,
        runtime_catalog_id: 'testString',
        cf_runtime_id: 'testString',
        template_id: 'testString',
        executable_file: 'testString',
        buildpack: 'testString',
        environment_variables: { 'key1' : 'testString' },
      };

      // UIMetaData
      const uiMetaDataModel = {
        strings: i18NModel,
        urls: urlsModel,
        embeddable_dashboard: 'testString',
        embeddable_dashboard_full_width: true,
        navigation_order: ['testString'],
        not_creatable: true,
        primary_offering_id: 'testString',
        accessible_during_provision: true,
        side_by_side_index: 38,
        end_of_service_time: '2019-01-01T12:00:00',
        hidden: true,
        hide_lite_metering: true,
        no_upgrade_next_step: true,
      };

      // ObjectMetadataSet
      const objectMetadataSetModel = {
        rc_compatible: true,
        service: cfMetaDataModel,
        plan: planMetaDataModel,
        alias: aliasMetaDataModel,
        template: templateMetaDataModel,
        ui: uiMetaDataModel,
        compliance: ['testString'],
        sla: slaMetaDataModel,
        callbacks: callbacksModel,
        original_name: 'testString',
        version: 'testString',
        other: { 'key1' : { foo: 'bar' } },
        pricing: pricingSetModel,
        deployment: deploymentBaseModel,
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createCatalogEntry
        const name = 'testString';
        const kind = 'service';
        const overviewUi = overviewUiModel;
        const images = imageModel;
        const disabled = true;
        const tags = ['testString'];
        const provider = providerModel;
        const id = 'testString';
        const parentId = 'testString';
        const group = true;
        const active = true;
        const metadata = objectMetadataSetModel;
        const account = 'testString';
        const params = {
          name: name,
          kind: kind,
          overviewUi: overviewUi,
          images: images,
          disabled: disabled,
          tags: tags,
          provider: provider,
          id: id,
          parentId: parentId,
          group: group,
          active: active,
          metadata: metadata,
          account: account,
        };

        const createCatalogEntryResult = globalCatalog.createCatalogEntry(params);

        // all methods should return a Promise
        expectToBePromise(createCatalogEntryResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['name']).toEqual(name);
        expect(options.body['kind']).toEqual(kind);
        expect(options.body['overview_ui']).toEqual(overviewUi);
        expect(options.body['images']).toEqual(images);
        expect(options.body['disabled']).toEqual(disabled);
        expect(options.body['tags']).toEqual(tags);
        expect(options.body['provider']).toEqual(provider);
        expect(options.body['id']).toEqual(id);
        expect(options.body['parent_id']).toEqual(parentId);
        expect(options.body['group']).toEqual(group);
        expect(options.body['active']).toEqual(active);
        expect(options.body['metadata']).toEqual(metadata);
        expect(options.qs['account']).toEqual(account);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const name = 'testString';
        const kind = 'service';
        const overviewUi = overviewUiModel;
        const images = imageModel;
        const disabled = true;
        const tags = ['testString'];
        const provider = providerModel;
        const id = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          name,
          kind,
          overviewUi,
          images,
          disabled,
          tags,
          provider,
          id,
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
        featured_description: 'testString',
      };

      // OverviewUI
      const overviewUiModel = {
        foo: overviewModel,
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
        quantity: 38,
      };

      // Price
      const priceModel = {
        quantity_tier: 38,
        Price: 72.5,
      };

      // UIMetaMedia
      const uiMetaMediaModel = {
        caption: 'testString',
        thumbnail_url: 'testString',
        type: 'testString',
        URL: 'testString',
        source: bulletsModel,
      };

      // Amount
      const amountModel = {
        country: 'testString',
        currency: 'testString',
        prices: [priceModel],
      };

      // Strings
      const stringsModel = {
        bullets: [bulletsModel],
        media: [uiMetaMediaModel],
        not_creatable_msg: 'testString',
        not_creatable__robot_msg: 'testString',
        deprecation_warning: 'testString',
        popup_warning_message: 'testString',
        instruction: 'testString',
      };

      // Broker
      const brokerModel = {
        name: 'testString',
        guid: 'testString',
      };

      // DRMetaData
      const drMetaDataModel = {
        dr: true,
        description: 'testString',
      };

      // I18N
      const i18NModel = {
        foo: stringsModel,
      };

      // SourceMetaData
      const sourceMetaDataModel = {
        path: 'testString',
        type: 'testString',
        url: 'testString',
      };

      // StartingPrice
      const startingPriceModel = {
        plan_id: 'testString',
        deployment_id: 'testString',
        unit: 'testString',
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
        dashboard_url: 'testString',
        registration_url: 'testString',
        apidocsurl: 'testString',
      };

      // AliasMetaData
      const aliasMetaDataModel = {
        type: 'testString',
        plan_id: 'testString',
      };

      // CFMetaData
      const cfMetaDataModel = {
        type: 'testString',
        iam_compatible: true,
        unique_api_key: true,
        provisionable: true,
        bindable: true,
        async_provisioning_supported: true,
        async_unprovisioning_supported: true,
        requires: ['testString'],
        plan_updateable: true,
        state: 'testString',
        service_check_enabled: true,
        test_check_interval: 38,
        service_key_supported: true,
        cf_guid: { 'key1' : 'testString' },
      };

      // Callbacks
      const callbacksModel = {
        controller_url: 'testString',
        broker_url: 'testString',
        broker_proxy_url: 'testString',
        dashboard_url: 'testString',
        dashboard_data_url: 'testString',
        dashboard_detail_tab_url: 'testString',
        dashboard_detail_tab_ext_url: 'testString',
        service_monitor_api: 'testString',
        service_monitor_app: 'testString',
        api_endpoint: { 'key1' : 'testString' },
      };

      // DeploymentBase
      const deploymentBaseModel = {
        location: 'testString',
        location_url: 'testString',
        original_location: 'testString',
        target_crn: 'testString',
        service_crn: 'testString',
        mccp_id: 'testString',
        broker: brokerModel,
        supports_rc_migration: true,
        target_network: 'testString',
      };

      // PlanMetaData
      const planMetaDataModel = {
        bindable: true,
        reservable: true,
        allow_internal_users: true,
        async_provisioning_supported: true,
        async_unprovisioning_supported: true,
        test_check_interval: 38,
        single_scope_instance: 'testString',
        service_check_enabled: true,
        cf_guid: { 'key1' : 'testString' },
      };

      // PricingSet
      const pricingSetModel = {
        type: 'testString',
        origin: 'testString',
        starting_price: startingPriceModel,
      };

      // SLAMetaData
      const slaMetaDataModel = {
        terms: 'testString',
        tenancy: 'testString',
        provisioning: 'testString',
        responsiveness: 'testString',
        dr: drMetaDataModel,
      };

      // TemplateMetaData
      const templateMetaDataModel = {
        services: ['testString'],
        default_memory: 38,
        start_cmd: 'testString',
        source: sourceMetaDataModel,
        runtime_catalog_id: 'testString',
        cf_runtime_id: 'testString',
        template_id: 'testString',
        executable_file: 'testString',
        buildpack: 'testString',
        environment_variables: { 'key1' : 'testString' },
      };

      // UIMetaData
      const uiMetaDataModel = {
        strings: i18NModel,
        urls: urlsModel,
        embeddable_dashboard: 'testString',
        embeddable_dashboard_full_width: true,
        navigation_order: ['testString'],
        not_creatable: true,
        primary_offering_id: 'testString',
        accessible_during_provision: true,
        side_by_side_index: 38,
        end_of_service_time: '2019-01-01T12:00:00',
        hidden: true,
        hide_lite_metering: true,
        no_upgrade_next_step: true,
      };

      // ObjectMetadataSet
      const objectMetadataSetModel = {
        rc_compatible: true,
        service: cfMetaDataModel,
        plan: planMetaDataModel,
        alias: aliasMetaDataModel,
        template: templateMetaDataModel,
        ui: uiMetaDataModel,
        compliance: ['testString'],
        sla: slaMetaDataModel,
        callbacks: callbacksModel,
        original_name: 'testString',
        version: 'testString',
        other: { 'key1' : { foo: 'bar' } },
        pricing: pricingSetModel,
        deployment: deploymentBaseModel,
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation updateCatalogEntry
        const id = 'testString';
        const name = 'testString';
        const kind = 'service';
        const overviewUi = overviewUiModel;
        const images = imageModel;
        const disabled = true;
        const tags = ['testString'];
        const provider = providerModel;
        const parentId = 'testString';
        const group = true;
        const active = true;
        const metadata = objectMetadataSetModel;
        const account = 'testString';
        const move = 'testString';
        const params = {
          id: id,
          name: name,
          kind: kind,
          overviewUi: overviewUi,
          images: images,
          disabled: disabled,
          tags: tags,
          provider: provider,
          parentId: parentId,
          group: group,
          active: active,
          metadata: metadata,
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
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['name']).toEqual(name);
        expect(options.body['kind']).toEqual(kind);
        expect(options.body['overview_ui']).toEqual(overviewUi);
        expect(options.body['images']).toEqual(images);
        expect(options.body['disabled']).toEqual(disabled);
        expect(options.body['tags']).toEqual(tags);
        expect(options.body['provider']).toEqual(provider);
        expect(options.body['parent_id']).toEqual(parentId);
        expect(options.body['group']).toEqual(group);
        expect(options.body['active']).toEqual(active);
        expect(options.body['metadata']).toEqual(metadata);
        expect(options.qs['account']).toEqual(account);
        expect(options.qs['move']).toEqual(move);
        expect(options.path['id']).toEqual(id);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const id = 'testString';
        const name = 'testString';
        const kind = 'service';
        const overviewUi = overviewUiModel;
        const images = imageModel;
        const disabled = true;
        const tags = ['testString'];
        const provider = providerModel;
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          id,
          name,
          kind,
          overviewUi,
          images,
          disabled,
          tags,
          provider,
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
  describe('deleteCatalogEntry', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteCatalogEntry
        const id = 'testString';
        const account = 'testString';
        const force = true;
        const params = {
          id: id,
          account: account,
          force: force,
        };

        const deleteCatalogEntryResult = globalCatalog.deleteCatalogEntry(params);

        // all methods should return a Promise
        expectToBePromise(deleteCatalogEntryResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/{id}', 'DELETE');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['account']).toEqual(account);
        expect(options.qs['force']).toEqual(force);
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

        globalCatalog.deleteCatalogEntry(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await globalCatalog.deleteCatalogEntry({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const deleteCatalogEntryPromise = globalCatalog.deleteCatalogEntry();
        expectToBePromise(deleteCatalogEntryPromise);

        deleteCatalogEntryPromise.catch(err => {
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

      // VisibilityDetailAccounts
      const visibilityDetailAccountsModel = {
        _accountid_: 'testString',
      };

      // VisibilityDetail
      const visibilityDetailModel = {
        accounts: visibilityDetailAccountsModel,
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation updateVisibility
        const id = 'testString';
        const extendable = true;
        const include = visibilityDetailModel;
        const exclude = visibilityDetailModel;
        const account = 'testString';
        const params = {
          id: id,
          extendable: extendable,
          include: include,
          exclude: exclude,
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
        expect(options.body['extendable']).toEqual(extendable);
        expect(options.body['include']).toEqual(include);
        expect(options.body['exclude']).toEqual(exclude);
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
        const accept = 'testString';
        const account = 'testString';
        const params = {
          objectId: objectId,
          artifactId: artifactId,
          accept: accept,
          account: account,
        };

        const getArtifactResult = globalCatalog.getArtifact(params);

        // all methods should return a Promise
        expectToBePromise(getArtifactResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/{object_id}/artifacts/{artifact_id}', 'GET');
        const expectedAccept = accept;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Accept', accept);
        expect(options.qs['account']).toEqual(account);
        expect(options.path['object_id']).toEqual(objectId);
        expect(options.path['artifact_id']).toEqual(artifactId);
        expect(options.responseType).toBe('stream');
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
        const artifact = Buffer.from('This is a mock file.');
        const contentType = 'testString';
        const account = 'testString';
        const params = {
          objectId: objectId,
          artifactId: artifactId,
          artifact: artifact,
          contentType: contentType,
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
        const expectedContentType = contentType;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Content-Type', contentType);
        expect(options.body).toEqual(artifact);
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
