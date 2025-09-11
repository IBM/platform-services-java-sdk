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
 * SearchRequest.
 *
 * Classes which extend this class:
 * - SearchRequestFirstCall
 * - SearchRequestNextCall
 */
public class SearchRequest extends GenericModel {

  protected String query;
  protected List<String> fields;
  @SerializedName("search_cursor")
  protected String searchCursor;

  protected SearchRequest() { }

  /**
   * Gets the query.
   *
   * The Lucene-formatted query string. Default to '*' if not set.
   *
   * @return the query
   */
  public String query() {
    return query;
  }

  /**
   * Gets the fields.
   *
   * The list of the fields returned by the search. By default, the returned fields are the `account_id`, `name`,
   * `type`, `family`, and `crn`. For all queries, `crn` is always returned. You may set `"fields": ["*"]` to discover
   * the set of fields available to request.
   *
   * @return the fields
   */
  public List<String> fields() {
    return fields;
  }

  /**
   * Gets the searchCursor.
   *
   * An opaque cursor that is returned on each call and that must be set on the subsequent call to get the next batch of
   * items. If the search returns no items, then the search_cursor is not present in the response. NOTE: any other
   * properties present in the body will be ignored.
   *
   * @return the searchCursor
   */
  public String searchCursor() {
    return searchCursor;
  }
}

