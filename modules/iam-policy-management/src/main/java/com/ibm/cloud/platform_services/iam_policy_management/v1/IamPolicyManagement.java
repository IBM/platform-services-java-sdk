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
 * IBM OpenAPI SDK Code Generator Version: 3.65.0-79fc0b8f-20230209-215651
 */

package com.ibm.cloud.platform_services.iam_policy_management.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.CommitPolicyTemplateOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.CreatePolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.CreatePolicyTemplateOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.CreatePolicyTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.CreateRoleOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.CreateV2PolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.CustomRole;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.DeletePolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.DeletePolicyTemplateOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.DeletePolicyTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.DeleteRoleOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.DeleteV2PolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.GetPolicyAssignmentOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.GetPolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.GetPolicyTemplateOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.GetPolicyTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.GetRoleOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.GetV2PolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ListPoliciesOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ListPolicyAssignmentsOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ListPolicyTemplateVersionsOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ListPolicyTemplatesOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ListRolesOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ListV2PoliciesOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.Policy;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyAssignment;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyCollection;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyTemplate;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyTemplateAssignmentCollection;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyTemplateCollection;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyTemplateVersionsCollection;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ReplacePolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ReplacePolicyTemplateOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ReplaceRoleOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ReplaceV2PolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.RoleCollection;
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
   * Get policies and filter by attributes. While managing policies, you might want to retrieve policies in the account
   * and filter by attribute values. This can be done through query parameters. The following attributes are supported:
   * account_id, iam_id, access_group_id, type, service_type, sort, format and state. account_id is a required query
   * parameter. Only policies that have the specified attributes and that the caller has read access to are returned. If
   * the caller does not have read access to any policies an empty array is returned.
   *
   * @param listPoliciesOptions the {@link ListPoliciesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PolicyCollection}
   */
  public ServiceCall<PolicyCollection> listPolicies(ListPoliciesOptions listPoliciesOptions) {
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
    ResponseConverter<PolicyCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PolicyCollection>() { }.getType());
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
   * service-id. Use the **`access_group_id`** subject attribute for assigning access for an access group. Assign roles
   * that are supported by the service or platform roles. For more information, see [IAM roles and
   * actions](/docs/account?topic=account-iam-service-roles-actions). Use only the resource attributes supported by the
   * service. To view a service's or the platform's supported attributes, check the [documentation](/docs?tab=all-docs).
   * The policy resource must include either the **`serviceType`**, **`serviceName`**, **`resourceGroupId`** or
   * **`service_group_id`** attribute and the **`accountId`** attribute. The IAM Services group (`IAM`) is a subset of
   * account management services that includes the IAM platform services IAM Identity, IAM Access Management, IAM Users
   * Management, IAM Groups, and future IAM services. If the subject is a locked service-id, the request will fail.
   *
   * ### Authorization
   *
   * Authorization policies are supported by services on a case by case basis. Refer to service documentation to verify
   * their support of authorization policies. To create an authorization policy, use **`"type": "authorization"`** in
   * the body. The subject attributes must match the supported authorization subjects of the resource. Multiple subject
   * attributes might be provided. The following attributes are supported:
   *   serviceName, serviceInstance, region, resourceType, resource, accountId Assign roles that are supported by the
   * service or platform roles. For more information, see [IAM roles and
   * actions](/docs/account?topic=account-iam-service-roles-actions). The user must also have the same level of access
   * or greater to the target resource in order to grant the role. Use only the resource attributes supported by the
   * service. To view a service's or the platform's supported attributes, check the [documentation](/docs?tab=all-docs).
   * Both the policy subject and the policy resource must include the **`serviceName`** and **`accountId`** attributes.
   *
   * ### Attribute Operators
   *
   * Currently, only the `stringEquals` and the `stringMatch` operators are available. Resource attributes may support
   * one or both operators. For more information, see [Assigning access by using wildcard
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
   * service-id. Use the **`access_group_id`** subject attribute for assigning access for an access group. Assign roles
   * that are supported by the service or platform roles. For more information, see [IAM roles and
   * actions](/docs/account?topic=account-iam-service-roles-actions). Use only the resource attributes supported by the
   * service. To view a service's or the platform's supported attributes, check the [documentation](/docs?tab=all-docs).
   * The policy resource must include either the **`serviceType`**, **`serviceName`**,  or **`resourceGroupId`**
   * attribute and the **`accountId`** attribute.` If the subject is a locked service-id, the request will fail.
   *
   * ### Authorization
   *
   * To update an authorization policy, use **`"type": "authorization"`** in the body. The subject attributes must match
   * the supported authorization subjects of the resource. Multiple subject attributes might be provided. The following
   * attributes are supported:
   *   serviceName, serviceInstance, region, resourceType, resource, accountId Assign roles that are supported by the
   * service or platform roles. For more information, see [IAM roles and
   * actions](/docs/account?topic=account-iam-service-roles-actions). The user must also have the same level of access
   * or greater to the target resource in order to grant the role. Use only the resource attributes supported by the
   * service. To view a service's or the platform's supported attributes, check the [documentation](/docs?tab=all-docs).
   * Both the policy subject and the policy resource must include the **`serviceName`** and **`accountId`** attributes.
   *
   * ### Attribute Operators
   *
   * Currently, only the `stringEquals` and the `stringMatch` operators are available. Resource attributes might support
   * one or both operators. For more information, see [Assigning access by using wildcard
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
   * service_group_id, source_service_name and policy_type. Both service_name and service_group_id attributes are
   * mutually exclusive. Only roles that match the filter and that the caller has read access to are returned. If the
   * caller does not have read access to any roles an empty array is returned.
   *
   * @param listRolesOptions the {@link ListRolesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link RoleCollection}
   */
  public ServiceCall<RoleCollection> listRoles(ListRolesOptions listRolesOptions) {
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
    if (listRolesOptions.serviceGroupId() != null) {
      builder.query("service_group_id", String.valueOf(listRolesOptions.serviceGroupId()));
    }
    ResponseConverter<RoleCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<RoleCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get roles by filters.
   *
   * Get roles based on the filters. While managing roles, you may want to retrieve roles and filter by usages. This can
   * be done through query parameters. Currently, we only support the following attributes: account_id, service_name,
   * service_group_id, source_service_name and policy_type. Both service_name and service_group_id attributes are
   * mutually exclusive. Only roles that match the filter and that the caller has read access to are returned. If the
   * caller does not have read access to any roles an empty array is returned.
   *
   * @return a {@link ServiceCall} with a result of type {@link RoleCollection}
   */
  public ServiceCall<RoleCollection> listRoles() {
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
   * Get policies and filter by attributes. While managing policies, you might want to retrieve policies in the account
   * and filter by attribute values. This can be done through query parameters. The following attributes are supported:
   * account_id, iam_id, access_group_id, type, service_type, sort, format and state. account_id is a required query
   * parameter. Only policies that have the specified attributes and that the caller has read access to are returned. If
   * the caller does not have read access to any policies an empty array is returned.
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
    if (listV2PoliciesOptions.sort() != null) {
      builder.query("sort", String.valueOf(listV2PoliciesOptions.sort()));
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
   * **access**. A policy administrator might want to create an access policy that grants access to a user, service-id,
   * or an access group.
   *
   * ### Access
   *
   * To create an access policy, use **`"type": "access"`** in the body. The supported subject attributes are
   * **`iam_id`** and **`access_group_id`**. Use the **`iam_id`** subject attribute to assign access to a user or
   * service-id. Use the **`access_group_id`** subject attribute to assign access to an access group. Assign roles that
   * are supported by the service or platform roles. For more information, see [IAM roles and
   * actions](/docs/account?topic=account-iam-service-roles-actions). Use only the resource attributes supported by the
   * service. To view a service's or the platform's supported attributes, check the [documentation](/docs?tab=all-docs).
   * The policy resource must include either the **`serviceType`**, **`serviceName`**, **`resourceGroupId`** or
   * **`service_group_id`** attribute and the **`accountId`** attribute. In the rule field, you can specify a single
   * condition by using **`key`**, **`value`**, and condition **`operator`**, or a set of **`conditions`** with a
   * combination **`operator`**. The possible combination operators are **`and`** and **`or`**. Combine conditions to
   * specify a time-based restriction (e.g., access only during business hours, during the Monday-Friday work week). For
   * example, a policy can grant access Monday-Friday, 9:00am-5:00pm using the following rule:
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
   * ``` You can use the following operators in the **`key`** and **`value`** pair:
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
   * conditions](https://cloud.ibm.com/docs/account?topic=account-iam-time-based&amp;interface=ui). If the subject is a
   * locked service-id, the request will fail.
   *
   * ### Attribute Operators
   *
   * Currently, only the `stringEquals`, `stringMatch`, and `stringEquals` operators are available. For more
   * information, see [Assigning access by using wildcard
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
   * To create an access policy, use **`"type": "access"`** in the body. The supported subject attributes are
   * **`iam_id`** and **`access_group_id`**. Use the **`iam_id`** subject attribute to assign access to a user or
   * service-id. Use the **`access_group_id`** subject attribute to assign access to an access group. Assign roles that
   * are supported by the service or platform roles. For more information, see [IAM roles and
   * actions](/docs/account?topic=account-iam-service-roles-actions). Use only the resource attributes supported by the
   * service. To view a service's or the platform's supported attributes, check the [documentation](/docs?tab=all-docs).
   * The policy resource must include either the **`serviceType`**, **`serviceName`**, **`resourceGroupId`** or
   * **`service_group_id`** attribute and the **`accountId`** attribute. In the rule field, you can specify a single
   * condition by using **`key`**, **`value`**, and condition **`operator`**, or a set of **`conditions`** with a
   * combination **`operator`**. The possible combination operators are **`and`** and **`or`**. Combine conditions to
   * specify a time-based restriction (e.g., access only during business hours, during the Monday-Friday work week). For
   * example, a policy can grant access Monday-Friday, 9:00am-5:00pm using the following rule:
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
   * ``` You can use the following operators in the **`key`**, **`value`** pair:
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
   * ### Attribute Operators
   *
   * Currently, only the `stringEquals`, `stringMatch`, and `stringEquals` operators are available. For more
   * information, see [Assigning access by using wildcard
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
    if (getV2PolicyOptions.format() != null) {
      builder.query("format", String.valueOf(getV2PolicyOptions.format()));
    }
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

  /**
   * List policy templates by attributes.
   *
   * List policy templates and filter by attributes by using query parameters. The following attributes are supported:
   * `account_id`.
   * `account_id` is a required query parameter. Only policy templates that have the specified attributes and that the
   * caller has read access to are returned. If the caller does not have read access to any policy templates an empty
   * array is returned.
   *
   * @param listPolicyTemplatesOptions the {@link ListPolicyTemplatesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PolicyTemplateCollection}
   */
  public ServiceCall<PolicyTemplateCollection> listPolicyTemplates(ListPolicyTemplatesOptions listPolicyTemplatesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listPolicyTemplatesOptions,
      "listPolicyTemplatesOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/policy_templates"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "listPolicyTemplates");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listPolicyTemplatesOptions.acceptLanguage() != null) {
      builder.header("Accept-Language", listPolicyTemplatesOptions.acceptLanguage());
    }
    builder.query("account_id", String.valueOf(listPolicyTemplatesOptions.accountId()));
    ResponseConverter<PolicyTemplateCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PolicyTemplateCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a policy template.
   *
   * Create a policy template. Policy templates define a policy without requiring a subject, and you can use them to
   * grant access to multiple subjects.
   *
   * @param createPolicyTemplateOptions the {@link CreatePolicyTemplateOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PolicyTemplate}
   */
  public ServiceCall<PolicyTemplate> createPolicyTemplate(CreatePolicyTemplateOptions createPolicyTemplateOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createPolicyTemplateOptions,
      "createPolicyTemplateOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/policy_templates"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "createPolicyTemplate");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createPolicyTemplateOptions.acceptLanguage() != null) {
      builder.header("Accept-Language", createPolicyTemplateOptions.acceptLanguage());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", createPolicyTemplateOptions.name());
    contentJson.addProperty("account_id", createPolicyTemplateOptions.accountId());
    contentJson.add("policy", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createPolicyTemplateOptions.policy()));
    if (createPolicyTemplateOptions.description() != null) {
      contentJson.addProperty("description", createPolicyTemplateOptions.description());
    }
    if (createPolicyTemplateOptions.committed() != null) {
      contentJson.addProperty("committed", createPolicyTemplateOptions.committed());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<PolicyTemplate> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PolicyTemplate>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve latest version of a policy template.
   *
   * Retrieve the latest version of a policy template by providing a policy template ID.
   *
   * @param getPolicyTemplateOptions the {@link GetPolicyTemplateOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PolicyTemplate}
   */
  public ServiceCall<PolicyTemplate> getPolicyTemplate(GetPolicyTemplateOptions getPolicyTemplateOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getPolicyTemplateOptions,
      "getPolicyTemplateOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("policy_template_id", getPolicyTemplateOptions.policyTemplateId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/policy_templates/{policy_template_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "getPolicyTemplate");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<PolicyTemplate> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PolicyTemplate>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a policy template.
   *
   * Delete a policy template by providing the policy template ID. This deletes all versions of this template. A policy
   * template can't be deleted if any version of the template is assigned to one or more child accounts. You must remove
   * the policy assignments first.
   *
   * @param deletePolicyTemplateOptions the {@link DeletePolicyTemplateOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deletePolicyTemplate(DeletePolicyTemplateOptions deletePolicyTemplateOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deletePolicyTemplateOptions,
      "deletePolicyTemplateOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("policy_template_id", deletePolicyTemplateOptions.policyTemplateId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/policy_templates/{policy_template_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "deletePolicyTemplate");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a new policy template version.
   *
   * Create a new version of a policy template. Use this if you need to make updates to a policy template that is
   * committed.
   *
   * @param createPolicyTemplateVersionOptions the {@link CreatePolicyTemplateVersionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PolicyTemplate}
   */
  public ServiceCall<PolicyTemplate> createPolicyTemplateVersion(CreatePolicyTemplateVersionOptions createPolicyTemplateVersionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createPolicyTemplateVersionOptions,
      "createPolicyTemplateVersionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("policy_template_id", createPolicyTemplateVersionOptions.policyTemplateId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/policy_templates/{policy_template_id}/versions", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "createPolicyTemplateVersion");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.add("policy", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createPolicyTemplateVersionOptions.policy()));
    if (createPolicyTemplateVersionOptions.description() != null) {
      contentJson.addProperty("description", createPolicyTemplateVersionOptions.description());
    }
    if (createPolicyTemplateVersionOptions.committed() != null) {
      contentJson.addProperty("committed", createPolicyTemplateVersionOptions.committed());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<PolicyTemplate> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PolicyTemplate>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve policy template versions.
   *
   * Retrieve the versions of a policy template by providing a policy template ID.
   *
   * @param listPolicyTemplateVersionsOptions the {@link ListPolicyTemplateVersionsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PolicyTemplateVersionsCollection}
   */
  public ServiceCall<PolicyTemplateVersionsCollection> listPolicyTemplateVersions(ListPolicyTemplateVersionsOptions listPolicyTemplateVersionsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listPolicyTemplateVersionsOptions,
      "listPolicyTemplateVersionsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("policy_template_id", listPolicyTemplateVersionsOptions.policyTemplateId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/policy_templates/{policy_template_id}/versions", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "listPolicyTemplateVersions");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<PolicyTemplateVersionsCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PolicyTemplateVersionsCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a policy template version.
   *
   * Update a specific version of a policy template. You can use this only if the version isn't committed.
   *
   * @param replacePolicyTemplateOptions the {@link ReplacePolicyTemplateOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PolicyTemplate}
   */
  public ServiceCall<PolicyTemplate> replacePolicyTemplate(ReplacePolicyTemplateOptions replacePolicyTemplateOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replacePolicyTemplateOptions,
      "replacePolicyTemplateOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("policy_template_id", replacePolicyTemplateOptions.policyTemplateId());
    pathParamsMap.put("version", replacePolicyTemplateOptions.version());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/policy_templates/{policy_template_id}/versions/{version}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "replacePolicyTemplate");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("If-Match", replacePolicyTemplateOptions.ifMatch());
    final JsonObject contentJson = new JsonObject();
    contentJson.add("policy", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replacePolicyTemplateOptions.policy()));
    if (replacePolicyTemplateOptions.description() != null) {
      contentJson.addProperty("description", replacePolicyTemplateOptions.description());
    }
    if (replacePolicyTemplateOptions.committed() != null) {
      contentJson.addProperty("committed", replacePolicyTemplateOptions.committed());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<PolicyTemplate> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PolicyTemplate>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a policy template version.
   *
   * Delete a specific version of a policy template by providing a policy template ID and version number. You can't
   * delete a policy template version that is assigned to one or more child accounts. You must remove the policy
   * assignments first.
   *
   * @param deletePolicyTemplateVersionOptions the {@link DeletePolicyTemplateVersionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deletePolicyTemplateVersion(DeletePolicyTemplateVersionOptions deletePolicyTemplateVersionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deletePolicyTemplateVersionOptions,
      "deletePolicyTemplateVersionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("policy_template_id", deletePolicyTemplateVersionOptions.policyTemplateId());
    pathParamsMap.put("version", deletePolicyTemplateVersionOptions.version());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/policy_templates/{policy_template_id}/versions/{version}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "deletePolicyTemplateVersion");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve a policy template version.
   *
   * Retrieve a policy template by providing a policy template ID and version number.
   *
   * @param getPolicyTemplateVersionOptions the {@link GetPolicyTemplateVersionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PolicyTemplate}
   */
  public ServiceCall<PolicyTemplate> getPolicyTemplateVersion(GetPolicyTemplateVersionOptions getPolicyTemplateVersionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getPolicyTemplateVersionOptions,
      "getPolicyTemplateVersionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("policy_template_id", getPolicyTemplateVersionOptions.policyTemplateId());
    pathParamsMap.put("version", getPolicyTemplateVersionOptions.version());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/policy_templates/{policy_template_id}/versions/{version}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "getPolicyTemplateVersion");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<PolicyTemplate> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PolicyTemplate>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Commit a policy template version.
   *
   * Commit a policy template version. You can make no further changes to the policy template once it's committed. If
   * you need to make updates after committing a version, create a new version.
   *
   * @param commitPolicyTemplateOptions the {@link CommitPolicyTemplateOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> commitPolicyTemplate(CommitPolicyTemplateOptions commitPolicyTemplateOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(commitPolicyTemplateOptions,
      "commitPolicyTemplateOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("policy_template_id", commitPolicyTemplateOptions.policyTemplateId());
    pathParamsMap.put("version", commitPolicyTemplateOptions.version());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/policy_templates/{policy_template_id}/versions/{version}/commit", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "commitPolicyTemplate");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("If-Match", commitPolicyTemplateOptions.ifMatch());
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get policy template assignments.
   *
   * Get policy template assignments by attributes. The following attributes are supported:
   * `account_id`, `template_id`, `template_version`, `sort`.
   * `account_id` is a required query parameter. Only policy template assignments that have the specified attributes and
   * that the caller has read access to are returned. If the caller does not have read access to any policy template
   * assignments an empty array is returned.
   *
   * @param listPolicyAssignmentsOptions the {@link ListPolicyAssignmentsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PolicyTemplateAssignmentCollection}
   */
  public ServiceCall<PolicyTemplateAssignmentCollection> listPolicyAssignments(ListPolicyAssignmentsOptions listPolicyAssignmentsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listPolicyAssignmentsOptions,
      "listPolicyAssignmentsOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/policy_assignments"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "listPolicyAssignments");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listPolicyAssignmentsOptions.acceptLanguage() != null) {
      builder.header("Accept-Language", listPolicyAssignmentsOptions.acceptLanguage());
    }
    builder.query("account_id", String.valueOf(listPolicyAssignmentsOptions.accountId()));
    if (listPolicyAssignmentsOptions.templateId() != null) {
      builder.query("template_id", String.valueOf(listPolicyAssignmentsOptions.templateId()));
    }
    if (listPolicyAssignmentsOptions.templateVersion() != null) {
      builder.query("template_version", String.valueOf(listPolicyAssignmentsOptions.templateVersion()));
    }
    ResponseConverter<PolicyTemplateAssignmentCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PolicyTemplateAssignmentCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Retrieve a policy assignment.
   *
   * Retrieve a policy template assignment by providing a policy assignment ID.
   *
   * @param getPolicyAssignmentOptions the {@link GetPolicyAssignmentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PolicyAssignment}
   */
  public ServiceCall<PolicyAssignment> getPolicyAssignment(GetPolicyAssignmentOptions getPolicyAssignmentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getPolicyAssignmentOptions,
      "getPolicyAssignmentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("assignment_id", getPolicyAssignmentOptions.assignmentId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/policy_assignments/{assignment_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_policy_management", "v1", "getPolicyAssignment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<PolicyAssignment> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PolicyAssignment>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}
