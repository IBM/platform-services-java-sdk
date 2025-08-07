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

package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * ProfileLinkLink.
 */
public class ProfileLinkLink extends GenericModel {

  protected String crn;
  protected String namespace;
  protected String name;
  @SerializedName("component_type")
  protected String componentType;
  @SerializedName("component_name")
  protected String componentName;

  protected ProfileLinkLink() { }

  /**
   * Gets the crn.
   *
   * The CRN of the compute resource.
   *
   * @return the crn
   */
  public String getCrn() {
    return crn;
  }

  /**
   * Gets the namespace.
   *
   * The compute resource namespace, only required if cr_type is IKS_SA or ROKS_SA.
   *
   * @return the namespace
   */
  public String getNamespace() {
    return namespace;
  }

  /**
   * Gets the name.
   *
   * Name of the compute resource, only required if cr_type is IKS_SA or ROKS_SA.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the componentType.
   *
   * Component type of the compute resource, only required if cr_type is CE.
   *
   * @return the componentType
   */
  public String getComponentType() {
    return componentType;
  }

  /**
   * Gets the componentName.
   *
   * Component name of the compute resource, only required if cr_type is CE.
   *
   * @return the componentName
   */
  public String getComponentName() {
    return componentName;
  }
}

