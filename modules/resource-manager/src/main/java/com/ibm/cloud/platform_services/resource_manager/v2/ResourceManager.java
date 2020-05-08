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
import java.util.Map;
import java.util.Map.Entry;

/**
 * Manage lifecycle of your Cloud resource groups using Resource Manager APIs.
 *
 * @version v2
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
   * Get a list of all quota definitions.
   *
   * Get a list of all quota definitions.
   *
   * @param listQuotaDefinitionsOptions the {@link ListQuotaDefinitionsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link QuotaDefinitionList}
   */
  public ServiceCall<QuotaDefinitionList> listQuotaDefinitions(ListQuotaDefinitionsOptions listQuotaDefinitionsOptions) {
    String[] pathSegments = { "quota_definitions" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
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
   * Get a list of all quota definitions.
   *
   * Get a list of all quota definitions.
   *
   * @return a {@link ServiceCall} with a result of type {@link QuotaDefinitionList}
   */
  public ServiceCall<QuotaDefinitionList> listQuotaDefinitions() {
    return listQuotaDefinitions(null);
  }

  /**
   * Get a quota definition.
   *
   * Get a quota definition.
   *
   * @param getQuotaDefinitionOptions the {@link GetQuotaDefinitionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link QuotaDefinition}
   */
  public ServiceCall<QuotaDefinition> getQuotaDefinition(GetQuotaDefinitionOptions getQuotaDefinitionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getQuotaDefinitionOptions,
      "getQuotaDefinitionOptions cannot be null");
    String[] pathSegments = { "quota_definitions" };
    String[] pathParameters = { getQuotaDefinitionOptions.id() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_manager", "v2", "getQuotaDefinition");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<QuotaDefinition> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<QuotaDefinition>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a list of all resource groups.
   *
   * Get a list of all resource groups in an account.
   *
   * @param listResourceGroupsOptions the {@link ListResourceGroupsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceGroupList}
   */
  public ServiceCall<ResourceGroupList> listResourceGroups(ListResourceGroupsOptions listResourceGroupsOptions) {
    String[] pathSegments = { "resource_groups" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_manager", "v2", "listResourceGroups");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listResourceGroupsOptions != null) {
      if (listResourceGroupsOptions.accountId() != null) {
        builder.query("account_id", listResourceGroupsOptions.accountId());
      }
    }
    ResponseConverter<ResourceGroupList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceGroupList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a list of all resource groups.
   *
   * Get a list of all resource groups in an account.
   *
   * @return a {@link ServiceCall} with a result of type {@link ResourceGroupList}
   */
  public ServiceCall<ResourceGroupList> listResourceGroups() {
    return listResourceGroups(null);
  }

  /**
   * Create a new resource group.
   *
   * Create a new resource group in an account.
   *
   * @param createResourceGroupOptions the {@link CreateResourceGroupOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResCreateResourceGroup}
   */
  public ServiceCall<ResCreateResourceGroup> createResourceGroup(CreateResourceGroupOptions createResourceGroupOptions) {
    String[] pathSegments = { "resource_groups" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_manager", "v2", "createResourceGroup");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createResourceGroupOptions != null) {
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
   * Create a new resource group.
   *
   * Create a new resource group in an account.
   *
   * @return a {@link ServiceCall} with a result of type {@link ResCreateResourceGroup}
   */
  public ServiceCall<ResCreateResourceGroup> createResourceGroup() {
    return createResourceGroup(null);
  }

  /**
   * Get a resource group.
   *
   * Retrieve a resource group by ID.
   *
   * @param getResourceGroupOptions the {@link GetResourceGroupOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceGroup}
   */
  public ServiceCall<ResourceGroup> getResourceGroup(GetResourceGroupOptions getResourceGroupOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getResourceGroupOptions,
      "getResourceGroupOptions cannot be null");
    String[] pathSegments = { "resource_groups" };
    String[] pathParameters = { getResourceGroupOptions.id() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
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
   * Update a resource group by ID.
   *
   * @param updateResourceGroupOptions the {@link UpdateResourceGroupOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceGroup}
   */
  public ServiceCall<ResourceGroup> updateResourceGroup(UpdateResourceGroupOptions updateResourceGroupOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateResourceGroupOptions,
      "updateResourceGroupOptions cannot be null");
    String[] pathSegments = { "resource_groups" };
    String[] pathParameters = { updateResourceGroupOptions.id() };
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
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
   * Delete a resource group by ID.
   *
   * @param deleteResourceGroupOptions the {@link DeleteResourceGroupOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteResourceGroup(DeleteResourceGroupOptions deleteResourceGroupOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteResourceGroupOptions,
      "deleteResourceGroupOptions cannot be null");
    String[] pathSegments = { "resource_groups" };
    String[] pathParameters = { deleteResourceGroupOptions.id() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_manager", "v2", "deleteResourceGroup");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }

    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

}
