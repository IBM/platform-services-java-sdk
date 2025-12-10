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
 * The getRoleTemplate options.
 */
public class GetRoleTemplateOptions extends GenericModel {

  /**
   * The role template state.
   */
  public interface State {
    /** active. */
    String ACTIVE = "active";
    /** deleted. */
    String DELETED = "deleted";
  }

  protected String roleTemplateId;
  protected String state;

  /**
   * Builder.
   */
  public static class Builder {
    private String roleTemplateId;
    private String state;

    /**
     * Instantiates a new Builder from an existing GetRoleTemplateOptions instance.
     *
     * @param getRoleTemplateOptions the instance to initialize the Builder with
     */
    private Builder(GetRoleTemplateOptions getRoleTemplateOptions) {
      this.roleTemplateId = getRoleTemplateOptions.roleTemplateId;
      this.state = getRoleTemplateOptions.state;
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
     * Builds a GetRoleTemplateOptions.
     *
     * @return the new GetRoleTemplateOptions instance
     */
    public GetRoleTemplateOptions build() {
      return new GetRoleTemplateOptions(this);
    }

    /**
     * Set the roleTemplateId.
     *
     * @param roleTemplateId the roleTemplateId
     * @return the GetRoleTemplateOptions builder
     */
    public Builder roleTemplateId(String roleTemplateId) {
      this.roleTemplateId = roleTemplateId;
      return this;
    }

    /**
     * Set the state.
     *
     * @param state the state
     * @return the GetRoleTemplateOptions builder
     */
    public Builder state(String state) {
      this.state = state;
      return this;
    }
  }

  protected GetRoleTemplateOptions() { }

  protected GetRoleTemplateOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.roleTemplateId,
      "roleTemplateId cannot be empty");
    roleTemplateId = builder.roleTemplateId;
    state = builder.state;
  }

  /**
   * New builder.
   *
   * @return a GetRoleTemplateOptions builder
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

  /**
   * Gets the state.
   *
   * The role template state.
   *
   * @return the state
   */
  public String state() {
    return state;
  }
}

