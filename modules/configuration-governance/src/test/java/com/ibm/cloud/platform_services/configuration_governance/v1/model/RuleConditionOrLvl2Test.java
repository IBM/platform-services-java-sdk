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

import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleConditionOrLvl2;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleSingleProperty;
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
 * Unit test class for the RuleConditionOrLvl2 model.
 */
public class RuleConditionOrLvl2Test {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRuleConditionOrLvl2() throws Throwable {
    RuleSingleProperty ruleSinglePropertyModel = new RuleSingleProperty.Builder()
      .description("testString")
      .property("public_access_enabled")
      .operator("is_true")
      .value("testString")
      .build();
    assertEquals(ruleSinglePropertyModel.description(), "testString");
    assertEquals(ruleSinglePropertyModel.property(), "public_access_enabled");
    assertEquals(ruleSinglePropertyModel.operator(), "is_true");
    assertEquals(ruleSinglePropertyModel.value(), "testString");

    RuleConditionOrLvl2 ruleConditionOrLvl2Model = new RuleConditionOrLvl2.Builder()
      .description("testString")
      .or(new java.util.ArrayList<RuleSingleProperty>(java.util.Arrays.asList(ruleSinglePropertyModel)))
      .build();
    assertEquals(ruleConditionOrLvl2Model.description(), "testString");
    assertEquals(ruleConditionOrLvl2Model.or(), new java.util.ArrayList<RuleSingleProperty>(java.util.Arrays.asList(ruleSinglePropertyModel)));

    String json = TestUtilities.serialize(ruleConditionOrLvl2Model);

    RuleConditionOrLvl2 ruleConditionOrLvl2ModelNew = TestUtilities.deserialize(json, RuleConditionOrLvl2.class);
    assertTrue(ruleConditionOrLvl2ModelNew instanceof RuleConditionOrLvl2);
    assertEquals(ruleConditionOrLvl2ModelNew.description(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRuleConditionOrLvl2Error() throws Throwable {
    new RuleConditionOrLvl2.Builder().build();
  }

}