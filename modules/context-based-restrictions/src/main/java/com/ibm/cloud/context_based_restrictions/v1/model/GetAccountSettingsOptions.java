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
 * The getAccountSettings options.
 */
public class GetAccountSettingsOptions extends GenericModel {

  protected String accountId;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String transactionId;

    private Builder(GetAccountSettingsOptions getAccountSettingsOptions) {
      this.accountId = getAccountSettingsOptions.accountId;
      this.transactionId = getAccountSettingsOptions.transactionId;
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
     * Builds a GetAccountSettingsOptions.
     *
     * @return the new GetAccountSettingsOptions instance
     */
    public GetAccountSettingsOptions build() {
      return new GetAccountSettingsOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the GetAccountSettingsOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the GetAccountSettingsOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected GetAccountSettingsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    accountId = builder.accountId;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a GetAccountSettingsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * The ID of the account the settings are for.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
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

