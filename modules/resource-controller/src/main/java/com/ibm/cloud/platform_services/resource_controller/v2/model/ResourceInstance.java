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
package com.ibm.cloud.platform_services.resource_controller.v2.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A resource instance.
 */
public class ResourceInstance extends GenericModel {

  protected String id;
  protected String guid;
  protected String crn;
  protected String url;
  protected String name;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("resource_group_id")
  protected String resourceGroupId;
  @SerializedName("resource_group_crn")
  protected String resourceGroupCrn;
  @SerializedName("resource_id")
  protected String resourceId;
  @SerializedName("resource_plan_id")
  protected String resourcePlanId;
  @SerializedName("target_crn")
  protected String targetCrn;
  protected String state;
  protected String type;
  @SerializedName("sub_type")
  protected String subType;
  @SerializedName("allow_cleanup")
  protected Boolean allowCleanup;
  protected Boolean locked;
  @SerializedName("last_operation")
  protected Map<String, Object> lastOperation;
  @SerializedName("dashboard_url")
  protected String dashboardUrl;
  @SerializedName("plan_history")
  protected List<PlanHistoryItem> planHistory;
  @SerializedName("resource_aliases_url")
  protected String resourceAliasesUrl;
  @SerializedName("resource_bindings_url")
  protected String resourceBindingsUrl;
  @SerializedName("resource_keys_url")
  protected String resourceKeysUrl;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("updated_at")
  protected Date updatedAt;
  @SerializedName("deleted_at")
  protected Date deletedAt;

  /**
   * Gets the id.
   *
   * The ID associated with the instance.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the guid.
   *
   * When you create a new resource, a globally unique identifier (GUID) is assigned. This GUID is a unique internal
   * identifier managed by the resource controller that corresponds to the instance.
   *
   * @return the guid
   */
  public String getGuid() {
    return guid;
  }

  /**
   * Gets the crn.
   *
   * The full Cloud Resource Name (CRN) associated with the instance. For more information about this format, see [Cloud
   * Resource Names](https://cloud.ibm.com/docs/overview?topic=overview-crn).
   *
   * @return the crn
   */
  public String getCrn() {
    return crn;
  }

  /**
   * Gets the url.
   *
   * When you provision a new resource, a relative URL path is created identifying the location of the instance.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the name.
   *
   * The human-readable name of the instance.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the accountId.
   *
   * An alpha-numeric value identifying the account ID.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the resourceGroupId.
   *
   * The short ID of the resource group.
   *
   * @return the resourceGroupId
   */
  public String getResourceGroupId() {
    return resourceGroupId;
  }

  /**
   * Gets the resourceGroupCrn.
   *
   * The long ID (full CRN) of the resource group.
   *
   * @return the resourceGroupCrn
   */
  public String getResourceGroupCrn() {
    return resourceGroupCrn;
  }

  /**
   * Gets the resourceId.
   *
   * The unique ID of the offering. This value is provided by and stored in the global catalog.
   *
   * @return the resourceId
   */
  public String getResourceId() {
    return resourceId;
  }

  /**
   * Gets the resourcePlanId.
   *
   * The unique ID of the plan associated with the offering. This value is provided by and stored in the global catalog.
   *
   * @return the resourcePlanId
   */
  public String getResourcePlanId() {
    return resourcePlanId;
  }

  /**
   * Gets the targetCrn.
   *
   * The full deployment CRN as defined in the global catalog. The Cloud Resource Name (CRN) of the deployment location
   * where the instance is provisioned.
   *
   * @return the targetCrn
   */
  public String getTargetCrn() {
    return targetCrn;
  }

  /**
   * Gets the state.
   *
   * The current state of the instance. For example, if the instance is deleted, it will return removed.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Gets the type.
   *
   * The type of the instance, e.g. `service_instance`.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the subType.
   *
   * The sub-type of instance, e.g. `cfaas`.
   *
   * @return the subType
   */
  public String getSubType() {
    return subType;
  }

  /**
   * Gets the allowCleanup.
   *
   * A boolean that dictates if the resource instance should be deleted (cleaned up) during the processing of a region
   * instance delete call.
   *
   * @return the allowCleanup
   */
  public Boolean isAllowCleanup() {
    return allowCleanup;
  }

  /**
   * Gets the locked.
   *
   * A boolean that dictates if the resource instance is locked or not.
   *
   * @return the locked
   */
  public Boolean isLocked() {
    return locked;
  }

  /**
   * Gets the lastOperation.
   *
   * The status of the last operation requested on the instance.
   *
   * @return the lastOperation
   */
  public Map<String, Object> getLastOperation() {
    return lastOperation;
  }

  /**
   * Gets the dashboardUrl.
   *
   * The resource-broker-provided URL to access administrative features of the instance.
   *
   * @return the dashboardUrl
   */
  public String getDashboardUrl() {
    return dashboardUrl;
  }

  /**
   * Gets the planHistory.
   *
   * The plan history of the instance.
   *
   * @return the planHistory
   */
  public List<PlanHistoryItem> getPlanHistory() {
    return planHistory;
  }

  /**
   * Gets the resourceAliasesUrl.
   *
   * The relative path to the resource aliases for the instance.
   *
   * @return the resourceAliasesUrl
   */
  public String getResourceAliasesUrl() {
    return resourceAliasesUrl;
  }

  /**
   * Gets the resourceBindingsUrl.
   *
   * The relative path to the resource bindings for the instance.
   *
   * @return the resourceBindingsUrl
   */
  public String getResourceBindingsUrl() {
    return resourceBindingsUrl;
  }

  /**
   * Gets the resourceKeysUrl.
   *
   * The relative path to the resource keys for the instance.
   *
   * @return the resourceKeysUrl
   */
  public String getResourceKeysUrl() {
    return resourceKeysUrl;
  }

  /**
   * Gets the createdAt.
   *
   * The date when the instance was created.
   *
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the updatedAt.
   *
   * The date when the instance was last updated.
   *
   * @return the updatedAt
   */
  public Date getUpdatedAt() {
    return updatedAt;
  }

  /**
   * Gets the deletedAt.
   *
   * The date when the instance was deleted.
   *
   * @return the deletedAt
   */
  public Date getDeletedAt() {
    return deletedAt;
  }
}

