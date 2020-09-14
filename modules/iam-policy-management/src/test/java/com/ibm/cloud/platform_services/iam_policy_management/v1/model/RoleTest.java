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

package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.Role;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Role model.
 */
public class RoleTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRole() throws Throwable {
    Role roleModel = new Role.Builder()
      .displayName("testString")
      .description("testString")
      .actions(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .build();
    assertEquals(roleModel.displayName(), "testString");
    assertEquals(roleModel.description(), "testString");
    assertEquals(roleModel.actions(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));

    String json = TestUtilities.serialize(roleModel);

    Role roleModelNew = TestUtilities.deserialize(json, Role.class);
    assertTrue(roleModelNew instanceof Role);
    assertEquals(roleModelNew.displayName(), "testString");
    assertEquals(roleModelNew.description(), "testString");
  }
}