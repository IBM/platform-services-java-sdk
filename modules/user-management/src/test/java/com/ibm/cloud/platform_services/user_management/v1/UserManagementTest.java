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
package com.ibm.cloud.platform_services.user_management.v1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
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

import com.ibm.cloud.platform_services.user_management.v1.model.AcceptOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.Attribute;
import com.ibm.cloud.platform_services.user_management.v1.model.GetUserProfileOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.GetUserSettingsOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.InviteUser;
import com.ibm.cloud.platform_services.user_management.v1.model.InviteUserIamPolicy;
import com.ibm.cloud.platform_services.user_management.v1.model.InviteUsersOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.InvitedUserList;
import com.ibm.cloud.platform_services.user_management.v1.model.ListUsersOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.RemoveUserOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.Resource;
import com.ibm.cloud.platform_services.user_management.v1.model.Role;
import com.ibm.cloud.platform_services.user_management.v1.model.UpdateUserProfileOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.UpdateUserSettingsOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.UserList;
import com.ibm.cloud.platform_services.user_management.v1.model.UserProfile;
import com.ibm.cloud.platform_services.user_management.v1.model.UserSettings;
import com.ibm.cloud.platform_services.user_management.v1.model.UsersPager;
import com.ibm.cloud.platform_services.user_management.v1.model.V3RemoveUserOptions;
import com.ibm.cloud.platform_services.user_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

/**
 * Unit test class for the UserManagement service.
 */
