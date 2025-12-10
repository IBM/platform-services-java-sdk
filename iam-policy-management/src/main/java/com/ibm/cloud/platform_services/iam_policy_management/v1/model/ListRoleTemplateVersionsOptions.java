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
 * The listRoleTemplateVersions options.
 */
public class ListRoleTemplateVersionsOptions extends GenericModel {

  /**
   * Role template state.
   */
  public interface State {
    /** active. */
    String ACTIVE = "active";
    /** deleted. */
    String DELETED = "deleted";
  }

  protected String roleTemplateId;
  protected String state;
  protected Long limit;
  protected String start;

  /**
   * Builder.
   */
  public static class Builder {
    private String roleTemplateId;
    private String state;
    private Long limit;
    private String start;

    /**
     * Instantiates a new Builder from an existing ListRoleTemplateVersionsOptions instance.
     *
     * @param listRoleTemplateVersionsOptions the instance to initialize the Builder with
     */
    private Builder(ListRoleTemplateVersionsOptions listRoleTemplateVersionsOptions) {
      this.roleTemplateId = listRoleTemplateVersionsOptions.roleTemplateId;
      this.state = listRoleTemplateVersionsOptions.state;
      this.limit = listRoleTemplateVersionsOptions.limit;
      this.start = listRoleTemplateVersionsOptions.start;
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
     * Builds a ListRoleTemplateVersionsOptions.
     *
     * @return the new ListRoleTemplateVersionsOptions instance
     */
    public ListRoleTemplateVersionsOptions build() {
      return new ListRoleTemplateVersionsOptions(this);
    }

    /**
     * Set the roleTemplateId.
     *
     * @param roleTemplateId the roleTemplateId
     * @return the ListRoleTemplateVersionsOptions builder
     */
    public Builder roleTemplateId(String roleTemplateId) {
      this.roleTemplateId = roleTemplateId;
      return this;
    }

    /**
     * Set the state.
     *
     * @param state the state
     * @return the ListRoleTemplateVersionsOptions builder
     */
    public Builder state(String state) {
      this.state = state;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListRoleTemplateVersionsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the start.
     *
     * @param start the start
     * @return the ListRoleTemplateVersionsOptions builder
     */
    public Builder start(String start) {
      this.start = start;
      return this;
    }
  }

  protected ListRoleTemplateVersionsOptions() { }

  protected ListRoleTemplateVersionsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.roleTemplateId,
      "roleTemplateId cannot be empty");
    roleTemplateId = builder.roleTemplateId;
    state = builder.state;
    limit = builder.limit;
    start = builder.start;
  }

  /**
   * New builder.
   *
   * @return a ListRoleTemplateVersionsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the roleTemplateId.
   *
   * The role template ID.
   *
   * @return the roleTemplateId
   */
  public String roleTemplateId() {
    return roleTemplateId;
  }

  /**
   * Gets the state.
   *
   * Role template state.
   *
   * @return the state
   */
  public String state() {
    return state;
  }

  /**
   * Gets the limit.
   *
   * The number of documents to include in the collection.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the start.
   *
   * Page token that refers to the page of the collection to return.
   *
   * @return the start
   */
  public String start() {
    return start;
  }
}

