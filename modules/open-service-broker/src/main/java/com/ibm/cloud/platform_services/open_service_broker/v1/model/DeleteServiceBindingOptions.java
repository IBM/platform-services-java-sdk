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
package com.ibm.cloud.platform_services.open_service_broker.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The deleteServiceBinding options.
 */
public class DeleteServiceBindingOptions extends GenericModel {

  protected String bindingId;
  protected String instanceId;
  protected String planId;
  protected String serviceId;

  /**
   * Builder.
   */
  public static class Builder {
    private String bindingId;
    private String instanceId;
    private String planId;
    private String serviceId;

    private Builder(DeleteServiceBindingOptions deleteServiceBindingOptions) {
      this.bindingId = deleteServiceBindingOptions.bindingId;
      this.instanceId = deleteServiceBindingOptions.instanceId;
      this.planId = deleteServiceBindingOptions.planId;
      this.serviceId = deleteServiceBindingOptions.serviceId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param bindingId the bindingId
     * @param instanceId the instanceId
     * @param planId the planId
     * @param serviceId the serviceId
     */
    public Builder(String bindingId, String instanceId, String planId, String serviceId) {
      this.bindingId = bindingId;
      this.instanceId = instanceId;
      this.planId = planId;
      this.serviceId = serviceId;
    }

    /**
     * Builds a DeleteServiceBindingOptions.
     *
     * @return the new DeleteServiceBindingOptions instance
     */
    public DeleteServiceBindingOptions build() {
      return new DeleteServiceBindingOptions(this);
    }

    /**
     * Set the bindingId.
     *
     * @param bindingId the bindingId
     * @return the DeleteServiceBindingOptions builder
     */
    public Builder bindingId(String bindingId) {
      this.bindingId = bindingId;
      return this;
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the DeleteServiceBindingOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the planId.
     *
     * @param planId the planId
     * @return the DeleteServiceBindingOptions builder
     */
    public Builder planId(String planId) {
      this.planId = planId;
      return this;
    }

    /**
     * Set the serviceId.
     *
     * @param serviceId the serviceId
     * @return the DeleteServiceBindingOptions builder
     */
    public Builder serviceId(String serviceId) {
      this.serviceId = serviceId;
      return this;
    }
  }

  protected DeleteServiceBindingOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.bindingId,
      "bindingId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.planId,
      "planId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.serviceId,
      "serviceId cannot be null");
    bindingId = builder.bindingId;
    instanceId = builder.instanceId;
    planId = builder.planId;
    serviceId = builder.serviceId;
  }

  /**
   * New builder.
   *
   * @return a DeleteServiceBindingOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the bindingId.
   *
   * The `binding_id` is the ID of a previously provisioned binding for that service instance.
   *
   * @return the bindingId
   */
  public String bindingId() {
    return bindingId;
  }

  /**
   * Gets the instanceId.
   *
   * The `instance_id` is the ID of a previously provisioned service instance.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
  }

  /**
   * Gets the planId.
   *
   * The ID of the plan from the catalog.json in the broker. It MUST be a non-empty string and should be a GUID.
   *
   * @return the planId
   */
  public String planId() {
    return planId;
  }

  /**
   * Gets the serviceId.
   *
   * The ID of the service from the catalog.json in the broker. It MUST be a non-empty string and should be a GUID.
   *
   * @return the serviceId
   */
  public String serviceId() {
    return serviceId;
  }
}

