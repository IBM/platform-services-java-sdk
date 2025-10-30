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
public class TemplateAccountSettings extends GenericModel {

  /**
   * Defines whether or not creating the resource is access controlled. Valid values:
   *   * RESTRICTED - only users assigned the 'Service ID creator' role on the IAM Identity Service can create service
   * IDs, including the account owner
   *   * NOT_RESTRICTED - all members of an account can create service IDs
   *   * NOT_SET - to 'unset' a previous set value.
   */
  public interface RestrictCreateServiceId {
    /** RESTRICTED. */
    String RESTRICTED = "RESTRICTED";
    /** NOT_RESTRICTED. */
    String NOT_RESTRICTED = "NOT_RESTRICTED";
    /** NOT_SET. */
    String NOT_SET = "NOT_SET";
  }

  /**
   * Defines whether or not creating the resource is access controlled. Valid values:
   *   * RESTRICTED - only users assigned the 'Service ID creator' role on the IAM Identity Service can create service
   * IDs, including the account owner
   *   * NOT_RESTRICTED - all members of an account can create service IDs
   *   * NOT_SET - to 'unset' a previous set value.
   */
  public interface RestrictCreatePlatformApikey {
    /** RESTRICTED. */
    String RESTRICTED = "RESTRICTED";
    /** NOT_RESTRICTED. */
    String NOT_RESTRICTED = "NOT_RESTRICTED";
    /** NOT_SET. */
    String NOT_SET = "NOT_SET";
  }

  /**
   * MFA trait definitions as follows:
   *   * NONE - No MFA trait set
   *   * NONE_NO_ROPC- No MFA, disable CLI logins with only a password
   *   * TOTP - For all non-federated IBMId users
   *   * TOTP4ALL - For all users
   *   * LEVEL1 - Email-based MFA for all users
   *   * LEVEL2 - TOTP-based MFA for all users
   *   * LEVEL3 - U2F MFA for all users.
   */
  public interface Mfa {
    /** NONE. */
    String NONE = "NONE";
    /** NONE_NO_ROPC. */
    String NONE_NO_ROPC = "NONE_NO_ROPC";
    /** TOTP. */
    String TOTP = "TOTP";
    /** TOTP4ALL. */
    String TOTP4ALL = "TOTP4ALL";
    /** LEVEL1. */
    String LEVEL1 = "LEVEL1";
    /** LEVEL2. */
    String LEVEL2 = "LEVEL2";
    /** LEVEL3. */
    String LEVEL3 = "LEVEL3";
  }

  /**
   * Defines whether or not user visibility is access controlled. Valid values:
   *   * RESTRICTED - users can view only specific types of users in the account, such as those the user has invited to
   * the account, or descendants of those users based on the classic infrastructure hierarchy
   *   * NOT_RESTRICTED - any user in the account can view other users from the Users page in IBM Cloud console
   *   * NOT_SET - to 'unset' a previous set value.
   */
  public interface RestrictUserListVisibility {
    /** RESTRICTED. */
    String RESTRICTED = "RESTRICTED";
    /** NOT_RESTRICTED. */
    String NOT_RESTRICTED = "NOT_RESTRICTED";
    /** NOT_SET. */
    String NOT_SET = "NOT_SET";
  }

  @SerializedName("restrict_create_service_id")
  protected String restrictCreateServiceId;
  @SerializedName("restrict_create_platform_apikey")
  protected String restrictCreatePlatformApikey;
  @SerializedName("allowed_ip_addresses")
  protected String allowedIpAddresses;
  protected String mfa;
  @SerializedName("user_mfa")
  protected List<UserMfa> userMfa;
  @SerializedName("session_expiration_in_seconds")
  protected String sessionExpirationInSeconds;
  @SerializedName("session_invalidation_in_seconds")
  protected String sessionInvalidationInSeconds;
  @SerializedName("max_sessions_per_identity")
  protected String maxSessionsPerIdentity;
  @SerializedName("system_access_token_expiration_in_seconds")
  protected String systemAccessTokenExpirationInSeconds;
  @SerializedName("system_refresh_token_expiration_in_seconds")
  protected String systemRefreshTokenExpirationInSeconds;
  @SerializedName("restrict_user_list_visibility")
  protected String restrictUserListVisibility;
  @SerializedName("restrict_user_domains")
  protected TemplateAccountSettingsRestrictUserDomains restrictUserDomains;

