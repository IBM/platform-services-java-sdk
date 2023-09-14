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
 * IBM OpenAPI SDK Code Generator Version: 3.75.0-726bc7e3-20230713-221716
 */

package com.ibm.cloud.platform_services.usage_reports.v4;

import com.google.gson.JsonObject;
import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.platform_services.usage_reports.v4.model.AccountSummary;
import com.ibm.cloud.platform_services.usage_reports.v4.model.AccountUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.model.CreateReportsSnapshotConfigOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.DeleteReportsSnapshotConfigOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetAccountSummaryOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetAccountUsageOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetOrgUsageOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetReportsSnapshotConfigOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetReportsSnapshotOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceGroupUsageOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceUsageAccountOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceUsageOrgOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceUsageResourceGroupOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.InstancesUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.model.OrgUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.model.ResourceGroupUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.model.SnapshotConfig;
import com.ibm.cloud.platform_services.usage_reports.v4.model.SnapshotList;
import com.ibm.cloud.platform_services.usage_reports.v4.model.UpdateReportsSnapshotConfigOptions;
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
 * Usage reports for IBM Cloud accounts.
 *
 * API Version: 4.0.6
 */
public class UsageReports extends BaseService {

  /**
   * Default service name used when configuring the `UsageReports` client.
   */
  public static final String DEFAULT_SERVICE_NAME = "usage_reports";

  /**
   * Default service endpoint URL.
   */
  public static final String DEFAULT_SERVICE_URL = "https://billing.cloud.ibm.com";

