/*
 * (C) Copyright IBM Corp. 2025.
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
 * The getAllPreferencesOnScopeAccount options.
 */
public class GetAllPreferencesOnScopeAccountOptions extends GenericModel {

  protected String accountId;
  protected String iamId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String iamId;

    /**
     * Instantiates a new Builder from an existing GetAllPreferencesOnScopeAccountOptions instance.
     *
     * @param getAllPreferencesOnScopeAccountOptions the instance to initialize the Builder with
     */
    private Builder(GetAllPreferencesOnScopeAccountOptions getAllPreferencesOnScopeAccountOptions) {
      this.accountId = getAllPreferencesOnScopeAccountOptions.accountId;
      this.iamId = getAllPreferencesOnScopeAccountOptions.iamId;
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
     * @param iamId the iamId
     */
    public Builder(String accountId, String iamId) {
      this.accountId = accountId;
      this.iamId = iamId;
    }

    /**
     * Builds a GetAllPreferencesOnScopeAccountOptions.
     *
     * @return the new GetAllPreferencesOnScopeAccountOptions instance
     */
    public GetAllPreferencesOnScopeAccountOptions build() {
      return new GetAllPreferencesOnScopeAccountOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the GetAllPreferencesOnScopeAccountOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the iamId.
     *
     * @param iamId the iamId
     * @return the GetAllPreferencesOnScopeAccountOptions builder
     */
    public Builder iamId(String iamId) {
      this.iamId = iamId;
      return this;
    }
  }

  protected GetAllPreferencesOnScopeAccountOptions() { }

  protected GetAllPreferencesOnScopeAccountOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.iamId,
      "iamId cannot be empty");
    accountId = builder.accountId;
    iamId = builder.iamId;
  }

  /**
   * New builder.
   *
   * @return a GetAllPreferencesOnScopeAccountOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * Account id to get preferences for.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the iamId.
   *
   * IAM id to get the preferences for.
   *
   * @return the iamId
   */
  public String iamId() {
    return iamId;
  }
}

