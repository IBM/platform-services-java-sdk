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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A resource binding.
 */
public class ResourceBinding extends GenericModel {

  protected String id;
  protected String guid;
  protected String crn;
  protected String url;
  protected String name;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("resource_group_id")
  protected String resourceGroupId;
  @SerializedName("source_crn")
  protected String sourceCrn;
  @SerializedName("target_crn")
  protected String targetCrn;
  @SerializedName("region_binding_id")
  protected String regionBindingId;
  protected String state;
  protected Credentials credentials;
  @SerializedName("iam_compatible")
  protected Boolean iamCompatible;
  @SerializedName("resource_alias_url")
  protected String resourceAliasUrl;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("updated_at")
  protected Date updatedAt;
  @SerializedName("deleted_at")
  protected Date deletedAt;

  /**
   * Gets the id.
   *
   * The ID associated with the binding.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the guid.
   *
   * When you create a new binding, a globally unique identifier (GUID) is assigned. This GUID is a unique internal
   * identifier managed by the resource controller that corresponds to the binding.
   *
   * @return the guid
   */
  public String getGuid() {
    return guid;
  }

  /**
   * Gets the crn.
   *
   * The full Cloud Resource Name (CRN) associated with the binding. For more information about this format, see [Cloud
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
   * When you provision a new binding, a relative URL path is created identifying the location of the binding.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the name.
   *
   * The human-readable name of the binding.
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
   * Gets the sourceCrn.
   *
   * The CRN of resource alias associated to the binding.
   *
   * @return the sourceCrn
   */
  public String getSourceCrn() {
    return sourceCrn;
  }

  /**
   * Gets the targetCrn.
   *
   * The CRN of target resource, e.g. application, in a specific environment.
   *
   * @return the targetCrn
   */
  public String getTargetCrn() {
    return targetCrn;
  }

  /**
   * Gets the regionBindingId.
   *
   * The short ID of the binding in specific targeted environment, e.g. `service_binding_id` in a given IBM Cloud
   * environment.
   *
   * @return the regionBindingId
   */
  public String getRegionBindingId() {
    return regionBindingId;
  }

  /**
   * Gets the state.
   *
   * The state of the binding.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Gets the credentials.
   *
   * The credentials for the binding. Additional key-value pairs are passed through from the resource brokers.  For
   * additional details, see the service’s documentation.
   *
   * @return the credentials
   */
  public Credentials getCredentials() {
    return credentials;
  }

  /**
   * Gets the iamCompatible.
   *
   * Specifies whether the binding’s credentials support IAM.
   *
   * @return the iamCompatible
   */
  public Boolean isIamCompatible() {
    return iamCompatible;
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

  /**
   * Gets the createdAt.
   *
   * The date when the binding was created.
   *
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the updatedAt.
   *
   * The date when the binding was last updated.
   *
   * @return the updatedAt
   */
  public Date getUpdatedAt() {
    return updatedAt;
  }

  /**
   * Gets the deletedAt.
   *
   * The date when the binding was deleted.
   *
   * @return the deletedAt
   */
  public Date getDeletedAt() {
    return deletedAt;
  }
}

