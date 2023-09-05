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
 * Response body format for an entity history record.
 */
public class EnityHistoryRecord extends GenericModel {

  protected String timestamp;
  @SerializedName("iam_id")
  protected String iamId;
  @SerializedName("iam_id_account")
  protected String iamIdAccount;
  protected String action;
  protected List<String> params;
  protected String message;

  protected EnityHistoryRecord() { }

  /**
   * Gets the timestamp.
   *
   * Timestamp when the action was triggered.
   *
   * @return the timestamp
   */
  public String getTimestamp() {
    return timestamp;
  }

  /**
   * Gets the iamId.
   *
   * IAM ID of the identity which triggered the action.
   *
   * @return the iamId
   */
  public String getIamId() {
    return iamId;
  }

  /**
   * Gets the iamIdAccount.
   *
   * Account of the identity which triggered the action.
   *
   * @return the iamIdAccount
   */
  public String getIamIdAccount() {
    return iamIdAccount;
  }

  /**
   * Gets the action.
   *
   * Action of the history entry.
   *
   * @return the action
   */
  public String getAction() {
    return action;
  }

  /**
   * Gets the params.
   *
   * Params of the history entry.
   *
   * @return the params
   */
  public List<String> getParams() {
    return params;
  }

  /**
   * Gets the message.
   *
   * Message which summarizes the executed action.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }
}

