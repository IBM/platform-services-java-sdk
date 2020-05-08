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
package com.ibm.cloud.platform_services.global_catalog.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getChildObjects options.
 */
public class GetChildObjectsOptions extends GenericModel {

  protected String id;
  protected String kind;
  protected String account;
  protected String include;
  protected String q;
  protected String sortBy;
  protected String descending;
  protected String languages;
  protected String complete;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String kind;
    private String account;
    private String include;
    private String q;
    private String sortBy;
    private String descending;
    private String languages;
    private String complete;

    private Builder(GetChildObjectsOptions getChildObjectsOptions) {
      this.id = getChildObjectsOptions.id;
      this.kind = getChildObjectsOptions.kind;
      this.account = getChildObjectsOptions.account;
      this.include = getChildObjectsOptions.include;
      this.q = getChildObjectsOptions.q;
      this.sortBy = getChildObjectsOptions.sortBy;
      this.descending = getChildObjectsOptions.descending;
      this.languages = getChildObjectsOptions.languages;
      this.complete = getChildObjectsOptions.complete;
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
     * @param kind the kind
     */
    public Builder(String id, String kind) {
      this.id = id;
      this.kind = kind;
    }

    /**
     * Builds a GetChildObjectsOptions.
     *
     * @return the new GetChildObjectsOptions instance
     */
    public GetChildObjectsOptions build() {
      return new GetChildObjectsOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the GetChildObjectsOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the kind.
     *
     * @param kind the kind
     * @return the GetChildObjectsOptions builder
     */
    public Builder kind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Set the account.
     *
     * @param account the account
     * @return the GetChildObjectsOptions builder
     */
    public Builder account(String account) {
      this.account = account;
      return this;
    }

    /**
     * Set the include.
     *
     * @param include the include
     * @return the GetChildObjectsOptions builder
     */
    public Builder include(String include) {
      this.include = include;
      return this;
    }

    /**
     * Set the q.
     *
     * @param q the q
     * @return the GetChildObjectsOptions builder
     */
    public Builder q(String q) {
      this.q = q;
      return this;
    }

    /**
     * Set the sortBy.
     *
     * @param sortBy the sortBy
     * @return the GetChildObjectsOptions builder
     */
    public Builder sortBy(String sortBy) {
      this.sortBy = sortBy;
      return this;
    }

    /**
     * Set the descending.
     *
     * @param descending the descending
     * @return the GetChildObjectsOptions builder
     */
    public Builder descending(String descending) {
      this.descending = descending;
      return this;
    }

    /**
     * Set the languages.
     *
     * @param languages the languages
     * @return the GetChildObjectsOptions builder
     */
    public Builder languages(String languages) {
      this.languages = languages;
      return this;
    }

    /**
     * Set the complete.
     *
     * @param complete the complete
     * @return the GetChildObjectsOptions builder
     */
    public Builder complete(String complete) {
      this.complete = complete;
      return this;
    }
  }

  protected GetChildObjectsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.kind,
      "kind cannot be empty");
    id = builder.id;
    kind = builder.kind;
    account = builder.account;
    include = builder.include;
    q = builder.q;
    sortBy = builder.sortBy;
    descending = builder.descending;
    languages = builder.languages;
    complete = builder.complete;
  }

  /**
   * New builder.
   *
   * @return a GetChildObjectsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The parent catalog entry's ID.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the kind.
   *
   * The **kind** of child catalog entries to search for. A wildcard (*) includes all child catalog entries for all
   * kinds, for example `GET /service_name/_*`.
   *
   * @return the kind
   */
  public String kind() {
    return kind;
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
   * A colon (:) separated list of properties to include. A GET call by defaults return a limited set of properties. To
   * include other properties, you must add the include parameter.  A wildcard (*) includes all properties.
   *
   * @return the include
   */
  public String include() {
    return include;
  }

  /**
   * Gets the q.
   *
   * A query filter, for example, `q=kind:iaas IBM`  will filter on entries of **kind** iaas that has `IBM` in their
   * name, display name, or description.
   *
   * @return the q
   */
  public String q() {
    return q;
  }

  /**
   * Gets the sortBy.
   *
   * The field on which to sort the output. By default by name. Available fields are **name**, **kind**, and
   * **provider**.
   *
   * @return the sortBy
   */
  public String sortBy() {
    return sortBy;
  }

  /**
   * Gets the descending.
   *
   * The sort order. The default is false, which is ascending.
   *
   * @return the descending
   */
  public String descending() {
    return descending;
  }

  /**
   * Gets the languages.
   *
   * Return the data strings in the specified langauge. By default the strings returned are of the language preferred by
   * your browser through the Accept-Langauge header. This allows an override of the header. Languages are specified in
   * standard form, such as `en-us`. To include all languages use the wildcard (*).
   *
   * @return the languages
   */
  public String languages() {
    return languages;
  }

  /**
   * Gets the complete.
   *
   * Use the value `?complete=true` as shortcut for ?include=*&amp;languages=*.
   *
   * @return the complete
   */
  public String complete() {
    return complete;
  }
}

