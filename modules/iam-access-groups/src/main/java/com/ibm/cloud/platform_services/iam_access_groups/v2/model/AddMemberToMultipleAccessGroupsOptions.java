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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The addMemberToMultipleAccessGroups options.
 */
public class AddMemberToMultipleAccessGroupsOptions extends GenericModel {

  protected String accountId;
  protected String iamId;
  protected String type;
  protected List<String> groups;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String iamId;
    private String type;
    private List<String> groups;
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing AddMemberToMultipleAccessGroupsOptions instance.
     *
     * @param addMemberToMultipleAccessGroupsOptions the instance to initialize the Builder with
     */
    private Builder(AddMemberToMultipleAccessGroupsOptions addMemberToMultipleAccessGroupsOptions) {
      this.accountId = addMemberToMultipleAccessGroupsOptions.accountId;
      this.iamId = addMemberToMultipleAccessGroupsOptions.iamId;
      this.type = addMemberToMultipleAccessGroupsOptions.type;
      this.groups = addMemberToMultipleAccessGroupsOptions.groups;
      this.transactionId = addMemberToMultipleAccessGroupsOptions.transactionId;
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
     * @param iamId the iamId
     */
    public Builder(String accountId, String iamId) {
      this.accountId = accountId;
      this.iamId = iamId;
    }

    /**
     * Builds a AddMemberToMultipleAccessGroupsOptions.
     *
     * @return the new AddMemberToMultipleAccessGroupsOptions instance
     */
    public AddMemberToMultipleAccessGroupsOptions build() {
      return new AddMemberToMultipleAccessGroupsOptions(this);
    }

    /**
     * Adds an groups to groups.
     *
     * @param groups the new groups
     * @return the AddMemberToMultipleAccessGroupsOptions builder
     */
    public Builder addGroups(String groups) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(groups,
        "groups cannot be null");
      if (this.groups == null) {
        this.groups = new ArrayList<String>();
      }
      this.groups.add(groups);
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the AddMemberToMultipleAccessGroupsOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the iamId.
     *
     * @param iamId the iamId
     * @return the AddMemberToMultipleAccessGroupsOptions builder
     */
    public Builder iamId(String iamId) {
      this.iamId = iamId;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the AddMemberToMultipleAccessGroupsOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the groups.
     * Existing groups will be replaced.
     *
     * @param groups the groups
     * @return the AddMemberToMultipleAccessGroupsOptions builder
     */
    public Builder groups(List<String> groups) {
      this.groups = groups;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the AddMemberToMultipleAccessGroupsOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected AddMemberToMultipleAccessGroupsOptions() { }

  protected AddMemberToMultipleAccessGroupsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.iamId,
      "iamId cannot be empty");
    accountId = builder.accountId;
    iamId = builder.iamId;
    type = builder.type;
    groups = builder.groups;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a AddMemberToMultipleAccessGroupsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * Account ID of the API keys(s) to query. If a service IAM ID is specified in iam_id then account_id must match the
   * account of the IAM ID. If a user IAM ID is specified in iam_id then then account_id must match the account of the
   * Authorization token.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the iamId.
   *
   * The IAM identifier.
   *
   * @return the iamId
   */
  public String iamId() {
    return iamId;
  }

  /**
   * Gets the type.
   *
   * The type of the member, must be either "user", "service" or "profile".
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the groups.
   *
   * The ids of the access groups a given member is to be added to.
   *
   * @return the groups
   */
  public List<String> groups() {
    return groups;
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
}

