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

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.CreateRoleTemplateOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.RoleTemplatePrototypeRole;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateRoleTemplateOptions model.
 */
public class CreateRoleTemplateOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateRoleTemplateOptions() throws Throwable {
    RoleTemplatePrototypeRole roleTemplatePrototypeRoleModel = new RoleTemplatePrototypeRole.Builder()
      .name("testString")
      .displayName("testString")
      .serviceName("testString")
      .description("testString")
      .actions(java.util.Arrays.asList("testString"))
      .build();
    assertEquals(roleTemplatePrototypeRoleModel.name(), "testString");
    assertEquals(roleTemplatePrototypeRoleModel.displayName(), "testString");
    assertEquals(roleTemplatePrototypeRoleModel.serviceName(), "testString");
    assertEquals(roleTemplatePrototypeRoleModel.description(), "testString");
    assertEquals(roleTemplatePrototypeRoleModel.actions(), java.util.Arrays.asList("testString"));

    CreateRoleTemplateOptions createRoleTemplateOptionsModel = new CreateRoleTemplateOptions.Builder()
      .name("testString")
      .accountId("testString")
      .description("testString")
      .committed(true)
      .role(roleTemplatePrototypeRoleModel)
      .acceptLanguage("default")
      .build();
    assertEquals(createRoleTemplateOptionsModel.name(), "testString");
    assertEquals(createRoleTemplateOptionsModel.accountId(), "testString");
    assertEquals(createRoleTemplateOptionsModel.description(), "testString");
    assertEquals(createRoleTemplateOptionsModel.committed(), Boolean.valueOf(true));
    assertEquals(createRoleTemplateOptionsModel.role(), roleTemplatePrototypeRoleModel);
    assertEquals(createRoleTemplateOptionsModel.acceptLanguage(), "default");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateRoleTemplateOptionsError() throws Throwable {
    new CreateRoleTemplateOptions.Builder().build();
  }

}