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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The container for all the plans in the resource.
 */
public class Resource extends GenericModel {

  @SerializedName("resource_id")
  protected String resourceId;
  @SerializedName("resource_name")
  protected String resourceName;
  @SerializedName("billable_cost")
  protected Double billableCost;
  @SerializedName("billable_rated_cost")
  protected Double billableRatedCost;
  @SerializedName("non_billable_cost")
  protected Double nonBillableCost;
  @SerializedName("non_billable_rated_cost")
  protected Double nonBillableRatedCost;
  protected List<Plan> plans;
  protected List<Discount> discounts;

  protected Resource() { }

  /**
   * Gets the resourceId.
   *
   * The ID of the resource.
   *
   * @return the resourceId
   */
  public String getResourceId() {
    return resourceId;
  }

  /**
   * Gets the resourceName.
   *
   * The name of the resource.
   *
   * @return the resourceName
   */
  public String getResourceName() {
    return resourceName;
  }

  /**
   * Gets the billableCost.
   *
   * The billable charges for the account.
   *
   * @return the billableCost
   */
  public Double getBillableCost() {
    return billableCost;
  }

  /**
   * Gets the billableRatedCost.
   *
   * The pre-discounted billable charges for the account.
   *
   * @return the billableRatedCost
   */
  public Double getBillableRatedCost() {
    return billableRatedCost;
  }

  /**
   * Gets the nonBillableCost.
   *
   * The non-billable charges for the account.
   *
   * @return the nonBillableCost
   */
  public Double getNonBillableCost() {
    return nonBillableCost;
  }

  /**
   * Gets the nonBillableRatedCost.
   *
   * The pre-discounted non-billable charges for the account.
   *
   * @return the nonBillableRatedCost
   */
  public Double getNonBillableRatedCost() {
    return nonBillableRatedCost;
  }

  /**
   * Gets the plans.
   *
   * All the plans in the resource.
   *
   * @return the plans
   */
  public List<Plan> getPlans() {
    return plans;
  }

  /**
   * Gets the discounts.
   *
   * All the discounts applicable to the resource.
   *
   * @return the discounts
   */
  public List<Discount> getDiscounts() {
    return discounts;
  }
}

