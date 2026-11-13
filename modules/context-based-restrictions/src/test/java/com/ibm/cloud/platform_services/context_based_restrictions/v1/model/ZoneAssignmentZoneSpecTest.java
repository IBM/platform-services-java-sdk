/*
 * (C) Copyright IBM Corp. 2026.
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

package com.ibm.cloud.platform_services.context_based_restrictions.v1.model;

import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ZoneAssignmentZoneSpec;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ZoneAssignmentZoneSpec model.
 */
public class ZoneAssignmentZoneSpecTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testZoneAssignmentZoneSpec() throws Throwable {
    ZoneAssignmentZoneSpec zoneAssignmentZoneSpecModel = new ZoneAssignmentZoneSpec.Builder()
      .id("testString")
      .build();
    assertEquals(zoneAssignmentZoneSpecModel.id(), "testString");

    String json = TestUtilities.serialize(zoneAssignmentZoneSpecModel);

    ZoneAssignmentZoneSpec zoneAssignmentZoneSpecModelNew = TestUtilities.deserialize(json, ZoneAssignmentZoneSpec.class);
    assertTrue(zoneAssignmentZoneSpecModelNew instanceof ZoneAssignmentZoneSpec);
    assertEquals(zoneAssignmentZoneSpecModelNew.id(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testZoneAssignmentZoneSpecError() throws Throwable {
    new ZoneAssignmentZoneSpec.Builder().build();
  }

}