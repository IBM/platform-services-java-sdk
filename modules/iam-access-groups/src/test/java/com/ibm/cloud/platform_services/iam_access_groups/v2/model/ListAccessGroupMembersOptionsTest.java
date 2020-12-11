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

import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListAccessGroupMembersOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ListAccessGroupMembersOptions model.
 */
public class ListAccessGroupMembersOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListAccessGroupMembersOptions() throws Throwable {
    ListAccessGroupMembersOptions listAccessGroupMembersOptionsModel = new ListAccessGroupMembersOptions.Builder()
      .accessGroupId("testString")
      .transactionId("testString")
      .limit(Long.valueOf("26"))
      .offset(Long.valueOf("26"))
      .type("testString")
      .verbose(true)
      .sort("testString")
      .build();
    assertEquals(listAccessGroupMembersOptionsModel.accessGroupId(), "testString");
    assertEquals(listAccessGroupMembersOptionsModel.transactionId(), "testString");
    assertEquals(listAccessGroupMembersOptionsModel.limit(), Long.valueOf("26"));
    assertEquals(listAccessGroupMembersOptionsModel.offset(), Long.valueOf("26"));
    assertEquals(listAccessGroupMembersOptionsModel.type(), "testString");
    assertEquals(listAccessGroupMembersOptionsModel.verbose(), Boolean.valueOf(true));
    assertEquals(listAccessGroupMembersOptionsModel.sort(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListAccessGroupMembersOptionsError() throws Throwable {
    new ListAccessGroupMembersOptions.Builder().build();
  }

}