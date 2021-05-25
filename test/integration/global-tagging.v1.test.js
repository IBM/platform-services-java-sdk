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

const { readExternalSources } = require('ibm-cloud-sdk-core');
const GlobalTaggingV1 = require('../../dist/global-tagging/v1');
const authHelper = require('../resources/auth-helper.js');

// testcase timeout value (30s).
const timeout = 30000;

// Location of our config file.
const configFile = 'global_tagging.env';

const describe = authHelper.prepareTests(configFile);

const sdkLabel = 'node-sdk';
const userTag1 = `${sdkLabel}-user-test1`;
const userTag2 = `${sdkLabel}-user-test2`;
const accessTag1 = `env:${sdkLabel}-public`;
const accessTag2 = `region:${sdkLabel}-us-south`;

let globalTaggingService;
let resourceCrn;

describe('GlobalTaggingV1_integration', () => {
  jest.setTimeout(timeout);

  beforeAll(async () => {
    console.log('Starting setup...');
    globalTaggingService = GlobalTaggingV1.newInstance({});
    expect(globalTaggingService).not.toBeNull();

    const config = readExternalSources(GlobalTaggingV1.DEFAULT_SERVICE_NAME);
    expect(config).not.toBeNull();

    const serviceUrl = config.url;
    expect(serviceUrl).toBeDefined();

    resourceCrn = config.resourceCrn;
    expect(resourceCrn).toBeDefined();

    console.log('Service URL: ', serviceUrl);
    console.log('Resource CRN: ', resourceCrn);

    await cleanTags(globalTaggingService, resourceCrn);

    console.log('Finished setup.');
  });

  afterAll(async () => {
    console.log('Starting teardown...');
    await cleanTags(globalTaggingService, resourceCrn);
    console.log('Finished teardown!');
  });

  test('createTag()', async () => {
    const params = {
      tagNames: [accessTag1, accessTag2],
      tagType: 'access',
    };

    const res = await globalTaggingService.createTag(params);
    expect(res).toBeDefined();
    expect(res.result).toBeDefined();

    const { result } = res;
    console.log('createTag() result: ', result);

    expect(result.results).toBeDefined();
    result.results.forEach((elem) => {
      expect(elem.is_error).toBe(false);
    });
  });

  test('attachTag(user)', async () => {
    // Request models needed by this operation.
    const resourceModel = {
      resource_id: resourceCrn,
    };

    const params = {
      resources: [resourceModel],
      tagNames: [userTag1, userTag2],
      tagType: 'user',
    };

    const res = await globalTaggingService.attachTag(params);
    expect(res).not.toBeNull();
    expect(res.status).toBe(200);

    const { result } = res;
    expect(result).toBeDefined();
    console.log('attachTag(user) result: ', result);

    expect(result.results).toBeDefined();
    result.results.forEach((elem) => {
      expect(elem.is_error).toBe(false);
    });

    // Make sure the tags were in fact attached to the resource.
    const tagNames = await getTagNamesForResource(globalTaggingService, resourceCrn, 'user');
    expect(tagNames).toContain(userTag1);
    expect(tagNames).toContain(userTag2);
  });

  test('attachTag(access)', async () => {
    // Request models needed by this operation.
    const resourceModel = {
      resource_id: resourceCrn,
    };

    const params = {
      resources: [resourceModel],
      tagNames: [accessTag1, accessTag2],
      tagType: 'access',
    };

    const res = await globalTaggingService.attachTag(params);
    expect(res).not.toBeNull();
    expect(res.status).toBe(200);

    const { result } = res;
    expect(result).toBeDefined();
    console.log('attachTag(access) result: ', result);

    expect(result.results).toBeDefined();
    result.results.forEach((elem) => {
      expect(elem.is_error).toBe(false);
    });

    // Make sure the tags were in fact attached to the resource.
    const tagNames = await getTagNamesForResource(globalTaggingService, resourceCrn, 'access');
    expect(tagNames).toContain(accessTag1);
    expect(tagNames).toContain(accessTag2);
  });

  test('listTags(user)', async () => {
    const results = [];
    let offset = 0;
    let moreResults = true;
    while (moreResults) {
      const params = {
        offset,
        limit: 500,
        tagType: 'user',
      };

      const res = await globalTaggingService.listTags(params);
      expect(res).not.toBeNull();
      expect(res.status).toBe(200);

      const { result } = res;
      expect(result).toBeDefined();
      expect(result.items).toBeDefined();

      if (result.items.length > 0) {
        results.push(...result.items);
        offset += result.items.length;
      } else {
        moreResults = false;
      }
    }
    console.log(`\nRetrieved a total of ${results.length} user tags.\n`);

    const matches = [];
    results.forEach((tag) => {
      if (tag.name.includes(sdkLabel)) {
        matches.push(tag.name);
      }
    });
    console.log(`Found ${matches.length} user tags containing our label: [${matches}]`);
  });

  test('listTags(access)', async () => {
    const results = [];
    let offset = 0;
    let moreResults = true;
    while (moreResults) {
      const params = {
        offset,
        limit: 500,
        tagType: 'access',
      };

      const res = await globalTaggingService.listTags(params);
      expect(res).not.toBeNull();
      expect(res.status).toBe(200);

      const { result } = res;
      expect(result).toBeDefined();
      expect(result.items).toBeDefined();

      if (result.items.length > 0) {
        results.push(...result.items);
        offset += result.items.length;
      } else {
        moreResults = false;
      }
    }

    console.log(`\nRetrieved a total of ${results.length} access tags.\n`);

    const matches = [];
    results.forEach((tag) => {
      if (tag.name.includes(sdkLabel)) {
        matches.push(tag.name);
      }
    });
    console.log(`Found ${matches.length} access tags containing our label: [${matches}]`);
  });

  test('detachTag(user)', async () => {
    // Request models needed by this operation.
    const resourceModel = {
      resource_id: resourceCrn,
    };

    const params = {
      resources: [resourceModel],
      tagNames: [userTag1, userTag2],
      tagType: 'user',
    };

    const res = await globalTaggingService.detachTag(params);
    const { result } = res;
    expect(result).toBeDefined();
    console.log('detachTag(user) result: ', result);

    expect(result.results).toBeDefined();
    result.results.forEach((elem) => {
      expect(elem.is_error).toBe(false);
    });

    // Make sure the tags were in fact detached from the resource.
    const tagNames = await getTagNamesForResource(globalTaggingService, resourceCrn, 'user');
    expect(tagNames).not.toContain(userTag1);
    expect(tagNames).not.toContain(userTag2);
  });

  test('detachTag(access)', async () => {
    // Request models needed by this operation.
    const resourceModel = {
      resource_id: resourceCrn,
    };

    const params = {
      resources: [resourceModel],
      tagNames: [accessTag1, accessTag2],
      tagType: 'access',
    };

    const res = await globalTaggingService.detachTag(params);
    const { result } = res;
    expect(result).toBeDefined();
    console.log('detachTag(access) result: ', result);

    expect(result.results).toBeDefined();
    result.results.forEach((elem) => {
      expect(elem.is_error).toBe(false);
    });

    // Make sure the tags were in fact detached from the resource.
    const tagNames = await getTagNamesForResource(globalTaggingService, resourceCrn, 'access');
    expect(tagNames).not.toContain(accessTag1);
    expect(tagNames).not.toContain(accessTag2);
  });

  test('deleteTag(user)', async () => {
    const params = {
      tagName: userTag1,
      tagType: 'user',
    };

    const res = await globalTaggingService.deleteTag(params);
    const { result } = res;
    expect(result).toBeDefined();
    console.log('deleteTag(user) result: ', result);

    expect(result.results).toBeDefined();
    result.results.forEach((elem) => {
      expect(elem.is_error).toBe(false);
    });
  });

  test('deleteTag(access)', async () => {
    const params = {
      tagName: accessTag1,
      tagType: 'access',
    };

    const res = await globalTaggingService.deleteTag(params);
    const { result } = res;
    expect(result).toBeDefined();
    console.log('deleteTag(access) result: ', result);

    expect(result.results).toBeDefined();
    result.results.forEach((elem) => {
      expect(elem.is_error).toBe(false);
    });
  });

  test('deleteTagAll(user)', async () => {
    const params = {
      tagType: 'user',
    };

    const res = await globalTaggingService.deleteTagAll(params);
    const { result } = res;
    expect(result).toBeDefined();
    console.log('deleteTagAll(user) result: ', result);

    expect(result.items).toBeDefined();
    result.items.forEach((elem) => {
      expect(elem.is_error).toBe(false);
    });
  });

  test('deleteTagAll(access)', async () => {
    const params = {
      tagType: 'access',
    };

    const res = await globalTaggingService.deleteTagAll(params);
    const { result } = res;
    expect(result).toBeDefined();
    console.log('deleteTagAll(access) result: ', result);

    expect(result.items).toBeDefined();
    result.items.forEach((elem) => {
      expect(elem.is_error).toBe(false);
    });
  });
});

