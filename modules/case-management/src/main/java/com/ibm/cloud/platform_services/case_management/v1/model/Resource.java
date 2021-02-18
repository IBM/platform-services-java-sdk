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
package com.ibm.cloud.platform_services.case_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A resource record of a case.
 */
public class Resource extends GenericModel {

  protected String crn;
  protected String name;
  protected String type;
  protected String url;
  protected String note;

  /**
   * Gets the crn.
   *
   * ID of the resource.
   *
   * @return the crn
   */
  public String getCrn() {
    return crn;
  }

  /**
   * Gets the name.
   *
   * Name of the resource.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the type.
   *
   * Type of resource.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the url.
   *
   * URL of resource.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the note.
   *
   * Note about resource.
   *
   * @return the note
   */
  public String getNote() {
    return note;
  }
}

