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
package com.ibm.cloud.platform_services.user_management.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The role of an IAM policy.
 */
public class Role extends GenericModel {

  @SerializedName("role_id")
  protected String roleId;

  /**
   * Builder.
   */
  public static class Builder {
    private String roleId;

    private Builder(Role role) {
      this.roleId = role.roleId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Role.
     *
     * @return the new Role instance
     */
    public Role build() {
      return new Role(this);
    }

    /**
     * Set the roleId.
     *
     * @param roleId the roleId
     * @return the Role builder
     */
    public Builder roleId(String roleId) {
      this.roleId = roleId;
      return this;
    }
  }

  protected Role(Builder builder) {
    roleId = builder.roleId;
  }

  /**
   * New builder.
   *
   * @return a Role builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the roleId.
   *
   * An alphanumeric value identifying the origin.
   *
   * @return the roleId
   */
  public String roleId() {
    return roleId;
  }
}

