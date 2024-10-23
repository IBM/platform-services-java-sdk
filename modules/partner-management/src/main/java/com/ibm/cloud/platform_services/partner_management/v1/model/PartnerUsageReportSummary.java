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

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The aggregated partner usage report.
 */
public class PartnerUsageReportSummary extends GenericModel {

  protected Long limit;
  protected PartnerUsageReportSummaryFirst first;
  protected PartnerUsageReportSummaryNext next;
  protected List<PartnerUsageReport> reports;

  protected PartnerUsageReportSummary() { }

  /**
   * Gets the limit.
   *
   * The maximum number of usage records in the response.
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
  public PartnerUsageReportSummaryFirst getFirst() {
    return first;
  }

  /**
   * Gets the next.
   *
   * The link to the next page of the search query.
   *
   * @return the next
   */
  public PartnerUsageReportSummaryNext getNext() {
    return next;
  }

  /**
   * Gets the reports.
   *
   * Aggregated usage report of all requested partners.
   *
   * @return the reports
   */
  public List<PartnerUsageReport> getReports() {
    return reports;
  }
}

