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
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The core set of properties associated with a policy.
 */
public class Policy extends GenericModel {

  /**
   * The policy state.
   */
  public interface State {
    /** active. */
    String ACTIVE = "active";
    /** deleted. */
    String DELETED = "deleted";
  }

  protected String id;
  protected String type;
  protected String description;
  protected List<PolicySubject> subjects;
  protected List<PolicyRole> roles;
  protected List<PolicyResource> resources;
  protected String href;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("created_by_id")
  protected String createdById;
  @SerializedName("last_modified_at")
  protected Date lastModifiedAt;
  @SerializedName("last_modified_by_id")
  protected String lastModifiedById;
  protected String state;

  protected Policy() { }

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
   * Customer-defined description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the subjects.
   *
   * The subjects associated with a policy.
   *
   * @return the subjects
   */
  public List<PolicySubject> getSubjects() {
    return subjects;
  }

  /**
   * Gets the roles.
   *
   * A set of role cloud resource names (CRNs) granted by the policy.
   *
   * @return the roles
   */
  public List<PolicyRole> getRoles() {
    return roles;
  }

  /**
   * Gets the resources.
   *
   * The resources associated with a policy.
   *
   * @return the resources
   */
  public List<PolicyResource> getResources() {
    return resources;
  }

  /**
   * Gets the href.
   *
   * The href link back to the policy.
   *
   * @return the href
   */
  public String getHref() {
    return href;
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
   * The policy state.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }
}

