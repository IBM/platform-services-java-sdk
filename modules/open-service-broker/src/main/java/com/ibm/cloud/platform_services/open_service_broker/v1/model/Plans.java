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
package com.ibm.cloud.platform_services.open_service_broker.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Where is this in the source?.
 */
public class Plans extends GenericModel {

  protected String description;
  protected Boolean free;
  protected String id;
  protected String name;

  /**
   * Gets the description.
   *
   * A short description of the plan. It MUST be a non-empty string. The description is NOT displayed in the IBM Cloud
   * catalog or IBM Cloud CLI.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the free.
   *
   * When false, service instances of this plan have a cost. The default is true.
   *
   * @return the free
   */
  public Boolean isFree() {
    return free;
  }

  /**
   * Gets the id.
   *
   * An identifier used to correlate this plan in future requests to the broker.  This MUST be globally unique within a
   * platform marketplace. It MUST be a non-empty string and using a GUID is RECOMMENDED. If you define your service in
   * the RMC, it will create a unique GUID for you to use. It is recommended to use the RMC to define and generate these
   * values and then use them in your catalog.json metadata in your broker. This value is NOT displayed in the IBM Cloud
   * catalog or IBM Cloud CLI.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the name.
   *
   * The programmatic name of the plan. It MUST be unique within the service. All lowercase, no spaces. It MUST be a
   * non-empty string, and it's NOT displayed in the IBM Cloud catalog or IBM Cloud CLI.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }
}

