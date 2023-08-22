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
package com.ibm.cloud.platform_services.iam_access_groups.v2.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Rule Input component.
 */
public class RuleInput extends GenericModel {

  protected String name;
  protected Long expiration;
  @SerializedName("realm_name")
  protected String realmName;
  protected List<ConditionInput> conditions;
  @SerializedName("action_controls")
  protected RulesActionControls actionControls;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private Long expiration;
    private String realmName;
    private List<ConditionInput> conditions;
    private RulesActionControls actionControls;

    /**
     * Instantiates a new Builder from an existing RuleInput instance.
     *
     * @param ruleInput the instance to initialize the Builder with
     */
    private Builder(RuleInput ruleInput) {
      this.name = ruleInput.name;
      this.expiration = ruleInput.expiration;
      this.realmName = ruleInput.realmName;
      this.conditions = ruleInput.conditions;
      this.actionControls = ruleInput.actionControls;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a RuleInput.
     *
     * @return the new RuleInput instance
     */
    public RuleInput build() {
      return new RuleInput(this);
    }

    /**
     * Adds an conditions to conditions.
     *
     * @param conditions the new conditions
     * @return the RuleInput builder
     */
    public Builder addConditions(ConditionInput conditions) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(conditions,
        "conditions cannot be null");
      if (this.conditions == null) {
        this.conditions = new ArrayList<ConditionInput>();
      }
      this.conditions.add(conditions);
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the RuleInput builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the expiration.
     *
     * @param expiration the expiration
     * @return the RuleInput builder
     */
    public Builder expiration(long expiration) {
      this.expiration = expiration;
      return this;
    }

    /**
     * Set the realmName.
     *
     * @param realmName the realmName
     * @return the RuleInput builder
     */
    public Builder realmName(String realmName) {
      this.realmName = realmName;
      return this;
    }

    /**
     * Set the conditions.
     * Existing conditions will be replaced.
     *
     * @param conditions the conditions
     * @return the RuleInput builder
     */
    public Builder conditions(List<ConditionInput> conditions) {
      this.conditions = conditions;
      return this;
    }

    /**
     * Set the actionControls.
     *
     * @param actionControls the actionControls
     * @return the RuleInput builder
     */
    public Builder actionControls(RulesActionControls actionControls) {
      this.actionControls = actionControls;
      return this;
    }
  }

  protected RuleInput() { }

  protected RuleInput(Builder builder) {
    name = builder.name;
    expiration = builder.expiration;
    realmName = builder.realmName;
    conditions = builder.conditions;
    actionControls = builder.actionControls;
  }

  /**
   * New builder.
   *
   * @return a RuleInput builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * rule input name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the expiration.
   *
   * rule input expiration.
   *
   * @return the expiration
   */
  public Long expiration() {
    return expiration;
  }

  /**
   * Gets the realmName.
   *
   * rule input realm name.
   *
   * @return the realmName
   */
  public String realmName() {
    return realmName;
  }

  /**
   * Gets the conditions.
   *
   * rule input conditions.
   *
   * @return the conditions
   */
  public List<ConditionInput> conditions() {
    return conditions;
  }

  /**
   * Gets the actionControls.
   *
   * Control whether or not child account administrators can update and remove dynamic rules from the enterprise-managed
   * access group in their account. These action controls will override outer level action controls.
   *
   * @return the actionControls
   */
  public RulesActionControls actionControls() {
    return actionControls;
  }
}

