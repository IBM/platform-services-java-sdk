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
 * The createActionControlTemplateVersion options.
 */
public class CreateActionControlTemplateVersionOptions extends GenericModel {

  protected String actionControlTemplateId;
  protected String name;
  protected String description;
  protected TemplateActionControl actionControl;
  protected Boolean committed;

  /**
   * Builder.
   */
  public static class Builder {
    private String actionControlTemplateId;
    private String name;
    private String description;
    private TemplateActionControl actionControl;
    private Boolean committed;

    /**
     * Instantiates a new Builder from an existing CreateActionControlTemplateVersionOptions instance.
     *
     * @param createActionControlTemplateVersionOptions the instance to initialize the Builder with
     */
    private Builder(CreateActionControlTemplateVersionOptions createActionControlTemplateVersionOptions) {
      this.actionControlTemplateId = createActionControlTemplateVersionOptions.actionControlTemplateId;
      this.name = createActionControlTemplateVersionOptions.name;
      this.description = createActionControlTemplateVersionOptions.description;
      this.actionControl = createActionControlTemplateVersionOptions.actionControl;
      this.committed = createActionControlTemplateVersionOptions.committed;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param actionControlTemplateId the actionControlTemplateId
     */
    public Builder(String actionControlTemplateId) {
      this.actionControlTemplateId = actionControlTemplateId;
    }

    /**
     * Builds a CreateActionControlTemplateVersionOptions.
     *
     * @return the new CreateActionControlTemplateVersionOptions instance
     */
    public CreateActionControlTemplateVersionOptions build() {
      return new CreateActionControlTemplateVersionOptions(this);
    }

    /**
     * Set the actionControlTemplateId.
     *
     * @param actionControlTemplateId the actionControlTemplateId
     * @return the CreateActionControlTemplateVersionOptions builder
     */
    public Builder actionControlTemplateId(String actionControlTemplateId) {
      this.actionControlTemplateId = actionControlTemplateId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateActionControlTemplateVersionOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateActionControlTemplateVersionOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the actionControl.
     *
     * @param actionControl the actionControl
     * @return the CreateActionControlTemplateVersionOptions builder
     */
    public Builder actionControl(TemplateActionControl actionControl) {
      this.actionControl = actionControl;
      return this;
    }

    /**
     * Set the committed.
     *
     * @param committed the committed
     * @return the CreateActionControlTemplateVersionOptions builder
     */
    public Builder committed(Boolean committed) {
      this.committed = committed;
      return this;
    }
  }

  protected CreateActionControlTemplateVersionOptions() { }

  protected CreateActionControlTemplateVersionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.actionControlTemplateId,
      "actionControlTemplateId cannot be empty");
    actionControlTemplateId = builder.actionControlTemplateId;
    name = builder.name;
    description = builder.description;
    actionControl = builder.actionControl;
    committed = builder.committed;
  }

  /**
   * New builder.
   *
   * @return a CreateActionControlTemplateVersionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the actionControlTemplateId.
   *
   * The action control template ID.
   *
   * @return the actionControlTemplateId
   */
  public String actionControlTemplateId() {
    return actionControlTemplateId;
  }

  /**
   * Gets the name.
   *
   * Required field when creating a new template. Otherwise, this field is optional. If the field is included, it will
   * change the name value for all existing versions of the template.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * Description of the action control template. This is shown to users in the enterprise account. Use this to describe
   * the purpose or context of the action control for enterprise users managing IAM templates.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the actionControl.
   *
   * The action control properties that are created in an action resource when the template is assigned.
   *
   * @return the actionControl
   */
  public TemplateActionControl actionControl() {
    return actionControl;
  }

  /**
   * Gets the committed.
   *
   * Committed status of the template version. If committed is set to true, then the template version can no longer be
   * updated.
   *
   * @return the committed
   */
  public Boolean committed() {
    return committed;
  }
}

