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
package com.ibm.cloud.platform_services.user_management.v1;

import com.ibm.cloud.platform_services.user_management.v1.UserManagement;
import com.ibm.cloud.platform_services.user_management.v1.model.Attribute;
import com.ibm.cloud.platform_services.user_management.v1.model.GetUserProfileOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.GetUserSettingsOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.InviteUser;
import com.ibm.cloud.platform_services.user_management.v1.model.InviteUserIamPolicy;
import com.ibm.cloud.platform_services.user_management.v1.model.InviteUsersOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.ListUsersOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.RemoveUsersOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.Resource;
import com.ibm.cloud.platform_services.user_management.v1.model.Role;
import com.ibm.cloud.platform_services.user_management.v1.model.UpdateUserProfilesOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.UpdateUserSettingsOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.UserList;
import com.ibm.cloud.platform_services.user_management.v1.model.UserProfile;
import com.ibm.cloud.platform_services.user_management.v1.model.UserSettings;
import com.ibm.cloud.platform_services.user_management.v1.utils.TestUtilities;
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
 * Unit test class for the UserManagement service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore({"javax.net.ssl.*", "org.mockito.*"})
public class UserManagementTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected UserManagement userManagementService;

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

    userManagementService = UserManagement.newInstance(serviceName);
    String url = server.url("/").toString();
    userManagementService.setServiceUrl(url);
  }

  /**
  * Negative Test - construct the service with a null authenticator.
  */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";

    new UserManagement(serviceName, null);
  }

  @Test
  public void testGetUserSettingsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"language\": \"language\", \"notification_language\": \"notificationLanguage\", \"allowed_ip_addresses\": \"32.96.110.50,172.16.254.1\", \"self_manage\": true}";
    String getUserSettingsPath = "/v2/accounts/testString/users/testString/settings";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetUserSettingsOptions model
    GetUserSettingsOptions getUserSettingsOptionsModel = new GetUserSettingsOptions.Builder()
    .accountId("testString")
    .iamId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<UserSettings> response = userManagementService.getUserSettings(getUserSettingsOptionsModel).execute();
    assertNotNull(response);
    UserSettings responseObj = response.getResult();
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
    assertEquals(parsedPath, getUserSettingsPath);
  }

  // Test the getUserSettings operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetUserSettingsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    userManagementService.getUserSettings(null).execute();
  }

  @Test
  public void testUpdateUserSettingsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"language\": \"language\", \"notification_language\": \"notificationLanguage\", \"allowed_ip_addresses\": \"32.96.110.50,172.16.254.1\", \"self_manage\": true}";
    String updateUserSettingsPath = "/v2/accounts/testString/users/testString/settings";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateUserSettingsOptions model
    UpdateUserSettingsOptions updateUserSettingsOptionsModel = new UpdateUserSettingsOptions.Builder()
    .accountId("testString")
    .iamId("testString")
    .language("testString")
    .notificationLanguage("testString")
    .allowedIpAddresses("32.96.110.50,172.16.254.1")
    .selfManage(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<UserSettings> response = userManagementService.updateUserSettings(updateUserSettingsOptionsModel).execute();
    assertNotNull(response);
    UserSettings responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateUserSettingsPath);
  }

  // Test the updateUserSettings operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateUserSettingsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    userManagementService.updateUserSettings(null).execute();
  }

  @Test
  public void testListUsersWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"total_results\": 12, \"limit\": 5, \"first_url\": \"firstUrl\", \"next_url\": \"nextUrl\", \"resources\": [{\"id\": \"id\", \"iam_id\": \"iamId\", \"realm\": \"realm\", \"user_id\": \"userId\", \"firstname\": \"firstname\", \"lastname\": \"lastname\", \"state\": \"state\", \"email\": \"email\", \"phonenumber\": \"phonenumber\", \"altphonenumber\": \"altphonenumber\", \"photo\": \"photo\", \"account_id\": \"accountId\"}]}";
    String listUsersPath = "/v2/accounts/testString/users";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListUsersOptions model
    ListUsersOptions listUsersOptionsModel = new ListUsersOptions.Builder()
    .accountId("testString")
    .state("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<UserList> response = userManagementService.listUsers(listUsersOptionsModel).execute();
    assertNotNull(response);
    UserList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("state"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listUsersPath);
  }

  // Test the listUsers operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListUsersNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    userManagementService.listUsers(null).execute();
  }

  @Test
  public void testInviteUsersWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"total_results\": 12, \"limit\": 5, \"first_url\": \"firstUrl\", \"next_url\": \"nextUrl\", \"resources\": [{\"id\": \"id\", \"iam_id\": \"iamId\", \"realm\": \"realm\", \"user_id\": \"userId\", \"firstname\": \"firstname\", \"lastname\": \"lastname\", \"state\": \"state\", \"email\": \"email\", \"phonenumber\": \"phonenumber\", \"altphonenumber\": \"altphonenumber\", \"photo\": \"photo\", \"account_id\": \"accountId\"}]}";
    String inviteUsersPath = "/v2/accounts/testString/users";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(202)
    .setBody(mockResponseBody));

    constructClientService();

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
    .attributes(new java.util.ArrayList<Attribute>(java.util.Arrays.asList(attributeModel)))
    .build();

    // Construct an instance of the InviteUserIamPolicy model
    InviteUserIamPolicy inviteUserIamPolicyModel = new InviteUserIamPolicy.Builder()
    .type("testString")
    .roles(new java.util.ArrayList<Role>(java.util.Arrays.asList(roleModel)))
    .resources(new java.util.ArrayList<Resource>(java.util.Arrays.asList(resourceModel)))
    .build();

    // Construct an instance of the InviteUsersOptions model
    InviteUsersOptions inviteUsersOptionsModel = new InviteUsersOptions.Builder()
    .accountId("testString")
    .users(new java.util.ArrayList<InviteUser>(java.util.Arrays.asList(inviteUserModel)))
    .iamPolicy(new java.util.ArrayList<InviteUserIamPolicy>(java.util.Arrays.asList(inviteUserIamPolicyModel)))
    .accessGroups(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<UserList> response = userManagementService.inviteUsers(inviteUsersOptionsModel).execute();
    assertNotNull(response);
    UserList responseObj = response.getResult();
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
    assertEquals(parsedPath, inviteUsersPath);
  }

  // Test the inviteUsers operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testInviteUsersNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    userManagementService.inviteUsers(null).execute();
  }

  @Test
  public void testGetUserProfileWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"iam_id\": \"iamId\", \"realm\": \"realm\", \"user_id\": \"userId\", \"firstname\": \"firstname\", \"lastname\": \"lastname\", \"state\": \"state\", \"email\": \"email\", \"phonenumber\": \"phonenumber\", \"altphonenumber\": \"altphonenumber\", \"photo\": \"photo\", \"account_id\": \"accountId\"}";
    String getUserProfilePath = "/v2/accounts/testString/users/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetUserProfileOptions model
    GetUserProfileOptions getUserProfileOptionsModel = new GetUserProfileOptions.Builder()
    .accountId("testString")
    .iamId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<UserProfile> response = userManagementService.getUserProfile(getUserProfileOptionsModel).execute();
    assertNotNull(response);
    UserProfile responseObj = response.getResult();
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
    assertEquals(parsedPath, getUserProfilePath);
  }

  // Test the getUserProfile operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetUserProfileNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    userManagementService.getUserProfile(null).execute();
  }

  @Test
  public void testUpdateUserProfilesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String updateUserProfilesPath = "/v2/accounts/testString/users/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateUserProfilesOptions model
    UpdateUserProfilesOptions updateUserProfilesOptionsModel = new UpdateUserProfilesOptions.Builder()
    .accountId("testString")
    .iamId("testString")
    .firstname("testString")
    .lastname("testString")
    .state("testString")
    .email("testString")
    .phonenumber("testString")
    .altphonenumber("testString")
    .photo("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = userManagementService.updateUserProfiles(updateUserProfilesOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateUserProfilesPath);
  }

  // Test the updateUserProfiles operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateUserProfilesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    userManagementService.updateUserProfiles(null).execute();
  }

  @Test
  public void testRemoveUsersWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String removeUsersPath = "/v2/accounts/testString/users/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the RemoveUsersOptions model
    RemoveUsersOptions removeUsersOptionsModel = new RemoveUsersOptions.Builder()
    .accountId("testString")
    .iamId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = userManagementService.removeUsers(removeUsersOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, removeUsersPath);
  }

  // Test the removeUsers operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRemoveUsersNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    userManagementService.removeUsers(null).execute();
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
    userManagementService = null;
  }
}