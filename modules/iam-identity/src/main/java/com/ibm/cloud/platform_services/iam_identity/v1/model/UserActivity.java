/*
 * (C) Copyright IBM Corp. 2022.
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
 * UserActivity.
 */
public class UserActivity extends GenericModel {

  @SerializedName("iam_id")
  protected String iamId;
  protected String username;
  @SerializedName("last_authn")
  protected String lastAuthn;

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
   * Gets the lastAuthn.
   *
   * Time when the user was last authenticated.
   *
   * @return the lastAuthn
   */
  public String getLastAuthn() {
    return lastAuthn;
  }
}

