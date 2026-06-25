/*
 * (C) Copyright IBM Corp. 2026.
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

package com.ibm.cloud.platform_services.platform_notifications.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createPreferences options.
 */
public class CreatePreferencesOptions extends GenericModel {

  protected String iamId;
  protected PreferenceValueWithUpdates incidentSeverity1;
  protected PreferenceValueWithUpdates incidentSeverity2;
  protected PreferenceValueWithUpdates incidentSeverity3;
  protected PreferenceValueWithUpdates incidentSeverity4;
  protected PreferenceValueWithUpdates maintenanceHigh;
  protected PreferenceValueWithUpdates maintenanceMedium;
  protected PreferenceValueWithUpdates maintenanceLow;
  protected PreferenceValueWithoutUpdates announcementsMajor;
  protected PreferenceValueWithoutUpdates announcementsMinor;
  protected PreferenceValueWithoutUpdates securityNormal;
  protected PreferenceValueWithoutUpdates accountNormal;
  protected PreferenceValueWithoutUpdates billingAndUsageOrder;
  protected PreferenceValueWithoutUpdates billingAndUsageInvoices;
  protected PreferenceValueWithoutUpdates billingAndUsagePayments;
  protected PreferenceValueWithoutUpdates billingAndUsageSubscriptionsAndPromoCodes;
  protected PreferenceValueWithoutUpdates billingAndUsageSpendingAlerts;
  protected PreferenceValueWithoutUpdates resourceactivityNormal;
  protected PreferenceValueWithoutUpdates orderingReview;
  protected PreferenceValueWithoutUpdates orderingApproved;
  protected PreferenceValueWithoutUpdates orderingApprovedVsi;
  protected PreferenceValueWithoutUpdates orderingApprovedServer;
  protected PreferenceValueWithoutUpdates provisioningReloadComplete;
  protected PreferenceValueWithoutUpdates provisioningCompleteVsi;
  protected PreferenceValueWithoutUpdates provisioningCompleteServer;
  protected String accountId;

  /**
   * Builder.
   */
  public static class Builder {
    private String iamId;
    private PreferenceValueWithUpdates incidentSeverity1;
    private PreferenceValueWithUpdates incidentSeverity2;
    private PreferenceValueWithUpdates incidentSeverity3;
    private PreferenceValueWithUpdates incidentSeverity4;
    private PreferenceValueWithUpdates maintenanceHigh;
    private PreferenceValueWithUpdates maintenanceMedium;
    private PreferenceValueWithUpdates maintenanceLow;
    private PreferenceValueWithoutUpdates announcementsMajor;
    private PreferenceValueWithoutUpdates announcementsMinor;
    private PreferenceValueWithoutUpdates securityNormal;
    private PreferenceValueWithoutUpdates accountNormal;
    private PreferenceValueWithoutUpdates billingAndUsageOrder;
    private PreferenceValueWithoutUpdates billingAndUsageInvoices;
    private PreferenceValueWithoutUpdates billingAndUsagePayments;
    private PreferenceValueWithoutUpdates billingAndUsageSubscriptionsAndPromoCodes;
    private PreferenceValueWithoutUpdates billingAndUsageSpendingAlerts;
    private PreferenceValueWithoutUpdates resourceactivityNormal;
    private PreferenceValueWithoutUpdates orderingReview;
    private PreferenceValueWithoutUpdates orderingApproved;
    private PreferenceValueWithoutUpdates orderingApprovedVsi;
    private PreferenceValueWithoutUpdates orderingApprovedServer;
    private PreferenceValueWithoutUpdates provisioningReloadComplete;
    private PreferenceValueWithoutUpdates provisioningCompleteVsi;
    private PreferenceValueWithoutUpdates provisioningCompleteServer;
    private String accountId;

