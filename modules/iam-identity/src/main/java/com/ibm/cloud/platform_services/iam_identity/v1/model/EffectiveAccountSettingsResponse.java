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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Response body format for Account Settings REST requests.
 */
public class EffectiveAccountSettingsResponse extends GenericModel {

  protected ResponseContext context;
  @SerializedName("account_id")
  protected String accountId;
  protected AccountSettingsEffectiveSection effective;
  protected AccountSettingsAccountSection account;
  @SerializedName("assigned_templates")
  protected List<AccountSettingsAssignedTemplatesSection> assignedTemplates;

  protected EffectiveAccountSettingsResponse() { }

  /**
   * Gets the context.
   *
   * Context with key properties for problem determination.
   *
   * @return the context
   */
  public ResponseContext getContext() {
    return context;
  }

  /**
   * Gets the accountId.
   *
   * Unique ID of the account.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the effective.
   *
   * @return the effective
   */
  public AccountSettingsEffectiveSection getEffective() {
    return effective;
  }

  /**
   * Gets the account.
   *
   * @return the account
   */
  public AccountSettingsAccountSection getAccount() {
    return account;
  }

  /**
   * Gets the assignedTemplates.
   *
   * assigned template section.
   *
   * @return the assignedTemplates
   */
  public List<AccountSettingsAssignedTemplatesSection> getAssignedTemplates() {
    return assignedTemplates;
  }
}

