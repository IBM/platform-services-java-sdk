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

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.Control;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.Grant;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.Roles;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.TemplatePolicy;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyResource;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyResourceAttribute;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyResourceTag;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyRuleRuleAttribute;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the TemplatePolicy model.
 */
public class TemplatePolicyTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testTemplatePolicy() throws Throwable {
    V2PolicyResourceAttribute v2PolicyResourceAttributeModel = new V2PolicyResourceAttribute.Builder()
      .key("testString")
      .operator("stringEquals")
      .value("testString")
      .build();
    assertEquals(v2PolicyResourceAttributeModel.key(), "testString");
    assertEquals(v2PolicyResourceAttributeModel.operator(), "stringEquals");
    assertEquals(v2PolicyResourceAttributeModel.value(), "testString");

    V2PolicyResourceTag v2PolicyResourceTagModel = new V2PolicyResourceTag.Builder()
      .key("testString")
      .value("testString")
      .operator("stringEquals")
      .build();
    assertEquals(v2PolicyResourceTagModel.key(), "testString");
    assertEquals(v2PolicyResourceTagModel.value(), "testString");
    assertEquals(v2PolicyResourceTagModel.operator(), "stringEquals");

    V2PolicyResource v2PolicyResourceModel = new V2PolicyResource.Builder()
      .attributes(java.util.Arrays.asList(v2PolicyResourceAttributeModel))
      .tags(java.util.Arrays.asList(v2PolicyResourceTagModel))
      .build();
    assertEquals(v2PolicyResourceModel.attributes(), java.util.Arrays.asList(v2PolicyResourceAttributeModel));
    assertEquals(v2PolicyResourceModel.tags(), java.util.Arrays.asList(v2PolicyResourceTagModel));

    V2PolicyRuleRuleAttribute v2PolicyRuleModel = new V2PolicyRuleRuleAttribute.Builder()
      .key("testString")
      .operator("timeLessThan")
      .value("testString")
      .build();
    assertEquals(v2PolicyRuleModel.key(), "testString");
    assertEquals(v2PolicyRuleModel.operator(), "timeLessThan");
    assertEquals(v2PolicyRuleModel.value(), "testString");

    Roles rolesModel = new Roles.Builder()
      .roleId("testString")
      .build();
    assertEquals(rolesModel.roleId(), "testString");

    Grant grantModel = new Grant.Builder()
      .roles(java.util.Arrays.asList(rolesModel))
      .build();
    assertEquals(grantModel.roles(), java.util.Arrays.asList(rolesModel));

    Control controlModel = new Control.Builder()
      .grant(grantModel)
      .build();
    assertEquals(controlModel.grant(), grantModel);

    TemplatePolicy templatePolicyModel = new TemplatePolicy.Builder()
      .type("access")
      .description("testString")
      .resource(v2PolicyResourceModel)
      .pattern("testString")
      .rule(v2PolicyRuleModel)
      .control(controlModel)
      .build();
    assertEquals(templatePolicyModel.type(), "access");
    assertEquals(templatePolicyModel.description(), "testString");
    assertEquals(templatePolicyModel.resource(), v2PolicyResourceModel);
    assertEquals(templatePolicyModel.pattern(), "testString");
    assertEquals(templatePolicyModel.rule(), v2PolicyRuleModel);
    assertEquals(templatePolicyModel.control(), controlModel);

    String json = TestUtilities.serialize(templatePolicyModel);

    TemplatePolicy templatePolicyModelNew = TestUtilities.deserialize(json, TemplatePolicy.class);
    assertTrue(templatePolicyModelNew instanceof TemplatePolicy);
    assertEquals(templatePolicyModelNew.type(), "access");
    assertEquals(templatePolicyModelNew.description(), "testString");
    assertEquals(templatePolicyModelNew.resource().toString(), v2PolicyResourceModel.toString());
    assertEquals(templatePolicyModelNew.pattern(), "testString");
    assertEquals(templatePolicyModelNew.rule().toString(), v2PolicyRuleModel.toString());
    assertEquals(templatePolicyModelNew.control().toString(), controlModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testTemplatePolicyError() throws Throwable {
    new TemplatePolicy.Builder().build();
  }

}