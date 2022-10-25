/*
 * (C) Copyright IBM Corp. 2022.
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
package com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getResourceUsageReport options.
 */
public class GetResourceUsageReportOptions extends GenericModel {

  protected String enterpriseId;
  protected String accountGroupId;
  protected String accountId;
  protected Boolean children;
  protected String month;
  protected String billingUnitId;
  protected Long limit;
  protected String offset;

  /**
   * Builder.
   */
  public static class Builder {
    private String enterpriseId;
    private String accountGroupId;
    private String accountId;
    private Boolean children;
    private String month;
    private String billingUnitId;
    private Long limit;
    private String offset;

    /**
     * Instantiates a new Builder from an existing GetResourceUsageReportOptions instance.
     *
     * @param getResourceUsageReportOptions the instance to initialize the Builder with
     */
    private Builder(GetResourceUsageReportOptions getResourceUsageReportOptions) {
      this.enterpriseId = getResourceUsageReportOptions.enterpriseId;
      this.accountGroupId = getResourceUsageReportOptions.accountGroupId;
      this.accountId = getResourceUsageReportOptions.accountId;
      this.children = getResourceUsageReportOptions.children;
      this.month = getResourceUsageReportOptions.month;
      this.billingUnitId = getResourceUsageReportOptions.billingUnitId;
      this.limit = getResourceUsageReportOptions.limit;
      this.offset = getResourceUsageReportOptions.offset;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a GetResourceUsageReportOptions.
     *
     * @return the new GetResourceUsageReportOptions instance
     */
    public GetResourceUsageReportOptions build() {
      return new GetResourceUsageReportOptions(this);
    }

    /**
     * Set the enterpriseId.
     *
     * @param enterpriseId the enterpriseId
     * @return the GetResourceUsageReportOptions builder
     */
    public Builder enterpriseId(String enterpriseId) {
      this.enterpriseId = enterpriseId;
      return this;
    }

    /**
     * Set the accountGroupId.
     *
     * @param accountGroupId the accountGroupId
     * @return the GetResourceUsageReportOptions builder
     */
    public Builder accountGroupId(String accountGroupId) {
      this.accountGroupId = accountGroupId;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the GetResourceUsageReportOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the children.
     *
     * @param children the children
     * @return the GetResourceUsageReportOptions builder
     */
    public Builder children(Boolean children) {
      this.children = children;
      return this;
    }

    /**
     * Set the month.
     *
     * @param month the month
     * @return the GetResourceUsageReportOptions builder
     */
    public Builder month(String month) {
      this.month = month;
      return this;
    }

    /**
     * Set the billingUnitId.
     *
     * @param billingUnitId the billingUnitId
     * @return the GetResourceUsageReportOptions builder
     */
    public Builder billingUnitId(String billingUnitId) {
      this.billingUnitId = billingUnitId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the GetResourceUsageReportOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the GetResourceUsageReportOptions builder
     */
    public Builder offset(String offset) {
      this.offset = offset;
      return this;
    }
  }

  protected GetResourceUsageReportOptions() { }

  protected GetResourceUsageReportOptions(Builder builder) {
    enterpriseId = builder.enterpriseId;
    accountGroupId = builder.accountGroupId;
    accountId = builder.accountId;
    children = builder.children;
    month = builder.month;
    billingUnitId = builder.billingUnitId;
    limit = builder.limit;
    offset = builder.offset;
  }

  /**
   * New builder.
   *
   * @return a GetResourceUsageReportOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enterpriseId.
   *
   * The ID of the enterprise for which the reports are queried. This parameter cannot be used with the `account_id` or
   * `account_group_id` query parameters.
   *
   * @return the enterpriseId
   */
  public String enterpriseId() {
    return enterpriseId;
  }

  /**
   * Gets the accountGroupId.
   *
   * The ID of the account group for which the reports are queried. This parameter cannot be used with the `account_id`
   * or `enterprise_id` query parameters.
   *
   * @return the accountGroupId
   */
  public String accountGroupId() {
    return accountGroupId;
  }

  /**
   * Gets the accountId.
   *
   * The ID of the account for which the reports are queried. This parameter cannot be used with the `account_group_id`
   * or `enterprise_id` query parameters.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the children.
   *
   * Returns the reports for the immediate child entities under the current account group or enterprise. This parameter
   * cannot be used with the `account_id` query parameter.
   *
   * @return the children
   */
  public Boolean children() {
    return children;
  }

  /**
   * Gets the month.
   *
   * The billing month for which the usage report is requested. The format is in yyyy-mm. Defaults to the month in which
   * the report is queried.
   *
   * @return the month
   */
  public String month() {
    return month;
  }

  /**
   * Gets the billingUnitId.
   *
   * The ID of the billing unit by which to filter the reports.
   *
   * @return the billingUnitId
   */
  public String billingUnitId() {
    return billingUnitId;
  }

  /**
   * Gets the limit.
   *
   * The maximum number of search results to be returned.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the offset.
   *
   * An opaque value representing the offset of the first item to be returned by a search query. If not specified, then
   * the first page of results is returned. To retrieve the next page of search results, use the 'offset' query
   * parameter value within the 'next.href' URL found within a prior search query response.
   *
   * @return the offset
   */
  public String offset() {
    return offset;
  }
}

