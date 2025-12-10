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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Permission is granted by the policy.
 */
public class TemplateGrant extends GenericModel {

  protected List<Roles> roles;
  @SerializedName("role_template_references")
  protected List<RoleTemplateReferencesItem> roleTemplateReferences;

  /**
   * Builder.
   */
  public static class Builder {
    private List<Roles> roles;
    private List<RoleTemplateReferencesItem> roleTemplateReferences;

    /**
     * Instantiates a new Builder from an existing TemplateGrant instance.
     *
     * @param templateGrant the instance to initialize the Builder with
     */
    private Builder(TemplateGrant templateGrant) {
      this.roles = templateGrant.roles;
      this.roleTemplateReferences = templateGrant.roleTemplateReferences;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a TemplateGrant.
     *
     * @return the new TemplateGrant instance
     */
    public TemplateGrant build() {
      return new TemplateGrant(this);
    }

    /**
     * Adds a new element to roles.
     *
     * @param roles the new element to be added
     * @return the TemplateGrant builder
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
     * Adds a new element to roleTemplateReferences.
     *
     * @param roleTemplateReferences the new element to be added
     * @return the TemplateGrant builder
     */
    public Builder addRoleTemplateReferences(RoleTemplateReferencesItem roleTemplateReferences) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(roleTemplateReferences,
        "roleTemplateReferences cannot be null");
      if (this.roleTemplateReferences == null) {
        this.roleTemplateReferences = new ArrayList<RoleTemplateReferencesItem>();
      }
      this.roleTemplateReferences.add(roleTemplateReferences);
      return this;
    }

    /**
     * Set the roles.
     * Existing roles will be replaced.
     *
     * @param roles the roles
     * @return the TemplateGrant builder
     */
    public Builder roles(List<Roles> roles) {
      this.roles = roles;
      return this;
    }

    /**
     * Set the roleTemplateReferences.
     * Existing roleTemplateReferences will be replaced.
     *
     * @param roleTemplateReferences the roleTemplateReferences
     * @return the TemplateGrant builder
     */
    public Builder roleTemplateReferences(List<RoleTemplateReferencesItem> roleTemplateReferences) {
      this.roleTemplateReferences = roleTemplateReferences;
      return this;
    }
  }

  protected TemplateGrant() { }

  protected TemplateGrant(Builder builder) {
    roles = builder.roles;
    roleTemplateReferences = builder.roleTemplateReferences;
  }

  /**
   * New builder.
   *
   * @return a TemplateGrant builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the roles.
   *
   * A set of role Cloud Resource Names (CRNs) granted by the policy.
   *
   * @return the roles
   */
  public List<Roles> roles() {
    return roles;
  }

  /**
   * Gets the roleTemplateReferences.
   *
   * A set of role template reference IDs granted by the policy.
   *
   * @return the roleTemplateReferences
   */
  public List<RoleTemplateReferencesItem> roleTemplateReferences() {
    return roleTemplateReferences;
  }
}

