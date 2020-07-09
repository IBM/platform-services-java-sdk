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

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * An entry in the global catalog.
 */
public class CatalogEntry extends GenericModel {

  /**
   * The type of catalog entry, **service**, **template**, **dashboard**, which determines the type and shape of the
   * object.
   */
  public interface Kind {
    /** service. */
    String SERVICE = "service";
    /** template. */
    String TEMPLATE = "template";
    /** dashboard. */
    String DASHBOARD = "dashboard";
  }

  protected String name;
  protected String kind;
  @SerializedName("overview_ui")
  protected Map<String, Overview> overviewUi;
  protected Image images;
  @SerializedName("parent_id")
  protected String parentId;
  protected Boolean disabled;
  protected List<String> tags;
  protected Boolean group;
  protected Provider provider;
  protected Boolean active;
  protected CatalogEntryMetadata metadata;
  protected String id;
  @SerializedName("catalog_crn")
  protected Object catalogCrn;
  protected Object url;
  @SerializedName("children_url")
  protected Object childrenUrl;
  @SerializedName("geo_tags")
  protected Object geoTags;
  @SerializedName("pricing_tags")
  protected Object pricingTags;
  protected Object created;
  protected Object updated;

  /**
   * Gets the name.
   *
   * Programmatic name for this catalog entry, which must be formatted like a CRN segment. See the display name in
   * OverviewUI for a user-readable name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the kind.
   *
   * The type of catalog entry, **service**, **template**, **dashboard**, which determines the type and shape of the
   * object.
   *
   * @return the kind
   */
  public String getKind() {
    return kind;
  }

  /**
   * Gets the overviewUi.
   *
   * Overview is nested in the top level. The key value pair is `[_language_]overview_ui`.
   *
   * @return the overviewUi
   */
  public Map<String, Overview> getOverviewUi() {
    return overviewUi;
  }

  /**
   * Gets the images.
   *
   * Image annotation for this catalog entry. The image is a URL.
   *
   * @return the images
   */
  public Image getImages() {
    return images;
  }

  /**
   * Gets the parentId.
   *
   * The ID of the parent catalog entry if it exists.
   *
   * @return the parentId
   */
  public String getParentId() {
    return parentId;
  }

  /**
   * Gets the disabled.
   *
   * Boolean value that determines the global visibility for the catalog entry, and its children. If it is not enabled,
   * all plans are disabled.
   *
   * @return the disabled
   */
  public Boolean isDisabled() {
    return disabled;
  }

  /**
   * Gets the tags.
   *
   * A list of tags. For example, IBM, 3rd Party, Beta, GA, and Single Tenant.
   *
   * @return the tags
   */
  public List<String> getTags() {
    return tags;
  }

  /**
   * Gets the group.
   *
   * Boolean value that determines whether the catalog entry is a group.
   *
   * @return the group
   */
  public Boolean isGroup() {
    return group;
  }

  /**
   * Gets the provider.
   *
   * Information related to the provider associated with a catalog entry.
   *
   * @return the provider
   */
  public Provider getProvider() {
    return provider;
  }

  /**
   * Gets the active.
   *
   * Boolean value that describes whether the service is active.
   *
   * @return the active
   */
  public Boolean isActive() {
    return active;
  }

  /**
   * Gets the metadata.
   *
   * Model used to describe metadata object returned.
   *
   * @return the metadata
   */
  public CatalogEntryMetadata getMetadata() {
    return metadata;
  }

  /**
   * Gets the id.
   *
   * Catalog entry's unique ID. It's the same across all catalog instances.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the catalogCrn.
   *
   * @return the catalogCrn
   */
  public Object getCatalogCrn() {
    return catalogCrn;
  }

  /**
   * Gets the url.
   *
   * URL to get details about this object.
   *
   * @return the url
   */
  public Object getUrl() {
    return url;
  }

  /**
   * Gets the childrenUrl.
   *
   * URL to get details about children of this object.
   *
   * @return the childrenUrl
   */
  public Object getChildrenUrl() {
    return childrenUrl;
  }

  /**
   * Gets the geoTags.
   *
   * tags to indicate the locations this service is deployable to.
   *
   * @return the geoTags
   */
  public Object getGeoTags() {
    return geoTags;
  }

  /**
   * Gets the pricingTags.
   *
   * tags to indicate the type of pricing plans this service supports.
   *
   * @return the pricingTags
   */
  public Object getPricingTags() {
    return pricingTags;
  }

  /**
   * Gets the created.
   *
   * Date created.
   *
   * @return the created
   */
  public Object getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * Date last updated.
   *
   * @return the updated
   */
  public Object getUpdated() {
    return updated;
  }
}

