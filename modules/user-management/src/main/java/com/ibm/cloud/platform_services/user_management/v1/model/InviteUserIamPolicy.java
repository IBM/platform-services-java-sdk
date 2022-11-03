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
package com.ibm.cloud.platform_services.user_management.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Invite a user to an IAM policy.
 */
public class InviteUserIamPolicy extends GenericModel {

  protected String type;
  protected List<Role> roles;
  protected List<Resource> resources;

  /**
   * Builder.
   */
  public static class Builder {
    private String type;
    private List<Role> roles;
    private List<Resource> resources;

    /**
     * Instantiates a new Builder from an existing InviteUserIamPolicy instance.
     *
     * @param inviteUserIamPolicy the instance to initialize the Builder with
     */
    private Builder(InviteUserIamPolicy inviteUserIamPolicy) {
      this.type = inviteUserIamPolicy.type;
      this.roles = inviteUserIamPolicy.roles;
      this.resources = inviteUserIamPolicy.resources;
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
     */
    public Builder(String type) {
      this.type = type;
    }

    /**
     * Builds a InviteUserIamPolicy.
     *
     * @return the new InviteUserIamPolicy instance
     */
    public InviteUserIamPolicy build() {
      return new InviteUserIamPolicy(this);
    }

    /**
     * Adds an roles to roles.
     *
     * @param roles the new roles
     * @return the InviteUserIamPolicy builder
     */
    public Builder addRoles(Role roles) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(roles,
        "roles cannot be null");
      if (this.roles == null) {
        this.roles = new ArrayList<Role>();
      }
      this.roles.add(roles);
      return this;
    }

    /**
     * Adds an resources to resources.
     *
     * @param resources the new resources
     * @return the InviteUserIamPolicy builder
     */
    public Builder addResources(Resource resources) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(resources,
        "resources cannot be null");
      if (this.resources == null) {
        this.resources = new ArrayList<Resource>();
      }
      this.resources.add(resources);
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the InviteUserIamPolicy builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the roles.
     * Existing roles will be replaced.
     *
     * @param roles the roles
     * @return the InviteUserIamPolicy builder
     */
    public Builder roles(List<Role> roles) {
      this.roles = roles;
      return this;
    }

    /**
     * Set the resources.
     * Existing resources will be replaced.
     *
     * @param resources the resources
     * @return the InviteUserIamPolicy builder
     */
    public Builder resources(List<Resource> resources) {
      this.resources = resources;
      return this;
    }
  }

  protected InviteUserIamPolicy() { }

  protected InviteUserIamPolicy(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    type = builder.type;
    roles = builder.roles;
    resources = builder.resources;
  }

  /**
   * New builder.
   *
   * @return a InviteUserIamPolicy builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the type.
   *
   * The policy type. This can be either "access" or "authorization".
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the roles.
   *
   * A list of IAM roles.
   *
   * @return the roles
   */
  public List<Role> roles() {
    return roles;
  }

  /**
   * Gets the resources.
   *
   * A list of resources.
   *
   * @return the resources
   */
  public List<Resource> resources() {
    return resources;
  }
}

