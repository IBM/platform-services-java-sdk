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
 * Properties associated with a rule, including both user-settable and server-populated properties.
 */
public class Rule extends GenericModel {

  /**
   * The type of rule. Rules that you create are `user_defined`.
   */
  public interface RuleType {
    /** user_defined. */
    String USER_DEFINED = "user_defined";
  }

  @SerializedName("account_id")
  protected String accountId;
  protected String name;
  protected String description;
  @SerializedName("rule_type")
  protected String ruleType;
  protected TargetResource target;
  @SerializedName("required_config")
  protected RuleRequiredConfig requiredConfig;
  @SerializedName("enforcement_actions")
  protected List<EnforcementAction> enforcementActions;
  protected List<String> labels;
  @SerializedName("rule_id")
  protected String ruleId;
  @SerializedName("creation_date")
  protected String creationDate;
  @SerializedName("created_by")
  protected String createdBy;
  @SerializedName("modification_date")
  protected String modificationDate;
  @SerializedName("modified_by")
  protected String modifiedBy;
  @SerializedName("number_of_attachments")
  protected Long numberOfAttachments;

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
   * Gets the name.
   *
   * A human-readable alias to assign to your rule.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * An extended description of your rule.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the ruleType.
   *
   * The type of rule. Rules that you create are `user_defined`.
   *
   * @return the ruleType
   */
  public String getRuleType() {
    return ruleType;
  }

  /**
   * Gets the target.
   *
   * The properties that describe the resource that you want to target
   * with the rule.
   *
   * @return the target
   */
  public TargetResource getTarget() {
    return target;
  }

  /**
   * Gets the requiredConfig.
   *
   * @return the requiredConfig
   */
  public RuleRequiredConfig getRequiredConfig() {
    return requiredConfig;
  }

  /**
   * Gets the enforcementActions.
   *
   * The actions that the service must run on your behalf when a request to create or modify the target resource does
   * not comply with your conditions.
   *
   * @return the enforcementActions
   */
  public List<EnforcementAction> getEnforcementActions() {
    return enforcementActions;
  }

  /**
   * Gets the labels.
   *
   * Labels that you can use to group and search for similar rules, such as those that help you to meet a specific
   * organization guideline.
   *
   * @return the labels
   */
  public List<String> getLabels() {
    return labels;
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
   * Gets the creationDate.
   *
   * The date the resource was created.
   *
   * @return the creationDate
   */
  public String getCreationDate() {
    return creationDate;
  }

  /**
   * Gets the createdBy.
   *
   * The unique identifier for the user or application that created the resource.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the modificationDate.
   *
   * The date the resource was last modified.
   *
   * @return the modificationDate
   */
  public String getModificationDate() {
    return modificationDate;
  }

  /**
   * Gets the modifiedBy.
   *
   * The unique identifier for the user or application that last modified the resource.
   *
   * @return the modifiedBy
   */
  public String getModifiedBy() {
    return modifiedBy;
  }

  /**
   * Gets the numberOfAttachments.
   *
   * The number of scope attachments that are associated with the rule.
   *
   * @return the numberOfAttachments
   */
  public Long getNumberOfAttachments() {
    return numberOfAttachments;
  }
}

