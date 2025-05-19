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
  @SerializedName("deployment_id")
  protected String deploymentId;
  @SerializedName("deployment_location")
  protected String deploymentLocation;
  @SerializedName("deployment_region")
  protected String deploymentRegion;
  @SerializedName("deployment_location_no_price_available")
  protected Boolean deploymentLocationNoPriceAvailable;
  protected List<Metrics> metrics;
  @SerializedName("deployment_regions")
  protected List<String> deploymentRegions;
  @SerializedName("effective_from")
  protected Date effectiveFrom;
  @SerializedName("effective_until")
  protected Date effectiveUntil;
  @SerializedName("require_login")
  protected Boolean requireLogin;
  @SerializedName("pricing_catalog_url")
  protected String pricingCatalogUrl;
  @SerializedName("sales_avenue")
  protected List<String> salesAvenue;

  protected CatalogEntryMetadataPricing() { }

  /**
   * Gets the type.
   *
   * Type of plan. Valid values are `free`, `trial`, `paygo`, `paid`, `subscription`.
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
   * Gets the deploymentId.
   *
   * The deployment object id this pricing is from. Only set if object kind is deployment.
   *
   * @return the deploymentId
   */
  public String getDeploymentId() {
    return deploymentId;
  }

  /**
   * Gets the deploymentLocation.
   *
   * The deployment location this pricing is from. Only set if object kind is deployment.
   *
   * @return the deploymentLocation
   */
  public String getDeploymentLocation() {
    return deploymentLocation;
  }

  /**
   * Gets the deploymentRegion.
   *
   * If price is for a deployment object then the region in the pricing catalog of the deployment object will be here.
   * To be valid, this value must be contained within deployment_regions.
   *
   * @return the deploymentRegion
   */
  public String getDeploymentRegion() {
    return deploymentRegion;
  }

  /**
   * Gets the deploymentLocationNoPriceAvailable.
   *
   * Is the location price not available. Only set in api /pricing/deployment and only set if true. This means for the
   * given deployment object there was no pricing set in pricing catalog.
   *
   * @return the deploymentLocationNoPriceAvailable
   */
  public Boolean isDeploymentLocationNoPriceAvailable() {
    return deploymentLocationNoPriceAvailable;
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

  /**
   * Gets the deploymentRegions.
   *
   * List of regions where region pricing is available. Only set on global deployments if enabled by owner.
   *
   * @return the deploymentRegions
   */
  public List<String> getDeploymentRegions() {
    return deploymentRegions;
  }

  /**
   * Gets the effectiveFrom.
   *
   * The start date-time indicating when this pricing plan takes effect.
   *
   * @return the effectiveFrom
   */
  public Date getEffectiveFrom() {
    return effectiveFrom;
  }

  /**
   * Gets the effectiveUntil.
   *
   * The end date-time indicating when this pricing plan is no longer in effect.
   *
   * @return the effectiveUntil
   */
  public Date getEffectiveUntil() {
    return effectiveUntil;
  }

  /**
   * Gets the requireLogin.
   *
   * Boolean value indicating whether or not this pricing plan requires login to get pricing data.
   *
   * @return the requireLogin
   */
  public Boolean isRequireLogin() {
    return requireLogin;
  }

  /**
   * Gets the pricingCatalogUrl.
   *
   * URL to the entry for this plan on the pricing catalog.
   *
   * @return the pricingCatalogUrl
   */
  public String getPricingCatalogUrl() {
    return pricingCatalogUrl;
  }

  /**
   * Gets the salesAvenue.
   *
   * Tags describing how this plan was purchased (catalog [default], seller, private offer). Currently only settable on
   * MCSP subscription plans.
   *
   * @return the salesAvenue
   */
  public List<String> getSalesAvenue() {
    return salesAvenue;
  }
}

