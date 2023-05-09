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

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Response object containing the details of a template assignment.
 */
public class TemplateCreateAssignmentResponse extends GenericModel {

  protected String id;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("template_id")
  protected String templateId;
  @SerializedName("template_version")
  protected String templateVersion;
  @SerializedName("target_type")
  protected String targetType;
  protected String target;
  protected String operation;
  protected String status;
  protected String href;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("created_by")
  protected String createdBy;
  @SerializedName("updated_at")
  protected Date updatedAt;
  @SerializedName("updated_by")
  protected String updatedBy;

  protected TemplateCreateAssignmentResponse() { }

  /**
   * Gets the id.
   *
   * The ID of the assignment.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the accountId.
   *
   * The ID of the account that the assignment belongs to.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the templateId.
   *
   * The ID of the template that the assignment is based on.
   *
   * @return the templateId
   */
  public String getTemplateId() {
    return templateId;
  }

  /**
   * Gets the templateVersion.
   *
   * The version of the template that the assignment is based on.
   *
   * @return the templateVersion
   */
  public String getTemplateVersion() {
    return templateVersion;
  }

  /**
   * Gets the targetType.
   *
   * The type of the entity that the assignment applies to.
   *
   * @return the targetType
   */
  public String getTargetType() {
    return targetType;
  }

  /**
   * Gets the target.
   *
   * The ID of the entity that the assignment applies to.
   *
   * @return the target
   */
  public String getTarget() {
    return target;
  }

  /**
   * Gets the operation.
   *
   * The operation that the assignment applies to (e.g. 'create', 'update', 'delete').
   *
   * @return the operation
   */
  public String getOperation() {
    return operation;
  }

  /**
   * Gets the status.
   *
   * The status of the assignment (e.g. 'pending', 'success', 'failure').
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the href.
   *
   * The URL of the assignment resource.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }

  /**
   * Gets the createdAt.
   *
   * The date and time when the assignment was created.
   *
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the createdBy.
   *
   * The user or system that created the assignment.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the updatedAt.
   *
   * The date and time when the assignment was last updated.
   *
   * @return the updatedAt
   */
  public Date getUpdatedAt() {
    return updatedAt;
  }

  /**
   * Gets the updatedBy.
   *
   * The user or system that last updated the assignment.
   *
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }
}

