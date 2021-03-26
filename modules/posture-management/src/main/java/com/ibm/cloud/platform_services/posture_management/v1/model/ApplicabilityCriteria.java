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
package com.ibm.cloud.platform_services.posture_management.v1.model;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The criteria that defines how a profile applies.
 */
public class ApplicabilityCriteria extends GenericModel {

  protected List<String> environment;
  protected List<String> resource;
  @SerializedName("environment_category")
  protected List<String> environmentCategory;
  @SerializedName("resource_category")
  protected List<String> resourceCategory;
  @SerializedName("resource_type")
  protected List<String> resourceType;
  @SerializedName("software_details")
  protected Map<String, Object> softwareDetails;
  @SerializedName("os_details")
  protected Map<String, Object> osDetails;
  @SerializedName("additional_details")
  protected Map<String, Object> additionalDetails;
  @SerializedName("environment_category_description")
  protected Map<String, String> environmentCategoryDescription;
  @SerializedName("environment_description")
  protected Map<String, String> environmentDescription;
  @SerializedName("resource_category_description")
  protected Map<String, String> resourceCategoryDescription;
  @SerializedName("resource_type_description")
  protected Map<String, String> resourceTypeDescription;
  @SerializedName("resource_description")
  protected Map<String, String> resourceDescription;

  /**
   * Gets the environment.
   *
   * A list of environments that a profile can be applied to.
   *
   * @return the environment
   */
  public List<String> getEnvironment() {
    return environment;
  }

  /**
   * Gets the resource.
   *
   * A list of resources that a profile can be used with.
   *
   * @return the resource
   */
  public List<String> getResource() {
    return resource;
  }

  /**
   * Gets the environmentCategory.
   *
   * The type of environment that a profile is able to be applied to.
   *
   * @return the environmentCategory
   */
  public List<String> getEnvironmentCategory() {
    return environmentCategory;
  }

  /**
   * Gets the resourceCategory.
   *
   * The type of resource that a profile is able to be applied to.
   *
   * @return the resourceCategory
   */
  public List<String> getResourceCategory() {
    return resourceCategory;
  }

  /**
   * Gets the resourceType.
   *
   * The resource type that the profile applies to.
   *
   * @return the resourceType
   */
  public List<String> getResourceType() {
    return resourceType;
  }

  /**
   * Gets the softwareDetails.
   *
   * The software that the profile applies to.
   *
   * @return the softwareDetails
   */
  public Map<String, Object> getSoftwareDetails() {
    return softwareDetails;
  }

  /**
   * Gets the osDetails.
   *
   * The operatoring system that the profile applies to.
   *
   * @return the osDetails
   */
  public Map<String, Object> getOsDetails() {
    return osDetails;
  }

  /**
   * Gets the additionalDetails.
   *
   * Any additional details about the profile.
   *
   * @return the additionalDetails
   */
  public Map<String, Object> getAdditionalDetails() {
    return additionalDetails;
  }

  /**
   * Gets the environmentCategoryDescription.
   *
   * The type of environment that your scope is targeted to.
   *
   * @return the environmentCategoryDescription
   */
  public Map<String, String> getEnvironmentCategoryDescription() {
    return environmentCategoryDescription;
  }

  /**
   * Gets the environmentDescription.
   *
   * The environment that your scope is targeted to.
   *
   * @return the environmentDescription
   */
  public Map<String, String> getEnvironmentDescription() {
    return environmentDescription;
  }

  /**
   * Gets the resourceCategoryDescription.
   *
   * The type of resource that your scope is targeted to.
   *
   * @return the resourceCategoryDescription
   */
  public Map<String, String> getResourceCategoryDescription() {
    return resourceCategoryDescription;
  }

  /**
   * Gets the resourceTypeDescription.
   *
   * A further classification of the type of resource that your scope is targeted to.
   *
   * @return the resourceTypeDescription
   */
  public Map<String, String> getResourceTypeDescription() {
    return resourceTypeDescription;
  }

  /**
   * Gets the resourceDescription.
   *
   * The resource that is scanned as part of your scope.
   *
   * @return the resourceDescription
   */
  public Map<String, String> getResourceDescription() {
    return resourceDescription;
  }
}

