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
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.CreateTemplateResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GroupActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.MembersActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.MembersInput;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.PolicyTemplatesInput;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RuleInput;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RulesActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateTemplateResponse model.
 */
public class CreateTemplateResponseTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateTemplateResponse() throws Throwable {
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

    PolicyTemplatesInput policyTemplatesInputModel = new PolicyTemplatesInput.Builder()
      .id("testString")
      .version("testString")
      .build();
    assertEquals(policyTemplatesInputModel.id(), "testString");
    assertEquals(policyTemplatesInputModel.version(), "testString");

    CreateTemplateResponse createTemplateResponseModel = new CreateTemplateResponse.Builder()
      .id("testString")
      .name("testString")
      .description("testString")
      .accountId("testString")
      .version("testString")
      .committed(true)
      .group(accessGroupInputModel)
      .policyTemplateReferences(java.util.Arrays.asList(policyTemplatesInputModel))
      .href("testString")
      .createdAt(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .createdById("testString")
      .lastModifiedAt(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .lastModifiedById("testString")
      .build();
    assertEquals(createTemplateResponseModel.id(), "testString");
    assertEquals(createTemplateResponseModel.name(), "testString");
    assertEquals(createTemplateResponseModel.description(), "testString");
    assertEquals(createTemplateResponseModel.accountId(), "testString");
    assertEquals(createTemplateResponseModel.version(), "testString");
    assertEquals(createTemplateResponseModel.committed(), Boolean.valueOf(true));
    assertEquals(createTemplateResponseModel.group(), accessGroupInputModel);
    assertEquals(createTemplateResponseModel.policyTemplateReferences(), java.util.Arrays.asList(policyTemplatesInputModel));
    assertEquals(createTemplateResponseModel.href(), "testString");
    assertEquals(createTemplateResponseModel.createdAt(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(createTemplateResponseModel.createdById(), "testString");
    assertEquals(createTemplateResponseModel.lastModifiedAt(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(createTemplateResponseModel.lastModifiedById(), "testString");

    String json = TestUtilities.serialize(createTemplateResponseModel);

    CreateTemplateResponse createTemplateResponseModelNew = TestUtilities.deserialize(json, CreateTemplateResponse.class);
    assertTrue(createTemplateResponseModelNew instanceof CreateTemplateResponse);
    assertEquals(createTemplateResponseModelNew.id(), "testString");
    assertEquals(createTemplateResponseModelNew.name(), "testString");
    assertEquals(createTemplateResponseModelNew.description(), "testString");
    assertEquals(createTemplateResponseModelNew.accountId(), "testString");
    assertEquals(createTemplateResponseModelNew.version(), "testString");
    assertEquals(createTemplateResponseModelNew.committed(), Boolean.valueOf(true));
    assertEquals(createTemplateResponseModelNew.group().toString(), accessGroupInputModel.toString());
    assertEquals(createTemplateResponseModelNew.href(), "testString");
    assertEquals(createTemplateResponseModelNew.createdAt(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(createTemplateResponseModelNew.createdById(), "testString");
    assertEquals(createTemplateResponseModelNew.lastModifiedAt(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(createTemplateResponseModelNew.lastModifiedById(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateTemplateResponseError() throws Throwable {
    new CreateTemplateResponse.Builder().build();
  }

}