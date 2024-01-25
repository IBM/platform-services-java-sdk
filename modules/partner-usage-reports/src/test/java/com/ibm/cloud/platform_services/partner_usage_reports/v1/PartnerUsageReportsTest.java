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
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PartnerUsageReports service.
 */
public class PartnerUsageReportsTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected PartnerUsageReports partnerUsageReportsService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new PartnerUsageReports(serviceName, null);
  }

  // Test the getResourceUsageReport operation with a valid options model parameter
  @Test
  public void testGetResourceUsageReportWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"limit\": 5, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"offset\": \"offset\"}, \"reports\": [{\"entity_id\": \"<distributor_enterprise_id>\", \"entity_type\": \"enterprise\", \"entity_crn\": \"crn:v1:bluemix:public:enterprise::a/fa359b76ff2c41eda727aad47b7e4063::enterprise:33a7eb04e7d547cd9489e90c99d476a5\", \"entity_name\": \"Arrow\", \"entity_partner_type\": \"DISTRIBUTOR\", \"viewpoint\": \"DISTRIBUTOR\", \"month\": \"2024-01\", \"currency_code\": \"EUR\", \"country_code\": \"FRA\", \"billable_cost\": 2331828.33275813, \"billable_rated_cost\": 3817593.35186263, \"non_billable_cost\": 0, \"non_billable_rated_cost\": 0, \"resources\": [{\"resource_id\": \"cloudant\", \"resource_name\": \"Cloudant\", \"billable_cost\": 75, \"billable_rated_cost\": 75, \"non_billable_cost\": 0, \"non_billable_rated_cost\": 0, \"plans\": [{\"plan_id\": \"cloudant-standard\", \"pricing_region\": \"Standard\", \"pricing_plan_id\": \"billable:v4:cloudant-standard::1552694400000:\", \"billable\": true, \"cost\": 75, \"rated_cost\": 75, \"usage\": [{\"metric\": \"GB_STORAGE_ACCRUED_PER_MONTH\", \"unit\": \"GIGABYTE_MONTHS\", \"quantity\": 10, \"rateable_quantity\": 10, \"cost\": 10, \"rated_cost\": 10, \"price\": [{\"anyKey\": \"anyValue\"}]}]}]}]}]}";
    String getResourceUsageReportPath = "/v1/resource-usage-reports";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetResourceUsageReportOptions model
    GetResourceUsageReportOptions getResourceUsageReportOptionsModel = new GetResourceUsageReportOptions.Builder()
      .partnerId("testString")
      .resellerId("testString")
      .customerId("testString")
      .children(false)
      .month("2024-01")
      .viewpoint("DISTRIBUTOR")
      .recurse(false)
      .limit(Long.valueOf("10"))
      .offset("testString")
      .build();

    // Invoke getResourceUsageReport() with a valid options model and verify the result
    Response<PartnerUsageReportSummary> response = partnerUsageReportsService.getResourceUsageReport(getResourceUsageReportOptionsModel).execute();
    assertNotNull(response);
    PartnerUsageReportSummary responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getResourceUsageReportPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("partner_id"), "testString");
    assertEquals(query.get("reseller_id"), "testString");
    assertEquals(query.get("customer_id"), "testString");
    assertEquals(Boolean.valueOf(query.get("children")), Boolean.valueOf(false));
    assertEquals(query.get("month"), "2024-01");
    assertEquals(query.get("viewpoint"), "DISTRIBUTOR");
    assertEquals(Boolean.valueOf(query.get("recurse")), Boolean.valueOf(false));
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(query.get("offset"), "testString");
  }

  // Test the getResourceUsageReport operation with and without retries enabled
  @Test
  public void testGetResourceUsageReportWRetries() throws Throwable {
    partnerUsageReportsService.enableRetries(4, 30);
    testGetResourceUsageReportWOptions();

    partnerUsageReportsService.disableRetries();
    testGetResourceUsageReportWOptions();
  }

  // Test the getResourceUsageReport operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetResourceUsageReportNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    partnerUsageReportsService.getResourceUsageReport(null).execute();
  }

  // Test the getResourceUsageReport operation using the GetResourceUsageReportPager.getNext() method
  @Test
  public void testGetResourceUsageReportWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"offset\":\"1\"},\"reports\":[{\"entity_id\":\"<distributor_enterprise_id>\",\"entity_type\":\"enterprise\",\"entity_crn\":\"crn:v1:bluemix:public:enterprise::a/fa359b76ff2c41eda727aad47b7e4063::enterprise:33a7eb04e7d547cd9489e90c99d476a5\",\"entity_name\":\"Arrow\",\"entity_partner_type\":\"DISTRIBUTOR\",\"viewpoint\":\"DISTRIBUTOR\",\"month\":\"2024-01\",\"currency_code\":\"EUR\",\"country_code\":\"FRA\",\"billable_cost\":2331828.33275813,\"billable_rated_cost\":3817593.35186263,\"non_billable_cost\":0,\"non_billable_rated_cost\":0,\"resources\":[{\"resource_id\":\"cloudant\",\"resource_name\":\"Cloudant\",\"billable_cost\":75,\"billable_rated_cost\":75,\"non_billable_cost\":0,\"non_billable_rated_cost\":0,\"plans\":[{\"plan_id\":\"cloudant-standard\",\"pricing_region\":\"Standard\",\"pricing_plan_id\":\"billable:v4:cloudant-standard::1552694400000:\",\"billable\":true,\"cost\":75,\"rated_cost\":75,\"usage\":[{\"metric\":\"GB_STORAGE_ACCRUED_PER_MONTH\",\"unit\":\"GIGABYTE_MONTHS\",\"quantity\":10,\"rateable_quantity\":10,\"cost\":10,\"rated_cost\":10,\"price\":[{\"anyKey\":\"anyValue\"}]}]}]}]}],\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"reports\":[{\"entity_id\":\"<distributor_enterprise_id>\",\"entity_type\":\"enterprise\",\"entity_crn\":\"crn:v1:bluemix:public:enterprise::a/fa359b76ff2c41eda727aad47b7e4063::enterprise:33a7eb04e7d547cd9489e90c99d476a5\",\"entity_name\":\"Arrow\",\"entity_partner_type\":\"DISTRIBUTOR\",\"viewpoint\":\"DISTRIBUTOR\",\"month\":\"2024-01\",\"currency_code\":\"EUR\",\"country_code\":\"FRA\",\"billable_cost\":2331828.33275813,\"billable_rated_cost\":3817593.35186263,\"non_billable_cost\":0,\"non_billable_rated_cost\":0,\"resources\":[{\"resource_id\":\"cloudant\",\"resource_name\":\"Cloudant\",\"billable_cost\":75,\"billable_rated_cost\":75,\"non_billable_cost\":0,\"non_billable_rated_cost\":0,\"plans\":[{\"plan_id\":\"cloudant-standard\",\"pricing_region\":\"Standard\",\"pricing_plan_id\":\"billable:v4:cloudant-standard::1552694400000:\",\"billable\":true,\"cost\":75,\"rated_cost\":75,\"usage\":[{\"metric\":\"GB_STORAGE_ACCRUED_PER_MONTH\",\"unit\":\"GIGABYTE_MONTHS\",\"quantity\":10,\"rateable_quantity\":10,\"cost\":10,\"rated_cost\":10,\"price\":[{\"anyKey\":\"anyValue\"}]}]}]}]}],\"total_count\":2,\"limit\":1}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    GetResourceUsageReportOptions getResourceUsageReportOptions = new GetResourceUsageReportOptions.Builder()
      .partnerId("testString")
      .resellerId("testString")
      .customerId("testString")
      .children(false)
      .month("2024-01")
      .viewpoint("DISTRIBUTOR")
      .recurse(false)
      .limit(Long.valueOf("10"))
      .build();

    List<PartnerUsageReport> allResults = new ArrayList<>();
    GetResourceUsageReportPager pager = new GetResourceUsageReportPager(partnerUsageReportsService, getResourceUsageReportOptions);
    while (pager.hasNext()) {
      List<PartnerUsageReport> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the getResourceUsageReport operation using the GetResourceUsageReportPager.getAll() method
  @Test
  public void testGetResourceUsageReportWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"offset\":\"1\"},\"reports\":[{\"entity_id\":\"<distributor_enterprise_id>\",\"entity_type\":\"enterprise\",\"entity_crn\":\"crn:v1:bluemix:public:enterprise::a/fa359b76ff2c41eda727aad47b7e4063::enterprise:33a7eb04e7d547cd9489e90c99d476a5\",\"entity_name\":\"Arrow\",\"entity_partner_type\":\"DISTRIBUTOR\",\"viewpoint\":\"DISTRIBUTOR\",\"month\":\"2024-01\",\"currency_code\":\"EUR\",\"country_code\":\"FRA\",\"billable_cost\":2331828.33275813,\"billable_rated_cost\":3817593.35186263,\"non_billable_cost\":0,\"non_billable_rated_cost\":0,\"resources\":[{\"resource_id\":\"cloudant\",\"resource_name\":\"Cloudant\",\"billable_cost\":75,\"billable_rated_cost\":75,\"non_billable_cost\":0,\"non_billable_rated_cost\":0,\"plans\":[{\"plan_id\":\"cloudant-standard\",\"pricing_region\":\"Standard\",\"pricing_plan_id\":\"billable:v4:cloudant-standard::1552694400000:\",\"billable\":true,\"cost\":75,\"rated_cost\":75,\"usage\":[{\"metric\":\"GB_STORAGE_ACCRUED_PER_MONTH\",\"unit\":\"GIGABYTE_MONTHS\",\"quantity\":10,\"rateable_quantity\":10,\"cost\":10,\"rated_cost\":10,\"price\":[{\"anyKey\":\"anyValue\"}]}]}]}]}],\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"reports\":[{\"entity_id\":\"<distributor_enterprise_id>\",\"entity_type\":\"enterprise\",\"entity_crn\":\"crn:v1:bluemix:public:enterprise::a/fa359b76ff2c41eda727aad47b7e4063::enterprise:33a7eb04e7d547cd9489e90c99d476a5\",\"entity_name\":\"Arrow\",\"entity_partner_type\":\"DISTRIBUTOR\",\"viewpoint\":\"DISTRIBUTOR\",\"month\":\"2024-01\",\"currency_code\":\"EUR\",\"country_code\":\"FRA\",\"billable_cost\":2331828.33275813,\"billable_rated_cost\":3817593.35186263,\"non_billable_cost\":0,\"non_billable_rated_cost\":0,\"resources\":[{\"resource_id\":\"cloudant\",\"resource_name\":\"Cloudant\",\"billable_cost\":75,\"billable_rated_cost\":75,\"non_billable_cost\":0,\"non_billable_rated_cost\":0,\"plans\":[{\"plan_id\":\"cloudant-standard\",\"pricing_region\":\"Standard\",\"pricing_plan_id\":\"billable:v4:cloudant-standard::1552694400000:\",\"billable\":true,\"cost\":75,\"rated_cost\":75,\"usage\":[{\"metric\":\"GB_STORAGE_ACCRUED_PER_MONTH\",\"unit\":\"GIGABYTE_MONTHS\",\"quantity\":10,\"rateable_quantity\":10,\"cost\":10,\"rated_cost\":10,\"price\":[{\"anyKey\":\"anyValue\"}]}]}]}]}],\"total_count\":2,\"limit\":1}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    GetResourceUsageReportOptions getResourceUsageReportOptions = new GetResourceUsageReportOptions.Builder()
      .partnerId("testString")
      .resellerId("testString")
      .customerId("testString")
      .children(false)
      .month("2024-01")
      .viewpoint("DISTRIBUTOR")
      .recurse(false)
      .limit(Long.valueOf("10"))
      .build();

    GetResourceUsageReportPager pager = new GetResourceUsageReportPager(partnerUsageReportsService, getResourceUsageReportOptions);
    List<PartnerUsageReport> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Perform setup needed before each test method
  @BeforeMethod
  public void beforeEachTest() {
    // Start the mock server.
    try {
      server = new MockWebServer();
      server.start();
    } catch (IOException err) {
      fail("Failed to instantiate mock web server");
    }

    // Construct an instance of the service
    constructClientService();
  }

  // Perform tear down after each test method
  @AfterMethod
  public void afterEachTest() throws IOException {
    server.shutdown();
    partnerUsageReportsService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    System.setProperty("TESTSERVICE_AUTH_TYPE", "noAuth");
    final String serviceName = "testService";

    partnerUsageReportsService = PartnerUsageReports.newInstance(serviceName);
    String url = server.url("/").toString();
    partnerUsageReportsService.setServiceUrl(url);
  }
}