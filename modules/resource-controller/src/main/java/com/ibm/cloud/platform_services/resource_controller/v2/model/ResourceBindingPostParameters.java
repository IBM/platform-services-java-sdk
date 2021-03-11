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
package com.ibm.cloud.platform_services.resource_controller.v2.model;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;

/**
 * Configuration options represented as key-value pairs. Service defined options are passed through to the target
 * resource brokers, whereas platform defined options are not.
 */
public class ResourceBindingPostParameters extends DynamicModel<Object> {

  @SerializedName("serviceid_crn")
  protected String serviceidCrn;

  public ResourceBindingPostParameters() {
    super(new TypeToken<Object>() { });
  }

  /**
   * Builder.
   */
  public static class Builder {
    private String serviceidCrn;
    private Map<String, Object> dynamicProperties;

    private Builder(ResourceBindingPostParameters resourceBindingPostParameters) {
      this.serviceidCrn = resourceBindingPostParameters.serviceidCrn;
      this.dynamicProperties = resourceBindingPostParameters.getProperties();
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

    /**
     * Add an arbitrary property.
     *
     * @param name the name of the property to add
     * @param value the value of the property to add
     * @return the ResourceBindingPostParameters builder
     */
    public Builder add(String name, Object value) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(name, "name cannot be null");
      if (this.dynamicProperties == null) {
        this.dynamicProperties = new HashMap<String, Object>();
      }
      this.dynamicProperties.put(name, value);
      return this;
    }
  }

  protected ResourceBindingPostParameters(Builder builder) {
    super(new TypeToken<Object>() { });
    serviceidCrn = builder.serviceidCrn;
    this.setProperties(builder.dynamicProperties);
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
  public String getServiceidCrn() {
    return this.serviceidCrn;
  }

  /**
   * Sets the serviceidCrn.
   *
   * @param serviceidCrn the new serviceidCrn
   */
  public void setServiceidCrn(final String serviceidCrn) {
    this.serviceidCrn = serviceidCrn;
  }
}
