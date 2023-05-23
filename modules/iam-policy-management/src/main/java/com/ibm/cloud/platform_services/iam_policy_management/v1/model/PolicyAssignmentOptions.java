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
package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The set of properties required for a policy assignment.
 */
public class PolicyAssignmentOptions extends GenericModel {

  /**
   * The policy subject type; either 'iam_id' or 'access_group_id'.
   */
  public interface SubjectType {
    /** iam_id. */
    String IAM_ID = "iam_id";
    /** access_group_id. */
    String ACCESS_GROUP_ID = "access_group_id";
  }

  @SerializedName("subject_type")
  protected String subjectType;
  @SerializedName("subject_id")
  protected String subjectId;
  @SerializedName("root_requester_id")
  protected String rootRequesterId;
  @SerializedName("root_template_id")
  protected String rootTemplateId;
  @SerializedName("root_template_version")
  protected String rootTemplateVersion;

  protected PolicyAssignmentOptions() { }

  /**
   * Gets the subjectType.
   *
   * The policy subject type; either 'iam_id' or 'access_group_id'.
   *
   * @return the subjectType
   */
  public String getSubjectType() {
    return subjectType;
  }

  /**
   * Gets the subjectId.
   *
   * The policy subject id.
   *
   * @return the subjectId
   */
  public String getSubjectId() {
    return subjectId;
  }

  /**
   * Gets the rootRequesterId.
   *
   * The policy assignment requester id.
   *
   * @return the rootRequesterId
   */
  public String getRootRequesterId() {
    return rootRequesterId;
  }

  /**
   * Gets the rootTemplateId.
   *
   * The template id where this policy is being assigned from.
   *
   * @return the rootTemplateId
   */
  public String getRootTemplateId() {
    return rootTemplateId;
  }

  /**
   * Gets the rootTemplateVersion.
   *
   * The template version where this policy is being assigned from.
   *
   * @return the rootTemplateVersion
   */
  public String getRootTemplateVersion() {
    return rootTemplateVersion;
  }
}

