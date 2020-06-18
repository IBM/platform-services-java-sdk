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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A role resource.
 */
public class Role extends GenericModel {

  @SerializedName("display_name")
  protected String displayName;
  protected String description;
  protected List<String> actions;
  protected String crn;

  /**
   * Builder.
   */
  public static class Builder {
    private String displayName;
    private String description;
    private List<String> actions;

    private Builder(Role role) {
      this.displayName = role.displayName;
      this.description = role.description;
      this.actions = role.actions;
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
     * Adds an actions to actions.
     *
     * @param actions the new actions
     * @return the Role builder
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
     * Set the displayName.
     *
     * @param displayName the displayName
     * @return the Role builder
     */
    public Builder displayName(String displayName) {
      this.displayName = displayName;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the Role builder
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
     * @return the Role builder
     */
    public Builder actions(List<String> actions) {
      this.actions = actions;
      return this;
    }
  }

  protected Role(Builder builder) {
    displayName = builder.displayName;
    description = builder.description;
    actions = builder.actions;
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

  /**
   * Gets the crn.
   *
   * The role CRN.
   *
   * @return the crn
   */
  public String crn() {
    return crn;
  }
}

