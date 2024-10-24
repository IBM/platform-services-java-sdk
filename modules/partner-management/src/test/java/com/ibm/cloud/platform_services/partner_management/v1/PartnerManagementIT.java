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

import com.ibm.cloud.platform_services.partner_management.v1.model.BillingOption;
import com.ibm.cloud.platform_services.partner_management.v1.model.BillingOptionsSummary;
import com.ibm.cloud.platform_services.partner_management.v1.model.CreditPoolsReport;
import com.ibm.cloud.platform_services.partner_management.v1.model.CreditPoolsReportSummary;
import com.ibm.cloud.platform_services.partner_management.v1.model.GetBillingOptionsOptions;
import com.ibm.cloud.platform_services.partner_management.v1.model.GetCreditPoolsReportOptions;
import com.ibm.cloud.platform_services.partner_management.v1.model.GetResourceUsageReportOptions;
import com.ibm.cloud.platform_services.partner_management.v1.model.GetResourceUsageReportPager;
import com.ibm.cloud.platform_services.partner_management.v1.model.MetricUsage;
import com.ibm.cloud.platform_services.partner_management.v1.model.Overage;
import com.ibm.cloud.platform_services.partner_management.v1.model.PartnerUsageReport;
import com.ibm.cloud.platform_services.partner_management.v1.model.PartnerUsageReportSummary;
import com.ibm.cloud.platform_services.partner_management.v1.model.PartnerUsageReportSummaryFirst;
import com.ibm.cloud.platform_services.partner_management.v1.model.PartnerUsageReportSummaryNext;
import com.ibm.cloud.platform_services.partner_management.v1.model.PlanUsage;
import com.ibm.cloud.platform_services.partner_management.v1.model.ResourceUsage;
import com.ibm.cloud.platform_services.partner_management.v1.model.TermCredits;
import com.ibm.cloud.platform_services.partner_management.v1.utils.TestUtilities;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
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
 * Integration test class for the PartnerManagement service.
 */
public class PartnerManagementIT extends SdkIntegrationTestBase {
  public PartnerManagement service = null;
  public static Map<String, String> config = null;

  // Test-related config properties.
  private static String PARTNER_ID;
  private static String RESELLER_ID;
  private static String CUSTOMER_ID;
  private static String BILLING_MONTH;
  private static String VIEWPOINT;

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();
  /**
   * This method provides our config filename to the base class.
   */

  public String getConfigFilename() {
    return "../../partner_management_v1.env";
  }

  @BeforeClass
  public void constructService() {
    // Ask super if we should skip the tests.
    if (skipTests()) {
      return;
    }

    service = PartnerManagement.newInstance();
    assertNotNull(service);
    assertNotNull(service.getServiceUrl());

    // Load up our test-specific config properties.
    config = CredentialUtils.getServiceProperties(PartnerManagement.DEFAULT_SERVICE_NAME);
    assertNotNull(config);
    assertFalse(config.isEmpty());
    assertEquals(service.getServiceUrl(), config.get("URL"));

    service.enableRetries(4, 30);

    PARTNER_ID = config.get("PARTNER_ID");
    RESELLER_ID = config.get("RESELLER_ID");
    CUSTOMER_ID = config.get("CUSTOMER_ID");
    BILLING_MONTH = config.get("BILLING_MONTH");
    VIEWPOINT = config.get("VIEWPOINT");
    assertNotNull(PARTNER_ID);
    assertNotNull(RESELLER_ID);
    assertNotNull(CUSTOMER_ID);
    assertNotNull(BILLING_MONTH);
    assertNotNull(VIEWPOINT);

    System.out.println("Setup complete.");
  }

