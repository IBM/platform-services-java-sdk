/*
 * (C) Copyright IBM Corp. 2025.
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
 * The getServicerefTarget options.
 */
public class GetServicerefTargetOptions extends GenericModel {

  protected String serviceName;
  protected String xCorrelationId;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String serviceName;
    private String xCorrelationId;
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing GetServicerefTargetOptions instance.
     *
     * @param getServicerefTargetOptions the instance to initialize the Builder with
     */
    private Builder(GetServicerefTargetOptions getServicerefTargetOptions) {
      this.serviceName = getServicerefTargetOptions.serviceName;
      this.xCorrelationId = getServicerefTargetOptions.xCorrelationId;
      this.transactionId = getServicerefTargetOptions.transactionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param serviceName the serviceName
     */
    public Builder(String serviceName) {
      this.serviceName = serviceName;
    }

    /**
     * Builds a GetServicerefTargetOptions.
     *
     * @return the new GetServicerefTargetOptions instance
     */
    public GetServicerefTargetOptions build() {
      return new GetServicerefTargetOptions(this);
    }

    /**
     * Set the serviceName.
     *
     * @param serviceName the serviceName
     * @return the GetServicerefTargetOptions builder
     */
    public Builder serviceName(String serviceName) {
      this.serviceName = serviceName;
      return this;
    }

    /**
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the GetServicerefTargetOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the GetServicerefTargetOptions builder
     * @deprecated this method is deprecated and may be removed in a future release
     */
    @Deprecated
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected GetServicerefTargetOptions() { }

  protected GetServicerefTargetOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.serviceName,
      "serviceName cannot be empty");
    serviceName = builder.serviceName;
    xCorrelationId = builder.xCorrelationId;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a GetServicerefTargetOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the serviceName.
   *
   * The name of a service.
   *
   * @return the serviceName
   */
  public String serviceName() {
    return serviceName;
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
}

