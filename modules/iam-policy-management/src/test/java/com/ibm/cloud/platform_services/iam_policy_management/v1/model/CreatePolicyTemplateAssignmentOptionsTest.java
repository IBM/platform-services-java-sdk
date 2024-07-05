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

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.AssignmentTargetDetails;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.AssignmentTemplateDetails;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.CreatePolicyTemplateAssignmentOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreatePolicyTemplateAssignmentOptions model.
 */
public class CreatePolicyTemplateAssignmentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreatePolicyTemplateAssignmentOptions() throws Throwable {
    AssignmentTargetDetails assignmentTargetDetailsModel = new AssignmentTargetDetails.Builder()
      .type("Account")
      .id("testString")
      .build();
    assertEquals(assignmentTargetDetailsModel.type(), "Account");
    assertEquals(assignmentTargetDetailsModel.id(), "testString");

    AssignmentTemplateDetails assignmentTemplateDetailsModel = new AssignmentTemplateDetails.Builder()
      .id("testString")
      .version("testString")
      .build();
    assertEquals(assignmentTemplateDetailsModel.id(), "testString");
    assertEquals(assignmentTemplateDetailsModel.version(), "testString");

    CreatePolicyTemplateAssignmentOptions createPolicyTemplateAssignmentOptionsModel = new CreatePolicyTemplateAssignmentOptions.Builder()
      .version("1.0")
      .target(assignmentTargetDetailsModel)
      .templates(java.util.Arrays.asList(assignmentTemplateDetailsModel))
      .acceptLanguage("default")
      .build();
    assertEquals(createPolicyTemplateAssignmentOptionsModel.version(), "1.0");
    assertEquals(createPolicyTemplateAssignmentOptionsModel.target(), assignmentTargetDetailsModel);
    assertEquals(createPolicyTemplateAssignmentOptionsModel.templates(), java.util.Arrays.asList(assignmentTemplateDetailsModel));
    assertEquals(createPolicyTemplateAssignmentOptionsModel.acceptLanguage(), "default");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreatePolicyTemplateAssignmentOptionsError() throws Throwable {
    new CreatePolicyTemplateAssignmentOptions.Builder().build();
  }

}