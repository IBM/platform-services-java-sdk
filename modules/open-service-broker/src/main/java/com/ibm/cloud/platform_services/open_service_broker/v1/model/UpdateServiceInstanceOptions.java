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

import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateServiceInstance options.
 */
public class UpdateServiceInstanceOptions extends GenericModel {

  protected String instanceId;
  protected Context context;
  protected Map<String, String> parameters;
  protected String planId;
  protected Map<String, String> previousValues;
  protected String serviceId;
  protected Boolean acceptsIncomplete;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private Context context;
    private Map<String, String> parameters;
    private String planId;
    private Map<String, String> previousValues;
    private String serviceId;
    private Boolean acceptsIncomplete;

    private Builder(UpdateServiceInstanceOptions updateServiceInstanceOptions) {
      this.instanceId = updateServiceInstanceOptions.instanceId;
      this.context = updateServiceInstanceOptions.context;
      this.parameters = updateServiceInstanceOptions.parameters;
      this.planId = updateServiceInstanceOptions.planId;
      this.previousValues = updateServiceInstanceOptions.previousValues;
      this.serviceId = updateServiceInstanceOptions.serviceId;
      this.acceptsIncomplete = updateServiceInstanceOptions.acceptsIncomplete;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param instanceId the instanceId
     */
    public Builder(String instanceId) {
      this.instanceId = instanceId;
    }

    /**
     * Builds a UpdateServiceInstanceOptions.
     *
     * @return the new UpdateServiceInstanceOptions instance
     */
    public UpdateServiceInstanceOptions build() {
      return new UpdateServiceInstanceOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the UpdateServiceInstanceOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the context.
     *
     * @param context the context
     * @return the UpdateServiceInstanceOptions builder
     */
    public Builder context(Context context) {
      this.context = context;
      return this;
    }

    /**
     * Set the parameters.
     *
     * @param parameters the parameters
     * @return the UpdateServiceInstanceOptions builder
     */
    public Builder parameters(Map<String, String> parameters) {
      this.parameters = parameters;
      return this;
    }

    /**
     * Set the planId.
     *
     * @param planId the planId
     * @return the UpdateServiceInstanceOptions builder
     */
    public Builder planId(String planId) {
      this.planId = planId;
      return this;
    }

    /**
     * Set the previousValues.
     *
     * @param previousValues the previousValues
     * @return the UpdateServiceInstanceOptions builder
     */
    public Builder previousValues(Map<String, String> previousValues) {
      this.previousValues = previousValues;
      return this;
    }

    /**
     * Set the serviceId.
     *
     * @param serviceId the serviceId
     * @return the UpdateServiceInstanceOptions builder
     */
    public Builder serviceId(String serviceId) {
      this.serviceId = serviceId;
      return this;
    }

    /**
     * Set the acceptsIncomplete.
     *
     * @param acceptsIncomplete the acceptsIncomplete
     * @return the UpdateServiceInstanceOptions builder
     */
    public Builder acceptsIncomplete(Boolean acceptsIncomplete) {
      this.acceptsIncomplete = acceptsIncomplete;
      return this;
    }
  }

  protected UpdateServiceInstanceOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    instanceId = builder.instanceId;
    context = builder.context;
    parameters = builder.parameters;
    planId = builder.planId;
    previousValues = builder.previousValues;
    serviceId = builder.serviceId;
    acceptsIncomplete = builder.acceptsIncomplete;
  }

  /**
   * New builder.
   *
   * @return a UpdateServiceInstanceOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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
   * Gets the context.
   *
   * Platform specific contextual information under which the service instance is to be provisioned.
   *
   * @return the context
   */
  public Context context() {
    return context;
  }

  /**
   * Gets the parameters.
   *
   * Configuration options for the service instance. An opaque object, controller treats this as a blob. Brokers should
   * ensure that the client has provided valid configuration parameters and values for the operation. If this field is
   * not present in the request message, then the broker MUST NOT change the parameters of the instance as a result of
   * this request.
   *
   * @return the parameters
   */
  public Map<String, String> parameters() {
    return parameters;
  }

  /**
   * Gets the planId.
   *
   * The ID of the plan for which the service instance has been requested, which is stored in the catalog.json of your
   * broker. This value should be a GUID. MUST be unique to a service. If present, MUST be a non-empty string. If this
   * field is not present in the request message, then the broker MUST NOT change the plan of the instance as a result
   * of this request.
   *
   * @return the planId
   */
  public String planId() {
    return planId;
  }

  /**
   * Gets the previousValues.
   *
   * Information about the service instance prior to the update.
   *
   * @return the previousValues
   */
  public Map<String, String> previousValues() {
    return previousValues;
  }

  /**
   * Gets the serviceId.
   *
   * The ID of the service stored in the catalog.json of your broker. This value should be a GUID. It MUST be a
   * non-empty string.
   *
   * @return the serviceId
   */
  public String serviceId() {
    return serviceId;
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

