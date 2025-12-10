/*
 * (C) Copyright IBM Corp. 2025.
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

package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Update to how external accounts can interact in relation to the requested account.
 */
public class ExternalAccountIdentityInteractionPatch extends GenericModel {

  @SerializedName("identity_types")
  protected IdentityTypesPatch identityTypes;

  /**
   * Builder.
   */
  public static class Builder {
    private IdentityTypesPatch identityTypes;

    /**
     * Instantiates a new Builder from an existing ExternalAccountIdentityInteractionPatch instance.
     *
     * @param externalAccountIdentityInteractionPatch the instance to initialize the Builder with
     */
    private Builder(ExternalAccountIdentityInteractionPatch externalAccountIdentityInteractionPatch) {
      this.identityTypes = externalAccountIdentityInteractionPatch.identityTypes;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ExternalAccountIdentityInteractionPatch.
     *
     * @return the new ExternalAccountIdentityInteractionPatch instance
     */
    public ExternalAccountIdentityInteractionPatch build() {
      return new ExternalAccountIdentityInteractionPatch(this);
    }

    /**
     * Set the identityTypes.
     *
     * @param identityTypes the identityTypes
     * @return the ExternalAccountIdentityInteractionPatch builder
     */
    public Builder identityTypes(IdentityTypesPatch identityTypes) {
      this.identityTypes = identityTypes;
      return this;
    }
  }

  protected ExternalAccountIdentityInteractionPatch() { }

  protected ExternalAccountIdentityInteractionPatch(Builder builder) {
    identityTypes = builder.identityTypes;
  }

  /**
   * New builder.
   *
   * @return a ExternalAccountIdentityInteractionPatch builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the identityTypes.
   *
   * The settings to apply for each identity type for a request.
   *
   * @return the identityTypes
   */
  public IdentityTypesPatch identityTypes() {
    return identityTypes;
  }
}

