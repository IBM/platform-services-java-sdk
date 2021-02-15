/*
 * (C) Copyright IBM Corp. 2021.
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
 * Pricing-related information.
 */
public class CatalogEntryMetadataPricing extends GenericModel {

  protected String type;
  protected String origin;
  @SerializedName("starting_price")
  protected StartingPrice startingPrice;
  protected List<Metrics> metrics;

  /**
   * Gets the type.
   *
   * Type of plan. Valid values are `free`, `trial`, `paygo`, `bluemix-subscription`, and `ibm-subscription`.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the origin.
   *
   * Defines where the pricing originates.
   *
   * @return the origin
   */
  public String getOrigin() {
    return origin;
  }

  /**
   * Gets the startingPrice.
   *
   * Plan-specific starting price information.
   *
   * @return the startingPrice
   */
  public StartingPrice getStartingPrice() {
    return startingPrice;
  }

  /**
   * Gets the metrics.
   *
   * Plan-specific cost metric structure.
   *
   * @return the metrics
   */
  public List<Metrics> getMetrics() {
    return metrics;
  }
}

