/*
 * (C) Copyright IBM Corp. 2021.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The searchObjects options.
 */
public class SearchObjectsOptions extends GenericModel {

  protected String query;
  protected Long limit;
  protected Long offset;
  protected Boolean collapse;
  protected Boolean digest;

  /**
   * Builder.
   */
  public static class Builder {
    private String query;
    private Long limit;
    private Long offset;
    private Boolean collapse;
    private Boolean digest;

    private Builder(SearchObjectsOptions searchObjectsOptions) {
      this.query = searchObjectsOptions.query;
      this.limit = searchObjectsOptions.limit;
      this.offset = searchObjectsOptions.offset;
      this.collapse = searchObjectsOptions.collapse;
      this.digest = searchObjectsOptions.digest;
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
     * Builds a SearchObjectsOptions.
     *
     * @return the new SearchObjectsOptions instance
     */
    public SearchObjectsOptions build() {
      return new SearchObjectsOptions(this);
    }

    /**
     * Set the query.
     *
     * @param query the query
     * @return the SearchObjectsOptions builder
     */
    public Builder query(String query) {
      this.query = query;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the SearchObjectsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the SearchObjectsOptions builder
     */
    public Builder offset(long offset) {
      this.offset = offset;
      return this;
    }

    /**
     * Set the collapse.
     *
     * @param collapse the collapse
     * @return the SearchObjectsOptions builder
     */
    public Builder collapse(Boolean collapse) {
      this.collapse = collapse;
      return this;
    }

    /**
     * Set the digest.
     *
     * @param digest the digest
     * @return the SearchObjectsOptions builder
     */
    public Builder digest(Boolean digest) {
      this.digest = digest;
      return this;
    }
  }

  protected SearchObjectsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.query,
      "query cannot be null");
    query = builder.query;
    limit = builder.limit;
    offset = builder.offset;
    collapse = builder.collapse;
    digest = builder.digest;
  }

  /**
   * New builder.
   *
   * @return a SearchObjectsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the query.
   *
   * Lucene query string.
   *
   * @return the query
   */
  public String query() {
    return query;
  }

  /**
   * Gets the limit.
   *
   * The maximum number of results to return.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the offset.
   *
   * The number of results to skip before returning values.
   *
   * @return the offset
   */
  public Long offset() {
    return offset;
  }

  /**
   * Gets the collapse.
   *
   * When true, hide private objects that correspond to public or IBM published objects.
   *
   * @return the collapse
   */
  public Boolean collapse() {
    return collapse;
  }

  /**
   * Gets the digest.
   *
   * Display a digests of search results, has default value of true.
   *
   * @return the digest
   */
  public Boolean digest() {
    return digest;
  }
}