async function getTagNamesForResource(service, resourceId, tagType) {
  const tagNames = [];

  const params = {
    offset: 0,
    limit: 1000,
    attachedTo: resourceId,
    tagType,
  };
  const res = await service.listTags(params);
  expect(res).toBeDefined();
  expect(res.status).toBe(200);
  const { result } = res;
  if (result.items) {
    result.items.forEach((tag) => {
      tagNames.push(tag.name);
    });
  }

  return tagNames;
}

async function detachTag(service, resourceId, tag, tagType) {
  const resourceModel = {
    resource_id: resourceId,
  };

  const params = {
    resources: [resourceModel],
    tagNames: [tag],
    tagType,
  };

  const res = await globalTaggingService.detachTag(params);
  expect(res.status).toBe(200);
  const { result } = res;
  expect(result).toBeDefined();
}

async function deleteTag(service, tag, tagType) {
  const params = {
    tagName: tag,
    tagType,
  };

  const res = await service.deleteTag(params);
  expect(res).toBeDefined();
  const { result } = res;
  expect(result).toBeDefined();

  expect(result.results).toBeDefined();
  result.results.forEach((elem) => {
    expect(elem.is_error).toBe(false);
  });
}

async function listTagsWithLabel(service, tagType, label) {
  const tagNames = [];

  let offset = 0;
  let moreResults = true;

  while (moreResults) {
    const params = {
      offset,
      limit: 500,
      tagType,
    };

    const res = await globalTaggingService.listTags(params);
    expect(res).not.toBeNull();
    expect(res.status).toBe(200);

    const { result } = res;
    expect(result).toBeDefined();
    expect(result.items).toBeDefined();

    if (result.items.length > 0) {
      for (const item of result.items) {
        if (item.name.includes(label)) {
          tagNames.push(item.name);
        }
      }
      offset += result.items.length;
    } else {
      moreResults = false;
    }
  }

  return tagNames;
}

