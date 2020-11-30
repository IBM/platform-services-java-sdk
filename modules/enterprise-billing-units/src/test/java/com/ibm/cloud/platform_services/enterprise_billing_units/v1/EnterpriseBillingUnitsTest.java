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
package com.ibm.cloud.platform_services.enterprise_billing_units.v1;

import com.ibm.cloud.platform_services.enterprise_billing_units.v1.EnterpriseBillingUnits;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.BillingOption;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.BillingOptionsList;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.BillingUnit;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.BillingUnitsList;
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
import com.ibm.cloud.sdk.core.util.EnvironmentUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the EnterpriseBillingUnits service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore({"javax.net.ssl.*", "org.mockito.*"})
public class EnterpriseBillingUnitsTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected EnterpriseBillingUnits enterpriseBillingUnitsService;

  // Creates a mock set of environment variables that are returned by EnvironmentUtils.getenv().
  private Map<String, String> getTestProcessEnvironment() {
    Map<String, String> env = new HashMap<>();
    env.put("TESTSERVICE_AUTH_TYPE", "noAuth");
    return env;
  }

  public void constructClientService() throws Throwable {
    PowerMockito.spy(EnvironmentUtils.class);
    PowerMockito.when(EnvironmentUtils.getenv()).thenReturn(getTestProcessEnvironment());
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

  @Test
  public void testGetBillingUnitWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"crn\": \"crn:v1:bluemix:public:billing::a/<<enterprise_account_id>>::billing-unit:<<billing_unit_id>>\", \"name\": \"name\", \"enterprise_id\": \"enterpriseId\", \"currency_code\": \"USD\", \"country_code\": \"USA\", \"master\": true, \"created_at\": \"2019-01-01T12:00:00\"}";
    String getBillingUnitPath = "/v1/billing-units/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetBillingUnitOptions model
    GetBillingUnitOptions getBillingUnitOptionsModel = new GetBillingUnitOptions.Builder()
    .billingUnitId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<BillingUnit> response = enterpriseBillingUnitsService.getBillingUnit(getBillingUnitOptionsModel).execute();
    assertNotNull(response);
    BillingUnit responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getBillingUnitPath);
  }

  // Test the getBillingUnit operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetBillingUnitNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    enterpriseBillingUnitsService.getBillingUnit(null).execute();
  }

  @Test
  public void testListBillingUnitsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"rows_count\": 9, \"next_url\": \"nextUrl\", \"resources\": [{\"id\": \"id\", \"crn\": \"crn:v1:bluemix:public:billing::a/<<enterprise_account_id>>::billing-unit:<<billing_unit_id>>\", \"name\": \"name\", \"enterprise_id\": \"enterpriseId\", \"currency_code\": \"USD\", \"country_code\": \"USA\", \"master\": true, \"created_at\": \"2019-01-01T12:00:00\"}]}";
    String listBillingUnitsPath = "/v1/billing-units";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListBillingUnitsOptions model
    ListBillingUnitsOptions listBillingUnitsOptionsModel = new ListBillingUnitsOptions.Builder()
    .accountId("testString")
    .enterpriseId("testString")
    .accountGroupId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<BillingUnitsList> response = enterpriseBillingUnitsService.listBillingUnits(listBillingUnitsOptionsModel).execute();
    assertNotNull(response);
    BillingUnitsList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("enterprise_id"), "testString");
    assertEquals(query.get("account_group_id"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listBillingUnitsPath);
  }

  @Test
  public void testListBillingOptionsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"rows_count\": 9, \"next_url\": \"nextUrl\", \"resources\": [{\"id\": \"id\", \"billing_unit_id\": \"billingUnitId\", \"start_date\": \"2019-01-01T12:00:00\", \"end_date\": \"2019-01-01T12:00:00\", \"state\": \"ACTIVE\", \"type\": \"SUBSCRIPTION\", \"category\": \"PLATFORM\", \"payment_instrument\": {\"mapKey\": \"anyValue\"}, \"duration_in_months\": 11, \"line_item_id\": 10, \"billing_system\": {\"mapKey\": \"anyValue\"}, \"renewal_mode_code\": \"renewalModeCode\", \"updated_at\": \"2019-01-01T12:00:00\"}]}";
    String listBillingOptionsPath = "/v1/billing-options";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListBillingOptionsOptions model
    ListBillingOptionsOptions listBillingOptionsOptionsModel = new ListBillingOptionsOptions.Builder()
    .billingUnitId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<BillingOptionsList> response = enterpriseBillingUnitsService.listBillingOptions(listBillingOptionsOptionsModel).execute();
    assertNotNull(response);
    BillingOptionsList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("billing_unit_id"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listBillingOptionsPath);
  }

  // Test the listBillingOptions operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListBillingOptionsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    enterpriseBillingUnitsService.listBillingOptions(null).execute();
  }

  @Test
  public void testGetCreditPoolsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"rows_count\": 2, \"next_url\": \"nextUrl\", \"resources\": [{\"type\": \"PLATFORM\", \"currency_code\": \"USD\", \"billing_unit_id\": \"billingUnitId\", \"term_credits\": [{\"billing_option_id\": \"JWX986YRGFSHACQUEFOI\", \"category\": \"PLATFORM\", \"start_date\": \"2019-01-01T12:00:00\", \"end_date\": \"2019-01-01T12:00:00\", \"total_credits\": 10000, \"starting_balance\": 9000, \"used_credits\": 9500, \"current_balance\": 0, \"resources\": [{\"mapKey\": \"anyValue\"}]}], \"overage\": {\"cost\": 500, \"resources\": [{\"mapKey\": \"anyValue\"}]}}]}";
    String getCreditPoolsPath = "/v1/credit-pools";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetCreditPoolsOptions model
    GetCreditPoolsOptions getCreditPoolsOptionsModel = new GetCreditPoolsOptions.Builder()
    .billingUnitId("testString")
    .date("testString")
    .type("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<CreditPoolsList> response = enterpriseBillingUnitsService.getCreditPools(getCreditPoolsOptionsModel).execute();
    assertNotNull(response);
    CreditPoolsList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("billing_unit_id"), "testString");
    assertEquals(query.get("date"), "testString");
    assertEquals(query.get("type"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCreditPoolsPath);
  }

  // Test the getCreditPools operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCreditPoolsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    enterpriseBillingUnitsService.getCreditPools(null).execute();
  }

  /** Initialize the server */
  @BeforeMethod
  public void setUpMockServer() {
    try {
        server = new MockWebServer();
        // register handler
        server.start();
        }
    catch (IOException err) {
        fail("Failed to instantiate mock web server");
    }
  }

  @AfterMethod
  public void tearDownMockServer() throws IOException {
    server.shutdown();
    enterpriseBillingUnitsService = null;
  }
}