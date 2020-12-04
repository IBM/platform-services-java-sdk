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

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Information about a billing unit.
 */
public class BillingUnit extends GenericModel {

  protected String id;
  protected String crn;
  protected String name;
  @SerializedName("enterprise_id")
  protected String enterpriseId;
  @SerializedName("currency_code")
  protected String currencyCode;
  @SerializedName("country_code")
  protected String countryCode;
  protected Boolean master;
  @SerializedName("created_at")
  protected Date createdAt;

  /**
   * Gets the id.
   *
   * The ID of the billing unit, which is a globally unique identifier (GUID).
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the crn.
   *
   * The Cloud Resource Name (CRN) of the billing unit, scoped to the enterprise account ID.
   *
   * @return the crn
   */
  public String getCrn() {
    return crn;
  }

  /**
   * Gets the name.
   *
   * The name of the billing unit.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the enterpriseId.
   *
   * The ID of the enterprise to which the billing unit is associated.
   *
   * @return the enterpriseId
   */
  public String getEnterpriseId() {
    return enterpriseId;
  }

  /**
   * Gets the currencyCode.
   *
   * The currency code for the billing unit.
   *
   * @return the currencyCode
   */
  public String getCurrencyCode() {
    return currencyCode;
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
   * Gets the master.
   *
   * A flag that indicates whether this billing unit is the primary billing mechanism for the enterprise.
   *
   * @return the master
   */
  public Boolean isMaster() {
    return master;
  }

  /**
   * Gets the createdAt.
   *
   * The creation date of the billing unit.
   *
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }
}

