/*
 * (C) Copyright IBM Corp. 2021.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * UI based URLs.
 */
public class URLS extends GenericModel {

  @SerializedName("doc_url")
  protected String docUrl;
  @SerializedName("instructions_url")
  protected String instructionsUrl;
  @SerializedName("api_url")
  protected String apiUrl;
  @SerializedName("create_url")
  protected String createUrl;
  @SerializedName("sdk_download_url")
  protected String sdkDownloadUrl;
  @SerializedName("terms_url")
  protected String termsUrl;
  @SerializedName("custom_create_page_url")
  protected String customCreatePageUrl;
  @SerializedName("catalog_details_url")
  protected String catalogDetailsUrl;
  @SerializedName("deprecation_doc_url")
  protected String deprecationDocUrl;
  @SerializedName("dashboard_url")
  protected String dashboardUrl;
  @SerializedName("registration_url")
  protected String registrationUrl;
  protected String apidocsurl;

  /**
   * Builder.
   */
  public static class Builder {
    private String docUrl;
    private String instructionsUrl;
    private String apiUrl;
    private String createUrl;
    private String sdkDownloadUrl;
    private String termsUrl;
    private String customCreatePageUrl;
    private String catalogDetailsUrl;
    private String deprecationDocUrl;
    private String dashboardUrl;
    private String registrationUrl;
    private String apidocsurl;

    private Builder(URLS urls) {
      this.docUrl = urls.docUrl;
      this.instructionsUrl = urls.instructionsUrl;
      this.apiUrl = urls.apiUrl;
      this.createUrl = urls.createUrl;
      this.sdkDownloadUrl = urls.sdkDownloadUrl;
      this.termsUrl = urls.termsUrl;
      this.customCreatePageUrl = urls.customCreatePageUrl;
      this.catalogDetailsUrl = urls.catalogDetailsUrl;
      this.deprecationDocUrl = urls.deprecationDocUrl;
      this.dashboardUrl = urls.dashboardUrl;
      this.registrationUrl = urls.registrationUrl;
      this.apidocsurl = urls.apidocsurl;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a URLS.
     *
     * @return the new URLS instance
     */
    public URLS build() {
      return new URLS(this);
    }

    /**
     * Set the docUrl.
     *
     * @param docUrl the docUrl
     * @return the URLS builder
     */
    public Builder docUrl(String docUrl) {
      this.docUrl = docUrl;
      return this;
    }

    /**
     * Set the instructionsUrl.
     *
     * @param instructionsUrl the instructionsUrl
     * @return the URLS builder
     */
    public Builder instructionsUrl(String instructionsUrl) {
      this.instructionsUrl = instructionsUrl;
      return this;
    }

    /**
     * Set the apiUrl.
     *
     * @param apiUrl the apiUrl
     * @return the URLS builder
     */
    public Builder apiUrl(String apiUrl) {
      this.apiUrl = apiUrl;
      return this;
    }

    /**
     * Set the createUrl.
     *
     * @param createUrl the createUrl
     * @return the URLS builder
     */
    public Builder createUrl(String createUrl) {
      this.createUrl = createUrl;
      return this;
    }

    /**
     * Set the sdkDownloadUrl.
     *
     * @param sdkDownloadUrl the sdkDownloadUrl
     * @return the URLS builder
     */
    public Builder sdkDownloadUrl(String sdkDownloadUrl) {
      this.sdkDownloadUrl = sdkDownloadUrl;
      return this;
    }

    /**
     * Set the termsUrl.
     *
     * @param termsUrl the termsUrl
     * @return the URLS builder
     */
    public Builder termsUrl(String termsUrl) {
      this.termsUrl = termsUrl;
      return this;
    }

    /**
     * Set the customCreatePageUrl.
     *
     * @param customCreatePageUrl the customCreatePageUrl
     * @return the URLS builder
     */
    public Builder customCreatePageUrl(String customCreatePageUrl) {
      this.customCreatePageUrl = customCreatePageUrl;
      return this;
    }

    /**
     * Set the catalogDetailsUrl.
     *
     * @param catalogDetailsUrl the catalogDetailsUrl
     * @return the URLS builder
     */
    public Builder catalogDetailsUrl(String catalogDetailsUrl) {
      this.catalogDetailsUrl = catalogDetailsUrl;
      return this;
    }

    /**
     * Set the deprecationDocUrl.
     *
     * @param deprecationDocUrl the deprecationDocUrl
     * @return the URLS builder
     */
    public Builder deprecationDocUrl(String deprecationDocUrl) {
      this.deprecationDocUrl = deprecationDocUrl;
      return this;
    }

    /**
     * Set the dashboardUrl.
     *
     * @param dashboardUrl the dashboardUrl
     * @return the URLS builder
     */
    public Builder dashboardUrl(String dashboardUrl) {
      this.dashboardUrl = dashboardUrl;
      return this;
    }

    /**
     * Set the registrationUrl.
     *
     * @param registrationUrl the registrationUrl
     * @return the URLS builder
     */
    public Builder registrationUrl(String registrationUrl) {
      this.registrationUrl = registrationUrl;
      return this;
    }

    /**
     * Set the apidocsurl.
     *
     * @param apidocsurl the apidocsurl
     * @return the URLS builder
     */
    public Builder apidocsurl(String apidocsurl) {
      this.apidocsurl = apidocsurl;
      return this;
    }
  }

