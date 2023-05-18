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
package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listPolicyTemplateVerssions options.
 */
public class ListPolicyTemplateVerssionsOptions extends GenericModel {

  protected String policyTemplateId;

  /**
   * Builder.
   */
  public static class Builder {
    private String policyTemplateId;

    /**
     * Instantiates a new Builder from an existing ListPolicyTemplateVerssionsOptions instance.
     *
     * @param listPolicyTemplateVerssionsOptions the instance to initialize the Builder with
     */
    private Builder(ListPolicyTemplateVerssionsOptions listPolicyTemplateVerssionsOptions) {
      this.policyTemplateId = listPolicyTemplateVerssionsOptions.policyTemplateId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param policyTemplateId the policyTemplateId
     */
    public Builder(String policyTemplateId) {
      this.policyTemplateId = policyTemplateId;
    }

    /**
     * Builds a ListPolicyTemplateVerssionsOptions.
     *
     * @return the new ListPolicyTemplateVerssionsOptions instance
     */
    public ListPolicyTemplateVerssionsOptions build() {
      return new ListPolicyTemplateVerssionsOptions(this);
    }

    /**
     * Set the policyTemplateId.
     *
     * @param policyTemplateId the policyTemplateId
     * @return the ListPolicyTemplateVerssionsOptions builder
     */
    public Builder policyTemplateId(String policyTemplateId) {
      this.policyTemplateId = policyTemplateId;
      return this;
    }
  }

  protected ListPolicyTemplateVerssionsOptions() { }

  protected ListPolicyTemplateVerssionsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.policyTemplateId,
      "policyTemplateId cannot be empty");
    policyTemplateId = builder.policyTemplateId;
  }

  /**
   * New builder.
   *
   * @return a ListPolicyTemplateVerssionsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the policyTemplateId.
   *
   * The policy template ID.
   *
   * @return the policyTemplateId
   */
  public String policyTemplateId() {
    return policyTemplateId;
  }
}

