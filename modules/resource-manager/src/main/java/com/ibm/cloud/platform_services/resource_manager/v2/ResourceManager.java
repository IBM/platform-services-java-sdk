/*
 * (C) Copyright IBM Corp. 2021.
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
 * IBM OpenAPI SDK Code Generator Version: 3.41.0-f1ef0102-20211018-193503
 */

package com.ibm.cloud.platform_services.resource_manager.v2;

import com.google.gson.JsonObject;
import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.platform_services.resource_manager.v2.model.CreateResourceGroupOptions;
import com.ibm.cloud.platform_services.resource_manager.v2.model.DeleteResourceGroupOptions;
import com.ibm.cloud.platform_services.resource_manager.v2.model.GetQuotaDefinitionOptions;
import com.ibm.cloud.platform_services.resource_manager.v2.model.GetResourceGroupOptions;
import com.ibm.cloud.platform_services.resource_manager.v2.model.ListQuotaDefinitionsOptions;
import com.ibm.cloud.platform_services.resource_manager.v2.model.ListResourceGroupsOptions;
import com.ibm.cloud.platform_services.resource_manager.v2.model.QuotaDefinition;
import com.ibm.cloud.platform_services.resource_manager.v2.model.QuotaDefinitionList;
import com.ibm.cloud.platform_services.resource_manager.v2.model.ResCreateResourceGroup;
import com.ibm.cloud.platform_services.resource_manager.v2.model.ResourceGroup;
import com.ibm.cloud.platform_services.resource_manager.v2.model.ResourceGroupList;
import com.ibm.cloud.platform_services.resource_manager.v2.model.UpdateResourceGroupOptions;
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
 * Manage lifecycle of your Cloud resource groups using Resource Manager APIs.
 *
 * API Version: 2.0
 */
