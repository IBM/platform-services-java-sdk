/*
 * (C) Copyright IBM Corp. 2022.
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
package com.ibm.cloud.platform_services.context_based_restrictions.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The operations this rule applies to.
 */
public class NewRuleOperations extends GenericModel {

  @SerializedName("api_types")
  protected List<NewRuleOperationsApiTypesItem> apiTypes;

  /**
   * Builder.
   */
  public static class Builder {
    private List<NewRuleOperationsApiTypesItem> apiTypes;

    private Builder(NewRuleOperations newRuleOperations) {
      this.apiTypes = newRuleOperations.apiTypes;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param apiTypes the apiTypes
     */
    public Builder(List<NewRuleOperationsApiTypesItem> apiTypes) {
      this.apiTypes = apiTypes;
    }

    /**
     * Builds a NewRuleOperations.
     *
     * @return the new NewRuleOperations instance
     */
    public NewRuleOperations build() {
      return new NewRuleOperations(this);
    }

    /**
     * Adds an apiTypes to apiTypes.
     *
     * @param apiTypes the new apiTypes
     * @return the NewRuleOperations builder
     */
    public Builder addApiTypes(NewRuleOperationsApiTypesItem apiTypes) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(apiTypes,
        "apiTypes cannot be null");
      if (this.apiTypes == null) {
        this.apiTypes = new ArrayList<NewRuleOperationsApiTypesItem>();
      }
      this.apiTypes.add(apiTypes);
      return this;
    }

    /**
     * Set the apiTypes.
     * Existing apiTypes will be replaced.
     *
     * @param apiTypes the apiTypes
     * @return the NewRuleOperations builder
     */
    public Builder apiTypes(List<NewRuleOperationsApiTypesItem> apiTypes) {
      this.apiTypes = apiTypes;
      return this;
    }
  }

  protected NewRuleOperations() { }

  protected NewRuleOperations(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.apiTypes,
      "apiTypes cannot be null");
    apiTypes = builder.apiTypes;
  }

  /**
   * New builder.
   *
   * @return a NewRuleOperations builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the apiTypes.
   *
   * The API types this rule applies to.
   *
   * @return the apiTypes
   */
  public List<NewRuleOperationsApiTypesItem> apiTypes() {
    return apiTypes;
  }
}

