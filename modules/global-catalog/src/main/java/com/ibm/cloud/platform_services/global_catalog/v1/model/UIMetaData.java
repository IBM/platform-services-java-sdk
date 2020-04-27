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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Information related to the UI presentation associated with a catalog entry.
 */
public class UIMetaData extends GenericModel {

  protected I18N strings;
  protected URLS urls;
  @SerializedName("embeddable_dashboard")
  protected String embeddableDashboard;
  @SerializedName("embeddable_dashboard_full_width")
  protected Boolean embeddableDashboardFullWidth;
  @SerializedName("navigation_order")
  protected List<String> navigationOrder;
  @SerializedName("not_creatable")
  protected Boolean notCreatable;
  protected Boolean reservable;
  @SerializedName("primary_offering_id")
  protected String primaryOfferingId;
  @SerializedName("accessible_during_provision")
  protected Boolean accessibleDuringProvision;
  @SerializedName("side_by_side_index")
  protected Long sideBySideIndex;
  @SerializedName("end_of_service_time")
  protected Date endOfServiceTime;

  /**
   * Builder.
   */
  public static class Builder {
    private I18N strings;
    private URLS urls;
    private String embeddableDashboard;
    private Boolean embeddableDashboardFullWidth;
    private List<String> navigationOrder;
    private Boolean notCreatable;
    private Boolean reservable;
    private String primaryOfferingId;
    private Boolean accessibleDuringProvision;
    private Long sideBySideIndex;
    private Date endOfServiceTime;

    private Builder(UIMetaData uiMetaData) {
      this.strings = uiMetaData.strings;
      this.urls = uiMetaData.urls;
      this.embeddableDashboard = uiMetaData.embeddableDashboard;
      this.embeddableDashboardFullWidth = uiMetaData.embeddableDashboardFullWidth;
      this.navigationOrder = uiMetaData.navigationOrder;
      this.notCreatable = uiMetaData.notCreatable;
      this.reservable = uiMetaData.reservable;
      this.primaryOfferingId = uiMetaData.primaryOfferingId;
      this.accessibleDuringProvision = uiMetaData.accessibleDuringProvision;
      this.sideBySideIndex = uiMetaData.sideBySideIndex;
      this.endOfServiceTime = uiMetaData.endOfServiceTime;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a UIMetaData.
     *
     * @return the new UIMetaData instance
     */
    public UIMetaData build() {
      return new UIMetaData(this);
    }

    /**
     * Adds an navigationOrder to navigationOrder.
     *
     * @param navigationOrder the new navigationOrder
     * @return the UIMetaData builder
     */
    public Builder addNavigationOrder(String navigationOrder) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(navigationOrder,
        "navigationOrder cannot be null");
      if (this.navigationOrder == null) {
        this.navigationOrder = new ArrayList<String>();
      }
      this.navigationOrder.add(navigationOrder);
      return this;
    }

    /**
     * Set the strings.
     *
     * @param strings the strings
     * @return the UIMetaData builder
     */
    public Builder strings(I18N strings) {
      this.strings = strings;
      return this;
    }

    /**
     * Set the urls.
     *
     * @param urls the urls
     * @return the UIMetaData builder
     */
    public Builder urls(URLS urls) {
      this.urls = urls;
      return this;
    }

    /**
     * Set the embeddableDashboard.
     *
     * @param embeddableDashboard the embeddableDashboard
     * @return the UIMetaData builder
     */
    public Builder embeddableDashboard(String embeddableDashboard) {
      this.embeddableDashboard = embeddableDashboard;
      return this;
    }

    /**
     * Set the embeddableDashboardFullWidth.
     *
     * @param embeddableDashboardFullWidth the embeddableDashboardFullWidth
     * @return the UIMetaData builder
     */
    public Builder embeddableDashboardFullWidth(Boolean embeddableDashboardFullWidth) {
      this.embeddableDashboardFullWidth = embeddableDashboardFullWidth;
      return this;
    }

    /**
     * Set the navigationOrder.
     * Existing navigationOrder will be replaced.
     *
     * @param navigationOrder the navigationOrder
     * @return the UIMetaData builder
     */
    public Builder navigationOrder(List<String> navigationOrder) {
      this.navigationOrder = navigationOrder;
      return this;
    }

    /**
     * Set the notCreatable.
     *
     * @param notCreatable the notCreatable
     * @return the UIMetaData builder
     */
    public Builder notCreatable(Boolean notCreatable) {
      this.notCreatable = notCreatable;
      return this;
    }

