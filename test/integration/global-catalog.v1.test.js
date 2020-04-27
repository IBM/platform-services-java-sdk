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

const GlobalCatalogV1 = require('../../dist/global-catalog/v1');
const authHelper = require('../resources/auth-helper.js');

const timeout = 25000;
const configFile = 'global_catalog.env';
const describe = authHelper.prepareTests(configFile);

describe('GlobalCatalogV1_integration', () => {
    jest.setTimeout(timeout);

    let service;

    const timestamp = Math.floor(new Date() / 1000);

    const defaultEntry = {
        'name': `someName${timestamp}`,
        'id': `someId${timestamp}`,
        'active': false,
        'kind': 'service',
        'disabled': false,
        'tags': ['a', 'b', 'c'],
        'overviewUi': {
            'en': {
                'display_name': 'display',
                'long_description': 'longDesc',
                'description': 'desc'
            }
        },
        'images': {
            'image': 'image',
            'small_image': 'small',
            'medium_image': 'medium',
            'feature_image': 'feature'
        },
        'provider': {
            'email': 'bogus@us.ibm.com',
            'name': 'someName'
        },
        'restrictions': 'private',
        'metadata': {
            'pricing': {
                'origin': 'global_catalog'
            }
        },
        'artifactId': 'someArtifactId.json',
        'artifact': {
            'someKey': 'someValue'
        }
    };

    const defaultChildEntry = {
        'name': `someChildName${timestamp}`,
        'id': `someChildId${timestamp}`,
        'parentId': defaultEntry.id,
        'active': false,
        'kind': 'service',
        'disabled': false,
        'tags': ['a', 'b', 'c'],
        'overviewUi': {
            'en': {
                'display_name': 'display',
                'long_description': 'longDesc',
                'description': 'desc'
            }
        },
        'images': {
            'image': 'image',
            'small_image': 'small',
            'medium_image': 'medium',
            'feature_image': 'feature'
        },
        'provider': {
            'email': 'bogus@us.ibm.com',
            'name': 'someName'
        }
    };

    const updatedEntry = {
        'name': `someNameUpdated${timestamp}`,
        'id': `someId${timestamp}`,
        'active': false,
        'kind': 'template',
        'disabled': false,
        'tags': ['x', 'y', 'z'],                            // tags are case-sensitive
        'overviewUi': {
            'en': {
                'display_name': 'displayUpdated',
                'long_description': 'longDescUpdated',
                'description': 'descUpdated'
            }
        },
        'images': {
            'image': 'imageUpdated',
            'small_image': 'smallUpdated',
            'medium_image': 'mediumUpdated',
            'feature_image': 'featureUpdated'
        },
        'provider': {
            'email': 'bogus@us.ibm.com',
            'name': 'someNameUpdated'
        }
    };

    beforeAll(() => {
        service = GlobalCatalogV1.newInstance();
    });

    beforeEach(async done => {
        await service.deleteCatalogEntry(defaultEntry);
        done();
    });

    afterEach(async done => {
        await service.deleteCatalogEntry(defaultEntry);
        done();
    });

    test('Create catalog entry', async done => {
        let response;

        try {
            response = await service.createCatalogEntry(defaultEntry);
        } catch (err) {
            done(err);
        }

        expect(response).toBeDefined();
        expect(response.status).toEqual(201);

        const { result } = response || {};
        expect(result).toBeDefined();
        expect(result.id).toEqual(defaultEntry.id);
        expect(result.name).toEqual(defaultEntry.name);
        expect(result.kind).toEqual(defaultEntry.kind);
        expect(result.images).toEqual(defaultEntry.images);
        expect(result.disabled).toEqual(defaultEntry.disabled);
        expect(result.tags).toEqual(defaultEntry.tags);
        expect(result.provider).toEqual(defaultEntry.provider);

        done();
    });

    test('Get catalog entry', async done => {
        let response;

        try {
            await service.createCatalogEntry(defaultEntry);
            response = await service.getCatalogEntry(defaultEntry);
        } catch (err) {
            done(err);
        }

        expect(response).toBeDefined();
        expect(response.status).toEqual(200);

        const { result } = response || {};
        expect(result).toBeDefined();
        expect(result.id).toEqual(defaultEntry.id);
        expect(result.name).toEqual(defaultEntry.name);
        expect(result.overview_ui).toEqual(defaultEntry.overviewUi);
        expect(result.kind).toEqual(defaultEntry.kind);
        expect(result.images).toEqual(defaultEntry.images);
        expect(result.disabled).toEqual(defaultEntry.disabled);
        expect(result.tags).toEqual(defaultEntry.tags);
        expect(result.provider).toEqual(defaultEntry.provider);

        done();
    });

    test('Update catalog entry', async done => {
        let response;

        try {
            await service.createCatalogEntry(defaultEntry);
            response = await service.updateCatalogEntry(updatedEntry);
        } catch (err) {
            done(err);
        }

        expect(response).toBeDefined();
        expect(response.status).toEqual(200);

        const { result } = response || {};
        expect(result).toBeDefined();
        expect(result.id).toEqual(updatedEntry.id);
        expect(result.name).toEqual(updatedEntry.name);
        expect(result.overview_ui).toEqual(updatedEntry.overviewUi);
        expect(result.kind).toEqual(updatedEntry.kind);
        expect(result.images).toEqual(updatedEntry.images);
        expect(result.disabled).toEqual(updatedEntry.disabled);
        expect(result.tags).toEqual(updatedEntry.tags);
        expect(result.provider).toEqual(updatedEntry.provider);

        done();
    });

    test('Delete catalog entry', async done => {
        let response;

        try {
            await service.createCatalogEntry(defaultEntry);
            response = await service.deleteCatalogEntry(updatedEntry);
        } catch (err) {
            done(err);
        }

        expect(response).toBeDefined();
        expect(response.status).toEqual(200);

        const { result } = response || {};
        expect(result).toBeDefined();

        done();
    });

    test('Fail to get catalog entry after deletion', async done => {
        expect.assertions(1);

        try {
            await service.createCatalogEntry(defaultEntry);
            await service.deleteCatalogEntry(defaultEntry);
        } catch (err) {
            done(err);
        }

        try {
            await service.getCatalogEntry(defaultEntry);
        } catch (err) {
            expect(err.status).toEqual(404);
            done();
        }
    });

    test('Fail to get catalog entry that does not exist', async done => {
        expect.assertions(1);

        try {
            const args = {'id': 'bogus'}
            await service.getCatalogEntry(args);
        } catch (err) {
            expect(err.status).toEqual(404);
            done();
        }
    });

    test('Fail to delete catalog entry that does not exist', async done => {
        let response;

        try {
            const args = {'id': 'bogus'}
            response = await service.deleteCatalogEntry(args);
        } catch (err) {
            done(err);
        }

        expect(response).toBeDefined();
        expect(response.status).toEqual(200);

        const { result } = response || {};
        expect(result).toBeDefined();

        done();
    });

    test('Fail to update catalog entry that does not exist', async done => {
        expect.assertions(1);

        try {
            await service.getCatalogEntry(updatedEntry)
        } catch (err) {
            expect(err.status).toEqual(404);
            done();
        }
    });

    test('Fail to create catalog entry that already exists', async done => {
        expect.assertions(1);

        try {
            await service.createCatalogEntry(defaultEntry);
        } catch (err) {
            done(err);
        }

        try {
            await service.createCatalogEntry(defaultEntry);
        } catch (err) {
            expect(err.status).toEqual(409);
            done();
        }
    });

    test('List catalog entry', async done => {
        let response;

        try {
            response = await service.listCatalogEntries();
        } catch (err) {
            done(err);
        }

        expect(response).toBeDefined();
        expect(response.status).toEqual(200);

        const { result } = response || {};
        expect(result).toBeDefined();

        const { resources } = result || {};
        expect(resources).toBeDefined();
        expect(resources.length).toBeGreaterThan(0);

        done();
    });

    test('Get child catalog entry', async done => {
        let response;

        try {
            await service.createCatalogEntry(defaultEntry);
            await service.createCatalogEntry(defaultChildEntry);
            response = await service.getChildObjects(defaultEntry);
        } catch (err) {
            done(err);
        }

        expect(response).toBeDefined();
        expect(response.status).toEqual(200);

        const { result } = response || {};
        expect(result).toBeDefined();
        expect(result.offset).toEqual(0);
        expect(result.count).toEqual(1);
        expect(result.resource_count).toEqual(1);

        const { resources } = result || {};
        expect(resources).toBeDefined();
        expect(resources.length).toEqual(1);
        expect(resources[0].id).toEqual(defaultChildEntry.id);
        expect(resources[0].name).toEqual(defaultChildEntry.name);
        expect(resources[0].active).toEqual(defaultChildEntry.active);
        expect(resources[0].disabled).toEqual(defaultChildEntry.disabled);
        expect(resources[0].kind).toEqual(defaultChildEntry.kind);
        expect(resources[0].images).toEqual(defaultChildEntry.images);
        expect(resources[0].disabled).toEqual(defaultChildEntry.disabled);
        expect(resources[0].tags).toEqual(defaultChildEntry.tags);
        expect(resources[0].provider).toEqual(defaultChildEntry.provider);

        done();
    });

    test('Fail to get child catalog entry that does not exist', async done => {
        expect.assertions(1);
        try {
            const args = {'id': 'bogus', 'kind': 'bogus'}
            await service.getChildObjects(args);
        } catch (err) {
            expect(err.status).toEqual(404);
            done();
        }
    });

    test('Restore catalog entry', async done => {
        let response;

        try {
            await service.createCatalogEntry(defaultEntry);
            await service.deleteCatalogEntry(defaultEntry);
            response = await service.restoreCatalogEntry(defaultEntry);
        } catch (err) {
            done(err);
        }

        expect(response).toBeDefined();
        expect(response.status).toEqual(200);

        try {
            response = await service.getCatalogEntry(defaultEntry);
        } catch (err) {
            done(err);
        }

        expect(response).toBeDefined();
        expect(response.status).toEqual(200);

        const { result } = response || {};
        expect(result).toBeDefined();
        expect(result.id).toEqual(defaultEntry.id);
        expect(result.name).toEqual(defaultEntry.name);
        expect(result.overview_ui).toEqual(defaultEntry.overviewUi);
        expect(result.kind).toEqual(defaultEntry.kind);
        expect(result.images).toEqual(defaultEntry.images);
        expect(result.disabled).toEqual(defaultEntry.disabled);
        expect(result.tags).toEqual(defaultEntry.tags);
        expect(result.provider).toEqual(defaultEntry.provider);

        done();
    });

    test('Fail to restore catalog entry that does not exist', async done => {
        expect.assertions(1);

        try {
            const args = {'id': 'bogus'};
            await service.getCatalogEntry(args);
        } catch (err) {
            expect(err.status).toEqual(404);
            done();
        }
    });

    test('Get catalog entry visibility', async done => {
        let response;

        try {
            await service.createCatalogEntry(defaultEntry);
            response = await service.getVisibility(defaultEntry);
        } catch (err) {
            done(err);
        }

        expect(response).toBeDefined();
        expect(response.status).toEqual(200);

        const { result } = response || {};
        expect(result).toBeDefined();
        expect(result.restrictions).toEqual(defaultEntry.restrictions);

        done();
    });

    test('Fail to get visibility for catalog entry that does not exist', async done => {
        expect.assertions(1);
        try {
            const args = {'id': 'bogus'};
            await service.getVisibility(args);
        } catch (err) {
            expect(err.status).toEqual(404);
            done();
        }
    });

    test('Update catalog entry visibility', async done => {
        expect.assertions(1);

        try {
            await service.createCatalogEntry(defaultEntry);
        } catch (err) {
            done(err);
        }

        try {
            await service.updateVisibility(defaultEntry);
        } catch (err) {
            expect(err.status).toEqual(403);
            done();
        }
    });

    test('Fail to update visibility for catalog entry that does not exist', async done => {
        expect.assertions(1);

        try {
            const args = {'id': 'bogus'}
            await service.updateVisibility(args);
        } catch (err) {
            expect(err.status).toEqual(404);
            done();
        }
    });

    test('Fail to get catalog entry pricing', async done => {
        expect.assertions(1);

        try {
            await service.createCatalogEntry(defaultEntry);
        } catch (err) {
            done(err);
        }

        try {
            await service.getPricing(defaultEntry);
        } catch (err) {
            expect(err.status).toEqual(404);
            done();
        }

        try {
            const args = {'id': 'bogus'};
            await service.getPricing(args);
        } catch (err) {
            expect(err.status).toEqual(404);
            done();
        }
    });

    test('List catalog entry artifacts', async done => {
        let response;

        try {
            await service.createCatalogEntry(defaultEntry);
            const args = {'objectId': defaultEntry.id, 'artifactId': defaultEntry.artifactId, 'artifact': defaultEntry.artifact};
            await service.uploadArtifact(args);
            response = await service.listArtifacts(args);
        } catch (err) {
            done(err);
        }

        expect(response).toBeDefined();
        expect(response.status).toEqual(200);

        const { result } = response || {};
        expect(result).toBeDefined();
        expect(result.count).toEqual(1);

        const { resources } = result || {};
        expect(resources).toBeDefined();
        expect(resources.length).toEqual(1);
        expect(resources[0].name).toEqual(defaultEntry.artifactId);
        expect(resources[0].url).toEqual(`${service.baseOptions.serviceUrl}/${defaultEntry.id}/artifacts/${defaultEntry.artifactId}`);
        expect(resources[0].size).toEqual(23);

        done();
    });

    test('Fail to list catalog entry artifacts', async done => {
        let response;

        try {
            const args = {'objectId': 'bogus'};
            response = await service.listArtifacts(args);
        } catch (err) {
            done(err);
        }

        expect(response).toBeDefined();
        expect(response.status).toEqual(200);

        const { result } = response || {};
        expect(result).toBeDefined();
        expect(result.count).toEqual(0);

        done();
    });

    test('Get catalog entry artifact', async done => {
        let response;

        try {
            await service.createCatalogEntry(defaultEntry);
            const args = {'objectId': defaultEntry.id, 'artifactId': defaultEntry.artifactId, 'artifact': defaultEntry.artifact};
            await service.uploadArtifact(args);
            response = await service.getArtifact(args);
        } catch (err) {
            done(err);
        }

        expect(response).toBeDefined();
        expect(response.status).toEqual(200);

        const { result } = response || {};
        expect(result).toBeDefined();
        expect(result).toEqual(defaultEntry.artifact)

        done();
    });

    test('Fail to get catalog entry artifact', async done => {
        expect.assertions(2);

        try {
            await service.createCatalogEntry(defaultEntry);
        } catch (err) {
            done(err);
        }

        try {
            const args = {'objectId': defaultEntry.id, 'artifactId': 'bogus'};
            await service.getArtifact(args);
        } catch (err) {
            expect(err.status).toEqual(404);
            done();
        }

        try {
            const args = {'objectId': 'bogus', 'artifactId': 'bogus'};
            await service.getArtifact(args);
        } catch (err) {
            expect(err.status).toEqual(404);
            done();
        }
    });

    test('Create catalog entry artifact', async done => {
        let response;

        try {
            await service.createCatalogEntry(defaultEntry);
            const args = {'objectId': defaultEntry.id, 'artifactId': defaultEntry.artifactId, 'artifact': defaultEntry.artifact};
            response = await service.uploadArtifact(args);
        } catch (err) {
            done(err);
        }

        expect(response).toBeDefined();
        expect(response.status).toEqual(200);

        const { result } = response || {};
        expect(result).toBeDefined();

        done();
    });


    test('Fail to create catalog entry artifact', async done => {
        expect.assertions(1);

        try {
            const args = {'objectId': 'bogus', 'artifactId': 'bogus', 'artifact': defaultEntry.artifact};
            await service.uploadArtifact(args);
        } catch (err) {
            expect(err.status).toEqual(404);
            done();
        }
    });

    test('Delete catalog entry artifact', async done => {
        let response;

        try {
            await service.createCatalogEntry(defaultEntry);
            const args = {'objectId': defaultEntry.id, 'artifactId': defaultEntry.artifactId, 'artifact': defaultEntry.artifact};
            await service.uploadArtifact(args);
            response = await service.deleteArtifact(args);
        } catch (err) {
            done(err);
        }

        expect(response).toBeDefined();
        expect(response.status).toEqual(200);

        const { result } = response || {};
        expect(result).toBeDefined();

        done();
    });

    test('Fail to delete catalog entry artifact', async done => {
        expect.assertions(1);

        try {
            const args = {'objectId': 'bogus', 'artifactId': 'bogus'};
            await service.deleteArtifact(args);
        } catch (err) {
            expect(err.status).toEqual(404);
            done();
        }
    });

});
