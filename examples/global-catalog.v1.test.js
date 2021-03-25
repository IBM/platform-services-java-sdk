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

const GlobalCatalogV1 = require('../dist/global-catalog/v1');
const { readExternalSources, streamToPromise } = require('ibm-cloud-sdk-core');
const authHelper = require('../test/resources/auth-helper.js');
const { CreateCatalogEntryConstants, UpdateCatalogEntryConstants } = require('../dist/global-catalog/v1');
const { v4: uuidv4 } = require('uuid');

//
// This file provides an example of how to use the Global Catalog service.
//
// The following configuration properties are assumed to be defined:
//
// GLOBAL_CATALOG_URL=<service url>
// GLOBAL_CATALOG_AUTH_TYPE=iam
// GLOBAL_CATALOG_APIKEY=<IAM apikey>
// GLOBAL_CATALOG_AUTH_URL=<IAM token service URL - omit this if using the production environment>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
const configFile = 'global_catalog.env';

const describe = authHelper.prepareTests(configFile);
const timeout = 60000;

// Save original console.log and console.warn
const originalLog = console.log;
const originalWarn = console.warn;

// Mocks for console.log and console.warn
const consoleLogMock = jest.spyOn(console, 'log');
const consoleWarnMock = jest.spyOn(console, 'warn');

