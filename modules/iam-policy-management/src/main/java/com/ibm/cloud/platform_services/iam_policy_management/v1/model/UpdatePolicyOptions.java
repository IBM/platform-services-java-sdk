/*
 * (C) Copyright IBM Corp. 2020.
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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updatePolicy options.
 */
public class UpdatePolicyOptions extends GenericModel {

  protected String policyId;
  protected String ifMatch;
  protected String type;
  protected List<PolicyRequestSubjectsItem> subjects;
  protected List<PolicyRequestRolesItem> roles;
  protected List<PolicyRequestResourcesItem> resources;

  /**
   * Builder.
   */
  public static class Builder {
    private String policyId;
    private String ifMatch;
    private String type;
    private List<PolicyRequestSubjectsItem> subjects;
    private List<PolicyRequestRolesItem> roles;
    private List<PolicyRequestResourcesItem> resources;

    private Builder(UpdatePolicyOptions updatePolicyOptions) {
      this.policyId = updatePolicyOptions.policyId;
      this.ifMatch = updatePolicyOptions.ifMatch;
      this.type = updatePolicyOptions.type;
      this.subjects = updatePolicyOptions.subjects;
      this.roles = updatePolicyOptions.roles;
      this.resources = updatePolicyOptions.resources;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param policyId the policyId
     * @param ifMatch the ifMatch
     * @param type the type
     * @param subjects the subjects
     * @param roles the roles
     * @param resources the resources
     */
    public Builder(String policyId, String ifMatch, String type, List<PolicyRequestSubjectsItem> subjects, List<PolicyRequestRolesItem> roles, List<PolicyRequestResourcesItem> resources) {
      this.policyId = policyId;
      this.ifMatch = ifMatch;
      this.type = type;
      this.subjects = subjects;
      this.roles = roles;
      this.resources = resources;
    }

    /**
     * Builds a UpdatePolicyOptions.
     *
     * @return the new UpdatePolicyOptions instance
     */
    public UpdatePolicyOptions build() {
      return new UpdatePolicyOptions(this);
    }

    /**
     * Adds an subjects to subjects.
     *
     * @param subjects the new subjects
     * @return the UpdatePolicyOptions builder
     */
    public Builder addSubjects(PolicyRequestSubjectsItem subjects) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(subjects,
        "subjects cannot be null");
      if (this.subjects == null) {
        this.subjects = new ArrayList<PolicyRequestSubjectsItem>();
      }
      this.subjects.add(subjects);
      return this;
    }

    /**
     * Adds an roles to roles.
     *
     * @param roles the new roles
     * @return the UpdatePolicyOptions builder
     */
    public Builder addRoles(PolicyRequestRolesItem roles) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(roles,
        "roles cannot be null");
      if (this.roles == null) {
        this.roles = new ArrayList<PolicyRequestRolesItem>();
      }
      this.roles.add(roles);
      return this;
    }

    /**
     * Adds an resources to resources.
     *
     * @param resources the new resources
     * @return the UpdatePolicyOptions builder
     */
    public Builder addResources(PolicyRequestResourcesItem resources) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(resources,
        "resources cannot be null");
      if (this.resources == null) {
        this.resources = new ArrayList<PolicyRequestResourcesItem>();
      }
      this.resources.add(resources);
      return this;
    }

    /**
     * Set the policyId.
     *
     * @param policyId the policyId
     * @return the UpdatePolicyOptions builder
     */
    public Builder policyId(String policyId) {
      this.policyId = policyId;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the UpdatePolicyOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the UpdatePolicyOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the subjects.
     * Existing subjects will be replaced.
     *
     * @param subjects the subjects
     * @return the UpdatePolicyOptions builder
     */
    public Builder subjects(List<PolicyRequestSubjectsItem> subjects) {
      this.subjects = subjects;
      return this;
    }

    /**
     * Set the roles.
     * Existing roles will be replaced.
     *
     * @param roles the roles
     * @return the UpdatePolicyOptions builder
     */
    public Builder roles(List<PolicyRequestRolesItem> roles) {
      this.roles = roles;
      return this;
    }

    /**
     * Set the resources.
     * Existing resources will be replaced.
     *
     * @param resources the resources
     * @return the UpdatePolicyOptions builder
     */
    public Builder resources(List<PolicyRequestResourcesItem> resources) {
      this.resources = resources;
      return this;
    }
  }

  protected UpdatePolicyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.policyId,
      "policyId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ifMatch,
      "ifMatch cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.subjects,
      "subjects cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.roles,
      "roles cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.resources,
      "resources cannot be null");
    policyId = builder.policyId;
    ifMatch = builder.ifMatch;
    type = builder.type;
    subjects = builder.subjects;
    roles = builder.roles;
    resources = builder.resources;
  }

  /**
   * New builder.
   *
   * @return a UpdatePolicyOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the policyId.
   *
   * The policy ID.
   *
   * @return the policyId
   */
  public String policyId() {
    return policyId;
  }

  /**
   * Gets the ifMatch.
   *
   * The revision number for updating a policy and must match the ETag value of the existing policy. The Etag can be
   * retrieved using the GET /v1/policies/{policy_id} API and looking at the ETag response header.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
  }

  /**
   * Gets the type.
   *
   * The policy type; either 'access' or 'authorization'.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the subjects.
   *
   * The subject attribute values that must match in order for this policy to apply in a permission decision.
   *
   * @return the subjects
   */
  public List<PolicyRequestSubjectsItem> subjects() {
    return subjects;
  }

  /**
   * Gets the roles.
   *
   * A set of role cloud resource names (CRNs) granted by the policy.
   *
   * @return the roles
   */
  public List<PolicyRequestRolesItem> roles() {
    return roles;
  }

  /**
   * Gets the resources.
   *
   * The attributes of the resource. Note that only one resource is allowed in a policy.
   *
   * @return the resources
   */
  public List<PolicyRequestResourcesItem> resources() {
    return resources;
  }
}

