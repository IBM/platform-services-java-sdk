/*
 * (C) Copyright IBM Corp. 2026.
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

package com.ibm.cloud.platform_services.context_based_restrictions.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The error target.
 */
public class ErrorTarget extends GenericModel {

  /**
   * The error target type.
   */
  public interface Type {
    /** field. */
    String FIELD = "field";
    /** parameter. */
    String PARAMETER = "parameter";
    /** header. */
    String HEADER = "header";
  }

  protected String type;
  protected String name;
  protected String value;

  protected ErrorTarget() { }

  /**
   * Gets the type.
   *
   * The error target type.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the name.
   *
   * The error target name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the value.
   *
   * The error target value.
   *
   * @return the value
   */
  public String getValue() {
    return value;
  }
}

