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

import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The name of the requested chart, or the name of a nested chart within the requested chart.
 */
public class HelmPackageChart extends GenericModel {

  @SerializedName("Chart.yaml")
  protected HelmChart chartYaml;
  protected Map<String, Object> sha;
  @SerializedName("README.md")
  protected String readmeMd;
  @SerializedName("values-metadata")
  protected Map<String, Object> valuesMetadata;
  @SerializedName("license-metadata")
  protected Map<String, Object> licenseMetadata;

  /**
   * Gets the chartYaml.
   *
   * Helm chart.
   *
   * @return the chartYaml
   */
  public HelmChart getChartYaml() {
    return chartYaml;
  }

  /**
   * Gets the sha.
   *
   * Project SHA.
   *
   * @return the sha
   */
  public Map<String, Object> getSha() {
    return sha;
  }

  /**
   * Gets the readmeMd.
   *
   * Helm chart description.
   *
   * @return the readmeMd
   */
  public String getReadmeMd() {
    return readmeMd;
  }

  /**
   * Gets the valuesMetadata.
   *
   * Values metadata.
   *
   * @return the valuesMetadata
   */
  public Map<String, Object> getValuesMetadata() {
    return valuesMetadata;
  }

  /**
   * Gets the licenseMetadata.
   *
   * License metadata.
   *
   * @return the licenseMetadata
   */
  public Map<String, Object> getLicenseMetadata() {
    return licenseMetadata;
  }
}