public class ResourceManager extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "resource_manager";

  public static final String DEFAULT_SERVICE_URL = "https://resource-controller.cloud.ibm.com";

 /**
   * Class method which constructs an instance of the `ResourceManager` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `ResourceManager` client using external configuration
   */
  public static ResourceManager newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `ResourceManager` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `ResourceManager` client using external configuration
   */
  public static ResourceManager newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    ResourceManager service = new ResourceManager(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `ResourceManager` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public ResourceManager(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * Get a list of all resource groups.
   *
   * Call this method to retrieve information about all resource groups and associated quotas in an account. The `id`
   * returned in the response can be used to [create a resource instance
   * later](https://cloud.ibm.com/apidocs/resource-controller/resource-controller?code=java#create-resource-instance).
   * The response can be filtered based on queryParams such as `account_id`, `name`, `default`, and more to narrow your
   * search.Users need to be assigned IAM policies with the Viewer role or higher on the targeted resource groups.
   *
   * @param listResourceGroupsOptions the {@link ListResourceGroupsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceGroupList}
   */
  public ServiceCall<ResourceGroupList> listResourceGroups(ListResourceGroupsOptions listResourceGroupsOptions) {
    if (listResourceGroupsOptions == null) {
      listResourceGroupsOptions = new ListResourceGroupsOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_groups"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_manager", "v2", "listResourceGroups");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listResourceGroupsOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(listResourceGroupsOptions.accountId()));
    }
    if (listResourceGroupsOptions.date() != null) {
      builder.query("date", String.valueOf(listResourceGroupsOptions.date()));
    }
    if (listResourceGroupsOptions.name() != null) {
      builder.query("name", String.valueOf(listResourceGroupsOptions.name()));
    }
    if (listResourceGroupsOptions.xDefault() != null) {
      builder.query("default", String.valueOf(listResourceGroupsOptions.xDefault()));
    }
    if (listResourceGroupsOptions.includeDeleted() != null) {
      builder.query("include_deleted", String.valueOf(listResourceGroupsOptions.includeDeleted()));
    }
    ResponseConverter<ResourceGroupList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceGroupList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a list of all resource groups.
   *
   * Call this method to retrieve information about all resource groups and associated quotas in an account. The `id`
   * returned in the response can be used to [create a resource instance
   * later](https://cloud.ibm.com/apidocs/resource-controller/resource-controller?code=java#create-resource-instance).
   * The response can be filtered based on queryParams such as `account_id`, `name`, `default`, and more to narrow your
   * search.Users need to be assigned IAM policies with the Viewer role or higher on the targeted resource groups.
   *
   * @return a {@link ServiceCall} with a result of type {@link ResourceGroupList}
   */
  public ServiceCall<ResourceGroupList> listResourceGroups() {
    return listResourceGroups(null);
  }

  /**
   * Create a resource group.
   *
   * Create a resource group in an account to organize your account resources in customizable groupings so that you can
   * quickly assign users access to more than one resource at a time. To learn what makes a good resource group
   * strategy, see [Best practices for organizing
   * resources](https://cloud.ibm.com/docs/account?topic=account-account_setup). A default resource group is created
   * when an account is created. If you have a Lite account or 30-day trial, you cannot create extra resource groups,
   * but you can rename your default resource group. If you have a Pay-As-You-Go or Subscription account, you can create
   * multiple resource groups. You must be assigned an IAM policy with the Administrator role on All Account Management
   * services to create extra resource groups.
   *
   * @param createResourceGroupOptions the {@link CreateResourceGroupOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResCreateResourceGroup}
   */
  public ServiceCall<ResCreateResourceGroup> createResourceGroup(CreateResourceGroupOptions createResourceGroupOptions) {
    boolean skipBody = false;
    if (createResourceGroupOptions == null) {
      createResourceGroupOptions = new CreateResourceGroupOptions.Builder().build();
      skipBody = true;
    }
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_groups"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_manager", "v2", "createResourceGroup");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (!skipBody) {
      final JsonObject contentJson = new JsonObject();
      if (createResourceGroupOptions.name() != null) {
        contentJson.addProperty("name", createResourceGroupOptions.name());
      }
      if (createResourceGroupOptions.accountId() != null) {
        contentJson.addProperty("account_id", createResourceGroupOptions.accountId());
      }
      builder.bodyJson(contentJson);
    }
    ResponseConverter<ResCreateResourceGroup> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResCreateResourceGroup>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a resource group.
   *
   * Create a resource group in an account to organize your account resources in customizable groupings so that you can
   * quickly assign users access to more than one resource at a time. To learn what makes a good resource group
   * strategy, see [Best practices for organizing
   * resources](https://cloud.ibm.com/docs/account?topic=account-account_setup). A default resource group is created
   * when an account is created. If you have a Lite account or 30-day trial, you cannot create extra resource groups,
   * but you can rename your default resource group. If you have a Pay-As-You-Go or Subscription account, you can create
   * multiple resource groups. You must be assigned an IAM policy with the Administrator role on All Account Management
   * services to create extra resource groups.
   *
   * @return a {@link ServiceCall} with a result of type {@link ResCreateResourceGroup}
   */
  public ServiceCall<ResCreateResourceGroup> createResourceGroup() {
    return createResourceGroup(null);
  }

  /**
   * Get a resource group.
   *
   * Retrieve a resource group by alias ID. Call this method to get details about a particular resource group, like the
   * name of the resource group, associated quotas, whether the state is active, the resource group ID and the CRN. The
   * `id` returned in the response can be used to [create a resource instance
   * later](https://cloud.ibm.com/apidocs/resource-controller/resource-controller?code=java#create-resource-instance).
   * Users need to be assigned an IAM policy with the Viewer role or higher on the targeted resource group.
   *
   * @param getResourceGroupOptions the {@link GetResourceGroupOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceGroup}
   */
  public ServiceCall<ResourceGroup> getResourceGroup(GetResourceGroupOptions getResourceGroupOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getResourceGroupOptions,
      "getResourceGroupOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", getResourceGroupOptions.id());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_groups/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_manager", "v2", "getResourceGroup");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ResourceGroup> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceGroup>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a resource group.
   *
   * Update a resource group by the alias ID. Call this method to update information about an existing resource group.
   * You can rename a resource group and activate or suspend a particular resource group. To update a resource group,
   * users need to be assigned with IAM policies with the Editor role or higher.
   *
   * @param updateResourceGroupOptions the {@link UpdateResourceGroupOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceGroup}
   */
  public ServiceCall<ResourceGroup> updateResourceGroup(UpdateResourceGroupOptions updateResourceGroupOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateResourceGroupOptions,
      "updateResourceGroupOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", updateResourceGroupOptions.id());
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_groups/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_manager", "v2", "updateResourceGroup");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (updateResourceGroupOptions.name() != null) {
      contentJson.addProperty("name", updateResourceGroupOptions.name());
    }
    if (updateResourceGroupOptions.state() != null) {
      contentJson.addProperty("state", updateResourceGroupOptions.state());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ResourceGroup> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceGroup>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a resource group.
   *
   * Delete a resource group by the alias ID. You can delete a resource group only if the targeted resource group does
   * not contain any resources or if it is not a default resource group. When a user creates an account, a default
   * resource group is created in the account. If you want to delete a resource group that contains resources, first
   * [delete the resource
   * instances](https://cloud.ibm.com/apidocs/resource-controller/resource-controller?code=java#delete-resource-instance).
   * Then, delete the resource group when all resource instances in the group are deleted. Users need to be assigned an
   * IAM policy with the Editor role or higher on the targeted resource group.
   *
   * @param deleteResourceGroupOptions the {@link DeleteResourceGroupOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteResourceGroup(DeleteResourceGroupOptions deleteResourceGroupOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteResourceGroupOptions,
      "deleteResourceGroupOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", deleteResourceGroupOptions.id());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_groups/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_manager", "v2", "deleteResourceGroup");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List quota definitions.
   *
   * Get a list of all quota definitions. Quotas for a resource group limit the number of apps, instances, and memory
   * allowed for that specific resource group. Each resource group that you have on your account has a specific set of
   * quotas. Standard quotas are for resource groups that are created by users with a Lite account, and Pay-As-You-Go
   * quotas are for resource groups that are created with a Pay-As-You-Go account. This method provides list of all
   * available quota definitions. No specific IAM policy needed.
   *
   * @param listQuotaDefinitionsOptions the {@link ListQuotaDefinitionsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link QuotaDefinitionList}
   */
  public ServiceCall<QuotaDefinitionList> listQuotaDefinitions(ListQuotaDefinitionsOptions listQuotaDefinitionsOptions) {
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/quota_definitions"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_manager", "v2", "listQuotaDefinitions");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<QuotaDefinitionList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<QuotaDefinitionList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List quota definitions.
   *
   * Get a list of all quota definitions. Quotas for a resource group limit the number of apps, instances, and memory
   * allowed for that specific resource group. Each resource group that you have on your account has a specific set of
   * quotas. Standard quotas are for resource groups that are created by users with a Lite account, and Pay-As-You-Go
   * quotas are for resource groups that are created with a Pay-As-You-Go account. This method provides list of all
   * available quota definitions. No specific IAM policy needed.
   *
   * @return a {@link ServiceCall} with a result of type {@link QuotaDefinitionList}
   */
  public ServiceCall<QuotaDefinitionList> listQuotaDefinitions() {
    return listQuotaDefinitions(null);
  }

  /**
   * Get a quota definition.
   *
   * Call this method to retrieve information about a particular quota by passing the quota ID. The response can be used
   * to identify the quota type, Standard or Paid. Information about available resources, such as number of apps, number
   * of service instances, and memory, are returned in the response. Quotas for a resource group limit the number of
   * apps, instances, and memory allowed for that specific resource group. Each resource group that you have on your
   * account has a specific set of quotas. Standard quotas are for resource groups that are created by users with a Lite
   * account, and Pay-As-You-Go quotas are for resource groups that are created with a Pay-As-You-Go account. No
   * specific IAM policy needed.
   *
   * @param getQuotaDefinitionOptions the {@link GetQuotaDefinitionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link QuotaDefinition}
   */
  public ServiceCall<QuotaDefinition> getQuotaDefinition(GetQuotaDefinitionOptions getQuotaDefinitionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getQuotaDefinitionOptions,
      "getQuotaDefinitionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", getQuotaDefinitionOptions.id());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/quota_definitions/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_manager", "v2", "getQuotaDefinition");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<QuotaDefinition> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<QuotaDefinition>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}