    /**
     * Set the reservable.
     *
     * @param reservable the reservable
     * @return the UIMetaData builder
     */
    public Builder reservable(Boolean reservable) {
      this.reservable = reservable;
      return this;
    }

    /**
     * Set the primaryOfferingId.
     *
     * @param primaryOfferingId the primaryOfferingId
     * @return the UIMetaData builder
     */
    public Builder primaryOfferingId(String primaryOfferingId) {
      this.primaryOfferingId = primaryOfferingId;
      return this;
    }

    /**
     * Set the accessibleDuringProvision.
     *
     * @param accessibleDuringProvision the accessibleDuringProvision
     * @return the UIMetaData builder
     */
    public Builder accessibleDuringProvision(Boolean accessibleDuringProvision) {
      this.accessibleDuringProvision = accessibleDuringProvision;
      return this;
    }

    /**
     * Set the sideBySideIndex.
     *
     * @param sideBySideIndex the sideBySideIndex
     * @return the UIMetaData builder
     */
    public Builder sideBySideIndex(long sideBySideIndex) {
      this.sideBySideIndex = sideBySideIndex;
      return this;
    }

    /**
     * Set the endOfServiceTime.
     *
     * @param endOfServiceTime the endOfServiceTime
     * @return the UIMetaData builder
     */
    public Builder endOfServiceTime(Date endOfServiceTime) {
      this.endOfServiceTime = endOfServiceTime;
      return this;
    }
  }

  protected UIMetaData(Builder builder) {
    strings = builder.strings;
    urls = builder.urls;
    embeddableDashboard = builder.embeddableDashboard;
    embeddableDashboardFullWidth = builder.embeddableDashboardFullWidth;
    navigationOrder = builder.navigationOrder;
    notCreatable = builder.notCreatable;
    reservable = builder.reservable;
    primaryOfferingId = builder.primaryOfferingId;
    accessibleDuringProvision = builder.accessibleDuringProvision;
    sideBySideIndex = builder.sideBySideIndex;
    endOfServiceTime = builder.endOfServiceTime;
  }

  /**
   * New builder.
   *
   * @return a UIMetaData builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the strings.
   *
   * Language specific translation of translation properties, like label and description.
   *
   * @return the strings
   */
  public I18N strings() {
    return strings;
  }

  /**
   * Gets the urls.
   *
   * UI based URLs.
   *
   * @return the urls
   */
  public URLS urls() {
    return urls;
  }

  /**
   * Gets the embeddableDashboard.
   *
   * Describes how the embeddable dashboard is rendered.
   *
   * @return the embeddableDashboard
   */
  public String embeddableDashboard() {
    return embeddableDashboard;
  }

  /**
   * Gets the embeddableDashboardFullWidth.
   *
   * Describes whether the embeddable dashboard is rendered at the full width.
   *
   * @return the embeddableDashboardFullWidth
   */
  public Boolean embeddableDashboardFullWidth() {
    return embeddableDashboardFullWidth;
  }

  /**
   * Gets the navigationOrder.
   *
   * Defines the order of information presented.
   *
   * @return the navigationOrder
   */
  public List<String> navigationOrder() {
    return navigationOrder;
  }

  /**
   * Gets the notCreatable.
   *
   * Describes whether this entry is able to be created from the UI element or CLI.
   *
   * @return the notCreatable
   */
  public Boolean notCreatable() {
    return notCreatable;
  }

  /**
   * Gets the reservable.
   *
   * Describes whether a plan or flavor is reservable.
   *
   * @return the reservable
   */
  public Boolean reservable() {
    return reservable;
  }

  /**
   * Gets the primaryOfferingId.
   *
   * ID of the primary offering for a group.
   *
   * @return the primaryOfferingId
   */
  public String primaryOfferingId() {
    return primaryOfferingId;
  }

  /**
   * Gets the accessibleDuringProvision.
   *
   * Alert to ACE to allow instance UI to be accessible while the provisioning state of instance is in progress.
   *
   * @return the accessibleDuringProvision
   */
  public Boolean accessibleDuringProvision() {
    return accessibleDuringProvision;
  }

  /**
   * Gets the sideBySideIndex.
   *
   * Specifies a side by side ordering weight to the UI.
   *
   * @return the sideBySideIndex
   */
  public Long sideBySideIndex() {
    return sideBySideIndex;
  }

  /**
   * Gets the endOfServiceTime.
   *
   * Date and time the service will no longer be available.
   *
   * @return the endOfServiceTime
   */
  public Date endOfServiceTime() {
    return endOfServiceTime;
  }
}

