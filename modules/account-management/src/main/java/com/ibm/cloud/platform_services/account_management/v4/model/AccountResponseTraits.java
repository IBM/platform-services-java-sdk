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

package com.ibm.cloud.platform_services.account_management.v4.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * AccountResponseTraits.
 */
public class AccountResponseTraits extends GenericModel {

  @SerializedName("eu_supported")
  protected Boolean euSupported;
  protected Boolean poc;
  protected Boolean hippa;

  protected AccountResponseTraits() { }

  /**
   * Gets the euSupported.
   *
   * @return the euSupported
   */
  public Boolean isEuSupported() {
    return euSupported;
  }

  /**
   * Gets the poc.
   *
   * @return the poc
   */
  public Boolean isPoc() {
    return poc;
  }

  /**
   * Gets the hippa.
   *
   * @return the hippa
   */
  public Boolean isHippa() {
    return hippa;
  }
}

