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
 * The request body when calling the first time the v3 search.
 */
public class SearchRequestFirstCall extends SearchRequest {


  /**
   * Builder.
   */
  public static class Builder {
    private String query;
    private List<String> fields;

    /**
     * Instantiates a new Builder from an existing SearchRequestFirstCall instance.
     *
     * @param searchRequestFirstCall the instance to initialize the Builder with
     */
    public Builder(SearchRequest searchRequestFirstCall) {
      this.query = searchRequestFirstCall.query;
      this.fields = searchRequestFirstCall.fields;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param query the query
     */
    public Builder(String query) {
      this.query = query;
    }

    /**
     * Builds a SearchRequestFirstCall.
     *
     * @return the new SearchRequestFirstCall instance
     */
    public SearchRequestFirstCall build() {
      return new SearchRequestFirstCall(this);
    }

    /**
     * Adds a new element to fields.
     *
     * @param fields the new element to be added
     * @return the SearchRequestFirstCall builder
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
     * Set the query.
     *
     * @param query the query
     * @return the SearchRequestFirstCall builder
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
     * @return the SearchRequestFirstCall builder
     */
    public Builder fields(List<String> fields) {
      this.fields = fields;
      return this;
    }
  }

  protected SearchRequestFirstCall() { }

  protected SearchRequestFirstCall(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.query,
      "query cannot be null");
    query = builder.query;
    fields = builder.fields;
  }

  /**
   * New builder.
   *
   * @return a SearchRequestFirstCall builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

