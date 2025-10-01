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
 * AccountSettingsUserMFA.
 */
public class AccountSettingsUserMFA extends GenericModel {

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

  /**
   * Builder.
   */
  public static class Builder {
    private String iamId;
    private String mfa;
    private String name;
    private String userName;
    private String email;
    private String description;

    /**
     * Instantiates a new Builder from an existing AccountSettingsUserMFA instance.
     *
     * @param accountSettingsUserMfa the instance to initialize the Builder with
     */
    private Builder(AccountSettingsUserMFA accountSettingsUserMfa) {
      this.iamId = accountSettingsUserMfa.iamId;
      this.mfa = accountSettingsUserMfa.mfa;
      this.name = accountSettingsUserMfa.name;
      this.userName = accountSettingsUserMfa.userName;
      this.email = accountSettingsUserMfa.email;
      this.description = accountSettingsUserMfa.description;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param iamId the iamId
     * @param mfa the mfa
     */
    public Builder(String iamId, String mfa) {
      this.iamId = iamId;
      this.mfa = mfa;
    }

    /**
     * Builds a AccountSettingsUserMFA.
     *
     * @return the new AccountSettingsUserMFA instance
     */
    public AccountSettingsUserMFA build() {
      return new AccountSettingsUserMFA(this);
    }

    /**
     * Set the iamId.
     *
     * @param iamId the iamId
     * @return the AccountSettingsUserMFA builder
     */
    public Builder iamId(String iamId) {
      this.iamId = iamId;
      return this;
    }

    /**
     * Set the mfa.
     *
     * @param mfa the mfa
     * @return the AccountSettingsUserMFA builder
     */
    public Builder mfa(String mfa) {
      this.mfa = mfa;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the AccountSettingsUserMFA builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the userName.
     *
     * @param userName the userName
     * @return the AccountSettingsUserMFA builder
     */
    public Builder userName(String userName) {
      this.userName = userName;
      return this;
    }

    /**
     * Set the email.
     *
     * @param email the email
     * @return the AccountSettingsUserMFA builder
     */
    public Builder email(String email) {
      this.email = email;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the AccountSettingsUserMFA builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }
  }

  protected AccountSettingsUserMFA() { }

  protected AccountSettingsUserMFA(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.iamId,
      "iamId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.mfa,
      "mfa cannot be null");
    iamId = builder.iamId;
    mfa = builder.mfa;
    name = builder.name;
    userName = builder.userName;
    email = builder.email;
    description = builder.description;
  }

  /**
   * New builder.
   *
   * @return a AccountSettingsUserMFA builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the iamId.
   *
   * The iam_id of the user.
   *
   * @return the iamId
   */
  public String iamId() {
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
  public String mfa() {
    return mfa;
  }

  /**
   * Gets the name.
   *
   * name of the user account.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the userName.
   *
   * userName of the user.
   *
   * @return the userName
   */
  public String userName() {
    return userName;
  }

  /**
   * Gets the email.
   *
   * email of the user.
   *
   * @return the email
   */
  public String email() {
    return email;
  }

  /**
   * Gets the description.
   *
   * optional description.
   *
   * @return the description
   */
  public String description() {
    return description;
  }
}

