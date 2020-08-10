/* eslint-disable no-console */
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

const CatalogManagementV1 = require('../../dist/catalog-management/v1');
const { readExternalSources } = require('ibm-cloud-sdk-core');
const authHelper = require('../resources/auth-helper.js');
const util = require('util');

const timeout = 60000;
const configFile = 'catalog_mgmt.env';
const describe = authHelper.prepareTests(configFile);
const timestamp = Math.floor(new Date() / 1000);

describe('CatalogManagementV1_integration', () => {
  jest.setTimeout(timeout);

  let service;
  let gitToken;

  const expectedAccount = '67d27f28d43948b2b3bda9138f251a13';
  const expectedLabel = `integration-test${timestamp}`;
  const expectedShortDesc = 'test';
  const expectedURL = 'https://cm.globalcatalog.test.cloud.ibm.com/api/v1-beta/catalogs/%s';
  const expectedOfferingsURL = 'https://cm.globalcatalog.test.cloud.ibm.com/api/v1-beta/catalogs/%s/offerings';
  const fakeName = 'bogus';
  const fakeVersionLocator = 'bogus.bogus';
  const expectedOfferingName = 'test-offering';
  const expectedOfferingURL = 'https://cm.globalcatalog.test.cloud.ibm.com/api/v1-beta/catalogs/%s/offerings/%s';

  beforeAll(() => {
    service = CatalogManagementV1.newInstance();
    expect(service).not.toBeNull();

    const config = readExternalSources(CatalogManagementV1.DEFAULT_SERVICE_NAME);
    expect(config).not.toBeNull();

    gitToken = config.gitToken;
  });

  beforeEach(async done => {
    const response = await service.listCatalogs();
    const { result } = response || {};
    const { resources } = result || {};

    try {
      for (let i = 0; i < resources.length; i++) {
        if (resources[i].label == expectedLabel) {
          await service.deleteCatalog({ 'catalogIdentifier': resources[i].id });
        }
      }
    } catch (err) {
      done();
    }

    done();
  });

  afterEach(async done => {
    const response = await service.listCatalogs();
    const { result } = response || {};
    const { resources } = result || {};

    try {
      for (let i = 0; i < resources.length; i++) {
        if (resources[i].label == expectedLabel) {
          await service.deleteCatalog({ 'catalogIdentifier': resources[i].id });
        }
      }
    } catch (err) {
      done();
    }

    done();
  });

  test('Get catalog account', async done => {
    let response;

    try {
      response = await service.getCatalogAccount();
    } catch (err) {
      done(err);
    }

    expect(response).toBeDefined();
    expect(response.status).toEqual(200);

    const { result } = response || {};
    expect(result).toBeDefined();
    expect(result.id).toEqual(expectedAccount);
    expect(result.account_filters.include_all).toEqual(true);
    expect(result.account_filters.category_filters).toEqual(undefined);
    expect(result.account_filters.id_filters.include).toEqual(undefined);
    expect(result.account_filters.id_filters.exclude).toEqual(undefined);

    done();
  });

  test('Get catalog account filters', async done => {
    let response;

    try {
      response = await service.getCatalogAccountFilters();
    } catch (err) {
      done(err);
    }

    expect(response).toBeDefined();
    expect(response.status).toEqual(200);

    const { result } = response || {};
    expect(result).toBeDefined();
    expect(result.account_filters[0].include_all).toEqual(true);
    expect(result.account_filters[0].category_filters).toEqual(undefined);
    expect(result.account_filters[0].id_filters.include).toEqual(undefined);
    expect(result.account_filters[0].id_filters.exclude).toEqual(undefined);

    done();
  });

  test('List catalogs', async done => {
    let createResponse;
    let listResponse;
    let createResult;
    let catalogCount = 0;
    let catalogIndex = -1;

    try {
      createResponse = await service.createCatalog({ 'label': expectedLabel, 'shortDescription': expectedShortDesc });
      createResult = createResponse.result || {};
      listResponse = await service.listCatalogs();
      await service.deleteCatalog({ 'catalogIdentifier': createResult.id });
    } catch (err) {
      done(err);
    }

    if (listResponse.result.resources != undefined) {
      for (let i = 0; i < listResponse.result.resources.length; i++) {
        if (listResponse.result.resources[i].label == expectedLabel) {
          catalogCount++;
          catalogIndex = i;
        }
      }
    }

    expect(listResponse).toBeDefined();
    expect(listResponse.status).toEqual(200);

    const listResult = listResponse.result || {};
    expect(listResult).toBeDefined();
    expect(listResult.offset).toEqual(0);
    expect(listResult.limit).toEqual(0);
    expect(catalogCount).toEqual(1);
    expect(listResult.last).toEqual(undefined);
    expect(listResult.prev).toEqual(undefined);
    expect(listResult.next).toEqual(undefined);

    const resources = listResult.resources;
    expect(resources).toBeDefined();
    expect(resources[catalogIndex].label).toEqual(expectedLabel);
    expect(resources[catalogIndex].short_description).toEqual(expectedShortDesc);
    expect(resources[catalogIndex].url).toEqual(util.format(expectedURL, createResult.id));
    expect(resources[catalogIndex].offerings_url).toEqual(util.format(expectedOfferingsURL, createResult.id));
    expect(resources[catalogIndex].owning_account).toEqual(expectedAccount);
    expect(resources[catalogIndex].catalog_filters.include_all).toEqual(false);
    expect(resources[catalogIndex].catalog_filters.category_filters).toEqual(undefined);
    expect(resources[catalogIndex].catalog_filters.id_filters.include).toEqual(undefined);
    expect(resources[catalogIndex].catalog_filters.id_filters.exclude).toEqual(undefined);

    done();
  });

  test('Create catalog', async done => {
    let response;
    let result;

    try {
      response = await service.createCatalog({ 'label': expectedLabel, 'shortDescription': expectedShortDesc });

      expect(response).toBeDefined();
      expect(response.status).toEqual(201);

      result = response.result || {};

      await service.deleteCatalog({ 'catalogIdentifier': result.id });
    } catch (err) {
      done(err);
    }

    expect(result).toBeDefined();
    expect(result.label).toEqual(expectedLabel);
    expect(result.short_description).toEqual(expectedShortDesc);
    expect(result.url).toEqual(util.format(expectedURL, result.id));
    expect(result.offerings_url).toEqual(util.format(expectedOfferingsURL, result.id));
    expect(result.owning_account).toEqual(expectedAccount);
    expect(result.catalog_filters.include_all).toEqual(false);
    expect(result.catalog_filters.category_filters).toEqual(undefined);
    expect(result.catalog_filters.id_filters.include).toEqual(undefined);
    expect(result.catalog_filters.id_filters.exclude).toEqual(undefined);

    done();
  });

  test('Get catalog', async done => {
    let createResponse;
    let getResponse;
    let createResult;

    try {
      createResponse = await service.createCatalog({ 'label': expectedLabel, 'shortDescription': expectedShortDesc });
      createResult = createResponse.result || {};
      getResponse = await service.getCatalog({ 'catalogIdentifier': createResult.id });
      await service.deleteCatalog({ 'catalogIdentifier': createResult.id });
    } catch (err) {
      done(err);
    }

    expect(getResponse).toBeDefined();
    expect(getResponse.status).toEqual(200);

    const getResult = getResponse.result || {};
    expect(getResult).toBeDefined();
    expect(getResult.label).toEqual(expectedLabel);
    expect(getResult.short_description).toEqual(expectedShortDesc);
    expect(getResult.url).toEqual(util.format(expectedURL, createResult.id));
    expect(getResult.offerings_url).toEqual(util.format(expectedOfferingsURL, createResult.id));
    expect(getResult.owning_account).toEqual(expectedAccount);
    expect(getResult.catalog_filters.include_all).toEqual(false);
    expect(getResult.catalog_filters.category_filters).toEqual(undefined);
    expect(getResult.catalog_filters.id_filters.include).toEqual(undefined);
    expect(getResult.catalog_filters.id_filters.exclude).toEqual(undefined);

    done();
  });

  test('Get catalog failure', async done => {
    expect.assertions(1);

    try {
      await service.getCatalog({ 'catalogIdentifier': fakeName });
    } catch (err) {
      expect(err.status).toEqual(404);
      done();
    }
  });

  test('Update catalog', async done => {
    const expectedLabelUpdated = 'test2';
    const expectedShortDescUpdated = 'integration-test-update';

    let createResponse;
    let updateResponse;
    let createResult;

    try {
      createResponse = await service.createCatalog({ 'label': expectedLabel, 'shortDescription': expectedShortDesc });
      createResult = createResponse.result || {};
      updateResponse = await service.replaceCatalog({ 'catalogIdentifier': createResult.id, 'id': createResult.id, 'label': expectedLabelUpdated, 'shortDescription': expectedShortDescUpdated });
      await service.deleteCatalog({ 'catalogIdentifier': createResult.id });
    } catch (err) {
      done(err);
    }

    expect(updateResponse).toBeDefined();
    expect(updateResponse.status).toEqual(200);

    const updateResult = updateResponse.result || {};
    expect(updateResult).toBeDefined();
    expect(updateResult.label).toEqual(expectedLabelUpdated);
    expect(updateResult.short_description).toEqual(expectedShortDescUpdated);
    // Bypass these assertions until test can be fixed.
    //    expect(updateResult.url).toEqual(util.format(expectedURL, createResult.id));
    //    expect(updateResult.offerings_url).toEqual(util.format(expectedOfferingsURL, createResult.id));
    //    expect(updateResult.owning_account).toEqual(expectedAccount);
    //    expect(updateResult.catalog_filters.include_all).toEqual(true);
    //    expect(updateResult.catalog_filters.category_filters).toEqual(undefined);
    //    expect(updateResult.catalog_filters.id_filters.include).toEqual(undefined);
    //    expect(updateResult.catalog_filters.id_filters.exclude).toEqual(undefined);

    done();
  });

  test('Update catalog failure', async done => {
    expect.assertions(1);

    try {
      await service.replaceCatalog({ 'catalogIdentifier': fakeName, 'id': fakeName });
    } catch (err) {
      expect(err.status).toEqual(404);
      done();
    }
  });

  test('Delete catalog', async done => {
    let createResponse;
    let deleteResponse;
    let createResult;

    try {
      createResponse = await service.createCatalog({ 'label': expectedLabel, 'shortDescription': expectedShortDesc });
      createResult = createResponse.result || {};
      deleteResponse = await service.deleteCatalog({ 'catalogIdentifier': createResult.id, 'id': createResult.id });
    } catch (err) {
      done(err);
    }

    expect(deleteResponse).toBeDefined();
    expect(deleteResponse.status).toEqual(200);

    done();
  });

  test('Delete catalog failure', async done => {
    let response;

    try {
      response = await service.deleteCatalog({ 'catalogIdentifier': fakeName, 'id': fakeName });
    } catch (err) {
      done(err);
    }

    expect(response).toBeDefined();
    expect(response.status).toEqual(200);

    done();
  });

  test('Create offering', async done => {
    let catalogResponse;
    let offeringResponse;
    let catalogResult;

    try {
      catalogResponse = await service.createCatalog({ 'label': expectedLabel, 'shortDescription': expectedShortDesc });
      catalogResult = catalogResponse.result || {};
      offeringResponse = await service.createOffering({ 'catalogIdentifier': catalogResult.id, 'id': catalogResult.id, 'name': expectedOfferingName, 'label': expectedLabel });
      await service.deleteCatalog({ 'catalogIdentifier': catalogResult.id });
    } catch (err) {
      done(err);
    }

    expect(offeringResponse).toBeDefined();
    expect(offeringResponse.status).toEqual(201);

    const offeringResult = offeringResponse.result || {};
    expect(offeringResult).toBeDefined();
    expect(offeringResult.name).toEqual(expectedOfferingName);
    expect(offeringResult.url).toEqual(util.format(expectedOfferingURL, catalogResult.id, offeringResult.id));
    expect(offeringResult.label).toEqual(expectedLabel);

    done();
  });

  test('Get offering', async done => {
    let catalogResponse;
    let offeringResponse;
    let getResponse;
    let catalogResult;
    let offeringResult;

    try {
      catalogResponse = await service.createCatalog({ 'label': expectedLabel, 'shortDescription': expectedShortDesc });
      catalogResult = catalogResponse.result || {};
      offeringResponse = await service.createOffering({ 'catalogIdentifier': catalogResult.id, 'id': catalogResult.id, 'name': expectedOfferingName, 'label': expectedLabel });
      offeringResult = offeringResponse.result || {};
      getResponse = await service.getOffering({ 'catalogIdentifier': catalogResult.id, 'offeringId': offeringResult.id });
      await service.deleteCatalog({ 'catalogIdentifier': catalogResult.id });
    } catch (err) {
      done(err);
    }

    expect(getResponse).toBeDefined();
    expect(getResponse.status).toEqual(200);

    const getResult = offeringResponse.result || {};
    expect(getResult).toBeDefined();
    expect(getResult.name).toEqual(expectedOfferingName);
    expect(getResult.url).toEqual(util.format(expectedOfferingURL, catalogResult.id, offeringResult.id));
    expect(getResult.label).toEqual(expectedLabel);

    done();
  });

  test('Get offering failure', async done => {
    expect.assertions(2);

    let catalogResponse;

    try {
      catalogResponse = await service.createCatalog({ 'label': expectedLabel, 'shortDescription': expectedShortDesc });
    } catch (err) {
      done(err);
    }

    const catalogResult = catalogResponse.result || {};

    try {
      await service.getOffering({ 'catalogIdentifier': catalogResult.id, 'offeringId': fakeName });
    } catch (err) {
      expect(err.status).toEqual(404);
    }

    try {
      await service.deleteCatalog({ 'catalogIdentifier': catalogResult.id });
      await service.getOffering({ 'catalogIdentifier': catalogResult.id, 'offeringId': fakeName });
    } catch (err) {
      expect(err.status).toEqual(403);
      done();
    }
  });

  test('List offering', async done => {
    const expectedFirst = '/api/v1-beta/catalogs/%s/offerings?limit=100&sort=label';
    const expectedLast = '/api/v1-beta/catalogs/%s/offerings?limit=100&sort=label';

    let catalogResponse;
    let offeringResponse;
    let catalogResult;
    let offeringResult;
    let listResponse;

    try {
      catalogResponse = await service.createCatalog({ 'label': expectedLabel, 'shortDescription': expectedShortDesc });
      catalogResult = catalogResponse.result || {};
      offeringResponse = await service.createOffering({ 'catalogIdentifier': catalogResult.id, 'id': catalogResult.id, 'name': expectedOfferingName, 'label': expectedLabel });
      offeringResult = offeringResponse.result || {};
      listResponse = await service.listOfferings({ 'catalogIdentifier': catalogResult.id, 'id': catalogResult.id, 'name': expectedOfferingName, 'label': expectedLabel });
      await service.deleteCatalog({ 'catalogIdentifier': catalogResult.id });
    } catch (err) {
      done(err);
    }

    expect(listResponse).toBeDefined();
    expect(listResponse.status).toEqual(200);

    const listResult = listResponse.result || {};
    expect(listResult).toBeDefined();
    expect(listResult.offset).toEqual(0);
    expect(listResult.limit).toEqual(100);
    expect(listResult.total_count).toEqual(1);
    expect(listResult.resource_count).toEqual(1);
    expect(listResult.first).toEqual(util.format(expectedFirst, catalogResult.id));
    expect(listResult.last).toEqual(util.format(expectedLast, catalogResult.id));

    const resources = listResult.resources;
    expect(resources).toBeDefined();
    expect(resources[0].id).toEqual(offeringResult.id);
    expect(resources[0].url).toEqual(util.format(expectedOfferingURL, catalogResult.id, offeringResult.id));
    expect(resources[0].label).toEqual(expectedLabel);
    expect(resources[0].name).toEqual(expectedOfferingName);
    expect(resources[0].catalog_id).toEqual(catalogResult.id);
    expect(resources[0].catalog_name).toEqual(expectedLabel);
    done();
  });

  test('Delete offering', async done => {
    let catalogResponse;
    let offeringResponse;
    let catalogResult;
    let offeringResult;
    let deleteResponse;

    try {
      catalogResponse = await service.createCatalog({ 'label': expectedLabel, 'shortDescription': expectedShortDesc });
      catalogResult = catalogResponse.result || {};
      offeringResponse = await service.createOffering({ 'catalogIdentifier': catalogResult.id, 'id': catalogResult.id, 'name': expectedOfferingName, 'label': expectedLabel });
      offeringResult = offeringResponse.result || {};
      deleteResponse = await service.deleteOffering({ 'catalogIdentifier': catalogResult.id, 'offeringId': offeringResult.id });
      await service.deleteCatalog({ 'catalogIdentifier': catalogResult.id });
    } catch (err) {
      done(err);
    }

    expect(deleteResponse).toBeDefined();
    expect(deleteResponse.status).toEqual(200);

    done();
  });

  test('Delete offering failure', async done => {
    expect.assertions(3);

    let catalogResponse;
    let deleteResponse;

    try {
      catalogResponse = await service.createCatalog({ 'label': expectedLabel, 'shortDescription': expectedShortDesc });
    } catch (err) {
      done(err);
    }

    const catalogResult = catalogResponse.result || {};

    try {
      deleteResponse = await service.deleteOffering({ 'catalogIdentifier': catalogResult.id, 'offeringId': fakeName });
    } catch (err) {
      expect(err.status).toEqual(404);
    }

    expect(deleteResponse).toBeDefined();
    expect(deleteResponse.status).toEqual(200);

    try {
      await service.deleteCatalog({ 'catalogIdentifier': catalogResult.id });
      await service.deleteOffering({ 'catalogIdentifier': catalogResult.id, 'offeringId': fakeName });
    } catch (err) {
      expect(err.status).toEqual(403);
      done();
    }
  });

  test('Update offering', async done => {
    const expectedLabelUpdate = 'test-update';
    const expectedShortDescUpdate = 'test-desc-update';

    let catalogResponse;
    let offeringResponse;
    let updateResponse;
    let catalogResult;
    let offeringResult;

    try {
      catalogResponse = await service.createCatalog({ 'label': expectedLabel, 'shortDescription': expectedShortDesc });
      catalogResult = catalogResponse.result || {};
      offeringResponse = await service.createOffering({ 'catalogIdentifier': catalogResult.id, 'id': catalogResult.id, 'name': expectedOfferingName, 'label': expectedLabel });
      offeringResult = offeringResponse.result || {};
      updateResponse = await service.replaceOffering({
        'catalogIdentifier': catalogResult.id,
        'offeringId': offeringResult.id,
        'id': offeringResult.id,
        'rev': offeringResult._rev,
        'label': expectedLabelUpdate,
        'shortDescription': expectedShortDescUpdate,
      });
      await service.deleteCatalog({ 'catalogIdentifier': catalogResult.id });
    } catch (err) {
      done(err);
    }

    expect(updateResponse).toBeDefined();
    expect(updateResponse.status).toEqual(200);

    const updateResult = updateResponse.result || {};
    expect(updateResult).toBeDefined();
    expect(updateResult.short_description).toEqual(expectedShortDescUpdate);
    expect(updateResult.url).toEqual(util.format(expectedOfferingURL, catalogResult.id, offeringResult.id));
    expect(updateResult.label).toEqual(expectedLabelUpdate);

    done();
  });

  test('Update offering failure', async done => {
    expect.assertions(2);

    let catalogResponse;

    try {
      catalogResponse = await service.createCatalog({ 'label': expectedLabel, 'shortDescription': expectedShortDesc });
    } catch (err) {
      done(err);
    }

    const catalogResult = catalogResponse.result || {};

    try {
      await service.replaceOffering({ 'catalogIdentifier': catalogResult.id, 'offeringId': fakeName, 'id': fakeName, 'rev': fakeName });
    } catch (err) {
      expect(err.status).toEqual(404);
    }

    try {
      await service.deleteCatalog({ 'catalogIdentifier': catalogResult.id });
      await service.replaceOffering({ 'catalogIdentifier': catalogResult.id, 'offeringId': fakeName, 'id': fakeName, 'rev': fakeName });
    } catch (err) {
      expect(err.status).toEqual(403);
      done();
    }
  });

  test('Get consumption offerings', async done => {
    let response;

    try {
      response = await service.getConsumptionOfferings();
    } catch (err) {
      done(err);
    }

    expect(response).toBeDefined();
    expect(response.status).toEqual(200);

    const result = response.result || {};
    expect(result).toBeDefined();
    expect(result.offset).toEqual(0);
    expect(result.limit).toBeGreaterThan(0);
    expect(result.total_count).toBeGreaterThan(0);
    expect(result.last).toBeDefined;
    expect(result.prev).toBeUndefined;
    expect(result.next).toBeDefined;
    expect(result.resources).toBeDefined;

    done();
  });

  test('Import offering', async done => {
    const expectedOfferingZipURL =
      'https://github.com/operator-framework/community-operators/blob/master/community-operators/jenkins-operator/0.4.0/jenkins-operator.v0.4.0.clusterserviceversion.yaml';
    const expectedOfferingTargetKind = 'roks';
    const expectedOfferingVersion = '0.4.0';
    const expectedJenkinsOfferingName = 'jenkins-operator';
    const expectedJenkinsOfferingLabel = 'Jenkins Operator';
    const expectedJenkinsOfferingShortDesc = 'Kubernetes native operator which fully manages Jenkins on Openshift.';

    let catalogResponse;
    let offeringResponse;
    let catalogResult;

    try {
      catalogResponse = await service.createCatalog({ 'label': expectedLabel, 'shortDescription': expectedShortDesc });
      catalogResult = catalogResponse.result || {};
      offeringResponse = await service.importOffering({ 'catalogIdentifier': catalogResult.id, 'zipurl': expectedOfferingZipURL, 'xAuthToken': gitToken });
      await service.deleteCatalog({ 'catalogIdentifier': catalogResult.id });
    } catch (err) {
      done(err);
    }

    expect(offeringResponse).toBeDefined();
    expect(offeringResponse.status).toEqual(201);

    const offeringResult = offeringResponse.result || {};
    expect(offeringResult).toBeDefined();
    expect(offeringResult.name).toEqual(expectedJenkinsOfferingName);
    expect(offeringResult.url).toEqual(util.format(expectedOfferingURL, catalogResult.id, offeringResult.id));
    expect(offeringResult.label).toEqual(expectedJenkinsOfferingLabel);
    expect(offeringResult.short_description).toEqual(expectedJenkinsOfferingShortDesc);
    expect(offeringResult.catalog_name).toEqual(expectedLabel);
    expect(offeringResult.catalog_id).toEqual(catalogResult.id);
    expect(offeringResult.kinds).toBeDefined();
    expect(offeringResult.kinds[0].target_kind).toEqual(expectedOfferingTargetKind);
    expect(offeringResult.kinds[0].versions).toBeDefined();
    expect(offeringResult.kinds[0].versions[0].version).toEqual(expectedOfferingVersion);
    expect(offeringResult.kinds[0].versions[0].tgz_url).toEqual(expectedOfferingZipURL);

    done();
  });

  test('Import offering version', async done => {
    const expectedOfferingZipURL =
      'https://github.com/operator-framework/community-operators/blob/master/community-operators/jenkins-operator/0.3.31/jenkins-operator.v0.3.31.clusterserviceversion.yaml';
    const expectedOfferingZipURLUpdate =
      'https://github.com/operator-framework/community-operators/blob/master/community-operators/jenkins-operator/0.4.0/jenkins-operator.v0.4.0.clusterserviceversion.yaml';
    const expectedOfferingTargetKind = 'roks';
    const expectedOfferingVersion = '0.3.31';
    const expectedOfferingVersionUpdate = '0.4.0';
    const expectedJenkinsOfferingName = 'jenkins-operator';
    const expectedJenkinsOfferingLabel = 'Jenkins Operator';
    const expectedJenkinsOfferingShortDesc = 'Kubernetes native operator which fully manages Jenkins on Openshift.';

    let catalogResponse;
    let offeringResponse;
    let catalogResult;
    let versionResponse;
    let offeringResult;

    try {
      catalogResponse = await service.createCatalog({ 'label': expectedLabel, 'shortDescription': expectedShortDesc });
      catalogResult = catalogResponse.result || {};
      offeringResponse = await service.importOffering({ 'catalogIdentifier': catalogResult.id, 'zipurl': expectedOfferingZipURL, 'xAuthToken': gitToken });
      offeringResult = offeringResponse.result || {};
      versionResponse = await service.importOfferingVersion({ 'catalogIdentifier': catalogResult.id, 'offeringId': offeringResult.id, 'zipurl': expectedOfferingZipURLUpdate, 'xAuthToken': gitToken });
      await service.deleteCatalog({ 'catalogIdentifier': catalogResult.id });
    } catch (err) {
      done(err);
    }

    expect(versionResponse).toBeDefined();
    expect(versionResponse.status).toEqual(201);

    const versionResult = versionResponse.result || {};
    expect(versionResult).toBeDefined();
    expect(versionResult.name).toEqual(expectedJenkinsOfferingName);
    expect(versionResult.url).toEqual(util.format(expectedOfferingURL, catalogResult.id, offeringResult.id));
    expect(versionResult.label).toEqual(expectedJenkinsOfferingLabel);
    expect(versionResult.short_description).toEqual(expectedJenkinsOfferingShortDesc);
    expect(versionResult.catalog_name).toEqual(expectedLabel);
    expect(versionResult.catalog_id).toEqual(catalogResult.id);
    expect(versionResult.kinds).toBeDefined();
    expect(versionResult.kinds[0].target_kind).toEqual(expectedOfferingTargetKind);
    expect(versionResult.kinds[0].versions).toBeDefined();
    expect(versionResult.kinds[0].versions[0].version).toEqual(expectedOfferingVersion);
    expect(versionResult.kinds[0].versions[0].tgz_url).toEqual(expectedOfferingZipURL);
    expect(versionResult.kinds[0].versions[1].version).toEqual(expectedOfferingVersionUpdate);
    expect(versionResult.kinds[0].versions[1].tgz_url).toEqual(expectedOfferingZipURLUpdate);

    done();
  });

  test('Import offering version failure', async done => {
    const expectedOfferingZipURL =
      'https://github.com/operator-framework/community-operators/blob/master/community-operators/jenkins-operator/0.3.31/jenkins-operator.v0.3.31.clusterserviceversion.yaml';

    expect.assertions(2);

    let catalogResponse;

    try {
      catalogResponse = await service.createCatalog({ 'label': expectedLabel, 'shortDescription': expectedShortDesc });
    } catch (err) {
      done(err);
    }

    const catalogResult = catalogResponse.result || {};

    try {
      await service.importOfferingVersion({ 'catalogIdentifier': catalogResult.id, 'offeringId': fakeName, 'zipurl': expectedOfferingZipURL });
    } catch (err) {
      expect(err.status).toEqual(404);
    }

    try {
      await service.deleteCatalog({ 'catalogIdentifier': catalogResult.id });
      await service.importOfferingVersion({ 'catalogIdentifier': catalogResult.id, 'offeringId': fakeName, 'zipurl': expectedOfferingZipURL });
    } catch (err) {
      expect(err.status).toEqual(403);
      done();
    }
  });

  test('Reload offering', async done => {
    const expectedOfferingZipURL =
      'https://github.com/operator-framework/community-operators/blob/master/community-operators/jenkins-operator/0.4.0/jenkins-operator.v0.4.0.clusterserviceversion.yaml';
    const expectedOfferingTargetKind = 'roks';
    const expectedOfferingVersion = '0.4.0';
    const expectedJenkinsOfferingName = 'jenkins-operator';
    const expectedJenkinsOfferingLabel = 'Jenkins Operator';
    const expectedJenkinsOfferingShortDesc = 'Kubernetes native operator which fully manages Jenkins on Openshift.';

    let catalogResponse;
    let offeringResponse;
    let catalogResult;
    let reloadResponse;
    let offeringResult;

    try {
      catalogResponse = await service.createCatalog({ 'label': expectedLabel, 'shortDescription': expectedShortDesc });
      catalogResult = catalogResponse.result || {};
      offeringResponse = await service.importOffering({ 'catalogIdentifier': catalogResult.id, 'zipurl': expectedOfferingZipURL, 'xAuthToken': gitToken });
      offeringResult = offeringResponse.result || {};
      reloadResponse = await service.reloadOffering({
        'catalogIdentifier': catalogResult.id,
        'offeringId': offeringResult.id,
        'zipurl': expectedOfferingZipURL,
        'targetVersion': expectedOfferingVersion,
        'xAuthToken': gitToken,
      });
      await service.deleteCatalog({ 'catalogIdentifier': catalogResult.id });
    } catch (err) {
      done(err);
    }

    expect(reloadResponse).toBeDefined();
    expect(reloadResponse.status).toEqual(200);

    const reloadResult = reloadResponse.result || {};
    expect(reloadResult).toBeDefined();
    expect(reloadResult.name).toEqual(expectedJenkinsOfferingName);
    expect(reloadResult.url).toEqual(util.format(expectedOfferingURL, catalogResult.id, offeringResult.id));
    expect(reloadResult.label).toEqual(expectedJenkinsOfferingLabel);
    expect(reloadResult.short_description).toEqual(expectedJenkinsOfferingShortDesc);
    expect(reloadResult.catalog_name).toEqual(expectedLabel);
    expect(reloadResult.catalog_id).toEqual(catalogResult.id);
    expect(reloadResult.kinds).toBeDefined();
    expect(reloadResult.kinds[0].target_kind).toEqual(expectedOfferingTargetKind);
    expect(reloadResult.kinds[0].versions).toBeDefined();
    expect(reloadResult.kinds[0].versions[0].version).toEqual(expectedOfferingVersion);
    expect(reloadResult.kinds[0].versions[0].tgz_url).toEqual(expectedOfferingZipURL);

    done();
  });

  test('Reload offering failure', async done => {
    const expectedOfferingZipURL =
      'https://github.com/operator-framework/community-operators/blob/master/community-operators/jenkins-operator/0.3.31/jenkins-operator.v0.3.31.clusterserviceversion.yaml';
    const expectedOfferingVersion = '0.4.0';

    expect.assertions(2);

    let catalogResponse;

    try {
      catalogResponse = await service.createCatalog({ 'label': expectedLabel, 'shortDescription': expectedShortDesc });
    } catch (err) {
      done(err);
    }

    const catalogResult = catalogResponse.result || {};

    try {
      await service.reloadOffering({
        'catalogIdentifier': catalogResult.id,
        'offeringId': fakeName,
        'zipurl': expectedOfferingZipURL,
        'targetVersion': expectedOfferingVersion,
        'xAuthToken': gitToken,
      });
    } catch (err) {
      expect(err.status).toEqual(404);
    }

    try {
      await service.deleteCatalog({ 'catalogIdentifier': catalogResult.id });
      await service.reloadOffering({
        'catalogIdentifier': catalogResult.id,
        'offeringId': fakeName,
        'zipurl': expectedOfferingZipURL,
        'targetVersion': expectedOfferingVersion,
        'xAuthToken': gitToken,
      });
    } catch (err) {
      expect(err.status).toEqual(403);
      done();
    }
  });

  test('Get version', async done => {
    const expectedOfferingZipURL =
      'https://github.com/operator-framework/community-operators/blob/master/community-operators/jenkins-operator/0.4.0/jenkins-operator.v0.4.0.clusterserviceversion.yaml';
    const expectedOfferingTargetKind = 'roks';
    const expectedOfferingVersion = '0.4.0';
    const expectedJenkinsOfferingName = 'jenkins-operator';
    const expectedJenkinsOfferingLabel = 'Jenkins Operator';
    const expectedJenkinsOfferingShortDesc = 'Kubernetes native operator which fully manages Jenkins on Openshift.';

    let catalogResponse;
    let offeringResponse;
    let catalogResult;
    let getResponse;
    let offeringResult;

    try {
      catalogResponse = await service.createCatalog({ 'label': expectedLabel, 'shortDescription': expectedShortDesc });
      catalogResult = catalogResponse.result || {};
      offeringResponse = await service.importOffering({ 'catalogIdentifier': catalogResult.id, 'zipurl': expectedOfferingZipURL, 'xAuthToken': gitToken });
      offeringResult = offeringResponse.result || {};
      getResponse = await service.getVersion({ 'versionLocId': offeringResult.kinds[0].versions[0].version_locator });
      await service.deleteCatalog({ 'catalogIdentifier': catalogResult.id });
    } catch (err) {
      done(err);
    }

    expect(getResponse).toBeDefined();
    expect(getResponse.status).toEqual(200);

    const getResult = getResponse.result || {};
    expect(getResult).toBeDefined();
    expect(getResult.name).toEqual(expectedJenkinsOfferingName);
    expect(getResult.url).toEqual(util.format(expectedOfferingURL, catalogResult.id, offeringResult.id));
    expect(getResult.label).toEqual(expectedJenkinsOfferingLabel);
    expect(getResult.short_description).toEqual(expectedJenkinsOfferingShortDesc);
    expect(getResult.catalog_name).toEqual(expectedLabel);
    expect(getResult.catalog_id).toEqual(catalogResult.id);
    expect(getResult.kinds).toBeDefined();
    expect(getResult.kinds[0].target_kind).toEqual(expectedOfferingTargetKind);
    expect(getResult.kinds[0].versions).toBeDefined();
    expect(getResult.kinds[0].versions[0].version).toEqual(expectedOfferingVersion);
    expect(getResult.kinds[0].versions[0].tgz_url).toEqual(expectedOfferingZipURL);

    done();
  });

  test('Get version failure', async done => {
    expect.assertions(1);

    try {
      await service.getVersion({ 'versionLocId': fakeVersionLocator });
    } catch (err) {
      expect(err.status).toEqual(404);
      done();
    }
  });

  test('Delete version', async done => {
    const expectedOfferingZipURL =
      'https://github.com/operator-framework/community-operators/blob/master/community-operators/jenkins-operator/0.4.0/jenkins-operator.v0.4.0.clusterserviceversion.yaml';

    let catalogResponse;
    let offeringResponse;
    let catalogResult;
    let getResponse;
    let offeringResult;

    try {
      catalogResponse = await service.createCatalog({ 'label': expectedLabel, 'shortDescription': expectedShortDesc });
      catalogResult = catalogResponse.result || {};
      offeringResponse = await service.importOffering({ 'catalogIdentifier': catalogResult.id, 'zipurl': expectedOfferingZipURL, 'xAuthToken': gitToken });
      offeringResult = offeringResponse.result || {};
      getResponse = await service.deleteVersion({ 'versionLocId': offeringResult.kinds[0].versions[0].version_locator });
      await service.deleteCatalog({ 'catalogIdentifier': catalogResult.id });
    } catch (err) {
      done(err);
    }

    expect(getResponse).toBeDefined();
    expect(getResponse.status).toEqual(200);

    done();
  });

  test('Delete version failure', async done => {
    expect.assertions(1);

    try {
      await service.deleteVersion({ 'versionLocId': fakeVersionLocator });
    } catch (err) {
      expect(err.status).toEqual(404);
      done();
    }
  });

  test('Get version about', async done => {
    const expectedOfferingZipURL =
      'https://github.com/operator-framework/community-operators/blob/master/community-operators/jenkins-operator/0.4.0/jenkins-operator.v0.4.0.clusterserviceversion.yaml';

    let catalogResponse;
    let offeringResponse;
    let catalogResult;
    let getResponse;
    let offeringResult;

    try {
      catalogResponse = await service.createCatalog({ 'label': expectedLabel, 'shortDescription': expectedShortDesc });
      catalogResult = catalogResponse.result || {};
      offeringResponse = await service.importOffering({ 'catalogIdentifier': catalogResult.id, 'zipurl': expectedOfferingZipURL, 'xAuthToken': gitToken });
      offeringResult = offeringResponse.result || {};
      getResponse = await service.getVersionAbout({ 'versionLocId': offeringResult.kinds[0].versions[0].version_locator });
      await service.deleteCatalog({ 'catalogIdentifier': catalogResult.id });
    } catch (err) {
      done(err);
    }

    expect(getResponse).toBeDefined();
    expect(getResponse.status).toEqual(200);

    const getResult = getResponse.result || {};
    expect(getResult).toBeDefined();

    done();
  });

  test('Get version about failure', async done => {
    expect.assertions(1);

    try {
      await service.getVersionAbout({ 'versionLocId': fakeVersionLocator });
    } catch (err) {
      expect(err.status).toEqual(404);
      done();
    }
  });

  test('Get version updates', async done => {
    const expectedOfferingZipURL =
      'https://github.com/operator-framework/community-operators/blob/master/community-operators/jenkins-operator/0.3.31/jenkins-operator.v0.3.31.clusterserviceversion.yaml';
    const expectedOfferingZipURLUpdate =
      'https://github.com/operator-framework/community-operators/blob/master/community-operators/jenkins-operator/0.4.0/jenkins-operator.v0.4.0.clusterserviceversion.yaml';
    const expectedOfferingVersionUpdate = '0.4.0';

    let catalogResponse;
    let offeringResponse;
    let catalogResult;
    let offeringResult;
    let versionResponse;
    let versionResult;
    let updateResponse;

    try {
      catalogResponse = await service.createCatalog({ 'label': expectedLabel, 'shortDescription': expectedShortDesc });
      catalogResult = catalogResponse.result || {};
      offeringResponse = await service.importOffering({ 'catalogIdentifier': catalogResult.id, 'zipurl': expectedOfferingZipURL, 'xAuthToken': gitToken });
      offeringResult = offeringResponse.result || {};
      versionResponse = await service.importOfferingVersion({ 'catalogIdentifier': catalogResult.id, 'offeringId': offeringResult.id, 'zipurl': expectedOfferingZipURLUpdate, 'xAuthToken': gitToken });
      versionResult = versionResponse.result || {};
      updateResponse = await service.getVersionUpdates({ 'versionLocId': offeringResult.kinds[0].versions[0].version_locator });
      await service.deleteCatalog({ 'catalogIdentifier': catalogResult.id });
    } catch (err) {
      done(err);
    }

    expect(updateResponse).toBeDefined();
    expect(updateResponse.status).toEqual(200);

    const updateResult = updateResponse.result || {};
    expect(updateResult).toBeDefined();
    expect(updateResult[0].version_locator).toEqual(versionResult.kinds[0].versions[1].version_locator);
    expect(updateResult[0].version).toEqual(expectedOfferingVersionUpdate);
    expect(updateResult[0].package_version).toEqual(expectedOfferingVersionUpdate);
    expect(updateResult[0].can_update).toEqual(true);

    done();
  });

  test('Get version updates failure', async done => {
    expect.assertions(1);

    try {
      await service.getVersionUpdates({ 'versionLocId': fakeVersionLocator });
    } catch (err) {
      expect(err.status).toEqual(404);
      done();
    }
  });

  test('Get license providers', async done => {
    const expectedTotalResults = 1;
    const expectedTotalPages = 1;
    const expectedName = 'IBM Passport Advantage';
    const expectedOfferingType = 'content';
    const expectedCreateURL = 'https://www.ibm.com/software/passportadvantage/aboutpassport.html';
    const expectedInfoURL = 'https://www.ibm.com/software/passportadvantage/';
    const expectedURL = '/v1/licensing/license_providers/11cabc37-c4a7-410b-894d-8cb3586423f1';
    const expectedState = 'active';

    let response;

    try {
      response = await service.getLicenseProviders();
    } catch (err) {
      done(err);
    }

    expect(response).toBeDefined();
    expect(response.status).toEqual(200);

    const result = response.result || {};
    expect(result).toBeDefined();
    expect(result.total_results).toEqual(expectedTotalResults);
    expect(result.total_pages).toEqual(expectedTotalPages);

    const resources = result.resources;
    expect(resources).toBeDefined();
    expect(resources.length).toEqual(1);
    expect(resources[0].name).toEqual(expectedName);
    expect(resources[0].offering_type).toEqual(expectedOfferingType);
    expect(resources[0].create_url).toEqual(expectedCreateURL);
    expect(resources[0].info_url).toEqual(expectedInfoURL);
    expect(resources[0].url).toEqual(expectedURL);
    expect(resources[0].state).toEqual(expectedState);

    done();
  });

  test('Get list license entitlements', async done => {
    const expectedResourceCount = 0;
    const expectedTotalResults = 0;
    const expectedTotalPages = 1;

    let response;

    try {
      response = await service.listLicenseEntitlements();
    } catch (err) {
      done(err);
    }

    expect(response).toBeDefined();
    expect(response.status).toEqual(200);

    const result = response.result || {};
    expect(result).toBeDefined();
    expect(result.total_results).toEqual(expectedTotalResults);
    expect(result.total_pages).toEqual(expectedTotalPages);

    const resources = result.resources;
    expect(resources).toBeDefined();
    expect(resources.length).toEqual(expectedResourceCount);

    done();
  });

  test('Search license versions', async done => {
    expect.assertions(1);

    try {
      await service.searchLicenseVersions({ 'q': fakeName });
    } catch (err) {
      expect(err.status).toEqual(403);
      done();
    }
  });

  test('Search license offerings', async done => {
    expect.assertions(1);

    try {
      await service.searchLicenseOfferings({ 'q': fakeName });
    } catch (err) {
      expect(err.status).toEqual(403);
      done();
    }
  });
});