  /**
   * Builder.
   */
  public static class Builder {
    private String restrictCreateServiceId;
    private String restrictCreatePlatformApikey;
    private String allowedIpAddresses;
    private String mfa;
    private List<UserMfa> userMfa;
    private String sessionExpirationInSeconds;
    private String sessionInvalidationInSeconds;
    private String maxSessionsPerIdentity;
    private String systemAccessTokenExpirationInSeconds;
    private String systemRefreshTokenExpirationInSeconds;
    private String restrictUserListVisibility;
    private TemplateAccountSettingsRestrictUserDomains restrictUserDomains;

    /**
     * Instantiates a new Builder from an existing TemplateAccountSettings instance.
     *
     * @param templateAccountSettings the instance to initialize the Builder with
     */
    private Builder(TemplateAccountSettings templateAccountSettings) {
      this.restrictCreateServiceId = templateAccountSettings.restrictCreateServiceId;
      this.restrictCreatePlatformApikey = templateAccountSettings.restrictCreatePlatformApikey;
      this.allowedIpAddresses = templateAccountSettings.allowedIpAddresses;
      this.mfa = templateAccountSettings.mfa;
      this.userMfa = templateAccountSettings.userMfa;
      this.sessionExpirationInSeconds = templateAccountSettings.sessionExpirationInSeconds;
      this.sessionInvalidationInSeconds = templateAccountSettings.sessionInvalidationInSeconds;
      this.maxSessionsPerIdentity = templateAccountSettings.maxSessionsPerIdentity;
      this.systemAccessTokenExpirationInSeconds = templateAccountSettings.systemAccessTokenExpirationInSeconds;
      this.systemRefreshTokenExpirationInSeconds = templateAccountSettings.systemRefreshTokenExpirationInSeconds;
      this.restrictUserListVisibility = templateAccountSettings.restrictUserListVisibility;
      this.restrictUserDomains = templateAccountSettings.restrictUserDomains;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a TemplateAccountSettings.
     *
     * @return the new TemplateAccountSettings instance
     */
    public TemplateAccountSettings build() {
      return new TemplateAccountSettings(this);
    }

    /**
     * Adds a new element to userMfa.
     *
     * @param userMfa the new element to be added
     * @return the TemplateAccountSettings builder
     */
    public Builder addUserMfa(UserMfa userMfa) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(userMfa,
        "userMfa cannot be null");
      if (this.userMfa == null) {
        this.userMfa = new ArrayList<UserMfa>();
      }
      this.userMfa.add(userMfa);
      return this;
    }

    /**
     * Set the restrictCreateServiceId.
     *
     * @param restrictCreateServiceId the restrictCreateServiceId
     * @return the TemplateAccountSettings builder
     */
    public Builder restrictCreateServiceId(String restrictCreateServiceId) {
      this.restrictCreateServiceId = restrictCreateServiceId;
      return this;
    }

    /**
     * Set the restrictCreatePlatformApikey.
     *
     * @param restrictCreatePlatformApikey the restrictCreatePlatformApikey
     * @return the TemplateAccountSettings builder
     */
    public Builder restrictCreatePlatformApikey(String restrictCreatePlatformApikey) {
      this.restrictCreatePlatformApikey = restrictCreatePlatformApikey;
      return this;
    }

    /**
     * Set the allowedIpAddresses.
     *
     * @param allowedIpAddresses the allowedIpAddresses
     * @return the TemplateAccountSettings builder
     */
    public Builder allowedIpAddresses(String allowedIpAddresses) {
      this.allowedIpAddresses = allowedIpAddresses;
      return this;
    }

    /**
     * Set the mfa.
     *
     * @param mfa the mfa
     * @return the TemplateAccountSettings builder
     */
    public Builder mfa(String mfa) {
      this.mfa = mfa;
      return this;
    }

    /**
     * Set the userMfa.
     * Existing userMfa will be replaced.
     *
     * @param userMfa the userMfa
     * @return the TemplateAccountSettings builder
     */
    public Builder userMfa(List<UserMfa> userMfa) {
      this.userMfa = userMfa;
      return this;
    }

