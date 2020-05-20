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
 * A resource group.
 */
public class ResourceGroup extends GenericModel {

  protected String id;
  protected String crn;
  @SerializedName("account_id")
  protected String accountId;
  protected String name;
  protected String state;
  @SerializedName("default")
  protected Boolean xDefault;
  @SerializedName("quota_id")
  protected String quotaId;
  @SerializedName("quota_url")
  protected String quotaUrl;
  @SerializedName("payment_methods_url")
  protected String paymentMethodsUrl;
  @SerializedName("resource_linkages")
  protected List<Object> resourceLinkages;
  @SerializedName("teams_url")
  protected String teamsUrl;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("updated_at")
  protected Date updatedAt;

  /**
   * Gets the id.
   *
   * An alpha-numeric value identifying the resource group.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the crn.
   *
   * The full CRN (cloud resource name) associated with the resource group. For more on this format, see [Cloud Resource
   * Names](https://cloud.ibm.com/docs/resources?topic=resources-crn).
   *
   * @return the crn
   */
  public String getCrn() {
    return crn;
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
   * Gets the name.
   *
   * The human-readable name of the resource group.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the state.
   *
   * The state of the resource group.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Gets the xDefault.
   *
   * Identify if this resource group is default of the account or not.
   *
   * @return the xDefault
   */
  public Boolean isXDefault() {
    return xDefault;
  }

  /**
   * Gets the quotaId.
   *
   * An alpha-numeric value identifying the quota ID associated with the resource group.
   *
   * @return the quotaId
   */
  public String getQuotaId() {
    return quotaId;
  }

  /**
   * Gets the quotaUrl.
   *
   * The URL to access the quota details that associated with the resource group.
   *
   * @return the quotaUrl
   */
  public String getQuotaUrl() {
    return quotaUrl;
  }

  /**
   * Gets the paymentMethodsUrl.
   *
   * The URL to access the payment methods details that associated with the resource group.
   *
   * @return the paymentMethodsUrl
   */
  public String getPaymentMethodsUrl() {
    return paymentMethodsUrl;
  }

  /**
   * Gets the resourceLinkages.
   *
   * An array of the resources that linked to the resource group.
   *
   * @return the resourceLinkages
   */
  public List<Object> getResourceLinkages() {
    return resourceLinkages;
  }

  /**
   * Gets the teamsUrl.
   *
   * The URL to access the team details that associated with the resource group.
   *
   * @return the teamsUrl
   */
  public String getTeamsUrl() {
    return teamsUrl;
  }

  /**
   * Gets the createdAt.
   *
   * The date when the resource group was initially created.
   *
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the updatedAt.
   *
   * The date when the resource group was last updated.
   *
   * @return the updatedAt
   */
  public Date getUpdatedAt() {
    return updatedAt;
  }
}

