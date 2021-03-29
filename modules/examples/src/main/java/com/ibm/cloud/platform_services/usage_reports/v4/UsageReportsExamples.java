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

package com.ibm.cloud.platform_services.usage_reports.v4;

import com.ibm.cloud.platform_services.usage_reports.v4.model.AccountSummary;
import com.ibm.cloud.platform_services.usage_reports.v4.model.AccountUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetAccountSummaryOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetAccountUsageOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetOrgUsageOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceGroupUsageOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceUsageAccountOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceUsageOrgOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceUsageResourceGroupOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.InstancesUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.model.OrgUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.model.ResourceGroupUsage;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//
// This class provides an example of how to use the Usage Reports service.
//
// The following configuration properties are assumed to be defined:
//
// USAGE_REPORTS_URL=<service url>
// USAGE_REPORTS_AUTHTYPE=iam
// USAGE_REPORTS_APIKEY=<IAM api key of user with authority to create rules>
// USAGE_REPORTS_AUTH_URL=<IAM token service URL - omit this if using the production environment>
// USAGE_REPORTS_ACCOUNT_ID=<the id of the account whose usage info will be retrieved>
// USAGE_REPORTS_RESOURCE_GROUP_ID=<the id of the resource group whose usage info will be retrieved>
// USAGE_REPORTS_ORG_ID=<the id of the organization whose usage info will be retrieved>
// USAGE_REPORTS_BILLING_MONTH=<the billing month (yyyy-mm) for which usage info will be retrieved>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
public class UsageReportsExamples {
  private static final Logger logger = LoggerFactory.getLogger(UsageReportsExamples.class);
  protected UsageReportsExamples() { }

  private static String accountId;
  private static String resourceGroupId;
  private static String orgId;
  private static String billingMonth;

  static {
      System.setProperty("IBM_CREDENTIALS_FILE", "../../usage_reports.env");
  }

  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    UsageReports service = UsageReports.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(UsageReports.DEFAULT_SERVICE_NAME);
    accountId = config.get("ACCOUNT_ID");
    resourceGroupId = config.get("RESOURCE_GROUP_ID");
    orgId = config.get("ORG_ID");
    billingMonth = config.get("BILLING_MONTH");

    try {
      // begin-get_account_summary
      GetAccountSummaryOptions getAccountSummaryOptions = new GetAccountSummaryOptions.Builder()
        .accountId(accountId)
        .billingmonth(billingMonth)
        .build();

      Response<AccountSummary> response = service.getAccountSummary(getAccountSummaryOptions).execute();
      AccountSummary accountSummary = response.getResult();

      System.out.printf("getAccountSummary() result:%n%s%n", accountSummary.toString());
      // end-get_account_summary
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_account_usage
      GetAccountUsageOptions getAccountUsageOptions = new GetAccountUsageOptions.Builder()
        .accountId(accountId)
        .billingmonth(billingMonth)
        .build();

      Response<AccountUsage> response = service.getAccountUsage(getAccountUsageOptions).execute();
      AccountUsage accountUsage = response.getResult();

      System.out.printf("getAccountUsage() result:%n%s%n", accountUsage.toString());
      // end-get_account_usage
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_resource_group_usage
      GetResourceGroupUsageOptions getResourceGroupUsageOptions = new GetResourceGroupUsageOptions.Builder()
        .accountId(accountId)
        .resourceGroupId(resourceGroupId)
        .billingmonth(billingMonth)
        .build();

      Response<ResourceGroupUsage> response = service.getResourceGroupUsage(getResourceGroupUsageOptions).execute();
      ResourceGroupUsage resourceGroupUsage = response.getResult();

      System.out.printf("getResourceGroupUsage() result:%n%s%n", resourceGroupUsage.toString());
      // end-get_resource_group_usage
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_org_usage
      GetOrgUsageOptions getOrgUsageOptions = new GetOrgUsageOptions.Builder()
        .accountId(accountId)
        .organizationId(orgId)
        .billingmonth(billingMonth)
        .build();

      Response<OrgUsage> response = service.getOrgUsage(getOrgUsageOptions).execute();
      OrgUsage orgUsage = response.getResult();

      System.out.printf("getOrgUsage() result:%n%s%n", orgUsage.toString());
      // end-get_org_usage
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_resource_usage_account
      GetResourceUsageAccountOptions getResourceUsageAccountOptions = new GetResourceUsageAccountOptions.Builder()
        .accountId(accountId)
        .billingmonth(billingMonth)
        .build();

      Response<InstancesUsage> response = service.getResourceUsageAccount(getResourceUsageAccountOptions).execute();
      InstancesUsage instancesUsage = response.getResult();

      System.out.printf("getResourceUsageAccount() result:%n%s%n", instancesUsage.toString());
      // end-get_resource_usage_account
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_resource_usage_resource_group
      GetResourceUsageResourceGroupOptions getResourceUsageResourceGroupOptions = new GetResourceUsageResourceGroupOptions.Builder()
        .accountId(accountId)
        .resourceGroupId(resourceGroupId)
        .billingmonth(billingMonth)
        .build();

      Response<InstancesUsage> response = service.getResourceUsageResourceGroup(getResourceUsageResourceGroupOptions).execute();
      InstancesUsage instancesUsage = response.getResult();

      System.out.printf("getResourceUsageResourceGroup() result:%n%s%n", instancesUsage.toString());
      // end-get_resource_usage_resource_group
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_resource_usage_org
      GetResourceUsageOrgOptions getResourceUsageOrgOptions = new GetResourceUsageOrgOptions.Builder()
        .accountId(accountId)
        .organizationId(orgId)
        .billingmonth(billingMonth)
        .build();

      Response<InstancesUsage> response = service.getResourceUsageOrg(getResourceUsageOrgOptions).execute();
      InstancesUsage instancesUsage = response.getResult();

      System.out.printf("getResourceUsageOrg() result:%n%s%n", instancesUsage.toString());
      // end-get_resource_usage_org
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  }
}
