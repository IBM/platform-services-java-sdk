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
 * The action control properties that are created in an action resource when the template is assigned.
 */
public class TemplateActionControl extends GenericModel {

  @SerializedName("service_name")
  protected String serviceName;
  protected String description;
  protected List<String> actions;

  /**
   * Builder.
   */
  public static class Builder {
    private String serviceName;
    private String description;
    private List<String> actions;

    /**
     * Instantiates a new Builder from an existing TemplateActionControl instance.
     *
     * @param templateActionControl the instance to initialize the Builder with
     */
    private Builder(TemplateActionControl templateActionControl) {
      this.serviceName = templateActionControl.serviceName;
      this.description = templateActionControl.description;
      this.actions = templateActionControl.actions;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param serviceName the serviceName
     * @param actions the actions
     */
    public Builder(String serviceName, List<String> actions) {
      this.serviceName = serviceName;
      this.actions = actions;
    }

    /**
     * Builds a TemplateActionControl.
     *
     * @return the new TemplateActionControl instance
     */
    public TemplateActionControl build() {
      return new TemplateActionControl(this);
    }

    /**
     * Adds a new element to actions.
     *
     * @param actions the new element to be added
     * @return the TemplateActionControl builder
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
     * Set the serviceName.
     *
     * @param serviceName the serviceName
     * @return the TemplateActionControl builder
     */
    public Builder serviceName(String serviceName) {
      this.serviceName = serviceName;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the TemplateActionControl builder
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
     * @return the TemplateActionControl builder
     */
    public Builder actions(List<String> actions) {
      this.actions = actions;
      return this;
    }
  }

  protected TemplateActionControl() { }

  protected TemplateActionControl(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.serviceName,
      "serviceName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.actions,
      "actions cannot be null");
    serviceName = builder.serviceName;
    description = builder.description;
    actions = builder.actions;
  }

  /**
   * New builder.
   *
   * @return a TemplateActionControl builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the serviceName.
   *
   * The service name that the action control refers.
   *
   * @return the serviceName
   */
  public String serviceName() {
    return serviceName;
  }

  /**
   * Gets the description.
   *
   * Description of the action control.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the actions.
   *
   * List of actions to control access.
   *
   * @return the actions
   */
  public List<String> actions() {
    return actions;
  }
}

