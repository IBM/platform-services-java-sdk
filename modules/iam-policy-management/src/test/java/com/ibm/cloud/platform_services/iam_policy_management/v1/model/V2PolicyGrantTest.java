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

package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyRole;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyGrant;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the V2PolicyGrant model.
 */
public class V2PolicyGrantTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testV2PolicyGrant() throws Throwable {
    PolicyRole policyRoleModel = new PolicyRole.Builder()
      .roleId("testString")
      .build();
    assertEquals(policyRoleModel.roleId(), "testString");

    V2PolicyGrant v2PolicyGrantModel = new V2PolicyGrant.Builder()
      .roles(java.util.Arrays.asList(policyRoleModel))
      .build();
    assertEquals(v2PolicyGrantModel.roles(), java.util.Arrays.asList(policyRoleModel));

    String json = TestUtilities.serialize(v2PolicyGrantModel);

    V2PolicyGrant v2PolicyGrantModelNew = TestUtilities.deserialize(json, V2PolicyGrant.class);
    assertTrue(v2PolicyGrantModelNew instanceof V2PolicyGrant);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testV2PolicyGrantError() throws Throwable {
    new V2PolicyGrant.Builder().build();
  }

}