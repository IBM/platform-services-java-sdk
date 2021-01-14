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
 * The listAttachments options.
 */
public class ListAttachmentsOptions extends GenericModel {

  protected String ruleId;
  protected String transactionId;
  protected Long limit;
  protected Long offset;

  /**
   * Builder.
   */
  public static class Builder {
    private String ruleId;
    private String transactionId;
    private Long limit;
    private Long offset;

    private Builder(ListAttachmentsOptions listAttachmentsOptions) {
      this.ruleId = listAttachmentsOptions.ruleId;
      this.transactionId = listAttachmentsOptions.transactionId;
      this.limit = listAttachmentsOptions.limit;
      this.offset = listAttachmentsOptions.offset;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param ruleId the ruleId
     */
    public Builder(String ruleId) {
      this.ruleId = ruleId;
    }

    /**
     * Builds a ListAttachmentsOptions.
     *
     * @return the new ListAttachmentsOptions instance
     */
    public ListAttachmentsOptions build() {
      return new ListAttachmentsOptions(this);
    }

    /**
     * Set the ruleId.
     *
     * @param ruleId the ruleId
     * @return the ListAttachmentsOptions builder
     */
    public Builder ruleId(String ruleId) {
      this.ruleId = ruleId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the ListAttachmentsOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListAttachmentsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the ListAttachmentsOptions builder
     */
    public Builder offset(long offset) {
      this.offset = offset;
      return this;
    }
  }

  protected ListAttachmentsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.ruleId,
      "ruleId cannot be empty");
    ruleId = builder.ruleId;
    transactionId = builder.transactionId;
    limit = builder.limit;
    offset = builder.offset;
  }

  /**
   * New builder.
   *
   * @return a ListAttachmentsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the ruleId.
   *
   * The UUID that uniquely identifies the rule.
   *
   * @return the ruleId
   */
  public String ruleId() {
    return ruleId;
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

