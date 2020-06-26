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
 * The replaceServiceBinding options.
 */
public class ReplaceServiceBindingOptions extends GenericModel {

  protected String bindingId;
  protected String instanceId;
  protected BindResource bindResource;
  protected Map<String, String> parameters;
  protected String planId;
  protected String serviceId;

  /**
   * Builder.
   */
  public static class Builder {
    private String bindingId;
    private String instanceId;
    private BindResource bindResource;
    private Map<String, String> parameters;
    private String planId;
    private String serviceId;

    private Builder(ReplaceServiceBindingOptions replaceServiceBindingOptions) {
      this.bindingId = replaceServiceBindingOptions.bindingId;
      this.instanceId = replaceServiceBindingOptions.instanceId;
      this.bindResource = replaceServiceBindingOptions.bindResource;
      this.parameters = replaceServiceBindingOptions.parameters;
      this.planId = replaceServiceBindingOptions.planId;
      this.serviceId = replaceServiceBindingOptions.serviceId;
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
     */
    public Builder(String bindingId, String instanceId) {
      this.bindingId = bindingId;
      this.instanceId = instanceId;
    }

    /**
     * Builds a ReplaceServiceBindingOptions.
     *
     * @return the new ReplaceServiceBindingOptions instance
     */
    public ReplaceServiceBindingOptions build() {
      return new ReplaceServiceBindingOptions(this);
    }

    /**
     * Set the bindingId.
     *
     * @param bindingId the bindingId
     * @return the ReplaceServiceBindingOptions builder
     */
    public Builder bindingId(String bindingId) {
      this.bindingId = bindingId;
      return this;
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the ReplaceServiceBindingOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the bindResource.
     *
     * @param bindResource the bindResource
     * @return the ReplaceServiceBindingOptions builder
     */
    public Builder bindResource(BindResource bindResource) {
      this.bindResource = bindResource;
      return this;
    }

    /**
     * Set the parameters.
     *
     * @param parameters the parameters
     * @return the ReplaceServiceBindingOptions builder
     */
    public Builder parameters(Map<String, String> parameters) {
      this.parameters = parameters;
      return this;
    }

    /**
     * Set the planId.
     *
     * @param planId the planId
     * @return the ReplaceServiceBindingOptions builder
     */
    public Builder planId(String planId) {
      this.planId = planId;
      return this;
    }

    /**
     * Set the serviceId.
     *
     * @param serviceId the serviceId
     * @return the ReplaceServiceBindingOptions builder
     */
    public Builder serviceId(String serviceId) {
      this.serviceId = serviceId;
      return this;
    }
  }

  protected ReplaceServiceBindingOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.bindingId,
      "bindingId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    bindingId = builder.bindingId;
    instanceId = builder.instanceId;
    bindResource = builder.bindResource;
    parameters = builder.parameters;
    planId = builder.planId;
    serviceId = builder.serviceId;
  }

  /**
   * New builder.
   *
   * @return a ReplaceServiceBindingOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the bindingId.
   *
   * The `binding_id` is provided by the IBM Cloud platform. This ID will be used for future unbind requests, so the
   * broker can use it to correlate the resource it creates.
   *
   * @return the bindingId
   */
  public String bindingId() {
    return bindingId;
  }

  /**
   * Gets the instanceId.
   *
   * The :`instance_id` is the ID of a previously provisioned service instance.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
  }

  /**
   * Gets the bindResource.
   *
   * A JSON object that contains data for platform resources associated with the binding to be created.
   *
   * @return the bindResource
   */
  public BindResource bindResource() {
    return bindResource;
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
   * The ID of the plan from the catalog.json in your broker. If present, it MUST be a non-empty string.
   *
   * @return the planId
   */
  public String planId() {
    return planId;
  }

  /**
   * Gets the serviceId.
   *
   * The ID of the service from the catalog.json in your broker. If present, it MUST be a non-empty string.
   *
   * @return the serviceId
   */
  public String serviceId() {
    return serviceId;
  }
}