public class UserManagementTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected UserManagement userManagementService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new UserManagement(serviceName, null);
  }

  // Test the listUsers operation with a valid options model parameter
  @Test
  public void testListUsersWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"total_results\": 12, \"limit\": 5, \"first_url\": \"firstUrl\", \"next_url\": \"nextUrl\", \"resources\": [{\"id\": \"id\", \"iam_id\": \"iamId\", \"realm\": \"realm\", \"user_id\": \"userId\", \"firstname\": \"firstname\", \"lastname\": \"lastname\", \"state\": \"state\", \"email\": \"email\", \"phonenumber\": \"phonenumber\", \"altphonenumber\": \"altphonenumber\", \"photo\": \"photo\", \"account_id\": \"accountId\", \"added_on\": \"addedOn\"}]}";
    String listUsersPath = "/v2/accounts/testString/users";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListUsersOptions model
    ListUsersOptions listUsersOptionsModel = new ListUsersOptions.Builder()
      .accountId("testString")
      .limit(Long.valueOf("10"))
      .start("testString")
      .userId("testString")
      .build();

    // Invoke listUsers() with a valid options model and verify the result
    Response<UserList> response = userManagementService.listUsers(listUsersOptionsModel).execute();
    assertNotNull(response);
    UserList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listUsersPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(query.get("_start"), "testString");
    assertEquals(query.get("user_id"), "testString");
  }

  // Test the listUsers operation with and without retries enabled
  @Test
  public void testListUsersWRetries() throws Throwable {
    userManagementService.enableRetries(4, 30);
    testListUsersWOptions();

    userManagementService.disableRetries();
    testListUsersWOptions();
  }

  // Test the listUsers operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListUsersNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    userManagementService.listUsers(null).execute();
  }

  // Test the listUsers operation using the UsersPager.getNext() method
  @Test
  public void testListUsersWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"total_count\":2,\"limit\":1,\"next_url\":\"https://myhost.com/somePath?_start=1\",\"resources\":[{\"id\":\"id\",\"iam_id\":\"iamId\",\"realm\":\"realm\",\"user_id\":\"userId\",\"firstname\":\"firstname\",\"lastname\":\"lastname\",\"state\":\"state\",\"email\":\"email\",\"phonenumber\":\"phonenumber\",\"altphonenumber\":\"altphonenumber\",\"photo\":\"photo\",\"account_id\":\"accountId\",\"added_on\":\"addedOn\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"id\":\"id\",\"iam_id\":\"iamId\",\"realm\":\"realm\",\"user_id\":\"userId\",\"firstname\":\"firstname\",\"lastname\":\"lastname\",\"state\":\"state\",\"email\":\"email\",\"phonenumber\":\"phonenumber\",\"altphonenumber\":\"altphonenumber\",\"photo\":\"photo\",\"account_id\":\"accountId\",\"added_on\":\"addedOn\"}]}";
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

    ListUsersOptions listUsersOptions = new ListUsersOptions.Builder()
      .accountId("testString")
      .limit(Long.valueOf("10"))
      .userId("testString")
      .build();

    List<UserProfile> allResults = new ArrayList<>();
    UsersPager pager = new UsersPager(userManagementService, listUsersOptions);
    while (pager.hasNext()) {
      List<UserProfile> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }

  // Test the listUsers operation using the UsersPager.getAll() method
  @Test
  public void testListUsersWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"total_count\":2,\"limit\":1,\"next_url\":\"https://myhost.com/somePath?_start=1\",\"resources\":[{\"id\":\"id\",\"iam_id\":\"iamId\",\"realm\":\"realm\",\"user_id\":\"userId\",\"firstname\":\"firstname\",\"lastname\":\"lastname\",\"state\":\"state\",\"email\":\"email\",\"phonenumber\":\"phonenumber\",\"altphonenumber\":\"altphonenumber\",\"photo\":\"photo\",\"account_id\":\"accountId\",\"added_on\":\"addedOn\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"id\":\"id\",\"iam_id\":\"iamId\",\"realm\":\"realm\",\"user_id\":\"userId\",\"firstname\":\"firstname\",\"lastname\":\"lastname\",\"state\":\"state\",\"email\":\"email\",\"phonenumber\":\"phonenumber\",\"altphonenumber\":\"altphonenumber\",\"photo\":\"photo\",\"account_id\":\"accountId\",\"added_on\":\"addedOn\"}]}";
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

    ListUsersOptions listUsersOptions = new ListUsersOptions.Builder()
      .accountId("testString")
      .limit(Long.valueOf("10"))
      .userId("testString")
      .build();

    UsersPager pager = new UsersPager(userManagementService, listUsersOptions);
    List<UserProfile> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }

  // Test the inviteUsers operation with a valid options model parameter
  @Test
  public void testInviteUsersWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"resources\": [{\"email\": \"email\", \"id\": \"id\", \"state\": \"state\"}]}";
    String inviteUsersPath = "/v2/accounts/testString/users";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(202)
      .setBody(mockResponseBody));

    // Construct an instance of the InviteUser model
    InviteUser inviteUserModel = new InviteUser.Builder()
      .email("testString")
      .accountRole("testString")
      .build();

    // Construct an instance of the Role model
    Role roleModel = new Role.Builder()
      .roleId("testString")
      .build();

    // Construct an instance of the Attribute model
    Attribute attributeModel = new Attribute.Builder()
      .name("testString")
      .value("testString")
      .build();

    // Construct an instance of the Resource model
    Resource resourceModel = new Resource.Builder()
      .attributes(java.util.Arrays.asList(attributeModel))
      .build();

    // Construct an instance of the InviteUserIamPolicy model
    InviteUserIamPolicy inviteUserIamPolicyModel = new InviteUserIamPolicy.Builder()
      .type("testString")
      .roles(java.util.Arrays.asList(roleModel))
      .resources(java.util.Arrays.asList(resourceModel))
      .build();

    // Construct an instance of the InviteUsersOptions model
    InviteUsersOptions inviteUsersOptionsModel = new InviteUsersOptions.Builder()
      .accountId("testString")
      .users(java.util.Arrays.asList(inviteUserModel))
      .iamPolicy(java.util.Arrays.asList(inviteUserIamPolicyModel))
      .accessGroups(java.util.Arrays.asList("testString"))
      .build();

    // Invoke inviteUsers() with a valid options model and verify the result
    Response<InvitedUserList> response = userManagementService.inviteUsers(inviteUsersOptionsModel).execute();
    assertNotNull(response);
    InvitedUserList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, inviteUsersPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the inviteUsers operation with and without retries enabled
  @Test
  public void testInviteUsersWRetries() throws Throwable {
    userManagementService.enableRetries(4, 30);
    testInviteUsersWOptions();

    userManagementService.disableRetries();
    testInviteUsersWOptions();
  }

  // Test the inviteUsers operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testInviteUsersNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    userManagementService.inviteUsers(null).execute();
  }

  // Test the getUserProfile operation with a valid options model parameter
  @Test
  public void testGetUserProfileWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"iam_id\": \"iamId\", \"realm\": \"realm\", \"user_id\": \"userId\", \"firstname\": \"firstname\", \"lastname\": \"lastname\", \"state\": \"state\", \"email\": \"email\", \"phonenumber\": \"phonenumber\", \"altphonenumber\": \"altphonenumber\", \"photo\": \"photo\", \"account_id\": \"accountId\", \"added_on\": \"addedOn\"}";
    String getUserProfilePath = "/v2/accounts/testString/users/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetUserProfileOptions model
    GetUserProfileOptions getUserProfileOptionsModel = new GetUserProfileOptions.Builder()
      .accountId("testString")
      .iamId("testString")
      .includeActivity("testString")
      .build();

    // Invoke getUserProfile() with a valid options model and verify the result
    Response<UserProfile> response = userManagementService.getUserProfile(getUserProfileOptionsModel).execute();
    assertNotNull(response);
    UserProfile responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getUserProfilePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("include_activity"), "testString");
  }

  // Test the getUserProfile operation with and without retries enabled
  @Test
  public void testGetUserProfileWRetries() throws Throwable {
    userManagementService.enableRetries(4, 30);
    testGetUserProfileWOptions();

    userManagementService.disableRetries();
    testGetUserProfileWOptions();
  }

  // Test the getUserProfile operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetUserProfileNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    userManagementService.getUserProfile(null).execute();
  }

  // Test the updateUserProfile operation with a valid options model parameter
  @Test
  public void testUpdateUserProfileWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String updateUserProfilePath = "/v2/accounts/testString/users/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the UpdateUserProfileOptions model
    UpdateUserProfileOptions updateUserProfileOptionsModel = new UpdateUserProfileOptions.Builder()
      .accountId("testString")
      .iamId("testString")
      .firstname("testString")
      .lastname("testString")
      .state("testString")
      .email("testString")
      .phonenumber("testString")
      .altphonenumber("testString")
      .photo("testString")
      .includeActivity("testString")
      .build();

    // Invoke updateUserProfile() with a valid options model and verify the result
    Response<Void> response = userManagementService.updateUserProfile(updateUserProfileOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateUserProfilePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("include_activity"), "testString");
  }

  // Test the updateUserProfile operation with and without retries enabled
  @Test
  public void testUpdateUserProfileWRetries() throws Throwable {
    userManagementService.enableRetries(4, 30);
    testUpdateUserProfileWOptions();

    userManagementService.disableRetries();
    testUpdateUserProfileWOptions();
  }

  // Test the updateUserProfile operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateUserProfileNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    userManagementService.updateUserProfile(null).execute();
  }

  // Test the removeUser operation with a valid options model parameter
  @Test
  public void testRemoveUserWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String removeUserPath = "/v2/accounts/testString/users/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the RemoveUserOptions model
    RemoveUserOptions removeUserOptionsModel = new RemoveUserOptions.Builder()
      .accountId("testString")
      .iamId("testString")
      .includeActivity("testString")
      .build();

    // Invoke removeUser() with a valid options model and verify the result
    Response<Void> response = userManagementService.removeUser(removeUserOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, removeUserPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("include_activity"), "testString");
  }

  // Test the removeUser operation with and without retries enabled
  @Test
  public void testRemoveUserWRetries() throws Throwable {
    userManagementService.enableRetries(4, 30);
    testRemoveUserWOptions();

    userManagementService.disableRetries();
    testRemoveUserWOptions();
  }

  // Test the removeUser operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRemoveUserNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    userManagementService.removeUser(null).execute();
  }

  // Test the accept operation with a valid options model parameter
  @Test
  public void testAcceptWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String acceptPath = "/v2/users/accept";
    server.enqueue(new MockResponse()
      .setResponseCode(202)
      .setBody(mockResponseBody));

    // Construct an instance of the AcceptOptions model
    AcceptOptions acceptOptionsModel = new AcceptOptions.Builder()
      .accountId("testString")
      .build();

    // Invoke accept() with a valid options model and verify the result
    Response<Void> response = userManagementService.accept(acceptOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, acceptPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the accept operation with and without retries enabled
  @Test
  public void testAcceptWRetries() throws Throwable {
    userManagementService.enableRetries(4, 30);
    testAcceptWOptions();

    userManagementService.disableRetries();
    testAcceptWOptions();
  }

  // Test the v3RemoveUser operation with a valid options model parameter
  @Test
  public void testV3RemoveUserWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String v3RemoveUserPath = "/v3/accounts/testString/users/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(202)
      .setBody(mockResponseBody));

    // Construct an instance of the V3RemoveUserOptions model
    V3RemoveUserOptions v3RemoveUserOptionsModel = new V3RemoveUserOptions.Builder()
      .accountId("testString")
      .iamId("testString")
      .build();

    // Invoke v3RemoveUser() with a valid options model and verify the result
    Response<Void> response = userManagementService.v3RemoveUser(v3RemoveUserOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, v3RemoveUserPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the v3RemoveUser operation with and without retries enabled
  @Test
  public void testV3RemoveUserWRetries() throws Throwable {
    userManagementService.enableRetries(4, 30);
    testV3RemoveUserWOptions();

    userManagementService.disableRetries();
    testV3RemoveUserWOptions();
  }

  // Test the v3RemoveUser operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testV3RemoveUserNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    userManagementService.v3RemoveUser(null).execute();
  }

  // Test the getUserSettings operation with a valid options model parameter
  @Test
  public void testGetUserSettingsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"language\": \"language\", \"notification_language\": \"notificationLanguage\", \"allowed_ip_addresses\": \"32.96.110.50,172.16.254.1\", \"self_manage\": true}";
    String getUserSettingsPath = "/v2/accounts/testString/users/testString/settings";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetUserSettingsOptions model
    GetUserSettingsOptions getUserSettingsOptionsModel = new GetUserSettingsOptions.Builder()
      .accountId("testString")
      .iamId("testString")
      .build();

    // Invoke getUserSettings() with a valid options model and verify the result
    Response<UserSettings> response = userManagementService.getUserSettings(getUserSettingsOptionsModel).execute();
    assertNotNull(response);
    UserSettings responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getUserSettingsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getUserSettings operation with and without retries enabled
  @Test
  public void testGetUserSettingsWRetries() throws Throwable {
    userManagementService.enableRetries(4, 30);
    testGetUserSettingsWOptions();

    userManagementService.disableRetries();
    testGetUserSettingsWOptions();
  }

  // Test the getUserSettings operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetUserSettingsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    userManagementService.getUserSettings(null).execute();
  }

  // Test the updateUserSettings operation with a valid options model parameter
  @Test
  public void testUpdateUserSettingsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String updateUserSettingsPath = "/v2/accounts/testString/users/testString/settings";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the UpdateUserSettingsOptions model
    UpdateUserSettingsOptions updateUserSettingsOptionsModel = new UpdateUserSettingsOptions.Builder()
      .accountId("testString")
      .iamId("testString")
      .language("testString")
      .notificationLanguage("testString")
      .allowedIpAddresses("32.96.110.50,172.16.254.1")
      .selfManage(true)
      .build();

    // Invoke updateUserSettings() with a valid options model and verify the result
    Response<Void> response = userManagementService.updateUserSettings(updateUserSettingsOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateUserSettingsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateUserSettings operation with and without retries enabled
  @Test
  public void testUpdateUserSettingsWRetries() throws Throwable {
    userManagementService.enableRetries(4, 30);
    testUpdateUserSettingsWOptions();

    userManagementService.disableRetries();
    testUpdateUserSettingsWOptions();
  }

  // Test the updateUserSettings operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateUserSettingsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    userManagementService.updateUserSettings(null).execute();
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
    userManagementService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    System.setProperty("TESTSERVICE_AUTH_TYPE", "noAuth");
    final String serviceName = "testService";

    userManagementService = UserManagement.newInstance(serviceName);
    String url = server.url("/").toString();
    userManagementService.setServiceUrl(url);
  }
}