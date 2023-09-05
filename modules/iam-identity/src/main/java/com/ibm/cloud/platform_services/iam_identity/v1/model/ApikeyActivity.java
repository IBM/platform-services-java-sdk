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
 * Apikeys activity details.
 */
public class ApikeyActivity extends GenericModel {

  protected String id;
  protected String name;
  protected String type;
  protected ApikeyActivityServiceid serviceid;
  protected ApikeyActivityUser user;
  @SerializedName("last_authn")
  protected String lastAuthn;

  protected ApikeyActivity() { }

  /**
   * Gets the id.
   *
   * Unique id of the apikey.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the name.
   *
   * Name provided during creation of the apikey.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the type.
   *
   * Type of the apikey. Supported values are `serviceid` and `user`.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the serviceid.
   *
   * serviceid details will be present if type is `serviceid`.
   *
   * @return the serviceid
   */
  public ApikeyActivityServiceid getServiceid() {
    return serviceid;
  }

  /**
   * Gets the user.
   *
   * user details will be present if type is `user`.
   *
   * @return the user
   */
  public ApikeyActivityUser getUser() {
    return user;
  }

  /**
   * Gets the lastAuthn.
   *
   * Time when the apikey was last authenticated.
   *
   * @return the lastAuthn
   */
  public String getLastAuthn() {
    return lastAuthn;
  }
}

