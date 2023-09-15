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

import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ServiceRefValue;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ServiceRefValue model.
 */
public class ServiceRefValueTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testServiceRefValue() throws Throwable {
    ServiceRefValue serviceRefValueModel = new ServiceRefValue.Builder()
      .accountId("testString")
      .serviceType("testString")
      .serviceName("testString")
      .serviceInstance("testString")
      .location("testString")
      .build();
    assertEquals(serviceRefValueModel.accountId(), "testString");
    assertEquals(serviceRefValueModel.serviceType(), "testString");
    assertEquals(serviceRefValueModel.serviceName(), "testString");
    assertEquals(serviceRefValueModel.serviceInstance(), "testString");
    assertEquals(serviceRefValueModel.location(), "testString");

    String json = TestUtilities.serialize(serviceRefValueModel);

    ServiceRefValue serviceRefValueModelNew = TestUtilities.deserialize(json, ServiceRefValue.class);
    assertTrue(serviceRefValueModelNew instanceof ServiceRefValue);
    assertEquals(serviceRefValueModelNew.accountId(), "testString");
    assertEquals(serviceRefValueModelNew.serviceType(), "testString");
    assertEquals(serviceRefValueModelNew.serviceName(), "testString");
    assertEquals(serviceRefValueModelNew.serviceInstance(), "testString");
    assertEquals(serviceRefValueModelNew.location(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testServiceRefValueError() throws Throwable {
    new ServiceRefValue.Builder().build();
  }

}