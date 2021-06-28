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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Offering kind.
 */
public class Kind extends GenericModel {

  protected String id;
  @SerializedName("format_kind")
  protected String formatKind;
  @SerializedName("target_kind")
  protected String targetKind;
  protected Map<String, Object> metadata;
  @SerializedName("install_description")
  protected String installDescription;
  protected List<String> tags;
  @SerializedName("additional_features")
  protected List<Feature> additionalFeatures;
  protected Date created;
  protected Date updated;
  protected List<Version> versions;
  protected List<Plan> plans;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String formatKind;
    private String targetKind;
    private Map<String, Object> metadata;
    private String installDescription;
    private List<String> tags;
    private List<Feature> additionalFeatures;
    private Date created;
    private Date updated;
    private List<Version> versions;
    private List<Plan> plans;

    private Builder(Kind kind) {
      this.id = kind.id;
      this.formatKind = kind.formatKind;
      this.targetKind = kind.targetKind;
      this.metadata = kind.metadata;
      this.installDescription = kind.installDescription;
      this.tags = kind.tags;
      this.additionalFeatures = kind.additionalFeatures;
      this.created = kind.created;
      this.updated = kind.updated;
      this.versions = kind.versions;
      this.plans = kind.plans;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Kind.
     *
     * @return the new Kind instance
     */
    public Kind build() {
      return new Kind(this);
    }

    /**
     * Adds an tags to tags.
     *
     * @param tags the new tags
     * @return the Kind builder
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
     * Adds an additionalFeatures to additionalFeatures.
     *
     * @param additionalFeatures the new additionalFeatures
     * @return the Kind builder
     */
    public Builder addAdditionalFeatures(Feature additionalFeatures) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(additionalFeatures,
        "additionalFeatures cannot be null");
      if (this.additionalFeatures == null) {
        this.additionalFeatures = new ArrayList<Feature>();
      }
      this.additionalFeatures.add(additionalFeatures);
      return this;
    }

    /**
     * Adds an versions to versions.
     *
     * @param versions the new versions
     * @return the Kind builder
     */
    public Builder addVersions(Version versions) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(versions,
        "versions cannot be null");
      if (this.versions == null) {
        this.versions = new ArrayList<Version>();
      }
      this.versions.add(versions);
      return this;
    }

    /**
     * Adds an plans to plans.
     *
     * @param plans the new plans
     * @return the Kind builder
     */
    public Builder addPlans(Plan plans) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(plans,
        "plans cannot be null");
      if (this.plans == null) {
        this.plans = new ArrayList<Plan>();
      }
      this.plans.add(plans);
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the Kind builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the formatKind.
     *
     * @param formatKind the formatKind
     * @return the Kind builder
     */
    public Builder formatKind(String formatKind) {
      this.formatKind = formatKind;
      return this;
    }

    /**
     * Set the targetKind.
     *
     * @param targetKind the targetKind
     * @return the Kind builder
     */
    public Builder targetKind(String targetKind) {
      this.targetKind = targetKind;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the Kind builder
     */
    public Builder metadata(Map<String, Object> metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Set the installDescription.
     *
     * @param installDescription the installDescription
     * @return the Kind builder
     */
    public Builder installDescription(String installDescription) {
      this.installDescription = installDescription;
      return this;
    }

    /**
     * Set the tags.
     * Existing tags will be replaced.
     *
     * @param tags the tags
     * @return the Kind builder
     */
    public Builder tags(List<String> tags) {
      this.tags = tags;
      return this;
    }

    /**
     * Set the additionalFeatures.
     * Existing additionalFeatures will be replaced.
     *
     * @param additionalFeatures the additionalFeatures
     * @return the Kind builder
     */
    public Builder additionalFeatures(List<Feature> additionalFeatures) {
      this.additionalFeatures = additionalFeatures;
      return this;
    }

    /**
     * Set the created.
     *
     * @param created the created
     * @return the Kind builder
     */
    public Builder created(Date created) {
      this.created = created;
      return this;
    }

    /**
     * Set the updated.
     *
     * @param updated the updated
     * @return the Kind builder
     */
    public Builder updated(Date updated) {
      this.updated = updated;
      return this;
    }

    /**
     * Set the versions.
     * Existing versions will be replaced.
     *
     * @param versions the versions
     * @return the Kind builder
     */
    public Builder versions(List<Version> versions) {
      this.versions = versions;
      return this;
    }

    /**
     * Set the plans.
     * Existing plans will be replaced.
     *
     * @param plans the plans
     * @return the Kind builder
     */
    public Builder plans(List<Plan> plans) {
      this.plans = plans;
      return this;
    }
  }

  protected Kind(Builder builder) {
    id = builder.id;
    formatKind = builder.formatKind;
    targetKind = builder.targetKind;
    metadata = builder.metadata;
    installDescription = builder.installDescription;
    tags = builder.tags;
    additionalFeatures = builder.additionalFeatures;
    created = builder.created;
    updated = builder.updated;
    versions = builder.versions;
    plans = builder.plans;
  }

  /**
   * New builder.
   *
   * @return a Kind builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * Unique ID.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the formatKind.
   *
   * content kind, e.g., helm, vm image.
   *
   * @return the formatKind
   */
  public String formatKind() {
    return formatKind;
  }

  /**
   * Gets the targetKind.
   *
   * target cloud to install, e.g., iks, open_shift_iks.
   *
   * @return the targetKind
   */
  public String targetKind() {
    return targetKind;
  }

  /**
   * Gets the metadata.
   *
   * Open ended metadata information.
   *
   * @return the metadata
   */
  public Map<String, Object> metadata() {
    return metadata;
  }

  /**
   * Gets the installDescription.
   *
   * Installation instruction.
   *
   * @return the installDescription
   */
  public String installDescription() {
    return installDescription;
  }

  /**
   * Gets the tags.
   *
   * List of tags associated with this catalog.
   *
   * @return the tags
   */
  public List<String> tags() {
    return tags;
  }

  /**
   * Gets the additionalFeatures.
   *
   * List of features associated with this offering.
   *
   * @return the additionalFeatures
   */
  public List<Feature> additionalFeatures() {
    return additionalFeatures;
  }

  /**
   * Gets the created.
   *
   * The date and time this catalog was created.
   *
   * @return the created
   */
  public Date created() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * The date and time this catalog was last updated.
   *
   * @return the updated
   */
  public Date updated() {
    return updated;
  }

  /**
   * Gets the versions.
   *
   * list of versions.
   *
   * @return the versions
   */
  public List<Version> versions() {
    return versions;
  }

  /**
   * Gets the plans.
   *
   * list of plans.
   *
   * @return the plans
   */
  public List<Plan> plans() {
    return plans;
  }
}

