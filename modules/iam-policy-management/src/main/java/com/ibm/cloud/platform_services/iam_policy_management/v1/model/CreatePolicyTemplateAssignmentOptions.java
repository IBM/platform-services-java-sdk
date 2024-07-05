/*
 * (C) Copyright IBM Corp. 2024.
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
 * The createPolicyTemplateAssignment options.
 */
public class CreatePolicyTemplateAssignmentOptions extends GenericModel {

  protected String version;
  protected AssignmentTargetDetails target;
  protected List<AssignmentTemplateDetails> templates;
  protected String acceptLanguage;

  /**
   * Builder.
   */
  public static class Builder {
    private String version;
    private AssignmentTargetDetails target;
    private List<AssignmentTemplateDetails> templates;
    private String acceptLanguage;

    /**
     * Instantiates a new Builder from an existing CreatePolicyTemplateAssignmentOptions instance.
     *
     * @param createPolicyTemplateAssignmentOptions the instance to initialize the Builder with
     */
    private Builder(CreatePolicyTemplateAssignmentOptions createPolicyTemplateAssignmentOptions) {
      this.version = createPolicyTemplateAssignmentOptions.version;
      this.target = createPolicyTemplateAssignmentOptions.target;
      this.templates = createPolicyTemplateAssignmentOptions.templates;
      this.acceptLanguage = createPolicyTemplateAssignmentOptions.acceptLanguage;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param version the version
     * @param target the target
     * @param templates the templates
     */
    public Builder(String version, AssignmentTargetDetails target, List<AssignmentTemplateDetails> templates) {
      this.version = version;
      this.target = target;
      this.templates = templates;
    }

    /**
     * Builds a CreatePolicyTemplateAssignmentOptions.
     *
     * @return the new CreatePolicyTemplateAssignmentOptions instance
     */
    public CreatePolicyTemplateAssignmentOptions build() {
      return new CreatePolicyTemplateAssignmentOptions(this);
    }

    /**
     * Adds a new element to templates.
     *
     * @param templates the new element to be added
     * @return the CreatePolicyTemplateAssignmentOptions builder
     */
    public Builder addTemplates(AssignmentTemplateDetails templates) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(templates,
        "templates cannot be null");
      if (this.templates == null) {
        this.templates = new ArrayList<AssignmentTemplateDetails>();
      }
      this.templates.add(templates);
      return this;
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the CreatePolicyTemplateAssignmentOptions builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }

    /**
     * Set the target.
     *
     * @param target the target
     * @return the CreatePolicyTemplateAssignmentOptions builder
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
     * @return the CreatePolicyTemplateAssignmentOptions builder
     */
    public Builder templates(List<AssignmentTemplateDetails> templates) {
      this.templates = templates;
      return this;
    }

    /**
     * Set the acceptLanguage.
     *
     * @param acceptLanguage the acceptLanguage
     * @return the CreatePolicyTemplateAssignmentOptions builder
     */
    public Builder acceptLanguage(String acceptLanguage) {
      this.acceptLanguage = acceptLanguage;
      return this;
    }
  }

  protected CreatePolicyTemplateAssignmentOptions() { }

  protected CreatePolicyTemplateAssignmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.version,
      "version cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.target,
      "target cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.templates,
      "templates cannot be null");
    version = builder.version;
    target = builder.target;
    templates = builder.templates;
    acceptLanguage = builder.acceptLanguage;
  }

  /**
   * New builder.
   *
   * @return a CreatePolicyTemplateAssignmentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the version.
   *
   * specify version of response body format.
   *
   * @return the version
   */
  public String version() {
    return version;
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
   * List of template details for policy assignment.
   *
   * @return the templates
   */
  public List<AssignmentTemplateDetails> templates() {
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

