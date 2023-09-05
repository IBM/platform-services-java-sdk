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

package com.ibm.cloud.platform_services.iam_access_groups.v2.model;

import com.ibm.cloud.platform_services.iam_access_groups.v2.model.Assertions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AssertionsActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AssertionsRule;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.Conditions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RuleActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Assertions model.
 */
public class AssertionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAssertions() throws Throwable {
    Conditions conditionsModel = new Conditions.Builder()
      .claim("testString")
      .operator("testString")
      .value("testString")
      .build();
    assertEquals(conditionsModel.claim(), "testString");
    assertEquals(conditionsModel.operator(), "testString");
    assertEquals(conditionsModel.value(), "testString");

    RuleActionControls ruleActionControlsModel = new RuleActionControls.Builder()
      .remove(true)
      .build();
    assertEquals(ruleActionControlsModel.remove(), Boolean.valueOf(true));

    AssertionsRule assertionsRuleModel = new AssertionsRule.Builder()
      .name("testString")
      .expiration(Long.valueOf("26"))
      .realmName("testString")
      .conditions(java.util.Arrays.asList(conditionsModel))
      .actionControls(ruleActionControlsModel)
      .build();
    assertEquals(assertionsRuleModel.name(), "testString");
    assertEquals(assertionsRuleModel.expiration(), Long.valueOf("26"));
    assertEquals(assertionsRuleModel.realmName(), "testString");
    assertEquals(assertionsRuleModel.conditions(), java.util.Arrays.asList(conditionsModel));
    assertEquals(assertionsRuleModel.actionControls(), ruleActionControlsModel);

    AssertionsActionControls assertionsActionControlsModel = new AssertionsActionControls.Builder()
      .add(true)
      .remove(true)
      .build();
    assertEquals(assertionsActionControlsModel.add(), Boolean.valueOf(true));
    assertEquals(assertionsActionControlsModel.remove(), Boolean.valueOf(true));

    Assertions assertionsModel = new Assertions.Builder()
      .rules(java.util.Arrays.asList(assertionsRuleModel))
      .actionControls(assertionsActionControlsModel)
      .build();
    assertEquals(assertionsModel.rules(), java.util.Arrays.asList(assertionsRuleModel));
    assertEquals(assertionsModel.actionControls(), assertionsActionControlsModel);

    String json = TestUtilities.serialize(assertionsModel);

    Assertions assertionsModelNew = TestUtilities.deserialize(json, Assertions.class);
    assertTrue(assertionsModelNew instanceof Assertions);
    assertEquals(assertionsModelNew.actionControls().toString(), assertionsActionControlsModel.toString());
  }
}