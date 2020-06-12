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
package com.ibm.cloud.platform_services.catalog_management.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Result of schematics workspace search.
 */
public class SchematicsWorkspaceSearchResult extends GenericModel {

  protected Long offset;
  protected Long limit;
  @SerializedName("total_count")
  protected Long totalCount;
  @SerializedName("resource_count")
  protected Long resourceCount;
  protected String first;
  protected String last;
  protected String prev;
  protected String next;
  protected List<SchematicsWorkspace> resources;

  /**
   * Gets the offset.
   *
   * The offset (origin 0) of the first resource in this page of search results.
   *
   * @return the offset
   */
  public Long getOffset() {
    return offset;
  }

  /**
   * Gets the limit.
   *
   * The maximum number of resources returned in each page of search results.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }

  /**
   * Gets the totalCount.
   *
   * The overall total number of resources in the search result set.
   *
   * @return the totalCount
   */
  public Long getTotalCount() {
    return totalCount;
  }

  /**
   * Gets the resourceCount.
   *
   * The number of resources returned in this page of search results.
   *
   * @return the resourceCount
   */
  public Long getResourceCount() {
    return resourceCount;
  }

  /**
   * Gets the first.
   *
   * A URL for retrieving the first page of search results.
   *
   * @return the first
   */
  public String getFirst() {
    return first;
  }

  /**
   * Gets the last.
   *
   * A URL for retrieving the last page of search results.
   *
   * @return the last
   */
  public String getLast() {
    return last;
  }

  /**
   * Gets the prev.
   *
   * A URL for retrieving the previous page of search results.
   *
   * @return the prev
   */
  public String getPrev() {
    return prev;
  }

  /**
   * Gets the next.
   *
   * A URL for retrieving the next page of search results.
   *
   * @return the next
   */
  public String getNext() {
    return next;
  }

  /**
   * Gets the resources.
   *
   * Resulting objects.
   *
   * @return the resources
   */
  public List<SchematicsWorkspace> getResources() {
    return resources;
  }
}

