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
 * The updateActionControlAssignment options.
 */
public class UpdateActionControlAssignmentOptions extends GenericModel {

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
     * Instantiates a new Builder from an existing UpdateActionControlAssignmentOptions instance.
     *
     * @param updateActionControlAssignmentOptions the instance to initialize the Builder with
     */
    private Builder(UpdateActionControlAssignmentOptions updateActionControlAssignmentOptions) {
      this.assignmentId = updateActionControlAssignmentOptions.assignmentId;
      this.ifMatch = updateActionControlAssignmentOptions.ifMatch;
      this.templateVersion = updateActionControlAssignmentOptions.templateVersion;
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
     * Builds a UpdateActionControlAssignmentOptions.
     *
     * @return the new UpdateActionControlAssignmentOptions instance
     */
    public UpdateActionControlAssignmentOptions build() {
      return new UpdateActionControlAssignmentOptions(this);
    }

    /**
     * Set the assignmentId.
     *
     * @param assignmentId the assignmentId
     * @return the UpdateActionControlAssignmentOptions builder
     */
    public Builder assignmentId(String assignmentId) {
      this.assignmentId = assignmentId;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the UpdateActionControlAssignmentOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the templateVersion.
     *
     * @param templateVersion the templateVersion
     * @return the UpdateActionControlAssignmentOptions builder
     */
    public Builder templateVersion(String templateVersion) {
      this.templateVersion = templateVersion;
      return this;
    }
  }

  protected UpdateActionControlAssignmentOptions() { }

  protected UpdateActionControlAssignmentOptions(Builder builder) {
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
   * @return a UpdateActionControlAssignmentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the assignmentId.
   *
   * Action control template assignment ID.
   *
   * @return the assignmentId
   */
  public String assignmentId() {
    return assignmentId;
  }

  /**
   * Gets the ifMatch.
   *
   * The revision number for updating an action control assignment and must match the Etag value of the existing action
   * control assignment. The Etag can be retrieved using the GET /v1/action_control_assignments/{assignment_id} API and
   * looking at the Etag response header.
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

