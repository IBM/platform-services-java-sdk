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

import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleSingleProperty;
import com.ibm.cloud.platform_services.configuration_governance.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the RuleSingleProperty model.
 */
public class RuleSinglePropertyTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRuleSingleProperty() throws Throwable {
    RuleSingleProperty ruleSinglePropertyModel = new RuleSingleProperty.Builder()
      .description("testString")
      .property("public_access_enabled")
      .operator("is_true")
      .value("testString")
      .build();
    assertEquals(ruleSinglePropertyModel.description(), "testString");
    assertEquals(ruleSinglePropertyModel.property(), "public_access_enabled");
    assertEquals(ruleSinglePropertyModel.operator(), "is_true");
    assertEquals(ruleSinglePropertyModel.value(), "testString");

    String json = TestUtilities.serialize(ruleSinglePropertyModel);

    RuleSingleProperty ruleSinglePropertyModelNew = TestUtilities.deserialize(json, RuleSingleProperty.class);
    assertTrue(ruleSinglePropertyModelNew instanceof RuleSingleProperty);
    assertEquals(ruleSinglePropertyModelNew.description(), "testString");
    assertEquals(ruleSinglePropertyModelNew.property(), "public_access_enabled");
    assertEquals(ruleSinglePropertyModelNew.operator(), "is_true");
    assertEquals(ruleSinglePropertyModelNew.value(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRuleSinglePropertyError() throws Throwable {
    new RuleSingleProperty.Builder().build();
  }

}