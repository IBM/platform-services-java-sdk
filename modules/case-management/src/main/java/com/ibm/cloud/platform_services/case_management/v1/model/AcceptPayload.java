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
 * Payload to accept the proposed resolution of the case.
 */
public class AcceptPayload extends StatusPayload {

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

    public Builder(StatusPayload acceptPayload) {
      this.action = acceptPayload.action;
      this.comment = acceptPayload.comment;
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
     * Builds a AcceptPayload.
     *
     * @return the new AcceptPayload instance
     */
    public AcceptPayload build() {
      return new AcceptPayload(this);
    }

    /**
     * Set the action.
     *
     * @param action the action
     * @return the AcceptPayload builder
     */
    public Builder action(String action) {
      this.action = action;
      return this;
    }

    /**
     * Set the comment.
     *
     * @param comment the comment
     * @return the AcceptPayload builder
     */
    public Builder comment(String comment) {
      this.comment = comment;
      return this;
    }
  }

  protected AcceptPayload(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.action,
      "action cannot be null");
    action = builder.action;
    comment = builder.comment;
  }

  /**
   * New builder.
   *
   * @return a AcceptPayload builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

