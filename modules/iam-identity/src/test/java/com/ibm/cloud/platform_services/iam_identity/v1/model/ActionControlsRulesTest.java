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

package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.ibm.cloud.platform_services.iam_identity.v1.model.ActionControlsRules;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ActionControlsRules model.
 */
public class ActionControlsRulesTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testActionControlsRules() throws Throwable {
    ActionControlsRules actionControlsRulesModel = new ActionControlsRules.Builder()
      .add(true)
      .remove(true)
      .build();
    assertEquals(actionControlsRulesModel.add(), Boolean.valueOf(true));
    assertEquals(actionControlsRulesModel.remove(), Boolean.valueOf(true));

    String json = TestUtilities.serialize(actionControlsRulesModel);

    ActionControlsRules actionControlsRulesModelNew = TestUtilities.deserialize(json, ActionControlsRules.class);
    assertTrue(actionControlsRulesModelNew instanceof ActionControlsRules);
    assertEquals(actionControlsRulesModelNew.add(), Boolean.valueOf(true));
    assertEquals(actionControlsRulesModelNew.remove(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testActionControlsRulesError() throws Throwable {
    new ActionControlsRules.Builder().build();
  }

}