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
 * Array of enterprise users to add to the template. All enterprise users that you add to the template must be invited
 * to the child accounts where the template is assigned.
 */
public class Members extends GenericModel {

  protected List<String> users;
  protected List<String> services;
  @SerializedName("action_controls")
  protected MembersActionControls actionControls;

  /**
   * Builder.
   */
  public static class Builder {
    private List<String> users;
    private List<String> services;
    private MembersActionControls actionControls;

    /**
     * Instantiates a new Builder from an existing Members instance.
     *
     * @param members the instance to initialize the Builder with
     */
    private Builder(Members members) {
      this.users = members.users;
      this.services = members.services;
      this.actionControls = members.actionControls;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Members.
     *
     * @return the new Members instance
     */
    public Members build() {
      return new Members(this);
    }

    /**
     * Adds an users to users.
     *
     * @param users the new users
     * @return the Members builder
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
     * Adds an services to services.
     *
     * @param services the new services
     * @return the Members builder
     */
    public Builder addServices(String services) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(services,
        "services cannot be null");
      if (this.services == null) {
        this.services = new ArrayList<String>();
      }
      this.services.add(services);
      return this;
    }

    /**
     * Set the users.
     * Existing users will be replaced.
     *
     * @param users the users
     * @return the Members builder
     */
    public Builder users(List<String> users) {
      this.users = users;
      return this;
    }

    /**
     * Set the services.
     * Existing services will be replaced.
     *
     * @param services the services
     * @return the Members builder
     */
    public Builder services(List<String> services) {
      this.services = services;
      return this;
    }

    /**
     * Set the actionControls.
     *
     * @param actionControls the actionControls
     * @return the Members builder
     */
    public Builder actionControls(MembersActionControls actionControls) {
      this.actionControls = actionControls;
      return this;
    }
  }

  protected Members() { }

  protected Members(Builder builder) {
    users = builder.users;
    services = builder.services;
    actionControls = builder.actionControls;
  }

  /**
   * New builder.
   *
   * @return a Members builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the users.
   *
   * Array of enterprise users to add to the template. All enterprise users that you add to the template must be invited
   * to the child accounts where the template is assigned.
   *
   * @return the users
   */
  public List<String> users() {
    return users;
  }

  /**
   * Gets the services.
   *
   * Array of service IDs to add to the template.
   *
   * @return the services
   */
  public List<String> services() {
    return services;
  }

  /**
   * Gets the actionControls.
   *
   * Control whether or not access group administrators in child accounts can add and remove members from the
   * enterprise-managed access group in their account.
   *
   * @return the actionControls
   */
  public MembersActionControls actionControls() {
    return actionControls;
  }
}

