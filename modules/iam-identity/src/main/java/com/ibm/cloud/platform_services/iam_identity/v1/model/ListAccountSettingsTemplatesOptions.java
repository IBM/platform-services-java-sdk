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
 * The listAccountSettingsTemplates options.
 */
public class ListAccountSettingsTemplatesOptions extends GenericModel {

  /**
   * Optional sort property. If specified, the returned templated are sorted according to this property.
   */
  public interface Sort {
    /** created_at. */
    String CREATED_AT = "created_at";
    /** last_modified_at. */
    String LAST_MODIFIED_AT = "last_modified_at";
    /** name. */
    String NAME = "name";
  }

  /**
   * Optional sort order.
   */
  public interface Order {
    /** asc. */
    String ASC = "asc";
    /** desc. */
    String DESC = "desc";
  }

  protected String accountId;
  protected String limit;
  protected String pagetoken;
  protected String sort;
  protected String order;
  protected String includeHistory;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String limit;
    private String pagetoken;
    private String sort;
    private String order;
    private String includeHistory;

    /**
     * Instantiates a new Builder from an existing ListAccountSettingsTemplatesOptions instance.
     *
     * @param listAccountSettingsTemplatesOptions the instance to initialize the Builder with
     */
    private Builder(ListAccountSettingsTemplatesOptions listAccountSettingsTemplatesOptions) {
      this.accountId = listAccountSettingsTemplatesOptions.accountId;
      this.limit = listAccountSettingsTemplatesOptions.limit;
      this.pagetoken = listAccountSettingsTemplatesOptions.pagetoken;
      this.sort = listAccountSettingsTemplatesOptions.sort;
      this.order = listAccountSettingsTemplatesOptions.order;
      this.includeHistory = listAccountSettingsTemplatesOptions.includeHistory;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListAccountSettingsTemplatesOptions.
     *
     * @return the new ListAccountSettingsTemplatesOptions instance
     */
    public ListAccountSettingsTemplatesOptions build() {
      return new ListAccountSettingsTemplatesOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListAccountSettingsTemplatesOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListAccountSettingsTemplatesOptions builder
     */
    public Builder limit(String limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the pagetoken.
     *
     * @param pagetoken the pagetoken
     * @return the ListAccountSettingsTemplatesOptions builder
     */
    public Builder pagetoken(String pagetoken) {
      this.pagetoken = pagetoken;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListAccountSettingsTemplatesOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the order.
     *
     * @param order the order
     * @return the ListAccountSettingsTemplatesOptions builder
     */
    public Builder order(String order) {
      this.order = order;
      return this;
    }

    /**
     * Set the includeHistory.
     *
     * @param includeHistory the includeHistory
     * @return the ListAccountSettingsTemplatesOptions builder
     */
    public Builder includeHistory(String includeHistory) {
      this.includeHistory = includeHistory;
      return this;
    }
  }

  protected ListAccountSettingsTemplatesOptions() { }

  protected ListAccountSettingsTemplatesOptions(Builder builder) {
    accountId = builder.accountId;
    limit = builder.limit;
    pagetoken = builder.pagetoken;
    sort = builder.sort;
    order = builder.order;
    includeHistory = builder.includeHistory;
  }

  /**
   * New builder.
   *
   * @return a ListAccountSettingsTemplatesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * Account ID of the account settings templates to query. This parameter is required unless using a pagetoken.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the limit.
   *
   * Optional size of a single page.
   *
   * @return the limit
   */
  public String limit() {
    return limit;
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
   * Optional sort property. If specified, the returned templated are sorted according to this property.
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }

  /**
   * Gets the order.
   *
   * Optional sort order.
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
  public String includeHistory() {
    return includeHistory;
  }
}

