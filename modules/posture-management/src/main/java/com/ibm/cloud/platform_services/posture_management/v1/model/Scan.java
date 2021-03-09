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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Scan.
 */
public class Scan extends GenericModel {

  /**
   * The status of the collector as it completes a scan.
   */
  public interface Status {
    /** pending. */
    String PENDING = "pending";
    /** discovery_started. */
    String DISCOVERY_STARTED = "discovery_started";
    /** discovery_completed. */
    String DISCOVERY_COMPLETED = "discovery_completed";
    /** error_in_discovery. */
    String ERROR_IN_DISCOVERY = "error_in_discovery";
    /** gateway_aborted. */
    String GATEWAY_ABORTED = "gateway_aborted";
    /** controller_aborted. */
    String CONTROLLER_ABORTED = "controller_aborted";
    /** not_accepted. */
    String NOT_ACCEPTED = "not_accepted";
    /** waiting_for_refine. */
    String WAITING_FOR_REFINE = "waiting_for_refine";
    /** validation_started. */
    String VALIDATION_STARTED = "validation_started";
    /** validation_completed. */
    String VALIDATION_COMPLETED = "validation_completed";
    /** sent_to_collector. */
    String SENT_TO_COLLECTOR = "sent_to_collector";
    /** discovery_in_progress. */
    String DISCOVERY_IN_PROGRESS = "discovery_in_progress";
    /** validation_in_progress. */
    String VALIDATION_IN_PROGRESS = "validation_in_progress";
    /** error_in_validation. */
    String ERROR_IN_VALIDATION = "error_in_validation";
    /** discovery_result_posted_with_error. */
    String DISCOVERY_RESULT_POSTED_WITH_ERROR = "discovery_result_posted_with_error";
    /** discovery_result_posted_no_error. */
    String DISCOVERY_RESULT_POSTED_NO_ERROR = "discovery_result_posted_no_error";
    /** validation_result_posted_with_error. */
    String VALIDATION_RESULT_POSTED_WITH_ERROR = "validation_result_posted_with_error";
    /** validation_result_posted_no_error. */
    String VALIDATION_RESULT_POSTED_NO_ERROR = "validation_result_posted_no_error";
    /** fact_collection_started. */
    String FACT_COLLECTION_STARTED = "fact_collection_started";
    /** fact_collection_in_progress. */
    String FACT_COLLECTION_IN_PROGRESS = "fact_collection_in_progress";
    /** fact_collection_completed. */
    String FACT_COLLECTION_COMPLETED = "fact_collection_completed";
    /** error_in_fact_collection. */
    String ERROR_IN_FACT_COLLECTION = "error_in_fact_collection";
    /** fact_validation_started. */
    String FACT_VALIDATION_STARTED = "fact_validation_started";
    /** fact_validation_in_progress. */
    String FACT_VALIDATION_IN_PROGRESS = "fact_validation_in_progress";
    /** fact_validation_completed. */
    String FACT_VALIDATION_COMPLETED = "fact_validation_completed";
    /** error_in_fact_validation. */
    String ERROR_IN_FACT_VALIDATION = "error_in_fact_validation";
    /** abort_task_request_received. */
    String ABORT_TASK_REQUEST_RECEIVED = "abort_task_request_received";
    /** error_in_abort_task_request. */
    String ERROR_IN_ABORT_TASK_REQUEST = "error_in_abort_task_request";
    /** abort_task_request_completed. */
    String ABORT_TASK_REQUEST_COMPLETED = "abort_task_request_completed";
    /** user_aborted. */
    String USER_ABORTED = "user_aborted";
    /** abort_task_request_failed. */
    String ABORT_TASK_REQUEST_FAILED = "abort_task_request_failed";
    /** remediation_started. */
    String REMEDIATION_STARTED = "remediation_started";
    /** remediation_in_progress. */
    String REMEDIATION_IN_PROGRESS = "remediation_in_progress";
    /** error_in_remediation. */
    String ERROR_IN_REMEDIATION = "error_in_remediation";
    /** remediation_completed. */
    String REMEDIATION_COMPLETED = "remediation_completed";
    /** inventory_started. */
    String INVENTORY_STARTED = "inventory_started";
    /** inventory_in_progress. */
    String INVENTORY_IN_PROGRESS = "inventory_in_progress";
    /** inventory_completed. */
    String INVENTORY_COMPLETED = "inventory_completed";
    /** error_in_inventory. */
    String ERROR_IN_INVENTORY = "error_in_inventory";
    /** inventory_completed_with_error. */
    String INVENTORY_COMPLETED_WITH_ERROR = "inventory_completed_with_error";
  }

  @SerializedName("scan_id")
  protected Long scanId;
  @SerializedName("discover_id")
  protected Long discoverId;
  protected String status;
  @SerializedName("status_message")
  protected String statusMessage;

  /**
   * Gets the scanId.
   *
   * An auto-generated unique identifier for the scan.
   *
   * @return the scanId
   */
  public Long getScanId() {
    return scanId;
  }

  /**
   * Gets the discoverId.
   *
   * An auto-generated unique identifier for discovery.
   *
   * @return the discoverId
   */
  public Long getDiscoverId() {
    return discoverId;
  }

  /**
   * Gets the status.
   *
   * The status of the collector as it completes a scan.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the statusMessage.
   *
   * The current status of the collector.
   *
   * @return the statusMessage
   */
  public String getStatusMessage() {
    return statusMessage;
  }
}

