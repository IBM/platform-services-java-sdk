/*
 * (C) Copyright IBM Corp. 2024.
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
package com.ibm.cloud.platform_services.enterprise_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listAccountGroups options.
 */
public class ListAccountGroupsOptions extends GenericModel {

  protected String enterpriseId;
  protected String parentAccountGroupId;
  protected String nextDocid;
  protected String parent;
  protected Long limit;
  protected Boolean includeDeleted;

  /**
   * Builder.
   */
  public static class Builder {
    private String enterpriseId;
    private String parentAccountGroupId;
    private String nextDocid;
    private String parent;
    private Long limit;
    private Boolean includeDeleted;

    /**
     * Instantiates a new Builder from an existing ListAccountGroupsOptions instance.
     *
     * @param listAccountGroupsOptions the instance to initialize the Builder with
     */
    private Builder(ListAccountGroupsOptions listAccountGroupsOptions) {
      this.enterpriseId = listAccountGroupsOptions.enterpriseId;
      this.parentAccountGroupId = listAccountGroupsOptions.parentAccountGroupId;
      this.nextDocid = listAccountGroupsOptions.nextDocid;
      this.parent = listAccountGroupsOptions.parent;
      this.limit = listAccountGroupsOptions.limit;
      this.includeDeleted = listAccountGroupsOptions.includeDeleted;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListAccountGroupsOptions.
     *
     * @return the new ListAccountGroupsOptions instance
     */
    public ListAccountGroupsOptions build() {
      return new ListAccountGroupsOptions(this);
    }

    /**
     * Set the enterpriseId.
     *
     * @param enterpriseId the enterpriseId
     * @return the ListAccountGroupsOptions builder
     */
    public Builder enterpriseId(String enterpriseId) {
      this.enterpriseId = enterpriseId;
      return this;
    }

    /**
     * Set the parentAccountGroupId.
     *
     * @param parentAccountGroupId the parentAccountGroupId
     * @return the ListAccountGroupsOptions builder
     */
    public Builder parentAccountGroupId(String parentAccountGroupId) {
      this.parentAccountGroupId = parentAccountGroupId;
      return this;
    }

    /**
     * Set the nextDocid.
     *
     * @param nextDocid the nextDocid
     * @return the ListAccountGroupsOptions builder
     */
    public Builder nextDocid(String nextDocid) {
      this.nextDocid = nextDocid;
      return this;
    }

    /**
     * Set the parent.
     *
     * @param parent the parent
     * @return the ListAccountGroupsOptions builder
     */
    public Builder parent(String parent) {
      this.parent = parent;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListAccountGroupsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the includeDeleted.
     *
     * @param includeDeleted the includeDeleted
     * @return the ListAccountGroupsOptions builder
     */
    public Builder includeDeleted(Boolean includeDeleted) {
      this.includeDeleted = includeDeleted;
      return this;
    }
  }

  protected ListAccountGroupsOptions() { }

  protected ListAccountGroupsOptions(Builder builder) {
    enterpriseId = builder.enterpriseId;
    parentAccountGroupId = builder.parentAccountGroupId;
    nextDocid = builder.nextDocid;
    parent = builder.parent;
    limit = builder.limit;
    includeDeleted = builder.includeDeleted;
  }

  /**
   * New builder.
   *
   * @return a ListAccountGroupsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enterpriseId.
   *
   * Get account groups that are either immediate children or are a part of the hierarchy for a given enterprise ID.
   *
   * @return the enterpriseId
   */
  public String enterpriseId() {
    return enterpriseId;
  }

  /**
   * Gets the parentAccountGroupId.
   *
   * Get account groups that are either immediate children or are a part of the hierarchy for a given account group ID.
   *
   * @return the parentAccountGroupId
   */
  public String parentAccountGroupId() {
    return parentAccountGroupId;
  }

  /**
   * Gets the nextDocid.
   *
   * The first item to be returned in the page of results. This value can be obtained from the next_url property from
   * the previous call of the operation. If not specified, then the first page of results is returned.
   *
   * @return the nextDocid
   */
  public String nextDocid() {
    return nextDocid;
  }

  /**
   * Gets the parent.
   *
   * Get account groups that are either immediate children or are a part of the hierarchy for a given parent CRN.
   *
   * @return the parent
   */
  public String parent() {
    return parent;
  }

  /**
   * Gets the limit.
   *
   * Return results up to this limit. Valid values are between `0` and `100`.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the includeDeleted.
   *
   * Include the deleted account groups from an enterprise when used in conjunction with other query parameters.
   *
   * @return the includeDeleted
   */
  public Boolean includeDeleted() {
    return includeDeleted;
  }
}

