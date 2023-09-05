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
 * The listProfiles options.
 */
public class ListProfilesOptions extends GenericModel {

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

    /**
     * Instantiates a new Builder from an existing ListProfilesOptions instance.
     *
     * @param listProfilesOptions the instance to initialize the Builder with
     */
    private Builder(ListProfilesOptions listProfilesOptions) {
      this.accountId = listProfilesOptions.accountId;
      this.name = listProfilesOptions.name;
      this.pagesize = listProfilesOptions.pagesize;
      this.sort = listProfilesOptions.sort;
      this.order = listProfilesOptions.order;
      this.includeHistory = listProfilesOptions.includeHistory;
      this.pagetoken = listProfilesOptions.pagetoken;
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
     * Builds a ListProfilesOptions.
     *
     * @return the new ListProfilesOptions instance
     */
    public ListProfilesOptions build() {
      return new ListProfilesOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListProfilesOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ListProfilesOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the pagesize.
     *
     * @param pagesize the pagesize
     * @return the ListProfilesOptions builder
     */
    public Builder pagesize(long pagesize) {
      this.pagesize = pagesize;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListProfilesOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the order.
     *
     * @param order the order
     * @return the ListProfilesOptions builder
     */
    public Builder order(String order) {
      this.order = order;
      return this;
    }

    /**
     * Set the includeHistory.
     *
     * @param includeHistory the includeHistory
     * @return the ListProfilesOptions builder
     */
    public Builder includeHistory(Boolean includeHistory) {
      this.includeHistory = includeHistory;
      return this;
    }

    /**
     * Set the pagetoken.
     *
     * @param pagetoken the pagetoken
     * @return the ListProfilesOptions builder
     */
    public Builder pagetoken(String pagetoken) {
      this.pagetoken = pagetoken;
      return this;
    }
  }

  protected ListProfilesOptions() { }

  protected ListProfilesOptions(Builder builder) {
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
   * @return a ListProfilesOptions builder
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

