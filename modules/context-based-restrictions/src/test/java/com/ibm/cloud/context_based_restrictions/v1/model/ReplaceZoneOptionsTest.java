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

package com.ibm.cloud.context_based_restrictions.v1.model;

import com.ibm.cloud.context_based_restrictions.v1.model.AddressIPAddress;
import com.ibm.cloud.context_based_restrictions.v1.model.ReplaceZoneOptions;
import com.ibm.cloud.context_based_restrictions.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
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
    AddressIPAddress addressModel = new AddressIPAddress.Builder()
      .type("ipAddress")
      .value("testString")
      .build();
    assertEquals(addressModel.type(), "ipAddress");
    assertEquals(addressModel.value(), "testString");

    ReplaceZoneOptions replaceZoneOptionsModel = new ReplaceZoneOptions.Builder()
      .zoneId("testString")
      .ifMatch("testString")
      .name("testString")
      .accountId("testString")
      .description("testString")
      .addresses(new java.util.ArrayList<Address>(java.util.Arrays.asList(addressModel)))
      .excluded(new java.util.ArrayList<Address>(java.util.Arrays.asList(addressModel)))
      .transactionId("testString")
      .build();
    assertEquals(replaceZoneOptionsModel.zoneId(), "testString");
    assertEquals(replaceZoneOptionsModel.ifMatch(), "testString");
    assertEquals(replaceZoneOptionsModel.name(), "testString");
    assertEquals(replaceZoneOptionsModel.accountId(), "testString");
    assertEquals(replaceZoneOptionsModel.description(), "testString");
    assertEquals(replaceZoneOptionsModel.addresses(), new java.util.ArrayList<Address>(java.util.Arrays.asList(addressModel)));
    assertEquals(replaceZoneOptionsModel.excluded(), new java.util.ArrayList<Address>(java.util.Arrays.asList(addressModel)));
    assertEquals(replaceZoneOptionsModel.transactionId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceZoneOptionsError() throws Throwable {
    new ReplaceZoneOptions.Builder().build();
  }

}