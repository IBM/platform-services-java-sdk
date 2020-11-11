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
package com.ibm.cloud.platform_services.configuration_governance.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * EnforcementAction.
 */
public class EnforcementAction extends GenericModel {

  /**
   * To block a request from completing, use `disallow`. To log the request to Activity Tracker with LogDNA, use
   * `audit_log`.
   */
  public interface Action {
    /** audit_log. */
    String AUDIT_LOG = "audit_log";
    /** disallow. */
    String DISALLOW = "disallow";
  }

  protected String action;

  /**
   * Builder.
   */
  public static class Builder {
    private String action;

    private Builder(EnforcementAction enforcementAction) {
      this.action = enforcementAction.action;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param action the action
     */
    public Builder(String action) {
      this.action = action;
    }

    /**
     * Builds a EnforcementAction.
     *
     * @return the new EnforcementAction instance
     */
    public EnforcementAction build() {
      return new EnforcementAction(this);
    }

    /**
     * Set the action.
     *
     * @param action the action
     * @return the EnforcementAction builder
     */
    public Builder action(String action) {
      this.action = action;
      return this;
    }
  }

  protected EnforcementAction(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.action,
      "action cannot be null");
    action = builder.action;
  }

  /**
   * New builder.
   *
   * @return a EnforcementAction builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the action.
   *
   * To block a request from completing, use `disallow`. To log the request to Activity Tracker with LogDNA, use
   * `audit_log`.
   *
   * @return the action
   */
  public String action() {
    return action;
  }
}

