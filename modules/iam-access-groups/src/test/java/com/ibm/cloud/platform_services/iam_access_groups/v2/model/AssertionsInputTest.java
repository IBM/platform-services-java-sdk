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

import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AssertionsActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AssertionsInput;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ConditionInput;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RuleInput;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RulesActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the AssertionsInput model.
 */
public class AssertionsInputTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAssertionsInput() throws Throwable {
    ConditionInput conditionInputModel = new ConditionInput.Builder()
      .claim("testString")
      .operator("testString")
      .value("testString")
      .build();
    assertEquals(conditionInputModel.claim(), "testString");
    assertEquals(conditionInputModel.operator(), "testString");
    assertEquals(conditionInputModel.value(), "testString");

    RulesActionControls rulesActionControlsModel = new RulesActionControls.Builder()
      .remove(true)
      .build();
    assertEquals(rulesActionControlsModel.remove(), Boolean.valueOf(true));

    RuleInput ruleInputModel = new RuleInput.Builder()
      .name("testString")
      .expiration(Long.valueOf("26"))
      .realmName("testString")
      .conditions(java.util.Arrays.asList(conditionInputModel))
      .actionControls(rulesActionControlsModel)
      .build();
    assertEquals(ruleInputModel.name(), "testString");
    assertEquals(ruleInputModel.expiration(), Long.valueOf("26"));
    assertEquals(ruleInputModel.realmName(), "testString");
    assertEquals(ruleInputModel.conditions(), java.util.Arrays.asList(conditionInputModel));
    assertEquals(ruleInputModel.actionControls(), rulesActionControlsModel);

    AssertionsActionControls assertionsActionControlsModel = new AssertionsActionControls.Builder()
      .add(true)
      .remove(true)
      .build();
    assertEquals(assertionsActionControlsModel.add(), Boolean.valueOf(true));
    assertEquals(assertionsActionControlsModel.remove(), Boolean.valueOf(true));

    AssertionsInput assertionsInputModel = new AssertionsInput.Builder()
      .rules(java.util.Arrays.asList(ruleInputModel))
      .actionControls(assertionsActionControlsModel)
      .build();
    assertEquals(assertionsInputModel.rules(), java.util.Arrays.asList(ruleInputModel));
    assertEquals(assertionsInputModel.actionControls(), assertionsActionControlsModel);

    String json = TestUtilities.serialize(assertionsInputModel);

    AssertionsInput assertionsInputModelNew = TestUtilities.deserialize(json, AssertionsInput.class);
    assertTrue(assertionsInputModelNew instanceof AssertionsInput);
    assertEquals(assertionsInputModelNew.actionControls().toString(), assertionsActionControlsModel.toString());
  }
}