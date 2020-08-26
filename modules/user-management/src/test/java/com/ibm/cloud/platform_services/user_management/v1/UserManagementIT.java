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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
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
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import org.json.JSONObject;
import org.json.JSONArray;


/**
 * Integration test class for the UserManagement service.
 */
public class UserManagementIT extends SdkIntegrationTestBase {
  public UserManagement service = null;
  public UserManagement alternateService = null;
  public static Map<String, String> config = null;
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();
  public String userId = null;
  /**
   * This method provides our config filename to the base class.
   */

  public String getConfigFilename() {
    return "../../user_management.env";
  }

  @BeforeClass
  public void constructService() {
    // Ask super if we should skip the tests.
    if (skipTests()) {
      return;
    }

    service = UserManagement.newInstance("USERMGMT1");
    assertNotNull(service);
    assertNotNull(service.getServiceUrl());

    alternateService = UserManagement.newInstance("USERMGMT2");
    assertNotNull(alternateService);
    assertNotNull(alternateService.getServiceUrl());

    // Load up our test-specific config properties.
    config = CredentialUtils.getServiceProperties("USERMGMT1");
    assertNotNull(config);
    assertFalse(config.isEmpty());
    assertEquals(service.getServiceUrl(), config.get("URL"));

    System.out.println("Setup complete.");
  }

  @Test
  public void testGetUserSettings() throws Exception {
    try {
      GetUserSettingsOptions getUserSettingsOptions = new GetUserSettingsOptions.Builder()
      .accountId("1aa434630b594b8a88b961a44c9eb2a9")
      .iamId("IBMid-550008BJPR")
      .build();

      // Invoke operation
      Response<UserSettings> response = service.getUserSettings(getUserSettingsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      UserSettings userSettingsResult = response.getResult();

      assertNotNull(userSettingsResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testUpdateUserSettings() throws Exception {
    try {
      UpdateUserSettingsOptions updateUserSettingsOptions = new UpdateUserSettingsOptions.Builder()
      .accountId("1aa434630b594b8a88b961a44c9eb2a9")
      .iamId("IBMid-550008BJPR")
      .language("testString")
      .notificationLanguage("testString")
      .allowedIpAddresses("32.96.110.50,172.16.254.1")
      .selfManage(true)
      .build();

      // Invoke operation
      Response<UserSettings> response = service.updateUserSettings(updateUserSettingsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
      UserSettings userSettingsResult = response.getResult();
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testListUsers() throws Exception {
    try {
      ListUsersOptions listUsersOptions = new ListUsersOptions.Builder()
      .accountId("1aa434630b594b8a88b961a44c9eb2a9")
      .state("ACTIVE")
      .build();

      // Invoke operation
      Response<UserList> response = service.listUsers(listUsersOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      UserList userListResult = response.getResult();

      assertNotNull(userListResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testInviteUsers() throws Exception {
    try {
      InviteUser inviteUserModel = new InviteUser.Builder()
      .email("aminttest+linked_account_owner_11@mail.test.ibm.com")
      .accountRole("Member")
      .build();

      Role roleModel = new Role.Builder()
      .roleId("crn:v1:bluemix:public:iam::::role:Viewer")
      .build();

      Attribute attributeModel = new Attribute.Builder()
      .name("accountId")
      .value("1aa434630b594b8a88b961a44c9eb2a9")
      .build();

      Attribute attributeModel2 = new Attribute.Builder()
      .name("resourceGroupId")
      .value("*")
      .build();

       Attribute[] attributeArray = new Attribute[]{attributeModel, attributeModel2};

      Resource resourceModel = new Resource.Builder()
      .attributes(new java.util.ArrayList<Attribute>(java.util.Arrays.asList(attributeArray)))
      .build();

      InviteUserIamPolicy inviteUserIamPolicyModel = new InviteUserIamPolicy.Builder()
      .type("access")
      .roles(new java.util.ArrayList<Role>(java.util.Arrays.asList(roleModel)))
      .resources(new java.util.ArrayList<Resource>(java.util.Arrays.asList(resourceModel)))
      .build();

      InviteUsersOptions inviteUsersOptions = new InviteUsersOptions.Builder()
      .accountId("1aa434630b594b8a88b961a44c9eb2a9")
      .users(new java.util.ArrayList<InviteUser>(java.util.Arrays.asList(inviteUserModel)))
      .iamPolicy(new java.util.ArrayList<InviteUserIamPolicy>(java.util.Arrays.asList(inviteUserIamPolicyModel)))
      .accessGroups(new java.util.ArrayList<String>(java.util.Arrays.asList("AccessGroupId-51675919-2bd7-4ce3-86e4-5faff8065574")))
      .build();

      // Invoke operation
      Response<UserList> response = alternateService.inviteUsers(inviteUsersOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 202);

      UserList userListResult = response.getResult();

      assertNotNull(userListResult);

      List<UserProfile> profile = userListResult.getResources();
      userId = profile.get(0).getId();

    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetUserProfile() throws Exception {
    try {
      GetUserProfileOptions getUserProfileOptions = new GetUserProfileOptions.Builder()
      .accountId("1aa434630b594b8a88b961a44c9eb2a9")
      .iamId("IBMid-550008BJPR")
      .build();

      // Invoke operation
      Response<UserProfile> response = service.getUserProfile(getUserProfileOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      UserProfile userProfileResult = response.getResult();

      assertNotNull(userProfileResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testUpdateUserProfiles() throws Exception {
    try {
      UpdateUserProfilesOptions updateUserProfilesOptions = new UpdateUserProfilesOptions.Builder()
      .accountId("1aa434630b594b8a88b961a44c9eb2a9")
      .iamId("IBMid-550008BJPR")
      .firstname("testString")
      .lastname("testString")
      .state("ACTIVE")
      .email("do_not_delete_user_without_iam_policy_stage@mail.test.ibm.com")
      .phonenumber("testString")
      .altphonenumber("testString")
      .photo("testString")
      .build();

      // Invoke operation
      Response<Void> response = service.updateUserProfiles(updateUserProfilesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testRemoveUsers() throws Exception {
    try {
      RemoveUsersOptions removeUsersOptions = new RemoveUsersOptions.Builder()
      .accountId("1aa434630b594b8a88b961a44c9eb2a9")
      .iamId(userId)
      .build();

      // Invoke operation
      Response<Void> response = service.removeUsers(removeUsersOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @AfterClass
  public void tearDown() {
    // Add any clean up logic here
    System.out.println("Clean up complete.");
  }
 }
