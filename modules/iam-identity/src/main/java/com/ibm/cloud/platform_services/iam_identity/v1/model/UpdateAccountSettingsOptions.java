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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateAccountSettings options.
 */
public class UpdateAccountSettingsOptions extends GenericModel {

  /**
   * Defines whether or not creating a service ID is access controlled. Valid values:
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
   * Defines whether or not creating platform API keys is access controlled. Valid values:
   *   * RESTRICTED - only users assigned the 'User API key creator' role on the IAM Identity Service can create API
   * keys, including the account owner
   *   * NOT_RESTRICTED - all members of an account can create platform API keys
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
   * Defines the MFA trait for the account. Valid values:
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

  protected String ifMatch;
  protected String accountId;
  protected String restrictCreateServiceId;
  protected String restrictCreatePlatformApikey;
  protected String allowedIpAddresses;
  protected String mfa;
  protected List<AccountSettingsUserMFA> userMfa;
  protected String sessionExpirationInSeconds;
  protected String sessionInvalidationInSeconds;
  protected String maxSessionsPerIdentity;
  protected String systemAccessTokenExpirationInSeconds;
  protected String systemRefreshTokenExpirationInSeconds;

  /**
   * Builder.
   */
  public static class Builder {
    private String ifMatch;
    private String accountId;
    private String restrictCreateServiceId;
    private String restrictCreatePlatformApikey;
    private String allowedIpAddresses;
    private String mfa;
    private List<AccountSettingsUserMFA> userMfa;
    private String sessionExpirationInSeconds;
    private String sessionInvalidationInSeconds;
    private String maxSessionsPerIdentity;
    private String systemAccessTokenExpirationInSeconds;
    private String systemRefreshTokenExpirationInSeconds;

