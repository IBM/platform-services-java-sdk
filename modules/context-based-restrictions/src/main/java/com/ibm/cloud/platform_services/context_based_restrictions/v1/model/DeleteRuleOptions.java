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
package com.ibm.cloud.platform_services.context_based_restrictions.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The deleteRule options.
 */
public class DeleteRuleOptions extends GenericModel {

  protected String ruleId;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String ruleId;
    private String transactionId;

    private Builder(DeleteRuleOptions deleteRuleOptions) {
      this.ruleId = deleteRuleOptions.ruleId;
      this.transactionId = deleteRuleOptions.transactionId;
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
     * Builds a DeleteRuleOptions.
     *
     * @return the new DeleteRuleOptions instance
     */
    public DeleteRuleOptions build() {
      return new DeleteRuleOptions(this);
    }

    /**
     * Set the ruleId.
     *
     * @param ruleId the ruleId
     * @return the DeleteRuleOptions builder
     */
    public Builder ruleId(String ruleId) {
      this.ruleId = ruleId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the DeleteRuleOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected DeleteRuleOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.ruleId,
      "ruleId cannot be empty");
    ruleId = builder.ruleId;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a DeleteRuleOptions builder
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

