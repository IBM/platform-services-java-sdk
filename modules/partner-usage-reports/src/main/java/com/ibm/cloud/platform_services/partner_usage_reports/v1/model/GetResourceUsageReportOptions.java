/*
 * (C) Copyright IBM Corp. 2024.
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
package com.ibm.cloud.platform_services.partner_usage_reports.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getResourceUsageReport options.
 */
public class GetResourceUsageReportOptions extends GenericModel {

  /**
   * Enables partner to view the cost of provisioned services as applicable at each level of the hierarchy. Defaults to
   * the type of the calling partner. The valid values are `DISTRIBUTOR`, `RESELLER` and `END_CUSTOMER`.
   */
  public interface Viewpoint {
    /** DISTRIBUTOR. */
    String DISTRIBUTOR = "DISTRIBUTOR";
    /** RESELLER. */
    String RESELLER = "RESELLER";
    /** END_CUSTOMER. */
    String END_CUSTOMER = "END_CUSTOMER";
  }

  protected String partnerId;
  protected String resellerId;
  protected String customerId;
  protected Boolean children;
  protected String month;
  protected String viewpoint;
  protected Boolean recurse;
  protected Long limit;
  protected String offset;

  /**
   * Builder.
   */
  public static class Builder {
    private String partnerId;
    private String resellerId;
    private String customerId;
    private Boolean children;
    private String month;
    private String viewpoint;
    private Boolean recurse;
    private Long limit;
    private String offset;

    /**
     * Instantiates a new Builder from an existing GetResourceUsageReportOptions instance.
     *
     * @param getResourceUsageReportOptions the instance to initialize the Builder with
     */
    private Builder(GetResourceUsageReportOptions getResourceUsageReportOptions) {
      this.partnerId = getResourceUsageReportOptions.partnerId;
      this.resellerId = getResourceUsageReportOptions.resellerId;
      this.customerId = getResourceUsageReportOptions.customerId;
      this.children = getResourceUsageReportOptions.children;
      this.month = getResourceUsageReportOptions.month;
      this.viewpoint = getResourceUsageReportOptions.viewpoint;
      this.recurse = getResourceUsageReportOptions.recurse;
      this.limit = getResourceUsageReportOptions.limit;
      this.offset = getResourceUsageReportOptions.offset;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param partnerId the partnerId
     */
    public Builder(String partnerId) {
      this.partnerId = partnerId;
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
     * Set the partnerId.
     *
     * @param partnerId the partnerId
     * @return the GetResourceUsageReportOptions builder
     */
    public Builder partnerId(String partnerId) {
      this.partnerId = partnerId;
      return this;
    }

    /**
     * Set the resellerId.
     *
     * @param resellerId the resellerId
     * @return the GetResourceUsageReportOptions builder
     */
    public Builder resellerId(String resellerId) {
      this.resellerId = resellerId;
      return this;
    }

    /**
     * Set the customerId.
     *
     * @param customerId the customerId
     * @return the GetResourceUsageReportOptions builder
     */
    public Builder customerId(String customerId) {
      this.customerId = customerId;
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
     * Set the viewpoint.
     *
     * @param viewpoint the viewpoint
     * @return the GetResourceUsageReportOptions builder
     */
    public Builder viewpoint(String viewpoint) {
      this.viewpoint = viewpoint;
      return this;
    }

    /**
     * Set the recurse.
     *
     * @param recurse the recurse
     * @return the GetResourceUsageReportOptions builder
     */
    public Builder recurse(Boolean recurse) {
      this.recurse = recurse;
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
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.partnerId,
      "partnerId cannot be null");
    partnerId = builder.partnerId;
    resellerId = builder.resellerId;
    customerId = builder.customerId;
    children = builder.children;
    month = builder.month;
    viewpoint = builder.viewpoint;
    recurse = builder.recurse;
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
   * Gets the partnerId.
   *
   * Enterprise ID of the distributor or reseller for which the report is requested.
   *
   * @return the partnerId
   */
  public String partnerId() {
    return partnerId;
  }

  /**
   * Gets the resellerId.
   *
   * Enterprise ID of the reseller for which the report is requested. This parameter cannot be used along with
   * `customer_id` query parameter.
   *
   * @return the resellerId
   */
  public String resellerId() {
    return resellerId;
  }

  /**
   * Gets the customerId.
   *
   * Enterprise ID of the child customer for which the report is requested. This parameter cannot be used along with
   * `reseller_id` query parameter.
   *
   * @return the customerId
   */
  public String customerId() {
    return customerId;
  }

  /**
   * Gets the children.
   *
   * Get report rolled-up to the direct children of the requested entity. Defaults to false. This parameter cannot be
   * used along with `customer_id` query parameter.
   *
   * @return the children
   */
  public Boolean children() {
    return children;
  }

  /**
   * Gets the month.
   *
   * The billing month for which the usage report is requested. Format is `yyyy-mm`. Defaults to current month.
   *
   * @return the month
   */
  public String month() {
    return month;
  }

  /**
   * Gets the viewpoint.
   *
   * Enables partner to view the cost of provisioned services as applicable at each level of the hierarchy. Defaults to
   * the type of the calling partner. The valid values are `DISTRIBUTOR`, `RESELLER` and `END_CUSTOMER`.
   *
   * @return the viewpoint
   */
  public String viewpoint() {
    return viewpoint;
  }

  /**
   * Gets the recurse.
   *
   * Get usage report rolled-up to the end customers of the requested entity. Defaults to false. This parameter cannot
   * be used along with `reseller_id` query parameter or `customer_id` query parameter.
   *
   * @return the recurse
   */
  public Boolean recurse() {
    return recurse;
  }

  /**
   * Gets the limit.
   *
   * Number of usage records to be returned. The default value is 30. Maximum value is 200.
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

