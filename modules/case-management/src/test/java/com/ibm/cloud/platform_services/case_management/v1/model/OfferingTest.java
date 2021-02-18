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

package com.ibm.cloud.platform_services.case_management.v1.model;

import com.ibm.cloud.platform_services.case_management.v1.model.Offering;
import com.ibm.cloud.platform_services.case_management.v1.model.OfferingType;
import com.ibm.cloud.platform_services.case_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Offering model.
 */
public class OfferingTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testOffering() throws Throwable {
    OfferingType offeringTypeModel = new OfferingType.Builder()
      .group("crn_service_name")
      .key("testString")
      .kind("testString")
      .id("testString")
      .build();
    assertEquals(offeringTypeModel.group(), "crn_service_name");
    assertEquals(offeringTypeModel.key(), "testString");
    assertEquals(offeringTypeModel.kind(), "testString");
    assertEquals(offeringTypeModel.id(), "testString");

    Offering offeringModel = new Offering.Builder()
      .name("testString")
      .type(offeringTypeModel)
      .build();
    assertEquals(offeringModel.name(), "testString");
    assertEquals(offeringModel.type(), offeringTypeModel);

    String json = TestUtilities.serialize(offeringModel);

    Offering offeringModelNew = TestUtilities.deserialize(json, Offering.class);
    assertTrue(offeringModelNew instanceof Offering);
    assertEquals(offeringModelNew.name(), "testString");
    assertEquals(offeringModelNew.type().toString(), offeringTypeModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testOfferingError() throws Throwable {
    new Offering.Builder().build();
  }

}