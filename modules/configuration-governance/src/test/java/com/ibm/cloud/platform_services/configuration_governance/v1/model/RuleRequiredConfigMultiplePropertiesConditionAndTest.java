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

import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleConditionSingleProperty;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleRequiredConfigMultiplePropertiesConditionAnd;
import com.ibm.cloud.platform_services.configuration_governance.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the RuleRequiredConfigMultiplePropertiesConditionAnd model.
 */
public class RuleRequiredConfigMultiplePropertiesConditionAndTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRuleRequiredConfigMultiplePropertiesConditionAnd() throws Throwable {
    RuleConditionSingleProperty ruleConditionModel = new RuleConditionSingleProperty.Builder()
      .description("testString")
      .property("public_access_enabled")
      .operator("is_true")
      .value("testString")
      .build();
    assertEquals(ruleConditionModel.description(), "testString");
    assertEquals(ruleConditionModel.property(), "public_access_enabled");
    assertEquals(ruleConditionModel.operator(), "is_true");
    assertEquals(ruleConditionModel.value(), "testString");

    RuleRequiredConfigMultiplePropertiesConditionAnd ruleRequiredConfigMultiplePropertiesConditionAndModel = new RuleRequiredConfigMultiplePropertiesConditionAnd.Builder()
      .description("testString")
      .and(new java.util.ArrayList<RuleCondition>(java.util.Arrays.asList(ruleConditionModel)))
      .build();
    assertEquals(ruleRequiredConfigMultiplePropertiesConditionAndModel.description(), "testString");
    assertEquals(ruleRequiredConfigMultiplePropertiesConditionAndModel.and(), new java.util.ArrayList<RuleCondition>(java.util.Arrays.asList(ruleConditionModel)));

    String json = TestUtilities.serialize(ruleRequiredConfigMultiplePropertiesConditionAndModel);

    RuleRequiredConfigMultiplePropertiesConditionAnd ruleRequiredConfigMultiplePropertiesConditionAndModelNew = TestUtilities.deserialize(json, RuleRequiredConfigMultiplePropertiesConditionAnd.class);
    assertTrue(ruleRequiredConfigMultiplePropertiesConditionAndModelNew instanceof RuleRequiredConfigMultiplePropertiesConditionAnd);
    assertEquals(ruleRequiredConfigMultiplePropertiesConditionAndModelNew.description(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRuleRequiredConfigMultiplePropertiesConditionAndError() throws Throwable {
    new RuleRequiredConfigMultiplePropertiesConditionAnd.Builder().build();
  }

}