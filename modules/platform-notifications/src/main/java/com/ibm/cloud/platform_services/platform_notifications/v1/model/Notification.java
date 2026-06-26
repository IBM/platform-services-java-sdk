/*
 * (C) Copyright IBM Corp. 2026.
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

package com.ibm.cloud.platform_services.platform_notifications.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A notification entry.
 */
public class Notification extends GenericModel {

  /**
   * The category of the notification.
   */
  public interface Category {
    /** incident. */
    String INCIDENT = "incident";
    /** maintenance. */
    String MAINTENANCE = "maintenance";
    /** announcements. */
    String ANNOUNCEMENTS = "announcements";
    /** security_bulletins. */
    String SECURITY_BULLETINS = "security_bulletins";
    /** security. */
    String SECURITY = "security";
    /** resource. */
    String RESOURCE = "resource";
    /** billing_and_usage. */
    String BILLING_AND_USAGE = "billing_and_usage";
    /** ordering. */
    String ORDERING = "ordering";
    /** provisioning. */
    String PROVISIONING = "provisioning";
    /** account. */
    String ACCOUNT = "account";
  }

  /**
   * The current state of the notification.
   */
  public interface State {
    /** new. */
    String X_NEW = "new";
    /** in-progress. */
    String IN_PROGRESS = "in-progress";
    /** complete. */
    String COMPLETE = "complete";
    /** resolved. */
    String RESOLVED = "resolved";
  }

  /**
   * The completion code of the notification.
   */
  public interface CompletionCode {
    /** successful. */
    String SUCCESSFUL = "successful";
    /** failed. */
    String FAILED = "failed";
    /** cancelled. */
    String CANCELLED = "cancelled";
  }

  protected String title;
  protected String body;
  protected String id;
  protected String category;
  @SerializedName("component_names")
  protected List<String> componentNames;
  @SerializedName("start_time")
  protected Long startTime;
  @SerializedName("is_global")
  protected Boolean isGlobal;
  protected String state;
  protected List<String> regions;
  @SerializedName("crn_masks")
  protected List<String> crnMasks;
  @SerializedName("record_id")
  protected String recordId;
  @SerializedName("source_id")
  protected String sourceId;
  @SerializedName("completion_code")
  protected String completionCode;
  @SerializedName("end_time")
  protected Long endTime;
  @SerializedName("update_time")
  protected Long updateTime;
  protected Long severity;
  @SerializedName("lucene_query")
  protected String luceneQuery;
  @SerializedName("resource_link")
  protected String resourceLink;
  @SerializedName("creation_timestamp")
  protected Long creationTimestamp;

  protected Notification() { }

  /**
   * Gets the title.
   *
   * The title of the notification.
   *
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Gets the body.
   *
   * The body content of the notification.
   *
   * @return the body
   */
  public String getBody() {
    return body;
  }

  /**
   * Gets the id.
   *
   * The unique identifier for the notification.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the category.
   *
   * The category of the notification.
   *
   * @return the category
   */
  public String getCategory() {
    return category;
  }

  /**
   * Gets the componentNames.
   *
   * Array of component/service names affected by this notification.
   *
   * @return the componentNames
   */
  public List<String> getComponentNames() {
    return componentNames;
  }

  /**
   * Gets the startTime.
   *
   * The start time of the notification in Unix timestamp (seconds).
   *
   * @return the startTime
   */
  public Long getStartTime() {
    return startTime;
  }

  /**
   * Gets the isGlobal.
   *
   * Indicates if the notification is global.
   *
   * @return the isGlobal
   */
  public Boolean isIsGlobal() {
    return isGlobal;
  }

  /**
   * Gets the state.
   *
   * The current state of the notification.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Gets the regions.
   *
   * Array of region identifiers affected by this notification.
   *
   * @return the regions
   */
  public List<String> getRegions() {
    return regions;
  }

  /**
   * Gets the crnMasks.
   *
   * Array of CRN masks that define the scope of affected resources.
   *
   * @return the crnMasks
   */
  public List<String> getCrnMasks() {
    return crnMasks;
  }

  /**
   * Gets the recordId.
   *
   * The record identifier for tracking purposes.
   *
   * @return the recordId
   */
  public String getRecordId() {
    return recordId;
  }

  /**
   * Gets the sourceId.
   *
   * The source identifier of the notification.
   *
   * @return the sourceId
   */
  public String getSourceId() {
    return sourceId;
  }

  /**
   * Gets the completionCode.
   *
   * The completion code of the notification.
   *
   * @return the completionCode
   */
  public String getCompletionCode() {
    return completionCode;
  }

  /**
   * Gets the endTime.
   *
   * The end time of the notification in Unix timestamp (seconds).
   *
   * @return the endTime
   */
  public Long getEndTime() {
    return endTime;
  }

  /**
   * Gets the updateTime.
   *
   * The last update time of the notification in Unix timestamp (seconds).
   *
   * @return the updateTime
   */
  public Long getUpdateTime() {
    return updateTime;
  }

  /**
   * Gets the severity.
   *
   * The severity level of the notification (0-3). The display value depends on the notification type:
   *
   * **Incidents:**
   * - 1 = Severity 1
   * - 2 = Severity 2
   * - 3 = Severity 3
   * - 0 = Severity 4
   *
   * **Maintenance:**
   * - 1 = High
   * - 2 = Medium
   * - 3 = Low
   *
   * **Announcements:**
   * - 1 = Major
   * - 0 = Minor.
   *
   * @return the severity
   */
  public Long getSeverity() {
    return severity;
  }

  /**
   * Gets the luceneQuery.
   *
   * Lucene query string for filtering affected resources. Only present when instance targets are specified and
   * resource_link is not available. Mutually exclusive with resource_link.
   *
   * @return the luceneQuery
   */
  public String getLuceneQuery() {
    return luceneQuery;
  }

  /**
   * Gets the resourceLink.
   *
   * Link to additional resource information or documentation. Takes precedence over lucene_query when both are
   * available. Mutually exclusive with lucene_query.
   *
   * @return the resourceLink
   */
  public String getResourceLink() {
    return resourceLink;
  }

  /**
   * Gets the creationTimestamp.
   *
   * The timestamp when the notification was created.
   *
   * @return the creationTimestamp
   */
  public Long getCreationTimestamp() {
    return creationTimestamp;
  }
}

