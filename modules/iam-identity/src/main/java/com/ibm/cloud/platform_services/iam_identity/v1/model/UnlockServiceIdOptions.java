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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The unlockServiceId options.
 */
public class UnlockServiceIdOptions extends GenericModel {

  protected String id;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;

    /**
     * Instantiates a new Builder from an existing UnlockServiceIdOptions instance.
     *
     * @param unlockServiceIdOptions the instance to initialize the Builder with
     */
    private Builder(UnlockServiceIdOptions unlockServiceIdOptions) {
      this.id = unlockServiceIdOptions.id;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param id the id
     */
    public Builder(String id) {
      this.id = id;
    }

    /**
     * Builds a UnlockServiceIdOptions.
     *
     * @return the new UnlockServiceIdOptions instance
     */
    public UnlockServiceIdOptions build() {
      return new UnlockServiceIdOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the UnlockServiceIdOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }
  }

  protected UnlockServiceIdOptions() { }

  protected UnlockServiceIdOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    id = builder.id;
  }

  /**
   * New builder.
   *
   * @return a UnlockServiceIdOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * Unique ID of the service ID.
   *
   * @return the id
   */
  public String id() {
    return id;
  }
}

