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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

import java.util.Date;

/**
 * Offering state.
 */
public class State extends GenericModel {

  protected String current;
  @SerializedName("current_entered")
  protected Date currentEntered;
  protected String pending;
  @SerializedName("pending_requested")
  protected Date pendingRequested;
  protected String previous;

  /**
   * Builder.
   */
  public static class Builder {
    private String current;
    private Date currentEntered;
    private String pending;
    private Date pendingRequested;
    private String previous;

    private Builder(State state) {
      this.current = state.current;
      this.currentEntered = state.currentEntered;
      this.pending = state.pending;
      this.pendingRequested = state.pendingRequested;
      this.previous = state.previous;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a State.
     *
     * @return the new State instance
     */
    public State build() {
      return new State(this);
    }

    /**
     * Set the current.
     *
     * @param current the current
     * @return the State builder
     */
    public Builder current(String current) {
      this.current = current;
      return this;
    }

    /**
     * Set the currentEntered.
     *
     * @param currentEntered the currentEntered
     * @return the State builder
     */
    public Builder currentEntered(Date currentEntered) {
      this.currentEntered = currentEntered;
      return this;
    }

    /**
     * Set the pending.
     *
     * @param pending the pending
     * @return the State builder
     */
    public Builder pending(String pending) {
      this.pending = pending;
      return this;
    }

    /**
     * Set the pendingRequested.
     *
     * @param pendingRequested the pendingRequested
     * @return the State builder
     */
    public Builder pendingRequested(Date pendingRequested) {
      this.pendingRequested = pendingRequested;
      return this;
    }

    /**
     * Set the previous.
     *
     * @param previous the previous
     * @return the State builder
     */
    public Builder previous(String previous) {
      this.previous = previous;
      return this;
    }
  }

  protected State(Builder builder) {
    current = builder.current;
    currentEntered = builder.currentEntered;
    pending = builder.pending;
    pendingRequested = builder.pendingRequested;
    previous = builder.previous;
  }

  /**
   * New builder.
   *
   * @return a State builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the current.
   *
   * one of: new, validated, account-published, ibm-published, public-published.
   *
   * @return the current
   */
  public String current() {
    return current;
  }

  /**
   * Gets the currentEntered.
   *
   * Date and time of current request.
   *
   * @return the currentEntered
   */
  public Date currentEntered() {
    return currentEntered;
  }

  /**
   * Gets the pending.
   *
   * one of: new, validated, account-published, ibm-published, public-published.
   *
   * @return the pending
   */
  public String pending() {
    return pending;
  }

  /**
   * Gets the pendingRequested.
   *
   * Date and time of pending request.
   *
   * @return the pendingRequested
   */
  public Date pendingRequested() {
    return pendingRequested;
  }

  /**
   * Gets the previous.
   *
   * one of: new, validated, account-published, ibm-published, public-published.
   *
   * @return the previous
   */
  public String previous() {
    return previous;
  }
}

