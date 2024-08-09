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

package com.ibm.cloud.platform_services.iam_identity.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * ReportMfaEnrollmentStatus.
 */
public class ReportMfaEnrollmentStatus extends GenericModel {

  @SerializedName("created_by")
  protected String createdBy;
  protected String reference;
  @SerializedName("report_time")
  protected String reportTime;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("ims_account_id")
  protected String imsAccountId;
  protected List<UserReportMfaEnrollmentStatus> users;

  protected ReportMfaEnrollmentStatus() { }

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
   * Gets the reportTime.
   *
   * Date time at which report is generated. Date is in ISO format.
   *
   * @return the reportTime
   */
  public String getReportTime() {
    return reportTime;
  }

  /**
   * Gets the accountId.
   *
   * BSS account id of the user who triggered the report.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the imsAccountId.
   *
   * IMS account id of the user who triggered the report.
   *
   * @return the imsAccountId
   */
  public String getImsAccountId() {
    return imsAccountId;
  }

  /**
   * Gets the users.
   *
   * List of users.
   *
   * @return the users
   */
  public List<UserReportMfaEnrollmentStatus> getUsers() {
    return users;
  }
}

