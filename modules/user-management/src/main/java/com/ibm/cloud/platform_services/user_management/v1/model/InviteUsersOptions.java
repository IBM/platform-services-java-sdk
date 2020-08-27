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
package com.ibm.cloud.platform_services.user_management.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The inviteUsers options.
 */
public class InviteUsersOptions extends GenericModel {

  protected String accountId;
  protected List<InviteUser> users;
  protected List<InviteUserIamPolicy> iamPolicy;
  protected List<String> accessGroups;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private List<InviteUser> users;
    private List<InviteUserIamPolicy> iamPolicy;
    private List<String> accessGroups;

    private Builder(InviteUsersOptions inviteUsersOptions) {
      this.accountId = inviteUsersOptions.accountId;
      this.users = inviteUsersOptions.users;
      this.iamPolicy = inviteUsersOptions.iamPolicy;
      this.accessGroups = inviteUsersOptions.accessGroups;
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
     * Builds a InviteUsersOptions.
     *
     * @return the new InviteUsersOptions instance
     */
    public InviteUsersOptions build() {
      return new InviteUsersOptions(this);
    }

    /**
     * Adds an users to users.
     *
     * @param users the new users
     * @return the InviteUsersOptions builder
     */
    public Builder addUsers(InviteUser users) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(users,
        "users cannot be null");
      if (this.users == null) {
        this.users = new ArrayList<InviteUser>();
      }
      this.users.add(users);
      return this;
    }

    /**
     * Adds an iamPolicy to iamPolicy.
     *
     * @param iamPolicy the new iamPolicy
     * @return the InviteUsersOptions builder
     */
    public Builder addIamPolicy(InviteUserIamPolicy iamPolicy) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(iamPolicy,
        "iamPolicy cannot be null");
      if (this.iamPolicy == null) {
        this.iamPolicy = new ArrayList<InviteUserIamPolicy>();
      }
      this.iamPolicy.add(iamPolicy);
      return this;
    }

    /**
     * Adds an accessGroups to accessGroups.
     *
     * @param accessGroups the new accessGroups
     * @return the InviteUsersOptions builder
     */
    public Builder addAccessGroups(String accessGroups) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(accessGroups,
        "accessGroups cannot be null");
      if (this.accessGroups == null) {
        this.accessGroups = new ArrayList<String>();
      }
      this.accessGroups.add(accessGroups);
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the InviteUsersOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the users.
     * Existing users will be replaced.
     *
     * @param users the users
     * @return the InviteUsersOptions builder
     */
    public Builder users(List<InviteUser> users) {
      this.users = users;
      return this;
    }

    /**
     * Set the iamPolicy.
     * Existing iamPolicy will be replaced.
     *
     * @param iamPolicy the iamPolicy
     * @return the InviteUsersOptions builder
     */
    public Builder iamPolicy(List<InviteUserIamPolicy> iamPolicy) {
      this.iamPolicy = iamPolicy;
      return this;
    }

    /**
     * Set the accessGroups.
     * Existing accessGroups will be replaced.
     *
     * @param accessGroups the accessGroups
     * @return the InviteUsersOptions builder
     */
    public Builder accessGroups(List<String> accessGroups) {
      this.accessGroups = accessGroups;
      return this;
    }
  }

  protected InviteUsersOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    accountId = builder.accountId;
    users = builder.users;
    iamPolicy = builder.iamPolicy;
    accessGroups = builder.accessGroups;
  }

  /**
   * New builder.
   *
   * @return a InviteUsersOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * The account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the users.
   *
   * A list of users to be invited.
   *
   * @return the users
   */
  public List<InviteUser> users() {
    return users;
  }

  /**
   * Gets the iamPolicy.
   *
   * A list of IAM policies.
   *
   * @return the iamPolicy
   */
  public List<InviteUserIamPolicy> iamPolicy() {
    return iamPolicy;
  }

  /**
   * Gets the accessGroups.
   *
   * A list of access groups.
   *
   * @return the accessGroups
   */
  public List<String> accessGroups() {
    return accessGroups;
  }
}

