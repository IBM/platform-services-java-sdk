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
package com.ibm.cloud.platform_services.usage_reports.v4.model;

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The list of instance usage reports.
 */
public class InstancesUsage extends GenericModel {

  protected Long limit;
  protected Long count;
  protected InstancesUsageFirst first;
  protected InstancesUsageNext next;
  protected List<InstanceUsage> resources;

  protected InstancesUsage() { }

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
   * Gets the count.
   *
   * The number of reports in the response.
   *
   * @return the count
   */
  public Long getCount() {
    return count;
  }

  /**
   * Gets the first.
   *
   * The link to the first page of the search query.
   *
   * @return the first
   */
  public InstancesUsageFirst getFirst() {
    return first;
  }

  /**
   * Gets the next.
   *
   * The link to the next page of the search query.
   *
   * @return the next
   */
  public InstancesUsageNext getNext() {
    return next;
  }

  /**
   * Gets the resources.
   *
   * The list of instance usage reports.
   *
   * @return the resources
   */
  public List<InstanceUsage> getResources() {
    return resources;
  }
}

