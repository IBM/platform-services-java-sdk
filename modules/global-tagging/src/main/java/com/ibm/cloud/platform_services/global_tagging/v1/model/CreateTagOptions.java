/*
 * (C) Copyright IBM Corp. 2021.
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
package com.ibm.cloud.platform_services.global_tagging.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createTag options.
 */
public class CreateTagOptions extends GenericModel {

  /**
   * The type of the tags you want to create. The only allowed value is `access`.
   */
  public interface TagType {
    /** access. */
    String ACCESS = "access";
  }

  protected List<String> tagNames;
  protected String impersonateUser;
  protected String accountId;
  protected String tagType;

  /**
   * Builder.
   */
  public static class Builder {
    private List<String> tagNames;
    private String impersonateUser;
    private String accountId;
    private String tagType;

    private Builder(CreateTagOptions createTagOptions) {
      this.tagNames = createTagOptions.tagNames;
      this.impersonateUser = createTagOptions.impersonateUser;
      this.accountId = createTagOptions.accountId;
      this.tagType = createTagOptions.tagType;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param tagNames the tagNames
     */
    public Builder(List<String> tagNames) {
      this.tagNames = tagNames;
    }

    /**
     * Builds a CreateTagOptions.
     *
     * @return the new CreateTagOptions instance
     */
    public CreateTagOptions build() {
      return new CreateTagOptions(this);
    }

    /**
     * Adds an tagNames to tagNames.
     *
     * @param tagNames the new tagNames
     * @return the CreateTagOptions builder
     */
    public Builder addTagNames(String tagNames) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(tagNames,
        "tagNames cannot be null");
      if (this.tagNames == null) {
        this.tagNames = new ArrayList<String>();
      }
      this.tagNames.add(tagNames);
      return this;
    }

    /**
     * Set the tagNames.
     * Existing tagNames will be replaced.
     *
     * @param tagNames the tagNames
     * @return the CreateTagOptions builder
     */
    public Builder tagNames(List<String> tagNames) {
      this.tagNames = tagNames;
      return this;
    }

    /**
     * Set the impersonateUser.
     *
     * @param impersonateUser the impersonateUser
     * @return the CreateTagOptions builder
     */
    public Builder impersonateUser(String impersonateUser) {
      this.impersonateUser = impersonateUser;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreateTagOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the tagType.
     *
     * @param tagType the tagType
     * @return the CreateTagOptions builder
     */
    public Builder tagType(String tagType) {
      this.tagType = tagType;
      return this;
    }
  }

  protected CreateTagOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.tagNames,
      "tagNames cannot be null");
    tagNames = builder.tagNames;
    impersonateUser = builder.impersonateUser;
    accountId = builder.accountId;
    tagType = builder.tagType;
  }

  /**
   * New builder.
   *
   * @return a CreateTagOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the tagNames.
   *
   * An array of tag names to create.
   *
   * @return the tagNames
   */
  public List<String> tagNames() {
    return tagNames;
  }

  /**
   * Gets the impersonateUser.
   *
   * The user on whose behalf the create operation must be performed (_for administrators only_).
   *
   * @return the impersonateUser
   */
  public String impersonateUser() {
    return impersonateUser;
  }

  /**
   * Gets the accountId.
   *
   * The ID of the billing account where the tag must be created. It is a required parameter if `impersonate_user` is
   * set.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the tagType.
   *
   * The type of the tags you want to create. The only allowed value is `access`.
   *
   * @return the tagType
   */
  public String tagType() {
    return tagType;
  }
}

