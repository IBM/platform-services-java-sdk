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
  protected String crn;
  protected String url;
  protected String name;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("resource_group_id")
  protected String resourceGroupId;
  @SerializedName("resource_group_crn")
  protected String resourceGroupCrn;
  @SerializedName("target_crn")
  protected String targetCrn;
  protected String state;
  @SerializedName("resource_instance_id")
  protected String resourceInstanceId;
  @SerializedName("region_instance_id")
  protected String regionInstanceId;
  @SerializedName("resource_instance_url")
  protected String resourceInstanceUrl;
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
  @SerializedName("created_by")
  protected String createdBy;
  @SerializedName("updated_by")
  protected String updatedBy;
  @SerializedName("deleted_by")
  protected String deletedBy;

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
   * Gets the crn.
   *
   * The full Cloud Resource Name (CRN) associated with the alias. For more information about this format, see [Cloud
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
   * When you created a new alias, a relative URL path is created identifying the location of the alias.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
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
   * Gets the resourceInstanceId.
   *
   * The short ID of the resource instance that is being aliased.
   *
   * @return the resourceInstanceId
   */
  public String getResourceInstanceId() {
    return resourceInstanceId;
  }

  /**
   * Gets the regionInstanceId.
   *
   * The short ID of the instance in the specific target environment, e.g. `service_instance_id` in a given IBM Cloud
   * environment.
   *
   * @return the regionInstanceId
   */
  public String getRegionInstanceId() {
    return regionInstanceId;
  }

  /**
   * Gets the resourceInstanceUrl.
   *
   * The relative path to the instance.
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
}

