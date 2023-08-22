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
package com.ibm.cloud.platform_services.iam_access_groups.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listTemplates options.
 */
public class ListTemplatesOptions extends GenericModel {

  protected String accountId;
  protected String transactionId;
  protected Long limit;
  protected Long offset;
  protected Boolean verbose;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String transactionId;
    private Long limit;
    private Long offset;
    private Boolean verbose;

    /**
     * Instantiates a new Builder from an existing ListTemplatesOptions instance.
     *
     * @param listTemplatesOptions the instance to initialize the Builder with
     */
    private Builder(ListTemplatesOptions listTemplatesOptions) {
      this.accountId = listTemplatesOptions.accountId;
      this.transactionId = listTemplatesOptions.transactionId;
      this.limit = listTemplatesOptions.limit;
      this.offset = listTemplatesOptions.offset;
      this.verbose = listTemplatesOptions.verbose;
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
     * Builds a ListTemplatesOptions.
     *
     * @return the new ListTemplatesOptions instance
     */
    public ListTemplatesOptions build() {
      return new ListTemplatesOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListTemplatesOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the ListTemplatesOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListTemplatesOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the ListTemplatesOptions builder
     */
    public Builder offset(long offset) {
      this.offset = offset;
      return this;
    }

    /**
     * Set the verbose.
     *
     * @param verbose the verbose
     * @return the ListTemplatesOptions builder
     */
    public Builder verbose(Boolean verbose) {
      this.verbose = verbose;
      return this;
    }
  }

  protected ListTemplatesOptions() { }

  protected ListTemplatesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    accountId = builder.accountId;
    transactionId = builder.transactionId;
    limit = builder.limit;
    offset = builder.offset;
    verbose = builder.verbose;
  }

  /**
   * New builder.
   *
   * @return a ListTemplatesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * Enterprise account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the transactionId.
   *
   * An optional transaction id for the request.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }

  /**
   * Gets the limit.
   *
   * Return up to this limit of results where limit is between 0 and 100.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the offset.
   *
   * The offset of the first result item to be returned.
   *
   * @return the offset
   */
  public Long offset() {
    return offset;
  }

  /**
   * Gets the verbose.
   *
   * If `verbose=true`, IAM resource details are returned. If performance is a concern, leave the `verbose` parameter
   * off so that details are not retrieved.
   *
   * @return the verbose
   */
  public Boolean verbose() {
    return verbose;
  }
}

