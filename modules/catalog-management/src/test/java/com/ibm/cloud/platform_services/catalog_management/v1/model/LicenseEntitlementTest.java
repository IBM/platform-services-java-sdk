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

import com.ibm.cloud.platform_services.catalog_management.v1.model.LicenseEntitlement;
import com.ibm.cloud.platform_services.catalog_management.v1.model.LicenseEntitlementHistoryItem;
import com.ibm.cloud.platform_services.catalog_management.v1.model.LicenseOfferingReference;
import com.ibm.cloud.platform_services.catalog_management.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the LicenseEntitlement model.
 */
public class LicenseEntitlementTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testLicenseEntitlement() throws Throwable {
    LicenseEntitlement licenseEntitlementModel = new LicenseEntitlement();
    assertNull(licenseEntitlementModel.getName());
    assertNull(licenseEntitlementModel.getId());
    assertNull(licenseEntitlementModel.getCrn());
    assertNull(licenseEntitlementModel.getUrl());
    assertNull(licenseEntitlementModel.getOfferingType());
    assertNull(licenseEntitlementModel.getState());
    assertNull(licenseEntitlementModel.getEffectiveFrom());
    assertNull(licenseEntitlementModel.getEffectiveUntil());
    assertNull(licenseEntitlementModel.getAccountId());
    assertNull(licenseEntitlementModel.getOwnerId());
    assertNull(licenseEntitlementModel.getVersionId());
    assertNull(licenseEntitlementModel.getLicenseOfferingId());
    assertNull(licenseEntitlementModel.getLicenseId());
    assertNull(licenseEntitlementModel.getLicenseOwnerId());
    assertNull(licenseEntitlementModel.getLicenseType());
    assertNull(licenseEntitlementModel.getLicenseProviderId());
    assertNull(licenseEntitlementModel.getLicenseProviderUrl());
    assertNull(licenseEntitlementModel.getLicenseProductId());
    assertNull(licenseEntitlementModel.getNamespaceRepository());
    assertNull(licenseEntitlementModel.getApikey());
    assertNull(licenseEntitlementModel.getCreateBy());
    assertNull(licenseEntitlementModel.getUpdateBy());
    assertNull(licenseEntitlementModel.getCreateAt());
    assertNull(licenseEntitlementModel.getUpdatedAt());
    assertNull(licenseEntitlementModel.getHistory());
    assertNull(licenseEntitlementModel.getOfferingList());
  }
}