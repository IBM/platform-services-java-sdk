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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The details of the IAM template that was used to create an enterprise-managed policy in your account. When returned,
 * this indicates that the policy is created from and managed by a template in the root enterprise account.
 */
public class TemplateMetadata extends GenericModel {

  protected String id;
  protected String version;
  @SerializedName("assignment_id")
  protected String assignmentId;
  @SerializedName("root_id")
  protected String rootId;
  @SerializedName("root_version")
  protected String rootVersion;

  protected TemplateMetadata() { }

  /**
   * Gets the id.
   *
   * The policy template ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the version.
   *
   * Template version.
   *
   * @return the version
   */
  public String getVersion() {
    return version;
  }

  /**
   * Gets the assignmentId.
   *
   * policy assignment id.
   *
   * @return the assignmentId
   */
  public String getAssignmentId() {
    return assignmentId;
  }

  /**
   * Gets the rootId.
   *
   * orchestrator template id.
   *
   * @return the rootId
   */
  public String getRootId() {
    return rootId;
  }

  /**
   * Gets the rootVersion.
   *
   * orchestrator template version.
   *
   * @return the rootVersion
   */
  public String getRootVersion() {
    return rootVersion;
  }
}

