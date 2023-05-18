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

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyAssignmentOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PolicyAssignmentOptions model.
 */
public class PolicyAssignmentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPolicyAssignmentOptions() throws Throwable {
    PolicyAssignmentOptions policyAssignmentOptionsModel = new PolicyAssignmentOptions.Builder()
      .subjectType("iam_id")
      .subjectId("testString")
      .rootRequesterId("testString")
      .rootTemplateId("testString")
      .rootTemplateVersion("testString")
      .build();
    assertEquals(policyAssignmentOptionsModel.subjectType(), "iam_id");
    assertEquals(policyAssignmentOptionsModel.subjectId(), "testString");
    assertEquals(policyAssignmentOptionsModel.rootRequesterId(), "testString");
    assertEquals(policyAssignmentOptionsModel.rootTemplateId(), "testString");
    assertEquals(policyAssignmentOptionsModel.rootTemplateVersion(), "testString");

    String json = TestUtilities.serialize(policyAssignmentOptionsModel);

    PolicyAssignmentOptions policyAssignmentOptionsModelNew = TestUtilities.deserialize(json, PolicyAssignmentOptions.class);
    assertTrue(policyAssignmentOptionsModelNew instanceof PolicyAssignmentOptions);
    assertEquals(policyAssignmentOptionsModelNew.subjectType(), "iam_id");
    assertEquals(policyAssignmentOptionsModelNew.subjectId(), "testString");
    assertEquals(policyAssignmentOptionsModelNew.rootRequesterId(), "testString");
    assertEquals(policyAssignmentOptionsModelNew.rootTemplateId(), "testString");
    assertEquals(policyAssignmentOptionsModelNew.rootTemplateVersion(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPolicyAssignmentOptionsError() throws Throwable {
    new PolicyAssignmentOptions.Builder().build();
  }

}