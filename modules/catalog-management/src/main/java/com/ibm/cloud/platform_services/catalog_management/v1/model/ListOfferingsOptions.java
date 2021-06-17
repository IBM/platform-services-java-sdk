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
 * The listOfferings options.
 */
public class ListOfferingsOptions extends GenericModel {

  protected String catalogIdentifier;
  protected Boolean digest;
  protected Long limit;
  protected Long offset;
  protected String name;
  protected String sort;

  /**
   * Builder.
   */
  public static class Builder {
    private String catalogIdentifier;
    private Boolean digest;
    private Long limit;
    private Long offset;
    private String name;
    private String sort;

    private Builder(ListOfferingsOptions listOfferingsOptions) {
      this.catalogIdentifier = listOfferingsOptions.catalogIdentifier;
      this.digest = listOfferingsOptions.digest;
      this.limit = listOfferingsOptions.limit;
      this.offset = listOfferingsOptions.offset;
      this.name = listOfferingsOptions.name;
      this.sort = listOfferingsOptions.sort;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param catalogIdentifier the catalogIdentifier
     */
    public Builder(String catalogIdentifier) {
      this.catalogIdentifier = catalogIdentifier;
    }

    /**
     * Builds a ListOfferingsOptions.
     *
     * @return the new ListOfferingsOptions instance
     */
    public ListOfferingsOptions build() {
      return new ListOfferingsOptions(this);
    }

    /**
     * Set the catalogIdentifier.
     *
     * @param catalogIdentifier the catalogIdentifier
     * @return the ListOfferingsOptions builder
     */
    public Builder catalogIdentifier(String catalogIdentifier) {
      this.catalogIdentifier = catalogIdentifier;
      return this;
    }

    /**
     * Set the digest.
     *
     * @param digest the digest
     * @return the ListOfferingsOptions builder
     */
    public Builder digest(Boolean digest) {
      this.digest = digest;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListOfferingsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the ListOfferingsOptions builder
     */
    public Builder offset(long offset) {
      this.offset = offset;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ListOfferingsOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListOfferingsOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }
  }

  protected ListOfferingsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.catalogIdentifier,
      "catalogIdentifier cannot be empty");
    catalogIdentifier = builder.catalogIdentifier;
    digest = builder.digest;
    limit = builder.limit;
    offset = builder.offset;
    name = builder.name;
    sort = builder.sort;
  }

  /**
   * New builder.
   *
   * @return a ListOfferingsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the catalogIdentifier.
   *
   * Catalog identifier.
   *
   * @return the catalogIdentifier
   */
  public String catalogIdentifier() {
    return catalogIdentifier;
  }

  /**
   * Gets the digest.
   *
   * true - Strip down the content of what is returned. For example don't return the readme. Makes the result much
   * smaller. Defaults to false.
   *
   * @return the digest
   */
  public Boolean digest() {
    return digest;
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
   * Gets the name.
   *
   * Only return results that contain the specified string.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the sort.
   *
   * The field on which the output is sorted. Sorts by default by **label** property. Available fields are **name**,
   * **label**, **created**, and **updated**. By adding **-** (i.e. **-label**) in front of the query string, you can
   * specify descending order. Default is ascending order.
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }
}

