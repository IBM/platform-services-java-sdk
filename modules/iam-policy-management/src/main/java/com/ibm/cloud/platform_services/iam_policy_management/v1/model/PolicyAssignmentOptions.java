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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The set of properties required for a policy assignment.
 */
public class PolicyAssignmentOptions extends GenericModel {

  /**
   * The policy subject type; either 'iam_id' or 'access_group_id'.
   */
  public interface SubjectType {
    /** iam_id. */
    String IAM_ID = "iam_id";
    /** access_group_id. */
    String ACCESS_GROUP_ID = "access_group_id";
  }

  @SerializedName("subject_type")
  protected String subjectType;
  @SerializedName("subject_id")
  protected String subjectId;
  @SerializedName("root_requester_id")
  protected String rootRequesterId;
  @SerializedName("root_template_id")
  protected String rootTemplateId;
  @SerializedName("root_template_version")
  protected String rootTemplateVersion;

  /**
   * Builder.
   */
  public static class Builder {
    private String subjectType;
    private String subjectId;
    private String rootRequesterId;
    private String rootTemplateId;
    private String rootTemplateVersion;

    /**
     * Instantiates a new Builder from an existing PolicyAssignmentOptions instance.
     *
     * @param policyAssignmentOptions the instance to initialize the Builder with
     */
    private Builder(PolicyAssignmentOptions policyAssignmentOptions) {
      this.subjectType = policyAssignmentOptions.subjectType;
      this.subjectId = policyAssignmentOptions.subjectId;
      this.rootRequesterId = policyAssignmentOptions.rootRequesterId;
      this.rootTemplateId = policyAssignmentOptions.rootTemplateId;
      this.rootTemplateVersion = policyAssignmentOptions.rootTemplateVersion;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param subjectType the subjectType
     * @param subjectId the subjectId
     * @param rootRequesterId the rootRequesterId
     */
    public Builder(String subjectType, String subjectId, String rootRequesterId) {
      this.subjectType = subjectType;
      this.subjectId = subjectId;
      this.rootRequesterId = rootRequesterId;
    }

    /**
     * Builds a PolicyAssignmentOptions.
     *
     * @return the new PolicyAssignmentOptions instance
     */
    public PolicyAssignmentOptions build() {
      return new PolicyAssignmentOptions(this);
    }

    /**
     * Set the subjectType.
     *
     * @param subjectType the subjectType
     * @return the PolicyAssignmentOptions builder
     */
    public Builder subjectType(String subjectType) {
      this.subjectType = subjectType;
      return this;
    }

    /**
     * Set the subjectId.
     *
     * @param subjectId the subjectId
     * @return the PolicyAssignmentOptions builder
     */
    public Builder subjectId(String subjectId) {
      this.subjectId = subjectId;
      return this;
    }

    /**
     * Set the rootRequesterId.
     *
     * @param rootRequesterId the rootRequesterId
     * @return the PolicyAssignmentOptions builder
     */
    public Builder rootRequesterId(String rootRequesterId) {
      this.rootRequesterId = rootRequesterId;
      return this;
    }

    /**
     * Set the rootTemplateId.
     *
     * @param rootTemplateId the rootTemplateId
     * @return the PolicyAssignmentOptions builder
     */
    public Builder rootTemplateId(String rootTemplateId) {
      this.rootTemplateId = rootTemplateId;
      return this;
    }

    /**
     * Set the rootTemplateVersion.
     *
     * @param rootTemplateVersion the rootTemplateVersion
     * @return the PolicyAssignmentOptions builder
     */
    public Builder rootTemplateVersion(String rootTemplateVersion) {
      this.rootTemplateVersion = rootTemplateVersion;
      return this;
    }
  }

  protected PolicyAssignmentOptions() { }

  protected PolicyAssignmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.subjectType,
      "subjectType cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.subjectId,
      "subjectId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.rootRequesterId,
      "rootRequesterId cannot be null");
    subjectType = builder.subjectType;
    subjectId = builder.subjectId;
    rootRequesterId = builder.rootRequesterId;
    rootTemplateId = builder.rootTemplateId;
    rootTemplateVersion = builder.rootTemplateVersion;
  }

  /**
   * New builder.
   *
   * @return a PolicyAssignmentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the subjectType.
   *
   * The policy subject type; either 'iam_id' or 'access_group_id'.
   *
   * @return the subjectType
   */
  public String subjectType() {
    return subjectType;
  }

  /**
   * Gets the subjectId.
   *
   * The policy subject id.
   *
   * @return the subjectId
   */
  public String subjectId() {
    return subjectId;
  }

  /**
   * Gets the rootRequesterId.
   *
   * The policy assignment requester id.
   *
   * @return the rootRequesterId
   */
  public String rootRequesterId() {
    return rootRequesterId;
  }

  /**
   * Gets the rootTemplateId.
   *
   * The template id where this policy is being assigned from.
   *
   * @return the rootTemplateId
   */
  public String rootTemplateId() {
    return rootTemplateId;
  }

  /**
   * Gets the rootTemplateVersion.
   *
   * The template version where this policy is being assigned from.
   *
   * @return the rootTemplateVersion
   */
  public String rootTemplateVersion() {
    return rootTemplateVersion;
  }
}