    /**
     * Instantiates a new Builder from an existing CreatePreferencesOptions instance.
     *
     * @param createPreferencesOptions the instance to initialize the Builder with
     */
    private Builder(CreatePreferencesOptions createPreferencesOptions) {
      this.iamId = createPreferencesOptions.iamId;
      this.incidentSeverity1 = createPreferencesOptions.incidentSeverity1;
      this.incidentSeverity2 = createPreferencesOptions.incidentSeverity2;
      this.incidentSeverity3 = createPreferencesOptions.incidentSeverity3;
      this.incidentSeverity4 = createPreferencesOptions.incidentSeverity4;
      this.maintenanceHigh = createPreferencesOptions.maintenanceHigh;
      this.maintenanceMedium = createPreferencesOptions.maintenanceMedium;
      this.maintenanceLow = createPreferencesOptions.maintenanceLow;
      this.announcementsMajor = createPreferencesOptions.announcementsMajor;
      this.announcementsMinor = createPreferencesOptions.announcementsMinor;
      this.securityNormal = createPreferencesOptions.securityNormal;
      this.accountNormal = createPreferencesOptions.accountNormal;
      this.billingAndUsageOrder = createPreferencesOptions.billingAndUsageOrder;
      this.billingAndUsageInvoices = createPreferencesOptions.billingAndUsageInvoices;
      this.billingAndUsagePayments = createPreferencesOptions.billingAndUsagePayments;
      this.billingAndUsageSubscriptionsAndPromoCodes = createPreferencesOptions.billingAndUsageSubscriptionsAndPromoCodes;
      this.billingAndUsageSpendingAlerts = createPreferencesOptions.billingAndUsageSpendingAlerts;
      this.resourceactivityNormal = createPreferencesOptions.resourceactivityNormal;
      this.orderingReview = createPreferencesOptions.orderingReview;
      this.orderingApproved = createPreferencesOptions.orderingApproved;
      this.orderingApprovedVsi = createPreferencesOptions.orderingApprovedVsi;
      this.orderingApprovedServer = createPreferencesOptions.orderingApprovedServer;
      this.provisioningReloadComplete = createPreferencesOptions.provisioningReloadComplete;
      this.provisioningCompleteVsi = createPreferencesOptions.provisioningCompleteVsi;
      this.provisioningCompleteServer = createPreferencesOptions.provisioningCompleteServer;
      this.accountId = createPreferencesOptions.accountId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param iamId the iamId
     */
    public Builder(String iamId) {
      this.iamId = iamId;
    }

    /**
     * Builds a CreatePreferencesOptions.
     *
     * @return the new CreatePreferencesOptions instance
     */
    public CreatePreferencesOptions build() {
      return new CreatePreferencesOptions(this);
    }

    /**
     * Set the iamId.
     *
     * @param iamId the iamId
     * @return the CreatePreferencesOptions builder
     */
    public Builder iamId(String iamId) {
      this.iamId = iamId;
      return this;
    }

    /**
     * Set the incidentSeverity1.
     *
     * @param incidentSeverity1 the incidentSeverity1
     * @return the CreatePreferencesOptions builder
     */
    public Builder incidentSeverity1(PreferenceValueWithUpdates incidentSeverity1) {
      this.incidentSeverity1 = incidentSeverity1;
      return this;
    }

    /**
     * Set the incidentSeverity2.
     *
     * @param incidentSeverity2 the incidentSeverity2
     * @return the CreatePreferencesOptions builder
     */
    public Builder incidentSeverity2(PreferenceValueWithUpdates incidentSeverity2) {
      this.incidentSeverity2 = incidentSeverity2;
      return this;
    }

    /**
     * Set the incidentSeverity3.
     *
     * @param incidentSeverity3 the incidentSeverity3
     * @return the CreatePreferencesOptions builder
     */
    public Builder incidentSeverity3(PreferenceValueWithUpdates incidentSeverity3) {
      this.incidentSeverity3 = incidentSeverity3;
      return this;
    }

    /**
     * Set the incidentSeverity4.
     *
     * @param incidentSeverity4 the incidentSeverity4
     * @return the CreatePreferencesOptions builder
     */
    public Builder incidentSeverity4(PreferenceValueWithUpdates incidentSeverity4) {
      this.incidentSeverity4 = incidentSeverity4;
      return this;
    }

    /**
     * Set the maintenanceHigh.
     *
     * @param maintenanceHigh the maintenanceHigh
     * @return the CreatePreferencesOptions builder
     */
    public Builder maintenanceHigh(PreferenceValueWithUpdates maintenanceHigh) {
      this.maintenanceHigh = maintenanceHigh;
      return this;
    }

    /**
     * Set the maintenanceMedium.
     *
     * @param maintenanceMedium the maintenanceMedium
     * @return the CreatePreferencesOptions builder
     */
    public Builder maintenanceMedium(PreferenceValueWithUpdates maintenanceMedium) {
      this.maintenanceMedium = maintenanceMedium;
      return this;
    }

    /**
     * Set the maintenanceLow.
     *
     * @param maintenanceLow the maintenanceLow
     * @return the CreatePreferencesOptions builder
     */
    public Builder maintenanceLow(PreferenceValueWithUpdates maintenanceLow) {
      this.maintenanceLow = maintenanceLow;
      return this;
    }

    /**
     * Set the announcementsMajor.
     *
     * @param announcementsMajor the announcementsMajor
     * @return the CreatePreferencesOptions builder
     */
    public Builder announcementsMajor(PreferenceValueWithoutUpdates announcementsMajor) {
      this.announcementsMajor = announcementsMajor;
      return this;
    }

    /**
     * Set the announcementsMinor.
     *
     * @param announcementsMinor the announcementsMinor
     * @return the CreatePreferencesOptions builder
     */
    public Builder announcementsMinor(PreferenceValueWithoutUpdates announcementsMinor) {
      this.announcementsMinor = announcementsMinor;
      return this;
    }

    /**
     * Set the securityNormal.
     *
     * @param securityNormal the securityNormal
     * @return the CreatePreferencesOptions builder
     */
    public Builder securityNormal(PreferenceValueWithoutUpdates securityNormal) {
      this.securityNormal = securityNormal;
      return this;
    }

    /**
     * Set the accountNormal.
     *
     * @param accountNormal the accountNormal
     * @return the CreatePreferencesOptions builder
     */
    public Builder accountNormal(PreferenceValueWithoutUpdates accountNormal) {
      this.accountNormal = accountNormal;
      return this;
    }

    /**
     * Set the billingAndUsageOrder.
     *
     * @param billingAndUsageOrder the billingAndUsageOrder
     * @return the CreatePreferencesOptions builder
     */
    public Builder billingAndUsageOrder(PreferenceValueWithoutUpdates billingAndUsageOrder) {
      this.billingAndUsageOrder = billingAndUsageOrder;
      return this;
    }

    /**
     * Set the billingAndUsageInvoices.
     *
     * @param billingAndUsageInvoices the billingAndUsageInvoices
     * @return the CreatePreferencesOptions builder
     */
    public Builder billingAndUsageInvoices(PreferenceValueWithoutUpdates billingAndUsageInvoices) {
      this.billingAndUsageInvoices = billingAndUsageInvoices;
      return this;
    }

    /**
     * Set the billingAndUsagePayments.
     *
     * @param billingAndUsagePayments the billingAndUsagePayments
     * @return the CreatePreferencesOptions builder
     */
    public Builder billingAndUsagePayments(PreferenceValueWithoutUpdates billingAndUsagePayments) {
      this.billingAndUsagePayments = billingAndUsagePayments;
      return this;
    }

    /**
     * Set the billingAndUsageSubscriptionsAndPromoCodes.
     *
     * @param billingAndUsageSubscriptionsAndPromoCodes the billingAndUsageSubscriptionsAndPromoCodes
     * @return the CreatePreferencesOptions builder
     */
    public Builder billingAndUsageSubscriptionsAndPromoCodes(PreferenceValueWithoutUpdates billingAndUsageSubscriptionsAndPromoCodes) {
      this.billingAndUsageSubscriptionsAndPromoCodes = billingAndUsageSubscriptionsAndPromoCodes;
      return this;
    }

    /**
     * Set the billingAndUsageSpendingAlerts.
     *
     * @param billingAndUsageSpendingAlerts the billingAndUsageSpendingAlerts
     * @return the CreatePreferencesOptions builder
     */
    public Builder billingAndUsageSpendingAlerts(PreferenceValueWithoutUpdates billingAndUsageSpendingAlerts) {
      this.billingAndUsageSpendingAlerts = billingAndUsageSpendingAlerts;
      return this;
    }

    /**
     * Set the resourceactivityNormal.
     *
     * @param resourceactivityNormal the resourceactivityNormal
     * @return the CreatePreferencesOptions builder
     */
    public Builder resourceactivityNormal(PreferenceValueWithoutUpdates resourceactivityNormal) {
      this.resourceactivityNormal = resourceactivityNormal;
      return this;
    }

    /**
     * Set the orderingReview.
     *
     * @param orderingReview the orderingReview
     * @return the CreatePreferencesOptions builder
     */
    public Builder orderingReview(PreferenceValueWithoutUpdates orderingReview) {
      this.orderingReview = orderingReview;
      return this;
    }

    /**
     * Set the orderingApproved.
     *
     * @param orderingApproved the orderingApproved
     * @return the CreatePreferencesOptions builder
     */
    public Builder orderingApproved(PreferenceValueWithoutUpdates orderingApproved) {
      this.orderingApproved = orderingApproved;
      return this;
    }

    /**
     * Set the orderingApprovedVsi.
     *
     * @param orderingApprovedVsi the orderingApprovedVsi
     * @return the CreatePreferencesOptions builder
     */
    public Builder orderingApprovedVsi(PreferenceValueWithoutUpdates orderingApprovedVsi) {
      this.orderingApprovedVsi = orderingApprovedVsi;
      return this;
    }

    /**
     * Set the orderingApprovedServer.
     *
     * @param orderingApprovedServer the orderingApprovedServer
     * @return the CreatePreferencesOptions builder
     */
    public Builder orderingApprovedServer(PreferenceValueWithoutUpdates orderingApprovedServer) {
      this.orderingApprovedServer = orderingApprovedServer;
      return this;
    }

    /**
     * Set the provisioningReloadComplete.
     *
     * @param provisioningReloadComplete the provisioningReloadComplete
     * @return the CreatePreferencesOptions builder
     */
    public Builder provisioningReloadComplete(PreferenceValueWithoutUpdates provisioningReloadComplete) {
      this.provisioningReloadComplete = provisioningReloadComplete;
      return this;
    }

    /**
     * Set the provisioningCompleteVsi.
     *
     * @param provisioningCompleteVsi the provisioningCompleteVsi
     * @return the CreatePreferencesOptions builder
     */
    public Builder provisioningCompleteVsi(PreferenceValueWithoutUpdates provisioningCompleteVsi) {
      this.provisioningCompleteVsi = provisioningCompleteVsi;
      return this;
    }

    /**
     * Set the provisioningCompleteServer.
     *
     * @param provisioningCompleteServer the provisioningCompleteServer
     * @return the CreatePreferencesOptions builder
     */
    public Builder provisioningCompleteServer(PreferenceValueWithoutUpdates provisioningCompleteServer) {
      this.provisioningCompleteServer = provisioningCompleteServer;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreatePreferencesOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the preferencesObject.
     *
     * @param preferencesObject the preferencesObject
     * @return the CreatePreferencesOptions builder
     */
    public Builder preferencesObject(PreferencesObject preferencesObject) {
      this.incidentSeverity1 = preferencesObject.incidentSeverity1();
      this.incidentSeverity2 = preferencesObject.incidentSeverity2();
      this.incidentSeverity3 = preferencesObject.incidentSeverity3();
      this.incidentSeverity4 = preferencesObject.incidentSeverity4();
      this.maintenanceHigh = preferencesObject.maintenanceHigh();
      this.maintenanceMedium = preferencesObject.maintenanceMedium();
      this.maintenanceLow = preferencesObject.maintenanceLow();
      this.announcementsMajor = preferencesObject.announcementsMajor();
      this.announcementsMinor = preferencesObject.announcementsMinor();
      this.securityNormal = preferencesObject.securityNormal();
      this.accountNormal = preferencesObject.accountNormal();
      this.billingAndUsageOrder = preferencesObject.billingAndUsageOrder();
      this.billingAndUsageInvoices = preferencesObject.billingAndUsageInvoices();
      this.billingAndUsagePayments = preferencesObject.billingAndUsagePayments();
      this.billingAndUsageSubscriptionsAndPromoCodes = preferencesObject.billingAndUsageSubscriptionsAndPromoCodes();
      this.billingAndUsageSpendingAlerts = preferencesObject.billingAndUsageSpendingAlerts();
      this.resourceactivityNormal = preferencesObject.resourceactivityNormal();
      this.orderingReview = preferencesObject.orderingReview();
      this.orderingApproved = preferencesObject.orderingApproved();
      this.orderingApprovedVsi = preferencesObject.orderingApprovedVsi();
      this.orderingApprovedServer = preferencesObject.orderingApprovedServer();
      this.provisioningReloadComplete = preferencesObject.provisioningReloadComplete();
      this.provisioningCompleteVsi = preferencesObject.provisioningCompleteVsi();
      this.provisioningCompleteServer = preferencesObject.provisioningCompleteServer();
      return this;
    }
  }

  protected CreatePreferencesOptions() { }

  protected CreatePreferencesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.iamId,
      "iamId cannot be empty");
    iamId = builder.iamId;
    incidentSeverity1 = builder.incidentSeverity1;
    incidentSeverity2 = builder.incidentSeverity2;
    incidentSeverity3 = builder.incidentSeverity3;
    incidentSeverity4 = builder.incidentSeverity4;
    maintenanceHigh = builder.maintenanceHigh;
    maintenanceMedium = builder.maintenanceMedium;
    maintenanceLow = builder.maintenanceLow;
    announcementsMajor = builder.announcementsMajor;
    announcementsMinor = builder.announcementsMinor;
    securityNormal = builder.securityNormal;
    accountNormal = builder.accountNormal;
    billingAndUsageOrder = builder.billingAndUsageOrder;
    billingAndUsageInvoices = builder.billingAndUsageInvoices;
    billingAndUsagePayments = builder.billingAndUsagePayments;
    billingAndUsageSubscriptionsAndPromoCodes = builder.billingAndUsageSubscriptionsAndPromoCodes;
    billingAndUsageSpendingAlerts = builder.billingAndUsageSpendingAlerts;
    resourceactivityNormal = builder.resourceactivityNormal;
    orderingReview = builder.orderingReview;
    orderingApproved = builder.orderingApproved;
    orderingApprovedVsi = builder.orderingApprovedVsi;
    orderingApprovedServer = builder.orderingApprovedServer;
    provisioningReloadComplete = builder.provisioningReloadComplete;
    provisioningCompleteVsi = builder.provisioningCompleteVsi;
    provisioningCompleteServer = builder.provisioningCompleteServer;
    accountId = builder.accountId;
  }

