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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A role associated with a policy with additional information (display_name, description, actions) when
 * `format=display`.
 */
public class EnrichedRoles extends GenericModel {

  @SerializedName("role_id")
  protected String roleId;
  @SerializedName("display_name")
  protected String displayName;
  protected String description;
  protected List<RoleAction> actions;

  protected EnrichedRoles() { }

  /**
   * Gets the roleId.
   *
   * The role Cloud Resource Name (CRN) granted by the policy. Example CRN: 'crn:v1:bluemix:public:iam::::role:Editor'.
   *
   * @return the roleId
   */
  public String getRoleId() {
    return roleId;
  }

  /**
   * Gets the displayName.
   *
   * The service defined (or user defined if a custom role) display name of the role.
   *
   * @return the displayName
   */
  public String getDisplayName() {
    return displayName;
  }

  /**
   * Gets the description.
   *
   * The service defined (or user defined if a custom role) description of the role.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the actions.
   *
   * The actions of the role. For more information, see [IAM roles and
   * actions](https://cloud.ibm.com/docs/account?topic=account-iam-service-roles-actions).
   *
   * @return the actions
   */
  public List<RoleAction> getActions() {
    return actions;
  }
}