async function cleanTags(service, resourceId) {
  // Detach all user and access tags that contain our label.
  let tags;
  tags = await getTagNamesForResource(service, resourceId, 'user');
  for (const tag of tags) {
    if (tag.includes(sdkLabel)) {
      console.log(`Detaching user tag ${tag} from resource ${resourceId}`);
      await detachTag(service, resourceId, tag, 'user');
    }
  }

  tags = await getTagNamesForResource(service, resourceId, 'user');
  console.log(`Resource now has these user tags: [${tags}]`);

  tags = await getTagNamesForResource(service, resourceId, 'access');
  for (const tag of tags) {
    if (tag.includes(sdkLabel)) {
      console.log(`Detaching access tag ${tag} from resource ${resourceId}`);
      await detachTag(service, resourceId, tag, 'access');
    }
  }

  tags = await getTagNamesForResource(service, resourceId, 'access');
  console.log(`Resource now has these access tags: [${tags}]`);

  // Delete all user and access tags that contain our label.
  tags = await listTagsWithLabel(service, 'user', sdkLabel);
  for (const tag of tags) {
    console.log(`Deleting user tag: ${tag}`);
    await deleteTag(service, tag, 'user');
  }

  tags = await listTagsWithLabel(service, 'access', sdkLabel);
  for (const tag of tags) {
    console.log(`Deleting access tag: ${tag}`);
    await deleteTag(service, tag, 'access');
  }
}
