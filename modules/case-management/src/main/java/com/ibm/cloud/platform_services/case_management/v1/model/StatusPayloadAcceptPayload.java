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
package com.ibm.cloud.platform_services.case_management.v1.model;

/**
 * StatusPayloadAcceptPayload.
 */
public class StatusPayloadAcceptPayload extends StatusPayload {

  /**
   * action to perform on the case.
   */
  public interface Action {
    /** resolve. */
    String RESOLVE = "resolve";
    /** unresolve. */
    String UNRESOLVE = "unresolve";
    /** accept. */
    String ACCEPT = "accept";
  }


  /**
   * Builder.
   */
  public static class Builder {
    private String action;
    private String comment;

    public Builder(StatusPayload statusPayloadAcceptPayload) {
      this.action = statusPayloadAcceptPayload.action;
      this.comment = statusPayloadAcceptPayload.comment;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param action the action
     */
    public Builder(String action) {
      this.action = action;
    }

    /**
     * Builds a StatusPayloadAcceptPayload.
     *
     * @return the new StatusPayloadAcceptPayload instance
     */
    public StatusPayloadAcceptPayload build() {
      return new StatusPayloadAcceptPayload(this);
    }

    /**
     * Set the action.
     *
     * @param action the action
     * @return the StatusPayloadAcceptPayload builder
     */
    public Builder action(String action) {
      this.action = action;
      return this;
    }

    /**
     * Set the comment.
     *
     * @param comment the comment
     * @return the StatusPayloadAcceptPayload builder
     */
    public Builder comment(String comment) {
      this.comment = comment;
      return this;
    }
  }

  protected StatusPayloadAcceptPayload(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.action,
      "action cannot be null");
    action = builder.action;
    comment = builder.comment;
  }

  /**
   * New builder.
   *
   * @return a StatusPayloadAcceptPayload builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

