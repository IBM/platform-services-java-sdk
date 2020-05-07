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
 * The listCatalogEntries options.
 */
public class ListCatalogEntriesOptions extends GenericModel {

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
    private String account;
    private String include;
    private String q;
    private String sortBy;
    private String descending;
    private String languages;
    private String complete;

    private Builder(ListCatalogEntriesOptions listCatalogEntriesOptions) {
      this.account = listCatalogEntriesOptions.account;
      this.include = listCatalogEntriesOptions.include;
      this.q = listCatalogEntriesOptions.q;
      this.sortBy = listCatalogEntriesOptions.sortBy;
      this.descending = listCatalogEntriesOptions.descending;
      this.languages = listCatalogEntriesOptions.languages;
      this.complete = listCatalogEntriesOptions.complete;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListCatalogEntriesOptions.
     *
     * @return the new ListCatalogEntriesOptions instance
     */
    public ListCatalogEntriesOptions build() {
      return new ListCatalogEntriesOptions(this);
    }

    /**
     * Set the account.
     *
     * @param account the account
     * @return the ListCatalogEntriesOptions builder
     */
    public Builder account(String account) {
      this.account = account;
      return this;
    }

    /**
     * Set the include.
     *
     * @param include the include
     * @return the ListCatalogEntriesOptions builder
     */
    public Builder include(String include) {
      this.include = include;
      return this;
    }

    /**
     * Set the q.
     *
     * @param q the q
     * @return the ListCatalogEntriesOptions builder
     */
    public Builder q(String q) {
      this.q = q;
      return this;
    }

    /**
     * Set the sortBy.
     *
     * @param sortBy the sortBy
     * @return the ListCatalogEntriesOptions builder
     */
    public Builder sortBy(String sortBy) {
      this.sortBy = sortBy;
      return this;
    }

    /**
     * Set the descending.
     *
     * @param descending the descending
     * @return the ListCatalogEntriesOptions builder
     */
    public Builder descending(String descending) {
      this.descending = descending;
      return this;
    }

    /**
     * Set the languages.
     *
     * @param languages the languages
     * @return the ListCatalogEntriesOptions builder
     */
    public Builder languages(String languages) {
      this.languages = languages;
      return this;
    }

    /**
     * Set the complete.
     *
     * @param complete the complete
     * @return the ListCatalogEntriesOptions builder
     */
    public Builder complete(String complete) {
      this.complete = complete;
      return this;
    }
  }

  protected ListCatalogEntriesOptions(Builder builder) {
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
   * @return a ListCatalogEntriesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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
   * A wildcard (`*`) includes all properties for an object, for example `GET /?include=*`. To include specific metadata
   * fields, separate each field with a colon (:), for example `GET /?include=metadata.ui:metadata.pricing`.
   *
   * @return the include
   */
  public String include() {
    return include;
  }

  /**
   * Gets the q.
   *
   * Searches the catalog entries for keywords. Add filters to refine your search. A query filter, for example,
   * `q=kind:iaas service_name rc:true`, filters entries of kind iaas with metadata.service.rc_compatible set to true
   * and  have a service name is in their name, display name, or description.  Valid tags are **kind**:&lt;string&gt;,
   * **tag**:&lt;strging&gt;, **rc**:[true|false], **iam**:[true|false], **active**:[true|false],
   * **geo**:&lt;string&gt;, and **price**:&lt;string&gt;.
   *
   * @return the q
   */
  public String q() {
    return q;
  }

  /**
   * Gets the sortBy.
   *
   * The field on which the output is sorted. Sorts by default by **name** property. Available fields are **name**,
   * **displayname** (overview_ui.display_name), **kind**, **provider** (provider.name), **sbsindex**
   * (metadata.ui.side_by_side_index), and the time **created**, and **updated**.
   *
   * @return the sortBy
   */
  public String sortBy() {
    return sortBy;
  }

  /**
   * Gets the descending.
   *
   * Sets the sort order. The default is false, which is ascending.
   *
   * @return the descending
   */
  public String descending() {
    return descending;
  }

  /**
   * Gets the languages.
   *
   * Return the data strings in a specified langauge. By default, the strings returned are of the language preferred by
   * your browser through the Accept-Langauge header, which allows an override of the header. Languages are specified in
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
  public String complete() {
    return complete;
  }
}

