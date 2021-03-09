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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Profile.
 */
public class Profile extends GenericModel {

  /**
   * The type of profile.
   */
  public interface ProfileType {
    /** predefined. */
    String PREDEFINED = "predefined";
    /** custom. */
    String CUSTOM = "custom";
    /** group. */
    String GROUP = "group";
  }

  protected String name;
  @SerializedName("no_of_goals")
  protected Long noOfGoals;
  protected String description;
  protected Long version;
  @SerializedName("created_by")
  protected String createdBy;
  @SerializedName("modified_by")
  protected String modifiedBy;
  @SerializedName("reason_for_delete")
  protected String reasonForDelete;
  @SerializedName("applicability_criteria")
  protected ApplicabilityCriteria applicabilityCriteria;
  @SerializedName("profile_id")
  protected Long profileId;
  @SerializedName("base_profile")
  protected String baseProfile;
  @SerializedName("profile_type")
  protected String profileType;
  @SerializedName("created_time")
  protected String createdTime;
  @SerializedName("modified_time")
  protected String modifiedTime;
  protected Boolean enabled;

  /**
   * Gets the name.
   *
   * The name of the profile.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the noOfGoals.
   *
   * The number of goals that are in the profile.
   *
   * @return the noOfGoals
   */
  public Long getNoOfGoals() {
    return noOfGoals;
  }

  /**
   * Gets the description.
   *
   * A description of the profile.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the version.
   *
   * The version of the profile.
   *
   * @return the version
   */
  public Long getVersion() {
    return version;
  }

  /**
   * Gets the createdBy.
   *
   * The user who created the profile.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the modifiedBy.
   *
   * The user who last modified the profile.
   *
   * @return the modifiedBy
   */
  public String getModifiedBy() {
    return modifiedBy;
  }

  /**
   * Gets the reasonForDelete.
   *
   * A reason that you want to delete a profile.
   *
   * @return the reasonForDelete
   */
  public String getReasonForDelete() {
    return reasonForDelete;
  }

  /**
   * Gets the applicabilityCriteria.
   *
   * The criteria that defines how a profile applies.
   *
   * @return the applicabilityCriteria
   */
  public ApplicabilityCriteria getApplicabilityCriteria() {
    return applicabilityCriteria;
  }

  /**
   * Gets the profileId.
   *
   * An auto-generated unique identifying number of the profile.
   *
   * @return the profileId
   */
  public Long getProfileId() {
    return profileId;
  }

  /**
   * Gets the baseProfile.
   *
   * The base profile that the controls are pulled from.
   *
   * @return the baseProfile
   */
  public String getBaseProfile() {
    return baseProfile;
  }

  /**
   * Gets the profileType.
   *
   * The type of profile.
   *
   * @return the profileType
   */
  public String getProfileType() {
    return profileType;
  }

  /**
   * Gets the createdTime.
   *
   * The time that the profile was created in UTC.
   *
   * @return the createdTime
   */
  public String getCreatedTime() {
    return createdTime;
  }

  /**
   * Gets the modifiedTime.
   *
   * The time that the profile was most recently modified in UTC.
   *
   * @return the modifiedTime
   */
  public String getModifiedTime() {
    return modifiedTime;
  }

  /**
   * Gets the enabled.
   *
   * The profile status. If the profile is enabled, the value is true. If the profile is disabled, the value is false.
   *
   * @return the enabled
   */
  public Boolean isEnabled() {
    return enabled;
  }
}

