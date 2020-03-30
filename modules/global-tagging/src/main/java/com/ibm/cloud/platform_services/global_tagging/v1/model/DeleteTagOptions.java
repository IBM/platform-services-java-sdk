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
 * The deleteTag options.
 */
public class DeleteTagOptions extends GenericModel {

  public interface Providers {
    /** ghost. */
    String GHOST = "ghost";
    /** ims. */
    String IMS = "ims";
  }

  protected String tagName;
  protected List<String> providers;

  /**
   * Builder.
   */
  public static class Builder {
    private String tagName;
    private List<String> providers;

    private Builder(DeleteTagOptions deleteTagOptions) {
      this.tagName = deleteTagOptions.tagName;
      this.providers = deleteTagOptions.providers;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param tagName the tagName
     */
    public Builder(String tagName) {
      this.tagName = tagName;
    }

    /**
     * Builds a DeleteTagOptions.
     *
     * @return the new DeleteTagOptions instance
     */
    public DeleteTagOptions build() {
      return new DeleteTagOptions(this);
    }

    /**
     * Adds an providers to providers.
     *
     * @param providers the new providers
     * @return the DeleteTagOptions builder
     */
    public Builder addProviders(String providers) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(providers,
        "providers cannot be null");
      if (this.providers == null) {
        this.providers = new ArrayList<String>();
      }
      this.providers.add(providers);
      return this;
    }

    /**
     * Set the tagName.
     *
     * @param tagName the tagName
     * @return the DeleteTagOptions builder
     */
    public Builder tagName(String tagName) {
      this.tagName = tagName;
      return this;
    }

    /**
     * Set the providers.
     * Existing providers will be replaced.
     *
     * @param providers the providers
     * @return the DeleteTagOptions builder
     */
    public Builder providers(List<String> providers) {
      this.providers = providers;
      return this;
    }
  }

  protected DeleteTagOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.tagName,
      "tagName cannot be empty");
    tagName = builder.tagName;
    providers = builder.providers;
  }

  /**
   * New builder.
   *
   * @return a DeleteTagOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the tagName.
   *
   * The name of tag to be deleted.
   *
   * @return the tagName
   */
  public String tagName() {
    return tagName;
  }

  /**
   * Gets the providers.
   *
   * Select a provider. Supported values are `ghost` and `ims`. To delete tag both in GhoST in IMS, use `ghost,ims`.
   *
   * @return the providers
   */
  public List<String> providers() {
    return providers;
  }
}

