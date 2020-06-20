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
package com.ibm.cloud.platform_services.catalog_management.v1.model;

import java.util.Date;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Validation response.
 */
public class Validation extends GenericModel {

  protected Date validated;
  protected Date requested;
  protected String state;
  @SerializedName("last_operation")
  protected String lastOperation;
  protected Map<String, Object> target;

  /**
   * Builder.
   */
  public static class Builder {
    private Date validated;
    private Date requested;
    private String state;
    private String lastOperation;
    private Map<String, Object> target;

    private Builder(Validation validation) {
      this.validated = validation.validated;
      this.requested = validation.requested;
      this.state = validation.state;
      this.lastOperation = validation.lastOperation;
      this.target = validation.target;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Validation.
     *
     * @return the new Validation instance
     */
    public Validation build() {
      return new Validation(this);
    }

    /**
     * Set the validated.
     *
     * @param validated the validated
     * @return the Validation builder
     */
    public Builder validated(Date validated) {
      this.validated = validated;
      return this;
    }

    /**
     * Set the requested.
     *
     * @param requested the requested
     * @return the Validation builder
     */
    public Builder requested(Date requested) {
      this.requested = requested;
      return this;
    }

    /**
     * Set the state.
     *
     * @param state the state
     * @return the Validation builder
     */
    public Builder state(String state) {
      this.state = state;
      return this;
    }

    /**
     * Set the lastOperation.
     *
     * @param lastOperation the lastOperation
     * @return the Validation builder
     */
    public Builder lastOperation(String lastOperation) {
      this.lastOperation = lastOperation;
      return this;
    }

    /**
     * Set the target.
     *
     * @param target the target
     * @return the Validation builder
     */
    public Builder target(Map<String, Object> target) {
      this.target = target;
      return this;
    }
  }

  protected Validation(Builder builder) {
    validated = builder.validated;
    requested = builder.requested;
    state = builder.state;
    lastOperation = builder.lastOperation;
    target = builder.target;
  }

  /**
   * New builder.
   *
   * @return a Validation builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the validated.
   *
   * Date and time of last successful validation.
   *
   * @return the validated
   */
  public Date validated() {
    return validated;
  }

  /**
   * Gets the requested.
   *
   * Date and time of last validation was requested.
   *
   * @return the requested
   */
  public Date requested() {
    return requested;
  }

  /**
   * Gets the state.
   *
   * Current validation state - &lt;empty&gt;, in_progress, valid, invalid, expired.
   *
   * @return the state
   */
  public String state() {
    return state;
  }

  /**
   * Gets the lastOperation.
   *
   * Last operation (e.g. submit_deployment, generate_installer, install_offering.
   *
   * @return the lastOperation
   */
  public String lastOperation() {
    return lastOperation;
  }

  /**
   * Gets the target.
   *
   * Validation target information (e.g. cluster_id, region, namespace, etc).  Values will vary by Content type.
   *
   * @return the target
   */
  public Map<String, Object> target() {
    return target;
  }
}

