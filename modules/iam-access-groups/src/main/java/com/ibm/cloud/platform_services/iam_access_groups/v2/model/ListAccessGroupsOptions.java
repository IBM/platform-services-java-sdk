/*
 * (C) Copyright IBM Corp. 2020.
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
 * The listAccessGroups options.
 */
public class ListAccessGroupsOptions extends GenericModel {

  protected String accountId;
  protected String transactionId;
  protected String iamId;
  protected Long limit;
  protected Long offset;
  protected String sort;
  protected Boolean showFederated;
  protected Boolean hidePublicAccess;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String transactionId;
    private String iamId;
    private Long limit;
    private Long offset;
    private String sort;
    private Boolean showFederated;
    private Boolean hidePublicAccess;

    private Builder(ListAccessGroupsOptions listAccessGroupsOptions) {
      this.accountId = listAccessGroupsOptions.accountId;
      this.transactionId = listAccessGroupsOptions.transactionId;
      this.iamId = listAccessGroupsOptions.iamId;
      this.limit = listAccessGroupsOptions.limit;
      this.offset = listAccessGroupsOptions.offset;
      this.sort = listAccessGroupsOptions.sort;
      this.showFederated = listAccessGroupsOptions.showFederated;
      this.hidePublicAccess = listAccessGroupsOptions.hidePublicAccess;
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
     * Builds a ListAccessGroupsOptions.
     *
     * @return the new ListAccessGroupsOptions instance
     */
    public ListAccessGroupsOptions build() {
      return new ListAccessGroupsOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListAccessGroupsOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the ListAccessGroupsOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the iamId.
     *
     * @param iamId the iamId
     * @return the ListAccessGroupsOptions builder
     */
    public Builder iamId(String iamId) {
      this.iamId = iamId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListAccessGroupsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the ListAccessGroupsOptions builder
     */
    public Builder offset(long offset) {
      this.offset = offset;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListAccessGroupsOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the showFederated.
     *
     * @param showFederated the showFederated
     * @return the ListAccessGroupsOptions builder
     */
    public Builder showFederated(Boolean showFederated) {
      this.showFederated = showFederated;
      return this;
    }

    /**
     * Set the hidePublicAccess.
     *
     * @param hidePublicAccess the hidePublicAccess
     * @return the ListAccessGroupsOptions builder
     */
    public Builder hidePublicAccess(Boolean hidePublicAccess) {
      this.hidePublicAccess = hidePublicAccess;
      return this;
    }
  }

  protected ListAccessGroupsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    accountId = builder.accountId;
    transactionId = builder.transactionId;
    iamId = builder.iamId;
    limit = builder.limit;
    offset = builder.offset;
    sort = builder.sort;
    showFederated = builder.showFederated;
    hidePublicAccess = builder.hidePublicAccess;
  }

  /**
   * New builder.
   *
   * @return a ListAccessGroupsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * IBM Cloud account identifier.
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
   * Gets the iamId.
   *
   * Return groups for member id (IBMid or Service Id).
   *
   * @return the iamId
   */
  public String iamId() {
    return iamId;
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
   * Gets the sort.
   *
   * Sort the results by id, name, description, or is_federated flag.
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }

  /**
   * Gets the showFederated.
   *
   * If show_federated is true, each group listed will return an is_federated value that is set to true if rules exist
   * for the group.
   *
   * @return the showFederated
   */
  public Boolean showFederated() {
    return showFederated;
  }

  /**
   * Gets the hidePublicAccess.
   *
   * If hide_public_access is true, do not include the Public Access Group in the results.
   *
   * @return the hidePublicAccess
   */
  public Boolean hidePublicAccess() {
    return hidePublicAccess;
  }
}

