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
package com.ibm.cloud.platform_services.enterprise_management.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A newly-created account.
 */
public class CreateAccountResponse extends GenericModel {

  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("iam_service_id")
  protected String iamServiceId;
  @SerializedName("iam_apikey_id")
  protected String iamApikeyId;
  @SerializedName("iam_apikey")
  protected String iamApikey;

  protected CreateAccountResponse() { }

  /**
   * Gets the accountId.
   *
   * The ID of the account entity that was created.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the iamServiceId.
   *
   * The iam_service_id of the account entity that was created.
   *
   * @return the iamServiceId
   */
  public String getIamServiceId() {
    return iamServiceId;
  }

  /**
   * Gets the iamApikeyId.
   *
   * The iam_apikey_id of the account entity that was created.
   *
   * @return the iamApikeyId
   */
  public String getIamApikeyId() {
    return iamApikeyId;
  }

  /**
   * Gets the iamApikey.
   *
   * The iam_apikey of the account entity with owner iam policies that was created.
   *
   * @return the iamApikey
   */
  public String getIamApikey() {
    return iamApikey;
  }
}

