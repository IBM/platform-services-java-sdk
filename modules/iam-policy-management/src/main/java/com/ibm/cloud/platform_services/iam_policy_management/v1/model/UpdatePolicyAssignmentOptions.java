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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updatePolicyAssignment options.
 */
public class UpdatePolicyAssignmentOptions extends GenericModel {

  protected String assignmentId;
  protected String version;
  protected String ifMatch;
  protected String templateVersion;

  /**
   * Builder.
   */
  public static class Builder {
    private String assignmentId;
    private String version;
    private String ifMatch;
    private String templateVersion;

    /**
     * Instantiates a new Builder from an existing UpdatePolicyAssignmentOptions instance.
     *
     * @param updatePolicyAssignmentOptions the instance to initialize the Builder with
     */
    private Builder(UpdatePolicyAssignmentOptions updatePolicyAssignmentOptions) {
      this.assignmentId = updatePolicyAssignmentOptions.assignmentId;
      this.version = updatePolicyAssignmentOptions.version;
      this.ifMatch = updatePolicyAssignmentOptions.ifMatch;
      this.templateVersion = updatePolicyAssignmentOptions.templateVersion;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param assignmentId the assignmentId
     * @param version the version
     * @param ifMatch the ifMatch
     * @param templateVersion the templateVersion
     */
    public Builder(String assignmentId, String version, String ifMatch, String templateVersion) {
      this.assignmentId = assignmentId;
      this.version = version;
      this.ifMatch = ifMatch;
      this.templateVersion = templateVersion;
    }

    /**
     * Builds a UpdatePolicyAssignmentOptions.
     *
     * @return the new UpdatePolicyAssignmentOptions instance
     */
    public UpdatePolicyAssignmentOptions build() {
      return new UpdatePolicyAssignmentOptions(this);
    }

    /**
     * Set the assignmentId.
     *
     * @param assignmentId the assignmentId
     * @return the UpdatePolicyAssignmentOptions builder
     */
    public Builder assignmentId(String assignmentId) {
      this.assignmentId = assignmentId;
      return this;
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the UpdatePolicyAssignmentOptions builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the UpdatePolicyAssignmentOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the templateVersion.
     *
     * @param templateVersion the templateVersion
     * @return the UpdatePolicyAssignmentOptions builder
     */
    public Builder templateVersion(String templateVersion) {
      this.templateVersion = templateVersion;
      return this;
    }
  }

  protected UpdatePolicyAssignmentOptions() { }

  protected UpdatePolicyAssignmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.assignmentId,
      "assignmentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.version,
      "version cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ifMatch,
      "ifMatch cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.templateVersion,
      "templateVersion cannot be null");
    assignmentId = builder.assignmentId;
    version = builder.version;
    ifMatch = builder.ifMatch;
    templateVersion = builder.templateVersion;
  }

  /**
   * New builder.
   *
   * @return a UpdatePolicyAssignmentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the assignmentId.
   *
   * The policy template assignment ID.
   *
   * @return the assignmentId
   */
  public String assignmentId() {
    return assignmentId;
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
   * Gets the ifMatch.
   *
   * The revision number for updating a policy assignment and must match the ETag value of the existing policy
   * assignment. The Etag can be retrieved using the GET /v1/policy_assignments/{assignment_id} API and looking at the
   * ETag response header.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
  }

  /**
   * Gets the templateVersion.
   *
   * The policy template version to update to.
   *
   * @return the templateVersion
   */
  public String templateVersion() {
    return templateVersion;
  }
}

