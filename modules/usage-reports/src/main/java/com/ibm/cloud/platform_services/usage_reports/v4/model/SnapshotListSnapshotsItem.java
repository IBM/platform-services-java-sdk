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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Snapshot Schema.
 */
public class SnapshotListSnapshotsItem extends GenericModel {

  /**
   * Type of account. Possible values are [enterprise, account].
   */
  public interface AccountType {
    /** account. */
    String ACCOUNT = "account";
    /** enterprise. */
    String ENTERPRISE = "enterprise";
  }

  /**
   * Status of the billing snapshot configuration. Possible values are [enabled, disabled].
   */
  public interface State {
    /** enabled. */
    String ENABLED = "enabled";
    /** disabled. */
    String DISABLED = "disabled";
  }

  @SerializedName("account_id")
  protected String accountId;
  protected String month;
  @SerializedName("account_type")
  protected String accountType;
  @SerializedName("expected_processed_at")
  protected Double expectedProcessedAt;
  protected String state;
  @SerializedName("billing_period")
  protected SnapshotListSnapshotsItemBillingPeriod billingPeriod;
  @SerializedName("snapshot_id")
  protected String snapshotId;
  protected String charset;
  protected String compression;
  @SerializedName("content_type")
  protected String contentType;
  protected String bucket;
  protected String version;
  @SerializedName("created_on")
  protected String createdOn;
  @SerializedName("report_types")
  protected List<SnapshotListSnapshotsItemReportTypesItem> reportTypes;
  protected List<SnapshotListSnapshotsItemFilesItem> files;
  @SerializedName("processed_at")
  protected Double processedAt;

  protected SnapshotListSnapshotsItem() { }

  /**
   * Gets the accountId.
   *
   * Account ID for which billing report snapshot is configured.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the month.
   *
   * Month of captured snapshot.
   *
   * @return the month
   */
  public String getMonth() {
    return month;
  }

  /**
   * Gets the accountType.
   *
   * Type of account. Possible values are [enterprise, account].
   *
   * @return the accountType
   */
  public String getAccountType() {
    return accountType;
  }

  /**
   * Gets the expectedProcessedAt.
   *
   * Timestamp of snapshot processed.
   *
   * @return the expectedProcessedAt
   */
  public Double getExpectedProcessedAt() {
    return expectedProcessedAt;
  }

  /**
   * Gets the state.
   *
   * Status of the billing snapshot configuration. Possible values are [enabled, disabled].
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Gets the billingPeriod.
   *
   * Period of billing in snapshot.
   *
   * @return the billingPeriod
   */
  public SnapshotListSnapshotsItemBillingPeriod getBillingPeriod() {
    return billingPeriod;
  }

  /**
   * Gets the snapshotId.
   *
   * Id of the snapshot captured.
   *
   * @return the snapshotId
   */
  public String getSnapshotId() {
    return snapshotId;
  }

  /**
   * Gets the charset.
   *
   * Character encoding used.
   *
   * @return the charset
   */
  public String getCharset() {
    return charset;
  }

  /**
   * Gets the compression.
   *
   * Compression format of the snapshot report.
   *
   * @return the compression
   */
  public String getCompression() {
    return compression;
  }

  /**
   * Gets the contentType.
   *
   * Type of content stored in snapshot report.
   *
   * @return the contentType
   */
  public String getContentType() {
    return contentType;
  }

  /**
   * Gets the bucket.
   *
   * The name of the COS bucket to store the snapshot of the billing reports.
   *
   * @return the bucket
   */
  public String getBucket() {
    return bucket;
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

  /**
   * Gets the createdOn.
   *
   * Date and time of creation of snapshot.
   *
   * @return the createdOn
   */
  public String getCreatedOn() {
    return createdOn;
  }

  /**
   * Gets the reportTypes.
   *
   * List of report types configured for the snapshot.
   *
   * @return the reportTypes
   */
  public List<SnapshotListSnapshotsItemReportTypesItem> getReportTypes() {
    return reportTypes;
  }

  /**
   * Gets the files.
   *
   * List of location of reports.
   *
   * @return the files
   */
  public List<SnapshotListSnapshotsItemFilesItem> getFiles() {
    return files;
  }

  /**
   * Gets the processedAt.
   *
   * Timestamp at which snapshot is captured.
   *
   * @return the processedAt
   */
  public Double getProcessedAt() {
    return processedAt;
  }
}

