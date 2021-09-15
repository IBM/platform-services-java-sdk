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

import com.ibm.cloud.context_based_restrictions.v1.model.AddressVPC;
import com.ibm.cloud.context_based_restrictions.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the AddressVPC model.
 */
public class AddressVPCTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAddressVPC() throws Throwable {
    AddressVPC addressVpcModel = new AddressVPC.Builder()
      .type("vpc")
      .value("testString")
      .build();
    assertEquals(addressVpcModel.type(), "vpc");
    assertEquals(addressVpcModel.value(), "testString");

    String json = TestUtilities.serialize(addressVpcModel);

    AddressVPC addressVpcModelNew = TestUtilities.deserialize(json, AddressVPC.class);
    assertTrue(addressVpcModelNew instanceof AddressVPC);
    assertEquals(addressVpcModelNew.type(), "vpc");
    assertEquals(addressVpcModelNew.value(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddressVPCError() throws Throwable {
    new AddressVPC.Builder().build();
  }

}