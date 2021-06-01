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
 * IBM OpenAPI SDK Code Generator Version: 3.32.0-4c6a3129-20210514-210323
 */

package com.ibm.cloud.platform_services.resource_controller.v2;

import com.google.gson.JsonObject;
import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.platform_services.resource_controller.v2.model.CreateResourceAliasOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.CreateResourceBindingOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.CreateResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.CreateResourceKeyOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.DeleteResourceAliasOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.DeleteResourceBindingOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.DeleteResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.DeleteResourceKeyOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.GetResourceAliasOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.GetResourceBindingOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.GetResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.GetResourceKeyOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListReclamationsOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceAliasesForInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceAliasesOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceBindingsForAliasOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceBindingsOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceInstancesOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceKeysForInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceKeysOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.LockResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.Reclamation;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ReclamationsList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceAlias;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceAliasesList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceBinding;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceBindingsList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceInstance;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceInstancesList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceKey;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceKeysList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.RunReclamationActionOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.UnlockResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.UpdateResourceAliasOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.UpdateResourceBindingOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.UpdateResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.UpdateResourceKeyOptions;
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
 * Manage lifecycle of your Cloud resources using Resource Controller APIs. Resources are provisioned globally in an
 * account scope. Supports asynchronous provisioning of resources. Enables consumption of a global resource through a
 * Cloud Foundry space in any region.
 *
 * @version v2
 */
