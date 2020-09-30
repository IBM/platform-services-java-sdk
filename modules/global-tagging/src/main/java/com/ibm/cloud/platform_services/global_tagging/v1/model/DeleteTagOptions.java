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

  /**
   * The type of the tag. Supported values are `user` and `service`. `service` is not supported for `providers=ims`.
   */
  public interface TagType {
    /** user. */
    String USER = "user";
    /** service. */
    String SERVICE = "service";
  }

  protected String tagName;
  protected List<String> providers;
  protected String accountId;
  protected String tagType;

  /**
   * Builder.
   */
  public static class Builder {
    private String tagName;
    private List<String> providers;
    private String accountId;
    private String tagType;

    private Builder(DeleteTagOptions deleteTagOptions) {
      this.tagName = deleteTagOptions.tagName;
      this.providers = deleteTagOptions.providers;
      this.accountId = deleteTagOptions.accountId;
      this.tagType = deleteTagOptions.tagType;
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

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the DeleteTagOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the tagType.
     *
     * @param tagType the tagType
     * @return the DeleteTagOptions builder
     */
    public Builder tagType(String tagType) {
      this.tagType = tagType;
      return this;
    }
  }

  protected DeleteTagOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.tagName,
      "tagName cannot be empty");
    tagName = builder.tagName;
    providers = builder.providers;
    accountId = builder.accountId;
    tagType = builder.tagType;
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

  /**
   * Gets the accountId.
   *
   * The ID of the billing account to delete the tag for. It is a required parameter if `tag_type` is set to `service`,
   * otherwise it is inferred from the authorization IAM token.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the tagType.
   *
   * The type of the tag. Supported values are `user` and `service`. `service` is not supported for `providers=ims`.
   *
   * @return the tagType
   */
  public String tagType() {
    return tagType;
  }
}

