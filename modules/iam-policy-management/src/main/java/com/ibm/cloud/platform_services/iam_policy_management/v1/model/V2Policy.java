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

package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The core set of properties associated with the policy.
 */
public class V2Policy extends GenericModel {

  /**
   * The policy type; either 'access' or 'authorization'.
   */
  public interface Type {
    /** access. */
    String ACCESS = "access";
    /** authorization. */
    String AUTHORIZATION = "authorization";
  }

  /**
   * The policy state, either 'deleted' or 'active'.
   */
  public interface State {
    /** active. */
    String ACTIVE = "active";
    /** deleted. */
    String DELETED = "deleted";
  }

  protected String type;
  protected String description;
  protected V2PolicySubject subject;
  protected V2PolicyResource resource;
  protected String pattern;
  protected V2PolicyRule rule;
  protected String id;
  protected String href;
  protected ControlResponse control;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("created_by_id")
  protected String createdById;
  @SerializedName("last_modified_at")
  protected Date lastModifiedAt;
  @SerializedName("last_modified_by_id")
  protected String lastModifiedById;
  protected String state;
  @SerializedName("last_permit_at")
  protected String lastPermitAt;
  @SerializedName("last_permit_frequency")
  protected Long lastPermitFrequency;

  protected V2Policy() { }

  /**
   * Gets the type.
   *
   * The policy type; either 'access' or 'authorization'.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the description.
   *
   * Description of the policy.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the subject.
   *
   * The subject attributes for whom the policy grants access.
   *
   * @return the subject
   */
  public V2PolicySubject getSubject() {
    return subject;
  }

  /**
   * Gets the resource.
   *
   * The resource attributes to which the policy grants access.
   *
   * @return the resource
   */
  public V2PolicyResource getResource() {
    return resource;
  }

  /**
   * Gets the pattern.
   *
   * Indicates pattern of rule, either 'time-based-conditions:once', 'time-based-conditions:weekly:all-day', or
   * 'time-based-conditions:weekly:custom-hours'.
   *
   * @return the pattern
   */
  public String getPattern() {
    return pattern;
  }

  /**
   * Gets the rule.
   *
   * Additional access conditions associated with the policy.
   *
   * @return the rule
   */
  public V2PolicyRule getRule() {
    return rule;
  }

  /**
   * Gets the id.
   *
   * The policy ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the href.
   *
   * The href URL that links to the policies API by policy ID.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }

  /**
   * Gets the control.
   *
   * @return the control
   */
  public ControlResponse getControl() {
    return control;
  }

  /**
   * Gets the createdAt.
   *
   * The UTC timestamp when the policy was created.
   *
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the createdById.
   *
   * The iam ID of the entity that created the policy.
   *
   * @return the createdById
   */
  public String getCreatedById() {
    return createdById;
  }

  /**
   * Gets the lastModifiedAt.
   *
   * The UTC timestamp when the policy was last modified.
   *
   * @return the lastModifiedAt
   */
  public Date getLastModifiedAt() {
    return lastModifiedAt;
  }

  /**
   * Gets the lastModifiedById.
   *
   * The iam ID of the entity that last modified the policy.
   *
   * @return the lastModifiedById
   */
  public String getLastModifiedById() {
    return lastModifiedById;
  }

  /**
   * Gets the state.
   *
   * The policy state, either 'deleted' or 'active'.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Gets the lastPermitAt.
   *
   * The optional last permit time of policy, when passing query parameter format=include_last_permit.
   *
   * @return the lastPermitAt
   */
  public String getLastPermitAt() {
    return lastPermitAt;
  }

  /**
   * Gets the lastPermitFrequency.
   *
   * The optional count of times that policy has provided a permit, when passing query parameter
   * format=include_last_permit.
   *
   * @return the lastPermitFrequency
   */
  public Long getLastPermitFrequency() {
    return lastPermitFrequency;
  }
}

