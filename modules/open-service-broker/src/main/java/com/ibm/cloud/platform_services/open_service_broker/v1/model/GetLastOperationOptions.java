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
 * The getLastOperation options.
 */
public class GetLastOperationOptions extends GenericModel {

  protected String instanceId;
  protected String operation;
  protected String planId;
  protected String serviceId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String operation;
    private String planId;
    private String serviceId;

    private Builder(GetLastOperationOptions getLastOperationOptions) {
      this.instanceId = getLastOperationOptions.instanceId;
      this.operation = getLastOperationOptions.operation;
      this.planId = getLastOperationOptions.planId;
      this.serviceId = getLastOperationOptions.serviceId;
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
     * Builds a GetLastOperationOptions.
     *
     * @return the new GetLastOperationOptions instance
     */
    public GetLastOperationOptions build() {
      return new GetLastOperationOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the GetLastOperationOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the operation.
     *
     * @param operation the operation
     * @return the GetLastOperationOptions builder
     */
    public Builder operation(String operation) {
      this.operation = operation;
      return this;
    }

    /**
     * Set the planId.
     *
     * @param planId the planId
     * @return the GetLastOperationOptions builder
     */
    public Builder planId(String planId) {
      this.planId = planId;
      return this;
    }

    /**
     * Set the serviceId.
     *
     * @param serviceId the serviceId
     * @return the GetLastOperationOptions builder
     */
    public Builder serviceId(String serviceId) {
      this.serviceId = serviceId;
      return this;
    }
  }

  protected GetLastOperationOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    instanceId = builder.instanceId;
    operation = builder.operation;
    planId = builder.planId;
    serviceId = builder.serviceId;
  }

  /**
   * New builder.
   *
   * @return a GetLastOperationOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceId.
   *
   * The unique instance ID generated during provisioning by the IBM Cloud platform.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
  }

  /**
   * Gets the operation.
   *
   * A broker-provided identifier for the operation. When a value for operation is included with asynchronous responses
   * for provision and update, and deprovision requests, the IBM Cloud platform will provide the same value using this
   * query parameter as a URL-encoded string. If present, MUST be a non-empty string.
   *
   * @return the operation
   */
  public String operation() {
    return operation;
  }

  /**
   * Gets the planId.
   *
   * ID of the plan from the catalog.json in your broker. If present, MUST be a non-empty string.
   *
   * @return the planId
   */
  public String planId() {
    return planId;
  }

  /**
   * Gets the serviceId.
   *
   * ID of the service from the catalog.json in your service broker. If present, MUST be a non-empty string.
   *
   * @return the serviceId
   */
  public String serviceId() {
    return serviceId;
  }
}

