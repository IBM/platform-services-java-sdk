/**
 * @jest-environment node
 */
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
'use strict';

/* eslint-disable no-console */

const CatalogManagementV1 = require('../dist/catalog-management/v1');
// eslint-disable-next-line node/no-unpublished-require
const authHelper = require('../test/resources/auth-helper.js');
// You can use the readExternalSources method to access additional configuration values
const { readExternalSources } = require('ibm-cloud-sdk-core');

//
// This file provides an example of how to use the Catalog Management service.
//
// The following configuration properties are assumed to be defined:
// CATALOG_MANAGEMENT_URL=<service base url>
// CATALOG_MANAGEMENT_AUTH_TYPE=iam
// CATALOG_MANAGEMENT_APIKEY=<IAM apikey>
// CATALOG_MANAGEMENT_AUTH_URL=<IAM token service base URL - omit this if using the production environment>
// CATALOG_MANAGEMENT_CLUSTER_ID=<ID of the cluster>
// CATALOG_MANAGEMENT_ACCOUNT_ID=<ID of the Account>
// CATALOG_MANAGEMENT_GIT_TOKEN=<Token used in communication with Git repository>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
const configFile = 'catalog_mgmt.env';

const describe = authHelper.prepareTests(configFile);

// Save original console.log
const originalLog = console.log;

// Mocks for console.log and console.warn
const consoleLogMock = jest.spyOn(console, 'log');
const consoleWarnMock = jest.spyOn(console, 'warn');

