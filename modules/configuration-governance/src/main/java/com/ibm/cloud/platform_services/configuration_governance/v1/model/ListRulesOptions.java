/*
 * (C) Copyright IBM Corp. 2021.
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
package com.ibm.cloud.platform_services.configuration_governance.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listRules options.
 */
public class ListRulesOptions extends GenericModel {

  protected String accountId;
  protected String transactionId;
  protected Boolean attached;
  protected String labels;
  protected String scopes;
  protected Long limit;
  protected Long offset;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String transactionId;
    private Boolean attached;
    private String labels;
    private String scopes;
    private Long limit;
    private Long offset;

    private Builder(ListRulesOptions listRulesOptions) {
      this.accountId = listRulesOptions.accountId;
      this.transactionId = listRulesOptions.transactionId;
      this.attached = listRulesOptions.attached;
      this.labels = listRulesOptions.labels;
      this.scopes = listRulesOptions.scopes;
      this.limit = listRulesOptions.limit;
      this.offset = listRulesOptions.offset;
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
     * Builds a ListRulesOptions.
     *
     * @return the new ListRulesOptions instance
     */
    public ListRulesOptions build() {
      return new ListRulesOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListRulesOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the ListRulesOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the attached.
     *
     * @param attached the attached
     * @return the ListRulesOptions builder
     */
    public Builder attached(Boolean attached) {
      this.attached = attached;
      return this;
    }

    /**
     * Set the labels.
     *
     * @param labels the labels
     * @return the ListRulesOptions builder
     */
    public Builder labels(String labels) {
      this.labels = labels;
      return this;
    }

    /**
     * Set the scopes.
     *
     * @param scopes the scopes
     * @return the ListRulesOptions builder
     */
    public Builder scopes(String scopes) {
      this.scopes = scopes;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListRulesOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the ListRulesOptions builder
     */
    public Builder offset(long offset) {
      this.offset = offset;
      return this;
    }
  }

  protected ListRulesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    accountId = builder.accountId;
    transactionId = builder.transactionId;
    attached = builder.attached;
    labels = builder.labels;
    scopes = builder.scopes;
    limit = builder.limit;
    offset = builder.offset;
  }

  /**
   * New builder.
   *
   * @return a ListRulesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * Your IBM Cloud account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the transactionId.
   *
   * The unique identifier that is used to trace an entire request. If you omit this field, the service generates and
   * sends a transaction ID as a response header of the request. In the case of an error, the transaction ID is set in
   * the `trace` field of the response body.
   *
   * **Note:** To help with debugging logs, it is strongly recommended that you generate and supply a `Transaction-Id`
   * with each request.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }

  /**
   * Gets the attached.
   *
   * Retrieves a list of rules that have scope attachments.
   *
   * @return the attached
   */
  public Boolean attached() {
    return attached;
  }

  /**
   * Gets the labels.
   *
   * Retrieves a list of rules that match the labels that you specify.
   *
   * @return the labels
   */
  public String labels() {
    return labels;
  }

  /**
   * Gets the scopes.
   *
   * Retrieves a list of rules that match the scope ID that you specify.
   *
   * @return the scopes
   */
  public String scopes() {
    return scopes;
  }

  /**
   * Gets the limit.
   *
   * The number of resources to retrieve. By default, list operations return the first 100 items. To retrieve a
   * different set of items, use `limit` with `offset` to page through your available resources.
   *
   * **Usage:** If you have 20 rules, and you want to retrieve only the first 5 rules, use
   * `../rules?account_id={account_id}&amp;limit=5`.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the offset.
   *
   * The number of resources to skip. By specifying `offset`, you retrieve a subset of resources that starts with the
   * `offset` value. Use `offset` with `limit` to page through your available resources.
   *
   * **Usage:** If you have 100 rules, and you want to retrieve rules 26 through 50, use
   * `../rules?account_id={account_id}&amp;offset=25&amp;limit=5`.
   *
   * @return the offset
   */
  public Long offset() {
    return offset;
  }
}

