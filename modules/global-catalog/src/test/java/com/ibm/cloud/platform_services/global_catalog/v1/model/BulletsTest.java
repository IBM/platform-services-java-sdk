/*
 * (C) Copyright IBM Corp. 2021.
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

package com.ibm.cloud.platform_services.global_catalog.v1.model;

import com.ibm.cloud.platform_services.global_catalog.v1.model.Bullets;
import com.ibm.cloud.platform_services.global_catalog.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Bullets model.
 */
public class BulletsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testBullets() throws Throwable {
    Bullets bulletsModel = new Bullets.Builder()
      .title("testString")
      .description("testString")
      .icon("testString")
      .quantity(Long.valueOf("26"))
      .build();
    assertEquals(bulletsModel.title(), "testString");
    assertEquals(bulletsModel.description(), "testString");
    assertEquals(bulletsModel.icon(), "testString");
    assertEquals(bulletsModel.quantity(), Long.valueOf("26"));

    String json = TestUtilities.serialize(bulletsModel);

    Bullets bulletsModelNew = TestUtilities.deserialize(json, Bullets.class);
    assertTrue(bulletsModelNew instanceof Bullets);
    assertEquals(bulletsModelNew.title(), "testString");
    assertEquals(bulletsModelNew.description(), "testString");
    assertEquals(bulletsModelNew.icon(), "testString");
    assertEquals(bulletsModelNew.quantity(), Long.valueOf("26"));
  }
}