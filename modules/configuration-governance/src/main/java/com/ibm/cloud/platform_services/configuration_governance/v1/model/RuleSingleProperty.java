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
 * The requirement that must be met to determine the resource's level of compliance in accordance with the rule.
 *
 * To apply a single property check, define a configuration property and the desired value that you want to check
 * against.
 */
public class RuleSingleProperty extends GenericModel {

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

  protected String description;
  protected String property;
  protected String operator;
  protected String value;

  /**
   * Builder.
   */
  public static class Builder {
    private String description;
    private String property;
    private String operator;
    private String value;

    private Builder(RuleSingleProperty ruleSingleProperty) {
      this.description = ruleSingleProperty.description;
      this.property = ruleSingleProperty.property;
      this.operator = ruleSingleProperty.operator;
      this.value = ruleSingleProperty.value;
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
     * Builds a RuleSingleProperty.
     *
     * @return the new RuleSingleProperty instance
     */
    public RuleSingleProperty build() {
      return new RuleSingleProperty(this);
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the RuleSingleProperty builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the property.
     *
     * @param property the property
     * @return the RuleSingleProperty builder
     */
    public Builder property(String property) {
      this.property = property;
      return this;
    }

    /**
     * Set the operator.
     *
     * @param operator the operator
     * @return the RuleSingleProperty builder
     */
    public Builder operator(String operator) {
      this.operator = operator;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the RuleSingleProperty builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }
  }

  protected RuleSingleProperty(Builder builder) {
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
   * @return a RuleSingleProperty builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the description.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the property.
   *
   * A resource configuration variable that describes the property that you want to apply to the target resource.
   *
   * Available options depend on the target service and resource.
   *
   * @return the property
   */
  public String property() {
    return property;
  }

  /**
   * Gets the operator.
   *
   * The way in which the `property` field is compared to its value.
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

