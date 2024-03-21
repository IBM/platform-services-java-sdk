/*
 * (C) Copyright IBM Corp. 2024.
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
package com.ibm.cloud.platform_services.context_based_restrictions.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listAvailableServiceOperations options.
 */
public class ListAvailableServiceOperationsOptions extends GenericModel {

  protected String xCorrelationId;
  protected String transactionId;
  protected String serviceName;
  protected String serviceGroupId;
  protected String resourceType;

  /**
   * Builder.
   */
  public static class Builder {
    private String xCorrelationId;
    private String transactionId;
    private String serviceName;
    private String serviceGroupId;
    private String resourceType;

    /**
     * Instantiates a new Builder from an existing ListAvailableServiceOperationsOptions instance.
     *
     * @param listAvailableServiceOperationsOptions the instance to initialize the Builder with
     */
    private Builder(ListAvailableServiceOperationsOptions listAvailableServiceOperationsOptions) {
      this.xCorrelationId = listAvailableServiceOperationsOptions.xCorrelationId;
      this.transactionId = listAvailableServiceOperationsOptions.transactionId;
      this.serviceName = listAvailableServiceOperationsOptions.serviceName;
      this.serviceGroupId = listAvailableServiceOperationsOptions.serviceGroupId;
      this.resourceType = listAvailableServiceOperationsOptions.resourceType;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListAvailableServiceOperationsOptions.
     *
     * @return the new ListAvailableServiceOperationsOptions instance
     */
    public ListAvailableServiceOperationsOptions build() {
      return new ListAvailableServiceOperationsOptions(this);
    }

    /**
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the ListAvailableServiceOperationsOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the ListAvailableServiceOperationsOptions builder
     * @deprecated this method is deprecated and may be removed in a future release
     */
    @Deprecated
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the serviceName.
     *
     * @param serviceName the serviceName
     * @return the ListAvailableServiceOperationsOptions builder
     */
    public Builder serviceName(String serviceName) {
      this.serviceName = serviceName;
      return this;
    }

    /**
     * Set the serviceGroupId.
     *
     * @param serviceGroupId the serviceGroupId
     * @return the ListAvailableServiceOperationsOptions builder
     */
    public Builder serviceGroupId(String serviceGroupId) {
      this.serviceGroupId = serviceGroupId;
      return this;
    }

    /**
     * Set the resourceType.
     *
     * @param resourceType the resourceType
     * @return the ListAvailableServiceOperationsOptions builder
     */
    public Builder resourceType(String resourceType) {
      this.resourceType = resourceType;
      return this;
    }
  }

  protected ListAvailableServiceOperationsOptions() { }

  protected ListAvailableServiceOperationsOptions(Builder builder) {
    xCorrelationId = builder.xCorrelationId;
    transactionId = builder.transactionId;
    serviceName = builder.serviceName;
    serviceGroupId = builder.serviceGroupId;
    resourceType = builder.resourceType;
  }

  /**
   * New builder.
   *
   * @return a ListAvailableServiceOperationsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the xCorrelationId.
   *
   * The supplied or generated value of this header is logged for a request and repeated in a response header for the
   * corresponding response. The same value is used for downstream requests and retries of those requests. If a value of
   * this headers is not supplied in a request, the service generates a random (version 4) UUID.
   *
   * @return the xCorrelationId
   */
  public String xCorrelationId() {
    return xCorrelationId;
  }

  /**
   * Gets the transactionId.
   *
   * The `Transaction-Id` header behaves as the `X-Correlation-Id` header. It is supported for backward compatibility
   * with other IBM platform services that support the `Transaction-Id` header only. If both `X-Correlation-Id` and
   * `Transaction-Id` are provided, `X-Correlation-Id` has the precedence over `Transaction-Id`.
   *
   * @return the transactionId
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
  public String transactionId() {
    return transactionId;
  }

  /**
   * Gets the serviceName.
   *
   * The name of the service.
   *
   * @return the serviceName
   */
  public String serviceName() {
    return serviceName;
  }

  /**
   * Gets the serviceGroupId.
   *
   * The id of the service group.
   *
   * @return the serviceGroupId
   */
  public String serviceGroupId() {
    return serviceGroupId;
  }

  /**
   * Gets the resourceType.
   *
   * The type of resource.
   *
   * @return the resourceType
   */
  public String resourceType() {
    return resourceType;
  }
}

