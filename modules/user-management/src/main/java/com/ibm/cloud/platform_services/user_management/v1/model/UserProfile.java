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
package com.ibm.cloud.platform_services.user_management.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Returned the user profile.
 */
public class UserProfile extends GenericModel {

  protected String id;
  @SerializedName("iam_id")
  protected String iamId;
  protected String realm;
  @SerializedName("user_id")
  protected String userId;
  protected String firstname;
  protected String lastname;
  protected String state;
  protected String email;
  protected String phonenumber;
  protected String altphonenumber;
  protected String photo;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("added_on")
  protected String addedOn;

  protected UserProfile() { }

  /**
   * Gets the id.
   *
   * An alphanumeric value identifying the user profile.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the iamId.
   *
   * An alphanumeric value identifying the user's IAM ID.
   *
   * @return the iamId
   */
  public String getIamId() {
    return iamId;
  }

  /**
   * Gets the realm.
   *
   * The realm of the user. The value is either `IBMid` or `SL`.
   *
   * @return the realm
   */
  public String getRealm() {
    return realm;
  }

  /**
   * Gets the userId.
   *
   * The user ID used for login.
   *
   * @return the userId
   */
  public String getUserId() {
    return userId;
  }

  /**
   * Gets the firstname.
   *
   * The first name of the user.
   *
   * @return the firstname
   */
  public String getFirstname() {
    return firstname;
  }

  /**
   * Gets the lastname.
   *
   * The last name of the user.
   *
   * @return the lastname
   */
  public String getLastname() {
    return lastname;
  }

  /**
   * Gets the state.
   *
   * The state of the user. Possible values are `PROCESSING`, `PENDING`, `ACTIVE`, `DISABLED_CLASSIC_INFRASTRUCTURE`,
   * and `VPN_ONLY`.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Gets the email.
   *
   * The email address of the user.
   *
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Gets the phonenumber.
   *
   * The phone number of the user.
   *
   * @return the phonenumber
   */
  public String getPhonenumber() {
    return phonenumber;
  }

  /**
   * Gets the altphonenumber.
   *
   * The alternative phone number of the user.
   *
   * @return the altphonenumber
   */
  public String getAltphonenumber() {
    return altphonenumber;
  }

  /**
   * Gets the photo.
   *
   * A link to a photo of the user.
   *
   * @return the photo
   */
  public String getPhoto() {
    return photo;
  }

  /**
   * Gets the accountId.
   *
   * An alphanumeric value identifying the account ID.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the addedOn.
   *
   * The timestamp for when the user was added to the account.
   *
   * @return the addedOn
   */
  public String getAddedOn() {
    return addedOn;
  }
}

