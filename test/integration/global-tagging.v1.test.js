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
const GlobalTaggingV1 = require('../../dist/global-tagging/v1');
const { readExternalSources } = require('ibm-cloud-sdk-core');
const authHelper = require('../resources/auth-helper.js');

// testcase timeout value (10s).
const timeout = 10000;

// Location of our config file.
const configFile = 'global_tagging.env';

const describe = authHelper.prepareTests(configFile);

let resourceCrn;

describe('GlobalTaggingV1_integration', () => {
  const globalTaggingService = GlobalTaggingV1.newInstance({});

  const config = readExternalSources(GlobalTaggingV1.DEFAULT_SERVICE_NAME);
  expect(globalTaggingService).not.toBeNull();
  expect(config).not.toBeNull();
  // console.log('config: ', config)

  const serviceUrl = config.url;
  expect(serviceUrl).toBeDefined();

  resourceCrn = config.resourceCrn;
  expect(resourceCrn).toBeDefined();

  const tagName = 'node-sdk-' + Math.floor(Math.random() * 100000 + 1).toString();

  // console.log('Service URL: ', serviceUrl);
  // console.log('Resource CRN: ', resourceCrn);
  // console.log('Test tag: ', tagName);

  jest.setTimeout(timeout);

  test('listTags()', done => {
    const params = {
      offset: 0,
      limit: 1000,
    };

    globalTaggingService
      .listTags(params)
      .then(res => {
        expect(res).not.toBeNull();
        expect(res.status).toBe(200);

        const result = res.result;
        expect(result).toBeDefined();
        // console.log('listTags() result: ', result)
        expect(result.items).toBeDefined();
        done();
      })
      .catch(err => {
        console.warn(err);
        done(err);
      });
  });
  test('attachTag()', async done => {
    // Request models needed by this operation.
    const resourceModel = {
      resource_id: resourceCrn,
    };

    const params = {
      resources: [resourceModel],
      tagNames: [tagName],
    };

    globalTaggingService
      .attachTag(params)
      .then(res => {
        expect(res).not.toBeNull();
        expect(res.status).toBe(200);

        const result = res.result;
        expect(result).toBeDefined();
        // console.log('attachTag() result: ', result)

        expect(result.results).toBeDefined();
        result.results.forEach(elem => {
          expect(elem.is_error).toBe(false);
        });

        // Make sure the tag was in fact attached to the resource.
        getTagNamesForResource(globalTaggingService, resourceCrn).then(tagNames => {
          expect(tagNames.includes(tagName)).toBe(true);
          done();
        });
      })
      .catch(err => {
        console.warn(err);
        done(err);
      });
  });
  test('detachTag()', done => {
    // Request models needed by this operation.
    const resourceModel = {
      resource_id: resourceCrn,
    };

    const params = {
      resources: [resourceModel],
      tagNames: [tagName],
    };

    globalTaggingService
      .detachTag(params)
      .then(res => {
        const result = res.result;
        expect(result).toBeDefined();
        // console.log('detachTag() result: ', result)

        expect(result.results).toBeDefined();
        result.results.forEach(elem => {
          expect(elem.is_error).toBe(false);
        });

        // Make sure the tag was in fact attached to the resource.
        getTagNamesForResource(globalTaggingService, resourceCrn).then(tagNames => {
          expect(tagNames.includes(tagName)).toBe(false);
          done();
        });
      })
      .catch(err => {
        console.warn(err);
        done(err);
      });
  });
  test('deleteTag()', done => {
    const params = {
      tagName: tagName,
    };

    globalTaggingService
      .deleteTag(params)
      .then(res => {
        const result = res.result;
        expect(result).toBeDefined();
        // console.log('deleteTag() result: ', result)

        expect(result.results).toBeDefined();
        result.results.forEach(elem => {
          expect(elem.is_error).toBe(false);
        });
        done();
      })
      .catch(err => {
        console.warn(err);
        done(err);
      });
  });
  test('deleteTagAll()', done => {
    const params = {};

    globalTaggingService
      .deleteTagAll(params)
      .then(res => {
        const result = res.result;
        expect(result).toBeDefined();
        // console.log('deleteTagAll() result: ', result)

        expect(result.items).toBeDefined();
        result.items.forEach(elem => {
          expect(elem.is_error).toBe(false);
        });
        done();
      })
      .catch(err => {
        console.warn(err);
        done(err);
      });
  });
});

async function getTagNamesForResource(service, resourceId) {
  const tagNames = [];

  const params = {
    offset: 0,
    limit: 1000,
    attachedTo: resourceId,
  };
  const response = await service.listTags(params);
  expect(response).toBeDefined();
  const result = response.result;
  if (result.items) {
    result.items.forEach(tag => {
      tagNames.push(tag.name);
    });
  }

  return tagNames;
}
