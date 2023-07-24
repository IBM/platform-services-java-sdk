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

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Members Input component.
 */
public class MembersInput extends GenericModel {

  protected List<String> users;
  @SerializedName("service_ids")
  protected List<String> serviceIds;
  @SerializedName("action_controls")
  protected MembersActionControls actionControls;

  /**
   * Builder.
   */
  public static class Builder {
    private List<String> users;
    private List<String> serviceIds;
    private MembersActionControls actionControls;

    /**
     * Instantiates a new Builder from an existing MembersInput instance.
     *
     * @param membersInput the instance to initialize the Builder with
     */
    private Builder(MembersInput membersInput) {
      this.users = membersInput.users;
      this.serviceIds = membersInput.serviceIds;
      this.actionControls = membersInput.actionControls;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a MembersInput.
     *
     * @return the new MembersInput instance
     */
    public MembersInput build() {
      return new MembersInput(this);
    }

    /**
     * Adds an users to users.
     *
     * @param users the new users
     * @return the MembersInput builder
     */
    public Builder addUsers(String users) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(users,
        "users cannot be null");
      if (this.users == null) {
        this.users = new ArrayList<String>();
      }
      this.users.add(users);
      return this;
    }

    /**
     * Adds an serviceIds to serviceIds.
     *
     * @param serviceIds the new serviceIds
     * @return the MembersInput builder
     */
    public Builder addServiceIds(String serviceIds) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(serviceIds,
        "serviceIds cannot be null");
      if (this.serviceIds == null) {
        this.serviceIds = new ArrayList<String>();
      }
      this.serviceIds.add(serviceIds);
      return this;
    }

    /**
     * Set the users.
     * Existing users will be replaced.
     *
     * @param users the users
     * @return the MembersInput builder
     */
    public Builder users(List<String> users) {
      this.users = users;
      return this;
    }

    /**
     * Set the serviceIds.
     * Existing serviceIds will be replaced.
     *
     * @param serviceIds the serviceIds
     * @return the MembersInput builder
     */
    public Builder serviceIds(List<String> serviceIds) {
      this.serviceIds = serviceIds;
      return this;
    }

    /**
     * Set the actionControls.
     *
     * @param actionControls the actionControls
     * @return the MembersInput builder
     */
    public Builder actionControls(MembersActionControls actionControls) {
      this.actionControls = actionControls;
      return this;
    }
  }

  protected MembersInput() { }

  protected MembersInput(Builder builder) {
    users = builder.users;
    serviceIds = builder.serviceIds;
    actionControls = builder.actionControls;
  }

  /**
   * New builder.
   *
   * @return a MembersInput builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the users.
   *
   * Users array.
   *
   * @return the users
   */
  public List<String> users() {
    return users;
  }

  /**
   * Gets the serviceIds.
   *
   * Service ids array.
   *
   * @return the serviceIds
   */
  public List<String> serviceIds() {
    return serviceIds;
  }

  /**
   * Gets the actionControls.
   *
   * Control whether or not child account administrators can add and remove members from the enterprise-managed access
   * group in their account.
   *
   * @return the actionControls
   */
  public MembersActionControls actionControls() {
    return actionControls;
  }
}

