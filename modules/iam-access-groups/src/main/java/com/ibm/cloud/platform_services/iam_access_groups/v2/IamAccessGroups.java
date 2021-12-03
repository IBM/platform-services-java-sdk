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

/*
 * IBM OpenAPI SDK Code Generator Version: 3.43.0-49eab5c7-20211117-152138
 */

package com.ibm.cloud.platform_services.iam_access_groups.v2;

import com.google.gson.JsonObject;
import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AccountSettings;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddAccessGroupRuleOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddGroupMembersResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddMemberToMultipleAccessGroupsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddMembersToAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddMembershipMultipleGroupsResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.CreateAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.DeleteAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.DeleteFromAllGroupsResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.DeleteGroupBulkMembersResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GetAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GetAccessGroupRuleOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GetAccountSettingsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.Group;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GroupMembersList;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GroupsList;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.IsMemberOfAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListAccessGroupMembersOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListAccessGroupRulesOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListAccessGroupsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RemoveAccessGroupRuleOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RemoveMemberFromAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RemoveMemberFromAllAccessGroupsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RemoveMembersFromAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ReplaceAccessGroupRuleOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.Rule;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RulesList;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.UpdateAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.UpdateAccountSettingsOptions;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * The IAM Access Groups API allows for the management of access groups (Create, Read, Update, Delete) as well as the
 * management of memberships and rules within the group container.
 *
 * API Version: 2.0
 */
