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
 * user details will be present if type is `user`.
 */
public class ApikeyActivityUser extends GenericModel {

  @SerializedName("iam_id")
  protected String iamId;
  protected String name;
  protected String username;
  protected String email;

  protected ApikeyActivityUser() { }

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
}

