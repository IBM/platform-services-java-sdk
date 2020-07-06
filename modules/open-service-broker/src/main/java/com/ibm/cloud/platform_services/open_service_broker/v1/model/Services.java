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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The service object that describes the properties of your service.
 */
public class Services extends GenericModel {

  protected Boolean bindable;
  protected String description;
  protected String id;
  protected String name;
  @SerializedName("plan_updateable")
  protected Boolean planUpdateable;
  protected List<Plans> plans;

  /**
   * Gets the bindable.
   *
   * Specifies whether or not your service can be bound to applications in IBM Cloud. If bindable, it must be able to
   * return API endpoints and credentials to your service consumers.
   *
   * @return the bindable
   */
  public Boolean isBindable() {
    return bindable;
  }

  /**
   * Gets the description.
   *
   * A short description of the service. It MUST be a non-empty string. Note that this description is not displayed by
   * the the IBM Cloud console or IBM Cloud CLI.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the id.
   *
   * An identifier used to correlate this service in future requests to the broker. This MUST be globally unique within
   * the IBM Cloud platform. It MUST be a non-empty string, and using a GUID is recommended. Recommended: If you define
   * your service in the RMC, the RMC will generate a globally unique GUID service ID that you can use in your service
   * broker.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the name.
   *
   * The service name is not your display name. Your service name must follow the follow these rules:
   *  - It must be all lowercase.
   *  - It can't include spaces but may include hyphens (`-`).
   *  - It must be less than 32 characters.
   *  Your service name should include your company name. If your company has more then one offering your service name
   * should include both company and offering as part of the name. For example, the Compose company has offerings for
   * Redis and Elasticsearch. Sample service names on IBM Cloud for these offerings would be `compose-redis` and
   * `compose-elasticsearch`.  Each of these service names have associated display names that are shown in the IBM Cloud
   * catalog: *Compose Redis* and *Compose Elasticsearch*. Another company (e.g. FastJetMail) may only have the single
   * JetMail offering, in which case the service name should be `fastjetmail`. Recommended: If you define your service
   * in RMC, you can export a catalog.json that will include the service name you defined within the RMC.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the planUpdateable.
   *
   * The Default is false. This specifices whether or not you support plan changes for provisioned instances. If your
   * offering supports multiple plans, and you want users to be able to change plans for a provisioned instance, you
   * will need to enable the ability for users to update their service instance by using
   * /v2/service_instances/{instance_id} PATCH.
   *
   * @return the planUpdateable
   */
  public Boolean isPlanUpdateable() {
    return planUpdateable;
  }

  /**
   * Gets the plans.
   *
   * A list of plans for this service that must contain at least one plan.
   *
   * @return the plans
   */
  public List<Plans> getPlans() {
    return plans;
  }
}

