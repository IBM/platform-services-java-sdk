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
 * The deleteRole options.
 */
public class DeleteRoleOptions extends GenericModel {

  protected String roleId;

  /**
   * Builder.
   */
  public static class Builder {
    private String roleId;

    /**
     * Instantiates a new Builder from an existing DeleteRoleOptions instance.
     *
     * @param deleteRoleOptions the instance to initialize the Builder with
     */
    private Builder(DeleteRoleOptions deleteRoleOptions) {
      this.roleId = deleteRoleOptions.roleId;
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
     */
    public Builder(String roleId) {
      this.roleId = roleId;
    }

    /**
     * Builds a DeleteRoleOptions.
     *
     * @return the new DeleteRoleOptions instance
     */
    public DeleteRoleOptions build() {
      return new DeleteRoleOptions(this);
    }

    /**
     * Set the roleId.
     *
     * @param roleId the roleId
     * @return the DeleteRoleOptions builder
     */
    public Builder roleId(String roleId) {
      this.roleId = roleId;
      return this;
    }
  }

  protected DeleteRoleOptions() { }

  protected DeleteRoleOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.roleId,
      "roleId cannot be empty");
    roleId = builder.roleId;
  }

  /**
   * New builder.
   *
   * @return a DeleteRoleOptions builder
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
}

