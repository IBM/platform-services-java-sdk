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
package com.ibm.cloud.platform_services.posture_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createValidation options.
 */
public class CreateValidationOptions extends GenericModel {

  protected String accountId;
  protected String scopeId;
  protected String profileId;
  protected String groupProfileId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String scopeId;
    private String profileId;
    private String groupProfileId;

    private Builder(CreateValidationOptions createValidationOptions) {
      this.accountId = createValidationOptions.accountId;
      this.scopeId = createValidationOptions.scopeId;
      this.profileId = createValidationOptions.profileId;
      this.groupProfileId = createValidationOptions.groupProfileId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param accountId the accountId
     */
    public Builder(String accountId) {
      this.accountId = accountId;
    }

    /**
     * Builds a CreateValidationOptions.
     *
     * @return the new CreateValidationOptions instance
     */
    public CreateValidationOptions build() {
      return new CreateValidationOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreateValidationOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the scopeId.
     *
     * @param scopeId the scopeId
     * @return the CreateValidationOptions builder
     */
    public Builder scopeId(String scopeId) {
      this.scopeId = scopeId;
      return this;
    }

    /**
     * Set the profileId.
     *
     * @param profileId the profileId
     * @return the CreateValidationOptions builder
     */
    public Builder profileId(String profileId) {
      this.profileId = profileId;
      return this;
    }

    /**
     * Set the groupProfileId.
     *
     * @param groupProfileId the groupProfileId
     * @return the CreateValidationOptions builder
     */
    public Builder groupProfileId(String groupProfileId) {
      this.groupProfileId = groupProfileId;
      return this;
    }
  }

  protected CreateValidationOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    accountId = builder.accountId;
    scopeId = builder.scopeId;
    profileId = builder.profileId;
    groupProfileId = builder.groupProfileId;
  }

  /**
   * New builder.
   *
   * @return a CreateValidationOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * Your IBM Cloud account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the scopeId.
   *
   * The unique ID of the scope.
   *
   * @return the scopeId
   */
  public String scopeId() {
    return scopeId;
  }

  /**
   * Gets the profileId.
   *
   * The unique ID of the profile.
   *
   * @return the profileId
   */
  public String profileId() {
    return profileId;
  }

  /**
   * Gets the groupProfileId.
   *
   * The ID of the profile group.
   *
   * @return the groupProfileId
   */
  public String groupProfileId() {
    return groupProfileId;
  }
}

