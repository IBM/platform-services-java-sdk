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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The search options.
 */
public class SearchOptions extends GenericModel {

  protected String query;
  protected List<String> fields;
  protected String searchCursor;
  protected String transactionId;
  protected String accountId;
  protected Long limit;
  protected Long timeout;
  protected List<String> sort;

  /**
   * Builder.
   */
  public static class Builder {
    private String query;
    private List<String> fields;
    private String searchCursor;
    private String transactionId;
    private String accountId;
    private Long limit;
    private Long timeout;
    private List<String> sort;

    private Builder(SearchOptions searchOptions) {
      this.query = searchOptions.query;
      this.fields = searchOptions.fields;
      this.searchCursor = searchOptions.searchCursor;
      this.transactionId = searchOptions.transactionId;
      this.accountId = searchOptions.accountId;
      this.limit = searchOptions.limit;
      this.timeout = searchOptions.timeout;
      this.sort = searchOptions.sort;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a SearchOptions.
     *
     * @return the new SearchOptions instance
     */
    public SearchOptions build() {
      return new SearchOptions(this);
    }

    /**
     * Adds an fields to fields.
     *
     * @param fields the new fields
     * @return the SearchOptions builder
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
     * Adds an sort to sort.
     *
     * @param sort the new sort
     * @return the SearchOptions builder
     */
    public Builder addSort(String sort) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(sort,
        "sort cannot be null");
      if (this.sort == null) {
        this.sort = new ArrayList<String>();
      }
      this.sort.add(sort);
      return this;
    }

    /**
     * Set the query.
     *
     * @param query the query
     * @return the SearchOptions builder
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
     * @return the SearchOptions builder
     */
    public Builder fields(List<String> fields) {
      this.fields = fields;
      return this;
    }

    /**
     * Set the searchCursor.
     *
     * @param searchCursor the searchCursor
     * @return the SearchOptions builder
     */
    public Builder searchCursor(String searchCursor) {
      this.searchCursor = searchCursor;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the SearchOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the SearchOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the SearchOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the timeout.
     *
     * @param timeout the timeout
     * @return the SearchOptions builder
     */
    public Builder timeout(long timeout) {
      this.timeout = timeout;
      return this;
    }

    /**
     * Set the sort.
     * Existing sort will be replaced.
     *
     * @param sort the sort
     * @return the SearchOptions builder
     */
    public Builder sort(List<String> sort) {
      this.sort = sort;
      return this;
    }
  }

  protected SearchOptions(Builder builder) {
    query = builder.query;
    fields = builder.fields;
    searchCursor = builder.searchCursor;
    transactionId = builder.transactionId;
    accountId = builder.accountId;
    limit = builder.limit;
    timeout = builder.timeout;
    sort = builder.sort;
  }

  /**
   * New builder.
   *
   * @return a SearchOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

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
   * The list of the fields returned by the search. Defaults to all. `crn` is always returned.
   *
   * @return the fields
   */
  public List<String> fields() {
    return fields;
  }

  /**
   * Gets the searchCursor.
   *
   * An opaque search cursor that is returned on each operation call and that must be set on next call.
   *
   * @return the searchCursor
   */
  public String searchCursor() {
    return searchCursor;
  }

  /**
   * Gets the transactionId.
   *
   * An aplhanumeric string that can be used to trace a request across services. If not specified it will be
   * automatically generated with the prefix "gst-".
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }

  /**
   * Gets the accountId.
   *
   * The account ID to filter resources.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the limit.
   *
   * The maximum number of hits to return. Defaults to 10.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the timeout.
   *
   * A search timeout, bounding the search request to be executed within the specified time value and bail with the hits
   * accumulated up to that point when expired. Defaults to the system defined timeout.
   *
   * @return the timeout
   */
  public Long timeout() {
    return timeout;
  }

  /**
   * Gets the sort.
   *
   * Comma separated properties names used for sorting.
   *
   * @return the sort
   */
  public List<String> sort() {
    return sort;
  }
}

