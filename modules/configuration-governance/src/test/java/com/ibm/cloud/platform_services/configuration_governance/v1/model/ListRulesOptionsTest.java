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

package com.ibm.cloud.platform_services.configuration_governance.v1.model;

import com.ibm.cloud.platform_services.configuration_governance.v1.model.ListRulesOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ListRulesOptions model.
 */
public class ListRulesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListRulesOptions() throws Throwable {
    ListRulesOptions listRulesOptionsModel = new ListRulesOptions.Builder()
      .accountId("531fc3e28bfc43c5a2cea07786d93f5c")
      .transactionId("testString")
      .attached(true)
      .labels("SOC2,ITCS300")
      .scopes("scope_id")
      .limit(Long.valueOf("1000"))
      .offset(Long.valueOf("26"))
      .build();
    assertEquals(listRulesOptionsModel.accountId(), "531fc3e28bfc43c5a2cea07786d93f5c");
    assertEquals(listRulesOptionsModel.transactionId(), "testString");
    assertEquals(listRulesOptionsModel.attached(), Boolean.valueOf(true));
    assertEquals(listRulesOptionsModel.labels(), "SOC2,ITCS300");
    assertEquals(listRulesOptionsModel.scopes(), "scope_id");
    assertEquals(listRulesOptionsModel.limit(), Long.valueOf("1000"));
    assertEquals(listRulesOptionsModel.offset(), Long.valueOf("26"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListRulesOptionsError() throws Throwable {
    new ListRulesOptions.Builder().build();
  }

}