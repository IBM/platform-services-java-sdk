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
 * The createRoleTemplateAssignment options.
 */
public class CreateRoleTemplateAssignmentOptions extends GenericModel {

  protected AssignmentTargetDetails target;
  protected List<RoleAssignmentTemplate> templates;
  protected String acceptLanguage;

  /**
   * Builder.
   */
  public static class Builder {
    private AssignmentTargetDetails target;
    private List<RoleAssignmentTemplate> templates;
    private String acceptLanguage;

    /**
     * Instantiates a new Builder from an existing CreateRoleTemplateAssignmentOptions instance.
     *
     * @param createRoleTemplateAssignmentOptions the instance to initialize the Builder with
     */
    private Builder(CreateRoleTemplateAssignmentOptions createRoleTemplateAssignmentOptions) {
      this.target = createRoleTemplateAssignmentOptions.target;
      this.templates = createRoleTemplateAssignmentOptions.templates;
      this.acceptLanguage = createRoleTemplateAssignmentOptions.acceptLanguage;
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
    public Builder(AssignmentTargetDetails target, List<RoleAssignmentTemplate> templates) {
      this.target = target;
      this.templates = templates;
    }

    /**
     * Builds a CreateRoleTemplateAssignmentOptions.
     *
     * @return the new CreateRoleTemplateAssignmentOptions instance
     */
    public CreateRoleTemplateAssignmentOptions build() {
      return new CreateRoleTemplateAssignmentOptions(this);
    }

    /**
     * Adds a new element to templates.
     *
     * @param templates the new element to be added
     * @return the CreateRoleTemplateAssignmentOptions builder
     */
    public Builder addTemplates(RoleAssignmentTemplate templates) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(templates,
        "templates cannot be null");
      if (this.templates == null) {
        this.templates = new ArrayList<RoleAssignmentTemplate>();
      }
      this.templates.add(templates);
      return this;
    }

    /**
     * Set the target.
     *
     * @param target the target
     * @return the CreateRoleTemplateAssignmentOptions builder
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
     * @return the CreateRoleTemplateAssignmentOptions builder
     */
    public Builder templates(List<RoleAssignmentTemplate> templates) {
      this.templates = templates;
      return this;
    }

    /**
     * Set the acceptLanguage.
     *
     * @param acceptLanguage the acceptLanguage
     * @return the CreateRoleTemplateAssignmentOptions builder
     */
    public Builder acceptLanguage(String acceptLanguage) {
      this.acceptLanguage = acceptLanguage;
      return this;
    }
  }

  protected CreateRoleTemplateAssignmentOptions() { }

  protected CreateRoleTemplateAssignmentOptions(Builder builder) {
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
   * @return a CreateRoleTemplateAssignmentOptions builder
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
   * List of role template details for role assignment.
   *
   * @return the templates
   */
  public List<RoleAssignmentTemplate> templates() {
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

