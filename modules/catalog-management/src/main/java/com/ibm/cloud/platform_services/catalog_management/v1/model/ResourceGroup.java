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
package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Resource group details.
 */
public class ResourceGroup extends GenericModel {

  protected String id;
  protected String name;
  protected String crn;
  @SerializedName("account_id")
  protected String accountId;
  protected String state;
  @SerializedName("default")
  protected Boolean xDefault;

  /**
   * Gets the id.
   *
   * Resource Group ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the name.
   *
   * Provider name, eg. IBM Passport Advantage.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the crn.
   *
   * Provider CRN.
   *
   * @return the crn
   */
  public String getCrn() {
    return crn;
  }

  /**
   * Gets the accountId.
   *
   * Account ID for this Resource Group.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the state.
   *
   * State of this Resource Group.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Gets the xDefault.
   *
   * Indicates if this Resource Group is active or not.
   *
   * @return the xDefault
   */
  public Boolean isXDefault() {
    return xDefault;
  }
}

