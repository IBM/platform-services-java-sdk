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
package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * RoleList.
 */
public class RoleList extends GenericModel {

  @SerializedName("custom_roles")
  protected List<RoleListCustomRolesItem> customRoles;
  @SerializedName("service_roles")
  protected List<RoleListServiceRolesItem> serviceRoles;
  @SerializedName("system_roles")
  protected List<RoleListSystemRolesItem> systemRoles;

  /**
   * Gets the customRoles.
   *
   * List of custom roles.
   *
   * @return the customRoles
   */
  public List<RoleListCustomRolesItem> getCustomRoles() {
    return customRoles;
  }

  /**
   * Gets the serviceRoles.
   *
   * List of service roles.
   *
   * @return the serviceRoles
   */
  public List<RoleListServiceRolesItem> getServiceRoles() {
    return serviceRoles;
  }

  /**
   * Gets the systemRoles.
   *
   * List of system roles.
   *
   * @return the systemRoles
   */
  public List<RoleListSystemRolesItem> getSystemRoles() {
    return systemRoles;
  }
}

