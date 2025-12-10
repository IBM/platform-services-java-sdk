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

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ListRoleAssignmentsOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ListRoleAssignmentsOptions model.
 */
public class ListRoleAssignmentsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListRoleAssignmentsOptions() throws Throwable {
    ListRoleAssignmentsOptions listRoleAssignmentsOptionsModel = new ListRoleAssignmentsOptions.Builder()
      .accountId("testString")
      .acceptLanguage("default")
      .templateId("testString")
      .templateVersion("testString")
      .limit(Long.valueOf("50"))
      .start("testString")
      .build();
    assertEquals(listRoleAssignmentsOptionsModel.accountId(), "testString");
    assertEquals(listRoleAssignmentsOptionsModel.acceptLanguage(), "default");
    assertEquals(listRoleAssignmentsOptionsModel.templateId(), "testString");
    assertEquals(listRoleAssignmentsOptionsModel.templateVersion(), "testString");
    assertEquals(listRoleAssignmentsOptionsModel.limit(), Long.valueOf("50"));
    assertEquals(listRoleAssignmentsOptionsModel.start(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListRoleAssignmentsOptionsError() throws Throwable {
    new ListRoleAssignmentsOptions.Builder().build();
  }

}