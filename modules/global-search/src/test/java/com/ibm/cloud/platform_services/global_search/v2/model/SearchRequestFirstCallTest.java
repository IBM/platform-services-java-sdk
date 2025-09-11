/*
 * (C) Copyright IBM Corp. 2025.
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

import com.ibm.cloud.platform_services.global_search.v2.model.SearchRequestFirstCall;
import com.ibm.cloud.platform_services.global_search.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the SearchRequestFirstCall model.
 */
public class SearchRequestFirstCallTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSearchRequestFirstCall() throws Throwable {
    SearchRequestFirstCall searchRequestFirstCallModel = new SearchRequestFirstCall.Builder()
      .query("testString")
      .fields(java.util.Arrays.asList("testString"))
      .build();
    assertEquals(searchRequestFirstCallModel.query(), "testString");
    assertEquals(searchRequestFirstCallModel.fields(), java.util.Arrays.asList("testString"));

    String json = TestUtilities.serialize(searchRequestFirstCallModel);

    SearchRequestFirstCall searchRequestFirstCallModelNew = TestUtilities.deserialize(json, SearchRequestFirstCall.class);
    assertTrue(searchRequestFirstCallModelNew instanceof SearchRequestFirstCall);
    assertEquals(searchRequestFirstCallModelNew.query(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSearchRequestFirstCallError() throws Throwable {
    new SearchRequestFirstCall.Builder().build();
  }

}