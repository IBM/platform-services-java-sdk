/*
 * (C) Copyright IBM Corp. 2023.
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
 * The getAccountSettings options.
 */
public class GetAccountSettingsOptions extends GenericModel {

  protected String accountId;
  protected Boolean includeHistory;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private Boolean includeHistory;

    /**
     * Instantiates a new Builder from an existing GetAccountSettingsOptions instance.
     *
     * @param getAccountSettingsOptions the instance to initialize the Builder with
     */
    private Builder(GetAccountSettingsOptions getAccountSettingsOptions) {
      this.accountId = getAccountSettingsOptions.accountId;
      this.includeHistory = getAccountSettingsOptions.includeHistory;
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
     * Set the includeHistory.
     *
     * @param includeHistory the includeHistory
     * @return the GetAccountSettingsOptions builder
     */
    public Builder includeHistory(Boolean includeHistory) {
      this.includeHistory = includeHistory;
      return this;
    }
  }

  protected GetAccountSettingsOptions() { }

  protected GetAccountSettingsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    accountId = builder.accountId;
    includeHistory = builder.includeHistory;
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
   * Unique ID of the account.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the includeHistory.
   *
   * Defines if the entity history is included in the response.
   *
   * @return the includeHistory
   */
  public Boolean includeHistory() {
    return includeHistory;
  }
}

