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

import com.ibm.cloud.platform_services.catalog_management.v1.model.Configuration;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Deployment;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Feature;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Kind;
import com.ibm.cloud.platform_services.catalog_management.v1.model.License;
import com.ibm.cloud.platform_services.catalog_management.v1.model.MediaItem;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Offering;
import com.ibm.cloud.platform_services.catalog_management.v1.model.OfferingSearchResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Plan;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ProviderInfo;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Rating;
import com.ibm.cloud.platform_services.catalog_management.v1.model.RepoInfo;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Resource;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Script;
import com.ibm.cloud.platform_services.catalog_management.v1.model.State;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Support;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Validation;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Version;
import com.ibm.cloud.platform_services.catalog_management.v1.model.VersionEntitlement;
import com.ibm.cloud.platform_services.catalog_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the OfferingSearchResult model.
 */
public class OfferingSearchResultTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testOfferingSearchResult() throws Throwable {
    OfferingSearchResult offeringSearchResultModel = new OfferingSearchResult();
    assertNull(offeringSearchResultModel.getOffset());
    assertNull(offeringSearchResultModel.getLimit());
    assertNull(offeringSearchResultModel.getTotalCount());
    assertNull(offeringSearchResultModel.getResourceCount());
    assertNull(offeringSearchResultModel.getFirst());
    assertNull(offeringSearchResultModel.getLast());
    assertNull(offeringSearchResultModel.getPrev());
    assertNull(offeringSearchResultModel.getNext());
    assertNull(offeringSearchResultModel.getResources());
  }
}