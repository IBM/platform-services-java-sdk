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

package com.ibm.cloud.platform_services.usage_reports.v4;

import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.platform_services.usage_reports.v4.model.AccountSummary;
import com.ibm.cloud.platform_services.usage_reports.v4.model.AccountUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.model.CreateReportsSnapshotConfigOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.DeleteReportsSnapshotConfigOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.Discount;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetAccountSummaryOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetAccountUsageOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetOrgUsageOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetReportsSnapshotConfigOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetReportsSnapshotOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceGroupUsageOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceUsageAccountOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceUsageAccountPager;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceUsageOrgOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceUsageOrgPager;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceUsageResourceGroupOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceUsageResourceGroupPager;
import com.ibm.cloud.platform_services.usage_reports.v4.model.InstanceUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.model.InstancesUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.model.InstancesUsageFirst;
import com.ibm.cloud.platform_services.usage_reports.v4.model.InstancesUsageNext;
import com.ibm.cloud.platform_services.usage_reports.v4.model.Metric;
import com.ibm.cloud.platform_services.usage_reports.v4.model.Offer;
import com.ibm.cloud.platform_services.usage_reports.v4.model.OfferCredits;
import com.ibm.cloud.platform_services.usage_reports.v4.model.OrgUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.model.Plan;
import com.ibm.cloud.platform_services.usage_reports.v4.model.Resource;
import com.ibm.cloud.platform_services.usage_reports.v4.model.ResourceGroupUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.model.ResourcesSummary;
import com.ibm.cloud.platform_services.usage_reports.v4.model.SnapshotConfig;
import com.ibm.cloud.platform_services.usage_reports.v4.model.SnapshotConfigHistoryItem;
import com.ibm.cloud.platform_services.usage_reports.v4.model.SnapshotList;
import com.ibm.cloud.platform_services.usage_reports.v4.model.SnapshotListFirst;
import com.ibm.cloud.platform_services.usage_reports.v4.model.SnapshotListNext;
import com.ibm.cloud.platform_services.usage_reports.v4.model.SnapshotListSnapshotsItem;
import com.ibm.cloud.platform_services.usage_reports.v4.model.SnapshotListSnapshotsItemBillingPeriod;
import com.ibm.cloud.platform_services.usage_reports.v4.model.SnapshotListSnapshotsItemFilesItem;
import com.ibm.cloud.platform_services.usage_reports.v4.model.SnapshotListSnapshotsItemReportTypesItem;
import com.ibm.cloud.platform_services.usage_reports.v4.model.Subscription;
import com.ibm.cloud.platform_services.usage_reports.v4.model.SubscriptionSummary;
import com.ibm.cloud.platform_services.usage_reports.v4.model.SubscriptionTerm;
import com.ibm.cloud.platform_services.usage_reports.v4.model.SubscriptionTermCredits;
import com.ibm.cloud.platform_services.usage_reports.v4.model.SupportSummary;
import com.ibm.cloud.platform_services.usage_reports.v4.model.UpdateReportsSnapshotConfigOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.sdk.core.util.DateUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Integration test class for the UsageReports service.
 */
public class UsageReportsIT extends SdkIntegrationTestBase {
  public UsageReports service = null;
  public static Map<String, String> config = null;
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();
  /**
   * This method provides our config filename to the base class.
   */

  public String getConfigFilename() {
    return "../../usage_reports_v4.env";
  }

  @BeforeClass
  public void constructService() {
    // Ask super if we should skip the tests.
    if (skipTests()) {
      return;
    }

    service = UsageReports.newInstance();
    assertNotNull(service);
    assertNotNull(service.getServiceUrl());

    // Load up our test-specific config properties.
    config = CredentialUtils.getServiceProperties(UsageReports.DEFAULT_SERVICE_NAME);
    assertNotNull(config);
    assertFalse(config.isEmpty());
    assertEquals(service.getServiceUrl(), config.get("URL"));

    service.enableRetries(4, 30);

    System.out.println("Setup complete.");
  }

