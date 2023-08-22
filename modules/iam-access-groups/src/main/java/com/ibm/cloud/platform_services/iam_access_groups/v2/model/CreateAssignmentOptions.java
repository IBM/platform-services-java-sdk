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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createAssignment options.
 */
public class CreateAssignmentOptions extends GenericModel {

  /**
   * The type of the entity to which the template should be assigned, e.g. 'Account', 'AccountGroup', etc.
   */
  public interface TargetType {
    /** Account. */
    String ACCOUNT = "Account";
    /** AccountGroup. */
    String ACCOUNTGROUP = "AccountGroup";
  }

  protected String templateId;
  protected String templateVersion;
  protected String targetType;
  protected String target;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String templateId;
    private String templateVersion;
    private String targetType;
    private String target;
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing CreateAssignmentOptions instance.
     *
     * @param createAssignmentOptions the instance to initialize the Builder with
     */
    private Builder(CreateAssignmentOptions createAssignmentOptions) {
      this.templateId = createAssignmentOptions.templateId;
      this.templateVersion = createAssignmentOptions.templateVersion;
      this.targetType = createAssignmentOptions.targetType;
      this.target = createAssignmentOptions.target;
      this.transactionId = createAssignmentOptions.transactionId;
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
    public Builder(String templateId, String templateVersion, String targetType, String target) {
      this.templateId = templateId;
      this.templateVersion = templateVersion;
      this.targetType = targetType;
      this.target = target;
    }

    /**
     * Builds a CreateAssignmentOptions.
     *
     * @return the new CreateAssignmentOptions instance
     */
    public CreateAssignmentOptions build() {
      return new CreateAssignmentOptions(this);
    }

    /**
     * Set the templateId.
     *
     * @param templateId the templateId
     * @return the CreateAssignmentOptions builder
     */
    public Builder templateId(String templateId) {
      this.templateId = templateId;
      return this;
    }

    /**
     * Set the templateVersion.
     *
     * @param templateVersion the templateVersion
     * @return the CreateAssignmentOptions builder
     */
    public Builder templateVersion(String templateVersion) {
      this.templateVersion = templateVersion;
      return this;
    }

    /**
     * Set the targetType.
     *
     * @param targetType the targetType
     * @return the CreateAssignmentOptions builder
     */
    public Builder targetType(String targetType) {
      this.targetType = targetType;
      return this;
    }

    /**
     * Set the target.
     *
     * @param target the target
     * @return the CreateAssignmentOptions builder
     */
    public Builder target(String target) {
      this.target = target;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the CreateAssignmentOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected CreateAssignmentOptions() { }

  protected CreateAssignmentOptions(Builder builder) {
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
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a CreateAssignmentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the templateId.
   *
   * The unique identifier of the template to be assigned.
   *
   * @return the templateId
   */
  public String templateId() {
    return templateId;
  }

  /**
   * Gets the templateVersion.
   *
   * The version number of the template to be assigned.
   *
   * @return the templateVersion
   */
  public String templateVersion() {
    return templateVersion;
  }

  /**
   * Gets the targetType.
   *
   * The type of the entity to which the template should be assigned, e.g. 'Account', 'AccountGroup', etc.
   *
   * @return the targetType
   */
  public String targetType() {
    return targetType;
  }

  /**
   * Gets the target.
   *
   * The unique identifier of the entity to which the template should be assigned.
   *
   * @return the target
   */
  public String target() {
    return target;
  }

  /**
   * Gets the transactionId.
   *
   * An optional transaction id for the request.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }
}

