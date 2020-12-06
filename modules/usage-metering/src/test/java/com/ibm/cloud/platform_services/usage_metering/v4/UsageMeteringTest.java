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
 * Unit test class for the UsageMetering service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore({"javax.net.ssl.*", "org.mockito.*"})
public class UsageMeteringTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected UsageMetering usageMeteringService;

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

    usageMeteringService = UsageMetering.newInstance(serviceName);
    String url = server.url("/").toString();
    usageMeteringService.setServiceUrl(url);
  }

  /**
  * Negative Test - construct the service with a null authenticator.
  */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";

    new UsageMetering(serviceName, null);
  }

  @Test
  public void testReportResourceUsageWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"resources\": [{\"status\": 6, \"location\": \"location\", \"code\": \"code\", \"message\": \"message\"}]}";
    String reportResourceUsagePath = "/v4/metering/resources/testString/usage";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(202)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the MeasureAndQuantity model
    MeasureAndQuantity measureAndQuantityModel = new MeasureAndQuantity.Builder()
    .measure("STORAGE")
    .quantity("1")
    .build();

    // Construct an instance of the ResourceInstanceUsage model
    ResourceInstanceUsage resourceInstanceUsageModel = new ResourceInstanceUsage.Builder()
    .resourceInstanceId("crn:v1:bluemix:staging:database-service:us-south:a/1c8ae972c35e470d994b6faff9494ce1:793ff3d3-9fe3-4329-9ea0-404703a3c371::")
    .planId("database-lite")
    .region("us-south")
    .start(Long.valueOf("1485907200000"))
    .end(Long.valueOf("1485907200000"))
    .measuredUsage(new java.util.ArrayList<MeasureAndQuantity>(java.util.Arrays.asList(measureAndQuantityModel)))
    .consumerId("cf-application:ed20abbe-8870-44e6-90f7-56d764c21127")
    .build();

    // Construct an instance of the ReportResourceUsageOptions model
    ReportResourceUsageOptions reportResourceUsageOptionsModel = new ReportResourceUsageOptions.Builder()
    .resourceId("testString")
    .resourceUsage(new java.util.ArrayList<ResourceInstanceUsage>(java.util.Arrays.asList(resourceInstanceUsageModel)))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResponseAccepted> response = usageMeteringService.reportResourceUsage(reportResourceUsageOptionsModel).execute();
    assertNotNull(response);
    ResponseAccepted responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, reportResourceUsagePath);
  }

  // Test the reportResourceUsage operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReportResourceUsageNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    usageMeteringService.reportResourceUsage(null).execute();
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
    usageMeteringService = null;
  }
}