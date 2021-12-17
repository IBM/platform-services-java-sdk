/*
 * (C) Copyright IBM Corp. 2021.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Installation status metadata.
 */
public class InstallStatusMetadata extends GenericModel {

  @SerializedName("cluster_id")
  protected String clusterId;
  protected String region;
  protected String namespace;
  @SerializedName("workspace_id")
  protected String workspaceId;
  @SerializedName("workspace_name")
  protected String workspaceName;

  /**
   * Gets the clusterId.
   *
   * Cluster ID.
   *
   * @return the clusterId
   */
  public String getClusterId() {
    return clusterId;
  }

  /**
   * Gets the region.
   *
   * Cluster region.
   *
   * @return the region
   */
  public String getRegion() {
    return region;
  }

  /**
   * Gets the namespace.
   *
   * Cluster namespace.
   *
   * @return the namespace
   */
  public String getNamespace() {
    return namespace;
  }

  /**
   * Gets the workspaceId.
   *
   * Workspace ID.
   *
   * @return the workspaceId
   */
  public String getWorkspaceId() {
    return workspaceId;
  }

  /**
   * Gets the workspaceName.
   *
   * Workspace name.
   *
   * @return the workspaceName
   */
  public String getWorkspaceName() {
    return workspaceName;
  }
}

