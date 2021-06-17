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

package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.ibm.cloud.platform_services.catalog_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Unit test class for the CreateLicenseEntitlementOptions model.
 */
public class CreateLicenseEntitlementOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateLicenseEntitlementOptions() throws Throwable {
    CreateLicenseEntitlementOptions createLicenseEntitlementOptionsModel = new CreateLicenseEntitlementOptions.Builder()
      .name("testString")
      .effectiveFrom("testString")
      .effectiveUntil("testString")
      .versionId("testString")
      .licenseId("testString")
      .licenseOwnerId("testString")
      .licenseProviderId("testString")
      .licenseProductId("testString")
      .accountId("testString")
      .build();
    assertEquals(createLicenseEntitlementOptionsModel.name(), "testString");
    assertEquals(createLicenseEntitlementOptionsModel.effectiveFrom(), "testString");
    assertEquals(createLicenseEntitlementOptionsModel.effectiveUntil(), "testString");
    assertEquals(createLicenseEntitlementOptionsModel.versionId(), "testString");
    assertEquals(createLicenseEntitlementOptionsModel.licenseId(), "testString");
    assertEquals(createLicenseEntitlementOptionsModel.licenseOwnerId(), "testString");
    assertEquals(createLicenseEntitlementOptionsModel.licenseProviderId(), "testString");
    assertEquals(createLicenseEntitlementOptionsModel.licenseProductId(), "testString");
    assertEquals(createLicenseEntitlementOptionsModel.accountId(), "testString");
  }
}