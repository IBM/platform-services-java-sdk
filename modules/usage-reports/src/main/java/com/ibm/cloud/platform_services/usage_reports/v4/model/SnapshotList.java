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

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * List of billing reports snapshots.
 */
public class SnapshotList extends GenericModel {

  protected Long count;
  protected SnapshotListFirst first;
  protected SnapshotListNext next;
  protected List<SnapshotListSnapshotsItem> snapshots;

  protected SnapshotList() { }

  /**
   * Gets the count.
   *
   * Number of total snapshots.
   *
   * @return the count
   */
  public Long getCount() {
    return count;
  }

  /**
   * Gets the first.
   *
   * Reference to the first page of the search query.
   *
   * @return the first
   */
  public SnapshotListFirst getFirst() {
    return first;
  }

  /**
   * Gets the next.
   *
   * Reference to the next page of the search query if any.
   *
   * @return the next
   */
  public SnapshotListNext getNext() {
    return next;
  }

  /**
   * Gets the snapshots.
   *
   * @return the snapshots
   */
  public List<SnapshotListSnapshotsItem> getSnapshots() {
    return snapshots;
  }
}

