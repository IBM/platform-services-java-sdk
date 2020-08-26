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
 * A condition with the `or` logical operator.
 */
public class RuleRequiredConfigMultiplePropertiesConditionOr extends RuleRequiredConfigMultipleProperties {


  /**
   * Builder.
   */
  public static class Builder {
    private String description;
    private List<RuleCondition> or;

    public Builder(RuleRequiredConfigMultipleProperties ruleRequiredConfigMultiplePropertiesConditionOr) {
      this.description = ruleRequiredConfigMultiplePropertiesConditionOr.description;
      this.or = ruleRequiredConfigMultiplePropertiesConditionOr.or;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param or the or
     */
    public Builder(List<RuleCondition> or) {
      this.or = or;
    }

    /**
     * Builds a RuleRequiredConfigMultiplePropertiesConditionOr.
     *
     * @return the new RuleRequiredConfigMultiplePropertiesConditionOr instance
     */
    public RuleRequiredConfigMultiplePropertiesConditionOr build() {
      return new RuleRequiredConfigMultiplePropertiesConditionOr(this);
    }

    /**
     * Adds an operand to or.
     *
     * @param operand the new operand
     * @return the RuleRequiredConfigMultiplePropertiesConditionOr builder
     */
    public Builder addOperand(RuleCondition operand) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(operand,
        "operand cannot be null");
      if (this.or == null) {
        this.or = new ArrayList<RuleCondition>();
      }
      this.or.add(operand);
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the RuleRequiredConfigMultiplePropertiesConditionOr builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the or.
     * Existing or will be replaced.
     *
     * @param or the or
     * @return the RuleRequiredConfigMultiplePropertiesConditionOr builder
     */
    public Builder or(List<RuleCondition> or) {
      this.or = or;
      return this;
    }
  }

  protected RuleRequiredConfigMultiplePropertiesConditionOr(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.or,
      "or cannot be null");
    description = builder.description;
    or = builder.or;
  }

  /**
   * New builder.
   *
   * @return a RuleRequiredConfigMultiplePropertiesConditionOr builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

