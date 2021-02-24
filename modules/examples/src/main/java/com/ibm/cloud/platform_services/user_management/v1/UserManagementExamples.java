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

package com.ibm.cloud.platform_services.user_management.v1;

import com.ibm.cloud.platform_services.user_management.v1.model.GetUserProfileOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.GetUserSettingsOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.InviteUsersOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.InvitedUserList;
import com.ibm.cloud.platform_services.user_management.v1.model.ListUsersOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.RemoveUserOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.UpdateUserProfileOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.UpdateUserSettingsOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.UserList;
import com.ibm.cloud.platform_services.user_management.v1.model.UserProfile;
import com.ibm.cloud.platform_services.user_management.v1.model.UserSettings;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserManagementExamples {
  private static final Logger logger = LoggerFactory.getLogger(UserManagementExamples.class);
  protected UserManagementExamples() { }

  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    UserManagement service = UserManagement.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(UserManagement.DEFAULT_SERVICE_NAME);

    try {
      // begin-list_users
      ListUsersOptions listUsersOptions = new ListUsersOptions.Builder()
        .accountId("testString")
        .build();

      Response<UserList> response = service.listUsers(listUsersOptions).execute();
      UserList userList = response.getResult();

      System.out.println(userList);
      // end-list_users
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-invite_users
      InviteUsersOptions inviteUsersOptions = new InviteUsersOptions.Builder()
        .accountId("testString")
        .build();

      Response<InvitedUserList> response = service.inviteUsers(inviteUsersOptions).execute();
      InvitedUserList invitedUserList = response.getResult();

      System.out.println(invitedUserList);
      // end-invite_users
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_user_profile
      GetUserProfileOptions getUserProfileOptions = new GetUserProfileOptions.Builder()
        .accountId("testString")
        .iamId("testString")
        .build();

      Response<UserProfile> response = service.getUserProfile(getUserProfileOptions).execute();
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
        .accountId("testString")
        .iamId("testString")
        .build();

      service.updateUserProfile(updateUserProfileOptions).execute();
      // end-update_user_profile
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_user_settings
      GetUserSettingsOptions getUserSettingsOptions = new GetUserSettingsOptions.Builder()
        .accountId("testString")
        .iamId("testString")
        .build();

      Response<UserSettings> response = service.getUserSettings(getUserSettingsOptions).execute();
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
        .accountId("testString")
        .iamId("testString")
        .build();

      service.updateUserSettings(updateUserSettingsOptions).execute();
      // end-update_user_settings
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-remove_user
      RemoveUserOptions removeUserOptions = new RemoveUserOptions.Builder()
        .accountId("testString")
        .iamId("testString")
        .build();

      service.removeUser(removeUserOptions).execute();
      // end-remove_user
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

  }
}