  /**
   * New builder.
   *
   * @return a CreatePreferencesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the iamId.
   *
   * The IAM ID of the user. Must match the IAM ID in the bearer token.
   *
   * @return the iamId
   */
  public String iamId() {
    return iamId;
  }

  /**
   * Gets the incidentSeverity1.
   *
   * Preference settings for notification types that support updates.
   *
   * @return the incidentSeverity1
   */
  public PreferenceValueWithUpdates incidentSeverity1() {
    return incidentSeverity1;
  }

  /**
   * Gets the incidentSeverity2.
   *
   * Preference settings for notification types that support updates.
   *
   * @return the incidentSeverity2
   */
  public PreferenceValueWithUpdates incidentSeverity2() {
    return incidentSeverity2;
  }

  /**
   * Gets the incidentSeverity3.
   *
   * Preference settings for notification types that support updates.
   *
   * @return the incidentSeverity3
   */
  public PreferenceValueWithUpdates incidentSeverity3() {
    return incidentSeverity3;
  }

  /**
   * Gets the incidentSeverity4.
   *
   * Preference settings for notification types that support updates.
   *
   * @return the incidentSeverity4
   */
  public PreferenceValueWithUpdates incidentSeverity4() {
    return incidentSeverity4;
  }

  /**
   * Gets the maintenanceHigh.
   *
   * Preference settings for notification types that support updates.
   *
   * @return the maintenanceHigh
   */
  public PreferenceValueWithUpdates maintenanceHigh() {
    return maintenanceHigh;
  }

