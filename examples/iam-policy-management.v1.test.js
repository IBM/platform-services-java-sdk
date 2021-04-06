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

const IamPolicyManagementV1 = require('../dist/iam-policy-management/v1');
const { readExternalSources } = require('ibm-cloud-sdk-core');
const authHelper = require('../test/resources/auth-helper.js');

//
// This file provides an example of how to use the IAM Policy Management service.
//
// The following configuration properties are assumed to be defined:
//
// IAM_POLICY_MANAGEMENT_URL=<service url>
// IAM_POLICY_MANAGEMENT_AUTH_TYPE=iam
// IAM_POLICY_MANAGEMENT_AUTH_URL=<IAM token service URL - omit this if using the production environment>
// IAM_POLICY_MANAGEMENT_APIKEY=<YOUR_APIKEY>
// IAM_POLICY_MANAGEMENT_TEST_ACCOUNT_ID=<YOUR_ACCOUNT_ID>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of config file>
//
// Location of our config file.
const configFile = 'iam_policy_management.env';

const describe = authHelper.prepareTests(configFile);

// Save original console.log and console.warn
const originalLog = console.log;
const originalWarn = console.warn;

// Mocks for console.log and console.warn
const consoleLogMock = jest.spyOn(console, 'log');
const consoleWarnMock = jest.spyOn(console, 'warn');

