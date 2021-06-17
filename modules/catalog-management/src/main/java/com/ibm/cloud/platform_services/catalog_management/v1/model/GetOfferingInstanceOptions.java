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
package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getOfferingInstance options.
 */
public class GetOfferingInstanceOptions extends GenericModel {

  protected String instanceIdentifier;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceIdentifier;

    private Builder(GetOfferingInstanceOptions getOfferingInstanceOptions) {
      this.instanceIdentifier = getOfferingInstanceOptions.instanceIdentifier;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param instanceIdentifier the instanceIdentifier
     */
    public Builder(String instanceIdentifier) {
      this.instanceIdentifier = instanceIdentifier;
    }

    /**
     * Builds a GetOfferingInstanceOptions.
     *
     * @return the new GetOfferingInstanceOptions instance
     */
    public GetOfferingInstanceOptions build() {
      return new GetOfferingInstanceOptions(this);
    }

    /**
     * Set the instanceIdentifier.
     *
     * @param instanceIdentifier the instanceIdentifier
     * @return the GetOfferingInstanceOptions builder
     */
    public Builder instanceIdentifier(String instanceIdentifier) {
      this.instanceIdentifier = instanceIdentifier;
      return this;
    }
  }

  protected GetOfferingInstanceOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceIdentifier,
      "instanceIdentifier cannot be empty");
    instanceIdentifier = builder.instanceIdentifier;
  }

  /**
   * New builder.
   *
   * @return a GetOfferingInstanceOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceIdentifier.
   *
   * Version Instance identifier.
   *
   * @return the instanceIdentifier
   */
  public String instanceIdentifier() {
    return instanceIdentifier;
  }
}