  @Test
  public void testGetAccountSummary() throws Exception {
    try {
      GetAccountSummaryOptions getAccountSummaryOptions = new GetAccountSummaryOptions.Builder()
        .accountId("testString")
        .billingmonth("testString")
        .build();

      // Invoke operation
      Response<AccountSummary> response = service.getAccountSummary(getAccountSummaryOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AccountSummary accountSummaryResult = response.getResult();

      assertNotNull(accountSummaryResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetAccountSummary" })
  public void testGetAccountUsage() throws Exception {
    try {
      GetAccountUsageOptions getAccountUsageOptions = new GetAccountUsageOptions.Builder()
        .accountId("testString")
        .billingmonth("testString")
        .names(true)
        .acceptLanguage("testString")
        .build();

      // Invoke operation
      Response<AccountUsage> response = service.getAccountUsage(getAccountUsageOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AccountUsage accountUsageResult = response.getResult();

      assertNotNull(accountUsageResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetAccountUsage" })
  public void testGetResourceGroupUsage() throws Exception {
    try {
      GetResourceGroupUsageOptions getResourceGroupUsageOptions = new GetResourceGroupUsageOptions.Builder()
        .accountId("testString")
        .resourceGroupId("testString")
        .billingmonth("testString")
        .names(true)
        .acceptLanguage("testString")
        .build();

      // Invoke operation
      Response<ResourceGroupUsage> response = service.getResourceGroupUsage(getResourceGroupUsageOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ResourceGroupUsage resourceGroupUsageResult = response.getResult();

      assertNotNull(resourceGroupUsageResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetResourceGroupUsage" })
  public void testGetResourceUsageAccount() throws Exception {
    try {
      GetResourceUsageAccountOptions getResourceUsageAccountOptions = new GetResourceUsageAccountOptions.Builder()
        .accountId("testString")
        .billingmonth("testString")
        .names(true)
        .tags(true)
        .acceptLanguage("testString")
        .limit(Long.valueOf("30"))
        .start("testString")
        .resourceGroupId("testString")
        .organizationId("testString")
        .resourceInstanceId("testString")
        .resourceId("testString")
        .planId("testString")
        .region("testString")
        .build();

      // Invoke operation
      Response<InstancesUsage> response = service.getResourceUsageAccount(getResourceUsageAccountOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      InstancesUsage instancesUsageResult = response.getResult();

      assertNotNull(instancesUsageResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetResourceUsageAccount" })
  public void testGetResourceUsageAccountWithPager() throws Exception {
    try {
      GetResourceUsageAccountOptions options = new GetResourceUsageAccountOptions.Builder()
        .accountId("testString")
        .billingmonth("testString")
        .names(true)
        .tags(true)
        .acceptLanguage("testString")
        .limit(Long.valueOf("30"))
        .resourceGroupId("testString")
        .organizationId("testString")
        .resourceInstanceId("testString")
        .resourceId("testString")
        .planId("testString")
        .region("testString")
        .build();

      // Test getNext().
      List<InstanceUsage> allResults = new ArrayList<>();
      GetResourceUsageAccountPager pager = new GetResourceUsageAccountPager(service, options);
      while (pager.hasNext()) {
        List<InstanceUsage> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }
      assertFalse(allResults.isEmpty());

      // Test getAll();
      pager = new GetResourceUsageAccountPager(service, options);
      List<InstanceUsage> allItems = pager.getAll();
      assertNotNull(allItems);
      assertFalse(allItems.isEmpty());

      assertEquals(allItems.size(), allResults.size());
      System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetResourceUsageAccount" })
  public void testGetResourceUsageResourceGroup() throws Exception {
    try {
      GetResourceUsageResourceGroupOptions getResourceUsageResourceGroupOptions = new GetResourceUsageResourceGroupOptions.Builder()
        .accountId("testString")
        .resourceGroupId("testString")
        .billingmonth("testString")
        .names(true)
        .tags(true)
        .acceptLanguage("testString")
        .limit(Long.valueOf("30"))
        .start("testString")
        .resourceInstanceId("testString")
        .resourceId("testString")
        .planId("testString")
        .region("testString")
        .build();

      // Invoke operation
      Response<InstancesUsage> response = service.getResourceUsageResourceGroup(getResourceUsageResourceGroupOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      InstancesUsage instancesUsageResult = response.getResult();

      assertNotNull(instancesUsageResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetResourceUsageResourceGroup" })
  public void testGetResourceUsageResourceGroupWithPager() throws Exception {
    try {
      GetResourceUsageResourceGroupOptions options = new GetResourceUsageResourceGroupOptions.Builder()
        .accountId("testString")
        .resourceGroupId("testString")
        .billingmonth("testString")
        .names(true)
        .tags(true)
        .acceptLanguage("testString")
        .limit(Long.valueOf("30"))
        .resourceInstanceId("testString")
        .resourceId("testString")
        .planId("testString")
        .region("testString")
        .build();

      // Test getNext().
      List<InstanceUsage> allResults = new ArrayList<>();
      GetResourceUsageResourceGroupPager pager = new GetResourceUsageResourceGroupPager(service, options);
      while (pager.hasNext()) {
        List<InstanceUsage> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }
      assertFalse(allResults.isEmpty());

      // Test getAll();
      pager = new GetResourceUsageResourceGroupPager(service, options);
      List<InstanceUsage> allItems = pager.getAll();
      assertNotNull(allItems);
      assertFalse(allItems.isEmpty());

      assertEquals(allItems.size(), allResults.size());
      System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetResourceUsageResourceGroup" })
  public void testGetResourceUsageOrg() throws Exception {
    try {
      GetResourceUsageOrgOptions getResourceUsageOrgOptions = new GetResourceUsageOrgOptions.Builder()
        .accountId("testString")
        .organizationId("testString")
        .billingmonth("testString")
        .names(true)
        .tags(true)
        .acceptLanguage("testString")
        .limit(Long.valueOf("30"))
        .start("testString")
        .resourceInstanceId("testString")
        .resourceId("testString")
        .planId("testString")
        .region("testString")
        .build();

      // Invoke operation
      Response<InstancesUsage> response = service.getResourceUsageOrg(getResourceUsageOrgOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      InstancesUsage instancesUsageResult = response.getResult();

      assertNotNull(instancesUsageResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetResourceUsageOrg" })
  public void testGetResourceUsageOrgWithPager() throws Exception {
    try {
      GetResourceUsageOrgOptions options = new GetResourceUsageOrgOptions.Builder()
        .accountId("testString")
        .organizationId("testString")
        .billingmonth("testString")
        .names(true)
        .tags(true)
        .acceptLanguage("testString")
        .limit(Long.valueOf("30"))
        .resourceInstanceId("testString")
        .resourceId("testString")
        .planId("testString")
        .region("testString")
        .build();

      // Test getNext().
      List<InstanceUsage> allResults = new ArrayList<>();
      GetResourceUsageOrgPager pager = new GetResourceUsageOrgPager(service, options);
      while (pager.hasNext()) {
        List<InstanceUsage> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }
      assertFalse(allResults.isEmpty());

      // Test getAll();
      pager = new GetResourceUsageOrgPager(service, options);
      List<InstanceUsage> allItems = pager.getAll();
      assertNotNull(allItems);
      assertFalse(allItems.isEmpty());

      assertEquals(allItems.size(), allResults.size());
      System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetResourceUsageOrg" })
  public void testGetOrgUsage() throws Exception {
    try {
      GetOrgUsageOptions getOrgUsageOptions = new GetOrgUsageOptions.Builder()
        .accountId("testString")
        .organizationId("testString")
        .billingmonth("testString")
        .names(true)
        .acceptLanguage("testString")
        .build();

      // Invoke operation
      Response<OrgUsage> response = service.getOrgUsage(getOrgUsageOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      OrgUsage orgUsageResult = response.getResult();

      assertNotNull(orgUsageResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetOrgUsage" })
  public void testCreateReportsSnapshotConfig() throws Exception {
    try {
      CreateReportsSnapshotConfigOptions createReportsSnapshotConfigOptions = new CreateReportsSnapshotConfigOptions.Builder()
        .accountId("abc")
        .interval("daily")
        .cosBucket("bucket_name")
        .cosLocation("us-south")
        .cosReportsFolder("IBMCloud-Billing-Reports")
        .reportTypes(java.util.Arrays.asList("account_summary", "enterprise_summary", "account_resource_instance_usage"))
        .versioning("new")
        .build();

      // Invoke operation
      Response<SnapshotConfig> response = service.createReportsSnapshotConfig(createReportsSnapshotConfigOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      SnapshotConfig snapshotConfigResult = response.getResult();

      assertNotNull(snapshotConfigResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testCreateReportsSnapshotConfig" })
  public void testGetReportsSnapshotConfig() throws Exception {
    try {
      GetReportsSnapshotConfigOptions getReportsSnapshotConfigOptions = new GetReportsSnapshotConfigOptions.Builder()
        .accountId("abc")
        .build();

      // Invoke operation
      Response<SnapshotConfig> response = service.getReportsSnapshotConfig(getReportsSnapshotConfigOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      SnapshotConfig snapshotConfigResult = response.getResult();

      assertNotNull(snapshotConfigResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetReportsSnapshotConfig" })
  public void testUpdateReportsSnapshotConfig() throws Exception {
    try {
      UpdateReportsSnapshotConfigOptions updateReportsSnapshotConfigOptions = new UpdateReportsSnapshotConfigOptions.Builder()
        .accountId("abc")
        .interval("daily")
        .cosBucket("bucket_name")
        .cosLocation("us-south")
        .cosReportsFolder("IBMCloud-Billing-Reports")
        .reportTypes(java.util.Arrays.asList("account_summary", "enterprise_summary", "account_resource_instance_usage"))
        .versioning("new")
        .build();

      // Invoke operation
      Response<SnapshotConfig> response = service.updateReportsSnapshotConfig(updateReportsSnapshotConfigOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      SnapshotConfig snapshotConfigResult = response.getResult();

      assertNotNull(snapshotConfigResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testUpdateReportsSnapshotConfig" })
  public void testGetReportsSnapshot() throws Exception {
    try {
      GetReportsSnapshotOptions getReportsSnapshotOptions = new GetReportsSnapshotOptions.Builder()
        .accountId("abc")
        .month("2023-02")
        .dateFrom(Double.valueOf("1675209600000"))
        .dateTo(Double.valueOf("1675987200000"))
        .build();

      // Invoke operation
      Response<SnapshotList> response = service.getReportsSnapshot(getReportsSnapshotOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      SnapshotList snapshotListResult = response.getResult();

      assertNotNull(snapshotListResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetReportsSnapshot" })
  public void testDeleteReportsSnapshotConfig() throws Exception {
    try {
      DeleteReportsSnapshotConfigOptions deleteReportsSnapshotConfigOptions = new DeleteReportsSnapshotConfigOptions.Builder()
        .accountId("abc")
        .build();

      // Invoke operation
      Response<Void> response = service.deleteReportsSnapshotConfig(deleteReportsSnapshotConfigOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @AfterClass
  public void tearDown() {
    // Add any clean up logic here
    System.out.println("Clean up complete.");
  }
 }
