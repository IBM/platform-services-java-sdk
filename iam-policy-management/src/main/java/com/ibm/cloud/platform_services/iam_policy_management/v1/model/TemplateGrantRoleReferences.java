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
 * TemplateGrantRoleReferences.
 */
public class TemplateGrantRoleReferences extends TemplateGrant {


  /**
   * Builder.
   */
  public static class Builder {
    private List<RoleTemplateReferencesItem> roleTemplateReferences;

    /**
     * Instantiates a new Builder from an existing TemplateGrantRoleReferences instance.
     *
     * @param templateGrantRoleReferences the instance to initialize the Builder with
     */
    public Builder(TemplateGrant templateGrantRoleReferences) {
      this.roleTemplateReferences = templateGrantRoleReferences.roleTemplateReferences;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param roleTemplateReferences the roleTemplateReferences
     */
    public Builder(List<RoleTemplateReferencesItem> roleTemplateReferences) {
      this.roleTemplateReferences = roleTemplateReferences;
    }

    /**
     * Builds a TemplateGrantRoleReferences.
     *
     * @return the new TemplateGrantRoleReferences instance
     */
    public TemplateGrantRoleReferences build() {
      return new TemplateGrantRoleReferences(this);
    }

    /**
     * Adds a new element to roleTemplateReferences.
     *
     * @param roleTemplateReferences the new element to be added
     * @return the TemplateGrantRoleReferences builder
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
     * Set the roleTemplateReferences.
     * Existing roleTemplateReferences will be replaced.
     *
     * @param roleTemplateReferences the roleTemplateReferences
     * @return the TemplateGrantRoleReferences builder
     */
    public Builder roleTemplateReferences(List<RoleTemplateReferencesItem> roleTemplateReferences) {
      this.roleTemplateReferences = roleTemplateReferences;
      return this;
    }
  }

  protected TemplateGrantRoleReferences() { }

  protected TemplateGrantRoleReferences(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.roleTemplateReferences,
      "roleTemplateReferences cannot be null");
    roleTemplateReferences = builder.roleTemplateReferences;
  }

  /**
   * New builder.
   *
   * @return a TemplateGrantRoleReferences builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

