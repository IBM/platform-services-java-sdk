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

package com.ibm.cloud.platform_services.context_based_restrictions.v1.model;

import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.AddressIPAddress;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.CreateZoneOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateZoneOptions model.
 */
public class CreateZoneOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateZoneOptions() throws Throwable {
    AddressIPAddress addressModel = new AddressIPAddress.Builder()
      .type("ipAddress")
      .value("testString")
      .build();
    assertEquals(addressModel.type(), "ipAddress");
    assertEquals(addressModel.value(), "testString");

    CreateZoneOptions createZoneOptionsModel = new CreateZoneOptions.Builder()
      .name("testString")
      .accountId("testString")
      .description("testString")
      .addresses(java.util.Arrays.asList(addressModel))
      .excluded(java.util.Arrays.asList(addressModel))
      .xCorrelationId("testString")
      .transactionId("testString")
      .build();
    assertEquals(createZoneOptionsModel.name(), "testString");
    assertEquals(createZoneOptionsModel.accountId(), "testString");
    assertEquals(createZoneOptionsModel.description(), "testString");
    assertEquals(createZoneOptionsModel.addresses(), java.util.Arrays.asList(addressModel));
    assertEquals(createZoneOptionsModel.excluded(), java.util.Arrays.asList(addressModel));
    assertEquals(createZoneOptionsModel.xCorrelationId(), "testString");
    assertEquals(createZoneOptionsModel.transactionId(), "testString");
  }
}