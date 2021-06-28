/* eslint-disable no-console */
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
const { readExternalSources, getQueryParam } = require('ibm-cloud-sdk-core');
const CatalogManagementV1 = require('../../dist/catalog-management/v1');
const authHelper = require('../resources/auth-helper.js');

// testcase timeout value (200s).
const timeout = 200000;

// Location of our config file.
const configFile = 'catalog_mgmt.env';

const describe = authHelper.prepareTests(configFile);

describe('CatalogManagementV1_integration', () => {
  jest.setTimeout(timeout);

  let catalogManagementServiceAuthorized;
  let catalogManagementServiceNotAuthorized;
  let config;

  const kindVpe = 'vpe';
  const kindRoks = 'roks';

  const regionUsSouth = 'us-south';
  const namespaceNode = 'node-sdk';
  const importOfferingZipUrl =
    'https://github.com/rhm-samples/node-red-operator/blob/master/node-red-operator/bundle/0.0.2/node-red-operator.v0.0.2.clusterserviceversion.yaml';

  const bogusVersionLocatorId = 'bogus-version-locator-id';
  const bogusRevision = 'bogus-revision';

  const labelNodeSdk = 'node-sdk';
  const repoTypeGitPublic = 'git_public';

  const objectName = 'object_created_by_node_sdk10';
  const objectCrn =
    'crn:v1:bluemix:public:iam-global-endpoint:global:::endpoint:private.iam.cloud.ibm.com';

  let catalogId;
  let offeringId;
  const createdOfferingIds = [];
  let objectId;
  const createdObjectIds = [];
  let versionLocatorId;
  let offeringInstanceId;
  let refreshTokenAuthorized;
  let refreshTokenNotAuthorized;

  let accountId;
  let clusterId;
  let gitAuthToken;

  test('Initialize services', async () => {
    catalogManagementServiceAuthorized = CatalogManagementV1.newInstance({});
    catalogManagementServiceNotAuthorized = CatalogManagementV1.newInstance({
      serviceName: 'NOT_AUTHORIZED',
    });

    expect(catalogManagementServiceAuthorized).toBeDefined();
    expect(catalogManagementServiceNotAuthorized).toBeDefined();

    config = readExternalSources(CatalogManagementV1.DEFAULT_SERVICE_NAME);
    expect(config).not.toBeNull();
  });

  test('Read necessary config values', async () => {
    accountId = config.accountId;
    expect(accountId).not.toBeNull();

    clusterId = config.clusterId;
    expect(clusterId).not.toBeNull();

    gitAuthToken = config.gitAuthToken;
    expect(gitAuthToken).not.toBeNull();
  });

  test('Acquire refresh tokens for services', async () => {
    const params = {
      catalogIdentifier: 'bogus-catalog-id',
    };

    await expect(catalogManagementServiceAuthorized.getCatalog(params)).rejects.toThrow();

    const iamAuthenticator = catalogManagementServiceAuthorized.getAuthenticator();
    refreshTokenAuthorized = iamAuthenticator.getRefreshToken();
    expect(refreshTokenAuthorized).toBeDefined();

    await expect(catalogManagementServiceNotAuthorized.getCatalog(params)).rejects.toThrow();

    const iamAuthenticatorNotAuthorized = catalogManagementServiceNotAuthorized.getAuthenticator();
    refreshTokenNotAuthorized = iamAuthenticatorNotAuthorized.getRefreshToken();
    expect(refreshTokenNotAuthorized).toBeDefined();
  });

  // ====
  // Create Catalog
  // ====

  test('createCatalog() returns 400 when user is not authorized', async () => {
    const params = {
      label: labelNodeSdk,
      tags: ['node', 'sdk'],
      owningAccount: accountId,
      kind: kindVpe,
    };

    await expect(catalogManagementServiceNotAuthorized.createCatalog(params)).rejects.toMatchObject(
      { status: 400 }
    );
  });

  test('createCatalog() returns 400 when backend input validation fails', async () => {
    const params = {
      rev: bogusRevision,
      label: labelNodeSdk,
      tags: ['node', 'sdk'],
      owningAccount: accountId,
      kind: kindVpe,
    };

    await expect(catalogManagementServiceAuthorized.createCatalog(params)).rejects.toMatchObject({
      status: 400,
    });
  });

  test('createCatalog() creates a catalog', async () => {
    const params = {
      label: labelNodeSdk,
      tags: ['node', 'sdk'],
      owningAccount: accountId,
      kind: kindVpe,
    };

    const res = await catalogManagementServiceAuthorized.createCatalog(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(201);
    expect(res.result).toBeDefined();
    expect(res.result.id).not.toBeNull();
    catalogId = res.result.id;
  });

  // ====
  // Get Catalog
  // ====

  test('getCatalog() returns 404 when no such catalog', async () => {
    expect(catalogId).toBeDefined();

    const params = {
      catalogIdentifier: `invalid-${catalogId}`,
    };

    await expect(catalogManagementServiceAuthorized.getCatalog(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('getCatalog() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
    };

    await expect(catalogManagementServiceNotAuthorized.getCatalog(params)).rejects.toMatchObject({
      status: 403,
    });
  });

  test('getCatalog() returns the catalog', async () => {
    expect(catalogId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
    };

    const res = await catalogManagementServiceAuthorized.getCatalog(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
    expect(res.result.id).toBe(catalogId);
  });

  // ====
  // Replace Catalog
  // ====

  test('replaceCatalog() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      id: catalogId,
      owningAccount: accountId,
      kind: kindVpe,
    };

    await expect(
      catalogManagementServiceNotAuthorized.replaceCatalog(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('replaceCatalog() returns 400 when backend input validation fails', async () => {
    expect(catalogId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      id: `invalid-${catalogId}`,
      owningAccount: accountId,
      kind: kindVpe,
    };

    await expect(catalogManagementServiceAuthorized.replaceCatalog(params)).rejects.toMatchObject({
      status: 400,
    });
  });

  test('replaceCatalog() returns 404 when no such catalog', async () => {
    expect(catalogId).toBeDefined();

    const params = {
      catalogIdentifier: `invalid-${catalogId}`,
      id: `invalid-${catalogId}`,
      owningAccount: accountId,
      kind: kindVpe,
    };

    await expect(catalogManagementServiceAuthorized.replaceCatalog(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('replaceCatalog() updates the catalog', async () => {
    expect(catalogId).toBeDefined();

    const tags = ['node', 'sdk', 'update'];
    const params = {
      catalogIdentifier: catalogId,
      id: catalogId,
      tags,
      owningAccount: accountId,
      kind: kindVpe,
    };

    const res = await catalogManagementServiceAuthorized.replaceCatalog(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
    expect(res.result.tags).toStrictEqual(tags);
  });

  // ====
  // List Catalog
  // ====

  test('listCatalogs()', async () => {
    expect(catalogId).toBeDefined();

    const res = await catalogManagementServiceAuthorized.listCatalogs();
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();

    const result = res.result.resources.find(({ id }) => id === catalogId);
    expect(result).toBeDefined();
  });

  // ====
  // Create Offering
  // ====

  test('createOffering() returns 404 when no such catalog', async () => {
    expect(catalogId).toBeDefined();

    const params = {
      catalogIdentifier: `invalid-${catalogId}`,
    };

    await expect(catalogManagementServiceAuthorized.createOffering(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('createOffering() returns 400 when backend input validation fails', async () => {
    expect(catalogId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      catalogId,
      name: 'Offering created by node sdk',
    };

    await expect(catalogManagementServiceAuthorized.createOffering(params)).rejects.toMatchObject({
      status: 400,
    });
  });

  test('createOffering() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      id: catalogId,
      name: 'offering-created-by-node-sdk',
    };

    await expect(
      catalogManagementServiceNotAuthorized.createOffering(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('createOffering() creates an offering', async () => {
    expect(catalogId).toBeDefined();

    for (let i = 0; i < 2; i++) {
      const params = {
        catalogIdentifier: catalogId,
        label: labelNodeSdk,
        name: `offering-created-by-node-sdk-${i}`,
      };

      const res = await catalogManagementServiceAuthorized.createOffering(params);
      expect(res).toBeDefined();
      expect(res.status).toBe(201);

      expect(res.result).toBeDefined();
      expect(res.result.id).toBeDefined();
      if (offeringId === undefined) {
        offeringId = res.result.id;
      }
      createdOfferingIds.push(res.result.id);
    }
  });

  // ====
  // Get Offering
  // ====

  test('getOffering() returns 404 when no such offering', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId: `invalid-${offeringId}`,
    };

    await expect(catalogManagementServiceAuthorized.getOffering(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('getOffering() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId,
    };

    await expect(catalogManagementServiceNotAuthorized.getOffering(params)).rejects.toMatchObject({
      status: 403,
    });
  });

  test('getOffering() returns the offering', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId,
    };

    const res = await catalogManagementServiceAuthorized.getOffering(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
    expect(res.result.id).toBe(offeringId);
    expect(res.result.catalog_id).toBe(catalogId);
  });

  // ====
  // Replace Offering
  // ====

  test('replaceOffering() returns 404 when no such offering', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId: `invalid-${offeringId}`,
      id: `invalid-${offeringId}`,
      name: 'updated-offering-name-created-by-node-sdk',
      catalogId,
    };

    await expect(catalogManagementServiceAuthorized.replaceOffering(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('replaceOffering() returns 400 backend input validation fails', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId,
      id: offeringId,
      name: 'updated offering name created by node sdk',
      catalogId,
    };

    await expect(catalogManagementServiceAuthorized.replaceOffering(params)).rejects.toMatchObject({
      status: 400,
    });
  });

  test('replaceOffering() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId,
      id: offeringId,
      name: 'updated-offering-name-created-by-node-sdk',
      catalogId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.replaceOffering(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  // once the version related conflict is resolved this test requires a conflict case
  test('replaceOffering() returns 409 when conflict occurs', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId,
      id: offeringId,
      name: 'updated-offering-name-by-node-sdk',
      catalogId,
    };

    await expect(catalogManagementServiceAuthorized.replaceOffering(params)).rejects.toMatchObject({
      status: 409,
    });
  });

  // it has a version related conflict which I don't know how to resolve
  test.skip('replaceOffering() updates offering', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const updatedOfferingName = 'updated-offering-name-by-node-sdk';
    const params = {
      catalogIdentifier: catalogId,
      offeringId,
      id: offeringId,
      name: updatedOfferingName,
      catalogId,
    };

    const res = await catalogManagementServiceAuthorized.replaceOffering(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();

    expect(res.result.id).toBe(offeringId);
    expect(res.result.catalog_id).toBe(catalogId);
    expect(res.result.name).toBe(updatedOfferingName);
  });

  // ====
  // List Offerings
  // ====

  test('listOfferings() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
    };

    await expect(catalogManagementServiceNotAuthorized.listOfferings(params)).rejects.toMatchObject(
      {
        status: 403,
      }
    );
  });

  test('listOfferings() returns 400 when backend input validation fails', async () => {
    const params = {
      catalogIdentifier: catalogId,
      digest: true,
      sort: 'bogus-sort-value',
    };

    await expect(catalogManagementServiceAuthorized.listOfferings(params)).rejects.toMatchObject({
      status: 400,
    });
  });

  test('listOfferings() returns 404 when no such catalog', async () => {
    expect(catalogId).toBeDefined();

    const params = {
      catalogIdentifier: `invalid-${catalogId}`,
    };

    await expect(catalogManagementServiceAuthorized.listOfferings(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('listOfferings() returns list of offerings', async () => {
    expect(catalogId).toBeDefined();

    let offset = 0;
    const limit = 1;
    let fetch = true;
    let amountOfOfferings = 0;

    while (fetch) {
      const params = {
        catalogIdentifier: catalogId,
        limit,
        offset,
      };

      const res = await catalogManagementServiceAuthorized.listOfferings(params);
      expect(res).toBeDefined();
      expect(res.status).toBe(200);
      expect(res.result).toBeDefined();

      const offsetValue = getQueryParam(res.result.next, 'offset');

      if (offsetValue) {
        offset = offsetValue;
      } else {
        fetch = false;
      }

      if (res.result.resource_count > 0) {
        amountOfOfferings += res.result.resource_count;
      }
    }
    console.log('Amount of offerings: ', amountOfOfferings);
  });

  // ====
  // Import Offering
  // ====

  test('importOffering() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      tags: ['sdk', 'node'],
      targetKinds: [kindVpe],
      zipurl: importOfferingZipUrl,
      offeringId,
      targetVersion: '0.0.3',
      repoType: repoTypeGitPublic,
      xAuthToken: gitAuthToken,
    };

    await expect(
      catalogManagementServiceNotAuthorized.importOffering(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('importOffering() returns 400 when backend input validation fails', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      tags: ['sdk', 'node'],
      targetKinds: ['rocks'],
      zipurl: importOfferingZipUrl,
      offeringId,
      targetVersion: '0.0.2-patch',
      repoType: repoTypeGitPublic,
      xAuthToken: gitAuthToken,
    };

    await expect(catalogManagementServiceAuthorized.importOffering(params)).rejects.toMatchObject({
      status: 400,
    });
  });

  test('importOffering() returns 404 when no such catalog', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: `invalid-${catalogId}`,
      tags: ['sdk', 'node'],
      targetKinds: [kindRoks],
      zipurl: importOfferingZipUrl,
      offeringId,
      targetVersion: '0.0.2',
      repoType: repoTypeGitPublic,
      xAuthToken: gitAuthToken,
    };

    await expect(catalogManagementServiceAuthorized.importOffering(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('importOffering() imports the offering', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      tags: ['sdk', 'node'],
      targetKinds: [kindRoks],
      zipurl: importOfferingZipUrl,
      offeringId,
      targetVersion: '0.0.2',
      repoType: repoTypeGitPublic,
      xAuthToken: gitAuthToken,
    };

    const res = await catalogManagementServiceAuthorized.importOffering(params);
    expect(res).toBeDefined();
    expect(res.result).toBeDefined();
    expect(res.status).toBe(201);
    expect(res.result.kinds[0].versions[0].version_locator).toBeDefined();
    versionLocatorId = res.result.kinds[0].versions[0].version_locator;
  });

  test('importOffering() returns 409 when conflict occurs', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      tags: ['sdk', 'node'],
      targetKinds: [kindRoks],
      zipurl: importOfferingZipUrl,
      offeringId,
      targetVersion: '0.0.2',
      repoType: repoTypeGitPublic,
      xAuthToken: gitAuthToken,
    };

    await expect(catalogManagementServiceAuthorized.importOffering(params)).rejects.toMatchObject({
      status: 409,
    });
  });

  // ====
  // Reload Offering
  // ====

  test('reloadOffering() returns 404 when no such offering', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId: `invalid-${offeringId}`,
      targetVersion: '0.0.2',
      kinds: [kindRoks],
      zipurl: importOfferingZipUrl,
      repoType: repoTypeGitPublic,
    };

    await expect(catalogManagementServiceAuthorized.reloadOffering(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('reloadOffering() returns 403 when the user is not authorized', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId,
      targetVersion: '0.0.2',
      targetKinds: [kindRoks],
      zipurl: importOfferingZipUrl,
      repoType: repoTypeGitPublic,
    };

    await expect(
      catalogManagementServiceNotAuthorized.reloadOffering(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  // Error: Could not find a kind with a target/format value of roks:operator for the current offering, Code: 400
  test.skip('reloadOffering() reloads the offering', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId,
      targetVersion: '0.0.2',
      targetKinds: [kindRoks],
      zipurl: importOfferingZipUrl,
      repoType: repoTypeGitPublic,
    };

    const res = await catalogManagementServiceAuthorized.reloadOffering(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(201);
    expect(res.result).toBeDefined();
  });

  // ====
  // Create Object
  // ====

  test('createObject() returns 400 when backend validation fails', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const publishObjectModel = {
      permit_ibm_public_publish: true,
      ibm_approved: true,
      public_approved: true,
    };

    const stateModel = {
      current: 'new',
    };

    const params = {
      catalogIdentifier: catalogId,
      catalogId,
      name: objectName,
      crn: objectCrn,
      parentId: 'bogus region name',
      kind: kindVpe,
      publish: publishObjectModel,
      state: stateModel,
    };

    await expect(catalogManagementServiceAuthorized.createObject(params)).rejects.toMatchObject({
      status: 400,
    });
  });

  test('createObject() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const publishObjectModel = {
      permit_ibm_public_publish: true,
      ibm_approved: true,
      public_approved: true,
    };

    const stateModel = {
      current: 'new',
    };

    const params = {
      catalogIdentifier: catalogId,
      catalogId,
      name: objectName,
      crn: objectCrn,
      parentId: regionUsSouth,
      kind: kindVpe,
      publish: publishObjectModel,
      state: stateModel,
    };

    await expect(catalogManagementServiceNotAuthorized.createObject(params)).rejects.toMatchObject({
      status: 403,
    });
  });

  test('createObject() returns 404 when no such catalog', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const publishObjectModel = {
      permit_ibm_public_publish: true,
      ibm_approved: true,
      public_approved: true,
    };

    const stateModel = {
      current: 'new',
    };

    const params = {
      catalogIdentifier: `invalid-${catalogId}`,
      catalogId: `invalid-${catalogId}`,
      name: objectName,
      crn: objectCrn,
      parentId: regionUsSouth,
      kind: kindVpe,
      publish: publishObjectModel,
      state: stateModel,
    };

    await expect(catalogManagementServiceAuthorized.createObject(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('createObject() creates an object', async () => {
    expect(catalogId).toBeDefined();

    for (let i = 0; i < 2; i++) {
      const publishObjectModel = {
        permit_ibm_public_publish: true,
        ibm_approved: true,
        public_approved: true,
      };

      const stateModel = {
        current: 'new',
      };

      const params = {
        catalogIdentifier: catalogId,
        catalogId,
        name: `${objectName}_${i}`,
        crn: objectCrn,
        parentId: regionUsSouth,
        kind: kindVpe,
        publish: publishObjectModel,
        state: stateModel,
      };

      const res = await catalogManagementServiceAuthorized.createObject(params);
      expect(res).toBeDefined();
      expect(res.status).toBe(201);
      expect(res.result).toBeDefined();
      expect(res.result.id).toBeDefined();

      if (objectId === undefined) {
        objectId = res.result.id;
      }
      createdObjectIds.push(res.result.id);
    }
  });

  // ====
  // Get Offering Audit
  // ====

  test('getOfferingAudit() returns 200 when no such offering', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId: `invalid-${offeringId}`,
    };

    const res = await catalogManagementServiceAuthorized.getOfferingAudit(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
  });

  test('getOfferingAudit() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.getOfferingAudit(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('getOfferingAudit() returns offering audit log', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId,
    };

    const res = await catalogManagementServiceAuthorized.getOfferingAudit(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Get Catalog Account
  // ====

  test('getCatalogAccount()', async () => {
    const res = await catalogManagementServiceAuthorized.getCatalogAccount();
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
    expect(res.result.id).toBe(accountId);
  });

  // ====
  // Update Catalog Account
  // ====

  test('updateCatalogAccount() returns 400 when no such catalog account', async () => {
    const params = {
      id: `invalid-${accountId}`,
    };

    await expect(
      catalogManagementServiceAuthorized.updateCatalogAccount(params)
    ).rejects.toMatchObject({
      status: 400,
    });
  });

  test('updateCatalogAccount() returns 403 when user is not authorized', async () => {
    const params = {
      id: accountId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.updateCatalogAccount(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  // user is not granted
  test.skip('updateCatalogAccount() returns 400 when backend input validation fails', async () => {
    // a body with failing data comes here

    const params = {
      id: accountId,
    };

    const res = await catalogManagementServiceAuthorized.updateCatalogAccount(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(400);
  });

  // user is not granted
  test.skip('updateCatalogAccount() updates catalog account', async () => {
    // data

    const params = {
      id: accountId,
    };

    const res = await catalogManagementServiceAuthorized.updateCatalogAccount(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Get Catalog Account Audit
  // ====

  test('getCatalogAccountAudit() returns 403 when user is not authorized', async () => {
    await expect(
      catalogManagementServiceNotAuthorized.getCatalogAccountAudit()
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('getCatalogAccountAudit() returns audit logs', async () => {
    const res = await catalogManagementServiceAuthorized.getCatalogAccountAudit();
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Get Catalog Account Filters
  // ====

  test('getCatalogAccountFilters() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();

    const params = {
      catalog: catalogId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.getCatalogAccountFilters(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('getCatalogAccountFilters() returns 404 when no such catalog', async () => {
    expect(catalogId).toBeDefined();

    const params = {
      catalog: `invalid-${catalogId}`,
    };

    await expect(
      catalogManagementServiceAuthorized.getCatalogAccountFilters(params)
    ).rejects.toMatchObject({
      status: 404,
    });
  });

  test('getCatalogAccountFilters() returns the account filters', async () => {
    expect(catalogId).toBeDefined();

    const params = {
      catalog: catalogId,
    };

    const res = await catalogManagementServiceAuthorized.getCatalogAccountFilters(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Get Catalog Audit
  // ====

  test('getCatalogAudit() returns 404 when no such catalog', async () => {
    expect(catalogId).toBeDefined();

    const params = {
      catalogIdentifier: `invalid-${catalogId}`,
    };

    await expect(catalogManagementServiceAuthorized.getCatalogAudit(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('getCatalogAudit() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.getCatalogAudit(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('getCatalogAudit() returns the catalog audit logs', async () => {
    expect(catalogId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
    };

    const res = await catalogManagementServiceAuthorized.getCatalogAudit(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Get Consumption Offerings
  // ====

  test('getConsumptionOfferings() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();

    const params = {
      catalog: catalogId,
      select: 'all',
    };

    await expect(
      catalogManagementServiceNotAuthorized.getConsumptionOfferings(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('getConsumptionOfferings() returns 404 when no such catalog', async () => {
    expect(catalogId).toBeDefined();

    const params = {
      catalog: `invalid-${catalogId}`,
      select: 'all',
    };

    await expect(
      catalogManagementServiceAuthorized.getConsumptionOfferings(params)
    ).rejects.toMatchObject({
      status: 404,
    });
  });

  test('getConsumptionOfferings() the catalog consumption offerings', async () => {
    expect(catalogId).toBeDefined();

    const params = {
      catalog: catalogId,
      select: 'all',
    };

    const res = await catalogManagementServiceAuthorized.getConsumptionOfferings(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Import Offering Version
  // ====

  test('importOfferingVersion() returns 400 when backend input validation fails', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId,
      targetKinds: ['rocks'],
      zipurl: importOfferingZipUrl,
      targetVersion: '0.0.3',
      repoType: repoTypeGitPublic,
    };

    await expect(
      catalogManagementServiceAuthorized.importOfferingVersion(params)
    ).rejects.toMatchObject({
      status: 400,
    });
  });

  test('importOfferingVersion() returns 404 when no such offering', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId: `invalid-${offeringId}`,
      targetKinds: [kindRoks],
      zipurl: importOfferingZipUrl,
      targetVersion: '0.0.3',
      repoType: repoTypeGitPublic,
    };

    await expect(
      catalogManagementServiceAuthorized.importOfferingVersion(params)
    ).rejects.toMatchObject({
      status: 404,
    });
  });

  test('importOfferingVersion() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId,
      targetKinds: [kindRoks],
      zipurl: importOfferingZipUrl,
      targetVersion: '0.0.3',
      repoType: repoTypeGitPublic,
    };

    await expect(
      catalogManagementServiceNotAuthorized.importOfferingVersion(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('importOfferingVersion()', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId,
      targetKinds: [kindRoks],
      zipurl: importOfferingZipUrl,
      targetVersion: '0.0.3',
      repoType: repoTypeGitPublic,
    };

    const res = await catalogManagementServiceAuthorized.importOfferingVersion(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(201);
    expect(res.result).toBeDefined();
  });

  // ====
  // Replace Offering Icon
  // ====

  test.skip('replaceOfferingIcon() returns 404 when no such offerings', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId: `invalid-${offeringId}`,
      fileName: 'filename.jpg',
    };

    const res = await catalogManagementServiceAuthorized.replaceOfferingIcon(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(404);
  });

  test.skip('replaceOfferingIcon() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId,
      fileName: 'filename.jpg',
    };

    const res = await catalogManagementServiceNotAuthorized.replaceOfferingIcon(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(403);
  });

  test.skip('replaceOfferingIcon() replaces the offerings icon', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId,
      fileName: 'filename.jpg',
    };

    const res = await catalogManagementServiceAuthorized.replaceOfferingIcon(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Update Offering IBM
  // ====

  // once the user is granted for this operation this test can be executed
  test.skip('updateOfferingIbm() returns 400 when backend input validation fails', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId,
      approvalType: 'bogus approval type',
      approved: true,
    };

    await expect(
      catalogManagementServiceAuthorized.updateOfferingIbm(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  // once the user is granted for this operation this test can be executed
  test.skip('updateOfferingIbm() returns 404 when no such offering', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId: `invalid-${offeringId}`,
      approvalType: 'allow_request',
      approved: true,
    };

    await expect(
      catalogManagementServiceAuthorized.updateOfferingIbm(params)
    ).rejects.toMatchObject({
      status: 404,
    });
  });

  test('updateOfferingIbm() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId,
      approvalType: 'allow_request',
      approved: true,
    };

    await expect(
      catalogManagementServiceNotAuthorized.updateOfferingIbm(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  // this user is not permitted to execute this operation
  test.skip('updateOfferingIbm() updates offering', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId,
      approvalType: 'allow_request',
      approved: true,
    };

    const res = await catalogManagementServiceAuthorized.updateOfferingIbm(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Get Offering Updates
  // ====

  // go and python fails, this one is not...
  test.skip('getOfferingUpdates() returns 400 when backend input validation fails', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId,
      kind: 'rocks',
      version: '0.0.2',
      clusterId,
      region: regionUsSouth,
    };

    await expect(
      catalogManagementServiceAuthorized.getOfferingUpdates(params)
    ).rejects.toMatchObject({
      status: 400,
    });
  });

  // it always complaining about offering types which is somehow related to create/import offerings
  // once this is resolved there is a chance we can squeeze a 404 out from the service

  test.skip('getOfferingUpdates() returns 404 when no such offerings', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId: `invalid-${offeringId}`,
      kind: kindRoks,
      version: '0.0.2',
      clusterId,
      region: regionUsSouth,
    };

    await expect(
      catalogManagementServiceAuthorized.getOfferingUpdates(params)
    ).rejects.toMatchObject({
      status: 404,
    });
  });

  test('getOfferingUpdates() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId,
      kind: kindRoks,
      version: '0.0.2',
      clusterId,
      region: regionUsSouth,
      namespaces: namespaceNode,
    };

    await expect(
      catalogManagementServiceNotAuthorized.getOfferingUpdates(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  // requires a special offering
  // Error: Could not find kind[roks] for offering

  test.skip('getOfferingUpdates() returns offering updates', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId,
      kind: kindRoks,
      version: '0.0.2',
      clusterId,
      region: regionUsSouth,
      namespace: namespaceNode,
    };

    const res = await catalogManagementServiceAuthorized.getOfferingUpdates(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Get Offering About
  // ====

  test('getOfferingAbout() returns 400 when backend input validation fails', async () => {
    const params = {
      versionLocId: bogusVersionLocatorId,
    };

    await expect(catalogManagementServiceAuthorized.getOfferingAbout(params)).rejects.toMatchObject(
      {
        status: 400,
      }
    );
  });

  test('getOfferingAbout() returns 404 when no such version', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: `invalid-${versionLocatorId}`,
    };

    await expect(catalogManagementServiceAuthorized.getOfferingAbout(params)).rejects.toMatchObject(
      {
        status: 404,
      }
    );
  });

  test('getOfferingAbout() returns 403 when user is not authorized', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.getOfferingAbout(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('getOfferingAbout() returns offering about', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
    };

    const res = await catalogManagementServiceAuthorized.getOfferingAbout(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Get Offering License
  // ====

  test('getOfferingLicense() returns 400 when backend input validation fails', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
      licenseId: 'license-id-is-needed',
    };

    await expect(
      catalogManagementServiceAuthorized.getOfferingLicense(params)
    ).rejects.toMatchObject({
      status: 400,
    });
  });

  test('getOfferingLicense() returns 404 when no such version', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: `invalid-${versionLocatorId}`,
      licenseId: 'license-id-is-needed',
    };

    await expect(
      catalogManagementServiceAuthorized.getOfferingLicense(params)
    ).rejects.toMatchObject({
      status: 404,
    });
  });

  test.skip('getOfferingLicense() returns 403 when user is not authorized', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
      licenseId: 'license-id-is-needed',
    };

    await expect(
      catalogManagementServiceNotAuthorized.getOfferingLicense(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test.skip('getOfferingLicense() returns the offering license', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
      licenseId: 'license-id-is-needed',
    };

    const res = await catalogManagementServiceAuthorized.getOfferingLicense(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Get Offering Container Images
  // ====

  test('getOfferingContainerImages() returns 400 when backend input validation fails', async () => {
    const params = {
      versionLocId: bogusVersionLocatorId,
    };

    await expect(
      catalogManagementServiceAuthorized.getOfferingContainerImages(params)
    ).rejects.toMatchObject({
      status: 400,
    });
  });

  test('getOfferingContainerImages() returns 404 when no such version', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: `invalid-${versionLocatorId}`,
    };

    await expect(
      catalogManagementServiceAuthorized.getOfferingContainerImages(params)
    ).rejects.toMatchObject({
      status: 404,
    });
  });

  test('getOfferingContainerImages() returns 403 when user is not authorized', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.getOfferingContainerImages(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('getOfferingContainerImages() returns offering container images', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
    };

    const res = await catalogManagementServiceAuthorized.getOfferingContainerImages(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Deprecate Version
  // ====

  test('deprecateVersion() returns 404 when no such version', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: `invalid-${versionLocatorId}`,
    };

    await expect(catalogManagementServiceAuthorized.deprecateVersion(params)).rejects.toMatchObject(
      {
        status: 404,
      }
    );
  });

  test('deprecateVersion() returns 400 when backend input validation fails', async () => {
    const params = {
      versionLocId: bogusVersionLocatorId,
    };

    await expect(catalogManagementServiceAuthorized.deprecateVersion(params)).rejects.toMatchObject(
      {
        status: 400,
      }
    );
  });

  test('deprecateVersion() returns 403 when user is not authorized', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.deprecateVersion(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  // the flow of different states
  // Error: Cannot request the state deprecated from the current state new.

  test.skip('deprecateVersion() deprecates the version', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
    };

    const res = await catalogManagementServiceAuthorized.deprecateVersion(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(202);
    expect(res.result).toBeDefined();
  });

  // ====
  // Account Publish Version
  // ====

  test('accountPublishVersion() returns 400 when backend input validation fails', async () => {
    const params = {
      versionLocId: bogusVersionLocatorId,
    };

    await expect(
      catalogManagementServiceAuthorized.accountPublishVersion(params)
    ).rejects.toMatchObject({
      status: 400,
    });
  });

  test('accountPublishVersion() returns 404 when no such version', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: `invalid-${versionLocatorId}`,
    };

    await expect(
      catalogManagementServiceAuthorized.accountPublishVersion(params)
    ).rejects.toMatchObject({
      status: 404,
    });
  });

  test('accountPublishVersion() returns 403 when user is not authorized', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.accountPublishVersion(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  // the phases of different states is unknown
  // Error: Cannot request the state account-published from the current state new.

  test.skip('accountPublishVersion()', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
    };

    const res = await catalogManagementServiceAuthorized.accountPublishVersion(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(202);
    expect(res.result).toBeDefined();
  });

  // ====
  // IBM Publish Version
  // ====

  test('ibmPublishVersion() returns 400 when backend input validation fails', async () => {
    const params = {
      versionLocId: bogusVersionLocatorId,
    };

    await expect(
      catalogManagementServiceAuthorized.ibmPublishVersion(params)
    ).rejects.toMatchObject({
      status: 400,
    });
  });

  test('ibmPublishVersion() returns 404 when no such version', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: `invalid-${versionLocatorId}`,
    };

    await expect(
      catalogManagementServiceAuthorized.ibmPublishVersion(params)
    ).rejects.toMatchObject({
      status: 404,
    });
  });

  test('ibmPublishVersion() returns 403 when user is not authorized', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.ibmPublishVersion(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  // user is not allowed to publish
  test.skip('ibmPublishVersion()', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
    };

    const res = await catalogManagementServiceAuthorized.ibmPublishVersion(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(202);
    expect(res.result).toBeDefined();
  });

  // ====
  // Public Publish Version
  // ====

  test('publicPublishVersion() returns 400 when backend input validation fails', async () => {
    const params = {
      versionLocId: bogusVersionLocatorId,
    };

    await expect(
      catalogManagementServiceAuthorized.publicPublishVersion(params)
    ).rejects.toMatchObject({
      status: 400,
    });
  });

  test('publicPublishVersion() returns 404 when no such version', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: `invalid-${versionLocatorId}`,
    };

    await expect(
      catalogManagementServiceAuthorized.publicPublishVersion(params)
    ).rejects.toMatchObject({
      status: 404,
    });
  });

  test('publicPublishVersion() returns 403 when user is not authorized', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.publicPublishVersion(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test.skip('publicPublishVersion() publishes the version', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
    };

    const res = await catalogManagementServiceAuthorized.publicPublishVersion(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(202);
    expect(res.result).toBeDefined();
  });

  // ====
  // Commit Version
  // ====

  test('commitVersion() returns 400 when backend input validation fails', async () => {
    const params = {
      versionLocId: bogusVersionLocatorId,
    };

    await expect(catalogManagementServiceAuthorized.commitVersion(params)).rejects.toMatchObject({
      status: 400,
    });
  });

  test('commitVersion() returns 404 when no such version', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: `invalid-${versionLocatorId}`,
    };

    await expect(catalogManagementServiceAuthorized.commitVersion(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('commitVersion() returns 403 when user is not authorized', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
    };

    await expect(catalogManagementServiceNotAuthorized.commitVersion(params)).rejects.toMatchObject(
      {
        status: 403,
      }
    );
  });

  // workflow of versions
  // Error: Could not find a working copy for the active version with id
  test.skip('commitVersion()', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
    };

    const res = await catalogManagementServiceAuthorized.commitVersion(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Copy Version
  // ====

  test('copyVersion() returns 403 when user is not authorized', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
      targetKinds: [kindRoks],
    };

    await expect(catalogManagementServiceNotAuthorized.copyVersion(params)).rejects.toMatchObject({
      status: 403,
    });
  });

  test('copyVersion() returns 404 when no such version', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: `invalid-${versionLocatorId}`,
      targetKinds: [kindRoks],
    };

    await expect(catalogManagementServiceAuthorized.copyVersion(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('copyVersion() returns 400 when backend input validation fails', async () => {
    const params = {
      versionLocId: bogusVersionLocatorId,
      targetKinds: [kindRoks],
    };

    await expect(catalogManagementServiceAuthorized.copyVersion(params)).rejects.toMatchObject({
      status: 400,
    });
  });

  // Error: Only helm charts can be copied to a new target at this time.
  test.skip('copyVersion() copies a version', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
      targetKinds: [kindRoks],
    };

    const res = await catalogManagementServiceAuthorized.copyVersion(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Get Offering Working Copy
  // ====

  test('getOfferingWorkingCopy() returns 400 when backend input validation fails', async () => {
    const params = {
      versionLocId: bogusVersionLocatorId,
    };

    await expect(
      catalogManagementServiceAuthorized.getOfferingWorkingCopy(params)
    ).rejects.toMatchObject({
      status: 400,
    });
  });

  test('getOfferingWorkingCopy() returns 403 when user is not authorized', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.getOfferingWorkingCopy(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('getOfferingWorkingCopy() returns 404 when no such version', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: `invalid-${versionLocatorId}`,
    };

    await expect(
      catalogManagementServiceAuthorized.getOfferingWorkingCopy(params)
    ).rejects.toMatchObject({
      status: 404,
    });
  });

  // requires published state which this user cannot create
  // Error: Cannot create a working copy for version 60cb36c3-39fd-40ed-9887-6bc98aa7b7be.  The version
  // must be in a published state, deprecated state, or invalidated state to create a working copy
  test.skip('getOfferingWorkingCopy() returns the offering working copy', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
    };

    const res = await catalogManagementServiceAuthorized.getOfferingWorkingCopy(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Get Version
  // ====

  test('getVersion() returns 400 when backend input validation fails', async () => {
    const params = {
      versionLocId: bogusVersionLocatorId,
    };

    await expect(catalogManagementServiceAuthorized.getVersion(params)).rejects.toMatchObject({
      status: 400,
    });
  });

  test('getVersion() returns 404 when no such version', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: `invalid-${versionLocatorId}`,
    };

    await expect(catalogManagementServiceAuthorized.getVersion(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('getVersion() returns 403 when user is not authorized', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
    };

    await expect(catalogManagementServiceNotAuthorized.getVersion(params)).rejects.toMatchObject({
      status: 403,
    });
  });

  test('getVersion() returns the version', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
    };

    const res = await catalogManagementServiceAuthorized.getVersion(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Get Cluster
  // ====

  // possibly this user doesn't have right to execute this operation
  test.skip('getCluster() returns 403 when user is not authorized', async () => {
    const params = {
      clusterId,
      region: regionUsSouth,
      xAuthRefreshToken: refreshTokenNotAuthorized,
    };

    await expect(catalogManagementServiceNotAuthorized.getCluster(params)).rejects.toMatchObject({
      status: 401,
    });
  });

  test('getCluster() returns 404 when no such cluster', async () => {
    const params = {
      clusterId: `invalid-${clusterId}`,
      region: regionUsSouth,
      xAuthRefreshToken: refreshTokenAuthorized,
    };

    await expect(catalogManagementServiceAuthorized.getCluster(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test.skip('getCluster()', async () => {
    // possibly this user doesn't have right to get the cluster details
    // until it is not clear it is skipped

    const params = {
      clusterId,
      region: regionUsSouth,
      xAuthRefreshToken: refreshTokenAuthorized,
    };

    const res = await catalogManagementServiceAuthorized.getCluster(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Get Namespaces
  // ====

  test('getNamespaces() returns 404 when no such cluster', async () => {
    const params = {
      clusterId: `invalid-${clusterId}`,
      region: regionUsSouth,
      xAuthRefreshToken: refreshTokenAuthorized,
    };

    await expect(catalogManagementServiceAuthorized.getNamespaces(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test.skip('getNamespaces() returns 403 when user is not authorized', async () => {
    const params = {
      clusterId,
      region: regionUsSouth,
      xAuthRefreshToken: refreshTokenNotAuthorized,
    };

    await expect(catalogManagementServiceNotAuthorized.getNamespaces(params)).rejects.toMatchObject(
      {
        status: 403,
      }
    );
  });

  test.skip('getNamespaces() returns namespaces', async () => {
    const params = {
      clusterId,
      region: regionUsSouth,
      xAuthRefreshToken: refreshTokenAuthorized,
    };

    const res = await catalogManagementServiceAuthorized.getNamespaces(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Deploy Operators
  // ====

  test('deployOperators() returns 403 when user is not authorized', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      xAuthRefreshToken: refreshTokenNotAuthorized,
      clusterId,
      region: regionUsSouth,
      allNamespaces: true,
      versionLocatorId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.deployOperators(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('deployOperators() returns 404 when no such cluster', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      xAuthRefreshToken: refreshTokenAuthorized,
      clusterId: `invalid-${clusterId}`,
      region: regionUsSouth,
      allNamespaces: true,
      versionLocatorId,
    };

    await expect(catalogManagementServiceAuthorized.deployOperators(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('deployOperators() returns 400 when backend input validation fails', async () => {
    const params = {
      xAuthRefreshToken: refreshTokenAuthorized,
      clusterId,
      region: regionUsSouth,
      allNamespaces: true,
      versionLocatorId: bogusVersionLocatorId,
    };

    await expect(catalogManagementServiceAuthorized.deployOperators(params)).rejects.toMatchObject({
      status: 400,
    });
  });

  // possibly this user doesn't have right to get the cluster details
  // until it is not clear it is skipped
  // The specified cluster could not be found. If applicable, make sure that you target the correct account
  // and resource group."
  test.skip('deployOperators() deploys an operator', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      xAuthRefreshToken: refreshTokenAuthorized,
      clusterId,
      region: regionUsSouth,
      allNamespaces: true,
      versionLocatorId,
    };

    const res = await catalogManagementServiceAuthorized.deployOperators(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // List Operators
  // ====

  test('listOperators() returns 403 when user is not authorized', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      xAuthRefreshToken: refreshTokenNotAuthorized,
      clusterId,
      region: regionUsSouth,
      versionLocatorId,
    };

    await expect(catalogManagementServiceNotAuthorized.listOperators(params)).rejects.toMatchObject(
      {
        status: 403,
      }
    );
  });

  test('listOperators() returns 400 when backend input validation fails', async () => {
    const params = {
      xAuthRefreshToken: refreshTokenAuthorized,
      clusterId,
      region: regionUsSouth,
      versionLocatorId: bogusVersionLocatorId,
    };

    await expect(catalogManagementServiceAuthorized.listOperators(params)).rejects.toMatchObject({
      status: 400,
    });
  });

  test('listOperators() returns 404 when no such cluster', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      xAuthRefreshToken: refreshTokenAuthorized,
      clusterId: `invalid-${clusterId}`,
      region: regionUsSouth,
      versionLocatorId,
    };

    await expect(catalogManagementServiceAuthorized.listOperators(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  // possibly this user doesn't have right to get the cluster details
  // until it is not clear it is skipped
  // The specified cluster could not be found. If applicable, make sure that you target the correct account
  // and resource group."
  test.skip('listOperators() returns list of operators', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      xAuthRefreshToken: refreshTokenAuthorized,
      clusterId,
      region: regionUsSouth,
      versionLocatorId,
    };

    const res = await catalogManagementServiceAuthorized.listOperators(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Replace Operators
  // ====

  test('replaceOperators() returns 403 when user is not authorized', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      xAuthRefreshToken: refreshTokenNotAuthorized,
      clusterId,
      region: regionUsSouth,
      allNamespaces: true,
      versionLocatorId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.replaceOperators(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('replaceOperators() returns 404 when no such cluster', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      xAuthRefreshToken: refreshTokenAuthorized,
      clusterId: `invalid-${clusterId}`,
      region: regionUsSouth,
      allNamespaces: true,
      versionLocatorId,
    };

    await expect(catalogManagementServiceAuthorized.replaceOperators(params)).rejects.toMatchObject(
      {
        status: 404,
      }
    );
  });

  test('replaceOperators() returns 400 when backend input validation fails', async () => {
    const params = {
      xAuthRefreshToken: refreshTokenAuthorized,
      clusterId,
      region: regionUsSouth,
      versionLocatorId: bogusVersionLocatorId,
    };

    await expect(catalogManagementServiceAuthorized.replaceOperators(params)).rejects.toMatchObject(
      {
        status: 400,
      }
    );
  });

  // possibly this user doesn't have right to get the cluster details
  // until it is not clear it is skipped
  // The specified cluster could not be found. If applicable, make sure that you target the correct account
  // and resource group."
  test.skip('replaceOperators()', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      xAuthRefreshToken: refreshTokenAuthorized,
      clusterId,
      region: regionUsSouth,
      allNamespaces: true,
      versionLocatorId,
    };

    const res = await catalogManagementServiceAuthorized.replaceOperators(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Install Version
  // ====

  test('installVersion() returns 403 when user is not authorized', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
      xAuthRefreshToken: refreshTokenNotAuthorized,
      clusterId,
      region: regionUsSouth,
      versionLocatorId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.installVersion(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('installVersion() returns 404 when no such cluster', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
      xAuthRefreshToken: refreshTokenAuthorized,
      clusterId: `invalid-${clusterId}`,
      region: regionUsSouth,
      versionLocatorId,
    };

    await expect(catalogManagementServiceAuthorized.installVersion(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('installVersion() returns 400 when backend input validation fails', async () => {
    const params = {
      versionLocId: bogusVersionLocatorId,
      xAuthRefreshToken: refreshTokenAuthorized,
      clusterId,
      region: regionUsSouth,
      versionLocatorId: bogusVersionLocatorId,
    };

    await expect(catalogManagementServiceAuthorized.installVersion(params)).rejects.toMatchObject({
      status: 400,
    });
  });

  // possibly this user doesn't have right to get the cluster details
  // until it is not clear it is skipped
  // The specified cluster could not be found. If applicable, make sure that you target the correct account
  // and resource group."
  test.skip('installVersion()', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
      xAuthRefreshToken: refreshTokenAuthorized,
      clusterId,
      region: regionUsSouth,
      versionLocatorId,
    };

    const res = await catalogManagementServiceAuthorized.installVersion(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(202);
    expect(res.result).toBeDefined();
  });

  // ====
  // Preinstall Version
  // ====

  test('preinstallVersion() returns 403 when user is not authorized', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
      xAuthRefreshToken: refreshTokenNotAuthorized,
      clusterId,
      region: regionUsSouth,
      versionLocatorId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.preinstallVersion(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test.skip('preinstallVersion() returns 404 when no such cluster', async () => {
    // it requires a version where preinstall script is installed
    // but I don't know how to do it
    // one it is done possible to squeeze a 404 from the cluster
    // until then it checks 400
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
      xAuthRefreshToken: refreshTokenAuthorized,
      clusterId: `invalid-${clusterId}`,
      region: regionUsSouth,
      versionLocatorId,
    };

    await expect(
      catalogManagementServiceAuthorized.preinstallVersion(params)
    ).rejects.toMatchObject({
      status: 404,
    });
  });

  test('preinstallVersion() returns 400 when backend input validation fails', async () => {
    const params = {
      versionLocId: bogusVersionLocatorId,
      xAuthRefreshToken: refreshTokenAuthorized,
      clusterId,
      region: regionUsSouth,
      versionLocatorId: bogusVersionLocatorId,
    };

    await expect(
      catalogManagementServiceAuthorized.preinstallVersion(params)
    ).rejects.toMatchObject({
      status: 400,
    });
  });

  test.skip('preinstallVersion()', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
      xAuthRefreshToken: refreshTokenAuthorized,
      clusterId,
      region: regionUsSouth,
      versionLocatorId,
    };

    const res = await catalogManagementServiceAuthorized.preinstallVersion(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(202);
    expect(res.result).toBeDefined();
  });

  // ====
  // Get Preinstall
  // ====

  test('getPreinstall() returns 403 when user is not authorized', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
      xAuthRefreshToken: refreshTokenNotAuthorized,
      clusterId,
      region: regionUsSouth,
    };

    await expect(catalogManagementServiceNotAuthorized.getPreinstall(params)).rejects.toMatchObject(
      {
        status: 403,
      }
    );
  });

  test('getPreinstall() returns 404 when no such version', async () => {
    const params = {
      versionLocId: `invalid-${versionLocatorId}`,
      xAuthRefreshToken: refreshTokenAuthorized,
      clusterId,
      region: regionUsSouth,
    };

    await expect(catalogManagementServiceAuthorized.getPreinstall(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('getPreinstall() returns 400 when backend input validation fails', async () => {
    const params = {
      versionLocId: bogusVersionLocatorId,
      xAuthRefreshToken: refreshTokenAuthorized,
      clusterId,
      region: regionUsSouth,
    };

    await expect(catalogManagementServiceAuthorized.getPreinstall(params)).rejects.toMatchObject({
      status: 400,
    });
  });

  test.skip('getPreinstall()', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
      xAuthRefreshToken: refreshTokenAuthorized,
      clusterId,
      region: regionUsSouth,
    };

    const res = await catalogManagementServiceAuthorized.getPreinstall(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Validate Install
  // ====

  test('validateInstall() returns 403 when user is not authorized', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
      xAuthRefreshToken: refreshTokenNotAuthorized,
      clusterId,
      region: regionUsSouth,
      versionLocatorId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.validateInstall(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('validateInstall() returns 404 when no such version', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: `invalid-${versionLocatorId}`,
      xAuthRefreshToken: refreshTokenAuthorized,
      clusterId,
      region: regionUsSouth,
    };

    await expect(catalogManagementServiceAuthorized.validateInstall(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('validateInstall() returns 400 when backend input validation fails', async () => {
    const params = {
      versionLocId: bogusVersionLocatorId,
      xAuthRefreshToken: refreshTokenAuthorized,
      clusterId,
      region: regionUsSouth,
      versionLocatorId: bogusVersionLocatorId,
    };

    await expect(catalogManagementServiceAuthorized.validateInstall(params)).rejects.toMatchObject({
      status: 400,
    });
  });

  // possibly this user doesn't have right to get the cluster details
  // until it is not clear it is skipped
  // The specified cluster could not be found. If applicable, make sure that you target the correct account
  // and resource group."
  test.skip('validateInstall()', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
      xAuthRefreshToken: refreshTokenAuthorized,
      clusterId,
      region: regionUsSouth,
      versionLocatorId,
    };

    const res = await catalogManagementServiceAuthorized.validateInstall(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(202);
    expect(res.result).toBeDefined();
  });

  // ====
  // Get Validation Status
  // ====

  test('getValidationStatus() returns 403 when user is not authorized', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
      xAuthRefreshToken: refreshTokenNotAuthorized,
    };

    await expect(
      catalogManagementServiceNotAuthorized.getValidationStatus(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('getValidationStatus() returns 404 when no such version', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: `invalid-${versionLocatorId}`,
      xAuthRefreshToken: refreshTokenAuthorized,
    };

    await expect(
      catalogManagementServiceAuthorized.getValidationStatus(params)
    ).rejects.toMatchObject({
      status: 404,
    });
  });

  test('getValidationStatus() returns 400 when backend input validation fails', async () => {
    const params = {
      versionLocId: bogusVersionLocatorId,
      xAuthRefreshToken: refreshTokenAuthorized,
    };

    await expect(
      catalogManagementServiceAuthorized.getValidationStatus(params)
    ).rejects.toMatchObject({
      status: 400,
    });
  });

  test('getValidationStatus()', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
      xAuthRefreshToken: refreshTokenAuthorized,
    };

    const res = await catalogManagementServiceAuthorized.getValidationStatus(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Get Override Values
  // ====

  test('getOverrideValues() returns 403 when user is not authorized', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.getOverrideValues(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('getOverrideValues() returns 404 when no such version', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: `invalid-${versionLocatorId}`,
    };

    await expect(
      catalogManagementServiceAuthorized.getOverrideValues(params)
    ).rejects.toMatchObject({
      status: 404,
    });
  });

  test('getOverrideValues() returns 400 when backend input validation fails', async () => {
    const params = {
      versionLocId: bogusVersionLocatorId,
    };

    await expect(
      catalogManagementServiceAuthorized.getOverrideValues(params)
    ).rejects.toMatchObject({
      status: 400,
    });
  });

  test.skip('getOverrideValues()', async () => {
    // requires validation run before this operation

    const params = {
      versionLocId: versionLocatorId,
    };

    const res = await catalogManagementServiceAuthorized.getOverrideValues(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Search Objects
  // ====

  test('searchObjects() returns 400 when backend input validation fails', async () => {
    const params = {
      query: ' ',
      collapse: true,
      digest: true,
    };

    await expect(catalogManagementServiceAuthorized.searchObjects(params)).rejects.toMatchObject({
      status: 400,
    });
  });

  test('searchObjects() returns 200 when user is not authorized', async () => {
    const params = {
      query: `name: ${objectName}`,
      collapse: true,
      digest: true,
    };

    const res = await catalogManagementServiceNotAuthorized.searchObjects(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  test('searchObjects()', async () => {
    let offset = 0;
    const limit = 1;
    let fetch = true;
    let amountOfObjects = 0;

    while (fetch) {
      const params = {
        query: 'name: object*',
        collapse: true,
        digest: true,
        limit,
        offset,
      };

      const res = await catalogManagementServiceAuthorized.searchObjects(params);
      expect(res).toBeDefined();
      expect(res.status).toBe(200);
      expect(res.result).toBeDefined();

      const offsetValue = getQueryParam(res.result.next, 'offset');

      if (offsetValue) {
        offset = offsetValue;
      } else {
        fetch = false;
      }

      if (res.result.resource_count > 0) {
        amountOfObjects += res.result.resource_count;
      }
    }
    console.log('Amount of objects: ', amountOfObjects);
  });

  // ====
  // List Objects
  // ====

  test('listObjects() returns 400 when backend input validation fails', async () => {
    expect(catalogId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      sort: ' ',
      name: ' ',
    };

    await expect(catalogManagementServiceAuthorized.listObjects(params)).rejects.toMatchObject({
      status: 400,
    });
  });

  test('listObjects() returns 403 when user is not authorized', async () => {
    const params = {
      catalogIdentifier: catalogId,
    };

    await expect(catalogManagementServiceNotAuthorized.listObjects(params)).rejects.toMatchObject({
      status: 403,
    });
  });

  test('listObjects()', async () => {
    expect(catalogId).toBeDefined();

    let offset = 0;
    const limit = 1;
    let fetch = true;
    let amountOfObjects = 0;

    while (fetch) {
      const params = {
        catalogIdentifier: catalogId,
        limit,
        offset,
      };

      const res = await catalogManagementServiceAuthorized.listObjects(params);
      expect(res).toBeDefined();
      expect(res.status).toBe(200);
      expect(res.result).toBeDefined();

      const offsetValue = getQueryParam(res.result.next, 'offset');

      if (offsetValue) {
        offset = offsetValue;
      } else {
        fetch = false;
      }

      if (res.result.resource_count > 0) {
        amountOfObjects += res.result.resource_count;
      }
    }
    console.log('Amount of objects: ', amountOfObjects);
  });

  // ====
  // Replace Object
  // ====

  test('replaceObject() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
      id: objectId,
      name: 'updated-object-name-created-by-node-sdk',
      parentId: regionUsSouth,
      kind: kindVpe,
      catalogId,
      data: {},
    };

    await expect(catalogManagementServiceNotAuthorized.replaceObject(params)).rejects.toMatchObject(
      {
        status: 403,
      }
    );
  });

  test('replaceObject() returns 404 when no such object', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: `invalid-${objectId}`,
      id: `invalid-${objectId}`,
      name: 'updated-object-name-created-by-node-sdk',
      parentId: regionUsSouth,
      kind: kindVpe,
      catalogId,
      data: {},
    };

    await expect(catalogManagementServiceAuthorized.replaceObject(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('replaceObject() returns 400 backend input validation fails', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
      id: objectId,
      name: 'updated object name created by node sdk',
      parentId: regionUsSouth,
      kind: kindVpe,
      catalogId,
      data: {},
    };

    await expect(catalogManagementServiceAuthorized.replaceObject(params)).rejects.toMatchObject({
      status: 400,
    });
  });

  // cannot change name of object, what can be changed?
  test.skip('replaceObject()', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
      id: objectId,
      name: 'updated-object-name-created-by-node-sdk',
      parentId: regionUsSouth,
      kind: kindVpe,
      catalogId,
      data: {},
    };

    const res = await catalogManagementServiceAuthorized.replaceObject(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Get Object
  // ====

  test('getObject() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
    };

    await expect(catalogManagementServiceNotAuthorized.getObject(params)).rejects.toMatchObject({
      status: 403,
    });
  });

  test('getObject() returns 404 when no such object', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: `$invalid-${objectId}`,
    };

    await expect(catalogManagementServiceAuthorized.getObject(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('getObject() returns the object', async () => {
    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
    };

    const res = await catalogManagementServiceAuthorized.getObject(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Get Object Audit
  // ====

  test('getObjectAudit() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.getObjectAudit(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('getObjectAudit() returns 200 when no such object', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: `invalid-${objectId}`,
    };

    const res = await catalogManagementServiceAuthorized.getObjectAudit(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  test('getObjectAudit() returns audit log of the object', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
    };

    const res = await catalogManagementServiceAuthorized.getObjectAudit(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Account Publish Object
  // ====

  test('accountPublishObject() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.accountPublishObject(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('accountPublishObject() returns 404 when no such object', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: `invalid-${objectId}`,
    };

    await expect(
      catalogManagementServiceAuthorized.accountPublishObject(params)
    ).rejects.toMatchObject({
      status: 404,
    });
  });

  test('accountPublishObject() publishes object', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
    };

    const res = await catalogManagementServiceAuthorized.accountPublishObject(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(202);
    expect(res.result).toBeDefined();
  });

  // ====
  // Shared Publish Object
  // ====

  test('sharedPublishObject() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.sharedPublishObject(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('sharedPublishObject() returns 404 when no such object', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: `invalid-${objectId}`,
    };

    await expect(
      catalogManagementServiceAuthorized.sharedPublishObject(params)
    ).rejects.toMatchObject({
      status: 404,
    });
  });

  test.skip('sharedPublishObject() publishes object', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
    };

    const res = await catalogManagementServiceAuthorized.sharedPublishObject(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(202);
    expect(res.result).toBeDefined();
  });

  // ====
  // IBM Publish Object
  // ====

  test('ibmPublishObject() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.ibmPublishObject(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('ibmPublishObject() returns 404 when no such object', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: `invalid-${objectId}`,
    };

    await expect(catalogManagementServiceAuthorized.ibmPublishObject(params)).rejects.toMatchObject(
      {
        status: 404,
      }
    );
  });

  // Error: Object not approved to request publishing to IBM for
  test.skip('ibmPublishObject() publishes object', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
    };

    const res = await catalogManagementServiceAuthorized.ibmPublishObject(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(202);
    expect(res.result).toBeDefined();
  });

  // ====
  // Public Publish Object
  // ====

  test('publicPublishObject() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.publicPublishObject(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('publicPublishObject() returns 404 when no such object', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: `invalid-${objectId}`,
    };

    await expect(
      catalogManagementServiceAuthorized.publicPublishObject(params)
    ).rejects.toMatchObject({
      status: 404,
    });
  });

  // Error: Object not approved to request publishing to IBM for
  test.skip('publicPublishObject() publishes the object', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
    };

    const res = await catalogManagementServiceAuthorized.publicPublishObject(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(202);
    expect(res.result).toBeDefined();
  });

  // ====
  // Create Object Access
  // ====

  test('createObjectAccess() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
      accountIdentifier: accountId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.createObjectAccess(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('createObjectAccess() returns 404 when no such object', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: `invalid-${objectId}`,
      accountIdentifier: accountId,
    };

    await expect(
      catalogManagementServiceAuthorized.createObjectAccess(params)
    ).rejects.toMatchObject({
      status: 404,
    });
  });

  test('createObjectAccess() creates object access', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
      accountIdentifier: accountId,
    };

    const res = await catalogManagementServiceAuthorized.createObjectAccess(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(201);
    expect(res.result).toBeDefined();
  });

  // ====
  // Get Object Access List
  // ====

  test('getObjectAccessList() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.getObjectAccessList(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('getObjectAccessList() returns 200 when no such object', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: `invalid-${objectId}`,
    };

    const res = await catalogManagementServiceAuthorized.getObjectAccessList(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  test('getObjectAccessList() returns the access list of the object', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
    };

    const res = await catalogManagementServiceAuthorized.getObjectAccessList(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Get Object Access
  // ====

  test('getObjectAccess() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
      accountIdentifier: accountId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.getObjectAccess(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('getObjectAccess() returns 404 when no such object', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: `invalid-${objectId}`,
      accountIdentifier: accountId,
    };

    await expect(catalogManagementServiceAuthorized.getObjectAccess(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  // Error: Error loading version with id: 6e263640-4805-471d-a30c-d7667325581c.
  // e59ad442-d113-49e4-bcd4-5431990135fd: Error[404 Not Found]
  test.skip('getObjectAccess() returns accesses of the object', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
      accountIdentifier: accountId,
    };

    const res = await catalogManagementServiceAuthorized.getObjectAccess(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Add object Access List
  // ====

  test('addObjectAccessList() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
      accounts: [accountId],
    };

    await expect(
      catalogManagementServiceNotAuthorized.addObjectAccessList(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('addObjectAccessList() returns 404 when no such object', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: `invalid-${objectId}`,
      accounts: [accountId],
    };

    await expect(
      catalogManagementServiceAuthorized.addObjectAccessList(params)
    ).rejects.toMatchObject({
      status: 404,
    });
  });

  test('addObjectAccessList() adds object access list to account', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
      accounts: [accountId],
    };

    const res = await catalogManagementServiceAuthorized.addObjectAccessList(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(201);
    expect(res.result).toBeDefined();
  });

  // ====
  // Create Offering Instance
  // ====

  // don't know what kind_format is needed here, vpe, helm and offering don't work
  test.skip('createOfferingInstance() returns 404 when no such catalog', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      xAuthRefreshToken: refreshTokenAuthorized,
      id: offeringId,
      catalogId: `invalid-${catalogId}`,
      offeringId,
      kindFormat: kindVpe,
      version: '0.0.2',
      clusterId,
      clusterRegion: regionUsSouth,
      cluster_all_namespaces: true,
    };

    await expect(
      catalogManagementServiceAuthorized.createOfferingInstance(params)
    ).rejects.toMatchObject({
      status: 404,
    });
  });

  // don't know what kind_format is needed here, vpe, helm and offering don't work
  test.skip('createOfferingInstance() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      xAuthRefreshToken: refreshTokenNotAuthorized,
      id: offeringId,
      catalogId,
      offeringId,
      kindFormat: kindVpe,
      version: '0.0.2',
      clusterId,
      clusterRegion: regionUsSouth,
      cluster_all_namespaces: true,
    };

    await expect(
      catalogManagementServiceNotAuthorized.createOfferingInstance(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('createOfferingInstance() returns 400 when backend input validation fails', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      xAuthRefreshToken: refreshTokenAuthorized,
      id: offeringId,
      catalogId,
      offeringId,
      kindFormat: 'bogus kind',
      version: '0.0.2',
      clusterId,
      clusterRegion: regionUsSouth,
      cluster_all_namespaces: true,
    };

    await expect(
      catalogManagementServiceAuthorized.createOfferingInstance(params)
    ).rejects.toMatchObject({
      status: 400,
    });
  });

  test.skip('createOfferingInstance() creates an instance', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      xAuthRefreshToken: refreshTokenAuthorized,
      id: offeringId,
      catalogId,
      offeringId,
      kindFormat: kindVpe,
      version: '0.0.2',
      clusterId,
      clusterRegion: regionUsSouth,
      cluster_all_namespaces: true,
    };

    const res = await catalogManagementServiceAuthorized.createOfferingInstance(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(201);
    expect(res.result).toBeDefined();
    expect(res.result.id).toBeDefined();
    offeringInstanceId = res.result.id;
  });

  // ====
  // Get Offering Instance
  // ====

  test.skip('getOfferingInstance() returns 403 when user is not authorized', async () => {
    expect(offeringInstanceId).toBeDefined();

    const params = {
      instanceIdentifier: offeringInstanceId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.getOfferingInstance(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test.skip('getOfferingInstance() returns 404 when no such offering instance', async () => {
    expect(offeringInstanceId).toBeDefined();

    const params = {
      instanceIdentifier: `invalid-${offeringInstanceId}`,
    };

    await expect(
      catalogManagementServiceAuthorized.getOfferingInstance(params)
    ).rejects.toMatchObject({
      status: 404,
    });
  });

  test.skip('getOfferingInstance()', async () => {
    expect(offeringInstanceId).toBeDefined();

    const params = {
      instanceIdentifier: offeringInstanceId,
    };

    const res = await catalogManagementServiceAuthorized.getOfferingInstance(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Put Offering Instance
  // ====

  test.skip('putOfferingInstance() returns 403 when user is not authorized', async () => {
    expect(offeringInstanceId).toBeDefined();
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      instanceIdentifier: offeringInstanceId,
      xAuthRefreshToken: refreshTokenNotAuthorized,
      id: offeringInstanceId,
      catalogId,
      offeringId,
      kindFormat: kindVpe,
      version: '0.0.3',
      clusterId,
      clusterRegion: regionUsSouth,
      cluster_all_namespaces: true,
    };

    await expect(
      catalogManagementServiceNotAuthorized.putOfferingInstance(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test.skip('putOfferingInstance() returns 404 when no such catalog', async () => {
    expect(offeringInstanceId).toBeDefined();
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      instanceIdentifier: offeringInstanceId,
      xAuthRefreshToken: refreshTokenNotAuthorized,
      id: offeringInstanceId,
      catalogId: `invalid-${catalogId}`,
      offeringId,
      kindFormat: kindVpe,
      version: '0.0.3',
      clusterId,
      clusterRegion: regionUsSouth,
      cluster_all_namespaces: true,
    };

    await expect(
      catalogManagementServiceAuthorized.putOfferingInstance(params)
    ).rejects.toMatchObject({
      status: 404,
    });
  });

  test.skip('putOfferingInstance() returns 400 when backend input validation fails', async () => {
    expect(offeringInstanceId).toBeDefined();
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      instanceIdentifier: offeringInstanceId,
      xAuthRefreshToken: refreshTokenNotAuthorized,
      id: offeringInstanceId,
      catalogId,
      offeringId,
      kindFormat: 'bogus kind',
      version: '0.0.3',
      clusterId,
      clusterRegion: regionUsSouth,
      cluster_all_namespaces: true,
    };

    await expect(
      catalogManagementServiceAuthorized.putOfferingInstance(params)
    ).rejects.toMatchObject({
      status: 400,
    });
  });

  test.skip('putOfferingInstance() updates the offering instance', async () => {
    expect(offeringInstanceId).toBeDefined();
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      instanceIdentifier: offeringInstanceId,
      xAuthRefreshToken: refreshTokenNotAuthorized,
      id: offeringInstanceId,
      catalogId,
      offeringId,
      kindFormat: kindVpe,
      version: '0.0.3',
      clusterId,
      clusterRegion: regionUsSouth,
      cluster_all_namespaces: true,
    };

    const res = await catalogManagementServiceAuthorized.putOfferingInstance(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Delete Version
  // ====

  test('deleteVersion() returns 400 when backend input validation fails', async () => {
    const params = {
      versionLocId: bogusVersionLocatorId,
    };

    await expect(catalogManagementServiceAuthorized.deleteVersion(params)).rejects.toMatchObject({
      status: 400,
    });
  });

  test('deleteVersion() returns 404 when no such version', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: `invalid-${versionLocatorId}`,
    };

    await expect(catalogManagementServiceAuthorized.deleteVersion(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('deleteVersion() returns 403 when user is not authorized', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
    };

    await expect(catalogManagementServiceNotAuthorized.deleteVersion(params)).rejects.toMatchObject(
      {
        status: 403,
      }
    );
  });

  test('deleteVersion() deletes the version', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      versionLocId: versionLocatorId,
    };

    const res = await catalogManagementServiceAuthorized.deleteVersion(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Delete Operators
  // ====

  test('deleteOperators() returns 403 when user is not authorized', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      xAuthRefreshToken: refreshTokenNotAuthorized,
      clusterId,
      region: regionUsSouth,
      versionLocatorId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.deleteOperators(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('deleteOperators() returns 404 when no such operator', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      xAuthRefreshToken: refreshTokenAuthorized,
      clusterId,
      region: regionUsSouth,
      versionLocatorId: `invalid-${versionLocatorId}`,
    };

    await expect(catalogManagementServiceAuthorized.deleteOperators(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('deleteOperators() returns 400 when backend input validation fails', async () => {
    const params = {
      xAuthRefreshToken: refreshTokenAuthorized,
      clusterId,
      region: regionUsSouth,
      versionLocatorId: bogusVersionLocatorId,
    };

    await expect(catalogManagementServiceAuthorized.deleteOperators(params)).rejects.toMatchObject({
      status: 400,
    });
  });

  // Error: Error loading version with id: fdeefb18-57aa-4390-a9e0-b66b551db803.
  // 2c187aa6-5009-4a2f-8f57-86533d2d3a18: Error[404 Not Found] -
  // Version not found: Catalog[fdeefb18-57aa-4390-a9e0-b66b551db803]:Version[2c187aa6-5009-4a2f-8f57-86533d2d3a18]
  test.skip('deleteOperators() deletes the operator', async () => {
    expect(versionLocatorId).toBeDefined();

    const params = {
      xAuthRefreshToken: refreshTokenAuthorized,
      clusterId,
      region: regionUsSouth,
      versionLocatorId,
    };

    const res = await catalogManagementServiceAuthorized.deleteOperators(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Delete Offering Instance
  // ====

  test.skip('deleteOfferingInstance() returns 403 when user is not authorized', async () => {
    expect(offeringInstanceId).toBeDefined();

    const params = {
      instanceIdentifier: offeringInstanceId,
      xAuthRefreshToken: refreshTokenNotAuthorized,
    };

    await expect(
      catalogManagementServiceNotAuthorized.deleteOfferingInstance(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test.skip('deleteOfferingInstance() returns 404 when no such offering instance', async () => {
    expect(offeringInstanceId).toBeDefined();

    const params = {
      instanceIdentifier: `invalid-${offeringInstanceId}`,
      xAuthRefreshToken: refreshTokenAuthorized,
    };

    await expect(
      catalogManagementServiceAuthorized.deleteOfferingInstance(params)
    ).rejects.toMatchObject({
      status: 404,
    });
  });

  test.skip('deleteOfferingInstance()', async () => {
    expect(offeringInstanceId).toBeDefined();

    const params = {
      instanceIdentifier: offeringInstanceId,
      xAuthRefreshToken: refreshTokenAuthorized,
    };

    const res = await catalogManagementServiceAuthorized.deleteOfferingInstance(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Delete Object Access List
  // ====

  test('deleteObjectAccessList() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
      accounts: [accountId],
    };

    await expect(
      catalogManagementServiceNotAuthorized.deleteObjectAccessList(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('deleteObjectAccessList() returns 404 when no such catalog', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: `invalid-${catalogId}`,
      objectIdentifier: objectId,
      accounts: [accountId],
    };

    await expect(
      catalogManagementServiceAuthorized.deleteObjectAccessList(params)
    ).rejects.toMatchObject({
      status: 404,
    });
  });

  test('deleteObjectAccessList() deletes access list of the object', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
      accounts: [accountId],
    };

    const res = await catalogManagementServiceAuthorized.deleteObjectAccessList(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Delete Object Access
  // ====

  test('deleteObjectAccess() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
      accountIdentifier: accountId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.deleteObjectAccess(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('deleteObjectAccess() returns 404 when no such object', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: `invalid-${catalogId}`,
      objectIdentifier: objectId,
      accountIdentifier: accountId,
    };

    await expect(
      catalogManagementServiceAuthorized.deleteObjectAccess(params)
    ).rejects.toMatchObject({
      status: 404,
    });
  });

  test('deleteObjectAccess() deletes access to object', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
      accountIdentifier: accountId,
    };

    const res = await catalogManagementServiceAuthorized.deleteObjectAccess(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
    expect(res.result).toBeDefined();
  });

  // ====
  // Delete Object
  // ====

  test('deleteObject() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
    };

    await expect(catalogManagementServiceNotAuthorized.deleteObject(params)).rejects.toMatchObject({
      status: 403,
    });
  });

  test('deleteObject() returns 200 when no such object', async () => {
    expect(catalogId).toBeDefined();
    expect(objectId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: `invalid-${objectId}`,
    };

    const res = await catalogManagementServiceAuthorized.deleteObject(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
  });

  test('deleteObject() deletes the object', async () => {
    expect(catalogId).toBeDefined();

    for (let i = 0; i < createdObjectIds.length; i++) {
      const params = {
        catalogIdentifier: catalogId,
        objectIdentifier: createdObjectIds[i],
      };

      const res = await catalogManagementServiceAuthorized.deleteObject(params);
      expect(res).toBeDefined();
      expect(res.status).toBe(200);
      expect(res.result).toBeDefined();
    }
  });

  // ====
  // Delete Offering
  // ====

  test('deleteOffering() returns 200 when no such offering', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId: `invalid-${offeringId}`,
    };

    const res = await catalogManagementServiceAuthorized.deleteOffering(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
  });

  test('deleteOffering() returns 403 when user is not authorized', async () => {
    expect(catalogId).toBeDefined();
    expect(offeringId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
      offeringId,
    };

    await expect(
      catalogManagementServiceNotAuthorized.deleteOffering(params)
    ).rejects.toMatchObject({
      status: 403,
    });
  });

  test('deleteOffering() deletes the offering', async () => {
    expect(catalogId).toBeDefined();

    for (let i = 0; i < createdOfferingIds.length; i++) {
      const params = {
        catalogIdentifier: catalogId,
        offeringId: createdOfferingIds[i],
      };

      const res = await catalogManagementServiceAuthorized.deleteOffering(params);
      expect(res).toBeDefined();
      expect(res.status).toBe(200);
    }
  });

  // ====
  // Delete Catalog
  // ====

  test.skip('deleteCatalog() returns 404 when no such catalog', async () => {
    expect(catalogId).toBeDefined();

    const params = {
      catalogIdentifier: `invalid-${catalogId}`,
    };

    await expect(catalogManagementServiceAuthorized.deleteCatalog(params)).rejects.toMatchObject({
      status: 404,
    });
  });

  test('deleteCatalog() returns 403 when the user is not authorized', async () => {
    expect(catalogId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
    };

    await expect(catalogManagementServiceNotAuthorized.deleteCatalog(params)).rejects.toMatchObject(
      {
        status: 403,
      }
    );
  });

  test('deleteCatalog() deletes the catalog', async () => {
    expect(catalogId).toBeDefined();

    const params = {
      catalogIdentifier: catalogId,
    };

    const res = await catalogManagementServiceAuthorized.deleteCatalog(params);
    expect(res).toBeDefined();
    expect(res.status).toBe(200);
  });

  afterAll(async () => {
    for (let i = 0; i < createdObjectIds.length; i++) {
      try {
        const params = {
          catalogIdentifier: catalogId,
          objectIdentifier: createdObjectIds[i],
        };

        await catalogManagementServiceAuthorized.deleteObject(params);
      } catch (e) {
        console.log('Cleanup: Object is already deleted.');
      }
    }

    for (let i = 0; i < createdOfferingIds.length; i++) {
      try {
        const params = {
          catalogIdentifier: catalogId,
          offeringId: createdOfferingIds[i],
        };

        await catalogManagementServiceAuthorized.deleteOffering(params);
      } catch (e) {
        console.log('Cleanup: Offering is already deleted.');
      }
    }

    try {
      const params = {
        catalogIdentifier: catalogId,
      };

      await catalogManagementServiceAuthorized.deleteCatalog(params);
    } catch (e) {
      console.log('Cleanup: Catalog is already deleted.');
    }
  });
});
