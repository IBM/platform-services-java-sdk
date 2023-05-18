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
package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createPolicyTemplateAssignment options.
 */
public class CreatePolicyTemplateAssignmentOptions extends GenericModel {

  /**
   * Assignment target type.
   */
  public interface TargetType {
    /** Account. */
    String ACCOUNT = "Account";
  }

  protected String templateId;
  protected String templateVersion;
  protected String assignmentId;
  protected String targetType;
  protected String target;
  protected List<PolicyAssignmentOptions> options;
  protected String acceptLanguage;

  /**
   * Builder.
   */
  public static class Builder {
    private String templateId;
    private String templateVersion;
    private String assignmentId;
    private String targetType;
    private String target;
    private List<PolicyAssignmentOptions> options;
    private String acceptLanguage;

    /**
     * Instantiates a new Builder from an existing CreatePolicyTemplateAssignmentOptions instance.
     *
     * @param createPolicyTemplateAssignmentOptions the instance to initialize the Builder with
     */
    private Builder(CreatePolicyTemplateAssignmentOptions createPolicyTemplateAssignmentOptions) {
      this.templateId = createPolicyTemplateAssignmentOptions.templateId;
      this.templateVersion = createPolicyTemplateAssignmentOptions.templateVersion;
      this.assignmentId = createPolicyTemplateAssignmentOptions.assignmentId;
      this.targetType = createPolicyTemplateAssignmentOptions.targetType;
      this.target = createPolicyTemplateAssignmentOptions.target;
      this.options = createPolicyTemplateAssignmentOptions.options;
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
     * @param templateId the templateId
     * @param templateVersion the templateVersion
     * @param assignmentId the assignmentId
     * @param targetType the targetType
     * @param target the target
     */
    public Builder(String templateId, String templateVersion, String assignmentId, String targetType, String target) {
      this.templateId = templateId;
      this.templateVersion = templateVersion;
      this.assignmentId = assignmentId;
      this.targetType = targetType;
      this.target = target;
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
     * Adds an options to options.
     *
     * @param options the new options
     * @return the CreatePolicyTemplateAssignmentOptions builder
     */
    public Builder addOptions(PolicyAssignmentOptions options) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(options,
        "options cannot be null");
      if (this.options == null) {
        this.options = new ArrayList<PolicyAssignmentOptions>();
      }
      this.options.add(options);
      return this;
    }

    /**
     * Set the templateId.
     *
     * @param templateId the templateId
     * @return the CreatePolicyTemplateAssignmentOptions builder
     */
    public Builder templateId(String templateId) {
      this.templateId = templateId;
      return this;
    }

    /**
     * Set the templateVersion.
     *
     * @param templateVersion the templateVersion
     * @return the CreatePolicyTemplateAssignmentOptions builder
     */
    public Builder templateVersion(String templateVersion) {
      this.templateVersion = templateVersion;
      return this;
    }

    /**
     * Set the assignmentId.
     *
     * @param assignmentId the assignmentId
     * @return the CreatePolicyTemplateAssignmentOptions builder
     */
    public Builder assignmentId(String assignmentId) {
      this.assignmentId = assignmentId;
      return this;
    }

    /**
     * Set the targetType.
     *
     * @param targetType the targetType
     * @return the CreatePolicyTemplateAssignmentOptions builder
     */
    public Builder targetType(String targetType) {
      this.targetType = targetType;
      return this;
    }

    /**
     * Set the target.
     *
     * @param target the target
     * @return the CreatePolicyTemplateAssignmentOptions builder
     */
    public Builder target(String target) {
      this.target = target;
      return this;
    }

    /**
     * Set the options.
     * Existing options will be replaced.
     *
     * @param options the options
     * @return the CreatePolicyTemplateAssignmentOptions builder
     */
    public Builder options(List<PolicyAssignmentOptions> options) {
      this.options = options;
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
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.templateId,
      "templateId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.templateVersion,
      "templateVersion cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.assignmentId,
      "assignmentId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.targetType,
      "targetType cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.target,
      "target cannot be null");
    templateId = builder.templateId;
    templateVersion = builder.templateVersion;
    assignmentId = builder.assignmentId;
    targetType = builder.targetType;
    target = builder.target;
    options = builder.options;
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
   * Gets the templateId.
   *
   * policy template id.
   *
   * @return the templateId
   */
  public String templateId() {
    return templateId;
  }

  /**
   * Gets the templateVersion.
   *
   * policy template version.
   *
   * @return the templateVersion
   */
  public String templateVersion() {
    return templateVersion;
  }

  /**
   * Gets the assignmentId.
   *
   * Passed in value to correlate with other assignments.
   *
   * @return the assignmentId
   */
  public String assignmentId() {
    return assignmentId;
  }

  /**
   * Gets the targetType.
   *
   * Assignment target type.
   *
   * @return the targetType
   */
  public String targetType() {
    return targetType;
  }

  /**
   * Gets the target.
   *
   * assignment target id.
   *
   * @return the target
   */
  public String target() {
    return target;
  }

  /**
   * Gets the options.
   *
   * List of objects with required properties for a policy assignment.
   *
   * @return the options
   */
  public List<PolicyAssignmentOptions> options() {
    return options;
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

