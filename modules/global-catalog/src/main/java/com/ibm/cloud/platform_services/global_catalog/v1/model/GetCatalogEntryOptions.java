/*
 * (C) Copyright IBM Corp. 2025.
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

package com.ibm.cloud.platform_services.global_catalog.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getCatalogEntry options.
 */
public class GetCatalogEntryOptions extends GenericModel {

  protected String id;
  protected String account;
  protected String include;
  protected String languages;
  protected Boolean complete;
  protected Long depth;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String account;
    private String include;
    private String languages;
    private Boolean complete;
    private Long depth;

    /**
     * Instantiates a new Builder from an existing GetCatalogEntryOptions instance.
     *
     * @param getCatalogEntryOptions the instance to initialize the Builder with
     */
    private Builder(GetCatalogEntryOptions getCatalogEntryOptions) {
      this.id = getCatalogEntryOptions.id;
      this.account = getCatalogEntryOptions.account;
      this.include = getCatalogEntryOptions.include;
      this.languages = getCatalogEntryOptions.languages;
      this.complete = getCatalogEntryOptions.complete;
      this.depth = getCatalogEntryOptions.depth;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param id the id
     */
    public Builder(String id) {
      this.id = id;
    }

    /**
     * Builds a GetCatalogEntryOptions.
     *
     * @return the new GetCatalogEntryOptions instance
     */
    public GetCatalogEntryOptions build() {
      return new GetCatalogEntryOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the GetCatalogEntryOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the account.
     *
     * @param account the account
     * @return the GetCatalogEntryOptions builder
     */
    public Builder account(String account) {
      this.account = account;
      return this;
    }

    /**
     * Set the include.
     *
     * @param include the include
     * @return the GetCatalogEntryOptions builder
     */
    public Builder include(String include) {
      this.include = include;
      return this;
    }

    /**
     * Set the languages.
     *
     * @param languages the languages
     * @return the GetCatalogEntryOptions builder
     */
    public Builder languages(String languages) {
      this.languages = languages;
      return this;
    }

    /**
     * Set the complete.
     *
     * @param complete the complete
     * @return the GetCatalogEntryOptions builder
     */
    public Builder complete(Boolean complete) {
      this.complete = complete;
      return this;
    }

    /**
     * Set the depth.
     *
     * @param depth the depth
     * @return the GetCatalogEntryOptions builder
     */
    public Builder depth(long depth) {
      this.depth = depth;
      return this;
    }
  }

  protected GetCatalogEntryOptions() { }

  protected GetCatalogEntryOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    id = builder.id;
    account = builder.account;
    include = builder.include;
    languages = builder.languages;
    complete = builder.complete;
    depth = builder.depth;
  }

  /**
   * New builder.
   *
   * @return a GetCatalogEntryOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The catalog entry's unique ID.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the account.
   *
   * This changes the scope of the request regardless of the authorization header. Example scopes are `account` and
   * `global`. `account=global` is reqired if operating with a service ID that has a global admin policy, for example
   * `GET /?account=global`.
   *
   * @return the account
   */
  public String account() {
    return account;
  }

  /**
   * Gets the include.
   *
   * A GET call by default returns a basic set of properties. To include other properties, you must add this parameter.
   * A wildcard (`*`) includes all properties for an object, for example `GET /id?include=*`. To include specific
   * metadata fields, separate each field with a colon (:), for example `GET /id?include=metadata.ui:metadata.pricing`.
   *
   * @return the include
   */
  public String include() {
    return include;
  }

  /**
   * Gets the languages.
   *
   * Return the data strings in the specified language. By default the strings returned are of the language preferred by
   * your browser through the Accept-Language header, which allows an override of the header. Languages are specified in
   * standard form, such as `en-us`. To include all languages use a wildcard (*).
   *
   * @return the languages
   */
  public String languages() {
    return languages;
  }

  /**
   * Gets the complete.
   *
   * Returns all available fields for all languages. Use the value `?complete=true` as shortcut for
   * ?include=*&amp;languages=*.
   *
   * @return the complete
   */
  public Boolean complete() {
    return complete;
  }

  /**
   * Gets the depth.
   *
   * Return the children down to the requested depth. Use * to include the entire children tree. If there are more
   * children than the maximum permitted an error will be returned. Be judicious with this as it can cause a large
   * number of database accesses and can result in a large amount of data returned.
   *
   * @return the depth
   */
  public Long depth() {
    return depth;
  }
}

