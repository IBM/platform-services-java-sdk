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
package com.ibm.cloud.platform_services.context_based_restrictions.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listZones options.
 */
public class ListZonesOptions extends GenericModel {

  protected String accountId;
  protected String transactionId;
  protected String name;
  protected String sort;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String transactionId;
    private String name;
    private String sort;

    private Builder(ListZonesOptions listZonesOptions) {
      this.accountId = listZonesOptions.accountId;
      this.transactionId = listZonesOptions.transactionId;
      this.name = listZonesOptions.name;
      this.sort = listZonesOptions.sort;
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
     * Builds a ListZonesOptions.
     *
     * @return the new ListZonesOptions instance
     */
    public ListZonesOptions build() {
      return new ListZonesOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListZonesOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the ListZonesOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ListZonesOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListZonesOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }
  }

  protected ListZonesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    accountId = builder.accountId;
    transactionId = builder.transactionId;
    name = builder.name;
    sort = builder.sort;
  }

  /**
   * New builder.
   *
   * @return a ListZonesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * The ID of the managing account.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the transactionId.
   *
   * The UUID that is used to correlate and track transactions. If you omit this field, the service generates and sends
   * a transaction ID in the response.
   * **Note:** To help with debugging, we strongly recommend that you generate and supply a `Transaction-Id` with each
   * request.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }

  /**
   * Gets the name.
   *
   * The name of the zone.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the sort.
   *
   * Sorts results by using a valid sort field. To learn more, see
   * [Sorting](https://cloud.ibm.com/docs/api-handbook?topic=api-handbook-sorting).
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }
}

