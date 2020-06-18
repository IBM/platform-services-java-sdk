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

/**
 * Template repository.
 */
public class SchematicsWorkspaceTemplateRepo extends GenericModel {

  @SerializedName("repo_url")
  protected String repoUrl;
  @SerializedName("chart_name")
  protected String chartName;
  @SerializedName("script_name")
  protected String scriptName;
  @SerializedName("uninstall_script_name")
  protected String uninstallScriptName;
  @SerializedName("folder_name")
  protected String folderName;
  @SerializedName("repo_sha_value")
  protected String repoShaValue;

  /**
   * Gets the repoUrl.
   *
   * The fully qualified path of the tgz used in the deploy.
   *
   * @return the repoUrl
   */
  public String getRepoUrl() {
    return repoUrl;
  }

  /**
   * Gets the chartName.
   *
   * Name of chart.
   *
   * @return the chartName
   */
  public String getChartName() {
    return chartName;
  }

  /**
   * Gets the scriptName.
   *
   * Name of script.
   *
   * @return the scriptName
   */
  public String getScriptName() {
    return scriptName;
  }

  /**
   * Gets the uninstallScriptName.
   *
   * Name of uninstall script.
   *
   * @return the uninstallScriptName
   */
  public String getUninstallScriptName() {
    return uninstallScriptName;
  }

  /**
   * Gets the folderName.
   *
   * Name of folder.
   *
   * @return the folderName
   */
  public String getFolderName() {
    return folderName;
  }

  /**
   * Gets the repoShaValue.
   *
   * Digest of project.
   *
   * @return the repoShaValue
   */
  public String getRepoShaValue() {
    return repoShaValue;
  }
}

