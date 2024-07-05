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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The replacePolicy options.
 */
public class ReplacePolicyOptions extends GenericModel {

  protected String policyId;
  protected String ifMatch;
  protected String type;
  protected List<PolicySubject> subjects;
  protected List<PolicyRole> roles;
  protected List<PolicyResource> resources;
  protected String description;

  /**
   * Builder.
   */
  public static class Builder {
    private String policyId;
    private String ifMatch;
    private String type;
    private List<PolicySubject> subjects;
    private List<PolicyRole> roles;
    private List<PolicyResource> resources;
    private String description;

    /**
     * Instantiates a new Builder from an existing ReplacePolicyOptions instance.
     *
     * @param replacePolicyOptions the instance to initialize the Builder with
     */
    private Builder(ReplacePolicyOptions replacePolicyOptions) {
      this.policyId = replacePolicyOptions.policyId;
      this.ifMatch = replacePolicyOptions.ifMatch;
      this.type = replacePolicyOptions.type;
      this.subjects = replacePolicyOptions.subjects;
      this.roles = replacePolicyOptions.roles;
      this.resources = replacePolicyOptions.resources;
      this.description = replacePolicyOptions.description;
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
    public Builder(String policyId, String ifMatch, String type, List<PolicySubject> subjects, List<PolicyRole> roles, List<PolicyResource> resources) {
      this.policyId = policyId;
      this.ifMatch = ifMatch;
      this.type = type;
      this.subjects = subjects;
      this.roles = roles;
      this.resources = resources;
    }

    /**
     * Builds a ReplacePolicyOptions.
     *
     * @return the new ReplacePolicyOptions instance
     */
    public ReplacePolicyOptions build() {
      return new ReplacePolicyOptions(this);
    }

    /**
     * Adds a new element to subjects.
     *
     * @param subjects the new element to be added
     * @return the ReplacePolicyOptions builder
     */
    public Builder addSubjects(PolicySubject subjects) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(subjects,
        "subjects cannot be null");
      if (this.subjects == null) {
        this.subjects = new ArrayList<PolicySubject>();
      }
      this.subjects.add(subjects);
      return this;
    }

    /**
     * Adds a new element to roles.
     *
     * @param roles the new element to be added
     * @return the ReplacePolicyOptions builder
     */
    public Builder addRoles(PolicyRole roles) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(roles,
        "roles cannot be null");
      if (this.roles == null) {
        this.roles = new ArrayList<PolicyRole>();
      }
      this.roles.add(roles);
      return this;
    }

    /**
     * Adds a new element to resources.
     *
     * @param resources the new element to be added
     * @return the ReplacePolicyOptions builder
     */
    public Builder addResources(PolicyResource resources) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(resources,
        "resources cannot be null");
      if (this.resources == null) {
        this.resources = new ArrayList<PolicyResource>();
      }
      this.resources.add(resources);
      return this;
    }

    /**
     * Set the policyId.
     *
     * @param policyId the policyId
     * @return the ReplacePolicyOptions builder
     */
    public Builder policyId(String policyId) {
      this.policyId = policyId;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the ReplacePolicyOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the ReplacePolicyOptions builder
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
     * @return the ReplacePolicyOptions builder
     */
    public Builder subjects(List<PolicySubject> subjects) {
      this.subjects = subjects;
      return this;
    }

    /**
     * Set the roles.
     * Existing roles will be replaced.
     *
     * @param roles the roles
     * @return the ReplacePolicyOptions builder
     */
    public Builder roles(List<PolicyRole> roles) {
      this.roles = roles;
      return this;
    }

    /**
     * Set the resources.
     * Existing resources will be replaced.
     *
     * @param resources the resources
     * @return the ReplacePolicyOptions builder
     */
    public Builder resources(List<PolicyResource> resources) {
      this.resources = resources;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the ReplacePolicyOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }
  }

  protected ReplacePolicyOptions() { }

  protected ReplacePolicyOptions(Builder builder) {
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
    description = builder.description;
  }

  /**
   * New builder.
   *
   * @return a ReplacePolicyOptions builder
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
   * The subjects associated with a policy.
   *
   * @return the subjects
   */
  public List<PolicySubject> subjects() {
    return subjects;
  }

  /**
   * Gets the roles.
   *
   * A set of role cloud resource names (CRNs) granted by the policy.
   *
   * @return the roles
   */
  public List<PolicyRole> roles() {
    return roles;
  }

  /**
   * Gets the resources.
   *
   * The resources associated with a policy.
   *
   * @return the resources
   */
  public List<PolicyResource> resources() {
    return resources;
  }

  /**
   * Gets the description.
   *
   * Customer-defined description.
   *
   * @return the description
   */
  public String description() {
    return description;
  }
}

