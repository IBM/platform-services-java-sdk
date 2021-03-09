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
package com.ibm.cloud.platform_services.posture_management.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Scope.
 */
public class Scope extends GenericModel {

  /**
   * The environment that the scope is targeted to.
   */
  public interface EnvironmentType {
    /** ibm. */
    String IBM = "ibm";
    /** aws. */
    String AWS = "aws";
    /** azure. */
    String AZURE = "azure";
    /** on_premise. */
    String ON_PREMISE = "on_premise";
    /** hosted. */
    String HOSTED = "hosted";
    /** services. */
    String SERVICES = "services";
    /** openstack. */
    String OPENSTACK = "openstack";
    /** gcp. */
    String GCP = "gcp";
  }

  /**
   * The last type of scan that was run on the scope.
   */
  public interface LastScanType {
    /** discovery. */
    String DISCOVERY = "discovery";
    /** validation. */
    String VALIDATION = "validation";
    /** fact_collection. */
    String FACT_COLLECTION = "fact_collection";
    /** fact_validation. */
    String FACT_VALIDATION = "fact_validation";
    /** inventory. */
    String INVENTORY = "inventory";
    /** remediation. */
    String REMEDIATION = "remediation";
    /** abort_tasks. */
    String ABORT_TASKS = "abort_tasks";
    /** evidence. */
    String EVIDENCE = "evidence";
    /** script. */
    String SCRIPT = "script";
  }

  protected String description;
  @SerializedName("created_by")
  protected String createdBy;
  @SerializedName("modified_by")
  protected String modifiedBy;
  @SerializedName("scope_id")
  protected Long scopeId;
  protected String name;
  protected Boolean enabled;
  @SerializedName("environment_type")
  protected String environmentType;
  @SerializedName("created_time")
  protected String createdTime;
  @SerializedName("modified_time")
  protected String modifiedTime;
  @SerializedName("last_scan_type")
  protected String lastScanType;
  @SerializedName("last_scan_type_description")
  protected String lastScanTypeDescription;
  @SerializedName("last_scan_status_updated_time")
  protected String lastScanStatusUpdatedTime;
  @SerializedName("collectors_id")
  protected List<Long> collectorsId;
  protected List<Scan> scans;

  /**
   * Gets the description.
   *
   * A detailed description of the scope.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the createdBy.
   *
   * The user who created the scope.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the modifiedBy.
   *
   * The user who most recently modified the scope.
   *
   * @return the modifiedBy
   */
  public String getModifiedBy() {
    return modifiedBy;
  }

  /**
   * Gets the scopeId.
   *
   * An auto-generated unique identifier for the scope.
   *
   * @return the scopeId
   */
  public Long getScopeId() {
    return scopeId;
  }

  /**
   * Gets the name.
   *
   * A unique name for your scope.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the enabled.
   *
   * Indicates whether scope is enabled/disabled.
   *
   * @return the enabled
   */
  public Boolean isEnabled() {
    return enabled;
  }

  /**
   * Gets the environmentType.
   *
   * The environment that the scope is targeted to.
   *
   * @return the environmentType
   */
  public String getEnvironmentType() {
    return environmentType;
  }

  /**
   * Gets the createdTime.
   *
   * The time that the scope was created in UTC.
   *
   * @return the createdTime
   */
  public String getCreatedTime() {
    return createdTime;
  }

  /**
   * Gets the modifiedTime.
   *
   * The time that the scope was last modified in UTC.
   *
   * @return the modifiedTime
   */
  public String getModifiedTime() {
    return modifiedTime;
  }

  /**
   * Gets the lastScanType.
   *
   * The last type of scan that was run on the scope.
   *
   * @return the lastScanType
   */
  public String getLastScanType() {
    return lastScanType;
  }

  /**
   * Gets the lastScanTypeDescription.
   *
   * A description of the last scan type.
   *
   * @return the lastScanTypeDescription
   */
  public String getLastScanTypeDescription() {
    return lastScanTypeDescription;
  }

  /**
   * Gets the lastScanStatusUpdatedTime.
   *
   * The last time that a scan status for a scope was updated in UTC.
   *
   * @return the lastScanStatusUpdatedTime
   */
  public String getLastScanStatusUpdatedTime() {
    return lastScanStatusUpdatedTime;
  }

  /**
   * Gets the collectorsId.
   *
   * The unique IDs of the collectors that are attached to the scope.
   *
   * @return the collectorsId
   */
  public List<Long> getCollectorsId() {
    return collectorsId;
  }

  /**
   * Gets the scans.
   *
   * A list of the scans that have been run on the scope.
   *
   * @return the scans
   */
  public List<Scan> getScans() {
    return scans;
  }
}

