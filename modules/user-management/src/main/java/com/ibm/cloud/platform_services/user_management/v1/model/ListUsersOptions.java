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
package com.ibm.cloud.platform_services.user_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listUsers options.
 */
public class ListUsersOptions extends GenericModel {

  protected String accountId;
  protected Long limit;
  protected Boolean includeSettings;
  protected String search;
  protected String start;
  protected String userId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private Long limit;
    private Boolean includeSettings;
    private String search;
    private String start;
    private String userId;

    /**
     * Instantiates a new Builder from an existing ListUsersOptions instance.
     *
     * @param listUsersOptions the instance to initialize the Builder with
     */
    private Builder(ListUsersOptions listUsersOptions) {
      this.accountId = listUsersOptions.accountId;
      this.limit = listUsersOptions.limit;
      this.includeSettings = listUsersOptions.includeSettings;
      this.search = listUsersOptions.search;
      this.start = listUsersOptions.start;
      this.userId = listUsersOptions.userId;
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
     * Builds a ListUsersOptions.
     *
     * @return the new ListUsersOptions instance
     */
    public ListUsersOptions build() {
      return new ListUsersOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListUsersOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListUsersOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the includeSettings.
     *
     * @param includeSettings the includeSettings
     * @return the ListUsersOptions builder
     */
    public Builder includeSettings(Boolean includeSettings) {
      this.includeSettings = includeSettings;
      return this;
    }

    /**
     * Set the search.
     *
     * @param search the search
     * @return the ListUsersOptions builder
     */
    public Builder search(String search) {
      this.search = search;
      return this;
    }

    /**
     * Set the start.
     *
     * @param start the start
     * @return the ListUsersOptions builder
     */
    public Builder start(String start) {
      this.start = start;
      return this;
    }

    /**
     * Set the userId.
     *
     * @param userId the userId
     * @return the ListUsersOptions builder
     */
    public Builder userId(String userId) {
      this.userId = userId;
      return this;
    }
  }

  protected ListUsersOptions() { }

  protected ListUsersOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    accountId = builder.accountId;
    limit = builder.limit;
    includeSettings = builder.includeSettings;
    search = builder.search;
    start = builder.start;
    userId = builder.userId;
  }

  /**
   * New builder.
   *
   * @return a ListUsersOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * The account ID of the specified user.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the limit.
   *
   * The number of results to be returned.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the includeSettings.
   *
   * The user settings to be returned. Set to true to view language, allowed IP address, and authentication settings.
   *
   * @return the includeSettings
   */
  public Boolean includeSettings() {
    return includeSettings;
  }

  /**
   * Gets the search.
   *
   * The desired search results to be returned. To view the list of users with the additional search filter, use the
   * following query options: `firstname`, `lastname`, `email`, `state`, `substate`, `iam_id`, `realm`, and `userId`.
   * HTML URL encoding for the search query and `:` must be used. For example, search=state%3AINVALID returns a list of
   * invalid users. Multiple search queries can be combined to obtain `OR` results using `,` operator (not URL encoded).
   * For example, search=state%3AINVALID,email%3Amail.test.ibm.com.
   *
   * @return the search
   */
  public String search() {
    return search;
  }

  /**
   * Gets the start.
   *
   * An optional token that indicates the beginning of the page of results to be returned. If omitted, the first page of
   * results is returned. This value is obtained from the 'next_url' field of the operation response.
   *
   * @return the start
   */
  public String start() {
    return start;
  }

  /**
   * Gets the userId.
   *
   * Filter users based on their user ID.
   *
   * @return the userId
   */
  public String userId() {
    return userId;
  }
}

