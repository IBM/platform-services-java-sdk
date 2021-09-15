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
package com.ibm.cloud.context_based_restrictions.v1.model;

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A page of service reference targets.
 */
public class ServiceRefTargetPage extends GenericModel {

  protected List<ServiceRefTarget> targets;

  /**
   * Gets the targets.
   *
   * The list of service reference targets.
   *
   * @return the targets
   */
  public List<ServiceRefTarget> getTargets() {
    return targets;
  }
}

