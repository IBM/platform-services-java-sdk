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
package com.ibm.cloud.platform_services.enterprise_billing_units.v1;

import com.ibm.cloud.platform_services.enterprise_billing_units.v1.EnterpriseBillingUnits;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.BillingOption;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.BillingOptionsList;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.BillingOptionsPager;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.BillingUnit;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.BillingUnitsList;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.BillingUnitsPager;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.CreditPool;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.CreditPoolOverage;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.CreditPoolsList;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.GetBillingUnitOptions;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.GetCreditPoolsOptions;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.ListBillingOptionsOptions;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.ListBillingUnitsOptions;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.TermCredits;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.utils.TestUtilities;
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
 * Unit test class for the EnterpriseBillingUnits service.
 */
public class EnterpriseBillingUnitsTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected EnterpriseBillingUnits enterpriseBillingUnitsService;

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    System.setProperty("TESTSERVICE_AUTH_TYPE", "noAuth");
    final String serviceName = "testService";

    enterpriseBillingUnitsService = EnterpriseBillingUnits.newInstance(serviceName);
    String url = server.url("/").toString();
    enterpriseBillingUnitsService.setServiceUrl(url);
  }

  /**
   * Negative Test - construct the service with a null authenticator.
   */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new EnterpriseBillingUnits(serviceName, null);
  }

  // Test the getBillingUnit operation with a valid options model parameter
  @Test
  public void testGetBillingUnitWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"crn\": \"crn:v1:bluemix:public:billing::a/<<enterprise_account_id>>::billing-unit:<<billing_unit_id>>\", \"name\": \"name\", \"enterprise_id\": \"enterpriseId\", \"currency_code\": \"USD\", \"country_code\": \"USA\", \"master\": true, \"created_at\": \"2019-01-01T12:00:00\"}";
    String getBillingUnitPath = "/v1/billing-units/testString";
    server.enqueue(new MockResponse()
        .setHeader("Content-type", "application/json")
        .setResponseCode(200)
        .setBody(mockResponseBody));

    // Construct an instance of the GetBillingUnitOptions model
    GetBillingUnitOptions getBillingUnitOptionsModel = new GetBillingUnitOptions.Builder()
        .billingUnitId("testString")
        .build();

    // Invoke getBillingUnit() with a valid options model and verify the result
    Response<BillingUnit> response = enterpriseBillingUnitsService.getBillingUnit(getBillingUnitOptionsModel).execute();
    assertNotNull(response);
    BillingUnit responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getBillingUnitPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getBillingUnit operation with and without retries enabled
  @Test
  public void testGetBillingUnitWRetries() throws Throwable {
    enterpriseBillingUnitsService.enableRetries(4, 30);
    testGetBillingUnitWOptions();

    enterpriseBillingUnitsService.disableRetries();
    testGetBillingUnitWOptions();
  }

  // Test the getBillingUnit operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetBillingUnitNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    enterpriseBillingUnitsService.getBillingUnit(null).execute();
  }

  // Test the listBillingUnits operation with a valid options model parameter
  @Test
  public void testListBillingUnitsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"rows_count\": 9, \"next_url\": \"nextUrl\", \"resources\": [{\"id\": \"id\", \"crn\": \"crn:v1:bluemix:public:billing::a/<<enterprise_account_id>>::billing-unit:<<billing_unit_id>>\", \"name\": \"name\", \"enterprise_id\": \"enterpriseId\", \"currency_code\": \"USD\", \"country_code\": \"USA\", \"master\": true, \"created_at\": \"2019-01-01T12:00:00\"}]}";
    String listBillingUnitsPath = "/v1/billing-units";
    server.enqueue(new MockResponse()
        .setHeader("Content-type", "application/json")
        .setResponseCode(200)
        .setBody(mockResponseBody));

    // Construct an instance of the ListBillingUnitsOptions model
    ListBillingUnitsOptions listBillingUnitsOptionsModel = new ListBillingUnitsOptions.Builder()
        .accountId("testString")
        .enterpriseId("testString")
        .accountGroupId("testString")
        .limit(Long.valueOf("10"))
        .start("testString")
        .build();

    // Invoke listBillingUnits() with a valid options model and verify the result
    Response<BillingUnitsList> response = enterpriseBillingUnitsService.listBillingUnits(listBillingUnitsOptionsModel)
        .execute();
    assertNotNull(response);
    BillingUnitsList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listBillingUnitsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("enterprise_id"), "testString");
    assertEquals(query.get("account_group_id"), "testString");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(query.get("start"), "testString");
  }

  // Test the listBillingUnits operation with and without retries enabled
  @Test
  public void testListBillingUnitsWRetries() throws Throwable {
    enterpriseBillingUnitsService.enableRetries(4, 30);
    testListBillingUnitsWOptions();

    enterpriseBillingUnitsService.disableRetries();
    testListBillingUnitsWOptions();
  }

  // Test the listBillingUnits operation using the BillingUnitsPager.getNext()
  // method
  @Test
  public void testListBillingUnitsWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"total_count\":2,\"limit\":1,\"next_url\":\"https://myhost.com/somePath?start=1\",\"resources\":[{\"id\":\"id\",\"crn\":\"crn:v1:bluemix:public:billing::a/<<enterprise_account_id>>::billing-unit:<<billing_unit_id>>\",\"name\":\"name\",\"enterprise_id\":\"enterpriseId\",\"currency_code\":\"USD\",\"country_code\":\"USA\",\"master\":true,\"created_at\":\"2019-05-01T00:00:00.000Z\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"id\":\"id\",\"crn\":\"crn:v1:bluemix:public:billing::a/<<enterprise_account_id>>::billing-unit:<<billing_unit_id>>\",\"name\":\"name\",\"enterprise_id\":\"enterpriseId\",\"currency_code\":\"USD\",\"country_code\":\"USA\",\"master\":true,\"created_at\":\"2019-05-01T00:00:00.000Z\"}]}";
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

    ListBillingUnitsOptions listBillingUnitsOptions = new ListBillingUnitsOptions.Builder()
        .accountId("testString")
        .enterpriseId("testString")
        .accountGroupId("testString")
        .limit(Long.valueOf("10"))
        .build();

    List<BillingUnit> allResults = new ArrayList<>();
    BillingUnitsPager pager = new BillingUnitsPager(enterpriseBillingUnitsService, listBillingUnitsOptions);
    while (pager.hasNext()) {
      List<BillingUnit> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }

  // Test the listBillingUnits operation using the BillingUnitsPager.getAll()
  // method
  @Test
  public void testListBillingUnitsWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"total_count\":2,\"limit\":1,\"next_url\":\"https://myhost.com/somePath?start=1\",\"resources\":[{\"id\":\"id\",\"crn\":\"crn:v1:bluemix:public:billing::a/<<enterprise_account_id>>::billing-unit:<<billing_unit_id>>\",\"name\":\"name\",\"enterprise_id\":\"enterpriseId\",\"currency_code\":\"USD\",\"country_code\":\"USA\",\"master\":true,\"created_at\":\"2019-05-01T00:00:00.000Z\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"id\":\"id\",\"crn\":\"crn:v1:bluemix:public:billing::a/<<enterprise_account_id>>::billing-unit:<<billing_unit_id>>\",\"name\":\"name\",\"enterprise_id\":\"enterpriseId\",\"currency_code\":\"USD\",\"country_code\":\"USA\",\"master\":true,\"created_at\":\"2019-05-01T00:00:00.000Z\"}]}";
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

    ListBillingUnitsOptions listBillingUnitsOptions = new ListBillingUnitsOptions.Builder()
        .accountId("testString")
        .enterpriseId("testString")
        .accountGroupId("testString")
        .limit(Long.valueOf("10"))
        .build();

    BillingUnitsPager pager = new BillingUnitsPager(enterpriseBillingUnitsService, listBillingUnitsOptions);
    List<BillingUnit> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }

  // Test the listBillingOptions operation with a valid options model parameter
  @Test
  public void testListBillingOptionsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"rows_count\": 9, \"next_url\": \"nextUrl\", \"resources\": [{\"id\": \"id\", \"billing_unit_id\": \"billingUnitId\", \"start_date\": \"2019-01-01T12:00:00\", \"end_date\": \"2019-01-01T12:00:00\", \"state\": \"ACTIVE\", \"type\": \"SUBSCRIPTION\", \"category\": \"PLATFORM\", \"payment_instrument\": {\"mapKey\": \"anyValue\"}, \"duration_in_months\": 11, \"line_item_id\": 10, \"billing_system\": {\"mapKey\": \"anyValue\"}, \"renewal_mode_code\": \"renewalModeCode\", \"updated_at\": \"2019-01-01T12:00:00\"}]}";
    String listBillingOptionsPath = "/v1/billing-options";
    server.enqueue(new MockResponse()
        .setHeader("Content-type", "application/json")
        .setResponseCode(200)
        .setBody(mockResponseBody));

    // Construct an instance of the ListBillingOptionsOptions model
    ListBillingOptionsOptions listBillingOptionsOptionsModel = new ListBillingOptionsOptions.Builder()
        .billingUnitId("testString")
        .limit(Long.valueOf("10"))
        .start("testString")
        .build();

    // Invoke listBillingOptions() with a valid options model and verify the result
    Response<BillingOptionsList> response = enterpriseBillingUnitsService
        .listBillingOptions(listBillingOptionsOptionsModel).execute();
    assertNotNull(response);
    BillingOptionsList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listBillingOptionsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("billing_unit_id"), "testString");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(query.get("start"), "testString");
  }

  // Test the listBillingOptions operation with and without retries enabled
  @Test
  public void testListBillingOptionsWRetries() throws Throwable {
    enterpriseBillingUnitsService.enableRetries(4, 30);
    testListBillingOptionsWOptions();

    enterpriseBillingUnitsService.disableRetries();
    testListBillingOptionsWOptions();
  }

  // Test the listBillingOptions operation with a null options model (negative
  // test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListBillingOptionsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    enterpriseBillingUnitsService.listBillingOptions(null).execute();
  }

  // Test the listBillingOptions operation using the BillingOptionsPager.getNext()
  // method
  @Test
  public void testListBillingOptionsWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"total_count\":2,\"limit\":1,\"next_url\":\"https://myhost.com/somePath?start=1\",\"resources\":[{\"id\":\"id\",\"billing_unit_id\":\"billingUnitId\",\"start_date\":\"2019-05-01T00:00:00.000Z\",\"end_date\":\"2020-05-01T00:00:00.000Z\",\"state\":\"ACTIVE\",\"type\":\"SUBSCRIPTION\",\"category\":\"PLATFORM\",\"payment_instrument\":{\"anyKey\":\"anyValue\"},\"duration_in_months\":11,\"line_item_id\":10,\"billing_system\":{\"anyKey\":\"anyValue\"},\"renewal_mode_code\":\"renewalModeCode\",\"updated_at\":\"2019-06-01T00:00:00.000Z\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"id\":\"id\",\"billing_unit_id\":\"billingUnitId\",\"start_date\":\"2019-05-01T00:00:00.000Z\",\"end_date\":\"2020-05-01T00:00:00.000Z\",\"state\":\"ACTIVE\",\"type\":\"SUBSCRIPTION\",\"category\":\"PLATFORM\",\"payment_instrument\":{\"anyKey\":\"anyValue\"},\"duration_in_months\":11,\"line_item_id\":10,\"billing_system\":{\"anyKey\":\"anyValue\"},\"renewal_mode_code\":\"renewalModeCode\",\"updated_at\":\"2019-06-01T00:00:00.000Z\"}]}";
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

    ListBillingOptionsOptions listBillingOptionsOptions = new ListBillingOptionsOptions.Builder()
        .billingUnitId("testString")
        .limit(Long.valueOf("10"))
        .build();

    List<BillingOption> allResults = new ArrayList<>();
    BillingOptionsPager pager = new BillingOptionsPager(enterpriseBillingUnitsService, listBillingOptionsOptions);
    while (pager.hasNext()) {
      List<BillingOption> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }

  // Test the listBillingOptions operation using the BillingOptionsPager.getAll()
  // method
  @Test
  public void testListBillingOptionsWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"total_count\":2,\"limit\":1,\"next_url\":\"https://myhost.com/somePath?start=1\",\"resources\":[{\"id\":\"id\",\"billing_unit_id\":\"billingUnitId\",\"start_date\":\"2019-05-01T00:00:00.000Z\",\"end_date\":\"2020-05-01T00:00:00.000Z\",\"state\":\"ACTIVE\",\"type\":\"SUBSCRIPTION\",\"category\":\"PLATFORM\",\"payment_instrument\":{\"anyKey\":\"anyValue\"},\"duration_in_months\":11,\"line_item_id\":10,\"billing_system\":{\"anyKey\":\"anyValue\"},\"renewal_mode_code\":\"renewalModeCode\",\"updated_at\":\"2019-06-01T00:00:00.000Z\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"id\":\"id\",\"billing_unit_id\":\"billingUnitId\",\"start_date\":\"2019-05-01T00:00:00.000Z\",\"end_date\":\"2020-05-01T00:00:00.000Z\",\"state\":\"ACTIVE\",\"type\":\"SUBSCRIPTION\",\"category\":\"PLATFORM\",\"payment_instrument\":{\"anyKey\":\"anyValue\"},\"duration_in_months\":11,\"line_item_id\":10,\"billing_system\":{\"anyKey\":\"anyValue\"},\"renewal_mode_code\":\"renewalModeCode\",\"updated_at\":\"2019-06-01T00:00:00.000Z\"}]}";
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

    ListBillingOptionsOptions listBillingOptionsOptions = new ListBillingOptionsOptions.Builder()
        .billingUnitId("testString")
        .limit(Long.valueOf("10"))
        .build();

    BillingOptionsPager pager = new BillingOptionsPager(enterpriseBillingUnitsService, listBillingOptionsOptions);
    List<BillingOption> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }

  // Test the getCreditPools operation with a valid options model parameter
  @Test
  public void testGetCreditPoolsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"rows_count\": 2, \"next_url\": \"nextUrl\", \"resources\": [{\"type\": \"PLATFORM\", \"currency_code\": \"USD\", \"billing_unit_id\": \"billingUnitId\", \"term_credits\": [{\"billing_option_id\": \"JWX986YRGFSHACQUEFOI\", \"category\": \"PLATFORM\", \"start_date\": \"2019-01-01T12:00:00\", \"end_date\": \"2019-01-01T12:00:00\", \"total_credits\": 10000, \"starting_balance\": 9000, \"used_credits\": 9500, \"current_balance\": 0, \"resources\": [{\"mapKey\": \"anyValue\"}]}], \"overage\": {\"cost\": 500, \"resources\": [{\"mapKey\": \"anyValue\"}]}}]}";
    String getCreditPoolsPath = "/v1/credit-pools";
    server.enqueue(new MockResponse()
        .setHeader("Content-type", "application/json")
        .setResponseCode(200)
        .setBody(mockResponseBody));

    // Construct an instance of the GetCreditPoolsOptions model
    GetCreditPoolsOptions getCreditPoolsOptionsModel = new GetCreditPoolsOptions.Builder()
        .billingUnitId("testString")
        .date("testString")
        .type("testString")
        .build();

    // Invoke getCreditPools() with a valid options model and verify the result
    Response<CreditPoolsList> response = enterpriseBillingUnitsService.getCreditPools(getCreditPoolsOptionsModel)
        .execute();
    assertNotNull(response);
    CreditPoolsList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCreditPoolsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("billing_unit_id"), "testString");
    assertEquals(query.get("date"), "testString");
    assertEquals(query.get("type"), "testString");
  }

  // Test the getCreditPools operation with and without retries enabled
  @Test
  public void testGetCreditPoolsWRetries() throws Throwable {
    enterpriseBillingUnitsService.enableRetries(4, 30);
    testGetCreditPoolsWOptions();

    enterpriseBillingUnitsService.disableRetries();
    testGetCreditPoolsWOptions();
  }

  // Test the getCreditPools operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCreditPoolsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    enterpriseBillingUnitsService.getCreditPools(null).execute();
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
    enterpriseBillingUnitsService = null;
  }
}
