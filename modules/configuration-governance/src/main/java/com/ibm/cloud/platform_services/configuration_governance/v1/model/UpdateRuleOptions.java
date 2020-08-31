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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateRule options.
 */
public class UpdateRuleOptions extends GenericModel {

  /**
   * The type of rule. Rules that you create are `user_defined`.
   */
  public interface RuleType {
    /** user_defined. */
    String USER_DEFINED = "user_defined";
  }

  protected String ruleId;
  protected String ifMatch;
  protected String name;
  protected String description;
  protected TargetResource target;
  protected RuleRequiredConfig requiredConfig;
  protected List<EnforcementAction> enforcementActions;
  protected String accountId;
  protected String ruleType;
  protected List<String> labels;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String ruleId;
    private String ifMatch;
    private String name;
    private String description;
    private TargetResource target;
    private RuleRequiredConfig requiredConfig;
    private List<EnforcementAction> enforcementActions;
    private String accountId;
    private String ruleType;
    private List<String> labels;
    private String transactionId;

    private Builder(UpdateRuleOptions updateRuleOptions) {
      this.ruleId = updateRuleOptions.ruleId;
      this.ifMatch = updateRuleOptions.ifMatch;
      this.name = updateRuleOptions.name;
      this.description = updateRuleOptions.description;
      this.target = updateRuleOptions.target;
      this.requiredConfig = updateRuleOptions.requiredConfig;
      this.enforcementActions = updateRuleOptions.enforcementActions;
      this.accountId = updateRuleOptions.accountId;
      this.ruleType = updateRuleOptions.ruleType;
      this.labels = updateRuleOptions.labels;
      this.transactionId = updateRuleOptions.transactionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param ruleId the ruleId
     * @param ifMatch the ifMatch
     * @param name the name
     * @param description the description
     * @param target the target
     * @param requiredConfig the requiredConfig
     * @param enforcementActions the enforcementActions
     */
    public Builder(String ruleId, String ifMatch, String name, String description, TargetResource target, RuleRequiredConfig requiredConfig, List<EnforcementAction> enforcementActions) {
      this.ruleId = ruleId;
      this.ifMatch = ifMatch;
      this.name = name;
      this.description = description;
      this.target = target;
      this.requiredConfig = requiredConfig;
      this.enforcementActions = enforcementActions;
    }

    /**
     * Builds a UpdateRuleOptions.
     *
     * @return the new UpdateRuleOptions instance
     */
    public UpdateRuleOptions build() {
      return new UpdateRuleOptions(this);
    }

    /**
     * Adds an enforcementAction to enforcementActions.
     *
     * @param enforcementAction the new enforcementAction
     * @return the UpdateRuleOptions builder
     */
    public Builder addEnforcementAction(EnforcementAction enforcementAction) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(enforcementAction,
        "enforcementAction cannot be null");
      if (this.enforcementActions == null) {
        this.enforcementActions = new ArrayList<EnforcementAction>();
      }
      this.enforcementActions.add(enforcementAction);
      return this;
    }

    /**
     * Adds an label to labels.
     *
     * @param label the new label
     * @return the UpdateRuleOptions builder
     */
    public Builder addLabel(String label) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(label,
        "label cannot be null");
      if (this.labels == null) {
        this.labels = new ArrayList<String>();
      }
      this.labels.add(label);
      return this;
    }

    /**
     * Set the ruleId.
     *
     * @param ruleId the ruleId
     * @return the UpdateRuleOptions builder
     */
    public Builder ruleId(String ruleId) {
      this.ruleId = ruleId;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the UpdateRuleOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateRuleOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the UpdateRuleOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the target.
     *
     * @param target the target
     * @return the UpdateRuleOptions builder
     */
    public Builder target(TargetResource target) {
      this.target = target;
      return this;
    }

    /**
     * Set the requiredConfig.
     *
     * @param requiredConfig the requiredConfig
     * @return the UpdateRuleOptions builder
     */
    public Builder requiredConfig(RuleRequiredConfig requiredConfig) {
      this.requiredConfig = requiredConfig;
      return this;
    }

    /**
     * Set the enforcementActions.
     * Existing enforcementActions will be replaced.
     *
     * @param enforcementActions the enforcementActions
     * @return the UpdateRuleOptions builder
     */
    public Builder enforcementActions(List<EnforcementAction> enforcementActions) {
      this.enforcementActions = enforcementActions;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the UpdateRuleOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the ruleType.
     *
     * @param ruleType the ruleType
     * @return the UpdateRuleOptions builder
     */
    public Builder ruleType(String ruleType) {
      this.ruleType = ruleType;
      return this;
    }

    /**
     * Set the labels.
     * Existing labels will be replaced.
     *
     * @param labels the labels
     * @return the UpdateRuleOptions builder
     */
    public Builder labels(List<String> labels) {
      this.labels = labels;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the UpdateRuleOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected UpdateRuleOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.ruleId,
      "ruleId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ifMatch,
      "ifMatch cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.description,
      "description cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.target,
      "target cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.requiredConfig,
      "requiredConfig cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.enforcementActions,
      "enforcementActions cannot be null");
    ruleId = builder.ruleId;
    ifMatch = builder.ifMatch;
    name = builder.name;
    description = builder.description;
    target = builder.target;
    requiredConfig = builder.requiredConfig;
    enforcementActions = builder.enforcementActions;
    accountId = builder.accountId;
    ruleType = builder.ruleType;
    labels = builder.labels;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a UpdateRuleOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the ruleId.
   *
   * The UUID that uniquely identifies the rule.
   *
   * @return the ruleId
   */
  public String ruleId() {
    return ruleId;
  }

  /**
   * Gets the ifMatch.
   *
   * Compares a supplied `Etag` value with the version that is stored for the requested resource. If the values match,
   * the server allows the request method to continue.
   *
   * To find the `Etag` value, run a GET request on the resource that you want to modify, and check the response
   * headers.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
  }

  /**
   * Gets the name.
   *
   * A human-readable alias to assign to your rule.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * An extended description of your rule.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the target.
   *
   * The properties that describe the resource that you want to target
   * with the rule.
   *
   * @return the target
   */
  public TargetResource target() {
    return target;
  }

  /**
   * Gets the requiredConfig.
   *
   * @return the requiredConfig
   */
  public RuleRequiredConfig requiredConfig() {
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
  public List<EnforcementAction> enforcementActions() {
    return enforcementActions;
  }

  /**
   * Gets the accountId.
   *
   * Your IBM Cloud account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the ruleType.
   *
   * The type of rule. Rules that you create are `user_defined`.
   *
   * @return the ruleType
   */
  public String ruleType() {
    return ruleType;
  }

  /**
   * Gets the labels.
   *
   * Labels that you can use to group and search for similar rules, such as those that help you to meet a specific
   * organization guideline.
   *
   * @return the labels
   */
  public List<String> labels() {
    return labels;
  }

  /**
   * Gets the transactionId.
   *
   * The unique identifier that is used to trace an entire request. If you omit this field, the service generates and
   * sends a transaction ID in the
   * `trace` field of the response body.
   *
   * **Note:** To help with debugging logs, it is strongly recommended that you generate and supply a `Transaction-Id`
   * with each request.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }
}

