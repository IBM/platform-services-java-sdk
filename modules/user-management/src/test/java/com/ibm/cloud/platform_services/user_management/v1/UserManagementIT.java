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

import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Integration test class for the UserManagement service.
 */
public class UserManagementIT extends SdkIntegrationTestBase {
  public UserManagement service = null;
  public static Map<String, String> config = null;
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();
  /**
   * This method provides our config filename to the base class.
   */

  public String getConfigFilename() {
    return "../../user_management_v1.env";
  }

  @BeforeClass
  public void constructService() {
    // Ask super if we should skip the tests.
    if (skipTests()) {
      return;
    }

    service = UserManagement.newInstance();
    assertNotNull(service);
    assertNotNull(service.getServiceUrl());

    // Load up our test-specific config properties.
    config = CredentialUtils.getServiceProperties(UserManagement.DEFAULT_SERVICE_NAME);
    assertNotNull(config);
    assertFalse(config.isEmpty());
    assertEquals(service.getServiceUrl(), config.get("URL"));

    System.out.println("Setup complete.");
  }

  @Test
  public void testGetUserSettings() throws Exception {
    try {
      GetUserSettingsOptions getUserSettingsOptions = new GetUserSettingsOptions.Builder()
      .accountId("testString")
      .iamId("testString")
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
      .accountId("testString")
      .iamId("testString")
      .language("testString")
      .notificationLanguage("testString")
      .allowedIpAddresses("32.96.110.50,172.16.254.1")
      .selfManage(true)
      .build();

      // Invoke operation
      Response<UserSettings> response = service.updateUserSettings(updateUserSettingsOptions).execute();
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
  public void testListUsers() throws Exception {
    try {
      ListUsersOptions listUsersOptions = new ListUsersOptions.Builder()
      .accountId("testString")
      .state("testString")
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
      .email("testString")
      .accountRole("testString")
      .build();

      Role roleModel = new Role.Builder()
      .roleId("testString")
      .build();

      Attribute attributeModel = new Attribute.Builder()
      .name("testString")
      .value("testString")
      .build();

      Resource resourceModel = new Resource.Builder()
      .attributes(new java.util.ArrayList<Attribute>(java.util.Arrays.asList(attributeModel)))
      .build();

      InviteUserIamPolicy inviteUserIamPolicyModel = new InviteUserIamPolicy.Builder()
      .roles(new java.util.ArrayList<Role>(java.util.Arrays.asList(roleModel)))
      .resources(new java.util.ArrayList<Resource>(java.util.Arrays.asList(resourceModel)))
      .build();

      InviteUsersOptions inviteUsersOptions = new InviteUsersOptions.Builder()
      .accountId("testString")
      .users(new java.util.ArrayList<InviteUser>(java.util.Arrays.asList(inviteUserModel)))
      .iamPolicy(new java.util.ArrayList<InviteUserIamPolicy>(java.util.Arrays.asList(inviteUserIamPolicyModel)))
      .accessGroups(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .build();

      // Invoke operation
      Response<UserList> response = service.inviteUsers(inviteUsersOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 202);

      UserList userListResult = response.getResult();

      assertNotNull(userListResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetUserProfile() throws Exception {
    try {
      GetUserProfileOptions getUserProfileOptions = new GetUserProfileOptions.Builder()
      .accountId("testString")
      .iamId("testString")
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

      // Invoke operation
      Response<Void> response = service.updateUserProfiles(updateUserProfilesOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);

      Void Result = response.getResult();
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testRemoveUsers() throws Exception {
    try {
      RemoveUsersOptions removeUsersOptions = new RemoveUsersOptions.Builder()
      .accountId("testString")
      .iamId("testString")
      .build();

      // Invoke operation
      Response<Void> response = service.removeUsers(removeUsersOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);

      Void Result = response.getResult();
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
