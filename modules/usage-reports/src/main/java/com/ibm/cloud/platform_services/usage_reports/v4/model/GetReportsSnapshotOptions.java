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
package com.ibm.cloud.platform_services.usage_reports.v4.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getReportsSnapshot options.
 */
public class GetReportsSnapshotOptions extends GenericModel {

  protected String accountId;
  protected String month;
  protected Long dateFrom;
  protected Long dateTo;
  protected Long limit;
  protected String start;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String month;
    private Long dateFrom;
    private Long dateTo;
    private Long limit;
    private String start;

    /**
     * Instantiates a new Builder from an existing GetReportsSnapshotOptions instance.
     *
     * @param getReportsSnapshotOptions the instance to initialize the Builder with
     */
    private Builder(GetReportsSnapshotOptions getReportsSnapshotOptions) {
      this.accountId = getReportsSnapshotOptions.accountId;
      this.month = getReportsSnapshotOptions.month;
      this.dateFrom = getReportsSnapshotOptions.dateFrom;
      this.dateTo = getReportsSnapshotOptions.dateTo;
      this.limit = getReportsSnapshotOptions.limit;
      this.start = getReportsSnapshotOptions.start;
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
     * @param month the month
     */
    public Builder(String accountId, String month) {
      this.accountId = accountId;
      this.month = month;
    }

    /**
     * Builds a GetReportsSnapshotOptions.
     *
     * @return the new GetReportsSnapshotOptions instance
     */
    public GetReportsSnapshotOptions build() {
      return new GetReportsSnapshotOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the GetReportsSnapshotOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the month.
     *
     * @param month the month
     * @return the GetReportsSnapshotOptions builder
     */
    public Builder month(String month) {
      this.month = month;
      return this;
    }

    /**
     * Set the dateFrom.
     *
     * @param dateFrom the dateFrom
     * @return the GetReportsSnapshotOptions builder
     */
    public Builder dateFrom(long dateFrom) {
      this.dateFrom = dateFrom;
      return this;
    }

    /**
     * Set the dateTo.
     *
     * @param dateTo the dateTo
     * @return the GetReportsSnapshotOptions builder
     */
    public Builder dateTo(long dateTo) {
      this.dateTo = dateTo;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the GetReportsSnapshotOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the start.
     *
     * @param start the start
     * @return the GetReportsSnapshotOptions builder
     */
    public Builder start(String start) {
      this.start = start;
      return this;
    }
  }

  protected GetReportsSnapshotOptions() { }

  protected GetReportsSnapshotOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.month,
      "month cannot be null");
    accountId = builder.accountId;
    month = builder.month;
    dateFrom = builder.dateFrom;
    dateTo = builder.dateTo;
    limit = builder.limit;
    start = builder.start;
  }

  /**
   * New builder.
   *
   * @return a GetReportsSnapshotOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * Account ID for which the billing report snapshot is requested.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the month.
   *
   * The month for which billing report snapshot is requested.  Format is yyyy-mm.
   *
   * @return the month
   */
  public String month() {
    return month;
  }

  /**
   * Gets the dateFrom.
   *
   * Timestamp in milliseconds for which billing report snapshot is requested.
   *
   * @return the dateFrom
   */
  public Long dateFrom() {
    return dateFrom;
  }

  /**
   * Gets the dateTo.
   *
   * Timestamp in milliseconds for which billing report snapshot is requested.
   *
   * @return the dateTo
   */
  public Long dateTo() {
    return dateTo;
  }

  /**
   * Gets the limit.
   *
   * Number of usage records returned. The default value is 30. Maximum value is 200.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the start.
   *
   * The offset from which the records must be fetched. Offset information is included in the response.
   *
   * @return the start
   */
  public String start() {
    return start;
  }
}

