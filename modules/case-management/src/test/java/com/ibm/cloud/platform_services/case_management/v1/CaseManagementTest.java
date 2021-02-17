/*
 * (C) Copyright IBM Corp. 2021.
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
package com.ibm.cloud.platform_services.case_management.v1;

import com.ibm.cloud.platform_services.case_management.v1.CaseManagement;
import com.ibm.cloud.platform_services.case_management.v1.model.AcceptPayload;
import com.ibm.cloud.platform_services.case_management.v1.model.AddCommentOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.AddResourceOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.AddWatchlistOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.Attachment;
import com.ibm.cloud.platform_services.case_management.v1.model.AttachmentList;
import com.ibm.cloud.platform_services.case_management.v1.model.Case;
import com.ibm.cloud.platform_services.case_management.v1.model.CaseEu;
import com.ibm.cloud.platform_services.case_management.v1.model.CaseList;
import com.ibm.cloud.platform_services.case_management.v1.model.CasePayloadEu;
import com.ibm.cloud.platform_services.case_management.v1.model.Comment;
import com.ibm.cloud.platform_services.case_management.v1.model.CreateCaseOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.DeleteFileOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.DownloadFileOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.GetCaseOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.GetCasesOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.Offering;
import com.ibm.cloud.platform_services.case_management.v1.model.OfferingType;
import com.ibm.cloud.platform_services.case_management.v1.model.PaginationLink;
import com.ibm.cloud.platform_services.case_management.v1.model.RemoveWatchlistOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.ResolvePayload;
import com.ibm.cloud.platform_services.case_management.v1.model.Resource;
import com.ibm.cloud.platform_services.case_management.v1.model.ResourcePayload;
import com.ibm.cloud.platform_services.case_management.v1.model.StatusPayload;
import com.ibm.cloud.platform_services.case_management.v1.model.UnresolvePayload;
import com.ibm.cloud.platform_services.case_management.v1.model.UpdateCaseStatusOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.UploadFileOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.User;
import com.ibm.cloud.platform_services.case_management.v1.model.Watchlist;
import com.ibm.cloud.platform_services.case_management.v1.model.WatchlistAddResponse;
import com.ibm.cloud.platform_services.case_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.EnvironmentUtils;
import com.ibm.cloud.sdk.core.util.RequestUtils;
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
 * Unit test class for the CaseManagement service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore({"javax.net.ssl.*", "org.mockito.*"})
public class CaseManagementTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected CaseManagement caseManagementService;

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

    caseManagementService = CaseManagement.newInstance(serviceName);
    String url = server.url("/").toString();
    caseManagementService.setServiceUrl(url);
  }

  /**
  * Negative Test - construct the service with a null authenticator.
  */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";

    new CaseManagement(serviceName, null);
  }

  @Test
  public void testGetCasesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"total_count\": 10, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\"}, \"previous\": {\"href\": \"href\"}, \"last\": {\"href\": \"href\"}, \"cases\": [{\"number\": \"number\", \"short_description\": \"shortDescription\", \"description\": \"description\", \"created_at\": \"createdAt\", \"created_by\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}, \"updated_at\": \"updatedAt\", \"updated_by\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}, \"contact_type\": \"Cloud Support Center\", \"contact\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}, \"status\": \"status\", \"severity\": 8, \"support_tier\": \"Free\", \"resolution\": \"resolution\", \"close_notes\": \"closeNotes\", \"eu\": {\"support\": false, \"data_center\": \"dataCenter\"}, \"watchlist\": [{\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}], \"attachments\": [{\"id\": \"id\", \"filename\": \"filename\", \"size_in_bytes\": 11, \"created_at\": \"createdAt\", \"url\": \"url\"}], \"offering\": {\"name\": \"name\", \"type\": {\"group\": \"crn_service_name\", \"key\": \"key\", \"kind\": \"kind\", \"id\": \"id\"}}, \"resources\": [{\"crn\": \"crn\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"note\": \"note\"}], \"comments\": [{\"value\": \"value\", \"added_at\": \"addedAt\", \"added_by\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}}]}]}";
    String getCasesPath = "/cases";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetCasesOptions model
    GetCasesOptions getCasesOptionsModel = new GetCasesOptions.Builder()
    .offset(Long.valueOf("26"))
    .limit(Long.valueOf("26"))
    .search("testString")
    .sort("number")
    .status(new java.util.ArrayList<String>(java.util.Arrays.asList("new")))
    .fields(new java.util.ArrayList<String>(java.util.Arrays.asList("number")))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<CaseList> response = caseManagementService.getCases(getCasesOptionsModel).execute();
    assertNotNull(response);
    CaseList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("26"));
    assertEquals(query.get("search"), "testString");
    assertEquals(query.get("sort"), "number");
    assertEquals(query.get("status"), RequestUtils.join(new java.util.ArrayList<String>(java.util.Arrays.asList("new")), ","));
    assertEquals(query.get("fields"), RequestUtils.join(new java.util.ArrayList<String>(java.util.Arrays.asList("number")), ","));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCasesPath);
  }

  @Test
  public void testCreateCaseWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"number\": \"number\", \"short_description\": \"shortDescription\", \"description\": \"description\", \"created_at\": \"createdAt\", \"created_by\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}, \"updated_at\": \"updatedAt\", \"updated_by\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}, \"contact_type\": \"Cloud Support Center\", \"contact\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}, \"status\": \"status\", \"severity\": 8, \"support_tier\": \"Free\", \"resolution\": \"resolution\", \"close_notes\": \"closeNotes\", \"eu\": {\"support\": false, \"data_center\": \"dataCenter\"}, \"watchlist\": [{\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}], \"attachments\": [{\"id\": \"id\", \"filename\": \"filename\", \"size_in_bytes\": 11, \"created_at\": \"createdAt\", \"url\": \"url\"}], \"offering\": {\"name\": \"name\", \"type\": {\"group\": \"crn_service_name\", \"key\": \"key\", \"kind\": \"kind\", \"id\": \"id\"}}, \"resources\": [{\"crn\": \"crn\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"note\": \"note\"}], \"comments\": [{\"value\": \"value\", \"added_at\": \"addedAt\", \"added_by\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}}]}";
    String createCasePath = "/cases";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CasePayloadEu model
    CasePayloadEu casePayloadEuModel = new CasePayloadEu.Builder()
    .supported(true)
    .dataCenter(Long.valueOf("26"))
    .build();

    // Construct an instance of the OfferingType model
    OfferingType offeringTypeModel = new OfferingType.Builder()
    .group("crn_service_name")
    .key("testString")
    .kind("testString")
    .id("testString")
    .build();

    // Construct an instance of the Offering model
    Offering offeringModel = new Offering.Builder()
    .name("testString")
    .type(offeringTypeModel)
    .build();

    // Construct an instance of the ResourcePayload model
    ResourcePayload resourcePayloadModel = new ResourcePayload.Builder()
    .crn("testString")
    .type("testString")
    .id(Double.valueOf("72.5"))
    .note("testString")
    .build();

    // Construct an instance of the User model
    User userModel = new User.Builder()
    .realm("IBMid")
    .userId("abc@ibm.com")
    .build();

    // Construct an instance of the CreateCaseOptions model
    CreateCaseOptions createCaseOptionsModel = new CreateCaseOptions.Builder()
    .type("technical")
    .subject("testString")
    .description("testString")
    .severity(Long.valueOf("1"))
    .eu(casePayloadEuModel)
    .offering(offeringModel)
    .resources(new java.util.ArrayList<ResourcePayload>(java.util.Arrays.asList(resourcePayloadModel)))
    .watchlist(new java.util.ArrayList<User>(java.util.Arrays.asList(userModel)))
    .invoiceNumber("testString")
    .slaCreditRequest(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Case> response = caseManagementService.createCase(createCaseOptionsModel).execute();
    assertNotNull(response);
    Case responseObj = response.getResult();
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
    assertEquals(parsedPath, createCasePath);
  }

  // Test the createCase operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateCaseNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    caseManagementService.createCase(null).execute();
  }

  @Test
  public void testGetCaseWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"number\": \"number\", \"short_description\": \"shortDescription\", \"description\": \"description\", \"created_at\": \"createdAt\", \"created_by\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}, \"updated_at\": \"updatedAt\", \"updated_by\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}, \"contact_type\": \"Cloud Support Center\", \"contact\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}, \"status\": \"status\", \"severity\": 8, \"support_tier\": \"Free\", \"resolution\": \"resolution\", \"close_notes\": \"closeNotes\", \"eu\": {\"support\": false, \"data_center\": \"dataCenter\"}, \"watchlist\": [{\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}], \"attachments\": [{\"id\": \"id\", \"filename\": \"filename\", \"size_in_bytes\": 11, \"created_at\": \"createdAt\", \"url\": \"url\"}], \"offering\": {\"name\": \"name\", \"type\": {\"group\": \"crn_service_name\", \"key\": \"key\", \"kind\": \"kind\", \"id\": \"id\"}}, \"resources\": [{\"crn\": \"crn\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"note\": \"note\"}], \"comments\": [{\"value\": \"value\", \"added_at\": \"addedAt\", \"added_by\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}}]}";
    String getCasePath = "/cases/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetCaseOptions model
    GetCaseOptions getCaseOptionsModel = new GetCaseOptions.Builder()
    .caseNumber("testString")
    .fields(new java.util.ArrayList<String>(java.util.Arrays.asList("number")))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Case> response = caseManagementService.getCase(getCaseOptionsModel).execute();
    assertNotNull(response);
    Case responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("fields"), RequestUtils.join(new java.util.ArrayList<String>(java.util.Arrays.asList("number")), ","));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCasePath);
  }

  // Test the getCase operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCaseNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    caseManagementService.getCase(null).execute();
  }

  @Test
  public void testUpdateCaseStatusWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"number\": \"number\", \"short_description\": \"shortDescription\", \"description\": \"description\", \"created_at\": \"createdAt\", \"created_by\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}, \"updated_at\": \"updatedAt\", \"updated_by\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}, \"contact_type\": \"Cloud Support Center\", \"contact\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}, \"status\": \"status\", \"severity\": 8, \"support_tier\": \"Free\", \"resolution\": \"resolution\", \"close_notes\": \"closeNotes\", \"eu\": {\"support\": false, \"data_center\": \"dataCenter\"}, \"watchlist\": [{\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}], \"attachments\": [{\"id\": \"id\", \"filename\": \"filename\", \"size_in_bytes\": 11, \"created_at\": \"createdAt\", \"url\": \"url\"}], \"offering\": {\"name\": \"name\", \"type\": {\"group\": \"crn_service_name\", \"key\": \"key\", \"kind\": \"kind\", \"id\": \"id\"}}, \"resources\": [{\"crn\": \"crn\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"note\": \"note\"}], \"comments\": [{\"value\": \"value\", \"added_at\": \"addedAt\", \"added_by\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}}]}";
    String updateCaseStatusPath = "/cases/testString/status";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ResolvePayload model
    ResolvePayload statusPayloadModel = new ResolvePayload.Builder()
    .action("resolve")
    .comment("It was actually a mistake")
    .resolutionCode(Long.valueOf("1"))
    .build();

    // Construct an instance of the UpdateCaseStatusOptions model
    UpdateCaseStatusOptions updateCaseStatusOptionsModel = new UpdateCaseStatusOptions.Builder()
    .caseNumber("testString")
    .statusPayload(statusPayloadModel)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Case> response = caseManagementService.updateCaseStatus(updateCaseStatusOptionsModel).execute();
    assertNotNull(response);
    Case responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateCaseStatusPath);
  }

  // Test the updateCaseStatus operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateCaseStatusNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    caseManagementService.updateCaseStatus(null).execute();
  }

  @Test
  public void testAddCommentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"value\": \"value\", \"added_at\": \"addedAt\", \"added_by\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}}";
    String addCommentPath = "/cases/testString/comments";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the AddCommentOptions model
    AddCommentOptions addCommentOptionsModel = new AddCommentOptions.Builder()
    .caseNumber("testString")
    .comment("This is a test comment")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Comment> response = caseManagementService.addComment(addCommentOptionsModel).execute();
    assertNotNull(response);
    Comment responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addCommentPath);
  }

  // Test the addComment operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddCommentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    caseManagementService.addComment(null).execute();
  }

  @Test
  public void testAddWatchlistWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"added\": [{\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}], \"failed\": [{\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}]}";
    String addWatchlistPath = "/cases/testString/watchlist";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the User model
    User userModel = new User.Builder()
    .realm("IBMid")
    .userId("abc@ibm.com")
    .build();

    // Construct an instance of the AddWatchlistOptions model
    AddWatchlistOptions addWatchlistOptionsModel = new AddWatchlistOptions.Builder()
    .caseNumber("testString")
    .watchlist(new java.util.ArrayList<User>(java.util.Arrays.asList(userModel)))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<WatchlistAddResponse> response = caseManagementService.addWatchlist(addWatchlistOptionsModel).execute();
    assertNotNull(response);
    WatchlistAddResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addWatchlistPath);
  }

  // Test the addWatchlist operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddWatchlistNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    caseManagementService.addWatchlist(null).execute();
  }

  @Test
  public void testRemoveWatchlistWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"watchlist\": [{\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}]}";
    String removeWatchlistPath = "/cases/testString/watchlist";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the User model
    User userModel = new User.Builder()
    .realm("IBMid")
    .userId("abc@ibm.com")
    .build();

    // Construct an instance of the RemoveWatchlistOptions model
    RemoveWatchlistOptions removeWatchlistOptionsModel = new RemoveWatchlistOptions.Builder()
    .caseNumber("testString")
    .watchlist(new java.util.ArrayList<User>(java.util.Arrays.asList(userModel)))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Watchlist> response = caseManagementService.removeWatchlist(removeWatchlistOptionsModel).execute();
    assertNotNull(response);
    Watchlist responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, removeWatchlistPath);
  }

  // Test the removeWatchlist operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRemoveWatchlistNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    caseManagementService.removeWatchlist(null).execute();
  }

  @Test
  public void testAddResourceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"crn\": \"crn\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"note\": \"note\"}";
    String addResourcePath = "/cases/testString/resources";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the AddResourceOptions model
    AddResourceOptions addResourceOptionsModel = new AddResourceOptions.Builder()
    .caseNumber("testString")
    .crn("testString")
    .type("testString")
    .id(Double.valueOf("72.5"))
    .note("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Resource> response = caseManagementService.addResource(addResourceOptionsModel).execute();
    assertNotNull(response);
    Resource responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addResourcePath);
  }

  // Test the addResource operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddResourceNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    caseManagementService.addResource(null).execute();
  }

  @Test
  public void testUploadFileWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"filename\": \"filename\", \"size_in_bytes\": 11, \"created_at\": \"createdAt\", \"url\": \"url\"}";
    String uploadFilePath = "/cases/testString/attachments";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UploadFileOptions model
    UploadFileOptions uploadFileOptionsModel = new UploadFileOptions.Builder()
    .caseNumber("testString")
    .file(mockListFileWithMetadata)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Attachment> response = caseManagementService.uploadFile(uploadFileOptionsModel).execute();
    assertNotNull(response);
    Attachment responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, uploadFilePath);
  }

  // Test the uploadFile operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUploadFileNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    caseManagementService.uploadFile(null).execute();
  }

  @Test
  public void testDownloadFileWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "This is a mock binary response.";
    String downloadFilePath = "/cases/testString/attachments/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/octet-stream")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DownloadFileOptions model
    DownloadFileOptions downloadFileOptionsModel = new DownloadFileOptions.Builder()
    .caseNumber("testString")
    .fileId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<InputStream> response = caseManagementService.downloadFile(downloadFileOptionsModel).execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
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
    assertEquals(parsedPath, downloadFilePath);
  }

  // Test the downloadFile operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDownloadFileNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    caseManagementService.downloadFile(null).execute();
  }

  @Test
  public void testDeleteFileWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"attachments\": [{\"id\": \"id\", \"filename\": \"filename\", \"size_in_bytes\": 11, \"created_at\": \"createdAt\", \"url\": \"url\"}]}";
    String deleteFilePath = "/cases/testString/attachments/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteFileOptions model
    DeleteFileOptions deleteFileOptionsModel = new DeleteFileOptions.Builder()
    .caseNumber("testString")
    .fileId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AttachmentList> response = caseManagementService.deleteFile(deleteFileOptionsModel).execute();
    assertNotNull(response);
    AttachmentList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteFilePath);
  }

  // Test the deleteFile operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteFileNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    caseManagementService.deleteFile(null).execute();
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
    caseManagementService = null;
  }
}