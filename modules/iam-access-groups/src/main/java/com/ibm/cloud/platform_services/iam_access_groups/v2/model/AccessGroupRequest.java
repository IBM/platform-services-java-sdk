/*
 * (C) Copyright IBM Corp. 2023.
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
package com.ibm.cloud.platform_services.iam_access_groups.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Access Group Component.
 */
public class AccessGroupRequest extends GenericModel {

  protected String name;
  protected String description;
  protected Members members;
  protected Assertions assertions;
  @SerializedName("action_controls")
  protected GroupActionControls actionControls;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String description;
    private Members members;
    private Assertions assertions;
    private GroupActionControls actionControls;

    /**
     * Instantiates a new Builder from an existing AccessGroupRequest instance.
     *
     * @param accessGroupRequest the instance to initialize the Builder with
     */
    private Builder(AccessGroupRequest accessGroupRequest) {
      this.name = accessGroupRequest.name;
      this.description = accessGroupRequest.description;
      this.members = accessGroupRequest.members;
      this.assertions = accessGroupRequest.assertions;
      this.actionControls = accessGroupRequest.actionControls;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     */
    public Builder(String name) {
      this.name = name;
    }

    /**
     * Builds a AccessGroupRequest.
     *
     * @return the new AccessGroupRequest instance
     */
    public AccessGroupRequest build() {
      return new AccessGroupRequest(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the AccessGroupRequest builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the AccessGroupRequest builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the members.
     *
     * @param members the members
     * @return the AccessGroupRequest builder
     */
    public Builder members(Members members) {
      this.members = members;
      return this;
    }

    /**
     * Set the assertions.
     *
     * @param assertions the assertions
     * @return the AccessGroupRequest builder
     */
    public Builder assertions(Assertions assertions) {
      this.assertions = assertions;
      return this;
    }

    /**
     * Set the actionControls.
     *
     * @param actionControls the actionControls
     * @return the AccessGroupRequest builder
     */
    public Builder actionControls(GroupActionControls actionControls) {
      this.actionControls = actionControls;
      return this;
    }
  }

  protected AccessGroupRequest() { }

  protected AccessGroupRequest(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    name = builder.name;
    description = builder.description;
    members = builder.members;
    assertions = builder.assertions;
    actionControls = builder.actionControls;
  }

  /**
   * New builder.
   *
   * @return a AccessGroupRequest builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * Give the access group a unique name that doesn't conflict with other templates access group name in the given
   * account. This is shown in child accounts.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * Access group description. This is shown in child accounts.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the members.
   *
   * Array of enterprise users to add to the template. All enterprise users that you add to the template must be invited
   * to the child accounts where the template is assigned.
   *
   * @return the members
   */
  public Members members() {
    return members;
  }

  /**
   * Gets the assertions.
   *
   * Assertions Input Component.
   *
   * @return the assertions
   */
  public Assertions assertions() {
    return assertions;
  }

  /**
   * Gets the actionControls.
   *
   * Access group action controls component.
   *
   * @return the actionControls
   */
  public GroupActionControls actionControls() {
    return actionControls;
  }
}

