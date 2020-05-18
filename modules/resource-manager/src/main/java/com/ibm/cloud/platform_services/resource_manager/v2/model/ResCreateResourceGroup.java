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
package com.ibm.cloud.platform_services.resource_manager.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A newly-created resource group.
 */
public class ResCreateResourceGroup extends GenericModel {

  protected String id;
  protected String crn;

  /**
   * Gets the id.
   *
   * An alpha-numeric value identifying the resource group.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the crn.
   *
   * The full CRN (cloud resource name) associated with the resource group. For more on this format, see [Cloud Resource
   * Names](https://cloud.ibm.com/docs/resources?topic=resources-crn).
   *
   * @return the crn
   */
  public String getCrn() {
    return crn;
  }
}

