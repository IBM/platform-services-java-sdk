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
package com.ibm.cloud.platform_services.resource_controller.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Configuration options represented as key-value pairs. Service defined options are passed through to the target
 * resource brokers, whereas platform defined options are not.
 */
public class ResourceBindingPostParameters extends GenericModel {

  @SerializedName("serviceid_crn")
  protected String serviceidCrn;

  /**
   * Builder.
   */
  public static class Builder {
    private String serviceidCrn;

    private Builder(ResourceBindingPostParameters resourceBindingPostParameters) {
      this.serviceidCrn = resourceBindingPostParameters.serviceidCrn;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ResourceBindingPostParameters.
     *
     * @return the new ResourceBindingPostParameters instance
     */
    public ResourceBindingPostParameters build() {
      return new ResourceBindingPostParameters(this);
    }

    /**
     * Set the serviceidCrn.
     *
     * @param serviceidCrn the serviceidCrn
     * @return the ResourceBindingPostParameters builder
     */
    public Builder serviceidCrn(String serviceidCrn) {
      this.serviceidCrn = serviceidCrn;
      return this;
    }
  }

  protected ResourceBindingPostParameters(Builder builder) {
    serviceidCrn = builder.serviceidCrn;
  }

  /**
   * New builder.
   *
   * @return a ResourceBindingPostParameters builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the serviceidCrn.
   *
   * An optional platform defined option to reuse an existing IAM serviceId for the role assignment.
   *
   * @return the serviceidCrn
   */
  public String serviceidCrn() {
    return serviceidCrn;
  }
}

