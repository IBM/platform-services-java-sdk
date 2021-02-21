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

package com.ibm.cloud.platform_services.configuration_governance.v1;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.cloud.platform_services.configuration_governance.v1.model.Attachment;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.AttachmentList;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.AttachmentRequest;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.CreateAttachmentsOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.CreateAttachmentsResponse;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.CreateRuleRequest;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.CreateRuleResponse;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.CreateRulesOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.CreateRulesResponse;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.DeleteAttachmentOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.DeleteRuleOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.EnforcementAction;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.GetAttachmentOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.GetRuleOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.ListAttachmentsOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.ListRulesOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.Rule;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleList;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleRequest;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleRequiredConfig;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleRequiredConfigSingleProperty;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleScope;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.TargetResource;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.UpdateAttachmentOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.UpdateRuleOptions;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

//
// This file provides an example of how to use the Configuration Governance service.
//
// The following configuration properties are assumed to be defined:
//
// CONFIGURATION_GOVERNANCE_URL=<service url>
// CONFIGURATION_GOVERNANCE_AUTHTYPE=iam
// CONFIGURATION_GOVERNANCE_APIKEY=<IAM api key of user with authority to create rules>
// CONFIGURATION_GOVERNANCE_AUTH_URL=<IAM token service URL - omit this if using the production environment>
// CONFIGURATION_GOVERNANCE_ACCOUNT_ID=<the id of the account under which rules/attachments should be created>
// CONFIGURATION_GOVERNANCE_EXAMPLE_SERVICE_NAME=<the name of the service to be associated with the example rule>
// CONFIGURATION_GOVERNANCE_ENTERPRISE_SCOPE_ID=<the id of the "enterprise" scope to be used in the examples>
// CONFIGURATION_GOVERNANCE_SUBACCT_SCOPE_ID=<the id of the "leaf account" scope to be used in the examples>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
public class ConfigurationGovernanceExamples {
  private static final Logger logger = LoggerFactory.getLogger(ConfigurationGovernanceExamples.class);
  protected ConfigurationGovernanceExamples() { }

  private static String accountId;
  private static String serviceName;
  private static String enterpriseScopeId;
  private static String subacctScopeId;

  // Variables used to hold various values shared between operations.
  private static String ruleIdLink;
  private static Rule ruleToUpdateLink;
  private static String ruleToUpdateEtagLink;

  private static String attachmentIdLink;
  private static Attachment attachmentToUpdateLink;
  private static String attachmentToUpdateEtagLink;

  static {
      System.setProperty("IBM_CREDENTIALS_FILE", "../../configuration_governance.env");
  }

