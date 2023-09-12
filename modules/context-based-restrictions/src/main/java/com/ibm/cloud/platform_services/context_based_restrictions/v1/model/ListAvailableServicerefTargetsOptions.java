/*
 * (C) Copyright IBM Corp. 2023.
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
 * The listAvailableServicerefTargets options.
 */
public class ListAvailableServicerefTargetsOptions extends GenericModel {

  /**
   * Specifies the types of services to retrieve.
   */
  public interface Type {
    /** all. */
    String ALL = "all";
    /** platform_service. */
    String PLATFORM_SERVICE = "platform_service";
  }

  protected String xCorrelationId;
  protected String transactionId;
  protected String type;

  /**
   * Builder.
   */
  public static class Builder {
    private String xCorrelationId;
    private String transactionId;
    private String type;

    /**
     * Instantiates a new Builder from an existing ListAvailableServicerefTargetsOptions instance.
     *
     * @param listAvailableServicerefTargetsOptions the instance to initialize the Builder with
     */
    private Builder(ListAvailableServicerefTargetsOptions listAvailableServicerefTargetsOptions) {
      this.xCorrelationId = listAvailableServicerefTargetsOptions.xCorrelationId;
      this.transactionId = listAvailableServicerefTargetsOptions.transactionId;
      this.type = listAvailableServicerefTargetsOptions.type;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListAvailableServicerefTargetsOptions.
     *
     * @return the new ListAvailableServicerefTargetsOptions instance
     */
    public ListAvailableServicerefTargetsOptions build() {
      return new ListAvailableServicerefTargetsOptions(this);
    }

    /**
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the ListAvailableServicerefTargetsOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the ListAvailableServicerefTargetsOptions builder
     * @deprecated this method is deprecated and may be removed in a future release
     */
    @Deprecated
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the ListAvailableServicerefTargetsOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }
  }

  protected ListAvailableServicerefTargetsOptions() { }

  protected ListAvailableServicerefTargetsOptions(Builder builder) {
    xCorrelationId = builder.xCorrelationId;
    transactionId = builder.transactionId;
    type = builder.type;
  }

  /**
   * New builder.
   *
   * @return a ListAvailableServicerefTargetsOptions builder
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
   * Gets the type.
   *
   * Specifies the types of services to retrieve.
   *
   * @return the type
   */
  public String type() {
    return type;
  }
}

