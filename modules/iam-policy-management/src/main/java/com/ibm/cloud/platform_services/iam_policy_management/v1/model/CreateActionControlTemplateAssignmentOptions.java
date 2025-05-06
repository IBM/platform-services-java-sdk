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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createActionControlTemplateAssignment options.
 */
public class CreateActionControlTemplateAssignmentOptions extends GenericModel {

  protected AssignmentTargetDetails target;
  protected List<ActionControlAssignmentTemplate> templates;
  protected String acceptLanguage;

  /**
   * Builder.
   */
  public static class Builder {
    private AssignmentTargetDetails target;
    private List<ActionControlAssignmentTemplate> templates;
    private String acceptLanguage;

    /**
     * Instantiates a new Builder from an existing CreateActionControlTemplateAssignmentOptions instance.
     *
     * @param createActionControlTemplateAssignmentOptions the instance to initialize the Builder with
     */
    private Builder(CreateActionControlTemplateAssignmentOptions createActionControlTemplateAssignmentOptions) {
      this.target = createActionControlTemplateAssignmentOptions.target;
      this.templates = createActionControlTemplateAssignmentOptions.templates;
      this.acceptLanguage = createActionControlTemplateAssignmentOptions.acceptLanguage;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param target the target
     * @param templates the templates
     */
    public Builder(AssignmentTargetDetails target, List<ActionControlAssignmentTemplate> templates) {
      this.target = target;
      this.templates = templates;
    }

    /**
     * Builds a CreateActionControlTemplateAssignmentOptions.
     *
     * @return the new CreateActionControlTemplateAssignmentOptions instance
     */
    public CreateActionControlTemplateAssignmentOptions build() {
      return new CreateActionControlTemplateAssignmentOptions(this);
    }

    /**
     * Adds a new element to templates.
     *
     * @param templates the new element to be added
     * @return the CreateActionControlTemplateAssignmentOptions builder
     */
    public Builder addTemplates(ActionControlAssignmentTemplate templates) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(templates,
        "templates cannot be null");
      if (this.templates == null) {
        this.templates = new ArrayList<ActionControlAssignmentTemplate>();
      }
      this.templates.add(templates);
      return this;
    }

    /**
     * Set the target.
     *
     * @param target the target
     * @return the CreateActionControlTemplateAssignmentOptions builder
     */
    public Builder target(AssignmentTargetDetails target) {
      this.target = target;
      return this;
    }

    /**
     * Set the templates.
     * Existing templates will be replaced.
     *
     * @param templates the templates
     * @return the CreateActionControlTemplateAssignmentOptions builder
     */
    public Builder templates(List<ActionControlAssignmentTemplate> templates) {
      this.templates = templates;
      return this;
    }

    /**
     * Set the acceptLanguage.
     *
     * @param acceptLanguage the acceptLanguage
     * @return the CreateActionControlTemplateAssignmentOptions builder
     */
    public Builder acceptLanguage(String acceptLanguage) {
      this.acceptLanguage = acceptLanguage;
      return this;
    }
  }

  protected CreateActionControlTemplateAssignmentOptions() { }

  protected CreateActionControlTemplateAssignmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.target,
      "target cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.templates,
      "templates cannot be null");
    target = builder.target;
    templates = builder.templates;
    acceptLanguage = builder.acceptLanguage;
  }

  /**
   * New builder.
   *
   * @return a CreateActionControlTemplateAssignmentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the target.
   *
   * assignment target account and type.
   *
   * @return the target
   */
  public AssignmentTargetDetails target() {
    return target;
  }

  /**
   * Gets the templates.
   *
   * List of action control template details for action control assignment.
   *
   * @return the templates
   */
  public List<ActionControlAssignmentTemplate> templates() {
    return templates;
  }

  /**
   * Gets the acceptLanguage.
   *
   * Language code for translations
   * * `default` - English
   * * `de` -  German (Standard)
   * * `en` - English
   * * `es` - Spanish (Spain)
   * * `fr` - French (Standard)
   * * `it` - Italian (Standard)
   * * `ja` - Japanese
   * * `ko` - Korean
   * * `pt-br` - Portuguese (Brazil)
   * * `zh-cn` - Chinese (Simplified, PRC)
   * * `zh-tw` - (Chinese, Taiwan).
   *
   * @return the acceptLanguage
   */
  public String acceptLanguage() {
    return acceptLanguage;
  }
}

