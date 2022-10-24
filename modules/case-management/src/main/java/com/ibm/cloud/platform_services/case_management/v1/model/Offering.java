/*
 * (C) Copyright IBM Corp. 2022.
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
package com.ibm.cloud.platform_services.case_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Offering details.
 */
public class Offering extends GenericModel {

  protected String name;
  protected OfferingType type;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private OfferingType type;

    /**
     * Instantiates a new Builder from an existing Offering instance.
     *
     * @param offering the instance to initialize the Builder with
     */
    private Builder(Offering offering) {
      this.name = offering.name;
      this.type = offering.type;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     * @param type the type
     */
    public Builder(String name, OfferingType type) {
      this.name = name;
      this.type = type;
    }

    /**
     * Builds a Offering.
     *
     * @return the new Offering instance
     */
    public Offering build() {
      return new Offering(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the Offering builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the Offering builder
     */
    public Builder type(OfferingType type) {
      this.type = type;
      return this;
    }
  }

  protected Offering() { }

  protected Offering(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    name = builder.name;
    type = builder.type;
  }

  /**
   * New builder.
   *
   * @return a Offering builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * Name of the offering.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the type.
   *
   * Offering type.
   *
   * @return the type
   */
  public OfferingType type() {
    return type;
  }
}

