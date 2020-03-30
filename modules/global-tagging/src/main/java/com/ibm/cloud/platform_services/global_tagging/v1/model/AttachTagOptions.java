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

  protected List<Resource> resources;
  protected String tagName;
  protected List<String> tagNames;

  /**
   * Builder.
   */
  public static class Builder {
    private List<Resource> resources;
    private String tagName;
    private List<String> tagNames;

    private Builder(AttachTagOptions attachTagOptions) {
      this.resources = attachTagOptions.resources;
      this.tagName = attachTagOptions.tagName;
      this.tagNames = attachTagOptions.tagNames;
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
  }

  protected AttachTagOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.resources,
      "resources cannot be null");
    resources = builder.resources;
    tagName = builder.tagName;
    tagNames = builder.tagNames;
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
}

