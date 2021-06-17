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

import com.ibm.cloud.platform_services.catalog_management.v1.model.GetNamespacesOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetNamespacesOptions model.
 */
public class GetNamespacesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetNamespacesOptions() throws Throwable {
    GetNamespacesOptions getNamespacesOptionsModel = new GetNamespacesOptions.Builder()
      .clusterId("testString")
      .region("testString")
      .xAuthRefreshToken("testString")
      .limit(Long.valueOf("1000"))
      .offset(Long.valueOf("26"))
      .build();
    assertEquals(getNamespacesOptionsModel.clusterId(), "testString");
    assertEquals(getNamespacesOptionsModel.region(), "testString");
    assertEquals(getNamespacesOptionsModel.xAuthRefreshToken(), "testString");
    assertEquals(getNamespacesOptionsModel.limit(), Long.valueOf("1000"));
    assertEquals(getNamespacesOptionsModel.offset(), Long.valueOf("26"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetNamespacesOptionsError() throws Throwable {
    new GetNamespacesOptions.Builder().build();
  }

}