/*
 * (C) Copyright IBM Corp. 2026.
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

package com.ibm.cloud.platform_services.global_tagging.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A valid Global Search string.
 */
public class QueryString extends GenericModel {

  @SerializedName("query_string")
  protected String queryString;

  /**
   * Builder.
   */
  public static class Builder {
    private String queryString;

    /**
     * Instantiates a new Builder from an existing QueryString instance.
     *
     * @param queryString the instance to initialize the Builder with
     */
    private Builder(QueryString queryString) {
      this.queryString = queryString.queryString;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param queryString the queryString
     */
    public Builder(String queryString) {
      this.queryString = queryString;
    }

    /**
     * Builds a QueryString.
     *
     * @return the new QueryString instance
     */
    public QueryString build() {
      return new QueryString(this);
    }

    /**
     * Set the queryString.
     *
     * @param queryString the queryString
     * @return the QueryString builder
     */
    public Builder queryString(String queryString) {
      this.queryString = queryString;
      return this;
    }
  }

  protected QueryString() { }

  protected QueryString(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.queryString,
      "queryString cannot be null");
    queryString = builder.queryString;
  }

  /**
   * New builder.
   *
   * @return a QueryString builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the queryString.
   *
   * The Lucene-formatted query string.
   *
   * @return the queryString
   */
  public String queryString() {
    return queryString;
  }
}

