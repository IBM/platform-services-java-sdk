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
 * Information about a metric.
 */
public class Metric extends GenericModel {

  protected String metric;
  @SerializedName("metric_name")
  protected String metricName;
  protected Double quantity;
  @SerializedName("rateable_quantity")
  protected Double rateableQuantity;
  protected Double cost;
  @SerializedName("rated_cost")
  protected Double ratedCost;
  protected List<Object> price;
  protected String unit;
  @SerializedName("unit_name")
  protected String unitName;
  @SerializedName("non_chargeable")
  protected Boolean nonChargeable;
  protected List<Discount> discounts;

  protected Metric() { }

  /**
   * Gets the metric.
   *
   * The ID of the metric.
   *
   * @return the metric
   */
  public String getMetric() {
    return metric;
  }

  /**
   * Gets the metricName.
   *
   * The name of the metric.
   *
   * @return the metricName
   */
  public String getMetricName() {
    return metricName;
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
   * The cost incurred by the metric.
   *
   * @return the cost
   */
  public Double getCost() {
    return cost;
  }

  /**
   * Gets the ratedCost.
   *
   * Pre-discounted cost incurred by the metric.
   *
   * @return the ratedCost
   */
  public Double getRatedCost() {
    return ratedCost;
  }

  /**
   * Gets the price.
   *
   * The price with which the cost was calculated.
   *
   * @return the price
   */
  public List<Object> getPrice() {
    return price;
  }

  /**
   * Gets the unit.
   *
   * The unit that qualifies the quantity.
   *
   * @return the unit
   */
  public String getUnit() {
    return unit;
  }

  /**
   * Gets the unitName.
   *
   * The name of the unit.
   *
   * @return the unitName
   */
  public String getUnitName() {
    return unitName;
  }

  /**
   * Gets the nonChargeable.
   *
   * When set to `true`, the cost is for informational purpose and is not included while calculating the plan charges.
   *
   * @return the nonChargeable
   */
  public Boolean isNonChargeable() {
    return nonChargeable;
  }

  /**
   * Gets the discounts.
   *
   * All the discounts applicable to the metric.
   *
   * @return the discounts
   */
  public List<Discount> getDiscounts() {
    return discounts;
  }
}

