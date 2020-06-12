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

import com.ibm.cloud.platform_services.catalog_management.v1.model.LicenseObject;
import com.ibm.cloud.platform_services.catalog_management.v1.model.LicenseOfferingReference;
import com.ibm.cloud.platform_services.catalog_management.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the LicenseObject model.
 */
public class LicenseObjectTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testLicenseObject() throws Throwable {
    LicenseObject licenseObjectModel = new LicenseObject();
    assertNull(licenseObjectModel.getName());
    assertNull(licenseObjectModel.getOfferingType());
    assertNull(licenseObjectModel.getSeatsAllowed());
    assertNull(licenseObjectModel.getSeatsUsed());
    assertNull(licenseObjectModel.getOwnerId());
    assertNull(licenseObjectModel.getLicenseOfferingId());
    assertNull(licenseObjectModel.getLicenseId());
    assertNull(licenseObjectModel.getLicenseOwnerId());
    assertNull(licenseObjectModel.getLicenseType());
    assertNull(licenseObjectModel.getLicenseProviderId());
    assertNull(licenseObjectModel.getLicenseProductId());
    assertNull(licenseObjectModel.getLicenseProviderUrl());
    assertNull(licenseObjectModel.getEffectiveFrom());
    assertNull(licenseObjectModel.getEffectiveUntil());
    assertNull(licenseObjectModel.isInternal());
    assertNull(licenseObjectModel.getOfferingList());
  }
}