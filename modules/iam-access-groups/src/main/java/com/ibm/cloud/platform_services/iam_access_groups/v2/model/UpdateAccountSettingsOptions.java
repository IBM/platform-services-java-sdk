/*
 * (C) Copyright IBM Corp. 2022.
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
 * The updateAccountSettings options.
 */
public class UpdateAccountSettingsOptions extends GenericModel {

  protected String accountId;
  protected Boolean publicAccessEnabled;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private Boolean publicAccessEnabled;
    private String transactionId;

    private Builder(UpdateAccountSettingsOptions updateAccountSettingsOptions) {
      this.accountId = updateAccountSettingsOptions.accountId;
      this.publicAccessEnabled = updateAccountSettingsOptions.publicAccessEnabled;
      this.transactionId = updateAccountSettingsOptions.transactionId;
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
     * Builds a UpdateAccountSettingsOptions.
     *
     * @return the new UpdateAccountSettingsOptions instance
     */
    public UpdateAccountSettingsOptions build() {
      return new UpdateAccountSettingsOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the UpdateAccountSettingsOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the publicAccessEnabled.
     *
     * @param publicAccessEnabled the publicAccessEnabled
     * @return the UpdateAccountSettingsOptions builder
     */
    public Builder publicAccessEnabled(Boolean publicAccessEnabled) {
      this.publicAccessEnabled = publicAccessEnabled;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the UpdateAccountSettingsOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected UpdateAccountSettingsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    accountId = builder.accountId;
    publicAccessEnabled = builder.publicAccessEnabled;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a UpdateAccountSettingsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * Account ID of the API keys(s) to query. If a service IAM ID is specified in iam_id then account_id must match the
   * account of the IAM ID. If a user IAM ID is specified in iam_id then then account_id must match the account of the
   * Authorization token.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the publicAccessEnabled.
   *
   * This flag controls the public access feature within the account. It is set to true by default. Note: When this flag
   * is set to false, all policies within the account attached to the Public Access group will be deleted.
   *
   * @return the publicAccessEnabled
   */
  public Boolean publicAccessEnabled() {
    return publicAccessEnabled;
  }

  /**
   * Gets the transactionId.
   *
   * An optional transaction ID can be passed to your request, which can be useful for tracking calls through multiple
   * services by using one identifier. The header key must be set to Transaction-Id and the value is anything that you
   * choose. If no transaction ID is passed in, then a random ID is generated.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }
}

