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
package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateRole options.
 */
public class UpdateRoleOptions extends GenericModel {

  protected String roleId;
  protected String ifMatch;
  protected String displayName;
  protected String description;
  protected List<String> actions;

  /**
   * Builder.
   */
  public static class Builder {
    private String roleId;
    private String ifMatch;
    private String displayName;
    private String description;
    private List<String> actions;

    private Builder(UpdateRoleOptions updateRoleOptions) {
      this.roleId = updateRoleOptions.roleId;
      this.ifMatch = updateRoleOptions.ifMatch;
      this.displayName = updateRoleOptions.displayName;
      this.description = updateRoleOptions.description;
      this.actions = updateRoleOptions.actions;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param roleId the roleId
     * @param ifMatch the ifMatch
     */
    public Builder(String roleId, String ifMatch) {
      this.roleId = roleId;
      this.ifMatch = ifMatch;
    }

    /**
     * Builds a UpdateRoleOptions.
     *
     * @return the new UpdateRoleOptions instance
     */
    public UpdateRoleOptions build() {
      return new UpdateRoleOptions(this);
    }

    /**
     * Adds an actions to actions.
     *
     * @param actions the new actions
     * @return the UpdateRoleOptions builder
     */
    public Builder addActions(String actions) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(actions,
        "actions cannot be null");
      if (this.actions == null) {
        this.actions = new ArrayList<String>();
      }
      this.actions.add(actions);
      return this;
    }

    /**
     * Set the roleId.
     *
     * @param roleId the roleId
     * @return the UpdateRoleOptions builder
     */
    public Builder roleId(String roleId) {
      this.roleId = roleId;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the UpdateRoleOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the displayName.
     *
     * @param displayName the displayName
     * @return the UpdateRoleOptions builder
     */
    public Builder displayName(String displayName) {
      this.displayName = displayName;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the UpdateRoleOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the actions.
     * Existing actions will be replaced.
     *
     * @param actions the actions
     * @return the UpdateRoleOptions builder
     */
    public Builder actions(List<String> actions) {
      this.actions = actions;
      return this;
    }

    /**
     * Set the role.
     *
     * @param role the role
     * @return the UpdateRoleOptions builder
     */
    public Builder role(Role role) {
      this.displayName = role.displayName();
      this.description = role.description();
      this.actions = role.actions();
      return this;
    }
  }

  protected UpdateRoleOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.roleId,
      "roleId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ifMatch,
      "ifMatch cannot be null");
    roleId = builder.roleId;
    ifMatch = builder.ifMatch;
    displayName = builder.displayName;
    description = builder.description;
    actions = builder.actions;
  }

  /**
   * New builder.
   *
   * @return a UpdateRoleOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the roleId.
   *
   * The role ID.
   *
   * @return the roleId
   */
  public String roleId() {
    return roleId;
  }

  /**
   * Gets the ifMatch.
   *
   * The revision number for updating a role and must match the ETag value of the existing role. The Etag can be
   * retrieved using the GET /v2/roles/{role_id} API and looking at the ETag response header.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
  }

  /**
   * Gets the displayName.
   *
   * The display name of the role that is shown in the console.
   *
   * @return the displayName
   */
  public String displayName() {
    return displayName;
  }

  /**
   * Gets the description.
   *
   * The description of the role.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the actions.
   *
   * The actions of the role.
   *
   * @return the actions
   */
  public List<String> actions() {
    return actions;
  }
}

