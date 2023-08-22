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
package com.ibm.cloud.platform_services.iam_access_groups.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Access group action controls component.
 */
public class GroupActionControls extends GenericModel {

  protected AccessActionControls access;

  /**
   * Builder.
   */
  public static class Builder {
    private AccessActionControls access;

    /**
     * Instantiates a new Builder from an existing GroupActionControls instance.
     *
     * @param groupActionControls the instance to initialize the Builder with
     */
    private Builder(GroupActionControls groupActionControls) {
      this.access = groupActionControls.access;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a GroupActionControls.
     *
     * @return the new GroupActionControls instance
     */
    public GroupActionControls build() {
      return new GroupActionControls(this);
    }

    /**
     * Set the access.
     *
     * @param access the access
     * @return the GroupActionControls builder
     */
    public Builder access(AccessActionControls access) {
      this.access = access;
      return this;
    }
  }

  protected GroupActionControls() { }

  protected GroupActionControls(Builder builder) {
    access = builder.access;
  }

  /**
   * New builder.
   *
   * @return a GroupActionControls builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the access.
   *
   * Control whether or not access group administrators in child accounts can add access policies to the
   * enterprise-managed access group in their account.
   *
   * @return the access
   */
  public AccessActionControls access() {
    return access;
  }
}

