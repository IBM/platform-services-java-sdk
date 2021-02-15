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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Country-specific pricing information.
 */
public class Amount extends GenericModel {

  protected String country;
  protected String currency;
  protected List<Price> prices;

  /**
   * Builder.
   */
  public static class Builder {
    private String country;
    private String currency;
    private List<Price> prices;

    private Builder(Amount amount) {
      this.country = amount.country;
      this.currency = amount.currency;
      this.prices = amount.prices;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Amount.
     *
     * @return the new Amount instance
     */
    public Amount build() {
      return new Amount(this);
    }

    /**
     * Adds an prices to prices.
     *
     * @param prices the new prices
     * @return the Amount builder
     */
    public Builder addPrices(Price prices) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(prices,
        "prices cannot be null");
      if (this.prices == null) {
        this.prices = new ArrayList<Price>();
      }
      this.prices.add(prices);
      return this;
    }

    /**
     * Set the country.
     *
     * @param country the country
     * @return the Amount builder
     */
    public Builder country(String country) {
      this.country = country;
      return this;
    }

    /**
     * Set the currency.
     *
     * @param currency the currency
     * @return the Amount builder
     */
    public Builder currency(String currency) {
      this.currency = currency;
      return this;
    }

    /**
     * Set the prices.
     * Existing prices will be replaced.
     *
     * @param prices the prices
     * @return the Amount builder
     */
    public Builder prices(List<Price> prices) {
      this.prices = prices;
      return this;
    }
  }

  protected Amount(Builder builder) {
    country = builder.country;
    currency = builder.currency;
    prices = builder.prices;
  }

  /**
   * New builder.
   *
   * @return a Amount builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the country.
   *
   * Country.
   *
   * @return the country
   */
  public String country() {
    return country;
  }

  /**
   * Gets the currency.
   *
   * Currency.
   *
   * @return the currency
   */
  public String currency() {
    return currency;
  }

  /**
   * Gets the prices.
   *
   * See Price for nested fields.
   *
   * @return the prices
   */
  public List<Price> prices() {
    return prices;
  }
}

