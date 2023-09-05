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

package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.ibm.cloud.platform_services.iam_identity.v1.model.ListTrustedProfileAssignmentsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ListTrustedProfileAssignmentsOptions model.
 */
public class ListTrustedProfileAssignmentsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListTrustedProfileAssignmentsOptions() throws Throwable {
    ListTrustedProfileAssignmentsOptions listTrustedProfileAssignmentsOptionsModel = new ListTrustedProfileAssignmentsOptions.Builder()
      .accountId("testString")
      .templateId("testString")
      .templateVersion("testString")
      .target("testString")
      .targetType("Account")
      .limit(Long.valueOf("20"))
      .pagetoken("testString")
      .sort("created_at")
      .order("asc")
      .includeHistory(false)
      .build();
    assertEquals(listTrustedProfileAssignmentsOptionsModel.accountId(), "testString");
    assertEquals(listTrustedProfileAssignmentsOptionsModel.templateId(), "testString");
    assertEquals(listTrustedProfileAssignmentsOptionsModel.templateVersion(), "testString");
    assertEquals(listTrustedProfileAssignmentsOptionsModel.target(), "testString");
    assertEquals(listTrustedProfileAssignmentsOptionsModel.targetType(), "Account");
    assertEquals(listTrustedProfileAssignmentsOptionsModel.limit(), Long.valueOf("20"));
    assertEquals(listTrustedProfileAssignmentsOptionsModel.pagetoken(), "testString");
    assertEquals(listTrustedProfileAssignmentsOptionsModel.sort(), "created_at");
    assertEquals(listTrustedProfileAssignmentsOptionsModel.order(), "asc");
    assertEquals(listTrustedProfileAssignmentsOptionsModel.includeHistory(), Boolean.valueOf(false));
  }
}