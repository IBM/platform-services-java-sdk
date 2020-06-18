/**
* @jest-environment node
*/
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

const CatalogManagementV1 = require('../dist/catalog-management/v1');

// Save original console.log and console.warn
const originalLog = console.log
const originalWarn = console.warn

// Mocks for console.log and console.warn
const consoleLogMock = jest.spyOn(console, 'log');
const consoleWarnMock = jest.spyOn(console, 'warn');

const catalogManagement = CatalogManagementV1.newInstance({});

describe('CatalogManagementV1', () => {
  test('getCatalogAccount request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-getCatalogAccount

    catalogManagement.getCatalogAccount({})
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-getCatalogAccount
  });
  test('updateCatalogAccount request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-updateCatalogAccount

    catalogManagement.updateCatalogAccount({})
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-updateCatalogAccount
  });
  test('getCatalogAccountFilters request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-getCatalogAccountFilters

    catalogManagement.getCatalogAccountFilters({})
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-getCatalogAccountFilters
  });
  test('listCatalogs request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-listCatalogs

    catalogManagement.listCatalogs({})
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-listCatalogs
  });
  test('createCatalog request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-createCatalog

    catalogManagement.createCatalog({})
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-createCatalog
  });
  test('getCatalog request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-getCatalog

    const params = {
      catalogIdentifier: 'testString',
    };

    catalogManagement.getCatalog(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-getCatalog
  });
  test('replaceCatalog request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-replaceCatalog

    const params = {
      catalogIdentifier: 'testString',
    };

    catalogManagement.replaceCatalog(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-replaceCatalog
  });
  test('getEnterprise request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-getEnterprise

    const params = {
      enterpriseId: 'testString',
    };

    catalogManagement.getEnterprise(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-getEnterprise
  });
  test('replaceEnterprise request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-replaceEnterprise

    const params = {
      enterpriseId: 'testString',
    };

    catalogManagement.replaceEnterprise(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-replaceEnterprise
  });
  test('getConsumptionOfferings request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-getConsumptionOfferings

    catalogManagement.getConsumptionOfferings({})
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-getConsumptionOfferings
  });
  test('listOfferings request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-listOfferings

    const params = {
      catalogIdentifier: 'testString',
    };

    catalogManagement.listOfferings(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-listOfferings
  });
  test('createOffering request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-createOffering

    const params = {
      catalogIdentifier: 'testString',
    };

    catalogManagement.createOffering(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-createOffering
  });
  test('importOfferingVersion request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-importOfferingVersion

    const params = {
      catalogIdentifier: 'testString',
      offeringId: 'testString',
      zipurl: 'testString',
    };

    catalogManagement.importOfferingVersion(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-importOfferingVersion
  });
  test('importOffering request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-importOffering

    const params = {
      catalogIdentifier: 'testString',
      zipurl: 'testString',
    };

    catalogManagement.importOffering(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-importOffering
  });
  test('reloadOffering request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-reloadOffering

    const params = {
      catalogIdentifier: 'testString',
      offeringId: 'testString',
      zipurl: 'testString',
      targetVersion: 'testString',
    };

    catalogManagement.reloadOffering(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-reloadOffering
  });
  test('getOffering request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-getOffering

    const params = {
      catalogIdentifier: 'testString',
      offeringId: 'testString',
    };

    catalogManagement.getOffering(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-getOffering
  });
  test('replaceOffering request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-replaceOffering

    const params = {
      catalogIdentifier: 'testString',
      offeringId: 'testString',
    };

    catalogManagement.replaceOffering(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-replaceOffering
  });
  test('replaceOfferingIcon request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-replaceOfferingIcon

    const params = {
      catalogIdentifier: 'testString',
      offeringId: 'testString',
      fileName: 'testString',
    };

    catalogManagement.replaceOfferingIcon(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-replaceOfferingIcon
  });
  test('updateOfferingIbm request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-updateOfferingIbm

    const params = {
      catalogIdentifier: 'testString',
      offeringId: 'testString',
      approvalType: 'ibm',
      approved: 'true',
    };

    catalogManagement.updateOfferingIbm(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-updateOfferingIbm
  });
  test('getVersionAbout request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-getVersionAbout

    const params = {
      versionLocId: 'testString',
    };

    catalogManagement.getVersionAbout(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-getVersionAbout
  });
  test('getVersionLicense request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-getVersionLicense

    const params = {
      versionLocId: 'testString',
      licenseId: 'testString',
    };

    catalogManagement.getVersionLicense(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-getVersionLicense
  });
  test('getVersionContainerImages request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-getVersionContainerImages

    const params = {
      versionLocId: 'testString',
    };

    catalogManagement.getVersionContainerImages(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-getVersionContainerImages
  });
  test('deprecateVersion request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-deprecateVersion

    const params = {
      versionLocId: 'testString',
    };

    catalogManagement.deprecateVersion(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-deprecateVersion
  });
  test('accountPublishVersion request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-accountPublishVersion

    const params = {
      versionLocId: 'testString',
    };

    catalogManagement.accountPublishVersion(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-accountPublishVersion
  });
  test('ibmPublishVersion request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-ibmPublishVersion

    const params = {
      versionLocId: 'testString',
    };

    catalogManagement.ibmPublishVersion(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-ibmPublishVersion
  });
  test('publicPublishVersion request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-publicPublishVersion

    const params = {
      versionLocId: 'testString',
    };

    catalogManagement.publicPublishVersion(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-publicPublishVersion
  });
  test('commitVersion request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-commitVersion

    const params = {
      versionLocId: 'testString',
    };

    catalogManagement.commitVersion(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-commitVersion
  });
  test('getVersionWorkingCopy request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-getVersionWorkingCopy

    const params = {
      versionLocId: 'testString',
    };

    catalogManagement.getVersionWorkingCopy(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-getVersionWorkingCopy
  });
  test('getVersionUpdates request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-getVersionUpdates

    const params = {
      versionLocId: 'testString',
    };

    catalogManagement.getVersionUpdates(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-getVersionUpdates
  });
  test('getVersion request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-getVersion

    const params = {
      versionLocId: 'testString',
    };

    catalogManagement.getVersion(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-getVersion
  });
  test('listVersions request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-listVersions

    const params = {
      q: 'testString',
    };

    catalogManagement.listVersions(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-listVersions
  });
  test('getRepos request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-getRepos

    const params = {
      type: 'testString',
      repourl: 'testString',
    };

    catalogManagement.getRepos(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-getRepos
  });
  test('getRepo request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-getRepo

    const params = {
      type: 'testString',
      charturl: 'testString',
    };

    catalogManagement.getRepo(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-getRepo
  });
  test('listClusters request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-listClusters

    catalogManagement.listClusters({})
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-listClusters
  });
  test('getCluster request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-getCluster

    const params = {
      clusterId: 'testString',
      region: 'testString',
      xAuthRefreshToken: 'testString',
    };

    catalogManagement.getCluster(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-getCluster
  });
  test('getNamespaces request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-getNamespaces

    const params = {
      clusterId: 'testString',
      region: 'testString',
      xAuthRefreshToken: 'testString',
    };

    catalogManagement.getNamespaces(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-getNamespaces
  });
  test('createOperator request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-createOperator

    const params = {
      xAuthRefreshToken: 'testString',
    };

    catalogManagement.createOperator(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-createOperator
  });
  test('listOperators request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-listOperators

    const params = {
      xAuthRefreshToken: 'testString',
      clusterId: 'testString',
      region: 'testString',
      versionLocatorId: 'testString',
    };

    catalogManagement.listOperators(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-listOperators
  });
  test('replaceOperator request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-replaceOperator

    const params = {
      xAuthRefreshToken: 'testString',
    };

    catalogManagement.replaceOperator(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-replaceOperator
  });
  test('installVersion request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-installVersion

    const params = {
      versionLocId: 'testString',
      xAuthRefreshToken: 'testString',
    };

    catalogManagement.installVersion(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-installVersion
  });
  test('preinstallVersion request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-preinstallVersion

    const params = {
      versionLocId: 'testString',
      xAuthRefreshToken: 'testString',
    };

    catalogManagement.preinstallVersion(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-preinstallVersion
  });
  test('getPreinstall request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-getPreinstall

    const params = {
      versionLocId: 'testString',
      xAuthRefreshToken: 'testString',
    };

    catalogManagement.getPreinstall(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-getPreinstall
  });
  test('validationInstall request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-validationInstall

    const params = {
      versionLocId: 'testString',
      xAuthRefreshToken: 'testString',
    };

    catalogManagement.validationInstall(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-validationInstall
  });
  test('getValidationStatus request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-getValidationStatus

    const params = {
      versionLocId: 'testString',
      xAuthRefreshToken: 'testString',
    };

    catalogManagement.getValidationStatus(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-getValidationStatus
  });
  test('getOverrideValues request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-getOverrideValues

    const params = {
      versionLocId: 'testString',
    };

    catalogManagement.getOverrideValues(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-getOverrideValues
  });
  test('getSchematicsWorkspaces request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-getSchematicsWorkspaces

    const params = {
      versionLocId: 'testString',
      xAuthRefreshToken: 'testString',
    };

    catalogManagement.getSchematicsWorkspaces(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-getSchematicsWorkspaces
  });
  test('canDeploySchematics request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-canDeploySchematics

    const params = {
      versionLocId: 'testString',
      clusterId: 'testString',
      region: 'testString',
    };

    catalogManagement.canDeploySchematics(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-canDeploySchematics
  });
  test('getResourceGroups request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-getResourceGroups

    catalogManagement.getResourceGroups({})
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-getResourceGroups
  });
  test('getLicenseProviders request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-getLicenseProviders

    catalogManagement.getLicenseProviders({})
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-getLicenseProviders
  });
  test('listLicenseEntitlements request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-listLicenseEntitlements

    catalogManagement.listLicenseEntitlements({})
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-listLicenseEntitlements
  });
  test('createLicenseEntitlement request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-createLicenseEntitlement

    catalogManagement.createLicenseEntitlement({})
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-createLicenseEntitlement
  });
  test('getLicenseEntitlements request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-getLicenseEntitlements

    const params = {
      licenseProductId: 'testString',
    };

    catalogManagement.getLicenseEntitlements(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-getLicenseEntitlements
  });
  test('getLicenses request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-getLicenses

    const params = {
      licenseProviderId: 'testString',
    };

    catalogManagement.getLicenses(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-getLicenses
  });
  test('searchLicenseVersions request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-searchLicenseVersions

    const params = {
      q: 'testString',
    };

    catalogManagement.searchLicenseVersions(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-searchLicenseVersions
  });
  test('searchLicenseOfferings request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-searchLicenseOfferings

    const params = {
      q: 'testString',
    };

    catalogManagement.searchLicenseOfferings(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-searchLicenseOfferings
  });
  test('deleteVersion request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-deleteVersion

    const params = {
      versionLocId: 'testString',
    };

    catalogManagement.deleteVersion(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-deleteVersion
  });
  test('deleteOperator request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-deleteOperator

    const params = {
      xAuthRefreshToken: 'testString',
      clusterId: 'testString',
      region: 'testString',
      versionLocatorId: 'testString',
    };

    catalogManagement.deleteOperator(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-deleteOperator
  });
  test('deleteOffering request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-deleteOffering

    const params = {
      catalogIdentifier: 'testString',
      offeringId: 'testString',
    };

    catalogManagement.deleteOffering(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-deleteOffering
  });
  test('deleteLicenseEntitlement request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-deleteLicenseEntitlement

    const params = {
      entitlementId: 'testString',
    };

    catalogManagement.deleteLicenseEntitlement(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-deleteLicenseEntitlement
  });
  test('deleteCatalog request example', done => {

    consoleLogMock.mockImplementation(output => {
        done();
    });
    consoleWarnMock.mockImplementation(output => {
        done(output);
    });

    // begin-deleteCatalog

    const params = {
      catalogIdentifier: 'testString',
    };

    catalogManagement.deleteCatalog(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-deleteCatalog
  });
});
