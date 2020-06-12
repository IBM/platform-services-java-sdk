/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.cloud.platform_services.catalog_management.v1.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schematics workspace information.
 */
public class SchematicsWorkspace extends GenericModel {

  protected String id;
  protected String name;
  protected List<String> type;
  protected String description;
  protected List<String> tags;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("created_by")
  protected String createdBy;
  protected String status;
  @SerializedName("workspace_status")
  protected SchematicsWorkspaceWorkspaceStatus workspaceStatus;
  @SerializedName("template_ref")
  protected String templateRef;
  @SerializedName("template_repo")
  protected SchematicsWorkspaceTemplateRepo templateRepo;
  @SerializedName("template_data")
  protected List<Object> templateData;
  @SerializedName("runtime_data")
  protected SchematicsWorkspaceRuntimeData runtimeData;
  @SerializedName("shared_data")
  protected Map<String, Object> sharedData;
  @SerializedName("catalog_ref")
  protected SchematicsWorkspaceCatalogRef catalogRef;

  /**
   * Gets the id.
   *
   * Workspace ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the name.
   *
   * Workspace name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the type.
   *
   * Workspace types.
   *
   * @return the type
   */
  public List<String> getType() {
    return type;
  }

  /**
   * Gets the description.
   *
   * Workspace description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the tags.
   *
   * Workspace tags.
   *
   * @return the tags
   */
  public List<String> getTags() {
    return tags;
  }

  /**
   * Gets the createdAt.
   *
   * Workspace creation date and time.
   *
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the createdBy.
   *
   * Email address of user that created the ID.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the status.
   *
   * Workspace apply status.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the workspaceStatus.
   *
   * Workspace frozen/locked status.
   *
   * @return the workspaceStatus
   */
  public SchematicsWorkspaceWorkspaceStatus getWorkspaceStatus() {
    return workspaceStatus;
  }

  /**
   * Gets the templateRef.
   *
   * Template reference.
   *
   * @return the templateRef
   */
  public String getTemplateRef() {
    return templateRef;
  }

  /**
   * Gets the templateRepo.
   *
   * Template repository.
   *
   * @return the templateRepo
   */
  public SchematicsWorkspaceTemplateRepo getTemplateRepo() {
    return templateRepo;
  }

  /**
   * Gets the templateData.
   *
   * Map of template data.
   *
   * @return the templateData
   */
  public List<Object> getTemplateData() {
    return templateData;
  }

  /**
   * Gets the runtimeData.
   *
   * Data describing runtime.
   *
   * @return the runtimeData
   */
  public SchematicsWorkspaceRuntimeData getRuntimeData() {
    return runtimeData;
  }

  /**
   * Gets the sharedData.
   *
   * Map of shared data.
   *
   * @return the sharedData
   */
  public Map<String, Object> getSharedData() {
    return sharedData;
  }

  /**
   * Gets the catalogRef.
   *
   * Catalog reference.
   *
   * @return the catalogRef
   */
  public SchematicsWorkspaceCatalogRef getCatalogRef() {
    return catalogRef;
  }
}

