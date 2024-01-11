/*
 * (C) Copyright IBM Corp. 2024.
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

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.Control;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.Grant;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.Roles;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Control model.
 */
public class ControlTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testControl() throws Throwable {
    Roles rolesModel = new Roles.Builder()
      .roleId("testString")
      .build();
    assertEquals(rolesModel.roleId(), "testString");

    Grant grantModel = new Grant.Builder()
      .roles(java.util.Arrays.asList(rolesModel))
      .build();
    assertEquals(grantModel.roles(), java.util.Arrays.asList(rolesModel));

    Control controlModel = new Control.Builder()
      .grant(grantModel)
      .build();
    assertEquals(controlModel.grant(), grantModel);

    String json = TestUtilities.serialize(controlModel);

    Control controlModelNew = TestUtilities.deserialize(json, Control.class);
    assertTrue(controlModelNew instanceof Control);
    assertEquals(controlModelNew.grant().toString(), grantModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testControlError() throws Throwable {
    new Control.Builder().build();
  }

}