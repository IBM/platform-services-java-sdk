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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Information about a user that has been invited to join an account.
 */
public class InvitedUser extends GenericModel {

  protected String email;
  protected String id;
  protected String state;

  /**
   * Gets the email.
   *
   * The email address associated with the invited user.
   *
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Gets the id.
   *
   * The id associated with the invited user.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the state.
   *
   * The state of the invitation for the user.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }
}

