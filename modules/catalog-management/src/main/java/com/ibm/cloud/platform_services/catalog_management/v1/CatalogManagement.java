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
package com.ibm.cloud.platform_services.catalog_management.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Account;
import com.ibm.cloud.platform_services.catalog_management.v1.model.AccountPublishVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.AccumulatedFilters;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ApprovalResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CanDeploySchematicsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Catalog;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CatalogSearchResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ClusterInfo;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ClusterSearchResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CommitVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateCatalogOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateLicenseEntitlementOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateOperatorOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteCatalogOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteLicenseEntitlementOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteOperatorOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeployRequirementsCheck;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeprecateVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Enterprise;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetCatalogAccountFiltersOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetCatalogAccountOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetCatalogOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetClusterOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetConsumptionOfferingsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetEnterpriseOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetLicenseEntitlementsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetLicenseProvidersOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetLicensesOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetNamespacesOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOverrideValuesOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetPreinstallOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetRepoOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetReposOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetResourceGroupsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetSchematicsWorkspacesOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetValidationStatusOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetVersionAboutOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetVersionContainerImagesOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetVersionLicenseOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetVersionUpdatesOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetVersionWorkingCopyOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.HelmPackage;
import com.ibm.cloud.platform_services.catalog_management.v1.model.HelmRepoList;
import com.ibm.cloud.platform_services.catalog_management.v1.model.IbmPublishVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ImageManifest;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ImportOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ImportOfferingVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.InstallStatus;
import com.ibm.cloud.platform_services.catalog_management.v1.model.InstallVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.LicenseEntitlement;
import com.ibm.cloud.platform_services.catalog_management.v1.model.LicenseEntitlements;
import com.ibm.cloud.platform_services.catalog_management.v1.model.LicenseProviders;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Licenses;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ListCatalogsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ListClustersOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ListLicenseEntitlementsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ListOfferingsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ListOperatorsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ListVersionsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.NamespaceSearchResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Offering;
import com.ibm.cloud.platform_services.catalog_management.v1.model.OfferingSearchResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.OperatorDeployResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.PreinstallVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.PublicPublishVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReloadOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceCatalogOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceEnterpriseOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceOfferingIconOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceOperatorOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ResourceGroups;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SchematicsWorkspaceSearchResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SearchLicenseOfferingsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SearchLicenseVersionsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.UpdateCatalogAccountOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.UpdateOfferingIbmOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Validation;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ValidationInstallOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Version;
import com.ibm.cloud.platform_services.catalog_management.v1.model.VersionUpdateDescriptor;
import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * This is the API to use for managing private catalogs for IBM Cloud. Private catalogs provide a way to centrally
 * manage access to products in the IBM Cloud catalog and your own catalogs.
 *
 * @version v1
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
   * Get the account settings.
   *
   * Get the account level settings for the account for private catalog.
   *
   * @param getCatalogAccountOptions the {@link GetCatalogAccountOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Account}
   */
  public ServiceCall<Account> getCatalogAccount(GetCatalogAccountOptions getCatalogAccountOptions) {
    String[] pathSegments = { "catalogaccount" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
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
   * Get the account settings.
   *
   * Get the account level settings for the account for private catalog.
   *
   * @return a {@link ServiceCall} with a result of type {@link Account}
   */
  public ServiceCall<Account> getCatalogAccount() {
    return getCatalogAccount(null);
  }

  /**
   * Set the account settings.
   *
   * @param updateCatalogAccountOptions the {@link UpdateCatalogAccountOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> updateCatalogAccount(UpdateCatalogAccountOptions updateCatalogAccountOptions) {
    String[] pathSegments = { "catalogaccount" };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "updateCatalogAccount");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (updateCatalogAccountOptions != null) {
      final JsonObject contentJson = new JsonObject();
      if (updateCatalogAccountOptions.id() != null) {
        contentJson.addProperty("id", updateCatalogAccountOptions.id());
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
   * Set the account settings.
   *
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> updateCatalogAccount() {
    return updateCatalogAccount(null);
  }

  /**
   * Get the accumulated filters of the account and of the catalogs you have access to.
   *
   * Get the accumulated filters of the account and of the catalogs you have access to.
   *
   * @param getCatalogAccountFiltersOptions the {@link GetCatalogAccountFiltersOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AccumulatedFilters}
   */
  public ServiceCall<AccumulatedFilters> getCatalogAccountFilters(GetCatalogAccountFiltersOptions getCatalogAccountFiltersOptions) {
    String[] pathSegments = { "catalogaccount/filters" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getCatalogAccountFilters");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getCatalogAccountFiltersOptions != null) {
      if (getCatalogAccountFiltersOptions.catalog() != null) {
        builder.query("catalog", getCatalogAccountFiltersOptions.catalog());
      }
    }
    ResponseConverter<AccumulatedFilters> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AccumulatedFilters>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get the accumulated filters of the account and of the catalogs you have access to.
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
   * List the available catalogs for a given account.
   *
   * @param listCatalogsOptions the {@link ListCatalogsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CatalogSearchResult}
   */
  public ServiceCall<CatalogSearchResult> listCatalogs(ListCatalogsOptions listCatalogsOptions) {
    String[] pathSegments = { "catalogs" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
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
   * List the available catalogs for a given account.
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
    String[] pathSegments = { "catalogs" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "createCatalog");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createCatalogOptions != null) {
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
      if (createCatalogOptions.url() != null) {
        contentJson.addProperty("url", createCatalogOptions.url());
      }
      if (createCatalogOptions.crn() != null) {
        contentJson.addProperty("crn", createCatalogOptions.crn());
      }
      if (createCatalogOptions.offeringsUrl() != null) {
        contentJson.addProperty("offerings_url", createCatalogOptions.offeringsUrl());
      }
      if (createCatalogOptions.features() != null) {
        contentJson.add("features", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createCatalogOptions.features()));
      }
      if (createCatalogOptions.disabled() != null) {
        contentJson.addProperty("disabled", createCatalogOptions.disabled());
      }
      if (createCatalogOptions.created() != null) {
        contentJson.add("created", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createCatalogOptions.created()));
      }
      if (createCatalogOptions.updated() != null) {
        contentJson.add("updated", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createCatalogOptions.updated()));
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
   * Get a catalog.
   *
   * Get a catalog.
   *
   * @param getCatalogOptions the {@link GetCatalogOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Catalog}
   */
  public ServiceCall<Catalog> getCatalog(GetCatalogOptions getCatalogOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getCatalogOptions,
      "getCatalogOptions cannot be null");
    String[] pathSegments = { "catalogs" };
    String[] pathParameters = { getCatalogOptions.catalogIdentifier() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
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
   * Update a catalog.
   *
   * Update a catalog.
   *
   * @param replaceCatalogOptions the {@link ReplaceCatalogOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Catalog}
   */
  public ServiceCall<Catalog> replaceCatalog(ReplaceCatalogOptions replaceCatalogOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceCatalogOptions,
      "replaceCatalogOptions cannot be null");
    String[] pathSegments = { "catalogs" };
    String[] pathParameters = { replaceCatalogOptions.catalogIdentifier() };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
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
    if (replaceCatalogOptions.url() != null) {
      contentJson.addProperty("url", replaceCatalogOptions.url());
    }
    if (replaceCatalogOptions.crn() != null) {
      contentJson.addProperty("crn", replaceCatalogOptions.crn());
    }
    if (replaceCatalogOptions.offeringsUrl() != null) {
      contentJson.addProperty("offerings_url", replaceCatalogOptions.offeringsUrl());
    }
    if (replaceCatalogOptions.features() != null) {
      contentJson.add("features", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceCatalogOptions.features()));
    }
    if (replaceCatalogOptions.disabled() != null) {
      contentJson.addProperty("disabled", replaceCatalogOptions.disabled());
    }
    if (replaceCatalogOptions.created() != null) {
      contentJson.add("created", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceCatalogOptions.created()));
    }
    if (replaceCatalogOptions.updated() != null) {
      contentJson.add("updated", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceCatalogOptions.updated()));
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
    builder.bodyJson(contentJson);
    ResponseConverter<Catalog> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Catalog>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a catalog.
   *
   * Delete a catalog.
   *
   * @param deleteCatalogOptions the {@link DeleteCatalogOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteCatalog(DeleteCatalogOptions deleteCatalogOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteCatalogOptions,
      "deleteCatalogOptions cannot be null");
    String[] pathSegments = { "catalogs" };
    String[] pathParameters = { deleteCatalogOptions.catalogIdentifier() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "deleteCatalog");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }

    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get the enterprise settings for the specified enterprise ID.
   *
   * Get the enterprise settings for the specified enterprise ID.
   *
   * @param getEnterpriseOptions the {@link GetEnterpriseOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Enterprise}
   */
  public ServiceCall<Enterprise> getEnterprise(GetEnterpriseOptions getEnterpriseOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getEnterpriseOptions,
      "getEnterpriseOptions cannot be null");
    String[] pathSegments = { "enterprises" };
    String[] pathParameters = { getEnterpriseOptions.enterpriseId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getEnterprise");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<Enterprise> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Enterprise>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Set the enterprise settings.
   *
   * @param replaceEnterpriseOptions the {@link ReplaceEnterpriseOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> replaceEnterprise(ReplaceEnterpriseOptions replaceEnterpriseOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceEnterpriseOptions,
      "replaceEnterpriseOptions cannot be null");
    String[] pathSegments = { "enterprises" };
    String[] pathParameters = { replaceEnterpriseOptions.enterpriseId() };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "replaceEnterprise");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    final JsonObject contentJson = new JsonObject();
    if (replaceEnterpriseOptions.id() != null) {
      contentJson.addProperty("id", replaceEnterpriseOptions.id());
    }
    if (replaceEnterpriseOptions.rev() != null) {
      contentJson.addProperty("_rev", replaceEnterpriseOptions.rev());
    }
    if (replaceEnterpriseOptions.accountFilters() != null) {
      contentJson.add("account_filters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceEnterpriseOptions.accountFilters()));
    }
    if (replaceEnterpriseOptions.accountGroups() != null) {
      contentJson.add("account_groups", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceEnterpriseOptions.accountGroups()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get list of offerings for consumption.
   *
   * List the available offerings from both public and from the account that currently scoped for consumption. These
   * copies cannot be used updating. They are not complete and only return what is visible to the caller.
   *
   * @param getConsumptionOfferingsOptions the {@link GetConsumptionOfferingsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link OfferingSearchResult}
   */
  public ServiceCall<OfferingSearchResult> getConsumptionOfferings(GetConsumptionOfferingsOptions getConsumptionOfferingsOptions) {
    String[] pathSegments = { "offerings" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getConsumptionOfferings");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getConsumptionOfferingsOptions != null) {
      if (getConsumptionOfferingsOptions.digest() != null) {
        builder.query("digest", String.valueOf(getConsumptionOfferingsOptions.digest()));
      }
      if (getConsumptionOfferingsOptions.catalog() != null) {
        builder.query("catalog", getConsumptionOfferingsOptions.catalog());
      }
      if (getConsumptionOfferingsOptions.select() != null) {
        builder.query("select", getConsumptionOfferingsOptions.select());
      }
      if (getConsumptionOfferingsOptions.includeHidden() != null) {
        builder.query("includeHidden", String.valueOf(getConsumptionOfferingsOptions.includeHidden()));
      }
    }
    ResponseConverter<OfferingSearchResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<OfferingSearchResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get list of offerings for consumption.
   *
   * List the available offerings from both public and from the account that currently scoped for consumption. These
   * copies cannot be used updating. They are not complete and only return what is visible to the caller.
   *
   * @return a {@link ServiceCall} with a result of type {@link OfferingSearchResult}
   */
  public ServiceCall<OfferingSearchResult> getConsumptionOfferings() {
    return getConsumptionOfferings(null);
  }

  /**
   * Get list of offerings.
   *
   * List the available offerings in the specified catalog.
   *
   * @param listOfferingsOptions the {@link ListOfferingsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link OfferingSearchResult}
   */
  public ServiceCall<OfferingSearchResult> listOfferings(ListOfferingsOptions listOfferingsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listOfferingsOptions,
      "listOfferingsOptions cannot be null");
    String[] pathSegments = { "catalogs", "offerings" };
    String[] pathParameters = { listOfferingsOptions.catalogIdentifier() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "listOfferings");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listOfferingsOptions.digest() != null) {
      builder.query("digest", String.valueOf(listOfferingsOptions.digest()));
    }
    ResponseConverter<OfferingSearchResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<OfferingSearchResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create an offering.
   *
   * Create an offering.
   *
   * @param createOfferingOptions the {@link CreateOfferingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Offering}
   */
  public ServiceCall<Offering> createOffering(CreateOfferingOptions createOfferingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createOfferingOptions,
      "createOfferingOptions cannot be null");
    String[] pathSegments = { "catalogs", "offerings" };
    String[] pathParameters = { createOfferingOptions.catalogIdentifier() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
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
    if (createOfferingOptions.repoInfo() != null) {
      contentJson.add("repo_info", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createOfferingOptions.repoInfo()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Offering> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Offering>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Import new version to offering from a tgz.
   *
   * Import new version to offering from a tgz.
   *
   * @param importOfferingVersionOptions the {@link ImportOfferingVersionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Offering}
   */
  public ServiceCall<Offering> importOfferingVersion(ImportOfferingVersionOptions importOfferingVersionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(importOfferingVersionOptions,
      "importOfferingVersionOptions cannot be null");
    String[] pathSegments = { "catalogs", "offerings", "version" };
    String[] pathParameters = { importOfferingVersionOptions.catalogIdentifier(), importOfferingVersionOptions.offeringId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "importOfferingVersion");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (importOfferingVersionOptions.xAuthToken() != null) {
      builder.header("X-Auth-Token", importOfferingVersionOptions.xAuthToken());
    }
    builder.query("zipurl", importOfferingVersionOptions.zipurl());
    if (importOfferingVersionOptions.targetVersion() != null) {
      builder.query("targetVersion", importOfferingVersionOptions.targetVersion());
    }
    if (importOfferingVersionOptions.includeConfig() != null) {
      builder.query("includeConfig", String.valueOf(importOfferingVersionOptions.includeConfig()));
    }
    if (importOfferingVersionOptions.repoType() != null) {
      builder.query("repoType", importOfferingVersionOptions.repoType());
    }
    final JsonObject contentJson = new JsonObject();
    if (importOfferingVersionOptions.tags() != null) {
      contentJson.add("tags", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(importOfferingVersionOptions.tags()));
    }
    if (importOfferingVersionOptions.targetKinds() != null) {
      contentJson.add("target_kinds", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(importOfferingVersionOptions.targetKinds()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Offering> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Offering>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Import a new offering from a tgz.
   *
   * Import a new offering from a tgz.
   *
   * @param importOfferingOptions the {@link ImportOfferingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Offering}
   */
  public ServiceCall<Offering> importOffering(ImportOfferingOptions importOfferingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(importOfferingOptions,
      "importOfferingOptions cannot be null");
    String[] pathSegments = { "catalogs", "import/offerings" };
    String[] pathParameters = { importOfferingOptions.catalogIdentifier() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "importOffering");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (importOfferingOptions.xAuthToken() != null) {
      builder.header("X-Auth-Token", importOfferingOptions.xAuthToken());
    }
    builder.query("zipurl", importOfferingOptions.zipurl());
    if (importOfferingOptions.offeringId() != null) {
      builder.query("offeringID", importOfferingOptions.offeringId());
    }
    if (importOfferingOptions.includeConfig() != null) {
      builder.query("includeConfig", String.valueOf(importOfferingOptions.includeConfig()));
    }
    if (importOfferingOptions.repoType() != null) {
      builder.query("repoType", importOfferingOptions.repoType());
    }
    final JsonObject contentJson = new JsonObject();
    if (importOfferingOptions.tags() != null) {
      contentJson.add("tags", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(importOfferingOptions.tags()));
    }
    if (importOfferingOptions.targetKinds() != null) {
      contentJson.add("target_kinds", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(importOfferingOptions.targetKinds()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Offering> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Offering>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Reload existing version in offering from a tgz.
   *
   * Reload existing version in offering from a tgz.
   *
   * @param reloadOfferingOptions the {@link ReloadOfferingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Offering}
   */
  public ServiceCall<Offering> reloadOffering(ReloadOfferingOptions reloadOfferingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(reloadOfferingOptions,
      "reloadOfferingOptions cannot be null");
    String[] pathSegments = { "catalogs", "offerings", "reload" };
    String[] pathParameters = { reloadOfferingOptions.catalogIdentifier(), reloadOfferingOptions.offeringId() };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "reloadOffering");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (reloadOfferingOptions.xAuthToken() != null) {
      builder.header("X-Auth-Token", reloadOfferingOptions.xAuthToken());
    }
    builder.query("zipurl", reloadOfferingOptions.zipurl());
    builder.query("targetVersion", reloadOfferingOptions.targetVersion());
    if (reloadOfferingOptions.repoType() != null) {
      builder.query("repoType", reloadOfferingOptions.repoType());
    }
    final JsonObject contentJson = new JsonObject();
    if (reloadOfferingOptions.tags() != null) {
      contentJson.add("tags", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(reloadOfferingOptions.tags()));
    }
    if (reloadOfferingOptions.targetKinds() != null) {
      contentJson.add("target_kinds", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(reloadOfferingOptions.targetKinds()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Offering> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Offering>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get an offering.
   *
   * Get an offering.
   *
   * @param getOfferingOptions the {@link GetOfferingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Offering}
   */
  public ServiceCall<Offering> getOffering(GetOfferingOptions getOfferingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getOfferingOptions,
      "getOfferingOptions cannot be null");
    String[] pathSegments = { "catalogs", "offerings" };
    String[] pathParameters = { getOfferingOptions.catalogIdentifier(), getOfferingOptions.offeringId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getOffering");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<Offering> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Offering>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update an offering.
   *
   * Update an offering.
   *
   * @param replaceOfferingOptions the {@link ReplaceOfferingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Catalog}
   */
  public ServiceCall<Catalog> replaceOffering(ReplaceOfferingOptions replaceOfferingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceOfferingOptions,
      "replaceOfferingOptions cannot be null");
    String[] pathSegments = { "catalogs", "offerings" };
    String[] pathParameters = { replaceOfferingOptions.catalogIdentifier(), replaceOfferingOptions.offeringId() };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
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
    if (replaceOfferingOptions.repoInfo() != null) {
      contentJson.add("repo_info", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceOfferingOptions.repoInfo()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Catalog> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Catalog>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete an offering.
   *
   * Delete an offering.
   *
   * @param deleteOfferingOptions the {@link DeleteOfferingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteOffering(DeleteOfferingOptions deleteOfferingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteOfferingOptions,
      "deleteOfferingOptions cannot be null");
    String[] pathSegments = { "catalogs", "offerings" };
    String[] pathParameters = { deleteOfferingOptions.catalogIdentifier(), deleteOfferingOptions.offeringId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "deleteOffering");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }

    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * upload an icon for the offering.
   *
   * upload an icon file to be stored in GC. File is uploaded as a binary payload - not as a form.
   *
   * @param replaceOfferingIconOptions the {@link ReplaceOfferingIconOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Offering}
   */
  public ServiceCall<Offering> replaceOfferingIcon(ReplaceOfferingIconOptions replaceOfferingIconOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceOfferingIconOptions,
      "replaceOfferingIconOptions cannot be null");
    String[] pathSegments = { "catalogs", "offerings", "icon" };
    String[] pathParameters = { replaceOfferingIconOptions.catalogIdentifier(), replaceOfferingIconOptions.offeringId(), replaceOfferingIconOptions.fileName() };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
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
   * Approve offering to be permitted to publish to IBM Public Catalog (IBMers only or Everyone).
   *
   * Approve or disapprove the offering to be allowed to publish to the IBM Public Catalog in `ibm` (visible to IBM
   * only) or `public` (visible to everyone). Can approve to only `ibm`, or it can be extended to `public`. If extended
   * to `public` then `ibm` is automatically approved too. If disapprove `public`, then `ibm` approval will not  be
   * changed. If disapprove `ibm` then `public` will automatically be disapproved. This is because the process steps
   * always go first through `ibm` and then to `public`. `ibm` cannot be skipped. Only users with Approval IAM authority
   * can use this.
   *
   * @param updateOfferingIbmOptions the {@link UpdateOfferingIbmOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApprovalResult}
   */
  public ServiceCall<ApprovalResult> updateOfferingIbm(UpdateOfferingIbmOptions updateOfferingIbmOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateOfferingIbmOptions,
      "updateOfferingIbmOptions cannot be null");
    String[] pathSegments = { "catalogs", "offerings", "publish", "" };
    String[] pathParameters = { updateOfferingIbmOptions.catalogIdentifier(), updateOfferingIbmOptions.offeringId(), updateOfferingIbmOptions.approvalType(), updateOfferingIbmOptions.approved() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
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
   * Get the about information, in markdown, for the current version.
   *
   * Get the about information, in markdown, for the current version.
   *
   * @param getVersionAboutOptions the {@link GetVersionAboutOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link String}
   */
  public ServiceCall<String> getVersionAbout(GetVersionAboutOptions getVersionAboutOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getVersionAboutOptions,
      "getVersionAboutOptions cannot be null");
    String[] pathSegments = { "versions", "about" };
    String[] pathParameters = { getVersionAboutOptions.versionLocId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getVersionAbout");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "text/markdown");

    ResponseConverter<String> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<String>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get the license content for the specified license ID in the specified version.
   *
   * Get the license content for the specified license ID in the specified version.
   *
   * @param getVersionLicenseOptions the {@link GetVersionLicenseOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> getVersionLicense(GetVersionLicenseOptions getVersionLicenseOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getVersionLicenseOptions,
      "getVersionLicenseOptions cannot be null");
    String[] pathSegments = { "versions", "licenses" };
    String[] pathParameters = { getVersionLicenseOptions.versionLocId(), getVersionLicenseOptions.licenseId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getVersionLicense");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }

    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get get the list of container images associated with this version.
   *
   * The "image_manifest_url" property of the version should be pointing the a URL for the image manifest, this api
   * reflects that content.
   *
   * @param getVersionContainerImagesOptions the {@link GetVersionContainerImagesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ImageManifest}
   */
  public ServiceCall<ImageManifest> getVersionContainerImages(GetVersionContainerImagesOptions getVersionContainerImagesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getVersionContainerImagesOptions,
      "getVersionContainerImagesOptions cannot be null");
    String[] pathSegments = { "versions", "containerImages" };
    String[] pathParameters = { getVersionContainerImagesOptions.versionLocId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getVersionContainerImages");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<ImageManifest> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ImageManifest>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Deprecate the specified version.
   *
   * Deprecate the specified version.
   *
   * @param deprecateVersionOptions the {@link DeprecateVersionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deprecateVersion(DeprecateVersionOptions deprecateVersionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deprecateVersionOptions,
      "deprecateVersionOptions cannot be null");
    String[] pathSegments = { "versions", "deprecate" };
    String[] pathParameters = { deprecateVersionOptions.versionLocId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "deprecateVersion");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }

    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Publish the specified version so it is viewable by account members.
   *
   * Publish the specified version so it is viewable by account members.
   *
   * @param accountPublishVersionOptions the {@link AccountPublishVersionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> accountPublishVersion(AccountPublishVersionOptions accountPublishVersionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(accountPublishVersionOptions,
      "accountPublishVersionOptions cannot be null");
    String[] pathSegments = { "versions", "account-publish" };
    String[] pathParameters = { accountPublishVersionOptions.versionLocId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "accountPublishVersion");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }

    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Publish the specified version so that it is visible to IBMers in the public catalog.
   *
   * Publish the specified version so that it is visible to IBMers in the public catalog.
   *
   * @param ibmPublishVersionOptions the {@link IbmPublishVersionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> ibmPublishVersion(IbmPublishVersionOptions ibmPublishVersionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(ibmPublishVersionOptions,
      "ibmPublishVersionOptions cannot be null");
    String[] pathSegments = { "versions", "ibm-publish" };
    String[] pathParameters = { ibmPublishVersionOptions.versionLocId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "ibmPublishVersion");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }

    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Publish the specified version so it is visible to all users in the public catalog.
   *
   * Publish the specified version so it is visible to all users in the public catalog.
   *
   * @param publicPublishVersionOptions the {@link PublicPublishVersionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> publicPublishVersion(PublicPublishVersionOptions publicPublishVersionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(publicPublishVersionOptions,
      "publicPublishVersionOptions cannot be null");
    String[] pathSegments = { "versions", "public-publish" };
    String[] pathParameters = { publicPublishVersionOptions.versionLocId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "publicPublishVersion");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }

    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Commit a working copy of the specified version.
   *
   * Commit a working copy of the specified version.
   *
   * @param commitVersionOptions the {@link CommitVersionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> commitVersion(CommitVersionOptions commitVersionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(commitVersionOptions,
      "commitVersionOptions cannot be null");
    String[] pathSegments = { "versions", "commit" };
    String[] pathParameters = { commitVersionOptions.versionLocId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "commitVersion");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }

    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a working copy of the specified version.
   *
   * Create a working copy of the specified version.
   *
   * @param getVersionWorkingCopyOptions the {@link GetVersionWorkingCopyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Version}
   */
  public ServiceCall<Version> getVersionWorkingCopy(GetVersionWorkingCopyOptions getVersionWorkingCopyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getVersionWorkingCopyOptions,
      "getVersionWorkingCopyOptions cannot be null");
    String[] pathSegments = { "versions", "workingcopy" };
    String[] pathParameters = { getVersionWorkingCopyOptions.versionLocId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getVersionWorkingCopy");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<Version> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Version>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get available updates for the specified version.
   *
   * Get available updates for the specified version.
   *
   * @param getVersionUpdatesOptions the {@link GetVersionUpdatesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link List}
   */
  public ServiceCall<List<VersionUpdateDescriptor>> getVersionUpdates(GetVersionUpdatesOptions getVersionUpdatesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getVersionUpdatesOptions,
      "getVersionUpdatesOptions cannot be null");
    String[] pathSegments = { "versions", "updates" };
    String[] pathParameters = { getVersionUpdatesOptions.versionLocId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getVersionUpdates");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getVersionUpdatesOptions.clusterId() != null) {
      builder.query("cluster_id", getVersionUpdatesOptions.clusterId());
    }
    if (getVersionUpdatesOptions.region() != null) {
      builder.query("region", getVersionUpdatesOptions.region());
    }
    if (getVersionUpdatesOptions.resourceGroupId() != null) {
      builder.query("resource_group_id", getVersionUpdatesOptions.resourceGroupId());
    }
    if (getVersionUpdatesOptions.namespace() != null) {
      builder.query("namespace", getVersionUpdatesOptions.namespace());
    }
    ResponseConverter<List<VersionUpdateDescriptor>> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<List<VersionUpdateDescriptor>>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get the Offering/Kind/Version 'branch' for the specified locator ID.
   *
   * Get the Offering/Kind/Version 'branch' for the specified locator ID.
   *
   * @param getVersionOptions the {@link GetVersionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Offering}
   */
  public ServiceCall<Offering> getVersion(GetVersionOptions getVersionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getVersionOptions,
      "getVersionOptions cannot be null");
    String[] pathSegments = { "versions" };
    String[] pathParameters = { getVersionOptions.versionLocId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
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
   * Delete a version.
   *
   * Delete a the specified version.  If the version is an active version with a working copy, the working copy will be
   * deleted as well.
   *
   * @param deleteVersionOptions the {@link DeleteVersionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteVersion(DeleteVersionOptions deleteVersionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteVersionOptions,
      "deleteVersionOptions cannot be null");
    String[] pathSegments = { "versions" };
    String[] pathParameters = { deleteVersionOptions.versionLocId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "deleteVersion");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }

    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Search for versions.
   *
   * [deprecated] use /search/license/versions api instead.   Search across all accounts for versions, requires global
   * admin permission.
   *
   * @param listVersionsOptions the {@link ListVersionsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> listVersions(ListVersionsOptions listVersionsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listVersionsOptions,
      "listVersionsOptions cannot be null");
    String[] pathSegments = { "versions" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "listVersions");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("q", listVersionsOptions.q());
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List a repo's entries.
   *
   * List the available entries from a given repo.
   *
   * @param getReposOptions the {@link GetReposOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link HelmRepoList}
   */
  public ServiceCall<HelmRepoList> getRepos(GetReposOptions getReposOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getReposOptions,
      "getReposOptions cannot be null");
    String[] pathSegments = { "repo", "entries" };
    String[] pathParameters = { getReposOptions.type() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getRepos");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("repourl", getReposOptions.repourl());
    ResponseConverter<HelmRepoList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<HelmRepoList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get contents of a repo.
   *
   * Get the contents of a given repo.
   *
   * @param getRepoOptions the {@link GetRepoOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link HelmPackage}
   */
  public ServiceCall<HelmPackage> getRepo(GetRepoOptions getRepoOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getRepoOptions,
      "getRepoOptions cannot be null");
    String[] pathSegments = { "repo" };
    String[] pathParameters = { getRepoOptions.type() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getRepo");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("charturl", getRepoOptions.charturl());
    ResponseConverter<HelmPackage> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<HelmPackage>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List Kube clusters.
   *
   * List Kube clusters.
   *
   * @param listClustersOptions the {@link ListClustersOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ClusterSearchResult}
   */
  public ServiceCall<ClusterSearchResult> listClusters(ListClustersOptions listClustersOptions) {
    String[] pathSegments = { "deploy/kubernetes/clusters" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "listClusters");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listClustersOptions != null) {
      if (listClustersOptions.limit() != null) {
        builder.query("limit", String.valueOf(listClustersOptions.limit()));
      }
      if (listClustersOptions.offset() != null) {
        builder.query("offset", String.valueOf(listClustersOptions.offset()));
      }
      if (listClustersOptions.type() != null) {
        builder.query("type", listClustersOptions.type());
      }
    }
    ResponseConverter<ClusterSearchResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ClusterSearchResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List Kube clusters.
   *
   * List Kube clusters.
   *
   * @return a {@link ServiceCall} with a result of type {@link ClusterSearchResult}
   */
  public ServiceCall<ClusterSearchResult> listClusters() {
    return listClusters(null);
  }

  /**
   * Get Kube cluster.
   *
   * Get Kube cluster.
   *
   * @param getClusterOptions the {@link GetClusterOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ClusterInfo}
   */
  public ServiceCall<ClusterInfo> getCluster(GetClusterOptions getClusterOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getClusterOptions,
      "getClusterOptions cannot be null");
    String[] pathSegments = { "deploy/kubernetes/clusters" };
    String[] pathParameters = { getClusterOptions.clusterId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getCluster");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("X-Auth-Refresh-Token", getClusterOptions.xAuthRefreshToken());
    builder.query("region", getClusterOptions.region());
    ResponseConverter<ClusterInfo> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ClusterInfo>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get cluster namespaces.
   *
   * Get cluster namespaces.
   *
   * @param getNamespacesOptions the {@link GetNamespacesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link NamespaceSearchResult}
   */
  public ServiceCall<NamespaceSearchResult> getNamespaces(GetNamespacesOptions getNamespacesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getNamespacesOptions,
      "getNamespacesOptions cannot be null");
    String[] pathSegments = { "deploy/kubernetes/clusters", "namespaces" };
    String[] pathParameters = { getNamespacesOptions.clusterId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getNamespaces");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("X-Auth-Refresh-Token", getNamespacesOptions.xAuthRefreshToken());
    builder.query("region", getNamespacesOptions.region());
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
   * Deploy Operator(s) on a Kube cluster.
   *
   * Deploy Operator(s) on a Kube cluster.
   *
   * @param createOperatorOptions the {@link CreateOperatorOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link List}
   */
  public ServiceCall<List<OperatorDeployResult>> createOperator(CreateOperatorOptions createOperatorOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createOperatorOptions,
      "createOperatorOptions cannot be null");
    String[] pathSegments = { "deploy/kubernetes/olm/operator" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "createOperator");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("X-Auth-Refresh-Token", createOperatorOptions.xAuthRefreshToken());
    final JsonObject contentJson = new JsonObject();
    if (createOperatorOptions.clusterId() != null) {
      contentJson.addProperty("cluster_id", createOperatorOptions.clusterId());
    }
    if (createOperatorOptions.region() != null) {
      contentJson.addProperty("region", createOperatorOptions.region());
    }
    if (createOperatorOptions.namespaces() != null) {
      contentJson.add("namespaces", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createOperatorOptions.namespaces()));
    }
    if (createOperatorOptions.versionLocatorId() != null) {
      contentJson.addProperty("version_locator_id", createOperatorOptions.versionLocatorId());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<List<OperatorDeployResult>> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<List<OperatorDeployResult>>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get Operator(s) from a Kube cluster.
   *
   * Get Operator(s) from a Kube cluster.
   *
   * @param listOperatorsOptions the {@link ListOperatorsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link List}
   */
  public ServiceCall<List<OperatorDeployResult>> listOperators(ListOperatorsOptions listOperatorsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listOperatorsOptions,
      "listOperatorsOptions cannot be null");
    String[] pathSegments = { "deploy/kubernetes/olm/operator" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "listOperators");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("X-Auth-Refresh-Token", listOperatorsOptions.xAuthRefreshToken());
    builder.query("cluster_id", listOperatorsOptions.clusterId());
    builder.query("region", listOperatorsOptions.region());
    builder.query("version_locator_id", listOperatorsOptions.versionLocatorId());
    ResponseConverter<List<OperatorDeployResult>> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<List<OperatorDeployResult>>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update Operator(s) on a Kube cluster.
   *
   * Update Operator(s) on a Kube cluster.
   *
   * @param replaceOperatorOptions the {@link ReplaceOperatorOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link List}
   */
  public ServiceCall<List<OperatorDeployResult>> replaceOperator(ReplaceOperatorOptions replaceOperatorOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceOperatorOptions,
      "replaceOperatorOptions cannot be null");
    String[] pathSegments = { "deploy/kubernetes/olm/operator" };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "replaceOperator");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("X-Auth-Refresh-Token", replaceOperatorOptions.xAuthRefreshToken());
    final JsonObject contentJson = new JsonObject();
    if (replaceOperatorOptions.clusterId() != null) {
      contentJson.addProperty("cluster_id", replaceOperatorOptions.clusterId());
    }
    if (replaceOperatorOptions.region() != null) {
      contentJson.addProperty("region", replaceOperatorOptions.region());
    }
    if (replaceOperatorOptions.namespaces() != null) {
      contentJson.add("namespaces", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceOperatorOptions.namespaces()));
    }
    if (replaceOperatorOptions.versionLocatorId() != null) {
      contentJson.addProperty("version_locator_id", replaceOperatorOptions.versionLocatorId());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<List<OperatorDeployResult>> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<List<OperatorDeployResult>>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete Operator(s) from a Kube cluster.
   *
   * Delete Operator(s) from a Kube cluster.
   *
   * @param deleteOperatorOptions the {@link DeleteOperatorOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteOperator(DeleteOperatorOptions deleteOperatorOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteOperatorOptions,
      "deleteOperatorOptions cannot be null");
    String[] pathSegments = { "deploy/kubernetes/olm/operator" };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "deleteOperator");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("X-Auth-Refresh-Token", deleteOperatorOptions.xAuthRefreshToken());
    builder.query("cluster_id", deleteOperatorOptions.clusterId());
    builder.query("region", deleteOperatorOptions.region());
    builder.query("version_locator_id", deleteOperatorOptions.versionLocatorId());
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create an install.
   *
   * Create an install.
   *
   * @param installVersionOptions the {@link InstallVersionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> installVersion(InstallVersionOptions installVersionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(installVersionOptions,
      "installVersionOptions cannot be null");
    String[] pathSegments = { "versions", "install" };
    String[] pathParameters = { installVersionOptions.versionLocId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
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
    if (installVersionOptions.vcenterPassword() != null) {
      contentJson.addProperty("vcenter_password", installVersionOptions.vcenterPassword());
    }
    if (installVersionOptions.vcenterLocation() != null) {
      contentJson.addProperty("vcenter_location", installVersionOptions.vcenterLocation());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a preinstall.
   *
   * Create a preinstall.
   *
   * @param preinstallVersionOptions the {@link PreinstallVersionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> preinstallVersion(PreinstallVersionOptions preinstallVersionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(preinstallVersionOptions,
      "preinstallVersionOptions cannot be null");
    String[] pathSegments = { "versions", "preinstall" };
    String[] pathParameters = { preinstallVersionOptions.versionLocId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
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
    if (preinstallVersionOptions.vcenterPassword() != null) {
      contentJson.addProperty("vcenter_password", preinstallVersionOptions.vcenterPassword());
    }
    if (preinstallVersionOptions.vcenterLocation() != null) {
      contentJson.addProperty("vcenter_location", preinstallVersionOptions.vcenterLocation());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a preinstall.
   *
   * Get a preinstall.
   *
   * @param getPreinstallOptions the {@link GetPreinstallOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InstallStatus}
   */
  public ServiceCall<InstallStatus> getPreinstall(GetPreinstallOptions getPreinstallOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getPreinstallOptions,
      "getPreinstallOptions cannot be null");
    String[] pathSegments = { "versions", "preinstall" };
    String[] pathParameters = { getPreinstallOptions.versionLocId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getPreinstall");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("X-Auth-Refresh-Token", getPreinstallOptions.xAuthRefreshToken());
    if (getPreinstallOptions.clusterId() != null) {
      builder.query("cluster_id", getPreinstallOptions.clusterId());
    }
    if (getPreinstallOptions.region() != null) {
      builder.query("region", getPreinstallOptions.region());
    }
    if (getPreinstallOptions.namespace() != null) {
      builder.query("namespace", getPreinstallOptions.namespace());
    }
    ResponseConverter<InstallStatus> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<InstallStatus>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Validate a offering.
   *
   * Validate a offering.
   *
   * @param validationInstallOptions the {@link ValidationInstallOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> validationInstall(ValidationInstallOptions validationInstallOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(validationInstallOptions,
      "validationInstallOptions cannot be null");
    String[] pathSegments = { "versions", "validation/install" };
    String[] pathParameters = { validationInstallOptions.versionLocId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "validationInstall");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("X-Auth-Refresh-Token", validationInstallOptions.xAuthRefreshToken());
    final JsonObject contentJson = new JsonObject();
    if (validationInstallOptions.clusterId() != null) {
      contentJson.addProperty("cluster_id", validationInstallOptions.clusterId());
    }
    if (validationInstallOptions.region() != null) {
      contentJson.addProperty("region", validationInstallOptions.region());
    }
    if (validationInstallOptions.namespace() != null) {
      contentJson.addProperty("namespace", validationInstallOptions.namespace());
    }
    if (validationInstallOptions.overrideValues() != null) {
      contentJson.add("override_values", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(validationInstallOptions.overrideValues()));
    }
    if (validationInstallOptions.entitlementApikey() != null) {
      contentJson.addProperty("entitlement_apikey", validationInstallOptions.entitlementApikey());
    }
    if (validationInstallOptions.schematics() != null) {
      contentJson.add("schematics", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(validationInstallOptions.schematics()));
    }
    if (validationInstallOptions.script() != null) {
      contentJson.addProperty("script", validationInstallOptions.script());
    }
    if (validationInstallOptions.scriptId() != null) {
      contentJson.addProperty("script_id", validationInstallOptions.scriptId());
    }
    if (validationInstallOptions.versionLocatorId() != null) {
      contentJson.addProperty("version_locator_id", validationInstallOptions.versionLocatorId());
    }
    if (validationInstallOptions.vcenterId() != null) {
      contentJson.addProperty("vcenter_id", validationInstallOptions.vcenterId());
    }
    if (validationInstallOptions.vcenterPassword() != null) {
      contentJson.addProperty("vcenter_password", validationInstallOptions.vcenterPassword());
    }
    if (validationInstallOptions.vcenterLocation() != null) {
      contentJson.addProperty("vcenter_location", validationInstallOptions.vcenterLocation());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Returns the install status for the specified offering version.
   *
   * Returns the install status for the specified offering version.
   *
   * @param getValidationStatusOptions the {@link GetValidationStatusOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Validation}
   */
  public ServiceCall<Validation> getValidationStatus(GetValidationStatusOptions getValidationStatusOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getValidationStatusOptions,
      "getValidationStatusOptions cannot be null");
    String[] pathSegments = { "versions", "validation/install" };
    String[] pathParameters = { getValidationStatusOptions.versionLocId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
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
   * Returns the override values that were used to validate the specified offering version.
   *
   * Returns the override values that were used to validate the specified offering version.
   *
   * @param getOverrideValuesOptions the {@link GetOverrideValuesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Map}
   */
  public ServiceCall<Map<String, Object>> getOverrideValues(GetOverrideValuesOptions getOverrideValuesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getOverrideValuesOptions,
      "getOverrideValuesOptions cannot be null");
    String[] pathSegments = { "versions", "validation/overridevalues" };
    String[] pathParameters = { getOverrideValuesOptions.versionLocId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
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
   * Returns the schematics workspaces for the specified offering version.
   *
   * Returns the schematics workspaces for the specified offering version.
   *
   * @param getSchematicsWorkspacesOptions the {@link GetSchematicsWorkspacesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link SchematicsWorkspaceSearchResult}
   */
  public ServiceCall<SchematicsWorkspaceSearchResult> getSchematicsWorkspaces(GetSchematicsWorkspacesOptions getSchematicsWorkspacesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getSchematicsWorkspacesOptions,
      "getSchematicsWorkspacesOptions cannot be null");
    String[] pathSegments = { "versions", "workspaces" };
    String[] pathParameters = { getSchematicsWorkspacesOptions.versionLocId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getSchematicsWorkspaces");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("X-Auth-Refresh-Token", getSchematicsWorkspacesOptions.xAuthRefreshToken());
    ResponseConverter<SchematicsWorkspaceSearchResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<SchematicsWorkspaceSearchResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Returns the schematics permissions for the specified user.
   *
   * Returns the schematics permissions for the specified user.
   *
   * @param canDeploySchematicsOptions the {@link CanDeploySchematicsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DeployRequirementsCheck}
   */
  public ServiceCall<DeployRequirementsCheck> canDeploySchematics(CanDeploySchematicsOptions canDeploySchematicsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(canDeploySchematicsOptions,
      "canDeploySchematicsOptions cannot be null");
    String[] pathSegments = { "versions", "candeploy" };
    String[] pathParameters = { canDeploySchematicsOptions.versionLocId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "canDeploySchematics");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("cluster_id", canDeploySchematicsOptions.clusterId());
    builder.query("region", canDeploySchematicsOptions.region());
    if (canDeploySchematicsOptions.namespace() != null) {
      builder.query("namespace", canDeploySchematicsOptions.namespace());
    }
    if (canDeploySchematicsOptions.resourceGroupId() != null) {
      builder.query("resource_group_id", canDeploySchematicsOptions.resourceGroupId());
    }
    ResponseConverter<DeployRequirementsCheck> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DeployRequirementsCheck>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Returns all active resource groups in the current account, where the current user has permission to create schematics workspaces.
   *
   * Returns all active resource groups in the current account, where the current user has permission to create
   * schematics workspaces.
   *
   * @param getResourceGroupsOptions the {@link GetResourceGroupsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceGroups}
   */
  public ServiceCall<ResourceGroups> getResourceGroups(GetResourceGroupsOptions getResourceGroupsOptions) {
    String[] pathSegments = { "deploy/schematics/resourcegroups" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getResourceGroups");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<ResourceGroups> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceGroups>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Returns all active resource groups in the current account, where the current user has permission to create schematics workspaces.
   *
   * Returns all active resource groups in the current account, where the current user has permission to create
   * schematics workspaces.
   *
   * @return a {@link ServiceCall} with a result of type {@link ResourceGroups}
   */
  public ServiceCall<ResourceGroups> getResourceGroups() {
    return getResourceGroups(null);
  }

  /**
   * Get license providers.
   *
   * Get license providers.
   *
   * @param getLicenseProvidersOptions the {@link GetLicenseProvidersOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link LicenseProviders}
   */
  public ServiceCall<LicenseProviders> getLicenseProviders(GetLicenseProvidersOptions getLicenseProvidersOptions) {
    String[] pathSegments = { "license/license_providers" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getLicenseProviders");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<LicenseProviders> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<LicenseProviders>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get license providers.
   *
   * Get license providers.
   *
   * @return a {@link ServiceCall} with a result of type {@link LicenseProviders}
   */
  public ServiceCall<LicenseProviders> getLicenseProviders() {
    return getLicenseProviders(null);
  }

  /**
   * Get license entitlements.
   *
   * Get license entitlements bound to an account.
   *
   * @param listLicenseEntitlementsOptions the {@link ListLicenseEntitlementsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link LicenseEntitlements}
   */
  public ServiceCall<LicenseEntitlements> listLicenseEntitlements(ListLicenseEntitlementsOptions listLicenseEntitlementsOptions) {
    String[] pathSegments = { "license/entitlements" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "listLicenseEntitlements");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listLicenseEntitlementsOptions != null) {
      if (listLicenseEntitlementsOptions.accountId() != null) {
        builder.query("account_id", listLicenseEntitlementsOptions.accountId());
      }
      if (listLicenseEntitlementsOptions.licenseProductId() != null) {
        builder.query("license_product_id", listLicenseEntitlementsOptions.licenseProductId());
      }
      if (listLicenseEntitlementsOptions.versionId() != null) {
        builder.query("version_id", listLicenseEntitlementsOptions.versionId());
      }
      if (listLicenseEntitlementsOptions.state() != null) {
        builder.query("state", listLicenseEntitlementsOptions.state());
      }
    }
    ResponseConverter<LicenseEntitlements> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<LicenseEntitlements>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get license entitlements.
   *
   * Get license entitlements bound to an account.
   *
   * @return a {@link ServiceCall} with a result of type {@link LicenseEntitlements}
   */
  public ServiceCall<LicenseEntitlements> listLicenseEntitlements() {
    return listLicenseEntitlements(null);
  }

  /**
   * Create a license entitlement.
   *
   * Create an entitlement for a Cloud account.  This is used to give an account an entitlement to a license.
   *
   * @param createLicenseEntitlementOptions the {@link CreateLicenseEntitlementOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link LicenseEntitlement}
   */
  public ServiceCall<LicenseEntitlement> createLicenseEntitlement(CreateLicenseEntitlementOptions createLicenseEntitlementOptions) {
    String[] pathSegments = { "license/entitlements" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "createLicenseEntitlement");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createLicenseEntitlementOptions != null) {
      if (createLicenseEntitlementOptions.accountId() != null) {
        builder.query("account_id", createLicenseEntitlementOptions.accountId());
      }
      final JsonObject contentJson = new JsonObject();
      if (createLicenseEntitlementOptions.name() != null) {
        contentJson.addProperty("name", createLicenseEntitlementOptions.name());
      }
      if (createLicenseEntitlementOptions.effectiveFrom() != null) {
        contentJson.addProperty("effective_from", createLicenseEntitlementOptions.effectiveFrom());
      }
      if (createLicenseEntitlementOptions.effectiveUntil() != null) {
        contentJson.addProperty("effective_until", createLicenseEntitlementOptions.effectiveUntil());
      }
      if (createLicenseEntitlementOptions.versionId() != null) {
        contentJson.addProperty("version_id", createLicenseEntitlementOptions.versionId());
      }
      if (createLicenseEntitlementOptions.licenseId() != null) {
        contentJson.addProperty("license_id", createLicenseEntitlementOptions.licenseId());
      }
      if (createLicenseEntitlementOptions.licenseOwnerId() != null) {
        contentJson.addProperty("license_owner_id", createLicenseEntitlementOptions.licenseOwnerId());
      }
      if (createLicenseEntitlementOptions.licenseProviderId() != null) {
        contentJson.addProperty("license_provider_id", createLicenseEntitlementOptions.licenseProviderId());
      }
      if (createLicenseEntitlementOptions.licenseProductId() != null) {
        contentJson.addProperty("license_product_id", createLicenseEntitlementOptions.licenseProductId());
      }
      builder.bodyJson(contentJson);
    }
    ResponseConverter<LicenseEntitlement> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<LicenseEntitlement>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a license entitlement.
   *
   * Create an entitlement for a Cloud account.  This is used to give an account an entitlement to a license.
   *
   * @return a {@link ServiceCall} with a result of type {@link LicenseEntitlement}
   */
  public ServiceCall<LicenseEntitlement> createLicenseEntitlement() {
    return createLicenseEntitlement(null);
  }

  /**
   * Get entitlements for a specific license product ID.
   *
   * Get an entitlements for a specific license product ID bound to an account.
   *
   * @param getLicenseEntitlementsOptions the {@link GetLicenseEntitlementsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link LicenseEntitlements}
   */
  public ServiceCall<LicenseEntitlements> getLicenseEntitlements(GetLicenseEntitlementsOptions getLicenseEntitlementsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getLicenseEntitlementsOptions,
      "getLicenseEntitlementsOptions cannot be null");
    String[] pathSegments = { "license/entitlements/productID" };
    String[] pathParameters = { getLicenseEntitlementsOptions.licenseProductId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getLicenseEntitlements");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getLicenseEntitlementsOptions.accountId() != null) {
      builder.query("account_id", getLicenseEntitlementsOptions.accountId());
    }
    if (getLicenseEntitlementsOptions.versionId() != null) {
      builder.query("version_id", getLicenseEntitlementsOptions.versionId());
    }
    ResponseConverter<LicenseEntitlements> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<LicenseEntitlements>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete license entitlement.
   *
   * Delete a license entitlement that is bound to an account. Note that BSS will mark the entitlement field "state":
   * "removed".
   *
   * @param deleteLicenseEntitlementOptions the {@link DeleteLicenseEntitlementOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteLicenseEntitlement(DeleteLicenseEntitlementOptions deleteLicenseEntitlementOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteLicenseEntitlementOptions,
      "deleteLicenseEntitlementOptions cannot be null");
    String[] pathSegments = { "license/entitlements" };
    String[] pathParameters = { deleteLicenseEntitlementOptions.entitlementId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "deleteLicenseEntitlement");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (deleteLicenseEntitlementOptions.accountId() != null) {
      builder.query("account_id", deleteLicenseEntitlementOptions.accountId());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get licenses.
   *
   * Retrieve available licenses from supported license subsystems.  This is used to get the list of available licenses
   * that the user has.
   *
   * @param getLicensesOptions the {@link GetLicensesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Licenses}
   */
  public ServiceCall<Licenses> getLicenses(GetLicensesOptions getLicensesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getLicensesOptions,
      "getLicensesOptions cannot be null");
    String[] pathSegments = { "license/licenses" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "getLicenses");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("license_provider_id", getLicensesOptions.licenseProviderId());
    if (getLicensesOptions.accountId() != null) {
      builder.query("account_id", getLicensesOptions.accountId());
    }
    if (getLicensesOptions.name() != null) {
      builder.query("name", getLicensesOptions.name());
    }
    if (getLicensesOptions.licenseType() != null) {
      builder.query("license_type", getLicensesOptions.licenseType());
    }
    if (getLicensesOptions.licenseProductId() != null) {
      builder.query("license_product_id", getLicensesOptions.licenseProductId());
    }
    ResponseConverter<Licenses> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Licenses>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Search for versions.
   *
   * Search across accounts for all versions usig a particular license, requires global admin permission.
   *
   * @param searchLicenseVersionsOptions the {@link SearchLicenseVersionsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> searchLicenseVersions(SearchLicenseVersionsOptions searchLicenseVersionsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(searchLicenseVersionsOptions,
      "searchLicenseVersionsOptions cannot be null");
    String[] pathSegments = { "search/license/versions" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "searchLicenseVersions");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("q", searchLicenseVersionsOptions.q());
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Search for Offerings.
   *
   * Search across accounts for all offerings using a particular license, requires global admin permission.
   *
   * @param searchLicenseOfferingsOptions the {@link SearchLicenseOfferingsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> searchLicenseOfferings(SearchLicenseOfferingsOptions searchLicenseOfferingsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(searchLicenseOfferingsOptions,
      "searchLicenseOfferingsOptions cannot be null");
    String[] pathSegments = { "search/license/offerings" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("catalog_management", "v1", "searchLicenseOfferings");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("q", searchLicenseOfferingsOptions.q());
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

}
