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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * MfaEnrollments.
 */
public class MfaEnrollments extends GenericModel {

  @SerializedName("effective_mfa_type")
  protected String effectiveMfaType;
  @SerializedName("id_based_mfa")
  protected IdBasedMfaEnrollment idBasedMfa;
  @SerializedName("account_based_mfa")
  protected AccountBasedMfaEnrollment accountBasedMfa;

  protected MfaEnrollments() { }

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