  /**
   * Gets the maintenanceMedium.
   *
   * Preference settings for notification types that support updates.
   *
   * @return the maintenanceMedium
   */
  public PreferenceValueWithUpdates maintenanceMedium() {
    return maintenanceMedium;
  }

  /**
   * Gets the maintenanceLow.
   *
   * Preference settings for notification types that support updates.
   *
   * @return the maintenanceLow
   */
  public PreferenceValueWithUpdates maintenanceLow() {
    return maintenanceLow;
  }

  /**
   * Gets the announcementsMajor.
   *
   * Preference settings for notification types that do not support updates.
   *
   * @return the announcementsMajor
   */
  public PreferenceValueWithoutUpdates announcementsMajor() {
    return announcementsMajor;
  }

  /**
   * Gets the announcementsMinor.
   *
   * Preference settings for notification types that do not support updates.
   *
   * @return the announcementsMinor
   */
  public PreferenceValueWithoutUpdates announcementsMinor() {
    return announcementsMinor;
  }

  /**
   * Gets the securityNormal.
   *
   * Preference settings for notification types that do not support updates.
   *
   * @return the securityNormal
   */
  public PreferenceValueWithoutUpdates securityNormal() {
    return securityNormal;
  }

  /**
   * Gets the accountNormal.
   *
   * Preference settings for notification types that do not support updates.
   *
   * @return the accountNormal
   */
  public PreferenceValueWithoutUpdates accountNormal() {
    return accountNormal;
  }

