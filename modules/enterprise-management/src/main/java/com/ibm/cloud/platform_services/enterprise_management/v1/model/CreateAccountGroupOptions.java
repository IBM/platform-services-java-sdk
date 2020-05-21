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
 * The createAccountGroup options.
 */
public class CreateAccountGroupOptions extends GenericModel {

  protected String parent;
  protected String name;
  protected String primaryContactIamId;

  /**
   * Builder.
   */
  public static class Builder {
    private String parent;
    private String name;
    private String primaryContactIamId;

    private Builder(CreateAccountGroupOptions createAccountGroupOptions) {
      this.parent = createAccountGroupOptions.parent;
      this.name = createAccountGroupOptions.name;
      this.primaryContactIamId = createAccountGroupOptions.primaryContactIamId;
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
     * @param primaryContactIamId the primaryContactIamId
     */
    public Builder(String parent, String name, String primaryContactIamId) {
      this.parent = parent;
      this.name = name;
      this.primaryContactIamId = primaryContactIamId;
    }

    /**
     * Builds a CreateAccountGroupOptions.
     *
     * @return the new CreateAccountGroupOptions instance
     */
    public CreateAccountGroupOptions build() {
      return new CreateAccountGroupOptions(this);
    }

    /**
     * Set the parent.
     *
     * @param parent the parent
     * @return the CreateAccountGroupOptions builder
     */
    public Builder parent(String parent) {
      this.parent = parent;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateAccountGroupOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the primaryContactIamId.
     *
     * @param primaryContactIamId the primaryContactIamId
     * @return the CreateAccountGroupOptions builder
     */
    public Builder primaryContactIamId(String primaryContactIamId) {
      this.primaryContactIamId = primaryContactIamId;
      return this;
    }
  }

  protected CreateAccountGroupOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.parent,
      "parent cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.primaryContactIamId,
      "primaryContactIamId cannot be null");
    parent = builder.parent;
    name = builder.name;
    primaryContactIamId = builder.primaryContactIamId;
  }

  /**
   * New builder.
   *
   * @return a CreateAccountGroupOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the parent.
   *
   * The CRN of the parent under which the account group will be created. The parent can be an existing account group or
   * the enterprise itself.
   *
   * @return the parent
   */
  public String parent() {
    return parent;
  }

  /**
   * Gets the name.
   *
   * The name of the account group. This field must have 3 - 60 characters.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the primaryContactIamId.
   *
   * The IAM ID of the primary contact for this account group, such as `IBMid-0123ABC`. The IAM ID must already exist.
   *
   * @return the primaryContactIamId
   */
  public String primaryContactIamId() {
    return primaryContactIamId;
  }
}

