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
 * SnapshotConfigHistoryItem.
 */
public class SnapshotConfigHistoryItem extends GenericModel {

  /**
   * Status of the billing snapshot configuration. Possible values are [enabled, disabled].
   */
  public interface State {
    /** enabled. */
    String ENABLED = "enabled";
    /** disabled. */
    String DISABLED = "disabled";
  }

  /**
   * Type of account. Possible values [enterprise, account].
   */
  public interface AccountType {
    /** account. */
    String ACCOUNT = "account";
    /** enterprise. */
    String ENTERPRISE = "enterprise";
  }

  /**
   * Frequency of taking the snapshot of the billing reports.
   */
  public interface Interval {
    /** daily. */
    String DAILY = "daily";
  }

  /**
   * A new version of report is created or the existing report version is overwritten with every update.
   */
  public interface Versioning {
    /** new. */
    String X_NEW = "new";
    /** overwrite. */
    String OVERWRITE = "overwrite";
  }

  public interface ReportTypes {
    /** account_summary. */
    String ACCOUNT_SUMMARY = "account_summary";
    /** enterprise_summary. */
    String ENTERPRISE_SUMMARY = "enterprise_summary";
    /** account_resource_instance_usage. */
    String ACCOUNT_RESOURCE_INSTANCE_USAGE = "account_resource_instance_usage";
  }

  @SerializedName("start_time")
  protected Double startTime;
  @SerializedName("end_time")
  protected Double endTime;
  @SerializedName("updated_by")
  protected String updatedBy;
  @SerializedName("account_id")
  protected String accountId;
  protected String state;
  @SerializedName("account_type")
  protected String accountType;
  protected String interval;
  protected String versioning;
  @SerializedName("report_types")
  protected List<String> reportTypes;
  protected String compression;
  @SerializedName("content_type")
  protected String contentType;
  @SerializedName("cos_reports_folder")
  protected String cosReportsFolder;
  @SerializedName("cos_bucket")
  protected String cosBucket;
  @SerializedName("cos_location")
  protected String cosLocation;
  @SerializedName("cos_endpoint")
  protected String cosEndpoint;

  protected SnapshotConfigHistoryItem() { }

  /**
   * Gets the startTime.
   *
   * Timestamp in milliseconds when the snapshot configuration was created.
   *
   * @return the startTime
   */
  public Double getStartTime() {
    return startTime;
  }

  /**
   * Gets the endTime.
   *
   * Timestamp in milliseconds when the snapshot configuration ends.
   *
   * @return the endTime
   */
  public Double getEndTime() {
    return endTime;
  }

  /**
   * Gets the updatedBy.
   *
   * Account that updated the billing snapshot configuration.
   *
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

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
   * Gets the accountType.
   *
   * Type of account. Possible values [enterprise, account].
   *
   * @return the accountType
   */
  public String getAccountType() {
    return accountType;
  }

  /**
   * Gets the interval.
   *
   * Frequency of taking the snapshot of the billing reports.
   *
   * @return the interval
   */
  public String getInterval() {
    return interval;
  }

  /**
   * Gets the versioning.
   *
   * A new version of report is created or the existing report version is overwritten with every update.
   *
   * @return the versioning
   */
  public String getVersioning() {
    return versioning;
  }

  /**
   * Gets the reportTypes.
   *
   * The type of billing reports to take snapshot of. Possible values are [account_summary, enterprise_summary,
   * account_resource_instance_usage].
   *
   * @return the reportTypes
   */
  public List<String> getReportTypes() {
    return reportTypes;
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
   * Gets the cosReportsFolder.
   *
   * The billing reports root folder to store the billing reports snapshots. Defaults to "IBMCloud-Billing-Reports".
   *
   * @return the cosReportsFolder
   */
  public String getCosReportsFolder() {
    return cosReportsFolder;
  }

  /**
   * Gets the cosBucket.
   *
   * The name of the COS bucket to store the snapshot of the billing reports.
   *
   * @return the cosBucket
   */
  public String getCosBucket() {
    return cosBucket;
  }

  /**
   * Gets the cosLocation.
   *
   * Region of the COS instance.
   *
   * @return the cosLocation
   */
  public String getCosLocation() {
    return cosLocation;
  }

  /**
   * Gets the cosEndpoint.
   *
   * The endpoint of the COS instance.
   *
   * @return the cosEndpoint
   */
  public String getCosEndpoint() {
    return cosEndpoint;
  }
}

