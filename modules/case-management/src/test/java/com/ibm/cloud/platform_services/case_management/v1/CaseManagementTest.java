/*
 * (C) Copyright IBM Corp. 2022.
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
import com.ibm.cloud.platform_services.case_management.v1.model.GetCasesPager;
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

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new CaseManagement(serviceName, null);
  }

  // Test the getCases operation with a valid options model parameter
  @Test
  public void testGetCasesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"total_count\": 10, \"first\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\"}, \"previous\": {\"href\": \"href\"}, \"last\": {\"href\": \"href\"}, \"cases\": [{\"number\": \"number\", \"short_description\": \"shortDescription\", \"description\": \"description\", \"created_at\": \"createdAt\", \"created_by\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}, \"updated_at\": \"updatedAt\", \"updated_by\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}, \"contact_type\": \"Cloud Support Center\", \"contact\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}, \"status\": \"status\", \"severity\": 8, \"support_tier\": \"Free\", \"resolution\": \"resolution\", \"close_notes\": \"closeNotes\", \"eu\": {\"support\": false, \"data_center\": \"dataCenter\"}, \"watchlist\": [{\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}], \"attachments\": [{\"id\": \"id\", \"filename\": \"filename\", \"size_in_bytes\": 11, \"created_at\": \"createdAt\", \"url\": \"url\"}], \"offering\": {\"name\": \"name\", \"type\": {\"group\": \"crn_service_name\", \"key\": \"key\", \"kind\": \"kind\", \"id\": \"id\"}}, \"resources\": [{\"crn\": \"crn\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"note\": \"note\"}], \"comments\": [{\"value\": \"value\", \"added_at\": \"addedAt\", \"added_by\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}}]}]}";
    String getCasesPath = "/cases";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetCasesOptions model
    GetCasesOptions getCasesOptionsModel = new GetCasesOptions.Builder()
      .offset(Long.valueOf("26"))
      .limit(Long.valueOf("10"))
      .search("testString")
      .sort("number")
      .status(java.util.Arrays.asList("new"))
      .fields(java.util.Arrays.asList("number"))
      .build();

    // Invoke getCases() with a valid options model and verify the result
    Response<CaseList> response = caseManagementService.getCases(getCasesOptionsModel).execute();
    assertNotNull(response);
    CaseList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCasesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(query.get("search"), "testString");
    assertEquals(query.get("sort"), "number");
    assertEquals(query.get("status"), RequestUtils.join(java.util.Arrays.asList("new"), ","));
    assertEquals(query.get("fields"), RequestUtils.join(java.util.Arrays.asList("number"), ","));
  }

  // Test the getCases operation with and without retries enabled
  @Test
  public void testGetCasesWRetries() throws Throwable {
    caseManagementService.enableRetries(4, 30);
    testGetCasesWOptions();

    caseManagementService.disableRetries();
    testGetCasesWOptions();
  }

  // Test the getCases operation using the GetCasesPager.getNext() method
  @Test
  public void testGetCasesWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"href\":\"https://myhost.com/somePath?offset=1\"},\"cases\":[{\"number\":\"number\",\"short_description\":\"shortDescription\",\"description\":\"description\",\"created_at\":\"createdAt\",\"created_by\":{\"name\":\"name\",\"realm\":\"IBMid\",\"user_id\":\"abc@ibm.com\"},\"updated_at\":\"updatedAt\",\"updated_by\":{\"name\":\"name\",\"realm\":\"IBMid\",\"user_id\":\"abc@ibm.com\"},\"contact_type\":\"Cloud Support Center\",\"contact\":{\"name\":\"name\",\"realm\":\"IBMid\",\"user_id\":\"abc@ibm.com\"},\"status\":\"status\",\"severity\":8,\"support_tier\":\"Free\",\"resolution\":\"resolution\",\"close_notes\":\"closeNotes\",\"eu\":{\"support\":false,\"data_center\":\"dataCenter\"},\"watchlist\":[{\"name\":\"name\",\"realm\":\"IBMid\",\"user_id\":\"abc@ibm.com\"}],\"attachments\":[{\"id\":\"id\",\"filename\":\"filename\",\"size_in_bytes\":11,\"created_at\":\"createdAt\",\"url\":\"url\"}],\"offering\":{\"name\":\"name\",\"type\":{\"group\":\"crn_service_name\",\"key\":\"key\",\"kind\":\"kind\",\"id\":\"id\"}},\"resources\":[{\"crn\":\"crn\",\"name\":\"name\",\"type\":\"type\",\"url\":\"url\",\"note\":\"note\"}],\"comments\":[{\"value\":\"value\",\"added_at\":\"addedAt\",\"added_by\":{\"name\":\"name\",\"realm\":\"IBMid\",\"user_id\":\"abc@ibm.com\"}}]}],\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"cases\":[{\"number\":\"number\",\"short_description\":\"shortDescription\",\"description\":\"description\",\"created_at\":\"createdAt\",\"created_by\":{\"name\":\"name\",\"realm\":\"IBMid\",\"user_id\":\"abc@ibm.com\"},\"updated_at\":\"updatedAt\",\"updated_by\":{\"name\":\"name\",\"realm\":\"IBMid\",\"user_id\":\"abc@ibm.com\"},\"contact_type\":\"Cloud Support Center\",\"contact\":{\"name\":\"name\",\"realm\":\"IBMid\",\"user_id\":\"abc@ibm.com\"},\"status\":\"status\",\"severity\":8,\"support_tier\":\"Free\",\"resolution\":\"resolution\",\"close_notes\":\"closeNotes\",\"eu\":{\"support\":false,\"data_center\":\"dataCenter\"},\"watchlist\":[{\"name\":\"name\",\"realm\":\"IBMid\",\"user_id\":\"abc@ibm.com\"}],\"attachments\":[{\"id\":\"id\",\"filename\":\"filename\",\"size_in_bytes\":11,\"created_at\":\"createdAt\",\"url\":\"url\"}],\"offering\":{\"name\":\"name\",\"type\":{\"group\":\"crn_service_name\",\"key\":\"key\",\"kind\":\"kind\",\"id\":\"id\"}},\"resources\":[{\"crn\":\"crn\",\"name\":\"name\",\"type\":\"type\",\"url\":\"url\",\"note\":\"note\"}],\"comments\":[{\"value\":\"value\",\"added_at\":\"addedAt\",\"added_by\":{\"name\":\"name\",\"realm\":\"IBMid\",\"user_id\":\"abc@ibm.com\"}}]}],\"total_count\":2,\"limit\":1}";
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

    GetCasesOptions getCasesOptions = new GetCasesOptions.Builder()
      .limit(Long.valueOf("10"))
      .search("testString")
      .sort("number")
      .status(java.util.Arrays.asList("new"))
      .fields(java.util.Arrays.asList("number"))
      .build();

    List<Case> allResults = new ArrayList<>();
    GetCasesPager pager = new GetCasesPager(caseManagementService, getCasesOptions);
    while (pager.hasNext()) {
      List<Case> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the getCases operation using the GetCasesPager.getAll() method
  @Test
  public void testGetCasesWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"href\":\"https://myhost.com/somePath?offset=1\"},\"cases\":[{\"number\":\"number\",\"short_description\":\"shortDescription\",\"description\":\"description\",\"created_at\":\"createdAt\",\"created_by\":{\"name\":\"name\",\"realm\":\"IBMid\",\"user_id\":\"abc@ibm.com\"},\"updated_at\":\"updatedAt\",\"updated_by\":{\"name\":\"name\",\"realm\":\"IBMid\",\"user_id\":\"abc@ibm.com\"},\"contact_type\":\"Cloud Support Center\",\"contact\":{\"name\":\"name\",\"realm\":\"IBMid\",\"user_id\":\"abc@ibm.com\"},\"status\":\"status\",\"severity\":8,\"support_tier\":\"Free\",\"resolution\":\"resolution\",\"close_notes\":\"closeNotes\",\"eu\":{\"support\":false,\"data_center\":\"dataCenter\"},\"watchlist\":[{\"name\":\"name\",\"realm\":\"IBMid\",\"user_id\":\"abc@ibm.com\"}],\"attachments\":[{\"id\":\"id\",\"filename\":\"filename\",\"size_in_bytes\":11,\"created_at\":\"createdAt\",\"url\":\"url\"}],\"offering\":{\"name\":\"name\",\"type\":{\"group\":\"crn_service_name\",\"key\":\"key\",\"kind\":\"kind\",\"id\":\"id\"}},\"resources\":[{\"crn\":\"crn\",\"name\":\"name\",\"type\":\"type\",\"url\":\"url\",\"note\":\"note\"}],\"comments\":[{\"value\":\"value\",\"added_at\":\"addedAt\",\"added_by\":{\"name\":\"name\",\"realm\":\"IBMid\",\"user_id\":\"abc@ibm.com\"}}]}],\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"cases\":[{\"number\":\"number\",\"short_description\":\"shortDescription\",\"description\":\"description\",\"created_at\":\"createdAt\",\"created_by\":{\"name\":\"name\",\"realm\":\"IBMid\",\"user_id\":\"abc@ibm.com\"},\"updated_at\":\"updatedAt\",\"updated_by\":{\"name\":\"name\",\"realm\":\"IBMid\",\"user_id\":\"abc@ibm.com\"},\"contact_type\":\"Cloud Support Center\",\"contact\":{\"name\":\"name\",\"realm\":\"IBMid\",\"user_id\":\"abc@ibm.com\"},\"status\":\"status\",\"severity\":8,\"support_tier\":\"Free\",\"resolution\":\"resolution\",\"close_notes\":\"closeNotes\",\"eu\":{\"support\":false,\"data_center\":\"dataCenter\"},\"watchlist\":[{\"name\":\"name\",\"realm\":\"IBMid\",\"user_id\":\"abc@ibm.com\"}],\"attachments\":[{\"id\":\"id\",\"filename\":\"filename\",\"size_in_bytes\":11,\"created_at\":\"createdAt\",\"url\":\"url\"}],\"offering\":{\"name\":\"name\",\"type\":{\"group\":\"crn_service_name\",\"key\":\"key\",\"kind\":\"kind\",\"id\":\"id\"}},\"resources\":[{\"crn\":\"crn\",\"name\":\"name\",\"type\":\"type\",\"url\":\"url\",\"note\":\"note\"}],\"comments\":[{\"value\":\"value\",\"added_at\":\"addedAt\",\"added_by\":{\"name\":\"name\",\"realm\":\"IBMid\",\"user_id\":\"abc@ibm.com\"}}]}],\"total_count\":2,\"limit\":1}";
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

    GetCasesOptions getCasesOptions = new GetCasesOptions.Builder()
      .limit(Long.valueOf("10"))
      .search("testString")
      .sort("number")
      .status(java.util.Arrays.asList("new"))
      .fields(java.util.Arrays.asList("number"))
      .build();

    GetCasesPager pager = new GetCasesPager(caseManagementService, getCasesOptions);
    List<Case> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the createCase operation with a valid options model parameter
  @Test
  public void testCreateCaseWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"number\": \"number\", \"short_description\": \"shortDescription\", \"description\": \"description\", \"created_at\": \"createdAt\", \"created_by\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}, \"updated_at\": \"updatedAt\", \"updated_by\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}, \"contact_type\": \"Cloud Support Center\", \"contact\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}, \"status\": \"status\", \"severity\": 8, \"support_tier\": \"Free\", \"resolution\": \"resolution\", \"close_notes\": \"closeNotes\", \"eu\": {\"support\": false, \"data_center\": \"dataCenter\"}, \"watchlist\": [{\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}], \"attachments\": [{\"id\": \"id\", \"filename\": \"filename\", \"size_in_bytes\": 11, \"created_at\": \"createdAt\", \"url\": \"url\"}], \"offering\": {\"name\": \"name\", \"type\": {\"group\": \"crn_service_name\", \"key\": \"key\", \"kind\": \"kind\", \"id\": \"id\"}}, \"resources\": [{\"crn\": \"crn\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"note\": \"note\"}], \"comments\": [{\"value\": \"value\", \"added_at\": \"addedAt\", \"added_by\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}}]}";
    String createCasePath = "/cases";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

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
      .resources(java.util.Arrays.asList(resourcePayloadModel))
      .watchlist(java.util.Arrays.asList(userModel))
      .invoiceNumber("testString")
      .slaCreditRequest(false)
      .build();

    // Invoke createCase() with a valid options model and verify the result
    Response<Case> response = caseManagementService.createCase(createCaseOptionsModel).execute();
    assertNotNull(response);
    Case responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createCasePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createCase operation with and without retries enabled
  @Test
  public void testCreateCaseWRetries() throws Throwable {
    caseManagementService.enableRetries(4, 30);
    testCreateCaseWOptions();

    caseManagementService.disableRetries();
    testCreateCaseWOptions();
  }

  // Test the createCase operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateCaseNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    caseManagementService.createCase(null).execute();
  }

  // Test the getCase operation with a valid options model parameter
  @Test
  public void testGetCaseWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"number\": \"number\", \"short_description\": \"shortDescription\", \"description\": \"description\", \"created_at\": \"createdAt\", \"created_by\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}, \"updated_at\": \"updatedAt\", \"updated_by\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}, \"contact_type\": \"Cloud Support Center\", \"contact\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}, \"status\": \"status\", \"severity\": 8, \"support_tier\": \"Free\", \"resolution\": \"resolution\", \"close_notes\": \"closeNotes\", \"eu\": {\"support\": false, \"data_center\": \"dataCenter\"}, \"watchlist\": [{\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}], \"attachments\": [{\"id\": \"id\", \"filename\": \"filename\", \"size_in_bytes\": 11, \"created_at\": \"createdAt\", \"url\": \"url\"}], \"offering\": {\"name\": \"name\", \"type\": {\"group\": \"crn_service_name\", \"key\": \"key\", \"kind\": \"kind\", \"id\": \"id\"}}, \"resources\": [{\"crn\": \"crn\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"note\": \"note\"}], \"comments\": [{\"value\": \"value\", \"added_at\": \"addedAt\", \"added_by\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}}]}";
    String getCasePath = "/cases/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetCaseOptions model
    GetCaseOptions getCaseOptionsModel = new GetCaseOptions.Builder()
      .caseNumber("testString")
      .fields(java.util.Arrays.asList("number"))
      .build();

    // Invoke getCase() with a valid options model and verify the result
    Response<Case> response = caseManagementService.getCase(getCaseOptionsModel).execute();
    assertNotNull(response);
    Case responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCasePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("fields"), RequestUtils.join(java.util.Arrays.asList("number"), ","));
  }

  // Test the getCase operation with and without retries enabled
  @Test
  public void testGetCaseWRetries() throws Throwable {
    caseManagementService.enableRetries(4, 30);
    testGetCaseWOptions();

    caseManagementService.disableRetries();
    testGetCaseWOptions();
  }

  // Test the getCase operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCaseNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    caseManagementService.getCase(null).execute();
  }

  // Test the updateCaseStatus operation with a valid options model parameter
  @Test
  public void testUpdateCaseStatusWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"number\": \"number\", \"short_description\": \"shortDescription\", \"description\": \"description\", \"created_at\": \"createdAt\", \"created_by\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}, \"updated_at\": \"updatedAt\", \"updated_by\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}, \"contact_type\": \"Cloud Support Center\", \"contact\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}, \"status\": \"status\", \"severity\": 8, \"support_tier\": \"Free\", \"resolution\": \"resolution\", \"close_notes\": \"closeNotes\", \"eu\": {\"support\": false, \"data_center\": \"dataCenter\"}, \"watchlist\": [{\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}], \"attachments\": [{\"id\": \"id\", \"filename\": \"filename\", \"size_in_bytes\": 11, \"created_at\": \"createdAt\", \"url\": \"url\"}], \"offering\": {\"name\": \"name\", \"type\": {\"group\": \"crn_service_name\", \"key\": \"key\", \"kind\": \"kind\", \"id\": \"id\"}}, \"resources\": [{\"crn\": \"crn\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"note\": \"note\"}], \"comments\": [{\"value\": \"value\", \"added_at\": \"addedAt\", \"added_by\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}}]}";
    String updateCaseStatusPath = "/cases/testString/status";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

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

    // Invoke updateCaseStatus() with a valid options model and verify the result
    Response<Case> response = caseManagementService.updateCaseStatus(updateCaseStatusOptionsModel).execute();
    assertNotNull(response);
    Case responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateCaseStatusPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateCaseStatus operation with and without retries enabled
  @Test
  public void testUpdateCaseStatusWRetries() throws Throwable {
    caseManagementService.enableRetries(4, 30);
    testUpdateCaseStatusWOptions();

    caseManagementService.disableRetries();
    testUpdateCaseStatusWOptions();
  }

  // Test the updateCaseStatus operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateCaseStatusNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    caseManagementService.updateCaseStatus(null).execute();
  }

  // Test the addComment operation with a valid options model parameter
  @Test
  public void testAddCommentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"value\": \"value\", \"added_at\": \"addedAt\", \"added_by\": {\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}}";
    String addCommentPath = "/cases/testString/comments";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the AddCommentOptions model
    AddCommentOptions addCommentOptionsModel = new AddCommentOptions.Builder()
      .caseNumber("testString")
      .comment("This is a test comment")
      .build();

    // Invoke addComment() with a valid options model and verify the result
    Response<Comment> response = caseManagementService.addComment(addCommentOptionsModel).execute();
    assertNotNull(response);
    Comment responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addCommentPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the addComment operation with and without retries enabled
  @Test
  public void testAddCommentWRetries() throws Throwable {
    caseManagementService.enableRetries(4, 30);
    testAddCommentWOptions();

    caseManagementService.disableRetries();
    testAddCommentWOptions();
  }

  // Test the addComment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddCommentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    caseManagementService.addComment(null).execute();
  }

  // Test the addWatchlist operation with a valid options model parameter
  @Test
  public void testAddWatchlistWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"added\": [{\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}], \"failed\": [{\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}]}";
    String addWatchlistPath = "/cases/testString/watchlist";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the User model
    User userModel = new User.Builder()
      .realm("IBMid")
      .userId("abc@ibm.com")
      .build();

    // Construct an instance of the AddWatchlistOptions model
    AddWatchlistOptions addWatchlistOptionsModel = new AddWatchlistOptions.Builder()
      .caseNumber("testString")
      .watchlist(java.util.Arrays.asList(userModel))
      .build();

    // Invoke addWatchlist() with a valid options model and verify the result
    Response<WatchlistAddResponse> response = caseManagementService.addWatchlist(addWatchlistOptionsModel).execute();
    assertNotNull(response);
    WatchlistAddResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addWatchlistPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the addWatchlist operation with and without retries enabled
  @Test
  public void testAddWatchlistWRetries() throws Throwable {
    caseManagementService.enableRetries(4, 30);
    testAddWatchlistWOptions();

    caseManagementService.disableRetries();
    testAddWatchlistWOptions();
  }

  // Test the addWatchlist operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddWatchlistNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    caseManagementService.addWatchlist(null).execute();
  }

  // Test the removeWatchlist operation with a valid options model parameter
  @Test
  public void testRemoveWatchlistWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"watchlist\": [{\"name\": \"name\", \"realm\": \"IBMid\", \"user_id\": \"abc@ibm.com\"}]}";
    String removeWatchlistPath = "/cases/testString/watchlist";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the User model
    User userModel = new User.Builder()
      .realm("IBMid")
      .userId("abc@ibm.com")
      .build();

    // Construct an instance of the RemoveWatchlistOptions model
    RemoveWatchlistOptions removeWatchlistOptionsModel = new RemoveWatchlistOptions.Builder()
      .caseNumber("testString")
      .watchlist(java.util.Arrays.asList(userModel))
      .build();

    // Invoke removeWatchlist() with a valid options model and verify the result
    Response<Watchlist> response = caseManagementService.removeWatchlist(removeWatchlistOptionsModel).execute();
    assertNotNull(response);
    Watchlist responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, removeWatchlistPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the removeWatchlist operation with and without retries enabled
  @Test
  public void testRemoveWatchlistWRetries() throws Throwable {
    caseManagementService.enableRetries(4, 30);
    testRemoveWatchlistWOptions();

    caseManagementService.disableRetries();
    testRemoveWatchlistWOptions();
  }

  // Test the removeWatchlist operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRemoveWatchlistNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    caseManagementService.removeWatchlist(null).execute();
  }

  // Test the addResource operation with a valid options model parameter
  @Test
  public void testAddResourceWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"crn\": \"crn\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"note\": \"note\"}";
    String addResourcePath = "/cases/testString/resources";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the AddResourceOptions model
    AddResourceOptions addResourceOptionsModel = new AddResourceOptions.Builder()
      .caseNumber("testString")
      .crn("testString")
      .type("testString")
      .id(Double.valueOf("72.5"))
      .note("testString")
      .build();

    // Invoke addResource() with a valid options model and verify the result
    Response<Resource> response = caseManagementService.addResource(addResourceOptionsModel).execute();
    assertNotNull(response);
    Resource responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addResourcePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the addResource operation with and without retries enabled
  @Test
  public void testAddResourceWRetries() throws Throwable {
    caseManagementService.enableRetries(4, 30);
    testAddResourceWOptions();

    caseManagementService.disableRetries();
    testAddResourceWOptions();
  }

  // Test the addResource operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddResourceNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    caseManagementService.addResource(null).execute();
  }

  // Test the uploadFile operation with a valid options model parameter
  @Test
  public void testUploadFileWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"filename\": \"filename\", \"size_in_bytes\": 11, \"created_at\": \"createdAt\", \"url\": \"url\"}";
    String uploadFilePath = "/cases/testString/attachments";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the UploadFileOptions model
    UploadFileOptions uploadFileOptionsModel = new UploadFileOptions.Builder()
      .caseNumber("testString")
      .file(mockListFileWithMetadata)
      .build();

    // Invoke uploadFile() with a valid options model and verify the result
    Response<Attachment> response = caseManagementService.uploadFile(uploadFileOptionsModel).execute();
    assertNotNull(response);
    Attachment responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, uploadFilePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the uploadFile operation with and without retries enabled
  @Test
  public void testUploadFileWRetries() throws Throwable {
    caseManagementService.enableRetries(4, 30);
    testUploadFileWOptions();

    caseManagementService.disableRetries();
    testUploadFileWOptions();
  }

  // Test the uploadFile operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUploadFileNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    caseManagementService.uploadFile(null).execute();
  }

  // Test the downloadFile operation with a valid options model parameter
  @Test
  public void testDownloadFileWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "This is a mock binary response.";
    String downloadFilePath = "/cases/testString/attachments/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/octet-stream")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the DownloadFileOptions model
    DownloadFileOptions downloadFileOptionsModel = new DownloadFileOptions.Builder()
      .caseNumber("testString")
      .fileId("testString")
      .build();

    // Invoke downloadFile() with a valid options model and verify the result
    Response<InputStream> response = caseManagementService.downloadFile(downloadFileOptionsModel).execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
    assertNotNull(responseObj);
    responseObj.close();

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, downloadFilePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the downloadFile operation with and without retries enabled
  @Test
  public void testDownloadFileWRetries() throws Throwable {
    caseManagementService.enableRetries(4, 30);
    testDownloadFileWOptions();

    caseManagementService.disableRetries();
    testDownloadFileWOptions();
  }

  // Test the downloadFile operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDownloadFileNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    caseManagementService.downloadFile(null).execute();
  }

  // Test the deleteFile operation with a valid options model parameter
  @Test
  public void testDeleteFileWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"attachments\": [{\"id\": \"id\", \"filename\": \"filename\", \"size_in_bytes\": 11, \"created_at\": \"createdAt\", \"url\": \"url\"}]}";
    String deleteFilePath = "/cases/testString/attachments/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteFileOptions model
    DeleteFileOptions deleteFileOptionsModel = new DeleteFileOptions.Builder()
      .caseNumber("testString")
      .fileId("testString")
      .build();

    // Invoke deleteFile() with a valid options model and verify the result
    Response<AttachmentList> response = caseManagementService.deleteFile(deleteFileOptionsModel).execute();
    assertNotNull(response);
    AttachmentList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteFilePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteFile operation with and without retries enabled
  @Test
  public void testDeleteFileWRetries() throws Throwable {
    caseManagementService.enableRetries(4, 30);
    testDeleteFileWOptions();

    caseManagementService.disableRetries();
    testDeleteFileWOptions();
  }

  // Test the deleteFile operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteFileNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    caseManagementService.deleteFile(null).execute();
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
    caseManagementService = null;
  }

  // Creates a mock set of environment variables that are returned by EnvironmentUtils.getenv()
  private Map<String, String> getTestProcessEnvironment() {
    Map<String, String> env = new HashMap<>();
    env.put("TESTSERVICE_AUTH_TYPE", "noAuth");
    return env;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    PowerMockito.spy(EnvironmentUtils.class);
    PowerMockito.when(EnvironmentUtils.getenv()).thenReturn(getTestProcessEnvironment());
    final String serviceName = "testService";

    caseManagementService = CaseManagement.newInstance(serviceName);
    String url = server.url("/").toString();
    caseManagementService.setServiceUrl(url);
  }
}