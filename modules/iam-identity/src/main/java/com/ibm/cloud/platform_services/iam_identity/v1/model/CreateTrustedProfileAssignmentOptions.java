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
package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createTrustedProfileAssignment options.
 */
public class CreateTrustedProfileAssignmentOptions extends GenericModel {

  /**
   * Type of target to deploy to.
   */
  public interface TargetType {
    /** Account. */
    String ACCOUNT = "Account";
    /** AccountGroup. */
    String ACCOUNTGROUP = "AccountGroup";
  }

  protected String templateId;
  protected Long templateVersion;
  protected String targetType;
  protected String target;

  /**
   * Builder.
   */
  public static class Builder {
    private String templateId;
    private Long templateVersion;
    private String targetType;
    private String target;

    /**
     * Instantiates a new Builder from an existing CreateTrustedProfileAssignmentOptions instance.
     *
     * @param createTrustedProfileAssignmentOptions the instance to initialize the Builder with
     */
    private Builder(CreateTrustedProfileAssignmentOptions createTrustedProfileAssignmentOptions) {
      this.templateId = createTrustedProfileAssignmentOptions.templateId;
      this.templateVersion = createTrustedProfileAssignmentOptions.templateVersion;
      this.targetType = createTrustedProfileAssignmentOptions.targetType;
      this.target = createTrustedProfileAssignmentOptions.target;
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
     * @param targetType the targetType
     * @param target the target
     */
    public Builder(String templateId, Long templateVersion, String targetType, String target) {
      this.templateId = templateId;
      this.templateVersion = templateVersion;
      this.targetType = targetType;
      this.target = target;
    }

    /**
     * Builds a CreateTrustedProfileAssignmentOptions.
     *
     * @return the new CreateTrustedProfileAssignmentOptions instance
     */
    public CreateTrustedProfileAssignmentOptions build() {
      return new CreateTrustedProfileAssignmentOptions(this);
    }

    /**
     * Set the templateId.
     *
     * @param templateId the templateId
     * @return the CreateTrustedProfileAssignmentOptions builder
     */
    public Builder templateId(String templateId) {
      this.templateId = templateId;
      return this;
    }

    /**
     * Set the templateVersion.
     *
     * @param templateVersion the templateVersion
     * @return the CreateTrustedProfileAssignmentOptions builder
     */
    public Builder templateVersion(long templateVersion) {
      this.templateVersion = templateVersion;
      return this;
    }

    /**
     * Set the targetType.
     *
     * @param targetType the targetType
     * @return the CreateTrustedProfileAssignmentOptions builder
     */
    public Builder targetType(String targetType) {
      this.targetType = targetType;
      return this;
    }

    /**
     * Set the target.
     *
     * @param target the target
     * @return the CreateTrustedProfileAssignmentOptions builder
     */
    public Builder target(String target) {
      this.target = target;
      return this;
    }
  }

  protected CreateTrustedProfileAssignmentOptions() { }

  protected CreateTrustedProfileAssignmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.templateId,
      "templateId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.templateVersion,
      "templateVersion cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.targetType,
      "targetType cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.target,
      "target cannot be null");
    templateId = builder.templateId;
    templateVersion = builder.templateVersion;
    targetType = builder.targetType;
    target = builder.target;
  }

  /**
   * New builder.
   *
   * @return a CreateTrustedProfileAssignmentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the templateId.
   *
   * ID of the template to assign.
   *
   * @return the templateId
   */
  public String templateId() {
    return templateId;
  }

  /**
   * Gets the templateVersion.
   *
   * Version of the template to assign.
   *
   * @return the templateVersion
   */
  public Long templateVersion() {
    return templateVersion;
  }

  /**
   * Gets the targetType.
   *
   * Type of target to deploy to.
   *
   * @return the targetType
   */
  public String targetType() {
    return targetType;
  }

  /**
   * Gets the target.
   *
   * Identifier of target to deploy to.
   *
   * @return the target
   */
  public String target() {
    return target;
  }
}

