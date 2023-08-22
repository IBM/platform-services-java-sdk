/*
 * (C) Copyright IBM Corp. 2023.
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
package com.ibm.cloud.platform_services.iam_access_groups.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Assignment resource entry.
 */
public class AssignmentResourceEntry extends GenericModel {

  protected String id;
  protected String name;
  protected String version;
  protected String resource;
  protected String error;
  protected String operation;
  protected String status;

  protected AssignmentResourceEntry() { }

  /**
   * Gets the id.
   *
   * Assignment Resource Entry Id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the name.
   *
   * Optional name of the resource.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the version.
   *
   * Optional version of the resource.
   *
   * @return the version
   */
  public String getVersion() {
    return version;
  }

  /**
   * Gets the resource.
   *
   * Resource in assignment resource entry.
   *
   * @return the resource
   */
  public String getResource() {
    return resource;
  }

  /**
   * Gets the error.
   *
   * Error in assignment resource entry.
   *
   * @return the error
   */
  public String getError() {
    return error;
  }

  /**
   * Gets the operation.
   *
   * Optional operation on the resource.
   *
   * @return the operation
   */
  public String getOperation() {
    return operation;
  }

  /**
   * Gets the status.
   *
   * Status of assignment resource entry.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }
}

