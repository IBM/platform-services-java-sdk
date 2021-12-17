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
package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Operator deploy result.
 */
public class OperatorDeployResult extends GenericModel {

  protected String phase;
  protected String message;
  protected String link;
  protected String name;
  protected String version;
  protected String namespace;
  @SerializedName("package_name")
  protected String packageName;
  @SerializedName("catalog_id")
  protected String catalogId;

  /**
   * Gets the phase.
   *
   * Status phase.
   *
   * @return the phase
   */
  public String getPhase() {
    return phase;
  }

  /**
   * Gets the message.
   *
   * Status message.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Gets the link.
   *
   * Operator API path.
   *
   * @return the link
   */
  public String getLink() {
    return link;
  }

  /**
   * Gets the name.
   *
   * Name of Operator.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the version.
   *
   * Operator version.
   *
   * @return the version
   */
  public String getVersion() {
    return version;
  }

  /**
   * Gets the namespace.
   *
   * Kube namespace.
   *
   * @return the namespace
   */
  public String getNamespace() {
    return namespace;
  }

  /**
   * Gets the packageName.
   *
   * Package Operator exists in.
   *
   * @return the packageName
   */
  public String getPackageName() {
    return packageName;
  }

  /**
   * Gets the catalogId.
   *
   * Catalog identification.
   *
   * @return the catalogId
   */
  public String getCatalogId() {
    return catalogId;
  }
}

