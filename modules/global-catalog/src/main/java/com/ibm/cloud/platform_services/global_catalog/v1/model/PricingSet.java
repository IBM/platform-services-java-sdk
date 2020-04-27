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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Pricing-related information.
 */
public class PricingSet extends GenericModel {

  protected String type;
  protected String origin;
  @SerializedName("starting_price")
  protected StartingPrice startingPrice;

  /**
   * Builder.
   */
  public static class Builder {
    private String type;
    private String origin;
    private StartingPrice startingPrice;

    private Builder(PricingSet pricingSet) {
      this.type = pricingSet.type;
      this.origin = pricingSet.origin;
      this.startingPrice = pricingSet.startingPrice;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a PricingSet.
     *
     * @return the new PricingSet instance
     */
    public PricingSet build() {
      return new PricingSet(this);
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the PricingSet builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the origin.
     *
     * @param origin the origin
     * @return the PricingSet builder
     */
    public Builder origin(String origin) {
      this.origin = origin;
      return this;
    }

    /**
     * Set the startingPrice.
     *
     * @param startingPrice the startingPrice
     * @return the PricingSet builder
     */
    public Builder startingPrice(StartingPrice startingPrice) {
      this.startingPrice = startingPrice;
      return this;
    }
  }

  protected PricingSet(Builder builder) {
    type = builder.type;
    origin = builder.origin;
    startingPrice = builder.startingPrice;
  }

  /**
   * New builder.
   *
   * @return a PricingSet builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the type.
   *
   * Type of plan. Valid values are `free`, `trial`, `paygo`, `bluemix-subscription`, and `ibm-subscription`.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the origin.
   *
   * Defines where the pricing originates.
   *
   * @return the origin
   */
  public String origin() {
    return origin;
  }

  /**
   * Gets the startingPrice.
   *
   * Plan-specific starting price information.
   *
   * @return the startingPrice
   */
  public StartingPrice startingPrice() {
    return startingPrice;
  }
}

