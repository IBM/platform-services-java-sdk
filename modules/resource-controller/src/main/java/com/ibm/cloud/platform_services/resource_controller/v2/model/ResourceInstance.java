/*
 * (C) Copyright IBM Corp. 2024.
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

  /**
   * The current state of the instance. For example, if the instance is deleted, it will return removed.
   */
  public interface State {
    /** active. */
    String ACTIVE = "active";
    /** inactive. */
    String INACTIVE = "inactive";
    /** removed. */
    String REMOVED = "removed";
    /** pending_removal. */
    String PENDING_REMOVAL = "pending_removal";
    /** pending_reclamation. */
    String PENDING_RECLAMATION = "pending_reclamation";
    /** failed. */
    String FAILED = "failed";
    /** provisioning. */
    String PROVISIONING = "provisioning";
    /** pre_provisioning. */
    String PRE_PROVISIONING = "pre_provisioning";
  }

  protected String id;
  protected String guid;
  protected String url;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("updated_at")
  protected Date updatedAt;
  @SerializedName("deleted_at")
  protected Date deletedAt;
  @SerializedName("created_by")
  protected String createdBy;
  @SerializedName("updated_by")
  protected String updatedBy;
  @SerializedName("deleted_by")
  protected String deletedBy;
  @SerializedName("scheduled_reclaim_at")
  protected Date scheduledReclaimAt;
  @SerializedName("restored_at")
  protected Date restoredAt;
  @SerializedName("restored_by")
  protected String restoredBy;
  @SerializedName("scheduled_reclaim_by")
  protected String scheduledReclaimBy;
  protected String name;
  @SerializedName("region_id")
  protected String regionId;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("reseller_channel_id")
  protected String resellerChannelId;
  @SerializedName("resource_plan_id")
  protected String resourcePlanId;
  @SerializedName("resource_group_id")
  protected String resourceGroupId;
  @SerializedName("resource_group_crn")
  protected String resourceGroupCrn;
  @SerializedName("target_crn")
  protected String targetCrn;
  @SerializedName("onetime_credentials")
  protected Boolean onetimeCredentials;
  protected Map<String, Object> parameters;
  @SerializedName("allow_cleanup")
  protected Boolean allowCleanup;
  protected String crn;
  protected String state;
  protected String type;
  @SerializedName("sub_type")
  protected String subType;
  @SerializedName("resource_id")
  protected String resourceId;
  @SerializedName("dashboard_url")
  protected String dashboardUrl;
  @SerializedName("last_operation")
  protected ResourceInstanceLastOperation lastOperation;
  @SerializedName("resource_aliases_url")
  protected String resourceAliasesUrl;
  @SerializedName("resource_bindings_url")
  protected String resourceBindingsUrl;
  @SerializedName("resource_keys_url")
  protected String resourceKeysUrl;
  @SerializedName("plan_history")
  protected List<PlanHistoryItem> planHistory;
  protected Boolean migrated;
  protected Map<String, Object> extensions;
  @SerializedName("controlled_by")
  protected String controlledBy;
  protected Boolean locked;

  protected ResourceInstance() { }

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
   * The GUID of the instance.
   *
   * @return the guid
   */
  public String getGuid() {
    return guid;
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

  /**
   * Gets the createdBy.
   *
   * The subject who created the instance.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the updatedBy.
   *
   * The subject who updated the instance.
   *
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

  /**
   * Gets the deletedBy.
   *
   * The subject who deleted the instance.
   *
   * @return the deletedBy
   */
  public String getDeletedBy() {
    return deletedBy;
  }

  /**
   * Gets the scheduledReclaimAt.
   *
   * The date when the instance was scheduled for reclamation.
   *
   * @return the scheduledReclaimAt
   */
  public Date getScheduledReclaimAt() {
    return scheduledReclaimAt;
  }

  /**
   * Gets the restoredAt.
   *
   * The date when the instance under reclamation was restored.
   *
   * @return the restoredAt
   */
  public Date getRestoredAt() {
    return restoredAt;
  }

  /**
   * Gets the restoredBy.
   *
   * The subject who restored the instance back from reclamation.
   *
   * @return the restoredBy
   */
  public String getRestoredBy() {
    return restoredBy;
  }

  /**
   * Gets the scheduledReclaimBy.
   *
   * The subject who initiated the instance reclamation.
   *
   * @return the scheduledReclaimBy
   */
  public String getScheduledReclaimBy() {
    return scheduledReclaimBy;
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
   * Gets the regionId.
   *
   * The deployment location where the instance was provisioned.
   *
   * @return the regionId
   */
  public String getRegionId() {
    return regionId;
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
   * Gets the resellerChannelId.
   *
   * The unique ID of the reseller channel where the instance was provisioned from.
   *
   * @return the resellerChannelId
   */
  public String getResellerChannelId() {
    return resellerChannelId;
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
   * Gets the resourceGroupId.
   *
   * The ID of the resource group.
   *
   * @return the resourceGroupId
   */
  public String getResourceGroupId() {
    return resourceGroupId;
  }

  /**
   * Gets the resourceGroupCrn.
   *
   * The CRN of the resource group.
   *
   * @return the resourceGroupCrn
   */
  public String getResourceGroupCrn() {
    return resourceGroupCrn;
  }

  /**
   * Gets the targetCrn.
   *
   * The deployment CRN as defined in the global catalog. The Cloud Resource Name (CRN) of the deployment location where
   * the instance is provisioned.
   *
   * @return the targetCrn
   */
  public String getTargetCrn() {
    return targetCrn;
  }

  /**
   * Gets the onetimeCredentials.
   *
   * Whether newly created resource key credentials can be retrieved by using get resource key or get a list of all of
   * the resource keys requests.
   *
   * @return the onetimeCredentials
   */
  public Boolean isOnetimeCredentials() {
    return onetimeCredentials;
  }

  /**
   * Gets the parameters.
   *
   * The current configuration parameters of the instance.
   *
   * @return the parameters
   */
  public Map<String, Object> getParameters() {
    return parameters;
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
   * The type of the instance, for example, `service_instance`.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the subType.
   *
   * The sub-type of instance, for example, `cfaas`.
   *
   * @return the subType
   */
  public String getSubType() {
    return subType;
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
   * Gets the lastOperation.
   *
   * The status of the last operation requested on the instance.
   *
   * @return the lastOperation
   */
  public ResourceInstanceLastOperation getLastOperation() {
    return lastOperation;
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
   * Gets the migrated.
   *
   * A boolean that dictates if the resource instance was migrated from a previous CF instance.
   *
   * @return the migrated
   */
  public Boolean isMigrated() {
    return migrated;
  }

  /**
   * Gets the extensions.
   *
   * Additional instance properties, contributed by the service and/or platform, are represented as key-value pairs.
   *
   * @return the extensions
   */
  public Map<String, Object> getExtensions() {
    return extensions;
  }

  /**
   * Gets the controlledBy.
   *
   * The CRN of the resource that has control of the instance.
   *
   * @return the controlledBy
   */
  public String getControlledBy() {
    return controlledBy;
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
}

