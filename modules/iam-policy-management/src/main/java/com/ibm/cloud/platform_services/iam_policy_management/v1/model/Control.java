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

package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Specifies the type of access granted by the policy.
 */
public class Control extends GenericModel {

  protected Grant grant;

  /**
   * Builder.
   */
  public static class Builder {
    private Grant grant;

    /**
     * Instantiates a new Builder from an existing Control instance.
     *
     * @param control the instance to initialize the Builder with
     */
    private Builder(Control control) {
      this.grant = control.grant;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param grant the grant
     */
    public Builder(Grant grant) {
      this.grant = grant;
    }

    /**
     * Builds a Control.
     *
     * @return the new Control instance
     */
    public Control build() {
      return new Control(this);
    }

    /**
     * Set the grant.
     *
     * @param grant the grant
     * @return the Control builder
     */
    public Builder grant(Grant grant) {
      this.grant = grant;
      return this;
    }
  }

  protected Control() { }

  protected Control(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.grant,
      "grant cannot be null");
    grant = builder.grant;
  }

  /**
   * New builder.
   *
   * @return a Control builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the grant.
   *
   * Permission granted by the policy.
   *
   * @return the grant
   */
  public Grant grant() {
    return grant;
  }
}

