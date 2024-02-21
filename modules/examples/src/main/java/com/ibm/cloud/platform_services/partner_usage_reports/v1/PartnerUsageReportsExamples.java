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

package com.ibm.cloud.platform_services.partner_usage_reports.v1;

import com.ibm.cloud.platform_services.partner_usage_reports.v1.model.GetResourceUsageReportOptions;
import com.ibm.cloud.platform_services.partner_usage_reports.v1.model.GetResourceUsageReportPager;
import com.ibm.cloud.platform_services.partner_usage_reports.v1.model.PartnerUsageReport;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class contains examples of how to use the Partner Usage Reports service.
 *
 * The following configuration properties are assumed to be defined:
 * PARTNER_USAGE_REPORTS_URL=&lt;service base url&gt;
 * PARTNER_USAGE_REPORTS_AUTH_TYPE=iam
 * PARTNER_USAGE_REPORTS_APIKEY=&lt;IAM apikey&gt;
 * PARTNER_USAGE_REPORTS_AUTH_URL=&lt;IAM token service base URL - omit this if using the production environment&gt;
 * PARTNER_USAGE_REPORTS_PARTNER_ID=Enterprise ID of the distributor or reseller for which the report is requested
 * PARTNER_USAGE_REPORTS_CUSTOMER_ID=Enterprise ID of the child customer for which the report is requested
 * PARTNER_USAGE_REPORTS_RESELLER_ID=Enterprise ID of the reseller for which the report is requested
 * PARTNER_USAGE_REPORTS_BILLING_MONTH=The billing month for which the usage report is requested. Format is `yyyy-mm`
 * PARTNER_USAGE_REPORTS_VIEWPOINT=Enables partner to view the cost of provisioned services as applicable at each level of the hierarchy
 *
 * These configuration properties can be exported as environment variables, or stored
 * in a configuration file and then:
 * export IBM_CREDENTIALS_FILE=&lt;name of configuration file&gt;
 */
public class PartnerUsageReportsExamples {
  private static final Logger logger = LoggerFactory.getLogger(PartnerUsageReportsExamples.class);
  protected PartnerUsageReportsExamples() { }

  private static String partnerId;
  private static String billingMonth;

  static {
    System.setProperty("IBM_CREDENTIALS_FILE", "../../partner_usage_reports_v1.env");
  }

  /**
   * The main() function invokes operations of the Partner Usage Reports service.
   * @param args command-line arguments
   * @throws Exception an error occurred
   */
  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    PartnerUsageReports partnerUsageReportsService = PartnerUsageReports.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> testConfigProperties = CredentialUtils.getServiceProperties(PartnerUsageReports.DEFAULT_SERVICE_NAME);
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

      GetResourceUsageReportPager pager = new GetResourceUsageReportPager(partnerUsageReportsService, getResourceUsageReportOptions);
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
  }
}
