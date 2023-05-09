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
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AccessGroupInput;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AccessGroupMembersPager;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AccessGroupsPager;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AccountSettings;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddAccessGroupRuleOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddGroupMembersRequestMembersItem;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddGroupMembersResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddMemberToMultipleAccessGroupsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddMembersToAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddMembershipMultipleGroupsResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AssertionsActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AssertionsInput;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.CommitTemplateOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ConditionInput;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.CreateAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.CreateAssignmentOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.CreateTemplateOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.CreateTemplateResponse;
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
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GetTemplateAssignmentResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GetTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.Group;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GroupActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.IsMemberOfAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListAccessGroupMembersOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListAccessGroupRulesOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListAccessGroupsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListAssignmentsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListGroupMembersResponseMember;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListTemplateVersionsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListTemplatesOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListTemplatesVersionsResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.MembersActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.MembersInput;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.PolicyTemplatesInput;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RemoveAccessGroupRuleOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RemoveMemberFromAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RemoveMemberFromAllAccessGroupsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RemoveMembersFromAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ReplaceAccessGroupRuleOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.Rule;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RuleConditions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RuleInput;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RulesActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RulesList;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.TemplateCreateAssignmentResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.TemplateItem;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.TemplateVersionsPager;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.TemplatesListAssignmentResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.TemplatesPager;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.UpdateAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.UpdateAccountSettingsOptions;
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

/**
 * This class contains examples of how to use the iam-access-groups service.
 *
 * The following configuration properties are assumed to be defined:
 * IAM_ACCESS_GROUPS_URL=&lt;service base url&gt;
 * IAM_ACCESS_GROUPS_AUTH_TYPE=iam
 * IAM_ACCESS_GROUPS_APIKEY=&lt;IAM apikey&gt;
 * IAM_ACCESS_GROUPS_AUTH_URL=&lt;IAM token service base URL - omit this if using the production environment&gt;
 *
 * These configuration properties can be exported as environment variables, or stored
 * in a configuration file and then:
 * export IBM_CREDENTIALS_FILE=&lt;name of configuration file&gt;
 */
public class IamAccessGroupsExamples {
  private static final Logger logger = LoggerFactory.getLogger(IamAccessGroupsExamples.class);
  protected IamAccessGroupsExamples() { }

  static {
    System.setProperty("IBM_CREDENTIALS_FILE", "../../iam_access_groups_v2.env");
  }

  /**
   * The main() function invokes operations of the iam-access-groups service.
   * @param args command-line arguments
   * @throws Exception an error occurred
   */
  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    IamAccessGroups iamAccessGroupsService = IamAccessGroups.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> testConfigProperties = CredentialUtils.getServiceProperties(IamAccessGroups.DEFAULT_SERVICE_NAME);

    // Variables to hold link values
    String accessGroupETagLink = null;
    String accessGroupIdLink = null;

