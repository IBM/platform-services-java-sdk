/*
 * (C) Copyright IBM Corp. 2021, 2022.
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import com.ibm.cloud.platform_services.user_management.v1.model.UserProfile;
import com.ibm.cloud.platform_services.user_management.v1.model.UserSettings;
import com.ibm.cloud.platform_services.user_management.v1.model.UsersPager;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.sdk.core.util.GsonSingleton;

//
// This file provides an example of how to use the User Management service.
//
// The following configuration properties are assumed to be defined:
//
// USER_MANAGEMENT_URL=<service url>
// USER_MANAGEMENT_AUTHTYPE=iam
// USER_MANAGEMENT_AUTH_URL=<IAM token service URL - omit this if using the production environment>
// USER_MANAGEMENT_APIKEY=<IAM apikey>
// USER_MANAGEMENT_ACCOUNT_ID=<account ID>
// USER_MANAGEMENT_USER_ID=<user ID>
// USER_MANAGEMENT_MEMBER_EMAIL=<member email to invite>
// USER_MANAGEMENT_VIEWER_ROLE_ID=<viewer role ID>
// USER_MANAGEMENT_ACCESS_GROUP_ID=<access group ID>
// # alternateService
// USER_MANAGEMENT_ADMIN_URL=<service url>
// USER_MANAGEMENT_ADMIN_AUTHTYPE=iam
// USER_MANAGEMENT_ADMIN_AUTH_URL=<IAM token service URL - omit this if using the production environment>
// USER_MANAGEMENT_ADMIN_APIKEY=<IAM apikey>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
public class UserManagementExamples {
  private static final Logger logger = LoggerFactory.getLogger(UserManagementExamples.class);
  protected UserManagementExamples() { }

  private static String accountId;
  private static String userId;
  private static String memberEmail;
  private static String viewerRoleId;
  private static String accessGroupId;

  private static String deleteUserId;

  static {
    System.setProperty("IBM_CREDENTIALS_FILE", "../../user_management.env");
  }

  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    UserManagement userManagementService = UserManagement.newInstance(UserManagement.DEFAULT_SERVICE_NAME);
    UserManagement userManagementServiceAdmin = UserManagement.newInstance("USER_MANAGEMENT_ADMIN");

    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(UserManagement.DEFAULT_SERVICE_NAME);

    accountId = config.get("ACCOUNT_ID");
    userId = config.get("USER_ID");
    memberEmail = config.get("MEMBER_EMAIL");
    viewerRoleId = config.get("VIEWER_ROLE_ID");
    accessGroupId = config.get("ACCESS_GROUP_ID");

    try {
      System.out.println("inviteUsers() result:");

      // begin-invite_users
      InviteUser inviteUserModel = new InviteUser.Builder()
              .email(memberEmail)
              .accountRole("Member")
              .build();

      Role roleModel = new Role.Builder()
              .roleId(viewerRoleId)
              .build();

      Attribute attributeModel = new Attribute.Builder()
              .name("accountId")
              .value(accountId)
              .build();

      Attribute attributeModel2 = new Attribute.Builder()
              .name("resourceGroupId")
              .value("*")
              .build();

      Resource resourceModel = new Resource.Builder()
              .addAttributes(attributeModel)
              .addAttributes(attributeModel2)
              .build();

      InviteUserIamPolicy inviteUserIamPolicyModel = new InviteUserIamPolicy.Builder()
              .type("access")
              .addRoles(roleModel)
              .addResources(resourceModel)
              .build();

      InviteUsersOptions inviteUsersOptions = new InviteUsersOptions.Builder()
              .accountId(accountId)
              .addUsers(inviteUserModel)
              .addIamPolicy(inviteUserIamPolicyModel)
              .addAccessGroups(accessGroupId)
              .build();

      Response<InvitedUserList> response = userManagementServiceAdmin.inviteUsers(inviteUsersOptions).execute();
      InvitedUserList invitedUserList = response.getResult();

      System.out.println(invitedUserList);

      // end-invite_users

      deleteUserId = invitedUserList.getResources().get(0).getId();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listUsers() result:");
      // begin-list_users
      ListUsersOptions listUsersOptions = new ListUsersOptions.Builder()
        .accountId(accountId)
        .build();

      UsersPager pager = new UsersPager(userManagementService, listUsersOptions);
      List<UserProfile> allResults = new ArrayList<>();
      while (pager.hasNext()) {
        List<UserProfile> nextPage = pager.getNext();
        allResults.addAll(nextPage);
      }

      System.out.println(GsonSingleton.getGson().toJson(allResults));
      // end-list_users
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {

      // begin-remove_user

      RemoveUserOptions removeUserOptions = new RemoveUserOptions.Builder()
        .accountId(accountId)
        .iamId(deleteUserId)
        .build();

      Response<Void> response = userManagementService.removeUser(removeUserOptions).execute();

      // end-remove_user

      System.out.printf("removeUser() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getUserProfile() result:");

      // begin-get_user_profile

      GetUserProfileOptions getUserProfileOptions = new GetUserProfileOptions.Builder()
        .accountId(accountId)
        .iamId(userId)
        .build();

      Response<UserProfile> response = userManagementService.getUserProfile(getUserProfileOptions).execute();
      UserProfile userProfile = response.getResult();

      System.out.println(userProfile);

      // end-get_user_profile

    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {

      // begin-update_user_profile

      UpdateUserProfileOptions updateUserProfileOptions = new UpdateUserProfileOptions.Builder()
        .accountId(accountId)
        .iamId(userId)
        .phonenumber("123456789")
        .build();

      Response<Void> response = userManagementService.updateUserProfile(updateUserProfileOptions).execute();

      // end-update_user_profile

      System.out.printf("updateUserProfile() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getUserSettings() result:");

      // begin-get_user_settings

      GetUserSettingsOptions getUserSettingsOptions = new GetUserSettingsOptions.Builder()
        .accountId(accountId)
        .iamId(userId)
        .build();

      Response<UserSettings> response = userManagementService.getUserSettings(getUserSettingsOptions).execute();
      UserSettings userSettings = response.getResult();

      System.out.println(userSettings);

      // end-get_user_settings

    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {

      // begin-update_user_settings

      UpdateUserSettingsOptions updateUserSettingsOptions = new UpdateUserSettingsOptions.Builder()
        .accountId(accountId)
        .iamId(userId)
        .selfManage(true)
        .allowedIpAddresses("192.168.0.2,192.168.0.3")
        .build();

      Response<Void> response = userManagementService.updateUserSettings(updateUserSettingsOptions).execute();

      // end-update_user_settings

      System.out.printf("updateUserSettings() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

  }
}
