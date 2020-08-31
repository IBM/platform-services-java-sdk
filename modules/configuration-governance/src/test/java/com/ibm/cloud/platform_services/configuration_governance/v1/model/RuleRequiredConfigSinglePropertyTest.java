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

import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleRequiredConfigSingleProperty;
import com.ibm.cloud.platform_services.configuration_governance.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the RuleRequiredConfigSingleProperty model.
 */
public class RuleRequiredConfigSinglePropertyTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRuleRequiredConfigSingleProperty() throws Throwable {
    RuleRequiredConfigSingleProperty ruleRequiredConfigSinglePropertyModel = new RuleRequiredConfigSingleProperty.Builder()
      .description("testString")
      .property("public_access_enabled")
      .operator("is_true")
      .value("testString")
      .build();
    assertEquals(ruleRequiredConfigSinglePropertyModel.description(), "testString");
    assertEquals(ruleRequiredConfigSinglePropertyModel.property(), "public_access_enabled");
    assertEquals(ruleRequiredConfigSinglePropertyModel.operator(), "is_true");
    assertEquals(ruleRequiredConfigSinglePropertyModel.value(), "testString");

    String json = TestUtilities.serialize(ruleRequiredConfigSinglePropertyModel);

    RuleRequiredConfigSingleProperty ruleRequiredConfigSinglePropertyModelNew = TestUtilities.deserialize(json, RuleRequiredConfigSingleProperty.class);
    assertTrue(ruleRequiredConfigSinglePropertyModelNew instanceof RuleRequiredConfigSingleProperty);
    assertEquals(ruleRequiredConfigSinglePropertyModelNew.description(), "testString");
    assertEquals(ruleRequiredConfigSinglePropertyModelNew.property(), "public_access_enabled");
    assertEquals(ruleRequiredConfigSinglePropertyModelNew.operator(), "is_true");
    assertEquals(ruleRequiredConfigSinglePropertyModelNew.value(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRuleRequiredConfigSinglePropertyError() throws Throwable {
    new RuleRequiredConfigSingleProperty.Builder().build();
  }

}