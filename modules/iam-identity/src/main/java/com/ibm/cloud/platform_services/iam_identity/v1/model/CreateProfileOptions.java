/*
 * (C) Copyright IBM Corp. 2021.
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
package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createProfile options.
 */
public class CreateProfileOptions extends GenericModel {

  protected String name;
  protected String accountId;
  protected String description;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String accountId;
    private String description;

    private Builder(CreateProfileOptions createProfileOptions) {
      this.name = createProfileOptions.name;
      this.accountId = createProfileOptions.accountId;
      this.description = createProfileOptions.description;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     * @param accountId the accountId
     */
    public Builder(String name, String accountId) {
      this.name = name;
      this.accountId = accountId;
    }

    /**
     * Builds a CreateProfileOptions.
     *
     * @return the new CreateProfileOptions instance
     */
    public CreateProfileOptions build() {
      return new CreateProfileOptions(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateProfileOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreateProfileOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateProfileOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }
  }

  protected CreateProfileOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    name = builder.name;
    accountId = builder.accountId;
    description = builder.description;
  }

  /**
   * New builder.
   *
   * @return a CreateProfileOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * Name of the trusted profile. The name is checked for uniqueness. Therefore trusted profiles with the same names can
   * not exist in the same account.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the accountId.
   *
   * The account ID of the trusted profile.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the description.
   *
   * The optional description of the trusted profile. The 'description' property is only available if a description was
   * provided during creation of trusted profile.
   *
   * @return the description
   */
  public String description() {
    return description;
  }
}

