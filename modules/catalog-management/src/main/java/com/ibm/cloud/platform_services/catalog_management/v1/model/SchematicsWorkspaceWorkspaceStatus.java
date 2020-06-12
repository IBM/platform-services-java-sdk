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
package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Workspace frozen/locked status.
 */
public class SchematicsWorkspaceWorkspaceStatus extends GenericModel {

  protected Boolean frozen;
  protected Boolean locked;

  /**
   * Gets the frozen.
   *
   * Workspace frozen state.
   *
   * @return the frozen
   */
  public Boolean isFrozen() {
    return frozen;
  }

  /**
   * Gets the locked.
   *
   * Workspace locked state.
   *
   * @return the locked
   */
  public Boolean isLocked() {
    return locked;
  }
}

