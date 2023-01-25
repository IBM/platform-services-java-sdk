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

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.CreateRoleOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateRoleOptions model.
 */
public class CreateRoleOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateRoleOptions() throws Throwable {
    CreateRoleOptions createRoleOptionsModel = new CreateRoleOptions.Builder()
      .displayName("testString")
      .actions(java.util.Arrays.asList("testString"))
      .name("Developer")
      .accountId("testString")
      .serviceName("iam-groups")
      .description("testString")
      .acceptLanguage("default")
      .build();
    assertEquals(createRoleOptionsModel.displayName(), "testString");
    assertEquals(createRoleOptionsModel.actions(), java.util.Arrays.asList("testString"));
    assertEquals(createRoleOptionsModel.name(), "Developer");
    assertEquals(createRoleOptionsModel.accountId(), "testString");
    assertEquals(createRoleOptionsModel.serviceName(), "iam-groups");
    assertEquals(createRoleOptionsModel.description(), "testString");
    assertEquals(createRoleOptionsModel.acceptLanguage(), "default");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateRoleOptionsError() throws Throwable {
    new CreateRoleOptions.Builder().build();
  }

}