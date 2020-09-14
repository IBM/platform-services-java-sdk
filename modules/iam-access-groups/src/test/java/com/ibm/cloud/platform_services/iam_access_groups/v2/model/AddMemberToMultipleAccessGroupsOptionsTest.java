/*
 * (C) Copyright IBM Corp. 2020.
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

import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddMemberToMultipleAccessGroupsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the AddMemberToMultipleAccessGroupsOptions model.
 */
public class AddMemberToMultipleAccessGroupsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAddMemberToMultipleAccessGroupsOptions() throws Throwable {
    AddMemberToMultipleAccessGroupsOptions addMemberToMultipleAccessGroupsOptionsModel = new AddMemberToMultipleAccessGroupsOptions.Builder()
      .accountId("testString")
      .iamId("testString")
      .type("testString")
      .groups(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .transactionId("testString")
      .build();
    assertEquals(addMemberToMultipleAccessGroupsOptionsModel.accountId(), "testString");
    assertEquals(addMemberToMultipleAccessGroupsOptionsModel.iamId(), "testString");
    assertEquals(addMemberToMultipleAccessGroupsOptionsModel.type(), "testString");
    assertEquals(addMemberToMultipleAccessGroupsOptionsModel.groups(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(addMemberToMultipleAccessGroupsOptionsModel.transactionId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddMemberToMultipleAccessGroupsOptionsError() throws Throwable {
    new AddMemberToMultipleAccessGroupsOptions.Builder().build();
  }

}