    try {
      System.out.println("createAccessGroup() result:");
      // begin-create_access_group
      CreateAccessGroupOptions createAccessGroupOptions = new CreateAccessGroupOptions.Builder()
        .accountId("testString")
        .name("Managers")
        .description("Group for managers")
        .build();

      Response<Group> response = iamAccessGroupsService.createAccessGroup(createAccessGroupOptions).execute();
      Group group = response.getResult();

      System.out.println(group);
      // end-create_access_group

      accessGroupIdLink = group.getId();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getAccessGroup() result:");
      // begin-get_access_group
      GetAccessGroupOptions getAccessGroupOptions = new GetAccessGroupOptions.Builder()
        .accessGroupId(accessGroupIdLink)
        .build();

      Response<Group> response = iamAccessGroupsService.getAccessGroup(getAccessGroupOptions).execute();
      Group group = response.getResult();

      System.out.println(group);
      // end-get_access_group

      accessGroupETagLink = response.getHeaders().values("ETag").get(0);
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listAccessGroups() result:");
      // begin-list_access_groups
      ListAccessGroupsOptions listAccessGroupsOptions = new ListAccessGroupsOptions.Builder()
        .accountId("testString")
        .transactionId("testString")
        .iamId("testString")
        .search("testString")
        .membershipType("static")
        .limit(Long.valueOf("10"))
        .sort("name")
        .showFederated(false)
        .hidePublicAccess(false)
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
      System.out.println("updateAccessGroup() result:");
      // begin-update_access_group
      UpdateAccessGroupOptions updateAccessGroupOptions = new UpdateAccessGroupOptions.Builder()
        .accessGroupId(accessGroupIdLink)
        .ifMatch(accessGroupETagLink)
        .name("Awesome Managers")
        .description("Group for awesome managers.")
        .build();

      Response<Group> response = iamAccessGroupsService.updateAccessGroup(updateAccessGroupOptions).execute();
      Group group = response.getResult();

      System.out.println(group);
      // end-update_access_group
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-is_member_of_access_group
      IsMemberOfAccessGroupOptions isMemberOfAccessGroupOptions = new IsMemberOfAccessGroupOptions.Builder()
        .accessGroupId(accessGroupIdLink)
        .iamId("testString")
        .build();

      Response<Void> response = iamAccessGroupsService.isMemberOfAccessGroup(isMemberOfAccessGroupOptions).execute();
      // end-is_member_of_access_group
      System.out.printf("isMemberOfAccessGroup() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("addMembersToAccessGroup() result:");
      // begin-add_members_to_access_group
      AddGroupMembersRequestMembersItem addGroupMembersRequestMembersItemModel = new AddGroupMembersRequestMembersItem.Builder()
        .iamId("IBMid-user1")
        .type("user")
        .build();
      AddMembersToAccessGroupOptions addMembersToAccessGroupOptions = new AddMembersToAccessGroupOptions.Builder()
        .accessGroupId(accessGroupIdLink)
        .members(java.util.Arrays.asList(addGroupMembersRequestMembersItemModel))
        .build();

      Response<AddGroupMembersResponse> response = iamAccessGroupsService.addMembersToAccessGroup(addMembersToAccessGroupOptions).execute();
      AddGroupMembersResponse addGroupMembersResponse = response.getResult();

      System.out.println(addGroupMembersResponse);
      // end-add_members_to_access_group
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listAccessGroupMembers() result:");
      // begin-list_access_group_members
      ListAccessGroupMembersOptions listAccessGroupMembersOptions = new ListAccessGroupMembersOptions.Builder()
        .accessGroupId(accessGroupIdLink)
        .transactionId("testString")
        .membershipType("static")
        .limit(Long.valueOf("10"))
        .type("testString")
        .verbose(false)
        .sort("testString")
        .build();

      AccessGroupMembersPager pager = new AccessGroupMembersPager(iamAccessGroupsService, listAccessGroupMembersOptions);
      List<ListGroupMembersResponseMember> allResults = new ArrayList<>();
      while (pager.hasNext()) {
        List<ListGroupMembersResponseMember> nextPage = pager.getNext();
        allResults.addAll(nextPage);
      }

      System.out.println(GsonSingleton.getGson().toJson(allResults));
      // end-list_access_group_members
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("removeMembersFromAccessGroup() result:");
      // begin-remove_members_from_access_group
      RemoveMembersFromAccessGroupOptions removeMembersFromAccessGroupOptions = new RemoveMembersFromAccessGroupOptions.Builder()
        .accessGroupId(accessGroupIdLink)
        .members(java.util.Arrays.asList("IBMId-user1", "iam-ServiceId-123", "iam-Profile-123"))
        .build();

      Response<DeleteGroupBulkMembersResponse> response = iamAccessGroupsService.removeMembersFromAccessGroup(removeMembersFromAccessGroupOptions).execute();
      DeleteGroupBulkMembersResponse deleteGroupBulkMembersResponse = response.getResult();

      System.out.println(deleteGroupBulkMembersResponse);
      // end-remove_members_from_access_group
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("addMemberToMultipleAccessGroups() result:");
      // begin-add_member_to_multiple_access_groups
      AddMemberToMultipleAccessGroupsOptions addMemberToMultipleAccessGroupsOptions = new AddMemberToMultipleAccessGroupsOptions.Builder()
        .accountId("testString")
        .iamId("testString")
        .type("user")
        .groups(java.util.Arrays.asList("access-group-id-1"))
        .build();

      Response<AddMembershipMultipleGroupsResponse> response = iamAccessGroupsService.addMemberToMultipleAccessGroups(addMemberToMultipleAccessGroupsOptions).execute();
      AddMembershipMultipleGroupsResponse addMembershipMultipleGroupsResponse = response.getResult();

      System.out.println(addMembershipMultipleGroupsResponse);
      // end-add_member_to_multiple_access_groups
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
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
        .accessGroupId(accessGroupIdLink)
        .expiration(Long.valueOf("12"))
        .realmName("https://idp.example.org/SAML2")
        .conditions(java.util.Arrays.asList(ruleConditionsModel))
        .name("Manager group rule")
        .build();

      Response<Rule> response = iamAccessGroupsService.addAccessGroupRule(addAccessGroupRuleOptions).execute();
      Rule rule = response.getResult();

      System.out.println(rule);
      // end-add_access_group_rule
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listAccessGroupRules() result:");
      // begin-list_access_group_rules
      ListAccessGroupRulesOptions listAccessGroupRulesOptions = new ListAccessGroupRulesOptions.Builder()
        .accessGroupId(accessGroupIdLink)
        .build();

      Response<RulesList> response = iamAccessGroupsService.listAccessGroupRules(listAccessGroupRulesOptions).execute();
      RulesList rulesList = response.getResult();

      System.out.println(rulesList);
      // end-list_access_group_rules
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getAccessGroupRule() result:");
      // begin-get_access_group_rule
      GetAccessGroupRuleOptions getAccessGroupRuleOptions = new GetAccessGroupRuleOptions.Builder()
        .accessGroupId(accessGroupIdLink)
        .ruleId("testString")
        .build();

      Response<Rule> response = iamAccessGroupsService.getAccessGroupRule(getAccessGroupRuleOptions).execute();
      Rule rule = response.getResult();

      System.out.println(rule);
      // end-get_access_group_rule
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
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
        .accessGroupId(accessGroupIdLink)
        .ruleId("testString")
        .ifMatch("testString")
        .expiration(Long.valueOf("12"))
        .realmName("https://idp.example.org/SAML2")
        .conditions(java.util.Arrays.asList(ruleConditionsModel))
        .name("Manager group rule")
        .build();

      Response<Rule> response = iamAccessGroupsService.replaceAccessGroupRule(replaceAccessGroupRuleOptions).execute();
      Rule rule = response.getResult();

      System.out.println(rule);
      // end-replace_access_group_rule
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getAccountSettings() result:");
      // begin-get_account_settings
      GetAccountSettingsOptions getAccountSettingsOptions = new GetAccountSettingsOptions.Builder()
        .accountId("testString")
        .build();

      Response<AccountSettings> response = iamAccessGroupsService.getAccountSettings(getAccountSettingsOptions).execute();
      AccountSettings accountSettings = response.getResult();

      System.out.println(accountSettings);
      // end-get_account_settings
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("updateAccountSettings() result:");
      // begin-update_account_settings
      UpdateAccountSettingsOptions updateAccountSettingsOptions = new UpdateAccountSettingsOptions.Builder()
        .accountId("testString")
        .publicAccessEnabled(true)
        .build();

      Response<AccountSettings> response = iamAccessGroupsService.updateAccountSettings(updateAccountSettingsOptions).execute();
      AccountSettings accountSettings = response.getResult();

      System.out.println(accountSettings);
      // end-update_account_settings
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createTemplate() result:");
      // begin-create_template
      MembersActionControls membersActionControlsModel = new MembersActionControls.Builder()
        .add(true)
        .remove(false)
        .build();
      MembersInput membersInputModel = new MembersInput.Builder()
        .users(java.util.Arrays.asList("IBMid-123", "IBMid-234"))
        .actionControls(membersActionControlsModel)
        .build();
      ConditionInput conditionInputModel = new ConditionInput.Builder()
        .claim("blueGroup")
        .operator("CONTAINS")
        .value("test-bluegroup-saml")
        .build();
      RulesActionControls rulesActionControlsModel = new RulesActionControls.Builder()
        .remove(false)
        .update(false)
        .build();
      RuleInput ruleInputModel = new RuleInput.Builder()
        .name("Manager group rule")
        .expiration(Long.valueOf("12"))
        .realmName("https://idp.example.org/SAML2")
        .conditions(java.util.Arrays.asList(conditionInputModel))
        .actionControls(rulesActionControlsModel)
        .build();
      AssertionsActionControls assertionsActionControlsModel = new AssertionsActionControls.Builder()
        .add(false)
        .remove(true)
        .update(true)
        .build();
      AssertionsInput assertionsInputModel = new AssertionsInput.Builder()
        .rules(java.util.Arrays.asList(ruleInputModel))
        .actionControls(assertionsActionControlsModel)
        .build();
      AccessActionControls accessActionControlsModel = new AccessActionControls.Builder()
        .add(false)
        .build();
      GroupActionControls groupActionControlsModel = new GroupActionControls.Builder()
        .access(accessActionControlsModel)
        .build();
      AccessGroupInput accessGroupInputModel = new AccessGroupInput.Builder()
        .name("IAM Admin Group")
        .description("This access group template allows admin access to all IAM platform services in the account.")
        .members(membersInputModel)
        .assertions(assertionsInputModel)
        .actionControls(groupActionControlsModel)
        .build();
      PolicyTemplatesInput policyTemplatesInputModel = new PolicyTemplatesInput.Builder()
        .id("policyTemplateId-123")
        .version("1")
        .build();
      CreateTemplateOptions createTemplateOptions = new CreateTemplateOptions.Builder()
        .name("IAM Admin Group template")
        .description("This access group template allows admin access to all IAM platform services in the account.")
        .accountId("accountID-123")
        .accessGroup(accessGroupInputModel)
        .policyTemplates(java.util.Arrays.asList(policyTemplatesInputModel))
        .build();

      Response<CreateTemplateResponse> response = iamAccessGroupsService.createTemplate(createTemplateOptions).execute();
      CreateTemplateResponse createTemplateResponse = response.getResult();

      System.out.println(createTemplateResponse);
      // end-create_template
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listTemplates() result:");
      // begin-list_templates
      ListTemplatesOptions listTemplatesOptions = new ListTemplatesOptions.Builder()
        .accountId("accountID-123")
        .transactionId("testString")
        .limit(Long.valueOf("50"))
        .verbose(true)
        .build();

      TemplatesPager pager = new TemplatesPager(iamAccessGroupsService, listTemplatesOptions);
      List<TemplateItem> allResults = new ArrayList<>();
      while (pager.hasNext()) {
        List<TemplateItem> nextPage = pager.getNext();
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
      MembersInput membersInputModel = new MembersInput.Builder()
        .users(java.util.Arrays.asList("IBMid-123", "IBMid-234"))
        .build();
      ConditionInput conditionInputModel = new ConditionInput.Builder()
        .claim("blueGroup")
        .operator("CONTAINS")
        .value("test-bluegroup-saml")
        .build();
      RuleInput ruleInputModel = new RuleInput.Builder()
        .name("Manager group rule")
        .expiration(Long.valueOf("12"))
        .realmName("https://idp.example.org/SAML2")
        .conditions(java.util.Arrays.asList(conditionInputModel))
        .build();
      AssertionsInput assertionsInputModel = new AssertionsInput.Builder()
        .rules(java.util.Arrays.asList(ruleInputModel))
        .build();
      AccessGroupInput accessGroupInputModel = new AccessGroupInput.Builder()
        .name("IAM Admin Group 8")
        .description("This access group template allows admin access to all IAM platform services in the account.")
        .members(membersInputModel)
        .assertions(assertionsInputModel)
        .build();
      PolicyTemplatesInput policyTemplatesInputModel = new PolicyTemplatesInput.Builder()
        .id("policyTemplateId-123")
        .version("1")
        .build();
      CreateTemplateVersionOptions createTemplateVersionOptions = new CreateTemplateVersionOptions.Builder()
        .templateId("testString")
        .name("IAM Admin Group template 2")
        .description("This access group template allows admin access to all IAM platform services in the account.")
        .accessGroup(accessGroupInputModel)
        .policyTemplates(java.util.Arrays.asList(policyTemplatesInputModel))
        .build();

      Response<CreateTemplateResponse> response = iamAccessGroupsService.createTemplateVersion(createTemplateVersionOptions).execute();
      CreateTemplateResponse createTemplateResponse = response.getResult();

      System.out.println(createTemplateResponse);
      // end-create_template_version
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listTemplateVersions() result:");
      // begin-list_template_versions
      ListTemplateVersionsOptions listTemplateVersionsOptions = new ListTemplateVersionsOptions.Builder()
        .templateId("testString")
        .limit(Long.valueOf("100"))
        .build();

      TemplateVersionsPager pager = new TemplateVersionsPager(iamAccessGroupsService, listTemplateVersionsOptions);
      List<ListTemplatesVersionsResponse> allResults = new ArrayList<>();
      while (pager.hasNext()) {
        List<ListTemplatesVersionsResponse> nextPage = pager.getNext();
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
        .templateId("testString")
        .versionNum("testString")
        .build();

      Response<CreateTemplateResponse> response = iamAccessGroupsService.getTemplateVersion(getTemplateVersionOptions).execute();
      CreateTemplateResponse createTemplateResponse = response.getResult();

      System.out.println(createTemplateResponse);
      // end-get_template_version
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("updateTemplateVersion() result:");
      // begin-update_template_version
      MembersInput membersInputModel = new MembersInput.Builder()
        .users(java.util.Arrays.asList("IBMid-5500085Q21"))
        .build();
      ConditionInput conditionInputModel = new ConditionInput.Builder()
        .claim("blueGroup")
        .operator("CONTAINS")
        .value("test-bluegroup-saml")
        .build();
      RuleInput ruleInputModel = new RuleInput.Builder()
        .name("Manager group rule")
        .expiration(Long.valueOf("12"))
        .realmName("https://idp.example.org/SAML2")
        .conditions(java.util.Arrays.asList(conditionInputModel))
        .build();
      AssertionsInput assertionsInputModel = new AssertionsInput.Builder()
        .rules(java.util.Arrays.asList(ruleInputModel))
        .build();
      AccessGroupInput accessGroupInputModel = new AccessGroupInput.Builder()
        .name("IAM Admin Group 8")
        .description("This access group template allows admin access to all IAM platform services in the account.")
        .members(membersInputModel)
        .assertions(assertionsInputModel)
        .build();
      PolicyTemplatesInput policyTemplatesInputModel = new PolicyTemplatesInput.Builder()
        .id("policyTemplateId-123")
        .version("1")
        .build();
      UpdateTemplateVersionOptions updateTemplateVersionOptions = new UpdateTemplateVersionOptions.Builder()
        .templateId("testString")
        .versionNum("testString")
        .ifMatch("testString")
        .name("IAM Admin Group template 2")
        .description("This access group template allows admin access to all IAM platform services in the account.")
        .accessGroup(accessGroupInputModel)
        .policyTemplates(java.util.Arrays.asList(policyTemplatesInputModel))
        .transactionId("83adf5bd-de790caa3")
        .build();

      Response<CreateTemplateResponse> response = iamAccessGroupsService.updateTemplateVersion(updateTemplateVersionOptions).execute();
      CreateTemplateResponse createTemplateResponse = response.getResult();

      System.out.println(createTemplateResponse);
      // end-update_template_version
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("commitTemplate() result:");
      // begin-commit_template
      CommitTemplateOptions commitTemplateOptions = new CommitTemplateOptions.Builder()
        .templateId("testString")
        .versionNum("testString")
        .ifMatch("testString")
        .build();

      Response<CreateTemplateResponse> response = iamAccessGroupsService.commitTemplate(commitTemplateOptions).execute();
      CreateTemplateResponse createTemplateResponse = response.getResult();

      System.out.println(createTemplateResponse);
      // end-commit_template
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getLatestTemplateVersion() result:");
      // begin-get_latest_template_version
      GetLatestTemplateVersionOptions getLatestTemplateVersionOptions = new GetLatestTemplateVersionOptions.Builder()
        .templateId("testString")
        .build();

      Response<CreateTemplateResponse> response = iamAccessGroupsService.getLatestTemplateVersion(getLatestTemplateVersionOptions).execute();
      CreateTemplateResponse createTemplateResponse = response.getResult();

      System.out.println(createTemplateResponse);
      // end-get_latest_template_version
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createAssignment() result:");
      // begin-create_assignment
      CreateAssignmentOptions createAssignmentOptions = new CreateAssignmentOptions.Builder()
        .templateId("AccessGroupTemplateId-4be4")
        .templateVersion("1")
        .targetType("accountGroup")
        .target("0a45594d0f-123")
        .build();

      Response<TemplateCreateAssignmentResponse> response = iamAccessGroupsService.createAssignment(createAssignmentOptions).execute();
      TemplateCreateAssignmentResponse templateCreateAssignmentResponse = response.getResult();

      System.out.println(templateCreateAssignmentResponse);
      // end-create_assignment
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listAssignments() result:");
      // begin-list_assignments
      ListAssignmentsOptions listAssignmentsOptions = new ListAssignmentsOptions.Builder()
        .accountId("accountID-123")
        .build();

      Response<TemplatesListAssignmentResponse> response = iamAccessGroupsService.listAssignments(listAssignmentsOptions).execute();
      TemplatesListAssignmentResponse templatesListAssignmentResponse = response.getResult();

      System.out.println(templatesListAssignmentResponse);
      // end-list_assignments
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getAssignment() result:");
      // begin-get_assignment
      GetAssignmentOptions getAssignmentOptions = new GetAssignmentOptions.Builder()
        .assignmentId("testString")
        .build();

      Response<GetTemplateAssignmentResponse> response = iamAccessGroupsService.getAssignment(getAssignmentOptions).execute();
      GetTemplateAssignmentResponse getTemplateAssignmentResponse = response.getResult();

      System.out.println(getTemplateAssignmentResponse);
      // end-get_assignment
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_access_group
      DeleteAccessGroupOptions deleteAccessGroupOptions = new DeleteAccessGroupOptions.Builder()
        .accessGroupId(accessGroupIdLink)
        .build();

      Response<Void> response = iamAccessGroupsService.deleteAccessGroup(deleteAccessGroupOptions).execute();
      // end-delete_access_group
      System.out.printf("deleteAccessGroup() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-remove_member_from_access_group
      RemoveMemberFromAccessGroupOptions removeMemberFromAccessGroupOptions = new RemoveMemberFromAccessGroupOptions.Builder()
        .accessGroupId(accessGroupIdLink)
        .iamId("testString")
        .build();

      Response<Void> response = iamAccessGroupsService.removeMemberFromAccessGroup(removeMemberFromAccessGroupOptions).execute();
      // end-remove_member_from_access_group
      System.out.printf("removeMemberFromAccessGroup() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-remove_access_group_rule
      RemoveAccessGroupRuleOptions removeAccessGroupRuleOptions = new RemoveAccessGroupRuleOptions.Builder()
        .accessGroupId(accessGroupIdLink)
        .ruleId("testString")
        .build();

      Response<Void> response = iamAccessGroupsService.removeAccessGroupRule(removeAccessGroupRuleOptions).execute();
      // end-remove_access_group_rule
      System.out.printf("removeAccessGroupRule() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("removeMemberFromAllAccessGroups() result:");
      // begin-remove_member_from_all_access_groups
      RemoveMemberFromAllAccessGroupsOptions removeMemberFromAllAccessGroupsOptions = new RemoveMemberFromAllAccessGroupsOptions.Builder()
        .accountId("testString")
        .iamId("testString")
        .build();

      Response<DeleteFromAllGroupsResponse> response = iamAccessGroupsService.removeMemberFromAllAccessGroups(removeMemberFromAllAccessGroupsOptions).execute();
      DeleteFromAllGroupsResponse deleteFromAllGroupsResponse = response.getResult();

      System.out.println(deleteFromAllGroupsResponse);
      // end-remove_member_from_all_access_groups
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_template_version
      DeleteTemplateVersionOptions deleteTemplateVersionOptions = new DeleteTemplateVersionOptions.Builder()
        .templateId("testString")
        .versionNum("testString")
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
        .templateId("testString")
        .build();

      Response<Void> response = iamAccessGroupsService.deleteTemplate(deleteTemplateOptions).execute();
      // end-delete_template
      System.out.printf("deleteTemplate() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_assignment
      DeleteAssignmentOptions deleteAssignmentOptions = new DeleteAssignmentOptions.Builder()
        .assignmentId("testString")
        .build();

      Response<Void> response = iamAccessGroupsService.deleteAssignment(deleteAssignmentOptions).execute();
      // end-delete_assignment
      System.out.printf("deleteAssignment() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  }
}
