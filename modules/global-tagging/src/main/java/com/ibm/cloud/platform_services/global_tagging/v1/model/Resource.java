/*
 * (C) Copyright IBM Corp. 2026.
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

package com.ibm.cloud.platform_services.global_tagging.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A resource that might have tags that are attached.
 */
public class Resource extends GenericModel {

  @SerializedName("resource_id")
  protected String resourceId;
  @SerializedName("resource_type")
  protected String resourceType;

  /**
   * Builder.
   */
  public static class Builder {
    private String resourceId;
    private String resourceType;

    /**
     * Instantiates a new Builder from an existing Resource instance.
     *
     * @param resource the instance to initialize the Builder with
     */
    private Builder(Resource resource) {
      this.resourceId = resource.resourceId;
      this.resourceType = resource.resourceType;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param resourceId the resourceId
     */
    public Builder(String resourceId) {
      this.resourceId = resourceId;
    }

    /**
     * Builds a Resource.
     *
     * @return the new Resource instance
     */
    public Resource build() {
      return new Resource(this);
    }

    /**
     * Set the resourceId.
     *
     * @param resourceId the resourceId
     * @return the Resource builder
     */
    public Builder resourceId(String resourceId) {
      this.resourceId = resourceId;
      return this;
    }

    /**
     * Set the resourceType.
     *
     * @param resourceType the resourceType
     * @return the Resource builder
     */
    public Builder resourceType(String resourceType) {
      this.resourceType = resourceType;
      return this;
    }
  }

  protected Resource() { }

  protected Resource(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.resourceId,
      "resourceId cannot be null");
    resourceId = builder.resourceId;
    resourceType = builder.resourceType;
  }

  /**
   * New builder.
   *
   * @return a Resource builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the resourceId.
   *
   * The CRN or IMS ID of the resource.
   *
   * @return the resourceId
   */
  public String resourceId() {
    return resourceId;
  }

  /**
   * Gets the resourceType.
   *
   * The IMS resource type of the resource. It can be one of SoftLayer_Virtual_DedicatedHost, SoftLayer_Hardware,
   * SoftLayer_Hardware_Server, SoftLayer_Network_Application_Delivery_Controller, SoftLayer_Network_Vlan,
   * SoftLayer_Network_Vlan_Firewall, SoftLayer_Network_Component_Firewall, SoftLayer_Network_Firewall_Module_Context,
   * SoftLayer_Virtual_Guest.
   *
   * @return the resourceType
   */
  public String resourceType() {
    return resourceType;
  }
}

