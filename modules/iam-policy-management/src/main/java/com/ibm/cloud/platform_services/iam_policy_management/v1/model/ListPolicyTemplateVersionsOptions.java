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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listPolicyTemplateVersions options.
 */
public class ListPolicyTemplateVersionsOptions extends GenericModel {

  /**
   * The policy template state.
   */
  public interface State {
    /** active. */
    String ACTIVE = "active";
    /** deleted. */
    String DELETED = "deleted";
  }

  protected String policyTemplateId;
  protected String state;
  protected Long limit;
  protected String start;

  /**
   * Builder.
   */
  public static class Builder {
    private String policyTemplateId;
    private String state;
    private Long limit;
    private String start;

    /**
     * Instantiates a new Builder from an existing ListPolicyTemplateVersionsOptions instance.
     *
     * @param listPolicyTemplateVersionsOptions the instance to initialize the Builder with
     */
    private Builder(ListPolicyTemplateVersionsOptions listPolicyTemplateVersionsOptions) {
      this.policyTemplateId = listPolicyTemplateVersionsOptions.policyTemplateId;
      this.state = listPolicyTemplateVersionsOptions.state;
      this.limit = listPolicyTemplateVersionsOptions.limit;
      this.start = listPolicyTemplateVersionsOptions.start;
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
     * Builds a ListPolicyTemplateVersionsOptions.
     *
     * @return the new ListPolicyTemplateVersionsOptions instance
     */
    public ListPolicyTemplateVersionsOptions build() {
      return new ListPolicyTemplateVersionsOptions(this);
    }

    /**
     * Set the policyTemplateId.
     *
     * @param policyTemplateId the policyTemplateId
     * @return the ListPolicyTemplateVersionsOptions builder
     */
    public Builder policyTemplateId(String policyTemplateId) {
      this.policyTemplateId = policyTemplateId;
      return this;
    }

    /**
     * Set the state.
     *
     * @param state the state
     * @return the ListPolicyTemplateVersionsOptions builder
     */
    public Builder state(String state) {
      this.state = state;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListPolicyTemplateVersionsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the start.
     *
     * @param start the start
     * @return the ListPolicyTemplateVersionsOptions builder
     */
    public Builder start(String start) {
      this.start = start;
      return this;
    }
  }

  protected ListPolicyTemplateVersionsOptions() { }

  protected ListPolicyTemplateVersionsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.policyTemplateId,
      "policyTemplateId cannot be empty");
    policyTemplateId = builder.policyTemplateId;
    state = builder.state;
    limit = builder.limit;
    start = builder.start;
  }

  /**
   * New builder.
   *
   * @return a ListPolicyTemplateVersionsOptions builder
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

  /**
   * Gets the state.
   *
   * The policy template state.
   *
   * @return the state
   */
  public String state() {
    return state;
  }

  /**
   * Gets the limit.
   *
   * The number of documents to include in collection.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the start.
   *
   * Page token that refers to the page of collection to return.
   *
   * @return the start
   */
  public String start() {
    return start;
  }
}

