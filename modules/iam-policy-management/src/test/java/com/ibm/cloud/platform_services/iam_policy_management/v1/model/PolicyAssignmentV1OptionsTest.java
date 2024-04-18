/*
 * (C) Copyright IBM Corp. 2024.
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

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyAssignmentV1Options;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyAssignmentV1OptionsRoot;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyAssignmentV1OptionsRootTemplate;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PolicyAssignmentV1Options model.
 */
public class PolicyAssignmentV1OptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPolicyAssignmentV1Options() throws Throwable {
    PolicyAssignmentV1OptionsRootTemplate policyAssignmentV1OptionsRootTemplateModel = new PolicyAssignmentV1OptionsRootTemplate.Builder()
      .id("testString")
      .version("testString")
      .build();
    assertEquals(policyAssignmentV1OptionsRootTemplateModel.id(), "testString");
    assertEquals(policyAssignmentV1OptionsRootTemplateModel.version(), "testString");

    PolicyAssignmentV1OptionsRoot policyAssignmentV1OptionsRootModel = new PolicyAssignmentV1OptionsRoot.Builder()
      .requesterId("testString")
      .assignmentId("testString")
      .template(policyAssignmentV1OptionsRootTemplateModel)
      .build();
    assertEquals(policyAssignmentV1OptionsRootModel.requesterId(), "testString");
    assertEquals(policyAssignmentV1OptionsRootModel.assignmentId(), "testString");
    assertEquals(policyAssignmentV1OptionsRootModel.template(), policyAssignmentV1OptionsRootTemplateModel);

    PolicyAssignmentV1Options policyAssignmentV1OptionsModel = new PolicyAssignmentV1Options.Builder()
      .root(policyAssignmentV1OptionsRootModel)
      .build();
    assertEquals(policyAssignmentV1OptionsModel.root(), policyAssignmentV1OptionsRootModel);

    String json = TestUtilities.serialize(policyAssignmentV1OptionsModel);

    PolicyAssignmentV1Options policyAssignmentV1OptionsModelNew = TestUtilities.deserialize(json, PolicyAssignmentV1Options.class);
    assertTrue(policyAssignmentV1OptionsModelNew instanceof PolicyAssignmentV1Options);
    assertEquals(policyAssignmentV1OptionsModelNew.root().toString(), policyAssignmentV1OptionsRootModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPolicyAssignmentV1OptionsError() throws Throwable {
    new PolicyAssignmentV1Options.Builder().build();
  }

}