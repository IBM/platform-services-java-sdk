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
 * The getConsumptionOfferings options.
 */
public class GetConsumptionOfferingsOptions extends GenericModel {

  /**
   * What should be selected. Default is 'all' which will return both public and private offerings. 'public' returns
   * only the public offerings and 'private' returns only the private offerings.
   */
  public interface Select {
    /** all. */
    String ALL = "all";
    /** public. */
    String X_PUBLIC = "public";
    /** private. */
    String X_PRIVATE = "private";
  }

  protected Boolean digest;
  protected String catalog;
  protected String select;
  protected Boolean includeHidden;
  protected Long limit;
  protected Long offset;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean digest;
    private String catalog;
    private String select;
    private Boolean includeHidden;
    private Long limit;
    private Long offset;

    private Builder(GetConsumptionOfferingsOptions getConsumptionOfferingsOptions) {
      this.digest = getConsumptionOfferingsOptions.digest;
      this.catalog = getConsumptionOfferingsOptions.catalog;
      this.select = getConsumptionOfferingsOptions.select;
      this.includeHidden = getConsumptionOfferingsOptions.includeHidden;
      this.limit = getConsumptionOfferingsOptions.limit;
      this.offset = getConsumptionOfferingsOptions.offset;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a GetConsumptionOfferingsOptions.
     *
     * @return the new GetConsumptionOfferingsOptions instance
     */
    public GetConsumptionOfferingsOptions build() {
      return new GetConsumptionOfferingsOptions(this);
    }

    /**
     * Set the digest.
     *
     * @param digest the digest
     * @return the GetConsumptionOfferingsOptions builder
     */
    public Builder digest(Boolean digest) {
      this.digest = digest;
      return this;
    }

    /**
     * Set the catalog.
     *
     * @param catalog the catalog
     * @return the GetConsumptionOfferingsOptions builder
     */
    public Builder catalog(String catalog) {
      this.catalog = catalog;
      return this;
    }

    /**
     * Set the select.
     *
     * @param select the select
     * @return the GetConsumptionOfferingsOptions builder
     */
    public Builder select(String select) {
      this.select = select;
      return this;
    }

    /**
     * Set the includeHidden.
     *
     * @param includeHidden the includeHidden
     * @return the GetConsumptionOfferingsOptions builder
     */
    public Builder includeHidden(Boolean includeHidden) {
      this.includeHidden = includeHidden;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the GetConsumptionOfferingsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the GetConsumptionOfferingsOptions builder
     */
    public Builder offset(long offset) {
      this.offset = offset;
      return this;
    }
  }

  protected GetConsumptionOfferingsOptions(Builder builder) {
    digest = builder.digest;
    catalog = builder.catalog;
    select = builder.select;
    includeHidden = builder.includeHidden;
    limit = builder.limit;
    offset = builder.offset;
  }

  /**
   * New builder.
   *
   * @return a GetConsumptionOfferingsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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
   * Gets the catalog.
   *
   * catalog id. Narrow search down to just a particular catalog. It will apply the catalog's public filters to the
   * public catalog offerings on the result.
   *
   * @return the catalog
   */
  public String catalog() {
    return catalog;
  }

  /**
   * Gets the select.
   *
   * What should be selected. Default is 'all' which will return both public and private offerings. 'public' returns
   * only the public offerings and 'private' returns only the private offerings.
   *
   * @return the select
   */
  public String select() {
    return select;
  }

  /**
   * Gets the includeHidden.
   *
   * true - include offerings which have been marked as hidden. The default is false and hidden offerings are not
   * returned.
   *
   * @return the includeHidden
   */
  public Boolean includeHidden() {
    return includeHidden;
  }

  /**
   * Gets the limit.
   *
   * number or results to return.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the offset.
   *
   * number of results to skip before returning values.
   *
   * @return the offset
   */
  public Long offset() {
    return offset;
  }
}

