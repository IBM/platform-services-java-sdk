/*
 * (C) Copyright IBM Corp. 2021.
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

import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddGroupMembersRequestMembersItem;
import com.ibm.cloud.platform_services.iam_access_groups.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the AddGroupMembersRequestMembersItem model.
 */
public class AddGroupMembersRequestMembersItemTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAddGroupMembersRequestMembersItem() throws Throwable {
    AddGroupMembersRequestMembersItem addGroupMembersRequestMembersItemModel = new AddGroupMembersRequestMembersItem.Builder()
      .iamId("testString")
      .type("testString")
      .build();
    assertEquals(addGroupMembersRequestMembersItemModel.iamId(), "testString");
    assertEquals(addGroupMembersRequestMembersItemModel.type(), "testString");

    String json = TestUtilities.serialize(addGroupMembersRequestMembersItemModel);

    AddGroupMembersRequestMembersItem addGroupMembersRequestMembersItemModelNew = TestUtilities.deserialize(json, AddGroupMembersRequestMembersItem.class);
    assertTrue(addGroupMembersRequestMembersItemModelNew instanceof AddGroupMembersRequestMembersItem);
    assertEquals(addGroupMembersRequestMembersItemModelNew.iamId(), "testString");
    assertEquals(addGroupMembersRequestMembersItemModelNew.type(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddGroupMembersRequestMembersItemError() throws Throwable {
    new AddGroupMembersRequestMembersItem.Builder().build();
  }

}