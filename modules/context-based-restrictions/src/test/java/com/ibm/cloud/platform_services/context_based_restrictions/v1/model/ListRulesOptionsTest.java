/*
 * (C) Copyright IBM Corp. 2022.
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

package com.ibm.cloud.platform_services.context_based_restrictions.v1.model;

import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ListRulesOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.utils.TestUtilities;
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
      .accountId("testString")
      .xCorrelationId("testString")
      .transactionId("testString")
      .region("testString")
      .resource("testString")
      .resourceType("testString")
      .serviceInstance("testString")
      .serviceName("testString")
      .serviceType("testString")
      .zoneId("testString")
      .sort("testString")
      .build();
    assertEquals(listRulesOptionsModel.accountId(), "testString");
    assertEquals(listRulesOptionsModel.xCorrelationId(), "testString");
    assertEquals(listRulesOptionsModel.transactionId(), "testString");
    assertEquals(listRulesOptionsModel.region(), "testString");
    assertEquals(listRulesOptionsModel.resource(), "testString");
    assertEquals(listRulesOptionsModel.resourceType(), "testString");
    assertEquals(listRulesOptionsModel.serviceInstance(), "testString");
    assertEquals(listRulesOptionsModel.serviceName(), "testString");
    assertEquals(listRulesOptionsModel.serviceType(), "testString");
    assertEquals(listRulesOptionsModel.zoneId(), "testString");
    assertEquals(listRulesOptionsModel.sort(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListRulesOptionsError() throws Throwable {
    new ListRulesOptions.Builder().build();
  }

}