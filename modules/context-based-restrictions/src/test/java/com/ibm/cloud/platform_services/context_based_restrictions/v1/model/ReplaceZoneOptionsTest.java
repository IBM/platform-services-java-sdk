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

import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.AddressVPC;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ReplaceZoneOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ReplaceZoneOptions model.
 */
public class ReplaceZoneOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReplaceZoneOptions() throws Throwable {
    AddressVPC addressModel = new AddressVPC.Builder()
      .type("vpc")
      .value("testString")
      .build();
    assertEquals(addressModel.type(), "vpc");
    assertEquals(addressModel.value(), "testString");

    ReplaceZoneOptions replaceZoneOptionsModel = new ReplaceZoneOptions.Builder()
      .zoneId("testString")
      .ifMatch("testString")
      .name("testString")
      .accountId("testString")
      .description("testString")
      .addresses(java.util.Arrays.asList(addressModel))
      .excluded(java.util.Arrays.asList(addressModel))
      .xCorrelationId("testString")
      .transactionId("testString")
      .build();
    assertEquals(replaceZoneOptionsModel.zoneId(), "testString");
    assertEquals(replaceZoneOptionsModel.ifMatch(), "testString");
    assertEquals(replaceZoneOptionsModel.name(), "testString");
    assertEquals(replaceZoneOptionsModel.accountId(), "testString");
    assertEquals(replaceZoneOptionsModel.description(), "testString");
    assertEquals(replaceZoneOptionsModel.addresses(), java.util.Arrays.asList(addressModel));
    assertEquals(replaceZoneOptionsModel.excluded(), java.util.Arrays.asList(addressModel));
    assertEquals(replaceZoneOptionsModel.xCorrelationId(), "testString");
    assertEquals(replaceZoneOptionsModel.transactionId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceZoneOptionsError() throws Throwable {
    new ReplaceZoneOptions.Builder().build();
  }

}