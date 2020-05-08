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
package com.ibm.cloud.platform_services.case_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * OfferingType.
 */
public class OfferingType extends GenericModel {

  protected String group;
  protected String key;
  protected String id;
  protected String kind;

  /**
   * Gets the group.
   *
   * indicating whether this is an offering or a broad category.
   *
   * @return the group
   */
  public String getGroup() {
    return group;
  }

  /**
   * Gets the key.
   *
   * crn service name of the offering or the value of the category.
   *
   * @return the key
   */
  public String getKey() {
    return key;
  }

  /**
   * Gets the id.
   *
   * catalog id of the offering.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the kind.
   *
   * kind of the offering.
   *
   * @return the kind
   */
  public String getKind() {
    return kind;
  }
}

