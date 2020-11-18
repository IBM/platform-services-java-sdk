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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.platform_services.usage_reports.v4.model.AccountSummary;
import com.ibm.cloud.platform_services.usage_reports.v4.model.AccountUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetAccountSummaryOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetAccountUsageOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetOrgUsageOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceGroupUsageOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceUsageAccountOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceUsageOrgOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceUsageResourceGroupOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.model.InstanceUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.model.InstancesUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.model.OrgUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.model.ResourceGroupUsage;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

/**
 * Integration test class for the UsageReports service.
 */
public class UsageReportsIT extends SdkIntegrationTestBase {
  public UsageReports service = null;
  public static Map<String, String> config = null;

  // Test-related config properties.
  private static String ACCOUNT_ID;
  private static String RESOURCE_GROUP_ID;
  private static String ORG_ID;
  private static String BILLING_MONTH;

  @Override
  public String getConfigFilename() {
    return "../../usage_reports.env";
  }

  @Override
  public boolean loggingEnabled() {
      return false;
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

    // Retrieve and verify some additional test-related config properties.
    ACCOUNT_ID = config.get("ACCOUNT_ID");
    RESOURCE_GROUP_ID = config.get("RESOURCE_GROUP_ID");
    ORG_ID = config.get("ORG_ID");
    BILLING_MONTH = config.get("BILLING_MONTH");
    assertNotNull(ACCOUNT_ID);
    assertNotNull(RESOURCE_GROUP_ID);
    assertNotNull(ORG_ID);
    assertNotNull(BILLING_MONTH);

    log("Setup complete.");
  }

