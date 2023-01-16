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

const GlobalSearchV2 = require('../../dist/global-search/v2');

const {
  getOptions,
  checkUrlAndMethod,
  checkMediaHeaders,
  expectToBePromise,
  checkUserHeader,
  checkForSuccessfulExecution,
} = unitTestUtils;

const globalSearchServiceOptions = {
  authenticator: new NoAuthAuthenticator(),
  url: 'https://api.global-search-tagging.cloud.ibm.com',
};

const globalSearchService = new GlobalSearchV2(globalSearchServiceOptions);

let createRequestMock = null;
function mock_createRequest() {
  if (!createRequestMock) {
    createRequestMock = jest.spyOn(globalSearchService, 'createRequest');
    createRequestMock.mockImplementation(() => Promise.resolve());
  }
}

// dont actually construct an authenticator
const getAuthenticatorMock = jest.spyOn(core, 'getAuthenticatorFromEnvironment');
getAuthenticatorMock.mockImplementation(() => new NoAuthAuthenticator());

describe('GlobalSearchV2', () => {

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
      const testInstance = GlobalSearchV2.newInstance();

      expect(getAuthenticatorMock).toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceName).toBe(GlobalSearchV2.DEFAULT_SERVICE_NAME);
      expect(testInstance.baseOptions.serviceUrl).toBe(GlobalSearchV2.DEFAULT_SERVICE_URL);
      expect(testInstance).toBeInstanceOf(GlobalSearchV2);
    });

    test('should set serviceName, serviceUrl, and authenticator when provided', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
        serviceName: 'my-service',
      };

      const testInstance = GlobalSearchV2.newInstance(options);

      expect(getAuthenticatorMock).not.toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
      expect(testInstance.baseOptions.serviceName).toBe('my-service');
      expect(testInstance).toBeInstanceOf(GlobalSearchV2);
    });
  });

  describe('the constructor', () => {
    test('use user-given service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
      };

      const testInstance = new GlobalSearchV2(options);

      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
    });

    test('use default service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
      };

      const testInstance = new GlobalSearchV2(options);

      expect(testInstance.baseOptions.serviceUrl).toBe(GlobalSearchV2.DEFAULT_SERVICE_URL);
    });
  });

  describe('search', () => {
    describe('positive tests', () => {
      function __searchTest() {
        // Construct the params object for operation search
        const query = 'testString';
        const fields = ['testString'];
        const searchCursor = 'testString';
        const transactionId = 'testString';
        const accountId = 'testString';
        const boundary = 'global';
        const limit = 1;
        const timeout = 0;
        const sort = ['testString'];
        const isDeleted = 'false';
        const isReclaimed = 'false';
        const isPublic = 'false';
        const impersonateUser = 'testString';
        const canTag = 'false';
        const isHidden = 'false';
        const searchParams = {
          query,
          fields,
          searchCursor,
          transactionId,
          accountId,
          boundary,
          limit,
          timeout,
          sort,
          isDeleted,
          isReclaimed,
          isPublic,
          impersonateUser,
          canTag,
          isHidden,
        };

        const searchResult = globalSearchService.search(searchParams);

        // all methods should return a Promise
        expectToBePromise(searchResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const mockRequestOptions = getOptions(createRequestMock);

        checkUrlAndMethod(mockRequestOptions, '/v3/resources/search', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'transaction-id', transactionId);
        expect(mockRequestOptions.body.query).toEqual(query);
        expect(mockRequestOptions.body.fields).toEqual(fields);
        expect(mockRequestOptions.body.search_cursor).toEqual(searchCursor);
        expect(mockRequestOptions.qs.account_id).toEqual(accountId);
        expect(mockRequestOptions.qs.boundary).toEqual(boundary);
        expect(mockRequestOptions.qs.limit).toEqual(limit);
        expect(mockRequestOptions.qs.timeout).toEqual(timeout);
        expect(mockRequestOptions.qs.sort).toEqual(sort);
        expect(mockRequestOptions.qs.is_deleted).toEqual(isDeleted);
        expect(mockRequestOptions.qs.is_reclaimed).toEqual(isReclaimed);
        expect(mockRequestOptions.qs.is_public).toEqual(isPublic);
        expect(mockRequestOptions.qs.impersonate_user).toEqual(impersonateUser);
        expect(mockRequestOptions.qs.can_tag).toEqual(canTag);
        expect(mockRequestOptions.qs.is_hidden).toEqual(isHidden);
      }

      test('should pass the right params to createRequest with enable and disable retries', () => {
        // baseline test
        __searchTest();

        // enable retries and test again
        createRequestMock.mockClear();
        globalSearchService.enableRetries();
        __searchTest();

        // disable retries and test again
        createRequestMock.mockClear();
        globalSearchService.disableRetries();
        __searchTest();
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const searchParams = {
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        globalSearchService.search(searchParams);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        globalSearchService.search({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });

  describe('getSupportedTypes', () => {
    describe('positive tests', () => {
      function __getSupportedTypesTest() {
        // Construct the params object for operation getSupportedTypes
        const getSupportedTypesParams = {};

        const getSupportedTypesResult = globalSearchService.getSupportedTypes(getSupportedTypesParams);

        // all methods should return a Promise
        expectToBePromise(getSupportedTypesResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const mockRequestOptions = getOptions(createRequestMock);

        checkUrlAndMethod(mockRequestOptions, '/v2/resources/supported_types', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
      }

      test('should pass the right params to createRequest with enable and disable retries', () => {
        // baseline test
        __getSupportedTypesTest();

        // enable retries and test again
        createRequestMock.mockClear();
        globalSearchService.enableRetries();
        __getSupportedTypesTest();

        // disable retries and test again
        createRequestMock.mockClear();
        globalSearchService.disableRetries();
        __getSupportedTypesTest();
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const getSupportedTypesParams = {
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        globalSearchService.getSupportedTypes(getSupportedTypesParams);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        globalSearchService.getSupportedTypes({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
});
