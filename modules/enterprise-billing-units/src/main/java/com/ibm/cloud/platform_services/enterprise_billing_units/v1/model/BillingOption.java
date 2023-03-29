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
package com.ibm.cloud.platform_services.enterprise_billing_units.v1.model;

import java.util.Date;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Information about a billing option.
 */
public class BillingOption extends GenericModel {

  /**
   * The state of the billing option. The valid values include `ACTIVE, `SUSPENDED`, and `CANCELED`.
   */
  public interface State {
    /** ACTIVE. */
    String ACTIVE = "ACTIVE";
    /** SUSPENDED. */
    String SUSPENDED = "SUSPENDED";
    /** CANCELED. */
    String CANCELED = "CANCELED";
  }

  /**
   * The type of billing option. The valid values are `SUBSCRIPTION` and `OFFER`.
   */
  public interface Type {
    /** SUBSCRIPTION. */
    String SUBSCRIPTION = "SUBSCRIPTION";
    /** OFFER. */
    String OFFER = "OFFER";
  }

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

  protected String id;
  @SerializedName("billing_unit_id")
  protected String billingUnitId;
  @SerializedName("start_date")
  protected Date startDate;
  @SerializedName("end_date")
  protected Date endDate;
  protected String state;
  protected String type;
  protected String category;
  @SerializedName("payment_instrument")
  protected Map<String, Object> paymentInstrument;
  @SerializedName("duration_in_months")
  protected Long durationInMonths;
  @SerializedName("line_item_id")
  protected Long lineItemId;
  @SerializedName("billing_system")
  protected Map<String, Object> billingSystem;
  @SerializedName("renewal_mode_code")
  protected String renewalModeCode;
  @SerializedName("updated_at")
  protected Date updatedAt;

  protected BillingOption() { }

  /**
   * Gets the id.
   *
   * The ID of the billing option.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the billingUnitId.
   *
   * The ID of the billing unit that's associated with the billing option.
   *
   * @return the billingUnitId
   */
  public String getBillingUnitId() {
    return billingUnitId;
  }

  /**
   * Gets the startDate.
   *
   * The start date of billing option.
   *
   * @return the startDate
   */
  public Date getStartDate() {
    return startDate;
  }

  /**
   * Gets the endDate.
   *
   * The end date of billing option.
   *
   * @return the endDate
   */
  public Date getEndDate() {
    return endDate;
  }

  /**
   * Gets the state.
   *
   * The state of the billing option. The valid values include `ACTIVE, `SUSPENDED`, and `CANCELED`.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Gets the type.
   *
   * The type of billing option. The valid values are `SUBSCRIPTION` and `OFFER`.
   *
   * @return the type
   */
  public String getType() {
    return type;
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
   * Gets the paymentInstrument.
   *
   * The payment method for support.
   *
   * @return the paymentInstrument
   */
  public Map<String, Object> getPaymentInstrument() {
    return paymentInstrument;
  }

  /**
   * Gets the durationInMonths.
   *
   * The duration of the billing options in months.
   *
   * @return the durationInMonths
   */
  public Long getDurationInMonths() {
    return durationInMonths;
  }

  /**
   * Gets the lineItemId.
   *
   * The line item ID for support.
   *
   * @return the lineItemId
   */
  public Long getLineItemId() {
    return lineItemId;
  }

  /**
   * Gets the billingSystem.
   *
   * The support billing system.
   *
   * @return the billingSystem
   */
  public Map<String, Object> getBillingSystem() {
    return billingSystem;
  }

  /**
   * Gets the renewalModeCode.
   *
   * The renewal code for support. This code denotes whether the subscription automatically renews, is assessed monthly,
   * and so on.
   *
   * @return the renewalModeCode
   */
  public String getRenewalModeCode() {
    return renewalModeCode;
  }

  /**
   * Gets the updatedAt.
   *
   * The date when the billing option was updated.
   *
   * @return the updatedAt
   */
  public Date getUpdatedAt() {
    return updatedAt;
  }
}

