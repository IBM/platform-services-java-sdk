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

import com.ibm.cloud.platform_services.global_catalog.v1.model.GetAuditLogsOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetAuditLogsOptions model.
 */
public class GetAuditLogsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetAuditLogsOptions() throws Throwable {
    GetAuditLogsOptions getAuditLogsOptionsModel = new GetAuditLogsOptions.Builder()
      .id("testString")
      .account("testString")
      .ascending("testString")
      .startat("testString")
      .offset(Long.valueOf("26"))
      .limit(Long.valueOf("200"))
      .build();
    assertEquals(getAuditLogsOptionsModel.id(), "testString");
    assertEquals(getAuditLogsOptionsModel.account(), "testString");
    assertEquals(getAuditLogsOptionsModel.ascending(), "testString");
    assertEquals(getAuditLogsOptionsModel.startat(), "testString");
    assertEquals(getAuditLogsOptionsModel.offset(), Long.valueOf("26"));
    assertEquals(getAuditLogsOptionsModel.limit(), Long.valueOf("200"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAuditLogsOptionsError() throws Throwable {
    new GetAuditLogsOptions.Builder().build();
  }

}