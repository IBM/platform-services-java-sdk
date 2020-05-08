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
package com.ibm.cloud.platform_services.resource_manager.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A resource quota.
 */
public class ResourceQuota extends GenericModel {

  @SerializedName("_id")
  protected String id;
  @SerializedName("resource_id")
  protected String resourceId;
  protected String crn;
  protected Double limit;

  /**
   * Gets the id.
   *
   * An alpha-numeric value identifying the quota.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the resourceId.
   *
   * The human-readable name of the quota.
   *
   * @return the resourceId
   */
  public String getResourceId() {
    return resourceId;
  }

  /**
   * Gets the crn.
   *
   * The full CRN (cloud resource name) associated with the quota. For more on this format, see
   * https://cloud.ibm.com/docs/resources?topic=resources-crn#crn.
   *
   * @return the crn
   */
  public String getCrn() {
    return crn;
  }

  /**
   * Gets the limit.
   *
   * The limit number of this resource.
   *
   * @return the limit
   */
  public Double getLimit() {
    return limit;
  }
}

