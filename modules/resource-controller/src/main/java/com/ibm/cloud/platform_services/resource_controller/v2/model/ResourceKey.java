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
 * A resource key.
 */
public class ResourceKey extends GenericModel {

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
  @SerializedName("source_crn")
  protected String sourceCrn;
  protected String name;
  protected String crn;
  protected String state;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("resource_group_id")
  protected String resourceGroupId;
  @SerializedName("resource_id")
  protected String resourceId;
  protected Credentials credentials;
  @SerializedName("iam_compatible")
  protected Boolean iamCompatible;
  protected Boolean migrated;
  @SerializedName("resource_instance_url")
  protected String resourceInstanceUrl;
  @SerializedName("resource_alias_url")
  protected String resourceAliasUrl;

  /**
   * Gets the id.
   *
   * The ID associated with the key.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the guid.
   *
   * When you create a new key, a globally unique identifier (GUID) is assigned. This GUID is a unique internal
   * identifier managed by the resource controller that corresponds to the key.
   *
   * @return the guid
   */
  public String getGuid() {
    return guid;
  }

  /**
   * Gets the url.
   *
   * When you created a new key, a relative URL path is created identifying the location of the key.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the createdAt.
   *
   * The date when the key was created.
   *
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the updatedAt.
   *
   * The date when the key was last updated.
   *
   * @return the updatedAt
   */
  public Date getUpdatedAt() {
    return updatedAt;
  }

  /**
   * Gets the deletedAt.
   *
   * The date when the key was deleted.
   *
   * @return the deletedAt
   */
  public Date getDeletedAt() {
    return deletedAt;
  }

  /**
   * Gets the createdBy.
   *
   * The subject who created the key.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the updatedBy.
   *
   * The subject who updated the key.
   *
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

  /**
   * Gets the deletedBy.
   *
   * The subject who deleted the key.
   *
   * @return the deletedBy
   */
  public String getDeletedBy() {
    return deletedBy;
  }

  /**
   * Gets the sourceCrn.
   *
   * The CRN of resource instance or alias associated to the key.
   *
   * @return the sourceCrn
   */
  public String getSourceCrn() {
    return sourceCrn;
  }

  /**
   * Gets the name.
   *
   * The human-readable name of the key.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the crn.
   *
   * The full Cloud Resource Name (CRN) associated with the key. For more information about this format, see [Cloud
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
   * The state of the key.
   *
   * @return the state
   */
  public String getState() {
    return state;
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
   * The ID of the resource group.
   *
   * @return the resourceGroupId
   */
  public String getResourceGroupId() {
    return resourceGroupId;
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
   * Gets the credentials.
   *
   * The credentials for the key. Additional key-value pairs are passed through from the resource brokers.  Refer to
   * service’s documentation for additional details.
   *
   * @return the credentials
   */
  public Credentials getCredentials() {
    return credentials;
  }

  /**
   * Gets the iamCompatible.
   *
   * Specifies whether the key’s credentials support IAM.
   *
   * @return the iamCompatible
   */
  public Boolean isIamCompatible() {
    return iamCompatible;
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
   * The relative path to the resource.
   *
   * @return the resourceInstanceUrl
   */
  public String getResourceInstanceUrl() {
    return resourceInstanceUrl;
  }

  /**
   * Gets the resourceAliasUrl.
   *
   * The relative path to the resource alias that this binding is associated with.
   *
   * @return the resourceAliasUrl
   */
  public String getResourceAliasUrl() {
    return resourceAliasUrl;
  }
}

