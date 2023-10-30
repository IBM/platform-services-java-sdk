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
package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Rule that specifies additional conditions.
 */
public class RuleAttributeWithConditions extends GenericModel {

  /**
   * The operator of an attribute.
   */
  public interface Operator {
    /** timeLessThan. */
    String TIMELESSTHAN = "timeLessThan";
    /** timeLessThanOrEquals. */
    String TIMELESSTHANOREQUALS = "timeLessThanOrEquals";
    /** timeGreaterThan. */
    String TIMEGREATERTHAN = "timeGreaterThan";
    /** timeGreaterThanOrEquals. */
    String TIMEGREATERTHANOREQUALS = "timeGreaterThanOrEquals";
    /** dateTimeLessThan. */
    String DATETIMELESSTHAN = "dateTimeLessThan";
    /** dateTimeLessThanOrEquals. */
    String DATETIMELESSTHANOREQUALS = "dateTimeLessThanOrEquals";
    /** dateTimeGreaterThan. */
    String DATETIMEGREATERTHAN = "dateTimeGreaterThan";
    /** dateTimeGreaterThanOrEquals. */
    String DATETIMEGREATERTHANOREQUALS = "dateTimeGreaterThanOrEquals";
    /** dayOfWeekEquals. */
    String DAYOFWEEKEQUALS = "dayOfWeekEquals";
    /** dayOfWeekAnyOf. */
    String DAYOFWEEKANYOF = "dayOfWeekAnyOf";
    /** and. */
    String AND = "and";
    /** or. */
    String OR = "or";
  }

  protected String key;
  protected String operator;
  protected Object value;
  protected List<RuleAttribute> conditions;

  /**
   * Builder.
   */
  public static class Builder {
    private String key;
    private String operator;
    private Object value;
    private List<RuleAttribute> conditions;

    /**
     * Instantiates a new Builder from an existing RuleAttributeWithConditions instance.
     *
     * @param ruleAttributeWithConditions the instance to initialize the Builder with
     */
    private Builder(RuleAttributeWithConditions ruleAttributeWithConditions) {
      this.key = ruleAttributeWithConditions.key;
      this.operator = ruleAttributeWithConditions.operator;
      this.value = ruleAttributeWithConditions.value;
      this.conditions = ruleAttributeWithConditions.conditions;
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
     */
    public Builder(String operator) {
      this.operator = operator;
    }

    /**
     * Builds a RuleAttributeWithConditions.
     *
     * @return the new RuleAttributeWithConditions instance
     */
    public RuleAttributeWithConditions build() {
      return new RuleAttributeWithConditions(this);
    }

    /**
     * Adds an conditions to conditions.
     *
     * @param conditions the new conditions
     * @return the RuleAttributeWithConditions builder
     */
    public Builder addConditions(RuleAttribute conditions) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(conditions,
        "conditions cannot be null");
      if (this.conditions == null) {
        this.conditions = new ArrayList<RuleAttribute>();
      }
      this.conditions.add(conditions);
      return this;
    }

    /**
     * Set the key.
     *
     * @param key the key
     * @return the RuleAttributeWithConditions builder
     */
    public Builder key(String key) {
      this.key = key;
      return this;
    }

    /**
     * Set the operator.
     *
     * @param operator the operator
     * @return the RuleAttributeWithConditions builder
     */
    public Builder operator(String operator) {
      this.operator = operator;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the RuleAttributeWithConditions builder
     */
    public Builder value(Object value) {
      this.value = value;
      return this;
    }

    /**
     * Set the conditions.
     * Existing conditions will be replaced.
     *
     * @param conditions the conditions
     * @return the RuleAttributeWithConditions builder
     */
    public Builder conditions(List<RuleAttribute> conditions) {
      this.conditions = conditions;
      return this;
    }
  }

  protected RuleAttributeWithConditions() { }

  protected RuleAttributeWithConditions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.operator,
      "operator cannot be null");
    key = builder.key;
    operator = builder.operator;
    value = builder.value;
    conditions = builder.conditions;
  }

  /**
   * New builder.
   *
   * @return a RuleAttributeWithConditions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the key.
   *
   * The name of an attribute.
   *
   * @return the key
   */
  public String key() {
    return key;
  }

  /**
   * Gets the operator.
   *
   * The operator of an attribute.
   *
   * @return the operator
   */
  public String operator() {
    return operator;
  }

  /**
   * Gets the value.
   *
   * The value of a rule or resource attribute; can be boolean or string for resource attribute. Can be string or an
   * array of strings (e.g., array of days to permit access) for rule attribute.
   *
   * @return the value
   */
  public Object value() {
    return value;
  }

  /**
   * Gets the conditions.
   *
   * List of additional conditions associated with a policy, e.g., time-based conditions that grant access over a
   * certain time period.
   *
   * @return the conditions
   */
  public List<RuleAttribute> conditions() {
    return conditions;
  }
}

