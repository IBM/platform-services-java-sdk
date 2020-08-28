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

import com.ibm.cloud.platform_services.configuration_governance.v1.model.AttachmentRequest;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.CreateAttachmentsOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.CreateRuleRequest;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.CreateRulesOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.DeleteAttachmentOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.DeleteRuleOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.EnforcementAction;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.GetAttachmentOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.GetRuleOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.ListAttachmentsOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.ListRulesOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleRequest;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleRequiredConfigSingleProperty;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleScope;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleTargetAttribute;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.TargetResource;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.UpdateAttachmentOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.UpdateRuleOptions;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigurationGovernanceExamples {
  private static final Logger logger = LoggerFactory.getLogger(ConfigurationGovernanceExamples.class);
  protected ConfigurationGovernanceExamples() { }

  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    ConfigurationGovernance service = ConfigurationGovernance.newInstance();

    try {
    // begin-create_rules
      RuleTargetAttribute ruleTargetAttributeModel = new RuleTargetAttribute.Builder()
      .name("resource_id")
      .operator("string_equals")
      .value("f0f8f7994e754ff38f9d370201966561")
      .build();
      TargetResource targetResourceModel = new TargetResource.Builder()
      .serviceName("iam-groups")
      .resourceKind("zone")
      .additionalTargetAttributes(new java.util.ArrayList<RuleTargetAttribute>(java.util.Arrays.asList(ruleTargetAttributeModel)))
      .build();
      RuleRequiredConfigSingleProperty ruleRequiredConfigModel = new RuleRequiredConfigSingleProperty.Builder()
      .property("public_access_enabled")
      .operator("is_true")
      .build();
      EnforcementAction enforcementActionModel = new EnforcementAction.Builder()
      .action("disallow")
      .build();
      RuleRequest ruleRequestModel = new RuleRequest.Builder()
      .name("testString")
      .description("testString")
      .version("1.0.0")
      .target(targetResourceModel)
      .requiredConfig(ruleRequiredConfigModel)
      .enforcementActions(new java.util.ArrayList<EnforcementAction>(java.util.Arrays.asList(enforcementActionModel)))
      .labels(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .build();
      CreateRuleRequest createRuleRequestModel = new CreateRuleRequest.Builder()
      .requestId("3cebc877-58e7-44a5-a292-32114fa73558")
      .rule(ruleRequestModel)
      .build();
      CreateRulesOptions createRulesOptions = new CreateRulesOptions.Builder()
      .rules(new java.util.ArrayList<CreateRuleRequest>(java.util.Arrays.asList(createRuleRequestModel)))
      .build();

      service.createRules(createRulesOptions).execute().getResult();
    // end-create_rules
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
    // begin-list_rules
      ListRulesOptions listRulesOptions = new ListRulesOptions.Builder()
      .accountId("testString")
      .attached(true)
      .labels("SOC2,ITCS300")
      .scopes("scope_id")
      .build();

      service.listRules(listRulesOptions).execute().getResult();
    // end-list_rules
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
    // begin-get_rule
      GetRuleOptions getRuleOptions = new GetRuleOptions.Builder()
      .ruleId("testString")
      .build();

      service.getRule(getRuleOptions).execute().getResult();
    // end-get_rule
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
    // begin-update_rule
      RuleTargetAttribute ruleTargetAttributeModel = new RuleTargetAttribute.Builder()
      .name("testString")
      .operator("string_equals")
      .build();
      TargetResource targetResourceModel = new TargetResource.Builder()
      .serviceName("iam-groups")
      .resourceKind("service")
      .additionalTargetAttributes(new java.util.ArrayList<RuleTargetAttribute>(java.util.Arrays.asList(ruleTargetAttributeModel)))
      .build();
      RuleRequiredConfigSingleProperty ruleRequiredConfigModel = new RuleRequiredConfigSingleProperty.Builder()
      .property("public_access_enabled")
      .operator("is_false")
      .build();
      EnforcementAction enforcementActionModel = new EnforcementAction.Builder()
      .action("audit_log")
      .build();
      UpdateRuleOptions updateRuleOptions = new UpdateRuleOptions.Builder()
      .ruleId("testString")
      .ifMatch("testString")
      .name("Disable public access")
      .description("Ensure that public access to account resources is disabled.")
      .target(targetResourceModel)
      .requiredConfig(ruleRequiredConfigModel)
      .enforcementActions(new java.util.ArrayList<EnforcementAction>(java.util.Arrays.asList(enforcementActionModel)))
      .accountId("531fc3e28bfc43c5a2cea07786d93f5c")
      .version("1.0.0")
      .ruleType("user_defined")
      .labels(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .build();

      service.updateRule(updateRuleOptions).execute().getResult();
    // end-update_rule
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
    // begin-create_attachments
      RuleScope ruleScopeModel = new RuleScope.Builder()
      .note("My enterprise")
      .scopeId("282cf433ac91493ba860480d92519990")
      .scopeType("enterprise")
      .build();
      AttachmentRequest attachmentRequestModel = new AttachmentRequest.Builder()
      .accountId("531fc3e28bfc43c5a2cea07786d93f5c")
      .includedScope(ruleScopeModel)
      .excludedScopes(new java.util.ArrayList<RuleScope>(java.util.Arrays.asList(ruleScopeModel)))
      .build();
      CreateAttachmentsOptions createAttachmentsOptions = new CreateAttachmentsOptions.Builder()
      .ruleId("testString")
      .attachments(new java.util.ArrayList<AttachmentRequest>(java.util.Arrays.asList(attachmentRequestModel)))
      .build();

      service.createAttachments(createAttachmentsOptions).execute().getResult();
    // end-create_attachments
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
    // begin-list_attachments
      ListAttachmentsOptions listAttachmentsOptions = new ListAttachmentsOptions.Builder()
      .ruleId("testString")
      .build();

      service.listAttachments(listAttachmentsOptions).execute().getResult();
    // end-list_attachments
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
    // begin-get_attachment
      GetAttachmentOptions getAttachmentOptions = new GetAttachmentOptions.Builder()
      .ruleId("testString")
      .attachmentId("testString")
      .build();

      service.getAttachment(getAttachmentOptions).execute().getResult();
    // end-get_attachment
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
    // begin-update_attachment
      RuleScope ruleScopeModel = new RuleScope.Builder()
      .scopeId("testString")
      .scopeType("enterprise")
      .build();
      UpdateAttachmentOptions updateAttachmentOptions = new UpdateAttachmentOptions.Builder()
      .ruleId("testString")
      .attachmentId("testString")
      .ifMatch("testString")
      .accountId("testString")
      .includedScope(ruleScopeModel)
      .build();

      service.updateAttachment(updateAttachmentOptions).execute().getResult();
    // end-update_attachment
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
    // begin-delete_rule
      DeleteRuleOptions deleteRuleOptions = new DeleteRuleOptions.Builder()
      .ruleId("testString")
      .build();

      service.deleteRule(deleteRuleOptions).execute().getResult();
    // end-delete_rule
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
    // begin-delete_attachment
      DeleteAttachmentOptions deleteAttachmentOptions = new DeleteAttachmentOptions.Builder()
      .ruleId("testString")
      .attachmentId("testString")
      .build();

      service.deleteAttachment(deleteAttachmentOptions).execute().getResult();
    // end-delete_attachment
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

  }
}
