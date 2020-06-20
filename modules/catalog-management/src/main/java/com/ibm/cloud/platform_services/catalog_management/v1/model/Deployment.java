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
package com.ibm.cloud.platform_services.catalog_management.v1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Deployment for offering.
 */
public class Deployment extends GenericModel {

  protected String id;
  protected String label;
  protected String name;
  @SerializedName("short_description")
  protected String shortDescription;
  @SerializedName("long_description")
  protected String longDescription;
  protected Map<String, Object> metadata;
  protected List<String> tags;
  protected Date created;
  protected Date updated;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String label;
    private String name;
    private String shortDescription;
    private String longDescription;
    private Map<String, Object> metadata;
    private List<String> tags;
    private Date created;
    private Date updated;

    private Builder(Deployment deployment) {
      this.id = deployment.id;
      this.label = deployment.label;
      this.name = deployment.name;
      this.shortDescription = deployment.shortDescription;
      this.longDescription = deployment.longDescription;
      this.metadata = deployment.metadata;
      this.tags = deployment.tags;
      this.created = deployment.created;
      this.updated = deployment.updated;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Deployment.
     *
     * @return the new Deployment instance
     */
    public Deployment build() {
      return new Deployment(this);
    }

    /**
     * Adds an tags to tags.
     *
     * @param tags the new tags
     * @return the Deployment builder
     */
    public Builder addTags(String tags) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(tags,
        "tags cannot be null");
      if (this.tags == null) {
        this.tags = new ArrayList<String>();
      }
      this.tags.add(tags);
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the Deployment builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the label.
     *
     * @param label the label
     * @return the Deployment builder
     */
    public Builder label(String label) {
      this.label = label;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the Deployment builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the shortDescription.
     *
     * @param shortDescription the shortDescription
     * @return the Deployment builder
     */
    public Builder shortDescription(String shortDescription) {
      this.shortDescription = shortDescription;
      return this;
    }

    /**
     * Set the longDescription.
     *
     * @param longDescription the longDescription
     * @return the Deployment builder
     */
    public Builder longDescription(String longDescription) {
      this.longDescription = longDescription;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the Deployment builder
     */
    public Builder metadata(Map<String, Object> metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Set the tags.
     * Existing tags will be replaced.
     *
     * @param tags the tags
     * @return the Deployment builder
     */
    public Builder tags(List<String> tags) {
      this.tags = tags;
      return this;
    }

    /**
     * Set the created.
     *
     * @param created the created
     * @return the Deployment builder
     */
    public Builder created(Date created) {
      this.created = created;
      return this;
    }

    /**
     * Set the updated.
     *
     * @param updated the updated
     * @return the Deployment builder
     */
    public Builder updated(Date updated) {
      this.updated = updated;
      return this;
    }
  }

  protected Deployment(Builder builder) {
    id = builder.id;
    label = builder.label;
    name = builder.name;
    shortDescription = builder.shortDescription;
    longDescription = builder.longDescription;
    metadata = builder.metadata;
    tags = builder.tags;
    created = builder.created;
    updated = builder.updated;
  }

  /**
   * New builder.
   *
   * @return a Deployment builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * unique id.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the label.
   *
   * Display Name in the requested language.
   *
   * @return the label
   */
  public String label() {
    return label;
  }

  /**
   * Gets the name.
   *
   * The programmatic name of this offering.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the shortDescription.
   *
   * Short description in the requested language.
   *
   * @return the shortDescription
   */
  public String shortDescription() {
    return shortDescription;
  }

  /**
   * Gets the longDescription.
   *
   * Long description in the requested language.
   *
   * @return the longDescription
   */
  public String longDescription() {
    return longDescription;
  }

  /**
   * Gets the metadata.
   *
   * open ended metadata information.
   *
   * @return the metadata
   */
  public Map<String, Object> metadata() {
    return metadata;
  }

  /**
   * Gets the tags.
   *
   * list of tags associated with this catalog.
   *
   * @return the tags
   */
  public List<String> tags() {
    return tags;
  }

  /**
   * Gets the created.
   *
   * the date'time this catalog was created.
   *
   * @return the created
   */
  public Date created() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * the date'time this catalog was last updated.
   *
   * @return the updated
   */
  public Date updated() {
    return updated;
  }
}

