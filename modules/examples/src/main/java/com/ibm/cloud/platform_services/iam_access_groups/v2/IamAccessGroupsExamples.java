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

package com.ibm.cloud.platform_services.iam_access_groups.v2;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AccountSettings;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddAccessGroupRuleOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddGroupMembersRequestMembersItem;
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
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RuleConditions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RulesList;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.UpdateAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.UpdateAccountSettingsOptions;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

//
// This file provides an example of how to use the IAM Access Groups service.
//
// The following configuration properties are assumed to be defined:
//
// IAM_ACCESS_GROUPS_URL=<service url>
// IAM_ACCESS_GROUPS_AUTHTYPE=iam
// IAM_ACCESS_GROUPS_APIKEY=<your iam apikey>
// IAM_ACCESS_GROUPS_AUTH_URL=<IAM token service URL - omit this if using the production environment>
// IAM_ACCESS_GROUPS_TEST_ACCOUNT_ID=<id of an account used for testing>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
public class IamAccessGroupsExamples {
  private static final Logger logger = LoggerFactory.getLogger(IamAccessGroupsExamples.class);
  protected IamAccessGroupsExamples() { }

  private static String testAccountId = null;
  private static String testGroupId = null;
  private static String testGroupETag = null;
  private static String testClaimRuleId = null;
  private static String testClaimRuleETag = null;

  static {
      System.setProperty("IBM_CREDENTIALS_FILE", "../../iam_access_groups.env");
  }

