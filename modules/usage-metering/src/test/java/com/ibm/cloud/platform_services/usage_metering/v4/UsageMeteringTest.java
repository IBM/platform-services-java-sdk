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
package com.ibm.cloud.platform_services.usage_metering.v4;

import com.ibm.cloud.platform_services.usage_metering.v4.UsageMetering;
import com.ibm.cloud.platform_services.usage_metering.v4.model.MeasureAndQuantity;
import com.ibm.cloud.platform_services.usage_metering.v4.model.ReportResourceUsageOptions;
import com.ibm.cloud.platform_services.usage_metering.v4.model.ResourceInstanceUsage;
import com.ibm.cloud.platform_services.usage_metering.v4.model.ResourceUsageDetails;
import com.ibm.cloud.platform_services.usage_metering.v4.model.ResponseAccepted;
import com.ibm.cloud.platform_services.usage_metering.v4.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
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
 * Unit test class for the UsageMetering service.
 */
public class UsageMeteringTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected UsageMetering usageMeteringService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new UsageMetering(serviceName, null);
  }

  // Test the reportResourceUsage operation with a valid options model parameter
  @Test
  public void testReportResourceUsageWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"resources\": [{\"status\": 6, \"location\": \"location\", \"code\": \"code\", \"message\": \"message\"}]}";
    String reportResourceUsagePath = "/v4/metering/resources/93d21e40-aafd-451c-a393-5273d09d056a/usage";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(202)
      .setBody(mockResponseBody));

    // Construct an instance of the MeasureAndQuantity model
    MeasureAndQuantity measureAndQuantityModel = new MeasureAndQuantity.Builder()
      .measure("STORAGE")
      .quantity("1")
      .build();

    // Construct an instance of the ResourceInstanceUsage model
    ResourceInstanceUsage resourceInstanceUsageModel = new ResourceInstanceUsage.Builder()
      .resourceInstanceId("crn:v1:bluemix:staging:database-service:us-south:a/1c8ae972c35e470d994b6faff9494ce1:793ff3d3-9fe3-4329-9ea0-404703a3c371::")
      .planId("da40662d-2f72-4a19-8c79-8c77cf285e17")
      .region("us-south")
      .start(Long.valueOf("1485907200000"))
      .end(Long.valueOf("1485907200000"))
      .measuredUsage(java.util.Arrays.asList(measureAndQuantityModel))
      .consumerId("cf-application:ed20abbe-8870-44e6-90f7-56d764c21127")
      .build();

    // Construct an instance of the ReportResourceUsageOptions model
    ReportResourceUsageOptions reportResourceUsageOptionsModel = new ReportResourceUsageOptions.Builder()
      .resourceId("93d21e40-aafd-451c-a393-5273d09d056a")
      .resourceUsage(java.util.Arrays.asList(resourceInstanceUsageModel))
      .build();

    // Invoke reportResourceUsage() with a valid options model and verify the result
    Response<ResponseAccepted> response = usageMeteringService.reportResourceUsage(reportResourceUsageOptionsModel).execute();
    assertNotNull(response);
    ResponseAccepted responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, reportResourceUsagePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the reportResourceUsage operation with and without retries enabled
  @Test
  public void testReportResourceUsageWRetries() throws Throwable {
    usageMeteringService.enableRetries(4, 30);
    testReportResourceUsageWOptions();

    usageMeteringService.disableRetries();
    testReportResourceUsageWOptions();
  }

  // Test the reportResourceUsage operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReportResourceUsageNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    usageMeteringService.reportResourceUsage(null).execute();
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
    usageMeteringService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    System.setProperty("TESTSERVICE_AUTH_TYPE", "noAuth");
    final String serviceName = "testService";

    usageMeteringService = UsageMetering.newInstance(serviceName);
    String url = server.url("/").toString();
    usageMeteringService.setServiceUrl(url);
  }
}