    /**
     * Set the sessionExpirationInSeconds.
     *
     * @param sessionExpirationInSeconds the sessionExpirationInSeconds
     * @return the TemplateAccountSettings builder
     */
    public Builder sessionExpirationInSeconds(String sessionExpirationInSeconds) {
      this.sessionExpirationInSeconds = sessionExpirationInSeconds;
      return this;
    }

    /**
     * Set the sessionInvalidationInSeconds.
     *
     * @param sessionInvalidationInSeconds the sessionInvalidationInSeconds
     * @return the TemplateAccountSettings builder
     */
    public Builder sessionInvalidationInSeconds(String sessionInvalidationInSeconds) {
      this.sessionInvalidationInSeconds = sessionInvalidationInSeconds;
      return this;
    }

    /**
     * Set the maxSessionsPerIdentity.
     *
     * @param maxSessionsPerIdentity the maxSessionsPerIdentity
     * @return the TemplateAccountSettings builder
     */
    public Builder maxSessionsPerIdentity(String maxSessionsPerIdentity) {
      this.maxSessionsPerIdentity = maxSessionsPerIdentity;
      return this;
    }

    /**
     * Set the systemAccessTokenExpirationInSeconds.
     *
     * @param systemAccessTokenExpirationInSeconds the systemAccessTokenExpirationInSeconds
     * @return the TemplateAccountSettings builder
     */
    public Builder systemAccessTokenExpirationInSeconds(String systemAccessTokenExpirationInSeconds) {
      this.systemAccessTokenExpirationInSeconds = systemAccessTokenExpirationInSeconds;
      return this;
    }

    /**
     * Set the systemRefreshTokenExpirationInSeconds.
     *
     * @param systemRefreshTokenExpirationInSeconds the systemRefreshTokenExpirationInSeconds
     * @return the TemplateAccountSettings builder
     */
    public Builder systemRefreshTokenExpirationInSeconds(String systemRefreshTokenExpirationInSeconds) {
      this.systemRefreshTokenExpirationInSeconds = systemRefreshTokenExpirationInSeconds;
      return this;
    }

    /**
     * Set the restrictUserListVisibility.
     *
     * @param restrictUserListVisibility the restrictUserListVisibility
     * @return the TemplateAccountSettings builder
     */
    public Builder restrictUserListVisibility(String restrictUserListVisibility) {
      this.restrictUserListVisibility = restrictUserListVisibility;
      return this;
    }

    /**
     * Set the restrictUserDomains.
     *
     * @param restrictUserDomains the restrictUserDomains
     * @return the TemplateAccountSettings builder
     */
    public Builder restrictUserDomains(TemplateAccountSettingsRestrictUserDomains restrictUserDomains) {
      this.restrictUserDomains = restrictUserDomains;
      return this;
    }
  }

  protected TemplateAccountSettings() { }

  protected TemplateAccountSettings(Builder builder) {
    restrictCreateServiceId = builder.restrictCreateServiceId;
    restrictCreatePlatformApikey = builder.restrictCreatePlatformApikey;
    allowedIpAddresses = builder.allowedIpAddresses;
    mfa = builder.mfa;
    userMfa = builder.userMfa;
    sessionExpirationInSeconds = builder.sessionExpirationInSeconds;
    sessionInvalidationInSeconds = builder.sessionInvalidationInSeconds;
    maxSessionsPerIdentity = builder.maxSessionsPerIdentity;
    systemAccessTokenExpirationInSeconds = builder.systemAccessTokenExpirationInSeconds;
    systemRefreshTokenExpirationInSeconds = builder.systemRefreshTokenExpirationInSeconds;
    restrictUserListVisibility = builder.restrictUserListVisibility;
    restrictUserDomains = builder.restrictUserDomains;
  }

  /**
   * New builder.
   *
   * @return a TemplateAccountSettings builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the restrictCreateServiceId.
   *
   * Defines whether or not creating the resource is access controlled. Valid values:
   *   * RESTRICTED - only users assigned the 'Service ID creator' role on the IAM Identity Service can create service
   * IDs, including the account owner
   *   * NOT_RESTRICTED - all members of an account can create service IDs
   *   * NOT_SET - to 'unset' a previous set value.
   *
   * @return the restrictCreateServiceId
   */
  public String restrictCreateServiceId() {
    return restrictCreateServiceId;
  }

