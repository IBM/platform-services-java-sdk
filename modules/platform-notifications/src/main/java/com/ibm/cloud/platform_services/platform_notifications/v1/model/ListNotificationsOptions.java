/*
 * (C) Copyright IBM Corp. 2026.
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

package com.ibm.cloud.platform_services.platform_notifications.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listNotifications options.
 */
public class ListNotificationsOptions extends GenericModel {

  protected String accountId;
  protected String start;
  protected Long limit;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String start;
    private Long limit;

    /**
     * Instantiates a new Builder from an existing ListNotificationsOptions instance.
     *
     * @param listNotificationsOptions the instance to initialize the Builder with
     */
    private Builder(ListNotificationsOptions listNotificationsOptions) {
      this.accountId = listNotificationsOptions.accountId;
      this.start = listNotificationsOptions.start;
      this.limit = listNotificationsOptions.limit;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListNotificationsOptions.
     *
     * @return the new ListNotificationsOptions instance
     */
    public ListNotificationsOptions build() {
      return new ListNotificationsOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListNotificationsOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the start.
     *
     * @param start the start
     * @return the ListNotificationsOptions builder
     */
    public Builder start(String start) {
      this.start = start;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListNotificationsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }
  }

  protected ListNotificationsOptions() { }

  protected ListNotificationsOptions(Builder builder) {
    accountId = builder.accountId;
    start = builder.start;
    limit = builder.limit;
  }

  /**
   * New builder.
   *
   * @return a ListNotificationsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * The IBM Cloud account ID. If not provided, the account ID from the bearer token will be used.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the start.
   *
   * An opaque page token that specifies the resource to start the page on or after. If unspecified, the first page of
   * results is returned.
   *
   * @return the start
   */
  public String start() {
    return start;
  }

  /**
   * Gets the limit.
   *
   * The maximum number of items to return per page. If unspecified, a default limit of 50 is used.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }
}

