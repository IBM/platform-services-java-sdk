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

/*
 * IBM OpenAPI SDK Code Generator Version: 99-SNAPSHOT-79b061f4-20200806-065240
 */

package com.ibm.cloud.platform_services.user_management.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.platform_services.user_management.v1.model.GetUserProfileOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.GetUserSettingsOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.InviteUsersOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.ListUsersOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.RemoveUsersOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.UpdateUserProfilesOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.UpdateUserSettingsOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.UserList;
import com.ibm.cloud.platform_services.user_management.v1.model.UserProfile;
import com.ibm.cloud.platform_services.user_management.v1.model.UserSettings;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Manage the lifecycle of your users using User Management APIs.
 *
 * @version v1
 */
public class UserManagement extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "user_management";

  public static final String DEFAULT_SERVICE_URL = "https://user-management.cloud.ibm.com";

 /**
   * Class method which constructs an instance of the `UserManagement` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `UserManagement` client using external configuration
   */
  public static UserManagement newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `UserManagement` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `UserManagement` client using external configuration
   */
  public static UserManagement newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    UserManagement service = new UserManagement(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `UserManagement` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public UserManagement(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * Get user settings.
   *
   * Retrieve a user's settings by the user's IAM ID. You can use the IAM service token or a user token for
   * authorization. To use this method, the requesting user or service ID must have the viewer, editor, or administrator
   * role on the User Management service. &lt;br/&gt;&lt;br/&gt;The user settings have several fields. The `language`
   * field is the language setting for the user interface display language. The `notification_language` field is the
   * language setting for phone and email notifications. The `allowed_ip_addresses` field specifies a list of IP
   * addresses that the user can log in and perform operations from as described in [Allowing specific IP addresses for
   * a user](/docs/account?topic=account-ips). For information about the `self_manage` field, review information about
   * the [user-managed login setting](/docs/account?topic=account-types).
   *
   * @param getUserSettingsOptions the {@link GetUserSettingsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link UserSettings}
   */
  public ServiceCall<UserSettings> getUserSettings(GetUserSettingsOptions getUserSettingsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getUserSettingsOptions,
      "getUserSettingsOptions cannot be null");
    String[] pathSegments = { "v2/accounts", "users", "settings" };
    String[] pathParameters = { getUserSettingsOptions.accountId(), getUserSettingsOptions.iamId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("user_management", "v1", "getUserSettings");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<UserSettings> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<UserSettings>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Partially update user settings.
   *
   * Update a user's settings by the user's IAM ID. You can use the IAM service token or a user token for authorization.
   * To fully use this method, the user or service ID must have the editor or administrator role on the User Management
   * service. Without these roles, a user can update only their own `language` or `notification_language` fields. If
   * `self_manage` is `true`, the user can also update the `allowed_ip_addresses` field.
   *
   * @param updateUserSettingsOptions the {@link UpdateUserSettingsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link UserSettings}
   */
  public ServiceCall<UserSettings> updateUserSettings(UpdateUserSettingsOptions updateUserSettingsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateUserSettingsOptions,
      "updateUserSettingsOptions cannot be null");
    String[] pathSegments = { "v2/accounts", "users", "settings" };
    String[] pathParameters = { updateUserSettingsOptions.accountId(), updateUserSettingsOptions.iamId() };
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("user_management", "v1", "updateUserSettings");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (updateUserSettingsOptions.language() != null) {
      contentJson.addProperty("language", updateUserSettingsOptions.language());
    }
    if (updateUserSettingsOptions.notificationLanguage() != null) {
      contentJson.addProperty("notification_language", updateUserSettingsOptions.notificationLanguage());
    }
    if (updateUserSettingsOptions.allowedIpAddresses() != null) {
      contentJson.addProperty("allowed_ip_addresses", updateUserSettingsOptions.allowedIpAddresses());
    }
    if (updateUserSettingsOptions.selfManage() != null) {
      contentJson.addProperty("self_manage", updateUserSettingsOptions.selfManage());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<UserSettings> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<UserSettings>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List users.
   *
   * Retrieve users in the account. You can use the IAM service token or a user token for authorization. To use this
   * method, the requesting user or service ID must have at least the viewer, editor, or administrator role on the User
   * Management service. If unrestricted view is enabled, the user can see all users in the same account without an IAM
   * role. If restricted view is enabled and user has the viewer, editor, or administrator role on the user management
   * service, the API returns all users in the account. If unrestricted view is enabled and the user does not have these
   * roles, the API returns only the current user. Users are returned in a paginated list with a default limit of 100
   * users. You can iterate through all users by following the `next_url` field.
   *
   * @param listUsersOptions the {@link ListUsersOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link UserList}
   */
  public ServiceCall<UserList> listUsers(ListUsersOptions listUsersOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listUsersOptions,
      "listUsersOptions cannot be null");
    String[] pathSegments = { "v2/accounts", "users" };
    String[] pathParameters = { listUsersOptions.accountId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("user_management", "v1", "listUsers");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listUsersOptions.state() != null) {
      builder.query("state", listUsersOptions.state());
    }
    ResponseConverter<UserList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<UserList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Invite users.
   *
   * Invite users to the account. You must use a user token for authorization. Service IDs can't invite users to the
   * account. To use this method, the requesting user must have the editor or administrator role on the User Management
   * service. For more information, see the [Inviting users](/docs/account?topic=account-iamuserinv) documentation. You
   * can specify the user account role and the corresponding IAM policy information in the request body.
   * &lt;br/&gt;&lt;br/&gt;When you invite a user to an account, the user is initially created in the `PROCESSING`
   * state. After the user is successfully created, all specified permissions are configured, and the activation email
   * is sent, the invited user is transitioned to the `PENDING` state. When the invited user clicks the activation email
   * and creates and confirms their IBM Cloud account, the user is transitioned to `ACTIVE` state. If the user email is
   * already verified, no email is generated.
   *
   * @param inviteUsersOptions the {@link InviteUsersOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link UserList}
   */
  public ServiceCall<UserList> inviteUsers(InviteUsersOptions inviteUsersOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(inviteUsersOptions,
      "inviteUsersOptions cannot be null");
    String[] pathSegments = { "v2/accounts", "users" };
    String[] pathParameters = { inviteUsersOptions.accountId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("user_management", "v1", "inviteUsers");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (inviteUsersOptions.users() != null) {
      contentJson.add("users", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(inviteUsersOptions.users()));
    }
    if (inviteUsersOptions.iamPolicy() != null) {
      contentJson.add("iam_policy", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(inviteUsersOptions.iamPolicy()));
    }
    if (inviteUsersOptions.accessGroups() != null) {
      contentJson.add("access_groups", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(inviteUsersOptions.accessGroups()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<UserList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<UserList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get user profile.
   *
   * Retrieve a user's profile by the user's IAM ID in your account. You can use the IAM service token or a user token
   * for authorization. To use this method, the requesting user or service ID must have at least the viewer, editor, or
   * administrator role on the User Management service.
   *
   * @param getUserProfileOptions the {@link GetUserProfileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link UserProfile}
   */
  public ServiceCall<UserProfile> getUserProfile(GetUserProfileOptions getUserProfileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getUserProfileOptions,
      "getUserProfileOptions cannot be null");
    String[] pathSegments = { "v2/accounts", "users" };
    String[] pathParameters = { getUserProfileOptions.accountId(), getUserProfileOptions.iamId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("user_management", "v1", "getUserProfile");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<UserProfile> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<UserProfile>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Partially update user profiles.
   *
   * Partially update a user's profile by user's IAM ID. You can use the IAM service token or a user token for
   * authorization. To use this method, the requesting user or service ID must have at least the editor or administrator
   * role on the User Management service. A user or service ID with these roles can change a user's state between
   * `ACTIVE`, `VPN_ONLY`, or `DISABLED_CLASSIC_INFRASTRUCTURE`, but they can't change the state to `PROCESSING` or
   * `PENDING` because these are system states. For other request body fields, a user can update their own profile
   * without having User Management service permissions.
   *
   * @param updateUserProfilesOptions the {@link UpdateUserProfilesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> updateUserProfiles(UpdateUserProfilesOptions updateUserProfilesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateUserProfilesOptions,
      "updateUserProfilesOptions cannot be null");
    String[] pathSegments = { "v2/accounts", "users" };
    String[] pathParameters = { updateUserProfilesOptions.accountId(), updateUserProfilesOptions.iamId() };
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("user_management", "v1", "updateUserProfiles");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    final JsonObject contentJson = new JsonObject();
    if (updateUserProfilesOptions.firstname() != null) {
      contentJson.addProperty("firstname", updateUserProfilesOptions.firstname());
    }
    if (updateUserProfilesOptions.lastname() != null) {
      contentJson.addProperty("lastname", updateUserProfilesOptions.lastname());
    }
    if (updateUserProfilesOptions.state() != null) {
      contentJson.addProperty("state", updateUserProfilesOptions.state());
    }
    if (updateUserProfilesOptions.email() != null) {
      contentJson.addProperty("email", updateUserProfilesOptions.email());
    }
    if (updateUserProfilesOptions.phonenumber() != null) {
      contentJson.addProperty("phonenumber", updateUserProfilesOptions.phonenumber());
    }
    if (updateUserProfilesOptions.altphonenumber() != null) {
      contentJson.addProperty("altphonenumber", updateUserProfilesOptions.altphonenumber());
    }
    if (updateUserProfilesOptions.photo() != null) {
      contentJson.addProperty("photo", updateUserProfilesOptions.photo());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Remove users.
   *
   * Remove users from an account by user's IAM ID. You must use a user token for authorization. Service IDs can't
   * remove users from an account. To use this method, the requesting user must have the editor or administrator role on
   * the User Management service. For more information, see the [Removing users](/docs/account?topic=account-remove)
   * documentation.
   *
   * @param removeUsersOptions the {@link RemoveUsersOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> removeUsers(RemoveUsersOptions removeUsersOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(removeUsersOptions,
      "removeUsersOptions cannot be null");
    String[] pathSegments = { "v2/accounts", "users" };
    String[] pathParameters = { removeUsersOptions.accountId(), removeUsersOptions.iamId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("user_management", "v1", "removeUsers");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

}
