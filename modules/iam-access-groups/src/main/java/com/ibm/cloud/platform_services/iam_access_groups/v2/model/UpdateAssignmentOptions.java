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
 * The updateAssignment options.
 */
public class UpdateAssignmentOptions extends GenericModel {

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
     * Instantiates a new Builder from an existing UpdateAssignmentOptions instance.
     *
     * @param updateAssignmentOptions the instance to initialize the Builder with
     */
    private Builder(UpdateAssignmentOptions updateAssignmentOptions) {
      this.assignmentId = updateAssignmentOptions.assignmentId;
      this.ifMatch = updateAssignmentOptions.ifMatch;
      this.templateVersion = updateAssignmentOptions.templateVersion;
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
     * Builds a UpdateAssignmentOptions.
     *
     * @return the new UpdateAssignmentOptions instance
     */
    public UpdateAssignmentOptions build() {
      return new UpdateAssignmentOptions(this);
    }

    /**
     * Set the assignmentId.
     *
     * @param assignmentId the assignmentId
     * @return the UpdateAssignmentOptions builder
     */
    public Builder assignmentId(String assignmentId) {
      this.assignmentId = assignmentId;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the UpdateAssignmentOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the templateVersion.
     *
     * @param templateVersion the templateVersion
     * @return the UpdateAssignmentOptions builder
     */
    public Builder templateVersion(String templateVersion) {
      this.templateVersion = templateVersion;
      return this;
    }
  }

  protected UpdateAssignmentOptions() { }

  protected UpdateAssignmentOptions(Builder builder) {
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
   * @return a UpdateAssignmentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the assignmentId.
   *
   * ID of the Assignment Record.
   *
   * @return the assignmentId
   */
  public String assignmentId() {
    return assignmentId;
  }

  /**
   * Gets the ifMatch.
   *
   * Version of the Assignment to be updated. Specify the version that you retrieved when reading the Assignment. This
   * value helps identifying parallel usage of this API. Pass * to indicate to update any version available. This might
   * result in stale updates.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
  }

  /**
   * Gets the templateVersion.
   *
   * Template version which shall be applied to the assignment.
   *
   * @return the templateVersion
   */
  public String templateVersion() {
    return templateVersion;
  }
}

