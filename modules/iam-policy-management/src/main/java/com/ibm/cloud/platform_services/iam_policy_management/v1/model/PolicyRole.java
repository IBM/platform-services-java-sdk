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

package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A role associated with a policy.
 */
public class PolicyRole extends GenericModel {

  @SerializedName("role_id")
  protected String roleId;
  @SerializedName("display_name")
  protected String displayName;
  protected String description;

  /**
   * Builder.
   */
  public static class Builder {
    private String roleId;

    /**
     * Instantiates a new Builder from an existing PolicyRole instance.
     *
     * @param policyRole the instance to initialize the Builder with
     */
    private Builder(PolicyRole policyRole) {
      this.roleId = policyRole.roleId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param roleId the roleId
     */
    public Builder(String roleId) {
      this.roleId = roleId;
    }

    /**
     * Builds a PolicyRole.
     *
     * @return the new PolicyRole instance
     */
    public PolicyRole build() {
      return new PolicyRole(this);
    }

    /**
     * Set the roleId.
     *
     * @param roleId the roleId
     * @return the PolicyRole builder
     */
    public Builder roleId(String roleId) {
      this.roleId = roleId;
      return this;
    }
  }

  protected PolicyRole() { }

  protected PolicyRole(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.roleId,
      "roleId cannot be null");
    roleId = builder.roleId;
  }

  /**
   * New builder.
   *
   * @return a PolicyRole builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the roleId.
   *
   * The role Cloud Resource Name (CRN) granted by the policy. Example CRN: 'crn:v1:bluemix:public:iam::::role:Editor'.
   *
   * @return the roleId
   */
  public String roleId() {
    return roleId;
  }

  /**
   * Gets the displayName.
   *
   * The display name of the role.
   *
   * @return the displayName
   */
  public String displayName() {
    return displayName;
  }

  /**
   * Gets the description.
   *
   * The description of the role.
   *
   * @return the description
   */
  public String description() {
    return description;
  }
}

