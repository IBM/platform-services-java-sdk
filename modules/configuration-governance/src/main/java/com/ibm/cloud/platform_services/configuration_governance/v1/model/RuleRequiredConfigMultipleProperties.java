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

/**
 * The requirements that must be met to determine the resource's level of compliance in accordance with the rule.
 *
 * Use logical operators (`and`/`or`) to define multiple property checks and conditions. To define requirements for a
 * rule, list one or more property check objects in the `and` array. To add conditions to a property check, use `or`.
 *
 * Classes which extend this class:
 * - RuleRequiredConfigMultiplePropertiesConditionOr
 * - RuleRequiredConfigMultiplePropertiesConditionAnd
 */
public class RuleRequiredConfigMultipleProperties extends RuleRequiredConfig {


  protected RuleRequiredConfigMultipleProperties() {
  }
}

