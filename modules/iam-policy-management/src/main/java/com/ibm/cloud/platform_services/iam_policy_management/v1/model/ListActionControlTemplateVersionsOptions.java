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
 * The listActionControlTemplateVersions options.
 */
public class ListActionControlTemplateVersionsOptions extends GenericModel {

  /**
   * Action control template state.
   */
  public interface State {
    /** active. */
    String ACTIVE = "active";
    /** deleted. */
    String DELETED = "deleted";
  }

  protected String actionControlTemplateId;
  protected String state;
  protected Long limit;
  protected String start;

  /**
   * Builder.
   */
  public static class Builder {
    private String actionControlTemplateId;
    private String state;
    private Long limit;
    private String start;

    /**
     * Instantiates a new Builder from an existing ListActionControlTemplateVersionsOptions instance.
     *
     * @param listActionControlTemplateVersionsOptions the instance to initialize the Builder with
     */
    private Builder(ListActionControlTemplateVersionsOptions listActionControlTemplateVersionsOptions) {
      this.actionControlTemplateId = listActionControlTemplateVersionsOptions.actionControlTemplateId;
      this.state = listActionControlTemplateVersionsOptions.state;
      this.limit = listActionControlTemplateVersionsOptions.limit;
      this.start = listActionControlTemplateVersionsOptions.start;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param actionControlTemplateId the actionControlTemplateId
     */
    public Builder(String actionControlTemplateId) {
      this.actionControlTemplateId = actionControlTemplateId;
    }

    /**
     * Builds a ListActionControlTemplateVersionsOptions.
     *
     * @return the new ListActionControlTemplateVersionsOptions instance
     */
    public ListActionControlTemplateVersionsOptions build() {
      return new ListActionControlTemplateVersionsOptions(this);
    }

    /**
     * Set the actionControlTemplateId.
     *
     * @param actionControlTemplateId the actionControlTemplateId
     * @return the ListActionControlTemplateVersionsOptions builder
     */
    public Builder actionControlTemplateId(String actionControlTemplateId) {
      this.actionControlTemplateId = actionControlTemplateId;
      return this;
    }

    /**
     * Set the state.
     *
     * @param state the state
     * @return the ListActionControlTemplateVersionsOptions builder
     */
    public Builder state(String state) {
      this.state = state;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListActionControlTemplateVersionsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the start.
     *
     * @param start the start
     * @return the ListActionControlTemplateVersionsOptions builder
     */
    public Builder start(String start) {
      this.start = start;
      return this;
    }
  }

  protected ListActionControlTemplateVersionsOptions() { }

  protected ListActionControlTemplateVersionsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.actionControlTemplateId,
      "actionControlTemplateId cannot be empty");
    actionControlTemplateId = builder.actionControlTemplateId;
    state = builder.state;
    limit = builder.limit;
    start = builder.start;
  }

  /**
   * New builder.
   *
   * @return a ListActionControlTemplateVersionsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the actionControlTemplateId.
   *
   * The action control template ID.
   *
   * @return the actionControlTemplateId
   */
  public String actionControlTemplateId() {
    return actionControlTemplateId;
  }

  /**
   * Gets the state.
   *
   * Action control template state.
   *
   * @return the state
   */
  public String state() {
    return state;
  }

  /**
   * Gets the limit.
   *
   * The number of documents to include in the collection.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the start.
   *
   * Page token that refers to the page of the collection to return.
   *
   * @return the start
   */
  public String start() {
    return start;
  }
}

