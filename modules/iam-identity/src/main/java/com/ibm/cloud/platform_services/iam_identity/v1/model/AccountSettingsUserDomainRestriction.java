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

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Input body parameters for the Account Settings REST request.
 */
public class AccountSettingsUserDomainRestriction extends GenericModel {

  @SerializedName("realm_id")
  protected String realmId;
  @SerializedName("invitation_email_allow_patterns")
  protected List<String> invitationEmailAllowPatterns;
  @SerializedName("restrict_invitation")
  protected Boolean restrictInvitation;

  /**
   * Builder.
   */
  public static class Builder {
    private String realmId;
    private List<String> invitationEmailAllowPatterns;
    private Boolean restrictInvitation;

    /**
     * Instantiates a new Builder from an existing AccountSettingsUserDomainRestriction instance.
     *
     * @param accountSettingsUserDomainRestriction the instance to initialize the Builder with
     */
    private Builder(AccountSettingsUserDomainRestriction accountSettingsUserDomainRestriction) {
      this.realmId = accountSettingsUserDomainRestriction.realmId;
      this.invitationEmailAllowPatterns = accountSettingsUserDomainRestriction.invitationEmailAllowPatterns;
      this.restrictInvitation = accountSettingsUserDomainRestriction.restrictInvitation;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param realmId the realmId
     */
    public Builder(String realmId) {
      this.realmId = realmId;
    }

    /**
     * Builds a AccountSettingsUserDomainRestriction.
     *
     * @return the new AccountSettingsUserDomainRestriction instance
     */
    public AccountSettingsUserDomainRestriction build() {
      return new AccountSettingsUserDomainRestriction(this);
    }

    /**
     * Adds a new element to invitationEmailAllowPatterns.
     *
     * @param invitationEmailAllowPatterns the new element to be added
     * @return the AccountSettingsUserDomainRestriction builder
     */
    public Builder addInvitationEmailAllowPatterns(String invitationEmailAllowPatterns) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(invitationEmailAllowPatterns,
        "invitationEmailAllowPatterns cannot be null");
      if (this.invitationEmailAllowPatterns == null) {
        this.invitationEmailAllowPatterns = new ArrayList<String>();
      }
      this.invitationEmailAllowPatterns.add(invitationEmailAllowPatterns);
      return this;
    }

    /**
     * Set the realmId.
     *
     * @param realmId the realmId
     * @return the AccountSettingsUserDomainRestriction builder
     */
    public Builder realmId(String realmId) {
      this.realmId = realmId;
      return this;
    }

    /**
     * Set the invitationEmailAllowPatterns.
     * Existing invitationEmailAllowPatterns will be replaced.
     *
     * @param invitationEmailAllowPatterns the invitationEmailAllowPatterns
     * @return the AccountSettingsUserDomainRestriction builder
     */
    public Builder invitationEmailAllowPatterns(List<String> invitationEmailAllowPatterns) {
      this.invitationEmailAllowPatterns = invitationEmailAllowPatterns;
      return this;
    }

    /**
     * Set the restrictInvitation.
     *
     * @param restrictInvitation the restrictInvitation
     * @return the AccountSettingsUserDomainRestriction builder
     */
    public Builder restrictInvitation(Boolean restrictInvitation) {
      this.restrictInvitation = restrictInvitation;
      return this;
    }
  }

  protected AccountSettingsUserDomainRestriction() { }

  protected AccountSettingsUserDomainRestriction(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.realmId,
      "realmId cannot be null");
    realmId = builder.realmId;
    invitationEmailAllowPatterns = builder.invitationEmailAllowPatterns;
    restrictInvitation = builder.restrictInvitation;
  }

  /**
   * New builder.
   *
   * @return a AccountSettingsUserDomainRestriction builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the realmId.
   *
   * The realm that the restrictions apply to.
   *
   * @return the realmId
   */
  public String realmId() {
    return realmId;
  }

  /**
   * Gets the invitationEmailAllowPatterns.
   *
   * The list of allowed email patterns. Wildcard syntax is supported, '*' represents any sequence of zero or more
   * characters in the string, except for '.' and '@'. The sequence ends if a '.' or '@' was found. '**' represents any
   * sequence of zero or more characters in the string - without limit.
   *
   * @return the invitationEmailAllowPatterns
   */
  public List<String> invitationEmailAllowPatterns() {
    return invitationEmailAllowPatterns;
  }

  /**
   * Gets the restrictInvitation.
   *
   * When true invites will only be possible to the domain patterns provided, otherwise invites are unrestricted.
   *
   * @return the restrictInvitation
   */
  public Boolean restrictInvitation() {
    return restrictInvitation;
  }
}

