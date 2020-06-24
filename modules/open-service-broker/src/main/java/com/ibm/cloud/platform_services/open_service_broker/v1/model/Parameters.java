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
 * Configuration options for the service instance. An opaque object, controller treats this as a blob. Brokers should
 * ensure that the client has provided valid configuration parameters and values for the operation. If this field is not
 * present in the request message, then the broker MUST NOT change the parameters of the instance as a result of this
 * request.
 */
public class Parameters extends GenericModel {

  protected Long parameter1;
  protected String parameter2;

  /**
   * Builder.
   */
  public static class Builder {
    private Long parameter1;
    private String parameter2;

    private Builder(Parameters parameters) {
      this.parameter1 = parameters.parameter1;
      this.parameter2 = parameters.parameter2;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Parameters.
     *
     * @return the new Parameters instance
     */
    public Parameters build() {
      return new Parameters(this);
    }

    /**
     * Set the parameter1.
     *
     * @param parameter1 the parameter1
     * @return the Parameters builder
     */
    public Builder parameter1(long parameter1) {
      this.parameter1 = parameter1;
      return this;
    }

    /**
     * Set the parameter2.
     *
     * @param parameter2 the parameter2
     * @return the Parameters builder
     */
    public Builder parameter2(String parameter2) {
      this.parameter2 = parameter2;
      return this;
    }
  }

  protected Parameters(Builder builder) {
    parameter1 = builder.parameter1;
    parameter2 = builder.parameter2;
  }

  /**
   * New builder.
   *
   * @return a Parameters builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the parameter1.
   *
   * a custom integer or string within the parameters JSON object.
   *
   * @return the parameter1
   */
  public Long parameter1() {
    return parameter1;
  }

  /**
   * Gets the parameter2.
   *
   * a custom integer or string within the parameters JSON object.
   *
   * @return the parameter2
   */
  public String parameter2() {
    return parameter2;
  }
}

