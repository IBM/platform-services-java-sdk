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
 * SnapshotListSnapshotsItemReportTypesItem.
 */
public class SnapshotListSnapshotsItemReportTypesItem extends GenericModel {

  /**
   * The type of billing report of the snapshot. Possible values are [account_summary, enterprise_summary,
   * account_resource_instance_usage].
   */
  public interface Type {
    /** account_summary. */
    String ACCOUNT_SUMMARY = "account_summary";
    /** enterprise_summary. */
    String ENTERPRISE_SUMMARY = "enterprise_summary";
    /** account_resource_instance_usage. */
    String ACCOUNT_RESOURCE_INSTANCE_USAGE = "account_resource_instance_usage";
  }

  protected String type;
  protected String version;

  protected SnapshotListSnapshotsItemReportTypesItem() { }

  /**
   * Gets the type.
   *
   * The type of billing report of the snapshot. Possible values are [account_summary, enterprise_summary,
   * account_resource_instance_usage].
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the version.
   *
   * Version of the snapshot.
   *
   * @return the version
   */
  public String getVersion() {
    return version;
  }
}

