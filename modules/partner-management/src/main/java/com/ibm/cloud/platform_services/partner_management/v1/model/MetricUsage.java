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

package com.ibm.cloud.platform_services.partner_management.v1.model;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * An object that represents a metric.
 */
public class MetricUsage extends GenericModel {

  protected String metric;
  protected String unit;
  protected Double quantity;
  @SerializedName("rateable_quantity")
  protected Double rateableQuantity;
  protected Double cost;
  @SerializedName("rated_cost")
  protected Double ratedCost;
  protected List<Map<String, Object>> price;

  protected MetricUsage() { }

  /**
   * Gets the metric.
   *
   * The name of the metric.
   *
   * @return the metric
   */
  public String getMetric() {
    return metric;
  }

  /**
   * Gets the unit.
   *
   * A unit to qualify the quantity.
   *
   * @return the unit
   */
  public String getUnit() {
    return unit;
  }

  /**
   * Gets the quantity.
   *
   * The aggregated value for the metric.
   *
   * @return the quantity
   */
  public Double getQuantity() {
    return quantity;
  }

  /**
   * Gets the rateableQuantity.
   *
   * The quantity that is used for calculating charges.
   *
   * @return the rateableQuantity
   */
  public Double getRateableQuantity() {
    return rateableQuantity;
  }

  /**
   * Gets the cost.
   *
   * The cost that was incurred by the metric.
   *
   * @return the cost
   */
  public Double getCost() {
    return cost;
  }

  /**
   * Gets the ratedCost.
   *
   * The pre-discounted cost that was incurred by the metric.
   *
   * @return the ratedCost
   */
  public Double getRatedCost() {
    return ratedCost;
  }

  /**
   * Gets the price.
   *
   * The price with which cost was calculated.
   *
   * @return the price
   */
  public List<Map<String, Object>> getPrice() {
    return price;
  }
}

