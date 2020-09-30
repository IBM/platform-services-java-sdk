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
package com.ibm.cloud.platform_services.global_tagging.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The attachTag options.
 */
public class AttachTagOptions extends GenericModel {

  /**
   * The type of the tag. Supported values are `user` and `service`. `service` is not supported if `providers` is set to
   * `ims`.
   */
  public interface TagType {
    /** user. */
    String USER = "user";
    /** service. */
    String SERVICE = "service";
  }

  protected List<Resource> resources;
  protected String tagName;
  protected List<String> tagNames;
  protected String accountId;
  protected String tagType;

  /**
   * Builder.
   */
  public static class Builder {
    private List<Resource> resources;
    private String tagName;
    private List<String> tagNames;
    private String accountId;
    private String tagType;

    private Builder(AttachTagOptions attachTagOptions) {
      this.resources = attachTagOptions.resources;
      this.tagName = attachTagOptions.tagName;
      this.tagNames = attachTagOptions.tagNames;
      this.accountId = attachTagOptions.accountId;
      this.tagType = attachTagOptions.tagType;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param resources the resources
     */
    public Builder(List<Resource> resources) {
      this.resources = resources;
    }

    /**
     * Builds a AttachTagOptions.
     *
     * @return the new AttachTagOptions instance
     */
    public AttachTagOptions build() {
      return new AttachTagOptions(this);
    }

    /**
     * Adds an resources to resources.
     *
     * @param resources the new resources
     * @return the AttachTagOptions builder
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
     * Adds an tagNames to tagNames.
     *
     * @param tagNames the new tagNames
     * @return the AttachTagOptions builder
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
     * Set the resources.
     * Existing resources will be replaced.
     *
     * @param resources the resources
     * @return the AttachTagOptions builder
     */
    public Builder resources(List<Resource> resources) {
      this.resources = resources;
      return this;
    }

    /**
     * Set the tagName.
     *
     * @param tagName the tagName
     * @return the AttachTagOptions builder
     */
    public Builder tagName(String tagName) {
      this.tagName = tagName;
      return this;
    }

    /**
     * Set the tagNames.
     * Existing tagNames will be replaced.
     *
     * @param tagNames the tagNames
     * @return the AttachTagOptions builder
     */
    public Builder tagNames(List<String> tagNames) {
      this.tagNames = tagNames;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the AttachTagOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the tagType.
     *
     * @param tagType the tagType
     * @return the AttachTagOptions builder
     */
    public Builder tagType(String tagType) {
      this.tagType = tagType;
      return this;
    }
  }

  protected AttachTagOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.resources,
      "resources cannot be null");
    resources = builder.resources;
    tagName = builder.tagName;
    tagNames = builder.tagNames;
    accountId = builder.accountId;
    tagType = builder.tagType;
  }

  /**
   * New builder.
   *
   * @return a AttachTagOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the resources.
   *
   * List of resources on which the tag or tags should be attached.
   *
   * @return the resources
   */
  public List<Resource> resources() {
    return resources;
  }

  /**
   * Gets the tagName.
   *
   * The name of the tag to attach.
   *
   * @return the tagName
   */
  public String tagName() {
    return tagName;
  }

  /**
   * Gets the tagNames.
   *
   * An array of tag names to attach.
   *
   * @return the tagNames
   */
  public List<String> tagNames() {
    return tagNames;
  }

  /**
   * Gets the accountId.
   *
   * The ID of the billing account where the resources to be tagged lives. It is a required parameter if `tag_type` is
   * set to `service`. Otherwise, it is inferred from the authorization IAM token.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the tagType.
   *
   * The type of the tag. Supported values are `user` and `service`. `service` is not supported if `providers` is set to
   * `ims`.
   *
   * @return the tagType
   */
  public String tagType() {
    return tagType;
  }
}

