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
package com.ibm.cloud.platform_services.enterprise_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createAccount options.
 */
public class CreateAccountOptions extends GenericModel {

  protected String parent;
  protected String name;
  protected String ownerIamId;

  /**
   * Builder.
   */
  public static class Builder {
    private String parent;
    private String name;
    private String ownerIamId;

    private Builder(CreateAccountOptions createAccountOptions) {
      this.parent = createAccountOptions.parent;
      this.name = createAccountOptions.name;
      this.ownerIamId = createAccountOptions.ownerIamId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param parent the parent
     * @param name the name
     * @param ownerIamId the ownerIamId
     */
    public Builder(String parent, String name, String ownerIamId) {
      this.parent = parent;
      this.name = name;
      this.ownerIamId = ownerIamId;
    }

    /**
     * Builds a CreateAccountOptions.
     *
     * @return the new CreateAccountOptions instance
     */
    public CreateAccountOptions build() {
      return new CreateAccountOptions(this);
    }

    /**
     * Set the parent.
     *
     * @param parent the parent
     * @return the CreateAccountOptions builder
     */
    public Builder parent(String parent) {
      this.parent = parent;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateAccountOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the ownerIamId.
     *
     * @param ownerIamId the ownerIamId
     * @return the CreateAccountOptions builder
     */
    public Builder ownerIamId(String ownerIamId) {
      this.ownerIamId = ownerIamId;
      return this;
    }
  }

  protected CreateAccountOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.parent,
      "parent cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ownerIamId,
      "ownerIamId cannot be null");
    parent = builder.parent;
    name = builder.name;
    ownerIamId = builder.ownerIamId;
  }

  /**
   * New builder.
   *
   * @return a CreateAccountOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the parent.
   *
   * The CRN of the parent under which the account will be created. The parent can be an existing account group or the
   * enterprise itself.
   *
   * @return the parent
   */
  public String parent() {
    return parent;
  }

  /**
   * Gets the name.
   *
   * The name of the account. This field must have 3 - 60 characters.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the ownerIamId.
   *
   * The IAM ID of the account owner, such as `IBMid-0123ABC`. The IAM ID must already exist.
   *
   * @return the ownerIamId
   */
  public String ownerIamId() {
    return ownerIamId;
  }
}

