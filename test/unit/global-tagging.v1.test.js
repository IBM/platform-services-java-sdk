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

const GlobalTaggingV1 = require('../../dist/global-tagging/v1');

const {
  getOptions,
  checkUrlAndMethod,
  checkMediaHeaders,
  expectToBePromise,
  checkForSuccessfulExecution,
} = unitTestUtils;

const service = {
  authenticator: new NoAuthAuthenticator(),
  url: 'https://tags.global-search-tagging.cloud.ibm.com',
};

const globalTagging = new GlobalTaggingV1(service);

// dont actually create a request
const createRequestMock = jest.spyOn(globalTagging, 'createRequest');
createRequestMock.mockImplementation(() => Promise.resolve());

// dont actually construct an authenticator
const getAuthenticatorMock = jest.spyOn(core, 'getAuthenticatorFromEnvironment');
getAuthenticatorMock.mockImplementation(() => new NoAuthAuthenticator());

afterEach(() => {
  createRequestMock.mockClear();
  getAuthenticatorMock.mockClear();
});

describe('GlobalTaggingV1', () => {
  describe('the newInstance method', () => {
    test('should use defaults when options not provided', () => {
      const testInstance = GlobalTaggingV1.newInstance();

      expect(getAuthenticatorMock).toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceName).toBe(GlobalTaggingV1.DEFAULT_SERVICE_NAME);
      expect(testInstance.baseOptions.serviceUrl).toBe(GlobalTaggingV1.DEFAULT_SERVICE_URL);
      expect(testInstance).toBeInstanceOf(GlobalTaggingV1);
    });

    test('should set serviceName, serviceUrl, and authenticator when provided', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
        serviceName: 'my-service',
      };

      const testInstance = GlobalTaggingV1.newInstance(options);

      expect(getAuthenticatorMock).not.toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
      expect(testInstance.baseOptions.serviceName).toBe('my-service');
      expect(testInstance).toBeInstanceOf(GlobalTaggingV1);
    });
  });
  describe('the constructor', () => {
    test('use user-given service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
      };

      const testInstance = new GlobalTaggingV1(options);

      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
    });

    test('use default service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
      };

      const testInstance = new GlobalTaggingV1(options);

      expect(testInstance.baseOptions.serviceUrl).toBe(GlobalTaggingV1.DEFAULT_SERVICE_URL);
    });
  });
  describe('listTags', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listTags
        const providers = ['ghost'];
        const attachedTo = 'testString';
        const fullData = true;
        const offset = 0;
        const limit = 1;
        const orderByName = 'asc';
        const timeout = 38;
        const attachedOnly = true;
        const params = {
          providers: providers,
          attachedTo: attachedTo,
          fullData: fullData,
          offset: offset,
          limit: limit,
          orderByName: orderByName,
          timeout: timeout,
          attachedOnly: attachedOnly,
        };

        const listTagsResult = globalTagging.listTags(params);

        // all methods should return a Promise
        expectToBePromise(listTagsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v3/tags', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['providers']).toEqual(providers);
        expect(options.qs['attached_to']).toEqual(attachedTo);
        expect(options.qs['full_data']).toEqual(fullData);
        expect(options.qs['offset']).toEqual(offset);
        expect(options.qs['limit']).toEqual(limit);
        expect(options.qs['order_by_name']).toEqual(orderByName);
        expect(options.qs['timeout']).toEqual(timeout);
        expect(options.qs['attached_only']).toEqual(attachedOnly);
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

        globalTagging.listTags(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        globalTagging.listTags({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('deleteTagAll', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteTagAll
        const providers = 'ghost';
        const params = {
          providers: providers,
        };

        const deleteTagAllResult = globalTagging.deleteTagAll(params);

        // all methods should return a Promise
        expectToBePromise(deleteTagAllResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v3/tags', 'DELETE');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['providers']).toEqual(providers);
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

        globalTagging.deleteTagAll(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        globalTagging.deleteTagAll({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('deleteTag', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteTag
        const tagName = 'testString';
        const providers = ['ghost'];
        const params = {
          tagName: tagName,
          providers: providers,
        };

        const deleteTagResult = globalTagging.deleteTag(params);

        // all methods should return a Promise
        expectToBePromise(deleteTagResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v3/tags/{tag_name}', 'DELETE');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['providers']).toEqual(providers);
        expect(options.path['tag_name']).toEqual(tagName);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const tagName = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          tagName,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        globalTagging.deleteTag(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await globalTagging.deleteTag({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const deleteTagPromise = globalTagging.deleteTag();
        expectToBePromise(deleteTagPromise);

        deleteTagPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('attachTag', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // Resource
      const resourceModel = {
        resource_id: 'testString',
        resource_type: 'testString',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation attachTag
        const resources = [resourceModel];
        const tagName = 'testString';
        const tagNames = ['testString'];
        const params = {
          resources: resources,
          tagName: tagName,
          tagNames: tagNames,
        };

        const attachTagResult = globalTagging.attachTag(params);

        // all methods should return a Promise
        expectToBePromise(attachTagResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v3/tags/attach', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['resources']).toEqual(resources);
        expect(options.body['tag_name']).toEqual(tagName);
        expect(options.body['tag_names']).toEqual(tagNames);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const resources = [resourceModel];
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          resources,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        globalTagging.attachTag(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await globalTagging.attachTag({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const attachTagPromise = globalTagging.attachTag();
        expectToBePromise(attachTagPromise);

        attachTagPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('detachTag', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // Resource
      const resourceModel = {
        resource_id: 'testString',
        resource_type: 'testString',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation detachTag
        const resources = [resourceModel];
        const tagName = 'testString';
        const tagNames = ['testString'];
        const params = {
          resources: resources,
          tagName: tagName,
          tagNames: tagNames,
        };

        const detachTagResult = globalTagging.detachTag(params);

        // all methods should return a Promise
        expectToBePromise(detachTagResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v3/tags/detach', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['resources']).toEqual(resources);
        expect(options.body['tag_name']).toEqual(tagName);
        expect(options.body['tag_names']).toEqual(tagNames);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const resources = [resourceModel];
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          resources,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        globalTagging.detachTag(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await globalTagging.detachTag({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const detachTagPromise = globalTagging.detachTag();
        expectToBePromise(detachTagPromise);

        detachTagPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
});
