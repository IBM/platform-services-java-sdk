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
package com.ibm.cloud.platform_services.usage_metering.v4.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A usage measurement.
 */
public class MeasureAndQuantity extends GenericModel {

  protected String measure;
  protected Object quantity;

  /**
   * Builder.
   */
  public static class Builder {
    private String measure;
    private Object quantity;

    private Builder(MeasureAndQuantity measureAndQuantity) {
      this.measure = measureAndQuantity.measure;
      this.quantity = measureAndQuantity.quantity;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param measure the measure
     * @param quantity the quantity
     */
    public Builder(String measure, Object quantity) {
      this.measure = measure;
      this.quantity = quantity;
    }

    /**
     * Builds a MeasureAndQuantity.
     *
     * @return the new MeasureAndQuantity instance
     */
    public MeasureAndQuantity build() {
      return new MeasureAndQuantity(this);
    }

    /**
     * Set the measure.
     *
     * @param measure the measure
     * @return the MeasureAndQuantity builder
     */
    public Builder measure(String measure) {
      this.measure = measure;
      return this;
    }

    /**
     * Set the quantity.
     *
     * @param quantity the quantity
     * @return the MeasureAndQuantity builder
     */
    public Builder quantity(Object quantity) {
      this.quantity = quantity;
      return this;
    }
  }

  protected MeasureAndQuantity(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.measure,
      "measure cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.quantity,
      "quantity cannot be null");
    measure = builder.measure;
    quantity = builder.quantity;
  }

  /**
   * New builder.
   *
   * @return a MeasureAndQuantity builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the measure.
   *
   * The name of the measure.
   *
   * @return the measure
   */
  public String measure() {
    return measure;
  }

  /**
   * Gets the quantity.
   *
   * For consumption-based submissions, `quantity` can be a double or integer value. For event-based submissions that do
   * not have binary states, previous and current values are required, such as `{ "previous": 1, "current": 2 }`.
   *
   * @return the quantity
   */
  public Object quantity() {
    return quantity;
  }
}

