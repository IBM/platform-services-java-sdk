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
package com.ibm.cloud.platform_services.configuration_governance.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The scopes to attach to the rule.
 */
public class Attachment extends GenericModel {

  @SerializedName("attachment_id")
  protected String attachmentId;
  @SerializedName("rule_id")
  protected String ruleId;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("included_scope")
  protected RuleScope includedScope;
  @SerializedName("excluded_scopes")
  protected List<RuleScope> excludedScopes;

  /**
   * Gets the attachmentId.
   *
   * The UUID that uniquely identifies the attachment.
   *
   * @return the attachmentId
   */
  public String getAttachmentId() {
    return attachmentId;
  }

  /**
   * Gets the ruleId.
   *
   * The UUID that uniquely identifies the rule.
   *
   * @return the ruleId
   */
  public String getRuleId() {
    return ruleId;
  }

  /**
   * Gets the accountId.
   *
   * Your IBM Cloud account ID.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the includedScope.
   *
   * The extent at which the rule can be attached across your accounts.
   *
   * @return the includedScope
   */
  public RuleScope getIncludedScope() {
    return includedScope;
  }

  /**
   * Gets the excludedScopes.
   *
   * The extent at which the rule can be excluded from the included scope.
   *
   * @return the excludedScopes
   */
  public List<RuleScope> getExcludedScopes() {
    return excludedScopes;
  }
}

