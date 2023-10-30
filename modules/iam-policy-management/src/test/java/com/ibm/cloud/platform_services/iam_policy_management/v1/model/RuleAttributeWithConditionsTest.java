/*
 * (C) Copyright IBM Corp. 2023.
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

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.RuleAttribute;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.RuleAttributeWithConditions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the RuleAttributeWithConditions model.
 */
public class RuleAttributeWithConditionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRuleAttributeWithConditions() throws Throwable {
    RuleAttribute ruleAttributeModel = new RuleAttribute.Builder()
      .key("testString")
      .operator("timeLessThan")
      .value("testString")
      .build();
    assertEquals(ruleAttributeModel.key(), "testString");
    assertEquals(ruleAttributeModel.operator(), "timeLessThan");
    assertEquals(ruleAttributeModel.value(), "testString");

    RuleAttributeWithConditions ruleAttributeWithConditionsModel = new RuleAttributeWithConditions.Builder()
      .key("testString")
      .operator("timeLessThan")
      .value("testString")
      .conditions(java.util.Arrays.asList(ruleAttributeModel))
      .build();
    assertEquals(ruleAttributeWithConditionsModel.key(), "testString");
    assertEquals(ruleAttributeWithConditionsModel.operator(), "timeLessThan");
    assertEquals(ruleAttributeWithConditionsModel.value(), "testString");
    assertEquals(ruleAttributeWithConditionsModel.conditions(), java.util.Arrays.asList(ruleAttributeModel));

    String json = TestUtilities.serialize(ruleAttributeWithConditionsModel);

    RuleAttributeWithConditions ruleAttributeWithConditionsModelNew = TestUtilities.deserialize(json, RuleAttributeWithConditions.class);
    assertTrue(ruleAttributeWithConditionsModelNew instanceof RuleAttributeWithConditions);
    assertEquals(ruleAttributeWithConditionsModelNew.key(), "testString");
    assertEquals(ruleAttributeWithConditionsModelNew.operator(), "timeLessThan");
    assertEquals(ruleAttributeWithConditionsModelNew.value(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRuleAttributeWithConditionsError() throws Throwable {
    new RuleAttributeWithConditions.Builder().build();
  }

}