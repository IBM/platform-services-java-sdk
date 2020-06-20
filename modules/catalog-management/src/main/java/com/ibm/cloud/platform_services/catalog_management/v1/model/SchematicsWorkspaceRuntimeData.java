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
 * Data describing runtime.
 */
public class SchematicsWorkspaceRuntimeData extends GenericModel {

  protected String id;
  @SerializedName("engine_name")
  protected String engineName;
  @SerializedName("engine_version")
  protected String engineVersion;
  @SerializedName("state_store_url")
  protected String stateStoreUrl;
  @SerializedName("log_store_url")
  protected String logStoreUrl;

  /**
   * Gets the id.
   *
   * Runtime ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the engineName.
   *
   * Engine name.
   *
   * @return the engineName
   */
  public String getEngineName() {
    return engineName;
  }

  /**
   * Gets the engineVersion.
   *
   * Engine version.
   *
   * @return the engineVersion
   */
  public String getEngineVersion() {
    return engineVersion;
  }

  /**
   * Gets the stateStoreUrl.
   *
   * URL path to state store.
   *
   * @return the stateStoreUrl
   */
  public String getStateStoreUrl() {
    return stateStoreUrl;
  }

  /**
   * Gets the logStoreUrl.
   *
   * URL path to log store.
   *
   * @return the logStoreUrl
   */
  public String getLogStoreUrl() {
    return logStoreUrl;
  }
}