  public static void main(String[] args) throws Exception {

    // Construct service instance using configuration properties.
    ConfigurationGovernance service = ConfigurationGovernance.newInstance();

    // Retrieve configuration properties whose names start with the default service name,
    Map<String, String> config = CredentialUtils.getServiceProperties(ConfigurationGovernance.DEFAULT_SERVICE_NAME);
    accountId = config.get("ACCOUNT_ID");
    serviceName = config.get("EXAMPLE_SERVICE_NAME");
    enterpriseScopeId = config.get("ENTERPRISE_SCOPE_ID");
    subacctScopeId = config.get("SUBACCT_SCOPE_ID");

    try {
      // begin-create_rules
      TargetResource targetResourceModel = new TargetResource.Builder()
        .serviceName(serviceName)
        .resourceKind("service")
        .build();
      RuleRequiredConfig ruleRequiredConfigModel = new RuleRequiredConfigSingleProperty.Builder()
        .description("Ensure public access is disabled")
        .property("public_access_enabled")
        .operator("is_false")
        .build();
      EnforcementAction disallowEnforcementActionModel = new EnforcementAction.Builder()
        .action("disallow")
        .build();
      EnforcementAction auditLogEnforcementActionModel = new EnforcementAction.Builder()
        .action("audit_log")
        .build();
      RuleRequest ruleRequestModel = new RuleRequest.Builder()
        .accountId(accountId)
        .name("Disable public access")
        .description("Ensure that public acess to account resources is disabled.")
        .target(targetResourceModel)
        .requiredConfig(ruleRequiredConfigModel)
        .addEnforcementAction(disallowEnforcementActionModel)
        .addEnforcementAction(auditLogEnforcementActionModel)
        .addLabel("test_label")
        .build();
      CreateRuleRequest createRuleRequestModel = new CreateRuleRequest.Builder()
        .rule(ruleRequestModel)
        .build();
      CreateRulesOptions createRulesOptions = new CreateRulesOptions.Builder()
        .addRule(createRuleRequestModel)
        .build();

      Response<CreateRulesResponse> response = service.createRules(createRulesOptions).execute();
      CreateRulesResponse result = response.getResult();
      if (response.getStatusCode() == 207) {
          for (CreateRuleResponse responseEntry : result.getRules()) {
              if (responseEntry.getStatusCode() > 299) {
                  throw new RuntimeException(String.format("%s: %s",
                          responseEntry.getErrors().get(0).getCode(),
                          responseEntry.getErrors().get(0).getMessage()));
              }
          }
      }
      System.out.println("createRules() result:\n" + result.toString());
      // end-create_rules

      // Retrieve the id of the new rule to use in other operations below.
      ruleIdLink = result.getRules().get(0).getRule().getRuleId();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-list_rules
      ListRulesOptions listRulesOptions = new ListRulesOptions.Builder()
        .accountId(accountId)
        .labels("test_label")
        .build();

      RuleList result = service.listRules(listRulesOptions).execute().getResult();
      System.out.println("listRules() result:\n" + result.toString());
      // end-list_rules
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_rule
      GetRuleOptions getRuleOptions = new GetRuleOptions.Builder()
        .ruleId(ruleIdLink)
        .build();

      Response<Rule> response = service.getRule(getRuleOptions).execute();
      Rule result = response.getResult();
      System.out.println("getRule() result:\n" + result.toString());
      // end-get_rule

      // Save the rule and its Etag header value so we can update it below.
      ruleToUpdateLink = result;
      ruleToUpdateEtagLink = response.getHeaders().values("Etag").get(0);
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-update_rule
      // Update the existing rule's description.
      UpdateRuleOptions updateRuleOptions = new UpdateRuleOptions.Builder()
        .ruleId(ruleIdLink)
        .ifMatch(ruleToUpdateEtagLink)
        .name(ruleToUpdateLink.getName())
        .description("This is an updated description.")
        .target(ruleToUpdateLink.getTarget())
        .requiredConfig(ruleToUpdateLink.getRequiredConfig())
        .enforcementActions(ruleToUpdateLink.getEnforcementActions())
        .accountId(ruleToUpdateLink.getAccountId())
        .ruleType(ruleToUpdateLink.getRuleType())
        .labels(ruleToUpdateLink.getLabels())
        .build();

      Rule result = service.updateRule(updateRuleOptions).execute().getResult();
      System.out.println("updateRule() result:\n" + result.toString());
      // end-update_rule
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-create_attachments
      RuleScope enterpriseScopeModel = new RuleScope.Builder()
        .note("My enterprise")
        .scopeId(enterpriseScopeId)
        .scopeType("enterprise")
        .build();
      RuleScope leafAccountScopeModel = new RuleScope.Builder()
        .note("leaf account")
        .scopeId(subacctScopeId)
        .scopeType("enterprise.account")
        .build();
      AttachmentRequest attachmentRequestModel = new AttachmentRequest.Builder()
        .accountId(accountId)
        .includedScope(enterpriseScopeModel)
        .addExcludedScope(leafAccountScopeModel)
        .build();
      CreateAttachmentsOptions createAttachmentsOptions = new CreateAttachmentsOptions.Builder()
        .ruleId(ruleIdLink)
        .addAttachment(attachmentRequestModel)
        .build();

      CreateAttachmentsResponse result = service.createAttachments(createAttachmentsOptions).execute().getResult();
      System.out.println("createAttachments() result:\n" + result.toString());
      // end-create_attachments

      // Retrieve the id of the new attachment to use in other operations below.
      attachmentIdLink = result.getAttachments().get(0).getAttachmentId();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-list_attachments
      ListAttachmentsOptions listAttachmentsOptions = new ListAttachmentsOptions.Builder()
        .ruleId(ruleIdLink)
        .build();

      AttachmentList result = service.listAttachments(listAttachmentsOptions).execute().getResult();
      System.out.println("listAttachments() result:\n" + result.toString());
      // end-list_attachments
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_attachment
      GetAttachmentOptions getAttachmentOptions = new GetAttachmentOptions.Builder()
        .ruleId(ruleIdLink)
        .attachmentId(attachmentIdLink)
        .build();

      Response<Attachment> response = service.getAttachment(getAttachmentOptions).execute();
      Attachment result = response.getResult();
      System.out.println("getAttachment() result:\n" + result.toString());
      // end-get_attachment

      // Save the attachment and its Etag header value so we can update it below.
      attachmentToUpdateLink = result;
      attachmentToUpdateEtagLink = response.getHeaders().values("Etag").get(0);
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-update_attachment
      RuleScope updatedIncludedScope = attachmentToUpdateLink.getIncludedScope().newBuilder()
        .note("This is a new note.")
        .build();
      UpdateAttachmentOptions updateAttachmentOptions = new UpdateAttachmentOptions.Builder()
        .ruleId(ruleIdLink)
        .attachmentId(attachmentIdLink)
        .ifMatch(attachmentToUpdateEtagLink)
        .accountId(attachmentToUpdateLink.getAccountId())
        .includedScope(updatedIncludedScope)
        .excludedScopes(attachmentToUpdateLink.getExcludedScopes())
        .build();

      Attachment result = service.updateAttachment(updateAttachmentOptions).execute().getResult();
      System.out.println("updateAttachment() result:\n" + result.toString());
      // end-update_attachment
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_attachment
      DeleteAttachmentOptions deleteAttachmentOptions = new DeleteAttachmentOptions.Builder()
        .ruleId(ruleIdLink)
        .attachmentId(attachmentIdLink)
        .build();

      Response<Void> response = service.deleteAttachment(deleteAttachmentOptions).execute();
      System.out.println("deleteAttachment() status code: " + response.getStatusCode());
      // end-delete_attachment
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_rule
      DeleteRuleOptions deleteRuleOptions = new DeleteRuleOptions.Builder()
        .ruleId(ruleIdLink)
        .build();

      Response<Void> response = service.deleteRule(deleteRuleOptions).execute();
      System.out.println("deleteRule() status code: " + response.getStatusCode());
      // end-delete_rule
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  }
}
