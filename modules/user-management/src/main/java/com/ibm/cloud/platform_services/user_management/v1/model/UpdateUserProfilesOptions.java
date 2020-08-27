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
 * The updateUserProfiles options.
 */
public class UpdateUserProfilesOptions extends GenericModel {

  protected String accountId;
  protected String iamId;
  protected String firstname;
  protected String lastname;
  protected String state;
  protected String email;
  protected String phonenumber;
  protected String altphonenumber;
  protected String photo;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String iamId;
    private String firstname;
    private String lastname;
    private String state;
    private String email;
    private String phonenumber;
    private String altphonenumber;
    private String photo;

    private Builder(UpdateUserProfilesOptions updateUserProfilesOptions) {
      this.accountId = updateUserProfilesOptions.accountId;
      this.iamId = updateUserProfilesOptions.iamId;
      this.firstname = updateUserProfilesOptions.firstname;
      this.lastname = updateUserProfilesOptions.lastname;
      this.state = updateUserProfilesOptions.state;
      this.email = updateUserProfilesOptions.email;
      this.phonenumber = updateUserProfilesOptions.phonenumber;
      this.altphonenumber = updateUserProfilesOptions.altphonenumber;
      this.photo = updateUserProfilesOptions.photo;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param accountId the accountId
     * @param iamId the iamId
     */
    public Builder(String accountId, String iamId) {
      this.accountId = accountId;
      this.iamId = iamId;
    }

    /**
     * Builds a UpdateUserProfilesOptions.
     *
     * @return the new UpdateUserProfilesOptions instance
     */
    public UpdateUserProfilesOptions build() {
      return new UpdateUserProfilesOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the UpdateUserProfilesOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the iamId.
     *
     * @param iamId the iamId
     * @return the UpdateUserProfilesOptions builder
     */
    public Builder iamId(String iamId) {
      this.iamId = iamId;
      return this;
    }

    /**
     * Set the firstname.
     *
     * @param firstname the firstname
     * @return the UpdateUserProfilesOptions builder
     */
    public Builder firstname(String firstname) {
      this.firstname = firstname;
      return this;
    }

    /**
     * Set the lastname.
     *
     * @param lastname the lastname
     * @return the UpdateUserProfilesOptions builder
     */
    public Builder lastname(String lastname) {
      this.lastname = lastname;
      return this;
    }

    /**
     * Set the state.
     *
     * @param state the state
     * @return the UpdateUserProfilesOptions builder
     */
    public Builder state(String state) {
      this.state = state;
      return this;
    }

    /**
     * Set the email.
     *
     * @param email the email
     * @return the UpdateUserProfilesOptions builder
     */
    public Builder email(String email) {
      this.email = email;
      return this;
    }

    /**
     * Set the phonenumber.
     *
     * @param phonenumber the phonenumber
     * @return the UpdateUserProfilesOptions builder
     */
    public Builder phonenumber(String phonenumber) {
      this.phonenumber = phonenumber;
      return this;
    }

    /**
     * Set the altphonenumber.
     *
     * @param altphonenumber the altphonenumber
     * @return the UpdateUserProfilesOptions builder
     */
    public Builder altphonenumber(String altphonenumber) {
      this.altphonenumber = altphonenumber;
      return this;
    }

    /**
     * Set the photo.
     *
     * @param photo the photo
     * @return the UpdateUserProfilesOptions builder
     */
    public Builder photo(String photo) {
      this.photo = photo;
      return this;
    }
  }

  protected UpdateUserProfilesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.iamId,
      "iamId cannot be empty");
    accountId = builder.accountId;
    iamId = builder.iamId;
    firstname = builder.firstname;
    lastname = builder.lastname;
    state = builder.state;
    email = builder.email;
    phonenumber = builder.phonenumber;
    altphonenumber = builder.altphonenumber;
    photo = builder.photo;
  }

  /**
   * New builder.
   *
   * @return a UpdateUserProfilesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * The account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the iamId.
   *
   * The user's IAM ID.
   *
   * @return the iamId
   */
  public String iamId() {
    return iamId;
  }

  /**
   * Gets the firstname.
   *
   * The first name of the user.
   *
   * @return the firstname
   */
  public String firstname() {
    return firstname;
  }

  /**
   * Gets the lastname.
   *
   * The last name of the user.
   *
   * @return the lastname
   */
  public String lastname() {
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
  public String state() {
    return state;
  }

  /**
   * Gets the email.
   *
   * The email address of the user.
   *
   * @return the email
   */
  public String email() {
    return email;
  }

  /**
   * Gets the phonenumber.
   *
   * The phone number of the user.
   *
   * @return the phonenumber
   */
  public String phonenumber() {
    return phonenumber;
  }

  /**
   * Gets the altphonenumber.
   *
   * The alternative phone number of the user.
   *
   * @return the altphonenumber
   */
  public String altphonenumber() {
    return altphonenumber;
  }

  /**
   * Gets the photo.
   *
   * A link to a photo of the user.
   *
   * @return the photo
   */
  public String photo() {
    return photo;
  }
}

