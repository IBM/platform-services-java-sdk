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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Aggregated subscription burn-down report for the end customers.
 */
public class CreditPoolsReport extends GenericModel {

  /**
   * The category of the billing option. The valid values are `PLATFORM`, `SERVICE` and `SUPPORT`.
   */
  public interface Type {
    /** PLATFORM. */
    String PLATFORM = "PLATFORM";
    /** SERVICE. */
    String SERVICE = "SERVICE";
    /** SUPPORT. */
    String SUPPORT = "SUPPORT";
  }

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

  protected String type;
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
  @SerializedName("currency_code")
  protected String currencyCode;
  @SerializedName("term_credits")
  protected List<TermCredits> termCredits;
  protected Overage overage;

  protected CreditPoolsReport() { }

  /**
   * Gets the type.
   *
   * The category of the billing option. The valid values are `PLATFORM`, `SERVICE` and `SUPPORT`.
   *
   * @return the type
   */
  public String getType() {
    return type;
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
   * Gets the currencyCode.
   *
   * The currency code of the billing unit.
   *
   * @return the currencyCode
   */
  public String getCurrencyCode() {
    return currencyCode;
  }

  /**
   * Gets the termCredits.
   *
   * A list of active subscription terms available within a credit.
   *
   * @return the termCredits
   */
  public List<TermCredits> getTermCredits() {
    return termCredits;
  }

  /**
   * Gets the overage.
   *
   * Overage that was generated on the credit pool.
   *
   * @return the overage
   */
  public Overage getOverage() {
    return overage;
  }
}

