/*
 * (C) Copyright IBM Corp. 2025.
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

package com.ibm.cloud.platform_services.global_search.v2.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The search scan response.
 */
public class ScanResult extends GenericModel {

  @SerializedName("search_cursor")
  protected String searchCursor;
  protected Long limit;
  protected List<ResultItem> items;

  protected ScanResult() { }

  /**
   * Gets the searchCursor.
   *
   * The search cursor to use on all calls after the first one.
   *
   * @return the searchCursor
   */
  public String getSearchCursor() {
    return searchCursor;
  }

  /**
   * Gets the limit.
   *
   * Value of the limit parameter specified by the user.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }

  /**
   * Gets the items.
   *
   * The array of results. Each item represents a resource. For each resource, the requested `fields` are returned. If
   * you did not set the `fields` request body parameter, then the `account_id`, `name`, `type`, `family`, and `crn` are
   * returned. An empty array signals the end of the result set, which means there are no more results to fetch.
   *
   * @return the items
   */
  public List<ResultItem> getItems() {
    return items;
  }
}

