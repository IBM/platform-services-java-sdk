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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateTemplateVersion options.
 */
public class UpdateTemplateVersionOptions extends GenericModel {

  protected String templateId;
  protected String versionNum;
  protected String ifMatch;
  protected String id;
  protected String name;
  protected String description;
  protected String accountId;
  protected String version;
  protected Boolean committed;
  protected AccessGroupInput accessGroup;
  protected List<PolicyTemplatesInput> policyTemplates;
  protected String href;
  protected Date createdAt;
  protected String createdById;
  protected Date lastModifiedAt;
  protected String lastModifiedById;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String templateId;
    private String versionNum;
    private String ifMatch;
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
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing UpdateTemplateVersionOptions instance.
     *
     * @param updateTemplateVersionOptions the instance to initialize the Builder with
     */
    private Builder(UpdateTemplateVersionOptions updateTemplateVersionOptions) {
      this.templateId = updateTemplateVersionOptions.templateId;
      this.versionNum = updateTemplateVersionOptions.versionNum;
      this.ifMatch = updateTemplateVersionOptions.ifMatch;
      this.id = updateTemplateVersionOptions.id;
      this.name = updateTemplateVersionOptions.name;
      this.description = updateTemplateVersionOptions.description;
      this.accountId = updateTemplateVersionOptions.accountId;
      this.version = updateTemplateVersionOptions.version;
      this.committed = updateTemplateVersionOptions.committed;
      this.accessGroup = updateTemplateVersionOptions.accessGroup;
      this.policyTemplates = updateTemplateVersionOptions.policyTemplates;
      this.href = updateTemplateVersionOptions.href;
      this.createdAt = updateTemplateVersionOptions.createdAt;
      this.createdById = updateTemplateVersionOptions.createdById;
      this.lastModifiedAt = updateTemplateVersionOptions.lastModifiedAt;
      this.lastModifiedById = updateTemplateVersionOptions.lastModifiedById;
      this.transactionId = updateTemplateVersionOptions.transactionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param templateId the templateId
     * @param versionNum the versionNum
     * @param ifMatch the ifMatch
     */
    public Builder(String templateId, String versionNum, String ifMatch) {
      this.templateId = templateId;
      this.versionNum = versionNum;
      this.ifMatch = ifMatch;
    }

    /**
     * Builds a UpdateTemplateVersionOptions.
     *
     * @return the new UpdateTemplateVersionOptions instance
     */
    public UpdateTemplateVersionOptions build() {
      return new UpdateTemplateVersionOptions(this);
    }

    /**
     * Adds an policyTemplates to policyTemplates.
     *
     * @param policyTemplates the new policyTemplates
     * @return the UpdateTemplateVersionOptions builder
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
     * Set the templateId.
     *
     * @param templateId the templateId
     * @return the UpdateTemplateVersionOptions builder
     */
    public Builder templateId(String templateId) {
      this.templateId = templateId;
      return this;
    }

    /**
     * Set the versionNum.
     *
     * @param versionNum the versionNum
     * @return the UpdateTemplateVersionOptions builder
     */
    public Builder versionNum(String versionNum) {
      this.versionNum = versionNum;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the UpdateTemplateVersionOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the UpdateTemplateVersionOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateTemplateVersionOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the UpdateTemplateVersionOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the UpdateTemplateVersionOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the UpdateTemplateVersionOptions builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }

    /**
     * Set the committed.
     *
     * @param committed the committed
     * @return the UpdateTemplateVersionOptions builder
     */
    public Builder committed(Boolean committed) {
      this.committed = committed;
      return this;
    }

    /**
     * Set the accessGroup.
     *
     * @param accessGroup the accessGroup
     * @return the UpdateTemplateVersionOptions builder
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
     * @return the UpdateTemplateVersionOptions builder
     */
    public Builder policyTemplates(List<PolicyTemplatesInput> policyTemplates) {
      this.policyTemplates = policyTemplates;
      return this;
    }

    /**
     * Set the href.
     *
     * @param href the href
     * @return the UpdateTemplateVersionOptions builder
     */
    public Builder href(String href) {
      this.href = href;
      return this;
    }

    /**
     * Set the createdAt.
     *
     * @param createdAt the createdAt
     * @return the UpdateTemplateVersionOptions builder
     */
    public Builder createdAt(Date createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    /**
     * Set the createdById.
     *
     * @param createdById the createdById
     * @return the UpdateTemplateVersionOptions builder
     */
    public Builder createdById(String createdById) {
      this.createdById = createdById;
      return this;
    }

    /**
     * Set the lastModifiedAt.
     *
     * @param lastModifiedAt the lastModifiedAt
     * @return the UpdateTemplateVersionOptions builder
     */
    public Builder lastModifiedAt(Date lastModifiedAt) {
      this.lastModifiedAt = lastModifiedAt;
      return this;
    }

    /**
     * Set the lastModifiedById.
     *
     * @param lastModifiedById the lastModifiedById
     * @return the UpdateTemplateVersionOptions builder
     */
    public Builder lastModifiedById(String lastModifiedById) {
      this.lastModifiedById = lastModifiedById;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the UpdateTemplateVersionOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the createTemplateResponse.
     *
     * @param createTemplateResponse the createTemplateResponse
     * @return the UpdateTemplateVersionOptions builder
     */
    public Builder createTemplateResponse(CreateTemplateResponse createTemplateResponse) {
      this.id = createTemplateResponse.id();
      this.name = createTemplateResponse.name();
      this.description = createTemplateResponse.description();
      this.accountId = createTemplateResponse.accountId();
      this.version = createTemplateResponse.version();
      this.committed = createTemplateResponse.committed();
      this.accessGroup = createTemplateResponse.accessGroup();
      this.policyTemplates = createTemplateResponse.policyTemplates();
      this.href = createTemplateResponse.href();
      this.createdAt = createTemplateResponse.createdAt();
      this.createdById = createTemplateResponse.createdById();
      this.lastModifiedAt = createTemplateResponse.lastModifiedAt();
      this.lastModifiedById = createTemplateResponse.lastModifiedById();
      return this;
    }
  }

  protected UpdateTemplateVersionOptions() { }

  protected UpdateTemplateVersionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.templateId,
      "templateId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.versionNum,
      "versionNum cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ifMatch,
      "ifMatch cannot be null");
    templateId = builder.templateId;
    versionNum = builder.versionNum;
    ifMatch = builder.ifMatch;
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
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a UpdateTemplateVersionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the templateId.
   *
   * ID of the template.
   *
   * @return the templateId
   */
  public String templateId() {
    return templateId;
  }

  /**
   * Gets the versionNum.
   *
   * Version number of the template.
   *
   * @return the versionNum
   */
  public String versionNum() {
    return versionNum;
  }

  /**
   * Gets the ifMatch.
   *
   * ETag value of the template version document.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
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

  /**
   * Gets the transactionId.
   *
   * transaction id in header.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }
}

