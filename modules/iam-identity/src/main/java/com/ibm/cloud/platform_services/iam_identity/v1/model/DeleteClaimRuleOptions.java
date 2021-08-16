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
 * The deleteClaimRule options.
 */
public class DeleteClaimRuleOptions extends GenericModel {

  protected String profileId;
  protected String ruleId;

  /**
   * Builder.
   */
  public static class Builder {
    private String profileId;
    private String ruleId;

    private Builder(DeleteClaimRuleOptions deleteClaimRuleOptions) {
      this.profileId = deleteClaimRuleOptions.profileId;
      this.ruleId = deleteClaimRuleOptions.ruleId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param profileId the profileId
     * @param ruleId the ruleId
     */
    public Builder(String profileId, String ruleId) {
      this.profileId = profileId;
      this.ruleId = ruleId;
    }

    /**
     * Builds a DeleteClaimRuleOptions.
     *
     * @return the new DeleteClaimRuleOptions instance
     */
    public DeleteClaimRuleOptions build() {
      return new DeleteClaimRuleOptions(this);
    }

    /**
     * Set the profileId.
     *
     * @param profileId the profileId
     * @return the DeleteClaimRuleOptions builder
     */
    public Builder profileId(String profileId) {
      this.profileId = profileId;
      return this;
    }

    /**
     * Set the ruleId.
     *
     * @param ruleId the ruleId
     * @return the DeleteClaimRuleOptions builder
     */
    public Builder ruleId(String ruleId) {
      this.ruleId = ruleId;
      return this;
    }
  }

  protected DeleteClaimRuleOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profileId,
      "profileId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.ruleId,
      "ruleId cannot be empty");
    profileId = builder.profileId;
    ruleId = builder.ruleId;
  }

  /**
   * New builder.
   *
   * @return a DeleteClaimRuleOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the profileId.
   *
   * ID of the trusted profile.
   *
   * @return the profileId
   */
  public String profileId() {
    return profileId;
  }

  /**
   * Gets the ruleId.
   *
   * ID of the claim rule to delete.
   *
   * @return the ruleId
   */
  public String ruleId() {
    return ruleId;
  }
}

