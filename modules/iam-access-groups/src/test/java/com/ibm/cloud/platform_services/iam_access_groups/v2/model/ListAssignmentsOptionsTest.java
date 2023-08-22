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

package com.ibm.cloud.platform_services.iam_access_groups.v2.model;

import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListAssignmentsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ListAssignmentsOptions model.
 */
public class ListAssignmentsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListAssignmentsOptions() throws Throwable {
    ListAssignmentsOptions listAssignmentsOptionsModel = new ListAssignmentsOptions.Builder()
      .accountId("accountID-123")
      .templateId("testString")
      .templateVersion("testString")
      .target("testString")
      .status("accepted")
      .transactionId("testString")
      .limit(Long.valueOf("50"))
      .offset(Long.valueOf("0"))
      .build();
    assertEquals(listAssignmentsOptionsModel.accountId(), "accountID-123");
    assertEquals(listAssignmentsOptionsModel.templateId(), "testString");
    assertEquals(listAssignmentsOptionsModel.templateVersion(), "testString");
    assertEquals(listAssignmentsOptionsModel.target(), "testString");
    assertEquals(listAssignmentsOptionsModel.status(), "accepted");
    assertEquals(listAssignmentsOptionsModel.transactionId(), "testString");
    assertEquals(listAssignmentsOptionsModel.limit(), Long.valueOf("50"));
    assertEquals(listAssignmentsOptionsModel.offset(), Long.valueOf("0"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListAssignmentsOptionsError() throws Throwable {
    new ListAssignmentsOptions.Builder().build();
  }

}