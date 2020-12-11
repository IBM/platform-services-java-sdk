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

package com.ibm.cloud.platform_services.iam_identity.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ApiKey;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ApiKeyList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetApiKeysDetailsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListApiKeysOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListServiceIdsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.LockApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.LockServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ServiceId;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ServiceIdList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UnlockApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UnlockServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateServiceIdOptions;
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
 * The IAM Identity Service API allows for the management of Identities (Service IDs, ApiKeys).
 *
 * @version v1
 */
public class IamIdentity extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "iam_identity";

  public static final String DEFAULT_SERVICE_URL = "https://iam.cloud.ibm.com";

 /**
   * Class method which constructs an instance of the `IamIdentity` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `IamIdentity` client using external configuration
   */
  public static IamIdentity newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `IamIdentity` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `IamIdentity` client using external configuration
   */
  public static IamIdentity newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    IamIdentity service = new IamIdentity(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `IamIdentity` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public IamIdentity(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * Get API keys for a given service or user IAM ID and account ID.
   *
   * Returns the list of API key details for a given service or user IAM ID and account ID. Users can manage user API
   * keys for themself, or service ID API keys for  service IDs that are bound to an entity they have access to. In case
   * of  service IDs and their API keys, a user must be either an account owner,  a IBM Cloud org manager or IBM Cloud
   * space developer in order to manage  service IDs of the entity.
   *
   * @param listApiKeysOptions the {@link ListApiKeysOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApiKeyList}
   */
  public ServiceCall<ApiKeyList> listApiKeys(ListApiKeysOptions listApiKeysOptions) {
    if (listApiKeysOptions == null) {
      listApiKeysOptions = new ListApiKeysOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/apikeys"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "listApiKeys");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listApiKeysOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(listApiKeysOptions.accountId()));
    }
    if (listApiKeysOptions.iamId() != null) {
      builder.query("iam_id", String.valueOf(listApiKeysOptions.iamId()));
    }
    if (listApiKeysOptions.pagesize() != null) {
      builder.query("pagesize", String.valueOf(listApiKeysOptions.pagesize()));
    }
    if (listApiKeysOptions.pagetoken() != null) {
      builder.query("pagetoken", String.valueOf(listApiKeysOptions.pagetoken()));
    }
    if (listApiKeysOptions.scope() != null) {
      builder.query("scope", String.valueOf(listApiKeysOptions.scope()));
    }
    if (listApiKeysOptions.type() != null) {
      builder.query("type", String.valueOf(listApiKeysOptions.type()));
    }
    if (listApiKeysOptions.sort() != null) {
      builder.query("sort", String.valueOf(listApiKeysOptions.sort()));
    }
    if (listApiKeysOptions.order() != null) {
      builder.query("order", String.valueOf(listApiKeysOptions.order()));
    }
    if (listApiKeysOptions.includeHistory() != null) {
      builder.query("include_history", String.valueOf(listApiKeysOptions.includeHistory()));
    }
    ResponseConverter<ApiKeyList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApiKeyList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get API keys for a given service or user IAM ID and account ID.
   *
   * Returns the list of API key details for a given service or user IAM ID and account ID. Users can manage user API
   * keys for themself, or service ID API keys for  service IDs that are bound to an entity they have access to. In case
   * of  service IDs and their API keys, a user must be either an account owner,  a IBM Cloud org manager or IBM Cloud
   * space developer in order to manage  service IDs of the entity.
   *
   * @return a {@link ServiceCall} with a result of type {@link ApiKeyList}
   */
  public ServiceCall<ApiKeyList> listApiKeys() {
    return listApiKeys(null);
  }

  /**
   * Create an API key.
   *
   * Creates an API key for a UserID or service ID. Users can manage user API keys for themself, or service ID API keys
   * for  service IDs that are bound to an entity they have access to.
   *
   * @param createApiKeyOptions the {@link CreateApiKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApiKey}
   */
  public ServiceCall<ApiKey> createApiKey(CreateApiKeyOptions createApiKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createApiKeyOptions,
      "createApiKeyOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/apikeys"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "createApiKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createApiKeyOptions.entityLock() != null) {
      builder.header("Entity-Lock", createApiKeyOptions.entityLock());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", createApiKeyOptions.name());
    contentJson.addProperty("iam_id", createApiKeyOptions.iamId());
    if (createApiKeyOptions.description() != null) {
      contentJson.addProperty("description", createApiKeyOptions.description());
    }
    if (createApiKeyOptions.accountId() != null) {
      contentJson.addProperty("account_id", createApiKeyOptions.accountId());
    }
    if (createApiKeyOptions.apikey() != null) {
      contentJson.addProperty("apikey", createApiKeyOptions.apikey());
    }
    if (createApiKeyOptions.storeValue() != null) {
      contentJson.addProperty("store_value", createApiKeyOptions.storeValue());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ApiKey> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApiKey>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get details of an API key by its value.
   *
   * Returns the details of an API key by its value. Users can manage user API keys for themself, or service ID API keys
   *  for service IDs that are bound to an entity they have access to.
   *
   * @param getApiKeysDetailsOptions the {@link GetApiKeysDetailsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApiKey}
   */
  public ServiceCall<ApiKey> getApiKeysDetails(GetApiKeysDetailsOptions getApiKeysDetailsOptions) {
    if (getApiKeysDetailsOptions == null) {
      getApiKeysDetailsOptions = new GetApiKeysDetailsOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/apikeys/details"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "getApiKeysDetails");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getApiKeysDetailsOptions.iamApiKey() != null) {
      builder.header("IAM-ApiKey", getApiKeysDetailsOptions.iamApiKey());
    }
    if (getApiKeysDetailsOptions.includeHistory() != null) {
      builder.query("include_history", String.valueOf(getApiKeysDetailsOptions.includeHistory()));
    }
    ResponseConverter<ApiKey> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApiKey>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get details of an API key by its value.
   *
   * Returns the details of an API key by its value. Users can manage user API keys for themself, or service ID API keys
   *  for service IDs that are bound to an entity they have access to.
   *
   * @return a {@link ServiceCall} with a result of type {@link ApiKey}
   */
  public ServiceCall<ApiKey> getApiKeysDetails() {
    return getApiKeysDetails(null);
  }

  /**
   * Get details of an API key.
   *
   * Returns the details of an API key. Users can manage user API keys for themself, or service ID API keys for  service
   * IDs that are bound to an entity they have access to. In case of  service IDs and their API keys, a user must be
   * either an account owner,  a IBM Cloud org manager or IBM Cloud space developer in order to manage  service IDs of
   * the entity.
   *
   * @param getApiKeyOptions the {@link GetApiKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApiKey}
   */
  public ServiceCall<ApiKey> getApiKey(GetApiKeyOptions getApiKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getApiKeyOptions,
      "getApiKeyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", getApiKeyOptions.id());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/apikeys/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "getApiKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getApiKeyOptions.includeHistory() != null) {
      builder.query("include_history", String.valueOf(getApiKeyOptions.includeHistory()));
    }
    ResponseConverter<ApiKey> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApiKey>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Updates an API key.
   *
   * Updates properties of an API key. This does NOT affect existing access tokens. Their token content will stay
   * unchanged until the access token is refreshed. To update an API key, pass the property to be modified. To delete
   * one property's value, pass the property with an empty value "".Users can manage user API keys for themself, or
   * service ID API keys for service IDs that are bound to an entity they have access to.
   *
   * @param updateApiKeyOptions the {@link UpdateApiKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApiKey}
   */
  public ServiceCall<ApiKey> updateApiKey(UpdateApiKeyOptions updateApiKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateApiKeyOptions,
      "updateApiKeyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", updateApiKeyOptions.id());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/apikeys/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "updateApiKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("If-Match", updateApiKeyOptions.ifMatch());
    final JsonObject contentJson = new JsonObject();
    if (updateApiKeyOptions.name() != null) {
      contentJson.addProperty("name", updateApiKeyOptions.name());
    }
    if (updateApiKeyOptions.description() != null) {
      contentJson.addProperty("description", updateApiKeyOptions.description());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ApiKey> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApiKey>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Deletes an API key.
   *
   * Deletes an API key. Existing tokens will remain valid until expired. Refresh tokens  will not work any more for
   * this API key. Users can manage user API keys for themself, or service ID API  keys for service IDs that are bound
   * to an entity they have access  to.
   *
   * @param deleteApiKeyOptions the {@link DeleteApiKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteApiKey(DeleteApiKeyOptions deleteApiKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteApiKeyOptions,
      "deleteApiKeyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", deleteApiKeyOptions.id());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/apikeys/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "deleteApiKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Lock the API key.
   *
   * Locks an API key by ID. Users can manage user API keys for themself, or service ID API keys for service IDs that
   * are bound to an entity they have access to. In case of service IDs and their API keys, a user must be either an
   * account owner, a IBM Cloud org manager or IBM Cloud space developer in order to manage service IDs of the entity.
   *
   * @param lockApiKeyOptions the {@link LockApiKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> lockApiKey(LockApiKeyOptions lockApiKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(lockApiKeyOptions,
      "lockApiKeyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", lockApiKeyOptions.id());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/apikeys/{id}/lock", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "lockApiKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Unlock the API key.
   *
   * Unlocks an API key by ID. Users can manage user API keys for themself, or service ID API keys for service IDs that
   * are bound to an entity they have access to. In case of service IDs and their API keys, a user must be either an
   * account owner, a IBM Cloud org manager or IBM Cloud space developer in order to manage service IDs of the entity.
   *
   * @param unlockApiKeyOptions the {@link UnlockApiKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> unlockApiKey(UnlockApiKeyOptions unlockApiKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(unlockApiKeyOptions,
      "unlockApiKeyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", unlockApiKeyOptions.id());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/apikeys/{id}/lock", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "unlockApiKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List service IDs.
   *
   * Returns a list of service IDs. Users can manage user API keys for themself, or service ID API keys for service IDs
   * that are bound to an entity they have access to.
   *
   * @param listServiceIdsOptions the {@link ListServiceIdsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ServiceIdList}
   */
  public ServiceCall<ServiceIdList> listServiceIds(ListServiceIdsOptions listServiceIdsOptions) {
    if (listServiceIdsOptions == null) {
      listServiceIdsOptions = new ListServiceIdsOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/serviceids/"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "listServiceIds");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listServiceIdsOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(listServiceIdsOptions.accountId()));
    }
    if (listServiceIdsOptions.name() != null) {
      builder.query("name", String.valueOf(listServiceIdsOptions.name()));
    }
    if (listServiceIdsOptions.pagesize() != null) {
      builder.query("pagesize", String.valueOf(listServiceIdsOptions.pagesize()));
    }
    if (listServiceIdsOptions.pagetoken() != null) {
      builder.query("pagetoken", String.valueOf(listServiceIdsOptions.pagetoken()));
    }
    if (listServiceIdsOptions.sort() != null) {
      builder.query("sort", String.valueOf(listServiceIdsOptions.sort()));
    }
    if (listServiceIdsOptions.order() != null) {
      builder.query("order", String.valueOf(listServiceIdsOptions.order()));
    }
    if (listServiceIdsOptions.includeHistory() != null) {
      builder.query("include_history", String.valueOf(listServiceIdsOptions.includeHistory()));
    }
    ResponseConverter<ServiceIdList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ServiceIdList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List service IDs.
   *
   * Returns a list of service IDs. Users can manage user API keys for themself, or service ID API keys for service IDs
   * that are bound to an entity they have access to.
   *
   * @return a {@link ServiceCall} with a result of type {@link ServiceIdList}
   */
  public ServiceCall<ServiceIdList> listServiceIds() {
    return listServiceIds(null);
  }

  /**
   * Create a service ID.
   *
   * Creates a service ID for an IBM Cloud account. Users can manage user API keys for themself, or service ID API keys
   * for service IDs that are bound to an entity they have access to.
   *
   * @param createServiceIdOptions the {@link CreateServiceIdOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ServiceId}
   */
  public ServiceCall<ServiceId> createServiceId(CreateServiceIdOptions createServiceIdOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createServiceIdOptions,
      "createServiceIdOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/serviceids/"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "createServiceId");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createServiceIdOptions.entityLock() != null) {
      builder.header("Entity-Lock", createServiceIdOptions.entityLock());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("account_id", createServiceIdOptions.accountId());
    contentJson.addProperty("name", createServiceIdOptions.name());
    if (createServiceIdOptions.description() != null) {
      contentJson.addProperty("description", createServiceIdOptions.description());
    }
    if (createServiceIdOptions.uniqueInstanceCrns() != null) {
      contentJson.add("unique_instance_crns", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createServiceIdOptions.uniqueInstanceCrns()));
    }
    if (createServiceIdOptions.apikey() != null) {
      contentJson.add("apikey", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createServiceIdOptions.apikey()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ServiceId> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ServiceId>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get details of a service ID.
   *
   * Returns the details of a service ID. Users can manage user API keys for themself, or service ID API keys for
   * service IDs that are bound to an entity they have access to.
   *
   * @param getServiceIdOptions the {@link GetServiceIdOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ServiceId}
   */
  public ServiceCall<ServiceId> getServiceId(GetServiceIdOptions getServiceIdOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getServiceIdOptions,
      "getServiceIdOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", getServiceIdOptions.id());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/serviceids/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "getServiceId");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getServiceIdOptions.includeHistory() != null) {
      builder.query("include_history", String.valueOf(getServiceIdOptions.includeHistory()));
    }
    ResponseConverter<ServiceId> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ServiceId>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update service ID.
   *
   * Updates properties of a service ID. This does NOT affect existing access tokens. Their token content will stay
   * unchanged until the access token is refreshed. To update a service ID, pass the property to be modified. To delete
   * one property's value, pass the property with an empty value "".Users can manage user API keys for themself, or
   * service ID API keys for service IDs that are bound to an entity they have access to.
   *
   * @param updateServiceIdOptions the {@link UpdateServiceIdOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ServiceId}
   */
  public ServiceCall<ServiceId> updateServiceId(UpdateServiceIdOptions updateServiceIdOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateServiceIdOptions,
      "updateServiceIdOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", updateServiceIdOptions.id());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/serviceids/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "updateServiceId");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("If-Match", updateServiceIdOptions.ifMatch());
    final JsonObject contentJson = new JsonObject();
    if (updateServiceIdOptions.name() != null) {
      contentJson.addProperty("name", updateServiceIdOptions.name());
    }
    if (updateServiceIdOptions.description() != null) {
      contentJson.addProperty("description", updateServiceIdOptions.description());
    }
    if (updateServiceIdOptions.uniqueInstanceCrns() != null) {
      contentJson.add("unique_instance_crns", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateServiceIdOptions.uniqueInstanceCrns()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ServiceId> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ServiceId>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Deletes a service ID and associated API keys.
   *
   * Deletes a service ID and all API keys associated to it. Before deleting the service ID, all associated API keys are
   * deleted. In case a Delete Conflict (status code 409) a retry of the request may help as the service ID is only
   * deleted if the associated API keys were successfully deleted before. Users can manage user API keys for themself,
   * or service ID API keys for service IDs that are bound to an entity they have access to.
   *
   * @param deleteServiceIdOptions the {@link DeleteServiceIdOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteServiceId(DeleteServiceIdOptions deleteServiceIdOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteServiceIdOptions,
      "deleteServiceIdOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", deleteServiceIdOptions.id());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/serviceids/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "deleteServiceId");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Lock the service ID.
   *
   * Locks a service ID by ID. Users can manage user API keys for themself, or service ID API keys for service IDs that
   * are bound to an entity they have access to. In case of service IDs and their API keys, a user must be either an
   * account owner, a IBM Cloud org manager or IBM Cloud space developer in order to manage service IDs of the entity.
   *
   * @param lockServiceIdOptions the {@link LockServiceIdOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> lockServiceId(LockServiceIdOptions lockServiceIdOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(lockServiceIdOptions,
      "lockServiceIdOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", lockServiceIdOptions.id());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/serviceids/{id}/lock", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "lockServiceId");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Unlock the service ID.
   *
   * Unlocks a service ID by ID. Users can manage user API keys for themself, or service ID API keys for service IDs
   * that are bound to an entity they have access to. In case of service IDs and their API keys, a user must be either
   * an account owner, a IBM Cloud org manager or IBM Cloud space developer in order to manage service IDs of the
   * entity.
   *
   * @param unlockServiceIdOptions the {@link UnlockServiceIdOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> unlockServiceId(UnlockServiceIdOptions unlockServiceIdOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(unlockServiceIdOptions,
      "unlockServiceIdOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", unlockServiceIdOptions.id());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/serviceids/{id}/lock", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "unlockServiceId");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

}
