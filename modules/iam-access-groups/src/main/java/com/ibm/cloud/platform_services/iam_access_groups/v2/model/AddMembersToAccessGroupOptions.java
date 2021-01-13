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
package com.ibm.cloud.platform_services.iam_access_groups.v2.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The addMembersToAccessGroup options.
 */
public class AddMembersToAccessGroupOptions extends GenericModel {

  protected String accessGroupId;
  protected List<AddGroupMembersRequestMembersItem> members;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accessGroupId;
    private List<AddGroupMembersRequestMembersItem> members;
    private String transactionId;

    private Builder(AddMembersToAccessGroupOptions addMembersToAccessGroupOptions) {
      this.accessGroupId = addMembersToAccessGroupOptions.accessGroupId;
      this.members = addMembersToAccessGroupOptions.members;
      this.transactionId = addMembersToAccessGroupOptions.transactionId;
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
     * Builds a AddMembersToAccessGroupOptions.
     *
     * @return the new AddMembersToAccessGroupOptions instance
     */
    public AddMembersToAccessGroupOptions build() {
      return new AddMembersToAccessGroupOptions(this);
    }

    /**
     * Adds an members to members.
     *
     * @param members the new members
     * @return the AddMembersToAccessGroupOptions builder
     */
    public Builder addMembers(AddGroupMembersRequestMembersItem members) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(members,
        "members cannot be null");
      if (this.members == null) {
        this.members = new ArrayList<AddGroupMembersRequestMembersItem>();
      }
      this.members.add(members);
      return this;
    }

    /**
     * Set the accessGroupId.
     *
     * @param accessGroupId the accessGroupId
     * @return the AddMembersToAccessGroupOptions builder
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
     * @return the AddMembersToAccessGroupOptions builder
     */
    public Builder members(List<AddGroupMembersRequestMembersItem> members) {
      this.members = members;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the AddMembersToAccessGroupOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected AddMembersToAccessGroupOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accessGroupId,
      "accessGroupId cannot be empty");
    accessGroupId = builder.accessGroupId;
    members = builder.members;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a AddMembersToAccessGroupOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accessGroupId.
   *
   * The Access Group identifier.
   *
   * @return the accessGroupId
   */
  public String accessGroupId() {
    return accessGroupId;
  }

  /**
   * Gets the members.
   *
   * An array of member objects to add to an access group.
   *
   * @return the members
   */
  public List<AddGroupMembersRequestMembersItem> members() {
    return members;
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
}