public class IamAccessGroups extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "iam_access_groups";

  public static final String DEFAULT_SERVICE_URL = "https://iam.cloud.ibm.com";

 /**
   * Class method which constructs an instance of the `IamAccessGroups` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `IamAccessGroups` client using external configuration
   */
  public static IamAccessGroups newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `IamAccessGroups` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `IamAccessGroups` client using external configuration
   */
  public static IamAccessGroups newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    IamAccessGroups service = new IamAccessGroups(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `IamAccessGroups` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public IamAccessGroups(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * Create an access group.
   *
   * Create a new access group to assign multiple users and service ids to multiple policies. The group will be created
   * in the account specified by the `account_id` parameter. The group name is a required field, but a description is
   * optional. Because the group's name does not have to be unique, it is possible to create multiple groups with the
   * same name.
   *
   * @param createAccessGroupOptions the {@link CreateAccessGroupOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Group}
   */
  public ServiceCall<Group> createAccessGroup(CreateAccessGroupOptions createAccessGroupOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createAccessGroupOptions,
      "createAccessGroupOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/groups"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_access_groups", "v2", "createAccessGroup");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createAccessGroupOptions.transactionId() != null) {
      builder.header("Transaction-Id", createAccessGroupOptions.transactionId());
    }
    builder.query("account_id", String.valueOf(createAccessGroupOptions.accountId()));
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", createAccessGroupOptions.name());
    if (createAccessGroupOptions.description() != null) {
      contentJson.addProperty("description", createAccessGroupOptions.description());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Group> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Group>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List access groups.
   *
   * This API lists access groups within an account. Parameters for pagination and sorting can be used to filter the
   * results. The `account_id` query parameter determines which account to retrieve groups from. Only the groups you
   * have access to are returned (either because of a policy on a specific group or account level access (admin, editor,
   * or viewer)). There may be more groups in the account that aren't shown if you lack the aforementioned permissions.
   *
   * @param listAccessGroupsOptions the {@link ListAccessGroupsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link GroupsList}
   */
  public ServiceCall<GroupsList> listAccessGroups(ListAccessGroupsOptions listAccessGroupsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listAccessGroupsOptions,
      "listAccessGroupsOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/groups"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_access_groups", "v2", "listAccessGroups");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listAccessGroupsOptions.transactionId() != null) {
      builder.header("Transaction-Id", listAccessGroupsOptions.transactionId());
    }
    builder.query("account_id", String.valueOf(listAccessGroupsOptions.accountId()));
    if (listAccessGroupsOptions.iamId() != null) {
      builder.query("iam_id", String.valueOf(listAccessGroupsOptions.iamId()));
    }
    if (listAccessGroupsOptions.limit() != null) {
      builder.query("limit", String.valueOf(listAccessGroupsOptions.limit()));
    }
    if (listAccessGroupsOptions.offset() != null) {
      builder.query("offset", String.valueOf(listAccessGroupsOptions.offset()));
    }
    if (listAccessGroupsOptions.sort() != null) {
      builder.query("sort", String.valueOf(listAccessGroupsOptions.sort()));
    }
    if (listAccessGroupsOptions.showFederated() != null) {
      builder.query("show_federated", String.valueOf(listAccessGroupsOptions.showFederated()));
    }
    if (listAccessGroupsOptions.hidePublicAccess() != null) {
      builder.query("hide_public_access", String.valueOf(listAccessGroupsOptions.hidePublicAccess()));
    }
    ResponseConverter<GroupsList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<GroupsList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get an access group.
   *
   * Retrieve an access group by its `access_group_id`. Only the groups data is returned (group name, description,
   * account_id, ...), not membership or rule information. A revision number is returned in the `ETag` header, which is
   * needed when updating the access group.
   *
   * @param getAccessGroupOptions the {@link GetAccessGroupOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Group}
   */
  public ServiceCall<Group> getAccessGroup(GetAccessGroupOptions getAccessGroupOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getAccessGroupOptions,
      "getAccessGroupOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("access_group_id", getAccessGroupOptions.accessGroupId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/groups/{access_group_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_access_groups", "v2", "getAccessGroup");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getAccessGroupOptions.transactionId() != null) {
      builder.header("Transaction-Id", getAccessGroupOptions.transactionId());
    }
    if (getAccessGroupOptions.showFederated() != null) {
      builder.query("show_federated", String.valueOf(getAccessGroupOptions.showFederated()));
    }
    ResponseConverter<Group> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Group>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update an access group.
   *
   * Update the group name or description of an existing access group using this API. An `If-Match` header must be
   * populated with the group's most recent revision number (which can be acquired in the `Get an access group` API).
   *
   * @param updateAccessGroupOptions the {@link UpdateAccessGroupOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Group}
   */
  public ServiceCall<Group> updateAccessGroup(UpdateAccessGroupOptions updateAccessGroupOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateAccessGroupOptions,
      "updateAccessGroupOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("access_group_id", updateAccessGroupOptions.accessGroupId());
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/groups/{access_group_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_access_groups", "v2", "updateAccessGroup");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("If-Match", updateAccessGroupOptions.ifMatch());
    if (updateAccessGroupOptions.transactionId() != null) {
      builder.header("Transaction-Id", updateAccessGroupOptions.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    if (updateAccessGroupOptions.name() != null) {
      contentJson.addProperty("name", updateAccessGroupOptions.name());
    }
    if (updateAccessGroupOptions.description() != null) {
      contentJson.addProperty("description", updateAccessGroupOptions.description());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Group> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Group>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete an access group.
   *
   * This API is used for deleting an access group. If the access group has no members or rules associated with it, the
   * group and its policies will be deleted. However, if rules or members do exist, set the `force` parameter to true to
   * delete the group as well as its associated members, rules, and policies.
   *
   * @param deleteAccessGroupOptions the {@link DeleteAccessGroupOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteAccessGroup(DeleteAccessGroupOptions deleteAccessGroupOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteAccessGroupOptions,
      "deleteAccessGroupOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("access_group_id", deleteAccessGroupOptions.accessGroupId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/groups/{access_group_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_access_groups", "v2", "deleteAccessGroup");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (deleteAccessGroupOptions.transactionId() != null) {
      builder.header("Transaction-Id", deleteAccessGroupOptions.transactionId());
    }
    if (deleteAccessGroupOptions.force() != null) {
      builder.query("force", String.valueOf(deleteAccessGroupOptions.force()));
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Check membership in an access group.
   *
   * This HEAD operation determines if a given `iam_id` is present in a group. No response body is returned with this
   * request. If the membership exists, a `204 - No Content` status code is returned. If the membership or the group
   * does not exist, a `404 - Not Found` status code is returned.
   *
   * @param isMemberOfAccessGroupOptions the {@link IsMemberOfAccessGroupOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> isMemberOfAccessGroup(IsMemberOfAccessGroupOptions isMemberOfAccessGroupOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(isMemberOfAccessGroupOptions,
      "isMemberOfAccessGroupOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("access_group_id", isMemberOfAccessGroupOptions.accessGroupId());
    pathParamsMap.put("iam_id", isMemberOfAccessGroupOptions.iamId());
    RequestBuilder builder = RequestBuilder.head(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/groups/{access_group_id}/members/{iam_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_access_groups", "v2", "isMemberOfAccessGroup");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (isMemberOfAccessGroupOptions.transactionId() != null) {
      builder.header("Transaction-Id", isMemberOfAccessGroupOptions.transactionId());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add members to an access group.
   *
   * Use this API to add users (`IBMid-...`) or service IDs (`iam-ServiceId-...`) to an access group. Any member added
   * gains access to resources defined in the group's policies. To revoke a given user's access, simply remove them from
   * the group. There is no limit to the number of members one group can have, but each `iam_id` can only be added to 50
   * groups. Additionally, this API request payload can add up to 50 members per call.
   *
   * @param addMembersToAccessGroupOptions the {@link AddMembersToAccessGroupOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AddGroupMembersResponse}
   */
  public ServiceCall<AddGroupMembersResponse> addMembersToAccessGroup(AddMembersToAccessGroupOptions addMembersToAccessGroupOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(addMembersToAccessGroupOptions,
      "addMembersToAccessGroupOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("access_group_id", addMembersToAccessGroupOptions.accessGroupId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/groups/{access_group_id}/members", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_access_groups", "v2", "addMembersToAccessGroup");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (addMembersToAccessGroupOptions.transactionId() != null) {
      builder.header("Transaction-Id", addMembersToAccessGroupOptions.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    if (addMembersToAccessGroupOptions.members() != null) {
      contentJson.add("members", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(addMembersToAccessGroupOptions.members()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<AddGroupMembersResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AddGroupMembersResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List access group members.
   *
   * List all members of a given group using this API. Parameters for pagination and sorting can be used to filter the
   * results. The most useful query parameter may be the `verbose` flag. If `verbose=true`, user and service ID names
   * will be retrieved for each `iam_id`. If performance is a concern, leave the `verbose` parameter off so that name
   * information does not get retrieved.
   *
   * @param listAccessGroupMembersOptions the {@link ListAccessGroupMembersOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link GroupMembersList}
   */
  public ServiceCall<GroupMembersList> listAccessGroupMembers(ListAccessGroupMembersOptions listAccessGroupMembersOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listAccessGroupMembersOptions,
      "listAccessGroupMembersOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("access_group_id", listAccessGroupMembersOptions.accessGroupId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/groups/{access_group_id}/members", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_access_groups", "v2", "listAccessGroupMembers");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listAccessGroupMembersOptions.transactionId() != null) {
      builder.header("Transaction-Id", listAccessGroupMembersOptions.transactionId());
    }
    if (listAccessGroupMembersOptions.limit() != null) {
      builder.query("limit", String.valueOf(listAccessGroupMembersOptions.limit()));
    }
    if (listAccessGroupMembersOptions.offset() != null) {
      builder.query("offset", String.valueOf(listAccessGroupMembersOptions.offset()));
    }
    if (listAccessGroupMembersOptions.type() != null) {
      builder.query("type", String.valueOf(listAccessGroupMembersOptions.type()));
    }
    if (listAccessGroupMembersOptions.verbose() != null) {
      builder.query("verbose", String.valueOf(listAccessGroupMembersOptions.verbose()));
    }
    if (listAccessGroupMembersOptions.sort() != null) {
      builder.query("sort", String.valueOf(listAccessGroupMembersOptions.sort()));
    }
    ResponseConverter<GroupMembersList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<GroupMembersList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete member from an access group.
   *
   * Remove one member from a group using this API. If the operation is successful, only a `204 - No Content` response
   * with no body is returned. However, if any error occurs, the standard error format will be returned.
   *
   * @param removeMemberFromAccessGroupOptions the {@link RemoveMemberFromAccessGroupOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> removeMemberFromAccessGroup(RemoveMemberFromAccessGroupOptions removeMemberFromAccessGroupOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(removeMemberFromAccessGroupOptions,
      "removeMemberFromAccessGroupOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("access_group_id", removeMemberFromAccessGroupOptions.accessGroupId());
    pathParamsMap.put("iam_id", removeMemberFromAccessGroupOptions.iamId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/groups/{access_group_id}/members/{iam_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_access_groups", "v2", "removeMemberFromAccessGroup");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (removeMemberFromAccessGroupOptions.transactionId() != null) {
      builder.header("Transaction-Id", removeMemberFromAccessGroupOptions.transactionId());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete members from an access group.
   *
   * Remove multiple members from a group using this API. On a successful call, this API will always return 207. It is
   * the caller's responsibility to iterate across the body to determine successful deletion of each member. This API
   * request payload can delete up to 50 members per call.
   *
   * @param removeMembersFromAccessGroupOptions the {@link RemoveMembersFromAccessGroupOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DeleteGroupBulkMembersResponse}
   */
  public ServiceCall<DeleteGroupBulkMembersResponse> removeMembersFromAccessGroup(RemoveMembersFromAccessGroupOptions removeMembersFromAccessGroupOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(removeMembersFromAccessGroupOptions,
      "removeMembersFromAccessGroupOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("access_group_id", removeMembersFromAccessGroupOptions.accessGroupId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/groups/{access_group_id}/members/delete", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_access_groups", "v2", "removeMembersFromAccessGroup");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (removeMembersFromAccessGroupOptions.transactionId() != null) {
      builder.header("Transaction-Id", removeMembersFromAccessGroupOptions.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    if (removeMembersFromAccessGroupOptions.members() != null) {
      contentJson.add("members", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(removeMembersFromAccessGroupOptions.members()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<DeleteGroupBulkMembersResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DeleteGroupBulkMembersResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete member from all access groups.
   *
   * This API removes a given member from every group they are a member of within the specified account. By using one
   * operation, you can revoke one member's access to all access groups in the account. If a partial failure occurs on
   * deletion, the response will be shown in the body.
   *
   * @param removeMemberFromAllAccessGroupsOptions the {@link RemoveMemberFromAllAccessGroupsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DeleteFromAllGroupsResponse}
   */
  public ServiceCall<DeleteFromAllGroupsResponse> removeMemberFromAllAccessGroups(RemoveMemberFromAllAccessGroupsOptions removeMemberFromAllAccessGroupsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(removeMemberFromAllAccessGroupsOptions,
      "removeMemberFromAllAccessGroupsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("iam_id", removeMemberFromAllAccessGroupsOptions.iamId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/groups/_allgroups/members/{iam_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_access_groups", "v2", "removeMemberFromAllAccessGroups");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (removeMemberFromAllAccessGroupsOptions.transactionId() != null) {
      builder.header("Transaction-Id", removeMemberFromAllAccessGroupsOptions.transactionId());
    }
    builder.query("account_id", String.valueOf(removeMemberFromAllAccessGroupsOptions.accountId()));
    ResponseConverter<DeleteFromAllGroupsResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DeleteFromAllGroupsResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add member to multiple access groups.
   *
   * This API will add a member to multiple access groups in an account. The limit of how many groups that can be in the
   * request is 50. The response is a list of results that show if adding the member to each group was successful or
   * not.
   *
   * @param addMemberToMultipleAccessGroupsOptions the {@link AddMemberToMultipleAccessGroupsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AddMembershipMultipleGroupsResponse}
   */
  public ServiceCall<AddMembershipMultipleGroupsResponse> addMemberToMultipleAccessGroups(AddMemberToMultipleAccessGroupsOptions addMemberToMultipleAccessGroupsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(addMemberToMultipleAccessGroupsOptions,
      "addMemberToMultipleAccessGroupsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("iam_id", addMemberToMultipleAccessGroupsOptions.iamId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/groups/_allgroups/members/{iam_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_access_groups", "v2", "addMemberToMultipleAccessGroups");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (addMemberToMultipleAccessGroupsOptions.transactionId() != null) {
      builder.header("Transaction-Id", addMemberToMultipleAccessGroupsOptions.transactionId());
    }
    builder.query("account_id", String.valueOf(addMemberToMultipleAccessGroupsOptions.accountId()));
    final JsonObject contentJson = new JsonObject();
    if (addMemberToMultipleAccessGroupsOptions.type() != null) {
      contentJson.addProperty("type", addMemberToMultipleAccessGroupsOptions.type());
    }
    if (addMemberToMultipleAccessGroupsOptions.groups() != null) {
      contentJson.add("groups", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(addMemberToMultipleAccessGroupsOptions.groups()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<AddMembershipMultipleGroupsResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AddMembershipMultipleGroupsResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create rule for an access group.
   *
   * Rules can be used to dynamically add users to an access group. If a user's SAML assertions match the rule's
   * conditions during login, the user will be dynamically added to the group. The duration of the user's access to the
   * group is determined by the `expiration` field. After access expires, the user will need to log in again to regain
   * access. Note that the condition's value field must be a stringified JSON value. [Consult this documentation for
   * further explanation of dynamic rules.](/docs/iam/accessgroup_rules.html#rules).
   *
   * @param addAccessGroupRuleOptions the {@link AddAccessGroupRuleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Rule}
   */
  public ServiceCall<Rule> addAccessGroupRule(AddAccessGroupRuleOptions addAccessGroupRuleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(addAccessGroupRuleOptions,
      "addAccessGroupRuleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("access_group_id", addAccessGroupRuleOptions.accessGroupId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/groups/{access_group_id}/rules", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_access_groups", "v2", "addAccessGroupRule");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (addAccessGroupRuleOptions.transactionId() != null) {
      builder.header("Transaction-Id", addAccessGroupRuleOptions.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("expiration", addAccessGroupRuleOptions.expiration());
    contentJson.addProperty("realm_name", addAccessGroupRuleOptions.realmName());
    contentJson.add("conditions", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(addAccessGroupRuleOptions.conditions()));
    if (addAccessGroupRuleOptions.name() != null) {
      contentJson.addProperty("name", addAccessGroupRuleOptions.name());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Rule> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Rule>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List access group rules.
   *
   * This API lists all rules in a given access group. Because only a few rules are created on each group, there is no
   * pagination or sorting support on this API.
   *
   * @param listAccessGroupRulesOptions the {@link ListAccessGroupRulesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link RulesList}
   */
  public ServiceCall<RulesList> listAccessGroupRules(ListAccessGroupRulesOptions listAccessGroupRulesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listAccessGroupRulesOptions,
      "listAccessGroupRulesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("access_group_id", listAccessGroupRulesOptions.accessGroupId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/groups/{access_group_id}/rules", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_access_groups", "v2", "listAccessGroupRules");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listAccessGroupRulesOptions.transactionId() != null) {
      builder.header("Transaction-Id", listAccessGroupRulesOptions.transactionId());
    }
    ResponseConverter<RulesList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<RulesList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get an access group rule.
   *
   * Retrieve a rule from an access group. A revision number is returned in the `ETag` header, which is needed when
   * updating the rule.
   *
   * @param getAccessGroupRuleOptions the {@link GetAccessGroupRuleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Rule}
   */
  public ServiceCall<Rule> getAccessGroupRule(GetAccessGroupRuleOptions getAccessGroupRuleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getAccessGroupRuleOptions,
      "getAccessGroupRuleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("access_group_id", getAccessGroupRuleOptions.accessGroupId());
    pathParamsMap.put("rule_id", getAccessGroupRuleOptions.ruleId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/groups/{access_group_id}/rules/{rule_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_access_groups", "v2", "getAccessGroupRule");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getAccessGroupRuleOptions.transactionId() != null) {
      builder.header("Transaction-Id", getAccessGroupRuleOptions.transactionId());
    }
    ResponseConverter<Rule> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Rule>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Replace an access group rule.
   *
   * Update the body of an existing rule using this API. An `If-Match` header must be populated with the rule's most
   * recent revision number (which can be acquired in the `Get an access group rule` API).
   *
   * @param replaceAccessGroupRuleOptions the {@link ReplaceAccessGroupRuleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Rule}
   */
  public ServiceCall<Rule> replaceAccessGroupRule(ReplaceAccessGroupRuleOptions replaceAccessGroupRuleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceAccessGroupRuleOptions,
      "replaceAccessGroupRuleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("access_group_id", replaceAccessGroupRuleOptions.accessGroupId());
    pathParamsMap.put("rule_id", replaceAccessGroupRuleOptions.ruleId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/groups/{access_group_id}/rules/{rule_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_access_groups", "v2", "replaceAccessGroupRule");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("If-Match", replaceAccessGroupRuleOptions.ifMatch());
    if (replaceAccessGroupRuleOptions.transactionId() != null) {
      builder.header("Transaction-Id", replaceAccessGroupRuleOptions.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("expiration", replaceAccessGroupRuleOptions.expiration());
    contentJson.addProperty("realm_name", replaceAccessGroupRuleOptions.realmName());
    contentJson.add("conditions", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceAccessGroupRuleOptions.conditions()));
    if (replaceAccessGroupRuleOptions.name() != null) {
      contentJson.addProperty("name", replaceAccessGroupRuleOptions.name());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Rule> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Rule>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete an access group rule.
   *
   * Remove one rule from a group using this API. If the operation is successful, only a `204 - No Content` response
   * with no body is returned. However, if any error occurs, the standard error format will be returned.
   *
   * @param removeAccessGroupRuleOptions the {@link RemoveAccessGroupRuleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> removeAccessGroupRule(RemoveAccessGroupRuleOptions removeAccessGroupRuleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(removeAccessGroupRuleOptions,
      "removeAccessGroupRuleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("access_group_id", removeAccessGroupRuleOptions.accessGroupId());
    pathParamsMap.put("rule_id", removeAccessGroupRuleOptions.ruleId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/groups/{access_group_id}/rules/{rule_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_access_groups", "v2", "removeAccessGroupRule");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (removeAccessGroupRuleOptions.transactionId() != null) {
      builder.header("Transaction-Id", removeAccessGroupRuleOptions.transactionId());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get account settings.
   *
   * Retrieve the access groups settings for a specific account.
   *
   * @param getAccountSettingsOptions the {@link GetAccountSettingsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AccountSettings}
   */
  public ServiceCall<AccountSettings> getAccountSettings(GetAccountSettingsOptions getAccountSettingsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getAccountSettingsOptions,
      "getAccountSettingsOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/groups/settings"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_access_groups", "v2", "getAccountSettings");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getAccountSettingsOptions.transactionId() != null) {
      builder.header("Transaction-Id", getAccountSettingsOptions.transactionId());
    }
    builder.query("account_id", String.valueOf(getAccountSettingsOptions.accountId()));
    ResponseConverter<AccountSettings> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AccountSettings>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update account settings.
   *
   * Update the access groups settings for a specific account. Note: When the `public_access_enabled` setting is set to
   * false, all policies within the account attached to the Public Access group will be deleted. Only set
   * `public_access_enabled` to false if you are sure that you want those policies to be removed.
   *
   * @param updateAccountSettingsOptions the {@link UpdateAccountSettingsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AccountSettings}
   */
  public ServiceCall<AccountSettings> updateAccountSettings(UpdateAccountSettingsOptions updateAccountSettingsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateAccountSettingsOptions,
      "updateAccountSettingsOptions cannot be null");
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/groups/settings"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("iam_access_groups", "v2", "updateAccountSettings");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (updateAccountSettingsOptions.transactionId() != null) {
      builder.header("Transaction-Id", updateAccountSettingsOptions.transactionId());
    }
    builder.query("account_id", String.valueOf(updateAccountSettingsOptions.accountId()));
    final JsonObject contentJson = new JsonObject();
    if (updateAccountSettingsOptions.publicAccessEnabled() != null) {
      contentJson.addProperty("public_access_enabled", updateAccountSettingsOptions.publicAccessEnabled());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<AccountSettings> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AccountSettings>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}
