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

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * RuleWithNestedConditionsConditionsItem.
 *
 * Classes which extend this class:
 * - RuleWithNestedConditionsConditionsItemRuleAttribute
 * - RuleWithNestedConditionsConditionsItemRuleWithConditions
 */
public class RuleWithNestedConditionsConditionsItem extends GenericModel {

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
  }

  protected String key;
  protected String operator;
  protected Object value;
  protected List<RuleAttribute> conditions;

  protected RuleWithNestedConditionsConditionsItem() { }

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
   * List of conditions associated with a policy, e.g., time-based conditions that grant access over a certain time
   * period.
   *
   * @return the conditions
   */
  public List<RuleAttribute> conditions() {
    return conditions;
  }
}

