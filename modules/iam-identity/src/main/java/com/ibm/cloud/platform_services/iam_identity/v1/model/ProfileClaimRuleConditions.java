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
package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * ProfileClaimRuleConditions.
 */
public class ProfileClaimRuleConditions extends GenericModel {

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

    private Builder(ProfileClaimRuleConditions profileClaimRuleConditions) {
      this.claim = profileClaimRuleConditions.claim;
      this.operator = profileClaimRuleConditions.operator;
      this.value = profileClaimRuleConditions.value;
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
     * Builds a ProfileClaimRuleConditions.
     *
     * @return the new ProfileClaimRuleConditions instance
     */
    public ProfileClaimRuleConditions build() {
      return new ProfileClaimRuleConditions(this);
    }

    /**
     * Set the claim.
     *
     * @param claim the claim
     * @return the ProfileClaimRuleConditions builder
     */
    public Builder claim(String claim) {
      this.claim = claim;
      return this;
    }

    /**
     * Set the operator.
     *
     * @param operator the operator
     * @return the ProfileClaimRuleConditions builder
     */
    public Builder operator(String operator) {
      this.operator = operator;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the ProfileClaimRuleConditions builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }
  }

  protected ProfileClaimRuleConditions(Builder builder) {
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
   * @return a ProfileClaimRuleConditions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the claim.
   *
   * The claim to valuate againt.
   *
   * @return the claim
   */
  public String claim() {
    return claim;
  }

  /**
   * Gets the operator.
   *
   * The operation to perform on the claim. valid values are EQUALS, NOT_EQUALS, EQUALS_IGNORE_CASE,
   * NOT_EQUALS_IGNORE_CASE, CONTAINS, IN.
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

