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
 * EU support.
 */
public class CaseEu extends GenericModel {

  protected Boolean support;
  @SerializedName("data_center")
  protected String dataCenter;

  /**
   * Gets the support.
   *
   * Identifying whether the case has EU Support.
   *
   * @return the support
   */
  public Boolean isSupport() {
    return support;
  }

  /**
   * Gets the dataCenter.
   *
   * Information about the data center.
   *
   * @return the dataCenter
   */
  public String getDataCenter() {
    return dataCenter;
  }
}

