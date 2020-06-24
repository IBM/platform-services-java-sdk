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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateServiceInstance options.
 */
public class UpdateServiceInstanceOptions extends GenericModel {

  protected String instanceId;
  protected List<Context> context;
  protected Parameters parameters;
  protected String planId;
  protected List<String> previousValues;
  protected String serviceId;
  protected String acceptsIncomplete;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private List<Context> context;
    private Parameters parameters;
    private String planId;
    private List<String> previousValues;
    private String serviceId;
    private String acceptsIncomplete;

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
     * Adds an context to context.
     *
     * @param context the new context
     * @return the UpdateServiceInstanceOptions builder
     */
    public Builder addContext(Context context) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(context,
        "context cannot be null");
      if (this.context == null) {
        this.context = new ArrayList<Context>();
      }
      this.context.add(context);
      return this;
    }

    /**
     * Adds an previousValues to previousValues.
     *
     * @param previousValues the new previousValues
     * @return the UpdateServiceInstanceOptions builder
     */
    public Builder addPreviousValues(String previousValues) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(previousValues,
        "previousValues cannot be null");
      if (this.previousValues == null) {
        this.previousValues = new ArrayList<String>();
      }
      this.previousValues.add(previousValues);
      return this;
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
     * Existing context will be replaced.
     *
     * @param context the context
     * @return the UpdateServiceInstanceOptions builder
     */
    public Builder context(List<Context> context) {
      this.context = context;
      return this;
    }

    /**
     * Set the parameters.
     *
     * @param parameters the parameters
     * @return the UpdateServiceInstanceOptions builder
     */
    public Builder parameters(Parameters parameters) {
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
     * Existing previousValues will be replaced.
     *
     * @param previousValues the previousValues
     * @return the UpdateServiceInstanceOptions builder
     */
    public Builder previousValues(List<String> previousValues) {
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
    public Builder acceptsIncomplete(String acceptsIncomplete) {
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
   * Contextual data under which the service instance is created.
   *
   * @return the context
   */
  public List<Context> context() {
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
  public Parameters parameters() {
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
  public List<String> previousValues() {
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
  public String acceptsIncomplete() {
    return acceptsIncomplete;
  }
}