  /**
   * Gets the billingAndUsageOrder.
   *
   * Preference settings for notification types that do not support updates.
   *
   * @return the billingAndUsageOrder
   */
  public PreferenceValueWithoutUpdates billingAndUsageOrder() {
    return billingAndUsageOrder;
  }

  /**
   * Gets the billingAndUsageInvoices.
   *
   * Preference settings for notification types that do not support updates.
   *
   * @return the billingAndUsageInvoices
   */
  public PreferenceValueWithoutUpdates billingAndUsageInvoices() {
    return billingAndUsageInvoices;
  }

  /**
   * Gets the billingAndUsagePayments.
   *
   * Preference settings for notification types that do not support updates.
   *
   * @return the billingAndUsagePayments
   */
  public PreferenceValueWithoutUpdates billingAndUsagePayments() {
    return billingAndUsagePayments;
  }

  /**
   * Gets the billingAndUsageSubscriptionsAndPromoCodes.
   *
   * Preference settings for notification types that do not support updates.
   *
   * @return the billingAndUsageSubscriptionsAndPromoCodes
   */
  public PreferenceValueWithoutUpdates billingAndUsageSubscriptionsAndPromoCodes() {
    return billingAndUsageSubscriptionsAndPromoCodes;
  }

  /**
   * Gets the billingAndUsageSpendingAlerts.
   *
   * Preference settings for notification types that do not support updates.
   *
   * @return the billingAndUsageSpendingAlerts
   */
  public PreferenceValueWithoutUpdates billingAndUsageSpendingAlerts() {
    return billingAndUsageSpendingAlerts;
  }

