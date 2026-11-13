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

package com.ibm.cloud.platform_services.context_based_restrictions.v1.model;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A zone assignment output object (full detail).
 */
public class ZoneAssignment extends GenericModel {

  /**
   * The current status of the zone assignment.
   */
  public interface Status {
    /** accepted. */
    String ACCEPTED = "accepted";
    /** in_progress. */
    String IN_PROGRESS = "in_progress";
    /** succeeded. */
    String SUCCEEDED = "succeeded";
    /** failure. */
    String FAILURE = "failure";
    /** superseded. */
    String SUPERSEDED = "superseded";
  }

  protected String id;
  protected String crn;
  @SerializedName("account_id")
  protected String accountId;
  protected ZoneAssignmentTarget target;
  protected ZoneAssignmentZone zone;
  protected String status;
  protected List<ZoneAssignmentResource> resources;
  protected String href;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("created_by_id")
  protected String createdById;
  @SerializedName("last_modified_at")
  protected Date lastModifiedAt;
  @SerializedName("last_modified_by_id")
  protected String lastModifiedById;

  protected ZoneAssignment() { }

  /**
   * Gets the id.
   *
   * The globally unique ID of the zone assignment.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the crn.
   *
   * The zone assignment CRN.
   *
   * @return the crn
   */
  public String getCrn() {
    return crn;
  }

  /**
   * Gets the accountId.
   *
   * The ID of the account that owns the zones being assigned.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the target.
   *
   * The enterprise target entity.
   *
   * @return the target
   */
  public ZoneAssignmentTarget getTarget() {
    return target;
  }

  /**
   * Gets the zone.
   *
   * The zone that was assigned.
   *
   * @return the zone
   */
  public ZoneAssignmentZone getZone() {
    return zone;
  }

  /**
   * Gets the status.
   *
   * The current status of the zone assignment.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the resources.
   *
   * The per-target results of applying the assignment.
   *
   * @return the resources
   */
  public List<ZoneAssignmentResource> getResources() {
    return resources;
  }

  /**
   * Gets the href.
   *
   * The href link to the resource.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }

  /**
   * Gets the createdAt.
   *
   * The time the resource was created.
   *
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the createdById.
   *
   * IAM ID of the user or service which created the resource.
   *
   * @return the createdById
   */
  public String getCreatedById() {
    return createdById;
  }

  /**
   * Gets the lastModifiedAt.
   *
   * The last time the resource was modified.
   *
   * @return the lastModifiedAt
   */
  public Date getLastModifiedAt() {
    return lastModifiedAt;
  }

  /**
   * Gets the lastModifiedById.
   *
   * IAM ID of the user or service which modified the resource.
   *
   * @return the lastModifiedById
   */
  public String getLastModifiedById() {
    return lastModifiedById;
  }
}

