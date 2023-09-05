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
 * The listApiKeys options.
 */
public class ListApiKeysOptions extends GenericModel {

  /**
   * Optional parameter to define the scope of the queried API Keys. Can be 'entity' (default) or 'account'.
   */
  public interface Scope {
    /** entity. */
    String ENTITY = "entity";
    /** account. */
    String ACCOUNT = "account";
  }

  /**
   * Optional parameter to filter the type of the queried API Keys. Can be 'user' or 'serviceid'.
   */
  public interface Type {
    /** user. */
    String USER = "user";
    /** serviceid. */
    String SERVICEID = "serviceid";
  }

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
  protected String iamId;
  protected Long pagesize;
  protected String pagetoken;
  protected String scope;
  protected String type;
  protected String sort;
  protected String order;
  protected Boolean includeHistory;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String iamId;
    private Long pagesize;
    private String pagetoken;
    private String scope;
    private String type;
    private String sort;
    private String order;
    private Boolean includeHistory;

    /**
     * Instantiates a new Builder from an existing ListApiKeysOptions instance.
     *
     * @param listApiKeysOptions the instance to initialize the Builder with
     */
    private Builder(ListApiKeysOptions listApiKeysOptions) {
      this.accountId = listApiKeysOptions.accountId;
      this.iamId = listApiKeysOptions.iamId;
      this.pagesize = listApiKeysOptions.pagesize;
      this.pagetoken = listApiKeysOptions.pagetoken;
      this.scope = listApiKeysOptions.scope;
      this.type = listApiKeysOptions.type;
      this.sort = listApiKeysOptions.sort;
      this.order = listApiKeysOptions.order;
      this.includeHistory = listApiKeysOptions.includeHistory;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListApiKeysOptions.
     *
     * @return the new ListApiKeysOptions instance
     */
    public ListApiKeysOptions build() {
      return new ListApiKeysOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListApiKeysOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the iamId.
     *
     * @param iamId the iamId
     * @return the ListApiKeysOptions builder
     */
    public Builder iamId(String iamId) {
      this.iamId = iamId;
      return this;
    }

    /**
     * Set the pagesize.
     *
     * @param pagesize the pagesize
     * @return the ListApiKeysOptions builder
     */
    public Builder pagesize(long pagesize) {
      this.pagesize = pagesize;
      return this;
    }

    /**
     * Set the pagetoken.
     *
     * @param pagetoken the pagetoken
     * @return the ListApiKeysOptions builder
     */
    public Builder pagetoken(String pagetoken) {
      this.pagetoken = pagetoken;
      return this;
    }

    /**
     * Set the scope.
     *
     * @param scope the scope
     * @return the ListApiKeysOptions builder
     */
    public Builder scope(String scope) {
      this.scope = scope;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the ListApiKeysOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListApiKeysOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the order.
     *
     * @param order the order
     * @return the ListApiKeysOptions builder
     */
    public Builder order(String order) {
      this.order = order;
      return this;
    }

    /**
     * Set the includeHistory.
     *
     * @param includeHistory the includeHistory
     * @return the ListApiKeysOptions builder
     */
    public Builder includeHistory(Boolean includeHistory) {
      this.includeHistory = includeHistory;
      return this;
    }
  }

  protected ListApiKeysOptions() { }

  protected ListApiKeysOptions(Builder builder) {
    accountId = builder.accountId;
    iamId = builder.iamId;
    pagesize = builder.pagesize;
    pagetoken = builder.pagetoken;
    scope = builder.scope;
    type = builder.type;
    sort = builder.sort;
    order = builder.order;
    includeHistory = builder.includeHistory;
  }

  /**
   * New builder.
   *
   * @return a ListApiKeysOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * Account ID of the API keys(s) to query. If a service IAM ID is specified in iam_id then account_id must match the
   * account of the IAM ID. If a user IAM ID is specified in iam_id then then account_id must match the account of the
   * Authorization token.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the iamId.
   *
   * IAM ID of the API key(s) to be queried. The IAM ID may be that of a user or a service. For a user IAM ID iam_id
   * must match the Authorization token.
   *
   * @return the iamId
   */
  public String iamId() {
    return iamId;
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
   * Gets the scope.
   *
   * Optional parameter to define the scope of the queried API Keys. Can be 'entity' (default) or 'account'.
   *
   * @return the scope
   */
  public String scope() {
    return scope;
  }

  /**
   * Gets the type.
   *
   * Optional parameter to filter the type of the queried API Keys. Can be 'user' or 'serviceid'.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the sort.
   *
   * Optional sort property, valid values are name, description, created_at and created_by. If specified, the items are
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

