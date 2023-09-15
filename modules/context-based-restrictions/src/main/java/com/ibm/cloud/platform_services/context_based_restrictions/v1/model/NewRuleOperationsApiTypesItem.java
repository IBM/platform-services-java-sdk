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
package com.ibm.cloud.platform_services.context_based_restrictions.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * NewRuleOperationsApiTypesItem.
 */
public class NewRuleOperationsApiTypesItem extends GenericModel {

  @SerializedName("api_type_id")
  protected String apiTypeId;

  /**
   * Builder.
   */
  public static class Builder {
    private String apiTypeId;

    /**
     * Instantiates a new Builder from an existing NewRuleOperationsApiTypesItem instance.
     *
     * @param newRuleOperationsApiTypesItem the instance to initialize the Builder with
     */
    private Builder(NewRuleOperationsApiTypesItem newRuleOperationsApiTypesItem) {
      this.apiTypeId = newRuleOperationsApiTypesItem.apiTypeId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param apiTypeId the apiTypeId
     */
    public Builder(String apiTypeId) {
      this.apiTypeId = apiTypeId;
    }

    /**
     * Builds a NewRuleOperationsApiTypesItem.
     *
     * @return the new NewRuleOperationsApiTypesItem instance
     */
    public NewRuleOperationsApiTypesItem build() {
      return new NewRuleOperationsApiTypesItem(this);
    }

    /**
     * Set the apiTypeId.
     *
     * @param apiTypeId the apiTypeId
     * @return the NewRuleOperationsApiTypesItem builder
     */
    public Builder apiTypeId(String apiTypeId) {
      this.apiTypeId = apiTypeId;
      return this;
    }
  }

  protected NewRuleOperationsApiTypesItem() { }

  protected NewRuleOperationsApiTypesItem(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.apiTypeId,
      "apiTypeId cannot be null");
    apiTypeId = builder.apiTypeId;
  }

  /**
   * New builder.
   *
   * @return a NewRuleOperationsApiTypesItem builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the apiTypeId.
   *
   * @return the apiTypeId
   */
  public String apiTypeId() {
    return apiTypeId;
  }
}

