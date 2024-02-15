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
package com.ibm.cloud.platform_services.partner_billing_units.v1.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Billing options report for the end customers.
 */
public class BillingOption extends GenericModel {

  /**
   * The customer type. The valid values are `ENTERPRISE`, `ACCOUNT`, and `ACCOUNT_GROUP`.
   */
  public interface CustomerType {
    /** ENTERPRISE. */
    String ENTERPRISE = "ENTERPRISE";
    /** ACCOUNT. */
    String ACCOUNT = "ACCOUNT";
    /** ACCOUNT_GROUP. */
    String ACCOUNT_GROUP = "ACCOUNT_GROUP";
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
  @SerializedName("customer_id")
  protected String customerId;
  @SerializedName("customer_type")
  protected String customerType;
  @SerializedName("customer_name")
  protected String customerName;
  @SerializedName("reseller_id")
  protected String resellerId;
  @SerializedName("reseller_name")
  protected String resellerName;
  protected String month;
  protected List<Map<String, Object>> errors;
  protected String type;
  @SerializedName("start_date")
  protected Date startDate;
  @SerializedName("end_date")
  protected Date endDate;
  protected String state;
  protected String category;
  @SerializedName("payment_instrument")
  protected Map<String, Object> paymentInstrument;
  @SerializedName("part_number")
  protected String partNumber;
  @SerializedName("catalog_id")
  protected String catalogId;
  @SerializedName("order_id")
  protected String orderId;
  @SerializedName("po_number")
  protected String poNumber;
  @SerializedName("subscription_model")
  protected String subscriptionModel;
  @SerializedName("duration_in_months")
  protected Long durationInMonths;
  @SerializedName("monthly_amount")
  protected Double monthlyAmount;
  @SerializedName("billing_system")
  protected Map<String, Object> billingSystem;
  @SerializedName("country_code")
  protected String countryCode;
  @SerializedName("currency_code")
  protected String currencyCode;

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
   * Gets the customerId.
   *
   * Account ID of the customer.
   *
   * @return the customerId
   */
  public String getCustomerId() {
    return customerId;
  }

  /**
   * Gets the customerType.
   *
   * The customer type. The valid values are `ENTERPRISE`, `ACCOUNT`, and `ACCOUNT_GROUP`.
   *
   * @return the customerType
   */
  public String getCustomerType() {
    return customerType;
  }

  /**
   * Gets the customerName.
   *
   * A user-defined name for the customer.
   *
   * @return the customerName
   */
  public String getCustomerName() {
    return customerName;
  }

  /**
   * Gets the resellerId.
   *
   * ID of the reseller in the heirarchy of the requested customer.
   *
   * @return the resellerId
   */
  public String getResellerId() {
    return resellerId;
  }

  /**
   * Gets the resellerName.
   *
   * Name of the reseller in the heirarchy of the requested customer.
   *
   * @return the resellerName
   */
  public String getResellerName() {
    return resellerName;
  }

  /**
   * Gets the month.
   *
   * The billing month for which the burn-down report is requested. Format is yyyy-mm. Defaults to current month.
   *
   * @return the month
   */
  public String getMonth() {
    return month;
  }

  /**
   * Gets the errors.
   *
   * Errors in the billing.
   *
   * @return the errors
   */
  public List<Map<String, Object>> getErrors() {
    return errors;
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
   * Gets the partNumber.
   *
   * Part number of the offering.
   *
   * @return the partNumber
   */
  public String getPartNumber() {
    return partNumber;
  }

  /**
   * Gets the catalogId.
   *
   * ID of the catalog containing this offering.
   *
   * @return the catalogId
   */
  public String getCatalogId() {
    return catalogId;
  }

  /**
   * Gets the orderId.
   *
   * ID of the order containing this offering.
   *
   * @return the orderId
   */
  public String getOrderId() {
    return orderId;
  }

  /**
   * Gets the poNumber.
   *
   * PO Number of the offering.
   *
   * @return the poNumber
   */
  public String getPoNumber() {
    return poNumber;
  }

  /**
   * Gets the subscriptionModel.
   *
   * Subscription model.
   *
   * @return the subscriptionModel
   */
  public String getSubscriptionModel() {
    return subscriptionModel;
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
   * Gets the monthlyAmount.
   *
   * Amount billed monthly for this offering.
   *
   * @return the monthlyAmount
   */
  public Double getMonthlyAmount() {
    return monthlyAmount;
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
   * Gets the countryCode.
   *
   * The country code for the billing unit.
   *
   * @return the countryCode
   */
  public String getCountryCode() {
    return countryCode;
  }

  /**
   * Gets the currencyCode.
   *
   * The currency code of the billing unit.
   *
   * @return the currencyCode
   */
  public String getCurrencyCode() {
    return currencyCode;
  }
}

