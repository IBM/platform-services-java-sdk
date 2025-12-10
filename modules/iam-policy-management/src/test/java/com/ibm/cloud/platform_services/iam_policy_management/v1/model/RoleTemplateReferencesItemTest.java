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

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.RoleTemplateReferencesItem;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the RoleTemplateReferencesItem model.
 */
public class RoleTemplateReferencesItemTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRoleTemplateReferencesItem() throws Throwable {
    RoleTemplateReferencesItem roleTemplateReferencesItemModel = new RoleTemplateReferencesItem.Builder()
      .id("testString")
      .version("testString")
      .build();
    assertEquals(roleTemplateReferencesItemModel.id(), "testString");
    assertEquals(roleTemplateReferencesItemModel.version(), "testString");

    String json = TestUtilities.serialize(roleTemplateReferencesItemModel);

    RoleTemplateReferencesItem roleTemplateReferencesItemModelNew = TestUtilities.deserialize(json, RoleTemplateReferencesItem.class);
    assertTrue(roleTemplateReferencesItemModelNew instanceof RoleTemplateReferencesItem);
    assertEquals(roleTemplateReferencesItemModelNew.id(), "testString");
    assertEquals(roleTemplateReferencesItemModelNew.version(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRoleTemplateReferencesItemError() throws Throwable {
    new RoleTemplateReferencesItem.Builder().build();
  }

}
