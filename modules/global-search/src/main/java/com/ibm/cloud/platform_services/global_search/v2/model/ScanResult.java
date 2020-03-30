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
  protected Double limit;
  protected List<ResultItem> items;

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
  public Double getLimit() {
    return limit;
  }

  /**
   * Gets the items.
   *
   * The array of results. Each item represents a resource. An empty array signals the end of the result set, there are
   * no more hits to fetch.
   *
   * @return the items
   */
  public List<ResultItem> getItems() {
    return items;
  }
}

