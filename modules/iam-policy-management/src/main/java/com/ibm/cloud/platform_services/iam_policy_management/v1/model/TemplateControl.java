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

package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Specifies the type of access that is granted by the policy.
 */
public class TemplateControl extends GenericModel {

  protected TemplateGrant grant;

  /**
   * Builder.
   */
  public static class Builder {
    private TemplateGrant grant;

    /**
     * Instantiates a new Builder from an existing TemplateControl instance.
     *
     * @param templateControl the instance to initialize the Builder with
     */
    private Builder(TemplateControl templateControl) {
      this.grant = templateControl.grant;
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
    public Builder(TemplateGrant grant) {
      this.grant = grant;
    }

    /**
     * Builds a TemplateControl.
     *
     * @return the new TemplateControl instance
     */
    public TemplateControl build() {
      return new TemplateControl(this);
    }

    /**
     * Set the grant.
     *
     * @param grant the grant
     * @return the TemplateControl builder
     */
    public Builder grant(TemplateGrant grant) {
      this.grant = grant;
      return this;
    }
  }

  protected TemplateControl() { }

  protected TemplateControl(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.grant,
      "grant cannot be null");
    grant = builder.grant;
  }

  /**
   * New builder.
   *
   * @return a TemplateControl builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the grant.
   *
   * Permission is granted by the policy.
   *
   * @return the grant
   */
  public TemplateGrant grant() {
    return grant;
  }
}
