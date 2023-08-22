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

import com.ibm.cloud.platform_services.iam_access_groups.v2.model.Members;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.MembersActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Members model.
 */
public class MembersTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testMembers() throws Throwable {
    MembersActionControls membersActionControlsModel = new MembersActionControls.Builder()
      .add(true)
      .remove(true)
      .build();
    assertEquals(membersActionControlsModel.add(), Boolean.valueOf(true));
    assertEquals(membersActionControlsModel.remove(), Boolean.valueOf(true));

    Members membersModel = new Members.Builder()
      .users(java.util.Arrays.asList("testString"))
      .services(java.util.Arrays.asList("testString"))
      .actionControls(membersActionControlsModel)
      .build();
    assertEquals(membersModel.users(), java.util.Arrays.asList("testString"));
    assertEquals(membersModel.services(), java.util.Arrays.asList("testString"));
    assertEquals(membersModel.actionControls(), membersActionControlsModel);

    String json = TestUtilities.serialize(membersModel);

    Members membersModelNew = TestUtilities.deserialize(json, Members.class);
    assertTrue(membersModelNew instanceof Members);
    assertEquals(membersModelNew.actionControls().toString(), membersActionControlsModel.toString());
  }
}