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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Object containing details of a resource list with target account ID.
 */
public class ResourceListWithTargetAccountID extends GenericModel {

  protected String target;
  protected AssignmentResourceAccessGroup group;
  @SerializedName("policy_template_references")
  protected List<AssignmentResourceEntry> policyTemplateReferences;

  protected ResourceListWithTargetAccountID() { }

  /**
   * Gets the target.
   *
   * The ID of the entity that the resource list applies to.
   *
   * @return the target
   */
  public String getTarget() {
    return target;
  }

  /**
   * Gets the group.
   *
   * Assignment Resource Access Group.
   *
   * @return the group
   */
  public AssignmentResourceAccessGroup getGroup() {
    return group;
  }

  /**
   * Gets the policyTemplateReferences.
   *
   * List of policy template references for the resource list.
   *
   * @return the policyTemplateReferences
   */
  public List<AssignmentResourceEntry> getPolicyTemplateReferences() {
    return policyTemplateReferences;
  }
}

