/*
 * (C) Copyright IBM Corp. 2023.
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
package com.ibm.cloud.platform_services.iam_access_groups.v2.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Successful response output for create template.
 */
public class CreateTemplateResponse extends GenericModel {

  protected String id;
  protected String name;
  protected String description;
  @SerializedName("account_id")
  protected String accountId;
  protected String version;
  protected Boolean committed;
  @SerializedName("access_group")
  protected AccessGroupInput accessGroup;
  @SerializedName("policy_templates")
  protected List<PolicyTemplatesInput> policyTemplates;
  protected String href;
  @SerializedName("created_at")
  protected Date createdAt;
  @SerializedName("created_by_id")
  protected String createdById;
  @SerializedName("last_modified_at")
  protected Date lastModifiedAt;
  @SerializedName("last_modified_by_id")
  protected String lastModifiedById;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String name;
    private String description;
    private String accountId;
    private String version;
    private Boolean committed;
    private AccessGroupInput accessGroup;
    private List<PolicyTemplatesInput> policyTemplates;
    private String href;
    private Date createdAt;
    private String createdById;
    private Date lastModifiedAt;
    private String lastModifiedById;

    /**
     * Instantiates a new Builder from an existing CreateTemplateResponse instance.
     *
     * @param createTemplateResponse the instance to initialize the Builder with
     */
    private Builder(CreateTemplateResponse createTemplateResponse) {
      this.id = createTemplateResponse.id;
      this.name = createTemplateResponse.name;
      this.description = createTemplateResponse.description;
      this.accountId = createTemplateResponse.accountId;
      this.version = createTemplateResponse.version;
      this.committed = createTemplateResponse.committed;
      this.accessGroup = createTemplateResponse.accessGroup;
      this.policyTemplates = createTemplateResponse.policyTemplates;
      this.href = createTemplateResponse.href;
      this.createdAt = createTemplateResponse.createdAt;
      this.createdById = createTemplateResponse.createdById;
      this.lastModifiedAt = createTemplateResponse.lastModifiedAt;
      this.lastModifiedById = createTemplateResponse.lastModifiedById;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a CreateTemplateResponse.
     *
     * @return the new CreateTemplateResponse instance
     */
    public CreateTemplateResponse build() {
      return new CreateTemplateResponse(this);
    }

    /**
     * Adds an policyTemplates to policyTemplates.
     *
     * @param policyTemplates the new policyTemplates
     * @return the CreateTemplateResponse builder
     */
    public Builder addPolicyTemplates(PolicyTemplatesInput policyTemplates) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(policyTemplates,
        "policyTemplates cannot be null");
      if (this.policyTemplates == null) {
        this.policyTemplates = new ArrayList<PolicyTemplatesInput>();
      }
      this.policyTemplates.add(policyTemplates);
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the CreateTemplateResponse builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateTemplateResponse builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateTemplateResponse builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreateTemplateResponse builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the CreateTemplateResponse builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }

    /**
     * Set the committed.
     *
     * @param committed the committed
     * @return the CreateTemplateResponse builder
     */
    public Builder committed(Boolean committed) {
      this.committed = committed;
      return this;
    }

    /**
     * Set the accessGroup.
     *
     * @param accessGroup the accessGroup
     * @return the CreateTemplateResponse builder
     */
    public Builder accessGroup(AccessGroupInput accessGroup) {
      this.accessGroup = accessGroup;
      return this;
    }

    /**
     * Set the policyTemplates.
     * Existing policyTemplates will be replaced.
     *
     * @param policyTemplates the policyTemplates
     * @return the CreateTemplateResponse builder
     */
    public Builder policyTemplates(List<PolicyTemplatesInput> policyTemplates) {
      this.policyTemplates = policyTemplates;
      return this;
    }

    /**
     * Set the href.
     *
     * @param href the href
     * @return the CreateTemplateResponse builder
     */
    public Builder href(String href) {
      this.href = href;
      return this;
    }

    /**
     * Set the createdAt.
     *
     * @param createdAt the createdAt
     * @return the CreateTemplateResponse builder
     */
    public Builder createdAt(Date createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    /**
     * Set the createdById.
     *
     * @param createdById the createdById
     * @return the CreateTemplateResponse builder
     */
    public Builder createdById(String createdById) {
      this.createdById = createdById;
      return this;
    }

    /**
     * Set the lastModifiedAt.
     *
     * @param lastModifiedAt the lastModifiedAt
     * @return the CreateTemplateResponse builder
     */
    public Builder lastModifiedAt(Date lastModifiedAt) {
      this.lastModifiedAt = lastModifiedAt;
      return this;
    }

    /**
     * Set the lastModifiedById.
     *
     * @param lastModifiedById the lastModifiedById
     * @return the CreateTemplateResponse builder
     */
    public Builder lastModifiedById(String lastModifiedById) {
      this.lastModifiedById = lastModifiedById;
      return this;
    }
  }

  protected CreateTemplateResponse() { }

  protected CreateTemplateResponse(Builder builder) {
    id = builder.id;
    name = builder.name;
    description = builder.description;
    accountId = builder.accountId;
    version = builder.version;
    committed = builder.committed;
    accessGroup = builder.accessGroup;
    policyTemplates = builder.policyTemplates;
    href = builder.href;
    createdAt = builder.createdAt;
    createdById = builder.createdById;
    lastModifiedAt = builder.lastModifiedAt;
    lastModifiedById = builder.lastModifiedById;
  }

  /**
   * New builder.
   *
   * @return a CreateTemplateResponse builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The ID of the access group template.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the name.
   *
   * The name of the access group template.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * The description of the access group template.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the accountId.
   *
   * The ID of the account to which the access group template is assigned.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the version.
   *
   * The version of the access group template.
   *
   * @return the version
   */
  public String version() {
    return version;
  }

  /**
   * Gets the committed.
   *
   * A boolean indicating whether the access group template is committed.
   *
   * @return the committed
   */
  public Boolean committed() {
    return committed;
  }

  /**
   * Gets the accessGroup.
   *
   * Access Group Input Component.
   *
   * @return the accessGroup
   */
  public AccessGroupInput accessGroup() {
    return accessGroup;
  }

  /**
   * Gets the policyTemplates.
   *
   * References to policy templates assigned to the access group template.
   *
   * @return the policyTemplates
   */
  public List<PolicyTemplatesInput> policyTemplates() {
    return policyTemplates;
  }

  /**
   * Gets the href.
   *
   * The URL of the access group template resource.
   *
   * @return the href
   */
  public String href() {
    return href;
  }

  /**
   * Gets the createdAt.
   *
   * The date and time when the access group template was created.
   *
   * @return the createdAt
   */
  public Date createdAt() {
    return createdAt;
  }

  /**
   * Gets the createdById.
   *
   * The ID of the user who created the access group template.
   *
   * @return the createdById
   */
  public String createdById() {
    return createdById;
  }

  /**
   * Gets the lastModifiedAt.
   *
   * The date and time when the access group template was last modified.
   *
   * @return the lastModifiedAt
   */
  public Date lastModifiedAt() {
    return lastModifiedAt;
  }

  /**
   * Gets the lastModifiedById.
   *
   * The ID of the user who last modified the access group template.
   *
   * @return the lastModifiedById
   */
  public String lastModifiedById() {
    return lastModifiedById;
  }
}