  protected URLS(Builder builder) {
    docUrl = builder.docUrl;
    instructionsUrl = builder.instructionsUrl;
    apiUrl = builder.apiUrl;
    createUrl = builder.createUrl;
    sdkDownloadUrl = builder.sdkDownloadUrl;
    termsUrl = builder.termsUrl;
    customCreatePageUrl = builder.customCreatePageUrl;
    catalogDetailsUrl = builder.catalogDetailsUrl;
    deprecationDocUrl = builder.deprecationDocUrl;
    dashboardUrl = builder.dashboardUrl;
    registrationUrl = builder.registrationUrl;
    apidocsurl = builder.apidocsurl;
  }

  /**
   * New builder.
   *
   * @return a URLS builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the docUrl.
   *
   * URL for documentation.
   *
   * @return the docUrl
   */
  public String docUrl() {
    return docUrl;
  }

  /**
   * Gets the instructionsUrl.
   *
   * URL for usage instructions.
   *
   * @return the instructionsUrl
   */
  public String instructionsUrl() {
    return instructionsUrl;
  }

  /**
   * Gets the apiUrl.
   *
   * API URL.
   *
   * @return the apiUrl
   */
  public String apiUrl() {
    return apiUrl;
  }

  /**
   * Gets the createUrl.
   *
   * URL Creation UI / API.
   *
   * @return the createUrl
   */
  public String createUrl() {
    return createUrl;
  }

  /**
   * Gets the sdkDownloadUrl.
   *
   * URL to downlaod an SDK.
   *
   * @return the sdkDownloadUrl
   */
  public String sdkDownloadUrl() {
    return sdkDownloadUrl;
  }

  /**
   * Gets the termsUrl.
   *
   * URL to the terms of use for your service.
   *
   * @return the termsUrl
   */
  public String termsUrl() {
    return termsUrl;
  }

  /**
   * Gets the customCreatePageUrl.
   *
   * URL to the custom create page for your serivce.
   *
   * @return the customCreatePageUrl
   */
  public String customCreatePageUrl() {
    return customCreatePageUrl;
  }

  /**
   * Gets the catalogDetailsUrl.
   *
   * URL to the catalog details page for your serivce.
   *
   * @return the catalogDetailsUrl
   */
  public String catalogDetailsUrl() {
    return catalogDetailsUrl;
  }

  /**
   * Gets the deprecationDocUrl.
   *
   * URL for deprecation documentation.
   *
   * @return the deprecationDocUrl
   */
  public String deprecationDocUrl() {
    return deprecationDocUrl;
  }

  /**
   * Gets the dashboardUrl.
   *
   * URL for dashboard.
   *
   * @return the dashboardUrl
   */
  public String dashboardUrl() {
    return dashboardUrl;
  }

  /**
   * Gets the registrationUrl.
   *
   * URL for registration.
   *
   * @return the registrationUrl
   */
  public String registrationUrl() {
    return registrationUrl;
  }

  /**
   * Gets the apidocsurl.
   *
   * URL for API documentation.
   *
   * @return the apidocsurl
   */
  public String apidocsurl() {
    return apidocsurl;
  }
}

