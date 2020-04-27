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
package com.ibm.cloud.platform_services.global_catalog.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Plan-specific cost metrics information.
 */
public class Metrics extends GenericModel {

  @SerializedName("metric_id")
  protected String metricId;
  @SerializedName("tier_model")
  protected String tierModel;
  @SerializedName("charge_unit_name")
  protected String chargeUnitName;
  @SerializedName("charge_unit_quantity")
  protected String chargeUnitQuantity;
  @SerializedName("resource_display_name")
  protected String resourceDisplayName;
  @SerializedName("charge_unit_display_name")
  protected String chargeUnitDisplayName;
  @SerializedName("usage_cap_qty")
  protected Long usageCapQty;
  protected List<Amount> amounts;

  /**
   * Gets the metricId.
   *
   * The metric ID or part number.
   *
   * @return the metricId
   */
  public String getMetricId() {
    return metricId;
  }

  /**
   * Gets the tierModel.
   *
   * The tier model.
   *
   * @return the tierModel
   */
  public String getTierModel() {
    return tierModel;
  }

  /**
   * Gets the chargeUnitName.
   *
   * The charge unit name.
   *
   * @return the chargeUnitName
   */
  public String getChargeUnitName() {
    return chargeUnitName;
  }

  /**
   * Gets the chargeUnitQuantity.
   *
   * The charge unit quantity.
   *
   * @return the chargeUnitQuantity
   */
  public String getChargeUnitQuantity() {
    return chargeUnitQuantity;
  }

  /**
   * Gets the resourceDisplayName.
   *
   * Display name of the resource.
   *
   * @return the resourceDisplayName
   */
  public String getResourceDisplayName() {
    return resourceDisplayName;
  }

  /**
   * Gets the chargeUnitDisplayName.
   *
   * Display name of the charge unit.
   *
   * @return the chargeUnitDisplayName
   */
  public String getChargeUnitDisplayName() {
    return chargeUnitDisplayName;
  }

  /**
   * Gets the usageCapQty.
   *
   * Usage limit for the metric.
   *
   * @return the usageCapQty
   */
  public Long getUsageCapQty() {
    return usageCapQty;
  }

  /**
   * Gets the amounts.
   *
   * The pricing per metric by country and currency.
   *
   * @return the amounts
   */
  public List<Amount> getAmounts() {
    return amounts;
  }
}

