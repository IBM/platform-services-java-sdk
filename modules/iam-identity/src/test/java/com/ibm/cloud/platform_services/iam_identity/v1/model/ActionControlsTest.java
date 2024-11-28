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

package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.ibm.cloud.platform_services.iam_identity.v1.model.ActionControls;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ActionControlsIdentities;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ActionControlsPolicies;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ActionControlsRules;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ActionControls model.
 */
public class ActionControlsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testActionControls() throws Throwable {
    ActionControlsIdentities actionControlsIdentitiesModel = new ActionControlsIdentities.Builder()
      .add(true)
      .remove(true)
      .build();
    assertEquals(actionControlsIdentitiesModel.add(), Boolean.valueOf(true));
    assertEquals(actionControlsIdentitiesModel.remove(), Boolean.valueOf(true));

    ActionControlsRules actionControlsRulesModel = new ActionControlsRules.Builder()
      .add(true)
      .remove(true)
      .build();
    assertEquals(actionControlsRulesModel.add(), Boolean.valueOf(true));
    assertEquals(actionControlsRulesModel.remove(), Boolean.valueOf(true));

    ActionControlsPolicies actionControlsPoliciesModel = new ActionControlsPolicies.Builder()
      .add(true)
      .remove(true)
      .build();
    assertEquals(actionControlsPoliciesModel.add(), Boolean.valueOf(true));
    assertEquals(actionControlsPoliciesModel.remove(), Boolean.valueOf(true));

    ActionControls actionControlsModel = new ActionControls.Builder()
      .identities(actionControlsIdentitiesModel)
      .rules(actionControlsRulesModel)
      .policies(actionControlsPoliciesModel)
      .build();
    assertEquals(actionControlsModel.identities(), actionControlsIdentitiesModel);
    assertEquals(actionControlsModel.rules(), actionControlsRulesModel);
    assertEquals(actionControlsModel.policies(), actionControlsPoliciesModel);

    String json = TestUtilities.serialize(actionControlsModel);

    ActionControls actionControlsModelNew = TestUtilities.deserialize(json, ActionControls.class);
    assertTrue(actionControlsModelNew instanceof ActionControls);
    assertEquals(actionControlsModelNew.identities().toString(), actionControlsIdentitiesModel.toString());
    assertEquals(actionControlsModelNew.rules().toString(), actionControlsRulesModel.toString());
    assertEquals(actionControlsModelNew.policies().toString(), actionControlsPoliciesModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testActionControlsError() throws Throwable {
    new ActionControls.Builder().build();
  }

}