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
 * IBM OpenAPI SDK Code Generator Version: 3.85.0-75c38f8f-20240206-210220
 */

package com.ibm.cloud.platform_services.partner_usage_reports.v1;

import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.platform_services.partner_usage_reports.v1.model.GetResourceUsageReportOptions;
import com.ibm.cloud.platform_services.partner_usage_reports.v1.model.PartnerUsageReportSummary;
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
 * Usage reports for IBM Cloud partner entities.
 *
 * API Version: 1.0.0
 */
public class PartnerUsageReports extends BaseService {

  /**
   * Default service name used when configuring the `PartnerUsageReports` client.
   */
  public static final String DEFAULT_SERVICE_NAME = "partner_usage_reports";

  /**
   * Default service endpoint URL.
   */
  public static final String DEFAULT_SERVICE_URL = "https://partner.cloud.ibm.com";

 /**
   * Class method which constructs an instance of the `PartnerUsageReports` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `PartnerUsageReports` client using external configuration
   */
  public static PartnerUsageReports newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `PartnerUsageReports` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `PartnerUsageReports` client using external configuration
   */
  public static PartnerUsageReports newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    PartnerUsageReports service = new PartnerUsageReports(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `PartnerUsageReports` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public PartnerUsageReports(String serviceName, Authenticator authenticator) {
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
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("partner_usage_reports", "v1", "getResourceUsageReport");
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

}
