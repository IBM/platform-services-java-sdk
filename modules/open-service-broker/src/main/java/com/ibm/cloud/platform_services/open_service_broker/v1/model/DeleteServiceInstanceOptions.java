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
 * The deleteServiceInstance options.
 */
public class DeleteServiceInstanceOptions extends GenericModel {

  protected String serviceId;
  protected String planId;
  protected String instanceId;
  protected Boolean acceptsIncomplete;

  /**
   * Builder.
   */
  public static class Builder {
    private String serviceId;
    private String planId;
    private String instanceId;
    private Boolean acceptsIncomplete;

    private Builder(DeleteServiceInstanceOptions deleteServiceInstanceOptions) {
      this.serviceId = deleteServiceInstanceOptions.serviceId;
      this.planId = deleteServiceInstanceOptions.planId;
      this.instanceId = deleteServiceInstanceOptions.instanceId;
      this.acceptsIncomplete = deleteServiceInstanceOptions.acceptsIncomplete;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param serviceId the serviceId
     * @param planId the planId
     * @param instanceId the instanceId
     */
    public Builder(String serviceId, String planId, String instanceId) {
      this.serviceId = serviceId;
      this.planId = planId;
      this.instanceId = instanceId;
    }

    /**
     * Builds a DeleteServiceInstanceOptions.
     *
     * @return the new DeleteServiceInstanceOptions instance
     */
    public DeleteServiceInstanceOptions build() {
      return new DeleteServiceInstanceOptions(this);
    }

    /**
     * Set the serviceId.
     *
     * @param serviceId the serviceId
     * @return the DeleteServiceInstanceOptions builder
     */
    public Builder serviceId(String serviceId) {
      this.serviceId = serviceId;
      return this;
    }

    /**
     * Set the planId.
     *
     * @param planId the planId
     * @return the DeleteServiceInstanceOptions builder
     */
    public Builder planId(String planId) {
      this.planId = planId;
      return this;
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the DeleteServiceInstanceOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the acceptsIncomplete.
     *
     * @param acceptsIncomplete the acceptsIncomplete
     * @return the DeleteServiceInstanceOptions builder
     */
    public Builder acceptsIncomplete(Boolean acceptsIncomplete) {
      this.acceptsIncomplete = acceptsIncomplete;
      return this;
    }
  }

  protected DeleteServiceInstanceOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.serviceId,
      "serviceId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.planId,
      "planId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    serviceId = builder.serviceId;
    planId = builder.planId;
    instanceId = builder.instanceId;
    acceptsIncomplete = builder.acceptsIncomplete;
  }

  /**
   * New builder.
   *
   * @return a DeleteServiceInstanceOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the serviceId.
   *
   * The ID of the service stored in the catalog.json of your broker. This value should be a GUID. MUST be a non-empty
   * string.
   *
   * @return the serviceId
   */
  public String serviceId() {
    return serviceId;
  }

  /**
   * Gets the planId.
   *
   * The ID of the plan for which the service instance has been requested, which is stored in the catalog.json of your
   * broker. This value should be a GUID. MUST be a non-empty string.
   *
   * @return the planId
   */
  public String planId() {
    return planId;
  }

  /**
   * Gets the instanceId.
   *
   * The ID of a previously provisioned service instance.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
  }

  /**
   * Gets the acceptsIncomplete.
   *
   * A value of true indicates that both the IBM Cloud platform and the requesting client support asynchronous
   * deprovisioning. If this parameter is not included in the request, and the broker can only deprovision a service
   * instance of the requested plan asynchronously, the broker MUST reject the request with a `422` Unprocessable
   * Entity.
   *
   * @return the acceptsIncomplete
   */
  public Boolean acceptsIncomplete() {
    return acceptsIncomplete;
  }
}

