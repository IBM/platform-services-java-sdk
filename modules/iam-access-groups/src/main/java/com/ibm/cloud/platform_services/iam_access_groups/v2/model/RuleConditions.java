/*
 * (C) Copyright IBM Corp. 2021.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The conditions of a rule.
 */
public class RuleConditions extends GenericModel {

  protected String claim;
  protected String operator;
  protected String value;

  /**
   * Builder.
   */
  public static class Builder {
    private String claim;
    private String operator;
    private String value;

    private Builder(RuleConditions ruleConditions) {
      this.claim = ruleConditions.claim;
      this.operator = ruleConditions.operator;
      this.value = ruleConditions.value;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param claim the claim
     * @param operator the operator
     * @param value the value
     */
    public Builder(String claim, String operator, String value) {
      this.claim = claim;
      this.operator = operator;
      this.value = value;
    }

    /**
     * Builds a RuleConditions.
     *
     * @return the new RuleConditions instance
     */
    public RuleConditions build() {
      return new RuleConditions(this);
    }

    /**
     * Set the claim.
     *
     * @param claim the claim
     * @return the RuleConditions builder
     */
    public Builder claim(String claim) {
      this.claim = claim;
      return this;
    }

    /**
     * Set the operator.
     *
     * @param operator the operator
     * @return the RuleConditions builder
     */
    public Builder operator(String operator) {
      this.operator = operator;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the RuleConditions builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }
  }

  protected RuleConditions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.claim,
      "claim cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.operator,
      "operator cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.value,
      "value cannot be null");
    claim = builder.claim;
    operator = builder.operator;
    value = builder.value;
  }

  /**
   * New builder.
   *
   * @return a RuleConditions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the claim.
   *
   * The claim to evaluate against. This will be found in the `ext` claims of a user's login request.
   *
   * @return the claim
   */
  public String claim() {
    return claim;
  }

  /**
   * Gets the operator.
   *
   * The operation to perform on the claim. Valid operators are EQUALS, EQUALS_IGNORE_CASE, IN, NOT_EQUALS_IGNORE_CASE,
   * NOT_EQUALS, and CONTAINS.
   *
   * @return the operator
   */
  public String operator() {
    return operator;
  }

  /**
   * Gets the value.
   *
   * The stringified JSON value that the claim is compared to using the operator.
   *
   * @return the value
   */
  public String value() {
    return value;
  }
}

