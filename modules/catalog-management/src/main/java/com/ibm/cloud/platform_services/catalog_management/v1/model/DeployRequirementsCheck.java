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
 * Failed deployment requirements.
 */
public class DeployRequirementsCheck extends GenericModel {

  @SerializedName("pre_install")
  protected Map<String, Object> preInstall;
  protected Map<String, Object> install;

  /**
   * Gets the preInstall.
   *
   * Failed during pre-install.
   *
   * @return the preInstall
   */
  public Map<String, Object> getPreInstall() {
    return preInstall;
  }

  /**
   * Gets the install.
   *
   * Failed during install.
   *
   * @return the install
   */
  public Map<String, Object> getInstall() {
    return install;
  }
}

