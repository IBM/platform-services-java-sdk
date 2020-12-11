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

/**
 * IBM OpenAPI SDK Code Generator Version: 99-SNAPSHOT-d753183b-20201209-163011
 */


import * as extend from 'extend';
import { IncomingHttpHeaders, OutgoingHttpHeaders } from 'http';
import { Authenticator, BaseService, getAuthenticatorFromEnvironment, getMissingParams, UserOptions } from 'ibm-cloud-sdk-core';
import { getSdkHeaders } from '../lib/common';

/**
 * IAM Policy Management API
 */

class IamPolicyManagementV1 extends BaseService {

  static DEFAULT_SERVICE_URL: string = 'https://iam.cloud.ibm.com';
  static DEFAULT_SERVICE_NAME: string = 'iam_policy_management';

  /*************************
   * Factory method
   ************************/

  /**
   * Constructs an instance of IamPolicyManagementV1 with passed in options and external configuration.
   *
   * @param {UserOptions} [options] - The parameters to send to the service.
   * @param {string} [options.serviceName] - The name of the service to configure
   * @param {Authenticator} [options.authenticator] - The Authenticator object used to authenticate requests to the service
   * @param {string} [options.serviceUrl] - The URL for the service
   * @returns {IamPolicyManagementV1}
   */

  public static newInstance(options: UserOptions): IamPolicyManagementV1 {
    options = options || {};

    if (!options.serviceName) {
      options.serviceName = this.DEFAULT_SERVICE_NAME;
    }
    if (!options.authenticator) {
      options.authenticator = getAuthenticatorFromEnvironment(options.serviceName);
    }
    const service = new IamPolicyManagementV1(options);
    service.configureService(options.serviceName);
    if (options.serviceUrl) {
      service.setServiceUrl(options.serviceUrl);
    }
    return service;
  }


  /**
   * Construct a IamPolicyManagementV1 object.
   *
   * @param {Object} options - Options for the service.
   * @param {string} [options.serviceUrl] - The base url to use when contacting the service. The base url may differ between IBM Cloud regions.
   * @param {OutgoingHttpHeaders} [options.headers] - Default headers that shall be included with every request to the service.
   * @param {Authenticator} options.authenticator - The Authenticator object used to authenticate requests to the service
   * @constructor
   * @returns {IamPolicyManagementV1}
   */
  constructor(options: UserOptions) {
    options = options || {};

    super(options);
    if (options.serviceUrl) {
      this.setServiceUrl(options.serviceUrl);
    } else {
      this.setServiceUrl(IamPolicyManagementV1.DEFAULT_SERVICE_URL);
    }
  }

  /*************************
   * policies
   ************************/

  /**
   * Get policies by attributes.
   *
   * Get policies and filter by attributes. While managing policies, you may want to retrieve policies in the account
   * and filter by attribute values. This can be done through query parameters. Currently, we only support the following
   * attributes: account_id, iam_id, access_group_id, type, and service_type. account_id is a required query parameter.
   * Only policies that have the specified attributes and that the caller has read access to are returned. If the caller
   * does not have read access to any policies an empty array is returned.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - The account GUID in which the policies belong to.
   * @param {string} [params.acceptLanguage] - Translation language code.
   * @param {string} [params.iamId] - The IAM ID used to identify the subject.
   * @param {string} [params.accessGroupId] - The access group id.
   * @param {string} [params.type] - The type of policy (access or authorization).
   * @param {string} [params.serviceType] - The type of service.
   * @param {string} [params.sort] - Sort the results by any of the top level policy fields (id, created_at,
   * created_by_id, last_modified_at, etc).
   * @param {string} [params.format] - Include additional data per policy returned [include_last_permit, display].
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamPolicyManagementV1.Response<IamPolicyManagementV1.PolicyList>>}
   */
  public listPolicies(params: IamPolicyManagementV1.ListPoliciesParams): Promise<IamPolicyManagementV1.Response<IamPolicyManagementV1.PolicyList>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['accountId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'account_id': _params.accountId,
      'iam_id': _params.iamId,
      'access_group_id': _params.accessGroupId,
      'type': _params.type,
      'service_type': _params.serviceType,
      'sort': _params.sort,
      'format': _params.format
    };

