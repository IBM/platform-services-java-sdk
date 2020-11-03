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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Resource Usage Reports API response.
 */
public class Reports extends GenericModel {

  protected Long limit;
  protected Link first;
  protected Link next;
  protected List<ResourceUsageReport> reports;

  /**
   * Gets the limit.
   *
   * The maximum number of reports in the response.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }

  /**
   * Gets the first.
   *
   * An object that contains the link to the first page of the search query.
   *
   * @return the first
   */
  public Link getFirst() {
    return first;
  }

  /**
   * Gets the next.
   *
   * An object that contains the link to the next page of the search query.
   *
   * @return the next
   */
  public Link getNext() {
    return next;
  }

  /**
   * Gets the reports.
   *
   * The list of usage reports.
   *
   * @return the reports
   */
  public List<ResourceUsageReport> getReports() {
    return reports;
  }
}

