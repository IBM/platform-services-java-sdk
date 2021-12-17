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
 * IBM OpenAPI SDK Code Generator Version: 3.43.0-49eab5c7-20211117-152138
 */

package com.ibm.cloud.platform_services.catalog_management.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.platform_services.catalog_management.v1.model.AccessListBulkResponse;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Account;
import com.ibm.cloud.platform_services.catalog_management.v1.model.AccountPublishObjectOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.AccountPublishVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.AccumulatedFilters;
import com.ibm.cloud.platform_services.catalog_management.v1.model.AddObjectAccessListOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ApprovalResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.AuditLog;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Catalog;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CatalogObject;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CatalogSearchResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ClusterInfo;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CommitVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CopyVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateCatalogOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateObjectAccessOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateObjectOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateOfferingInstanceOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteCatalogOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteObjectAccessListOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteObjectAccessOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteObjectOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteOfferingInstanceOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteOperatorsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeployOperatorsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeprecateOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeprecateVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetCatalogAccountAuditOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetCatalogAccountFiltersOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetCatalogAccountOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetCatalogAuditOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetCatalogOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetClusterOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetConsumptionOfferingsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetNamespacesOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetObjectAccessListOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetObjectAccessOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetObjectAuditOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetObjectOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingAboutOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingAuditOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingContainerImagesOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingInstanceOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingLicenseOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingSourceOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingUpdatesOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingWorkingCopyOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOverrideValuesOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetPreinstallOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetValidationStatusOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.IbmPublishObjectOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.IbmPublishVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ImageManifest;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ImportOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ImportOfferingVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.InstallStatus;
import com.ibm.cloud.platform_services.catalog_management.v1.model.InstallVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ListCatalogsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ListObjectsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ListOfferingsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ListOperatorsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.NamespaceSearchResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ObjectAccess;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ObjectAccessListResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ObjectListResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ObjectSearchResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Offering;
import com.ibm.cloud.platform_services.catalog_management.v1.model.OfferingInstance;
import com.ibm.cloud.platform_services.catalog_management.v1.model.OfferingSearchResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.OperatorDeployResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.PreinstallVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.PublicPublishObjectOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.PublicPublishVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.PutOfferingInstanceOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReloadOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceCatalogOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceObjectOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceOfferingIconOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceOperatorsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SearchObjectsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SetDeprecateVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SharedPublishObjectOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.UpdateCatalogAccountOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.UpdateOfferingIbmOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.UpdateOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ValidateInstallOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Validation;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Version;
import com.ibm.cloud.platform_services.catalog_management.v1.model.VersionUpdateDescriptor;
import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * This is the API to use for managing private catalogs for IBM Cloud. Private catalogs provide a way to centrally
 * manage access to products in the IBM Cloud catalog and your own catalogs.
 *
 * API Version: 1.0
 */
