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
package com.ibm.cloud.platform_services.resource_controller.v2.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A resource alias.
 */
public class ResourceAlias extends GenericModel {

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
  protected String name;
  @SerializedName("resource_instance_id")
  protected String resourceInstanceId;
  @SerializedName("target_crn")
  protected String targetCrn;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("resource_id")
  protected String resourceId;
  @SerializedName("resource_group_id")
  protected String resourceGroupId;
  protected String crn;
  @SerializedName("region_instance_id")
  protected String regionInstanceId;
  @SerializedName("region_instance_crn")
  protected String regionInstanceCrn;
  protected String state;
  protected Boolean migrated;
  @SerializedName("resource_instance_url")
  protected String resourceInstanceUrl;
  @SerializedName("resource_bindings_url")
  protected String resourceBindingsUrl;
  @SerializedName("resource_keys_url")
  protected String resourceKeysUrl;

  /**
   * Gets the id.
   *
   * The ID associated with the alias.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the guid.
   *
   * When you create a new alias, a globally unique identifier (GUID) is assigned. This GUID is a unique internal
   * indentifier managed by the resource controller that corresponds to the alias.
   *
   * @return the guid
   */
  public String getGuid() {
    return guid;
  }

  /**
   * Gets the url.
   *
   * When you created a new alias, a relative URL path is created identifying the location of the alias.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the createdAt.
   *
   * The date when the alias was created.
   *
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the updatedAt.
   *
   * The date when the alias was last updated.
   *
   * @return the updatedAt
   */
  public Date getUpdatedAt() {
    return updatedAt;
  }

  /**
   * Gets the deletedAt.
   *
   * The date when the alias was deleted.
   *
   * @return the deletedAt
   */
  public Date getDeletedAt() {
    return deletedAt;
  }

  /**
   * Gets the createdBy.
   *
   * The subject who created the alias.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the updatedBy.
   *
   * The subject who updated the alias.
   *
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

  /**
   * Gets the deletedBy.
   *
   * The subject who deleted the alias.
   *
   * @return the deletedBy
   */
  public String getDeletedBy() {
    return deletedBy;
  }

  /**
   * Gets the name.
   *
   * The human-readable name of the alias.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the resourceInstanceId.
   *
   * The ID of the resource instance that is being aliased.
   *
   * @return the resourceInstanceId
   */
  public String getResourceInstanceId() {
    return resourceInstanceId;
  }

  /**
   * Gets the targetCrn.
   *
   * The CRN of the target namespace in the specific environment.
   *
   * @return the targetCrn
   */
  public String getTargetCrn() {
    return targetCrn;
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
   * Gets the crn.
   *
   * The CRN of the alias. For more information about this format, see [Cloud Resource
   * Names](https://cloud.ibm.com/docs/overview?topic=overview-crn).
   *
   * @return the crn
   */
  public String getCrn() {
    return crn;
  }

  /**
   * Gets the regionInstanceId.
   *
   * The ID of the instance in the specific target environment, for example, `service_instance_id` in a given IBM Cloud
   * environment.
   *
   * @return the regionInstanceId
   */
  public String getRegionInstanceId() {
    return regionInstanceId;
  }

  /**
   * Gets the regionInstanceCrn.
   *
   * The CRN of the instance in the specific target environment.
   *
   * @return the regionInstanceCrn
   */
  public String getRegionInstanceCrn() {
    return regionInstanceCrn;
  }

  /**
   * Gets the state.
   *
   * The state of the alias.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Gets the migrated.
   *
   * A boolean that dictates if the alias was migrated from a previous CF instance.
   *
   * @return the migrated
   */
  public Boolean isMigrated() {
    return migrated;
  }

  /**
   * Gets the resourceInstanceUrl.
   *
   * The relative path to the resource instance.
   *
   * @return the resourceInstanceUrl
   */
  public String getResourceInstanceUrl() {
    return resourceInstanceUrl;
  }

  /**
   * Gets the resourceBindingsUrl.
   *
   * The relative path to the resource bindings for the alias.
   *
   * @return the resourceBindingsUrl
   */
  public String getResourceBindingsUrl() {
    return resourceBindingsUrl;
  }

  /**
   * Gets the resourceKeysUrl.
   *
   * The relative path to the resource keys for the alias.
   *
   * @return the resourceKeysUrl
   */
  public String getResourceKeysUrl() {
    return resourceKeysUrl;
  }
}

