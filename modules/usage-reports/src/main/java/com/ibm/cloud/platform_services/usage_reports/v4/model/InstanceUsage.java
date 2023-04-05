/*
 * (C) Copyright IBM Corp. 2023.
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
package com.ibm.cloud.platform_services.usage_reports.v4.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The aggregated usage and charges for an instance.
 */
public class InstanceUsage extends GenericModel {

  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("resource_instance_id")
  protected String resourceInstanceId;
  @SerializedName("resource_instance_name")
  protected String resourceInstanceName;
  @SerializedName("resource_id")
  protected String resourceId;
  @SerializedName("resource_name")
  protected String resourceName;
  @SerializedName("resource_group_id")
  protected String resourceGroupId;
  @SerializedName("resource_group_name")
  protected String resourceGroupName;
  @SerializedName("organization_id")
  protected String organizationId;
  @SerializedName("organization_name")
  protected String organizationName;
  @SerializedName("space_id")
  protected String spaceId;
  @SerializedName("space_name")
  protected String spaceName;
  @SerializedName("consumer_id")
  protected String consumerId;
  protected String region;
  @SerializedName("pricing_region")
  protected String pricingRegion;
  @SerializedName("pricing_country")
  protected String pricingCountry;
  @SerializedName("currency_code")
  protected String currencyCode;
  protected Boolean billable;
  @SerializedName("plan_id")
  protected String planId;
  @SerializedName("plan_name")
  protected String planName;
  protected String month;
  protected List<Metric> usage;
  protected Boolean pending;
  @SerializedName("currency_rate")
  protected Double currencyRate;

  protected InstanceUsage() { }

  /**
   * Gets the accountId.
   *
   * The ID of the account.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the resourceInstanceId.
   *
   * The ID of the resource instance.
   *
   * @return the resourceInstanceId
   */
  public String getResourceInstanceId() {
    return resourceInstanceId;
  }

  /**
   * Gets the resourceInstanceName.
   *
   * The name of the resource instance.
   *
   * @return the resourceInstanceName
   */
  public String getResourceInstanceName() {
    return resourceInstanceName;
  }

  /**
   * Gets the resourceId.
   *
   * The ID of the resource.
   *
   * @return the resourceId
   */
  public String getResourceId() {
    return resourceId;
  }

  /**
   * Gets the resourceName.
   *
   * The name of the resource.
   *
   * @return the resourceName
   */
  public String getResourceName() {
    return resourceName;
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
   * Gets the resourceGroupName.
   *
   * The name of the resource group.
   *
   * @return the resourceGroupName
   */
  public String getResourceGroupName() {
    return resourceGroupName;
  }

  /**
   * Gets the organizationId.
   *
   * The ID of the organization.
   *
   * @return the organizationId
   */
  public String getOrganizationId() {
    return organizationId;
  }

  /**
   * Gets the organizationName.
   *
   * The name of the organization.
   *
   * @return the organizationName
   */
  public String getOrganizationName() {
    return organizationName;
  }

  /**
   * Gets the spaceId.
   *
   * The ID of the space.
   *
   * @return the spaceId
   */
  public String getSpaceId() {
    return spaceId;
  }

  /**
   * Gets the spaceName.
   *
   * The name of the space.
   *
   * @return the spaceName
   */
  public String getSpaceName() {
    return spaceName;
  }

  /**
   * Gets the consumerId.
   *
   * The ID of the consumer.
   *
   * @return the consumerId
   */
  public String getConsumerId() {
    return consumerId;
  }

  /**
   * Gets the region.
   *
   * The region where instance was provisioned.
   *
   * @return the region
   */
  public String getRegion() {
    return region;
  }

  /**
   * Gets the pricingRegion.
   *
   * The pricing region where the usage that was submitted was rated.
   *
   * @return the pricingRegion
   */
  public String getPricingRegion() {
    return pricingRegion;
  }

  /**
   * Gets the pricingCountry.
   *
   * The target country pricing that should be used.
   *
   * @return the pricingCountry
   */
  public String getPricingCountry() {
    return pricingCountry;
  }

  /**
   * Gets the currencyCode.
   *
   * The currency for the cost fields in the resources, plans and metrics.
   *
   * @return the currencyCode
   */
  public String getCurrencyCode() {
    return currencyCode;
  }

  /**
   * Gets the billable.
   *
   * Is the cost charged to the account.
   *
   * @return the billable
   */
  public Boolean isBillable() {
    return billable;
  }

  /**
   * Gets the planId.
   *
   * The ID of the plan where the instance was provisioned and rated.
   *
   * @return the planId
   */
  public String getPlanId() {
    return planId;
  }

  /**
   * Gets the planName.
   *
   * The name of the plan where the instance was provisioned and rated.
   *
   * @return the planName
   */
  public String getPlanName() {
    return planName;
  }

  /**
   * Gets the month.
   *
   * The month.
   *
   * @return the month
   */
  public String getMonth() {
    return month;
  }

  /**
   * Gets the usage.
   *
   * All the resource used in the account.
   *
   * @return the usage
   */
  public List<Metric> getUsage() {
    return usage;
  }

  /**
   * Gets the pending.
   *
   * Pending charge from classic infrastructure.
   *
   * @return the pending
   */
  public Boolean isPending() {
    return pending;
  }

  /**
   * Gets the currencyRate.
   *
   * The value of the account's currency in USD.
   *
   * @return the currencyRate
   */
  public Double getCurrencyRate() {
    return currencyRate;
  }
}

