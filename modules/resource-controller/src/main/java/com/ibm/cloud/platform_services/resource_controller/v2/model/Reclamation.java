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
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A reclamation.
 */
public class Reclamation extends GenericModel {

  protected String id;
  @SerializedName("entity_id")
  protected String entityId;
  @SerializedName("entity_type_id")
  protected String entityTypeId;
  @SerializedName("entity_crn")
  protected String entityCrn;
  @SerializedName("resource_instance_id")
  protected Object resourceInstanceId;
  @SerializedName("resource_group_id")
  protected String resourceGroupId;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("policy_id")
  protected String policyId;
  protected String state;
  @SerializedName("target_time")
  protected String targetTime;
  @SerializedName("custom_properties")
  protected Map<String, Object> customProperties;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("created_by")
  protected String createdBy;
  @SerializedName("updated_at")
  protected Date updatedAt;
  @SerializedName("updated_by")
  protected String updatedBy;

  /**
   * Gets the id.
   *
   * The ID associated with the reclamation.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the entityId.
   *
   * The short ID of the entity for the reclamation.
   *
   * @return the entityId
   */
  public String getEntityId() {
    return entityId;
  }

  /**
   * Gets the entityTypeId.
   *
   * The short ID of the entity type for the reclamation.
   *
   * @return the entityTypeId
   */
  public String getEntityTypeId() {
    return entityTypeId;
  }

  /**
   * Gets the entityCrn.
   *
   * The full Cloud Resource Name (CRN) associated with the binding. For more information about this format, see [Cloud
   * Resource Names](https://cloud.ibm.com/docs/overview?topic=overview-crn).
   *
   * @return the entityCrn
   */
  public String getEntityCrn() {
    return entityCrn;
  }

  /**
   * Gets the resourceInstanceId.
   *
   * The short ID of the resource instance.
   *
   * @return the resourceInstanceId
   */
  public Object getResourceInstanceId() {
    return resourceInstanceId;
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
   * Gets the policyId.
   *
   * The short ID of policy for the reclamation.
   *
   * @return the policyId
   */
  public String getPolicyId() {
    return policyId;
  }

  /**
   * Gets the state.
   *
   * The state of the reclamation.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Gets the targetTime.
   *
   * The target time that the reclamation retention period end.
   *
   * @return the targetTime
   */
  public String getTargetTime() {
    return targetTime;
  }

  /**
   * Gets the customProperties.
   *
   * The custom properties of the reclamation.
   *
   * @return the customProperties
   */
  public Map<String, Object> getCustomProperties() {
    return customProperties;
  }

  /**
   * Gets the createdAt.
   *
   * The date when the reclamation was created.
   *
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the createdBy.
   *
   * The subject who created the reclamation.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the updatedAt.
   *
   * The date when the reclamation was last updated.
   *
   * @return the updatedAt
   */
  public Date getUpdatedAt() {
    return updatedAt;
  }

  /**
   * Gets the updatedBy.
   *
   * The subject who updated the reclamation.
   *
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }
}

