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
package com.ibm.cloud.platform_services.partner_billing_units.v1;

import com.ibm.cloud.platform_services.partner_billing_units.v1.model.BillingOptionsSummary;
import com.ibm.cloud.platform_services.partner_billing_units.v1.model.CreditPoolsReportSummary;
import com.ibm.cloud.platform_services.partner_billing_units.v1.model.GetBillingOptionsOptions;
import com.ibm.cloud.platform_services.partner_billing_units.v1.model.GetCreditPoolsReportOptions;
import com.ibm.cloud.platform_services.partner_billing_units.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.IOException;
import java.io.InputStream;
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
 * Unit test class for the PartnerBillingUnits service.
 */
public class PartnerBillingUnitsTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected PartnerBillingUnits partnerBillingUnitsService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new PartnerBillingUnits(serviceName, null);
  }

  // Test the getBillingOptions operation with a valid options model parameter
  @Test
  public void testGetBillingOptionsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"limit\": 5, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"offset\": \"offset\"}, \"resources\": [{\"id\": \"CFL_JJKLVZ2I0JE-_MGU\", \"billing_unit_id\": \"e19fa97c9bb34963a31a2008044d8b59\", \"customer_id\": \"<ford_account_id>\", \"customer_type\": \"ACCOUNT\", \"customer_name\": \"Ford\", \"reseller_id\": \"<techdata_enterprise_id>\", \"reseller_name\": \"TechData\", \"month\": \"2022-04\", \"errors\": [{\"anyKey\": \"anyValue\"}], \"type\": \"SUBSCRIPTION\", \"start_date\": \"2019-05-01T00:00:00.000Z\", \"end_date\": \"2020-05-01T00:00:00.000Z\", \"state\": \"ACTIVE\", \"category\": \"PLATFORM\", \"payment_instrument\": {\"anyKey\": \"anyValue\"}, \"part_number\": \"<PART_NUMBER_1>\", \"catalog_id\": \"ibmcloud-platform-payg-commit\", \"order_id\": \"23wzpnpmh8\", \"po_number\": \"<PO_NUMBER_1>\", \"subscription_model\": \"4.0\", \"duration_in_months\": 11, \"monthly_amount\": 8333.333333333334, \"billing_system\": {\"anyKey\": \"anyValue\"}, \"country_code\": \"USA\", \"currency_code\": \"USD\"}]}";
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
      .date("2022-04")
      .limit(Long.valueOf("30"))
      .build();

    // Invoke getBillingOptions() with a valid options model and verify the result
    Response<BillingOptionsSummary> response = partnerBillingUnitsService.getBillingOptions(getBillingOptionsOptionsModel).execute();
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
    assertEquals(query.get("date"), "2022-04");
    assertEquals(Long.valueOf(query.get("_limit")), Long.valueOf("30"));
  }

  // Test the getBillingOptions operation with and without retries enabled
  @Test
  public void testGetBillingOptionsWRetries() throws Throwable {
    partnerBillingUnitsService.enableRetries(4, 30);
    testGetBillingOptionsWOptions();

    partnerBillingUnitsService.disableRetries();
    testGetBillingOptionsWOptions();
  }

  // Test the getBillingOptions operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetBillingOptionsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    partnerBillingUnitsService.getBillingOptions(null).execute();
  }

  // Test the getCreditPoolsReport operation with a valid options model parameter
  @Test
  public void testGetCreditPoolsReportWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"limit\": 5, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\", \"offset\": \"offset\"}, \"resources\": [{\"type\": \"PLATFORM\", \"billing_unit_id\": \"e19fa97c9bb34963a31a2008044d8b59\", \"customer_id\": \"<ford_account_id>\", \"customer_type\": \"ACCOUNT\", \"customer_name\": \"Ford\", \"reseller_id\": \"<techdata_enterprise_id>\", \"reseller_name\": \"TechData\", \"month\": \"2022-04\", \"currency_code\": \"USD\", \"term_credits\": [{\"billing_option_id\": \"JWX986YRGFSHACQUEFOI\", \"billing_option_model\": \"4.0\", \"category\": \"PLATFORM\", \"start_date\": \"2019-07-01T00:00:00.000Z\", \"end_date\": \"2019-08-31T23:59:59.999Z\", \"total_credits\": 100000, \"starting_balance\": 100000, \"used_credits\": 0, \"current_balance\": 100000, \"resources\": [{\"anyKey\": \"anyValue\"}]}], \"overage\": {\"cost\": 500, \"resources\": [{\"anyKey\": \"anyValue\"}]}}]}";
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
      .date("2022-04")
      .limit(Long.valueOf("30"))
      .build();

    // Invoke getCreditPoolsReport() with a valid options model and verify the result
    Response<CreditPoolsReportSummary> response = partnerBillingUnitsService.getCreditPoolsReport(getCreditPoolsReportOptionsModel).execute();
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
    assertEquals(query.get("date"), "2022-04");
    assertEquals(Long.valueOf(query.get("_limit")), Long.valueOf("30"));
  }

  // Test the getCreditPoolsReport operation with and without retries enabled
  @Test
  public void testGetCreditPoolsReportWRetries() throws Throwable {
    partnerBillingUnitsService.enableRetries(4, 30);
    testGetCreditPoolsReportWOptions();

    partnerBillingUnitsService.disableRetries();
    testGetCreditPoolsReportWOptions();
  }

  // Test the getCreditPoolsReport operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCreditPoolsReportNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    partnerBillingUnitsService.getCreditPoolsReport(null).execute();
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
    partnerBillingUnitsService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    System.setProperty("TESTSERVICE_AUTH_TYPE", "noAuth");
    final String serviceName = "testService";

    partnerBillingUnitsService = PartnerBillingUnits.newInstance(serviceName);
    String url = server.url("/").toString();
    partnerBillingUnitsService.setServiceUrl(url);
  }
}