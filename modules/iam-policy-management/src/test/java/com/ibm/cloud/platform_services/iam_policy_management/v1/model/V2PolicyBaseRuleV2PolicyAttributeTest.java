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

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyBaseRuleV2PolicyAttribute;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the V2PolicyBaseRuleV2PolicyAttribute model.
 */
public class V2PolicyBaseRuleV2PolicyAttributeTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testV2PolicyBaseRuleV2PolicyAttribute() throws Throwable {
    V2PolicyBaseRuleV2PolicyAttribute v2PolicyBaseRuleV2PolicyAttributeModel = new V2PolicyBaseRuleV2PolicyAttribute.Builder()
      .key("testString")
      .operator("testString")
      .value("testString")
      .build();
    assertEquals(v2PolicyBaseRuleV2PolicyAttributeModel.key(), "testString");
    assertEquals(v2PolicyBaseRuleV2PolicyAttributeModel.operator(), "testString");
    assertEquals(v2PolicyBaseRuleV2PolicyAttributeModel.value(), "testString");

    String json = TestUtilities.serialize(v2PolicyBaseRuleV2PolicyAttributeModel);

    V2PolicyBaseRuleV2PolicyAttribute v2PolicyBaseRuleV2PolicyAttributeModelNew = TestUtilities.deserialize(json, V2PolicyBaseRuleV2PolicyAttribute.class);
    assertTrue(v2PolicyBaseRuleV2PolicyAttributeModelNew instanceof V2PolicyBaseRuleV2PolicyAttribute);
    assertEquals(v2PolicyBaseRuleV2PolicyAttributeModelNew.key(), "testString");
    assertEquals(v2PolicyBaseRuleV2PolicyAttributeModelNew.operator(), "testString");
    assertEquals(v2PolicyBaseRuleV2PolicyAttributeModelNew.value(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testV2PolicyBaseRuleV2PolicyAttributeError() throws Throwable {
    new V2PolicyBaseRuleV2PolicyAttribute.Builder().build();
  }

}