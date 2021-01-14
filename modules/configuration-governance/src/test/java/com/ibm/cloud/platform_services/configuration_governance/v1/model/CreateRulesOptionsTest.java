/*
 * (C) Copyright IBM Corp. 2021.
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

import com.ibm.cloud.platform_services.configuration_governance.v1.model.CreateRuleRequest;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.CreateRulesOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.EnforcementAction;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleRequest;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleRequiredConfigSingleProperty;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleTargetAttribute;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.TargetResource;
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
 * Unit test class for the CreateRulesOptions model.
 */
public class CreateRulesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateRulesOptions() throws Throwable {
    RuleTargetAttribute ruleTargetAttributeModel = new RuleTargetAttribute.Builder()
      .name("resource_id")
      .operator("string_equals")
      .value("f0f8f7994e754ff38f9d370201966561")
      .build();
    assertEquals(ruleTargetAttributeModel.name(), "resource_id");
    assertEquals(ruleTargetAttributeModel.operator(), "string_equals");
    assertEquals(ruleTargetAttributeModel.value(), "f0f8f7994e754ff38f9d370201966561");

    TargetResource targetResourceModel = new TargetResource.Builder()
      .serviceName("iam-groups")
      .resourceKind("zone")
      .additionalTargetAttributes(new java.util.ArrayList<RuleTargetAttribute>(java.util.Arrays.asList(ruleTargetAttributeModel)))
      .build();
    assertEquals(targetResourceModel.serviceName(), "iam-groups");
    assertEquals(targetResourceModel.resourceKind(), "zone");
    assertEquals(targetResourceModel.additionalTargetAttributes(), new java.util.ArrayList<RuleTargetAttribute>(java.util.Arrays.asList(ruleTargetAttributeModel)));

    RuleRequiredConfigSingleProperty ruleRequiredConfigModel = new RuleRequiredConfigSingleProperty.Builder()
      .description("testString")
      .property("public_access_enabled")
      .operator("is_true")
      .value("testString")
      .build();
    assertEquals(ruleRequiredConfigModel.description(), "testString");
    assertEquals(ruleRequiredConfigModel.property(), "public_access_enabled");
    assertEquals(ruleRequiredConfigModel.operator(), "is_true");
    assertEquals(ruleRequiredConfigModel.value(), "testString");

    EnforcementAction enforcementActionModel = new EnforcementAction.Builder()
      .action("disallow")
      .build();
    assertEquals(enforcementActionModel.action(), "disallow");

    RuleRequest ruleRequestModel = new RuleRequest.Builder()
      .accountId("testString")
      .name("testString")
      .description("testString")
      .ruleType("user_defined")
      .target(targetResourceModel)
      .requiredConfig(ruleRequiredConfigModel)
      .enforcementActions(new java.util.ArrayList<EnforcementAction>(java.util.Arrays.asList(enforcementActionModel)))
      .labels(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .build();
    assertEquals(ruleRequestModel.accountId(), "testString");
    assertEquals(ruleRequestModel.name(), "testString");
    assertEquals(ruleRequestModel.description(), "testString");
    assertEquals(ruleRequestModel.ruleType(), "user_defined");
    assertEquals(ruleRequestModel.target(), targetResourceModel);
    assertEquals(ruleRequestModel.requiredConfig(), ruleRequiredConfigModel);
    assertEquals(ruleRequestModel.enforcementActions(), new java.util.ArrayList<EnforcementAction>(java.util.Arrays.asList(enforcementActionModel)));
    assertEquals(ruleRequestModel.labels(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));

    CreateRuleRequest createRuleRequestModel = new CreateRuleRequest.Builder()
      .requestId("3cebc877-58e7-44a5-a292-32114fa73558")
      .rule(ruleRequestModel)
      .build();
    assertEquals(createRuleRequestModel.requestId(), "3cebc877-58e7-44a5-a292-32114fa73558");
    assertEquals(createRuleRequestModel.rule(), ruleRequestModel);

    CreateRulesOptions createRulesOptionsModel = new CreateRulesOptions.Builder()
      .rules(new java.util.ArrayList<CreateRuleRequest>(java.util.Arrays.asList(createRuleRequestModel)))
      .transactionId("testString")
      .build();
    assertEquals(createRulesOptionsModel.rules(), new java.util.ArrayList<CreateRuleRequest>(java.util.Arrays.asList(createRuleRequestModel)));
    assertEquals(createRulesOptionsModel.transactionId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateRulesOptionsError() throws Throwable {
    new CreateRulesOptions.Builder().build();
  }

}