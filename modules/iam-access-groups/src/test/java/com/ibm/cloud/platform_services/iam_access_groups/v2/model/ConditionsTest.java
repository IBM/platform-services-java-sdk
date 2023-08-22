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

package com.ibm.cloud.platform_services.iam_access_groups.v2.model;

import com.ibm.cloud.platform_services.iam_access_groups.v2.model.Conditions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Conditions model.
 */
public class ConditionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testConditions() throws Throwable {
    Conditions conditionsModel = new Conditions.Builder()
      .claim("testString")
      .operator("testString")
      .value("testString")
      .build();
    assertEquals(conditionsModel.claim(), "testString");
    assertEquals(conditionsModel.operator(), "testString");
    assertEquals(conditionsModel.value(), "testString");

    String json = TestUtilities.serialize(conditionsModel);

    Conditions conditionsModelNew = TestUtilities.deserialize(json, Conditions.class);
    assertTrue(conditionsModelNew instanceof Conditions);
    assertEquals(conditionsModelNew.claim(), "testString");
    assertEquals(conditionsModelNew.operator(), "testString");
    assertEquals(conditionsModelNew.value(), "testString");
  }
}