public class ResourceController extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "resource_controller";

  public static final String DEFAULT_SERVICE_URL = "https://resource-controller.cloud.ibm.com";

 /**
   * Class method which constructs an instance of the `ResourceController` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `ResourceController` client using external configuration
   */
  public static ResourceController newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `ResourceController` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `ResourceController` client using external configuration
   */
  public static ResourceController newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    ResourceController service = new ResourceController(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `ResourceController` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public ResourceController(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * Get a list of all resource instances.
   *
   * View a list of all available resource instances. Resources is a broad term that could mean anything from a service
   * instance to a virtual machine associated with the customer account.
   *
   * @param listResourceInstancesOptions the {@link ListResourceInstancesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceInstancesList}
   */
  public ServiceCall<ResourceInstancesList> listResourceInstances(ListResourceInstancesOptions listResourceInstancesOptions) {
    if (listResourceInstancesOptions == null) {
      listResourceInstancesOptions = new ListResourceInstancesOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_instances"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "listResourceInstances");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listResourceInstancesOptions.guid() != null) {
      builder.query("guid", String.valueOf(listResourceInstancesOptions.guid()));
    }
    if (listResourceInstancesOptions.name() != null) {
      builder.query("name", String.valueOf(listResourceInstancesOptions.name()));
    }
    if (listResourceInstancesOptions.resourceGroupId() != null) {
      builder.query("resource_group_id", String.valueOf(listResourceInstancesOptions.resourceGroupId()));
    }
    if (listResourceInstancesOptions.resourceId() != null) {
      builder.query("resource_id", String.valueOf(listResourceInstancesOptions.resourceId()));
    }
    if (listResourceInstancesOptions.resourcePlanId() != null) {
      builder.query("resource_plan_id", String.valueOf(listResourceInstancesOptions.resourcePlanId()));
    }
    if (listResourceInstancesOptions.type() != null) {
      builder.query("type", String.valueOf(listResourceInstancesOptions.type()));
    }
    if (listResourceInstancesOptions.subType() != null) {
      builder.query("sub_type", String.valueOf(listResourceInstancesOptions.subType()));
    }
    if (listResourceInstancesOptions.limit() != null) {
      builder.query("limit", String.valueOf(listResourceInstancesOptions.limit()));
    }
    if (listResourceInstancesOptions.start() != null) {
      builder.query("start", String.valueOf(listResourceInstancesOptions.start()));
    }
    if (listResourceInstancesOptions.state() != null) {
      builder.query("state", String.valueOf(listResourceInstancesOptions.state()));
    }
    if (listResourceInstancesOptions.updatedFrom() != null) {
      builder.query("updated_from", String.valueOf(listResourceInstancesOptions.updatedFrom()));
    }
    if (listResourceInstancesOptions.updatedTo() != null) {
      builder.query("updated_to", String.valueOf(listResourceInstancesOptions.updatedTo()));
    }
    ResponseConverter<ResourceInstancesList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceInstancesList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a list of all resource instances.
   *
   * View a list of all available resource instances. Resources is a broad term that could mean anything from a service
   * instance to a virtual machine associated with the customer account.
   *
   * @return a {@link ServiceCall} with a result of type {@link ResourceInstancesList}
   */
  public ServiceCall<ResourceInstancesList> listResourceInstances() {
    return listResourceInstances(null);
  }

  /**
   * Create (provision) a new resource instance.
   *
   * When you provision a service you get an instance of that service. An instance represents the resource with which
   * you create, and additionally, represents a chargeable record of which billing can occur.
   *
   * @param createResourceInstanceOptions the {@link CreateResourceInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceInstance}
   */
  public ServiceCall<ResourceInstance> createResourceInstance(CreateResourceInstanceOptions createResourceInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createResourceInstanceOptions,
      "createResourceInstanceOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_instances"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "createResourceInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createResourceInstanceOptions.entityLock() != null) {
      builder.header("Entity-Lock", createResourceInstanceOptions.entityLock());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", createResourceInstanceOptions.name());
    contentJson.addProperty("target", createResourceInstanceOptions.target());
    contentJson.addProperty("resource_group", createResourceInstanceOptions.resourceGroup());
    contentJson.addProperty("resource_plan_id", createResourceInstanceOptions.resourcePlanId());
    if (createResourceInstanceOptions.tags() != null) {
      contentJson.add("tags", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createResourceInstanceOptions.tags()));
    }
    if (createResourceInstanceOptions.allowCleanup() != null) {
      contentJson.addProperty("allow_cleanup", createResourceInstanceOptions.allowCleanup());
    }
    if (createResourceInstanceOptions.parameters() != null) {
      contentJson.add("parameters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createResourceInstanceOptions.parameters()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ResourceInstance> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceInstance>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a resource instance.
   *
   * Retrieve a resource instance by ID. Find more details on a particular instance, like when it was provisioned and
   * who provisioned it.
   *
   * @param getResourceInstanceOptions the {@link GetResourceInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceInstance}
   */
  public ServiceCall<ResourceInstance> getResourceInstance(GetResourceInstanceOptions getResourceInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getResourceInstanceOptions,
      "getResourceInstanceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", getResourceInstanceOptions.id());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_instances/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "getResourceInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ResourceInstance> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceInstance>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a resource instance.
   *
   * Delete a resource instance by ID. If the resource instance has any resource keys or aliases associated with it, use
   * the `recursive=true parameter` to delete it.
   *
   * @param deleteResourceInstanceOptions the {@link DeleteResourceInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteResourceInstance(DeleteResourceInstanceOptions deleteResourceInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteResourceInstanceOptions,
      "deleteResourceInstanceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", deleteResourceInstanceOptions.id());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_instances/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "deleteResourceInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (deleteResourceInstanceOptions.recursive() != null) {
      builder.query("recursive", String.valueOf(deleteResourceInstanceOptions.recursive()));
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a resource instance.
   *
   * You can use the ID to make updates to the resource instance, like changing the name or plan.
   *
   * @param updateResourceInstanceOptions the {@link UpdateResourceInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceInstance}
   */
  public ServiceCall<ResourceInstance> updateResourceInstance(UpdateResourceInstanceOptions updateResourceInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateResourceInstanceOptions,
      "updateResourceInstanceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", updateResourceInstanceOptions.id());
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_instances/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "updateResourceInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (updateResourceInstanceOptions.name() != null) {
      contentJson.addProperty("name", updateResourceInstanceOptions.name());
    }
    if (updateResourceInstanceOptions.parameters() != null) {
      contentJson.add("parameters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateResourceInstanceOptions.parameters()));
    }
    if (updateResourceInstanceOptions.resourcePlanId() != null) {
      contentJson.addProperty("resource_plan_id", updateResourceInstanceOptions.resourcePlanId());
    }
    if (updateResourceInstanceOptions.allowCleanup() != null) {
      contentJson.addProperty("allow_cleanup", updateResourceInstanceOptions.allowCleanup());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ResourceInstance> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceInstance>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a list of all resource aliases for the instance.
   *
   * Retrieving a list of all resource aliases can help you find out who's using the resource instance.
   *
   * @param listResourceAliasesForInstanceOptions the {@link ListResourceAliasesForInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceAliasesList}
   */
  public ServiceCall<ResourceAliasesList> listResourceAliasesForInstance(ListResourceAliasesForInstanceOptions listResourceAliasesForInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listResourceAliasesForInstanceOptions,
      "listResourceAliasesForInstanceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", listResourceAliasesForInstanceOptions.id());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_instances/{id}/resource_aliases", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "listResourceAliasesForInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listResourceAliasesForInstanceOptions.limit() != null) {
      builder.query("limit", String.valueOf(listResourceAliasesForInstanceOptions.limit()));
    }
    if (listResourceAliasesForInstanceOptions.start() != null) {
      builder.query("start", String.valueOf(listResourceAliasesForInstanceOptions.start()));
    }
    ResponseConverter<ResourceAliasesList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceAliasesList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a list of all the resource keys for the instance.
   *
   * You may have many resource keys for one resource instance. For example, you may have a different resource key for
   * each user or each role.
   *
   * @param listResourceKeysForInstanceOptions the {@link ListResourceKeysForInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceKeysList}
   */
  public ServiceCall<ResourceKeysList> listResourceKeysForInstance(ListResourceKeysForInstanceOptions listResourceKeysForInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listResourceKeysForInstanceOptions,
      "listResourceKeysForInstanceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", listResourceKeysForInstanceOptions.id());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_instances/{id}/resource_keys", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "listResourceKeysForInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listResourceKeysForInstanceOptions.limit() != null) {
      builder.query("limit", String.valueOf(listResourceKeysForInstanceOptions.limit()));
    }
    if (listResourceKeysForInstanceOptions.start() != null) {
      builder.query("start", String.valueOf(listResourceKeysForInstanceOptions.start()));
    }
    ResponseConverter<ResourceKeysList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceKeysList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Lock a resource instance.
   *
   * Locks a resource instance by ID. A locked instance can not be updated or deleted. It does not affect actions
   * performed on child resources like aliases, bindings or keys.
   *
   * @param lockResourceInstanceOptions the {@link LockResourceInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceInstance}
   */
  public ServiceCall<ResourceInstance> lockResourceInstance(LockResourceInstanceOptions lockResourceInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(lockResourceInstanceOptions,
      "lockResourceInstanceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", lockResourceInstanceOptions.id());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_instances/{id}/lock", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "lockResourceInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ResourceInstance> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceInstance>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Unlock a resource instance.
   *
   * Unlock a resource instance to update or delete it. Unlocking a resource instance does not affect child resources
   * like aliases, bindings or keys.
   *
   * @param unlockResourceInstanceOptions the {@link UnlockResourceInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceInstance}
   */
  public ServiceCall<ResourceInstance> unlockResourceInstance(UnlockResourceInstanceOptions unlockResourceInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(unlockResourceInstanceOptions,
      "unlockResourceInstanceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", unlockResourceInstanceOptions.id());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_instances/{id}/lock", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "unlockResourceInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ResourceInstance> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceInstance>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a list of all of the resource keys.
   *
   * View all of the resource keys that exist for all of your resource instances.
   *
   * @param listResourceKeysOptions the {@link ListResourceKeysOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceKeysList}
   */
  public ServiceCall<ResourceKeysList> listResourceKeys(ListResourceKeysOptions listResourceKeysOptions) {
    if (listResourceKeysOptions == null) {
      listResourceKeysOptions = new ListResourceKeysOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_keys"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "listResourceKeys");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listResourceKeysOptions.guid() != null) {
      builder.query("guid", String.valueOf(listResourceKeysOptions.guid()));
    }
    if (listResourceKeysOptions.name() != null) {
      builder.query("name", String.valueOf(listResourceKeysOptions.name()));
    }
    if (listResourceKeysOptions.resourceGroupId() != null) {
      builder.query("resource_group_id", String.valueOf(listResourceKeysOptions.resourceGroupId()));
    }
    if (listResourceKeysOptions.resourceId() != null) {
      builder.query("resource_id", String.valueOf(listResourceKeysOptions.resourceId()));
    }
    if (listResourceKeysOptions.limit() != null) {
      builder.query("limit", String.valueOf(listResourceKeysOptions.limit()));
    }
    if (listResourceKeysOptions.start() != null) {
      builder.query("start", String.valueOf(listResourceKeysOptions.start()));
    }
    if (listResourceKeysOptions.updatedFrom() != null) {
      builder.query("updated_from", String.valueOf(listResourceKeysOptions.updatedFrom()));
    }
    if (listResourceKeysOptions.updatedTo() != null) {
      builder.query("updated_to", String.valueOf(listResourceKeysOptions.updatedTo()));
    }
    ResponseConverter<ResourceKeysList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceKeysList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a list of all of the resource keys.
   *
   * View all of the resource keys that exist for all of your resource instances.
   *
   * @return a {@link ServiceCall} with a result of type {@link ResourceKeysList}
   */
  public ServiceCall<ResourceKeysList> listResourceKeys() {
    return listResourceKeys(null);
  }

  /**
   * Create a new resource key.
   *
   * A resource key is a saved credential you can use to authenticate with a resource instance.
   *
   * @param createResourceKeyOptions the {@link CreateResourceKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceKey}
   */
  public ServiceCall<ResourceKey> createResourceKey(CreateResourceKeyOptions createResourceKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createResourceKeyOptions,
      "createResourceKeyOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_keys"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "createResourceKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", createResourceKeyOptions.name());
    contentJson.addProperty("source", createResourceKeyOptions.source());
    if (createResourceKeyOptions.parameters() != null) {
      contentJson.add("parameters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createResourceKeyOptions.parameters()));
    }
    if (createResourceKeyOptions.role() != null) {
      contentJson.addProperty("role", createResourceKeyOptions.role());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ResourceKey> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceKey>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get resource key by ID.
   *
   * View a resource key and all of its details, like the credentials for the key and who created it.
   *
   * @param getResourceKeyOptions the {@link GetResourceKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceKey}
   */
  public ServiceCall<ResourceKey> getResourceKey(GetResourceKeyOptions getResourceKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getResourceKeyOptions,
      "getResourceKeyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", getResourceKeyOptions.id());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_keys/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "getResourceKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ResourceKey> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceKey>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a resource key by ID.
   *
   * Deleting a resource key does not affect any resource instance or resource alias associated with the key.
   *
   * @param deleteResourceKeyOptions the {@link DeleteResourceKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteResourceKey(DeleteResourceKeyOptions deleteResourceKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteResourceKeyOptions,
      "deleteResourceKeyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", deleteResourceKeyOptions.id());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_keys/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "deleteResourceKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a resource key.
   *
   * Use the resource key ID to update the name of the resource key.
   *
   * @param updateResourceKeyOptions the {@link UpdateResourceKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceKey}
   */
  public ServiceCall<ResourceKey> updateResourceKey(UpdateResourceKeyOptions updateResourceKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateResourceKeyOptions,
      "updateResourceKeyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", updateResourceKeyOptions.id());
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_keys/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "updateResourceKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", updateResourceKeyOptions.name());
    builder.bodyJson(contentJson);
    ResponseConverter<ResourceKey> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceKey>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a list of all resource bindings.
   *
   * View all of the resource bindings that exist for all of your resource aliases.
   *
   * @param listResourceBindingsOptions the {@link ListResourceBindingsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceBindingsList}
   */
  public ServiceCall<ResourceBindingsList> listResourceBindings(ListResourceBindingsOptions listResourceBindingsOptions) {
    if (listResourceBindingsOptions == null) {
      listResourceBindingsOptions = new ListResourceBindingsOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_bindings"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "listResourceBindings");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listResourceBindingsOptions.guid() != null) {
      builder.query("guid", String.valueOf(listResourceBindingsOptions.guid()));
    }
    if (listResourceBindingsOptions.name() != null) {
      builder.query("name", String.valueOf(listResourceBindingsOptions.name()));
    }
    if (listResourceBindingsOptions.resourceGroupId() != null) {
      builder.query("resource_group_id", String.valueOf(listResourceBindingsOptions.resourceGroupId()));
    }
    if (listResourceBindingsOptions.resourceId() != null) {
      builder.query("resource_id", String.valueOf(listResourceBindingsOptions.resourceId()));
    }
    if (listResourceBindingsOptions.regionBindingId() != null) {
      builder.query("region_binding_id", String.valueOf(listResourceBindingsOptions.regionBindingId()));
    }
    if (listResourceBindingsOptions.limit() != null) {
      builder.query("limit", String.valueOf(listResourceBindingsOptions.limit()));
    }
    if (listResourceBindingsOptions.start() != null) {
      builder.query("start", String.valueOf(listResourceBindingsOptions.start()));
    }
    if (listResourceBindingsOptions.updatedFrom() != null) {
      builder.query("updated_from", String.valueOf(listResourceBindingsOptions.updatedFrom()));
    }
    if (listResourceBindingsOptions.updatedTo() != null) {
      builder.query("updated_to", String.valueOf(listResourceBindingsOptions.updatedTo()));
    }
    ResponseConverter<ResourceBindingsList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceBindingsList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a list of all resource bindings.
   *
   * View all of the resource bindings that exist for all of your resource aliases.
   *
   * @return a {@link ServiceCall} with a result of type {@link ResourceBindingsList}
   */
  public ServiceCall<ResourceBindingsList> listResourceBindings() {
    return listResourceBindings(null);
  }

  /**
   * Create a new resource binding.
   *
   * A resource binding connects credentials to a resource alias. The credentials are in the form of a resource key.
   *
   * @param createResourceBindingOptions the {@link CreateResourceBindingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceBinding}
   */
  public ServiceCall<ResourceBinding> createResourceBinding(CreateResourceBindingOptions createResourceBindingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createResourceBindingOptions,
      "createResourceBindingOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_bindings"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "createResourceBinding");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("source", createResourceBindingOptions.source());
    contentJson.addProperty("target", createResourceBindingOptions.target());
    if (createResourceBindingOptions.name() != null) {
      contentJson.addProperty("name", createResourceBindingOptions.name());
    }
    if (createResourceBindingOptions.parameters() != null) {
      contentJson.add("parameters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createResourceBindingOptions.parameters()));
    }
    if (createResourceBindingOptions.role() != null) {
      contentJson.addProperty("role", createResourceBindingOptions.role());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ResourceBinding> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceBinding>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a resource binding.
   *
   * View a resource binding and all of its details, like who created it, the credential, and the resource alias that
   * the binding is associated with.
   *
   * @param getResourceBindingOptions the {@link GetResourceBindingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceBinding}
   */
  public ServiceCall<ResourceBinding> getResourceBinding(GetResourceBindingOptions getResourceBindingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getResourceBindingOptions,
      "getResourceBindingOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", getResourceBindingOptions.id());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_bindings/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "getResourceBinding");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ResourceBinding> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceBinding>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a resource binding.
   *
   * Deleting a resource binding does not affect the resource alias that the binding is associated with.
   *
   * @param deleteResourceBindingOptions the {@link DeleteResourceBindingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteResourceBinding(DeleteResourceBindingOptions deleteResourceBindingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteResourceBindingOptions,
      "deleteResourceBindingOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", deleteResourceBindingOptions.id());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_bindings/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "deleteResourceBinding");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a resource binding.
   *
   * Use the resource binding ID to update the name of the resource binding.
   *
   * @param updateResourceBindingOptions the {@link UpdateResourceBindingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceBinding}
   */
  public ServiceCall<ResourceBinding> updateResourceBinding(UpdateResourceBindingOptions updateResourceBindingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateResourceBindingOptions,
      "updateResourceBindingOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", updateResourceBindingOptions.id());
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_bindings/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "updateResourceBinding");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", updateResourceBindingOptions.name());
    builder.bodyJson(contentJson);
    ResponseConverter<ResourceBinding> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceBinding>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a list of all resource aliases.
   *
   * View all of the resource aliases that exist for every resource instance.
   *
   * @param listResourceAliasesOptions the {@link ListResourceAliasesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceAliasesList}
   */
  public ServiceCall<ResourceAliasesList> listResourceAliases(ListResourceAliasesOptions listResourceAliasesOptions) {
    if (listResourceAliasesOptions == null) {
      listResourceAliasesOptions = new ListResourceAliasesOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_aliases"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "listResourceAliases");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listResourceAliasesOptions.guid() != null) {
      builder.query("guid", String.valueOf(listResourceAliasesOptions.guid()));
    }
    if (listResourceAliasesOptions.name() != null) {
      builder.query("name", String.valueOf(listResourceAliasesOptions.name()));
    }
    if (listResourceAliasesOptions.resourceInstanceId() != null) {
      builder.query("resource_instance_id", String.valueOf(listResourceAliasesOptions.resourceInstanceId()));
    }
    if (listResourceAliasesOptions.regionInstanceId() != null) {
      builder.query("region_instance_id", String.valueOf(listResourceAliasesOptions.regionInstanceId()));
    }
    if (listResourceAliasesOptions.resourceId() != null) {
      builder.query("resource_id", String.valueOf(listResourceAliasesOptions.resourceId()));
    }
    if (listResourceAliasesOptions.resourceGroupId() != null) {
      builder.query("resource_group_id", String.valueOf(listResourceAliasesOptions.resourceGroupId()));
    }
    if (listResourceAliasesOptions.limit() != null) {
      builder.query("limit", String.valueOf(listResourceAliasesOptions.limit()));
    }
    if (listResourceAliasesOptions.start() != null) {
      builder.query("start", String.valueOf(listResourceAliasesOptions.start()));
    }
    if (listResourceAliasesOptions.updatedFrom() != null) {
      builder.query("updated_from", String.valueOf(listResourceAliasesOptions.updatedFrom()));
    }
    if (listResourceAliasesOptions.updatedTo() != null) {
      builder.query("updated_to", String.valueOf(listResourceAliasesOptions.updatedTo()));
    }
    ResponseConverter<ResourceAliasesList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceAliasesList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a list of all resource aliases.
   *
   * View all of the resource aliases that exist for every resource instance.
   *
   * @return a {@link ServiceCall} with a result of type {@link ResourceAliasesList}
   */
  public ServiceCall<ResourceAliasesList> listResourceAliases() {
    return listResourceAliases(null);
  }

  /**
   * Create a new resource alias.
   *
   * Alias a resource instance into a targeted environment's (name)space.
   *
   * @param createResourceAliasOptions the {@link CreateResourceAliasOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceAlias}
   */
  public ServiceCall<ResourceAlias> createResourceAlias(CreateResourceAliasOptions createResourceAliasOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createResourceAliasOptions,
      "createResourceAliasOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_aliases"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "createResourceAlias");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", createResourceAliasOptions.name());
    contentJson.addProperty("source", createResourceAliasOptions.source());
    contentJson.addProperty("target", createResourceAliasOptions.target());
    builder.bodyJson(contentJson);
    ResponseConverter<ResourceAlias> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceAlias>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a resource alias.
   *
   * View a resource alias and all of its details, like who created it and the resource instance that it's associated
   * with.
   *
   * @param getResourceAliasOptions the {@link GetResourceAliasOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceAlias}
   */
  public ServiceCall<ResourceAlias> getResourceAlias(GetResourceAliasOptions getResourceAliasOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getResourceAliasOptions,
      "getResourceAliasOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", getResourceAliasOptions.id());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_aliases/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "getResourceAlias");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ResourceAlias> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceAlias>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a resource alias.
   *
   * If the resource alias has any resource keys or bindings associated with it, you must delete those child resources
   * before deleting the resource alias.
   *
   * @param deleteResourceAliasOptions the {@link DeleteResourceAliasOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteResourceAlias(DeleteResourceAliasOptions deleteResourceAliasOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteResourceAliasOptions,
      "deleteResourceAliasOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", deleteResourceAliasOptions.id());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_aliases/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "deleteResourceAlias");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a resource alias.
   *
   * Use the resource alias ID to update the name of the resource alias.
   *
   * @param updateResourceAliasOptions the {@link UpdateResourceAliasOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceAlias}
   */
  public ServiceCall<ResourceAlias> updateResourceAlias(UpdateResourceAliasOptions updateResourceAliasOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateResourceAliasOptions,
      "updateResourceAliasOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", updateResourceAliasOptions.id());
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_aliases/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "updateResourceAlias");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", updateResourceAliasOptions.name());
    builder.bodyJson(contentJson);
    ResponseConverter<ResourceAlias> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceAlias>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a list of all resource bindings for the alias.
   *
   * View all of the resource bindings associated with a specific resource alias.
   *
   * @param listResourceBindingsForAliasOptions the {@link ListResourceBindingsForAliasOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceBindingsList}
   */
  public ServiceCall<ResourceBindingsList> listResourceBindingsForAlias(ListResourceBindingsForAliasOptions listResourceBindingsForAliasOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listResourceBindingsForAliasOptions,
      "listResourceBindingsForAliasOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", listResourceBindingsForAliasOptions.id());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resource_aliases/{id}/resource_bindings", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "listResourceBindingsForAlias");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listResourceBindingsForAliasOptions.limit() != null) {
      builder.query("limit", String.valueOf(listResourceBindingsForAliasOptions.limit()));
    }
    if (listResourceBindingsForAliasOptions.start() != null) {
      builder.query("start", String.valueOf(listResourceBindingsForAliasOptions.start()));
    }
    ResponseConverter<ResourceBindingsList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceBindingsList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a list of all reclamations.
   *
   * View all of the resource reclamations that exist for every resource instance.
   *
   * @param listReclamationsOptions the {@link ListReclamationsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ReclamationsList}
   */
  public ServiceCall<ReclamationsList> listReclamations(ListReclamationsOptions listReclamationsOptions) {
    if (listReclamationsOptions == null) {
      listReclamationsOptions = new ListReclamationsOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/reclamations"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "listReclamations");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listReclamationsOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(listReclamationsOptions.accountId()));
    }
    if (listReclamationsOptions.resourceInstanceId() != null) {
      builder.query("resource_instance_id", String.valueOf(listReclamationsOptions.resourceInstanceId()));
    }
    ResponseConverter<ReclamationsList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ReclamationsList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a list of all reclamations.
   *
   * View all of the resource reclamations that exist for every resource instance.
   *
   * @return a {@link ServiceCall} with a result of type {@link ReclamationsList}
   */
  public ServiceCall<ReclamationsList> listReclamations() {
    return listReclamations(null);
  }

  /**
   * Perform a reclamation action.
   *
   * Reclaim a resource instance so that it can no longer be used, or restore the resource instance so that it's usable
   * again.
   *
   * @param runReclamationActionOptions the {@link RunReclamationActionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Reclamation}
   */
  public ServiceCall<Reclamation> runReclamationAction(RunReclamationActionOptions runReclamationActionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(runReclamationActionOptions,
      "runReclamationActionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", runReclamationActionOptions.id());
    pathParamsMap.put("action_name", runReclamationActionOptions.actionName());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/reclamations/{id}/actions/{action_name}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "runReclamationAction");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (runReclamationActionOptions.requestBy() != null) {
      contentJson.addProperty("request_by", runReclamationActionOptions.requestBy());
    }
    if (runReclamationActionOptions.comment() != null) {
      contentJson.addProperty("comment", runReclamationActionOptions.comment());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Reclamation> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Reclamation>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}
