/*
 * (C) Copyright IBM Corp. 2022.
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
 * IBM OpenAPI SDK Code Generator Version: 3.47.0-60650593-20220330-200002
 */

package com.ibm.cloud.platform_services.iam_identity.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.platform_services.iam_identity.v1.model.AccountSettingsResponse;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ApiKey;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ApiKeyList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateClaimRuleOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateLinkOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateProfileOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateReportOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteClaimRuleOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteLinkOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteProfileOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetAccountSettingsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetApiKeysDetailsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetClaimRuleOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetLinkOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetProfileOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetReportOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListApiKeysOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListClaimRulesOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListLinksOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListProfilesOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListServiceIdsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.LockApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.LockServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileClaimRule;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileClaimRuleList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileLink;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileLinkList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.Report;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ReportReference;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ServiceId;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ServiceIdList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TrustedProfile;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TrustedProfilesList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UnlockApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UnlockServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateAccountSettingsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateClaimRuleOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateProfileOptions;
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
 * The IAM Identity Service API allows for the management of Account Settings and Identities (Service IDs, ApiKeys).
 *
 * API Version: 1.0.0
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
    if (getApiKeyOptions.includeActivity() != null) {
      builder.query("include_activity", String.valueOf(getApiKeyOptions.includeActivity()));
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
   * Deletes an API key. Existing tokens will remain valid until expired. Users can manage user API keys for themself,
   * or service ID API  keys for service IDs that are bound to an entity they have access  to.
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
   * that are bound to an entity they have access to. Note: apikey details are only included in the response when
   * creating a Service ID with an api key.
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
   * that are bound to an entity they have access to. Note: apikey details are only included in the response when
   * creating a Service ID with an api key.
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
   * service IDs that are bound to an entity they have access to. Note: apikey details are only included in the response
   * when  creating a Service ID with an api key.
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
    if (getServiceIdOptions.includeActivity() != null) {
      builder.query("include_activity", String.valueOf(getServiceIdOptions.includeActivity()));
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
   * service ID API keys for service IDs that are bound to an entity they have access to.   Note: apikey details are
   * only included in the response when creating a  Service ID with an apikey.
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

  /**
   * Create a trusted profile.
   *
   * Create a trusted profile for a given account ID.
   *
   * @param createProfileOptions the {@link CreateProfileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link TrustedProfile}
   */
  public ServiceCall<TrustedProfile> createProfile(CreateProfileOptions createProfileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createProfileOptions,
      "createProfileOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/profiles"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "createProfile");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", createProfileOptions.name());
    contentJson.addProperty("account_id", createProfileOptions.accountId());
    if (createProfileOptions.description() != null) {
      contentJson.addProperty("description", createProfileOptions.description());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<TrustedProfile> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<TrustedProfile>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List trusted profiles.
   *
   * List the trusted profiles in an account. The `account_id` query parameter determines the account from which to
   * retrieve the list of trusted profiles.
   *
   * @param listProfilesOptions the {@link ListProfilesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link TrustedProfilesList}
   */
  public ServiceCall<TrustedProfilesList> listProfiles(ListProfilesOptions listProfilesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listProfilesOptions,
      "listProfilesOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/profiles"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "listProfiles");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("account_id", String.valueOf(listProfilesOptions.accountId()));
    if (listProfilesOptions.name() != null) {
      builder.query("name", String.valueOf(listProfilesOptions.name()));
    }
    if (listProfilesOptions.pagesize() != null) {
      builder.query("pagesize", String.valueOf(listProfilesOptions.pagesize()));
    }
    if (listProfilesOptions.sort() != null) {
      builder.query("sort", String.valueOf(listProfilesOptions.sort()));
    }
    if (listProfilesOptions.order() != null) {
      builder.query("order", String.valueOf(listProfilesOptions.order()));
    }
    if (listProfilesOptions.includeHistory() != null) {
      builder.query("include_history", String.valueOf(listProfilesOptions.includeHistory()));
    }
    if (listProfilesOptions.pagetoken() != null) {
      builder.query("pagetoken", String.valueOf(listProfilesOptions.pagetoken()));
    }
    ResponseConverter<TrustedProfilesList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<TrustedProfilesList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a trusted profile.
   *
   * Retrieve a trusted profile by its `profile-id`. Only the trusted profile's data is returned (`name`, `description`,
   * `iam_id`, etc.), not the federated users or compute resources that qualify to apply the trusted profile.
   *
   * @param getProfileOptions the {@link GetProfileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link TrustedProfile}
   */
  public ServiceCall<TrustedProfile> getProfile(GetProfileOptions getProfileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getProfileOptions,
      "getProfileOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profile-id", getProfileOptions.profileId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/profiles/{profile-id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "getProfile");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getProfileOptions.includeActivity() != null) {
      builder.query("include_activity", String.valueOf(getProfileOptions.includeActivity()));
    }
    ResponseConverter<TrustedProfile> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<TrustedProfile>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a trusted profile.
   *
   * Update the name or description of an existing trusted profile.
   *
   * @param updateProfileOptions the {@link UpdateProfileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link TrustedProfile}
   */
  public ServiceCall<TrustedProfile> updateProfile(UpdateProfileOptions updateProfileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateProfileOptions,
      "updateProfileOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profile-id", updateProfileOptions.profileId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/profiles/{profile-id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "updateProfile");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("If-Match", updateProfileOptions.ifMatch());
    final JsonObject contentJson = new JsonObject();
    if (updateProfileOptions.name() != null) {
      contentJson.addProperty("name", updateProfileOptions.name());
    }
    if (updateProfileOptions.description() != null) {
      contentJson.addProperty("description", updateProfileOptions.description());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<TrustedProfile> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<TrustedProfile>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a trusted profile.
   *
   * Delete a trusted profile. When you delete trusted profile, compute resources and federated users are unlinked from
   * the profile and can no longer apply the trusted profile identity.
   *
   * @param deleteProfileOptions the {@link DeleteProfileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteProfile(DeleteProfileOptions deleteProfileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteProfileOptions,
      "deleteProfileOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profile-id", deleteProfileOptions.profileId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/profiles/{profile-id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "deleteProfile");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create claim rule for a trusted profile.
   *
   * Create a claim rule for a trusted profile. There is a limit of 20 rules per trusted profile.
   *
   * @param createClaimRuleOptions the {@link CreateClaimRuleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProfileClaimRule}
   */
  public ServiceCall<ProfileClaimRule> createClaimRule(CreateClaimRuleOptions createClaimRuleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createClaimRuleOptions,
      "createClaimRuleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profile-id", createClaimRuleOptions.profileId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/profiles/{profile-id}/rules", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "createClaimRule");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("type", createClaimRuleOptions.type());
    contentJson.add("conditions", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createClaimRuleOptions.conditions()));
    if (createClaimRuleOptions.context() != null) {
      contentJson.add("context", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createClaimRuleOptions.context()));
    }
    if (createClaimRuleOptions.name() != null) {
      contentJson.addProperty("name", createClaimRuleOptions.name());
    }
    if (createClaimRuleOptions.realmName() != null) {
      contentJson.addProperty("realm_name", createClaimRuleOptions.realmName());
    }
    if (createClaimRuleOptions.crType() != null) {
      contentJson.addProperty("cr_type", createClaimRuleOptions.crType());
    }
    if (createClaimRuleOptions.expiration() != null) {
      contentJson.addProperty("expiration", createClaimRuleOptions.expiration());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ProfileClaimRule> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProfileClaimRule>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List claim rules for a trusted profile.
   *
   * Get a list of all claim rules for a trusted profile. The `profile-id` query parameter determines the profile from
   * which to retrieve the list of claim rules.
   *
   * @param listClaimRulesOptions the {@link ListClaimRulesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProfileClaimRuleList}
   */
  public ServiceCall<ProfileClaimRuleList> listClaimRules(ListClaimRulesOptions listClaimRulesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listClaimRulesOptions,
      "listClaimRulesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profile-id", listClaimRulesOptions.profileId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/profiles/{profile-id}/rules", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "listClaimRules");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ProfileClaimRuleList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProfileClaimRuleList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a claim rule for a trusted profile.
   *
   * A specific claim rule can be fetched for a given trusted profile ID and rule ID.
   *
   * @param getClaimRuleOptions the {@link GetClaimRuleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProfileClaimRule}
   */
  public ServiceCall<ProfileClaimRule> getClaimRule(GetClaimRuleOptions getClaimRuleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getClaimRuleOptions,
      "getClaimRuleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profile-id", getClaimRuleOptions.profileId());
    pathParamsMap.put("rule-id", getClaimRuleOptions.ruleId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/profiles/{profile-id}/rules/{rule-id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "getClaimRule");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ProfileClaimRule> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProfileClaimRule>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update claim rule for a trusted profile.
   *
   * Update a specific claim rule for a given trusted profile ID and rule ID.
   *
   * @param updateClaimRuleOptions the {@link UpdateClaimRuleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProfileClaimRule}
   */
  public ServiceCall<ProfileClaimRule> updateClaimRule(UpdateClaimRuleOptions updateClaimRuleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateClaimRuleOptions,
      "updateClaimRuleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profile-id", updateClaimRuleOptions.profileId());
    pathParamsMap.put("rule-id", updateClaimRuleOptions.ruleId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/profiles/{profile-id}/rules/{rule-id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "updateClaimRule");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("If-Match", updateClaimRuleOptions.ifMatch());
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("type", updateClaimRuleOptions.type());
    contentJson.add("conditions", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateClaimRuleOptions.conditions()));
    if (updateClaimRuleOptions.context() != null) {
      contentJson.add("context", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateClaimRuleOptions.context()));
    }
    if (updateClaimRuleOptions.name() != null) {
      contentJson.addProperty("name", updateClaimRuleOptions.name());
    }
    if (updateClaimRuleOptions.realmName() != null) {
      contentJson.addProperty("realm_name", updateClaimRuleOptions.realmName());
    }
    if (updateClaimRuleOptions.crType() != null) {
      contentJson.addProperty("cr_type", updateClaimRuleOptions.crType());
    }
    if (updateClaimRuleOptions.expiration() != null) {
      contentJson.addProperty("expiration", updateClaimRuleOptions.expiration());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ProfileClaimRule> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProfileClaimRule>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a claim rule.
   *
   * Delete a claim rule. When you delete a claim rule, federated user or compute resources are no longer required to
   * meet the conditions of the claim rule in order to apply the trusted profile.
   *
   * @param deleteClaimRuleOptions the {@link DeleteClaimRuleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteClaimRule(DeleteClaimRuleOptions deleteClaimRuleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteClaimRuleOptions,
      "deleteClaimRuleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profile-id", deleteClaimRuleOptions.profileId());
    pathParamsMap.put("rule-id", deleteClaimRuleOptions.ruleId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/profiles/{profile-id}/rules/{rule-id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "deleteClaimRule");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create link to a trusted profile.
   *
   * Create a direct link between a specific compute resource and a trusted profile, rather than creating conditions
   * that a compute resource must fulfill to apply a trusted profile.
   *
   * @param createLinkOptions the {@link CreateLinkOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProfileLink}
   */
  public ServiceCall<ProfileLink> createLink(CreateLinkOptions createLinkOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createLinkOptions,
      "createLinkOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profile-id", createLinkOptions.profileId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/profiles/{profile-id}/links", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "createLink");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("cr_type", createLinkOptions.crType());
    contentJson.add("link", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createLinkOptions.link()));
    if (createLinkOptions.name() != null) {
      contentJson.addProperty("name", createLinkOptions.name());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ProfileLink> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProfileLink>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List links to a trusted profile.
   *
   * Get a list of links to a trusted profile.
   *
   * @param listLinksOptions the {@link ListLinksOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProfileLinkList}
   */
  public ServiceCall<ProfileLinkList> listLinks(ListLinksOptions listLinksOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listLinksOptions,
      "listLinksOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profile-id", listLinksOptions.profileId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/profiles/{profile-id}/links", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "listLinks");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ProfileLinkList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProfileLinkList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get link to a trusted profile.
   *
   * Get a specific link to a trusted profile by `link_id`.
   *
   * @param getLinkOptions the {@link GetLinkOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProfileLink}
   */
  public ServiceCall<ProfileLink> getLink(GetLinkOptions getLinkOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getLinkOptions,
      "getLinkOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profile-id", getLinkOptions.profileId());
    pathParamsMap.put("link-id", getLinkOptions.linkId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/profiles/{profile-id}/links/{link-id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "getLink");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ProfileLink> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProfileLink>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete link to a trusted profile.
   *
   * Delete a link between a compute resource and a trusted profile.
   *
   * @param deleteLinkOptions the {@link DeleteLinkOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteLink(DeleteLinkOptions deleteLinkOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteLinkOptions,
      "deleteLinkOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("profile-id", deleteLinkOptions.profileId());
    pathParamsMap.put("link-id", deleteLinkOptions.linkId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/profiles/{profile-id}/links/{link-id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "deleteLink");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get account configurations.
   *
   * Returns the details of an account's configuration.
   *
   * @param getAccountSettingsOptions the {@link GetAccountSettingsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AccountSettingsResponse}
   */
  public ServiceCall<AccountSettingsResponse> getAccountSettings(GetAccountSettingsOptions getAccountSettingsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getAccountSettingsOptions,
      "getAccountSettingsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", getAccountSettingsOptions.accountId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/accounts/{account_id}/settings/identity", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "getAccountSettings");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getAccountSettingsOptions.includeHistory() != null) {
      builder.query("include_history", String.valueOf(getAccountSettingsOptions.includeHistory()));
    }
    ResponseConverter<AccountSettingsResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AccountSettingsResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update account configurations.
   *
   * Allows a user to configure settings on their account with regards to MFA, session lifetimes,  access control for
   * creating new identities, and enforcing IP restrictions on  token creation.
   *
   * @param updateAccountSettingsOptions the {@link UpdateAccountSettingsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AccountSettingsResponse}
   */
  public ServiceCall<AccountSettingsResponse> updateAccountSettings(UpdateAccountSettingsOptions updateAccountSettingsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateAccountSettingsOptions,
      "updateAccountSettingsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", updateAccountSettingsOptions.accountId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/accounts/{account_id}/settings/identity", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "updateAccountSettings");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("If-Match", updateAccountSettingsOptions.ifMatch());
    final JsonObject contentJson = new JsonObject();
    if (updateAccountSettingsOptions.restrictCreateServiceId() != null) {
      contentJson.addProperty("restrict_create_service_id", updateAccountSettingsOptions.restrictCreateServiceId());
    }
    if (updateAccountSettingsOptions.restrictCreatePlatformApikey() != null) {
      contentJson.addProperty("restrict_create_platform_apikey", updateAccountSettingsOptions.restrictCreatePlatformApikey());
    }
    if (updateAccountSettingsOptions.allowedIpAddresses() != null) {
      contentJson.addProperty("allowed_ip_addresses", updateAccountSettingsOptions.allowedIpAddresses());
    }
    if (updateAccountSettingsOptions.mfa() != null) {
      contentJson.addProperty("mfa", updateAccountSettingsOptions.mfa());
    }
    if (updateAccountSettingsOptions.sessionExpirationInSeconds() != null) {
      contentJson.addProperty("session_expiration_in_seconds", updateAccountSettingsOptions.sessionExpirationInSeconds());
    }
    if (updateAccountSettingsOptions.sessionInvalidationInSeconds() != null) {
      contentJson.addProperty("session_invalidation_in_seconds", updateAccountSettingsOptions.sessionInvalidationInSeconds());
    }
    if (updateAccountSettingsOptions.maxSessionsPerIdentity() != null) {
      contentJson.addProperty("max_sessions_per_identity", updateAccountSettingsOptions.maxSessionsPerIdentity());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<AccountSettingsResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AccountSettingsResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Trigger activity report across on account scope.
   *
   * Trigger activity report across on account scope for a given accountid.
   *
   * @param createReportOptions the {@link CreateReportOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ReportReference}
   */
  public ServiceCall<ReportReference> createReport(CreateReportOptions createReportOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createReportOptions,
      "createReportOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", createReportOptions.accountId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/activity/accounts/{account_id}/report", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "createReport");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createReportOptions.type() != null) {
      builder.query("type", String.valueOf(createReportOptions.type()));
    }
    if (createReportOptions.duration() != null) {
      builder.query("duration", String.valueOf(createReportOptions.duration()));
    }
    ResponseConverter<ReportReference> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ReportReference>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get activity report across on account scope.
   *
   * Get activity report across on account scope for a given accountid.
   *
   * @param getReportOptions the {@link GetReportOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Report}
   */
  public ServiceCall<Report> getReport(GetReportOptions getReportOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getReportOptions,
      "getReportOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", getReportOptions.accountId());
    pathParamsMap.put("reference", getReportOptions.reference());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/activity/accounts/{account_id}/report/{reference}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_identity", "v1", "getReport");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Report> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Report>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}
