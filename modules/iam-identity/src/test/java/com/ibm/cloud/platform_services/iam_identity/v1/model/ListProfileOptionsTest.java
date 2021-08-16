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

package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.ibm.cloud.platform_services.iam_identity.v1.model.ListProfileOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ListProfileOptions model.
 */
public class ListProfileOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListProfileOptions() throws Throwable {
    ListProfileOptions listProfileOptionsModel = new ListProfileOptions.Builder()
      .accountId("testString")
      .name("testString")
      .pagesize(Long.valueOf("26"))
      .sort("testString")
      .order("asc")
      .includeHistory(false)
      .pagetoken("testString")
      .build();
    assertEquals(listProfileOptionsModel.accountId(), "testString");
    assertEquals(listProfileOptionsModel.name(), "testString");
    assertEquals(listProfileOptionsModel.pagesize(), Long.valueOf("26"));
    assertEquals(listProfileOptionsModel.sort(), "testString");
    assertEquals(listProfileOptionsModel.order(), "asc");
    assertEquals(listProfileOptionsModel.includeHistory(), Boolean.valueOf(false));
    assertEquals(listProfileOptionsModel.pagetoken(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListProfileOptionsError() throws Throwable {
    new ListProfileOptions.Builder().build();
  }

}