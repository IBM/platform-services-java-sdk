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

import com.ibm.cloud.platform_services.catalog_management.v1.model.Catalog;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CatalogSearchResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CategoryFilter;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Feature;
import com.ibm.cloud.platform_services.catalog_management.v1.model.FilterTerms;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Filters;
import com.ibm.cloud.platform_services.catalog_management.v1.model.IDFilter;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SyndicationAuthorization;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SyndicationCluster;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SyndicationHistory;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SyndicationResource;
import com.ibm.cloud.platform_services.catalog_management.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CatalogSearchResult model.
 */
public class CatalogSearchResultTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCatalogSearchResult() throws Throwable {
    CatalogSearchResult catalogSearchResultModel = new CatalogSearchResult();
    assertNull(catalogSearchResultModel.getOffset());
    assertNull(catalogSearchResultModel.getLimit());
    assertNull(catalogSearchResultModel.getTotalCount());
    assertNull(catalogSearchResultModel.getResourceCount());
    assertNull(catalogSearchResultModel.getFirst());
    assertNull(catalogSearchResultModel.getLast());
    assertNull(catalogSearchResultModel.getPrev());
    assertNull(catalogSearchResultModel.getNext());
    assertNull(catalogSearchResultModel.getResources());
  }
}