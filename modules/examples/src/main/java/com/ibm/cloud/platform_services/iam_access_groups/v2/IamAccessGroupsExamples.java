/*
 * (C) Copyright IBM Corp. 2023.
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

import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AccessActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AccessGroupMembersPager;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AccessGroupRequest;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AccessGroupsPager;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AccountSettings;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddAccessGroupRuleOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddGroupMembersRequestMembersItem;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddGroupMembersResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddMemberToMultipleAccessGroupsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddMembersToAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddMembershipMultipleGroupsResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.Assertions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AssertionsActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AssertionsRule;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.CommitTemplateOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.Conditions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.CreateAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.CreateAssignmentOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.CreateTemplateOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.CreateTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.DeleteAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.DeleteAssignmentOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.DeleteFromAllGroupsResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.DeleteGroupBulkMembersResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.DeleteTemplateOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.DeleteTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GetAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GetAccessGroupRuleOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GetAccountSettingsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GetAssignmentOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GetLatestTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GetTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.Group;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GroupActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GroupTemplate;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.IsMemberOfAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListAccessGroupMembersOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListAccessGroupRulesOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListAccessGroupsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListAssignmentsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListGroupMembersResponseMember;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListTemplateAssignmentResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListTemplateVersionResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListTemplateVersionsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListTemplatesOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.Members;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.MembersActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.PolicyTemplates;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RemoveAccessGroupRuleOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RemoveMemberFromAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RemoveMemberFromAllAccessGroupsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RemoveMembersFromAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ReplaceAccessGroupRuleOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.Rule;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RuleActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RuleConditions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RulesList;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.TemplateAssignmentResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.TemplateAssignmentVerboseResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.TemplateResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.TemplateVersionResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.TemplateVersionsPager;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.TemplatesPager;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.UpdateAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.UpdateAccountSettingsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.UpdateAssignmentOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.UpdateTemplateVersionOptions;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
// IAM_ACCESS_GROUPS_TEST_PROFILE_ID=<id of an profile used for testing>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
public class IamAccessGroupsExamples {
  private static final Logger logger = LoggerFactory.getLogger(IamAccessGroupsExamples.class);
  protected IamAccessGroupsExamples() { }

  private static String testAccountId = null;
  private static String testProfileId = null;
  private static String testGroupId = null;
  private static String testGroupETag = null;
  private static String testClaimRuleId = null;
  private static String testClaimRuleETag = null;
  private static String testPolicyTemplateId = null;
  private static String testTemplateId = null;
  private static String testTemplateETag = null;
  private static String testLatestVersionETag = null;
  private static String testAccountGroupId = null;
  private static String testAssignmentId = null;
  private static String testAssignmentETag = null;

  static {
      System.setProperty("IBM_CREDENTIALS_FILE", "../../iam_access_groups_v2.env");
  }

  public static void main(String[] args) throws Exception {
    IamAccessGroups iamAccessGroupsService = IamAccessGroups.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(IamAccessGroups.DEFAULT_SERVICE_NAME);
    testAccountId = config.get("TEST_ACCOUNT_ID");
    testProfileId = config.get("TEST_PROFILE_ID");
    testPolicyTemplateId = config.get("TEST_POLICY_TEMPLATE_ID");
    testAccountGroupId = config.get("TEST_ACCOUNT_GROUP_ID");

    try {
      System.out.println("createAccessGroup() result:");

      // begin-create_access_group

      CreateAccessGroupOptions createAccessGroupOptions = new CreateAccessGroupOptions.Builder()
        .accountId(testAccountId)
        .name("Managers")
        .description("Group for managers")
        .build();

      Response<Group> response = iamAccessGroupsService.createAccessGroup(createAccessGroupOptions).execute();
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

      Response<Group> response = iamAccessGroupsService.getAccessGroup(getAccessGroupOptions).execute();
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

      Response<Group> response = iamAccessGroupsService.updateAccessGroup(updateAccessGroupOptions).execute();
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

      AccessGroupsPager pager = new AccessGroupsPager(iamAccessGroupsService, listAccessGroupsOptions);
      List<Group> allResults = new ArrayList<>();
      while (pager.hasNext()) {
        List<Group> nextPage = pager.getNext();
        allResults.addAll(nextPage);
      }

      System.out.println(GsonSingleton.getGson().toJson(allResults));
      // end-list_access_groups
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
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
        AddGroupMembersRequestMembersItem member3 = new AddGroupMembersRequestMembersItem.Builder()
        .iamId(testProfileId)
        .type("profile")
        .build();
      AddMembersToAccessGroupOptions addMembersToAccessGroupOptions = new AddMembersToAccessGroupOptions.Builder()
        .accessGroupId(testGroupId)
        .addMembers(member1)
        .addMembers(member2)
        .addMembers(member3)
        .build();
      Response<AddGroupMembersResponse> response = iamAccessGroupsService.addMembersToAccessGroup(addMembersToAccessGroupOptions).execute();
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

      Response<Void> response = iamAccessGroupsService.isMemberOfAccessGroup(isMemberOfAccessGroupOptions).execute();

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
          .accessGroupId(testGroupId).build();

      AccessGroupMembersPager pager = new AccessGroupMembersPager(iamAccessGroupsService,
          listAccessGroupMembersOptions);
      List<ListGroupMembersResponseMember> allResults = new ArrayList<>();
      while (pager.hasNext()) {
        List<ListGroupMembersResponseMember> nextPage = pager.getNext();
        allResults.addAll(nextPage);
      }

      System.out.println(GsonSingleton.getGson().toJson(allResults));
      // end-list_access_group_members
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s", e.getStatusCode(),
          e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {

      // begin-remove_member_from_access_group

      RemoveMemberFromAccessGroupOptions removeMemberFromAccessGroupOptions = new RemoveMemberFromAccessGroupOptions.Builder()
        .accessGroupId(testGroupId)
        .iamId("IBMid-user1")
        .build();

      Response<Void> response = iamAccessGroupsService.removeMemberFromAccessGroup(removeMemberFromAccessGroupOptions).execute();

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

      Response<DeleteGroupBulkMembersResponse> response = iamAccessGroupsService.removeMembersFromAccessGroup(removeMembersFromAccessGroupOptions).execute();
      DeleteGroupBulkMembersResponse deleteGroupBulkMembersResponse = response.getResult();

      System.out.println(deleteGroupBulkMembersResponse);

      // end-remove_members_from_access_group

    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("removeMembersFromAccessGroup() result:");

      // begin-remove_members_from_access_group

      RemoveMembersFromAccessGroupOptions removeMembersFromAccessGroupOptions = new RemoveMembersFromAccessGroupOptions.Builder()
        .accessGroupId(testGroupId)
        .addMembers(testProfileId)
        .build();

      Response<DeleteGroupBulkMembersResponse> response = iamAccessGroupsService.removeMembersFromAccessGroup(removeMembersFromAccessGroupOptions).execute();
      DeleteGroupBulkMembersResponse deleteGroupBulkMembersResponse = response.getResult();

      System.out.println(deleteGroupBulkMembersResponse);

      // end-remove_members_from_access_group

    } catch (ServiceResponseException e) {
        logger.error(String.format("Profile returned status code %s: %s\nError details: %s",
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

      Response<AddMembershipMultipleGroupsResponse> response = iamAccessGroupsService.addMemberToMultipleAccessGroups(addMemberToMultipleAccessGroupsOptions).execute();
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

      Response<DeleteFromAllGroupsResponse> response = iamAccessGroupsService.removeMemberFromAllAccessGroups(removeMemberFromAllAccessGroupsOptions).execute();
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
        .realmName("https://idp.example.org/SAML2a")
        .addConditions(ruleConditionsModel)
        .build();

      Response<Rule> response = iamAccessGroupsService.addAccessGroupRule(addAccessGroupRuleOptions).execute();
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

      Response<Rule> response = iamAccessGroupsService.getAccessGroupRule(getAccessGroupRuleOptions).execute();
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

      Response<Rule> response = iamAccessGroupsService.replaceAccessGroupRule(replaceAccessGroupRuleOptions).execute();
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

      Response<RulesList> response = iamAccessGroupsService.listAccessGroupRules(listAccessGroupRulesOptions).execute();
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

      Response<Void> response = iamAccessGroupsService.removeAccessGroupRule(removeAccessGroupRuleOptions).execute();

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

      Response<AccountSettings> response = iamAccessGroupsService.getAccountSettings(getAccountSettingsOptions).execute();
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

      Response<AccountSettings> response = iamAccessGroupsService.updateAccountSettings(updateAccountSettingsOptions).execute();
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

      Response<Void> response = iamAccessGroupsService.deleteAccessGroup(deleteAccessGroupOptions).execute();

      // end-delete_access_group

      System.out.printf("deleteAccessGroup() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createTemplate() result:");
      // begin-create_template
      MembersActionControls membersActionControlsModel = new MembersActionControls.Builder()
              .add(true)
              .remove(false)
              .build();
      Members membersModel = new Members.Builder()
              .users(java.util.Arrays.asList("IBMid-50PJGPKYJJ", "IBMid-665000T8WY"))
              .actionControls(membersActionControlsModel)
              .build();
      Conditions conditionsModel = new Conditions.Builder()
              .claim("blueGroup")
              .operator("CONTAINS")
              .value("\"test-bluegroup-saml\"")
              .build();
      RuleActionControls ruleActionControlsModel = new RuleActionControls.Builder()
              .remove(false)
              .build();
      AssertionsRule assertionsRuleModel = new AssertionsRule.Builder()
              .name("Manager group rule")
              .expiration(Long.valueOf("12"))
              .realmName("https://idp.example.org/SAML2")
              .conditions(java.util.Arrays.asList(conditionsModel))
              .actionControls(ruleActionControlsModel)
              .build();
      AssertionsActionControls assertionsActionControlsModel = new AssertionsActionControls.Builder()
              .add(false)
              .remove(true)
              .build();
      Assertions assertionsModel = new Assertions.Builder()
              .rules(java.util.Arrays.asList(assertionsRuleModel))
              .actionControls(assertionsActionControlsModel)
              .build();
      AccessActionControls accessActionControlsModel = new AccessActionControls.Builder()
              .add(false)
              .build();
      GroupActionControls groupActionControlsModel = new GroupActionControls.Builder()
              .access(accessActionControlsModel)
              .build();
      AccessGroupRequest accessGroupRequestModel = new AccessGroupRequest.Builder()
              .name("IAM Admin Group")
              .description("This access group template allows admin access to all IAM platform services in the account.")
              .members(membersModel)
              .assertions(assertionsModel)
              .actionControls(groupActionControlsModel)
              .build();
      PolicyTemplates policyTemplatesModel = new PolicyTemplates.Builder()
              .id(testPolicyTemplateId)
              .version("1")
              .build();
      CreateTemplateOptions createTemplateOptions = new CreateTemplateOptions.Builder()
              .name("IAM Admin Group template")
              .accountId(testAccountId)
              .description("This access group template allows admin access to all IAM platform services in the account.")
              .group(accessGroupRequestModel)
              .policyTemplateReferences(java.util.Arrays.asList(policyTemplatesModel))
              .build();

      Response<TemplateResponse> response = iamAccessGroupsService.createTemplate(createTemplateOptions).execute();
      TemplateResponse templateResponse = response.getResult();

      System.out.println(templateResponse);
      // end-create_template
      testTemplateId = templateResponse.getId();
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listTemplates() result:");
      // begin-list_templates
      ListTemplatesOptions listTemplatesOptions = new ListTemplatesOptions.Builder()
              .accountId(testAccountId)
              .transactionId("testString")
              .limit(Long.valueOf("50"))
              .verbose(true)
              .build();

      TemplatesPager pager = new TemplatesPager(iamAccessGroupsService, listTemplatesOptions);
      List<GroupTemplate> allResults = new ArrayList<>();
      while (pager.hasNext()) {
          List<GroupTemplate> nextPage = pager.getNext();
          allResults.addAll(nextPage);
      }

      System.out.println(GsonSingleton.getGson().toJson(allResults));
      // end-list_templates
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createTemplateVersion() result:");
      // begin-create_template_version
      MembersActionControls membersActionControlsModel = new MembersActionControls.Builder()
              .add(true)
              .remove(false)
              .build();
      Members membersModel = new Members.Builder()
              .users(java.util.Arrays.asList("IBMid-50PJGPKYJJ", "IBMid-665000T8WY"))
              .actionControls(membersActionControlsModel)
              .build();
      Conditions conditionsModel = new Conditions.Builder()
              .claim("blueGroup")
              .operator("CONTAINS")
              .value("\"test-bluegroup-saml\"")
              .build();
      AssertionsRule assertionsRuleModel = new AssertionsRule.Builder()
              .name("Manager group rule")
              .expiration(Long.valueOf("12"))
              .realmName("https://idp.example.org/SAML2")
              .conditions(java.util.Arrays.asList(conditionsModel))
              .build();
      AssertionsActionControls assertionsActionControlsModel = new AssertionsActionControls.Builder()
              .add(false)
              .build();
      Assertions assertionsModel = new Assertions.Builder()
              .rules(java.util.Arrays.asList(assertionsRuleModel))
              .actionControls(assertionsActionControlsModel)
              .build();
      AccessActionControls accessActionControlsModel = new AccessActionControls.Builder()
              .add(false)
              .build();
      GroupActionControls groupActionControlsModel = new GroupActionControls.Builder()
              .access(accessActionControlsModel)
              .build();
      AccessGroupRequest accessGroupRequestModel = new AccessGroupRequest.Builder()
              .name("IAM Admin Group 8")
              .description("This access group template allows admin access to all IAM platform services in the account.")
              .members(membersModel)
              .assertions(assertionsModel)
              .actionControls(groupActionControlsModel)
              .build();
      PolicyTemplates policyTemplatesModel = new PolicyTemplates.Builder()
              .id(testPolicyTemplateId)
              .version("1")
              .build();
      CreateTemplateVersionOptions createTemplateVersionOptions = new CreateTemplateVersionOptions.Builder()
              .templateId(testTemplateId)
              .name("IAM Admin Group template 2")
              .description("This access group template allows admin access to all IAM platform services in the account.")
              .group(accessGroupRequestModel)
              .policyTemplateReferences(java.util.Arrays.asList(policyTemplatesModel))
              .build();

      Response<TemplateVersionResponse> response = iamAccessGroupsService.createTemplateVersion(createTemplateVersionOptions).execute();
      TemplateVersionResponse templateVersionResponse = response.getResult();

      System.out.println(templateVersionResponse);
      // end-create_template_version
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listTemplateVersions() result:");
      // begin-list_template_versions
      ListTemplateVersionsOptions listTemplateVersionsOptions = new ListTemplateVersionsOptions.Builder()
              .templateId(testTemplateId)
              .limit(Long.valueOf("100"))
              .build();

      TemplateVersionsPager pager = new TemplateVersionsPager(iamAccessGroupsService, listTemplateVersionsOptions);
      List<ListTemplateVersionResponse> allResults = new ArrayList<>();
      while (pager.hasNext()) {
          List<ListTemplateVersionResponse> nextPage = pager.getNext();
          allResults.addAll(nextPage);
      }

      System.out.println(GsonSingleton.getGson().toJson(allResults));
      // end-list_template_versions
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getTemplateVersion() result:");
      // begin-get_template_version
      GetTemplateVersionOptions getTemplateVersionOptions = new GetTemplateVersionOptions.Builder()
              .templateId(testTemplateId)
              .versionNum("1")
              .build();

      Response<TemplateVersionResponse> response = iamAccessGroupsService.getTemplateVersion(getTemplateVersionOptions).execute();
      TemplateVersionResponse templateVersionResponse = response.getResult();

      System.out.println(templateVersionResponse);
      // end-get_template_version
      testTemplateETag = response.getHeaders().values("Etag").get(0);
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("updateTemplateVersion() result:");
      // begin-update_template_version
      MembersActionControls membersActionControlsModel = new MembersActionControls.Builder()
              .add(true)
              .remove(false)
              .build();
      Members membersModel = new Members.Builder()
              .users(java.util.Arrays.asList("IBMid-665000T8WY"))
              .actionControls(membersActionControlsModel)
              .build();
      Conditions conditionsModel = new Conditions.Builder()
              .claim("blueGroup")
              .operator("CONTAINS")
              .value("\"test-bluegroup-saml\"")
              .build();
      RuleActionControls ruleActionControlsModel = new RuleActionControls.Builder()
              .remove(false)
              .build();
      AssertionsRule assertionsRuleModel = new AssertionsRule.Builder()
              .name("Manager group rule")
              .expiration(Long.valueOf("12"))
              .realmName("https://idp.example.org/SAML2")
              .conditions(java.util.Arrays.asList(conditionsModel))
              .actionControls(ruleActionControlsModel)
              .build();
      AssertionsActionControls assertionsActionControlsModel = new AssertionsActionControls.Builder()
              .add(false)
              .build();
      Assertions assertionsModel = new Assertions.Builder()
              .rules(java.util.Arrays.asList(assertionsRuleModel))
              .actionControls(assertionsActionControlsModel)
              .build();
      AccessActionControls accessActionControlsModel = new AccessActionControls.Builder()
              .add(false)
              .build();
      GroupActionControls groupActionControlsModel = new GroupActionControls.Builder()
              .access(accessActionControlsModel)
              .build();
      AccessGroupRequest accessGroupRequestModel = new AccessGroupRequest.Builder()
              .name("IAM Admin Group 8")
              .description("This access group template allows admin access to all IAM platform services in the account.")
              .members(membersModel)
              .assertions(assertionsModel)
              .actionControls(groupActionControlsModel)
              .build();
      PolicyTemplates policyTemplatesModel = new PolicyTemplates.Builder()
              .id(testPolicyTemplateId)
              .version("1")
              .build();
      UpdateTemplateVersionOptions updateTemplateVersionOptions = new UpdateTemplateVersionOptions.Builder()
              .templateId(testTemplateId)
              .versionNum("1")
              .ifMatch(testTemplateETag)
              .name("IAM Admin Group template 2")
              .description("This access group template allows admin access to all IAM platform services in the account.")
              .group(accessGroupRequestModel)
              .policyTemplateReferences(java.util.Arrays.asList(policyTemplatesModel))
              .transactionId("83adf5bd-de790caa3")
              .build();

      Response<TemplateVersionResponse> response = iamAccessGroupsService.updateTemplateVersion(updateTemplateVersionOptions).execute();
      TemplateVersionResponse templateVersionResponse = response.getResult();

      System.out.println(templateVersionResponse);
      // end-update_template_version
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getLatestTemplateVersion() result:");
      // begin-get_latest_template_version
      GetLatestTemplateVersionOptions getLatestTemplateVersionOptions = new GetLatestTemplateVersionOptions.Builder()
              .templateId(testTemplateId)
              .build();

      Response<TemplateVersionResponse> response = iamAccessGroupsService.getLatestTemplateVersion(getLatestTemplateVersionOptions).execute();
      TemplateVersionResponse templateVersionResponse = response.getResult();

      System.out.println(templateVersionResponse);
      // end-get_latest_template_version
      testLatestVersionETag = response.getHeaders().values("Etag").get(0);
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-commit_template
      CommitTemplateOptions commitTemplateOptions = new CommitTemplateOptions.Builder()
              .templateId(testTemplateId)
              .versionNum("2")
              .ifMatch(testLatestVersionETag)
              .build();

      Response<Void> response = iamAccessGroupsService.commitTemplate(commitTemplateOptions).execute();
      // end-commit_template
      System.out.printf("commitTemplate() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createAssignment() result:");
      // begin-create_assignment
      CreateAssignmentOptions createAssignmentOptions = new CreateAssignmentOptions.Builder()
              .templateId(testTemplateId)
              .templateVersion("2")
              .targetType("AccountGroup")
              .target(testAccountGroupId)
              .build();

      Response<TemplateAssignmentResponse> response = iamAccessGroupsService.createAssignment(createAssignmentOptions).execute();
      TemplateAssignmentResponse templateAssignmentResponse = response.getResult();

      System.out.println(templateAssignmentResponse);
      // end-create_assignment
      testAssignmentId = templateAssignmentResponse.getId();
      Thread.sleep(60000);
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listAssignments() result:");
      // begin-list_assignments
      ListAssignmentsOptions listAssignmentsOptions = new ListAssignmentsOptions.Builder()
              .accountId(testAccountId)
              .build();

      Response<ListTemplateAssignmentResponse> response = iamAccessGroupsService.listAssignments(listAssignmentsOptions).execute();
      ListTemplateAssignmentResponse listTemplateAssignmentResponse = response.getResult();

      System.out.println(listTemplateAssignmentResponse);
      // end-list_assignments
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getAssignment() result:");
      // begin-get_assignment
      GetAssignmentOptions getAssignmentOptions = new GetAssignmentOptions.Builder()
              .assignmentId(testAssignmentId)
              .build();

      Response<TemplateAssignmentVerboseResponse> response = iamAccessGroupsService.getAssignment(getAssignmentOptions).execute();
      TemplateAssignmentVerboseResponse templateAssignmentVerboseResponse = response.getResult();

      System.out.println(templateAssignmentVerboseResponse);
      // end-get_assignment
      testAssignmentETag = response.getHeaders().values("Etag").get(0);
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("updateAssignment() result:");
      // begin-update_assignment
      UpdateAssignmentOptions updateAssignmentOptions = new UpdateAssignmentOptions.Builder()
              .assignmentId(testAssignmentId)
              .ifMatch(testAssignmentETag)
              .templateVersion("2")
              .build();

      Response<TemplateAssignmentVerboseResponse> response = iamAccessGroupsService.updateAssignment(updateAssignmentOptions).execute();
      TemplateAssignmentVerboseResponse templateAssignmentVerboseResponse = response.getResult();

      System.out.println(templateAssignmentVerboseResponse);
      // end-update_assignment
      Thread.sleep(60000);
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_assignment
      DeleteAssignmentOptions deleteAssignmentOptions = new DeleteAssignmentOptions.Builder()
              .assignmentId(testAssignmentId)
              .build();

      Response<Void> response = iamAccessGroupsService.deleteAssignment(deleteAssignmentOptions).execute();
      // end-delete_assignment
      System.out.printf("deleteAssignment() response status code: %d%n", response.getStatusCode());
      Thread.sleep(90000);
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_template_version
      DeleteTemplateVersionOptions deleteTemplateVersionOptions = new DeleteTemplateVersionOptions.Builder()
              .templateId(testTemplateId)
              .versionNum("1")
              .build();

      Response<Void> response = iamAccessGroupsService.deleteTemplateVersion(deleteTemplateVersionOptions).execute();
      // end-delete_template_version
      System.out.printf("deleteTemplateVersion() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_template
      DeleteTemplateOptions deleteTemplateOptions = new DeleteTemplateOptions.Builder()
              .templateId(testTemplateId)
              .build();

      Response<Void> response = iamAccessGroupsService.deleteTemplate(deleteTemplateOptions).execute();
      // end-delete_template
      System.out.printf("deleteTemplate() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

  }
}
