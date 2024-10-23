/*
 * (C) Copyright IBM Corp. 2024.
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
 * IBM OpenAPI SDK Code Generator Version: 3.96.0-d6dec9d7-20241008-212902
 */

package com.ibm.cloud.platform_services.partner_management.v1;

import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.platform_services.partner_management.v1.model.BillingOptionsSummary;
import com.ibm.cloud.platform_services.partner_management.v1.model.CreditPoolsReportSummary;
import com.ibm.cloud.platform_services.partner_management.v1.model.GetBillingOptionsOptions;
import com.ibm.cloud.platform_services.partner_management.v1.model.GetCreditPoolsReportOptions;
import com.ibm.cloud.platform_services.partner_management.v1.model.GetResourceUsageReportOptions;
import com.ibm.cloud.platform_services.partner_management.v1.model.PartnerUsageReportSummary;
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
 * The Partner Management APIs enable you to manage the IBM Cloud partner entities and fetch multiple reports in
 * different formats.
 *
 * API Version: 1.0.0
 */
public class PartnerManagement extends BaseService {

  /**
   * Default service name used when configuring the `PartnerManagement` client.
   */
  public static final String DEFAULT_SERVICE_NAME = "partner_management";

  /**
   * Default service endpoint URL.
   */
  public static final String DEFAULT_SERVICE_URL = "https://partner.cloud.ibm.com";

 /**
   * Class method which constructs an instance of the `PartnerManagement` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `PartnerManagement` client using external configuration
   */
  public static PartnerManagement newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `PartnerManagement` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `PartnerManagement` client using external configuration
   */
  public static PartnerManagement newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    PartnerManagement service = new PartnerManagement(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `PartnerManagement` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public PartnerManagement(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * Get partner resource usage report.
   *
   * Returns the summary for the partner for a given month. Partner billing managers are authorized to access this
   * report.
   *
   * @param getResourceUsageReportOptions the {@link GetResourceUsageReportOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PartnerUsageReportSummary}
   */
  public ServiceCall<PartnerUsageReportSummary> getResourceUsageReport(GetResourceUsageReportOptions getResourceUsageReportOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getResourceUsageReportOptions,
      "getResourceUsageReportOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/resource-usage-reports"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("partner_management", "v1", "getResourceUsageReport");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("partner_id", String.valueOf(getResourceUsageReportOptions.partnerId()));
    if (getResourceUsageReportOptions.resellerId() != null) {
      builder.query("reseller_id", String.valueOf(getResourceUsageReportOptions.resellerId()));
    }
    if (getResourceUsageReportOptions.customerId() != null) {
      builder.query("customer_id", String.valueOf(getResourceUsageReportOptions.customerId()));
    }
    if (getResourceUsageReportOptions.children() != null) {
      builder.query("children", String.valueOf(getResourceUsageReportOptions.children()));
    }
    if (getResourceUsageReportOptions.month() != null) {
      builder.query("month", String.valueOf(getResourceUsageReportOptions.month()));
    }
    if (getResourceUsageReportOptions.viewpoint() != null) {
      builder.query("viewpoint", String.valueOf(getResourceUsageReportOptions.viewpoint()));
    }
    if (getResourceUsageReportOptions.recurse() != null) {
      builder.query("recurse", String.valueOf(getResourceUsageReportOptions.recurse()));
    }
    if (getResourceUsageReportOptions.limit() != null) {
      builder.query("limit", String.valueOf(getResourceUsageReportOptions.limit()));
    }
    if (getResourceUsageReportOptions.offset() != null) {
      builder.query("offset", String.valueOf(getResourceUsageReportOptions.offset()));
    }
    ResponseConverter<PartnerUsageReportSummary> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PartnerUsageReportSummary>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get customers billing options.
   *
   * Returns the billing options for the requested customer for a given month.
   *
   * @param getBillingOptionsOptions the {@link GetBillingOptionsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link BillingOptionsSummary}
   */
  public ServiceCall<BillingOptionsSummary> getBillingOptions(GetBillingOptionsOptions getBillingOptionsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getBillingOptionsOptions,
      "getBillingOptionsOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/billing-options"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("partner_management", "v1", "getBillingOptions");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("partner_id", String.valueOf(getBillingOptionsOptions.partnerId()));
    if (getBillingOptionsOptions.customerId() != null) {
      builder.query("customer_id", String.valueOf(getBillingOptionsOptions.customerId()));
    }
    if (getBillingOptionsOptions.resellerId() != null) {
      builder.query("reseller_id", String.valueOf(getBillingOptionsOptions.resellerId()));
    }
    if (getBillingOptionsOptions.date() != null) {
      builder.query("date", String.valueOf(getBillingOptionsOptions.date()));
    }
    if (getBillingOptionsOptions.limit() != null) {
      builder.query("limit", String.valueOf(getBillingOptionsOptions.limit()));
    }
    ResponseConverter<BillingOptionsSummary> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<BillingOptionsSummary>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get credit pools report.
   *
   * Returns the subscription or commitment burn-down reports for the end customers for a given month.
   *
   * @param getCreditPoolsReportOptions the {@link GetCreditPoolsReportOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CreditPoolsReportSummary}
   */
  public ServiceCall<CreditPoolsReportSummary> getCreditPoolsReport(GetCreditPoolsReportOptions getCreditPoolsReportOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getCreditPoolsReportOptions,
      "getCreditPoolsReportOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/credit-pools"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("partner_management", "v1", "getCreditPoolsReport");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("partner_id", String.valueOf(getCreditPoolsReportOptions.partnerId()));
    if (getCreditPoolsReportOptions.customerId() != null) {
      builder.query("customer_id", String.valueOf(getCreditPoolsReportOptions.customerId()));
    }
    if (getCreditPoolsReportOptions.resellerId() != null) {
      builder.query("reseller_id", String.valueOf(getCreditPoolsReportOptions.resellerId()));
    }
    if (getCreditPoolsReportOptions.date() != null) {
      builder.query("date", String.valueOf(getCreditPoolsReportOptions.date()));
    }
    if (getCreditPoolsReportOptions.limit() != null) {
      builder.query("limit", String.valueOf(getCreditPoolsReportOptions.limit()));
    }
    ResponseConverter<CreditPoolsReportSummary> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CreditPoolsReportSummary>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}
