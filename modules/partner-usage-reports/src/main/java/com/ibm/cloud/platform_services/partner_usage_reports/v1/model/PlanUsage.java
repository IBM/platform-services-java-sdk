/*
 * (C) Copyright IBM Corp. 2024.
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
package com.ibm.cloud.platform_services.partner_usage_reports.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Aggregated values for the plan.
 */
public class PlanUsage extends GenericModel {

  @SerializedName("plan_id")
  protected String planId;
  @SerializedName("pricing_region")
  protected String pricingRegion;
  @SerializedName("pricing_plan_id")
  protected String pricingPlanId;
  protected Boolean billable;
  protected Double cost;
  @SerializedName("rated_cost")
  protected Double ratedCost;
  protected List<MetricUsage> usage;

  protected PlanUsage() { }

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
   * Gets the pricingPlanId.
   *
   * The pricing plan with which the usage was rated.
   *
   * @return the pricingPlanId
   */
  public String getPricingPlanId() {
    return pricingPlanId;
  }

  /**
   * Gets the billable.
   *
   * Whether the plan charges are billed to the customer.
   *
   * @return the billable
   */
  public Boolean isBillable() {
    return billable;
  }

  /**
   * Gets the cost.
   *
   * The total cost that was incurred by the plan.
   *
   * @return the cost
   */
  public Double getCost() {
    return cost;
  }

  /**
   * Gets the ratedCost.
   *
   * The total pre-discounted cost that was incurred by the plan.
   *
   * @return the ratedCost
   */
  public Double getRatedCost() {
    return ratedCost;
  }

  /**
   * Gets the usage.
   *
   * All of the metrics in the plan.
   *
   * @return the usage
   */
  public List<MetricUsage> getUsage() {
    return usage;
  }
}

