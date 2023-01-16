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
   * The type of the tag. Supported values are `user`, `service` and `access`. `service` and `access` are not supported
   * for IMS resources (`providers` parameter set to `ims`).
   */
  public interface TagType {
    /** user. */
    String USER = "user";
    /** service. */
    String SERVICE = "service";
    /** access. */
    String ACCESS = "access";
  }

  protected String transactionId;
  protected String providers;
  protected String impersonateUser;
  protected String accountId;
  protected String tagType;

  /**
   * Builder.
   */
  public static class Builder {
    private String transactionId;
    private String providers;
    private String impersonateUser;
    private String accountId;
    private String tagType;

    /**
     * Instantiates a new Builder from an existing DeleteTagAllOptions instance.
     *
     * @param deleteTagAllOptions the instance to initialize the Builder with
     */
    private Builder(DeleteTagAllOptions deleteTagAllOptions) {
      this.transactionId = deleteTagAllOptions.transactionId;
      this.providers = deleteTagAllOptions.providers;
      this.impersonateUser = deleteTagAllOptions.impersonateUser;
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
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the DeleteTagAllOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
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
     * Set the impersonateUser.
     *
     * @param impersonateUser the impersonateUser
     * @return the DeleteTagAllOptions builder
     */
    public Builder impersonateUser(String impersonateUser) {
      this.impersonateUser = impersonateUser;
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

  protected DeleteTagAllOptions() { }

  protected DeleteTagAllOptions(Builder builder) {
    transactionId = builder.transactionId;
    providers = builder.providers;
    impersonateUser = builder.impersonateUser;
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
   * Gets the transactionId.
   *
   * An alphanumeric string that can be used to trace a request across services. If not specified, it automatically
   * generated with the prefix "gst-".
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
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
   * Gets the impersonateUser.
   *
   * The user on whose behalf the delete all operation must be performed (_for administrators only_).
   *
   * @return the impersonateUser
   */
  public String impersonateUser() {
    return impersonateUser;
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
   * The type of the tag. Supported values are `user`, `service` and `access`. `service` and `access` are not supported
   * for IMS resources (`providers` parameter set to `ims`).
   *
   * @return the tagType
   */
  public String tagType() {
    return tagType;
  }
}