  public static void main(String[] args) throws Exception {
    IamAccessGroups service = IamAccessGroups.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(IamAccessGroups.DEFAULT_SERVICE_NAME);
    testAccountId = config.get("TEST_ACCOUNT_ID");

    try {
      System.out.println("createAccessGroup() result:");

      // begin-create_access_group

      CreateAccessGroupOptions createAccessGroupOptions = new CreateAccessGroupOptions.Builder()
        .accountId(testAccountId)
        .name("Managers")
        .description("Group for managers")
        .build();

      Response<Group> response = service.createAccessGroup(createAccessGroupOptions).execute();
      Group group = response.getResult();

      System.out.println(group);

      // end-create_access_group

      testGroupId = group.getId();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getAccessGroup() result:");

      // begin-get_access_group

      GetAccessGroupOptions getAccessGroupOptions = new GetAccessGroupOptions.Builder()
        .accessGroupId(testGroupId)
        .build();

      Response<Group> response = service.getAccessGroup(getAccessGroupOptions).execute();
      Group group = response.getResult();

      System.out.println(group);

      // end-get_access_group

      testGroupETag = response.getHeaders().values("Etag").get(0);
   } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("updateAccessGroup() result:");

      // begin-update_access_group

      UpdateAccessGroupOptions updateAccessGroupOptions = new UpdateAccessGroupOptions.Builder()
        .accessGroupId(testGroupId)
        .ifMatch(testGroupETag)
        .name("Awesome Managers")
        .description("Group for awesome managers")
        .build();

      Response<Group> response = service.updateAccessGroup(updateAccessGroupOptions).execute();
      Group group = response.getResult();

      System.out.println(group);

      // end-update_access_group

    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listAccessGroups() result:");

      // begin-list_access_groups

      ListAccessGroupsOptions listAccessGroupsOptions = new ListAccessGroupsOptions.Builder()
        .accountId(testAccountId)
        .build();

      Response<GroupsList> response = service.listAccessGroups(listAccessGroupsOptions).execute();
      GroupsList groupsList = response.getResult();

      System.out.println(groupsList);

      // end-list_access_groups

    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("addMembersToAccessGroup() result:");

      // begin-add_members_to_access_group

      AddGroupMembersRequestMembersItem member1 = new AddGroupMembersRequestMembersItem.Builder()
        .iamId("IBMid-user1")
        .type("user")
        .build();
      AddGroupMembersRequestMembersItem member2 = new AddGroupMembersRequestMembersItem.Builder()
        .iamId("iam-ServiceId-123")
        .type("service")
        .build();
      AddMembersToAccessGroupOptions addMembersToAccessGroupOptions = new AddMembersToAccessGroupOptions.Builder()
        .accessGroupId(testGroupId)
        .addMembers(member1)
        .addMembers(member2)
        .build();
      Response<AddGroupMembersResponse> response = service.addMembersToAccessGroup(addMembersToAccessGroupOptions).execute();
      AddGroupMembersResponse addGroupMembersResponse = response.getResult();

      System.out.println(addGroupMembersResponse);

      // end-add_members_to_access_group

    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {

      // begin-is_member_of_access_group

      IsMemberOfAccessGroupOptions isMemberOfAccessGroupOptions = new IsMemberOfAccessGroupOptions.Builder()
        .accessGroupId(testGroupId)
        .iamId("IBMid-user1")
        .build();

      Response<Void> response = service.isMemberOfAccessGroup(isMemberOfAccessGroupOptions).execute();

      // end-is_member_of_access_group

      System.out.printf("isMemberOfAccessGroup() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listAccessGroupMembers() result:");

      // begin-list_access_group_members

      ListAccessGroupMembersOptions listAccessGroupMembersOptions = new ListAccessGroupMembersOptions.Builder()
        .accessGroupId(testGroupId)
        .build();

      Response<GroupMembersList> response = service.listAccessGroupMembers(listAccessGroupMembersOptions).execute();
      GroupMembersList groupMembersList = response.getResult();

      System.out.println(groupMembersList);

      // end-list_access_group_members

    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {

      // begin-remove_member_from_access_group

      RemoveMemberFromAccessGroupOptions removeMemberFromAccessGroupOptions = new RemoveMemberFromAccessGroupOptions.Builder()
        .accessGroupId(testGroupId)
        .iamId("IBMid-user1")
        .build();

      Response<Void> response = service.removeMemberFromAccessGroup(removeMemberFromAccessGroupOptions).execute();

      // end-remove_member_from_access_group

      System.out.printf("removeMemberFromAccessGroup() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("removeMembersFromAccessGroup() result:");

      // begin-remove_members_from_access_group

      RemoveMembersFromAccessGroupOptions removeMembersFromAccessGroupOptions = new RemoveMembersFromAccessGroupOptions.Builder()
        .accessGroupId(testGroupId)
        .addMembers("iam-ServiceId-123")
        .build();

      Response<DeleteGroupBulkMembersResponse> response = service.removeMembersFromAccessGroup(removeMembersFromAccessGroupOptions).execute();
      DeleteGroupBulkMembersResponse deleteGroupBulkMembersResponse = response.getResult();

      System.out.println(deleteGroupBulkMembersResponse);

      // end-remove_members_from_access_group

    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("addMemberToMultipleAccessGroups() result:");

      // begin-add_member_to_multiple_access_groups

      AddMemberToMultipleAccessGroupsOptions addMemberToMultipleAccessGroupsOptions = new AddMemberToMultipleAccessGroupsOptions.Builder()
        .accountId(testAccountId)
        .iamId("IBMid-user1")
        .type("user")
        .addGroups(testGroupId)
        .build();

      Response<AddMembershipMultipleGroupsResponse> response = service.addMemberToMultipleAccessGroups(addMemberToMultipleAccessGroupsOptions).execute();
      AddMembershipMultipleGroupsResponse addMembershipMultipleGroupsResponse = response.getResult();

      System.out.println(addMembershipMultipleGroupsResponse);

      // end-add_member_to_multiple_access_groups

    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("removeMemberFromAllAccessGroups() result:");

      // begin-remove_member_from_all_access_groups

      RemoveMemberFromAllAccessGroupsOptions removeMemberFromAllAccessGroupsOptions = new RemoveMemberFromAllAccessGroupsOptions.Builder()
        .accountId(testAccountId)
        .iamId("IBMid-user1")
        .build();

      Response<DeleteFromAllGroupsResponse> response = service.removeMemberFromAllAccessGroups(removeMemberFromAllAccessGroupsOptions).execute();
      DeleteFromAllGroupsResponse deleteFromAllGroupsResponse = response.getResult();

      System.out.println(deleteFromAllGroupsResponse);

      // end-remove_member_from_all_access_groups

    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("addAccessGroupRule() result:");

      // begin-add_access_group_rule

      RuleConditions ruleConditionsModel = new RuleConditions.Builder()
        .claim("isManager")
        .operator("EQUALS")
        .value("true")
        .build();
      AddAccessGroupRuleOptions addAccessGroupRuleOptions = new AddAccessGroupRuleOptions.Builder()
        .accessGroupId(testGroupId)
        .name("Manager group rule")
        .expiration(12)
        .realmName("https://idp.example.org/SAML2")
        .addConditions(ruleConditionsModel)
        .build();

      Response<Rule> response = service.addAccessGroupRule(addAccessGroupRuleOptions).execute();
      Rule rule = response.getResult();

      System.out.println(rule);

      // end-add_access_group_rule

      testClaimRuleId = rule.getId();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getAccessGroupRule() result:");

      // begin-get_access_group_rule

      GetAccessGroupRuleOptions getAccessGroupRuleOptions = new GetAccessGroupRuleOptions.Builder()
        .accessGroupId(testGroupId)
        .ruleId(testClaimRuleId)
        .build();

      Response<Rule> response = service.getAccessGroupRule(getAccessGroupRuleOptions).execute();
      Rule rule = response.getResult();

      System.out.println(rule);

      // end-get_access_group_rule

      testClaimRuleETag = response.getHeaders().values("Etag").get(0);
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("replaceAccessGroupRule() result:");

      // begin-replace_access_group_rule

      RuleConditions ruleConditionsModel = new RuleConditions.Builder()
        .claim("isManager")
        .operator("EQUALS")
        .value("true")
        .build();
      ReplaceAccessGroupRuleOptions replaceAccessGroupRuleOptions = new ReplaceAccessGroupRuleOptions.Builder()
        .accessGroupId(testGroupId)
        .ruleId(testClaimRuleId)
        .ifMatch(testClaimRuleETag)
        .name("Manager group rule")
        .expiration(24)
        .realmName("https://idp.example.org/SAML2\"")
        .addConditions(ruleConditionsModel)
        .build();

      Response<Rule> response = service.replaceAccessGroupRule(replaceAccessGroupRuleOptions).execute();
      Rule rule = response.getResult();

      System.out.println(rule);

      // end-replace_access_group_rule

    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listAccessGroupRules() result:");

      // begin-list_access_group_rules

      ListAccessGroupRulesOptions listAccessGroupRulesOptions = new ListAccessGroupRulesOptions.Builder()
        .accessGroupId(testGroupId)
        .build();

      Response<RulesList> response = service.listAccessGroupRules(listAccessGroupRulesOptions).execute();
      RulesList rulesList = response.getResult();

      System.out.println(rulesList);

      // end-list_access_group_rules

    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {

      // begin-remove_access_group_rule

      RemoveAccessGroupRuleOptions removeAccessGroupRuleOptions = new RemoveAccessGroupRuleOptions.Builder()
        .accessGroupId(testGroupId)
        .ruleId(testClaimRuleId)
        .build();

      Response<Void> response = service.removeAccessGroupRule(removeAccessGroupRuleOptions).execute();

      // end-remove_access_group_rule

      System.out.printf("removeAccessGroupRule() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getAccountSettings() result:");

      // begin-get_account_settings

      GetAccountSettingsOptions getAccountSettingsOptions = new GetAccountSettingsOptions.Builder()
        .accountId(testAccountId)
        .build();

      Response<AccountSettings> response = service.getAccountSettings(getAccountSettingsOptions).execute();
      AccountSettings accountSettings = response.getResult();

      System.out.println(accountSettings);

      // end-get_account_settings

    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("updateAccountSettings() result:");

      // begin-update_account_settings

      UpdateAccountSettingsOptions updateAccountSettingsOptions = new UpdateAccountSettingsOptions.Builder()
        .accountId(testAccountId)
        .publicAccessEnabled(true)
        .build();

      Response<AccountSettings> response = service.updateAccountSettings(updateAccountSettingsOptions).execute();
      AccountSettings accountSettings = response.getResult();

      System.out.println(accountSettings);

      // end-update_account_settings

    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {

      // begin-delete_access_group

      DeleteAccessGroupOptions deleteAccessGroupOptions = new DeleteAccessGroupOptions.Builder()
        .accessGroupId(testGroupId)
        .build();

      Response<Void> response = service.deleteAccessGroup(deleteAccessGroupOptions).execute();

      // end-delete_access_group

      System.out.printf("deleteAccessGroup() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

  }
}
