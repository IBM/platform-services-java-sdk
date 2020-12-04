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
package com.ibm.cloud.platform_services.enterprise_billing_units.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The credit pool for a billing unit.
 */
public class CreditPool extends GenericModel {

  /**
   * The type of credit, either `PLATFORM` or `SUPPORT`.
   */
  public interface Type {
    /** PLATFORM. */
    String PLATFORM = "PLATFORM";
    /** SUPPORT. */
    String SUPPORT = "SUPPORT";
  }

  protected String type;
  @SerializedName("currency_code")
  protected String currencyCode;
  @SerializedName("billing_unit_id")
  protected String billingUnitId;
  @SerializedName("term_credits")
  protected List<TermCredits> termCredits;
  protected CreditPoolOverage overage;

  /**
   * Gets the type.
   *
   * The type of credit, either `PLATFORM` or `SUPPORT`.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the currencyCode.
   *
   * The currency code of the associated billing unit.
   *
   * @return the currencyCode
   */
  public String getCurrencyCode() {
    return currencyCode;
  }

  /**
   * Gets the billingUnitId.
   *
   * The ID of the billing unit that's associated with the credit pool. This value is a globally unique identifier
   * (GUID).
   *
   * @return the billingUnitId
   */
  public String getBillingUnitId() {
    return billingUnitId;
  }

  /**
   * Gets the termCredits.
   *
   * A list of active subscription terms available within a credit pool.
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
  public CreditPoolOverage getOverage() {
    return overage;
  }
}

