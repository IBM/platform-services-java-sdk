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

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Subscription.
 */
public class Subscription extends GenericModel {

  @SerializedName("subscription_id")
  protected String subscriptionId;
  @SerializedName("charge_agreement_number")
  protected String chargeAgreementNumber;
  protected String type;
  @SerializedName("subscription_amount")
  protected Double subscriptionAmount;
  protected Date start;
  protected Date end;
  @SerializedName("credits_total")
  protected Double creditsTotal;
  protected List<SubscriptionTerm> terms;

  protected Subscription() { }

  /**
   * Gets the subscriptionId.
   *
   * The ID of the subscription.
   *
   * @return the subscriptionId
   */
  public String getSubscriptionId() {
    return subscriptionId;
  }

  /**
   * Gets the chargeAgreementNumber.
   *
   * The charge agreement number of the subsciption.
   *
   * @return the chargeAgreementNumber
   */
  public String getChargeAgreementNumber() {
    return chargeAgreementNumber;
  }

  /**
   * Gets the type.
   *
   * Type of the subscription.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the subscriptionAmount.
   *
   * The credits available in the subscription for the month.
   *
   * @return the subscriptionAmount
   */
  public Double getSubscriptionAmount() {
    return subscriptionAmount;
  }

  /**
   * Gets the start.
   *
   * The date from which the subscription was active.
   *
   * @return the start
   */
  public Date getStart() {
    return start;
  }

  /**
   * Gets the end.
   *
   * The date until which the subscription is active. End time is unavailable for PayGO accounts.
   *
   * @return the end
   */
  public Date getEnd() {
    return end;
  }

  /**
   * Gets the creditsTotal.
   *
   * The total credits available in the subscription.
   *
   * @return the creditsTotal
   */
  public Double getCreditsTotal() {
    return creditsTotal;
  }

  /**
   * Gets the terms.
   *
   * The terms through which the subscription is split into.
   *
   * @return the terms
   */
  public List<SubscriptionTerm> getTerms() {
    return terms;
  }
}

