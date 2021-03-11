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
package com.ibm.cloud.platform_services.resource_controller.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The runReclamationAction options.
 */
public class RunReclamationActionOptions extends GenericModel {

  protected String id;
  protected String actionName;
  protected String requestBy;
  protected String comment;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String actionName;
    private String requestBy;
    private String comment;

    private Builder(RunReclamationActionOptions runReclamationActionOptions) {
      this.id = runReclamationActionOptions.id;
      this.actionName = runReclamationActionOptions.actionName;
      this.requestBy = runReclamationActionOptions.requestBy;
      this.comment = runReclamationActionOptions.comment;
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
     * @param actionName the actionName
     */
    public Builder(String id, String actionName) {
      this.id = id;
      this.actionName = actionName;
    }

    /**
     * Builds a RunReclamationActionOptions.
     *
     * @return the new RunReclamationActionOptions instance
     */
    public RunReclamationActionOptions build() {
      return new RunReclamationActionOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the RunReclamationActionOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the actionName.
     *
     * @param actionName the actionName
     * @return the RunReclamationActionOptions builder
     */
    public Builder actionName(String actionName) {
      this.actionName = actionName;
      return this;
    }

    /**
     * Set the requestBy.
     *
     * @param requestBy the requestBy
     * @return the RunReclamationActionOptions builder
     */
    public Builder requestBy(String requestBy) {
      this.requestBy = requestBy;
      return this;
    }

    /**
     * Set the comment.
     *
     * @param comment the comment
     * @return the RunReclamationActionOptions builder
     */
    public Builder comment(String comment) {
      this.comment = comment;
      return this;
    }
  }

  protected RunReclamationActionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.actionName,
      "actionName cannot be empty");
    id = builder.id;
    actionName = builder.actionName;
    requestBy = builder.requestBy;
    comment = builder.comment;
  }

  /**
   * New builder.
   *
   * @return a RunReclamationActionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The ID associated with the reclamation.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the actionName.
   *
   * The reclamation action name. Specify `reclaim` to delete a resource, or `restore` to restore a resource.
   *
   * @return the actionName
   */
  public String actionName() {
    return actionName;
  }

  /**
   * Gets the requestBy.
   *
   * The request initiator, if different from the request token.
   *
   * @return the requestBy
   */
  public String requestBy() {
    return requestBy;
  }

  /**
   * Gets the comment.
   *
   * A comment to describe the action.
   *
   * @return the comment
   */
  public String comment() {
    return comment;
  }
}

