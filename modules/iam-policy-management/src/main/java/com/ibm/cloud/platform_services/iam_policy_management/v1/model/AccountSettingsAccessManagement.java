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

package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The Access Management Account Settings that are currently set for the requested account.
 */
public class AccountSettingsAccessManagement extends GenericModel {

  @SerializedName("external_account_identity_interaction")
  protected ExternalAccountIdentityInteraction externalAccountIdentityInteraction;

  protected AccountSettingsAccessManagement() { }

  /**
   * Gets the externalAccountIdentityInteraction.
   *
   * How external accounts can interact in relation to the requested account.
   *
   * @return the externalAccountIdentityInteraction
   */
  public ExternalAccountIdentityInteraction getExternalAccountIdentityInteraction() {
    return externalAccountIdentityInteraction;
  }
}

