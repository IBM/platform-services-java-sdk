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
package com.ibm.cloud.platform_services.iam_access_groups.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Condition Input component.
 */
public class ConditionInput extends GenericModel {

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

    /**
     * Instantiates a new Builder from an existing ConditionInput instance.
     *
     * @param conditionInput the instance to initialize the Builder with
     */
    private Builder(ConditionInput conditionInput) {
      this.claim = conditionInput.claim;
      this.operator = conditionInput.operator;
      this.value = conditionInput.value;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ConditionInput.
     *
     * @return the new ConditionInput instance
     */
    public ConditionInput build() {
      return new ConditionInput(this);
    }

    /**
     * Set the claim.
     *
     * @param claim the claim
     * @return the ConditionInput builder
     */
    public Builder claim(String claim) {
      this.claim = claim;
      return this;
    }

    /**
     * Set the operator.
     *
     * @param operator the operator
     * @return the ConditionInput builder
     */
    public Builder operator(String operator) {
      this.operator = operator;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the ConditionInput builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }
  }

  protected ConditionInput() { }

  protected ConditionInput(Builder builder) {
    claim = builder.claim;
    operator = builder.operator;
    value = builder.value;
  }

  /**
   * New builder.
   *
   * @return a ConditionInput builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the claim.
   *
   * condition input claim.
   *
   * @return the claim
   */
  public String claim() {
    return claim;
  }

  /**
   * Gets the operator.
   *
   * condition input operator.
   *
   * @return the operator
   */
  public String operator() {
    return operator;
  }

  /**
   * Gets the value.
   *
   * condition input value.
   *
   * @return the value
   */
  public String value() {
    return value;
  }
}

