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
package com.ibm.cloud.platform_services.resource_manager.v2.model;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A returned quota definition.
 */
public class QuotaDefinition extends GenericModel {

  protected String id;
  protected String name;
  protected String type;
  @SerializedName("number_of_apps")
  protected Double numberOfApps;
  @SerializedName("number_of_service_instances")
  protected Double numberOfServiceInstances;
  @SerializedName("default_number_of_instances_per_lite_plan")
  protected Double defaultNumberOfInstancesPerLitePlan;
  @SerializedName("instances_per_app")
  protected Double instancesPerApp;
  @SerializedName("instance_memory")
  protected String instanceMemory;
  @SerializedName("total_app_memory")
  protected String totalAppMemory;
  @SerializedName("vsi_limit")
  protected Double vsiLimit;
  @SerializedName("resource_quotas")
  protected List<ResourceQuota> resourceQuotas;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("updated_at")
  protected Date updatedAt;

  /**
   * Gets the id.
   *
   * An alpha-numeric value identifying the quota.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the name.
   *
   * The human-readable name of the quota.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the type.
   *
   * The type of the quota.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the numberOfApps.
   *
   * The total app limit.
   *
   * @return the numberOfApps
   */
  public Double getNumberOfApps() {
    return numberOfApps;
  }

  /**
   * Gets the numberOfServiceInstances.
   *
   * The total service instances limit per app.
   *
   * @return the numberOfServiceInstances
   */
  public Double getNumberOfServiceInstances() {
    return numberOfServiceInstances;
  }

  /**
   * Gets the defaultNumberOfInstancesPerLitePlan.
   *
   * Default number of instances per lite plan.
   *
   * @return the defaultNumberOfInstancesPerLitePlan
   */
  public Double getDefaultNumberOfInstancesPerLitePlan() {
    return defaultNumberOfInstancesPerLitePlan;
  }

  /**
   * Gets the instancesPerApp.
   *
   * The total instances limit per app.
   *
   * @return the instancesPerApp
   */
  public Double getInstancesPerApp() {
    return instancesPerApp;
  }

  /**
   * Gets the instanceMemory.
   *
   * The total memory of app instance.
   *
   * @return the instanceMemory
   */
  public String getInstanceMemory() {
    return instanceMemory;
  }

  /**
   * Gets the totalAppMemory.
   *
   * The total app memory capacity.
   *
   * @return the totalAppMemory
   */
  public String getTotalAppMemory() {
    return totalAppMemory;
  }

  /**
   * Gets the vsiLimit.
   *
   * The VSI limit.
   *
   * @return the vsiLimit
   */
  public Double getVsiLimit() {
    return vsiLimit;
  }

  /**
   * Gets the resourceQuotas.
   *
   * The resource quotas associated with a quota definition.
   *
   * @return the resourceQuotas
   */
  public List<ResourceQuota> getResourceQuotas() {
    return resourceQuotas;
  }

  /**
   * Gets the createdAt.
   *
   * The date when the quota was initially created.
   *
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the updatedAt.
   *
   * The date when the quota was last updated.
   *
   * @return the updatedAt
   */
  public Date getUpdatedAt() {
    return updatedAt;
  }
}

