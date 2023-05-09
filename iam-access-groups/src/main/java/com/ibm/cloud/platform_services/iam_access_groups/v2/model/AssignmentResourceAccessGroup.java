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

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Assignment Resource Access Group.
 */
public class AssignmentResourceAccessGroup extends GenericModel {

  protected AssignmentResourceEntry group;
  protected List<AssignmentResourceEntry> members;
  protected List<AssignmentResourceEntry> rules;

  protected AssignmentResourceAccessGroup() { }

  /**
   * Gets the group.
   *
   * Assignment resource entry.
   *
   * @return the group
   */
  public AssignmentResourceEntry getGroup() {
    return group;
  }

  /**
   * Gets the members.
   *
   * List of member resources of the group.
   *
   * @return the members
   */
  public List<AssignmentResourceEntry> getMembers() {
    return members;
  }

  /**
   * Gets the rules.
   *
   * List of rules associated with the group.
   *
   * @return the rules
   */
  public List<AssignmentResourceEntry> getRules() {
    return rules;
  }
}

