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
package com.ibm.cloud.platform_services.enterprise_management.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The response from calling create enterprise.
 */
public class CreateEnterpriseResponse extends GenericModel {

  @SerializedName("enterprise_id")
  protected String enterpriseId;
  @SerializedName("enterprise_account_id")
  protected String enterpriseAccountId;

  /**
   * Gets the enterpriseId.
   *
   * The ID of the enterprise entity that was created. This entity is the root of the hierarchy.
   *
   * @return the enterpriseId
   */
  public String getEnterpriseId() {
    return enterpriseId;
  }

  /**
   * Gets the enterpriseAccountId.
   *
   * The ID of the enterprise account that was created. The enterprise account is used to manage billing and access to
   * the enterprise management.
   *
   * @return the enterpriseAccountId
   */
  public String getEnterpriseAccountId() {
    return enterpriseAccountId;
  }
}