describe('IamPolicyManagementV1', () => {

  let exampleAccountId;
  let examplePolicyId;
  let examplePolicyETag;
  let exampleCustomRoleId;
  let exampleCustomRoleEtag;
  const exampleUserId = 'IBMid-user1';
  const exampleServiceName = 'iam-groups';

  // begin-common

  const iamPolicyManagementService = IamPolicyManagementV1.newInstance({});

  // end-common

  const config = readExternalSources(IamPolicyManagementV1.DEFAULT_SERVICE_NAME);

  expect(iamPolicyManagementService).not.toBeNull();
  expect(config).not.toBeNull();
  expect(config).toHaveProperty('testAccountId');
  exampleAccountId = config.testAccountId;

  test('createPolicy request example', done => {
    expect(exampleAccountId).not.toBeNull();

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-create_policy

    const policySubjects = [
      {
        attributes: [
          {
            name: 'iam_id',
            value: exampleUserId,
          },
        ],
      },
    ];
    const policyRoles = [
      {
        role_id: 'crn:v1:bluemix:public:iam::::role:Viewer',
      },
    ];
    const accountIdResourceAttribute = {
      name: 'accountId',
      value: exampleAccountId,
      operator: 'stringEquals',
    };
    const serviceNameResourceAttribute = {
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
        attributes: [accountIdResourceAttribute, serviceNameResourceAttribute],
        tags: [policyResourceTag],
      },
    ];
    const params = {
      type: 'access',
      subjects: policySubjects,
      roles: policyRoles,
      resources: policyResources,
    };

    iamPolicyManagementService.createPolicy(params)
      .then(res => {
        examplePolicyId = res.result.id;
        console.log('createPolicy() result:\n' + JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-create_policy
  });
  test('getPolicy request example', done => {
    expect(examplePolicyId).toBeDefined();

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-get_policy

    const params = {
      policyId: examplePolicyId,
    };

    iamPolicyManagementService.getPolicy(params)
      .then(res => {
        examplePolicyETag = res.headers.etag;
        console.log('getPolicy() result:\n' + JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-get_policy
  });
  test('updatePolicy request example', done => {
    expect(exampleAccountId).not.toBeNull();
    expect(examplePolicyId).toBeDefined();
    expect(examplePolicyETag).toBeDefined();

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-update_policy

    const policySubjects = [
      {
        attributes: [
          {
            name: 'iam_id',
            value: exampleUserId,
          },
        ],
      },
    ];
    const accountIdResourceAttribute = {
      name: 'accountId',
      value: exampleAccountId,
      operator: 'stringEquals',
    };
    const serviceNameResourceAttribute = {
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
        attributes: [accountIdResourceAttribute, serviceNameResourceAttribute],
        tags: [policyResourceTag],
      },
    ];
    const updatedPolicyRoles = [
      {
        role_id: 'crn:v1:bluemix:public:iam::::role:Editor',
      },
    ];
    const params = {
      type: 'access',
      policyId: examplePolicyId,
      ifMatch: examplePolicyETag,
      subjects: policySubjects,
      roles: updatedPolicyRoles,
      resources: policyResources,
    };

    iamPolicyManagementService.updatePolicy(params)
      .then(res => {
        examplePolicyETag = res.headers.etag;
        console.log('updatePolicy() result:\n' + JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-update_policy
  });
  test('patchPolicy request example', done => {
    expect(examplePolicyId).toBeDefined();
    expect(examplePolicyETag).toBeDefined();

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-patch_policy

    const params = {
      policyId: examplePolicyId,
      ifMatch: examplePolicyETag,
      state: 'active'
    };

    iamPolicyManagementService.patchPolicy(params)
      .then(res => {
        console.log(JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-patch_policy
  });
  test('listPolicies request example', done => {
    expect(exampleAccountId).not.toBeNull();

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-list_policies

    const params = {
      accountId: exampleAccountId,
      iamId: exampleUserId,
      format: 'include_last_permit',
    };

    iamPolicyManagementService.listPolicies(params)
      .then(res => {
        console.log('listPolicies() result:\n' + JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-list_policies
  });
  test('deletePolicy request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-delete_policy

    const params = {
      policyId: examplePolicyId,
    };

    iamPolicyManagementService.deletePolicy(params)
      .then(res => {
        console.log('deletePolicy() response status code: ' + res.status);
      })
      .catch(err => {
        console.warn(err)
      });

    // end-delete_policy
  });
  test('createRole request example', done => {
    expect(exampleAccountId).not.toBeNull();

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-create_role

    const params = {
      displayName: 'IAM Groups read access',
      actions: ['iam-groups.groups.read'],
      name: 'ExampleRoleIAMGroups',
      accountId: exampleAccountId,
      serviceName: exampleServiceName,
    };

    iamPolicyManagementService.createRole(params)
      .then(res => {
        exampleCustomRoleId = res.result.id;
        console.log('createRole() result:\n' + JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-create_role
  });
  test('getRole request example', done => {
    expect(exampleCustomRoleId).toBeDefined();

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-get_role

    const params = {
      roleId: exampleCustomRoleId,
    };

    iamPolicyManagementService.getRole(params)
      .then(res => {
        exampleCustomRoleEtag = res.headers.etag;
        console.log('getRole() result:\n' + JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-get_role
  });
  test('updateRole request example', done => {
    expect(exampleCustomRoleId).toBeDefined();
    expect(exampleCustomRoleEtag).toBeDefined();

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-update_role

    const updatedRoleActions = ['iam-groups.groups.read', 'iam-groups.groups.list'];
    const params = {
      roleId: exampleCustomRoleId,
      ifMatch: exampleCustomRoleEtag,
      actions: updatedRoleActions,
    };

    iamPolicyManagementService.updateRole(params)
      .then(res => {
        console.log('updateRole() result:\n' + JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-update_role
  });
  test('listRoles request example', done => {

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-list_roles

    const params = {
      accountId: exampleAccountId,
    };

    iamPolicyManagementService.listRoles(params)
      .then(res => {
        console.log('listRoles() result:\n' + JSON.stringify(res.result, null, 2));
      })
      .catch(err => {
        console.warn(err)
      });

    // end-list_roles
  });
  test('deleteRole request example', done => {
    expect(exampleCustomRoleId).toBeDefined();

    consoleLogMock.mockImplementation(output => {
      originalLog(output);
      done();
    });
    consoleWarnMock.mockImplementation(output => {
      done(output);
    });

    // begin-delete_role

    const params = {
      roleId: exampleCustomRoleId,
    };

    iamPolicyManagementService.deleteRole(params)
      .then(res => {
        console.log('deleteRole() response status code: ' + res.status);
      })
      .catch(err => {
        console.warn(err)
      });

    // end-delete_role
  });
});
