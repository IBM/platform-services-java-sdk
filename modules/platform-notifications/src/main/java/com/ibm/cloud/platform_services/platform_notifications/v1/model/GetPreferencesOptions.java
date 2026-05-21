/*
 * (C) Copyright IBM Corp. 2026.
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

package com.ibm.cloud.platform_services.platform_notifications.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getPreferences options.
 */
public class GetPreferencesOptions extends GenericModel {

  protected String iamId;
  protected String accountId;

  /**
   * Builder.
   */
  public static class Builder {
    private String iamId;
    private String accountId;

    /**
     * Instantiates a new Builder from an existing GetPreferencesOptions instance.
     *
     * @param getPreferencesOptions the instance to initialize the Builder with
     */
    private Builder(GetPreferencesOptions getPreferencesOptions) {
      this.iamId = getPreferencesOptions.iamId;
      this.accountId = getPreferencesOptions.accountId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param iamId the iamId
     */
    public Builder(String iamId) {
      this.iamId = iamId;
    }

    /**
     * Builds a GetPreferencesOptions.
     *
     * @return the new GetPreferencesOptions instance
     */
    public GetPreferencesOptions build() {
      return new GetPreferencesOptions(this);
    }

    /**
     * Set the iamId.
     *
     * @param iamId the iamId
     * @return the GetPreferencesOptions builder
     */
    public Builder iamId(String iamId) {
      this.iamId = iamId;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the GetPreferencesOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }
  }

  protected GetPreferencesOptions() { }

  protected GetPreferencesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.iamId,
      "iamId cannot be empty");
    iamId = builder.iamId;
    accountId = builder.accountId;
  }

  /**
   * New builder.
   *
   * @return a GetPreferencesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the iamId.
   *
   * The IAM ID of the user. Must match the IAM ID in the bearer token.
   *
   * @return the iamId
   */
  public String iamId() {
    return iamId;
  }

  /**
   * Gets the accountId.
   *
   * The IBM Cloud account ID. If not provided, the account ID from the bearer token will be used.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }
}

