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
 * subject details of access type assignment.
 */
public class PolicyAssignmentV1Subject extends GenericModel {

  public interface Type {
    /** iam_id. */
    String IAM_ID = "iam_id";
    /** access_group_id. */
    String ACCESS_GROUP_ID = "access_group_id";
  }

  protected String id;
  protected String type;

  protected PolicyAssignmentV1Subject() { }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the type.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }
}

