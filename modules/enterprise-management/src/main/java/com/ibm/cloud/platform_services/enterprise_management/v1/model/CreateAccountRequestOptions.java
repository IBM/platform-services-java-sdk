/*
 * (C) Copyright IBM Corp. 2024.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The options object can be used to set properties on child accounts of an enterprise. You can pass a field to to
 * create IAM service id with IAM api key when creating a child account in the enterprise. This is an optional field.
 */
public class CreateAccountRequestOptions extends GenericModel {

  @SerializedName("create_iam_service_id_with_apikey_and_owner_policies")
  protected Boolean createIamServiceIdWithApikeyAndOwnerPolicies;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean createIamServiceIdWithApikeyAndOwnerPolicies;

    /**
     * Instantiates a new Builder from an existing CreateAccountRequestOptions instance.
     *
     * @param createAccountRequestOptions the instance to initialize the Builder with
     */
    private Builder(CreateAccountRequestOptions createAccountRequestOptions) {
      this.createIamServiceIdWithApikeyAndOwnerPolicies = createAccountRequestOptions.createIamServiceIdWithApikeyAndOwnerPolicies;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a CreateAccountRequestOptions.
     *
     * @return the new CreateAccountRequestOptions instance
     */
    public CreateAccountRequestOptions build() {
      return new CreateAccountRequestOptions(this);
    }

    /**
     * Set the createIamServiceIdWithApikeyAndOwnerPolicies.
     *
     * @param createIamServiceIdWithApikeyAndOwnerPolicies the createIamServiceIdWithApikeyAndOwnerPolicies
     * @return the CreateAccountRequestOptions builder
     */
    public Builder createIamServiceIdWithApikeyAndOwnerPolicies(Boolean createIamServiceIdWithApikeyAndOwnerPolicies) {
      this.createIamServiceIdWithApikeyAndOwnerPolicies = createIamServiceIdWithApikeyAndOwnerPolicies;
      return this;
    }
  }

  protected CreateAccountRequestOptions() { }

  protected CreateAccountRequestOptions(Builder builder) {
    createIamServiceIdWithApikeyAndOwnerPolicies = builder.createIamServiceIdWithApikeyAndOwnerPolicies;
  }

  /**
   * New builder.
   *
   * @return a CreateAccountRequestOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the createIamServiceIdWithApikeyAndOwnerPolicies.
   *
   * By default create_iam_service_id_with_apikey_and_owner_policies is turned off for a newly created child account.
   * You can enable this property by passing 'true' in this boolean field. IAM service id has account owner IAM policies
   * and the API key associated with it can generate a token and setup resources in the account. This is an optional
   * field.
   *
   * @return the createIamServiceIdWithApikeyAndOwnerPolicies
   */
  public Boolean createIamServiceIdWithApikeyAndOwnerPolicies() {
    return createIamServiceIdWithApikeyAndOwnerPolicies;
  }
}

