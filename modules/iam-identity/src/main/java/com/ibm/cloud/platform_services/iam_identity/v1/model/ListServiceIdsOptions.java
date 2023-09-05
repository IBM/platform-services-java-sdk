/*
 * (C) Copyright IBM Corp. 2023.
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
 * The listServiceIds options.
 */
public class ListServiceIdsOptions extends GenericModel {

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
  protected String pagetoken;
  protected String sort;
  protected String order;
  protected Boolean includeHistory;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String name;
    private Long pagesize;
    private String pagetoken;
    private String sort;
    private String order;
    private Boolean includeHistory;

    /**
     * Instantiates a new Builder from an existing ListServiceIdsOptions instance.
     *
     * @param listServiceIdsOptions the instance to initialize the Builder with
     */
    private Builder(ListServiceIdsOptions listServiceIdsOptions) {
      this.accountId = listServiceIdsOptions.accountId;
      this.name = listServiceIdsOptions.name;
      this.pagesize = listServiceIdsOptions.pagesize;
      this.pagetoken = listServiceIdsOptions.pagetoken;
      this.sort = listServiceIdsOptions.sort;
      this.order = listServiceIdsOptions.order;
      this.includeHistory = listServiceIdsOptions.includeHistory;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListServiceIdsOptions.
     *
     * @return the new ListServiceIdsOptions instance
     */
    public ListServiceIdsOptions build() {
      return new ListServiceIdsOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListServiceIdsOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ListServiceIdsOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the pagesize.
     *
     * @param pagesize the pagesize
     * @return the ListServiceIdsOptions builder
     */
    public Builder pagesize(long pagesize) {
      this.pagesize = pagesize;
      return this;
    }

    /**
     * Set the pagetoken.
     *
     * @param pagetoken the pagetoken
     * @return the ListServiceIdsOptions builder
     */
    public Builder pagetoken(String pagetoken) {
      this.pagetoken = pagetoken;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListServiceIdsOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the order.
     *
     * @param order the order
     * @return the ListServiceIdsOptions builder
     */
    public Builder order(String order) {
      this.order = order;
      return this;
    }

    /**
     * Set the includeHistory.
     *
     * @param includeHistory the includeHistory
     * @return the ListServiceIdsOptions builder
     */
    public Builder includeHistory(Boolean includeHistory) {
      this.includeHistory = includeHistory;
      return this;
    }
  }

  protected ListServiceIdsOptions() { }

  protected ListServiceIdsOptions(Builder builder) {
    accountId = builder.accountId;
    name = builder.name;
    pagesize = builder.pagesize;
    pagetoken = builder.pagetoken;
    sort = builder.sort;
    order = builder.order;
    includeHistory = builder.includeHistory;
  }

  /**
   * New builder.
   *
   * @return a ListServiceIdsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * Account ID of the service ID(s) to query. This parameter is required (unless using a pagetoken).
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the name.
   *
   * Name of the service ID(s) to query. Optional.20 items per page. Valid range is 1 to 100.
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
   * Gets the pagetoken.
   *
   * Optional Prev or Next page token returned from a previous query execution. Default is start with first page.
   *
   * @return the pagetoken
   */
  public String pagetoken() {
    return pagetoken;
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
}

