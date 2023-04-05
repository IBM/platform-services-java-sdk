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
 * The aggregated usage and charges for all the plans in the org.
 */
public class OrgUsage extends GenericModel {

  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("organization_id")
  protected String organizationId;
  @SerializedName("organization_name")
  protected String organizationName;
  @SerializedName("pricing_country")
  protected String pricingCountry;
  @SerializedName("currency_code")
  protected String currencyCode;
  protected String month;
  protected List<Resource> resources;
  @SerializedName("currency_rate")
  protected Double currencyRate;

  protected OrgUsage() { }

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
   * Gets the resources.
   *
   * All the resource used in the account.
   *
   * @return the resources
   */
  public List<Resource> getResources() {
    return resources;
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

