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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Permission granted by the policy.
 */
public class Grant extends GenericModel {

  protected List<Roles> roles;

  /**
   * Builder.
   */
  public static class Builder {
    private List<Roles> roles;

    /**
     * Instantiates a new Builder from an existing Grant instance.
     *
     * @param grant the instance to initialize the Builder with
     */
    private Builder(Grant grant) {
      this.roles = grant.roles;
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
     * Builds a Grant.
     *
     * @return the new Grant instance
     */
    public Grant build() {
      return new Grant(this);
    }

    /**
     * Adds a new element to roles.
     *
     * @param roles the new element to be added
     * @return the Grant builder
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
     * @return the Grant builder
     */
    public Builder roles(List<Roles> roles) {
      this.roles = roles;
      return this;
    }
  }

  protected Grant() { }

  protected Grant(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.roles,
      "roles cannot be null");
    roles = builder.roles;
  }

  /**
   * New builder.
   *
   * @return a Grant builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the roles.
   *
   * A set of role cloud resource names (CRNs) granted by the policy.
   *
   * @return the roles
   */
  public List<Roles> roles() {
    return roles;
  }
}

