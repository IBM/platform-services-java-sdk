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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Access Group Component.
 */
public class AccessGroupResponse extends GenericModel {

  protected String name;
  protected String description;
  protected Members members;
  protected Assertions assertions;
  @SerializedName("action_controls")
  protected GroupActionControls actionControls;

  protected AccessGroupResponse() { }

  /**
   * Gets the name.
   *
   * Give the access group a unique name that doesn't conflict with other templates access group name in the given
   * account. This is shown in child accounts.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * Access group description. This is shown in child accounts.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the members.
   *
   * Array of enterprise users to add to the template. All enterprise users that you add to the template must be invited
   * to the child accounts where the template is assigned.
   *
   * @return the members
   */
  public Members getMembers() {
    return members;
  }

  /**
   * Gets the assertions.
   *
   * Assertions Input Component.
   *
   * @return the assertions
   */
  public Assertions getAssertions() {
    return assertions;
  }

  /**
   * Gets the actionControls.
   *
   * Access group action controls component.
   *
   * @return the actionControls
   */
  public GroupActionControls getActionControls() {
    return actionControls;
  }
}

