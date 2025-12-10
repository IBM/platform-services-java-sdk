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

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The set of properties associated with the assigned role template.
 */
public class RoleAssignment extends GenericModel {

  /**
   * The current operation of the role assignment.
   */
  public interface Operation {
    /** create. */
    String CREATE = "create";
    /** apply. */
    String APPLY = "apply";
    /** update. */
    String UPDATE = "update";
    /** remove. */
    String REMOVE = "remove";
  }

  /**
   * The role assignment status.
   */
  public interface Status {
    /** accepted. */
    String ACCEPTED = "accepted";
    /** failure. */
    String FAILURE = "failure";
    /** in_progress. */
    String IN_PROGRESS = "in_progress";
    /** superseded. */
    String SUPERSEDED = "superseded";
  }

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
  protected String operation;
  protected List<RoleAssignmentResource> resources;
  protected RoleAssignmentTemplate template;
  protected AssignmentTargetDetails target;
  protected String status;

  protected RoleAssignment() { }

  /**
   * Gets the id.
   *
   * Action control assignment ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the accountId.
   *
   * The account GUID that the role assignments belong to.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the href.
   *
   * The href URL that links to the role assignments API by role assignment ID.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }

  /**
   * Gets the createdAt.
   *
   * The UTC timestamp when the role assignment was created.
   *
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the createdById.
   *
   * The IAM ID of the entity that created the role assignment.
   *
   * @return the createdById
   */
  public String getCreatedById() {
    return createdById;
  }

  /**
   * Gets the lastModifiedAt.
   *
   * The UTC timestamp when the role assignment was last modified.
   *
   * @return the lastModifiedAt
   */
  public Date getLastModifiedAt() {
    return lastModifiedAt;
  }

  /**
   * Gets the lastModifiedById.
   *
   * The IAM ID of the entity that last modified the role assignment.
   *
   * @return the lastModifiedById
   */
  public String getLastModifiedById() {
    return lastModifiedById;
  }

  /**
   * Gets the operation.
   *
   * The current operation of the role assignment.
   *
   * @return the operation
   */
  public String getOperation() {
    return operation;
  }

  /**
   * Gets the resources.
   *
   * Resources created when role template is assigned.
   *
   * @return the resources
   */
  public List<RoleAssignmentResource> getResources() {
    return resources;
  }

  /**
   * Gets the template.
   *
   * The role template id and version that will be assigned.
   *
   * @return the template
   */
  public RoleAssignmentTemplate getTemplate() {
    return template;
  }

  /**
   * Gets the target.
   *
   * assignment target account and type.
   *
   * @return the target
   */
  public AssignmentTargetDetails getTarget() {
    return target;
  }

  /**
   * Gets the status.
   *
   * The role assignment status.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }
}

