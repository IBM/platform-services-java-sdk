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

import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Callback-related information associated with a catalog entry.
 */
public class Callbacks extends GenericModel {

  @SerializedName("controller_url")
  protected String controllerUrl;
  @SerializedName("broker_url")
  protected String brokerUrl;
  @SerializedName("broker_proxy_url")
  protected String brokerProxyUrl;
  @SerializedName("dashboard_url")
  protected String dashboardUrl;
  @SerializedName("dashboard_data_url")
  protected String dashboardDataUrl;
  @SerializedName("dashboard_detail_tab_url")
  protected String dashboardDetailTabUrl;
  @SerializedName("dashboard_detail_tab_ext_url")
  protected String dashboardDetailTabExtUrl;
  @SerializedName("service_monitor_api")
  protected String serviceMonitorApi;
  @SerializedName("service_monitor_app")
  protected String serviceMonitorApp;
  @SerializedName("api_endpoint")
  protected Map<String, String> apiEndpoint;

  /**
   * Builder.
   */
  public static class Builder {
    private String controllerUrl;
    private String brokerUrl;
    private String brokerProxyUrl;
    private String dashboardUrl;
    private String dashboardDataUrl;
    private String dashboardDetailTabUrl;
    private String dashboardDetailTabExtUrl;
    private String serviceMonitorApi;
    private String serviceMonitorApp;
    private Map<String, String> apiEndpoint;

    /**
     * Instantiates a new Builder from an existing Callbacks instance.
     *
     * @param callbacks the instance to initialize the Builder with
     */
    private Builder(Callbacks callbacks) {
      this.controllerUrl = callbacks.controllerUrl;
      this.brokerUrl = callbacks.brokerUrl;
      this.brokerProxyUrl = callbacks.brokerProxyUrl;
      this.dashboardUrl = callbacks.dashboardUrl;
      this.dashboardDataUrl = callbacks.dashboardDataUrl;
      this.dashboardDetailTabUrl = callbacks.dashboardDetailTabUrl;
      this.dashboardDetailTabExtUrl = callbacks.dashboardDetailTabExtUrl;
      this.serviceMonitorApi = callbacks.serviceMonitorApi;
      this.serviceMonitorApp = callbacks.serviceMonitorApp;
      this.apiEndpoint = callbacks.apiEndpoint;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Callbacks.
     *
     * @return the new Callbacks instance
     */
    public Callbacks build() {
      return new Callbacks(this);
    }

    /**
     * Set the controllerUrl.
     *
     * @param controllerUrl the controllerUrl
     * @return the Callbacks builder
     */
    public Builder controllerUrl(String controllerUrl) {
      this.controllerUrl = controllerUrl;
      return this;
    }

    /**
     * Set the brokerUrl.
     *
     * @param brokerUrl the brokerUrl
     * @return the Callbacks builder
     */
    public Builder brokerUrl(String brokerUrl) {
      this.brokerUrl = brokerUrl;
      return this;
    }

    /**
     * Set the brokerProxyUrl.
     *
     * @param brokerProxyUrl the brokerProxyUrl
     * @return the Callbacks builder
     * @deprecated this method is deprecated and may be removed in a future release
     */
    @Deprecated
    public Builder brokerProxyUrl(String brokerProxyUrl) {
      this.brokerProxyUrl = brokerProxyUrl;
      return this;
    }

    /**
     * Set the dashboardUrl.
     *
     * @param dashboardUrl the dashboardUrl
     * @return the Callbacks builder
     */
    public Builder dashboardUrl(String dashboardUrl) {
      this.dashboardUrl = dashboardUrl;
      return this;
    }

    /**
     * Set the dashboardDataUrl.
     *
     * @param dashboardDataUrl the dashboardDataUrl
     * @return the Callbacks builder
     */
    public Builder dashboardDataUrl(String dashboardDataUrl) {
      this.dashboardDataUrl = dashboardDataUrl;
      return this;
    }

    /**
     * Set the dashboardDetailTabUrl.
     *
     * @param dashboardDetailTabUrl the dashboardDetailTabUrl
     * @return the Callbacks builder
     */
    public Builder dashboardDetailTabUrl(String dashboardDetailTabUrl) {
      this.dashboardDetailTabUrl = dashboardDetailTabUrl;
      return this;
    }

    /**
     * Set the dashboardDetailTabExtUrl.
     *
     * @param dashboardDetailTabExtUrl the dashboardDetailTabExtUrl
     * @return the Callbacks builder
     */
    public Builder dashboardDetailTabExtUrl(String dashboardDetailTabExtUrl) {
      this.dashboardDetailTabExtUrl = dashboardDetailTabExtUrl;
      return this;
    }

    /**
     * Set the serviceMonitorApi.
     *
     * @param serviceMonitorApi the serviceMonitorApi
     * @return the Callbacks builder
     */
    public Builder serviceMonitorApi(String serviceMonitorApi) {
      this.serviceMonitorApi = serviceMonitorApi;
      return this;
    }

    /**
     * Set the serviceMonitorApp.
     *
     * @param serviceMonitorApp the serviceMonitorApp
     * @return the Callbacks builder
     */
    public Builder serviceMonitorApp(String serviceMonitorApp) {
      this.serviceMonitorApp = serviceMonitorApp;
      return this;
    }

    /**
     * Set the apiEndpoint.
     *
     * @param apiEndpoint the apiEndpoint
     * @return the Callbacks builder
     */
    public Builder apiEndpoint(Map<String, String> apiEndpoint) {
      this.apiEndpoint = apiEndpoint;
      return this;
    }
  }

