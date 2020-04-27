/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.cloud.platform_services.enterprise_management.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The create account request completed successfully.
 */
public class CreateAccountResponse extends GenericModel {

  @SerializedName("account_group_id")
  protected String accountGroupId;

  /**
   * Gets the accountGroupId.
   *
   * The ID of the account group entity that was created.
   *
   * @return the accountGroupId
   */
  public String getAccountGroupId() {
    return accountGroupId;
  }
}

