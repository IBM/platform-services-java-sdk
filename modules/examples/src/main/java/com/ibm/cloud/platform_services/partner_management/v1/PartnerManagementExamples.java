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

package com.ibm.cloud.platform_services.partner_management.v1;

import com.ibm.cloud.platform_services.partner_management.v1.model.BillingOptionsSummary;
import com.ibm.cloud.platform_services.partner_management.v1.model.CreditPoolsReportSummary;
import com.ibm.cloud.platform_services.partner_management.v1.model.GetBillingOptionsOptions;
import com.ibm.cloud.platform_services.partner_management.v1.model.GetCreditPoolsReportOptions;
import com.ibm.cloud.platform_services.partner_management.v1.model.GetResourceUsageReportOptions;
import com.ibm.cloud.platform_services.partner_management.v1.model.GetResourceUsageReportPager;
import com.ibm.cloud.platform_services.partner_management.v1.model.PartnerUsageReport;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class contains examples of how to use the Partner Management service.
 *
 * The following configuration properties are assumed to be defined:
 * PARTNER_MANAGEMENT_URL=&lt;service base url&gt;
 * PARTNER_MANAGEMENT_AUTH_TYPE=iam
 * PARTNER_MANAGEMENT_APIKEY=&lt;IAM apikey&gt;
 * PARTNER_MANAGEMENT_AUTH_URL=&lt;IAM token service base URL - omit this if using the production environment&gt;
 * PARTNER_MANAGEMENT_PARTNER_ID=Enterprise ID of the distributor or reseller for which the report is requested
 * PARTNER_MANAGEMENT_CUSTOMER_ID=Enterprise ID of the child customer for which the report is requested
 * PARTNER_MANAGEMENT_RESELLER_ID=Enterprise ID of the reseller for which the report is requested
 * PARTNER_MANAGEMENT_BILLING_MONTH=The billing month for which the usage report is requested. Format is `yyyy-mm`
 * PARTNER_MANAGEMENT_VIEWPOINT=Enables partner to view the cost of provisioned services as applicable at each level of the hierarchy
 *
 * These configuration properties can be exported as environment variables, or stored
 * in a configuration file and then:
 * export IBM_CREDENTIALS_FILE=&lt;name of configuration file&gt;
 */
public class PartnerManagementExamples {
  private static final Logger logger = LoggerFactory.getLogger(PartnerManagementExamples.class);
  protected PartnerManagementExamples() { }

  private static String partnerId;
  private static String billingMonth;

  static {
    System.setProperty("IBM_CREDENTIALS_FILE", "../../partner_management_v1.env");
  }

  /**
   * The main() function invokes operations of the Partner Management service.
   * @param args command-line arguments
   * @throws Exception an error occurred
   */
  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    PartnerManagement partnerManagementService = PartnerManagement.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> testConfigProperties = CredentialUtils.getServiceProperties(PartnerManagement.DEFAULT_SERVICE_NAME);
    partnerId = testConfigProperties.get("PARTNER_ID");
    billingMonth = testConfigProperties.get("BILLING_MONTH");

    try {
      System.out.println("getResourceUsageReport() result:");
      // begin-get_resource_usage_report
      GetResourceUsageReportOptions getResourceUsageReportOptions = new GetResourceUsageReportOptions.Builder()
        .partnerId(partnerId)
        .month(billingMonth)
        .limit(Long.valueOf("10"))
        .build();

      GetResourceUsageReportPager pager = new GetResourceUsageReportPager(partnerManagementService, getResourceUsageReportOptions);
      List<PartnerUsageReport> allResults = new ArrayList<>();
      while (pager.hasNext()) {
        List<PartnerUsageReport> nextPage = pager.getNext();
        allResults.addAll(nextPage);
      }

      System.out.println(GsonSingleton.getGson().toJson(allResults));
      // end-get_resource_usage_report
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getBillingOptions() result:");
      // begin-get_billing_options
      GetBillingOptionsOptions getBillingOptionsOptions = new GetBillingOptionsOptions.Builder()
        .partnerId(partnerId)
        .date(billingMonth)
        .build();

      Response<BillingOptionsSummary> response = partnerManagementService.getBillingOptions(getBillingOptionsOptions).execute();
      BillingOptionsSummary billingOptionsSummary = response.getResult();

      System.out.println(billingOptionsSummary);
      // end-get_billing_options
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getCreditPoolsReport() result:");
      // begin-get_credit_pools_report
      GetCreditPoolsReportOptions getCreditPoolsReportOptions = new GetCreditPoolsReportOptions.Builder()
        .partnerId(partnerId)
        .date(billingMonth)
        .build();

      Response<CreditPoolsReportSummary> response = partnerManagementService.getCreditPoolsReport(getCreditPoolsReportOptions).execute();
      CreditPoolsReportSummary creditPoolsReportSummary = response.getResult();

      System.out.println(creditPoolsReportSummary);
      // end-get_credit_pools_report
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  }
}