  @Test
  public void testGetAccountSummary() throws Exception {
      try {
          GetAccountSummaryOptions getAccountSummaryOptions = new GetAccountSummaryOptions.Builder()
                  .accountId(ACCOUNT_ID)
                  .billingmonth(BILLING_MONTH)
                  .build();

          Response<AccountSummary> response = service.getAccountSummary(getAccountSummaryOptions).execute();
          assertNotNull(response);
          assertEquals(response.getStatusCode(), 200);

          AccountSummary accountSummaryResult = response.getResult();
          assertNotNull(accountSummaryResult);
          log(String.format("GetAccountSummary response:\n%s", accountSummaryResult.toString()));

          assertEquals(accountSummaryResult.getAccountId(), ACCOUNT_ID);
          assertNotNull(accountSummaryResult.getOffers());
          assertFalse(accountSummaryResult.getOffers().isEmpty());
      } catch (ServiceResponseException e) {
          fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                  e.getMessage(), e.getDebuggingInfo()));
      }
  }

  @Test
  public void testGetAccountUsage() throws Exception {
      try {
          GetAccountUsageOptions getAccountUsageOptions = new GetAccountUsageOptions.Builder()
                  .accountId(ACCOUNT_ID)
                  .billingmonth(BILLING_MONTH)
                  .names(true)
                  .acceptLanguage("English")
                  .build();

          Response<AccountUsage> response = service.getAccountUsage(getAccountUsageOptions).execute();
          assertNotNull(response);
          assertEquals(response.getStatusCode(), 200);

          AccountUsage accountUsageResult = response.getResult();
          assertNotNull(accountUsageResult);
          log(String.format("GetAccountUsage response:\n%s", accountUsageResult.toString()));

          assertEquals(accountUsageResult.getAccountId(), ACCOUNT_ID);
          assertEquals(accountUsageResult.getMonth(), BILLING_MONTH);
          assertNotNull(accountUsageResult.getResources());
          assertFalse(accountUsageResult.getResources().isEmpty());
      } catch (ServiceResponseException e) {
          fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                  e.getMessage(), e.getDebuggingInfo()));
      }
  }

  @Test
  public void testGetResourceGroupUsage() throws Exception {
    try {
      GetResourceGroupUsageOptions getResourceGroupUsageOptions = new GetResourceGroupUsageOptions.Builder()
      .accountId(ACCOUNT_ID)
      .resourceGroupId(RESOURCE_GROUP_ID)
      .billingmonth(BILLING_MONTH)
      .names(true)
      .build();

      Response<ResourceGroupUsage> response = service.getResourceGroupUsage(getResourceGroupUsageOptions).execute();
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ResourceGroupUsage resourceGroupUsageResult = response.getResult();
      assertNotNull(resourceGroupUsageResult);
      log(String.format("GetResourceGroupUsage response:\n%s", resourceGroupUsageResult.toString()));

      assertEquals(resourceGroupUsageResult.getAccountId(), ACCOUNT_ID);
      assertEquals(resourceGroupUsageResult.getMonth(), BILLING_MONTH);
      assertNotNull(resourceGroupUsageResult.getResources());
      assertFalse(resourceGroupUsageResult.getResources().isEmpty());
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetOrgUsage() throws Exception {
      try {
          GetOrgUsageOptions getOrgUsageOptions = new GetOrgUsageOptions.Builder()
                  .accountId(ACCOUNT_ID)
                  .organizationId(ORG_ID)
                  .billingmonth(BILLING_MONTH)
                  .names(true)
                  .build();

          Response<OrgUsage> response = service.getOrgUsage(getOrgUsageOptions).execute();
          assertNotNull(response);
          assertEquals(response.getStatusCode(), 200);

          OrgUsage orgUsageResult = response.getResult();
          assertNotNull(orgUsageResult);
          log(String.format("GetOrgUsage response:\n%s", orgUsageResult.toString()));

          assertEquals(orgUsageResult.getAccountId(), ACCOUNT_ID);
          assertEquals(orgUsageResult.getMonth(), BILLING_MONTH);
          assertNotNull(orgUsageResult.getResources());
          assertFalse(orgUsageResult.getResources().isEmpty());
      } catch (ServiceResponseException e) {
          fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                  e.getMessage(), e.getDebuggingInfo()));
      }
  }

  @Test
  public void testGetResourceUsageAccount() throws Exception {
      try {
          GetResourceUsageAccountOptions getResourceUsageAccountOptions = new GetResourceUsageAccountOptions.Builder()
                  .accountId(ACCOUNT_ID)
                  .billingmonth(BILLING_MONTH)
                  .names(true)
                  .limit(50L)
                  .build();

          List<InstanceUsage> results = new ArrayList<>();

          String offset = null;
          boolean moreResults = true;

          while (moreResults) {

              // Set "start" parameter for next page of results.
              getResourceUsageAccountOptions = getResourceUsageAccountOptions.newBuilder()
                      .start(offset)
                      .build();

              Response<InstancesUsage> response = service.getResourceUsageAccount(getResourceUsageAccountOptions)
                      .execute();
              assertNotNull(response);
              assertEquals(response.getStatusCode(), 200);

              InstancesUsage instancesUsageResult = response.getResult();
              assertNotNull(instancesUsageResult);

              // Add the just-retrieved page to the results.
              if (instancesUsageResult.getResources() != null) {
                  results.addAll(instancesUsageResult.getResources());
              }

              // Determine offset for next page of results.
              if (instancesUsageResult.getNext() != null) {
                  offset = instancesUsageResult.getNext().getOffset();
              } else {
                  offset = null;
                  moreResults = false;
              }
          }

          log(String.format("GetResourceUsageAccount response contained %d total resources.", results.size()));
          assertFalse(results.isEmpty());
      } catch (ServiceResponseException e) {
          fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                  e.getMessage(), e.getDebuggingInfo()));
      }
  }

  @Test
  public void testGetResourceUsageResourceGroup() throws Exception {
      try {
          GetResourceUsageResourceGroupOptions getResourceUsageResourceGroupOptions =
                  new GetResourceUsageResourceGroupOptions.Builder()
                      .accountId(ACCOUNT_ID)
                      .resourceGroupId(RESOURCE_GROUP_ID)
                      .billingmonth(BILLING_MONTH)
                      .names(true)
                      .limit(50L)
                      .build();

          List<InstanceUsage> results = new ArrayList<>();

          String offset = null;
          boolean moreResults = true;

          while (moreResults) {

              // Set "start" parameter for next page of results.
              getResourceUsageResourceGroupOptions = getResourceUsageResourceGroupOptions.newBuilder()
                      .start(offset)
                      .build();

              Response<InstancesUsage> response = service
                      .getResourceUsageResourceGroup(getResourceUsageResourceGroupOptions).execute();
              assertNotNull(response);
              assertEquals(response.getStatusCode(), 200);

              InstancesUsage instancesUsageResult = response.getResult();
              assertNotNull(instancesUsageResult);

              // Add the just-retrieved page to the results.
              if (instancesUsageResult.getResources() != null) {
                  results.addAll(instancesUsageResult.getResources());
              }

              // Determine offset for next page of results.
              if (instancesUsageResult.getNext() != null) {
                  offset = instancesUsageResult.getNext().getOffset();
              } else {
                  offset = null;
                  moreResults = false;
              }
          }

          log(String.format("GetResourceUsageResourceGroup response contained %d total resources.", results.size()));
          assertFalse(results.isEmpty());
      } catch (ServiceResponseException e) {
          fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                  e.getMessage(), e.getDebuggingInfo()));
      }
  }

  @Test
  public void testGetResourceUsageOrg() throws Exception {
      try {
          GetResourceUsageOrgOptions getResourceUsageOrgOptions = new GetResourceUsageOrgOptions.Builder()
                  .accountId(ACCOUNT_ID)
                  .organizationId(ORG_ID)
                  .billingmonth(BILLING_MONTH)
                  .names(true)
                  .limit(50L)
                  .build();

          List<InstanceUsage> results = new ArrayList<>();

          String offset = null;
          boolean moreResults = true;

          while (moreResults) {

              // Set "start" parameter for next page of results.
              getResourceUsageOrgOptions = getResourceUsageOrgOptions.newBuilder()
                      .start(offset)
                      .build();

              Response<InstancesUsage> response = service.getResourceUsageOrg(getResourceUsageOrgOptions).execute();
              assertNotNull(response);
              assertEquals(response.getStatusCode(), 200);

              InstancesUsage instancesUsageResult = response.getResult();
              assertNotNull(instancesUsageResult);

              // Add the just-retrieved page to the results.
              if (instancesUsageResult.getResources() != null) {
                  results.addAll(instancesUsageResult.getResources());
              }

              // Determine offset for next page of results.
              if (instancesUsageResult.getNext() != null) {
                  offset = instancesUsageResult.getNext().getOffset();
              } else {
                  offset = null;
                  moreResults = false;
              }
          }

          log(String.format("GetResourceUsageOrg response contained %d total resources.", results.size()));
          assertFalse(results.isEmpty());
      } catch (ServiceResponseException e) {
          fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                  e.getMessage(), e.getDebuggingInfo()));
      }
  }
 }
