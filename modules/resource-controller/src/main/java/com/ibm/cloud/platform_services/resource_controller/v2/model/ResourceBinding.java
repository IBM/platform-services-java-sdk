/*
 * (C) Copyright IBM Corp. 2022.
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
  @SerializedName("target_crn")
  protected String targetCrn;
  protected String crn;
  @SerializedName("region_binding_id")
  protected String regionBindingId;
  @SerializedName("region_binding_crn")
  protected String regionBindingCrn;
  protected String name;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("resource_group_id")
  protected String resourceGroupId;
  protected String state;
  protected Credentials credentials;
  @SerializedName("iam_compatible")
  protected Boolean iamCompatible;
  @SerializedName("resource_id")
  protected String resourceId;
  protected Boolean migrated;
  @SerializedName("resource_alias_url")
  protected String resourceAliasUrl;

  protected ResourceBinding() { }

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
   * The GUID of the binding.
   *
   * @return the guid
   */
  public String getGuid() {
    return guid;
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

  /**
   * Gets the createdBy.
   *
   * The subject who created the binding.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the updatedBy.
   *
   * The subject who updated the binding.
   *
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

  /**
   * Gets the deletedBy.
   *
   * The subject who deleted the binding.
   *
   * @return the deletedBy
   */
  public String getDeletedBy() {
    return deletedBy;
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
   * The CRN of target resource, for example, application, in a specific environment.
   *
   * @return the targetCrn
   */
  public String getTargetCrn() {
    return targetCrn;
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
   * Gets the regionBindingId.
   *
   * The ID of the binding in the target environment. For example, `service_binding_id` in a given IBM Cloud
   * environment.
   *
   * @return the regionBindingId
   */
  public String getRegionBindingId() {
    return regionBindingId;
  }

  /**
   * Gets the regionBindingCrn.
   *
   * The CRN of the binding in the target environment.
   *
   * @return the regionBindingCrn
   */
  public String getRegionBindingCrn() {
    return regionBindingCrn;
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
   * The ID of the resource group.
   *
   * @return the resourceGroupId
   */
  public String getResourceGroupId() {
    return resourceGroupId;
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
   * The credentials for the binding. Additional key-value pairs are passed through from the resource brokers. After a
   * credential is created for a service, it can be viewed at any time for users that need the API key value. However,
   * all users must have the correct level of access to see the details of a credential that includes the API key value.
   * For additional details, see [viewing a
   * credential](https://cloud.ibm.com/docs/account?topic=account-service_credentials&amp;interface=ui#viewing-credentials-ui)
   * or the service’s documentation.
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

