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

import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListAccessGroupsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ListAccessGroupsOptions model.
 */
public class ListAccessGroupsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListAccessGroupsOptions() throws Throwable {
    ListAccessGroupsOptions listAccessGroupsOptionsModel = new ListAccessGroupsOptions.Builder()
      .accountId("testString")
      .transactionId("testString")
      .iamId("testString")
      .search("testString")
      .membershipType("static")
      .limit(Long.valueOf("50"))
      .offset(Long.valueOf("0"))
      .sort("name")
      .showFederated(false)
      .hidePublicAccess(false)
      .build();
    assertEquals(listAccessGroupsOptionsModel.accountId(), "testString");
    assertEquals(listAccessGroupsOptionsModel.transactionId(), "testString");
    assertEquals(listAccessGroupsOptionsModel.iamId(), "testString");
    assertEquals(listAccessGroupsOptionsModel.search(), "testString");
    assertEquals(listAccessGroupsOptionsModel.membershipType(), "static");
    assertEquals(listAccessGroupsOptionsModel.limit(), Long.valueOf("50"));
    assertEquals(listAccessGroupsOptionsModel.offset(), Long.valueOf("0"));
    assertEquals(listAccessGroupsOptionsModel.sort(), "name");
    assertEquals(listAccessGroupsOptionsModel.showFederated(), Boolean.valueOf(false));
    assertEquals(listAccessGroupsOptionsModel.hidePublicAccess(), Boolean.valueOf(false));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListAccessGroupsOptionsError() throws Throwable {
    new ListAccessGroupsOptions.Builder().build();
  }

}