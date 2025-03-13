/*
 * (C) Copyright IBM Corp. 2025.
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

package com.ibm.cloud.platform_services.global_catalog.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getAuditLogs options.
 */
public class GetAuditLogsOptions extends GenericModel {

  protected String id;
  protected String account;
  protected String ascending;
  protected String startat;
  protected Long offset;
  protected Long limit;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String account;
    private String ascending;
    private String startat;
    private Long offset;
    private Long limit;

    /**
     * Instantiates a new Builder from an existing GetAuditLogsOptions instance.
     *
     * @param getAuditLogsOptions the instance to initialize the Builder with
     */
    private Builder(GetAuditLogsOptions getAuditLogsOptions) {
      this.id = getAuditLogsOptions.id;
      this.account = getAuditLogsOptions.account;
      this.ascending = getAuditLogsOptions.ascending;
      this.startat = getAuditLogsOptions.startat;
      this.offset = getAuditLogsOptions.offset;
      this.limit = getAuditLogsOptions.limit;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param id the id
     */
    public Builder(String id) {
      this.id = id;
    }

    /**
     * Builds a GetAuditLogsOptions.
     *
     * @return the new GetAuditLogsOptions instance
     */
    public GetAuditLogsOptions build() {
      return new GetAuditLogsOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the GetAuditLogsOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the account.
     *
     * @param account the account
     * @return the GetAuditLogsOptions builder
     */
    public Builder account(String account) {
      this.account = account;
      return this;
    }

    /**
     * Set the ascending.
     *
     * @param ascending the ascending
     * @return the GetAuditLogsOptions builder
     */
    public Builder ascending(String ascending) {
      this.ascending = ascending;
      return this;
    }

    /**
     * Set the startat.
     *
     * @param startat the startat
     * @return the GetAuditLogsOptions builder
     */
    public Builder startat(String startat) {
      this.startat = startat;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the GetAuditLogsOptions builder
     */
    public Builder offset(long offset) {
      this.offset = offset;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the GetAuditLogsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }
  }

  protected GetAuditLogsOptions() { }

  protected GetAuditLogsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    id = builder.id;
    account = builder.account;
    ascending = builder.ascending;
    startat = builder.startat;
    offset = builder.offset;
    limit = builder.limit;
  }

  /**
   * New builder.
   *
   * @return a GetAuditLogsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The object's unique ID.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the account.
   *
   * This changes the scope of the request regardless of the authorization header. Example scopes are `account` and
   * `global`. `account=global` is reqired if operating with a service ID that has a global admin policy, for example
   * `GET /?account=global`.
   *
   * @return the account
   */
  public String account() {
    return account;
  }

  /**
   * Gets the ascending.
   *
   * Sets the sort order. False is descending.
   *
   * @return the ascending
   */
  public String ascending() {
    return ascending;
  }

  /**
   * Gets the startat.
   *
   * Starting time for the logs. If it's descending then the entries will be equal or earlier. The default is latest.
   * For ascending it will entries equal or later. The default is earliest. It can be either a number or a string. If a
   * number then it is in the format of Unix timestamps. If it is a string then it is a date in the format
   * YYYY-MM-DDTHH:MM:SSZ  and the time is UTC. The T and the Z are required. For example: 2017-12-24T12:00:00Z for Noon
   * UTC on Dec 24, 2017.
   *
   * @return the startat
   */
  public String startat() {
    return startat;
  }

  /**
   * Gets the offset.
   *
   * Count of number of log entries to skip before returning logs. The default is zero.
   *
   * @return the offset
   */
  public Long offset() {
    return offset;
  }

  /**
   * Gets the limit.
   *
   * Count of number of entries to return. The default is fifty. The maximum value is two hundred.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }
}

