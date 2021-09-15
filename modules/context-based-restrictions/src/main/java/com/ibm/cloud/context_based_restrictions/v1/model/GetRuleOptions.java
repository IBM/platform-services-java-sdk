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
package com.ibm.cloud.context_based_restrictions.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getRule options.
 */
public class GetRuleOptions extends GenericModel {

  protected String ruleId;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String ruleId;
    private String transactionId;

    private Builder(GetRuleOptions getRuleOptions) {
      this.ruleId = getRuleOptions.ruleId;
      this.transactionId = getRuleOptions.transactionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param ruleId the ruleId
     */
    public Builder(String ruleId) {
      this.ruleId = ruleId;
    }

    /**
     * Builds a GetRuleOptions.
     *
     * @return the new GetRuleOptions instance
     */
    public GetRuleOptions build() {
      return new GetRuleOptions(this);
    }

    /**
     * Set the ruleId.
     *
     * @param ruleId the ruleId
     * @return the GetRuleOptions builder
     */
    public Builder ruleId(String ruleId) {
      this.ruleId = ruleId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the GetRuleOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected GetRuleOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.ruleId,
      "ruleId cannot be empty");
    ruleId = builder.ruleId;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a GetRuleOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the ruleId.
   *
   * The ID of a rule.
   *
   * @return the ruleId
   */
  public String ruleId() {
    return ruleId;
  }

  /**
   * Gets the transactionId.
   *
   * The UUID that is used to correlate and track transactions. If you omit this field, the service generates and sends
   * a transaction ID in the response.
   * **Note:** To help with debugging, we strongly recommend that you generate and supply a `Transaction-Id` with each
   * request.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }
}

