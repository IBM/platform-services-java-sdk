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
 * The updateRoleAssignment options.
 */
public class UpdateRoleAssignmentOptions extends GenericModel {

  protected String assignmentId;
  protected String ifMatch;
  protected String templateVersion;

  /**
   * Builder.
   */
  public static class Builder {
    private String assignmentId;
    private String ifMatch;
    private String templateVersion;

    /**
     * Instantiates a new Builder from an existing UpdateRoleAssignmentOptions instance.
     *
     * @param updateRoleAssignmentOptions the instance to initialize the Builder with
     */
    private Builder(UpdateRoleAssignmentOptions updateRoleAssignmentOptions) {
      this.assignmentId = updateRoleAssignmentOptions.assignmentId;
      this.ifMatch = updateRoleAssignmentOptions.ifMatch;
      this.templateVersion = updateRoleAssignmentOptions.templateVersion;
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
     * @param ifMatch the ifMatch
     * @param templateVersion the templateVersion
     */
    public Builder(String assignmentId, String ifMatch, String templateVersion) {
      this.assignmentId = assignmentId;
      this.ifMatch = ifMatch;
      this.templateVersion = templateVersion;
    }

    /**
     * Builds a UpdateRoleAssignmentOptions.
     *
     * @return the new UpdateRoleAssignmentOptions instance
     */
    public UpdateRoleAssignmentOptions build() {
      return new UpdateRoleAssignmentOptions(this);
    }

    /**
     * Set the assignmentId.
     *
     * @param assignmentId the assignmentId
     * @return the UpdateRoleAssignmentOptions builder
     */
    public Builder assignmentId(String assignmentId) {
      this.assignmentId = assignmentId;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the UpdateRoleAssignmentOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the templateVersion.
     *
     * @param templateVersion the templateVersion
     * @return the UpdateRoleAssignmentOptions builder
     */
    public Builder templateVersion(String templateVersion) {
      this.templateVersion = templateVersion;
      return this;
    }
  }

  protected UpdateRoleAssignmentOptions() { }

  protected UpdateRoleAssignmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.assignmentId,
      "assignmentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ifMatch,
      "ifMatch cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.templateVersion,
      "templateVersion cannot be null");
    assignmentId = builder.assignmentId;
    ifMatch = builder.ifMatch;
    templateVersion = builder.templateVersion;
  }

  /**
   * New builder.
   *
   * @return a UpdateRoleAssignmentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the assignmentId.
   *
   * Role template assignment ID.
   *
   * @return the assignmentId
   */
  public String assignmentId() {
    return assignmentId;
  }

  /**
   * Gets the ifMatch.
   *
   * The revision number for updating a role assignment and must match the Etag value of the existing role assignment.
   * The Etag can be retrieved using the GET /v1/role_assignments/{assignment_id} API and looking at the Etag response
   * header.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
  }

  /**
   * Gets the templateVersion.
   *
   * The version number of the template used to identify different versions of same template.
   *
   * @return the templateVersion
   */
  public String templateVersion() {
    return templateVersion;
  }
}

