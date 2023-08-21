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
package com.ibm.cloud.platform_services.usage_reports.v4.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Period of billing in snapshot.
 */
public class SnapshotListSnapshotsItemBillingPeriod extends GenericModel {

  protected String start;
  protected String end;

  protected SnapshotListSnapshotsItemBillingPeriod() { }

  /**
   * Gets the start.
   *
   * Date and time of start of billing in the respective snapshot.
   *
   * @return the start
   */
  public String getStart() {
    return start;
  }

  /**
   * Gets the end.
   *
   * Date and time of end of billing in the respective snapshot.
   *
   * @return the end
   */
  public String getEnd() {
    return end;
  }
}

