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
package com.ibm.cloud.platform_services.configuration_governance.v1.model;

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The response associated with a request to create one or more rules.
 */
public class CreateRulesResponse extends GenericModel {

  protected List<CreateRuleResponse> rules;

  /**
   * Gets the rules.
   *
   * An array of rule responses.
   *
   * @return the rules
   */
  public List<CreateRuleResponse> getRules() {
    return rules;
  }
}