    const sdkHeaders = getSdkHeaders(IamPolicyManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'listPolicies');

    const parameters = {
      options: {
        url: '/v1/policies',
        method: 'GET',
        qs: query,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Accept-Language': _params.acceptLanguage
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Create a policy.
   *
   * Creates a policy to grant access between a subject and a resource. There are two types of policies: **access** and
   * **authorization**. A policy administrator might want to create an access policy which grants access to a user,
   * service-id, or an access group. They might also want to create an authorization policy and setup access between
   * services.
   * ### Access To create an access policy, use **`"type": "access"`** in the body. The possible subject attributes are
   * **`iam_id`** and **`access_group_id`**. Use the **`iam_id`** subject attribute for assigning access for a user or
   * service-id. Use the **`access_group_id`** subject attribute for assigning access for an access group. The roles
   * must be a subset of a service's or the platform's supported roles. The resource attributes must be a subset of a
   * service's or the platform's supported attributes. The policy resource must include either the **`serviceType`**,
   * **`serviceName`**,  or **`resourceGroupId`** attribute and the **`accountId`** attribute.` If the subject is a
   * locked service-id, the request will fail.
   * ### Authorization Authorization policies are supported by services on a case by case basis. Refer to service
   * documentation to verify their support of authorization policies. To create an authorization policy, use **`"type":
   * "authorization"`** in the body. The subject attributes must match the supported authorization subjects of the
   * resource. Multiple subject attributes might be provided. The following attributes are supported:
   *   serviceName, serviceInstance, region, resourceType, resource, accountId The policy roles must be a subset of the
   * supported authorization roles supported by the target service. The user must also have the same level of access or
   * greater to the target resource in order to grant the role. The resource attributes must be a subset of a service's
   * or the platform's supported attributes. Both the policy subject and the policy resource must include the
   * **`serviceName`** and **`accountId`** attributes.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.type - The policy type; either 'access' or 'authorization'.
   * @param {PolicySubject[]} params.subjects - The subjects associated with a policy.
   * @param {PolicyRole[]} params.roles - A set of role cloud resource names (CRNs) granted by the policy.
   * @param {PolicyResource[]} params.resources - The resources associated with a policy.
   * @param {string} [params.description] - Customer-defined description.
   * @param {string} [params.acceptLanguage] - Translation language code.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamPolicyManagementV1.Response<IamPolicyManagementV1.Policy>>}
   */
  public createPolicy(params: IamPolicyManagementV1.CreatePolicyParams): Promise<IamPolicyManagementV1.Response<IamPolicyManagementV1.Policy>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['type', 'subjects', 'roles', 'resources'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'type': _params.type,
      'subjects': _params.subjects,
      'roles': _params.roles,
      'resources': _params.resources,
      'description': _params.description
    };

    const sdkHeaders = getSdkHeaders(IamPolicyManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'createPolicy');

    const parameters = {
      options: {
        url: '/v1/policies',
        method: 'POST',
        body,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
          'Accept-Language': _params.acceptLanguage
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Update a policy.
   *
   * Update a policy to grant access between a subject and a resource. A policy administrator might want to update an
   * existing policy. The policy type cannot be changed (You cannot change an access policy to an authorization policy).
   * ### Access To update an access policy, use **`"type": "access"`** in the body. The possible subject attributes are
   * **`iam_id`** and **`access_group_id`**. Use the **`iam_id`** subject attribute for assigning access for a user or
   * service-id. Use the **`access_group_id`** subject attribute for assigning access for an access group. The roles
   * must be a subset of a service's or the platform's supported roles. The resource attributes must be a subset of a
   * service's or the platform's supported attributes. The policy resource must include either the **`serviceType`**,
   * **`serviceName`**,  or **`resourceGroupId`** attribute and the **`accountId`** attribute.` If the subject is a
   * locked service-id, the request will fail.
   * ### Authorization To update an authorization policy, use **`"type": "authorization"`** in the body. The subject
   * attributes must match the supported authorization subjects of the resource. Multiple subject attributes might be
   * provided. The following attributes are supported:
   *   serviceName, serviceInstance, region, resourceType, resource, accountId The policy roles must be a subset of the
   * supported authorization roles supported by the target service. The user must also have the same level of access or
   * greater to the target resource in order to grant the role. The resource attributes must be a subset of a service's
   * or the platform's supported attributes. Both the policy subject and the policy resource must include the
   * **`serviceName`** and **`accountId`** attributes.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.policyId - The policy ID.
   * @param {string} params.ifMatch - The revision number for updating a policy and must match the ETag value of the
   * existing policy. The Etag can be retrieved using the GET /v1/policies/{policy_id} API and looking at the ETag
   * response header.
   * @param {string} params.type - The policy type; either 'access' or 'authorization'.
   * @param {PolicySubject[]} params.subjects - The subjects associated with a policy.
   * @param {PolicyRole[]} params.roles - A set of role cloud resource names (CRNs) granted by the policy.
   * @param {PolicyResource[]} params.resources - The resources associated with a policy.
   * @param {string} [params.description] - Customer-defined description.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamPolicyManagementV1.Response<IamPolicyManagementV1.Policy>>}
   */
  public updatePolicy(params: IamPolicyManagementV1.UpdatePolicyParams): Promise<IamPolicyManagementV1.Response<IamPolicyManagementV1.Policy>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['policyId', 'ifMatch', 'type', 'subjects', 'roles', 'resources'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'type': _params.type,
      'subjects': _params.subjects,
      'roles': _params.roles,
      'resources': _params.resources,
      'description': _params.description
    };

    const path = {
      'policy_id': _params.policyId
    };

    const sdkHeaders = getSdkHeaders(IamPolicyManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'updatePolicy');

    const parameters = {
      options: {
        url: '/v1/policies/{policy_id}',
        method: 'PUT',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
          'If-Match': _params.ifMatch
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Retrieve a policy by ID.
   *
   * Retrieve a policy by providing a policy ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.policyId - The policy ID.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamPolicyManagementV1.Response<IamPolicyManagementV1.Policy>>}
   */
  public getPolicy(params: IamPolicyManagementV1.GetPolicyParams): Promise<IamPolicyManagementV1.Response<IamPolicyManagementV1.Policy>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['policyId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'policy_id': _params.policyId
    };

    const sdkHeaders = getSdkHeaders(IamPolicyManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getPolicy');

    const parameters = {
      options: {
        url: '/v1/policies/{policy_id}',
        method: 'GET',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Delete a policy by ID.
   *
   * Delete a policy by providing a policy ID. A policy cannot be deleted if the subject ID contains a locked service
   * ID. If the subject of the policy is a locked service-id, the request will fail.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.policyId - The policy ID.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamPolicyManagementV1.Response<IamPolicyManagementV1.Empty>>}
   */
  public deletePolicy(params: IamPolicyManagementV1.DeletePolicyParams): Promise<IamPolicyManagementV1.Response<IamPolicyManagementV1.Empty>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['policyId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'policy_id': _params.policyId
    };

    const sdkHeaders = getSdkHeaders(IamPolicyManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'deletePolicy');

    const parameters = {
      options: {
        url: '/v1/policies/{policy_id}',
        method: 'DELETE',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /*************************
   * roles
   ************************/

  /**
   * Get roles by filters.
   *
   * Get roles based on the filters. While managing roles, you may want to retrieve roles and filter by usages. This can
   * be done through query parameters. Currently, we only support the following attributes: account_id, and
   * service_name. Only roles that match the filter and that the caller has read access to are returned. If the caller
   * does not have read access to any roles an empty array is returned.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {string} [params.acceptLanguage] - Translation language code.
   * @param {string} [params.accountId] - The account GUID in which the roles belong to.
   * @param {string} [params.serviceName] - The name of service.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamPolicyManagementV1.Response<IamPolicyManagementV1.RoleList>>}
   */
  public listRoles(params?: IamPolicyManagementV1.ListRolesParams): Promise<IamPolicyManagementV1.Response<IamPolicyManagementV1.RoleList>> {
    const _params = Object.assign({}, params);

    const query = {
      'account_id': _params.accountId,
      'service_name': _params.serviceName
    };

    const sdkHeaders = getSdkHeaders(IamPolicyManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'listRoles');

    const parameters = {
      options: {
        url: '/v2/roles',
        method: 'GET',
        qs: query,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Accept-Language': _params.acceptLanguage
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Create a role.
   *
   * Creates a custom role for a specific service within the account. An account owner or a user assigned the
   * Administrator role on the Role management service can create a custom role. Any number of actions for a single
   * service can be mapped to the new role, but there must be at least one service-defined action to successfully create
   * the new role.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.displayName - The display name of the role that is shown in the console.
   * @param {string[]} params.actions - The actions of the role.
   * @param {string} params.name - The name of the role that is used in the CRN. Can only be alphanumeric and has to be
   * capitalized.
   * @param {string} params.accountId - The account GUID.
   * @param {string} params.serviceName - The service name.
   * @param {string} [params.description] - The description of the role.
   * @param {string} [params.acceptLanguage] - Translation language code.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamPolicyManagementV1.Response<IamPolicyManagementV1.CustomRole>>}
   */
  public createRole(params: IamPolicyManagementV1.CreateRoleParams): Promise<IamPolicyManagementV1.Response<IamPolicyManagementV1.CustomRole>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['displayName', 'actions', 'name', 'accountId', 'serviceName'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'display_name': _params.displayName,
      'actions': _params.actions,
      'name': _params.name,
      'account_id': _params.accountId,
      'service_name': _params.serviceName,
      'description': _params.description
    };

    const sdkHeaders = getSdkHeaders(IamPolicyManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'createRole');

    const parameters = {
      options: {
        url: '/v2/roles',
        method: 'POST',
        body,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
          'Accept-Language': _params.acceptLanguage
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Update a role.
   *
   * Update a custom role. A role administrator might want to update an existing role by updating the display name,
   * description, or the actions that are mapped to the role. The name, account_id, and service_name can't be changed.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.roleId - The role ID.
   * @param {string} params.ifMatch - The revision number for updating a role and must match the ETag value of the
   * existing role. The Etag can be retrieved using the GET /v2/roles/{role_id} API and looking at the ETag response
   * header.
   * @param {string} [params.displayName] - The display name of the role that is shown in the console.
   * @param {string} [params.description] - The description of the role.
   * @param {string[]} [params.actions] - The actions of the role.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamPolicyManagementV1.Response<IamPolicyManagementV1.CustomRole>>}
   */
  public updateRole(params: IamPolicyManagementV1.UpdateRoleParams): Promise<IamPolicyManagementV1.Response<IamPolicyManagementV1.CustomRole>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['roleId', 'ifMatch'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'display_name': _params.displayName,
      'description': _params.description,
      'actions': _params.actions
    };

    const path = {
      'role_id': _params.roleId
    };

    const sdkHeaders = getSdkHeaders(IamPolicyManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'updateRole');

    const parameters = {
      options: {
        url: '/v2/roles/{role_id}',
        method: 'PUT',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
          'If-Match': _params.ifMatch
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Retrieve a role by ID.
   *
   * Retrieve a role by providing a role ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.roleId - The role ID.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamPolicyManagementV1.Response<IamPolicyManagementV1.CustomRole>>}
   */
  public getRole(params: IamPolicyManagementV1.GetRoleParams): Promise<IamPolicyManagementV1.Response<IamPolicyManagementV1.CustomRole>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['roleId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'role_id': _params.roleId
    };

    const sdkHeaders = getSdkHeaders(IamPolicyManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getRole');

    const parameters = {
      options: {
        url: '/v2/roles/{role_id}',
        method: 'GET',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Delete a role by ID.
   *
   * Delete a role by providing a role ID.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.roleId - The role ID.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IamPolicyManagementV1.Response<IamPolicyManagementV1.Empty>>}
   */
  public deleteRole(params: IamPolicyManagementV1.DeleteRoleParams): Promise<IamPolicyManagementV1.Response<IamPolicyManagementV1.Empty>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['roleId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'role_id': _params.roleId
    };

    const sdkHeaders = getSdkHeaders(IamPolicyManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'deleteRole');

    const parameters = {
      options: {
        url: '/v2/roles/{role_id}',
        method: 'DELETE',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

}

/*************************
 * interfaces
 ************************/

namespace IamPolicyManagementV1 {

  /** An operation response. */
  export interface Response<T = any>  {
    result: T;
    status: number;
    statusText: string;
    headers: IncomingHttpHeaders;
  }

  /** The callback for a service request. */
  export type Callback<T> = (error: any, response?: Response<T>) => void;

  /** The body of a service request that returns no response data. */
  export interface Empty { }

  /** A standard JS object, defined to avoid the limitations of `Object` and `object` */
  export interface JsonObject {
    [key: string]: any;
  }

  /*************************
   * request interfaces
   ************************/

  /** Parameters for the `listPolicies` operation. */
  export interface ListPoliciesParams {
    /** The account GUID in which the policies belong to. */
    accountId: string;
    /** Translation language code. */
    acceptLanguage?: string;
    /** The IAM ID used to identify the subject. */
    iamId?: string;
    /** The access group id. */
    accessGroupId?: string;
    /** The type of policy (access or authorization). */
    type?: string;
    /** The type of service. */
    serviceType?: string;
    /** Sort the results by any of the top level policy fields (id, created_at, created_by_id, last_modified_at,
     *  etc).
     */
    sort?: string;
    /** Include additional data per policy returned [include_last_permit, display]. */
    format?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `createPolicy` operation. */
  export interface CreatePolicyParams {
    /** The policy type; either 'access' or 'authorization'. */
    type: string;
    /** The subjects associated with a policy. */
    subjects: PolicySubject[];
    /** A set of role cloud resource names (CRNs) granted by the policy. */
    roles: PolicyRole[];
    /** The resources associated with a policy. */
    resources: PolicyResource[];
    /** Customer-defined description. */
    description?: string;
    /** Translation language code. */
    acceptLanguage?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `updatePolicy` operation. */
  export interface UpdatePolicyParams {
    /** The policy ID. */
    policyId: string;
    /** The revision number for updating a policy and must match the ETag value of the existing policy. The Etag can
     *  be retrieved using the GET /v1/policies/{policy_id} API and looking at the ETag response header.
     */
    ifMatch: string;
    /** The policy type; either 'access' or 'authorization'. */
    type: string;
    /** The subjects associated with a policy. */
    subjects: PolicySubject[];
    /** A set of role cloud resource names (CRNs) granted by the policy. */
    roles: PolicyRole[];
    /** The resources associated with a policy. */
    resources: PolicyResource[];
    /** Customer-defined description. */
    description?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getPolicy` operation. */
  export interface GetPolicyParams {
    /** The policy ID. */
    policyId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deletePolicy` operation. */
  export interface DeletePolicyParams {
    /** The policy ID. */
    policyId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listRoles` operation. */
  export interface ListRolesParams {
    /** Translation language code. */
    acceptLanguage?: string;
    /** The account GUID in which the roles belong to. */
    accountId?: string;
    /** The name of service. */
    serviceName?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `createRole` operation. */
  export interface CreateRoleParams {
    /** The display name of the role that is shown in the console. */
    displayName: string;
    /** The actions of the role. */
    actions: string[];
    /** The name of the role that is used in the CRN. Can only be alphanumeric and has to be capitalized. */
    name: string;
    /** The account GUID. */
    accountId: string;
    /** The service name. */
    serviceName: string;
    /** The description of the role. */
    description?: string;
    /** Translation language code. */
    acceptLanguage?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `updateRole` operation. */
  export interface UpdateRoleParams {
    /** The role ID. */
    roleId: string;
    /** The revision number for updating a role and must match the ETag value of the existing role. The Etag can be
     *  retrieved using the GET /v2/roles/{role_id} API and looking at the ETag response header.
     */
    ifMatch: string;
    /** The display name of the role that is shown in the console. */
    displayName?: string;
    /** The description of the role. */
    description?: string;
    /** The actions of the role. */
    actions?: string[];
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getRole` operation. */
  export interface GetRoleParams {
    /** The role ID. */
    roleId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deleteRole` operation. */
  export interface DeleteRoleParams {
    /** The role ID. */
    roleId: string;
    headers?: OutgoingHttpHeaders;
  }

  /*************************
   * model interfaces
   ************************/

  /** An additional set of properties associated with a role. */
  export interface CustomRole {
    /** The role ID. */
    id?: string;
    /** The display name of the role that is shown in the console. */
    display_name?: string;
    /** The description of the role. */
    description?: string;
    /** The actions of the role. */
    actions?: string[];
    /** The role CRN. */
    crn?: string;
    /** The name of the role that is used in the CRN. Can only be alphanumeric and has to be capitalized. */
    name?: string;
    /** The account GUID. */
    account_id?: string;
    /** The service name. */
    service_name?: string;
    /** The UTC timestamp when the role was created. */
    created_at?: string;
    /** The iam ID of the entity that created the role. */
    created_by_id?: string;
    /** The UTC timestamp when the role was last modified. */
    last_modified_at?: string;
    /** The iam ID of the entity that last modified the policy. */
    last_modified_by_id?: string;
    /** The href link back to the role. */
    href?: string;
  }

  /** The core set of properties associated with a policy. */
  export interface Policy {
    /** The policy ID. */
    id?: string;
    /** The policy type; either 'access' or 'authorization'. */
    type?: string;
    /** Customer-defined description. */
    description?: string;
    /** The subjects associated with a policy. */
    subjects?: PolicySubject[];
    /** A set of role cloud resource names (CRNs) granted by the policy. */
    roles?: PolicyRole[];
    /** The resources associated with a policy. */
    resources?: PolicyResource[];
    /** The href link back to the policy. */
    href?: string;
    /** The UTC timestamp when the policy was created. */
    created_at?: string;
    /** The iam ID of the entity that created the policy. */
    created_by_id?: string;
    /** The UTC timestamp when the policy was last modified. */
    last_modified_at?: string;
    /** The iam ID of the entity that last modified the policy. */
    last_modified_by_id?: string;
  }

  /** A collection of policies. */
  export interface PolicyList {
    /** List of policies. */
    policies?: Policy[];
  }

  /** The attributes of the resource. Note that only one resource is allowed in a policy. */
  export interface PolicyResource {
    /** List of resource attributes. */
    attributes?: ResourceAttribute[];
  }

  /** A role associated with a policy. */
  export interface PolicyRole {
    /** The role cloud resource name granted by the policy. */
    role_id: string;
    /** The display name of the role. */
    display_name?: string;
    /** The description of the role. */
    description?: string;
  }

  /** The subject attribute values that must match in order for this policy to apply in a permission decision. */
  export interface PolicySubject {
    /** List of subject attributes. */
    attributes?: SubjectAttribute[];
  }

  /** An attribute associated with a resource. */
  export interface ResourceAttribute {
    /** The name of an attribute. */
    name: string;
    /** The value of an attribute. */
    value: string;
    /** The operator of an attribute. */
    operator?: string;
  }

  /** A role resource. */
  export interface Role {
    /** The display name of the role that is shown in the console. */
    display_name?: string;
    /** The description of the role. */
    description?: string;
    /** The actions of the role. */
    actions?: string[];
    /** The role CRN. */
    crn?: string;
  }

  /** A collection of roles returned by the 'list roles' operation. */
  export interface RoleList {
    /** List of custom roles. */
    custom_roles?: CustomRole[];
    /** List of service roles. */
    service_roles?: Role[];
    /** List of system roles. */
    system_roles?: Role[];
  }

  /** An attribute associated with a subject. */
  export interface SubjectAttribute {
    /** The name of an attribute. */
    name: string;
    /** The value of an attribute. */
    value: string;
  }

}

export = IamPolicyManagementV1;
