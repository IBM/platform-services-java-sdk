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

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The role properties that are created in an action resource when the template is assigned.
 */
public class RoleTemplatePrototypeRole extends GenericModel {

  protected String name;
  @SerializedName("display_name")
  protected String displayName;
  @SerializedName("service_name")
  protected String serviceName;
  protected String description;
  protected List<String> actions;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String displayName;
    private String serviceName;
    private String description;
    private List<String> actions;

    /**
     * Instantiates a new Builder from an existing RoleTemplatePrototypeRole instance.
     *
     * @param roleTemplatePrototypeRole the instance to initialize the Builder with
     */
    private Builder(RoleTemplatePrototypeRole roleTemplatePrototypeRole) {
      this.name = roleTemplatePrototypeRole.name;
      this.displayName = roleTemplatePrototypeRole.displayName;
      this.serviceName = roleTemplatePrototypeRole.serviceName;
      this.description = roleTemplatePrototypeRole.description;
      this.actions = roleTemplatePrototypeRole.actions;
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
     * @param displayName the displayName
     * @param actions the actions
     */
    public Builder(String name, String displayName, List<String> actions) {
      this.name = name;
      this.displayName = displayName;
      this.actions = actions;
    }

    /**
     * Builds a RoleTemplatePrototypeRole.
     *
     * @return the new RoleTemplatePrototypeRole instance
     */
    public RoleTemplatePrototypeRole build() {
      return new RoleTemplatePrototypeRole(this);
    }

    /**
     * Adds a new element to actions.
     *
     * @param actions the new element to be added
     * @return the RoleTemplatePrototypeRole builder
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
     * Set the name.
     *
     * @param name the name
     * @return the RoleTemplatePrototypeRole builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the displayName.
     *
     * @param displayName the displayName
     * @return the RoleTemplatePrototypeRole builder
     */
    public Builder displayName(String displayName) {
      this.displayName = displayName;
      return this;
    }

    /**
     * Set the serviceName.
     *
     * @param serviceName the serviceName
     * @return the RoleTemplatePrototypeRole builder
     */
    public Builder serviceName(String serviceName) {
      this.serviceName = serviceName;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the RoleTemplatePrototypeRole builder
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
     * @return the RoleTemplatePrototypeRole builder
     */
    public Builder actions(List<String> actions) {
      this.actions = actions;
      return this;
    }
  }

  protected RoleTemplatePrototypeRole() { }

  protected RoleTemplatePrototypeRole(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.displayName,
      "displayName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.actions,
      "actions cannot be null");
    name = builder.name;
    displayName = builder.displayName;
    serviceName = builder.serviceName;
    description = builder.description;
    actions = builder.actions;
  }

  /**
   * New builder.
   *
   * @return a RoleTemplatePrototypeRole builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * The name of the role that is used in the CRN. This must be alphanumeric and capitalized.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the displayName.
   *
   * The display the name of the role that is shown in the console.
   *
   * @return the displayName
   */
  public String displayName() {
    return displayName;
  }

  /**
   * Gets the serviceName.
   *
   * The service name that the role refers.
   *
   * @return the serviceName
   */
  public String serviceName() {
    return serviceName;
  }

  /**
   * Gets the description.
   *
   * Description of the role.
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

