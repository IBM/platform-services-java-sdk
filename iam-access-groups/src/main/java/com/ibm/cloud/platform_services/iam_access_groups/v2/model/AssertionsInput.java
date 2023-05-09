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
 * Assertions Input Component.
 */
public class AssertionsInput extends GenericModel {

  protected List<RuleInput> rules;
  @SerializedName("action_controls")
  protected AssertionsActionControls actionControls;

  /**
   * Builder.
   */
  public static class Builder {
    private List<RuleInput> rules;
    private AssertionsActionControls actionControls;

    /**
     * Instantiates a new Builder from an existing AssertionsInput instance.
     *
     * @param assertionsInput the instance to initialize the Builder with
     */
    private Builder(AssertionsInput assertionsInput) {
      this.rules = assertionsInput.rules;
      this.actionControls = assertionsInput.actionControls;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a AssertionsInput.
     *
     * @return the new AssertionsInput instance
     */
    public AssertionsInput build() {
      return new AssertionsInput(this);
    }

    /**
     * Adds an rules to rules.
     *
     * @param rules the new rules
     * @return the AssertionsInput builder
     */
    public Builder addRules(RuleInput rules) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(rules,
        "rules cannot be null");
      if (this.rules == null) {
        this.rules = new ArrayList<RuleInput>();
      }
      this.rules.add(rules);
      return this;
    }

    /**
     * Set the rules.
     * Existing rules will be replaced.
     *
     * @param rules the rules
     * @return the AssertionsInput builder
     */
    public Builder rules(List<RuleInput> rules) {
      this.rules = rules;
      return this;
    }

    /**
     * Set the actionControls.
     *
     * @param actionControls the actionControls
     * @return the AssertionsInput builder
     */
    public Builder actionControls(AssertionsActionControls actionControls) {
      this.actionControls = actionControls;
      return this;
    }
  }

  protected AssertionsInput() { }

  protected AssertionsInput(Builder builder) {
    rules = builder.rules;
    actionControls = builder.actionControls;
  }

  /**
   * New builder.
   *
   * @return a AssertionsInput builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the rules.
   *
   * assertions input rules.
   *
   * @return the rules
   */
  public List<RuleInput> rules() {
    return rules;
  }

  /**
   * Gets the actionControls.
   *
   * Assertions Action Controls component.
   *
   * @return the actionControls
   */
  public AssertionsActionControls actionControls() {
    return actionControls;
  }
}

