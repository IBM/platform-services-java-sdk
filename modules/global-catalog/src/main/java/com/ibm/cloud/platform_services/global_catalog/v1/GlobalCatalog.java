/*
 * (C) Copyright IBM Corp. 2025.
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
 * IBM OpenAPI SDK Code Generator Version: 3.106.0-09823488-20250707-071701
 */

package com.ibm.cloud.platform_services.global_catalog.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Artifacts;
import com.ibm.cloud.platform_services.global_catalog.v1.model.AuditSearchResult;
import com.ibm.cloud.platform_services.global_catalog.v1.model.CatalogEntry;
import com.ibm.cloud.platform_services.global_catalog.v1.model.CreateCatalogEntryOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.DeleteArtifactOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.DeleteCatalogEntryOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.EntrySearchResult;
import com.ibm.cloud.platform_services.global_catalog.v1.model.GetArtifactOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.GetAuditLogsOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.GetCatalogEntryOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.GetChildObjectsOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.GetPricingDeploymentsOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.GetPricingOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.GetVisibilityOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ListArtifactsOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ListCatalogEntriesOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.PricingGet;
import com.ibm.cloud.platform_services.global_catalog.v1.model.PricingSearchResult;
import com.ibm.cloud.platform_services.global_catalog.v1.model.RestoreCatalogEntryOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.UpdateCatalogEntryOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.UpdateVisibilityOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.UploadArtifactOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Visibility;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * The catalog service manages offerings across geographies as the system of record. The catalog supports a RESTful API
 * where users can retrieve information about existing offerings and create, manage, and delete their offerings. Start
 * with the base URL and use the endpoints to retrieve metadata about services in the catalog and manage service
 * visbility. Depending on the kind of object, the metadata can include information about pricing, provisioning,
 * regions, and more. For more information, see the [catalog
 * documentation](https://cloud.ibm.com/docs/overview/catalog.html#global-catalog-overview).
 *
 * API Version: 1.0.3
 */
public class GlobalCatalog extends BaseService {

  /**
   * Default service name used when configuring the `GlobalCatalog` client.
   */
  public static final String DEFAULT_SERVICE_NAME = "global_catalog";

  /**
   * Default service endpoint URL.
   */
  public static final String DEFAULT_SERVICE_URL = "https://globalcatalog.cloud.ibm.com/api/v1";

 /**
   * Class method which constructs an instance of the `GlobalCatalog` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `GlobalCatalog` client using external configuration
   */
  public static GlobalCatalog newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `GlobalCatalog` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `GlobalCatalog` client using external configuration
   */
  public static GlobalCatalog newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    GlobalCatalog service = new GlobalCatalog(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `GlobalCatalog` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public GlobalCatalog(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * Returns parent catalog entries.
   *
   * Includes key information, such as ID, name, kind, CRN, tags, and provider. This endpoint is ETag enabled.
   *
   * @param listCatalogEntriesOptions the {@link ListCatalogEntriesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link EntrySearchResult}
   */
  public ServiceCall<EntrySearchResult> listCatalogEntries(ListCatalogEntriesOptions listCatalogEntriesOptions) {
    if (listCatalogEntriesOptions == null) {
      listCatalogEntriesOptions = new ListCatalogEntriesOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("global_catalog", "v1", "listCatalogEntries");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listCatalogEntriesOptions.account() != null) {
      builder.query("account", String.valueOf(listCatalogEntriesOptions.account()));
    }
    if (listCatalogEntriesOptions.include() != null) {
      builder.query("include", String.valueOf(listCatalogEntriesOptions.include()));
    }
    if (listCatalogEntriesOptions.q() != null) {
      builder.query("q", String.valueOf(listCatalogEntriesOptions.q()));
    }
    if (listCatalogEntriesOptions.sortBy() != null) {
      builder.query("sort-by", String.valueOf(listCatalogEntriesOptions.sortBy()));
    }
    if (listCatalogEntriesOptions.descending() != null) {
      builder.query("descending", String.valueOf(listCatalogEntriesOptions.descending()));
    }
    if (listCatalogEntriesOptions.languages() != null) {
      builder.query("languages", String.valueOf(listCatalogEntriesOptions.languages()));
    }
    if (listCatalogEntriesOptions.catalog() != null) {
      builder.query("catalog", String.valueOf(listCatalogEntriesOptions.catalog()));
    }
    if (listCatalogEntriesOptions.complete() != null) {
      builder.query("complete", String.valueOf(listCatalogEntriesOptions.complete()));
    }
    if (listCatalogEntriesOptions.offset() != null) {
      builder.query("_offset", String.valueOf(listCatalogEntriesOptions.offset()));
    }
    if (listCatalogEntriesOptions.limit() != null) {
      builder.query("_limit", String.valueOf(listCatalogEntriesOptions.limit()));
    }
    ResponseConverter<EntrySearchResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<EntrySearchResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Returns parent catalog entries.
   *
   * Includes key information, such as ID, name, kind, CRN, tags, and provider. This endpoint is ETag enabled.
   *
   * @return a {@link ServiceCall} with a result of type {@link EntrySearchResult}
   */
  public ServiceCall<EntrySearchResult> listCatalogEntries() {
    return listCatalogEntries(null);
  }

  /**
   * Create a catalog entry.
   *
   * The created catalog entry is restricted by default. You must have an administrator or editor role in the scope of
   * the provided token. This API will return an ETag that can be used for standard ETag processing, except when depth
   * query is used.
   *
   * @param createCatalogEntryOptions the {@link CreateCatalogEntryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CatalogEntry}
   */
  public ServiceCall<CatalogEntry> createCatalogEntry(CreateCatalogEntryOptions createCatalogEntryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createCatalogEntryOptions,
      "createCatalogEntryOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("global_catalog", "v1", "createCatalogEntry");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createCatalogEntryOptions.account() != null) {
      builder.query("account", String.valueOf(createCatalogEntryOptions.account()));
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", createCatalogEntryOptions.name());
    contentJson.addProperty("kind", createCatalogEntryOptions.kind());
    contentJson.add("overview_ui", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createCatalogEntryOptions.overviewUi()));
    contentJson.add("images", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createCatalogEntryOptions.images()));
    contentJson.addProperty("disabled", createCatalogEntryOptions.disabled());
    contentJson.add("tags", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createCatalogEntryOptions.tags()));
    contentJson.add("provider", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createCatalogEntryOptions.provider()));
    contentJson.addProperty("id", createCatalogEntryOptions.id());
    if (createCatalogEntryOptions.parentId() != null) {
      contentJson.addProperty("parent_id", createCatalogEntryOptions.parentId());
    }
    if (createCatalogEntryOptions.group() != null) {
      contentJson.addProperty("group", createCatalogEntryOptions.group());
    }
    if (createCatalogEntryOptions.active() != null) {
      contentJson.addProperty("active", createCatalogEntryOptions.active());
    }
    if (createCatalogEntryOptions.url() != null) {
      contentJson.addProperty("url", createCatalogEntryOptions.url());
    }
    if (createCatalogEntryOptions.metadata() != null) {
      contentJson.add("metadata", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createCatalogEntryOptions.metadata()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<CatalogEntry> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CatalogEntry>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a specific catalog object.
   *
   * This endpoint returns a specific catalog entry using the object's unique identifier, for example
   * `/_*service_name*?complete=true`. This endpoint is ETag enabled. This can be used by an unauthenticated user for
   * publicly available services.
   *
   * @param getCatalogEntryOptions the {@link GetCatalogEntryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CatalogEntry}
   */
  public ServiceCall<CatalogEntry> getCatalogEntry(GetCatalogEntryOptions getCatalogEntryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getCatalogEntryOptions,
      "getCatalogEntryOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", getCatalogEntryOptions.id());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("global_catalog", "v1", "getCatalogEntry");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getCatalogEntryOptions.account() != null) {
      builder.query("account", String.valueOf(getCatalogEntryOptions.account()));
    }
    if (getCatalogEntryOptions.include() != null) {
      builder.query("include", String.valueOf(getCatalogEntryOptions.include()));
    }
    if (getCatalogEntryOptions.languages() != null) {
      builder.query("languages", String.valueOf(getCatalogEntryOptions.languages()));
    }
    if (getCatalogEntryOptions.complete() != null) {
      builder.query("complete", String.valueOf(getCatalogEntryOptions.complete()));
    }
    if (getCatalogEntryOptions.depth() != null) {
      builder.query("depth", String.valueOf(getCatalogEntryOptions.depth()));
    }
    ResponseConverter<CatalogEntry> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CatalogEntry>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a catalog entry.
   *
   * Update a catalog entry. The visibility of the catalog entry cannot be modified with this endpoint. You must be an
   * administrator or editor in the scope of the provided token. This endpoint is ETag enabled.
   *
   * @param updateCatalogEntryOptions the {@link UpdateCatalogEntryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CatalogEntry}
   */
  public ServiceCall<CatalogEntry> updateCatalogEntry(UpdateCatalogEntryOptions updateCatalogEntryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateCatalogEntryOptions,
      "updateCatalogEntryOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", updateCatalogEntryOptions.id());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("global_catalog", "v1", "updateCatalogEntry");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (updateCatalogEntryOptions.account() != null) {
      builder.query("account", String.valueOf(updateCatalogEntryOptions.account()));
    }
    if (updateCatalogEntryOptions.move() != null) {
      builder.query("move", String.valueOf(updateCatalogEntryOptions.move()));
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", updateCatalogEntryOptions.name());
    contentJson.addProperty("kind", updateCatalogEntryOptions.kind());
    contentJson.add("overview_ui", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateCatalogEntryOptions.overviewUi()));
    contentJson.add("images", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateCatalogEntryOptions.images()));
    contentJson.addProperty("disabled", updateCatalogEntryOptions.disabled());
    contentJson.add("tags", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateCatalogEntryOptions.tags()));
    contentJson.add("provider", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateCatalogEntryOptions.provider()));
    if (updateCatalogEntryOptions.parentId() != null) {
      contentJson.addProperty("parent_id", updateCatalogEntryOptions.parentId());
    }
    if (updateCatalogEntryOptions.group() != null) {
      contentJson.addProperty("group", updateCatalogEntryOptions.group());
    }
    if (updateCatalogEntryOptions.active() != null) {
      contentJson.addProperty("active", updateCatalogEntryOptions.active());
    }
    if (updateCatalogEntryOptions.url() != null) {
      contentJson.addProperty("url", updateCatalogEntryOptions.url());
    }
    if (updateCatalogEntryOptions.metadata() != null) {
      contentJson.add("metadata", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateCatalogEntryOptions.metadata()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<CatalogEntry> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CatalogEntry>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a catalog entry.
   *
   * Delete a catalog entry. This will archive the catalog entry for a minimum of two weeks. While archived, it can be
   * restored using the PUT restore API. After two weeks, it will be deleted and cannot be restored. You must have
   * administrator role in the scope of the provided token to modify it. This endpoint is ETag enabled.
   *
   * @param deleteCatalogEntryOptions the {@link DeleteCatalogEntryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteCatalogEntry(DeleteCatalogEntryOptions deleteCatalogEntryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteCatalogEntryOptions,
      "deleteCatalogEntryOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", deleteCatalogEntryOptions.id());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("global_catalog", "v1", "deleteCatalogEntry");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (deleteCatalogEntryOptions.account() != null) {
      builder.query("account", String.valueOf(deleteCatalogEntryOptions.account()));
    }
    if (deleteCatalogEntryOptions.force() != null) {
      builder.query("force", String.valueOf(deleteCatalogEntryOptions.force()));
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get child catalog entries of a specific kind.
   *
   * Fetch child catalog entries for a catalog entry with a specific id. This endpoint is ETag enabled. This can be used
   * by an unauthenticated user for publicly available services.
   *
   * @param getChildObjectsOptions the {@link GetChildObjectsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link EntrySearchResult}
   */
  public ServiceCall<EntrySearchResult> getChildObjects(GetChildObjectsOptions getChildObjectsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getChildObjectsOptions,
      "getChildObjectsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", getChildObjectsOptions.id());
    pathParamsMap.put("kind", getChildObjectsOptions.kind());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{id}/{kind}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("global_catalog", "v1", "getChildObjects");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getChildObjectsOptions.account() != null) {
      builder.query("account", String.valueOf(getChildObjectsOptions.account()));
    }
    if (getChildObjectsOptions.include() != null) {
      builder.query("include", String.valueOf(getChildObjectsOptions.include()));
    }
    if (getChildObjectsOptions.q() != null) {
      builder.query("q", String.valueOf(getChildObjectsOptions.q()));
    }
    if (getChildObjectsOptions.sortBy() != null) {
      builder.query("sort-by", String.valueOf(getChildObjectsOptions.sortBy()));
    }
    if (getChildObjectsOptions.descending() != null) {
      builder.query("descending", String.valueOf(getChildObjectsOptions.descending()));
    }
    if (getChildObjectsOptions.languages() != null) {
      builder.query("languages", String.valueOf(getChildObjectsOptions.languages()));
    }
    if (getChildObjectsOptions.complete() != null) {
      builder.query("complete", String.valueOf(getChildObjectsOptions.complete()));
    }
    if (getChildObjectsOptions.offset() != null) {
      builder.query("_offset", String.valueOf(getChildObjectsOptions.offset()));
    }
    if (getChildObjectsOptions.limit() != null) {
      builder.query("_limit", String.valueOf(getChildObjectsOptions.limit()));
    }
    ResponseConverter<EntrySearchResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<EntrySearchResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Restore archived catalog entry.
   *
   * Restore an archived catalog entry. You must have an administrator role in the scope of the provided token.
   *
   * @param restoreCatalogEntryOptions the {@link RestoreCatalogEntryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> restoreCatalogEntry(RestoreCatalogEntryOptions restoreCatalogEntryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(restoreCatalogEntryOptions,
      "restoreCatalogEntryOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", restoreCatalogEntryOptions.id());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{id}/restore", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("global_catalog", "v1", "restoreCatalogEntry");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (restoreCatalogEntryOptions.account() != null) {
      builder.query("account", String.valueOf(restoreCatalogEntryOptions.account()));
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get the visibility constraints for an object.
   *
   * This endpoint returns the visibility rules for this object. Overall visibility is determined by the parent objects
   * and any further restrictions on this object. You must have an administrator role in the scope of the provided
   * token. This endpoint is ETag enabled.
   *
   * @param getVisibilityOptions the {@link GetVisibilityOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Visibility}
   */
  public ServiceCall<Visibility> getVisibility(GetVisibilityOptions getVisibilityOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getVisibilityOptions,
      "getVisibilityOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", getVisibilityOptions.id());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{id}/visibility", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("global_catalog", "v1", "getVisibility");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getVisibilityOptions.account() != null) {
      builder.query("account", String.valueOf(getVisibilityOptions.account()));
    }
    ResponseConverter<Visibility> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Visibility>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update visibility.
   *
   * Update an Object's Visibility. You must have an administrator role in the scope of the provided token. This
   * endpoint is ETag enabled.
   *
   * @param updateVisibilityOptions the {@link UpdateVisibilityOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> updateVisibility(UpdateVisibilityOptions updateVisibilityOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateVisibilityOptions,
      "updateVisibilityOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", updateVisibilityOptions.id());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{id}/visibility", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("global_catalog", "v1", "updateVisibility");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (updateVisibilityOptions.account() != null) {
      builder.query("account", String.valueOf(updateVisibilityOptions.account()));
    }
    final JsonObject contentJson = new JsonObject();
    if (updateVisibilityOptions.restrictions() != null) {
      contentJson.addProperty("restrictions", updateVisibilityOptions.restrictions());
    }
    if (updateVisibilityOptions.extendable() != null) {
      contentJson.addProperty("extendable", updateVisibilityOptions.extendable());
    }
    if (updateVisibilityOptions.include() != null) {
      contentJson.add("include", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateVisibilityOptions.include()));
    }
    if (updateVisibilityOptions.exclude() != null) {
      contentJson.add("exclude", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateVisibilityOptions.exclude()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get the pricing for an object.
   *
   * This endpoint returns the pricing for an object. Static pricing is defined in the catalog. Dynamic pricing is
   * stored in IBM Cloud Pricing Catalog. This can be used by an unauthenticated user for publicly available services.
   *
   * @param getPricingOptions the {@link GetPricingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PricingGet}
   */
  public ServiceCall<PricingGet> getPricing(GetPricingOptions getPricingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getPricingOptions,
      "getPricingOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", getPricingOptions.id());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{id}/pricing", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("global_catalog", "v1", "getPricing");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getPricingOptions.account() != null) {
      builder.query("account", String.valueOf(getPricingOptions.account()));
    }
    if (getPricingOptions.deploymentRegion() != null) {
      builder.query("deployment_region", String.valueOf(getPricingOptions.deploymentRegion()));
    }
    ResponseConverter<PricingGet> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PricingGet>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get the pricing deployments for a plan.
   *
   * This endpoint returns the deployment pricing for a plan. For a plan it returns a pricing for each visible child
   * deployment object. Static pricing is defined in the catalog. Dynamic pricing is stored in IBM Cloud Pricing
   * Catalog. This can be used by an unauthenticated user for publicly available services.
   *
   * @param getPricingDeploymentsOptions the {@link GetPricingDeploymentsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PricingSearchResult}
   */
  public ServiceCall<PricingSearchResult> getPricingDeployments(GetPricingDeploymentsOptions getPricingDeploymentsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getPricingDeploymentsOptions,
      "getPricingDeploymentsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", getPricingDeploymentsOptions.id());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{id}/pricing/deployment", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("global_catalog", "v1", "getPricingDeployments");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getPricingDeploymentsOptions.account() != null) {
      builder.query("account", String.valueOf(getPricingDeploymentsOptions.account()));
    }
    ResponseConverter<PricingSearchResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PricingSearchResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get the audit logs for an object.
   *
   * This endpoint returns the audit logs for an object. Only administrators and editors can get logs.
   *
   * @param getAuditLogsOptions the {@link GetAuditLogsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AuditSearchResult}
   */
  public ServiceCall<AuditSearchResult> getAuditLogs(GetAuditLogsOptions getAuditLogsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getAuditLogsOptions,
      "getAuditLogsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("id", getAuditLogsOptions.id());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{id}/logs", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("global_catalog", "v1", "getAuditLogs");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getAuditLogsOptions.account() != null) {
      builder.query("account", String.valueOf(getAuditLogsOptions.account()));
    }
    if (getAuditLogsOptions.ascending() != null) {
      builder.query("ascending", String.valueOf(getAuditLogsOptions.ascending()));
    }
    if (getAuditLogsOptions.startat() != null) {
      builder.query("startat", String.valueOf(getAuditLogsOptions.startat()));
    }
    if (getAuditLogsOptions.offset() != null) {
      builder.query("_offset", String.valueOf(getAuditLogsOptions.offset()));
    }
    if (getAuditLogsOptions.limit() != null) {
      builder.query("_limit", String.valueOf(getAuditLogsOptions.limit()));
    }
    ResponseConverter<AuditSearchResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AuditSearchResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get artifacts.
   *
   * This endpoint returns a list of artifacts for an object.
   *
   * @param listArtifactsOptions the {@link ListArtifactsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Artifacts}
   */
  public ServiceCall<Artifacts> listArtifacts(ListArtifactsOptions listArtifactsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listArtifactsOptions,
      "listArtifactsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("object_id", listArtifactsOptions.objectId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{object_id}/artifacts", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("global_catalog", "v1", "listArtifacts");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listArtifactsOptions.account() != null) {
      builder.query("account", String.valueOf(listArtifactsOptions.account()));
    }
    ResponseConverter<Artifacts> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Artifacts>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get artifact.
   *
   * This endpoint returns the binary of an artifact.
   *
   * @param getArtifactOptions the {@link GetArtifactOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> getArtifact(GetArtifactOptions getArtifactOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getArtifactOptions,
      "getArtifactOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("object_id", getArtifactOptions.objectId());
    pathParamsMap.put("artifact_id", getArtifactOptions.artifactId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{object_id}/artifacts/{artifact_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("global_catalog", "v1", "getArtifact");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (getArtifactOptions.accept() != null) {
      builder.header("Accept", getArtifactOptions.accept());
    }
    if (getArtifactOptions.account() != null) {
      builder.query("account", String.valueOf(getArtifactOptions.account()));
    }
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Upload artifact.
   *
   * This endpoint uploads the binary for an artifact. Only administrators and editors can upload artifacts.
   *
   * @param uploadArtifactOptions the {@link UploadArtifactOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> uploadArtifact(UploadArtifactOptions uploadArtifactOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(uploadArtifactOptions,
      "uploadArtifactOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("object_id", uploadArtifactOptions.objectId());
    pathParamsMap.put("artifact_id", uploadArtifactOptions.artifactId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{object_id}/artifacts/{artifact_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("global_catalog", "v1", "uploadArtifact");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (uploadArtifactOptions.contentType() != null) {
      builder.header("Content-Type", uploadArtifactOptions.contentType());
    }
    if (uploadArtifactOptions.account() != null) {
      builder.query("account", String.valueOf(uploadArtifactOptions.account()));
    }
    builder.bodyContent(uploadArtifactOptions.contentType(), null,
      null, uploadArtifactOptions.artifact());
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete artifact.
   *
   * This endpoint deletes an artifact. Only administrators and editors can delete artifacts.
   *
   * @param deleteArtifactOptions the {@link DeleteArtifactOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteArtifact(DeleteArtifactOptions deleteArtifactOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteArtifactOptions,
      "deleteArtifactOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("object_id", deleteArtifactOptions.objectId());
    pathParamsMap.put("artifact_id", deleteArtifactOptions.artifactId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/{object_id}/artifacts/{artifact_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("global_catalog", "v1", "deleteArtifact");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (deleteArtifactOptions.account() != null) {
      builder.query("account", String.valueOf(deleteArtifactOptions.account()));
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

}