  protected Callbacks() { }

  protected Callbacks(Builder builder) {
    controllerUrl = builder.controllerUrl;
    brokerUrl = builder.brokerUrl;
    brokerProxyUrl = builder.brokerProxyUrl;
    dashboardUrl = builder.dashboardUrl;
    dashboardDataUrl = builder.dashboardDataUrl;
    dashboardDetailTabUrl = builder.dashboardDetailTabUrl;
    dashboardDetailTabExtUrl = builder.dashboardDetailTabExtUrl;
    serviceMonitorApi = builder.serviceMonitorApi;
    serviceMonitorApp = builder.serviceMonitorApp;
    apiEndpoint = builder.apiEndpoint;
  }

  /**
   * New builder.
   *
   * @return a Callbacks builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the controllerUrl.
   *
   * The URL of the deployment controller.
   *
   * @return the controllerUrl
   */
  public String controllerUrl() {
    return controllerUrl;
  }

  /**
   * Gets the brokerUrl.
   *
   * The URL of the deployment broker.
   *
   * @return the brokerUrl
   */
  public String brokerUrl() {
    return brokerUrl;
  }

  /**
   * Gets the brokerProxyUrl.
   *
   * The URL of the deployment broker SC proxy.
   *
   * @return the brokerProxyUrl
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
  public String brokerProxyUrl() {
    return brokerProxyUrl;
  }

  /**
   * Gets the dashboardUrl.
   *
   * The URL of dashboard callback.
   *
   * @return the dashboardUrl
   */
  public String dashboardUrl() {
    return dashboardUrl;
  }

  /**
   * Gets the dashboardDataUrl.
   *
   * The URL of dashboard data.
   *
   * @return the dashboardDataUrl
   */
  public String dashboardDataUrl() {
    return dashboardDataUrl;
  }

  /**
   * Gets the dashboardDetailTabUrl.
   *
   * The URL of the dashboard detail tab.
   *
   * @return the dashboardDetailTabUrl
   */
  public String dashboardDetailTabUrl() {
    return dashboardDetailTabUrl;
  }

  /**
   * Gets the dashboardDetailTabExtUrl.
   *
   * The URL of the dashboard detail tab extension.
   *
   * @return the dashboardDetailTabExtUrl
   */
  public String dashboardDetailTabExtUrl() {
    return dashboardDetailTabExtUrl;
  }

  /**
   * Gets the serviceMonitorApi.
   *
   * Service monitor API URL.
   *
   * @return the serviceMonitorApi
   */
  public String serviceMonitorApi() {
    return serviceMonitorApi;
  }

  /**
   * Gets the serviceMonitorApp.
   *
   * Service monitor app URL.
   *
   * @return the serviceMonitorApp
   */
  public String serviceMonitorApp() {
    return serviceMonitorApp;
  }

  /**
   * Gets the apiEndpoint.
   *
   * API endpoint.
   *
   * @return the apiEndpoint
   */
  public Map<String, String> apiEndpoint() {
    return apiEndpoint;
  }
}

