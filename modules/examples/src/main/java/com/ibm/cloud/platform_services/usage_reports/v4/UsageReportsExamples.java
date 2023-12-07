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
import com.ibm.cloud.platform_services.usage_reports.v4.model.CreateReportsSnapshotConfigOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.DeleteReportsSnapshotConfigOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetAccountSummaryOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetAccountUsageOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetOrgUsageOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetReportsSnapshotConfigOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetReportsSnapshotOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetReportsSnapshotPager;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceGroupUsageOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceUsageAccountOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceUsageOrgOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceUsageResourceGroupOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.InstancesUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.model.OrgUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.model.ResourceGroupUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.model.SnapshotConfig;
import com.ibm.cloud.platform_services.usage_reports.v4.model.SnapshotConfigValidateResponse;
import com.ibm.cloud.platform_services.usage_reports.v4.model.SnapshotListSnapshotsItem;
import com.ibm.cloud.platform_services.usage_reports.v4.model.UpdateReportsSnapshotConfigOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.ValidateReportsSnapshotConfigOptions;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.sdk.core.util.GsonSingleton;

import java.util.ArrayList;
import java.util.List;
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
// USAGE_REPORTS_COS_BUCKET=<The name of the COS bucket to store the snapshot of the billing reports.>
// USAGE_REPORTS_COS_LOCATION=<Region of the COS instance.>
// USAGE_REPORTS_DATE_FROM=<Timestamp in milliseconds for which billing report snapshot is requested.>
// USAGE_REPORTS_DATE_TO=<Timestamp in milliseconds for which billing report snapshot is requested.>
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
  private static String cosBucket;
  private static String cosLocation;
  private static String snapshotDateFrom;
  private static String snapshotDateTo;

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
    cosBucket = config.get("COS_BUCKET");
    cosLocation = config.get("COS_LOCATION");
    snapshotDateFrom = config.get("DATE_FROM");
    snapshotDateTo = config.get("DATE_TO");

    try {
      System.out.println("getAccountSummary() result:");

      // begin-get_account_summary

      GetAccountSummaryOptions getAccountSummaryOptions = new GetAccountSummaryOptions.Builder()
        .accountId(accountId)
        .billingmonth(billingMonth)
        .build();

      Response<AccountSummary> response = service.getAccountSummary(getAccountSummaryOptions).execute();
      AccountSummary accountSummary = response.getResult();

      System.out.println(accountSummary);

      // end-get_account_summary

    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getAccountUsage() result:");

      // begin-get_account_usage

      GetAccountUsageOptions getAccountUsageOptions = new GetAccountUsageOptions.Builder()
        .accountId(accountId)
        .billingmonth(billingMonth)
        .build();

      Response<AccountUsage> response = service.getAccountUsage(getAccountUsageOptions).execute();
      AccountUsage accountUsage = response.getResult();

      System.out.println(accountUsage);

      // end-get_account_usage

    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getResourceGroupUsage() result:");

      // begin-get_resource_group_usage

      GetResourceGroupUsageOptions getResourceGroupUsageOptions = new GetResourceGroupUsageOptions.Builder()
        .accountId(accountId)
        .resourceGroupId(resourceGroupId)
        .billingmonth(billingMonth)
        .build();

      Response<ResourceGroupUsage> response = service.getResourceGroupUsage(getResourceGroupUsageOptions).execute();
      ResourceGroupUsage resourceGroupUsage = response.getResult();

      System.out.println(resourceGroupUsage);

      // end-get_resource_group_usage

    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getOrgUsage() result:");

      // begin-get_org_usage

      GetOrgUsageOptions getOrgUsageOptions = new GetOrgUsageOptions.Builder()
        .accountId(accountId)
        .organizationId(orgId)
        .billingmonth(billingMonth)
        .build();

      Response<OrgUsage> response = service.getOrgUsage(getOrgUsageOptions).execute();
      OrgUsage orgUsage = response.getResult();

      System.out.println(orgUsage);

      // end-get_org_usage

    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getResourceUsageAccount() result:");

      // begin-get_resource_usage_account

      GetResourceUsageAccountOptions getResourceUsageAccountOptions = new GetResourceUsageAccountOptions.Builder()
        .accountId(accountId)
        .billingmonth(billingMonth)
        .build();

      Response<InstancesUsage> response = service.getResourceUsageAccount(getResourceUsageAccountOptions).execute();
      InstancesUsage instancesUsage = response.getResult();

      System.out.println(instancesUsage);

      // end-get_resource_usage_account

    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getResourceUsageResourceGroup() result:");

      // begin-get_resource_usage_resource_group

      GetResourceUsageResourceGroupOptions getResourceUsageResourceGroupOptions = new GetResourceUsageResourceGroupOptions.Builder()
        .accountId(accountId)
        .resourceGroupId(resourceGroupId)
        .billingmonth(billingMonth)
        .build();

      Response<InstancesUsage> response = service.getResourceUsageResourceGroup(getResourceUsageResourceGroupOptions).execute();
      InstancesUsage instancesUsage = response.getResult();

      System.out.println(instancesUsage);

      // end-get_resource_usage_resource_group

    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getResourceUsageOrg() result:");

      // begin-get_resource_usage_org

      GetResourceUsageOrgOptions getResourceUsageOrgOptions = new GetResourceUsageOrgOptions.Builder()
        .accountId(accountId)
        .organizationId(orgId)
        .billingmonth(billingMonth)
        .build();

      Response<InstancesUsage> response = service.getResourceUsageOrg(getResourceUsageOrgOptions).execute();
      InstancesUsage instancesUsage = response.getResult();

      System.out.println(instancesUsage);

      // end-get_resource_usage_org

    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createReportsSnapshotConfig() result:");
      // begin-create_reports_snapshot_config
      CreateReportsSnapshotConfigOptions createReportsSnapshotConfigOptions = new CreateReportsSnapshotConfigOptions.Builder()
        .accountId(accountId)
        .interval("daily")
        .cosBucket(cosBucket)
        .cosLocation(cosLocation)
        .build();

      Response<SnapshotConfig> response = service.createReportsSnapshotConfig(createReportsSnapshotConfigOptions).execute();
      SnapshotConfig snapshotConfig = response.getResult();

      System.out.println(snapshotConfig);
      // end-create_reports_snapshot_config
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getReportsSnapshotConfig() result:");
      // begin-get_reports_snapshot_config
      GetReportsSnapshotConfigOptions getReportsSnapshotConfigOptions = new GetReportsSnapshotConfigOptions.Builder()
        .accountId(accountId)
        .build();

      Response<SnapshotConfig> response = service.getReportsSnapshotConfig(getReportsSnapshotConfigOptions).execute();
      SnapshotConfig snapshotConfig = response.getResult();

      System.out.println(snapshotConfig);
      // end-get_reports_snapshot_config
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("updateReportsSnapshotConfig() result:");
      // begin-update_reports_snapshot_config
      UpdateReportsSnapshotConfigOptions updateReportsSnapshotConfigOptions = new UpdateReportsSnapshotConfigOptions.Builder()
        .accountId(accountId)
        .reportTypes(java.util.Arrays.asList("account_summary", "enterprise_summary"))
        .build();

      Response<SnapshotConfig> response = service.updateReportsSnapshotConfig(updateReportsSnapshotConfigOptions).execute();
      SnapshotConfig snapshotConfig = response.getResult();

      System.out.println(snapshotConfig);
      // end-update_reports_snapshot_config
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("validateReportsSnapshotConfig() result:");
      // begin-validate_reports_snapshot_config
      ValidateReportsSnapshotConfigOptions validateReportsSnapshotConfigOptions = new ValidateReportsSnapshotConfigOptions.Builder()
        .accountId(accountId)
        .interval("daily")
        .cosBucket(cosBucket)
        .cosLocation(cosLocation)
        .build();

      Response<SnapshotConfigValidateResponse> response = service.validateReportsSnapshotConfig(validateReportsSnapshotConfigOptions).execute();
      SnapshotConfigValidateResponse snapshotConfigValidateResponse = response.getResult();

      System.out.println(snapshotConfigValidateResponse);
      // end-validate_reports_snapshot_config
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getReportsSnapshot() result:");
      // begin-get_reports_snapshot
      GetReportsSnapshotOptions getReportsSnapshotOptions = new GetReportsSnapshotOptions.Builder()
        .accountId(accountId)
        .month(billingMonth)
        .dateFrom(Long.valueOf(snapshotDateFrom))
        .dateTo(Long.valueOf(snapshotDateTo))
        .limit(Long.valueOf("30"))
        .build();

      GetReportsSnapshotPager pager = new GetReportsSnapshotPager(service, getReportsSnapshotOptions);
      List<SnapshotListSnapshotsItem> allResults = new ArrayList<>();
      while (pager.hasNext()) {
        List<SnapshotListSnapshotsItem> nextPage = pager.getNext();
        allResults.addAll(nextPage);
      }

      System.out.println(GsonSingleton.getGson().toJson(allResults));
      // end-get_reports_snapshot
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_reports_snapshot_config
      DeleteReportsSnapshotConfigOptions deleteReportsSnapshotConfigOptions = new DeleteReportsSnapshotConfigOptions.Builder()
        .accountId(accountId)
        .build();

      Response<Void> response = service.deleteReportsSnapshotConfig(deleteReportsSnapshotConfigOptions).execute();
      // end-delete_reports_snapshot_config
      System.out.printf("deleteReportsSnapshotConfig() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  }
}
