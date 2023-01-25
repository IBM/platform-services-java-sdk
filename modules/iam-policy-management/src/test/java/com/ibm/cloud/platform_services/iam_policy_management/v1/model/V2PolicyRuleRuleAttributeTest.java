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

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyRuleRuleAttribute;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the V2PolicyRuleRuleAttribute model.
 */
public class V2PolicyRuleRuleAttributeTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testV2PolicyRuleRuleAttribute() throws Throwable {
    V2PolicyRuleRuleAttribute v2PolicyRuleRuleAttributeModel = new V2PolicyRuleRuleAttribute.Builder()
      .key("testString")
      .operator("timeLessThan")
      .value("testString")
      .build();
    assertEquals(v2PolicyRuleRuleAttributeModel.key(), "testString");
    assertEquals(v2PolicyRuleRuleAttributeModel.operator(), "timeLessThan");
    assertEquals(v2PolicyRuleRuleAttributeModel.value(), "testString");

    String json = TestUtilities.serialize(v2PolicyRuleRuleAttributeModel);

    V2PolicyRuleRuleAttribute v2PolicyRuleRuleAttributeModelNew = TestUtilities.deserialize(json, V2PolicyRuleRuleAttribute.class);
    assertTrue(v2PolicyRuleRuleAttributeModelNew instanceof V2PolicyRuleRuleAttribute);
    assertEquals(v2PolicyRuleRuleAttributeModelNew.key(), "testString");
    assertEquals(v2PolicyRuleRuleAttributeModelNew.operator(), "timeLessThan");
    assertEquals(v2PolicyRuleRuleAttributeModelNew.value(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testV2PolicyRuleRuleAttributeError() throws Throwable {
    new V2PolicyRuleRuleAttribute.Builder().build();
  }

}