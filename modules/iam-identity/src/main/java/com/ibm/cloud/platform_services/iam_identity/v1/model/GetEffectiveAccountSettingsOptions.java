/*
 * (C) Copyright IBM Corp. 2024.
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
 * The getEffectiveAccountSettings options.
 */
public class GetEffectiveAccountSettingsOptions extends GenericModel {

  protected String accountId;
  protected Boolean includeHistory;
  protected Boolean resolveUserMfa;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private Boolean includeHistory;
    private Boolean resolveUserMfa;

    /**
     * Instantiates a new Builder from an existing GetEffectiveAccountSettingsOptions instance.
     *
     * @param getEffectiveAccountSettingsOptions the instance to initialize the Builder with
     */
    private Builder(GetEffectiveAccountSettingsOptions getEffectiveAccountSettingsOptions) {
      this.accountId = getEffectiveAccountSettingsOptions.accountId;
      this.includeHistory = getEffectiveAccountSettingsOptions.includeHistory;
      this.resolveUserMfa = getEffectiveAccountSettingsOptions.resolveUserMfa;
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
     * Builds a GetEffectiveAccountSettingsOptions.
     *
     * @return the new GetEffectiveAccountSettingsOptions instance
     */
    public GetEffectiveAccountSettingsOptions build() {
      return new GetEffectiveAccountSettingsOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the GetEffectiveAccountSettingsOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the includeHistory.
     *
     * @param includeHistory the includeHistory
     * @return the GetEffectiveAccountSettingsOptions builder
     */
    public Builder includeHistory(Boolean includeHistory) {
      this.includeHistory = includeHistory;
      return this;
    }

    /**
     * Set the resolveUserMfa.
     *
     * @param resolveUserMfa the resolveUserMfa
     * @return the GetEffectiveAccountSettingsOptions builder
     */
    public Builder resolveUserMfa(Boolean resolveUserMfa) {
      this.resolveUserMfa = resolveUserMfa;
      return this;
    }
  }

  protected GetEffectiveAccountSettingsOptions() { }

  protected GetEffectiveAccountSettingsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    accountId = builder.accountId;
    includeHistory = builder.includeHistory;
    resolveUserMfa = builder.resolveUserMfa;
  }

  /**
   * New builder.
   *
   * @return a GetEffectiveAccountSettingsOptions builder
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

  /**
   * Gets the resolveUserMfa.
   *
   * Enrich MFA exemptions with user information.
   *
   * @return the resolveUserMfa
   */
  public Boolean resolveUserMfa() {
    return resolveUserMfa;
  }
}

