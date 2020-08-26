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

/**
 * A condition with the `and` logical operator.
 */
public class RuleConditionAndLvl2 extends RuleCondition {


  /**
   * Builder.
   */
  public static class Builder {
    private String description;
    private List<RuleSingleProperty> and;

    public Builder(RuleCondition ruleConditionAndLvl2) {
      this.description = ruleConditionAndLvl2.description;
      this.and = ruleConditionAndLvl2.and;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param and the and
     */
    public Builder(List<RuleSingleProperty> and) {
      this.and = and;
    }

    /**
     * Builds a RuleConditionAndLvl2.
     *
     * @return the new RuleConditionAndLvl2 instance
     */
    public RuleConditionAndLvl2 build() {
      return new RuleConditionAndLvl2(this);
    }

    /**
     * Adds an operand to and.
     *
     * @param operand the new operand
     * @return the RuleConditionAndLvl2 builder
     */
    public Builder addOperand(RuleSingleProperty operand) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(operand,
        "operand cannot be null");
      if (this.and == null) {
        this.and = new ArrayList<RuleSingleProperty>();
      }
      this.and.add(operand);
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the RuleConditionAndLvl2 builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the and.
     * Existing and will be replaced.
     *
     * @param and the and
     * @return the RuleConditionAndLvl2 builder
     */
    public Builder and(List<RuleSingleProperty> and) {
      this.and = and;
      return this;
    }
  }

  protected RuleConditionAndLvl2(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.and,
      "and cannot be null");
    description = builder.description;
    and = builder.and;
  }

  /**
   * New builder.
   *
   * @return a RuleConditionAndLvl2 builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

