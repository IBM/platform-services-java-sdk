/*
 * (C) Copyright IBM Corp. 2026.
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
 * UserReportMfaEnrollmentStatus.
 */
public class UserReportMfaEnrollmentStatus extends GenericModel {

  @SerializedName("iam_id")
  protected String iamId;
  protected String name;
  protected String username;
  protected String email;
  @SerializedName("effective_mfa_type")
  protected String effectiveMfaType;
  @SerializedName("id_based_mfa")
  protected IdBasedMfaEnrollment idBasedMfa;
  @SerializedName("account_based_mfa")
  protected AccountBasedMfaEnrollment accountBasedMfa;

  protected UserReportMfaEnrollmentStatus() { }

  /**
   * Gets the iamId.
   *
   * IAMid of the user.
   *
   * @return the iamId
   */
  public String getIamId() {
    return iamId;
  }

  /**
   * Gets the name.
   *
   * Name of the user.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the username.
   *
   * Username of the user.
   *
   * @return the username
   */
  public String getUsername() {
    return username;
  }

  /**
   * Gets the email.
   *
   * Email of the user.
   *
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Gets the effectiveMfaType.
   *
   * currently effective mfa type i.e. id_based_mfa or account_based_mfa.
   *
   * @return the effectiveMfaType
   */
  public String getEffectiveMfaType() {
    return effectiveMfaType;
  }

  /**
   * Gets the idBasedMfa.
   *
   * @return the idBasedMfa
   */
  public IdBasedMfaEnrollment getIdBasedMfa() {
    return idBasedMfa;
  }

  /**
   * Gets the accountBasedMfa.
   *
   * @return the accountBasedMfa
   */
  public AccountBasedMfaEnrollment getAccountBasedMfa() {
    return accountBasedMfa;
  }
}

