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
package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listProfile options.
 */
public class ListProfileOptions extends GenericModel {

  /**
   * Optional sort order, valid values are asc and desc. Default: asc.
   */
  public interface Order {
    /** asc. */
    String ASC = "asc";
    /** desc. */
    String DESC = "desc";
  }

  protected String accountId;
  protected String name;
  protected Long pagesize;
  protected String sort;
  protected String order;
  protected Boolean includeHistory;
  protected String pagetoken;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String name;
    private Long pagesize;
    private String sort;
    private String order;
    private Boolean includeHistory;
    private String pagetoken;

    private Builder(ListProfileOptions listProfileOptions) {
      this.accountId = listProfileOptions.accountId;
      this.name = listProfileOptions.name;
      this.pagesize = listProfileOptions.pagesize;
      this.sort = listProfileOptions.sort;
      this.order = listProfileOptions.order;
      this.includeHistory = listProfileOptions.includeHistory;
      this.pagetoken = listProfileOptions.pagetoken;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param accountId the accountId
     */
    public Builder(String accountId) {
      this.accountId = accountId;
    }

    /**
     * Builds a ListProfileOptions.
     *
     * @return the new ListProfileOptions instance
     */
    public ListProfileOptions build() {
      return new ListProfileOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListProfileOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ListProfileOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the pagesize.
     *
     * @param pagesize the pagesize
     * @return the ListProfileOptions builder
     */
    public Builder pagesize(long pagesize) {
      this.pagesize = pagesize;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListProfileOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the order.
     *
     * @param order the order
     * @return the ListProfileOptions builder
     */
    public Builder order(String order) {
      this.order = order;
      return this;
    }

    /**
     * Set the includeHistory.
     *
     * @param includeHistory the includeHistory
     * @return the ListProfileOptions builder
     */
    public Builder includeHistory(Boolean includeHistory) {
      this.includeHistory = includeHistory;
      return this;
    }

    /**
     * Set the pagetoken.
     *
     * @param pagetoken the pagetoken
     * @return the ListProfileOptions builder
     */
    public Builder pagetoken(String pagetoken) {
      this.pagetoken = pagetoken;
      return this;
    }
  }

  protected ListProfileOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    accountId = builder.accountId;
    name = builder.name;
    pagesize = builder.pagesize;
    sort = builder.sort;
    order = builder.order;
    includeHistory = builder.includeHistory;
    pagetoken = builder.pagetoken;
  }

  /**
   * New builder.
   *
   * @return a ListProfileOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * Account ID to query for trusted profiles.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the name.
   *
   * Name of the trusted profile to query.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the pagesize.
   *
   * Optional size of a single page. Default is 20 items per page. Valid range is 1 to 100.
   *
   * @return the pagesize
   */
  public Long pagesize() {
    return pagesize;
  }

  /**
   * Gets the sort.
   *
   * Optional sort property, valid values are name, description, created_at and modified_at. If specified, the items are
   * sorted by the value of this property.
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }

  /**
   * Gets the order.
   *
   * Optional sort order, valid values are asc and desc. Default: asc.
   *
   * @return the order
   */
  public String order() {
    return order;
  }

  /**
   * Gets the includeHistory.
   *
   * Defines if the entity history is included in the response.
   *
   * @return the includeHistory
   */
  public Boolean includeHistory() {
    return includeHistory;
  }

  /**
   * Gets the pagetoken.
   *
   * Optional Prev or Next page token returned from a previous query execution. Default is start with first page.
   *
   * @return the pagetoken
   */
  public String pagetoken() {
    return pagetoken;
  }
}

