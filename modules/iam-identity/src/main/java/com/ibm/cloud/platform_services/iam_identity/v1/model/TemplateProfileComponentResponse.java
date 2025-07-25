/*
 * (C) Copyright IBM Corp. 2025.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Input body parameters for the TemplateProfileComponent.
 */
public class TemplateProfileComponentResponse extends GenericModel {

  protected String name;
  protected String description;
  protected List<TrustedProfileTemplateClaimRule> rules;
  protected String email;
  protected List<ProfileIdentityResponse> identities;

  protected TemplateProfileComponentResponse() { }

  /**
   * Gets the name.
   *
   * Name of the Profile.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * Description of the Profile.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the rules.
   *
   * Rules for the Profile.
   *
   * @return the rules
   */
  public List<TrustedProfileTemplateClaimRule> getRules() {
    return rules;
  }

  /**
   * Gets the email.
   *
   * Email of the trusted profile.
   *
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Gets the identities.
   *
   * Identities for the Profile.
   *
   * @return the identities
   */
  public List<ProfileIdentityResponse> getIdentities() {
    return identities;
  }
}

