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
 * A summary of charges and credits for an account.
 */
public class AccountSummary extends GenericModel {

  @SerializedName("account_id")
  protected String accountId;
  protected String month;
  @SerializedName("billing_country_code")
  protected String billingCountryCode;
  @SerializedName("billing_currency_code")
  protected String billingCurrencyCode;
  protected ResourcesSummary resources;
  protected List<Offer> offers;
  protected List<SupportSummary> support;
  protected SubscriptionSummary subscription;

  protected AccountSummary() { }

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
   * Gets the month.
   *
   * The month in which usages were incurred. Represented in yyyy-mm format.
   *
   * @return the month
   */
  public String getMonth() {
    return month;
  }

  /**
   * Gets the billingCountryCode.
   *
   * Country.
   *
   * @return the billingCountryCode
   */
  public String getBillingCountryCode() {
    return billingCountryCode;
  }

  /**
   * Gets the billingCurrencyCode.
   *
   * The currency in which the account is billed.
   *
   * @return the billingCurrencyCode
   */
  public String getBillingCurrencyCode() {
    return billingCurrencyCode;
  }

  /**
   * Gets the resources.
   *
   * Charges related to cloud resources.
   *
   * @return the resources
   */
  public ResourcesSummary getResources() {
    return resources;
  }

  /**
   * Gets the offers.
   *
   * The list of offers applicable for the account for the month.
   *
   * @return the offers
   */
  public List<Offer> getOffers() {
    return offers;
  }

  /**
   * Gets the support.
   *
   * Support-related charges.
   *
   * @return the support
   */
  public List<SupportSummary> getSupport() {
    return support;
  }

  /**
   * Gets the subscription.
   *
   * A summary of charges and credits related to a subscription.
   *
   * @return the subscription
   */
  public SubscriptionSummary getSubscription() {
    return subscription;
  }
}

