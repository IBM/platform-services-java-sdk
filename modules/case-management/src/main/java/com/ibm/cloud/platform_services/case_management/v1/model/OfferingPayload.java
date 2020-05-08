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
package com.ibm.cloud.platform_services.case_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * OfferingPayload.
 */
public class OfferingPayload extends GenericModel {

  protected String name;
  protected OfferingPayloadType type;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private OfferingPayloadType type;

    private Builder(OfferingPayload offeringPayload) {
      this.name = offeringPayload.name;
      this.type = offeringPayload.type;
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
    public Builder(String name, OfferingPayloadType type) {
      this.name = name;
      this.type = type;
    }

    /**
     * Builds a OfferingPayload.
     *
     * @return the new OfferingPayload instance
     */
    public OfferingPayload build() {
      return new OfferingPayload(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the OfferingPayload builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the OfferingPayload builder
     */
    public Builder type(OfferingPayloadType type) {
      this.type = type;
      return this;
    }
  }

  protected OfferingPayload(Builder builder) {
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
   * @return a OfferingPayload builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * Offering name.
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
  public OfferingPayloadType type() {
    return type;
  }
}

