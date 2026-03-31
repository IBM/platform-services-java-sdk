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

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Usage count for API keys per identity.
 */
public class IdentityLimitsUsageResponseApikeysPerIdentity extends GenericModel {

  protected Long limit;
  protected List<IdentityCount> identities;

  protected IdentityLimitsUsageResponseApikeysPerIdentity() { }

  /**
   * Gets the limit.
   *
   * Maximum allowed API keys per identity.
   *
   * @return the limit
   */
  public Long getLimit() {
    return limit;
  }

  /**
   * Gets the identities.
   *
   * List of identities with their API key usage counts.
   *
   * @return the identities
   */
  public List<IdentityCount> getIdentities() {
    return identities;
  }
}

