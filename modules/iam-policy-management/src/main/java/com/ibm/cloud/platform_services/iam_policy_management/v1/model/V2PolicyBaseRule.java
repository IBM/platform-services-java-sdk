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

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Additional access conditions associated with a policy.
 *
 * Classes which extend this class:
 * - V2PolicyBaseRuleV2PolicyAttribute
 * - V2PolicyBaseRuleV2RuleWithConditions
 */
public class V2PolicyBaseRule extends GenericModel {

  protected String key;
  protected String operator;
  protected Object value;
  protected List<V2PolicyAttribute> conditions;

  protected V2PolicyBaseRule() { }

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
   * The value of an attribute; can be array, boolean, string, or integer.
   *
   * @return the value
   */
  public Object value() {
    return value;
  }

  /**
   * Gets the conditions.
   *
   * List of conditions to associated with a policy. Note that conditions can be nested up to 2 levels.
   *
   * @return the conditions
   */
  public List<V2PolicyAttribute> conditions() {
    return conditions;
  }
}

