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

import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AccessActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AccessGroupInput;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AssertionsActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AssertionsInput;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ConditionInput;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GroupActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.MembersActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.MembersInput;
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
 * Unit test class for the AccessGroupInput model.
 */
public class AccessGroupInputTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAccessGroupInput() throws Throwable {
    MembersActionControls membersActionControlsModel = new MembersActionControls.Builder()
      .add(true)
      .remove(true)
      .build();
    assertEquals(membersActionControlsModel.add(), Boolean.valueOf(true));
    assertEquals(membersActionControlsModel.remove(), Boolean.valueOf(true));

    MembersInput membersInputModel = new MembersInput.Builder()
      .users(java.util.Arrays.asList("testString"))
      .serviceIds(java.util.Arrays.asList("testString"))
      .actionControls(membersActionControlsModel)
      .build();
    assertEquals(membersInputModel.users(), java.util.Arrays.asList("testString"));
    assertEquals(membersInputModel.serviceIds(), java.util.Arrays.asList("testString"));
    assertEquals(membersInputModel.actionControls(), membersActionControlsModel);

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

    AccessActionControls accessActionControlsModel = new AccessActionControls.Builder()
      .add(true)
      .build();
    assertEquals(accessActionControlsModel.add(), Boolean.valueOf(true));

    GroupActionControls groupActionControlsModel = new GroupActionControls.Builder()
      .access(accessActionControlsModel)
      .build();
    assertEquals(groupActionControlsModel.access(), accessActionControlsModel);

    AccessGroupInput accessGroupInputModel = new AccessGroupInput.Builder()
      .name("testString")
      .description("testString")
      .members(membersInputModel)
      .assertions(assertionsInputModel)
      .actionControls(groupActionControlsModel)
      .build();
    assertEquals(accessGroupInputModel.name(), "testString");
    assertEquals(accessGroupInputModel.description(), "testString");
    assertEquals(accessGroupInputModel.members(), membersInputModel);
    assertEquals(accessGroupInputModel.assertions(), assertionsInputModel);
    assertEquals(accessGroupInputModel.actionControls(), groupActionControlsModel);

    String json = TestUtilities.serialize(accessGroupInputModel);

    AccessGroupInput accessGroupInputModelNew = TestUtilities.deserialize(json, AccessGroupInput.class);
    assertTrue(accessGroupInputModelNew instanceof AccessGroupInput);
    assertEquals(accessGroupInputModelNew.name(), "testString");
    assertEquals(accessGroupInputModelNew.description(), "testString");
    assertEquals(accessGroupInputModelNew.members().toString(), membersInputModel.toString());
    assertEquals(accessGroupInputModelNew.assertions().toString(), assertionsInputModel.toString());
    assertEquals(accessGroupInputModelNew.actionControls().toString(), groupActionControlsModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAccessGroupInputError() throws Throwable {
    new AccessGroupInput.Builder().build();
  }

}