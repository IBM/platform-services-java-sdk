/*
 * (C) Copyright IBM Corp. 2025.
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
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.CreateRoleTemplateAssignmentOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.RoleAssignmentTemplate;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateRoleTemplateAssignmentOptions model.
 */
public class CreateRoleTemplateAssignmentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateRoleTemplateAssignmentOptions() throws Throwable {
    AssignmentTargetDetails assignmentTargetDetailsModel = new AssignmentTargetDetails.Builder()
      .type("Account")
      .id("testString")
      .build();
    assertEquals(assignmentTargetDetailsModel.type(), "Account");
    assertEquals(assignmentTargetDetailsModel.id(), "testString");

    RoleAssignmentTemplate roleAssignmentTemplateModel = new RoleAssignmentTemplate.Builder()
      .id("testString")
      .version("testString")
      .build();
    assertEquals(roleAssignmentTemplateModel.id(), "testString");
    assertEquals(roleAssignmentTemplateModel.version(), "testString");

    CreateRoleTemplateAssignmentOptions createRoleTemplateAssignmentOptionsModel = new CreateRoleTemplateAssignmentOptions.Builder()
      .target(assignmentTargetDetailsModel)
      .templates(java.util.Arrays.asList(roleAssignmentTemplateModel))
      .acceptLanguage("default")
      .build();
    assertEquals(createRoleTemplateAssignmentOptionsModel.target(), assignmentTargetDetailsModel);
    assertEquals(createRoleTemplateAssignmentOptionsModel.templates(), java.util.Arrays.asList(roleAssignmentTemplateModel));
    assertEquals(createRoleTemplateAssignmentOptionsModel.acceptLanguage(), "default");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateRoleTemplateAssignmentOptionsError() throws Throwable {
    new CreateRoleTemplateAssignmentOptions.Builder().build();
  }

}