describe('GlobalCatalogV1', () => {
  jest.setTimeout(timeout);

  // begin-common

  const globalCatalogService = GlobalCatalogV1.newInstance({});

  // end-common

  const config = readExternalSources(GlobalCatalogV1.DEFAULT_SERVICE_NAME);

  // Global variables to hold values shared between testcases.
  let catalogEntryId;


  test('createCatalogEntry request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-create_catalog_entry
    const overviewModelEN = {
      display_name: 'Example Web Starter',
      description: 'Use the Example service in your applications',
      long_description: 'This is a starter that helps you use the Example service within your applications.',
    };
    const overviewUIModel = {
      en: overviewModelEN,
    };
    const imageModel = {
      image: 'https://somehost.com/examplewebstarter/cachedIcon/large/0',
      small_image: 'https://somehost.com/examplewebstarter/cachedIcon/small/0',
      medium_image: 'https://somehost.com/examplewebstarter/cachedIcon/medium/0',
      feature_image: 'https://somehost.com/examplewebstarter/cachedIcon/large/0',
    };
    const providerModel = {
      email: 'info@examplestarter.com',
      name: 'Example Starter Co., Inc.',
      contact: 'Example Starter Developer Relations',
      support_email: 'support@examplestarter.com',
      phone: '800-555-1234',
    };
    const metadataModel = {
      version: '1.0.0',
    };

    catalogEntryId = uuidv4();

    const params = {
      name: 'exampleWebStarter123',
      kind: CreateCatalogEntryConstants.Kind.TEMPLATE,
      overviewUi: overviewUIModel,
      images: imageModel,
      disabled: false,
      tags: ['example-tag-1', 'example-tag-2'],
      provider: providerModel,
      id: catalogEntryId,
      active: true,
      metadata: metadataModel,
    };

    globalCatalogService.createCatalogEntry(params)
      .then(res => {
        console.log('createCatalogEntry() result:\n' + JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-create_catalog_entry
  });
  test('getCatalogEntry request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(catalogEntryId).not.toBeNull();

    // begin-get_catalog_entry

    const params = {
      id: catalogEntryId,
      complete: true,
    };

    globalCatalogService.getCatalogEntry(params)
      .then(res => {
        console.log('getCatalogEntry() result:\n' + JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-get_catalog_entry
  });
  test('updateCatalogEntry request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(catalogEntryId).not.toBeNull();

    // begin-update_catalog_entry
    const overviewModelEN = {
      display_name: 'Example Web Starter V2',
      description: 'Use the Example V2 service in your applications',
      long_description: 'This is a starter that helps you use the Example V2 service within your applications.',
    };
    const overviewUIModel = {
      en: overviewModelEN,
    };
    const imageModel = {
      image: 'https://somehost.com/examplewebstarter/cachedIcon/large/0',
      small_image: 'https://somehost.com/examplewebstarter/cachedIcon/small/0',
      medium_image: 'https://somehost.com/examplewebstarter/cachedIcon/medium/0',
      feature_image: 'https://somehost.com/examplewebstarter/cachedIcon/large/0',
    };
    const providerModel = {
      email: 'info@examplestarter.com',
      name: 'Example Starter Co., Inc.',
      contact: 'Example Starter Developer Relations',
      support_email: 'support@examplestarter.com',
      phone: '800-555-1234',
    };
    const metadataModel = {
      version: '2.0.0',
    };

    const params = {
      id: catalogEntryId,
      name: 'exampleWebStarter123',
      kind: UpdateCatalogEntryConstants.Kind.TEMPLATE,
      overviewUi: overviewUIModel,
      images: imageModel,
      disabled: false,
      tags: ['example-tag-1', 'example-tag-2', 'new-example-tag-3'],
      provider: providerModel,
      active: true,
      metadata: metadataModel,
    };

    globalCatalogService.updateCatalogEntry(params)
      .then(res => {
        console.log('updateCatalogEntry() result:\n' + JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-update_catalog_entry
  });
  test('listCatalogEntries request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-list_catalog_entries
    const params = {
      offset: 0,
      limit: 10,
      q: 'kind:template tag:example-tag-1',
      complete: true,
    };
    globalCatalogService.listCatalogEntries(params)
      .then(res => {
        console.log('listCatalogEntries() result:\n' + JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-list_catalog_entries
  });
  test('getChildObjects request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(catalogEntryId).not.toBeNull();

    // begin-get_child_objects

    const params = {
      id: catalogEntryId,
      kind: '*',
      offset: 0,
      limit: 10,
      complete: true,
    };

    globalCatalogService.getChildObjects(params)
      .then(res => {
        console.log('getChildObjects() result:\n' + JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-get_child_objects
  });
  test('restoreCatalogEntry request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(catalogEntryId).not.toBeNull();

    // begin-restore_catalog_entry

    const params = {
      id: catalogEntryId,
    };

    globalCatalogService.restoreCatalogEntry(params)
      .then(res => {
        console.log('restoreCatalogEntry() response status code: ' + res.status);
      })
      .catch(err => {
        console.warn(err)
      });

    // end-restore_catalog_entry
  });
  test('getVisibility request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(catalogEntryId).not.toBeNull();

    // begin-get_visibility

    const params = {
      id: catalogEntryId,
    };

    globalCatalogService.getVisibility(params)
      .then(res => {
        console.log('getVisibility() result:\n' + JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-get_visibility
  });
  test('updateVisibility request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(catalogEntryId).not.toBeNull();

    // begin-update_visibility

    const params = {
      id: catalogEntryId,
      extendable: false,
    };

    globalCatalogService.updateVisibility(params)
      .then(res => {
        console.log('updateVisibility() response status code: ' + res.status);
      })
      .catch(err => {
        console.log('updateVisibility() returned the following error: ' + err);
      });

    // end-update_visibility
  });
  test('getPricing request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(catalogEntryId).not.toBeNull();

    // begin-get_pricing

    const params = {
      id: catalogEntryId,
    };

    globalCatalogService.getPricing(params)
      .then(res => {
        console.log('getPricing() result:\n' + JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-get_pricing
  });
  test('getAuditLogs request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(catalogEntryId).not.toBeNull();

    // begin-get_audit_logs

    const params = {
      id: catalogEntryId,
      offset: 0,
      limit: 10,
    };

    globalCatalogService.getAuditLogs(params)
      .then(res => {
        console.log('getAuditLogs() result:\n' + JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-get_audit_logs
  });
  test('uploadArtifact request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(catalogEntryId).not.toBeNull();

    // begin-upload_artifact
    const params = {
      objectId: catalogEntryId,
      artifactId: 'artifact.txt',
      artifact: Buffer.from('This is an example artifact associated with a catalog entry.', 'utf8'),
      contentType: 'text/plain',
    };

    globalCatalogService.uploadArtifact(params)
      .then(res => {
        console.log('uploadArtifact() response status code: ' + res.status);
      })
      .catch(err => {
        console.warn(err)
      });

    // end-upload_artifact
  });
  test('getArtifact request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(catalogEntryId).not.toBeNull();

    let responseContentType = null;

    // begin-get_artifact

    const params = {
      objectId: catalogEntryId,
      artifactId: 'artifact.txt',
    };

    globalCatalogService.getArtifact(params)
      .then(res => {
        responseContentType = res.headers['content-type'];
        return streamToPromise(res.result);
      })
      .then(contents => {
        console.log('getArtifact() result:\n');
        console.log(`Artifact content type: ${responseContentType}\nArtifact contents: ${contents}`);
      })
      .catch(err => {
        console.warn(err)
      });

    // end-get_artifact
  });
  test('listArtifacts request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(catalogEntryId).not.toBeNull();

    // begin-list_artifacts

    const params = {
      objectId: catalogEntryId,
    };

    globalCatalogService.listArtifacts(params)
      .then(res => {
        console.log('listArtifacts() result:\n' + JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-list_artifacts
  });
  test('deleteArtifact request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(catalogEntryId).not.toBeNull();

    // begin-delete_artifact

    const params = {
      objectId: catalogEntryId,
      artifactId: 'artifact.txt',
    };

    globalCatalogService.deleteArtifact(params)
      .then(res => {
        console.log('deleteArtifact() response status code: ' + res.status);
      })
      .catch(err => {
        console.warn(err)
      });

    // end-delete_artifact
  });
  test('deleteCatalogEntry request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    expect(catalogEntryId).not.toBeNull();

    // begin-delete_catalog_entry

    const params = {
      id: catalogEntryId,
    };

    globalCatalogService.deleteCatalogEntry(params)
      .then(res => {
        console.log('deleteCatalogEntry() response status code: ' + res.status);
      })
      .catch(err => {
        console.warn(err)
      });

    // end-delete_catalog_entry
  });
});
