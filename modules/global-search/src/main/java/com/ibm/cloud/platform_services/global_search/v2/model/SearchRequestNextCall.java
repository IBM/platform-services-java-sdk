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

import java.util.ArrayList;
import java.util.List;

/**
 * The request body when calling the v3 search as second or next time, in order to retrieve further items.
 */
public class SearchRequestNextCall extends SearchRequest {


  /**
   * Builder.
   */
  public static class Builder {
    private String searchCursor;
    private String query;
    private List<String> fields;

    /**
     * Instantiates a new Builder from an existing SearchRequestNextCall instance.
     *
     * @param searchRequestNextCall the instance to initialize the Builder with
     */
    public Builder(SearchRequest searchRequestNextCall) {
      this.searchCursor = searchRequestNextCall.searchCursor;
      this.query = searchRequestNextCall.query;
      this.fields = searchRequestNextCall.fields;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param searchCursor the searchCursor
     */
    public Builder(String searchCursor) {
      this.searchCursor = searchCursor;
    }

    /**
     * Builds a SearchRequestNextCall.
     *
     * @return the new SearchRequestNextCall instance
     */
    public SearchRequestNextCall build() {
      return new SearchRequestNextCall(this);
    }

    /**
     * Adds a new element to fields.
     *
     * @param fields the new element to be added
     * @return the SearchRequestNextCall builder
     */
    public Builder addFields(String fields) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(fields,
        "fields cannot be null");
      if (this.fields == null) {
        this.fields = new ArrayList<String>();
      }
      this.fields.add(fields);
      return this;
    }

    /**
     * Set the searchCursor.
     *
     * @param searchCursor the searchCursor
     * @return the SearchRequestNextCall builder
     */
    public Builder searchCursor(String searchCursor) {
      this.searchCursor = searchCursor;
      return this;
    }

    /**
     * Set the query.
     *
     * @param query the query
     * @return the SearchRequestNextCall builder
     */
    public Builder query(String query) {
      this.query = query;
      return this;
    }

    /**
     * Set the fields.
     * Existing fields will be replaced.
     *
     * @param fields the fields
     * @return the SearchRequestNextCall builder
     */
    public Builder fields(List<String> fields) {
      this.fields = fields;
      return this;
    }
  }

  protected SearchRequestNextCall() { }

  protected SearchRequestNextCall(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.searchCursor,
      "searchCursor cannot be null");
    searchCursor = builder.searchCursor;
    query = builder.query;
    fields = builder.fields;
  }

  /**
   * New builder.
   *
   * @return a SearchRequestNextCall builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

