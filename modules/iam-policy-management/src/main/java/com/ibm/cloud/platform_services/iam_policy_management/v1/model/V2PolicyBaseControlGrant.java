/*
 * (C) Copyright IBM Corp. 2022.
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
public class V2PolicyBaseControlGrant extends GenericModel {

  protected List<PolicyRole> roles;

  /**
   * Builder.
   */
  public static class Builder {
    private List<PolicyRole> roles;

    /**
     * Instantiates a new Builder from an existing V2PolicyBaseControlGrant instance.
     *
     * @param v2PolicyBaseControlGrant the instance to initialize the Builder with
     */
    private Builder(V2PolicyBaseControlGrant v2PolicyBaseControlGrant) {
      this.roles = v2PolicyBaseControlGrant.roles;
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
    public Builder(List<PolicyRole> roles) {
      this.roles = roles;
    }

    /**
     * Builds a V2PolicyBaseControlGrant.
     *
     * @return the new V2PolicyBaseControlGrant instance
     */
    public V2PolicyBaseControlGrant build() {
      return new V2PolicyBaseControlGrant(this);
    }

    /**
     * Adds an roles to roles.
     *
     * @param roles the new roles
     * @return the V2PolicyBaseControlGrant builder
     */
    public Builder addRoles(PolicyRole roles) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(roles,
        "roles cannot be null");
      if (this.roles == null) {
        this.roles = new ArrayList<PolicyRole>();
      }
      this.roles.add(roles);
      return this;
    }

    /**
     * Set the roles.
     * Existing roles will be replaced.
     *
     * @param roles the roles
     * @return the V2PolicyBaseControlGrant builder
     */
    public Builder roles(List<PolicyRole> roles) {
      this.roles = roles;
      return this;
    }
  }

  protected V2PolicyBaseControlGrant() { }

  protected V2PolicyBaseControlGrant(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.roles,
      "roles cannot be null");
    roles = builder.roles;
  }

  /**
   * New builder.
   *
   * @return a V2PolicyBaseControlGrant builder
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
  public List<PolicyRole> roles() {
    return roles;
  }
}

