/*
 * (C) Copyright IBM Corp. 2026.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * API key count for a specific identity.
 */
public class IdentityCount extends GenericModel {

  @SerializedName("iam_id")
  protected String iamId;
  protected Long count;

  protected IdentityCount() { }

  /**
   * Gets the iamId.
   *
   * IAM identifier of the identity.
   *
   * @return the iamId
   */
  public String getIamId() {
    return iamId;
  }

  /**
   * Gets the count.
   *
   * Number of API keys for the identity.
   *
   * @return the count
   */
  public Long getCount() {
    return count;
  }
}

