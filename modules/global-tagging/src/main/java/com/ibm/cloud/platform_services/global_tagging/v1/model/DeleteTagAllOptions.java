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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The deleteTagAll options.
 */
public class DeleteTagAllOptions extends GenericModel {

  /**
   * Select a provider. Supported values are `ghost` and `ims`.
   */
  public interface Providers {
    /** ghost. */
    String GHOST = "ghost";
    /** ims. */
    String IMS = "ims";
  }

  /**
   * The type of the tag. Supported values are `user` and `service`. `service` is not supported if the `providers`
   * parameter is set to `ims`.
   */
  public interface TagType {
    /** user. */
    String USER = "user";
    /** service. */
    String SERVICE = "service";
  }

  protected String providers;
  protected String accountId;
  protected String tagType;

  /**
   * Builder.
   */
  public static class Builder {
    private String providers;
    private String accountId;
    private String tagType;

    private Builder(DeleteTagAllOptions deleteTagAllOptions) {
      this.providers = deleteTagAllOptions.providers;
      this.accountId = deleteTagAllOptions.accountId;
      this.tagType = deleteTagAllOptions.tagType;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a DeleteTagAllOptions.
     *
     * @return the new DeleteTagAllOptions instance
     */
    public DeleteTagAllOptions build() {
      return new DeleteTagAllOptions(this);
    }

    /**
     * Set the providers.
     *
     * @param providers the providers
     * @return the DeleteTagAllOptions builder
     */
    public Builder providers(String providers) {
      this.providers = providers;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the DeleteTagAllOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the tagType.
     *
     * @param tagType the tagType
     * @return the DeleteTagAllOptions builder
     */
    public Builder tagType(String tagType) {
      this.tagType = tagType;
      return this;
    }
  }

  protected DeleteTagAllOptions(Builder builder) {
    providers = builder.providers;
    accountId = builder.accountId;
    tagType = builder.tagType;
  }

  /**
   * New builder.
   *
   * @return a DeleteTagAllOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the providers.
   *
   * Select a provider. Supported values are `ghost` and `ims`.
   *
   * @return the providers
   */
  public String providers() {
    return providers;
  }

  /**
   * Gets the accountId.
   *
   * The ID of the billing account to delete the tags for. If it is not set, then it is taken from the authorization
   * token. It is a required parameter if `tag_type` is set to `service`.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the tagType.
   *
   * The type of the tag. Supported values are `user` and `service`. `service` is not supported if the `providers`
   * parameter is set to `ims`.
   *
   * @return the tagType
   */
  public String tagType() {
    return tagType;
  }
}

