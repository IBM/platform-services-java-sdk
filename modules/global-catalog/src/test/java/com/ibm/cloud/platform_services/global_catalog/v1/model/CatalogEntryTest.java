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

package com.ibm.cloud.platform_services.global_catalog.v1.model;

import com.ibm.cloud.platform_services.global_catalog.v1.model.Amount;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Bullets;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Callbacks;
import com.ibm.cloud.platform_services.global_catalog.v1.model.CatalogEntry;
import com.ibm.cloud.platform_services.global_catalog.v1.model.DeploymentBase;
import com.ibm.cloud.platform_services.global_catalog.v1.model.DeploymentBaseBroker;
import com.ibm.cloud.platform_services.global_catalog.v1.model.I18N;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Image;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBaseAlias;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBasePlan;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBaseService;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBaseSla;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBaseSlaDr;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBaseTemplate;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBaseTemplateEnvironmentVariables;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBaseTemplateSource;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataSet;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Overview;
import com.ibm.cloud.platform_services.global_catalog.v1.model.OverviewUI;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Price;
import com.ibm.cloud.platform_services.global_catalog.v1.model.PricingSet;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Provider;
import com.ibm.cloud.platform_services.global_catalog.v1.model.StartingPrice;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Strings;
import com.ibm.cloud.platform_services.global_catalog.v1.model.UIMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.model.UIMetaMedia;
import com.ibm.cloud.platform_services.global_catalog.v1.model.URLS;
import com.ibm.cloud.platform_services.global_catalog.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CatalogEntry model.
 */
public class CatalogEntryTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCatalogEntry() throws Throwable {
    CatalogEntry catalogEntryModel = new CatalogEntry();
    assertNull(catalogEntryModel.getName());
    assertNull(catalogEntryModel.getKind());
    assertNull(catalogEntryModel.getOverviewUi());
    assertNull(catalogEntryModel.getImages());
    assertNull(catalogEntryModel.getParentId());
    assertNull(catalogEntryModel.isDisabled());
    assertNull(catalogEntryModel.getTags());
    assertNull(catalogEntryModel.isGroup());
    assertNull(catalogEntryModel.getProvider());
    assertNull(catalogEntryModel.isActive());
    assertNull(catalogEntryModel.getMetadata());
  }
}