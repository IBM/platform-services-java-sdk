/*
 * (C) Copyright IBM Corp. 2021.
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
package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The deleteVersion options.
 */
public class DeleteVersionOptions extends GenericModel {

  protected String versionLocId;

  /**
   * Builder.
   */
  public static class Builder {
    private String versionLocId;

    private Builder(DeleteVersionOptions deleteVersionOptions) {
      this.versionLocId = deleteVersionOptions.versionLocId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param versionLocId the versionLocId
     */
    public Builder(String versionLocId) {
      this.versionLocId = versionLocId;
    }

    /**
     * Builds a DeleteVersionOptions.
     *
     * @return the new DeleteVersionOptions instance
     */
    public DeleteVersionOptions build() {
      return new DeleteVersionOptions(this);
    }

    /**
     * Set the versionLocId.
     *
     * @param versionLocId the versionLocId
     * @return the DeleteVersionOptions builder
     */
    public Builder versionLocId(String versionLocId) {
      this.versionLocId = versionLocId;
      return this;
    }
  }

  protected DeleteVersionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.versionLocId,
      "versionLocId cannot be empty");
    versionLocId = builder.versionLocId;
  }

  /**
   * New builder.
   *
   * @return a DeleteVersionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the versionLocId.
   *
   * A dotted value of `catalogID`.`versionID`.
   *
   * @return the versionLocId
   */
  public String versionLocId() {
    return versionLocId;
  }
}

