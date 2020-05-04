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
import com.ibm.cloud.platform_services.global_catalog.v1.model.CatalogEntryMetadata;
import com.ibm.cloud.platform_services.global_catalog.v1.model.CatalogEntryMetadataDeployment;
import com.ibm.cloud.platform_services.global_catalog.v1.model.CatalogEntryMetadataDeploymentBroker;
import com.ibm.cloud.platform_services.global_catalog.v1.model.CatalogEntryMetadataPricing;
import com.ibm.cloud.platform_services.global_catalog.v1.model.EntrySearchResult;
import com.ibm.cloud.platform_services.global_catalog.v1.model.I18N;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Image;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Metrics;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBaseAlias;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBasePlan;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBaseService;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBaseSla;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBaseSlaDr;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBaseTemplate;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBaseTemplateEnvironmentVariables;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBaseTemplateSource;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Overview;
import com.ibm.cloud.platform_services.global_catalog.v1.model.OverviewUI;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Price;
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
 * Unit test class for the EntrySearchResult model.
 */
public class EntrySearchResultTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testEntrySearchResult() throws Throwable {
    EntrySearchResult entrySearchResultModel = new EntrySearchResult();
    assertNull(entrySearchResultModel.getOffset());
    assertNull(entrySearchResultModel.getLimit());
    assertNull(entrySearchResultModel.getCount());
    assertNull(entrySearchResultModel.getResourceCount());
    assertNull(entrySearchResultModel.getFirst());
    assertNull(entrySearchResultModel.getLast());
    assertNull(entrySearchResultModel.getPrev());
    assertNull(entrySearchResultModel.getNext());
    assertNull(entrySearchResultModel.getResources());
  }
}