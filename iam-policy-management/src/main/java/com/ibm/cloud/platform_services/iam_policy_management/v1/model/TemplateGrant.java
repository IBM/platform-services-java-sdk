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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Permission is granted by the policy.
 *
 * Classes which extend this class:
 * - TemplateGrantRoles
 * - TemplateGrantRoleReferences
 */
public class TemplateGrant extends GenericModel {

  protected List<Roles> roles;
  @SerializedName("role_template_references")
  protected List<RoleTemplateReferencesItem> roleTemplateReferences;

  protected TemplateGrant() { }

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

