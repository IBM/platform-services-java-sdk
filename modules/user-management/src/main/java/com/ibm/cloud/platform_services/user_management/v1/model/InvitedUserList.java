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

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A collection of invited users.  This is the response returned by the invite_users operation.
 */
public class InvitedUserList extends GenericModel {

  protected List<InvitedUser> resources;

  protected InvitedUserList() { }

  /**
   * Gets the resources.
   *
   * The list of users that have been invited to join the account.
   *
   * @return the resources
   */
  public List<InvitedUser> getResources() {
    return resources;
  }
}

