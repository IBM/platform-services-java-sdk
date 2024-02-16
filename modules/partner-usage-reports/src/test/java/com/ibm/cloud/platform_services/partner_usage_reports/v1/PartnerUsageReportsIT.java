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
import com.ibm.cloud.platform_services.partner_usage_reports.v1.model.PartnerUsageReportSummary;
import com.ibm.cloud.platform_services.partner_usage_reports.v1.utils.TestUtilities;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
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
 * Integration test class for the PartnerUsageReports service.
 */
public class PartnerUsageReportsIT extends SdkIntegrationTestBase {
  public PartnerUsageReports service = null;
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
    return "../../partner_usage_reports_v1.env";
  }

  @BeforeClass
  public void constructService() {
    // Ask super if we should skip the tests.
    if (skipTests()) {
      return;
    }

    service = PartnerUsageReports.newInstance();
    assertNotNull(service);
    assertNotNull(service.getServiceUrl());

    // Load up our test-specific config properties.
    config = CredentialUtils.getServiceProperties(PartnerUsageReports.DEFAULT_SERVICE_NAME);
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
        .recurse(true)
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
        .recurse(true)
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

  @AfterClass
  public void tearDown() {
    // Add any clean up logic here
    System.out.println("Clean up complete.");
  }
 }
