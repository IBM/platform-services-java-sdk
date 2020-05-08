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
package com.ibm.cloud.platform_services.global_catalog.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Information related to the provider associated with a catalog entry.
 */
public class Provider extends GenericModel {

  protected String email;
  protected String name;
  protected String contact;
  @SerializedName("support_email")
  protected String supportEmail;
  protected String phone;

  /**
   * Builder.
   */
  public static class Builder {
    private String email;
    private String name;
    private String contact;
    private String supportEmail;
    private String phone;

    private Builder(Provider provider) {
      this.email = provider.email;
      this.name = provider.name;
      this.contact = provider.contact;
      this.supportEmail = provider.supportEmail;
      this.phone = provider.phone;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param email the email
     * @param name the name
     */
    public Builder(String email, String name) {
      this.email = email;
      this.name = name;
    }

    /**
     * Builds a Provider.
     *
     * @return the new Provider instance
     */
    public Provider build() {
      return new Provider(this);
    }

    /**
     * Set the email.
     *
     * @param email the email
     * @return the Provider builder
     */
    public Builder email(String email) {
      this.email = email;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the Provider builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the contact.
     *
     * @param contact the contact
     * @return the Provider builder
     */
    public Builder contact(String contact) {
      this.contact = contact;
      return this;
    }

    /**
     * Set the supportEmail.
     *
     * @param supportEmail the supportEmail
     * @return the Provider builder
     */
    public Builder supportEmail(String supportEmail) {
      this.supportEmail = supportEmail;
      return this;
    }

    /**
     * Set the phone.
     *
     * @param phone the phone
     * @return the Provider builder
     */
    public Builder phone(String phone) {
      this.phone = phone;
      return this;
    }
  }

  protected Provider(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.email,
      "email cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    email = builder.email;
    name = builder.name;
    contact = builder.contact;
    supportEmail = builder.supportEmail;
    phone = builder.phone;
  }

  /**
   * New builder.
   *
   * @return a Provider builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the email.
   *
   * Provider's email address for this catalog entry.
   *
   * @return the email
   */
  public String email() {
    return email;
  }

  /**
   * Gets the name.
   *
   * Provider's name, for example, IBM.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the contact.
   *
   * Provider's contact name.
   *
   * @return the contact
   */
  public String contact() {
    return contact;
  }

  /**
   * Gets the supportEmail.
   *
   * Provider's support email.
   *
   * @return the supportEmail
   */
  public String supportEmail() {
    return supportEmail;
  }

  /**
   * Gets the phone.
   *
   * Provider's contact phone.
   *
   * @return the phone
   */
  public String phone() {
    return phone;
  }
}

