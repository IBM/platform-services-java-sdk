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
 * The createValidationScan options.
 */
public class CreateValidationScanOptions extends GenericModel {

  protected String accountId;
  protected Long scopeId;
  protected Long profileId;
  protected Long groupProfileId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private Long scopeId;
    private Long profileId;
    private Long groupProfileId;

    private Builder(CreateValidationScanOptions createValidationScanOptions) {
      this.accountId = createValidationScanOptions.accountId;
      this.scopeId = createValidationScanOptions.scopeId;
      this.profileId = createValidationScanOptions.profileId;
      this.groupProfileId = createValidationScanOptions.groupProfileId;
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
     * Builds a CreateValidationScanOptions.
     *
     * @return the new CreateValidationScanOptions instance
     */
    public CreateValidationScanOptions build() {
      return new CreateValidationScanOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreateValidationScanOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the scopeId.
     *
     * @param scopeId the scopeId
     * @return the CreateValidationScanOptions builder
     */
    public Builder scopeId(long scopeId) {
      this.scopeId = scopeId;
      return this;
    }

    /**
     * Set the profileId.
     *
     * @param profileId the profileId
     * @return the CreateValidationScanOptions builder
     */
    public Builder profileId(long profileId) {
      this.profileId = profileId;
      return this;
    }

    /**
     * Set the groupProfileId.
     *
     * @param groupProfileId the groupProfileId
     * @return the CreateValidationScanOptions builder
     */
    public Builder groupProfileId(long groupProfileId) {
      this.groupProfileId = groupProfileId;
      return this;
    }
  }

  protected CreateValidationScanOptions(Builder builder) {
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
   * @return a CreateValidationScanOptions builder
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
  public Long scopeId() {
    return scopeId;
  }

  /**
   * Gets the profileId.
   *
   * The unique ID of the profile.
   *
   * @return the profileId
   */
  public Long profileId() {
    return profileId;
  }

  /**
   * Gets the groupProfileId.
   *
   * The ID of the profile group.
   *
   * @return the groupProfileId
   */
  public Long groupProfileId() {
    return groupProfileId;
  }
}

