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
 * StatusPayloadResolvePayload.
 */
public class StatusPayloadResolvePayload extends StatusPayload {

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
    private Long resolutionCode;

    public Builder(StatusPayload statusPayloadResolvePayload) {
      this.action = statusPayloadResolvePayload.action;
      this.comment = statusPayloadResolvePayload.comment;
      this.resolutionCode = statusPayloadResolvePayload.resolutionCode;
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
     * @param resolutionCode the resolutionCode
     */
    public Builder(String action, Long resolutionCode) {
      this.action = action;
      this.resolutionCode = resolutionCode;
    }

    /**
     * Builds a StatusPayloadResolvePayload.
     *
     * @return the new StatusPayloadResolvePayload instance
     */
    public StatusPayloadResolvePayload build() {
      return new StatusPayloadResolvePayload(this);
    }

    /**
     * Set the action.
     *
     * @param action the action
     * @return the StatusPayloadResolvePayload builder
     */
    public Builder action(String action) {
      this.action = action;
      return this;
    }

    /**
     * Set the comment.
     *
     * @param comment the comment
     * @return the StatusPayloadResolvePayload builder
     */
    public Builder comment(String comment) {
      this.comment = comment;
      return this;
    }

    /**
     * Set the resolutionCode.
     *
     * @param resolutionCode the resolutionCode
     * @return the StatusPayloadResolvePayload builder
     */
    public Builder resolutionCode(long resolutionCode) {
      this.resolutionCode = resolutionCode;
      return this;
    }
  }

  protected StatusPayloadResolvePayload(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.action,
      "action cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.resolutionCode,
      "resolutionCode cannot be null");
    action = builder.action;
    comment = builder.comment;
    resolutionCode = builder.resolutionCode;
  }

  /**
   * New builder.
   *
   * @return a StatusPayloadResolvePayload builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

