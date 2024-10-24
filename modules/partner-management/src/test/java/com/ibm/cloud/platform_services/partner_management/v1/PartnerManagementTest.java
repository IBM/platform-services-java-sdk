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

import com.ibm.cloud.platform_services.partner_management.v1.PartnerManagement;
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
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
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
 * Unit test class for the PartnerManagement service.
 */
public class PartnerManagementTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected PartnerManagement partnerManagementService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new PartnerManagement(serviceName, null);
  }

  // Test the getResourceUsageReport operation with a valid options model parameter
  @Test
  public void testGetResourceUsageReportWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"limit\": 5, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"offset\": \"offset\"}, \"reports\": [{\"entity_id\": \"<distributor_enterprise_id>\", \"entity_type\": \"enterprise\", \"entity_crn\": \"crn:v1:bluemix:public:enterprise::a/fa359b76ff2c41eda727aad47b7e4063::enterprise:33a7eb04e7d547cd9489e90c99d476a5\", \"entity_name\": \"Company\", \"entity_partner_type\": \"DISTRIBUTOR\", \"viewpoint\": \"DISTRIBUTOR\", \"month\": \"2024-01\", \"currency_code\": \"EUR\", \"country_code\": \"FRA\", \"billable_cost\": 2331828.33275813, \"billable_rated_cost\": 3817593.35186263, \"non_billable_cost\": 0, \"non_billable_rated_cost\": 0, \"resources\": [{\"resource_id\": \"cloudant\", \"resource_name\": \"Cloudant\", \"billable_cost\": 75, \"billable_rated_cost\": 75, \"non_billable_cost\": 0, \"non_billable_rated_cost\": 0, \"plans\": [{\"plan_id\": \"cloudant-standard\", \"pricing_region\": \"Standard\", \"pricing_plan_id\": \"billable:v4:cloudant-standard::1552694400000:\", \"billable\": true, \"cost\": 75, \"rated_cost\": 75, \"usage\": [{\"metric\": \"GB_STORAGE_ACCRUED_PER_MONTH\", \"unit\": \"GIGABYTE_MONTHS\", \"quantity\": 10, \"rateable_quantity\": 10, \"cost\": 10, \"rated_cost\": 10, \"price\": [{\"anyKey\": \"anyValue\"}]}]}]}]}]}";
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
    Response<PartnerUsageReportSummary> response = partnerManagementService.getResourceUsageReport(getResourceUsageReportOptionsModel).execute();
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
    partnerManagementService.enableRetries(4, 30);
    testGetResourceUsageReportWOptions();

    partnerManagementService.disableRetries();
    testGetResourceUsageReportWOptions();
  }

  // Test the getResourceUsageReport operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetResourceUsageReportNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    partnerManagementService.getResourceUsageReport(null).execute();
  }

  // Test the getResourceUsageReport operation using the GetResourceUsageReportPager.getNext() method
  @Test
  public void testGetResourceUsageReportWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"offset\":\"1\"},\"reports\":[{\"entity_id\":\"<distributor_enterprise_id>\",\"entity_type\":\"enterprise\",\"entity_crn\":\"crn:v1:bluemix:public:enterprise::a/fa359b76ff2c41eda727aad47b7e4063::enterprise:33a7eb04e7d547cd9489e90c99d476a5\",\"entity_name\":\"Company\",\"entity_partner_type\":\"DISTRIBUTOR\",\"viewpoint\":\"DISTRIBUTOR\",\"month\":\"2024-01\",\"currency_code\":\"EUR\",\"country_code\":\"FRA\",\"billable_cost\":2331828.33275813,\"billable_rated_cost\":3817593.35186263,\"non_billable_cost\":0,\"non_billable_rated_cost\":0,\"resources\":[{\"resource_id\":\"cloudant\",\"resource_name\":\"Cloudant\",\"billable_cost\":75,\"billable_rated_cost\":75,\"non_billable_cost\":0,\"non_billable_rated_cost\":0,\"plans\":[{\"plan_id\":\"cloudant-standard\",\"pricing_region\":\"Standard\",\"pricing_plan_id\":\"billable:v4:cloudant-standard::1552694400000:\",\"billable\":true,\"cost\":75,\"rated_cost\":75,\"usage\":[{\"metric\":\"GB_STORAGE_ACCRUED_PER_MONTH\",\"unit\":\"GIGABYTE_MONTHS\",\"quantity\":10,\"rateable_quantity\":10,\"cost\":10,\"rated_cost\":10,\"price\":[{\"anyKey\":\"anyValue\"}]}]}]}]}],\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"reports\":[{\"entity_id\":\"<distributor_enterprise_id>\",\"entity_type\":\"enterprise\",\"entity_crn\":\"crn:v1:bluemix:public:enterprise::a/fa359b76ff2c41eda727aad47b7e4063::enterprise:33a7eb04e7d547cd9489e90c99d476a5\",\"entity_name\":\"Company\",\"entity_partner_type\":\"DISTRIBUTOR\",\"viewpoint\":\"DISTRIBUTOR\",\"month\":\"2024-01\",\"currency_code\":\"EUR\",\"country_code\":\"FRA\",\"billable_cost\":2331828.33275813,\"billable_rated_cost\":3817593.35186263,\"non_billable_cost\":0,\"non_billable_rated_cost\":0,\"resources\":[{\"resource_id\":\"cloudant\",\"resource_name\":\"Cloudant\",\"billable_cost\":75,\"billable_rated_cost\":75,\"non_billable_cost\":0,\"non_billable_rated_cost\":0,\"plans\":[{\"plan_id\":\"cloudant-standard\",\"pricing_region\":\"Standard\",\"pricing_plan_id\":\"billable:v4:cloudant-standard::1552694400000:\",\"billable\":true,\"cost\":75,\"rated_cost\":75,\"usage\":[{\"metric\":\"GB_STORAGE_ACCRUED_PER_MONTH\",\"unit\":\"GIGABYTE_MONTHS\",\"quantity\":10,\"rateable_quantity\":10,\"cost\":10,\"rated_cost\":10,\"price\":[{\"anyKey\":\"anyValue\"}]}]}]}]}],\"total_count\":2,\"limit\":1}";
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
    GetResourceUsageReportPager pager = new GetResourceUsageReportPager(partnerManagementService, getResourceUsageReportOptions);
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
    String mockResponsePage1 = "{\"next\":{\"offset\":\"1\"},\"reports\":[{\"entity_id\":\"<distributor_enterprise_id>\",\"entity_type\":\"enterprise\",\"entity_crn\":\"crn:v1:bluemix:public:enterprise::a/fa359b76ff2c41eda727aad47b7e4063::enterprise:33a7eb04e7d547cd9489e90c99d476a5\",\"entity_name\":\"Company\",\"entity_partner_type\":\"DISTRIBUTOR\",\"viewpoint\":\"DISTRIBUTOR\",\"month\":\"2024-01\",\"currency_code\":\"EUR\",\"country_code\":\"FRA\",\"billable_cost\":2331828.33275813,\"billable_rated_cost\":3817593.35186263,\"non_billable_cost\":0,\"non_billable_rated_cost\":0,\"resources\":[{\"resource_id\":\"cloudant\",\"resource_name\":\"Cloudant\",\"billable_cost\":75,\"billable_rated_cost\":75,\"non_billable_cost\":0,\"non_billable_rated_cost\":0,\"plans\":[{\"plan_id\":\"cloudant-standard\",\"pricing_region\":\"Standard\",\"pricing_plan_id\":\"billable:v4:cloudant-standard::1552694400000:\",\"billable\":true,\"cost\":75,\"rated_cost\":75,\"usage\":[{\"metric\":\"GB_STORAGE_ACCRUED_PER_MONTH\",\"unit\":\"GIGABYTE_MONTHS\",\"quantity\":10,\"rateable_quantity\":10,\"cost\":10,\"rated_cost\":10,\"price\":[{\"anyKey\":\"anyValue\"}]}]}]}]}],\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"reports\":[{\"entity_id\":\"<distributor_enterprise_id>\",\"entity_type\":\"enterprise\",\"entity_crn\":\"crn:v1:bluemix:public:enterprise::a/fa359b76ff2c41eda727aad47b7e4063::enterprise:33a7eb04e7d547cd9489e90c99d476a5\",\"entity_name\":\"Company\",\"entity_partner_type\":\"DISTRIBUTOR\",\"viewpoint\":\"DISTRIBUTOR\",\"month\":\"2024-01\",\"currency_code\":\"EUR\",\"country_code\":\"FRA\",\"billable_cost\":2331828.33275813,\"billable_rated_cost\":3817593.35186263,\"non_billable_cost\":0,\"non_billable_rated_cost\":0,\"resources\":[{\"resource_id\":\"cloudant\",\"resource_name\":\"Cloudant\",\"billable_cost\":75,\"billable_rated_cost\":75,\"non_billable_cost\":0,\"non_billable_rated_cost\":0,\"plans\":[{\"plan_id\":\"cloudant-standard\",\"pricing_region\":\"Standard\",\"pricing_plan_id\":\"billable:v4:cloudant-standard::1552694400000:\",\"billable\":true,\"cost\":75,\"rated_cost\":75,\"usage\":[{\"metric\":\"GB_STORAGE_ACCRUED_PER_MONTH\",\"unit\":\"GIGABYTE_MONTHS\",\"quantity\":10,\"rateable_quantity\":10,\"cost\":10,\"rated_cost\":10,\"price\":[{\"anyKey\":\"anyValue\"}]}]}]}]}],\"total_count\":2,\"limit\":1}";
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

    GetResourceUsageReportPager pager = new GetResourceUsageReportPager(partnerManagementService, getResourceUsageReportOptions);
    List<PartnerUsageReport> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the getBillingOptions operation with a valid options model parameter
  @Test
  public void testGetBillingOptionsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"rows_count\": 9, \"next_url\": \"nextUrl\", \"resources\": [{\"id\": \"CFL_JJKLVZ2I0JE-_MGU\", \"billing_unit_id\": \"e19fa97c9bb34963a31a2008044d8b59\", \"customer_id\": \"<ford_account_id>\", \"customer_type\": \"ACCOUNT\", \"customer_name\": \"Ford\", \"reseller_id\": \"<techdata_enterprise_id>\", \"reseller_name\": \"TechData\", \"month\": \"2024-01\", \"errors\": [{\"anyKey\": \"anyValue\"}], \"type\": \"SUBSCRIPTION\", \"start_date\": \"2019-05-01T00:00:00.000Z\", \"end_date\": \"2020-05-01T00:00:00.000Z\", \"state\": \"ACTIVE\", \"category\": \"PLATFORM\", \"payment_instrument\": {\"anyKey\": \"anyValue\"}, \"part_number\": \"<PART_NUMBER_1>\", \"catalog_id\": \"ibmcloud-platform-payg-commit\", \"order_id\": \"23wzpnpmh8\", \"po_number\": \"<PO_NUMBER_1>\", \"subscription_model\": \"4.0\", \"duration_in_months\": 11, \"monthly_amount\": 8333.333333333334, \"billing_system\": {\"anyKey\": \"anyValue\"}, \"country_code\": \"USA\", \"currency_code\": \"USD\"}]}";
    String getBillingOptionsPath = "/v1/billing-options";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetBillingOptionsOptions model
    GetBillingOptionsOptions getBillingOptionsOptionsModel = new GetBillingOptionsOptions.Builder()
      .partnerId("testString")
      .customerId("testString")
      .resellerId("testString")
      .date("2024-01")
      .limit(Long.valueOf("200"))
      .build();

    // Invoke getBillingOptions() with a valid options model and verify the result
    Response<BillingOptionsSummary> response = partnerManagementService.getBillingOptions(getBillingOptionsOptionsModel).execute();
    assertNotNull(response);
    BillingOptionsSummary responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getBillingOptionsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("partner_id"), "testString");
    assertEquals(query.get("customer_id"), "testString");
    assertEquals(query.get("reseller_id"), "testString");
    assertEquals(query.get("date"), "2024-01");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("200"));
  }

  // Test the getBillingOptions operation with and without retries enabled
  @Test
  public void testGetBillingOptionsWRetries() throws Throwable {
    partnerManagementService.enableRetries(4, 30);
    testGetBillingOptionsWOptions();

    partnerManagementService.disableRetries();
    testGetBillingOptionsWOptions();
  }

  // Test the getBillingOptions operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetBillingOptionsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    partnerManagementService.getBillingOptions(null).execute();
  }

  // Test the getCreditPoolsReport operation with a valid options model parameter
  @Test
  public void testGetCreditPoolsReportWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"rows_count\": 9, \"next_url\": \"nextUrl\", \"resources\": [{\"type\": \"PLATFORM\", \"billing_unit_id\": \"e19fa97c9bb34963a31a2008044d8b59\", \"customer_id\": \"<ford_account_id>\", \"customer_type\": \"ACCOUNT\", \"customer_name\": \"Ford\", \"reseller_id\": \"<techdata_enterprise_id>\", \"reseller_name\": \"TechData\", \"month\": \"2024-01\", \"currency_code\": \"USD\", \"term_credits\": [{\"billing_option_id\": \"JWX986YRGFSHACQUEFOI\", \"billing_option_model\": \"4.0\", \"category\": \"PLATFORM\", \"start_date\": \"2019-07-01T00:00:00.000Z\", \"end_date\": \"2019-08-31T23:59:59.999Z\", \"total_credits\": 100000, \"starting_balance\": 100000, \"used_credits\": 0, \"current_balance\": 100000, \"resources\": [{\"anyKey\": \"anyValue\"}]}], \"overage\": {\"cost\": 500, \"resources\": [{\"anyKey\": \"anyValue\"}]}}]}";
    String getCreditPoolsReportPath = "/v1/credit-pools";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetCreditPoolsReportOptions model
    GetCreditPoolsReportOptions getCreditPoolsReportOptionsModel = new GetCreditPoolsReportOptions.Builder()
      .partnerId("testString")
      .customerId("testString")
      .resellerId("testString")
      .date("2024-01")
      .limit(Long.valueOf("30"))
      .build();

    // Invoke getCreditPoolsReport() with a valid options model and verify the result
    Response<CreditPoolsReportSummary> response = partnerManagementService.getCreditPoolsReport(getCreditPoolsReportOptionsModel).execute();
    assertNotNull(response);
    CreditPoolsReportSummary responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCreditPoolsReportPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("partner_id"), "testString");
    assertEquals(query.get("customer_id"), "testString");
    assertEquals(query.get("reseller_id"), "testString");
    assertEquals(query.get("date"), "2024-01");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("30"));
  }

  // Test the getCreditPoolsReport operation with and without retries enabled
  @Test
  public void testGetCreditPoolsReportWRetries() throws Throwable {
    partnerManagementService.enableRetries(4, 30);
    testGetCreditPoolsReportWOptions();

    partnerManagementService.disableRetries();
    testGetCreditPoolsReportWOptions();
  }

  // Test the getCreditPoolsReport operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCreditPoolsReportNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    partnerManagementService.getCreditPoolsReport(null).execute();
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
    partnerManagementService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    System.setProperty("TESTSERVICE_AUTH_TYPE", "noAuth");
    final String serviceName = "testService";

    partnerManagementService = PartnerManagement.newInstance(serviceName);
    String url = server.url("/").toString();
    partnerManagementService.setServiceUrl(url);
  }
}