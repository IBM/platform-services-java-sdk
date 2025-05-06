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

package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateSettings options.
 */
public class UpdateSettingsOptions extends GenericModel {

  protected String accountId;
  protected String ifMatch;
  protected ExternalAccountIdentityInteractionPatch externalAccountIdentityInteraction;
  protected String acceptLanguage;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String ifMatch;
    private ExternalAccountIdentityInteractionPatch externalAccountIdentityInteraction;
    private String acceptLanguage;

    /**
     * Instantiates a new Builder from an existing UpdateSettingsOptions instance.
     *
     * @param updateSettingsOptions the instance to initialize the Builder with
     */
    private Builder(UpdateSettingsOptions updateSettingsOptions) {
      this.accountId = updateSettingsOptions.accountId;
      this.ifMatch = updateSettingsOptions.ifMatch;
      this.externalAccountIdentityInteraction = updateSettingsOptions.externalAccountIdentityInteraction;
      this.acceptLanguage = updateSettingsOptions.acceptLanguage;
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
     * @param ifMatch the ifMatch
     */
    public Builder(String accountId, String ifMatch) {
      this.accountId = accountId;
      this.ifMatch = ifMatch;
    }

    /**
     * Builds a UpdateSettingsOptions.
     *
     * @return the new UpdateSettingsOptions instance
     */
    public UpdateSettingsOptions build() {
      return new UpdateSettingsOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the UpdateSettingsOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the UpdateSettingsOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the externalAccountIdentityInteraction.
     *
     * @param externalAccountIdentityInteraction the externalAccountIdentityInteraction
     * @return the UpdateSettingsOptions builder
     */
    public Builder externalAccountIdentityInteraction(ExternalAccountIdentityInteractionPatch externalAccountIdentityInteraction) {
      this.externalAccountIdentityInteraction = externalAccountIdentityInteraction;
      return this;
    }

    /**
     * Set the acceptLanguage.
     *
     * @param acceptLanguage the acceptLanguage
     * @return the UpdateSettingsOptions builder
     */
    public Builder acceptLanguage(String acceptLanguage) {
      this.acceptLanguage = acceptLanguage;
      return this;
    }
  }

  protected UpdateSettingsOptions() { }

  protected UpdateSettingsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ifMatch,
      "ifMatch cannot be null");
    accountId = builder.accountId;
    ifMatch = builder.ifMatch;
    externalAccountIdentityInteraction = builder.externalAccountIdentityInteraction;
    acceptLanguage = builder.acceptLanguage;
  }

  /**
   * New builder.
   *
   * @return a UpdateSettingsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * The account GUID that the settings belong to.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the ifMatch.
   *
   * The revision number for updating Access Management Account Settings and must match the Etag value of the existing
   * Access Management Account Settings. The Etag can be retrieved using the GET
   * /v1/accounts/{account_id}/settings/access_management API and looking at the Etag response header.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
  }

  /**
   * Gets the externalAccountIdentityInteraction.
   *
   * Update to how external accounts can interact in relation to the requested account.
   *
   * @return the externalAccountIdentityInteraction
   */
  public ExternalAccountIdentityInteractionPatch externalAccountIdentityInteraction() {
    return externalAccountIdentityInteraction;
  }

  /**
   * Gets the acceptLanguage.
   *
   * Language code for translations
   * * `default` - English
   * * `de` -  German (Standard)
   * * `en` - English
   * * `es` - Spanish (Spain)
   * * `fr` - French (Standard)
   * * `it` - Italian (Standard)
   * * `ja` - Japanese
   * * `ko` - Korean
   * * `pt-br` - Portuguese (Brazil)
   * * `zh-cn` - Chinese (Simplified, PRC)
   * * `zh-tw` - (Chinese, Taiwan).
   *
   * @return the acceptLanguage
   */
  public String acceptLanguage() {
    return acceptLanguage;
  }
}