    /**
     * Instantiates a new Builder from an existing UpdateAccountSettingsOptions instance.
     *
     * @param updateAccountSettingsOptions the instance to initialize the Builder with
     */
    private Builder(UpdateAccountSettingsOptions updateAccountSettingsOptions) {
      this.ifMatch = updateAccountSettingsOptions.ifMatch;
      this.accountId = updateAccountSettingsOptions.accountId;
      this.restrictCreateServiceId = updateAccountSettingsOptions.restrictCreateServiceId;
      this.restrictCreatePlatformApikey = updateAccountSettingsOptions.restrictCreatePlatformApikey;
      this.allowedIpAddresses = updateAccountSettingsOptions.allowedIpAddresses;
      this.mfa = updateAccountSettingsOptions.mfa;
      this.userMfa = updateAccountSettingsOptions.userMfa;
      this.sessionExpirationInSeconds = updateAccountSettingsOptions.sessionExpirationInSeconds;
      this.sessionInvalidationInSeconds = updateAccountSettingsOptions.sessionInvalidationInSeconds;
      this.maxSessionsPerIdentity = updateAccountSettingsOptions.maxSessionsPerIdentity;
      this.systemAccessTokenExpirationInSeconds = updateAccountSettingsOptions.systemAccessTokenExpirationInSeconds;
      this.systemRefreshTokenExpirationInSeconds = updateAccountSettingsOptions.systemRefreshTokenExpirationInSeconds;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param ifMatch the ifMatch
     * @param accountId the accountId
     */
    public Builder(String ifMatch, String accountId) {
      this.ifMatch = ifMatch;
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
     * Adds an userMfa to userMfa.
     *
     * @param userMfa the new userMfa
     * @return the UpdateAccountSettingsOptions builder
     */
    public Builder addUserMfa(AccountSettingsUserMFA userMfa) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(userMfa,
        "userMfa cannot be null");
      if (this.userMfa == null) {
        this.userMfa = new ArrayList<AccountSettingsUserMFA>();
      }
      this.userMfa.add(userMfa);
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the UpdateAccountSettingsOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
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
     * Set the restrictCreateServiceId.
     *
     * @param restrictCreateServiceId the restrictCreateServiceId
     * @return the UpdateAccountSettingsOptions builder
     */
    public Builder restrictCreateServiceId(String restrictCreateServiceId) {
      this.restrictCreateServiceId = restrictCreateServiceId;
      return this;
    }

    /**
     * Set the restrictCreatePlatformApikey.
     *
     * @param restrictCreatePlatformApikey the restrictCreatePlatformApikey
     * @return the UpdateAccountSettingsOptions builder
     */
    public Builder restrictCreatePlatformApikey(String restrictCreatePlatformApikey) {
      this.restrictCreatePlatformApikey = restrictCreatePlatformApikey;
      return this;
    }

    /**
     * Set the allowedIpAddresses.
     *
     * @param allowedIpAddresses the allowedIpAddresses
     * @return the UpdateAccountSettingsOptions builder
     */
    public Builder allowedIpAddresses(String allowedIpAddresses) {
      this.allowedIpAddresses = allowedIpAddresses;
      return this;
    }

    /**
     * Set the mfa.
     *
     * @param mfa the mfa
     * @return the UpdateAccountSettingsOptions builder
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
     * @return the UpdateAccountSettingsOptions builder
     */
    public Builder userMfa(List<AccountSettingsUserMFA> userMfa) {
      this.userMfa = userMfa;
      return this;
    }

    /**
     * Set the sessionExpirationInSeconds.
     *
     * @param sessionExpirationInSeconds the sessionExpirationInSeconds
     * @return the UpdateAccountSettingsOptions builder
     */
    public Builder sessionExpirationInSeconds(String sessionExpirationInSeconds) {
      this.sessionExpirationInSeconds = sessionExpirationInSeconds;
      return this;
    }

    /**
     * Set the sessionInvalidationInSeconds.
     *
     * @param sessionInvalidationInSeconds the sessionInvalidationInSeconds
     * @return the UpdateAccountSettingsOptions builder
     */
    public Builder sessionInvalidationInSeconds(String sessionInvalidationInSeconds) {
      this.sessionInvalidationInSeconds = sessionInvalidationInSeconds;
      return this;
    }

    /**
     * Set the maxSessionsPerIdentity.
     *
     * @param maxSessionsPerIdentity the maxSessionsPerIdentity
     * @return the UpdateAccountSettingsOptions builder
     */
    public Builder maxSessionsPerIdentity(String maxSessionsPerIdentity) {
      this.maxSessionsPerIdentity = maxSessionsPerIdentity;
      return this;
    }

    /**
     * Set the systemAccessTokenExpirationInSeconds.
     *
     * @param systemAccessTokenExpirationInSeconds the systemAccessTokenExpirationInSeconds
     * @return the UpdateAccountSettingsOptions builder
     */
    public Builder systemAccessTokenExpirationInSeconds(String systemAccessTokenExpirationInSeconds) {
      this.systemAccessTokenExpirationInSeconds = systemAccessTokenExpirationInSeconds;
      return this;
    }

    /**
     * Set the systemRefreshTokenExpirationInSeconds.
     *
     * @param systemRefreshTokenExpirationInSeconds the systemRefreshTokenExpirationInSeconds
     * @return the UpdateAccountSettingsOptions builder
     */
    public Builder systemRefreshTokenExpirationInSeconds(String systemRefreshTokenExpirationInSeconds) {
      this.systemRefreshTokenExpirationInSeconds = systemRefreshTokenExpirationInSeconds;
      return this;
    }
  }

  protected UpdateAccountSettingsOptions() { }

  protected UpdateAccountSettingsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ifMatch,
      "ifMatch cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    ifMatch = builder.ifMatch;
    accountId = builder.accountId;
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
   * Gets the ifMatch.
   *
   * Version of the account settings to be updated. Specify the version that you retrieved as entity_tag (ETag header)
   * when reading the account. This value helps identifying parallel usage of this API. Pass * to indicate to update any
   * version available. This might result in stale updates.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
  }

  /**
   * Gets the accountId.
   *
   * The id of the account to update the settings for.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the restrictCreateServiceId.
   *
   * Defines whether or not creating a service ID is access controlled. Valid values:
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
   * Defines whether or not creating platform API keys is access controlled. Valid values:
   *   * RESTRICTED - only users assigned the 'User API key creator' role on the IAM Identity Service can create API
   * keys, including the account owner
   *   * NOT_RESTRICTED - all members of an account can create platform API keys
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
   * Defines the MFA trait for the account. Valid values:
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
  public List<AccountSettingsUserMFA> userMfa() {
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
   * Defines the max allowed sessions per identity required by the account. Value values:
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
}

