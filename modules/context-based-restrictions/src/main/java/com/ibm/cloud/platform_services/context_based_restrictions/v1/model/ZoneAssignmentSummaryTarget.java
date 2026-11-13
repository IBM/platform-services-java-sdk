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

package com.ibm.cloud.platform_services.context_based_restrictions.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The enterprise target entity.
 */
public class ZoneAssignmentSummaryTarget extends GenericModel {

  /**
   * The type of the enterprise target.
   */
  public interface Type {
    /** Account. */
    String ACCOUNT = "Account";
    /** AccountGroup. */
    String ACCOUNTGROUP = "AccountGroup";
    /** Enterprise. */
    String ENTERPRISE = "Enterprise";
  }

  protected String type;
  protected String id;

  protected ZoneAssignmentSummaryTarget() { }

  /**
   * Gets the type.
   *
   * The type of the enterprise target.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the id.
   *
   * The ID of the enterprise target entity.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }
}

