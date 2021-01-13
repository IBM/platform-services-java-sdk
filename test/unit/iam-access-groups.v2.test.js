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

// need to import the whole package to mock getAuthenticatorFromEnvironment
const core = require('ibm-cloud-sdk-core');
const { NoAuthAuthenticator, unitTestUtils } = core;

const IamAccessGroupsV2 = require('../../dist/iam-access-groups/v2');

const {
  getOptions,
  checkUrlAndMethod,
  checkMediaHeaders,
  expectToBePromise,
  checkUserHeader,
} = unitTestUtils;

const service = {
  authenticator: new NoAuthAuthenticator(),
  url: 'https://iam.cloud.ibm.com/v2',
};

const iamAccessGroupsService = new IamAccessGroupsV2(service);

// dont actually create a request
const createRequestMock = jest.spyOn(iamAccessGroupsService, 'createRequest');
createRequestMock.mockImplementation(() => Promise.resolve());

// dont actually construct an authenticator
const getAuthenticatorMock = jest.spyOn(core, 'getAuthenticatorFromEnvironment');
getAuthenticatorMock.mockImplementation(() => new NoAuthAuthenticator());

afterEach(() => {
  createRequestMock.mockClear();
  getAuthenticatorMock.mockClear();
});

describe('IamAccessGroupsV2', () => {
  describe('the newInstance method', () => {
    test('should use defaults when options not provided', () => {
      const testInstance = IamAccessGroupsV2.newInstance();

      expect(getAuthenticatorMock).toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceName).toBe(IamAccessGroupsV2.DEFAULT_SERVICE_NAME);
      expect(testInstance.baseOptions.serviceUrl).toBe(IamAccessGroupsV2.DEFAULT_SERVICE_URL);
      expect(testInstance).toBeInstanceOf(IamAccessGroupsV2);
    });

    test('should set serviceName, serviceUrl, and authenticator when provided', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
        serviceName: 'my-service',
      };

      const testInstance = IamAccessGroupsV2.newInstance(options);

      expect(getAuthenticatorMock).not.toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
      expect(testInstance.baseOptions.serviceName).toBe('my-service');
      expect(testInstance).toBeInstanceOf(IamAccessGroupsV2);
    });
  });
  describe('the constructor', () => {
    test('use user-given service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
      };

      const testInstance = new IamAccessGroupsV2(options);

      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
    });

    test('use default service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
      };

      const testInstance = new IamAccessGroupsV2(options);

      expect(testInstance.baseOptions.serviceUrl).toBe(IamAccessGroupsV2.DEFAULT_SERVICE_URL);
    });
  });
  describe('createAccessGroup', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createAccessGroup
        const accountId = 'testString';
        const name = 'testString';
        const description = 'testString';
        const transactionId = 'testString';
        const params = {
          accountId: accountId,
          name: name,
          description: description,
          transactionId: transactionId,
        };

        const createAccessGroupResult = iamAccessGroupsService.createAccessGroup(params);

        // all methods should return a Promise
        expectToBePromise(createAccessGroupResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/groups', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
        expect(options.body['name']).toEqual(name);
        expect(options.body['description']).toEqual(description);
        expect(options.qs['account_id']).toEqual(accountId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountId = 'testString';
        const name = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountId,
          name,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamAccessGroupsService.createAccessGroup(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamAccessGroupsService.createAccessGroup({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const createAccessGroupPromise = iamAccessGroupsService.createAccessGroup();
        expectToBePromise(createAccessGroupPromise);

        createAccessGroupPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('listAccessGroups', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listAccessGroups
        const accountId = 'testString';
        const transactionId = 'testString';
        const iamId = 'testString';
        const limit = 38;
        const offset = 38;
        const sort = 'testString';
        const showFederated = true;
        const hidePublicAccess = true;
        const params = {
          accountId: accountId,
          transactionId: transactionId,
          iamId: iamId,
          limit: limit,
          offset: offset,
          sort: sort,
          showFederated: showFederated,
          hidePublicAccess: hidePublicAccess,
        };

        const listAccessGroupsResult = iamAccessGroupsService.listAccessGroups(params);

        // all methods should return a Promise
        expectToBePromise(listAccessGroupsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/groups', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
        expect(options.qs['account_id']).toEqual(accountId);
        expect(options.qs['iam_id']).toEqual(iamId);
        expect(options.qs['limit']).toEqual(limit);
        expect(options.qs['offset']).toEqual(offset);
        expect(options.qs['sort']).toEqual(sort);
        expect(options.qs['show_federated']).toEqual(showFederated);
        expect(options.qs['hide_public_access']).toEqual(hidePublicAccess);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamAccessGroupsService.listAccessGroups(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamAccessGroupsService.listAccessGroups({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const listAccessGroupsPromise = iamAccessGroupsService.listAccessGroups();
        expectToBePromise(listAccessGroupsPromise);

        listAccessGroupsPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getAccessGroup', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getAccessGroup
        const accessGroupId = 'testString';
        const transactionId = 'testString';
        const showFederated = true;
        const params = {
          accessGroupId: accessGroupId,
          transactionId: transactionId,
          showFederated: showFederated,
        };

        const getAccessGroupResult = iamAccessGroupsService.getAccessGroup(params);

        // all methods should return a Promise
        expectToBePromise(getAccessGroupResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/groups/{access_group_id}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
        expect(options.qs['show_federated']).toEqual(showFederated);
        expect(options.path['access_group_id']).toEqual(accessGroupId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accessGroupId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accessGroupId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamAccessGroupsService.getAccessGroup(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamAccessGroupsService.getAccessGroup({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getAccessGroupPromise = iamAccessGroupsService.getAccessGroup();
        expectToBePromise(getAccessGroupPromise);

        getAccessGroupPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('updateAccessGroup', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation updateAccessGroup
        const accessGroupId = 'testString';
        const ifMatch = 'testString';
        const name = 'testString';
        const description = 'testString';
        const transactionId = 'testString';
        const params = {
          accessGroupId: accessGroupId,
          ifMatch: ifMatch,
          name: name,
          description: description,
          transactionId: transactionId,
        };

        const updateAccessGroupResult = iamAccessGroupsService.updateAccessGroup(params);

        // all methods should return a Promise
        expectToBePromise(updateAccessGroupResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/groups/{access_group_id}', 'PATCH');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'If-Match', ifMatch);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
        expect(options.body['name']).toEqual(name);
        expect(options.body['description']).toEqual(description);
        expect(options.path['access_group_id']).toEqual(accessGroupId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accessGroupId = 'testString';
        const ifMatch = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accessGroupId,
          ifMatch,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamAccessGroupsService.updateAccessGroup(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamAccessGroupsService.updateAccessGroup({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const updateAccessGroupPromise = iamAccessGroupsService.updateAccessGroup();
        expectToBePromise(updateAccessGroupPromise);

        updateAccessGroupPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deleteAccessGroup', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteAccessGroup
        const accessGroupId = 'testString';
        const transactionId = 'testString';
        const force = true;
        const params = {
          accessGroupId: accessGroupId,
          transactionId: transactionId,
          force: force,
        };

        const deleteAccessGroupResult = iamAccessGroupsService.deleteAccessGroup(params);

        // all methods should return a Promise
        expectToBePromise(deleteAccessGroupResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/groups/{access_group_id}', 'DELETE');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
        expect(options.qs['force']).toEqual(force);
        expect(options.path['access_group_id']).toEqual(accessGroupId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accessGroupId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accessGroupId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamAccessGroupsService.deleteAccessGroup(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamAccessGroupsService.deleteAccessGroup({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const deleteAccessGroupPromise = iamAccessGroupsService.deleteAccessGroup();
        expectToBePromise(deleteAccessGroupPromise);

        deleteAccessGroupPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('isMemberOfAccessGroup', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation isMemberOfAccessGroup
        const accessGroupId = 'testString';
        const iamId = 'testString';
        const transactionId = 'testString';
        const params = {
          accessGroupId: accessGroupId,
          iamId: iamId,
          transactionId: transactionId,
        };

        const isMemberOfAccessGroupResult = iamAccessGroupsService.isMemberOfAccessGroup(params);

        // all methods should return a Promise
        expectToBePromise(isMemberOfAccessGroupResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/groups/{access_group_id}/members/{iam_id}', 'HEAD');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
        expect(options.path['access_group_id']).toEqual(accessGroupId);
        expect(options.path['iam_id']).toEqual(iamId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accessGroupId = 'testString';
        const iamId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accessGroupId,
          iamId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamAccessGroupsService.isMemberOfAccessGroup(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamAccessGroupsService.isMemberOfAccessGroup({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const isMemberOfAccessGroupPromise = iamAccessGroupsService.isMemberOfAccessGroup();
        expectToBePromise(isMemberOfAccessGroupPromise);

        isMemberOfAccessGroupPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('addMembersToAccessGroup', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // AddGroupMembersRequestMembersItem
      const addGroupMembersRequestMembersItemModel = {
        iam_id: 'testString',
        type: 'testString',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation addMembersToAccessGroup
        const accessGroupId = 'testString';
        const members = [addGroupMembersRequestMembersItemModel];
        const transactionId = 'testString';
        const params = {
          accessGroupId: accessGroupId,
          members: members,
          transactionId: transactionId,
        };

        const addMembersToAccessGroupResult = iamAccessGroupsService.addMembersToAccessGroup(params);

        // all methods should return a Promise
        expectToBePromise(addMembersToAccessGroupResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/groups/{access_group_id}/members', 'PUT');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
        expect(options.body['members']).toEqual(members);
        expect(options.path['access_group_id']).toEqual(accessGroupId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accessGroupId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accessGroupId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamAccessGroupsService.addMembersToAccessGroup(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamAccessGroupsService.addMembersToAccessGroup({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const addMembersToAccessGroupPromise = iamAccessGroupsService.addMembersToAccessGroup();
        expectToBePromise(addMembersToAccessGroupPromise);

        addMembersToAccessGroupPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('listAccessGroupMembers', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listAccessGroupMembers
        const accessGroupId = 'testString';
        const transactionId = 'testString';
        const limit = 38;
        const offset = 38;
        const type = 'testString';
        const verbose = true;
        const sort = 'testString';
        const params = {
          accessGroupId: accessGroupId,
          transactionId: transactionId,
          limit: limit,
          offset: offset,
          type: type,
          verbose: verbose,
          sort: sort,
        };

        const listAccessGroupMembersResult = iamAccessGroupsService.listAccessGroupMembers(params);

        // all methods should return a Promise
        expectToBePromise(listAccessGroupMembersResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/groups/{access_group_id}/members', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
        expect(options.qs['limit']).toEqual(limit);
        expect(options.qs['offset']).toEqual(offset);
        expect(options.qs['type']).toEqual(type);
        expect(options.qs['verbose']).toEqual(verbose);
        expect(options.qs['sort']).toEqual(sort);
        expect(options.path['access_group_id']).toEqual(accessGroupId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accessGroupId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accessGroupId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamAccessGroupsService.listAccessGroupMembers(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamAccessGroupsService.listAccessGroupMembers({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const listAccessGroupMembersPromise = iamAccessGroupsService.listAccessGroupMembers();
        expectToBePromise(listAccessGroupMembersPromise);

        listAccessGroupMembersPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('removeMemberFromAccessGroup', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation removeMemberFromAccessGroup
        const accessGroupId = 'testString';
        const iamId = 'testString';
        const transactionId = 'testString';
        const params = {
          accessGroupId: accessGroupId,
          iamId: iamId,
          transactionId: transactionId,
        };

        const removeMemberFromAccessGroupResult = iamAccessGroupsService.removeMemberFromAccessGroup(params);

        // all methods should return a Promise
        expectToBePromise(removeMemberFromAccessGroupResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/groups/{access_group_id}/members/{iam_id}', 'DELETE');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
        expect(options.path['access_group_id']).toEqual(accessGroupId);
        expect(options.path['iam_id']).toEqual(iamId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accessGroupId = 'testString';
        const iamId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accessGroupId,
          iamId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamAccessGroupsService.removeMemberFromAccessGroup(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamAccessGroupsService.removeMemberFromAccessGroup({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const removeMemberFromAccessGroupPromise = iamAccessGroupsService.removeMemberFromAccessGroup();
        expectToBePromise(removeMemberFromAccessGroupPromise);

        removeMemberFromAccessGroupPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('removeMembersFromAccessGroup', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation removeMembersFromAccessGroup
        const accessGroupId = 'testString';
        const members = ['testString'];
        const transactionId = 'testString';
        const params = {
          accessGroupId: accessGroupId,
          members: members,
          transactionId: transactionId,
        };

        const removeMembersFromAccessGroupResult = iamAccessGroupsService.removeMembersFromAccessGroup(params);

        // all methods should return a Promise
        expectToBePromise(removeMembersFromAccessGroupResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/groups/{access_group_id}/members/delete', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
        expect(options.body['members']).toEqual(members);
        expect(options.path['access_group_id']).toEqual(accessGroupId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accessGroupId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accessGroupId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamAccessGroupsService.removeMembersFromAccessGroup(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamAccessGroupsService.removeMembersFromAccessGroup({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const removeMembersFromAccessGroupPromise = iamAccessGroupsService.removeMembersFromAccessGroup();
        expectToBePromise(removeMembersFromAccessGroupPromise);

        removeMembersFromAccessGroupPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('removeMemberFromAllAccessGroups', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation removeMemberFromAllAccessGroups
        const accountId = 'testString';
        const iamId = 'testString';
        const transactionId = 'testString';
        const params = {
          accountId: accountId,
          iamId: iamId,
          transactionId: transactionId,
        };

        const removeMemberFromAllAccessGroupsResult = iamAccessGroupsService.removeMemberFromAllAccessGroups(params);

        // all methods should return a Promise
        expectToBePromise(removeMemberFromAllAccessGroupsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/groups/_allgroups/members/{iam_id}', 'DELETE');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
        expect(options.qs['account_id']).toEqual(accountId);
        expect(options.path['iam_id']).toEqual(iamId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountId = 'testString';
        const iamId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountId,
          iamId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamAccessGroupsService.removeMemberFromAllAccessGroups(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamAccessGroupsService.removeMemberFromAllAccessGroups({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const removeMemberFromAllAccessGroupsPromise = iamAccessGroupsService.removeMemberFromAllAccessGroups();
        expectToBePromise(removeMemberFromAllAccessGroupsPromise);

        removeMemberFromAllAccessGroupsPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('addMemberToMultipleAccessGroups', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation addMemberToMultipleAccessGroups
        const accountId = 'testString';
        const iamId = 'testString';
        const type = 'testString';
        const groups = ['testString'];
        const transactionId = 'testString';
        const params = {
          accountId: accountId,
          iamId: iamId,
          type: type,
          groups: groups,
          transactionId: transactionId,
        };

        const addMemberToMultipleAccessGroupsResult = iamAccessGroupsService.addMemberToMultipleAccessGroups(params);

        // all methods should return a Promise
        expectToBePromise(addMemberToMultipleAccessGroupsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/groups/_allgroups/members/{iam_id}', 'PUT');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
        expect(options.body['type']).toEqual(type);
        expect(options.body['groups']).toEqual(groups);
        expect(options.qs['account_id']).toEqual(accountId);
        expect(options.path['iam_id']).toEqual(iamId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountId = 'testString';
        const iamId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountId,
          iamId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamAccessGroupsService.addMemberToMultipleAccessGroups(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamAccessGroupsService.addMemberToMultipleAccessGroups({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const addMemberToMultipleAccessGroupsPromise = iamAccessGroupsService.addMemberToMultipleAccessGroups();
        expectToBePromise(addMemberToMultipleAccessGroupsPromise);

        addMemberToMultipleAccessGroupsPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('addAccessGroupRule', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // RuleConditions
      const ruleConditionsModel = {
        claim: 'testString',
        operator: 'testString',
        value: 'testString',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation addAccessGroupRule
        const accessGroupId = 'testString';
        const expiration = 38;
        const realmName = 'testString';
        const conditions = [ruleConditionsModel];
        const name = 'testString';
        const transactionId = 'testString';
        const params = {
          accessGroupId: accessGroupId,
          expiration: expiration,
          realmName: realmName,
          conditions: conditions,
          name: name,
          transactionId: transactionId,
        };

        const addAccessGroupRuleResult = iamAccessGroupsService.addAccessGroupRule(params);

        // all methods should return a Promise
        expectToBePromise(addAccessGroupRuleResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/groups/{access_group_id}/rules', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
        expect(options.body['expiration']).toEqual(expiration);
        expect(options.body['realm_name']).toEqual(realmName);
        expect(options.body['conditions']).toEqual(conditions);
        expect(options.body['name']).toEqual(name);
        expect(options.path['access_group_id']).toEqual(accessGroupId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accessGroupId = 'testString';
        const expiration = 38;
        const realmName = 'testString';
        const conditions = [ruleConditionsModel];
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accessGroupId,
          expiration,
          realmName,
          conditions,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamAccessGroupsService.addAccessGroupRule(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamAccessGroupsService.addAccessGroupRule({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const addAccessGroupRulePromise = iamAccessGroupsService.addAccessGroupRule();
        expectToBePromise(addAccessGroupRulePromise);

        addAccessGroupRulePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('listAccessGroupRules', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listAccessGroupRules
        const accessGroupId = 'testString';
        const transactionId = 'testString';
        const params = {
          accessGroupId: accessGroupId,
          transactionId: transactionId,
        };

        const listAccessGroupRulesResult = iamAccessGroupsService.listAccessGroupRules(params);

        // all methods should return a Promise
        expectToBePromise(listAccessGroupRulesResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/groups/{access_group_id}/rules', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
        expect(options.path['access_group_id']).toEqual(accessGroupId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accessGroupId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accessGroupId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamAccessGroupsService.listAccessGroupRules(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamAccessGroupsService.listAccessGroupRules({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const listAccessGroupRulesPromise = iamAccessGroupsService.listAccessGroupRules();
        expectToBePromise(listAccessGroupRulesPromise);

        listAccessGroupRulesPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getAccessGroupRule', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getAccessGroupRule
        const accessGroupId = 'testString';
        const ruleId = 'testString';
        const transactionId = 'testString';
        const params = {
          accessGroupId: accessGroupId,
          ruleId: ruleId,
          transactionId: transactionId,
        };

        const getAccessGroupRuleResult = iamAccessGroupsService.getAccessGroupRule(params);

        // all methods should return a Promise
        expectToBePromise(getAccessGroupRuleResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/groups/{access_group_id}/rules/{rule_id}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
        expect(options.path['access_group_id']).toEqual(accessGroupId);
        expect(options.path['rule_id']).toEqual(ruleId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accessGroupId = 'testString';
        const ruleId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accessGroupId,
          ruleId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamAccessGroupsService.getAccessGroupRule(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamAccessGroupsService.getAccessGroupRule({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getAccessGroupRulePromise = iamAccessGroupsService.getAccessGroupRule();
        expectToBePromise(getAccessGroupRulePromise);

        getAccessGroupRulePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('replaceAccessGroupRule', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // RuleConditions
      const ruleConditionsModel = {
        claim: 'testString',
        operator: 'testString',
        value: 'testString',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation replaceAccessGroupRule
        const accessGroupId = 'testString';
        const ruleId = 'testString';
        const ifMatch = 'testString';
        const expiration = 38;
        const realmName = 'testString';
        const conditions = [ruleConditionsModel];
        const name = 'testString';
        const transactionId = 'testString';
        const params = {
          accessGroupId: accessGroupId,
          ruleId: ruleId,
          ifMatch: ifMatch,
          expiration: expiration,
          realmName: realmName,
          conditions: conditions,
          name: name,
          transactionId: transactionId,
        };

        const replaceAccessGroupRuleResult = iamAccessGroupsService.replaceAccessGroupRule(params);

        // all methods should return a Promise
        expectToBePromise(replaceAccessGroupRuleResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/groups/{access_group_id}/rules/{rule_id}', 'PUT');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'If-Match', ifMatch);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
        expect(options.body['expiration']).toEqual(expiration);
        expect(options.body['realm_name']).toEqual(realmName);
        expect(options.body['conditions']).toEqual(conditions);
        expect(options.body['name']).toEqual(name);
        expect(options.path['access_group_id']).toEqual(accessGroupId);
        expect(options.path['rule_id']).toEqual(ruleId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accessGroupId = 'testString';
        const ruleId = 'testString';
        const ifMatch = 'testString';
        const expiration = 38;
        const realmName = 'testString';
        const conditions = [ruleConditionsModel];
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accessGroupId,
          ruleId,
          ifMatch,
          expiration,
          realmName,
          conditions,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamAccessGroupsService.replaceAccessGroupRule(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamAccessGroupsService.replaceAccessGroupRule({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const replaceAccessGroupRulePromise = iamAccessGroupsService.replaceAccessGroupRule();
        expectToBePromise(replaceAccessGroupRulePromise);

        replaceAccessGroupRulePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('removeAccessGroupRule', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation removeAccessGroupRule
        const accessGroupId = 'testString';
        const ruleId = 'testString';
        const transactionId = 'testString';
        const params = {
          accessGroupId: accessGroupId,
          ruleId: ruleId,
          transactionId: transactionId,
        };

        const removeAccessGroupRuleResult = iamAccessGroupsService.removeAccessGroupRule(params);

        // all methods should return a Promise
        expectToBePromise(removeAccessGroupRuleResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/groups/{access_group_id}/rules/{rule_id}', 'DELETE');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
        expect(options.path['access_group_id']).toEqual(accessGroupId);
        expect(options.path['rule_id']).toEqual(ruleId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accessGroupId = 'testString';
        const ruleId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accessGroupId,
          ruleId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamAccessGroupsService.removeAccessGroupRule(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamAccessGroupsService.removeAccessGroupRule({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const removeAccessGroupRulePromise = iamAccessGroupsService.removeAccessGroupRule();
        expectToBePromise(removeAccessGroupRulePromise);

        removeAccessGroupRulePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getAccountSettings', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getAccountSettings
        const accountId = 'testString';
        const transactionId = 'testString';
        const params = {
          accountId: accountId,
          transactionId: transactionId,
        };

        const getAccountSettingsResult = iamAccessGroupsService.getAccountSettings(params);

        // all methods should return a Promise
        expectToBePromise(getAccountSettingsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/groups/settings', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
        expect(options.qs['account_id']).toEqual(accountId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamAccessGroupsService.getAccountSettings(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamAccessGroupsService.getAccountSettings({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getAccountSettingsPromise = iamAccessGroupsService.getAccountSettings();
        expectToBePromise(getAccountSettingsPromise);

        getAccountSettingsPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('updateAccountSettings', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation updateAccountSettings
        const accountId = 'testString';
        const publicAccessEnabled = true;
        const transactionId = 'testString';
        const params = {
          accountId: accountId,
          publicAccessEnabled: publicAccessEnabled,
          transactionId: transactionId,
        };

        const updateAccountSettingsResult = iamAccessGroupsService.updateAccountSettings(params);

        // all methods should return a Promise
        expectToBePromise(updateAccountSettingsResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/groups/settings', 'PATCH');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Transaction-Id', transactionId);
        expect(options.body['public_access_enabled']).toEqual(publicAccessEnabled);
        expect(options.qs['account_id']).toEqual(accountId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const accountId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          accountId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamAccessGroupsService.updateAccountSettings(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamAccessGroupsService.updateAccountSettings({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const updateAccountSettingsPromise = iamAccessGroupsService.updateAccountSettings();
        expectToBePromise(updateAccountSettingsPromise);

        updateAccountSettingsPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
});
