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
 * Control whether or not access group administrators in child accounts can add access policies to the
 * enterprise-managed access group in their account.
 */
public class AccessActionControls extends GenericModel {

  protected Boolean add;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean add;

    /**
     * Instantiates a new Builder from an existing AccessActionControls instance.
     *
     * @param accessActionControls the instance to initialize the Builder with
     */
    private Builder(AccessActionControls accessActionControls) {
      this.add = accessActionControls.add;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a AccessActionControls.
     *
     * @return the new AccessActionControls instance
     */
    public AccessActionControls build() {
      return new AccessActionControls(this);
    }

    /**
     * Set the add.
     *
     * @param add the add
     * @return the AccessActionControls builder
     */
    public Builder add(Boolean add) {
      this.add = add;
      return this;
    }
  }

  protected AccessActionControls() { }

  protected AccessActionControls(Builder builder) {
    add = builder.add;
  }

  /**
   * New builder.
   *
   * @return a AccessActionControls builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the add.
   *
   * Action control for adding access policies to an enterprise-managed access group in a child account. If an access
   * group administrator in a child account adds a policy, they can always update or remove it. Note that if conflicts
   * arise between an update to this control in a new version and polices added to the access group by an administrator
   * in a child account, you must resolve those conflicts in the child account. This prevents breaking access in the
   * child account. For more information, see [Working with
   * versions](https://test.cloud.ibm.com/docs/secure-enterprise?topic=secure-enterprise-working-with-versions#new-version-scenarios).
   *
   * @return the add
   */
  public Boolean add() {
    return add;
  }
}