public class CatalogManagement extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "catalog_management";

  public static final String DEFAULT_SERVICE_URL = "https://cm.globalcatalog.cloud.ibm.com/api/v1-beta";

 /**
   * Class method which constructs an instance of the `CatalogManagement` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `CatalogManagement` client using external configuration
   */
  public static CatalogManagement newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `CatalogManagement` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `CatalogManagement` client using external configuration
   */
  public static CatalogManagement newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    CatalogManagement service = new CatalogManagement(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `CatalogManagement` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public CatalogManagement(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * Get catalog account settings.
   *
   * Get the account level settings for the account for private catalog.
   *
   * @param getCatalogAccountOptions the {@link GetCatalogAccountOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Account}
   */
  public ServiceCall<Account> getCatalogAccount(GetCatalogAccountOptions getCatalogAccountOptions) {
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogaccount"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getCatalogAccount");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Account> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Account>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get catalog account settings.
   *
   * Get the account level settings for the account for private catalog.
   *
   * @return a {@link ServiceCall} with a result of type {@link Account}
   */
  public ServiceCall<Account> getCatalogAccount() {
    return getCatalogAccount(null);
  }

  /**
   * Update account settings.
   *
   * Update the account level settings for the account for private catalog.
   *
   * @param updateCatalogAccountOptions the {@link UpdateCatalogAccountOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> updateCatalogAccount(UpdateCatalogAccountOptions updateCatalogAccountOptions) {
    boolean skipBody = false;
    if (updateCatalogAccountOptions == null) {
      updateCatalogAccountOptions = new UpdateCatalogAccountOptions.Builder().build();
      skipBody = true;
    }
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogaccount"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "updateCatalogAccount");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (!skipBody) {
      final JsonObject contentJson = new JsonObject();
      if (updateCatalogAccountOptions.id() != null) {
        contentJson.addProperty("id", updateCatalogAccountOptions.id());
      }
      if (updateCatalogAccountOptions.hideIbmCloudCatalog() != null) {
        contentJson.addProperty("hide_IBM_cloud_catalog", updateCatalogAccountOptions.hideIbmCloudCatalog());
      }
      if (updateCatalogAccountOptions.accountFilters() != null) {
        contentJson.add("account_filters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateCatalogAccountOptions.accountFilters()));
      }
      builder.bodyJson(contentJson);
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update account settings.
   *
   * Update the account level settings for the account for private catalog.
   *
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> updateCatalogAccount() {
    return updateCatalogAccount(null);
  }

  /**
   * Get catalog account audit log.
   *
   * Get the audit log associated with a catalog account.
   *
   * @param getCatalogAccountAuditOptions the {@link GetCatalogAccountAuditOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AuditLog}
   */
  public ServiceCall<AuditLog> getCatalogAccountAudit(GetCatalogAccountAuditOptions getCatalogAccountAuditOptions) {
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogaccount/audit"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getCatalogAccountAudit");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<AuditLog> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AuditLog>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get catalog account audit log.
   *
   * Get the audit log associated with a catalog account.
   *
   * @return a {@link ServiceCall} with a result of type {@link AuditLog}
   */
  public ServiceCall<AuditLog> getCatalogAccountAudit() {
    return getCatalogAccountAudit(null);
  }

  /**
   * Get catalog account filters.
   *
   * Get the accumulated filters of the account and of the catalogs you have access to.
   *
   * @param getCatalogAccountFiltersOptions the {@link GetCatalogAccountFiltersOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AccumulatedFilters}
   */
  public ServiceCall<AccumulatedFilters> getCatalogAccountFilters(GetCatalogAccountFiltersOptions getCatalogAccountFiltersOptions) {
    if (getCatalogAccountFiltersOptions == null) {
      getCatalogAccountFiltersOptions = new GetCatalogAccountFiltersOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogaccount/filters"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getCatalogAccountFilters");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getCatalogAccountFiltersOptions.catalog() != null) {
      builder.query("catalog", String.valueOf(getCatalogAccountFiltersOptions.catalog()));
    }
    ResponseConverter<AccumulatedFilters> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AccumulatedFilters>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get catalog account filters.
   *
   * Get the accumulated filters of the account and of the catalogs you have access to.
   *
   * @return a {@link ServiceCall} with a result of type {@link AccumulatedFilters}
   */
  public ServiceCall<AccumulatedFilters> getCatalogAccountFilters() {
    return getCatalogAccountFilters(null);
  }

  /**
   * Get list of catalogs.
   *
   * Retrieves the available catalogs for a given account. This can be used by an unauthenticated user to retrieve the
   * public catalog.
   *
   * @param listCatalogsOptions the {@link ListCatalogsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CatalogSearchResult}
   */
  public ServiceCall<CatalogSearchResult> listCatalogs(ListCatalogsOptions listCatalogsOptions) {
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "listCatalogs");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<CatalogSearchResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CatalogSearchResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get list of catalogs.
   *
   * Retrieves the available catalogs for a given account. This can be used by an unauthenticated user to retrieve the
   * public catalog.
   *
   * @return a {@link ServiceCall} with a result of type {@link CatalogSearchResult}
   */
  public ServiceCall<CatalogSearchResult> listCatalogs() {
    return listCatalogs(null);
  }

  /**
   * Create a catalog.
   *
   * Create a catalog for a given account.
   *
   * @param createCatalogOptions the {@link CreateCatalogOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Catalog}
   */
  public ServiceCall<Catalog> createCatalog(CreateCatalogOptions createCatalogOptions) {
    boolean skipBody = false;
    if (createCatalogOptions == null) {
      createCatalogOptions = new CreateCatalogOptions.Builder().build();
      skipBody = true;
    }
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "createCatalog");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (!skipBody) {
      final JsonObject contentJson = new JsonObject();
      if (createCatalogOptions.id() != null) {
        contentJson.addProperty("id", createCatalogOptions.id());
      }
      if (createCatalogOptions.rev() != null) {
        contentJson.addProperty("_rev", createCatalogOptions.rev());
      }
      if (createCatalogOptions.label() != null) {
        contentJson.addProperty("label", createCatalogOptions.label());
      }
      if (createCatalogOptions.shortDescription() != null) {
        contentJson.addProperty("short_description", createCatalogOptions.shortDescription());
      }
      if (createCatalogOptions.catalogIconUrl() != null) {
        contentJson.addProperty("catalog_icon_url", createCatalogOptions.catalogIconUrl());
      }
      if (createCatalogOptions.tags() != null) {
        contentJson.add("tags", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createCatalogOptions.tags()));
      }
      if (createCatalogOptions.features() != null) {
        contentJson.add("features", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createCatalogOptions.features()));
      }
      if (createCatalogOptions.disabled() != null) {
        contentJson.addProperty("disabled", createCatalogOptions.disabled());
      }
      if (createCatalogOptions.resourceGroupId() != null) {
        contentJson.addProperty("resource_group_id", createCatalogOptions.resourceGroupId());
      }
      if (createCatalogOptions.owningAccount() != null) {
        contentJson.addProperty("owning_account", createCatalogOptions.owningAccount());
      }
      if (createCatalogOptions.catalogFilters() != null) {
        contentJson.add("catalog_filters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createCatalogOptions.catalogFilters()));
      }
      if (createCatalogOptions.syndicationSettings() != null) {
        contentJson.add("syndication_settings", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createCatalogOptions.syndicationSettings()));
      }
      if (createCatalogOptions.kind() != null) {
        contentJson.addProperty("kind", createCatalogOptions.kind());
      }
      builder.bodyJson(contentJson);
    }
    ResponseConverter<Catalog> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Catalog>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a catalog.
   *
   * Create a catalog for a given account.
   *
   * @return a {@link ServiceCall} with a result of type {@link Catalog}
   */
  public ServiceCall<Catalog> createCatalog() {
    return createCatalog(null);
  }

  /**
   * Get catalog.
   *
   * Get a catalog. This can also be used by an unauthenticated user to get the public catalog.
   *
   * @param getCatalogOptions the {@link GetCatalogOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Catalog}
   */
  public ServiceCall<Catalog> getCatalog(GetCatalogOptions getCatalogOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getCatalogOptions,
      "getCatalogOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", getCatalogOptions.catalogIdentifier());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getCatalog");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Catalog> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Catalog>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update catalog.
   *
   * Update a catalog.
   *
   * @param replaceCatalogOptions the {@link ReplaceCatalogOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Catalog}
   */
  public ServiceCall<Catalog> replaceCatalog(ReplaceCatalogOptions replaceCatalogOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceCatalogOptions,
      "replaceCatalogOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", replaceCatalogOptions.catalogIdentifier());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "replaceCatalog");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (replaceCatalogOptions.id() != null) {
      contentJson.addProperty("id", replaceCatalogOptions.id());
    }
    if (replaceCatalogOptions.rev() != null) {
      contentJson.addProperty("_rev", replaceCatalogOptions.rev());
    }
    if (replaceCatalogOptions.label() != null) {
      contentJson.addProperty("label", replaceCatalogOptions.label());
    }
    if (replaceCatalogOptions.shortDescription() != null) {
      contentJson.addProperty("short_description", replaceCatalogOptions.shortDescription());
    }
    if (replaceCatalogOptions.catalogIconUrl() != null) {
      contentJson.addProperty("catalog_icon_url", replaceCatalogOptions.catalogIconUrl());
    }
    if (replaceCatalogOptions.tags() != null) {
      contentJson.add("tags", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceCatalogOptions.tags()));
    }
    if (replaceCatalogOptions.features() != null) {
      contentJson.add("features", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceCatalogOptions.features()));
    }
    if (replaceCatalogOptions.disabled() != null) {
      contentJson.addProperty("disabled", replaceCatalogOptions.disabled());
    }
    if (replaceCatalogOptions.resourceGroupId() != null) {
      contentJson.addProperty("resource_group_id", replaceCatalogOptions.resourceGroupId());
    }
    if (replaceCatalogOptions.owningAccount() != null) {
      contentJson.addProperty("owning_account", replaceCatalogOptions.owningAccount());
    }
    if (replaceCatalogOptions.catalogFilters() != null) {
      contentJson.add("catalog_filters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceCatalogOptions.catalogFilters()));
    }
    if (replaceCatalogOptions.syndicationSettings() != null) {
      contentJson.add("syndication_settings", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceCatalogOptions.syndicationSettings()));
    }
    if (replaceCatalogOptions.kind() != null) {
      contentJson.addProperty("kind", replaceCatalogOptions.kind());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Catalog> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Catalog>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete catalog.
   *
   * Delete a catalog.
   *
   * @param deleteCatalogOptions the {@link DeleteCatalogOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteCatalog(DeleteCatalogOptions deleteCatalogOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteCatalogOptions,
      "deleteCatalogOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", deleteCatalogOptions.catalogIdentifier());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "deleteCatalog");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get catalog audit log.
   *
   * Get the audit log associated with a catalog.
   *
   * @param getCatalogAuditOptions the {@link GetCatalogAuditOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AuditLog}
   */
  public ServiceCall<AuditLog> getCatalogAudit(GetCatalogAuditOptions getCatalogAuditOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getCatalogAuditOptions,
      "getCatalogAuditOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", getCatalogAuditOptions.catalogIdentifier());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/audit", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getCatalogAudit");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<AuditLog> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AuditLog>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get consumption offerings.
   *
   * Retrieve the available offerings from both public and from the account that currently scoped for consumption. These
   * copies cannot be used for updating. They are not complete and only return what is visible to the caller. This can
   * be used by an unauthenticated user to retreive publicly available offerings.
   *
   * @param getConsumptionOfferingsOptions the {@link GetConsumptionOfferingsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link OfferingSearchResult}
   */
  public ServiceCall<OfferingSearchResult> getConsumptionOfferings(GetConsumptionOfferingsOptions getConsumptionOfferingsOptions) {
    if (getConsumptionOfferingsOptions == null) {
      getConsumptionOfferingsOptions = new GetConsumptionOfferingsOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/offerings"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getConsumptionOfferings");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getConsumptionOfferingsOptions.digest() != null) {
      builder.query("digest", String.valueOf(getConsumptionOfferingsOptions.digest()));
    }
    if (getConsumptionOfferingsOptions.catalog() != null) {
      builder.query("catalog", String.valueOf(getConsumptionOfferingsOptions.catalog()));
    }
    if (getConsumptionOfferingsOptions.select() != null) {
      builder.query("select", String.valueOf(getConsumptionOfferingsOptions.select()));
    }
    if (getConsumptionOfferingsOptions.includeHidden() != null) {
      builder.query("includeHidden", String.valueOf(getConsumptionOfferingsOptions.includeHidden()));
    }
    if (getConsumptionOfferingsOptions.limit() != null) {
      builder.query("limit", String.valueOf(getConsumptionOfferingsOptions.limit()));
    }
    if (getConsumptionOfferingsOptions.offset() != null) {
      builder.query("offset", String.valueOf(getConsumptionOfferingsOptions.offset()));
    }
    ResponseConverter<OfferingSearchResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<OfferingSearchResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get consumption offerings.
   *
   * Retrieve the available offerings from both public and from the account that currently scoped for consumption. These
   * copies cannot be used for updating. They are not complete and only return what is visible to the caller. This can
   * be used by an unauthenticated user to retreive publicly available offerings.
   *
   * @return a {@link ServiceCall} with a result of type {@link OfferingSearchResult}
   */
  public ServiceCall<OfferingSearchResult> getConsumptionOfferings() {
    return getConsumptionOfferings(null);
  }

  /**
   * Get list of offerings.
   *
   * Retrieve the available offerings in the specified catalog. This can also be used by an unauthenticated user to
   * retreive publicly available offerings.
   *
   * @param listOfferingsOptions the {@link ListOfferingsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link OfferingSearchResult}
   */
  public ServiceCall<OfferingSearchResult> listOfferings(ListOfferingsOptions listOfferingsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listOfferingsOptions,
      "listOfferingsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", listOfferingsOptions.catalogIdentifier());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/offerings", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "listOfferings");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listOfferingsOptions.digest() != null) {
      builder.query("digest", String.valueOf(listOfferingsOptions.digest()));
    }
    if (listOfferingsOptions.limit() != null) {
      builder.query("limit", String.valueOf(listOfferingsOptions.limit()));
    }
    if (listOfferingsOptions.offset() != null) {
      builder.query("offset", String.valueOf(listOfferingsOptions.offset()));
    }
    if (listOfferingsOptions.name() != null) {
      builder.query("name", String.valueOf(listOfferingsOptions.name()));
    }
    if (listOfferingsOptions.sort() != null) {
      builder.query("sort", String.valueOf(listOfferingsOptions.sort()));
    }
    ResponseConverter<OfferingSearchResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<OfferingSearchResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create offering.
   *
   * Create an offering.
   *
   * @param createOfferingOptions the {@link CreateOfferingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Offering}
   */
  public ServiceCall<Offering> createOffering(CreateOfferingOptions createOfferingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createOfferingOptions,
      "createOfferingOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", createOfferingOptions.catalogIdentifier());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/offerings", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "createOffering");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (createOfferingOptions.id() != null) {
      contentJson.addProperty("id", createOfferingOptions.id());
    }
    if (createOfferingOptions.rev() != null) {
      contentJson.addProperty("_rev", createOfferingOptions.rev());
    }
    if (createOfferingOptions.url() != null) {
      contentJson.addProperty("url", createOfferingOptions.url());
    }
    if (createOfferingOptions.crn() != null) {
      contentJson.addProperty("crn", createOfferingOptions.crn());
    }
    if (createOfferingOptions.label() != null) {
      contentJson.addProperty("label", createOfferingOptions.label());
    }
    if (createOfferingOptions.name() != null) {
      contentJson.addProperty("name", createOfferingOptions.name());
    }
    if (createOfferingOptions.offeringIconUrl() != null) {
      contentJson.addProperty("offering_icon_url", createOfferingOptions.offeringIconUrl());
    }
    if (createOfferingOptions.offeringDocsUrl() != null) {
      contentJson.addProperty("offering_docs_url", createOfferingOptions.offeringDocsUrl());
    }
    if (createOfferingOptions.offeringSupportUrl() != null) {
      contentJson.addProperty("offering_support_url", createOfferingOptions.offeringSupportUrl());
    }
    if (createOfferingOptions.tags() != null) {
      contentJson.add("tags", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createOfferingOptions.tags()));
    }
    if (createOfferingOptions.keywords() != null) {
      contentJson.add("keywords", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createOfferingOptions.keywords()));
    }
    if (createOfferingOptions.rating() != null) {
      contentJson.add("rating", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createOfferingOptions.rating()));
    }
    if (createOfferingOptions.created() != null) {
      contentJson.add("created", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createOfferingOptions.created()));
    }
    if (createOfferingOptions.updated() != null) {
      contentJson.add("updated", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createOfferingOptions.updated()));
    }
    if (createOfferingOptions.shortDescription() != null) {
      contentJson.addProperty("short_description", createOfferingOptions.shortDescription());
    }
    if (createOfferingOptions.longDescription() != null) {
      contentJson.addProperty("long_description", createOfferingOptions.longDescription());
    }
    if (createOfferingOptions.features() != null) {
      contentJson.add("features", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createOfferingOptions.features()));
    }
    if (createOfferingOptions.kinds() != null) {
      contentJson.add("kinds", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createOfferingOptions.kinds()));
    }
    if (createOfferingOptions.permitRequestIbmPublicPublish() != null) {
      contentJson.addProperty("permit_request_ibm_public_publish", createOfferingOptions.permitRequestIbmPublicPublish());
    }
    if (createOfferingOptions.ibmPublishApproved() != null) {
      contentJson.addProperty("ibm_publish_approved", createOfferingOptions.ibmPublishApproved());
    }
    if (createOfferingOptions.publicPublishApproved() != null) {
      contentJson.addProperty("public_publish_approved", createOfferingOptions.publicPublishApproved());
    }
    if (createOfferingOptions.publicOriginalCrn() != null) {
      contentJson.addProperty("public_original_crn", createOfferingOptions.publicOriginalCrn());
    }
    if (createOfferingOptions.publishPublicCrn() != null) {
      contentJson.addProperty("publish_public_crn", createOfferingOptions.publishPublicCrn());
    }
    if (createOfferingOptions.portalApprovalRecord() != null) {
      contentJson.addProperty("portal_approval_record", createOfferingOptions.portalApprovalRecord());
    }
    if (createOfferingOptions.portalUiUrl() != null) {
      contentJson.addProperty("portal_ui_url", createOfferingOptions.portalUiUrl());
    }
    if (createOfferingOptions.catalogId() != null) {
      contentJson.addProperty("catalog_id", createOfferingOptions.catalogId());
    }
    if (createOfferingOptions.catalogName() != null) {
      contentJson.addProperty("catalog_name", createOfferingOptions.catalogName());
    }
    if (createOfferingOptions.metadata() != null) {
      contentJson.add("metadata", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createOfferingOptions.metadata()));
    }
    if (createOfferingOptions.disclaimer() != null) {
      contentJson.addProperty("disclaimer", createOfferingOptions.disclaimer());
    }
    if (createOfferingOptions.hidden() != null) {
      contentJson.addProperty("hidden", createOfferingOptions.hidden());
    }
    if (createOfferingOptions.provider() != null) {
      contentJson.addProperty("provider", createOfferingOptions.provider());
    }
    if (createOfferingOptions.providerInfo() != null) {
      contentJson.add("provider_info", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createOfferingOptions.providerInfo()));
    }
    if (createOfferingOptions.repoInfo() != null) {
      contentJson.add("repo_info", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createOfferingOptions.repoInfo()));
    }
    if (createOfferingOptions.support() != null) {
      contentJson.add("support", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createOfferingOptions.support()));
    }
    if (createOfferingOptions.media() != null) {
      contentJson.add("media", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createOfferingOptions.media()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Offering> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Offering>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Import offering version.
   *
   * Import new version to offering from a tgz.
   *
   * @param importOfferingVersionOptions the {@link ImportOfferingVersionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Offering}
   */
  public ServiceCall<Offering> importOfferingVersion(ImportOfferingVersionOptions importOfferingVersionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(importOfferingVersionOptions,
      "importOfferingVersionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", importOfferingVersionOptions.catalogIdentifier());
    pathParamsMap.put("offering_id", importOfferingVersionOptions.offeringId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/offerings/{offering_id}/version", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "importOfferingVersion");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (importOfferingVersionOptions.zipurl() != null) {
      builder.query("zipurl", String.valueOf(importOfferingVersionOptions.zipurl()));
    }
    if (importOfferingVersionOptions.targetVersion() != null) {
      builder.query("targetVersion", String.valueOf(importOfferingVersionOptions.targetVersion()));
    }
    if (importOfferingVersionOptions.includeConfig() != null) {
      builder.query("includeConfig", String.valueOf(importOfferingVersionOptions.includeConfig()));
    }
    if (importOfferingVersionOptions.isVsi() != null) {
      builder.query("isVSI", String.valueOf(importOfferingVersionOptions.isVsi()));
    }
    if (importOfferingVersionOptions.repoType() != null) {
      builder.query("repoType", String.valueOf(importOfferingVersionOptions.repoType()));
    }
    final JsonObject contentJson = new JsonObject();
    if (importOfferingVersionOptions.tags() != null) {
      contentJson.add("tags", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(importOfferingVersionOptions.tags()));
    }
    if (importOfferingVersionOptions.targetKinds() != null) {
      contentJson.add("target_kinds", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(importOfferingVersionOptions.targetKinds()));
    }
    if (importOfferingVersionOptions.content() != null) {
      contentJson.add("content", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(importOfferingVersionOptions.content()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Offering> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Offering>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Import offering.
   *
   * Import a new offering from a tgz.
   *
   * @param importOfferingOptions the {@link ImportOfferingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Offering}
   */
  public ServiceCall<Offering> importOffering(ImportOfferingOptions importOfferingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(importOfferingOptions,
      "importOfferingOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", importOfferingOptions.catalogIdentifier());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/import/offerings", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "importOffering");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (importOfferingOptions.xAuthToken() != null) {
      builder.header("X-Auth-Token", importOfferingOptions.xAuthToken());
    }
    if (importOfferingOptions.zipurl() != null) {
      builder.query("zipurl", String.valueOf(importOfferingOptions.zipurl()));
    }
    if (importOfferingOptions.offeringId() != null) {
      builder.query("offeringID", String.valueOf(importOfferingOptions.offeringId()));
    }
    if (importOfferingOptions.targetVersion() != null) {
      builder.query("targetVersion", String.valueOf(importOfferingOptions.targetVersion()));
    }
    if (importOfferingOptions.includeConfig() != null) {
      builder.query("includeConfig", String.valueOf(importOfferingOptions.includeConfig()));
    }
    if (importOfferingOptions.isVsi() != null) {
      builder.query("isVSI", String.valueOf(importOfferingOptions.isVsi()));
    }
    if (importOfferingOptions.repoType() != null) {
      builder.query("repoType", String.valueOf(importOfferingOptions.repoType()));
    }
    final JsonObject contentJson = new JsonObject();
    if (importOfferingOptions.tags() != null) {
      contentJson.add("tags", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(importOfferingOptions.tags()));
    }
    if (importOfferingOptions.targetKinds() != null) {
      contentJson.add("target_kinds", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(importOfferingOptions.targetKinds()));
    }
    if (importOfferingOptions.content() != null) {
      contentJson.add("content", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(importOfferingOptions.content()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Offering> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Offering>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Reload offering.
   *
   * Reload an existing version in offering from a tgz.
   *
   * @param reloadOfferingOptions the {@link ReloadOfferingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Offering}
   */
  public ServiceCall<Offering> reloadOffering(ReloadOfferingOptions reloadOfferingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(reloadOfferingOptions,
      "reloadOfferingOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", reloadOfferingOptions.catalogIdentifier());
    pathParamsMap.put("offering_id", reloadOfferingOptions.offeringId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/offerings/{offering_id}/reload", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "reloadOffering");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("targetVersion", String.valueOf(reloadOfferingOptions.targetVersion()));
    if (reloadOfferingOptions.zipurl() != null) {
      builder.query("zipurl", String.valueOf(reloadOfferingOptions.zipurl()));
    }
    if (reloadOfferingOptions.repoType() != null) {
      builder.query("repoType", String.valueOf(reloadOfferingOptions.repoType()));
    }
    final JsonObject contentJson = new JsonObject();
    if (reloadOfferingOptions.tags() != null) {
      contentJson.add("tags", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(reloadOfferingOptions.tags()));
    }
    if (reloadOfferingOptions.targetKinds() != null) {
      contentJson.add("target_kinds", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(reloadOfferingOptions.targetKinds()));
    }
    if (reloadOfferingOptions.content() != null) {
      contentJson.add("content", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(reloadOfferingOptions.content()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Offering> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Offering>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get offering.
   *
   * Get an offering. This can be used by an unauthenticated user for publicly available offerings.
   *
   * @param getOfferingOptions the {@link GetOfferingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Offering}
   */
  public ServiceCall<Offering> getOffering(GetOfferingOptions getOfferingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getOfferingOptions,
      "getOfferingOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", getOfferingOptions.catalogIdentifier());
    pathParamsMap.put("offering_id", getOfferingOptions.offeringId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/offerings/{offering_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getOffering");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getOfferingOptions.type() != null) {
      builder.query("type", String.valueOf(getOfferingOptions.type()));
    }
    if (getOfferingOptions.digest() != null) {
      builder.query("digest", String.valueOf(getOfferingOptions.digest()));
    }
    ResponseConverter<Offering> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Offering>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update offering.
   *
   * Update an offering.
   *
   * @param replaceOfferingOptions the {@link ReplaceOfferingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Offering}
   */
  public ServiceCall<Offering> replaceOffering(ReplaceOfferingOptions replaceOfferingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceOfferingOptions,
      "replaceOfferingOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", replaceOfferingOptions.catalogIdentifier());
    pathParamsMap.put("offering_id", replaceOfferingOptions.offeringId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/offerings/{offering_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "replaceOffering");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (replaceOfferingOptions.id() != null) {
      contentJson.addProperty("id", replaceOfferingOptions.id());
    }
    if (replaceOfferingOptions.rev() != null) {
      contentJson.addProperty("_rev", replaceOfferingOptions.rev());
    }
    if (replaceOfferingOptions.url() != null) {
      contentJson.addProperty("url", replaceOfferingOptions.url());
    }
    if (replaceOfferingOptions.crn() != null) {
      contentJson.addProperty("crn", replaceOfferingOptions.crn());
    }
    if (replaceOfferingOptions.label() != null) {
      contentJson.addProperty("label", replaceOfferingOptions.label());
    }
    if (replaceOfferingOptions.name() != null) {
      contentJson.addProperty("name", replaceOfferingOptions.name());
    }
    if (replaceOfferingOptions.offeringIconUrl() != null) {
      contentJson.addProperty("offering_icon_url", replaceOfferingOptions.offeringIconUrl());
    }
    if (replaceOfferingOptions.offeringDocsUrl() != null) {
      contentJson.addProperty("offering_docs_url", replaceOfferingOptions.offeringDocsUrl());
    }
    if (replaceOfferingOptions.offeringSupportUrl() != null) {
      contentJson.addProperty("offering_support_url", replaceOfferingOptions.offeringSupportUrl());
    }
    if (replaceOfferingOptions.tags() != null) {
      contentJson.add("tags", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceOfferingOptions.tags()));
    }
    if (replaceOfferingOptions.keywords() != null) {
      contentJson.add("keywords", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceOfferingOptions.keywords()));
    }
    if (replaceOfferingOptions.rating() != null) {
      contentJson.add("rating", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceOfferingOptions.rating()));
    }
    if (replaceOfferingOptions.created() != null) {
      contentJson.add("created", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceOfferingOptions.created()));
    }
    if (replaceOfferingOptions.updated() != null) {
      contentJson.add("updated", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceOfferingOptions.updated()));
    }
    if (replaceOfferingOptions.shortDescription() != null) {
      contentJson.addProperty("short_description", replaceOfferingOptions.shortDescription());
    }
    if (replaceOfferingOptions.longDescription() != null) {
      contentJson.addProperty("long_description", replaceOfferingOptions.longDescription());
    }
    if (replaceOfferingOptions.features() != null) {
      contentJson.add("features", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceOfferingOptions.features()));
    }
    if (replaceOfferingOptions.kinds() != null) {
      contentJson.add("kinds", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceOfferingOptions.kinds()));
    }
    if (replaceOfferingOptions.permitRequestIbmPublicPublish() != null) {
      contentJson.addProperty("permit_request_ibm_public_publish", replaceOfferingOptions.permitRequestIbmPublicPublish());
    }
    if (replaceOfferingOptions.ibmPublishApproved() != null) {
      contentJson.addProperty("ibm_publish_approved", replaceOfferingOptions.ibmPublishApproved());
    }
    if (replaceOfferingOptions.publicPublishApproved() != null) {
      contentJson.addProperty("public_publish_approved", replaceOfferingOptions.publicPublishApproved());
    }
    if (replaceOfferingOptions.publicOriginalCrn() != null) {
      contentJson.addProperty("public_original_crn", replaceOfferingOptions.publicOriginalCrn());
    }
    if (replaceOfferingOptions.publishPublicCrn() != null) {
      contentJson.addProperty("publish_public_crn", replaceOfferingOptions.publishPublicCrn());
    }
    if (replaceOfferingOptions.portalApprovalRecord() != null) {
      contentJson.addProperty("portal_approval_record", replaceOfferingOptions.portalApprovalRecord());
    }
    if (replaceOfferingOptions.portalUiUrl() != null) {
      contentJson.addProperty("portal_ui_url", replaceOfferingOptions.portalUiUrl());
    }
    if (replaceOfferingOptions.catalogId() != null) {
      contentJson.addProperty("catalog_id", replaceOfferingOptions.catalogId());
    }
    if (replaceOfferingOptions.catalogName() != null) {
      contentJson.addProperty("catalog_name", replaceOfferingOptions.catalogName());
    }
    if (replaceOfferingOptions.metadata() != null) {
      contentJson.add("metadata", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceOfferingOptions.metadata()));
    }
    if (replaceOfferingOptions.disclaimer() != null) {
      contentJson.addProperty("disclaimer", replaceOfferingOptions.disclaimer());
    }
    if (replaceOfferingOptions.hidden() != null) {
      contentJson.addProperty("hidden", replaceOfferingOptions.hidden());
    }
    if (replaceOfferingOptions.provider() != null) {
      contentJson.addProperty("provider", replaceOfferingOptions.provider());
    }
    if (replaceOfferingOptions.providerInfo() != null) {
      contentJson.add("provider_info", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceOfferingOptions.providerInfo()));
    }
    if (replaceOfferingOptions.repoInfo() != null) {
      contentJson.add("repo_info", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceOfferingOptions.repoInfo()));
    }
    if (replaceOfferingOptions.support() != null) {
      contentJson.add("support", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceOfferingOptions.support()));
    }
    if (replaceOfferingOptions.media() != null) {
      contentJson.add("media", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceOfferingOptions.media()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Offering> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Offering>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update offering.
   *
   * Update an offering.
   *
   * @param updateOfferingOptions the {@link UpdateOfferingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Offering}
   */
  public ServiceCall<Offering> updateOffering(UpdateOfferingOptions updateOfferingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateOfferingOptions,
      "updateOfferingOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", updateOfferingOptions.catalogIdentifier());
    pathParamsMap.put("offering_id", updateOfferingOptions.offeringId());
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/offerings/{offering_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "updateOffering");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("If-Match", updateOfferingOptions.ifMatch());
    if (updateOfferingOptions.updates() != null) {
      builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithoutPrettyPrinting().toJson(updateOfferingOptions.updates()), "application/json-patch+json");
    }
    ResponseConverter<Offering> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Offering>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete offering.
   *
   * Delete an offering.
   *
   * @param deleteOfferingOptions the {@link DeleteOfferingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteOffering(DeleteOfferingOptions deleteOfferingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteOfferingOptions,
      "deleteOfferingOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", deleteOfferingOptions.catalogIdentifier());
    pathParamsMap.put("offering_id", deleteOfferingOptions.offeringId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/offerings/{offering_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "deleteOffering");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get offering audit log.
   *
   * Get the audit log associated with an offering.
   *
   * @param getOfferingAuditOptions the {@link GetOfferingAuditOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AuditLog}
   */
  public ServiceCall<AuditLog> getOfferingAudit(GetOfferingAuditOptions getOfferingAuditOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getOfferingAuditOptions,
      "getOfferingAuditOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", getOfferingAuditOptions.catalogIdentifier());
    pathParamsMap.put("offering_id", getOfferingAuditOptions.offeringId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/offerings/{offering_id}/audit", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getOfferingAudit");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<AuditLog> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AuditLog>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Upload icon for offering.
   *
   * Upload an icon file to be stored in GC. File is uploaded as a binary payload - not as a form.
   *
   * @param replaceOfferingIconOptions the {@link ReplaceOfferingIconOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Offering}
   */
  public ServiceCall<Offering> replaceOfferingIcon(ReplaceOfferingIconOptions replaceOfferingIconOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceOfferingIconOptions,
      "replaceOfferingIconOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", replaceOfferingIconOptions.catalogIdentifier());
    pathParamsMap.put("offering_id", replaceOfferingIconOptions.offeringId());
    pathParamsMap.put("file_name", replaceOfferingIconOptions.fileName());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/offerings/{offering_id}/icon/{file_name}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "replaceOfferingIcon");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Offering> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Offering>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Allow offering to be published.
   *
   * Approve or disapprove the offering to be allowed to publish to the IBM Public Catalog. Options:
   * * `allow_request` - (Allow requesting to publish to IBM)
   * * `ibm` - (Allow publishing to be visible to IBM only)
   * * `public` - (Allow publishing to be visible to everyone, including IBM)
   *
   * If disapprove `public`, then `ibm` approval will not  be changed. If disapprove `ibm` then `public` will
   * automatically be disapproved. if disapprove `allow_request` then all rights to publish will be removed. This is
   * because the process steps always go first through `allow` to `ibm` and then to `public`. `ibm` cannot be skipped.
   * Only users with Approval IAM authority can use this. Approvers should use the catalog and offering id from the
   * public catalog since they wouldn't have access to the private offering.
   *
   * @param updateOfferingIbmOptions the {@link UpdateOfferingIbmOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApprovalResult}
   */
  public ServiceCall<ApprovalResult> updateOfferingIbm(UpdateOfferingIbmOptions updateOfferingIbmOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateOfferingIbmOptions,
      "updateOfferingIbmOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", updateOfferingIbmOptions.catalogIdentifier());
    pathParamsMap.put("offering_id", updateOfferingIbmOptions.offeringId());
    pathParamsMap.put("approval_type", updateOfferingIbmOptions.approvalType());
    pathParamsMap.put("approved", updateOfferingIbmOptions.approved());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/offerings/{offering_id}/publish/{approval_type}/{approved}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "updateOfferingIbm");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ApprovalResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApprovalResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Allows offering to be deprecated.
   *
   * Approve or disapprove the offering to be deprecated.
   *
   * @param deprecateOfferingOptions the {@link DeprecateOfferingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deprecateOffering(DeprecateOfferingOptions deprecateOfferingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deprecateOfferingOptions,
      "deprecateOfferingOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", deprecateOfferingOptions.catalogIdentifier());
    pathParamsMap.put("offering_id", deprecateOfferingOptions.offeringId());
    pathParamsMap.put("setting", deprecateOfferingOptions.setting());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/offerings/{offering_id}/deprecate/{setting}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "deprecateOffering");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    final JsonObject contentJson = new JsonObject();
    if (deprecateOfferingOptions.description() != null) {
      contentJson.addProperty("description", deprecateOfferingOptions.description());
    }
    if (deprecateOfferingOptions.daysUntilDeprecate() != null) {
      contentJson.addProperty("days_until_deprecate", deprecateOfferingOptions.daysUntilDeprecate());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get version updates.
   *
   * Get available updates for the specified version.
   *
   * @param getOfferingUpdatesOptions the {@link GetOfferingUpdatesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link List}
   */
  public ServiceCall<List<VersionUpdateDescriptor>> getOfferingUpdates(GetOfferingUpdatesOptions getOfferingUpdatesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getOfferingUpdatesOptions,
      "getOfferingUpdatesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", getOfferingUpdatesOptions.catalogIdentifier());
    pathParamsMap.put("offering_id", getOfferingUpdatesOptions.offeringId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/offerings/{offering_id}/updates", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getOfferingUpdates");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("X-Auth-Refresh-Token", getOfferingUpdatesOptions.xAuthRefreshToken());
    builder.query("kind", String.valueOf(getOfferingUpdatesOptions.kind()));
    if (getOfferingUpdatesOptions.target() != null) {
      builder.query("target", String.valueOf(getOfferingUpdatesOptions.target()));
    }
    if (getOfferingUpdatesOptions.version() != null) {
      builder.query("version", String.valueOf(getOfferingUpdatesOptions.version()));
    }
    if (getOfferingUpdatesOptions.clusterId() != null) {
      builder.query("cluster_id", String.valueOf(getOfferingUpdatesOptions.clusterId()));
    }
    if (getOfferingUpdatesOptions.region() != null) {
      builder.query("region", String.valueOf(getOfferingUpdatesOptions.region()));
    }
    if (getOfferingUpdatesOptions.resourceGroupId() != null) {
      builder.query("resource_group_id", String.valueOf(getOfferingUpdatesOptions.resourceGroupId()));
    }
    if (getOfferingUpdatesOptions.namespace() != null) {
      builder.query("namespace", String.valueOf(getOfferingUpdatesOptions.namespace()));
    }
    if (getOfferingUpdatesOptions.sha() != null) {
      builder.query("sha", String.valueOf(getOfferingUpdatesOptions.sha()));
    }
    if (getOfferingUpdatesOptions.channel() != null) {
      builder.query("channel", String.valueOf(getOfferingUpdatesOptions.channel()));
    }
    if (getOfferingUpdatesOptions.namespaces() != null) {
      builder.query("namespaces", RequestUtils.join(getOfferingUpdatesOptions.namespaces(), ","));
    }
    if (getOfferingUpdatesOptions.allNamespaces() != null) {
      builder.query("all_namespaces", String.valueOf(getOfferingUpdatesOptions.allNamespaces()));
    }
    ResponseConverter<List<VersionUpdateDescriptor>> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<List<VersionUpdateDescriptor>>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get offering source.
   *
   * Get an offering's source.  This request requires authorization, even for public offerings.
   *
   * @param getOfferingSourceOptions the {@link GetOfferingSourceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> getOfferingSource(GetOfferingSourceOptions getOfferingSourceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getOfferingSourceOptions,
      "getOfferingSourceOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/offering/source"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getOfferingSource");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (getOfferingSourceOptions.accept() != null) {
      builder.header("Accept", getOfferingSourceOptions.accept());
    }
    builder.query("version", String.valueOf(getOfferingSourceOptions.version()));
    if (getOfferingSourceOptions.catalogId() != null) {
      builder.query("catalogID", String.valueOf(getOfferingSourceOptions.catalogId()));
    }
    if (getOfferingSourceOptions.name() != null) {
      builder.query("name", String.valueOf(getOfferingSourceOptions.name()));
    }
    if (getOfferingSourceOptions.id() != null) {
      builder.query("id", String.valueOf(getOfferingSourceOptions.id()));
    }
    if (getOfferingSourceOptions.kind() != null) {
      builder.query("kind", String.valueOf(getOfferingSourceOptions.kind()));
    }
    if (getOfferingSourceOptions.channel() != null) {
      builder.query("channel", String.valueOf(getOfferingSourceOptions.channel()));
    }
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get version about information.
   *
   * Get the about information, in markdown, for the current version.
   *
   * @param getOfferingAboutOptions the {@link GetOfferingAboutOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link String}
   */
  public ServiceCall<String> getOfferingAbout(GetOfferingAboutOptions getOfferingAboutOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getOfferingAboutOptions,
      "getOfferingAboutOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("version_loc_id", getOfferingAboutOptions.versionLocId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/versions/{version_loc_id}/about", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getOfferingAbout");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "text/markdown");
    ResponseConverter<String> responseConverter = ResponseConverterUtils.getString();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get version license content.
   *
   * Get the license content for the specified license ID in the specified version.
   *
   * @param getOfferingLicenseOptions the {@link GetOfferingLicenseOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link String}
   */
  public ServiceCall<String> getOfferingLicense(GetOfferingLicenseOptions getOfferingLicenseOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getOfferingLicenseOptions,
      "getOfferingLicenseOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("version_loc_id", getOfferingLicenseOptions.versionLocId());
    pathParamsMap.put("license_id", getOfferingLicenseOptions.licenseId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/versions/{version_loc_id}/licenses/{license_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getOfferingLicense");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "text/plain");
    ResponseConverter<String> responseConverter = ResponseConverterUtils.getString();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get version's container images.
   *
   * Get the list of container images associated with the specified version. The "image_manifest_url" property of the
   * version should be the URL for the image manifest, and the operation will return that content.
   *
   * @param getOfferingContainerImagesOptions the {@link GetOfferingContainerImagesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ImageManifest}
   */
  public ServiceCall<ImageManifest> getOfferingContainerImages(GetOfferingContainerImagesOptions getOfferingContainerImagesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getOfferingContainerImagesOptions,
      "getOfferingContainerImagesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("version_loc_id", getOfferingContainerImagesOptions.versionLocId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/versions/{version_loc_id}/containerImages", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getOfferingContainerImages");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ImageManifest> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ImageManifest>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Deprecate version immediately.
   *
   * Deprecate the specified version.
   *
   * @param deprecateVersionOptions the {@link DeprecateVersionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deprecateVersion(DeprecateVersionOptions deprecateVersionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deprecateVersionOptions,
      "deprecateVersionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("version_loc_id", deprecateVersionOptions.versionLocId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/versions/{version_loc_id}/deprecate", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "deprecateVersion");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Sets version to be deprecated in a certain time period.
   *
   * Set or cancel the version to be deprecated.
   *
   * @param setDeprecateVersionOptions the {@link SetDeprecateVersionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> setDeprecateVersion(SetDeprecateVersionOptions setDeprecateVersionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(setDeprecateVersionOptions,
      "setDeprecateVersionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("version_loc_id", setDeprecateVersionOptions.versionLocId());
    pathParamsMap.put("setting", setDeprecateVersionOptions.setting());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/versions/{version_loc_id}/deprecate/{setting}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "setDeprecateVersion");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    final JsonObject contentJson = new JsonObject();
    if (setDeprecateVersionOptions.description() != null) {
      contentJson.addProperty("description", setDeprecateVersionOptions.description());
    }
    if (setDeprecateVersionOptions.daysUntilDeprecate() != null) {
      contentJson.addProperty("days_until_deprecate", setDeprecateVersionOptions.daysUntilDeprecate());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Publish version to account members.
   *
   * Publish the specified version so it is viewable by account members.
   *
   * @param accountPublishVersionOptions the {@link AccountPublishVersionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> accountPublishVersion(AccountPublishVersionOptions accountPublishVersionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(accountPublishVersionOptions,
      "accountPublishVersionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("version_loc_id", accountPublishVersionOptions.versionLocId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/versions/{version_loc_id}/account-publish", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "accountPublishVersion");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Publish version to IBMers in public catalog.
   *
   * Publish the specified version so that it is visible to IBMers in the public catalog.
   *
   * @param ibmPublishVersionOptions the {@link IbmPublishVersionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> ibmPublishVersion(IbmPublishVersionOptions ibmPublishVersionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(ibmPublishVersionOptions,
      "ibmPublishVersionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("version_loc_id", ibmPublishVersionOptions.versionLocId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/versions/{version_loc_id}/ibm-publish", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "ibmPublishVersion");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Publish version to all users in public catalog.
   *
   * Publish the specified version so it is visible to all users in the public catalog.
   *
   * @param publicPublishVersionOptions the {@link PublicPublishVersionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> publicPublishVersion(PublicPublishVersionOptions publicPublishVersionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(publicPublishVersionOptions,
      "publicPublishVersionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("version_loc_id", publicPublishVersionOptions.versionLocId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/versions/{version_loc_id}/public-publish", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "publicPublishVersion");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Commit version.
   *
   * Commit a working copy of the specified version.
   *
   * @param commitVersionOptions the {@link CommitVersionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> commitVersion(CommitVersionOptions commitVersionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(commitVersionOptions,
      "commitVersionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("version_loc_id", commitVersionOptions.versionLocId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/versions/{version_loc_id}/commit", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "commitVersion");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Copy version to new target kind.
   *
   * Copy the specified version to a new target kind within the same offering.
   *
   * @param copyVersionOptions the {@link CopyVersionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> copyVersion(CopyVersionOptions copyVersionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(copyVersionOptions,
      "copyVersionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("version_loc_id", copyVersionOptions.versionLocId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/versions/{version_loc_id}/copy", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "copyVersion");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    final JsonObject contentJson = new JsonObject();
    if (copyVersionOptions.tags() != null) {
      contentJson.add("tags", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(copyVersionOptions.tags()));
    }
    if (copyVersionOptions.targetKinds() != null) {
      contentJson.add("target_kinds", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(copyVersionOptions.targetKinds()));
    }
    if (copyVersionOptions.content() != null) {
      contentJson.add("content", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(copyVersionOptions.content()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create working copy of version.
   *
   * Create a working copy of the specified version.
   *
   * @param getOfferingWorkingCopyOptions the {@link GetOfferingWorkingCopyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Version}
   */
  public ServiceCall<Version> getOfferingWorkingCopy(GetOfferingWorkingCopyOptions getOfferingWorkingCopyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getOfferingWorkingCopyOptions,
      "getOfferingWorkingCopyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("version_loc_id", getOfferingWorkingCopyOptions.versionLocId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/versions/{version_loc_id}/workingcopy", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getOfferingWorkingCopy");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Version> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Version>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get offering/kind/version 'branch'.
   *
   * Get the Offering/Kind/Version 'branch' for the specified locator ID.
   *
   * @param getVersionOptions the {@link GetVersionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Offering}
   */
  public ServiceCall<Offering> getVersion(GetVersionOptions getVersionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getVersionOptions,
      "getVersionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("version_loc_id", getVersionOptions.versionLocId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/versions/{version_loc_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getVersion");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Offering> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Offering>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete version.
   *
   * Delete the specified version.  If the version is an active version with a working copy, the working copy will be
   * deleted as well.
   *
   * @param deleteVersionOptions the {@link DeleteVersionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteVersion(DeleteVersionOptions deleteVersionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteVersionOptions,
      "deleteVersionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("version_loc_id", deleteVersionOptions.versionLocId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/versions/{version_loc_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "deleteVersion");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get kubernetes cluster.
   *
   * Get the contents of the specified kubernetes cluster.
   *
   * @param getClusterOptions the {@link GetClusterOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ClusterInfo}
   */
  public ServiceCall<ClusterInfo> getCluster(GetClusterOptions getClusterOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getClusterOptions,
      "getClusterOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("cluster_id", getClusterOptions.clusterId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/deploy/kubernetes/clusters/{cluster_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getCluster");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("X-Auth-Refresh-Token", getClusterOptions.xAuthRefreshToken());
    builder.query("region", String.valueOf(getClusterOptions.region()));
    ResponseConverter<ClusterInfo> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ClusterInfo>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get cluster namespaces.
   *
   * Get the namespaces associated with the specified kubernetes cluster.
   *
   * @param getNamespacesOptions the {@link GetNamespacesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link NamespaceSearchResult}
   */
  public ServiceCall<NamespaceSearchResult> getNamespaces(GetNamespacesOptions getNamespacesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getNamespacesOptions,
      "getNamespacesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("cluster_id", getNamespacesOptions.clusterId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/deploy/kubernetes/clusters/{cluster_id}/namespaces", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getNamespaces");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("X-Auth-Refresh-Token", getNamespacesOptions.xAuthRefreshToken());
    builder.query("region", String.valueOf(getNamespacesOptions.region()));
    if (getNamespacesOptions.limit() != null) {
      builder.query("limit", String.valueOf(getNamespacesOptions.limit()));
    }
    if (getNamespacesOptions.offset() != null) {
      builder.query("offset", String.valueOf(getNamespacesOptions.offset()));
    }
    ResponseConverter<NamespaceSearchResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<NamespaceSearchResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Deploy operators.
   *
   * Deploy operators on a kubernetes cluster.
   *
   * @param deployOperatorsOptions the {@link DeployOperatorsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link List}
   */
  public ServiceCall<List<OperatorDeployResult>> deployOperators(DeployOperatorsOptions deployOperatorsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deployOperatorsOptions,
      "deployOperatorsOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/deploy/kubernetes/olm/operator"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "deployOperators");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("X-Auth-Refresh-Token", deployOperatorsOptions.xAuthRefreshToken());
    final JsonObject contentJson = new JsonObject();
    if (deployOperatorsOptions.clusterId() != null) {
      contentJson.addProperty("cluster_id", deployOperatorsOptions.clusterId());
    }
    if (deployOperatorsOptions.region() != null) {
      contentJson.addProperty("region", deployOperatorsOptions.region());
    }
    if (deployOperatorsOptions.namespaces() != null) {
      contentJson.add("namespaces", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(deployOperatorsOptions.namespaces()));
    }
    if (deployOperatorsOptions.allNamespaces() != null) {
      contentJson.addProperty("all_namespaces", deployOperatorsOptions.allNamespaces());
    }
    if (deployOperatorsOptions.versionLocatorId() != null) {
      contentJson.addProperty("version_locator_id", deployOperatorsOptions.versionLocatorId());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<List<OperatorDeployResult>> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<List<OperatorDeployResult>>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List operators.
   *
   * List the operators from a kubernetes cluster.
   *
   * @param listOperatorsOptions the {@link ListOperatorsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link List}
   */
  public ServiceCall<List<OperatorDeployResult>> listOperators(ListOperatorsOptions listOperatorsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listOperatorsOptions,
      "listOperatorsOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/deploy/kubernetes/olm/operator"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "listOperators");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("X-Auth-Refresh-Token", listOperatorsOptions.xAuthRefreshToken());
    builder.query("cluster_id", String.valueOf(listOperatorsOptions.clusterId()));
    builder.query("region", String.valueOf(listOperatorsOptions.region()));
    builder.query("version_locator_id", String.valueOf(listOperatorsOptions.versionLocatorId()));
    ResponseConverter<List<OperatorDeployResult>> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<List<OperatorDeployResult>>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update operators.
   *
   * Update the operators on a kubernetes cluster.
   *
   * @param replaceOperatorsOptions the {@link ReplaceOperatorsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link List}
   */
  public ServiceCall<List<OperatorDeployResult>> replaceOperators(ReplaceOperatorsOptions replaceOperatorsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceOperatorsOptions,
      "replaceOperatorsOptions cannot be null");
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/deploy/kubernetes/olm/operator"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "replaceOperators");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("X-Auth-Refresh-Token", replaceOperatorsOptions.xAuthRefreshToken());
    final JsonObject contentJson = new JsonObject();
    if (replaceOperatorsOptions.clusterId() != null) {
      contentJson.addProperty("cluster_id", replaceOperatorsOptions.clusterId());
    }
    if (replaceOperatorsOptions.region() != null) {
      contentJson.addProperty("region", replaceOperatorsOptions.region());
    }
    if (replaceOperatorsOptions.namespaces() != null) {
      contentJson.add("namespaces", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceOperatorsOptions.namespaces()));
    }
    if (replaceOperatorsOptions.allNamespaces() != null) {
      contentJson.addProperty("all_namespaces", replaceOperatorsOptions.allNamespaces());
    }
    if (replaceOperatorsOptions.versionLocatorId() != null) {
      contentJson.addProperty("version_locator_id", replaceOperatorsOptions.versionLocatorId());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<List<OperatorDeployResult>> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<List<OperatorDeployResult>>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete operators.
   *
   * Delete operators from a kubernetes cluster.
   *
   * @param deleteOperatorsOptions the {@link DeleteOperatorsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteOperators(DeleteOperatorsOptions deleteOperatorsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteOperatorsOptions,
      "deleteOperatorsOptions cannot be null");
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/deploy/kubernetes/olm/operator"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "deleteOperators");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("X-Auth-Refresh-Token", deleteOperatorsOptions.xAuthRefreshToken());
    builder.query("cluster_id", String.valueOf(deleteOperatorsOptions.clusterId()));
    builder.query("region", String.valueOf(deleteOperatorsOptions.region()));
    builder.query("version_locator_id", String.valueOf(deleteOperatorsOptions.versionLocatorId()));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Install version.
   *
   * Create an install for the specified version.
   *
   * @param installVersionOptions the {@link InstallVersionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> installVersion(InstallVersionOptions installVersionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(installVersionOptions,
      "installVersionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("version_loc_id", installVersionOptions.versionLocId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/versions/{version_loc_id}/install", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "installVersion");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("X-Auth-Refresh-Token", installVersionOptions.xAuthRefreshToken());
    final JsonObject contentJson = new JsonObject();
    if (installVersionOptions.clusterId() != null) {
      contentJson.addProperty("cluster_id", installVersionOptions.clusterId());
    }
    if (installVersionOptions.region() != null) {
      contentJson.addProperty("region", installVersionOptions.region());
    }
    if (installVersionOptions.namespace() != null) {
      contentJson.addProperty("namespace", installVersionOptions.namespace());
    }
    if (installVersionOptions.overrideValues() != null) {
      contentJson.add("override_values", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(installVersionOptions.overrideValues()));
    }
    if (installVersionOptions.entitlementApikey() != null) {
      contentJson.addProperty("entitlement_apikey", installVersionOptions.entitlementApikey());
    }
    if (installVersionOptions.schematics() != null) {
      contentJson.add("schematics", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(installVersionOptions.schematics()));
    }
    if (installVersionOptions.script() != null) {
      contentJson.addProperty("script", installVersionOptions.script());
    }
    if (installVersionOptions.scriptId() != null) {
      contentJson.addProperty("script_id", installVersionOptions.scriptId());
    }
    if (installVersionOptions.versionLocatorId() != null) {
      contentJson.addProperty("version_locator_id", installVersionOptions.versionLocatorId());
    }
    if (installVersionOptions.vcenterId() != null) {
      contentJson.addProperty("vcenter_id", installVersionOptions.vcenterId());
    }
    if (installVersionOptions.vcenterUser() != null) {
      contentJson.addProperty("vcenter_user", installVersionOptions.vcenterUser());
    }
    if (installVersionOptions.vcenterPassword() != null) {
      contentJson.addProperty("vcenter_password", installVersionOptions.vcenterPassword());
    }
    if (installVersionOptions.vcenterLocation() != null) {
      contentJson.addProperty("vcenter_location", installVersionOptions.vcenterLocation());
    }
    if (installVersionOptions.vcenterDatastore() != null) {
      contentJson.addProperty("vcenter_datastore", installVersionOptions.vcenterDatastore());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Pre-install version.
   *
   * Create a pre-install for the specified version.
   *
   * @param preinstallVersionOptions the {@link PreinstallVersionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> preinstallVersion(PreinstallVersionOptions preinstallVersionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(preinstallVersionOptions,
      "preinstallVersionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("version_loc_id", preinstallVersionOptions.versionLocId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/versions/{version_loc_id}/preinstall", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "preinstallVersion");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("X-Auth-Refresh-Token", preinstallVersionOptions.xAuthRefreshToken());
    final JsonObject contentJson = new JsonObject();
    if (preinstallVersionOptions.clusterId() != null) {
      contentJson.addProperty("cluster_id", preinstallVersionOptions.clusterId());
    }
    if (preinstallVersionOptions.region() != null) {
      contentJson.addProperty("region", preinstallVersionOptions.region());
    }
    if (preinstallVersionOptions.namespace() != null) {
      contentJson.addProperty("namespace", preinstallVersionOptions.namespace());
    }
    if (preinstallVersionOptions.overrideValues() != null) {
      contentJson.add("override_values", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(preinstallVersionOptions.overrideValues()));
    }
    if (preinstallVersionOptions.entitlementApikey() != null) {
      contentJson.addProperty("entitlement_apikey", preinstallVersionOptions.entitlementApikey());
    }
    if (preinstallVersionOptions.schematics() != null) {
      contentJson.add("schematics", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(preinstallVersionOptions.schematics()));
    }
    if (preinstallVersionOptions.script() != null) {
      contentJson.addProperty("script", preinstallVersionOptions.script());
    }
    if (preinstallVersionOptions.scriptId() != null) {
      contentJson.addProperty("script_id", preinstallVersionOptions.scriptId());
    }
    if (preinstallVersionOptions.versionLocatorId() != null) {
      contentJson.addProperty("version_locator_id", preinstallVersionOptions.versionLocatorId());
    }
    if (preinstallVersionOptions.vcenterId() != null) {
      contentJson.addProperty("vcenter_id", preinstallVersionOptions.vcenterId());
    }
    if (preinstallVersionOptions.vcenterUser() != null) {
      contentJson.addProperty("vcenter_user", preinstallVersionOptions.vcenterUser());
    }
    if (preinstallVersionOptions.vcenterPassword() != null) {
      contentJson.addProperty("vcenter_password", preinstallVersionOptions.vcenterPassword());
    }
    if (preinstallVersionOptions.vcenterLocation() != null) {
      contentJson.addProperty("vcenter_location", preinstallVersionOptions.vcenterLocation());
    }
    if (preinstallVersionOptions.vcenterDatastore() != null) {
      contentJson.addProperty("vcenter_datastore", preinstallVersionOptions.vcenterDatastore());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get version pre-install status.
   *
   * Get the pre-install status for the specified version.
   *
   * @param getPreinstallOptions the {@link GetPreinstallOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InstallStatus}
   */
  public ServiceCall<InstallStatus> getPreinstall(GetPreinstallOptions getPreinstallOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getPreinstallOptions,
      "getPreinstallOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("version_loc_id", getPreinstallOptions.versionLocId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/versions/{version_loc_id}/preinstall", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getPreinstall");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("X-Auth-Refresh-Token", getPreinstallOptions.xAuthRefreshToken());
    if (getPreinstallOptions.clusterId() != null) {
      builder.query("cluster_id", String.valueOf(getPreinstallOptions.clusterId()));
    }
    if (getPreinstallOptions.region() != null) {
      builder.query("region", String.valueOf(getPreinstallOptions.region()));
    }
    if (getPreinstallOptions.namespace() != null) {
      builder.query("namespace", String.valueOf(getPreinstallOptions.namespace()));
    }
    ResponseConverter<InstallStatus> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<InstallStatus>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Validate offering.
   *
   * Validate the offering associated with the specified version.
   *
   * @param validateInstallOptions the {@link ValidateInstallOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> validateInstall(ValidateInstallOptions validateInstallOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(validateInstallOptions,
      "validateInstallOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("version_loc_id", validateInstallOptions.versionLocId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/versions/{version_loc_id}/validation/install", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "validateInstall");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("X-Auth-Refresh-Token", validateInstallOptions.xAuthRefreshToken());
    final JsonObject contentJson = new JsonObject();
    if (validateInstallOptions.clusterId() != null) {
      contentJson.addProperty("cluster_id", validateInstallOptions.clusterId());
    }
    if (validateInstallOptions.region() != null) {
      contentJson.addProperty("region", validateInstallOptions.region());
    }
    if (validateInstallOptions.namespace() != null) {
      contentJson.addProperty("namespace", validateInstallOptions.namespace());
    }
    if (validateInstallOptions.overrideValues() != null) {
      contentJson.add("override_values", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(validateInstallOptions.overrideValues()));
    }
    if (validateInstallOptions.entitlementApikey() != null) {
      contentJson.addProperty("entitlement_apikey", validateInstallOptions.entitlementApikey());
    }
    if (validateInstallOptions.schematics() != null) {
      contentJson.add("schematics", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(validateInstallOptions.schematics()));
    }
    if (validateInstallOptions.script() != null) {
      contentJson.addProperty("script", validateInstallOptions.script());
    }
    if (validateInstallOptions.scriptId() != null) {
      contentJson.addProperty("script_id", validateInstallOptions.scriptId());
    }
    if (validateInstallOptions.versionLocatorId() != null) {
      contentJson.addProperty("version_locator_id", validateInstallOptions.versionLocatorId());
    }
    if (validateInstallOptions.vcenterId() != null) {
      contentJson.addProperty("vcenter_id", validateInstallOptions.vcenterId());
    }
    if (validateInstallOptions.vcenterUser() != null) {
      contentJson.addProperty("vcenter_user", validateInstallOptions.vcenterUser());
    }
    if (validateInstallOptions.vcenterPassword() != null) {
      contentJson.addProperty("vcenter_password", validateInstallOptions.vcenterPassword());
    }
    if (validateInstallOptions.vcenterLocation() != null) {
      contentJson.addProperty("vcenter_location", validateInstallOptions.vcenterLocation());
    }
    if (validateInstallOptions.vcenterDatastore() != null) {
      contentJson.addProperty("vcenter_datastore", validateInstallOptions.vcenterDatastore());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get offering install status.
   *
   * Returns the install status for the specified offering version.
   *
   * @param getValidationStatusOptions the {@link GetValidationStatusOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Validation}
   */
  public ServiceCall<Validation> getValidationStatus(GetValidationStatusOptions getValidationStatusOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getValidationStatusOptions,
      "getValidationStatusOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("version_loc_id", getValidationStatusOptions.versionLocId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/versions/{version_loc_id}/validation/install", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getValidationStatus");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("X-Auth-Refresh-Token", getValidationStatusOptions.xAuthRefreshToken());
    ResponseConverter<Validation> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Validation>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get override values.
   *
   * Returns the override values that were used to validate the specified offering version.
   *
   * @param getOverrideValuesOptions the {@link GetOverrideValuesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Map}
   */
  public ServiceCall<Map<String, Object>> getOverrideValues(GetOverrideValuesOptions getOverrideValuesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getOverrideValuesOptions,
      "getOverrideValuesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("version_loc_id", getOverrideValuesOptions.versionLocId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/versions/{version_loc_id}/validation/overridevalues", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getOverrideValues");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Map<String, Object>> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Map<String, Object>>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List objects across catalogs.
   *
   * List the available objects from both public and private catalogs. These copies cannot be used for updating. They
   * are not complete and only return what is visible to the caller.
   *
   * @param searchObjectsOptions the {@link SearchObjectsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ObjectSearchResult}
   */
  public ServiceCall<ObjectSearchResult> searchObjects(SearchObjectsOptions searchObjectsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(searchObjectsOptions,
      "searchObjectsOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/objects"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "searchObjects");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("query", String.valueOf(searchObjectsOptions.query()));
    if (searchObjectsOptions.limit() != null) {
      builder.query("limit", String.valueOf(searchObjectsOptions.limit()));
    }
    if (searchObjectsOptions.offset() != null) {
      builder.query("offset", String.valueOf(searchObjectsOptions.offset()));
    }
    if (searchObjectsOptions.collapse() != null) {
      builder.query("collapse", String.valueOf(searchObjectsOptions.collapse()));
    }
    if (searchObjectsOptions.digest() != null) {
      builder.query("digest", String.valueOf(searchObjectsOptions.digest()));
    }
    ResponseConverter<ObjectSearchResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ObjectSearchResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List objects within a catalog.
   *
   * List the available objects within the specified catalog.
   *
   * @param listObjectsOptions the {@link ListObjectsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ObjectListResult}
   */
  public ServiceCall<ObjectListResult> listObjects(ListObjectsOptions listObjectsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listObjectsOptions,
      "listObjectsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", listObjectsOptions.catalogIdentifier());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/objects", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "listObjects");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listObjectsOptions.limit() != null) {
      builder.query("limit", String.valueOf(listObjectsOptions.limit()));
    }
    if (listObjectsOptions.offset() != null) {
      builder.query("offset", String.valueOf(listObjectsOptions.offset()));
    }
    if (listObjectsOptions.name() != null) {
      builder.query("name", String.valueOf(listObjectsOptions.name()));
    }
    if (listObjectsOptions.sort() != null) {
      builder.query("sort", String.valueOf(listObjectsOptions.sort()));
    }
    ResponseConverter<ObjectListResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ObjectListResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create catalog object.
   *
   * Create an object with a specific catalog.
   *
   * @param createObjectOptions the {@link CreateObjectOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CatalogObject}
   */
  public ServiceCall<CatalogObject> createObject(CreateObjectOptions createObjectOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createObjectOptions,
      "createObjectOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", createObjectOptions.catalogIdentifier());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/objects", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "createObject");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (createObjectOptions.id() != null) {
      contentJson.addProperty("id", createObjectOptions.id());
    }
    if (createObjectOptions.name() != null) {
      contentJson.addProperty("name", createObjectOptions.name());
    }
    if (createObjectOptions.rev() != null) {
      contentJson.addProperty("_rev", createObjectOptions.rev());
    }
    if (createObjectOptions.crn() != null) {
      contentJson.addProperty("crn", createObjectOptions.crn());
    }
    if (createObjectOptions.url() != null) {
      contentJson.addProperty("url", createObjectOptions.url());
    }
    if (createObjectOptions.parentId() != null) {
      contentJson.addProperty("parent_id", createObjectOptions.parentId());
    }
    if (createObjectOptions.labelI18n() != null) {
      contentJson.addProperty("label_i18n", createObjectOptions.labelI18n());
    }
    if (createObjectOptions.label() != null) {
      contentJson.addProperty("label", createObjectOptions.label());
    }
    if (createObjectOptions.tags() != null) {
      contentJson.add("tags", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createObjectOptions.tags()));
    }
    if (createObjectOptions.created() != null) {
      contentJson.add("created", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createObjectOptions.created()));
    }
    if (createObjectOptions.updated() != null) {
      contentJson.add("updated", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createObjectOptions.updated()));
    }
    if (createObjectOptions.shortDescription() != null) {
      contentJson.addProperty("short_description", createObjectOptions.shortDescription());
    }
    if (createObjectOptions.shortDescriptionI18n() != null) {
      contentJson.addProperty("short_description_i18n", createObjectOptions.shortDescriptionI18n());
    }
    if (createObjectOptions.kind() != null) {
      contentJson.addProperty("kind", createObjectOptions.kind());
    }
    if (createObjectOptions.publish() != null) {
      contentJson.add("publish", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createObjectOptions.publish()));
    }
    if (createObjectOptions.state() != null) {
      contentJson.add("state", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createObjectOptions.state()));
    }
    if (createObjectOptions.catalogId() != null) {
      contentJson.addProperty("catalog_id", createObjectOptions.catalogId());
    }
    if (createObjectOptions.catalogName() != null) {
      contentJson.addProperty("catalog_name", createObjectOptions.catalogName());
    }
    if (createObjectOptions.data() != null) {
      contentJson.add("data", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createObjectOptions.data()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<CatalogObject> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CatalogObject>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get catalog object.
   *
   * Get the specified object from within the specified catalog.
   *
   * @param getObjectOptions the {@link GetObjectOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CatalogObject}
   */
  public ServiceCall<CatalogObject> getObject(GetObjectOptions getObjectOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getObjectOptions,
      "getObjectOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", getObjectOptions.catalogIdentifier());
    pathParamsMap.put("object_identifier", getObjectOptions.objectIdentifier());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/objects/{object_identifier}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getObject");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<CatalogObject> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CatalogObject>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update catalog object.
   *
   * Update an object within a specific catalog.
   *
   * @param replaceObjectOptions the {@link ReplaceObjectOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CatalogObject}
   */
  public ServiceCall<CatalogObject> replaceObject(ReplaceObjectOptions replaceObjectOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceObjectOptions,
      "replaceObjectOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", replaceObjectOptions.catalogIdentifier());
    pathParamsMap.put("object_identifier", replaceObjectOptions.objectIdentifier());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/objects/{object_identifier}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "replaceObject");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (replaceObjectOptions.id() != null) {
      contentJson.addProperty("id", replaceObjectOptions.id());
    }
    if (replaceObjectOptions.name() != null) {
      contentJson.addProperty("name", replaceObjectOptions.name());
    }
    if (replaceObjectOptions.rev() != null) {
      contentJson.addProperty("_rev", replaceObjectOptions.rev());
    }
    if (replaceObjectOptions.crn() != null) {
      contentJson.addProperty("crn", replaceObjectOptions.crn());
    }
    if (replaceObjectOptions.url() != null) {
      contentJson.addProperty("url", replaceObjectOptions.url());
    }
    if (replaceObjectOptions.parentId() != null) {
      contentJson.addProperty("parent_id", replaceObjectOptions.parentId());
    }
    if (replaceObjectOptions.labelI18n() != null) {
      contentJson.addProperty("label_i18n", replaceObjectOptions.labelI18n());
    }
    if (replaceObjectOptions.label() != null) {
      contentJson.addProperty("label", replaceObjectOptions.label());
    }
    if (replaceObjectOptions.tags() != null) {
      contentJson.add("tags", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceObjectOptions.tags()));
    }
    if (replaceObjectOptions.created() != null) {
      contentJson.add("created", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceObjectOptions.created()));
    }
    if (replaceObjectOptions.updated() != null) {
      contentJson.add("updated", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceObjectOptions.updated()));
    }
    if (replaceObjectOptions.shortDescription() != null) {
      contentJson.addProperty("short_description", replaceObjectOptions.shortDescription());
    }
    if (replaceObjectOptions.shortDescriptionI18n() != null) {
      contentJson.addProperty("short_description_i18n", replaceObjectOptions.shortDescriptionI18n());
    }
    if (replaceObjectOptions.kind() != null) {
      contentJson.addProperty("kind", replaceObjectOptions.kind());
    }
    if (replaceObjectOptions.publish() != null) {
      contentJson.add("publish", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceObjectOptions.publish()));
    }
    if (replaceObjectOptions.state() != null) {
      contentJson.add("state", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceObjectOptions.state()));
    }
    if (replaceObjectOptions.catalogId() != null) {
      contentJson.addProperty("catalog_id", replaceObjectOptions.catalogId());
    }
    if (replaceObjectOptions.catalogName() != null) {
      contentJson.addProperty("catalog_name", replaceObjectOptions.catalogName());
    }
    if (replaceObjectOptions.data() != null) {
      contentJson.add("data", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceObjectOptions.data()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<CatalogObject> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CatalogObject>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete catalog object.
   *
   * Delete a specific object within a specific catalog.
   *
   * @param deleteObjectOptions the {@link DeleteObjectOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteObject(DeleteObjectOptions deleteObjectOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteObjectOptions,
      "deleteObjectOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", deleteObjectOptions.catalogIdentifier());
    pathParamsMap.put("object_identifier", deleteObjectOptions.objectIdentifier());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/objects/{object_identifier}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "deleteObject");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get catalog object audit log.
   *
   * Get the audit log associated with a specific catalog object.
   *
   * @param getObjectAuditOptions the {@link GetObjectAuditOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AuditLog}
   */
  public ServiceCall<AuditLog> getObjectAudit(GetObjectAuditOptions getObjectAuditOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getObjectAuditOptions,
      "getObjectAuditOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", getObjectAuditOptions.catalogIdentifier());
    pathParamsMap.put("object_identifier", getObjectAuditOptions.objectIdentifier());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/objects/{object_identifier}/audit", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getObjectAudit");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<AuditLog> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AuditLog>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Publish object to account.
   *
   * Publish a catalog object to account.
   *
   * @param accountPublishObjectOptions the {@link AccountPublishObjectOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> accountPublishObject(AccountPublishObjectOptions accountPublishObjectOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(accountPublishObjectOptions,
      "accountPublishObjectOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", accountPublishObjectOptions.catalogIdentifier());
    pathParamsMap.put("object_identifier", accountPublishObjectOptions.objectIdentifier());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/objects/{object_identifier}/account-publish", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "accountPublishObject");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Publish object to share with allow list.
   *
   * Publish the specified object so that it is visible to those in the allow list.
   *
   * @param sharedPublishObjectOptions the {@link SharedPublishObjectOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> sharedPublishObject(SharedPublishObjectOptions sharedPublishObjectOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(sharedPublishObjectOptions,
      "sharedPublishObjectOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", sharedPublishObjectOptions.catalogIdentifier());
    pathParamsMap.put("object_identifier", sharedPublishObjectOptions.objectIdentifier());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/objects/{object_identifier}/shared-publish", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "sharedPublishObject");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Publish object to share with IBMers.
   *
   * Publish the specified object so that it is visible to IBMers in the public catalog.
   *
   * @param ibmPublishObjectOptions the {@link IbmPublishObjectOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> ibmPublishObject(IbmPublishObjectOptions ibmPublishObjectOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(ibmPublishObjectOptions,
      "ibmPublishObjectOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", ibmPublishObjectOptions.catalogIdentifier());
    pathParamsMap.put("object_identifier", ibmPublishObjectOptions.objectIdentifier());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/objects/{object_identifier}/ibm-publish", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "ibmPublishObject");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Publish object to share with all users.
   *
   * Publish the specified object so it is visible to all users in the public catalog.
   *
   * @param publicPublishObjectOptions the {@link PublicPublishObjectOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> publicPublishObject(PublicPublishObjectOptions publicPublishObjectOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(publicPublishObjectOptions,
      "publicPublishObjectOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", publicPublishObjectOptions.catalogIdentifier());
    pathParamsMap.put("object_identifier", publicPublishObjectOptions.objectIdentifier());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/objects/{object_identifier}/public-publish", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "publicPublishObject");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add account ID to object access list.
   *
   * Add an account ID to an object's access list.
   *
   * @param createObjectAccessOptions the {@link CreateObjectAccessOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> createObjectAccess(CreateObjectAccessOptions createObjectAccessOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createObjectAccessOptions,
      "createObjectAccessOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", createObjectAccessOptions.catalogIdentifier());
    pathParamsMap.put("object_identifier", createObjectAccessOptions.objectIdentifier());
    pathParamsMap.put("account_identifier", createObjectAccessOptions.accountIdentifier());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/objects/{object_identifier}/access/{account_identifier}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "createObjectAccess");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Check for account ID in object access list.
   *
   * Determine if an account ID is in an object's access list.
   *
   * @param getObjectAccessOptions the {@link GetObjectAccessOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ObjectAccess}
   */
  public ServiceCall<ObjectAccess> getObjectAccess(GetObjectAccessOptions getObjectAccessOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getObjectAccessOptions,
      "getObjectAccessOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", getObjectAccessOptions.catalogIdentifier());
    pathParamsMap.put("object_identifier", getObjectAccessOptions.objectIdentifier());
    pathParamsMap.put("account_identifier", getObjectAccessOptions.accountIdentifier());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/objects/{object_identifier}/access/{account_identifier}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getObjectAccess");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ObjectAccess> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ObjectAccess>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Remove account ID from object access list.
   *
   * Delete the specified account ID from the specified object's access list.
   *
   * @param deleteObjectAccessOptions the {@link DeleteObjectAccessOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteObjectAccess(DeleteObjectAccessOptions deleteObjectAccessOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteObjectAccessOptions,
      "deleteObjectAccessOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", deleteObjectAccessOptions.catalogIdentifier());
    pathParamsMap.put("object_identifier", deleteObjectAccessOptions.objectIdentifier());
    pathParamsMap.put("account_identifier", deleteObjectAccessOptions.accountIdentifier());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/objects/{object_identifier}/access/{account_identifier}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "deleteObjectAccess");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get object access list.
   *
   * Get the access list associated with the specified object.
   *
   * @param getObjectAccessListOptions the {@link GetObjectAccessListOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ObjectAccessListResult}
   */
  public ServiceCall<ObjectAccessListResult> getObjectAccessList(GetObjectAccessListOptions getObjectAccessListOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getObjectAccessListOptions,
      "getObjectAccessListOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", getObjectAccessListOptions.catalogIdentifier());
    pathParamsMap.put("object_identifier", getObjectAccessListOptions.objectIdentifier());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/objects/{object_identifier}/access", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getObjectAccessList");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getObjectAccessListOptions.limit() != null) {
      builder.query("limit", String.valueOf(getObjectAccessListOptions.limit()));
    }
    if (getObjectAccessListOptions.offset() != null) {
      builder.query("offset", String.valueOf(getObjectAccessListOptions.offset()));
    }
    ResponseConverter<ObjectAccessListResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ObjectAccessListResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete accounts from object access list.
   *
   * Delete all or a set of accounts from an object's access list.
   *
   * @param deleteObjectAccessListOptions the {@link DeleteObjectAccessListOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AccessListBulkResponse}
   */
  public ServiceCall<AccessListBulkResponse> deleteObjectAccessList(DeleteObjectAccessListOptions deleteObjectAccessListOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteObjectAccessListOptions,
      "deleteObjectAccessListOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", deleteObjectAccessListOptions.catalogIdentifier());
    pathParamsMap.put("object_identifier", deleteObjectAccessListOptions.objectIdentifier());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/objects/{object_identifier}/access", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "deleteObjectAccessList");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithoutPrettyPrinting().toJson(deleteObjectAccessListOptions.accounts()), "application/json");
    ResponseConverter<AccessListBulkResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AccessListBulkResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add accounts to object access list.
   *
   * Add one or more accounts to the specified object's access list.
   *
   * @param addObjectAccessListOptions the {@link AddObjectAccessListOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AccessListBulkResponse}
   */
  public ServiceCall<AccessListBulkResponse> addObjectAccessList(AddObjectAccessListOptions addObjectAccessListOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(addObjectAccessListOptions,
      "addObjectAccessListOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("catalog_identifier", addObjectAccessListOptions.catalogIdentifier());
    pathParamsMap.put("object_identifier", addObjectAccessListOptions.objectIdentifier());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/catalogs/{catalog_identifier}/objects/{object_identifier}/access", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "addObjectAccessList");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithoutPrettyPrinting().toJson(addObjectAccessListOptions.accounts()), "application/json");
    ResponseConverter<AccessListBulkResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AccessListBulkResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create an offering resource instance.
   *
   * Provision a new offering in a given account, and return its resource instance.
   *
   * @param createOfferingInstanceOptions the {@link CreateOfferingInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link OfferingInstance}
   */
  public ServiceCall<OfferingInstance> createOfferingInstance(CreateOfferingInstanceOptions createOfferingInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createOfferingInstanceOptions,
      "createOfferingInstanceOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/offerings"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "createOfferingInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("X-Auth-Refresh-Token", createOfferingInstanceOptions.xAuthRefreshToken());
    final JsonObject contentJson = new JsonObject();
    if (createOfferingInstanceOptions.id() != null) {
      contentJson.addProperty("id", createOfferingInstanceOptions.id());
    }
    if (createOfferingInstanceOptions.rev() != null) {
      contentJson.addProperty("_rev", createOfferingInstanceOptions.rev());
    }
    if (createOfferingInstanceOptions.url() != null) {
      contentJson.addProperty("url", createOfferingInstanceOptions.url());
    }
    if (createOfferingInstanceOptions.crn() != null) {
      contentJson.addProperty("crn", createOfferingInstanceOptions.crn());
    }
    if (createOfferingInstanceOptions.label() != null) {
      contentJson.addProperty("label", createOfferingInstanceOptions.label());
    }
    if (createOfferingInstanceOptions.catalogId() != null) {
      contentJson.addProperty("catalog_id", createOfferingInstanceOptions.catalogId());
    }
    if (createOfferingInstanceOptions.offeringId() != null) {
      contentJson.addProperty("offering_id", createOfferingInstanceOptions.offeringId());
    }
    if (createOfferingInstanceOptions.kindFormat() != null) {
      contentJson.addProperty("kind_format", createOfferingInstanceOptions.kindFormat());
    }
    if (createOfferingInstanceOptions.version() != null) {
      contentJson.addProperty("version", createOfferingInstanceOptions.version());
    }
    if (createOfferingInstanceOptions.clusterId() != null) {
      contentJson.addProperty("cluster_id", createOfferingInstanceOptions.clusterId());
    }
    if (createOfferingInstanceOptions.clusterRegion() != null) {
      contentJson.addProperty("cluster_region", createOfferingInstanceOptions.clusterRegion());
    }
    if (createOfferingInstanceOptions.clusterNamespaces() != null) {
      contentJson.add("cluster_namespaces", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createOfferingInstanceOptions.clusterNamespaces()));
    }
    if (createOfferingInstanceOptions.clusterAllNamespaces() != null) {
      contentJson.addProperty("cluster_all_namespaces", createOfferingInstanceOptions.clusterAllNamespaces());
    }
    if (createOfferingInstanceOptions.schematicsWorkspaceId() != null) {
      contentJson.addProperty("schematics_workspace_id", createOfferingInstanceOptions.schematicsWorkspaceId());
    }
    if (createOfferingInstanceOptions.resourceGroupId() != null) {
      contentJson.addProperty("resource_group_id", createOfferingInstanceOptions.resourceGroupId());
    }
    if (createOfferingInstanceOptions.installPlan() != null) {
      contentJson.addProperty("install_plan", createOfferingInstanceOptions.installPlan());
    }
    if (createOfferingInstanceOptions.channel() != null) {
      contentJson.addProperty("channel", createOfferingInstanceOptions.channel());
    }
    if (createOfferingInstanceOptions.metadata() != null) {
      contentJson.add("metadata", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createOfferingInstanceOptions.metadata()));
    }
    if (createOfferingInstanceOptions.lastOperation() != null) {
      contentJson.add("last_operation", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createOfferingInstanceOptions.lastOperation()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<OfferingInstance> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<OfferingInstance>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get Offering Instance.
   *
   * Get the resource associated with an installed offering instance.
   *
   * @param getOfferingInstanceOptions the {@link GetOfferingInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link OfferingInstance}
   */
  public ServiceCall<OfferingInstance> getOfferingInstance(GetOfferingInstanceOptions getOfferingInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getOfferingInstanceOptions,
      "getOfferingInstanceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_identifier", getOfferingInstanceOptions.instanceIdentifier());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/offerings/{instance_identifier}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getOfferingInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<OfferingInstance> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<OfferingInstance>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update Offering Instance.
   *
   * Update an installed offering instance.
   *
   * @param putOfferingInstanceOptions the {@link PutOfferingInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link OfferingInstance}
   */
  public ServiceCall<OfferingInstance> putOfferingInstance(PutOfferingInstanceOptions putOfferingInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(putOfferingInstanceOptions,
      "putOfferingInstanceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_identifier", putOfferingInstanceOptions.instanceIdentifier());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/offerings/{instance_identifier}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "putOfferingInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("X-Auth-Refresh-Token", putOfferingInstanceOptions.xAuthRefreshToken());
    final JsonObject contentJson = new JsonObject();
    if (putOfferingInstanceOptions.id() != null) {
      contentJson.addProperty("id", putOfferingInstanceOptions.id());
    }
    if (putOfferingInstanceOptions.rev() != null) {
      contentJson.addProperty("_rev", putOfferingInstanceOptions.rev());
    }
    if (putOfferingInstanceOptions.url() != null) {
      contentJson.addProperty("url", putOfferingInstanceOptions.url());
    }
    if (putOfferingInstanceOptions.crn() != null) {
      contentJson.addProperty("crn", putOfferingInstanceOptions.crn());
    }
    if (putOfferingInstanceOptions.label() != null) {
      contentJson.addProperty("label", putOfferingInstanceOptions.label());
    }
    if (putOfferingInstanceOptions.catalogId() != null) {
      contentJson.addProperty("catalog_id", putOfferingInstanceOptions.catalogId());
    }
    if (putOfferingInstanceOptions.offeringId() != null) {
      contentJson.addProperty("offering_id", putOfferingInstanceOptions.offeringId());
    }
    if (putOfferingInstanceOptions.kindFormat() != null) {
      contentJson.addProperty("kind_format", putOfferingInstanceOptions.kindFormat());
    }
    if (putOfferingInstanceOptions.version() != null) {
      contentJson.addProperty("version", putOfferingInstanceOptions.version());
    }
    if (putOfferingInstanceOptions.clusterId() != null) {
      contentJson.addProperty("cluster_id", putOfferingInstanceOptions.clusterId());
    }
    if (putOfferingInstanceOptions.clusterRegion() != null) {
      contentJson.addProperty("cluster_region", putOfferingInstanceOptions.clusterRegion());
    }
    if (putOfferingInstanceOptions.clusterNamespaces() != null) {
      contentJson.add("cluster_namespaces", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(putOfferingInstanceOptions.clusterNamespaces()));
    }
    if (putOfferingInstanceOptions.clusterAllNamespaces() != null) {
      contentJson.addProperty("cluster_all_namespaces", putOfferingInstanceOptions.clusterAllNamespaces());
    }
    if (putOfferingInstanceOptions.schematicsWorkspaceId() != null) {
      contentJson.addProperty("schematics_workspace_id", putOfferingInstanceOptions.schematicsWorkspaceId());
    }
    if (putOfferingInstanceOptions.resourceGroupId() != null) {
      contentJson.addProperty("resource_group_id", putOfferingInstanceOptions.resourceGroupId());
    }
    if (putOfferingInstanceOptions.installPlan() != null) {
      contentJson.addProperty("install_plan", putOfferingInstanceOptions.installPlan());
    }
    if (putOfferingInstanceOptions.channel() != null) {
      contentJson.addProperty("channel", putOfferingInstanceOptions.channel());
    }
    if (putOfferingInstanceOptions.metadata() != null) {
      contentJson.add("metadata", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(putOfferingInstanceOptions.metadata()));
    }
    if (putOfferingInstanceOptions.lastOperation() != null) {
      contentJson.add("last_operation", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(putOfferingInstanceOptions.lastOperation()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<OfferingInstance> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<OfferingInstance>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a version instance.
   *
   * Delete and instance deployed out of a product version.
   *
   * @param deleteOfferingInstanceOptions the {@link DeleteOfferingInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteOfferingInstance(DeleteOfferingInstanceOptions deleteOfferingInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteOfferingInstanceOptions,
      "deleteOfferingInstanceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("instance_identifier", deleteOfferingInstanceOptions.instanceIdentifier());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/instances/offerings/{instance_identifier}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "deleteOfferingInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("X-Auth-Refresh-Token", deleteOfferingInstanceOptions.xAuthRefreshToken());
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

}
