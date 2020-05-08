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
public class Price extends GenericModel {

  @SerializedName("quantity_tier")
  protected Long quantityTier;
  @SerializedName("Price")
  protected Double price;

  /**
   * Builder.
   */
  public static class Builder {
    private Long quantityTier;
    private Double price;

    private Builder(Price price) {
      this.quantityTier = price.quantityTier;
      this.price = price.price;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Price.
     *
     * @return the new Price instance
     */
    public Price build() {
      return new Price(this);
    }

    /**
     * Set the quantityTier.
     *
     * @param quantityTier the quantityTier
     * @return the Price builder
     */
    public Builder quantityTier(long quantityTier) {
      this.quantityTier = quantityTier;
      return this;
    }

    /**
     * Set the price.
     *
     * @param price the price
     * @return the Price builder
     */
    public Builder price(Double price) {
      this.price = price;
      return this;
    }
  }

  protected Price(Builder builder) {
    quantityTier = builder.quantityTier;
    price = builder.price;
  }

  /**
   * New builder.
   *
   * @return a Price builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the quantityTier.
   *
   * Pricing tier.
   *
   * @return the quantityTier
   */
  public Long quantityTier() {
    return quantityTier;
  }

  /**
   * Gets the price.
   *
   * Price in the selected currency.
   *
   * @return the price
   */
  public Double price() {
    return price;
  }
}

