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
package com.ibm.cloud.platform_services.usage_reports.v4.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Validated billing service to COS bucket authorization.
 */
public class SnapshotConfigValidateResponse extends GenericModel {

  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("cos_bucket")
  protected String cosBucket;
  @SerializedName("cos_location")
  protected String cosLocation;

  protected SnapshotConfigValidateResponse() { }

  /**
   * Gets the accountId.
   *
   * Account ID for which billing report snapshot is configured.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the cosBucket.
   *
   * The name of the COS bucket to store the snapshot of the billing reports.
   *
   * @return the cosBucket
   */
  public String getCosBucket() {
    return cosBucket;
  }

  /**
   * Gets the cosLocation.
   *
   * Region of the COS instance.
   *
   * @return the cosLocation
   */
  public String getCosLocation() {
    return cosLocation;
  }
}

