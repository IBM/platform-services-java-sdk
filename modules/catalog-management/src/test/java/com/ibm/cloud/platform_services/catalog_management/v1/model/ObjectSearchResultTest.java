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

import com.ibm.cloud.platform_services.catalog_management.v1.model.CatalogObject;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ObjectSearchResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.PublishObject;
import com.ibm.cloud.platform_services.catalog_management.v1.model.State;
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
 * Unit test class for the ObjectSearchResult model.
 */
public class ObjectSearchResultTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testObjectSearchResult() throws Throwable {
    ObjectSearchResult objectSearchResultModel = new ObjectSearchResult();
    assertNull(objectSearchResultModel.getOffset());
    assertNull(objectSearchResultModel.getLimit());
    assertNull(objectSearchResultModel.getTotalCount());
    assertNull(objectSearchResultModel.getResourceCount());
    assertNull(objectSearchResultModel.getFirst());
    assertNull(objectSearchResultModel.getLast());
    assertNull(objectSearchResultModel.getPrev());
    assertNull(objectSearchResultModel.getNext());
    assertNull(objectSearchResultModel.getResources());
  }
}