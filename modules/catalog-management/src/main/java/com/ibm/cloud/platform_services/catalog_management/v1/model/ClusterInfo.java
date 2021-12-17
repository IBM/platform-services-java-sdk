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
 * Cluster information.
 */
public class ClusterInfo extends GenericModel {

  @SerializedName("resource_group_id")
  protected String resourceGroupId;
  @SerializedName("resource_group_name")
  protected String resourceGroupName;
  protected String id;
  protected String name;
  protected String region;

  /**
   * Gets the resourceGroupId.
   *
   * Resource Group ID.
   *
   * @return the resourceGroupId
   */
  public String getResourceGroupId() {
    return resourceGroupId;
  }

  /**
   * Gets the resourceGroupName.
   *
   * Resource Group name.
   *
   * @return the resourceGroupName
   */
  public String getResourceGroupName() {
    return resourceGroupName;
  }

  /**
   * Gets the id.
   *
   * Cluster ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the name.
   *
   * Cluster name.
   *
   * @return the name
   */
  public String getName() {
    return name;
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
}

