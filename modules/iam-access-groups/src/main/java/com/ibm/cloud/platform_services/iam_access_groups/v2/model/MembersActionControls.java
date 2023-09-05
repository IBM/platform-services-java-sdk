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
 * Control whether or not access group administrators in child accounts can add and remove members from the
 * enterprise-managed access group in their account.
 */
public class MembersActionControls extends GenericModel {

  protected Boolean add;
  protected Boolean remove;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean add;
    private Boolean remove;

    /**
     * Instantiates a new Builder from an existing MembersActionControls instance.
     *
     * @param membersActionControls the instance to initialize the Builder with
     */
    private Builder(MembersActionControls membersActionControls) {
      this.add = membersActionControls.add;
      this.remove = membersActionControls.remove;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a MembersActionControls.
     *
     * @return the new MembersActionControls instance
     */
    public MembersActionControls build() {
      return new MembersActionControls(this);
    }

    /**
     * Set the add.
     *
     * @param add the add
     * @return the MembersActionControls builder
     */
    public Builder add(Boolean add) {
      this.add = add;
      return this;
    }

    /**
     * Set the remove.
     *
     * @param remove the remove
     * @return the MembersActionControls builder
     */
    public Builder remove(Boolean remove) {
      this.remove = remove;
      return this;
    }
  }

  protected MembersActionControls() { }

  protected MembersActionControls(Builder builder) {
    add = builder.add;
    remove = builder.remove;
  }

  /**
   * New builder.
   *
   * @return a MembersActionControls builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the add.
   *
   * Action control for adding child account members to an enterprise-managed access group. If an access group
   * administrator in a child account adds a member, they can always remove them. Note that if conflicts arise between
   * an update to this control in a new version and members added by an administrator in the child account, you must
   * resolve those conflicts in the child account. This prevents breaking access in the child account. For more
   * information, see [Working with versions]
   * (https://test.cloud.ibm.com/docs/secure-enterprise?topic=secure-enterprise-working-with-versions#new-version-scenarios).
   *
   * @return the add
   */
  public Boolean add() {
    return add;
  }

  /**
   * Gets the remove.
   *
   * Action control for removing enterprise-managed members from an enterprise-managed access group. Note that if an
   * enterprise member is removed from an enterprise-managed access group in a child account and you reassign the
   * template, the membership is reinstated.
   *
   * @return the remove
   */
  public Boolean remove() {
    return remove;
  }
}

