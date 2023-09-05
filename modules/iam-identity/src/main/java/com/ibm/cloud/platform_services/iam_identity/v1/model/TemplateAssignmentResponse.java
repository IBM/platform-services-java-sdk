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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Response body format for Template Assignment Record.
 */
public class TemplateAssignmentResponse extends GenericModel {

  protected ResponseContext context;
  protected String id;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("template_id")
  protected String templateId;
  @SerializedName("template_version")
  protected Long templateVersion;
  @SerializedName("target_type")
  protected String targetType;
  protected String target;
  protected String status;
  protected List<TemplateAssignmentResponseResource> resources;
  protected List<EnityHistoryRecord> history;
  protected String href;
  @SerializedName("created_at")
  protected String createdAt;
  @SerializedName("created_by_id")
  protected String createdById;
  @SerializedName("last_modified_at")
  protected String lastModifiedAt;
  @SerializedName("last_modified_by_id")
  protected String lastModifiedById;
  @SerializedName("entity_tag")
  protected String entityTag;

  protected TemplateAssignmentResponse() { }

  /**
   * Gets the context.
   *
   * Context with key properties for problem determination.
   *
   * @return the context
   */
  public ResponseContext getContext() {
    return context;
  }

  /**
   * Gets the id.
   *
   * Assignment record Id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the accountId.
   *
   * Enterprise account Id.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the templateId.
   *
   * Template Id.
   *
   * @return the templateId
   */
  public String getTemplateId() {
    return templateId;
  }

  /**
   * Gets the templateVersion.
   *
   * Template version.
   *
   * @return the templateVersion
   */
  public Long getTemplateVersion() {
    return templateVersion;
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
   * Assignment target.
   *
   * @return the target
   */
  public String getTarget() {
    return target;
  }

  /**
   * Gets the status.
   *
   * Assignment status.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the resources.
   *
   * Status breakdown per target account of IAM resources created or errors encountered in attempting to create those
   * IAM resources. IAM resources are only included in the response providing the assignment is not in progress. IAM
   * resources are also only included when getting a single assignment, and excluded by list APIs.
   *
   * @return the resources
   */
  public List<TemplateAssignmentResponseResource> getResources() {
    return resources;
  }

  /**
   * Gets the history.
   *
   * Assignment history.
   *
   * @return the history
   */
  public List<EnityHistoryRecord> getHistory() {
    return history;
  }

  /**
   * Gets the href.
   *
   * Href.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }

  /**
   * Gets the createdAt.
   *
   * Assignment created at.
   *
   * @return the createdAt
   */
  public String getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the createdById.
   *
   * IAMid of the identity that created the assignment.
   *
   * @return the createdById
   */
  public String getCreatedById() {
    return createdById;
  }

  /**
   * Gets the lastModifiedAt.
   *
   * Assignment modified at.
   *
   * @return the lastModifiedAt
   */
  public String getLastModifiedAt() {
    return lastModifiedAt;
  }

  /**
   * Gets the lastModifiedById.
   *
   * IAMid of the identity that last modified the assignment.
   *
   * @return the lastModifiedById
   */
  public String getLastModifiedById() {
    return lastModifiedById;
  }

  /**
   * Gets the entityTag.
   *
   * Entity tag for this assignment record.
   *
   * @return the entityTag
   */
  public String getEntityTag() {
    return entityTag;
  }
}

