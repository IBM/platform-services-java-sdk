/*
 * (C) Copyright IBM Corp. 2023.
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
 * IBM OpenAPI SDK Code Generator Version: 3.64.0-959a5845-20230112-195144
 */

package com.ibm.cloud.platform_services.iam_policy_management.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.CreatePolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.CreateRoleOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.CreateV2PolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.CustomRole;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.DeletePolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.DeleteRoleOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.DeleteV2PolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.GetPolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.GetRoleOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.GetV2PolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ListPoliciesOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ListRolesOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ListV2PoliciesOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.Policy;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyList;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ReplacePolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ReplaceRoleOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ReplaceV2PolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.RoleList;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.UpdatePolicyStateOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2Policy;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyCollection;
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
 * API Version: 1.0.1
 */
public class IamPolicyManagement extends BaseService {

  /**
   * Default service name used when configuring the `IamPolicyManagement` client.
   */
  public static final String DEFAULT_SERVICE_NAME = "iam_policy_management";

  /**
   * Default service endpoint URL.
   */
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
   * and filter by attribute values. This can be done through query parameters. Currently, only the following attributes
   * are supported: account_id, iam_id, access_group_id, type, service_type, sort, format and state. account_id is a
   * required query parameter. Only policies that have the specified attributes and that the caller has read access to
   * are returned. If the caller does not have read access to any policies an empty array is returned. If a policy was
   * created using the new beta v2/policies API, then the caller will see placeholder information, e.g., "unsupported
   * version" for iam_id, and a valid v2/policies href. The caller should use this href to view the policy.
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
    if (listPoliciesOptions.tagName() != null) {
      builder.query("tag_name", String.valueOf(listPoliciesOptions.tagName()));
    }
    if (listPoliciesOptions.tagValue() != null) {
      builder.query("tag_value", String.valueOf(listPoliciesOptions.tagValue()));
    }
    if (listPoliciesOptions.sort() != null) {
      builder.query("sort", String.valueOf(listPoliciesOptions.sort()));
    }
    if (listPoliciesOptions.format() != null) {
      builder.query("format", String.valueOf(listPoliciesOptions.format()));
    }
    if (listPoliciesOptions.state() != null) {
      builder.query("state", String.valueOf(listPoliciesOptions.state()));
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
   *
   * ### Access
   *
   * To create an access policy, use **`"type": "access"`** in the body. The possible subject attributes are
   * **`iam_id`** and **`access_group_id`**. Use the **`iam_id`** subject attribute for assigning access for a user or
   * service-id. Use the **`access_group_id`** subject attribute for assigning access for an access group. The roles
   * must be a subset of a service's or the platform's supported roles. The resource attributes must be a subset of a
   * service's or the platform's supported attributes. The policy resource must include either the **`serviceType`**,
   * **`serviceName`**, **`resourceGroupId`** or **`service_group_id`** attribute and the **`accountId`** attribute.`
   * The IAM Services group (`IAM`) is a subset of account management services that includes the IAM platform services
   * IAM Identity, IAM Access Management, IAM Users Management, IAM Groups, and future IAM services. If the subject is a
   * locked service-id, the request will fail.
   *
   * ### Authorization
   *
   * Authorization policies are supported by services on a case by case basis. Refer to service documentation to verify
   * their support of authorization policies. To create an authorization policy, use **`"type": "authorization"`** in
   * the body. The subject attributes must match the supported authorization subjects of the resource. Multiple subject
   * attributes might be provided. The following attributes are supported:
   *   serviceName, serviceInstance, region, resourceType, resource, accountId The policy roles must be a subset of the
   * supported authorization roles supported by the target service. The user must also have the same level of access or
   * greater to the target resource in order to grant the role. The resource attributes must be a subset of a service's
   * or the platform's supported attributes. Both the policy subject and the policy resource must include the
   * **`serviceName`** and **`accountId`** attributes.
   *
   * ### Attribute Operators
   *
   * Currently, only the `stringEquals` and the `stringMatch` operators are available. Resource attributes may support
   * one or both operators. For more information, see [how to assign access by using wildcards
   * policies](https://cloud.ibm.com/docs/account?topic=account-wildcard).
   *
   * ### Attribute Validations
   *
   * Policy attribute values must be between 1 and 1,000 characters in length. If location related attributes like
   * geography, country, metro, region, satellite, and locationvalues are supported by the service, they are validated
   * against Global Catalog locations.
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
   *
   * ### Access
   *
   * To update an access policy, use **`"type": "access"`** in the body. The possible subject attributes are
   * **`iam_id`** and **`access_group_id`**. Use the **`iam_id`** subject attribute for assigning access for a user or
   * service-id. Use the **`access_group_id`** subject attribute for assigning access for an access group. The roles
   * must be a subset of a service's or the platform's supported roles. The resource attributes must be a subset of a
   * service's or the platform's supported attributes. The policy resource must include either the **`serviceType`**,
   * **`serviceName`**,  or **`resourceGroupId`** attribute and the **`accountId`** attribute.` If the subject is a
   * locked service-id, the request will fail.
   *
   * ### Authorization
   *
   * To update an authorization policy, use **`"type": "authorization"`** in the body. The subject attributes must match
   * the supported authorization subjects of the resource. Multiple subject attributes might be provided. The following
   * attributes are supported:
   *   serviceName, serviceInstance, region, resourceType, resource, accountId The policy roles must be a subset of the
   * supported authorization roles supported by the target service. The user must also have the same level of access or
   * greater to the target resource in order to grant the role. The resource attributes must be a subset of a service's
   * or the platform's supported attributes. Both the policy subject and the policy resource must include the
   * **`serviceName`** and **`accountId`** attributes.
   *
   * ### Attribute Operators
   *
   * Currently, only the `stringEquals` and the `stringMatch` operators are available. Resource attributes might support
   * one or both operators. For more information, see [how to assign access by using wildcards
   * policies](https://cloud.ibm.com/docs/account?topic=account-wildcard).
   *
   * ### Attribute Validations
   *
   * Policy attribute values must be between 1 and 1,000 characters in length. If location related attributes like
   * geography, country, metro, region, satellite, and locationvalues are supported by the service, they are validated
   * against Global Catalog locations.
   *
   * @param replacePolicyOptions the {@link ReplacePolicyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Policy}
   */
  public ServiceCall<Policy> replacePolicy(ReplacePolicyOptions replacePolicyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replacePolicyOptions,
      "replacePolicyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("policy_id", replacePolicyOptions.policyId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/policies/{policy_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "replacePolicy");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("If-Match", replacePolicyOptions.ifMatch());
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("type", replacePolicyOptions.type());
    contentJson.add("subjects", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replacePolicyOptions.subjects()));
    contentJson.add("roles", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replacePolicyOptions.roles()));
    contentJson.add("resources", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replacePolicyOptions.resources()));
    if (replacePolicyOptions.description() != null) {
      contentJson.addProperty("description", replacePolicyOptions.description());
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
   * Restore a deleted policy by ID.
   *
   * Restore a policy that has recently been deleted. A policy administrator might want to restore a deleted policy. To
   * restore a policy, use **`"state": "active"`** in the body.
   *
   * @param updatePolicyStateOptions the {@link UpdatePolicyStateOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Policy}
   */
  public ServiceCall<Policy> updatePolicyState(UpdatePolicyStateOptions updatePolicyStateOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updatePolicyStateOptions,
      "updatePolicyStateOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("policy_id", updatePolicyStateOptions.policyId());
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/policies/{policy_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "updatePolicyState");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("If-Match", updatePolicyStateOptions.ifMatch());
    final JsonObject contentJson = new JsonObject();
    if (updatePolicyStateOptions.state() != null) {
      contentJson.addProperty("state", updatePolicyStateOptions.state());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Policy> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Policy>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get roles by filters.
   *
   * Get roles based on the filters. While managing roles, you may want to retrieve roles and filter by usages. This can
   * be done through query parameters. Currently, we only support the following attributes: account_id, service_name,
   * source_service_name and policy_type. Only roles that match the filter and that the caller has read access to are
   * returned. If the caller does not have read access to any roles an empty array is returned.
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
    if (listRolesOptions.sourceServiceName() != null) {
      builder.query("source_service_name", String.valueOf(listRolesOptions.sourceServiceName()));
    }
    if (listRolesOptions.policyType() != null) {
      builder.query("policy_type", String.valueOf(listRolesOptions.policyType()));
    }
    ResponseConverter<RoleList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<RoleList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get roles by filters.
   *
   * Get roles based on the filters. While managing roles, you may want to retrieve roles and filter by usages. This can
   * be done through query parameters. Currently, we only support the following attributes: account_id, service_name,
   * source_service_name and policy_type. Only roles that match the filter and that the caller has read access to are
   * returned. If the caller does not have read access to any roles an empty array is returned.
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
   * @param replaceRoleOptions the {@link ReplaceRoleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CustomRole}
   */
  public ServiceCall<CustomRole> replaceRole(ReplaceRoleOptions replaceRoleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceRoleOptions,
      "replaceRoleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("role_id", replaceRoleOptions.roleId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/roles/{role_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "replaceRole");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("If-Match", replaceRoleOptions.ifMatch());
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("display_name", replaceRoleOptions.displayName());
    contentJson.add("actions", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceRoleOptions.actions()));
    if (replaceRoleOptions.description() != null) {
      contentJson.addProperty("description", replaceRoleOptions.description());
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

  /**
   * Get policies by attributes.
   *
   * Get policies and filter by attributes. While managing policies, you may want to retrieve policies in the account
   * and filter by attribute values. This can be done through query parameters. Currently, only the following attributes
   * are supported: account_id, iam_id, access_group_id, type, service_type, sort, format and state. account_id is a
   * required query parameter. Only policies that have the specified attributes and that the caller has read access to
   * are returned. If the caller does not have read access to any policies an empty array is returned.
   *
   * @param listV2PoliciesOptions the {@link ListV2PoliciesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link V2PolicyCollection}
   */
  public ServiceCall<V2PolicyCollection> listV2Policies(ListV2PoliciesOptions listV2PoliciesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listV2PoliciesOptions,
      "listV2PoliciesOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/policies"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "listV2Policies");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listV2PoliciesOptions.acceptLanguage() != null) {
      builder.header("Accept-Language", listV2PoliciesOptions.acceptLanguage());
    }
    builder.query("account_id", String.valueOf(listV2PoliciesOptions.accountId()));
    if (listV2PoliciesOptions.iamId() != null) {
      builder.query("iam_id", String.valueOf(listV2PoliciesOptions.iamId()));
    }
    if (listV2PoliciesOptions.accessGroupId() != null) {
      builder.query("access_group_id", String.valueOf(listV2PoliciesOptions.accessGroupId()));
    }
    if (listV2PoliciesOptions.type() != null) {
      builder.query("type", String.valueOf(listV2PoliciesOptions.type()));
    }
    if (listV2PoliciesOptions.serviceType() != null) {
      builder.query("service_type", String.valueOf(listV2PoliciesOptions.serviceType()));
    }
    if (listV2PoliciesOptions.serviceName() != null) {
      builder.query("service_name", String.valueOf(listV2PoliciesOptions.serviceName()));
    }
    if (listV2PoliciesOptions.serviceGroupId() != null) {
      builder.query("service_group_id", String.valueOf(listV2PoliciesOptions.serviceGroupId()));
    }
    if (listV2PoliciesOptions.format() != null) {
      builder.query("format", String.valueOf(listV2PoliciesOptions.format()));
    }
    if (listV2PoliciesOptions.state() != null) {
      builder.query("state", String.valueOf(listV2PoliciesOptions.state()));
    }
    ResponseConverter<V2PolicyCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<V2PolicyCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a policy.
   *
   * Creates a policy to grant access between a subject and a resource. Currently, there is one type of a v2/policy:
   * **access**. A policy administrator might want to create an access policy which grants access to a user, service-id,
   * or an access group.
   *
   * ### Access
   *
   * To create an access policy, use **`"type": "access"`** in the body. The possible subject attributes are
   * **`iam_id`** and **`access_group_id`**. Use the **`iam_id`** subject attribute for assigning access for a user or
   * service-id. Use the **`access_group_id`** subject attribute for assigning access for an access group. The roles
   * must be a subset of a service's or the platform's supported roles. For more information, see [IAM roles and
   * actions](https://cloud.ibm.com/docs/account?topic=account-iam-service-roles-actions). The resource attributes must
   * be a subset of a service's or the platform's supported attributes. Caller should check with service, e.g.,
   * [VPC](https://cloud.ibm.com/docs/vpc?topic=vpc-resource-attributes), to view supported attributes. The policy
   * resource must include either the **`serviceType`**, **`serviceName`**, **`resourceGroupId`** or
   * **`service_group_id`** attribute and the **`accountId`** attribute.` The rule field can either specify single
   * **`key`**, **`value`**, and **`operator`** or be set of **`conditions`** with a combination **`operator`**.  The
   * possible combination operator are **`and`** and **`or`**. The operator for a rule can be used to specify a
   * time-based condition (e.g., access only during business hours, during the Monday-Friday work week). For example, a
   * policy can grant access Monday-Friday, 9:00am-5:00pm using the following rule:
   * ```json
   *   "rule": {
   *     "operator": "and",
   *     "conditions": [{
   *       "key": "{{environment.attributes.day_of_week}}",
   *       "operator": "dayOfWeekAnyOf",
   *       "value": ["1+00:00", "2+00:00", "3+00:00", "4+00:00", "5+00:00"]
   *     },
   *       "key": "{{environment.attributes.current_time}}",
   *       "operator": "timeGreaterThanOrEquals",
   *       "value": "09:00:00+00:00"
   *     },
   *       "key": "{{environment.attributes.current_time}}",
   *       "operator": "timeLessThanOrEquals",
   *       "value": "17:00:00+00:00"
   *     }]
   *   }
   * ``` Rules and conditions allow the following operators with **`key`**, **`value`** :
   * ```
   *   'timeLessThan', 'timeLessThanOrEquals', 'timeGreaterThan', 'timeGreaterThanOrEquals',
   *   'dateTimeLessThan', 'dateTimeLessThanOrEquals', 'dateTimeGreaterThan', 'dateTimeGreaterThanOrEquals',
   *   'dayOfWeekEquals', 'dayOfWeekAnyOf',
   * ```
   *
   * The pattern field that matches the rule is required when rule is provided. For the business hour rule example
   * above, the **`pattern`** is **`"time-based-conditions:weekly"`**. For more information, see [Time-based conditions
   * operators](https://cloud.ibm.com/docs/account?topic=account-iam-condition-properties&amp;interface=ui#policy-condition-properties)
   * and
   * [Limiting access with time-based
   * conditions](https://cloud.ibm.com/docs/account?topic=account-iam-time-based&amp;interface=ui). The IAM Services
   * group (`IAM`) is a subset of account management services that includes the IAM platform services IAM Identity, IAM
   * Access Management, IAM Users Management, IAM Groups, and future IAM services. If the subject is a locked
   * service-id, the request will fail.
   *
   * ### Attribute Operators
   *
   * Currently, only the `stringEquals`, `stringMatch`, and `stringEquals` operators are available. For more
   * information, see [how to assign access by using wildcards
   * policies](https://cloud.ibm.com/docs/account?topic=account-wildcard).
   *
   * ### Attribute Validations
   *
   * Policy attribute values must be between 1 and 1,000 characters in length. If location related attributes like
   * geography, country, metro, region, satellite, and locationvalues are supported by the service, they are validated
   * against Global Catalog locations.
   *
   * @param createV2PolicyOptions the {@link CreateV2PolicyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link V2Policy}
   */
  public ServiceCall<V2Policy> createV2Policy(CreateV2PolicyOptions createV2PolicyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createV2PolicyOptions,
      "createV2PolicyOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/policies"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "createV2Policy");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createV2PolicyOptions.acceptLanguage() != null) {
      builder.header("Accept-Language", createV2PolicyOptions.acceptLanguage());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.add("control", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createV2PolicyOptions.control()));
    contentJson.addProperty("type", createV2PolicyOptions.type());
    if (createV2PolicyOptions.description() != null) {
      contentJson.addProperty("description", createV2PolicyOptions.description());
    }
    if (createV2PolicyOptions.subject() != null) {
      contentJson.add("subject", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createV2PolicyOptions.subject()));
    }
    if (createV2PolicyOptions.resource() != null) {
      contentJson.add("resource", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createV2PolicyOptions.resource()));
    }
    if (createV2PolicyOptions.pattern() != null) {
      contentJson.addProperty("pattern", createV2PolicyOptions.pattern());
    }
    if (createV2PolicyOptions.rule() != null) {
      contentJson.add("rule", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createV2PolicyOptions.rule()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<V2Policy> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<V2Policy>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a policy.
   *
   * Update a policy to grant access between a subject and a resource. A policy administrator might want to update an
   * existing policy.
   *
   * ### Access
   *
   * To update an access policy, use **`"type": "access"`** in the body. The possible subject attributes are
   * **`iam_id`** and **`access_group_id`**. Use the **`iam_id`** subject attribute for assigning access for a user or
   * service-id. Use the **`access_group_id`** subject attribute for assigning access for an access group. The roles
   * must be a subset of a service's or the platform's supported roles. For more information, see [IAM roles and
   * actions](https://cloud.ibm.com/docs/account?topic=account-iam-service-roles-actions). The resource attributes must
   * be a subset of a service's or the platform's supported attributes. Caller should check with service, e.g.,
   * [VPC](https://cloud.ibm.com/docs/vpc?topic=vpc-resource-attributes), to view supported attributes. The policy
   * resource must include either the **`serviceType`**, **`serviceName`**,  or **`resourceGroupId`** attribute and the
   * **`accountId`** attribute.` The rule field can either specify single **`key`**, **`value`**, and **`operator`** or
   * be set of **`conditions`** with a combination **`operator`**.  The possible combination operator are **`and`** and
   * **`or`**. The operator for a rule can be used to specify a time-based condition (e.g., access only during business
   * hours, during the Monday-Friday work week). For example, a policy can grant access Monday-Friday, 9:00am-5:00pm
   * using the following rule:
   * ```json
   *   "rule": {
   *     "operator": "and",
   *     "conditions": [{
   *       "key": "{{environment.attributes.day_of_week}}",
   *       "operator": "dayOfWeekAnyOf",
   *       "value": ["1+00:00", "2+00:00", "3+00:00", "4+00:00", "5+00:00"]
   *     },
   *       "key": "{{environment.attributes.current_time}}",
   *       "operator": "timeGreaterThanOrEquals",
   *       "value": "09:00:00+00:00"
   *     },
   *       "key": "{{environment.attributes.current_time}}",
   *       "operator": "timeLessThanOrEquals",
   *       "value": "17:00:00+00:00"
   *     }]
   *   }
   * ``` Rules and conditions allow the following operators with **`key`**, **`value`** :
   * ```
   *   'timeLessThan', 'timeLessThanOrEquals', 'timeGreaterThan', 'timeGreaterThanOrEquals',
   *   'dateTimeLessThan', 'dateTimeLessThanOrEquals', 'dateTimeGreaterThan', 'dateTimeGreaterThanOrEquals',
   *   'dayOfWeekEquals', 'dayOfWeekAnyOf',
   * ``` The pattern field that matches the rule is required when rule is provided. For the business hour rule example
   * above, the **`pattern`** is **`"time-based-conditions:weekly"`**. For more information, see [Time-based conditions
   * operators](https://cloud.ibm.com/docs/account?topic=account-iam-condition-properties&amp;interface=ui#policy-condition-properties)
   * and
   * [Limiting access with time-based
   * conditions](https://cloud.ibm.com/docs/account?topic=account-iam-time-based&amp;interface=ui).
   *
   * ### Attribute Operators
   *
   * Currently, only the `stringEquals`, `stringMatch`, and `stringEquals` operators are available. For more
   * information, see [how to assign access by using wildcards
   * policies](https://cloud.ibm.com/docs/account?topic=account-wildcard).
   *
   * ### Attribute Validations
   *
   * Policy attribute values must be between 1 and 1,000 characters in length. If location related attributes like
   * geography, country, metro, region, satellite, and locationvalues are supported by the service, they are validated
   * against Global Catalog locations.
   *
   * @param replaceV2PolicyOptions the {@link ReplaceV2PolicyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link V2Policy}
   */
  public ServiceCall<V2Policy> replaceV2Policy(ReplaceV2PolicyOptions replaceV2PolicyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceV2PolicyOptions,
      "replaceV2PolicyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", replaceV2PolicyOptions.id());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/policies/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "replaceV2Policy");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("If-Match", replaceV2PolicyOptions.ifMatch());
    final JsonObject contentJson = new JsonObject();
    contentJson.add("control", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceV2PolicyOptions.control()));
    contentJson.addProperty("type", replaceV2PolicyOptions.type());
    if (replaceV2PolicyOptions.description() != null) {
      contentJson.addProperty("description", replaceV2PolicyOptions.description());
    }
    if (replaceV2PolicyOptions.subject() != null) {
      contentJson.add("subject", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceV2PolicyOptions.subject()));
    }
    if (replaceV2PolicyOptions.resource() != null) {
      contentJson.add("resource", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceV2PolicyOptions.resource()));
    }
    if (replaceV2PolicyOptions.pattern() != null) {
      contentJson.addProperty("pattern", replaceV2PolicyOptions.pattern());
    }
    if (replaceV2PolicyOptions.rule() != null) {
      contentJson.add("rule", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceV2PolicyOptions.rule()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<V2Policy> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<V2Policy>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve a policy by ID.
   *
   * Retrieve a policy by providing a policy ID.
   *
   * @param getV2PolicyOptions the {@link GetV2PolicyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link V2Policy}
   */
  public ServiceCall<V2Policy> getV2Policy(GetV2PolicyOptions getV2PolicyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getV2PolicyOptions,
      "getV2PolicyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", getV2PolicyOptions.id());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/policies/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "getV2Policy");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<V2Policy> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<V2Policy>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a policy by ID.
   *
   * Delete a policy by providing a policy ID. A policy cannot be deleted if the subject ID contains a locked service
   * ID. If the subject of the policy is a locked service-id, the request will fail.
   *
   * @param deleteV2PolicyOptions the {@link DeleteV2PolicyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteV2Policy(DeleteV2PolicyOptions deleteV2PolicyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteV2PolicyOptions,
      "deleteV2PolicyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", deleteV2PolicyOptions.id());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/policies/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "deleteV2Policy");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

}
