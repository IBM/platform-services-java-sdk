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
package com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * An object that represents a usage report.
 */
public class ResourceUsageReport extends GenericModel {

  /**
   * The entity type.
   */
  public interface EntityType {
    /** enterprise. */
    String ENTERPRISE = "enterprise";
    /** account-group. */
    String ACCOUNT_GROUP = "account-group";
    /** account. */
    String ACCOUNT = "account";
  }

  @SerializedName("entity_id")
  protected String entityId;
  @SerializedName("entity_type")
  protected String entityType;
  @SerializedName("entity_crn")
  protected String entityCrn;
  @SerializedName("entity_name")
  protected String entityName;
  @SerializedName("billing_unit_id")
  protected String billingUnitId;
  @SerializedName("billing_unit_crn")
  protected String billingUnitCrn;
  @SerializedName("billing_unit_name")
  protected String billingUnitName;
  @SerializedName("country_code")
  protected String countryCode;
  @SerializedName("currency_code")
  protected String currencyCode;
  protected String month;
  @SerializedName("billable_cost")
  protected Double billableCost;
  @SerializedName("non_billable_cost")
  protected Double nonBillableCost;
  @SerializedName("billable_rated_cost")
  protected Double billableRatedCost;
  @SerializedName("non_billable_rated_cost")
  protected Double nonBillableRatedCost;
  protected List<ResourceUsage> resources;

  /**
   * Gets the entityId.
   *
   * The ID of the entity.
   *
   * @return the entityId
   */
  public String getEntityId() {
    return entityId;
  }

  /**
   * Gets the entityType.
   *
   * The entity type.
   *
   * @return the entityType
   */
  public String getEntityType() {
    return entityType;
  }

  /**
   * Gets the entityCrn.
   *
   * The Cloud Resource Name (CRN) of the entity towards which the resource usages were rolled up.
   *
   * @return the entityCrn
   */
  public String getEntityCrn() {
    return entityCrn;
  }

  /**
   * Gets the entityName.
   *
   * A user-defined name for the entity, such as the enterprise name or account group name.
   *
   * @return the entityName
   */
  public String getEntityName() {
    return entityName;
  }

  /**
   * Gets the billingUnitId.
   *
   * The ID of the billing unit.
   *
   * @return the billingUnitId
   */
  public String getBillingUnitId() {
    return billingUnitId;
  }

  /**
   * Gets the billingUnitCrn.
   *
   * The CRN of the billing unit.
   *
   * @return the billingUnitCrn
   */
  public String getBillingUnitCrn() {
    return billingUnitCrn;
  }

  /**
   * Gets the billingUnitName.
   *
   * The name of the billing unit.
   *
   * @return the billingUnitName
   */
  public String getBillingUnitName() {
    return billingUnitName;
  }

  /**
   * Gets the countryCode.
   *
   * The country code of the billing unit.
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

  /**
   * Gets the month.
   *
   * Billing month.
   *
   * @return the month
   */
  public String getMonth() {
    return month;
  }

  /**
   * Gets the billableCost.
   *
   * Billable charges that are aggregated from all entities in the report.
   *
   * @return the billableCost
   */
  public Double getBillableCost() {
    return billableCost;
  }

  /**
   * Gets the nonBillableCost.
   *
   * Non-billable charges that are aggregated from all entities in the report.
   *
   * @return the nonBillableCost
   */
  public Double getNonBillableCost() {
    return nonBillableCost;
  }

  /**
   * Gets the billableRatedCost.
   *
   * Aggregated billable charges before discounts.
   *
   * @return the billableRatedCost
   */
  public Double getBillableRatedCost() {
    return billableRatedCost;
  }

  /**
   * Gets the nonBillableRatedCost.
   *
   * Aggregated non-billable charges before discounts.
   *
   * @return the nonBillableRatedCost
   */
  public Double getNonBillableRatedCost() {
    return nonBillableRatedCost;
  }

  /**
   * Gets the resources.
   *
   * Details about all the resources that are included in the aggregated charges.
   *
   * @return the resources
   */
  public List<ResourceUsage> getResources() {
    return resources;
  }
}

