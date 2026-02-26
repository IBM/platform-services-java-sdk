/*
 * (C) Copyright IBM Corp. 2026.
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

package com.ibm.cloud.platform_services.account_management.v4.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * AccountResponse.
 */
public class AccountResponse extends GenericModel {

  protected String name;
  protected String id;
  protected String owner;
  @SerializedName("owner_userid")
  protected String ownerUserid;
  @SerializedName("owner_iamid")
  protected String ownerIamid;
  protected String type;
  protected String status;
  @SerializedName("linked_softlayer_account")
  protected String linkedSoftlayerAccount;
  @SerializedName("team_directory_enabled")
  protected Boolean teamDirectoryEnabled;
  protected AccountResponseTraits traits;

  protected AccountResponse() { }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the owner.
   *
   * @return the owner
   */
  public String getOwner() {
    return owner;
  }

  /**
   * Gets the ownerUserid.
   *
   * @return the ownerUserid
   */
  public String getOwnerUserid() {
    return ownerUserid;
  }

  /**
   * Gets the ownerIamid.
   *
   * @return the ownerIamid
   */
  public String getOwnerIamid() {
    return ownerIamid;
  }

  /**
   * Gets the type.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the status.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the linkedSoftlayerAccount.
   *
   * @return the linkedSoftlayerAccount
   */
  public String getLinkedSoftlayerAccount() {
    return linkedSoftlayerAccount;
  }

  /**
   * Gets the teamDirectoryEnabled.
   *
   * @return the teamDirectoryEnabled
   */
  public Boolean isTeamDirectoryEnabled() {
    return teamDirectoryEnabled;
  }

  /**
   * Gets the traits.
   *
   * @return the traits
   */
  public AccountResponseTraits getTraits() {
    return traits;
  }
}

