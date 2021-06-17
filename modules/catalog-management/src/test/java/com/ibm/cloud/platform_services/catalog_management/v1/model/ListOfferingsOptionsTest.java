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

package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.ibm.cloud.platform_services.catalog_management.v1.model.ListOfferingsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ListOfferingsOptions model.
 */
public class ListOfferingsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListOfferingsOptions() throws Throwable {
    ListOfferingsOptions listOfferingsOptionsModel = new ListOfferingsOptions.Builder()
      .catalogIdentifier("testString")
      .digest(true)
      .limit(Long.valueOf("1000"))
      .offset(Long.valueOf("26"))
      .name("testString")
      .sort("testString")
      .build();
    assertEquals(listOfferingsOptionsModel.catalogIdentifier(), "testString");
    assertEquals(listOfferingsOptionsModel.digest(), Boolean.valueOf(true));
    assertEquals(listOfferingsOptionsModel.limit(), Long.valueOf("1000"));
    assertEquals(listOfferingsOptionsModel.offset(), Long.valueOf("26"));
    assertEquals(listOfferingsOptionsModel.name(), "testString");
    assertEquals(listOfferingsOptionsModel.sort(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListOfferingsOptionsError() throws Throwable {
    new ListOfferingsOptions.Builder().build();
  }

}