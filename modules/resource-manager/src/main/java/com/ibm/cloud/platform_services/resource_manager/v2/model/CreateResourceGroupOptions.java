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
package com.ibm.cloud.platform_services.resource_manager.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createResourceGroup options.
 */
public class CreateResourceGroupOptions extends GenericModel {

  protected String name;
  protected String accountId;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String accountId;

    private Builder(CreateResourceGroupOptions createResourceGroupOptions) {
      this.name = createResourceGroupOptions.name;
      this.accountId = createResourceGroupOptions.accountId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a CreateResourceGroupOptions.
     *
     * @return the new CreateResourceGroupOptions instance
     */
    public CreateResourceGroupOptions build() {
      return new CreateResourceGroupOptions(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateResourceGroupOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreateResourceGroupOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }
  }

  protected CreateResourceGroupOptions(Builder builder) {
    name = builder.name;
    accountId = builder.accountId;
  }

  /**
   * New builder.
   *
   * @return a CreateResourceGroupOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * The new name of the resource group.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the accountId.
   *
   * The account id of the resource group.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }
}

