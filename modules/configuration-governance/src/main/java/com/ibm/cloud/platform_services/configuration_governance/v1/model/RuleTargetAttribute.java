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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The attributes that are associated with a rule target.
 */
public class RuleTargetAttribute extends GenericModel {

  /**
   * The way in which the `name` field is compared to its value.
   *
   * There are three types of operators: string, numeric, and boolean.
   */
  public interface Operator {
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
    /** is_empty. */
    String IS_EMPTY = "is_empty";
    /** is_not_empty. */
    String IS_NOT_EMPTY = "is_not_empty";
    /** is_true. */
    String IS_TRUE = "is_true";
    /** is_false. */
    String IS_FALSE = "is_false";
    /** ips_in_range. */
    String IPS_IN_RANGE = "ips_in_range";
    /** strings_in_list. */
    String STRINGS_IN_LIST = "strings_in_list";
  }

  protected String name;
  protected String operator;
  protected String value;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String operator;
    private String value;

    private Builder(RuleTargetAttribute ruleTargetAttribute) {
      this.name = ruleTargetAttribute.name;
      this.operator = ruleTargetAttribute.operator;
      this.value = ruleTargetAttribute.value;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     * @param operator the operator
     */
    public Builder(String name, String operator) {
      this.name = name;
      this.operator = operator;
    }

    /**
     * Builds a RuleTargetAttribute.
     *
     * @return the new RuleTargetAttribute instance
     */
    public RuleTargetAttribute build() {
      return new RuleTargetAttribute(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the RuleTargetAttribute builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the operator.
     *
     * @param operator the operator
     * @return the RuleTargetAttribute builder
     */
    public Builder operator(String operator) {
      this.operator = operator;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the RuleTargetAttribute builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }
  }

  protected RuleTargetAttribute(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.operator,
      "operator cannot be null");
    name = builder.name;
    operator = builder.operator;
    value = builder.value;
  }

  /**
   * New builder.
   *
   * @return a RuleTargetAttribute builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the operator.
   *
   * The way in which the `name` field is compared to its value.
   *
   * There are three types of operators: string, numeric, and boolean.
   *
   * @return the operator
   */
  public String operator() {
    return operator;
  }

  /**
   * Gets the value.
   *
   * The way in which you want your property to be applied.
   *
   * Value options differ depending on the rule that you configure. If you use a boolean operator, you do not need to
   * input a value.
   *
   * @return the value
   */
  public String value() {
    return value;
  }
}

