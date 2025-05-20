/*
 * (C) Copyright IBM Corp. 2025.
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

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Plan-specific cost metrics information.
 */
public class Metrics extends GenericModel {

  @SerializedName("part_ref")
  protected String partRef;
  @SerializedName("metric_id")
  protected String metricId;
  @SerializedName("tier_model")
  protected String tierModel;
  @SerializedName("charge_unit")
  protected String chargeUnit;
  @SerializedName("charge_unit_name")
  protected String chargeUnitName;
  @SerializedName("charge_unit_quantity")
  protected Long chargeUnitQuantity;
  @SerializedName("resource_display_name")
  protected String resourceDisplayName;
  @SerializedName("charge_unit_display_name")
  protected String chargeUnitDisplayName;
  @SerializedName("usage_cap_qty")
  protected Long usageCapQty;
  @SerializedName("display_cap")
  protected Long displayCap;
  @SerializedName("effective_from")
  protected Date effectiveFrom;
  @SerializedName("effective_until")
  protected Date effectiveUntil;
  protected List<Amount> amounts;
  @SerializedName("additional_properties")
  protected Map<String, Object> additionalProperties;

  protected Metrics() { }

  /**
   * Gets the partRef.
   *
   * The reference guid for the part.
   *
   * @return the partRef
   */
  public String getPartRef() {
    return partRef;
  }

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
   * The pricing tier type used to calculate the marginal unit price. Follows simple, graduated or block tier styles.
   *
   * @return the tierModel
   */
  public String getTierModel() {
    return tierModel;
  }

  /**
   * Gets the chargeUnit.
   *
   * The unit to be charged under this metric.
   *
   * @return the chargeUnit
   */
  public String getChargeUnit() {
    return chargeUnit;
  }

  /**
   * Gets the chargeUnitName.
   *
   * The name associated with a charge unit to provide context.
   *
   * @return the chargeUnitName
   */
  public String getChargeUnitName() {
    return chargeUnitName;
  }

  /**
   * Gets the chargeUnitQuantity.
   *
   * The quantity associated with the charge unit to determine price change intervals.
   *
   * @return the chargeUnitQuantity
   */
  public Long getChargeUnitQuantity() {
    return chargeUnitQuantity;
  }

  /**
   * Gets the resourceDisplayName.
   *
   * The display name of the resource tied to the charge unit of this metric.
   *
   * @return the resourceDisplayName
   */
  public String getResourceDisplayName() {
    return resourceDisplayName;
  }

  /**
   * Gets the chargeUnitDisplayName.
   *
   * Display name of the charge unit to be rendered human readable by the UI.
   *
   * @return the chargeUnitDisplayName
   */
  public String getChargeUnitDisplayName() {
    return chargeUnitDisplayName;
  }

  /**
   * Gets the usageCapQty.
   *
   * Upper bound for the usage under the parent metric.
   *
   * @return the usageCapQty
   */
  public Long getUsageCapQty() {
    return usageCapQty;
  }

  /**
   * Gets the displayCap.
   *
   * The display capacity for the UI.
   *
   * @return the displayCap
   */
  public Long getDisplayCap() {
    return displayCap;
  }

  /**
   * Gets the effectiveFrom.
   *
   * The end date-time indicating when this metric is no longer in effect.
   *
   * @return the effectiveFrom
   */
  public Date getEffectiveFrom() {
    return effectiveFrom;
  }

  /**
   * Gets the effectiveUntil.
   *
   * The start date-time indicating when this metric takes effect.
   *
   * @return the effectiveUntil
   */
  public Date getEffectiveUntil() {
    return effectiveUntil;
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

  /**
   * Gets the additionalProperties.
   *
   * A property-bag like extension to metric metadata.
   *
   * @return the additionalProperties
   */
  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }
}

