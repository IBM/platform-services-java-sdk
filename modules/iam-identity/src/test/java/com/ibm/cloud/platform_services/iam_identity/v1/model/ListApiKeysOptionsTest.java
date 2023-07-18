/*
 * (C) Copyright IBM Corp. 2023.
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

import com.ibm.cloud.platform_services.iam_identity.v1.model.ListApiKeysOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ListApiKeysOptions model.
 */
public class ListApiKeysOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListApiKeysOptions() throws Throwable {
    ListApiKeysOptions listApiKeysOptionsModel = new ListApiKeysOptions.Builder()
      .accountId("testString")
      .iamId("testString")
      .pagesize(Long.valueOf("26"))
      .pagetoken("testString")
      .scope("entity")
      .type("user")
      .sort("testString")
      .order("asc")
      .includeHistory(false)
      .build();
    assertEquals(listApiKeysOptionsModel.accountId(), "testString");
    assertEquals(listApiKeysOptionsModel.iamId(), "testString");
    assertEquals(listApiKeysOptionsModel.pagesize(), Long.valueOf("26"));
    assertEquals(listApiKeysOptionsModel.pagetoken(), "testString");
    assertEquals(listApiKeysOptionsModel.scope(), "entity");
    assertEquals(listApiKeysOptionsModel.type(), "user");
    assertEquals(listApiKeysOptionsModel.sort(), "testString");
    assertEquals(listApiKeysOptionsModel.order(), "asc");
    assertEquals(listApiKeysOptionsModel.includeHistory(), Boolean.valueOf(false));
  }
}