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

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The set of properties associated with the policy template assignment.
 */
public class PolicyAssignmentRecord extends GenericModel {

  /**
   * Assignment target type.
   */
  public interface TargetType {
    /** Account. */
    String ACCOUNT = "Account";
  }

  /**
   * The policy assignment status.
   */
  public interface Status {
    /** in_progress. */
    String IN_PROGRESS = "in_progress";
    /** succeeded. */
    String SUCCEEDED = "succeeded";
    /** succeed_with_errors. */
    String SUCCEED_WITH_ERRORS = "succeed_with_errors";
    /** failed. */
    String FAILED = "failed";
  }

  @SerializedName("template_id")
  protected String templateId;
  @SerializedName("template_version")
  protected String templateVersion;
  @SerializedName("assignment_id")
  protected String assignmentId;
  @SerializedName("target_type")
  protected String targetType;
  protected String target;
  protected String id;
  @SerializedName("account_id")
  protected String accountId;
  protected String href;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("created_by_id")
  protected String createdById;
  @SerializedName("last_modified_at")
  protected Date lastModifiedAt;
  @SerializedName("last_modified_by_id")
  protected String lastModifiedById;
  protected List<PolicyAssignmentOptions> options;
  protected List<PolicyAssignmentResources> resources;
  protected String status;

  protected PolicyAssignmentRecord() { }

  /**
   * Gets the templateId.
   *
   * policy template id.
   *
   * @return the templateId
   */
  public String getTemplateId() {
    return templateId;
  }

  /**
   * Gets the templateVersion.
   *
   * policy template version.
   *
   * @return the templateVersion
   */
  public String getTemplateVersion() {
    return templateVersion;
  }

  /**
   * Gets the assignmentId.
   *
   * Passed in value to correlate with other assignments.
   *
   * @return the assignmentId
   */
  public String getAssignmentId() {
    return assignmentId;
  }

  /**
   * Gets the targetType.
   *
   * Assignment target type.
   *
   * @return the targetType
   */
  public String getTargetType() {
    return targetType;
  }

  /**
   * Gets the target.
   *
   * assignment target id.
   *
   * @return the target
   */
  public String getTarget() {
    return target;
  }

  /**
   * Gets the id.
   *
   * Policy assignment ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the accountId.
   *
   * The account GUID that the policies assignments belong to..
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the href.
   *
   * The href URL that links to the policies assignments API by policy assignment ID.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }

  /**
   * Gets the createdAt.
   *
   * The UTC timestamp when the policy assignment was created.
   *
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the createdById.
   *
   * The iam ID of the entity that created the policy assignment.
   *
   * @return the createdById
   */
  public String getCreatedById() {
    return createdById;
  }

  /**
   * Gets the lastModifiedAt.
   *
   * The UTC timestamp when the policy assignment was last modified.
   *
   * @return the lastModifiedAt
   */
  public Date getLastModifiedAt() {
    return lastModifiedAt;
  }

  /**
   * Gets the lastModifiedById.
   *
   * The iam ID of the entity that last modified the policy assignment.
   *
   * @return the lastModifiedById
   */
  public String getLastModifiedById() {
    return lastModifiedById;
  }

  /**
   * Gets the options.
   *
   * Object for each properties for a policy assignment.
   *
   * @return the options
   */
  public List<PolicyAssignmentOptions> getOptions() {
    return options;
  }

  /**
   * Gets the resources.
   *
   * Object for each account assigned.
   *
   * @return the resources
   */
  public List<PolicyAssignmentResources> getResources() {
    return resources;
  }

  /**
   * Gets the status.
   *
   * The policy assignment status.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }
}

