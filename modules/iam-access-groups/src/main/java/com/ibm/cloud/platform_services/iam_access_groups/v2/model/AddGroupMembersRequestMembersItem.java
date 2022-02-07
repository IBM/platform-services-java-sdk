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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * AddGroupMembersRequestMembersItem.
 */
public class AddGroupMembersRequestMembersItem extends GenericModel {

  @SerializedName("iam_id")
  protected String iamId;
  protected String type;

  /**
   * Builder.
   */
  public static class Builder {
    private String iamId;
    private String type;

    private Builder(AddGroupMembersRequestMembersItem addGroupMembersRequestMembersItem) {
      this.iamId = addGroupMembersRequestMembersItem.iamId;
      this.type = addGroupMembersRequestMembersItem.type;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param iamId the iamId
     * @param type the type
     */
    public Builder(String iamId, String type) {
      this.iamId = iamId;
      this.type = type;
    }

    /**
     * Builds a AddGroupMembersRequestMembersItem.
     *
     * @return the new AddGroupMembersRequestMembersItem instance
     */
    public AddGroupMembersRequestMembersItem build() {
      return new AddGroupMembersRequestMembersItem(this);
    }

    /**
     * Set the iamId.
     *
     * @param iamId the iamId
     * @return the AddGroupMembersRequestMembersItem builder
     */
    public Builder iamId(String iamId) {
      this.iamId = iamId;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the AddGroupMembersRequestMembersItem builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }
  }

  protected AddGroupMembersRequestMembersItem(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.iamId,
      "iamId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    iamId = builder.iamId;
    type = builder.type;
  }

  /**
   * New builder.
   *
   * @return a AddGroupMembersRequestMembersItem builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the iamId.
   *
   * The IBMid, Service Id or Profile Id of the member.
   *
   * @return the iamId
   */
  public String iamId() {
    return iamId;
  }

  /**
   * Gets the type.
   *
   * The type of the member, must be either "user", "service" or "trusted profile".
   *
   * @return the type
   */
  public String type() {
    return type;
  }
}

