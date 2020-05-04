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
 * Model used to describe metadata object returned.
 */
public class CatalogEntryMetadata extends GenericModel {

  @SerializedName("rc_compatible")
  protected Boolean rcCompatible;
  protected UIMetaData ui;
  protected List<String> compliance;
  protected ObjectMetadataBaseService service;
  protected ObjectMetadataBasePlan plan;
  protected ObjectMetadataBaseTemplate template;
  protected ObjectMetadataBaseAlias alias;
  protected ObjectMetadataBaseSla sla;
  protected Callbacks callbacks;
  protected String version;
  @SerializedName("original_name")
  protected String originalName;
  protected Map<String, Object> other;
  protected CatalogEntryMetadataPricing pricing;
  protected CatalogEntryMetadataDeployment deployment;

  /**
   * Gets the rcCompatible.
   *
   * Boolean value that describes whether the service is compatible with the Resource Controller.
   *
   * @return the rcCompatible
   */
  public Boolean isRcCompatible() {
    return rcCompatible;
  }

  /**
   * Gets the ui.
   *
   * Information related to the UI presentation associated with a catalog entry.
   *
   * @return the ui
   */
  public UIMetaData getUi() {
    return ui;
  }

  /**
   * Gets the compliance.
   *
   * Compliance information for HIPAA and PCI.
   *
   * @return the compliance
   */
  public List<String> getCompliance() {
    return compliance;
  }

  /**
   * Gets the service.
   *
   * Service-related metadata.
   *
   * @return the service
   */
  public ObjectMetadataBaseService getService() {
    return service;
  }

  /**
   * Gets the plan.
   *
   * Plan-related metadata.
   *
   * @return the plan
   */
  public ObjectMetadataBasePlan getPlan() {
    return plan;
  }

  /**
   * Gets the template.
   *
   * Template-related metadata.
   *
   * @return the template
   */
  public ObjectMetadataBaseTemplate getTemplate() {
    return template;
  }

  /**
   * Gets the alias.
   *
   * Alias-related metadata.
   *
   * @return the alias
   */
  public ObjectMetadataBaseAlias getAlias() {
    return alias;
  }

  /**
   * Gets the sla.
   *
   * Service Level Agreement related metadata.
   *
   * @return the sla
   */
  public ObjectMetadataBaseSla getSla() {
    return sla;
  }

  /**
   * Gets the callbacks.
   *
   * Callback-related information associated with a catalog entry.
   *
   * @return the callbacks
   */
  public Callbacks getCallbacks() {
    return callbacks;
  }

  /**
   * Gets the version.
   *
   * Optional version of the object.
   *
   * @return the version
   */
  public String getVersion() {
    return version;
  }

  /**
   * Gets the originalName.
   *
   * The original name of the object.
   *
   * @return the originalName
   */
  public String getOriginalName() {
    return originalName;
  }

  /**
   * Gets the other.
   *
   * Additional information.
   *
   * @return the other
   */
  public Map<String, Object> getOther() {
    return other;
  }

  /**
   * Gets the pricing.
   *
   * Pricing-related information.
   *
   * @return the pricing
   */
  public CatalogEntryMetadataPricing getPricing() {
    return pricing;
  }

  /**
   * Gets the deployment.
   *
   * Deployment-related metadata.
   *
   * @return the deployment
   */
  public CatalogEntryMetadataDeployment getDeployment() {
    return deployment;
  }
}

