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
 * The deleteRoleTemplate options.
 */
public class DeleteRoleTemplateOptions extends GenericModel {

  protected String roleTemplateId;

  /**
   * Builder.
   */
  public static class Builder {
    private String roleTemplateId;

    /**
     * Instantiates a new Builder from an existing DeleteRoleTemplateOptions instance.
     *
     * @param deleteRoleTemplateOptions the instance to initialize the Builder with
     */
    private Builder(DeleteRoleTemplateOptions deleteRoleTemplateOptions) {
      this.roleTemplateId = deleteRoleTemplateOptions.roleTemplateId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param roleTemplateId the roleTemplateId
     */
    public Builder(String roleTemplateId) {
      this.roleTemplateId = roleTemplateId;
    }

    /**
     * Builds a DeleteRoleTemplateOptions.
     *
     * @return the new DeleteRoleTemplateOptions instance
     */
    public DeleteRoleTemplateOptions build() {
      return new DeleteRoleTemplateOptions(this);
    }

    /**
     * Set the roleTemplateId.
     *
     * @param roleTemplateId the roleTemplateId
     * @return the DeleteRoleTemplateOptions builder
     */
    public Builder roleTemplateId(String roleTemplateId) {
      this.roleTemplateId = roleTemplateId;
      return this;
    }
  }

  protected DeleteRoleTemplateOptions() { }

  protected DeleteRoleTemplateOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.roleTemplateId,
      "roleTemplateId cannot be empty");
    roleTemplateId = builder.roleTemplateId;
  }

  /**
   * New builder.
   *
   * @return a DeleteRoleTemplateOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the roleTemplateId.
   *
   * Role template ID.
   *
   * @return the roleTemplateId
   */
  public String roleTemplateId() {
    return roleTemplateId;
  }
}

