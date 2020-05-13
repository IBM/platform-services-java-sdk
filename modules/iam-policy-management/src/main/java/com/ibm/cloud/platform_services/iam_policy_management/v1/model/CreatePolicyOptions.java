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
 * The createPolicy options.
 */
public class CreatePolicyOptions extends GenericModel {

  protected String type;
  protected List<PolicyRequestSubjectsItem> subjects;
  protected List<PolicyRequestRolesItem> roles;
  protected List<PolicyRequestResourcesItem> resources;
  protected String acceptLanguage;

  /**
   * Builder.
   */
  public static class Builder {
    private String type;
    private List<PolicyRequestSubjectsItem> subjects;
    private List<PolicyRequestRolesItem> roles;
    private List<PolicyRequestResourcesItem> resources;
    private String acceptLanguage;

    private Builder(CreatePolicyOptions createPolicyOptions) {
      this.type = createPolicyOptions.type;
      this.subjects = createPolicyOptions.subjects;
      this.roles = createPolicyOptions.roles;
      this.resources = createPolicyOptions.resources;
      this.acceptLanguage = createPolicyOptions.acceptLanguage;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param type the type
     * @param subjects the subjects
     * @param roles the roles
     * @param resources the resources
     */
    public Builder(String type, List<PolicyRequestSubjectsItem> subjects, List<PolicyRequestRolesItem> roles, List<PolicyRequestResourcesItem> resources) {
      this.type = type;
      this.subjects = subjects;
      this.roles = roles;
      this.resources = resources;
    }

    /**
     * Builds a CreatePolicyOptions.
     *
     * @return the new CreatePolicyOptions instance
     */
    public CreatePolicyOptions build() {
      return new CreatePolicyOptions(this);
    }

    /**
     * Adds an subjects to subjects.
     *
     * @param subjects the new subjects
     * @return the CreatePolicyOptions builder
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
     * @return the CreatePolicyOptions builder
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
     * @return the CreatePolicyOptions builder
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
     * Set the type.
     *
     * @param type the type
     * @return the CreatePolicyOptions builder
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
     * @return the CreatePolicyOptions builder
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
     * @return the CreatePolicyOptions builder
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
     * @return the CreatePolicyOptions builder
     */
    public Builder resources(List<PolicyRequestResourcesItem> resources) {
      this.resources = resources;
      return this;
    }

    /**
     * Set the acceptLanguage.
     *
     * @param acceptLanguage the acceptLanguage
     * @return the CreatePolicyOptions builder
     */
    public Builder acceptLanguage(String acceptLanguage) {
      this.acceptLanguage = acceptLanguage;
      return this;
    }
  }

  protected CreatePolicyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.subjects,
      "subjects cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.roles,
      "roles cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.resources,
      "resources cannot be null");
    type = builder.type;
    subjects = builder.subjects;
    roles = builder.roles;
    resources = builder.resources;
    acceptLanguage = builder.acceptLanguage;
  }

  /**
   * New builder.
   *
   * @return a CreatePolicyOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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

  /**
   * Gets the acceptLanguage.
   *
   * Translation language code.
   *
   * @return the acceptLanguage
   */
  public String acceptLanguage() {
    return acceptLanguage;
  }
}

