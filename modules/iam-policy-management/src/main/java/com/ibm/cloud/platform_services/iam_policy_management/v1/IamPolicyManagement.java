/*
 * (C) Copyright IBM Corp. 2020.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

/*
 * IBM OpenAPI SDK Code Generator Version: 99-SNAPSHOT-d753183b-20201209-163011
 */

package com.ibm.cloud.platform_services.iam_policy_management.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.CreatePolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.CreateRoleOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.CustomRole;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.DeletePolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.DeleteRoleOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.GetPolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.GetRoleOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ListPoliciesOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ListRolesOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.Policy;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyList;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.RoleList;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.UpdatePolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.UpdateRoleOptions;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * IAM Policy Management API.
 *
 * @version v1
 */
public class IamPolicyManagement extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "iam_policy_management";

  public static final String DEFAULT_SERVICE_URL = "https://iam.cloud.ibm.com";

 /**
   * Class method which constructs an instance of the `IamPolicyManagement` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `IamPolicyManagement` client using external configuration
   */
  public static IamPolicyManagement newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `IamPolicyManagement` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `IamPolicyManagement` client using external configuration
   */
  public static IamPolicyManagement newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    IamPolicyManagement service = new IamPolicyManagement(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `IamPolicyManagement` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public IamPolicyManagement(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * Get policies by attributes.
   *
   * Get policies and filter by attributes. While managing policies, you may want to retrieve policies in the account
   * and filter by attribute values. This can be done through query parameters. Currently, we only support the following
   * attributes: account_id, iam_id, access_group_id, type, and service_type. account_id is a required query parameter.
   * Only policies that have the specified attributes and that the caller has read access to are returned. If the caller
   * does not have read access to any policies an empty array is returned.
   *
   * @param listPoliciesOptions the {@link ListPoliciesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PolicyList}
   */
  public ServiceCall<PolicyList> listPolicies(ListPoliciesOptions listPoliciesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listPoliciesOptions,
      "listPoliciesOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/policies"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "listPolicies");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listPoliciesOptions.acceptLanguage() != null) {
      builder.header("Accept-Language", listPoliciesOptions.acceptLanguage());
    }
    builder.query("account_id", String.valueOf(listPoliciesOptions.accountId()));
    if (listPoliciesOptions.iamId() != null) {
      builder.query("iam_id", String.valueOf(listPoliciesOptions.iamId()));
    }
    if (listPoliciesOptions.accessGroupId() != null) {
      builder.query("access_group_id", String.valueOf(listPoliciesOptions.accessGroupId()));
    }
    if (listPoliciesOptions.type() != null) {
      builder.query("type", String.valueOf(listPoliciesOptions.type()));
    }
    if (listPoliciesOptions.serviceType() != null) {
      builder.query("service_type", String.valueOf(listPoliciesOptions.serviceType()));
    }
    if (listPoliciesOptions.sort() != null) {
      builder.query("sort", String.valueOf(listPoliciesOptions.sort()));
    }
    if (listPoliciesOptions.format() != null) {
      builder.query("format", String.valueOf(listPoliciesOptions.format()));
    }
    ResponseConverter<PolicyList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PolicyList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

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
   * @param createPolicyOptions the {@link CreatePolicyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Policy}
   */
  public ServiceCall<Policy> createPolicy(CreatePolicyOptions createPolicyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createPolicyOptions,
      "createPolicyOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/policies"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "createPolicy");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createPolicyOptions.acceptLanguage() != null) {
      builder.header("Accept-Language", createPolicyOptions.acceptLanguage());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("type", createPolicyOptions.type());
    contentJson.add("subjects", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createPolicyOptions.subjects()));
    contentJson.add("roles", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createPolicyOptions.roles()));
    contentJson.add("resources", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createPolicyOptions.resources()));
    if (createPolicyOptions.description() != null) {
      contentJson.addProperty("description", createPolicyOptions.description());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Policy> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Policy>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

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
   * @param updatePolicyOptions the {@link UpdatePolicyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Policy}
   */
  public ServiceCall<Policy> updatePolicy(UpdatePolicyOptions updatePolicyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updatePolicyOptions,
      "updatePolicyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("policy_id", updatePolicyOptions.policyId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/policies/{policy_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "updatePolicy");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("If-Match", updatePolicyOptions.ifMatch());
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("type", updatePolicyOptions.type());
    contentJson.add("subjects", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updatePolicyOptions.subjects()));
    contentJson.add("roles", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updatePolicyOptions.roles()));
    contentJson.add("resources", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updatePolicyOptions.resources()));
    if (updatePolicyOptions.description() != null) {
      contentJson.addProperty("description", updatePolicyOptions.description());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Policy> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Policy>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve a policy by ID.
   *
   * Retrieve a policy by providing a policy ID.
   *
   * @param getPolicyOptions the {@link GetPolicyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Policy}
   */
  public ServiceCall<Policy> getPolicy(GetPolicyOptions getPolicyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getPolicyOptions,
      "getPolicyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("policy_id", getPolicyOptions.policyId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/policies/{policy_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "getPolicy");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Policy> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Policy>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a policy by ID.
   *
   * Delete a policy by providing a policy ID. A policy cannot be deleted if the subject ID contains a locked service
   * ID. If the subject of the policy is a locked service-id, the request will fail.
   *
   * @param deletePolicyOptions the {@link DeletePolicyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deletePolicy(DeletePolicyOptions deletePolicyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deletePolicyOptions,
      "deletePolicyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("policy_id", deletePolicyOptions.policyId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/policies/{policy_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "deletePolicy");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get roles by filters.
   *
   * Get roles based on the filters. While managing roles, you may want to retrieve roles and filter by usages. This can
   * be done through query parameters. Currently, we only support the following attributes: account_id, and
   * service_name. Only roles that match the filter and that the caller has read access to are returned. If the caller
   * does not have read access to any roles an empty array is returned.
   *
   * @param listRolesOptions the {@link ListRolesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link RoleList}
   */
  public ServiceCall<RoleList> listRoles(ListRolesOptions listRolesOptions) {
    if (listRolesOptions == null) {
      listRolesOptions = new ListRolesOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/roles"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "listRoles");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listRolesOptions.acceptLanguage() != null) {
      builder.header("Accept-Language", listRolesOptions.acceptLanguage());
    }
    if (listRolesOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(listRolesOptions.accountId()));
    }
    if (listRolesOptions.serviceName() != null) {
      builder.query("service_name", String.valueOf(listRolesOptions.serviceName()));
    }
    ResponseConverter<RoleList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<RoleList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get roles by filters.
   *
   * Get roles based on the filters. While managing roles, you may want to retrieve roles and filter by usages. This can
   * be done through query parameters. Currently, we only support the following attributes: account_id, and
   * service_name. Only roles that match the filter and that the caller has read access to are returned. If the caller
   * does not have read access to any roles an empty array is returned.
   *
   * @return a {@link ServiceCall} with a result of type {@link RoleList}
   */
  public ServiceCall<RoleList> listRoles() {
    return listRoles(null);
  }

  /**
   * Create a role.
   *
   * Creates a custom role for a specific service within the account. An account owner or a user assigned the
   * Administrator role on the Role management service can create a custom role. Any number of actions for a single
   * service can be mapped to the new role, but there must be at least one service-defined action to successfully create
   * the new role.
   *
   * @param createRoleOptions the {@link CreateRoleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CustomRole}
   */
  public ServiceCall<CustomRole> createRole(CreateRoleOptions createRoleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createRoleOptions,
      "createRoleOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/roles"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "createRole");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createRoleOptions.acceptLanguage() != null) {
      builder.header("Accept-Language", createRoleOptions.acceptLanguage());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("display_name", createRoleOptions.displayName());
    contentJson.add("actions", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createRoleOptions.actions()));
    contentJson.addProperty("name", createRoleOptions.name());
    contentJson.addProperty("account_id", createRoleOptions.accountId());
    contentJson.addProperty("service_name", createRoleOptions.serviceName());
    if (createRoleOptions.description() != null) {
      contentJson.addProperty("description", createRoleOptions.description());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<CustomRole> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CustomRole>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a role.
   *
   * Update a custom role. A role administrator might want to update an existing role by updating the display name,
   * description, or the actions that are mapped to the role. The name, account_id, and service_name can't be changed.
   *
   * @param updateRoleOptions the {@link UpdateRoleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CustomRole}
   */
  public ServiceCall<CustomRole> updateRole(UpdateRoleOptions updateRoleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateRoleOptions,
      "updateRoleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("role_id", updateRoleOptions.roleId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/roles/{role_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "updateRole");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("If-Match", updateRoleOptions.ifMatch());
    final JsonObject contentJson = new JsonObject();
    if (updateRoleOptions.displayName() != null) {
      contentJson.addProperty("display_name", updateRoleOptions.displayName());
    }
    if (updateRoleOptions.description() != null) {
      contentJson.addProperty("description", updateRoleOptions.description());
    }
    if (updateRoleOptions.actions() != null) {
      contentJson.add("actions", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateRoleOptions.actions()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<CustomRole> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CustomRole>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve a role by ID.
   *
   * Retrieve a role by providing a role ID.
   *
   * @param getRoleOptions the {@link GetRoleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CustomRole}
   */
  public ServiceCall<CustomRole> getRole(GetRoleOptions getRoleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getRoleOptions,
      "getRoleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("role_id", getRoleOptions.roleId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/roles/{role_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "getRole");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<CustomRole> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CustomRole>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a role by ID.
   *
   * Delete a role by providing a role ID.
   *
   * @param deleteRoleOptions the {@link DeleteRoleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteRole(DeleteRoleOptions deleteRoleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteRoleOptions,
      "deleteRoleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("role_id", deleteRoleOptions.roleId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/roles/{role_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "deleteRole");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

}
