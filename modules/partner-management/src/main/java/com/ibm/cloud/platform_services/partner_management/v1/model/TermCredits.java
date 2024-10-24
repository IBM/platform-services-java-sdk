/*
 * (C) Copyright IBM Corp. 2024.
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

package com.ibm.cloud.platform_services.partner_management.v1.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The subscription term that is active in the requested month.
 */
public class TermCredits extends GenericModel {

  /**
   * The category of the billing option. The valid values are `PLATFORM`, `SERVICE`, and `SUPPORT`.
   */
  public interface Category {
    /** PLATFORM. */
    String PLATFORM = "PLATFORM";
    /** SERVICE. */
    String SERVICE = "SERVICE";
    /** SUPPORT. */
    String SUPPORT = "SUPPORT";
  }

  @SerializedName("billing_option_id")
  protected String billingOptionId;
  @SerializedName("billing_option_model")
  protected String billingOptionModel;
  protected String category;
  @SerializedName("start_date")
  protected Date startDate;
  @SerializedName("end_date")
  protected Date endDate;
  @SerializedName("total_credits")
  protected Double totalCredits;
  @SerializedName("starting_balance")
  protected Double startingBalance;
  @SerializedName("used_credits")
  protected Double usedCredits;
  @SerializedName("current_balance")
  protected Double currentBalance;
  protected List<Map<String, Object>> resources;

  protected TermCredits() { }

  /**
   * Gets the billingOptionId.
   *
   * The ID of the billing option from which the subscription term is derived.
   *
   * @return the billingOptionId
   */
  public String getBillingOptionId() {
    return billingOptionId;
  }

  /**
   * Gets the billingOptionModel.
   *
   * Billing option model.
   *
   * @return the billingOptionModel
   */
  public String getBillingOptionModel() {
    return billingOptionModel;
  }

  /**
   * Gets the category.
   *
   * The category of the billing option. The valid values are `PLATFORM`, `SERVICE`, and `SUPPORT`.
   *
   * @return the category
   */
  public String getCategory() {
    return category;
  }

  /**
   * Gets the startDate.
   *
   * The start date of the term in ISO format.
   *
   * @return the startDate
   */
  public Date getStartDate() {
    return startDate;
  }

  /**
   * Gets the endDate.
   *
   * The end date of the term in ISO format.
   *
   * @return the endDate
   */
  public Date getEndDate() {
    return endDate;
  }

  /**
   * Gets the totalCredits.
   *
   * The total credit available in this term.
   *
   * @return the totalCredits
   */
  public Double getTotalCredits() {
    return totalCredits;
  }

  /**
   * Gets the startingBalance.
   *
   * The balance of available credit at the start of the current month.
   *
   * @return the startingBalance
   */
  public Double getStartingBalance() {
    return startingBalance;
  }

  /**
   * Gets the usedCredits.
   *
   * The amount of credit used during the current month.
   *
   * @return the usedCredits
   */
  public Double getUsedCredits() {
    return usedCredits;
  }

  /**
   * Gets the currentBalance.
   *
   * The balance of remaining credit in the subscription term.
   *
   * @return the currentBalance
   */
  public Double getCurrentBalance() {
    return currentBalance;
  }

  /**
   * Gets the resources.
   *
   * A list of resources that used credit during the month.
   *
   * @return the resources
   */
  public List<Map<String, Object>> getResources() {
    return resources;
  }
}

