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

package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.ibm.cloud.platform_services.catalog_management.v1.model.License;
import com.ibm.cloud.platform_services.catalog_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the License model.
 */
public class LicenseTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testLicense() throws Throwable {
    License licenseModel = new License.Builder()
      .id("testString")
      .name("testString")
      .type("testString")
      .url("testString")
      .description("testString")
      .build();
    assertEquals(licenseModel.id(), "testString");
    assertEquals(licenseModel.name(), "testString");
    assertEquals(licenseModel.type(), "testString");
    assertEquals(licenseModel.url(), "testString");
    assertEquals(licenseModel.description(), "testString");

    String json = TestUtilities.serialize(licenseModel);

    License licenseModelNew = TestUtilities.deserialize(json, License.class);
    assertTrue(licenseModelNew instanceof License);
    assertEquals(licenseModelNew.id(), "testString");
    assertEquals(licenseModelNew.name(), "testString");
    assertEquals(licenseModelNew.type(), "testString");
    assertEquals(licenseModelNew.url(), "testString");
    assertEquals(licenseModelNew.description(), "testString");
  }
}