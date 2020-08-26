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

package com.ibm.cloud.platform_services.configuration_governance.v1.model;

import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleTargetAttribute;
import com.ibm.cloud.platform_services.configuration_governance.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the RuleTargetAttribute model.
 */
public class RuleTargetAttributeTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRuleTargetAttribute() throws Throwable {
    RuleTargetAttribute ruleTargetAttributeModel = new RuleTargetAttribute.Builder()
      .name("testString")
      .operator("string_equals")
      .value("testString")
      .build();
    assertEquals(ruleTargetAttributeModel.name(), "testString");
    assertEquals(ruleTargetAttributeModel.operator(), "string_equals");
    assertEquals(ruleTargetAttributeModel.value(), "testString");

    String json = TestUtilities.serialize(ruleTargetAttributeModel);

    RuleTargetAttribute ruleTargetAttributeModelNew = TestUtilities.deserialize(json, RuleTargetAttribute.class);
    assertTrue(ruleTargetAttributeModelNew instanceof RuleTargetAttribute);
    assertEquals(ruleTargetAttributeModelNew.name(), "testString");
    assertEquals(ruleTargetAttributeModelNew.operator(), "string_equals");
    assertEquals(ruleTargetAttributeModelNew.value(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRuleTargetAttributeError() throws Throwable {
    new RuleTargetAttribute.Builder().build();
  }

}