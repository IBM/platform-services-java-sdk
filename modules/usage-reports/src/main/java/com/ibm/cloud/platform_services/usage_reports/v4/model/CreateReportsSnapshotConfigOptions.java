/*
 * (C) Copyright IBM Corp. 2024.
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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createReportsSnapshotConfig options.
 */
public class CreateReportsSnapshotConfigOptions extends GenericModel {

  /**
   * Frequency of taking the snapshot of the billing reports.
   */
  public interface Interval {
    /** daily. */
    String DAILY = "daily";
  }

  public interface ReportTypes {
    /** account_summary. */
    String ACCOUNT_SUMMARY = "account_summary";
    /** enterprise_summary. */
    String ENTERPRISE_SUMMARY = "enterprise_summary";
    /** account_resource_instance_usage. */
    String ACCOUNT_RESOURCE_INSTANCE_USAGE = "account_resource_instance_usage";
  }

  /**
   * A new version of report is created or the existing report version is overwritten with every update. Defaults to
   * "new".
   */
  public interface Versioning {
    /** new. */
    String X_NEW = "new";
    /** overwrite. */
    String OVERWRITE = "overwrite";
  }

  protected String accountId;
  protected String interval;
  protected String cosBucket;
  protected String cosLocation;
  protected String cosReportsFolder;
  protected List<String> reportTypes;
  protected String versioning;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String interval;
    private String cosBucket;
    private String cosLocation;
    private String cosReportsFolder;
    private List<String> reportTypes;
    private String versioning;

    /**
     * Instantiates a new Builder from an existing CreateReportsSnapshotConfigOptions instance.
     *
     * @param createReportsSnapshotConfigOptions the instance to initialize the Builder with
     */
    private Builder(CreateReportsSnapshotConfigOptions createReportsSnapshotConfigOptions) {
      this.accountId = createReportsSnapshotConfigOptions.accountId;
      this.interval = createReportsSnapshotConfigOptions.interval;
      this.cosBucket = createReportsSnapshotConfigOptions.cosBucket;
      this.cosLocation = createReportsSnapshotConfigOptions.cosLocation;
      this.cosReportsFolder = createReportsSnapshotConfigOptions.cosReportsFolder;
      this.reportTypes = createReportsSnapshotConfigOptions.reportTypes;
      this.versioning = createReportsSnapshotConfigOptions.versioning;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param accountId the accountId
     * @param interval the interval
     * @param cosBucket the cosBucket
     * @param cosLocation the cosLocation
     */
    public Builder(String accountId, String interval, String cosBucket, String cosLocation) {
      this.accountId = accountId;
      this.interval = interval;
      this.cosBucket = cosBucket;
      this.cosLocation = cosLocation;
    }

    /**
     * Builds a CreateReportsSnapshotConfigOptions.
     *
     * @return the new CreateReportsSnapshotConfigOptions instance
     */
    public CreateReportsSnapshotConfigOptions build() {
      return new CreateReportsSnapshotConfigOptions(this);
    }

    /**
     * Adds a new element to reportTypes.
     *
     * @param reportTypes the new element to be added
     * @return the CreateReportsSnapshotConfigOptions builder
     */
    public Builder addReportTypes(String reportTypes) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(reportTypes,
        "reportTypes cannot be null");
      if (this.reportTypes == null) {
        this.reportTypes = new ArrayList<String>();
      }
      this.reportTypes.add(reportTypes);
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreateReportsSnapshotConfigOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the interval.
     *
     * @param interval the interval
     * @return the CreateReportsSnapshotConfigOptions builder
     */
    public Builder interval(String interval) {
      this.interval = interval;
      return this;
    }

    /**
     * Set the cosBucket.
     *
     * @param cosBucket the cosBucket
     * @return the CreateReportsSnapshotConfigOptions builder
     */
    public Builder cosBucket(String cosBucket) {
      this.cosBucket = cosBucket;
      return this;
    }

    /**
     * Set the cosLocation.
     *
     * @param cosLocation the cosLocation
     * @return the CreateReportsSnapshotConfigOptions builder
     */
    public Builder cosLocation(String cosLocation) {
      this.cosLocation = cosLocation;
      return this;
    }

    /**
     * Set the cosReportsFolder.
     *
     * @param cosReportsFolder the cosReportsFolder
     * @return the CreateReportsSnapshotConfigOptions builder
     */
    public Builder cosReportsFolder(String cosReportsFolder) {
      this.cosReportsFolder = cosReportsFolder;
      return this;
    }

    /**
     * Set the reportTypes.
     * Existing reportTypes will be replaced.
     *
     * @param reportTypes the reportTypes
     * @return the CreateReportsSnapshotConfigOptions builder
     */
    public Builder reportTypes(List<String> reportTypes) {
      this.reportTypes = reportTypes;
      return this;
    }

    /**
     * Set the versioning.
     *
     * @param versioning the versioning
     * @return the CreateReportsSnapshotConfigOptions builder
     */
    public Builder versioning(String versioning) {
      this.versioning = versioning;
      return this;
    }
  }

  protected CreateReportsSnapshotConfigOptions() { }

  protected CreateReportsSnapshotConfigOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.interval,
      "interval cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.cosBucket,
      "cosBucket cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.cosLocation,
      "cosLocation cannot be null");
    accountId = builder.accountId;
    interval = builder.interval;
    cosBucket = builder.cosBucket;
    cosLocation = builder.cosLocation;
    cosReportsFolder = builder.cosReportsFolder;
    reportTypes = builder.reportTypes;
    versioning = builder.versioning;
  }

  /**
   * New builder.
   *
   * @return a CreateReportsSnapshotConfigOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * Account ID for which billing report snapshot is configured.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the interval.
   *
   * Frequency of taking the snapshot of the billing reports.
   *
   * @return the interval
   */
  public String interval() {
    return interval;
  }

  /**
   * Gets the cosBucket.
   *
   * The name of the COS bucket to store the snapshot of the billing reports.
   *
   * @return the cosBucket
   */
  public String cosBucket() {
    return cosBucket;
  }

  /**
   * Gets the cosLocation.
   *
   * Region of the COS instance.
   *
   * @return the cosLocation
   */
  public String cosLocation() {
    return cosLocation;
  }

  /**
   * Gets the cosReportsFolder.
   *
   * The billing reports root folder to store the billing reports snapshots. Defaults to "IBMCloud-Billing-Reports".
   *
   * @return the cosReportsFolder
   */
  public String cosReportsFolder() {
    return cosReportsFolder;
  }

  /**
   * Gets the reportTypes.
   *
   * The type of billing reports to take snapshot of. Possible values are [account_summary, enterprise_summary,
   * account_resource_instance_usage].
   *
   * @return the reportTypes
   */
  public List<String> reportTypes() {
    return reportTypes;
  }

  /**
   * Gets the versioning.
   *
   * A new version of report is created or the existing report version is overwritten with every update. Defaults to
   * "new".
   *
   * @return the versioning
   */
  public String versioning() {
    return versioning;
  }
}

