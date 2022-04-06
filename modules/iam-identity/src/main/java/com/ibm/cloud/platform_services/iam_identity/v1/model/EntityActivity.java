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
 * EntityActivity.
 */
public class EntityActivity extends GenericModel {

  protected String id;
  protected String name;
  @SerializedName("last_authn")
  protected String lastAuthn;

  /**
   * Gets the id.
   *
   * Unique id of the entity.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the name.
   *
   * Name provided during creation of the entity.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the lastAuthn.
   *
   * Time when the entity was last authenticated.
   *
   * @return the lastAuthn
   */
  public String getLastAuthn() {
    return lastAuthn;
  }
}

