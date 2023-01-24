/*
 * (C) Copyright IBM Corp. 2022, 2023.
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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.GetResourceUsageReportOptions;
import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.GetResourceUsageReportPager;
import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.Reports;
import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.ResourceUsageReport;
import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

/**
 * Unit test class for the EnterpriseUsageReports service.
 */
public class EnterpriseUsageReportsTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected EnterpriseUsageReports enterpriseUsageReportsService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new EnterpriseUsageReports(serviceName, null);
  }

  // Test the getResourceUsageReport operation with a valid options model parameter
  @Test
  public void testGetResourceUsageReportWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"limit\": 5, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\"}, \"reports\": [{\"entity_id\": \"de129b787b86403db7d3a14be2ae5f76\", \"entity_type\": \"enterprise\", \"entity_crn\": \"crn:v1:bluemix:public:enterprise::a/e9a57260546c4b4aa9ebfa316a82e56e::enterprise:de129b787b86403db7d3a14be2ae5f76\", \"entity_name\": \"Platform-Services\", \"billing_unit_id\": \"65719a07280a4022a9efa2f6ff4c3369\", \"billing_unit_crn\": \"crn:v1:bluemix:public:billing::a/3f99f8accbc848ea96f3c61a0ae22c44::billing-unit:65719a07280a4022a9efa2f6ff4c3369\", \"billing_unit_name\": \"Operations\", \"country_code\": \"USA\", \"currency_code\": \"USD\", \"month\": \"2017-08\", \"billable_cost\": 12, \"non_billable_cost\": 15, \"billable_rated_cost\": 17, \"non_billable_rated_cost\": 20, \"resources\": [{\"resource_id\": \"resourceId\", \"billable_cost\": 12, \"billable_rated_cost\": 17, \"non_billable_cost\": 15, \"non_billable_rated_cost\": 20, \"plans\": [{\"plan_id\": \"planId\", \"pricing_region\": \"pricingRegion\", \"pricing_plan_id\": \"pricingPlanId\", \"billable\": true, \"cost\": 4, \"rated_cost\": 9, \"usage\": [{\"metric\": \"UP-TIME\", \"unit\": \"HOURS\", \"quantity\": 711.11, \"rateable_quantity\": 700, \"cost\": 123.45, \"rated_cost\": 130, \"price\": [{\"anyKey\": \"anyValue\"}]}]}]}]}]}";
    String getResourceUsageReportPath = "/v1/resource-usage-reports";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetResourceUsageReportOptions model
    GetResourceUsageReportOptions getResourceUsageReportOptionsModel = new GetResourceUsageReportOptions.Builder()
      .enterpriseId("abc12340d4bf4e36b0423d209b286f24")
      .accountGroupId("def456a237b94b9a9238ef024e204c9f")
      .accountId("987abcba31834216b8c726a7dd9eb8d6")
      .children(true)
      .month("2019-06")
      .billingUnitId("testString")
      .limit(Long.valueOf("10"))
      .offset("testString")
      .build();

    // Invoke getResourceUsageReport() with a valid options model and verify the result
    Response<Reports> response = enterpriseUsageReportsService.getResourceUsageReport(getResourceUsageReportOptionsModel).execute();
    assertNotNull(response);
    Reports responseObj = response.getResult();
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
    assertEquals(query.get("enterprise_id"), "abc12340d4bf4e36b0423d209b286f24");
    assertEquals(query.get("account_group_id"), "def456a237b94b9a9238ef024e204c9f");
    assertEquals(query.get("account_id"), "987abcba31834216b8c726a7dd9eb8d6");
    assertEquals(Boolean.valueOf(query.get("children")), Boolean.valueOf(true));
    assertEquals(query.get("month"), "2019-06");
    assertEquals(query.get("billing_unit_id"), "testString");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(query.get("offset"), "testString");
  }

  // Test the getResourceUsageReport operation with and without retries enabled
  @Test
  public void testGetResourceUsageReportWRetries() throws Throwable {
    enterpriseUsageReportsService.enableRetries(4, 30);
    testGetResourceUsageReportWOptions();

    enterpriseUsageReportsService.disableRetries();
    testGetResourceUsageReportWOptions();
  }

  // Test the getResourceUsageReport operation using the GetResourceUsageReportPager.getNext() method
  @Test
  public void testGetResourceUsageReportWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"href\":\"https://myhost.com/somePath?offset=1\"},\"reports\":[{\"entity_id\":\"de129b787b86403db7d3a14be2ae5f76\",\"entity_type\":\"enterprise\",\"entity_crn\":\"crn:v1:bluemix:public:enterprise::a/e9a57260546c4b4aa9ebfa316a82e56e::enterprise:de129b787b86403db7d3a14be2ae5f76\",\"entity_name\":\"Platform-Services\",\"billing_unit_id\":\"65719a07280a4022a9efa2f6ff4c3369\",\"billing_unit_crn\":\"crn:v1:bluemix:public:billing::a/3f99f8accbc848ea96f3c61a0ae22c44::billing-unit:65719a07280a4022a9efa2f6ff4c3369\",\"billing_unit_name\":\"Operations\",\"country_code\":\"USA\",\"currency_code\":\"USD\",\"month\":\"2017-08\",\"billable_cost\":12,\"non_billable_cost\":15,\"billable_rated_cost\":17,\"non_billable_rated_cost\":20,\"resources\":[{\"resource_id\":\"resourceId\",\"billable_cost\":12,\"billable_rated_cost\":17,\"non_billable_cost\":15,\"non_billable_rated_cost\":20,\"plans\":[{\"plan_id\":\"planId\",\"pricing_region\":\"pricingRegion\",\"pricing_plan_id\":\"pricingPlanId\",\"billable\":true,\"cost\":4,\"rated_cost\":9,\"usage\":[{\"metric\":\"UP-TIME\",\"unit\":\"HOURS\",\"quantity\":711.11,\"rateable_quantity\":700,\"cost\":123.45,\"rated_cost\":130,\"price\":[{\"anyKey\":\"anyValue\"}]}]}]}]}],\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"reports\":[{\"entity_id\":\"de129b787b86403db7d3a14be2ae5f76\",\"entity_type\":\"enterprise\",\"entity_crn\":\"crn:v1:bluemix:public:enterprise::a/e9a57260546c4b4aa9ebfa316a82e56e::enterprise:de129b787b86403db7d3a14be2ae5f76\",\"entity_name\":\"Platform-Services\",\"billing_unit_id\":\"65719a07280a4022a9efa2f6ff4c3369\",\"billing_unit_crn\":\"crn:v1:bluemix:public:billing::a/3f99f8accbc848ea96f3c61a0ae22c44::billing-unit:65719a07280a4022a9efa2f6ff4c3369\",\"billing_unit_name\":\"Operations\",\"country_code\":\"USA\",\"currency_code\":\"USD\",\"month\":\"2017-08\",\"billable_cost\":12,\"non_billable_cost\":15,\"billable_rated_cost\":17,\"non_billable_rated_cost\":20,\"resources\":[{\"resource_id\":\"resourceId\",\"billable_cost\":12,\"billable_rated_cost\":17,\"non_billable_cost\":15,\"non_billable_rated_cost\":20,\"plans\":[{\"plan_id\":\"planId\",\"pricing_region\":\"pricingRegion\",\"pricing_plan_id\":\"pricingPlanId\",\"billable\":true,\"cost\":4,\"rated_cost\":9,\"usage\":[{\"metric\":\"UP-TIME\",\"unit\":\"HOURS\",\"quantity\":711.11,\"rateable_quantity\":700,\"cost\":123.45,\"rated_cost\":130,\"price\":[{\"anyKey\":\"anyValue\"}]}]}]}]}],\"total_count\":2,\"limit\":1}";
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
      .enterpriseId("abc12340d4bf4e36b0423d209b286f24")
      .accountGroupId("def456a237b94b9a9238ef024e204c9f")
      .accountId("987abcba31834216b8c726a7dd9eb8d6")
      .children(true)
      .month("2019-06")
      .billingUnitId("testString")
      .limit(Long.valueOf("10"))
      .build();

    List<ResourceUsageReport> allResults = new ArrayList<>();
    GetResourceUsageReportPager pager = new GetResourceUsageReportPager(enterpriseUsageReportsService, getResourceUsageReportOptions);
    while (pager.hasNext()) {
      List<ResourceUsageReport> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }

  // Test the getResourceUsageReport operation using the GetResourceUsageReportPager.getAll() method
  @Test
  public void testGetResourceUsageReportWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"href\":\"https://myhost.com/somePath?offset=1\"},\"reports\":[{\"entity_id\":\"de129b787b86403db7d3a14be2ae5f76\",\"entity_type\":\"enterprise\",\"entity_crn\":\"crn:v1:bluemix:public:enterprise::a/e9a57260546c4b4aa9ebfa316a82e56e::enterprise:de129b787b86403db7d3a14be2ae5f76\",\"entity_name\":\"Platform-Services\",\"billing_unit_id\":\"65719a07280a4022a9efa2f6ff4c3369\",\"billing_unit_crn\":\"crn:v1:bluemix:public:billing::a/3f99f8accbc848ea96f3c61a0ae22c44::billing-unit:65719a07280a4022a9efa2f6ff4c3369\",\"billing_unit_name\":\"Operations\",\"country_code\":\"USA\",\"currency_code\":\"USD\",\"month\":\"2017-08\",\"billable_cost\":12,\"non_billable_cost\":15,\"billable_rated_cost\":17,\"non_billable_rated_cost\":20,\"resources\":[{\"resource_id\":\"resourceId\",\"billable_cost\":12,\"billable_rated_cost\":17,\"non_billable_cost\":15,\"non_billable_rated_cost\":20,\"plans\":[{\"plan_id\":\"planId\",\"pricing_region\":\"pricingRegion\",\"pricing_plan_id\":\"pricingPlanId\",\"billable\":true,\"cost\":4,\"rated_cost\":9,\"usage\":[{\"metric\":\"UP-TIME\",\"unit\":\"HOURS\",\"quantity\":711.11,\"rateable_quantity\":700,\"cost\":123.45,\"rated_cost\":130,\"price\":[{\"anyKey\":\"anyValue\"}]}]}]}]}],\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"reports\":[{\"entity_id\":\"de129b787b86403db7d3a14be2ae5f76\",\"entity_type\":\"enterprise\",\"entity_crn\":\"crn:v1:bluemix:public:enterprise::a/e9a57260546c4b4aa9ebfa316a82e56e::enterprise:de129b787b86403db7d3a14be2ae5f76\",\"entity_name\":\"Platform-Services\",\"billing_unit_id\":\"65719a07280a4022a9efa2f6ff4c3369\",\"billing_unit_crn\":\"crn:v1:bluemix:public:billing::a/3f99f8accbc848ea96f3c61a0ae22c44::billing-unit:65719a07280a4022a9efa2f6ff4c3369\",\"billing_unit_name\":\"Operations\",\"country_code\":\"USA\",\"currency_code\":\"USD\",\"month\":\"2017-08\",\"billable_cost\":12,\"non_billable_cost\":15,\"billable_rated_cost\":17,\"non_billable_rated_cost\":20,\"resources\":[{\"resource_id\":\"resourceId\",\"billable_cost\":12,\"billable_rated_cost\":17,\"non_billable_cost\":15,\"non_billable_rated_cost\":20,\"plans\":[{\"plan_id\":\"planId\",\"pricing_region\":\"pricingRegion\",\"pricing_plan_id\":\"pricingPlanId\",\"billable\":true,\"cost\":4,\"rated_cost\":9,\"usage\":[{\"metric\":\"UP-TIME\",\"unit\":\"HOURS\",\"quantity\":711.11,\"rateable_quantity\":700,\"cost\":123.45,\"rated_cost\":130,\"price\":[{\"anyKey\":\"anyValue\"}]}]}]}]}],\"total_count\":2,\"limit\":1}";
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
      .enterpriseId("abc12340d4bf4e36b0423d209b286f24")
      .accountGroupId("def456a237b94b9a9238ef024e204c9f")
      .accountId("987abcba31834216b8c726a7dd9eb8d6")
      .children(true)
      .month("2019-06")
      .billingUnitId("testString")
      .limit(Long.valueOf("10"))
      .build();

    GetResourceUsageReportPager pager = new GetResourceUsageReportPager(enterpriseUsageReportsService, getResourceUsageReportOptions);
    List<ResourceUsageReport> allResults = pager.getAll();
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
    enterpriseUsageReportsService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    System.setProperty("TESTSERVICE_AUTH_TYPE", "noAuth");
    final String serviceName = "testService";

    enterpriseUsageReportsService = EnterpriseUsageReports.newInstance(serviceName);
    String url = server.url("/").toString();
    enterpriseUsageReportsService.setServiceUrl(url);
  }
}