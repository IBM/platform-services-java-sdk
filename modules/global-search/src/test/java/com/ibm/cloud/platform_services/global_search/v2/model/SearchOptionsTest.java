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

package com.ibm.cloud.platform_services.global_search.v2.model;

import com.ibm.cloud.platform_services.global_search.v2.model.SearchOptions;
import com.ibm.cloud.platform_services.global_search.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the SearchOptions model.
 */
public class SearchOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSearchOptions() throws Throwable {
    SearchOptions searchOptionsModel = new SearchOptions.Builder()
      .query("testString")
      .fields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .searchCursor("testString")
      .transactionId("testString")
      .accountId("testString")
      .limit(Long.valueOf("1"))
      .timeout(Long.valueOf("0"))
      .sort(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .build();
    assertEquals(searchOptionsModel.query(), "testString");
    assertEquals(searchOptionsModel.fields(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(searchOptionsModel.searchCursor(), "testString");
    assertEquals(searchOptionsModel.transactionId(), "testString");
    assertEquals(searchOptionsModel.accountId(), "testString");
    assertEquals(searchOptionsModel.limit(), Long.valueOf("1"));
    assertEquals(searchOptionsModel.timeout(), Long.valueOf("0"));
    assertEquals(searchOptionsModel.sort(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
  }
}