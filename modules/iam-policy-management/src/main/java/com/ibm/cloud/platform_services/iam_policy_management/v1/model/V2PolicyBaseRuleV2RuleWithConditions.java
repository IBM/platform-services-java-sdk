/*
 * (C) Copyright IBM Corp. 2022.
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
package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Policy rule that has 2 to 10 conditions.
 */
public class V2PolicyBaseRuleV2RuleWithConditions extends V2PolicyBaseRule {

  /**
   * Operator to evalute conditions.
   */
  public interface Operator {
    /** and. */
    String AND = "and";
    /** or. */
    String OR = "or";
  }


  /**
   * Builder.
   */
  public static class Builder {
    private String operator;
    private List<V2PolicyAttribute> conditions;

    /**
     * Instantiates a new Builder from an existing V2PolicyBaseRuleV2RuleWithConditions instance.
     *
     * @param v2PolicyBaseRuleV2RuleWithConditions the instance to initialize the Builder with
     */
    public Builder(V2PolicyBaseRule v2PolicyBaseRuleV2RuleWithConditions) {
      this.operator = v2PolicyBaseRuleV2RuleWithConditions.operator;
      this.conditions = v2PolicyBaseRuleV2RuleWithConditions.conditions;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param operator the operator
     * @param conditions the conditions
     */
    public Builder(String operator, List<V2PolicyAttribute> conditions) {
      this.operator = operator;
      this.conditions = conditions;
    }

    /**
     * Builds a V2PolicyBaseRuleV2RuleWithConditions.
     *
     * @return the new V2PolicyBaseRuleV2RuleWithConditions instance
     */
    public V2PolicyBaseRuleV2RuleWithConditions build() {
      return new V2PolicyBaseRuleV2RuleWithConditions(this);
    }

    /**
     * Adds an conditions to conditions.
     *
     * @param conditions the new conditions
     * @return the V2PolicyBaseRuleV2RuleWithConditions builder
     */
    public Builder addConditions(V2PolicyAttribute conditions) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(conditions,
        "conditions cannot be null");
      if (this.conditions == null) {
        this.conditions = new ArrayList<V2PolicyAttribute>();
      }
      this.conditions.add(conditions);
      return this;
    }

    /**
     * Set the operator.
     *
     * @param operator the operator
     * @return the V2PolicyBaseRuleV2RuleWithConditions builder
     */
    public Builder operator(String operator) {
      this.operator = operator;
      return this;
    }

    /**
     * Set the conditions.
     * Existing conditions will be replaced.
     *
     * @param conditions the conditions
     * @return the V2PolicyBaseRuleV2RuleWithConditions builder
     */
    public Builder conditions(List<V2PolicyAttribute> conditions) {
      this.conditions = conditions;
      return this;
    }
  }

  protected V2PolicyBaseRuleV2RuleWithConditions() { }

  protected V2PolicyBaseRuleV2RuleWithConditions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.operator,
      "operator cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.conditions,
      "conditions cannot be null");
    operator = builder.operator;
    conditions = builder.conditions;
  }

  /**
   * New builder.
   *
   * @return a V2PolicyBaseRuleV2RuleWithConditions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

