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
import com.ibm.cloud.platform_services.configuration_governance.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the RuleConditionSingleProperty model.
 */
public class RuleConditionSinglePropertyTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRuleConditionSingleProperty() throws Throwable {
    RuleConditionSingleProperty ruleConditionSinglePropertyModel = new RuleConditionSingleProperty.Builder()
      .description("testString")
      .property("public_access_enabled")
      .operator("is_true")
      .value("testString")
      .build();
    assertEquals(ruleConditionSinglePropertyModel.description(), "testString");
    assertEquals(ruleConditionSinglePropertyModel.property(), "public_access_enabled");
    assertEquals(ruleConditionSinglePropertyModel.operator(), "is_true");
    assertEquals(ruleConditionSinglePropertyModel.value(), "testString");

    String json = TestUtilities.serialize(ruleConditionSinglePropertyModel);

    RuleConditionSingleProperty ruleConditionSinglePropertyModelNew = TestUtilities.deserialize(json, RuleConditionSingleProperty.class);
    assertTrue(ruleConditionSinglePropertyModelNew instanceof RuleConditionSingleProperty);
    assertEquals(ruleConditionSinglePropertyModelNew.description(), "testString");
    assertEquals(ruleConditionSinglePropertyModelNew.property(), "public_access_enabled");
    assertEquals(ruleConditionSinglePropertyModelNew.operator(), "is_true");
    assertEquals(ruleConditionSinglePropertyModelNew.value(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRuleConditionSinglePropertyError() throws Throwable {
    new RuleConditionSingleProperty.Builder().build();
  }

}