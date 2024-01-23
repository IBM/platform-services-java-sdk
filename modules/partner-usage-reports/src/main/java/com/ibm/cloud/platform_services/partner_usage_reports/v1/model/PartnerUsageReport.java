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
package com.ibm.cloud.platform_services.partner_usage_reports.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Aggregated usage report of a partner.
 */
public class PartnerUsageReport extends GenericModel {

  @SerializedName("entity_id")
  protected String entityId;
  @SerializedName("entity_type")
  protected String entityType;
  @SerializedName("entity_crn")
  protected String entityCrn;
  @SerializedName("entity_name")
  protected String entityName;
  @SerializedName("entity_partner_type")
  protected String entityPartnerType;
  protected String viewpoint;
  protected String month;
  @SerializedName("currency_code")
  protected String currencyCode;
  @SerializedName("country_code")
  protected String countryCode;
  @SerializedName("billable_cost")
  protected Double billableCost;
  @SerializedName("billable_rated_cost")
  protected Double billableRatedCost;
  @SerializedName("non_billable_cost")
  protected Double nonBillableCost;
  @SerializedName("non_billable_rated_cost")
  protected Double nonBillableRatedCost;
  protected List<ResourceUsage> resources;

  protected PartnerUsageReport() { }

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
   * Gets the entityPartnerType.
   *
   * Role of the `entity_id` for which the usage report is fetched.
   *
   * @return the entityPartnerType
   */
  public String getEntityPartnerType() {
    return entityPartnerType;
  }

  /**
   * Gets the viewpoint.
   *
   * Enables partner to view the cost of provisioned services as applicable at each level of the hierarchy.
   *
   * @return the viewpoint
   */
  public String getViewpoint() {
    return viewpoint;
  }

  /**
   * Gets the month.
   *
   * The billing month for which the usage report is requested. Format is yyyy-mm.
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
   * @return the resources
   */
  public List<ResourceUsage> getResources() {
    return resources;
  }
}

