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
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleRequiredConfigMultiplePropertiesConditionOr;
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
 * Unit test class for the RuleRequiredConfigMultiplePropertiesConditionOr model.
 */
public class RuleRequiredConfigMultiplePropertiesConditionOrTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRuleRequiredConfigMultiplePropertiesConditionOr() throws Throwable {
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

    RuleRequiredConfigMultiplePropertiesConditionOr ruleRequiredConfigMultiplePropertiesConditionOrModel = new RuleRequiredConfigMultiplePropertiesConditionOr.Builder()
      .description("testString")
      .or(new java.util.ArrayList<RuleCondition>(java.util.Arrays.asList(ruleConditionModel)))
      .build();
    assertEquals(ruleRequiredConfigMultiplePropertiesConditionOrModel.description(), "testString");
    assertEquals(ruleRequiredConfigMultiplePropertiesConditionOrModel.or(), new java.util.ArrayList<RuleCondition>(java.util.Arrays.asList(ruleConditionModel)));

    String json = TestUtilities.serialize(ruleRequiredConfigMultiplePropertiesConditionOrModel);

    RuleRequiredConfigMultiplePropertiesConditionOr ruleRequiredConfigMultiplePropertiesConditionOrModelNew = TestUtilities.deserialize(json, RuleRequiredConfigMultiplePropertiesConditionOr.class);
    assertTrue(ruleRequiredConfigMultiplePropertiesConditionOrModelNew instanceof RuleRequiredConfigMultiplePropertiesConditionOr);
    assertEquals(ruleRequiredConfigMultiplePropertiesConditionOrModelNew.description(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRuleRequiredConfigMultiplePropertiesConditionOrError() throws Throwable {
    new RuleRequiredConfigMultiplePropertiesConditionOr.Builder().build();
  }

}