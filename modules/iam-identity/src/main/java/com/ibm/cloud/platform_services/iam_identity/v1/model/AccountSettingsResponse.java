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
package com.ibm.cloud.platform_services.iam_identity.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Response body format for Account Settings REST requests.
 */
public class AccountSettingsResponse extends GenericModel {

  /**
   * Defines whether or not creating a Service Id is access controlled. Valid values:
   *   * RESTRICTED - to apply access control
   *   * NOT_RESTRICTED - to remove access control
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
   * Defines whether or not creating a Service Id is access controlled. Valid values:
   *   * RESTRICTED - to apply access control
   *   * NOT_RESTRICTED - to remove access control
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
   *   * TOTP - For all non-federated IBMId users
   *   * TOTP4ALL - For all users
   *   * LEVEL1 - Email-based MFA for all users
   *   * LEVEL2 - TOTP-based MFA for all users
   *   * LEVEL3 - U2F MFA for all users.
   */
  public interface Mfa {
    /** NONE. */
    String NONE = "NONE";
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

  protected ResponseContext context;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("restrict_create_service_id")
  protected String restrictCreateServiceId;
  @SerializedName("restrict_create_platform_apikey")
  protected String restrictCreatePlatformApikey;
  @SerializedName("allowed_ip_addresses")
  protected String allowedIpAddresses;
  @SerializedName("entity_tag")
  protected String entityTag;
  protected String mfa;
  protected List<EnityHistoryRecord> history;
  @SerializedName("session_expiration_in_seconds")
  protected String sessionExpirationInSeconds;
  @SerializedName("session_invalidation_in_seconds")
  protected String sessionInvalidationInSeconds;

  /**
   * Gets the context.
   *
   * Context with key properties for problem determination.
   *
   * @return the context
   */
  public ResponseContext getContext() {
    return context;
  }

  /**
   * Gets the accountId.
   *
   * Unique ID of the account.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the restrictCreateServiceId.
   *
   * Defines whether or not creating a Service Id is access controlled. Valid values:
   *   * RESTRICTED - to apply access control
   *   * NOT_RESTRICTED - to remove access control
   *   * NOT_SET - to 'unset' a previous set value.
   *
   * @return the restrictCreateServiceId
   */
  public String getRestrictCreateServiceId() {
    return restrictCreateServiceId;
  }

  /**
   * Gets the restrictCreatePlatformApikey.
   *
   * Defines whether or not creating a Service Id is access controlled. Valid values:
   *   * RESTRICTED - to apply access control
   *   * NOT_RESTRICTED - to remove access control
   *   * NOT_SET - to 'unset' a previous set value.
   *
   * @return the restrictCreatePlatformApikey
   */
  public String getRestrictCreatePlatformApikey() {
    return restrictCreatePlatformApikey;
  }

  /**
   * Gets the allowedIpAddresses.
   *
   * Defines the IP addresses and subnets from which IAM tokens can be created for the account.
   *
   * @return the allowedIpAddresses
   */
  public String getAllowedIpAddresses() {
    return allowedIpAddresses;
  }

  /**
   * Gets the entityTag.
   *
   * Version of the account settings.
   *
   * @return the entityTag
   */
  public String getEntityTag() {
    return entityTag;
  }

  /**
   * Gets the mfa.
   *
   * Defines the MFA trait for the account. Valid values:
   *   * NONE - No MFA trait set
   *   * TOTP - For all non-federated IBMId users
   *   * TOTP4ALL - For all users
   *   * LEVEL1 - Email-based MFA for all users
   *   * LEVEL2 - TOTP-based MFA for all users
   *   * LEVEL3 - U2F MFA for all users.
   *
   * @return the mfa
   */
  public String getMfa() {
    return mfa;
  }

  /**
   * Gets the history.
   *
   * History of the Account Settings.
   *
   * @return the history
   */
  public List<EnityHistoryRecord> getHistory() {
    return history;
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
  public String getSessionExpirationInSeconds() {
    return sessionExpirationInSeconds;
  }

  /**
   * Gets the sessionInvalidationInSeconds.
   *
   * Defines the period of time in seconds in which a session will be invalidated due  to inactivity. Valid values:
   *   * Any whole number between '900' and '7200'
   *   * NOT_SET - To unset account setting and use service default.
   *
   * @return the sessionInvalidationInSeconds
   */
  public String getSessionInvalidationInSeconds() {
    return sessionInvalidationInSeconds;
  }
}

