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
package com.ibm.cloud.platform_services.resource_controller.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listResourceKeysForInstance options.
 */
public class ListResourceKeysForInstanceOptions extends GenericModel {

  protected String id;
  protected Long limit;
  protected String start;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private Long limit;
    private String start;

    private Builder(ListResourceKeysForInstanceOptions listResourceKeysForInstanceOptions) {
      this.id = listResourceKeysForInstanceOptions.id;
      this.limit = listResourceKeysForInstanceOptions.limit;
      this.start = listResourceKeysForInstanceOptions.start;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param id the id
     */
    public Builder(String id) {
      this.id = id;
    }

    /**
     * Builds a ListResourceKeysForInstanceOptions.
     *
     * @return the new ListResourceKeysForInstanceOptions instance
     */
    public ListResourceKeysForInstanceOptions build() {
      return new ListResourceKeysForInstanceOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the ListResourceKeysForInstanceOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListResourceKeysForInstanceOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the start.
     *
     * @param start the start
     * @return the ListResourceKeysForInstanceOptions builder
     */
    public Builder start(String start) {
      this.start = start;
      return this;
    }
  }

  protected ListResourceKeysForInstanceOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    id = builder.id;
    limit = builder.limit;
    start = builder.start;
  }

  /**
   * New builder.
   *
   * @return a ListResourceKeysForInstanceOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The short or long ID of the instance.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the limit.
   *
   * Limit on how many items should be returned.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the start.
   *
   * An optional token that indicates the beginning of the page of results to be returned. Any additional query
   * parameters are ignored if a page token is present. If omitted, the first page of results is returned. This value is
   * obtained from the 'next_url' field of the operation response.
   *
   * @return the start
   */
  public String start() {
    return start;
  }
}

