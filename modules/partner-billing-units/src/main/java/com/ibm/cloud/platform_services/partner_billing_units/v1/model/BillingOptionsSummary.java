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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The billing options report for the customer.
 */
public class BillingOptionsSummary extends GenericModel {

  protected Long limit;
  protected BillingOptionsSummaryFirst first;
  protected BillingOptionsSummaryNext next;
  protected List<BillingOption> resources;

  protected BillingOptionsSummary() { }

  /**
   * Gets the limit.
   *
   * The max number of reports in the response.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }

  /**
   * Gets the first.
   *
   * The link to the first page of the search query.
   *
   * @return the first
   */
  public BillingOptionsSummaryFirst getFirst() {
    return first;
  }

  /**
   * Gets the next.
   *
   * The link to the next page of the search query.
   *
   * @return the next
   */
  public BillingOptionsSummaryNext getNext() {
    return next;
  }

  /**
   * Gets the resources.
   *
   * Aggregated usage report of all requested partners.
   *
   * @return the resources
   */
  public List<BillingOption> getResources() {
    return resources;
  }
}

