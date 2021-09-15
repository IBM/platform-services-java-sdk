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

import com.ibm.cloud.context_based_restrictions.v1.model.AddressSubnet;
import com.ibm.cloud.context_based_restrictions.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the AddressSubnet model.
 */
public class AddressSubnetTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAddressSubnet() throws Throwable {
    AddressSubnet addressSubnetModel = new AddressSubnet.Builder()
      .type("subnet")
      .value("testString")
      .build();
    assertEquals(addressSubnetModel.type(), "subnet");
    assertEquals(addressSubnetModel.value(), "testString");

    String json = TestUtilities.serialize(addressSubnetModel);

    AddressSubnet addressSubnetModelNew = TestUtilities.deserialize(json, AddressSubnet.class);
    assertTrue(addressSubnetModelNew instanceof AddressSubnet);
    assertEquals(addressSubnetModelNew.type(), "subnet");
    assertEquals(addressSubnetModelNew.value(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddressSubnetError() throws Throwable {
    new AddressSubnet.Builder().build();
  }

}