/*
 * (C) Copyright IBM Corp. 2025.
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
 * The createServiceIdGroup options.
 */
public class CreateServiceIdGroupOptions extends GenericModel {

  protected String accountId;
  protected String name;
  protected String description;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String name;
    private String description;

    /**
     * Instantiates a new Builder from an existing CreateServiceIdGroupOptions instance.
     *
     * @param createServiceIdGroupOptions the instance to initialize the Builder with
     */
    private Builder(CreateServiceIdGroupOptions createServiceIdGroupOptions) {
      this.accountId = createServiceIdGroupOptions.accountId;
      this.name = createServiceIdGroupOptions.name;
      this.description = createServiceIdGroupOptions.description;
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
     * @param name the name
     */
    public Builder(String accountId, String name) {
      this.accountId = accountId;
      this.name = name;
    }

    /**
     * Builds a CreateServiceIdGroupOptions.
     *
     * @return the new CreateServiceIdGroupOptions instance
     */
    public CreateServiceIdGroupOptions build() {
      return new CreateServiceIdGroupOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreateServiceIdGroupOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateServiceIdGroupOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateServiceIdGroupOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }
  }

  protected CreateServiceIdGroupOptions() { }

  protected CreateServiceIdGroupOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    accountId = builder.accountId;
    name = builder.name;
    description = builder.description;
  }

  /**
   * New builder.
   *
   * @return a CreateServiceIdGroupOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * ID of the account the service ID group belongs to.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the name.
   *
   * Name of the service ID group. Unique in the account.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * Description of the service ID group.
   *
   * @return the description
   */
  public String description() {
    return description;
  }
}