  /**
   * Gets the restrictCreatePlatformApikey.
   *
   * Defines whether or not creating the resource is access controlled. Valid values:
   *   * RESTRICTED - only users assigned the 'Service ID creator' role on the IAM Identity Service can create service
   * IDs, including the account owner
   *   * NOT_RESTRICTED - all members of an account can create service IDs
   *   * NOT_SET - to 'unset' a previous set value.
   *
   * @return the restrictCreatePlatformApikey
   */
  public String restrictCreatePlatformApikey() {
    return restrictCreatePlatformApikey;
  }

  /**
   * Gets the allowedIpAddresses.
   *
   * Defines the IP addresses and subnets from which IAM tokens can be created for the account.
   *
   * @return the allowedIpAddresses
   */
  public String allowedIpAddresses() {
    return allowedIpAddresses;
  }

  /**
   * Gets the mfa.
   *
   * MFA trait definitions as follows:
   *   * NONE - No MFA trait set
   *   * NONE_NO_ROPC- No MFA, disable CLI logins with only a password
   *   * TOTP - For all non-federated IBMId users
   *   * TOTP4ALL - For all users
   *   * LEVEL1 - Email-based MFA for all users
   *   * LEVEL2 - TOTP-based MFA for all users
   *   * LEVEL3 - U2F MFA for all users.
   *
   * @return the mfa
   */
  public String mfa() {
    return mfa;
  }

  /**
   * Gets the userMfa.
   *
   * List of users that are exempted from the MFA requirement of the account.
   *
   * @return the userMfa
   */
  public List<UserMfa> userMfa() {
    return userMfa;
  }

  /**
   * Gets the sessionExpirationInSeconds.
   *
   * Defines the session expiration in seconds for the account. Valid values:
   *   * Any whole number between between '900' and '86400'
   *   * NOT_SET - To unset account setting and use service default.
   *
   * @return the sessionExpirationInSeconds
   */
  public String sessionExpirationInSeconds() {
    return sessionExpirationInSeconds;
  }

  /**
   * Gets the sessionInvalidationInSeconds.
   *
   * Defines the period of time in seconds in which a session will be invalidated due to inactivity. Valid values:
   *   * Any whole number between '900' and '7200'
   *   * NOT_SET - To unset account setting and use service default.
   *
   * @return the sessionInvalidationInSeconds
   */
  public String sessionInvalidationInSeconds() {
    return sessionInvalidationInSeconds;
  }

  /**
   * Gets the maxSessionsPerIdentity.
   *
   * Defines the max allowed sessions per identity required by the account. Valid values:
   *   * Any whole number greater than 0
   *   * NOT_SET - To unset account setting and use service default.
   *
   * @return the maxSessionsPerIdentity
   */
  public String maxSessionsPerIdentity() {
    return maxSessionsPerIdentity;
  }

  /**
   * Gets the systemAccessTokenExpirationInSeconds.
   *
   * Defines the access token expiration in seconds. Valid values:
   *   * Any whole number between '900' and '3600'
   *   * NOT_SET - To unset account setting and use service default.
   *
   * @return the systemAccessTokenExpirationInSeconds
   */
  public String systemAccessTokenExpirationInSeconds() {
    return systemAccessTokenExpirationInSeconds;
  }

  /**
   * Gets the systemRefreshTokenExpirationInSeconds.
   *
   * Defines the refresh token expiration in seconds. Valid values:
   *   * Any whole number between '900' and '259200'
   *   * NOT_SET - To unset account setting and use service default.
   *
   * @return the systemRefreshTokenExpirationInSeconds
   */
  public String systemRefreshTokenExpirationInSeconds() {
    return systemRefreshTokenExpirationInSeconds;
  }

  /**
   * Gets the restrictUserListVisibility.
   *
   * Defines whether or not user visibility is access controlled. Valid values:
   *   * RESTRICTED - users can view only specific types of users in the account, such as those the user has invited to
   * the account, or descendants of those users based on the classic infrastructure hierarchy
   *   * NOT_RESTRICTED - any user in the account can view other users from the Users page in IBM Cloud console
   *   * NOT_SET - to 'unset' a previous set value.
   *
   * @return the restrictUserListVisibility
   */
  public String restrictUserListVisibility() {
    return restrictUserListVisibility;
  }

  /**
   * Gets the restrictUserDomains.
   *
   * @return the restrictUserDomains
   */
  public TemplateAccountSettingsRestrictUserDomains restrictUserDomains() {
    return restrictUserDomains;
  }
}