  /**
   * Gets the resourceactivityNormal.
   *
   * Preference settings for notification types that do not support updates.
   *
   * @return the resourceactivityNormal
   */
  public PreferenceValueWithoutUpdates resourceactivityNormal() {
    return resourceactivityNormal;
  }

  /**
   * Gets the orderingReview.
   *
   * Preference settings for notification types that do not support updates.
   *
   * @return the orderingReview
   */
  public PreferenceValueWithoutUpdates orderingReview() {
    return orderingReview;
  }

  /**
   * Gets the orderingApproved.
   *
   * Preference settings for notification types that do not support updates.
   *
   * @return the orderingApproved
   */
  public PreferenceValueWithoutUpdates orderingApproved() {
    return orderingApproved;
  }

  /**
   * Gets the orderingApprovedVsi.
   *
   * Preference settings for notification types that do not support updates.
   *
   * @return the orderingApprovedVsi
   */
  public PreferenceValueWithoutUpdates orderingApprovedVsi() {
    return orderingApprovedVsi;
  }

  /**
   * Gets the orderingApprovedServer.
   *
   * Preference settings for notification types that do not support updates.
   *
   * @return the orderingApprovedServer
   */
  public PreferenceValueWithoutUpdates orderingApprovedServer() {
    return orderingApprovedServer;
  }

  /**
   * Gets the provisioningReloadComplete.
   *
   * Preference settings for notification types that do not support updates.
   *
   * @return the provisioningReloadComplete
   */
  public PreferenceValueWithoutUpdates provisioningReloadComplete() {
    return provisioningReloadComplete;
  }

  /**
   * Gets the provisioningCompleteVsi.
   *
   * Preference settings for notification types that do not support updates.
   *
   * @return the provisioningCompleteVsi
   */
  public PreferenceValueWithoutUpdates provisioningCompleteVsi() {
    return provisioningCompleteVsi;
  }

  /**
   * Gets the provisioningCompleteServer.
   *
   * Preference settings for notification types that do not support updates.
   *
   * @return the provisioningCompleteServer
   */
  public PreferenceValueWithoutUpdates provisioningCompleteServer() {
    return provisioningCompleteServer;
  }

  /**
   * Gets the accountId.
   *
   * The IBM Cloud account ID. If not provided, the account ID from the bearer token will be used.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }
}

