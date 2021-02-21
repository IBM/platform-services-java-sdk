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

package com.ibm.cloud.platform_services.enterprise_usage_reports.v1;

import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.GetResourceUsageReportOptions;
import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.Reports;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//
// This file provides an example of how to use the Enterprise Usage Reports service.
//
// The following configuration properties are assumed to be defined:
//
// ENTERPRISE_USAGE_REPORTS_URL=<service url>
// ENTERPRISE_USAGE_REPORTS_AUTHTYPE=iam
// ENTERPRISE_USAGE_REPORTS_APIKEY=<IAM api key of user with authority to create rules>
// ENTERPRISE_USAGE_REPORTS_AUTH_URL=<IAM token service URL - omit this if using the production environment>
// ENTERPRISE_USAGE_REPORTS_ENTERPRISE_ID=<the id of the enterprise whose usage info will be retrieved>
// ENTERPRISE_USAGE_REPORTS_ACCOUNT_ID=<the id of the account whose usage info will be retrieved>
// ENTERPRISE_USAGE_REPORTS_ACCOUNT_GROUP_ID=<the id of the account group whose usage info will be retrieved>
// ENTERPRISE_USAGE_REPORTS_BILLING_MONTH=<the billing month (yyyy-mm) for which usage info will be retrieved>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
public class EnterpriseUsageReportsExamples {
    private static final Logger logger = LoggerFactory.getLogger(EnterpriseUsageReportsExamples.class);

    protected EnterpriseUsageReportsExamples() {
    }

    private static String enterpriseId;
    private static String billingMonth;

    static {
        System.setProperty("IBM_CREDENTIALS_FILE", "../../enterprise_usage_reports.env");
    }

    public static void main(String[] args) throws Exception {
        EnterpriseUsageReports service = EnterpriseUsageReports.newInstance();

        // Load up our test-specific config properties.
        Map<String, String> config = CredentialUtils.getServiceProperties(EnterpriseUsageReports.DEFAULT_SERVICE_NAME);
        enterpriseId = config.get("ENTERPRISE_ID");
        billingMonth = config.get("BILLING_MONTH");

        try {
            // begin-get_resource_usage_report
            GetResourceUsageReportOptions getResourceUsageReportOptions = new GetResourceUsageReportOptions.Builder()
                    .enterpriseId(enterpriseId)
                    .month(billingMonth)
                    .limit(10L)
                    .build();

            Response<Reports> response = service.getResourceUsageReport(getResourceUsageReportOptions).execute();
            Reports reports = response.getResult();

            System.out.println(reports);
            // end-get_resource_usage_report
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

    }
}
