/*
 * (C) Copyright IBM Corp. 2021.
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
package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Result of approval.
 */
public class ApprovalResult extends GenericModel {

  @SerializedName("allow_request")
  protected Boolean allowRequest;
  protected Boolean ibm;
  @SerializedName("public")
  protected Boolean xPublic;
  protected Boolean changed;

  /**
   * Gets the allowRequest.
   *
   * Allowed to request to publish.
   *
   * @return the allowRequest
   */
  public Boolean isAllowRequest() {
    return allowRequest;
  }

  /**
   * Gets the ibm.
   *
   * Visible to IBM.
   *
   * @return the ibm
   */
  public Boolean isIbm() {
    return ibm;
  }

  /**
   * Gets the xPublic.
   *
   * Visible to everyone.
   *
   * @return the xPublic
   */
  public Boolean isXPublic() {
    return xPublic;
  }

  /**
   * Gets the changed.
   *
   * Denotes whether approval has changed.
   *
   * @return the changed
   */
  public Boolean isChanged() {
    return changed;
  }
}