  @Test
  public void testGetResourceUsageReportPartner() throws Exception {
    try {
      GetResourceUsageReportOptions getResourceUsageReportOptions = new GetResourceUsageReportOptions.Builder()
        .partnerId(PARTNER_ID)
        .month(BILLING_MONTH)
        .limit(Long.valueOf("10"))
        .build();

      // Invoke operation
      Response<PartnerUsageReportSummary> response = service.getResourceUsageReport(getResourceUsageReportOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      PartnerUsageReportSummary partnerUsageReportSummaryResult = response.getResult();
      assertNotNull(partnerUsageReportSummaryResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetResourceUsageReportPartner" })
  public void testGetResourceUsageReportPartnerWithPager() throws Exception {
    try {
      GetResourceUsageReportOptions options = new GetResourceUsageReportOptions.Builder()
        .partnerId(PARTNER_ID)
        .month(BILLING_MONTH)
        .limit(Long.valueOf("10"))
        .build();

      // Test getNext().
      List<PartnerUsageReport> allResults = new ArrayList<>();
      GetResourceUsageReportPager pager = new GetResourceUsageReportPager(service, options);
      while (pager.hasNext()) {
        List<PartnerUsageReport> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }
      assertFalse(allResults.isEmpty());

      // Test getAll();
      pager = new GetResourceUsageReportPager(service, options);
      List<PartnerUsageReport> allItems = pager.getAll();
      assertNotNull(allItems);
      assertFalse(allItems.isEmpty());

      assertEquals(allItems.size(), allResults.size());
      System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetResourceUsageReportResellerForPartner() throws Exception {
    try {
      GetResourceUsageReportOptions getResourceUsageReportOptions = new GetResourceUsageReportOptions.Builder()
        .partnerId(PARTNER_ID)
        .children(true)
        .month(BILLING_MONTH)
        .limit(Long.valueOf("10"))
        .build();

      // Invoke operation
      Response<PartnerUsageReportSummary> response = service.getResourceUsageReport(getResourceUsageReportOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      PartnerUsageReportSummary partnerUsageReportSummaryResult = response.getResult();
      assertNotNull(partnerUsageReportSummaryResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetResourceUsageReportResellerForPartner" })
  public void testGetResourceUsageReportResellerForPartnerWithPager() throws Exception {
    try {
      GetResourceUsageReportOptions options = new GetResourceUsageReportOptions.Builder()
        .partnerId(PARTNER_ID)
        .children(true)
        .month(BILLING_MONTH)
        .limit(Long.valueOf("10"))
        .build();

      // Test getNext().
      List<PartnerUsageReport> allResults = new ArrayList<>();
      GetResourceUsageReportPager pager = new GetResourceUsageReportPager(service, options);
      while (pager.hasNext()) {
        List<PartnerUsageReport> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }
      assertFalse(allResults.isEmpty());

      // Test getAll();
      pager = new GetResourceUsageReportPager(service, options);
      List<PartnerUsageReport> allItems = pager.getAll();
      assertNotNull(allItems);
      assertFalse(allItems.isEmpty());

      assertEquals(allItems.size(), allResults.size());
      System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetResourceUsageReportSpecificReseller() throws Exception {
    try {
      GetResourceUsageReportOptions getResourceUsageReportOptions = new GetResourceUsageReportOptions.Builder()
        .partnerId(PARTNER_ID)
        .resellerId(RESELLER_ID)
        .month(BILLING_MONTH)
        .limit(Long.valueOf("10"))
        .build();

      // Invoke operation
      Response<PartnerUsageReportSummary> response = service.getResourceUsageReport(getResourceUsageReportOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      PartnerUsageReportSummary partnerUsageReportSummaryResult = response.getResult();
      assertNotNull(partnerUsageReportSummaryResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetResourceUsageReportSpecificReseller" })
  public void testGetResourceUsageReportSpecificResellerWithPager() throws Exception {
    try {
      GetResourceUsageReportOptions options = new GetResourceUsageReportOptions.Builder()
        .partnerId(PARTNER_ID)
        .resellerId(RESELLER_ID)
        .month(BILLING_MONTH)
        .limit(Long.valueOf("10"))
        .build();

      // Test getNext().
      List<PartnerUsageReport> allResults = new ArrayList<>();
      GetResourceUsageReportPager pager = new GetResourceUsageReportPager(service, options);
      while (pager.hasNext()) {
        List<PartnerUsageReport> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }
      assertFalse(allResults.isEmpty());

      // Test getAll();
      pager = new GetResourceUsageReportPager(service, options);
      List<PartnerUsageReport> allItems = pager.getAll();
      assertNotNull(allItems);
      assertFalse(allItems.isEmpty());

      assertEquals(allItems.size(), allResults.size());
      System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetResourceUsageReportSpecificCustomer() throws Exception {
    try {
      GetResourceUsageReportOptions getResourceUsageReportOptions = new GetResourceUsageReportOptions.Builder()
        .partnerId(PARTNER_ID)
        .customerId(CUSTOMER_ID)
        .month(BILLING_MONTH)
        .limit(Long.valueOf("10"))
        .build();

      // Invoke operation
      Response<PartnerUsageReportSummary> response = service.getResourceUsageReport(getResourceUsageReportOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      PartnerUsageReportSummary partnerUsageReportSummaryResult = response.getResult();
      assertNotNull(partnerUsageReportSummaryResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetResourceUsageReportSpecificCustomer" })
  public void testGetResourceUsageReportSpecificCustomerWithPager() throws Exception {
    try {
      GetResourceUsageReportOptions options = new GetResourceUsageReportOptions.Builder()
        .partnerId(PARTNER_ID)
        .customerId(CUSTOMER_ID)
        .month(BILLING_MONTH)
        .limit(Long.valueOf("10"))
        .build();

      // Test getNext().
      List<PartnerUsageReport> allResults = new ArrayList<>();
      GetResourceUsageReportPager pager = new GetResourceUsageReportPager(service, options);
      while (pager.hasNext()) {
        List<PartnerUsageReport> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }
      assertFalse(allResults.isEmpty());

      // Test getAll();
      pager = new GetResourceUsageReportPager(service, options);
      List<PartnerUsageReport> allItems = pager.getAll();
      assertNotNull(allItems);
      assertFalse(allItems.isEmpty());

      assertEquals(allItems.size(), allResults.size());
      System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetResourceUsageReportRecursive() throws Exception {
    try {
      GetResourceUsageReportOptions getResourceUsageReportOptions = new GetResourceUsageReportOptions.Builder()
        .partnerId(PARTNER_ID)
        .month(BILLING_MONTH)
        .recurse(false)
        .limit(Long.valueOf("10"))
        .build();

      // Invoke operation
      Response<PartnerUsageReportSummary> response = service.getResourceUsageReport(getResourceUsageReportOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      PartnerUsageReportSummary partnerUsageReportSummaryResult = response.getResult();
      assertNotNull(partnerUsageReportSummaryResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetResourceUsageReportRecursive" })
  public void testGetResourceUsageReportRecursiveWithPager() throws Exception {
    try {
      GetResourceUsageReportOptions options = new GetResourceUsageReportOptions.Builder()
        .partnerId(PARTNER_ID)
        .month(BILLING_MONTH)
        .recurse(false)
        .limit(Long.valueOf("10"))
        .build();

      // Test getNext().
      List<PartnerUsageReport> allResults = new ArrayList<>();
      GetResourceUsageReportPager pager = new GetResourceUsageReportPager(service, options);
      while (pager.hasNext()) {
        List<PartnerUsageReport> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }
      assertFalse(allResults.isEmpty());

      // Test getAll();
      pager = new GetResourceUsageReportPager(service, options);
      List<PartnerUsageReport> allItems = pager.getAll();
      assertNotNull(allItems);
      assertFalse(allItems.isEmpty());

      assertEquals(allItems.size(), allResults.size());
      System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetResourceUsageReportViewpoint() throws Exception {
    try {
      GetResourceUsageReportOptions getResourceUsageReportOptions = new GetResourceUsageReportOptions.Builder()
        .partnerId(PARTNER_ID)
        .children(true)
        .month(BILLING_MONTH)
        .viewpoint(VIEWPOINT)
        .limit(Long.valueOf("10"))
        .build();

      // Invoke operation
      Response<PartnerUsageReportSummary> response = service.getResourceUsageReport(getResourceUsageReportOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      PartnerUsageReportSummary partnerUsageReportSummaryResult = response.getResult();
      assertNotNull(partnerUsageReportSummaryResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = { "testGetResourceUsageReportViewpoint" })
  public void testGetResourceUsageReportViewpointWithPager() throws Exception {
    try {
      GetResourceUsageReportOptions options = new GetResourceUsageReportOptions.Builder()
        .partnerId(PARTNER_ID)
        .children(true)
        .month(BILLING_MONTH)
        .viewpoint(VIEWPOINT)
        .limit(Long.valueOf("10"))
        .build();

      // Test getNext().
      List<PartnerUsageReport> allResults = new ArrayList<>();
      GetResourceUsageReportPager pager = new GetResourceUsageReportPager(service, options);
      while (pager.hasNext()) {
        List<PartnerUsageReport> nextPage = pager.getNext();
        assertNotNull(nextPage);
        allResults.addAll(nextPage);
      }
      assertFalse(allResults.isEmpty());

      // Test getAll();
      pager = new GetResourceUsageReportPager(service, options);
      List<PartnerUsageReport> allItems = pager.getAll();
      assertNotNull(allItems);
      assertFalse(allItems.isEmpty());

      assertEquals(allItems.size(), allResults.size());
      System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetBillingOptions() throws Exception {
    try {
      GetBillingOptionsOptions getBillingOptionsOptions = new GetBillingOptionsOptions.Builder()
        .partnerId(PARTNER_ID)
        .date(BILLING_MONTH)
        .limit(Long.valueOf("30"))
        .build();

      // Invoke operation
      Response<BillingOptionsSummary> response = service.getBillingOptions(getBillingOptionsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      BillingOptionsSummary billingOptionsSummaryResult = response.getResult();
      assertNotNull(billingOptionsSummaryResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetBillingOptionsResellerForPartner() throws Exception {
    try {
      GetBillingOptionsOptions getBillingOptionsOptions = new GetBillingOptionsOptions.Builder()
        .partnerId(PARTNER_ID)
        .resellerId(RESELLER_ID)
        .date(BILLING_MONTH)
        .limit(Long.valueOf("30"))
        .build();

      // Invoke operation
      Response<BillingOptionsSummary> response = service.getBillingOptions(getBillingOptionsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      BillingOptionsSummary billingOptionsSummaryResult = response.getResult();
      assertNotNull(billingOptionsSummaryResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetBillingOptionsCustomerForPartner() throws Exception {
    try {
      GetBillingOptionsOptions getBillingOptionsOptions = new GetBillingOptionsOptions.Builder()
        .partnerId(PARTNER_ID)
        .customerId(CUSTOMER_ID)
        .date(BILLING_MONTH)
        .limit(Long.valueOf("30"))
        .build();

      // Invoke operation
      Response<BillingOptionsSummary> response = service.getBillingOptions(getBillingOptionsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      BillingOptionsSummary billingOptionsSummaryResult = response.getResult();
      assertNotNull(billingOptionsSummaryResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetCreditPoolsReport() throws Exception {
    try {
      GetCreditPoolsReportOptions getCreditPoolsReportOptions = new GetCreditPoolsReportOptions.Builder()
        .partnerId(PARTNER_ID)
        .date(BILLING_MONTH)
        .limit(Long.valueOf("30"))
        .build();

      // Invoke operation
      Response<CreditPoolsReportSummary> response = service.getCreditPoolsReport(getCreditPoolsReportOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      CreditPoolsReportSummary creditPoolsReportSummaryResult = response.getResult();
      assertNotNull(creditPoolsReportSummaryResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetCreditPoolsReportResellerForPartner() throws Exception {
    try {
      GetCreditPoolsReportOptions getCreditPoolsReportOptions = new GetCreditPoolsReportOptions.Builder()
        .partnerId(PARTNER_ID)
        .resellerId(RESELLER_ID)
        .date(BILLING_MONTH)
        .limit(Long.valueOf("30"))
        .build();

      // Invoke operation
      Response<CreditPoolsReportSummary> response = service.getCreditPoolsReport(getCreditPoolsReportOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      CreditPoolsReportSummary creditPoolsReportSummaryResult = response.getResult();
      assertNotNull(creditPoolsReportSummaryResult);

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetCreditPoolsReportCustomerForPartner() throws Exception {
    try {
      GetCreditPoolsReportOptions getCreditPoolsReportOptions = new GetCreditPoolsReportOptions.Builder()
        .partnerId(PARTNER_ID)
        .customerId(CUSTOMER_ID)
        .date(BILLING_MONTH)
        .limit(Long.valueOf("30"))
        .build();

      // Invoke operation
      Response<CreditPoolsReportSummary> response = service.getCreditPoolsReport(getCreditPoolsReportOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      CreditPoolsReportSummary creditPoolsReportSummaryResult = response.getResult();
      assertNotNull(creditPoolsReportSummaryResult);

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
