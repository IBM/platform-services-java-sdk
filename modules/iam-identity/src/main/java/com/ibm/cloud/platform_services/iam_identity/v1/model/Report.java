/*
 * (C) Copyright IBM Corp. 2022.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Report.
 */
public class Report extends GenericModel {

  @SerializedName("created_by")
  protected String createdBy;
  protected String reference;
  @SerializedName("report_duration")
  protected String reportDuration;
  @SerializedName("report_start_time")
  protected String reportStartTime;
  @SerializedName("report_end_time")
  protected String reportEndTime;
  protected List<UserActivity> users;
  protected List<EntityActivity> apikeys;
  protected List<EntityActivity> serviceids;
  protected List<EntityActivity> profiles;

  /**
   * Gets the createdBy.
   *
   * IAMid of the user who triggered the report.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the reference.
   *
   * Unique reference used to generate the report.
   *
   * @return the reference
   */
  public String getReference() {
    return reference;
  }

  /**
   * Gets the reportDuration.
   *
   * Duration in hours for which the report is generated.
   *
   * @return the reportDuration
   */
  public String getReportDuration() {
    return reportDuration;
  }

  /**
   * Gets the reportStartTime.
   *
   * Start time of the report.
   *
   * @return the reportStartTime
   */
  public String getReportStartTime() {
    return reportStartTime;
  }

  /**
   * Gets the reportEndTime.
   *
   * End time of the report.
   *
   * @return the reportEndTime
   */
  public String getReportEndTime() {
    return reportEndTime;
  }

  /**
   * Gets the users.
   *
   * List of users.
   *
   * @return the users
   */
  public List<UserActivity> getUsers() {
    return users;
  }

  /**
   * Gets the apikeys.
   *
   * List of apikeys.
   *
   * @return the apikeys
   */
  public List<EntityActivity> getApikeys() {
    return apikeys;
  }

  /**
   * Gets the serviceids.
   *
   * List of serviceids.
   *
   * @return the serviceids
   */
  public List<EntityActivity> getServiceids() {
    return serviceids;
  }

  /**
   * Gets the profiles.
   *
   * List of profiles.
   *
   * @return the profiles
   */
  public List<EntityActivity> getProfiles() {
    return profiles;
  }
}

