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

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ReplaceRoleTemplateOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.TemplateRole;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ReplaceRoleTemplateOptions model.
 */
public class ReplaceRoleTemplateOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReplaceRoleTemplateOptions() throws Throwable {
    TemplateRole templateRoleModel = new TemplateRole.Builder()
      .name("testString")
      .displayName("testString")
      .serviceName("testString")
      .description("testString")
      .actions(java.util.Arrays.asList("testString"))
      .build();
    assertEquals(templateRoleModel.name(), "testString");
    assertEquals(templateRoleModel.displayName(), "testString");
    assertEquals(templateRoleModel.serviceName(), "testString");
    assertEquals(templateRoleModel.description(), "testString");
    assertEquals(templateRoleModel.actions(), java.util.Arrays.asList("testString"));

    ReplaceRoleTemplateOptions replaceRoleTemplateOptionsModel = new ReplaceRoleTemplateOptions.Builder()
      .roleTemplateId("testString")
      .version("testString")
      .ifMatch("testString")
      .role(templateRoleModel)
      .name("testString")
      .description("testString")
      .committed(true)
      .build();
    assertEquals(replaceRoleTemplateOptionsModel.roleTemplateId(), "testString");
    assertEquals(replaceRoleTemplateOptionsModel.version(), "testString");
    assertEquals(replaceRoleTemplateOptionsModel.ifMatch(), "testString");
    assertEquals(replaceRoleTemplateOptionsModel.role(), templateRoleModel);
    assertEquals(replaceRoleTemplateOptionsModel.name(), "testString");
    assertEquals(replaceRoleTemplateOptionsModel.description(), "testString");
    assertEquals(replaceRoleTemplateOptionsModel.committed(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceRoleTemplateOptionsError() throws Throwable {
    new ReplaceRoleTemplateOptions.Builder().build();
  }

}