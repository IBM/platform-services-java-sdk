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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * LicenseEntitlementHistoryItem.
 */
public class LicenseEntitlementHistoryItem extends GenericModel {

  protected String action;
  protected String user;
  protected String date;

  /**
   * Gets the action.
   *
   * Eg. create.
   *
   * @return the action
   */
  public String getAction() {
    return action;
  }

  /**
   * Gets the user.
   *
   * Eg. IBM ID of user.
   *
   * @return the user
   */
  public String getUser() {
    return user;
  }

  /**
   * Gets the date.
   *
   * Date of action, eg. '2019-07-17T21:21:47.6794935Z'.
   *
   * @return the date
   */
  public String getDate() {
    return date;
  }
}

