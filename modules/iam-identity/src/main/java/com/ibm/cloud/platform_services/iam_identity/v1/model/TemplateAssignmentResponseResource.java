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
package com.ibm.cloud.platform_services.iam_identity.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Overview of resources assignment per target account.
 */
public class TemplateAssignmentResponseResource extends GenericModel {

  protected String target;
  protected TemplateAssignmentResponseResourceDetail profile;
  @SerializedName("account_settings")
  protected TemplateAssignmentResponseResourceDetail accountSettings;
  @SerializedName("policy_template_refs")
  protected List<TemplateAssignmentResponseResourceDetail> policyTemplateRefs;

  protected TemplateAssignmentResponseResource() { }

  /**
   * Gets the target.
   *
   * Target account where the IAM resource is created.
   *
   * @return the target
   */
  public String getTarget() {
    return target;
  }

  /**
   * Gets the profile.
   *
   * @return the profile
   */
  public TemplateAssignmentResponseResourceDetail getProfile() {
    return profile;
  }

  /**
   * Gets the accountSettings.
   *
   * @return the accountSettings
   */
  public TemplateAssignmentResponseResourceDetail getAccountSettings() {
    return accountSettings;
  }

  /**
   * Gets the policyTemplateRefs.
   *
   * Policy resource(s) included only for trusted profile assignments with policy references.
   *
   * @return the policyTemplateRefs
   */
  public List<TemplateAssignmentResponseResourceDetail> getPolicyTemplateRefs() {
    return policyTemplateRefs;
  }
}

