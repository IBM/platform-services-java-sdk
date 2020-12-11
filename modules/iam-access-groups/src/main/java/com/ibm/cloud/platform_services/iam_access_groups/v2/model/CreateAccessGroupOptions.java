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
package com.ibm.cloud.platform_services.iam_access_groups.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createAccessGroup options.
 */
public class CreateAccessGroupOptions extends GenericModel {

  protected String accountId;
  protected String name;
  protected String description;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String name;
    private String description;
    private String transactionId;

    private Builder(CreateAccessGroupOptions createAccessGroupOptions) {
      this.accountId = createAccessGroupOptions.accountId;
      this.name = createAccessGroupOptions.name;
      this.description = createAccessGroupOptions.description;
      this.transactionId = createAccessGroupOptions.transactionId;
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
     * Builds a CreateAccessGroupOptions.
     *
     * @return the new CreateAccessGroupOptions instance
     */
    public CreateAccessGroupOptions build() {
      return new CreateAccessGroupOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreateAccessGroupOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateAccessGroupOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateAccessGroupOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the CreateAccessGroupOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected CreateAccessGroupOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    accountId = builder.accountId;
    name = builder.name;
    description = builder.description;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a CreateAccessGroupOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * IBM Cloud account identifier.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the name.
   *
   * Assign the specified name to the Access Group. This field has a limit of 100 characters.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * Assign a description for the Access Group. This field has a limit of 250 characters.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the transactionId.
   *
   * An optional transaction id for the request.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }
}