 /**
   * Class method which constructs an instance of the `UsageReports` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `UsageReports` client using external configuration
   */
  public static UsageReports newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `UsageReports` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `UsageReports` client using external configuration
   */
  public static UsageReports newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    UsageReports service = new UsageReports(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `UsageReports` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public UsageReports(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * Get account summary.
   *
   * Returns the summary for the account for a given month. Account billing managers are authorized to access this
   * report.
   *
   * @param getAccountSummaryOptions the {@link GetAccountSummaryOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AccountSummary}
   */
  public ServiceCall<AccountSummary> getAccountSummary(GetAccountSummaryOptions getAccountSummaryOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getAccountSummaryOptions,
      "getAccountSummaryOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", getAccountSummaryOptions.accountId());
    pathParamsMap.put("billingmonth", getAccountSummaryOptions.billingmonth());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v4/accounts/{account_id}/summary/{billingmonth}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("usage_reports", "v4", "getAccountSummary");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<AccountSummary> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AccountSummary>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get account usage.
   *
   * Usage for all the resources and plans in an account for a given month. Account billing managers are authorized to
   * access this report.
   *
   * @param getAccountUsageOptions the {@link GetAccountUsageOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AccountUsage}
   */
  public ServiceCall<AccountUsage> getAccountUsage(GetAccountUsageOptions getAccountUsageOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getAccountUsageOptions,
      "getAccountUsageOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", getAccountUsageOptions.accountId());
    pathParamsMap.put("billingmonth", getAccountUsageOptions.billingmonth());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v4/accounts/{account_id}/usage/{billingmonth}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("usage_reports", "v4", "getAccountUsage");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getAccountUsageOptions.acceptLanguage() != null) {
      builder.header("Accept-Language", getAccountUsageOptions.acceptLanguage());
    }
    if (getAccountUsageOptions.names() != null) {
      builder.query("_names", String.valueOf(getAccountUsageOptions.names()));
    }
    ResponseConverter<AccountUsage> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AccountUsage>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get resource group usage.
   *
   * Usage for all the resources and plans in a resource group in a given month. Account billing managers or resource
   * group billing managers are authorized to access this report.
   *
   * @param getResourceGroupUsageOptions the {@link GetResourceGroupUsageOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceGroupUsage}
   */
  public ServiceCall<ResourceGroupUsage> getResourceGroupUsage(GetResourceGroupUsageOptions getResourceGroupUsageOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getResourceGroupUsageOptions,
      "getResourceGroupUsageOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", getResourceGroupUsageOptions.accountId());
    pathParamsMap.put("resource_group_id", getResourceGroupUsageOptions.resourceGroupId());
    pathParamsMap.put("billingmonth", getResourceGroupUsageOptions.billingmonth());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v4/accounts/{account_id}/resource_groups/{resource_group_id}/usage/{billingmonth}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("usage_reports", "v4", "getResourceGroupUsage");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getResourceGroupUsageOptions.acceptLanguage() != null) {
      builder.header("Accept-Language", getResourceGroupUsageOptions.acceptLanguage());
    }
    if (getResourceGroupUsageOptions.names() != null) {
      builder.query("_names", String.valueOf(getResourceGroupUsageOptions.names()));
    }
    ResponseConverter<ResourceGroupUsage> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceGroupUsage>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get resource instance usage in an account.
   *
   * Query for resource instance usage in an account. Filter the results with query parameters. Account billing
   * administrator is authorized to access this report.
   *
   * @param getResourceUsageAccountOptions the {@link GetResourceUsageAccountOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InstancesUsage}
   */
  public ServiceCall<InstancesUsage> getResourceUsageAccount(GetResourceUsageAccountOptions getResourceUsageAccountOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getResourceUsageAccountOptions,
      "getResourceUsageAccountOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", getResourceUsageAccountOptions.accountId());
    pathParamsMap.put("billingmonth", getResourceUsageAccountOptions.billingmonth());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v4/accounts/{account_id}/resource_instances/usage/{billingmonth}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("usage_reports", "v4", "getResourceUsageAccount");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getResourceUsageAccountOptions.acceptLanguage() != null) {
      builder.header("Accept-Language", getResourceUsageAccountOptions.acceptLanguage());
    }
    if (getResourceUsageAccountOptions.names() != null) {
      builder.query("_names", String.valueOf(getResourceUsageAccountOptions.names()));
    }
    if (getResourceUsageAccountOptions.limit() != null) {
      builder.query("_limit", String.valueOf(getResourceUsageAccountOptions.limit()));
    }
    if (getResourceUsageAccountOptions.start() != null) {
      builder.query("_start", String.valueOf(getResourceUsageAccountOptions.start()));
    }
    if (getResourceUsageAccountOptions.resourceGroupId() != null) {
      builder.query("resource_group_id", String.valueOf(getResourceUsageAccountOptions.resourceGroupId()));
    }
    if (getResourceUsageAccountOptions.organizationId() != null) {
      builder.query("organization_id", String.valueOf(getResourceUsageAccountOptions.organizationId()));
    }
    if (getResourceUsageAccountOptions.resourceInstanceId() != null) {
      builder.query("resource_instance_id", String.valueOf(getResourceUsageAccountOptions.resourceInstanceId()));
    }
    if (getResourceUsageAccountOptions.resourceId() != null) {
      builder.query("resource_id", String.valueOf(getResourceUsageAccountOptions.resourceId()));
    }
    if (getResourceUsageAccountOptions.planId() != null) {
      builder.query("plan_id", String.valueOf(getResourceUsageAccountOptions.planId()));
    }
    if (getResourceUsageAccountOptions.region() != null) {
      builder.query("region", String.valueOf(getResourceUsageAccountOptions.region()));
    }
    ResponseConverter<InstancesUsage> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<InstancesUsage>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get resource instance usage in a resource group.
   *
   * Query for resource instance usage in a resource group. Filter the results with query parameters. Account billing
   * administrator and resource group billing administrators are authorized to access this report.
   *
   * @param getResourceUsageResourceGroupOptions the {@link GetResourceUsageResourceGroupOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InstancesUsage}
   */
  public ServiceCall<InstancesUsage> getResourceUsageResourceGroup(GetResourceUsageResourceGroupOptions getResourceUsageResourceGroupOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getResourceUsageResourceGroupOptions,
      "getResourceUsageResourceGroupOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", getResourceUsageResourceGroupOptions.accountId());
    pathParamsMap.put("resource_group_id", getResourceUsageResourceGroupOptions.resourceGroupId());
    pathParamsMap.put("billingmonth", getResourceUsageResourceGroupOptions.billingmonth());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v4/accounts/{account_id}/resource_groups/{resource_group_id}/resource_instances/usage/{billingmonth}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("usage_reports", "v4", "getResourceUsageResourceGroup");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getResourceUsageResourceGroupOptions.acceptLanguage() != null) {
      builder.header("Accept-Language", getResourceUsageResourceGroupOptions.acceptLanguage());
    }
    if (getResourceUsageResourceGroupOptions.names() != null) {
      builder.query("_names", String.valueOf(getResourceUsageResourceGroupOptions.names()));
    }
    if (getResourceUsageResourceGroupOptions.limit() != null) {
      builder.query("_limit", String.valueOf(getResourceUsageResourceGroupOptions.limit()));
    }
    if (getResourceUsageResourceGroupOptions.start() != null) {
      builder.query("_start", String.valueOf(getResourceUsageResourceGroupOptions.start()));
    }
    if (getResourceUsageResourceGroupOptions.resourceInstanceId() != null) {
      builder.query("resource_instance_id", String.valueOf(getResourceUsageResourceGroupOptions.resourceInstanceId()));
    }
    if (getResourceUsageResourceGroupOptions.resourceId() != null) {
      builder.query("resource_id", String.valueOf(getResourceUsageResourceGroupOptions.resourceId()));
    }
    if (getResourceUsageResourceGroupOptions.planId() != null) {
      builder.query("plan_id", String.valueOf(getResourceUsageResourceGroupOptions.planId()));
    }
    if (getResourceUsageResourceGroupOptions.region() != null) {
      builder.query("region", String.valueOf(getResourceUsageResourceGroupOptions.region()));
    }
    ResponseConverter<InstancesUsage> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<InstancesUsage>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get resource instance usage in an organization.
   *
   * Query for resource instance usage in an organization. Filter the results with query parameters. Account billing
   * administrator and organization billing administrators are authorized to access this report.
   *
   * @param getResourceUsageOrgOptions the {@link GetResourceUsageOrgOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InstancesUsage}
   */
  public ServiceCall<InstancesUsage> getResourceUsageOrg(GetResourceUsageOrgOptions getResourceUsageOrgOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getResourceUsageOrgOptions,
      "getResourceUsageOrgOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", getResourceUsageOrgOptions.accountId());
    pathParamsMap.put("organization_id", getResourceUsageOrgOptions.organizationId());
    pathParamsMap.put("billingmonth", getResourceUsageOrgOptions.billingmonth());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v4/accounts/{account_id}/organizations/{organization_id}/resource_instances/usage/{billingmonth}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("usage_reports", "v4", "getResourceUsageOrg");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getResourceUsageOrgOptions.acceptLanguage() != null) {
      builder.header("Accept-Language", getResourceUsageOrgOptions.acceptLanguage());
    }
    if (getResourceUsageOrgOptions.names() != null) {
      builder.query("_names", String.valueOf(getResourceUsageOrgOptions.names()));
    }
    if (getResourceUsageOrgOptions.limit() != null) {
      builder.query("_limit", String.valueOf(getResourceUsageOrgOptions.limit()));
    }
    if (getResourceUsageOrgOptions.start() != null) {
      builder.query("_start", String.valueOf(getResourceUsageOrgOptions.start()));
    }
    if (getResourceUsageOrgOptions.resourceInstanceId() != null) {
      builder.query("resource_instance_id", String.valueOf(getResourceUsageOrgOptions.resourceInstanceId()));
    }
    if (getResourceUsageOrgOptions.resourceId() != null) {
      builder.query("resource_id", String.valueOf(getResourceUsageOrgOptions.resourceId()));
    }
    if (getResourceUsageOrgOptions.planId() != null) {
      builder.query("plan_id", String.valueOf(getResourceUsageOrgOptions.planId()));
    }
    if (getResourceUsageOrgOptions.region() != null) {
      builder.query("region", String.valueOf(getResourceUsageOrgOptions.region()));
    }
    ResponseConverter<InstancesUsage> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<InstancesUsage>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get organization usage.
   *
   * Usage for all the resources and plans in an organization in a given month. Account billing managers or organization
   * billing managers are authorized to access this report.
   *
   * @param getOrgUsageOptions the {@link GetOrgUsageOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link OrgUsage}
   */
  public ServiceCall<OrgUsage> getOrgUsage(GetOrgUsageOptions getOrgUsageOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getOrgUsageOptions,
      "getOrgUsageOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", getOrgUsageOptions.accountId());
    pathParamsMap.put("organization_id", getOrgUsageOptions.organizationId());
    pathParamsMap.put("billingmonth", getOrgUsageOptions.billingmonth());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v4/accounts/{account_id}/organizations/{organization_id}/usage/{billingmonth}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("usage_reports", "v4", "getOrgUsage");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getOrgUsageOptions.acceptLanguage() != null) {
      builder.header("Accept-Language", getOrgUsageOptions.acceptLanguage());
    }
    if (getOrgUsageOptions.names() != null) {
      builder.query("_names", String.valueOf(getOrgUsageOptions.names()));
    }
    ResponseConverter<OrgUsage> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<OrgUsage>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Setup the snapshot configuration.
   *
   * Snapshots of the billing reports would be taken on a periodic interval and stored based on the configuration setup
   * by the customer for the given Account Id.
   *
   * @param createReportsSnapshotConfigOptions the {@link CreateReportsSnapshotConfigOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link SnapshotConfig}
   */
  public ServiceCall<SnapshotConfig> createReportsSnapshotConfig(CreateReportsSnapshotConfigOptions createReportsSnapshotConfigOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createReportsSnapshotConfigOptions,
      "createReportsSnapshotConfigOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/billing-reports-snapshot-config"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("usage_reports", "v4", "createReportsSnapshotConfig");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("account_id", createReportsSnapshotConfigOptions.accountId());
    contentJson.addProperty("interval", createReportsSnapshotConfigOptions.interval());
    contentJson.addProperty("cos_bucket", createReportsSnapshotConfigOptions.cosBucket());
    contentJson.addProperty("cos_location", createReportsSnapshotConfigOptions.cosLocation());
    if (createReportsSnapshotConfigOptions.cosReportsFolder() != null) {
      contentJson.addProperty("cos_reports_folder", createReportsSnapshotConfigOptions.cosReportsFolder());
    }
    if (createReportsSnapshotConfigOptions.reportTypes() != null) {
      contentJson.add("report_types", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createReportsSnapshotConfigOptions.reportTypes()));
    }
    if (createReportsSnapshotConfigOptions.versioning() != null) {
      contentJson.addProperty("versioning", createReportsSnapshotConfigOptions.versioning());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<SnapshotConfig> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<SnapshotConfig>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Fetch the snapshot configuration.
   *
   * Returns the configuration of snapshot of the billing reports setup by the customer for the given Account Id.
   *
   * @param getReportsSnapshotConfigOptions the {@link GetReportsSnapshotConfigOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link SnapshotConfig}
   */
  public ServiceCall<SnapshotConfig> getReportsSnapshotConfig(GetReportsSnapshotConfigOptions getReportsSnapshotConfigOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getReportsSnapshotConfigOptions,
      "getReportsSnapshotConfigOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/billing-reports-snapshot-config"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("usage_reports", "v4", "getReportsSnapshotConfig");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("account_id", String.valueOf(getReportsSnapshotConfigOptions.accountId()));
    ResponseConverter<SnapshotConfig> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<SnapshotConfig>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update the snapshot configuration.
   *
   * Updates the configuration of snapshot of the billing reports setup by the customer for the given Account Id.
   *
   * @param updateReportsSnapshotConfigOptions the {@link UpdateReportsSnapshotConfigOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link SnapshotConfig}
   */
  public ServiceCall<SnapshotConfig> updateReportsSnapshotConfig(UpdateReportsSnapshotConfigOptions updateReportsSnapshotConfigOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateReportsSnapshotConfigOptions,
      "updateReportsSnapshotConfigOptions cannot be null");
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/billing-reports-snapshot-config"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("usage_reports", "v4", "updateReportsSnapshotConfig");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("account_id", updateReportsSnapshotConfigOptions.accountId());
    if (updateReportsSnapshotConfigOptions.interval() != null) {
      contentJson.addProperty("interval", updateReportsSnapshotConfigOptions.interval());
    }
    if (updateReportsSnapshotConfigOptions.cosBucket() != null) {
      contentJson.addProperty("cos_bucket", updateReportsSnapshotConfigOptions.cosBucket());
    }
    if (updateReportsSnapshotConfigOptions.cosLocation() != null) {
      contentJson.addProperty("cos_location", updateReportsSnapshotConfigOptions.cosLocation());
    }
    if (updateReportsSnapshotConfigOptions.cosReportsFolder() != null) {
      contentJson.addProperty("cos_reports_folder", updateReportsSnapshotConfigOptions.cosReportsFolder());
    }
    if (updateReportsSnapshotConfigOptions.reportTypes() != null) {
      contentJson.add("report_types", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateReportsSnapshotConfigOptions.reportTypes()));
    }
    if (updateReportsSnapshotConfigOptions.versioning() != null) {
      contentJson.addProperty("versioning", updateReportsSnapshotConfigOptions.versioning());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<SnapshotConfig> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<SnapshotConfig>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete the snapshot configuration.
   *
   * Delete the configuration of snapshot of the billing reports setup by the customer for the given Account Id.
   *
   * @param deleteReportsSnapshotConfigOptions the {@link DeleteReportsSnapshotConfigOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteReportsSnapshotConfig(DeleteReportsSnapshotConfigOptions deleteReportsSnapshotConfigOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteReportsSnapshotConfigOptions,
      "deleteReportsSnapshotConfigOptions cannot be null");
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/billing-reports-snapshot-config"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("usage_reports", "v4", "deleteReportsSnapshotConfig");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.query("account_id", String.valueOf(deleteReportsSnapshotConfigOptions.accountId()));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Fetch the current or past snapshots.
   *
   * Returns the billing reports snapshots captured for the given Account Id in the specific time period.
   *
   * @param getReportsSnapshotOptions the {@link GetReportsSnapshotOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link SnapshotList}
   */
  public ServiceCall<SnapshotList> getReportsSnapshot(GetReportsSnapshotOptions getReportsSnapshotOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getReportsSnapshotOptions,
      "getReportsSnapshotOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/billing-reports-snapshots"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("usage_reports", "v4", "getReportsSnapshot");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("account_id", String.valueOf(getReportsSnapshotOptions.accountId()));
    builder.query("month", String.valueOf(getReportsSnapshotOptions.month()));
    if (getReportsSnapshotOptions.dateFrom() != null) {
      builder.query("date_from", String.valueOf(getReportsSnapshotOptions.dateFrom()));
    }
    if (getReportsSnapshotOptions.dateTo() != null) {
      builder.query("date_to", String.valueOf(getReportsSnapshotOptions.dateTo()));
    }
    ResponseConverter<SnapshotList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<SnapshotList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}
