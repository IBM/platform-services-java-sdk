/*
 * (C) Copyright IBM Corp. 2022.
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
 * The listAccessGroupMembers options.
 */
public class ListAccessGroupMembersOptions extends GenericModel {

  protected String accessGroupId;
  protected String transactionId;
  protected Long limit;
  protected Long offset;
  protected String type;
  protected Boolean verbose;
  protected String sort;

  /**
   * Builder.
   */
  public static class Builder {
    private String accessGroupId;
    private String transactionId;
    private Long limit;
    private Long offset;
    private String type;
    private Boolean verbose;
    private String sort;

    private Builder(ListAccessGroupMembersOptions listAccessGroupMembersOptions) {
      this.accessGroupId = listAccessGroupMembersOptions.accessGroupId;
      this.transactionId = listAccessGroupMembersOptions.transactionId;
      this.limit = listAccessGroupMembersOptions.limit;
      this.offset = listAccessGroupMembersOptions.offset;
      this.type = listAccessGroupMembersOptions.type;
      this.verbose = listAccessGroupMembersOptions.verbose;
      this.sort = listAccessGroupMembersOptions.sort;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param accessGroupId the accessGroupId
     */
    public Builder(String accessGroupId) {
      this.accessGroupId = accessGroupId;
    }

    /**
     * Builds a ListAccessGroupMembersOptions.
     *
     * @return the new ListAccessGroupMembersOptions instance
     */
    public ListAccessGroupMembersOptions build() {
      return new ListAccessGroupMembersOptions(this);
    }

    /**
     * Set the accessGroupId.
     *
     * @param accessGroupId the accessGroupId
     * @return the ListAccessGroupMembersOptions builder
     */
    public Builder accessGroupId(String accessGroupId) {
      this.accessGroupId = accessGroupId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the ListAccessGroupMembersOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListAccessGroupMembersOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the ListAccessGroupMembersOptions builder
     */
    public Builder offset(long offset) {
      this.offset = offset;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the ListAccessGroupMembersOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the verbose.
     *
     * @param verbose the verbose
     * @return the ListAccessGroupMembersOptions builder
     */
    public Builder verbose(Boolean verbose) {
      this.verbose = verbose;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListAccessGroupMembersOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }
  }

  protected ListAccessGroupMembersOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accessGroupId,
      "accessGroupId cannot be empty");
    accessGroupId = builder.accessGroupId;
    transactionId = builder.transactionId;
    limit = builder.limit;
    offset = builder.offset;
    type = builder.type;
    verbose = builder.verbose;
    sort = builder.sort;
  }

  /**
   * New builder.
   *
   * @return a ListAccessGroupMembersOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accessGroupId.
   *
   * The access group identifier.
   *
   * @return the accessGroupId
   */
  public String accessGroupId() {
    return accessGroupId;
  }

  /**
   * Gets the transactionId.
   *
   * An optional transaction ID can be passed to your request, which can be useful for tracking calls through multiple
   * services by using one identifier. The header key must be set to Transaction-Id and the value is anything that you
   * choose. If no transaction ID is passed in, then a random ID is generated.
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
   * Gets the type.
   *
   * Filter the results by member type.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the verbose.
   *
   * Return user's email and name for each user id or the name for each service id or trusted profile.
   *
   * @return the verbose
   */
  public Boolean verbose() {
    return verbose;
  }

  /**
   * Gets the sort.
   *
   * If verbose is true, sort the results by id, name, or email.
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }
}

