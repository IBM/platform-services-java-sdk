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

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Plan-specific starting price information.
 */
public class StartingPrice extends GenericModel {

  @SerializedName("plan_id")
  protected String planId;
  @SerializedName("deployment_id")
  protected String deploymentId;
  protected String unit;
  protected List<Amount> amount;

  /**
   * Builder.
   */
  public static class Builder {
    private String planId;
    private String deploymentId;
    private String unit;
    private List<Amount> amount;

    /**
     * Instantiates a new Builder from an existing StartingPrice instance.
     *
     * @param startingPrice the instance to initialize the Builder with
     */
    private Builder(StartingPrice startingPrice) {
      this.planId = startingPrice.planId;
      this.deploymentId = startingPrice.deploymentId;
      this.unit = startingPrice.unit;
      this.amount = startingPrice.amount;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a StartingPrice.
     *
     * @return the new StartingPrice instance
     */
    public StartingPrice build() {
      return new StartingPrice(this);
    }

    /**
     * Adds a new element to amount.
     *
     * @param amount the new element to be added
     * @return the StartingPrice builder
     */
    public Builder addAmount(Amount amount) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(amount,
        "amount cannot be null");
      if (this.amount == null) {
        this.amount = new ArrayList<Amount>();
      }
      this.amount.add(amount);
      return this;
    }

    /**
     * Set the planId.
     *
     * @param planId the planId
     * @return the StartingPrice builder
     */
    public Builder planId(String planId) {
      this.planId = planId;
      return this;
    }

    /**
     * Set the deploymentId.
     *
     * @param deploymentId the deploymentId
     * @return the StartingPrice builder
     */
    public Builder deploymentId(String deploymentId) {
      this.deploymentId = deploymentId;
      return this;
    }

    /**
     * Set the unit.
     *
     * @param unit the unit
     * @return the StartingPrice builder
     */
    public Builder unit(String unit) {
      this.unit = unit;
      return this;
    }

    /**
     * Set the amount.
     * Existing amount will be replaced.
     *
     * @param amount the amount
     * @return the StartingPrice builder
     */
    public Builder amount(List<Amount> amount) {
      this.amount = amount;
      return this;
    }
  }

  protected StartingPrice() { }

  protected StartingPrice(Builder builder) {
    planId = builder.planId;
    deploymentId = builder.deploymentId;
    unit = builder.unit;
    amount = builder.amount;
  }

  /**
   * New builder.
   *
   * @return a StartingPrice builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the planId.
   *
   * ID of the plan the starting price is calculated.
   *
   * @return the planId
   */
  public String planId() {
    return planId;
  }

  /**
   * Gets the deploymentId.
   *
   * ID of the deployment the starting price is calculated.
   *
   * @return the deploymentId
   */
  public String deploymentId() {
    return deploymentId;
  }

  /**
   * Gets the unit.
   *
   * Pricing unit.
   *
   * @return the unit
   */
  public String unit() {
    return unit;
  }

  /**
   * Gets the amount.
   *
   * The pricing per metric by country and currency.
   *
   * @return the amount
   */
  public List<Amount> amount() {
    return amount;
  }
}

