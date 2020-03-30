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

const IamPolicyManagementV1 = require('../../dist/iam-policy-management/v1');

const {
  getOptions,
  checkUrlAndMethod,
  checkMediaHeaders,
  expectToBePromise,
  checkUserHeader,
  checkForSuccessfulExecution,
} = unitTestUtils;

const service = {
  authenticator: new NoAuthAuthenticator(),
  url: 'https://iam.test.cloud.ibm.com',
};

const iamPolicyManagement = new IamPolicyManagementV1(service);

// dont actually create a request
const createRequestMock = jest.spyOn(iamPolicyManagement, 'createRequest');
createRequestMock.mockImplementation(() => Promise.resolve());

// dont actually construct an authenticator
const getAuthenticatorMock = jest.spyOn(core, 'getAuthenticatorFromEnvironment');
getAuthenticatorMock.mockImplementation(() => new NoAuthAuthenticator());

afterEach(() => {
  createRequestMock.mockClear();
  getAuthenticatorMock.mockClear();
});

describe('IamPolicyManagementV1', () => {
  describe('the newInstance method', () => {
    test('should use defaults when options not provided', () => {
      const testInstance = IamPolicyManagementV1.newInstance();

      expect(getAuthenticatorMock).toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceName).toBe(IamPolicyManagementV1.DEFAULT_SERVICE_NAME);
      expect(testInstance.baseOptions.serviceUrl).toBe(IamPolicyManagementV1.DEFAULT_SERVICE_URL);
      expect(testInstance).toBeInstanceOf(IamPolicyManagementV1);
    });

    test('should set serviceName, serviceUrl, and authenticator when provided', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
        serviceName: 'my-service',
      };

      const testInstance = IamPolicyManagementV1.newInstance(options);

      expect(getAuthenticatorMock).not.toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
      expect(testInstance.baseOptions.serviceName).toBe('my-service');
      expect(testInstance).toBeInstanceOf(IamPolicyManagementV1);
    });
  });
  describe('the constructor', () => {
    test('use user-given service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
      };

      const testInstance = new IamPolicyManagementV1(options);

      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
    });

    test('use default service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
      };

      const testInstance = new IamPolicyManagementV1(options);

      expect(testInstance.baseOptions.serviceUrl).toBe(IamPolicyManagementV1.DEFAULT_SERVICE_URL);
    });
  });
  describe('listPolicies', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listPolicies
        const accountId = 'testString';
        const acceptLanguage = 'testString';
        const iamId = 'testString';
        const accessGroupId = 'testString';
        const type = 'testString';
        const serviceType = 'testString';
        const params = {
          accountId: accountId,
          acceptLanguage: acceptLanguage,
          iamId: iamId,
          accessGroupId: accessGroupId,
          type: type,
          serviceType: serviceType,
        };

        const listPoliciesResult = iamPolicyManagement.listPolicies(params);

        // all methods should return a Promise
        expectToBePromise(listPoliciesResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/policies', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Accept-Language', acceptLanguage);
        expect(options.qs['account_id']).toEqual(accountId);
        expect(options.qs['iam_id']).toEqual(iamId);
        expect(options.qs['access_group_id']).toEqual(accessGroupId);
        expect(options.qs['type']).toEqual(type);
        expect(options.qs['service_type']).toEqual(serviceType);
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

        iamPolicyManagement.listPolicies(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamPolicyManagement.listPolicies({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const listPoliciesPromise = iamPolicyManagement.listPolicies();
        expectToBePromise(listPoliciesPromise);

        listPoliciesPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('createPolicy', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // PolicyRequestSubjectsItemAttributesItem
      const policyRequestSubjectsItemAttributesItemModel = {
        name: 'testString',
        value: 'testString',
      };

      // PolicyRequestSubjectsItem
      const policyRequestSubjectsItemModel = {
        attributes: [policyRequestSubjectsItemAttributesItemModel],
      };

      // PolicyRequestRolesItem
      const policyRequestRolesItemModel = {
        role_id: 'testString',
      };

      // PolicyRequestResourcesItemAttributesItem
      const policyRequestResourcesItemAttributesItemModel = {
        name: 'testString',
        value: 'testString',
        operator: 'testString',
      };

      // PolicyRequestResourcesItem
      const policyRequestResourcesItemModel = {
        attributes: [policyRequestResourcesItemAttributesItemModel],
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createPolicy
        const type = 'testString';
        const subjects = [policyRequestSubjectsItemModel];
        const roles = [policyRequestRolesItemModel];
        const resources = [policyRequestResourcesItemModel];
        const acceptLanguage = 'testString';
        const params = {
          type: type,
          subjects: subjects,
          roles: roles,
          resources: resources,
          acceptLanguage: acceptLanguage,
        };

        const createPolicyResult = iamPolicyManagement.createPolicy(params);

        // all methods should return a Promise
        expectToBePromise(createPolicyResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/policies', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Accept-Language', acceptLanguage);
        expect(options.body['type']).toEqual(type);
        expect(options.body['subjects']).toEqual(subjects);
        expect(options.body['roles']).toEqual(roles);
        expect(options.body['resources']).toEqual(resources);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const type = 'testString';
        const subjects = [policyRequestSubjectsItemModel];
        const roles = [policyRequestRolesItemModel];
        const resources = [policyRequestResourcesItemModel];
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          type,
          subjects,
          roles,
          resources,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamPolicyManagement.createPolicy(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamPolicyManagement.createPolicy({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const createPolicyPromise = iamPolicyManagement.createPolicy();
        expectToBePromise(createPolicyPromise);

        createPolicyPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('updatePolicy', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // PolicyRequestSubjectsItemAttributesItem
      const policyRequestSubjectsItemAttributesItemModel = {
        name: 'testString',
        value: 'testString',
      };

      // PolicyRequestSubjectsItem
      const policyRequestSubjectsItemModel = {
        attributes: [policyRequestSubjectsItemAttributesItemModel],
      };

      // PolicyRequestRolesItem
      const policyRequestRolesItemModel = {
        role_id: 'testString',
      };

      // PolicyRequestResourcesItemAttributesItem
      const policyRequestResourcesItemAttributesItemModel = {
        name: 'testString',
        value: 'testString',
        operator: 'testString',
      };

      // PolicyRequestResourcesItem
      const policyRequestResourcesItemModel = {
        attributes: [policyRequestResourcesItemAttributesItemModel],
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation updatePolicy
        const policyId = 'testString';
        const ifMatch = 'testString';
        const type = 'testString';
        const subjects = [policyRequestSubjectsItemModel];
        const roles = [policyRequestRolesItemModel];
        const resources = [policyRequestResourcesItemModel];
        const params = {
          policyId: policyId,
          ifMatch: ifMatch,
          type: type,
          subjects: subjects,
          roles: roles,
          resources: resources,
        };

        const updatePolicyResult = iamPolicyManagement.updatePolicy(params);

        // all methods should return a Promise
        expectToBePromise(updatePolicyResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/policies/{policy_id}', 'PUT');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'If-Match', ifMatch);
        expect(options.body['type']).toEqual(type);
        expect(options.body['subjects']).toEqual(subjects);
        expect(options.body['roles']).toEqual(roles);
        expect(options.body['resources']).toEqual(resources);
        expect(options.path['policy_id']).toEqual(policyId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const policyId = 'testString';
        const ifMatch = 'testString';
        const type = 'testString';
        const subjects = [policyRequestSubjectsItemModel];
        const roles = [policyRequestRolesItemModel];
        const resources = [policyRequestResourcesItemModel];
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          policyId,
          ifMatch,
          type,
          subjects,
          roles,
          resources,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamPolicyManagement.updatePolicy(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamPolicyManagement.updatePolicy({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const updatePolicyPromise = iamPolicyManagement.updatePolicy();
        expectToBePromise(updatePolicyPromise);

        updatePolicyPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getPolicy', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getPolicy
        const policyId = 'testString';
        const params = {
          policyId: policyId,
        };

        const getPolicyResult = iamPolicyManagement.getPolicy(params);

        // all methods should return a Promise
        expectToBePromise(getPolicyResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/policies/{policy_id}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['policy_id']).toEqual(policyId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const policyId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          policyId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamPolicyManagement.getPolicy(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamPolicyManagement.getPolicy({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getPolicyPromise = iamPolicyManagement.getPolicy();
        expectToBePromise(getPolicyPromise);

        getPolicyPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deletePolicy', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deletePolicy
        const policyId = 'testString';
        const params = {
          policyId: policyId,
        };

        const deletePolicyResult = iamPolicyManagement.deletePolicy(params);

        // all methods should return a Promise
        expectToBePromise(deletePolicyResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v1/policies/{policy_id}', 'DELETE');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['policy_id']).toEqual(policyId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const policyId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          policyId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamPolicyManagement.deletePolicy(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamPolicyManagement.deletePolicy({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const deletePolicyPromise = iamPolicyManagement.deletePolicy();
        expectToBePromise(deletePolicyPromise);

        deletePolicyPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('listRoles', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation listRoles
        const acceptLanguage = 'testString';
        const accountId = 'testString';
        const serviceName = 'testString';
        const params = {
          acceptLanguage: acceptLanguage,
          accountId: accountId,
          serviceName: serviceName,
        };

        const listRolesResult = iamPolicyManagement.listRoles(params);

        // all methods should return a Promise
        expectToBePromise(listRolesResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/roles', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Accept-Language', acceptLanguage);
        expect(options.qs['account_id']).toEqual(accountId);
        expect(options.qs['service_name']).toEqual(serviceName);
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

        iamPolicyManagement.listRoles(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        iamPolicyManagement.listRoles({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('createRole', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createRole
        const name = 'testString';
        const accountId = 'testString';
        const serviceName = 'testString';
        const displayName = 'testString';
        const actions = ['testString'];
        const description = 'testString';
        const acceptLanguage = 'testString';
        const params = {
          name: name,
          accountId: accountId,
          serviceName: serviceName,
          displayName: displayName,
          actions: actions,
          description: description,
          acceptLanguage: acceptLanguage,
        };

        const createRoleResult = iamPolicyManagement.createRole(params);

        // all methods should return a Promise
        expectToBePromise(createRoleResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/roles', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'Accept-Language', acceptLanguage);
        expect(options.body['name']).toEqual(name);
        expect(options.body['account_id']).toEqual(accountId);
        expect(options.body['service_name']).toEqual(serviceName);
        expect(options.body['display_name']).toEqual(displayName);
        expect(options.body['actions']).toEqual(actions);
        expect(options.body['description']).toEqual(description);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const name = 'testString';
        const accountId = 'testString';
        const serviceName = 'testString';
        const displayName = 'testString';
        const actions = ['testString'];
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          name,
          accountId,
          serviceName,
          displayName,
          actions,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamPolicyManagement.createRole(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamPolicyManagement.createRole({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const createRolePromise = iamPolicyManagement.createRole();
        expectToBePromise(createRolePromise);

        createRolePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('updateRole', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation updateRole
        const roleId = 'testString';
        const ifMatch = 'testString';
        const displayName = 'testString';
        const description = 'testString';
        const actions = ['testString'];
        const params = {
          roleId: roleId,
          ifMatch: ifMatch,
          displayName: displayName,
          description: description,
          actions: actions,
        };

        const updateRoleResult = iamPolicyManagement.updateRole(params);

        // all methods should return a Promise
        expectToBePromise(updateRoleResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/roles/{role_id}', 'PUT');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        checkUserHeader(createRequestMock, 'If-Match', ifMatch);
        expect(options.body['display_name']).toEqual(displayName);
        expect(options.body['description']).toEqual(description);
        expect(options.body['actions']).toEqual(actions);
        expect(options.path['role_id']).toEqual(roleId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const roleId = 'testString';
        const ifMatch = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          roleId,
          ifMatch,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamPolicyManagement.updateRole(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamPolicyManagement.updateRole({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const updateRolePromise = iamPolicyManagement.updateRole();
        expectToBePromise(updateRolePromise);

        updateRolePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getRole', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getRole
        const roleId = 'testString';
        const params = {
          roleId: roleId,
        };

        const getRoleResult = iamPolicyManagement.getRole(params);

        // all methods should return a Promise
        expectToBePromise(getRoleResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/roles/{role_id}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['role_id']).toEqual(roleId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const roleId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          roleId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamPolicyManagement.getRole(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamPolicyManagement.getRole({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getRolePromise = iamPolicyManagement.getRole();
        expectToBePromise(getRolePromise);

        getRolePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deleteRole', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteRole
        const roleId = 'testString';
        const params = {
          roleId: roleId,
        };

        const deleteRoleResult = iamPolicyManagement.deleteRole(params);

        // all methods should return a Promise
        expectToBePromise(deleteRoleResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/v2/roles/{role_id}', 'DELETE');
        const expectedAccept = undefined;
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['role_id']).toEqual(roleId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const roleId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          roleId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        iamPolicyManagement.deleteRole(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await iamPolicyManagement.deleteRole({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const deleteRolePromise = iamPolicyManagement.deleteRole();
        expectToBePromise(deleteRolePromise);

        deleteRolePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
});
