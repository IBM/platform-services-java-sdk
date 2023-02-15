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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * AccountBasedMfaEnrollment.
 */
public class AccountBasedMfaEnrollment extends GenericModel {

  @SerializedName("security_questions")
  protected MfaEnrollmentTypeStatus securityQuestions;
  protected MfaEnrollmentTypeStatus totp;
  protected MfaEnrollmentTypeStatus verisign;
  protected Boolean complies;

  protected AccountBasedMfaEnrollment() { }

  /**
   * Gets the securityQuestions.
   *
   * @return the securityQuestions
   */
  public MfaEnrollmentTypeStatus getSecurityQuestions() {
    return securityQuestions;
  }

  /**
   * Gets the totp.
   *
   * @return the totp
   */
  public MfaEnrollmentTypeStatus getTotp() {
    return totp;
  }

  /**
   * Gets the verisign.
   *
   * @return the verisign
   */
  public MfaEnrollmentTypeStatus getVerisign() {
    return verisign;
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
}

