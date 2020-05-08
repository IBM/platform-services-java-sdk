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
package com.ibm.cloud.platform_services.global_catalog.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Alias-related metadata.
 */
public class AliasMetaData extends GenericModel {

  protected String type;
  @SerializedName("plan_id")
  protected String planId;

  /**
   * Builder.
   */
  public static class Builder {
    private String type;
    private String planId;

    private Builder(AliasMetaData aliasMetaData) {
      this.type = aliasMetaData.type;
      this.planId = aliasMetaData.planId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a AliasMetaData.
     *
     * @return the new AliasMetaData instance
     */
    public AliasMetaData build() {
      return new AliasMetaData(this);
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the AliasMetaData builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the planId.
     *
     * @param planId the planId
     * @return the AliasMetaData builder
     */
    public Builder planId(String planId) {
      this.planId = planId;
      return this;
    }
  }

  protected AliasMetaData(Builder builder) {
    type = builder.type;
    planId = builder.planId;
  }

  /**
   * New builder.
   *
   * @return a AliasMetaData builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the type.
   *
   * Type of alias.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the planId.
   *
   * Points to the plan that this object is an alias for.
   *
   * @return the planId
   */
  public String planId() {
    return planId;
  }
}

