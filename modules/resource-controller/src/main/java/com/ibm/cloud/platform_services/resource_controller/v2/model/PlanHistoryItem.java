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
package com.ibm.cloud.platform_services.resource_controller.v2.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * An element of the plan history of the instance.
 */
public class PlanHistoryItem extends GenericModel {

  @SerializedName("resource_plan_id")
  protected String resourcePlanId;
  @SerializedName("start_date")
  protected Date startDate;
  @SerializedName("requestor_id")
  protected String requestorId;

  protected PlanHistoryItem() { }

  /**
   * Gets the resourcePlanId.
   *
   * The unique ID of the plan associated with the offering. This value is provided by and stored in the global catalog.
   *
   * @return the resourcePlanId
   */
  public String getResourcePlanId() {
    return resourcePlanId;
  }

  /**
   * Gets the startDate.
   *
   * The date on which the plan was changed.
   *
   * @return the startDate
   */
  public Date getStartDate() {
    return startDate;
  }

  /**
   * Gets the requestorId.
   *
   * The subject who made the plan change.
   *
   * @return the requestorId
   */
  public String getRequestorId() {
    return requestorId;
  }
}

