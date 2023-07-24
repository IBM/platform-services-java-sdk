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
 * Access Group Input Component.
 */
public class AccessGroupInput extends GenericModel {

  protected String name;
  protected String description;
  protected MembersInput members;
  protected AssertionsInput assertions;
  @SerializedName("action_controls")
  protected GroupActionControls actionControls;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String description;
    private MembersInput members;
    private AssertionsInput assertions;
    private GroupActionControls actionControls;

    /**
     * Instantiates a new Builder from an existing AccessGroupInput instance.
     *
     * @param accessGroupInput the instance to initialize the Builder with
     */
    private Builder(AccessGroupInput accessGroupInput) {
      this.name = accessGroupInput.name;
      this.description = accessGroupInput.description;
      this.members = accessGroupInput.members;
      this.assertions = accessGroupInput.assertions;
      this.actionControls = accessGroupInput.actionControls;
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
     * Builds a AccessGroupInput.
     *
     * @return the new AccessGroupInput instance
     */
    public AccessGroupInput build() {
      return new AccessGroupInput(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the AccessGroupInput builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the AccessGroupInput builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the members.
     *
     * @param members the members
     * @return the AccessGroupInput builder
     */
    public Builder members(MembersInput members) {
      this.members = members;
      return this;
    }

    /**
     * Set the assertions.
     *
     * @param assertions the assertions
     * @return the AccessGroupInput builder
     */
    public Builder assertions(AssertionsInput assertions) {
      this.assertions = assertions;
      return this;
    }

    /**
     * Set the actionControls.
     *
     * @param actionControls the actionControls
     * @return the AccessGroupInput builder
     */
    public Builder actionControls(GroupActionControls actionControls) {
      this.actionControls = actionControls;
      return this;
    }
  }

  protected AccessGroupInput() { }

  protected AccessGroupInput(Builder builder) {
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
   * @return a AccessGroupInput builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * access group input name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * access group input description.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the members.
   *
   * Members Input component.
   *
   * @return the members
   */
  public MembersInput members() {
    return members;
  }

  /**
   * Gets the assertions.
   *
   * Assertions Input Component.
   *
   * @return the assertions
   */
  public AssertionsInput assertions() {
    return assertions;
  }

  /**
   * Gets the actionControls.
   *
   * Access Group Action Controls component.
   *
   * @return the actionControls
   */
  public GroupActionControls actionControls() {
    return actionControls;
  }
}

