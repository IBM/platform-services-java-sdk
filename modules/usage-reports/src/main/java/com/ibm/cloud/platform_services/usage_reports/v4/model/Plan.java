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
 * The aggregated values for the plan.
 */
public class Plan extends GenericModel {

  @SerializedName("plan_id")
  protected String planId;
  @SerializedName("plan_name")
  protected String planName;
  @SerializedName("pricing_region")
  protected String pricingRegion;
  protected Boolean billable;
  protected Double cost;
  @SerializedName("rated_cost")
  protected Double ratedCost;
  protected List<Metric> usage;
  protected List<Discount> discounts;
  protected Boolean pending;

  protected Plan() { }

  /**
   * Gets the planId.
   *
   * The ID of the plan.
   *
   * @return the planId
   */
  public String getPlanId() {
    return planId;
  }

  /**
   * Gets the planName.
   *
   * The name of the plan.
   *
   * @return the planName
   */
  public String getPlanName() {
    return planName;
  }

  /**
   * Gets the pricingRegion.
   *
   * The pricing region for the plan.
   *
   * @return the pricingRegion
   */
  public String getPricingRegion() {
    return pricingRegion;
  }

  /**
   * Gets the billable.
   *
   * Indicates if the plan charges are billed to the customer.
   *
   * @return the billable
   */
  public Boolean isBillable() {
    return billable;
  }

  /**
   * Gets the cost.
   *
   * The total cost incurred by the plan.
   *
   * @return the cost
   */
  public Double getCost() {
    return cost;
  }

  /**
   * Gets the ratedCost.
   *
   * Total pre-discounted cost incurred by the plan.
   *
   * @return the ratedCost
   */
  public Double getRatedCost() {
    return ratedCost;
  }

  /**
   * Gets the usage.
   *
   * All the metrics in the plan.
   *
   * @return the usage
   */
  public List<Metric> getUsage() {
    return usage;
  }

  /**
   * Gets the discounts.
   *
   * All the discounts applicable to the plan.
   *
   * @return the discounts
   */
  public List<Discount> getDiscounts() {
    return discounts;
  }

  /**
   * Gets the pending.
   *
   * Pending charge from classic infrastructure.
   *
   * @return the pending
   */
  public Boolean isPending() {
    return pending;
  }
}

