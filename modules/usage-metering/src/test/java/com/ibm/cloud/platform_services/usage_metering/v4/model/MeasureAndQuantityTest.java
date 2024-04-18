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

package com.ibm.cloud.platform_services.usage_metering.v4.model;

import com.ibm.cloud.platform_services.usage_metering.v4.model.MeasureAndQuantity;
import com.ibm.cloud.platform_services.usage_metering.v4.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the MeasureAndQuantity model.
 */
public class MeasureAndQuantityTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testMeasureAndQuantity() throws Throwable {
    MeasureAndQuantity measureAndQuantityModel = new MeasureAndQuantity.Builder()
      .measure("STORAGE")
      .quantity("1")
      .build();
    assertEquals(measureAndQuantityModel.measure(), "STORAGE");
    assertEquals(measureAndQuantityModel.quantity(), "1");

    String json = TestUtilities.serialize(measureAndQuantityModel);

    MeasureAndQuantity measureAndQuantityModelNew = TestUtilities.deserialize(json, MeasureAndQuantity.class);
    assertTrue(measureAndQuantityModelNew instanceof MeasureAndQuantity);
    assertEquals(measureAndQuantityModelNew.measure(), "STORAGE");
    assertEquals(measureAndQuantityModelNew.quantity(), "1");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testMeasureAndQuantityError() throws Throwable {
    new MeasureAndQuantity.Builder().build();
  }

}