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

import java.util.ArrayList;
import java.util.List;

/**
 * TemplateGrantRoles.
 */
public class TemplateGrantRoles extends TemplateGrant {


  /**
   * Builder.
   */
  public static class Builder {
    private List<Roles> roles;

    /**
     * Instantiates a new Builder from an existing TemplateGrantRoles instance.
     *
     * @param templateGrantRoles the instance to initialize the Builder with
     */
    public Builder(TemplateGrant templateGrantRoles) {
      this.roles = templateGrantRoles.roles;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param roles the roles
     */
    public Builder(List<Roles> roles) {
      this.roles = roles;
    }

    /**
     * Builds a TemplateGrantRoles.
     *
     * @return the new TemplateGrantRoles instance
     */
    public TemplateGrantRoles build() {
      return new TemplateGrantRoles(this);
    }

    /**
     * Adds a new element to roles.
     *
     * @param roles the new element to be added
     * @return the TemplateGrantRoles builder
     */
    public Builder addRoles(Roles roles) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(roles,
        "roles cannot be null");
      if (this.roles == null) {
        this.roles = new ArrayList<Roles>();
      }
      this.roles.add(roles);
      return this;
    }

    /**
     * Set the roles.
     * Existing roles will be replaced.
     *
     * @param roles the roles
     * @return the TemplateGrantRoles builder
     */
    public Builder roles(List<Roles> roles) {
      this.roles = roles;
      return this;
    }
  }

  protected TemplateGrantRoles() { }

  protected TemplateGrantRoles(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.roles,
      "roles cannot be null");
    roles = builder.roles;
  }

  /**
   * New builder.
   *
   * @return a TemplateGrantRoles builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

