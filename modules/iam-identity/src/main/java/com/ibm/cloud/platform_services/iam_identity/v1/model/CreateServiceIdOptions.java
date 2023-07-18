/*
 * (C) Copyright IBM Corp. 2023.
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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createServiceId options.
 */
public class CreateServiceIdOptions extends GenericModel {

  protected String accountId;
  protected String name;
  protected String description;
  protected List<String> uniqueInstanceCrns;
  protected ApiKeyInsideCreateServiceIdRequest apikey;
  protected String entityLock;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String name;
    private String description;
    private List<String> uniqueInstanceCrns;
    private ApiKeyInsideCreateServiceIdRequest apikey;
    private String entityLock;

    /**
     * Instantiates a new Builder from an existing CreateServiceIdOptions instance.
     *
     * @param createServiceIdOptions the instance to initialize the Builder with
     */
    private Builder(CreateServiceIdOptions createServiceIdOptions) {
      this.accountId = createServiceIdOptions.accountId;
      this.name = createServiceIdOptions.name;
      this.description = createServiceIdOptions.description;
      this.uniqueInstanceCrns = createServiceIdOptions.uniqueInstanceCrns;
      this.apikey = createServiceIdOptions.apikey;
      this.entityLock = createServiceIdOptions.entityLock;
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
     * Builds a CreateServiceIdOptions.
     *
     * @return the new CreateServiceIdOptions instance
     */
    public CreateServiceIdOptions build() {
      return new CreateServiceIdOptions(this);
    }

    /**
     * Adds an uniqueInstanceCrns to uniqueInstanceCrns.
     *
     * @param uniqueInstanceCrns the new uniqueInstanceCrns
     * @return the CreateServiceIdOptions builder
     */
    public Builder addUniqueInstanceCrns(String uniqueInstanceCrns) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(uniqueInstanceCrns,
        "uniqueInstanceCrns cannot be null");
      if (this.uniqueInstanceCrns == null) {
        this.uniqueInstanceCrns = new ArrayList<String>();
      }
      this.uniqueInstanceCrns.add(uniqueInstanceCrns);
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreateServiceIdOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateServiceIdOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateServiceIdOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the uniqueInstanceCrns.
     * Existing uniqueInstanceCrns will be replaced.
     *
     * @param uniqueInstanceCrns the uniqueInstanceCrns
     * @return the CreateServiceIdOptions builder
     */
    public Builder uniqueInstanceCrns(List<String> uniqueInstanceCrns) {
      this.uniqueInstanceCrns = uniqueInstanceCrns;
      return this;
    }

    /**
     * Set the apikey.
     *
     * @param apikey the apikey
     * @return the CreateServiceIdOptions builder
     */
    public Builder apikey(ApiKeyInsideCreateServiceIdRequest apikey) {
      this.apikey = apikey;
      return this;
    }

    /**
     * Set the entityLock.
     *
     * @param entityLock the entityLock
     * @return the CreateServiceIdOptions builder
     */
    public Builder entityLock(String entityLock) {
      this.entityLock = entityLock;
      return this;
    }
  }

  protected CreateServiceIdOptions() { }

  protected CreateServiceIdOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    accountId = builder.accountId;
    name = builder.name;
    description = builder.description;
    uniqueInstanceCrns = builder.uniqueInstanceCrns;
    apikey = builder.apikey;
    entityLock = builder.entityLock;
  }

  /**
   * New builder.
   *
   * @return a CreateServiceIdOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * ID of the account the service ID belongs to.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the name.
   *
   * Name of the Service Id. The name is not checked for uniqueness. Therefore multiple names with the same value can
   * exist. Access is done via the UUID of the Service Id.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * The optional description of the Service Id. The 'description' property is only available if a description was
   * provided during a create of a Service Id.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the uniqueInstanceCrns.
   *
   * Optional list of CRNs (string array) which point to the services connected to the service ID.
   *
   * @return the uniqueInstanceCrns
   */
  public List<String> uniqueInstanceCrns() {
    return uniqueInstanceCrns;
  }

  /**
   * Gets the apikey.
   *
   * Parameters for the API key in the Create service Id V1 REST request.
   *
   * @return the apikey
   */
  public ApiKeyInsideCreateServiceIdRequest apikey() {
    return apikey;
  }

  /**
   * Gets the entityLock.
   *
   * Indicates if the service ID is locked for further write operations. False by default.
   *
   * @return the entityLock
   */
  public String entityLock() {
    return entityLock;
  }
}

