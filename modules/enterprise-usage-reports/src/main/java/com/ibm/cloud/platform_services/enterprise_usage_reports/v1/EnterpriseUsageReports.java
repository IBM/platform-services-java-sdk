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
 * IBM OpenAPI SDK Code Generator Version: 99-SNAPSHOT-629bbb97-20201207-171303
 */

package com.ibm.cloud.platform_services.enterprise_usage_reports.v1;

import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.GetResourceUsageReportOptions;
import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.Reports;
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
 * Usage reports for IBM Cloud enterprise entities.
 *
 * @version v1
 */
public class EnterpriseUsageReports extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "enterprise_usage_reports";

  public static final String DEFAULT_SERVICE_URL = "https://enterprise.cloud.ibm.com";

 /**
   * Class method which constructs an instance of the `EnterpriseUsageReports` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `EnterpriseUsageReports` client using external configuration
   */
  public static EnterpriseUsageReports newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `EnterpriseUsageReports` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `EnterpriseUsageReports` client using external configuration
   */
  public static EnterpriseUsageReports newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    EnterpriseUsageReports service = new EnterpriseUsageReports(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `EnterpriseUsageReports` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public EnterpriseUsageReports(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * Get usage reports for enterprise entities.
   *
   * Usage reports for entities in the IBM Cloud enterprise. These entities can be the enterprise, an account group, or
   * an account.
   *
   * @param getResourceUsageReportOptions the {@link GetResourceUsageReportOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Reports}
   */
  public ServiceCall<Reports> getResourceUsageReport(GetResourceUsageReportOptions getResourceUsageReportOptions) {
    if (getResourceUsageReportOptions == null) {
      getResourceUsageReportOptions = new GetResourceUsageReportOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/resource-usage-reports"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("enterprise_usage_reports", "v1", "getResourceUsageReport");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getResourceUsageReportOptions.enterpriseId() != null) {
      builder.query("enterprise_id", String.valueOf(getResourceUsageReportOptions.enterpriseId()));
    }
    if (getResourceUsageReportOptions.accountGroupId() != null) {
      builder.query("account_group_id", String.valueOf(getResourceUsageReportOptions.accountGroupId()));
    }
    if (getResourceUsageReportOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(getResourceUsageReportOptions.accountId()));
    }
    if (getResourceUsageReportOptions.children() != null) {
      builder.query("children", String.valueOf(getResourceUsageReportOptions.children()));
    }
    if (getResourceUsageReportOptions.month() != null) {
      builder.query("month", String.valueOf(getResourceUsageReportOptions.month()));
    }
    if (getResourceUsageReportOptions.billingUnitId() != null) {
      builder.query("billing_unit_id", String.valueOf(getResourceUsageReportOptions.billingUnitId()));
    }
    if (getResourceUsageReportOptions.limit() != null) {
      builder.query("limit", String.valueOf(getResourceUsageReportOptions.limit()));
    }
    if (getResourceUsageReportOptions.offset() != null) {
      builder.query("offset", String.valueOf(getResourceUsageReportOptions.offset()));
    }
    ResponseConverter<Reports> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Reports>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get usage reports for enterprise entities.
   *
   * Usage reports for entities in the IBM Cloud enterprise. These entities can be the enterprise, an account group, or
   * an account.
   *
   * @return a {@link ServiceCall} with a result of type {@link Reports}
   */
  public ServiceCall<Reports> getResourceUsageReport() {
    return getResourceUsageReport(null);
  }

}
