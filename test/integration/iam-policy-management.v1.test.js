/* eslint-disable no-console */
/**
 * (C) Copyright IBM Corp. 2020.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

'use strict';

const IamPolicyManagementV1 = require('../../dist/iam-policy-management/v1');
const { readExternalSources } = require('ibm-cloud-sdk-core');
const authHelper = require('../resources/auth-helper.js');

// testcase timeout value (25s).
const timeout = 25000;

// Location of our config file.
const configFile = 'iam_policy_management.env';

// Use authHelper to skip tests if our configFile is not available.
const describe = authHelper.prepareTests(configFile);

describe('IamPolicyManagementV1_integration', () => {
  jest.setTimeout(timeout);

  let service;
  let config;
  let testAccountId;
  let testPolicyETag;
  let testPolicyId;
  const testUniqueId = Math.floor(Math.random() * 100000);
  const testUserId = 'IBMid-SDKNode' + testUniqueId;
  const testViewerRoleCrn = 'crn:v1:bluemix:public:iam::::role:Viewer';
  const testEditorRoleCrn = 'crn:v1:bluemix:public:iam::::role:Editor';
  const testServiceName = 'iam-groups';
  const policyType = 'access';
  const policySubjects = [
    {
      attributes: [
        {
          name: 'iam_id',
          value: testUserId,
        },
      ],
    },
  ];
  const policyRoles = [
    {
      role_id: testViewerRoleCrn,
    },
  ];
  const policyResourceAccountAttribute = {
    name: 'accountId',
    value: testAccountId,
    operator: 'stringEquals',
  };
  const policyResourceServiceAttribute = {
    name: 'serviceType',
    value: 'service',
    operator: 'stringEquals',
  };
  const policyResourceTag = {
    name: 'project',
    operator: 'stringEquals',
    value: 'prototype',
  };
  const policyResources = [
    {
      attributes: [policyResourceAccountAttribute, policyResourceServiceAttribute],
      tags: [policyResourceTag],
    },
  ];

  let testCustomRoleId;
  let testCustomRoleEtag;
  const testCustomRoleName = 'TestNodeRole' + testUniqueId;
  const testCustomRoleDisplayName = 'SDK ' + testCustomRoleName;
  const testCustomRoleDescription = 'SDK ' + testCustomRoleName;
  const testCustomRoleActions = ['iam-groups.groups.read'];

  test('should successfully complete initialization', done => {
    // Initialize the service client.
    service = IamPolicyManagementV1.newInstance();

    // Grab our test-specific config properties.
    config = readExternalSources(IamPolicyManagementV1.DEFAULT_SERVICE_NAME);

    expect(service).not.toBeNull();
    expect(config).not.toBeNull();
    expect(config).toHaveProperty('testAccountId');

    // Retrieve the test account id to be used with the tests.
    testAccountId = config.testAccountId;
    policyResourceAccountAttribute.value = testAccountId;

    expect(testAccountId).not.toBeNull();
    done();
  });

  describe('Access policy tests', () => {
    test('Create an access policy', async done => {
      const params = {
        type: 'access',
        subjects: policySubjects,
        roles: policyRoles,
        resources: policyResources,
      };

      let response;
      try {
        response = await service.createPolicy(params);
      } catch (err) {
        done(err);
      }

      expect(response).toBeDefined();
      expect(response.status).toEqual(201);
      const { result } = response || {};
      expect(result).toBeDefined();
      expect(result['type']).toEqual(policyType);
      expect(result['subjects']).toEqual(policySubjects);
      expect(result['roles'][0]['role_id']).toEqual(policyRoles[0]['role_id']);
      expect(result['resources']).toEqual(policyResources);

      testPolicyId = result.id;

      done();
    });

    test('Get an access policy', async done => {
      expect(testPolicyId).toBeDefined();

      const params = {
        policyId: testPolicyId,
      };

      let response;
      try {
        response = await service.getPolicy(params);
      } catch (err) {
        done(err);
      }

      expect(response).toBeDefined();
      expect(response.status).toEqual(200);
      const { result } = response || {};
      expect(result).toBeDefined();
      expect(result.id).toEqual(testPolicyId);
      expect(result['type']).toEqual(policyType);
      expect(result['subjects']).toEqual(policySubjects);
      expect(result['roles'][0]['role_id']).toEqual(policyRoles[0]['role_id']);
      expect(result['resources']).toEqual(policyResources);

      testPolicyETag = response.headers.etag;

      done();
    });

    test('Update an access policy', async done => {
      expect(testPolicyId).toBeDefined();
      expect(testPolicyETag).toBeDefined();

      const updPolicyRoles = [
        {
          role_id: testEditorRoleCrn,
        },
      ];

      const params = {
        policyId: testPolicyId,
        ifMatch: testPolicyETag,
        type: 'access',
        subjects: policySubjects,
        roles: updPolicyRoles,
        resources: policyResources,
      };

      let response;
      try {
        response = await service.updatePolicy(params);
      } catch (err) {
        done(err);
      }

      expect(response).toBeDefined();
      expect(response.status).toEqual(200);
      const { result } = response || {};
      expect(result).toBeDefined();
      expect(result.id).toEqual(testPolicyId);
      expect(result['type']).toEqual(policyType);
      expect(result['subjects']).toEqual(policySubjects);
      expect(result['roles'][0]['role_id']).toEqual(updPolicyRoles[0]['role_id']);
      expect(result['resources']).toEqual(policyResources);

      done();
    });

    test('List access policies', async done => {
      expect(testPolicyId).toBeDefined();

      const params = {
        accountId: testAccountId,
        iamId: testUserId,
      };

      let response;
      try {
        response = await service.listPolicies(params);
      } catch (err) {
        done(err);
      }

      expect(response).toBeDefined();
      expect(response.status).toEqual(200);
      const { result } = response || {};
      expect(result).toBeDefined();

      // Confirm the test policy is present
      let foundTestPolicy = false;
      let policy;
      for (policy of result.policies) {
        if (policy.id === testPolicyId) {
          foundTestPolicy = true;
          break;
        }
      }
      expect(foundTestPolicy).toBeTruthy();

      done();
    });

    test('Clean up all test policies', async done => {
      // List all policies for the test user in the account
      const params = {
        accountId: testAccountId,
        iamId: testUserId,
      };

      let response;
      try {
        response = await service.listPolicies(params);
      } catch (err) {
        done(err);
      }

      expect(response).toBeDefined();
      expect(response.status).toEqual(200);
      const { result } = response || {};
      expect(result).toBeDefined();

      // Iterate across the policies
      let policy;
      for (policy of result.policies) {
        // Delete the test policy (or any test policies older than 5 minutes)
        const createdAt = Date.parse(policy.created_at);
        const FIVE_MINUTES = 5 * 60 * 1000;
        const fiveMinutesAgo = Date.now() - FIVE_MINUTES;

        if (policy.id === testPolicyId || createdAt < fiveMinutesAgo) {
          const params = {
            policyId: policy.id,
          };

          let response;
          try {
            response = await service.deletePolicy(params);
          } catch (err) {
            done(err);
          }

          expect(response).toBeDefined();
          expect(response.status).toEqual(204);
        }
      }

      done();
    });
  });

  describe('Custom roles tests', () => {
    test('Create a custom role', async done => {
      const params = {
        displayName: testCustomRoleDisplayName,
        description: testCustomRoleDescription,
        name: testCustomRoleName,
        accountId: testAccountId,
        serviceName: testServiceName,
        actions: testCustomRoleActions,
      };

      let response;
      try {
        response = await service.createRole(params);
      } catch (err) {
        done(err);
      }

      expect(response).toBeDefined();
      expect(response.status).toEqual(201);
      const { result } = response || {};
      expect(result).toBeDefined();
      expect(result['name']).toEqual(testCustomRoleName);
      expect(result['display_name']).toEqual(testCustomRoleDisplayName);
      expect(result['description']).toEqual(testCustomRoleDescription);
      expect(result['account_id']).toEqual(testAccountId);
      expect(result['service_name']).toEqual(testServiceName);
      expect(result['actions']).toEqual(testCustomRoleActions);

      testCustomRoleId = result.id;

      done();
    });

    test('Get a custom role', async done => {
      expect(testCustomRoleId).toBeDefined();

      const params = {
        roleId: testCustomRoleId,
      };

      let response;
      try {
        response = await service.getRole(params);
      } catch (err) {
        done(err);
      }

      expect(response).toBeDefined();
      expect(response.status).toEqual(200);
      const { result } = response || {};
      expect(result).toBeDefined();
      expect(result.id).toEqual(testCustomRoleId);
      expect(result['name']).toEqual(testCustomRoleName);
      expect(result['display_name']).toEqual(testCustomRoleDisplayName);
      expect(result['description']).toEqual(testCustomRoleDescription);
      expect(result['account_id']).toEqual(testAccountId);
      expect(result['service_name']).toEqual(testServiceName);
      expect(result['actions']).toEqual(testCustomRoleActions);

      testCustomRoleEtag = response.headers.etag;

      done();
    });

    test('Update a custom role', async done => {
      expect(testCustomRoleId).toBeDefined();
      expect(testCustomRoleEtag).toBeDefined();

      const updCustomRoleDescription = 'Udated description';

      const params = {
        roleId: testCustomRoleId,
        ifMatch: testCustomRoleEtag,
        description: updCustomRoleDescription,
        headers: { 'transaction-Id': 'SDKNode-' + testUniqueId },
      };

      let response;
      try {
        response = await service.updateRole(params);
      } catch (err) {
        done(err);
      }

      expect(response).toBeDefined();
      expect(response.status).toEqual(200);
      const { result } = response || {};
      expect(result).toBeDefined();
      expect(result.id).toEqual(testCustomRoleId);
      expect(result['name']).toEqual(testCustomRoleName);
      expect(result['display_name']).toEqual(testCustomRoleDisplayName);
      expect(result['description']).toEqual(updCustomRoleDescription);
      expect(result['account_id']).toEqual(testAccountId);
      expect(result['service_name']).toEqual(testServiceName);
      expect(result['actions']).toEqual(testCustomRoleActions);

      done();
    });

    test('List custom roles', async done => {
      expect(testCustomRoleId).toBeDefined();

      const params = {
        accountId: testAccountId,
        serviceName: testServiceName,
      };

      let response;
      try {
        response = await service.listRoles(params);
      } catch (err) {
        done(err);
      }

      expect(response).toBeDefined();
      expect(response.status).toEqual(200);
      const { result } = response || {};
      expect(result).toBeDefined();

      // Confirm the test role is present
      let foundCustomRole = false;
      let role;
      for (role of result.custom_roles) {
        if (role.id === testCustomRoleId) {
          foundCustomRole = true;
          break;
        }
      }
      expect(foundCustomRole).toBeTruthy();

      done();
    });

    test('Clean up all test custom roles', async done => {
      // List all custom roles in the account
      const params = {
        accountId: testAccountId,
        serviceName: testServiceName,
      };

      let response;
      try {
        response = await service.listRoles(params);
      } catch (err) {
        done(err);
      }

      expect(response).toBeDefined();
      expect(response.status).toEqual(200);
      const { result } = response || {};
      expect(result).toBeDefined();

      // Iterate across the custom_roles
      let role;
      for (role of result.custom_roles) {
        // Delete the test role (or any test role older than 5 minutes)
        const createdAt = Date.parse(role.created_at);
        const FIVE_MINUTES = 5 * 60 * 1000;
        const fiveMinutesAgo = Date.now() - FIVE_MINUTES;

        if (role.id === testCustomRoleId || createdAt < fiveMinutesAgo) {
          const params = {
            roleId: role.id,
          };

          let response;
          try {
            response = await service.deleteRole(params);
          } catch (err) {
            done(err);
          }

          expect(response).toBeDefined();
          expect(response.status).toEqual(204);
        }
      }

      done();
    });
  });
});
