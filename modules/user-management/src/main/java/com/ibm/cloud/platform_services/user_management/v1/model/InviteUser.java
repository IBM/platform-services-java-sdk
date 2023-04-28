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
package com.ibm.cloud.platform_services.user_management.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Invite a user.
 */
public class InviteUser extends GenericModel {

  protected String email;
  @SerializedName("account_role")
  protected String accountRole;

  /**
   * Builder.
   */
  public static class Builder {
    private String email;
    private String accountRole;

    /**
     * Instantiates a new Builder from an existing InviteUser instance.
     *
     * @param inviteUser the instance to initialize the Builder with
     */
    private Builder(InviteUser inviteUser) {
      this.email = inviteUser.email;
      this.accountRole = inviteUser.accountRole;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a InviteUser.
     *
     * @return the new InviteUser instance
     */
    public InviteUser build() {
      return new InviteUser(this);
    }

    /**
     * Set the email.
     *
     * @param email the email
     * @return the InviteUser builder
     */
    public Builder email(String email) {
      this.email = email;
      return this;
    }

    /**
     * Set the accountRole.
     *
     * @param accountRole the accountRole
     * @return the InviteUser builder
     */
    public Builder accountRole(String accountRole) {
      this.accountRole = accountRole;
      return this;
    }
  }

  protected InviteUser() { }

  protected InviteUser(Builder builder) {
    email = builder.email;
    accountRole = builder.accountRole;
  }

  /**
   * New builder.
   *
   * @return a InviteUser builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the email.
   *
   * The email of the user to be invited.
   *
   * @return the email
   */
  public String email() {
    return email;
  }

  /**
   * Gets the accountRole.
   *
   * The account role of the user to be invited.
   *
   * @return the accountRole
   */
  public String accountRole() {
    return accountRole;
  }
}

