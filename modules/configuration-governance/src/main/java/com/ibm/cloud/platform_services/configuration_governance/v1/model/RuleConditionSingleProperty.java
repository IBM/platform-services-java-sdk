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

/**
 * The requirement that must be met to determine the resource's level of compliance in accordance with the rule.
 *
 * To apply a single property check, define a configuration property and the desired value that you want to check
 * against.
 */
public class RuleConditionSingleProperty extends RuleCondition {

  /**
   * The way in which the `property` field is compared to its value.
   *
   * There are three types of operators: string, numeric, and boolean.
   */
  public interface Operator {
    /** is_true. */
    String IS_TRUE = "is_true";
    /** is_false. */
    String IS_FALSE = "is_false";
    /** is_empty. */
    String IS_EMPTY = "is_empty";
    /** is_not_empty. */
    String IS_NOT_EMPTY = "is_not_empty";
    /** string_equals. */
    String STRING_EQUALS = "string_equals";
    /** string_not_equals. */
    String STRING_NOT_EQUALS = "string_not_equals";
    /** string_match. */
    String STRING_MATCH = "string_match";
    /** string_not_match. */
    String STRING_NOT_MATCH = "string_not_match";
    /** num_equals. */
    String NUM_EQUALS = "num_equals";
    /** num_not_equals. */
    String NUM_NOT_EQUALS = "num_not_equals";
    /** num_less_than. */
    String NUM_LESS_THAN = "num_less_than";
    /** num_less_than_equals. */
    String NUM_LESS_THAN_EQUALS = "num_less_than_equals";
    /** num_greater_than. */
    String NUM_GREATER_THAN = "num_greater_than";
    /** num_greater_than_equals. */
    String NUM_GREATER_THAN_EQUALS = "num_greater_than_equals";
    /** ips_in_range. */
    String IPS_IN_RANGE = "ips_in_range";
    /** strings_in_list. */
    String STRINGS_IN_LIST = "strings_in_list";
  }


  /**
   * Builder.
   */
  public static class Builder {
    private String description;
    private String property;
    private String operator;
    private String value;

    public Builder(RuleCondition ruleConditionSingleProperty) {
      this.description = ruleConditionSingleProperty.description;
      this.property = ruleConditionSingleProperty.property;
      this.operator = ruleConditionSingleProperty.operator;
      this.value = ruleConditionSingleProperty.value;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param property the property
     * @param operator the operator
     */
    public Builder(String property, String operator) {
      this.property = property;
      this.operator = operator;
    }

    /**
     * Builds a RuleConditionSingleProperty.
     *
     * @return the new RuleConditionSingleProperty instance
     */
    public RuleConditionSingleProperty build() {
      return new RuleConditionSingleProperty(this);
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the RuleConditionSingleProperty builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the property.
     *
     * @param property the property
     * @return the RuleConditionSingleProperty builder
     */
    public Builder property(String property) {
      this.property = property;
      return this;
    }

    /**
     * Set the operator.
     *
     * @param operator the operator
     * @return the RuleConditionSingleProperty builder
     */
    public Builder operator(String operator) {
      this.operator = operator;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the RuleConditionSingleProperty builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }
  }

  protected RuleConditionSingleProperty(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.property,
      "property cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.operator,
      "operator cannot be null");
    description = builder.description;
    property = builder.property;
    operator = builder.operator;
    value = builder.value;
  }

  /**
   * New builder.
   *
   * @return a RuleConditionSingleProperty builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

