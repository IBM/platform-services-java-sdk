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
 * The replaceServiceInstance options.
 */
public class ReplaceServiceInstanceOptions extends GenericModel {

  protected String instanceId;
  protected List<Context> context;
  protected String organizationGuid;
  protected List<Parameters> parameters;
  protected String planId;
  protected String serviceId;
  protected String spaceGuid;
  protected Boolean acceptsIncomplete;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private List<Context> context;
    private String organizationGuid;
    private List<Parameters> parameters;
    private String planId;
    private String serviceId;
    private String spaceGuid;
    private Boolean acceptsIncomplete;

    private Builder(ReplaceServiceInstanceOptions replaceServiceInstanceOptions) {
      this.instanceId = replaceServiceInstanceOptions.instanceId;
      this.context = replaceServiceInstanceOptions.context;
      this.organizationGuid = replaceServiceInstanceOptions.organizationGuid;
      this.parameters = replaceServiceInstanceOptions.parameters;
      this.planId = replaceServiceInstanceOptions.planId;
      this.serviceId = replaceServiceInstanceOptions.serviceId;
      this.spaceGuid = replaceServiceInstanceOptions.spaceGuid;
      this.acceptsIncomplete = replaceServiceInstanceOptions.acceptsIncomplete;
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
     * Builds a ReplaceServiceInstanceOptions.
     *
     * @return the new ReplaceServiceInstanceOptions instance
     */
    public ReplaceServiceInstanceOptions build() {
      return new ReplaceServiceInstanceOptions(this);
    }

    /**
     * Adds an context to context.
     *
     * @param context the new context
     * @return the ReplaceServiceInstanceOptions builder
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
     * Adds an parameters to parameters.
     *
     * @param parameters the new parameters
     * @return the ReplaceServiceInstanceOptions builder
     */
    public Builder addParameters(Parameters parameters) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(parameters,
        "parameters cannot be null");
      if (this.parameters == null) {
        this.parameters = new ArrayList<Parameters>();
      }
      this.parameters.add(parameters);
      return this;
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the ReplaceServiceInstanceOptions builder
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
     * @return the ReplaceServiceInstanceOptions builder
     */
    public Builder context(List<Context> context) {
      this.context = context;
      return this;
    }

    /**
     * Set the organizationGuid.
     *
     * @param organizationGuid the organizationGuid
     * @return the ReplaceServiceInstanceOptions builder
     */
    public Builder organizationGuid(String organizationGuid) {
      this.organizationGuid = organizationGuid;
      return this;
    }

    /**
     * Set the parameters.
     * Existing parameters will be replaced.
     *
     * @param parameters the parameters
     * @return the ReplaceServiceInstanceOptions builder
     */
    public Builder parameters(List<Parameters> parameters) {
      this.parameters = parameters;
      return this;
    }

    /**
     * Set the planId.
     *
     * @param planId the planId
     * @return the ReplaceServiceInstanceOptions builder
     */
    public Builder planId(String planId) {
      this.planId = planId;
      return this;
    }

    /**
     * Set the serviceId.
     *
     * @param serviceId the serviceId
     * @return the ReplaceServiceInstanceOptions builder
     */
    public Builder serviceId(String serviceId) {
      this.serviceId = serviceId;
      return this;
    }

    /**
     * Set the spaceGuid.
     *
     * @param spaceGuid the spaceGuid
     * @return the ReplaceServiceInstanceOptions builder
     */
    public Builder spaceGuid(String spaceGuid) {
      this.spaceGuid = spaceGuid;
      return this;
    }

    /**
     * Set the acceptsIncomplete.
     *
     * @param acceptsIncomplete the acceptsIncomplete
     * @return the ReplaceServiceInstanceOptions builder
     */
    public Builder acceptsIncomplete(Boolean acceptsIncomplete) {
      this.acceptsIncomplete = acceptsIncomplete;
      return this;
    }
  }

  protected ReplaceServiceInstanceOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    instanceId = builder.instanceId;
    context = builder.context;
    organizationGuid = builder.organizationGuid;
    parameters = builder.parameters;
    planId = builder.planId;
    serviceId = builder.serviceId;
    spaceGuid = builder.spaceGuid;
    acceptsIncomplete = builder.acceptsIncomplete;
  }

  /**
   * New builder.
   *
   * @return a ReplaceServiceInstanceOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceId.
   *
   * The `instance_id` of a service instance is provided by the IBM Cloud platform. This ID will be used for future
   * requests to bind and deprovision, so the broker can use it to correlate the resource it creates.
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
  public List<Context> context() {
    return context;
  }

  /**
   * Gets the organizationGuid.
   *
   * Deprecated in favor of `context`. The identifier for the project space within the IBM Cloud platform organization.
   * Although most brokers will not use this field, it might be helpful for executing operations on a user's behalf. It
   * MUST be a non-empty string.
   *
   * @return the organizationGuid
   */
  public String organizationGuid() {
    return organizationGuid;
  }

  /**
   * Gets the parameters.
   *
   * A list of plans for this service that must contain at least one plan.
   *
   * @return the parameters
   */
  public List<Parameters> parameters() {
    return parameters;
  }

  /**
   * Gets the planId.
   *
   * The ID of the plan for which the service instance has been requested, which is stored in the catalog.json of your
   * broker. This value should be a GUID and it MUST be unique to a service.
   *
   * @return the planId
   */
  public String planId() {
    return planId;
  }

  /**
   * Gets the serviceId.
   *
   * The ID of the service stored in the catalog.json of your broker. This value should be a GUID and it MUST be a
   * non-empty string.
   *
   * @return the serviceId
   */
  public String serviceId() {
    return serviceId;
  }

  /**
   * Gets the spaceGuid.
   *
   * Deprecated in favor of `context`. The IBM Cloud platform GUID for the organization under which the service instance
   * is to be provisioned. Although most brokers will not use this field, it might be helpful for executing operations
   * on a user's behalf. It MUST be a non-empty string.
   *
   * @return the spaceGuid
   */
  public String spaceGuid() {
    return spaceGuid;
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

