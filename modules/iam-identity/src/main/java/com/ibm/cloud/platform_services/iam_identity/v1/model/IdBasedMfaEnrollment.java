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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * IdBasedMfaEnrollment.
 */
public class IdBasedMfaEnrollment extends GenericModel {

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
  public interface TraitAccountDefault {
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
   * MFA trait definitions as follows:
   *   * NONE - No MFA trait set
   *   * NONE_NO_ROPC- No MFA, disable CLI logins with only a password
   *   * TOTP - For all non-federated IBMId users
   *   * TOTP4ALL - For all users
   *   * LEVEL1 - Email-based MFA for all users
   *   * LEVEL2 - TOTP-based MFA for all users
   *   * LEVEL3 - U2F MFA for all users.
   */
  public interface TraitUserSpecific {
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
   * MFA trait definitions as follows:
   *   * NONE - No MFA trait set
   *   * NONE_NO_ROPC- No MFA, disable CLI logins with only a password
   *   * TOTP - For all non-federated IBMId users
   *   * TOTP4ALL - For all users
   *   * LEVEL1 - Email-based MFA for all users
   *   * LEVEL2 - TOTP-based MFA for all users
   *   * LEVEL3 - U2F MFA for all users.
   */
  public interface TraitEffective {
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
   * Defines comply state for the account. Valid values:
   *   * NO - User does not comply in the given account.
   *   * ACCOUNT- User complies in the given account, but does not comply in at least one of the other account
   * memberships.
   *   * CROSS_ACCOUNT - User complies in the given account and across all other account memberships.
   */
  public interface ComplyState {
    /** NO. */
    String NO = "NO";
    /** ACCOUNT. */
    String ACCOUNT = "ACCOUNT";
    /** CROSS_ACCOUNT. */
    String CROSS_ACCOUNT = "CROSS_ACCOUNT";
  }

  @SerializedName("trait_account_default")
  protected String traitAccountDefault;
  @SerializedName("trait_user_specific")
  protected String traitUserSpecific;
  @SerializedName("trait_effective")
  protected String traitEffective;
  protected Boolean complies;
  @SerializedName("comply_state")
  protected String complyState;

  protected IdBasedMfaEnrollment() { }

  /**
   * Gets the traitAccountDefault.
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
   * @return the traitAccountDefault
   */
  public String getTraitAccountDefault() {
    return traitAccountDefault;
  }

  /**
   * Gets the traitUserSpecific.
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
   * @return the traitUserSpecific
   */
  public String getTraitUserSpecific() {
    return traitUserSpecific;
  }

  /**
   * Gets the traitEffective.
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
   * @return the traitEffective
   */
  public String getTraitEffective() {
    return traitEffective;
  }

  /**
   * Gets the complies.
   *
   * The enrollment complies to the effective requirement.
   *
   * @return the complies
   */
  public Boolean isComplies() {
    return complies;
  }

  /**
   * Gets the complyState.
   *
   * Defines comply state for the account. Valid values:
   *   * NO - User does not comply in the given account.
   *   * ACCOUNT- User complies in the given account, but does not comply in at least one of the other account
   * memberships.
   *   * CROSS_ACCOUNT - User complies in the given account and across all other account memberships.
   *
   * @return the complyState
   */
  public String getComplyState() {
    return complyState;
  }
}

