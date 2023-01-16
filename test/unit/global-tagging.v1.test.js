/**
 * (C) Copyright IBM Corp. 2023.
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

// need to import the whole package to mock getAuthenticatorFromEnvironment
const core = require('ibm-cloud-sdk-core');

const { NoAuthAuthenticator, unitTestUtils } = core;

const GlobalTaggingV1 = require('../../dist/global-tagging/v1');

const {
  getOptions,
  checkUrlAndMethod,
  checkMediaHeaders,
  expectToBePromise,
  checkUserHeader,
  checkForSuccessfulExecution,
} = unitTestUtils;

const globalTaggingServiceOptions = {
  authenticator: new NoAuthAuthenticator(),
  url: 'https://tags.global-search-tagging.cloud.ibm.com',
};

const globalTaggingService = new GlobalTaggingV1(globalTaggingServiceOptions);

let createRequestMock = null;
function mock_createRequest() {
  if (!createRequestMock) {
    createRequestMock = jest.spyOn(globalTaggingService, 'createRequest');
    createRequestMock.mockImplementation(() => Promise.resolve());
  }
}

// dont actually construct an authenticator
const getAuthenticatorMock = jest.spyOn(core, 'getAuthenticatorFromEnvironment');
getAuthenticatorMock.mockImplementation(() => new NoAuthAuthenticator());

describe('GlobalTaggingV1', () => {

  beforeEach(() => {
    mock_createRequest();
  });

  afterEach(() => {
    if (createRequestMock) {
      createRequestMock.mockClear();
    }
    getAuthenticatorMock.mockClear();
  });
  
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
      function __listTagsTest() {
        // Construct the params object for operation listTags
        const transactionId = 'testString';
        const impersonateUser = 'testString';
        const accountId = 'testString';
        const tagType = 'user';
        const fullData = false;
        const providers = ['ghost'];
        const attachedTo = 'testString';
        const offset = 0;
        const limit = 1;
        const timeout = 0;
        const orderByName = 'asc';
        const attachedOnly = false;
        const listTagsParams = {
          transactionId,
          impersonateUser,
          accountId,
          tagType,
          fullData,
          providers,
          attachedTo,
          offset,
          limit,
          timeout,
          orderByName,
          attachedOnly,
        };

        const listTagsResult = globalTaggingService.listTags(listTagsParams);

        // all methods should return a Promise
        expectToBePromise(listTagsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const mockRequestOptions = getOptions(createRequestMock);

        checkUrlAndMethod(mockRequestOptions, '/v3/tags', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'transaction-id', transactionId);
        expect(mockRequestOptions.qs.impersonate_user).toEqual(impersonateUser);
        expect(mockRequestOptions.qs.account_id).toEqual(accountId);
        expect(mockRequestOptions.qs.tag_type).toEqual(tagType);
        expect(mockRequestOptions.qs.full_data).toEqual(fullData);
        expect(mockRequestOptions.qs.providers).toEqual(providers);
        expect(mockRequestOptions.qs.attached_to).toEqual(attachedTo);
        expect(mockRequestOptions.qs.offset).toEqual(offset);
        expect(mockRequestOptions.qs.limit).toEqual(limit);
        expect(mockRequestOptions.qs.timeout).toEqual(timeout);
        expect(mockRequestOptions.qs.order_by_name).toEqual(orderByName);
        expect(mockRequestOptions.qs.attached_only).toEqual(attachedOnly);
      }

      test('should pass the right params to createRequest with enable and disable retries', () => {
        // baseline test
        __listTagsTest();

        // enable retries and test again
        createRequestMock.mockClear();
        globalTaggingService.enableRetries();
        __listTagsTest();

        // disable retries and test again
        createRequestMock.mockClear();
        globalTaggingService.disableRetries();
        __listTagsTest();
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const listTagsParams = {
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        globalTaggingService.listTags(listTagsParams);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        globalTaggingService.listTags({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });

  describe('createTag', () => {
    describe('positive tests', () => {
      function __createTagTest() {
        // Construct the params object for operation createTag
        const tagNames = ['testString'];
        const impersonateUser = 'testString';
        const transactionId = 'testString';
        const accountId = 'testString';
        const tagType = 'access';
        const createTagParams = {
          tagNames,
          impersonateUser,
          transactionId,
          accountId,
          tagType,
        };

        const createTagResult = globalTaggingService.createTag(createTagParams);

        // all methods should return a Promise
        expectToBePromise(createTagResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const mockRequestOptions = getOptions(createRequestMock);

        checkUrlAndMethod(mockRequestOptions, '/v3/tags', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'transaction-id', transactionId);
        expect(mockRequestOptions.body.tag_names).toEqual(tagNames);
        expect(mockRequestOptions.qs.impersonate_user).toEqual(impersonateUser);
        expect(mockRequestOptions.qs.account_id).toEqual(accountId);
        expect(mockRequestOptions.qs.tag_type).toEqual(tagType);
      }

      test('should pass the right params to createRequest with enable and disable retries', () => {
        // baseline test
        __createTagTest();

        // enable retries and test again
        createRequestMock.mockClear();
        globalTaggingService.enableRetries();
        __createTagTest();

        // disable retries and test again
        createRequestMock.mockClear();
        globalTaggingService.disableRetries();
        __createTagTest();
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const tagNames = ['testString'];
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const createTagParams = {
          tagNames,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        globalTaggingService.createTag(createTagParams);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async () => {
        let err;
        try {
          await globalTaggingService.createTag({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
      });

      test('should reject promise when required params are not given', async () => {
        let err;
        try {
          await globalTaggingService.createTag();
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
      });
    });
  });

  describe('deleteTagAll', () => {
    describe('positive tests', () => {
      function __deleteTagAllTest() {
        // Construct the params object for operation deleteTagAll
        const transactionId = 'testString';
        const providers = 'ghost';
        const impersonateUser = 'testString';
        const accountId = 'testString';
        const tagType = 'user';
        const deleteTagAllParams = {
          transactionId,
          providers,
          impersonateUser,
          accountId,
          tagType,
        };

        const deleteTagAllResult = globalTaggingService.deleteTagAll(deleteTagAllParams);

        // all methods should return a Promise
        expectToBePromise(deleteTagAllResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const mockRequestOptions = getOptions(createRequestMock);

        checkUrlAndMethod(mockRequestOptions, '/v3/tags', 'DELETE');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'transaction-id', transactionId);
        expect(mockRequestOptions.qs.providers).toEqual(providers);
        expect(mockRequestOptions.qs.impersonate_user).toEqual(impersonateUser);
        expect(mockRequestOptions.qs.account_id).toEqual(accountId);
        expect(mockRequestOptions.qs.tag_type).toEqual(tagType);
      }

      test('should pass the right params to createRequest with enable and disable retries', () => {
        // baseline test
        __deleteTagAllTest();

        // enable retries and test again
        createRequestMock.mockClear();
        globalTaggingService.enableRetries();
        __deleteTagAllTest();

        // disable retries and test again
        createRequestMock.mockClear();
        globalTaggingService.disableRetries();
        __deleteTagAllTest();
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const deleteTagAllParams = {
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        globalTaggingService.deleteTagAll(deleteTagAllParams);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        globalTaggingService.deleteTagAll({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });

  describe('deleteTag', () => {
    describe('positive tests', () => {
      function __deleteTagTest() {
        // Construct the params object for operation deleteTag
        const tagName = 'testString';
        const transactionId = 'testString';
        const providers = ['ghost'];
        const impersonateUser = 'testString';
        const accountId = 'testString';
        const tagType = 'user';
        const deleteTagParams = {
          tagName,
          transactionId,
          providers,
          impersonateUser,
          accountId,
          tagType,
        };

        const deleteTagResult = globalTaggingService.deleteTag(deleteTagParams);

        // all methods should return a Promise
        expectToBePromise(deleteTagResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const mockRequestOptions = getOptions(createRequestMock);

        checkUrlAndMethod(mockRequestOptions, '/v3/tags/{tag_name}', 'DELETE');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'transaction-id', transactionId);
        expect(mockRequestOptions.qs.providers).toEqual(providers);
        expect(mockRequestOptions.qs.impersonate_user).toEqual(impersonateUser);
        expect(mockRequestOptions.qs.account_id).toEqual(accountId);
        expect(mockRequestOptions.qs.tag_type).toEqual(tagType);
        expect(mockRequestOptions.path.tag_name).toEqual(tagName);
      }

      test('should pass the right params to createRequest with enable and disable retries', () => {
        // baseline test
        __deleteTagTest();

        // enable retries and test again
        createRequestMock.mockClear();
        globalTaggingService.enableRetries();
        __deleteTagTest();

        // disable retries and test again
        createRequestMock.mockClear();
        globalTaggingService.disableRetries();
        __deleteTagTest();
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const tagName = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const deleteTagParams = {
          tagName,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        globalTaggingService.deleteTag(deleteTagParams);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async () => {
        let err;
        try {
          await globalTaggingService.deleteTag({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
      });

      test('should reject promise when required params are not given', async () => {
        let err;
        try {
          await globalTaggingService.deleteTag();
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
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

      function __attachTagTest() {
        // Construct the params object for operation attachTag
        const resources = [resourceModel];
        const tagName = 'testString';
        const tagNames = ['testString'];
        const transactionId = 'testString';
        const impersonateUser = 'testString';
        const accountId = 'testString';
        const tagType = 'user';
        const attachTagParams = {
          resources,
          tagName,
          tagNames,
          transactionId,
          impersonateUser,
          accountId,
          tagType,
        };

        const attachTagResult = globalTaggingService.attachTag(attachTagParams);

        // all methods should return a Promise
        expectToBePromise(attachTagResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const mockRequestOptions = getOptions(createRequestMock);

        checkUrlAndMethod(mockRequestOptions, '/v3/tags/attach', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'transaction-id', transactionId);
        expect(mockRequestOptions.body.resources).toEqual(resources);
        expect(mockRequestOptions.body.tag_name).toEqual(tagName);
        expect(mockRequestOptions.body.tag_names).toEqual(tagNames);
        expect(mockRequestOptions.qs.impersonate_user).toEqual(impersonateUser);
        expect(mockRequestOptions.qs.account_id).toEqual(accountId);
        expect(mockRequestOptions.qs.tag_type).toEqual(tagType);
      }

      test('should pass the right params to createRequest with enable and disable retries', () => {
        // baseline test
        __attachTagTest();

        // enable retries and test again
        createRequestMock.mockClear();
        globalTaggingService.enableRetries();
        __attachTagTest();

        // disable retries and test again
        createRequestMock.mockClear();
        globalTaggingService.disableRetries();
        __attachTagTest();
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const resources = [resourceModel];
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const attachTagParams = {
          resources,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        globalTaggingService.attachTag(attachTagParams);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async () => {
        let err;
        try {
          await globalTaggingService.attachTag({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
      });

      test('should reject promise when required params are not given', async () => {
        let err;
        try {
          await globalTaggingService.attachTag();
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
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

      function __detachTagTest() {
        // Construct the params object for operation detachTag
        const resources = [resourceModel];
        const tagName = 'testString';
        const tagNames = ['testString'];
        const transactionId = 'testString';
        const impersonateUser = 'testString';
        const accountId = 'testString';
        const tagType = 'user';
        const detachTagParams = {
          resources,
          tagName,
          tagNames,
          transactionId,
          impersonateUser,
          accountId,
          tagType,
        };

        const detachTagResult = globalTaggingService.detachTag(detachTagParams);

        // all methods should return a Promise
        expectToBePromise(detachTagResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const mockRequestOptions = getOptions(createRequestMock);

        checkUrlAndMethod(mockRequestOptions, '/v3/tags/detach', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'transaction-id', transactionId);
        expect(mockRequestOptions.body.resources).toEqual(resources);
        expect(mockRequestOptions.body.tag_name).toEqual(tagName);
        expect(mockRequestOptions.body.tag_names).toEqual(tagNames);
        expect(mockRequestOptions.qs.impersonate_user).toEqual(impersonateUser);
        expect(mockRequestOptions.qs.account_id).toEqual(accountId);
        expect(mockRequestOptions.qs.tag_type).toEqual(tagType);
      }

      test('should pass the right params to createRequest with enable and disable retries', () => {
        // baseline test
        __detachTagTest();

        // enable retries and test again
        createRequestMock.mockClear();
        globalTaggingService.enableRetries();
        __detachTagTest();

        // disable retries and test again
        createRequestMock.mockClear();
        globalTaggingService.disableRetries();
        __detachTagTest();
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const resources = [resourceModel];
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const detachTagParams = {
          resources,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        globalTaggingService.detachTag(detachTagParams);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async () => {
        let err;
        try {
          await globalTaggingService.detachTag({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
      });

      test('should reject promise when required params are not given', async () => {
        let err;
        try {
          await globalTaggingService.detachTag();
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
      });
    });
  });
});
