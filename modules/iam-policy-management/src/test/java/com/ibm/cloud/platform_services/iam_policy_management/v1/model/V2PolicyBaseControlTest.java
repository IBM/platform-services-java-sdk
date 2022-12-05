/*
 * (C) Copyright IBM Corp. 2022.
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
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyBaseControl;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyBaseControlGrant;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the V2PolicyBaseControl model.
 */
public class V2PolicyBaseControlTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testV2PolicyBaseControl() throws Throwable {
    PolicyRole policyRoleModel = new PolicyRole.Builder()
      .roleId("testString")
      .build();
    assertEquals(policyRoleModel.roleId(), "testString");

    V2PolicyBaseControlGrant v2PolicyBaseControlGrantModel = new V2PolicyBaseControlGrant.Builder()
      .roles(java.util.Arrays.asList(policyRoleModel))
      .build();
    assertEquals(v2PolicyBaseControlGrantModel.roles(), java.util.Arrays.asList(policyRoleModel));

    V2PolicyBaseControl v2PolicyBaseControlModel = new V2PolicyBaseControl.Builder()
      .grant(v2PolicyBaseControlGrantModel)
      .build();
    assertEquals(v2PolicyBaseControlModel.grant(), v2PolicyBaseControlGrantModel);

    String json = TestUtilities.serialize(v2PolicyBaseControlModel);

    V2PolicyBaseControl v2PolicyBaseControlModelNew = TestUtilities.deserialize(json, V2PolicyBaseControl.class);
    assertTrue(v2PolicyBaseControlModelNew instanceof V2PolicyBaseControl);
    assertEquals(v2PolicyBaseControlModelNew.grant().toString(), v2PolicyBaseControlGrantModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testV2PolicyBaseControlError() throws Throwable {
    new V2PolicyBaseControl.Builder().build();
  }

}