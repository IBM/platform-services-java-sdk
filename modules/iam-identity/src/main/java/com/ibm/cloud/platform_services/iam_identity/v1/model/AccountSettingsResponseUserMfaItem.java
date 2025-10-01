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
 * AccountSettingsResponseUserMfaItem.
 */
public class AccountSettingsResponseUserMfaItem extends GenericModel {

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

  @SerializedName("iam_id")
  protected String iamId;
  protected String mfa;
  protected String name;
  protected String userName;
  protected String email;
  protected String description;

  protected AccountSettingsResponseUserMfaItem() { }

  /**
   * Gets the iamId.
   *
   * The iam_id of the user.
   *
   * @return the iamId
   */
  public String getIamId() {
    return iamId;
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
  public String getMfa() {
    return mfa;
  }

  /**
   * Gets the name.
   *
   * name of the user account.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the userName.
   *
   * userName of the user.
   *
   * @return the userName
   */
  public String getUserName() {
    return userName;
  }

  /**
   * Gets the email.
   *
   * email of the user.
   *
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Gets the description.
   *
   * optional description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }
}