describe('CatalogManagementV1', () => {

  // begin-common

  const catalogManagementService = CatalogManagementV1.newInstance({});

  // end-common

  let bearerToken;
  let catalogId;
  let offeringId;
  let versionLocatorId;
  let offeringInstanceId;
  let objectId;

  // To access additional configuration values, uncomment this line and extract the values from config
  const config = readExternalSources(CatalogManagementV1.DEFAULT_SERVICE_NAME);
  expect(config).not.toBeNull();

  const accountId = config.accountId;
  expect(accountId).not.toBeUndefined();

  const gitTokenForPublicRepo = config.gitToken;
  expect(gitTokenForPublicRepo).not.toBeUndefined();

  const clusterId = config.clusterId;
  expect(clusterId).not.toBeUndefined();

  test('Acquire bearer token', async () => {
    await catalogManagementService.getCatalogAccount();
    bearerToken = catalogManagementService.getAuthenticator().getRefreshToken()
    expect(bearerToken).not.toBeUndefined();
  })

  test('createCatalog request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('createCatalog() result:');
    // begin-create_catalog

    const params = {
      label: 'Catalog Management Service',
      tags: ['node', 'sdk'],
      kind: 'vpe',
      owningAccount: accountId
    }

    catalogManagementService.createCatalog(params)
    .then(res => {
      catalogId = res.result.id;
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-create_catalog
  });

  test('getCatalog request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('getCatalog() result:');
    // begin-get_catalog

    const params = {
      catalogIdentifier: catalogId,
    };

    catalogManagementService.getCatalog(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-get_catalog
  });

  test('replaceCatalog request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('replaceCatalog() result:');
    // begin-replace_catalog

    const params = {
      catalogIdentifier: catalogId,
      id: catalogId,
      tags: ['node', 'sdk', 'updated'],
      owningAccount: accountId,
      kind: 'vpe',
    };

    catalogManagementService.replaceCatalog(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-replace_catalog
  });

  test('listCatalogs request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('listCatalogs() result:');
    // begin-list_catalogs

    catalogManagementService.listCatalogs({})
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-list_catalogs
  });

  test('createOffering request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('createOffering() result:');
    // begin-create_offering

    const params = {
      catalogIdentifier: catalogId,
      name: 'offering-name'
    };

    catalogManagementService.createOffering(params)
    .then(res => {
      offeringId = res.result.id;
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-create_offering
  });

  test('getOffering request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('getOffering() result:');
    // begin-get_offering

    const params = {
      catalogIdentifier: catalogId,
      offeringId: offeringId,
    };

    catalogManagementService.getOffering(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-get_offering
  });

  test.skip('replaceOffering request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('replaceOffering() result:');
    // begin-replace_offering

    const params = {
      catalogIdentifier: catalogId,
      offeringId: offeringId,
      id: offeringId,
      name: 'updated-offering-name'
    };

    catalogManagementService.replaceOffering(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-replace_offering
  });

  test('listOfferings request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('listOfferings() result:');
    // begin-list_offerings

    const params = {
      catalogIdentifier: catalogId,
      limit: 100,
      offset: 0,
    };

    catalogManagementService.listOfferings(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-list_offerings
  });

  test('importOffering request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('importOffering() result:');
    // begin-import_offering

    const params = {
      catalogIdentifier: catalogId,
      tags: ['node', 'sdk'],
      target_kinds: ['roks'],
      zipurl: 'https://github.com/rhm-samples/node-red-operator/blob/master/node-red-operator/bundle/0.0.2/node-red-operator.v0.0.2.clusterserviceversion.yaml',
      offeringId: offeringId,
      targetVersion: '0.0.2',
      repoType: 'git_public',
      xAuthToken: gitTokenForPublicRepo,
    };

    catalogManagementService.importOffering(params)
    .then(res => {
      versionLocatorId = res.result.kinds[0].versions[0].version_locator;
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-import_offering
  });

  test.skip('reloadOffering request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('reloadOffering() result:');
    // begin-reload_offering

    const params = {
      catalogIdentifier: catalogId,
      tags: ['node', 'sdk'],
      target_kinds: ['roks'],
      zipurl: 'https://github.com/rhm-samples/node-red-operator/blob/master/node-red-operator/bundle/0.0.2/node-red-operator.v0.0.2.clusterserviceversion.yaml',
      offeringId: offeringId,
      targetVersion: '0.0.2',
      repoType: 'git_public',
    };

    catalogManagementService.reloadOffering(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-reload_offering
  });

  test('createObject request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('createObject() result:');
    // begin-create_object

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
      catalogId: catalogId,
      name: 'object_in_ibm_cloud',
      crn: 'crn:v1:bluemix:public:iam-global-endpoint:global:::endpoint:private.iam.cloud.ibm.com',
      parentId: 'us-south',
      kind: 'vpe',
      publish: publishObjectModel,
      state: stateModel,
    };

    catalogManagementService.createObject(params)
    .then(res => {
      objectId = res.result.id;
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-create_object
  });

  test('getOfferingAudit request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('getOfferingAudit() result:');
    // begin-get_offering_audit

    const params = {
      catalogIdentifier: catalogId,
      offeringId: offeringId,
    };

    catalogManagementService.getOfferingAudit(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-get_offering_audit
  });

  test('getCatalogAccount request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('getCatalogAccount() result:');
    // begin-get_catalog_account

    catalogManagementService.getCatalogAccount({})
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-get_catalog_account
  });

  test.skip('updateCatalogAccount request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-update_catalog_account

    catalogManagementService.updateCatalogAccount({})
    .then(res => {
      done();
    })
    .catch(err => {
      console.warn(err)
    });

    // end-update_catalog_account
  });

  test('getCatalogAccountAudit request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('getCatalogAccountAudit() result:');
    // begin-get_catalog_account_audit

    catalogManagementService.getCatalogAccountAudit({})
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-get_catalog_account_audit
  });


  test('getCatalogAccountFilters request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('getCatalogAccountFilters() result:');
    // begin-get_catalog_account_filters

    catalogManagementService.getCatalogAccountFilters({})
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-get_catalog_account_filters
  });

  test('getCatalogAudit request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('getCatalogAudit() result:');
    // begin-get_catalog_audit

    const params = {
      catalogIdentifier: catalogId,
    };

    catalogManagementService.getCatalogAudit(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-get_catalog_audit
  });

  test('getConsumptionOfferings request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('getConsumptionOfferings() result:');
    // begin-get_consumption_offerings

    catalogManagementService.getConsumptionOfferings({})
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-get_consumption_offerings
  });

  test('importOfferingVersion request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('importOfferingVersion() result:');
    // begin-import_offering_version

    const params = {
      catalogIdentifier: catalogId,
      offeringId: offeringId,
      targetKinds: ['roks'],
      zipurl: 'https://github.com/rhm-samples/node-red-operator/blob/master/node-red-operator/bundle/0.0.2/node-red-operator.v0.0.2.clusterserviceversion.yaml',
      targetVersion: '0.0.3',
      repoType: 'git_public',
    };

    catalogManagementService.importOfferingVersion(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-import_offering_version
  });

  test.skip('replaceOfferingIcon request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('replaceOfferingIcon() result:');
    // begin-replace_offering_icon

    const params = {
      catalogIdentifier: catalogId,
      offeringId: offeringId,
      fileName: 'offering_icon.png',
    };

    catalogManagementService.replaceOfferingIcon(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-replace_offering_icon
  });

  test.skip('updateOfferingIbm request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('updateOfferingIbm() result:');
    // begin-update_offering_ibm

    const params = {
      catalogIdentifier: catalogId,
      offeringId: offeringId,
      approvalType: 'allow_request',
      approved: 'true',
    };

    catalogManagementService.updateOfferingIbm(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-update_offering_ibm
  });

  test.skip('getOfferingUpdates request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('getOfferingUpdates() result:');
    // begin-get_offering_updates

    const params = {
      catalogIdentifier: catalogId,
      offeringId: offeringId,
      kind: 'roks',
      version: '0.0.2',
      clusterId: clusterId,
      region: 'us-south',
      namespace: 'application-development-namespace',
    };

    catalogManagementService.getOfferingUpdates(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-get_offering_updates
  });

  test.skip('getOfferingAbout request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('getOfferingAbout() result:');
    // begin-get_offering_about

    const params = {
      versionLocId: versionLocatorId,
    };

    catalogManagementService.getOfferingAbout(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-get_offering_about
  });

  test.skip('getOfferingLicense request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('getOfferingLicense() result:');
    // begin-get_offering_license

    const params = {
      versionLocId: versionLocatorId,
      licenseId: 'license-id',
    };

    catalogManagementService.getOfferingLicense(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-get_offering_license
  });

  test('getOfferingContainerImages request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('getOfferingContainerImages() result:');
    // begin-get_offering_container_images

    const params = {
      versionLocId: versionLocatorId,
    };

    catalogManagementService.getOfferingContainerImages(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-get_offering_container_images
  });

  test.skip('deprecateVersion request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-deprecate_version

    const params = {
      versionLocId: versionLocatorId,
    };

    catalogManagementService.deprecateVersion(params)
    .then(res => {
      done();
    })
    .catch(err => {
      console.warn(err)
    });

    // end-deprecate_version
  });

  test.skip('accountPublishVersion request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-account_publish_version

    const params = {
      versionLocId: versionLocatorId,
    };

    catalogManagementService.accountPublishVersion(params)
    .then(res => {
      done();
    })
    .catch(err => {
      console.warn(err)
    });

    // end-account_publish_version
  });

  test.skip('ibmPublishVersion request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-ibm_publish_version

    const params = {
      versionLocId: versionLocatorId,
    };

    catalogManagementService.ibmPublishVersion(params)
    .then(res => {
      done();
    })
    .catch(err => {
      console.warn(err)
    });

    // end-ibm_publish_version
  });

  test.skip('publicPublishVersion request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-public_publish_version

    const params = {
      versionLocId: versionLocatorId,
    };

    catalogManagementService.publicPublishVersion(params)
    .then(res => {
      done();
    })
    .catch(err => {
      console.warn(err)
    });

    // end-public_publish_version
  });

  test.skip('commitVersion request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-commit_version

    const params = {
      versionLocId: versionLocatorId,
    };

    catalogManagementService.commitVersion(params)
    .then(res => {
      done();
    })
    .catch(err => {
      console.warn(err)
    });

    // end-commit_version
  });

  test.skip('copyVersion request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-copy_version

    const params = {
      versionLocId: versionLocatorId,
      targetKinds: ['roks'],
    };

    catalogManagementService.copyVersion(params)
    .then(res => {
      done();
    })
    .catch(err => {
      console.warn(err)
    });

    // end-copy_version
  });

  test.skip('getOfferingWorkingCopy request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('getOfferingWorkingCopy() result:');
    // begin-get_offering_working_copy

    const params = {
      versionLocId: versionLocatorId,
    };

    catalogManagementService.getOfferingWorkingCopy(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-get_offering_working_copy
  });

  test('getVersion request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('getVersion() result:');
    // begin-get_version

    const params = {
      versionLocId: versionLocatorId,
    };

    catalogManagementService.getVersion(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-get_version
  });

  test.skip('getCluster request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('getCluster() result:');
    // begin-get_cluster

    const params = {
      clusterId: clusterId,
      region: 'us-south',
      xAuthRefreshToken: bearerToken,
    };

    catalogManagementService.getCluster(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-get_cluster
  });

  test.skip('getNamespaces request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('getNamespaces() result:');
    // begin-get_namespaces

    const params = {
      clusterId: clusterId,
      region: 'us-south',
      xAuthRefreshToken: bearerToken,
    };

    catalogManagementService.getNamespaces(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-get_namespaces
  });

  test.skip('deployOperators request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('deployOperators() result:');
    // begin-deploy_operators

    const params = {
      xAuthRefreshToken: bearerToken,
      clusterId: clusterId,
      region: 'us-south',
      allNamespaces: true,
      versionLocatorId: versionLocatorId,
    };

    catalogManagementService.deployOperators(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-deploy_operators
  });

  test.skip('listOperators request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('listOperators() result:');
    // begin-list_operators

    const params = {
      xAuthRefreshToken: bearerToken,
      clusterId: clusterId,
      region: 'us-south',
      versionLocatorId: versionLocatorId,
    };

    catalogManagementService.listOperators(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-list_operators
  });

  test.skip('replaceOperators request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('replaceOperators() result:');
    // begin-replace_operators

    const params = {
      xAuthRefreshToken: bearerToken,
      clusterId: clusterId,
      region: 'us-south',
      allNamespaces: true,
      versionLocatorId: versionLocatorId,
    };

    catalogManagementService.replaceOperators(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-replace_operators
  });

  test.skip('installVersion request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-install_version

    const params = {
      versionLocId: versionLocatorId,
      xAuthRefreshToken: bearerToken,
      clusterId: clusterId,
      region: 'us-south',
      versionLocatorId: versionLocatorId,
    };

    catalogManagementService.installVersion(params)
    .then(res => {
      done();
    })
    .catch(err => {
      console.warn(err)
    });

    // end-install_version
  });

  test.skip('preinstallVersion request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-preinstall_version

    const params = {
      versionLocId: versionLocatorId,
      xAuthRefreshToken: bearerToken,
      clusterId: clusterId,
      region: 'us-south',
      versionLocatorId: versionLocatorId,
    };

    catalogManagementService.preinstallVersion(params)
    .then(res => {
      done();
    })
    .catch(err => {
      console.warn(err)
    });

    // end-preinstall_version
  });

  test.skip('getPreinstall request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('getPreinstall() result:');
    // begin-get_preinstall

    const params = {
      versionLocId: versionLocatorId,
      xAuthRefreshToken: bearerToken,
      clusterId: clusterId,
      region: 'us-south',
    };

    catalogManagementService.getPreinstall(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-get_preinstall
  });

  test.skip('validateInstall request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-validate_install

    const params = {
      versionLocId: versionLocatorId,
      xAuthRefreshToken: bearerToken,
      clusterId: clusterId,
      region: 'us-south',
      versionLocatorId: versionLocatorId,
    };

    catalogManagementService.validateInstall(params)
    .then(res => {
      done();
    })
    .catch(err => {
      console.warn(err)
    });

    // end-validate_install
  });

  test('getValidationStatus request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('getValidationStatus() result:');
    // begin-get_validation_status

    const params = {
      versionLocId: versionLocatorId,
      xAuthRefreshToken: bearerToken,
    };

    catalogManagementService.getValidationStatus(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-get_validation_status
  });

  test.skip('getOverrideValues request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('getOverrideValues() result:');
    // begin-get_override_values

    const params = {
      versionLocId: versionLocatorId,
    };

    catalogManagementService.getOverrideValues(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-get_override_values
  });

  test('searchObjects request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('searchObjects() result:');
    // begin-search_objects

    const params = {
      query: 'name: object*',
      collapse: true,
      digest: true,
      limit: 100,
      offset: 0,
    };

    catalogManagementService.searchObjects(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-search_objects
  });

  test('listObjects request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('listObjects() result:');
    // begin-list_objects

    const params = {
      catalogIdentifier: catalogId,
      limit: 100,
      offset: 0,
    };

    catalogManagementService.listObjects(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-list_objects
  });

  test.skip('replaceObject request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('replaceObject() result:');
    // begin-replace_object

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
      id: objectId,
      name: 'updated-object-name',
      parentId: 'us-south',
      kind: 'vpe',
      catalogId: catalogId,
    };

    catalogManagementService.replaceObject(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-replace_object
  });

  test('getObject request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('getObject() result:');
    // begin-get_object

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
    };

    catalogManagementService.getObject(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-get_object
  });

  test('getObjectAudit request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('getObjectAudit() result:');
    // begin-get_object_audit

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
    };

    catalogManagementService.getObjectAudit(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-get_object_audit
  });

  test('accountPublishObject request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-account_publish_object

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
    };

    catalogManagementService.accountPublishObject(params)
    .then(res => {
      done();
    })
    .catch(err => {
      console.warn(err)
    });

    // end-account_publish_object
  });

  test.skip('sharedPublishObject request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-shared_publish_object

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
    };

    catalogManagementService.sharedPublishObject(params)
    .then(res => {
      done();
    })
    .catch(err => {
      console.warn(err)
    });

    // end-shared_publish_object
  });

  test.skip('ibmPublishObject request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-ibm_publish_object

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
    };

    catalogManagementService.ibmPublishObject(params)
    .then(res => {
      done();
    })
    .catch(err => {
      console.warn(err)
    });

    // end-ibm_publish_object
  });

  test.skip('publicPublishObject request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-public_publish_object

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
    };

    catalogManagementService.publicPublishObject(params)
    .then(res => {
      done();
    })
    .catch(err => {
      console.warn(err)
    });

    // end-public_publish_object
  });

  test('createObjectAccess request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-create_object_access

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
      accountIdentifier: accountId,
    };

    catalogManagementService.createObjectAccess(params)
    .then(res => {
      done();
    })
    .catch(err => {
      console.warn(err)
    });

    // end-create_object_access
  });

  test('getObjectAccess request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('getObjectAccess() result:');
    // begin-get_object_access

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
      accountIdentifier: accountId,
    };

    catalogManagementService.getObjectAccess(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-get_object_access
  });

  test('addObjectAccessList request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('addObjectAccessList() result:');
    // begin-add_object_access_list

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
      accounts: [accountId],
    };

    catalogManagementService.addObjectAccessList(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-add_object_access_list
  });

  test('getObjectAccessList request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('getObjectAccessList() result:');
    // begin-get_object_access_list

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
    };

    catalogManagementService.getObjectAccessList(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-get_object_access_list
  });

  test.skip('createOfferingInstance request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('createOfferingInstance() result:');
    // begin-create_offering_instance

    const params = {
      xAuthRefreshToken: bearerToken,
      id: offeringId,
      catalogId: catalogId,
      offeringId: offeringId,
      kindFormat: 'vpe',
      version: '0.0.2',
      clusterId: clusterId,
      clusterRegion: 'us-south',
      clusterAllNamespaces: true,
    };

    catalogManagementService.createOfferingInstance(params)
    .then(res => {
      offeringInstanceId = res.result.id;
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-create_offering_instance
  });

  test.skip('getOfferingInstance request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('getOfferingInstance() result:');
    // begin-get_offering_instance

    const params = {
      instanceIdentifier: offeringInstanceId,
    };

    catalogManagementService.getOfferingInstance(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-get_offering_instance
  });

  test.skip('putOfferingInstance request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('putOfferingInstance() result:');
    // begin-put_offering_instance

    const params = {
      instanceIdentifier: offeringInstanceId,
      xAuthRefreshToken: bearerToken,
      id: offeringId,
      catalogId: catalogId,
      offeringId: offeringId,
      kindFormat: 'vpe',
      version: '0.0.2',
      clusterId: clusterId,
      clusterRegion: 'us-south',
      clusterAllNamespaces: true,
    };

    catalogManagementService.putOfferingInstance(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-put_offering_instance
  });

  test('deleteVersion request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-delete_version

    const params = {
      versionLocId: versionLocatorId,
    };

    catalogManagementService.deleteVersion(params)
    .then(res => {
      done();
    })
    .catch(err => {
      console.warn(err)
    });

    // end-delete_version
  });

  test.skip('deleteOperators request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-delete_operators

    const params = {
      xAuthRefreshToken: bearerToken,
      clusterId: clusterId,
      region: 'us-south',
      versionLocatorId: versionLocatorId,
    };

    catalogManagementService.deleteOperators(params)
    .then(res => {
      done();
    })
    .catch(err => {
      console.warn(err)
    });

    // end-delete_operators
  });

  test.skip('deleteOfferingInstance request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-delete_offering_instance

    const params = {
      instanceIdentifier: 'testString',
      xAuthRefreshToken: bearerToken,
    };

    catalogManagementService.deleteOfferingInstance(params)
    .then(res => {
      done();
    })
    .catch(err => {
      console.warn(err)
    });

    // end-delete_offering_instance
  });

  test('deleteObjectAccessList request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    originalLog('deleteObjectAccessList() result:');
    // begin-delete_object_access_list

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
      accounts: [accountId],
    };

    catalogManagementService.deleteObjectAccessList(params)
    .then(res => {
      console.log(JSON.stringify(res.result, null, 2));
    })
    .catch(err => {
      console.warn(err)
    });

    // end-delete_object_access_list
  });

  test('deleteObjectAccess request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-delete_object_access

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
      accountIdentifier: accountId,
    };

    catalogManagementService.deleteObjectAccess(params)
    .then(res => {
      done();
    })
    .catch(err => {
      console.warn(err)
    });

    // end-delete_object_access
  });

  test('deleteObject request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-delete_object

    const params = {
      catalogIdentifier: catalogId,
      objectIdentifier: objectId,
    };

    catalogManagementService.deleteObject(params)
    .then(res => {
      done();
    })
    .catch(err => {
      console.warn(err)
    });

    // end-delete_object
  });

  test('deleteOffering request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-delete_offering

    const params = {
      catalogIdentifier: catalogId,
      offeringId: offeringId,
    };

    catalogManagementService.deleteOffering(params)
    .then(res => {
      done();
    })
    .catch(err => {
      console.warn(err)
    });

    // end-delete_offering
  });

  test('deleteCatalog request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-delete_catalog

    const params = {
      catalogIdentifier: catalogId,
    };

    catalogManagementService.deleteCatalog(params)
    .then(res => {
      done();
    })
    .catch(err => {
      console.warn(err)
    });

    // end-delete_catalog
  });

});
