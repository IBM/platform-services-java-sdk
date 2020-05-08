/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.cloud.platform_services.case_management.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * User.
 */
public class User extends GenericModel {

  /**
   * the ID realm.
   */
  public interface Realm {
    /** IBMid. */
    String IBMID = "IBMid";
    /** SL. */
    String SL = "SL";
    /** BSS. */
    String BSS = "BSS";
  }

  protected String name;
  protected String realm;
  @SerializedName("user_id")
  protected String userId;

  /**
   * Gets the name.
   *
   * Full name of the user.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the realm.
   *
   * the ID realm.
   *
   * @return the realm
   */
  public String getRealm() {
    return realm;
  }

  /**
   * Gets the userId.
   *
   * unique user ID in the realm specified by the type.
   *
   * @return the userId
   */
  public String getUserId() {
    return userId;
  }
}

