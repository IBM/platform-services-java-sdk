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
 * The removeMembersFromAccessGroup options.
 */
public class RemoveMembersFromAccessGroupOptions extends GenericModel {

  protected String accessGroupId;
  protected List<String> members;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accessGroupId;
    private List<String> members;
    private String transactionId;

    private Builder(RemoveMembersFromAccessGroupOptions removeMembersFromAccessGroupOptions) {
      this.accessGroupId = removeMembersFromAccessGroupOptions.accessGroupId;
      this.members = removeMembersFromAccessGroupOptions.members;
      this.transactionId = removeMembersFromAccessGroupOptions.transactionId;
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
     * Builds a RemoveMembersFromAccessGroupOptions.
     *
     * @return the new RemoveMembersFromAccessGroupOptions instance
     */
    public RemoveMembersFromAccessGroupOptions build() {
      return new RemoveMembersFromAccessGroupOptions(this);
    }

    /**
     * Adds an members to members.
     *
     * @param members the new members
     * @return the RemoveMembersFromAccessGroupOptions builder
     */
    public Builder addMembers(String members) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(members,
        "members cannot be null");
      if (this.members == null) {
        this.members = new ArrayList<String>();
      }
      this.members.add(members);
      return this;
    }

    /**
     * Set the accessGroupId.
     *
     * @param accessGroupId the accessGroupId
     * @return the RemoveMembersFromAccessGroupOptions builder
     */
    public Builder accessGroupId(String accessGroupId) {
      this.accessGroupId = accessGroupId;
      return this;
    }

    /**
     * Set the members.
     * Existing members will be replaced.
     *
     * @param members the members
     * @return the RemoveMembersFromAccessGroupOptions builder
     */
    public Builder members(List<String> members) {
      this.members = members;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the RemoveMembersFromAccessGroupOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected RemoveMembersFromAccessGroupOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accessGroupId,
      "accessGroupId cannot be empty");
    accessGroupId = builder.accessGroupId;
    members = builder.members;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a RemoveMembersFromAccessGroupOptions builder
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
   * Gets the members.
   *
   * The `iam_id`s to remove from the access group. This field has a limit of 50 `iam_id`s.
   *
   * @return the members
   */
  public List<String> members() {
    return members;
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

