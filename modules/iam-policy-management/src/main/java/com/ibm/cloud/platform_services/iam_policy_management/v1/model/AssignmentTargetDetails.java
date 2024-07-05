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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * assignment target account and type.
 */
public class AssignmentTargetDetails extends GenericModel {

  /**
   * Assignment target type.
   */
  public interface Type {
    /** Account. */
    String ACCOUNT = "Account";
  }

  protected String type;
  protected String id;

  /**
   * Builder.
   */
  public static class Builder {
    private String type;
    private String id;

    /**
     * Instantiates a new Builder from an existing AssignmentTargetDetails instance.
     *
     * @param assignmentTargetDetails the instance to initialize the Builder with
     */
    private Builder(AssignmentTargetDetails assignmentTargetDetails) {
      this.type = assignmentTargetDetails.type;
      this.id = assignmentTargetDetails.id;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a AssignmentTargetDetails.
     *
     * @return the new AssignmentTargetDetails instance
     */
    public AssignmentTargetDetails build() {
      return new AssignmentTargetDetails(this);
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the AssignmentTargetDetails builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the AssignmentTargetDetails builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }
  }

  protected AssignmentTargetDetails() { }

  protected AssignmentTargetDetails(Builder builder) {
    type = builder.type;
    id = builder.id;
  }

  /**
   * New builder.
   *
   * @return a AssignmentTargetDetails builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the type.
   *
   * Assignment target type.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the id.
   *
   * ID of the target account.
   *
   * @return the id
   */
  public String id() {
    return id;
  }
}

