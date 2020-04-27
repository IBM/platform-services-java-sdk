/*
 * (C) Copyright IBM Corp. 2020.
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

package com.ibm.cloud.platform_services.global_catalog.v1.model;

import com.ibm.cloud.platform_services.global_catalog.v1.model.Visibility;
import com.ibm.cloud.platform_services.global_catalog.v1.model.VisibilityDetail;
import com.ibm.cloud.platform_services.global_catalog.v1.model.VisibilityDetailAccounts;
import com.ibm.cloud.platform_services.global_catalog.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Visibility model.
 */
public class VisibilityTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testVisibility() throws Throwable {
    VisibilityDetailAccounts visibilityDetailAccountsModel = new VisibilityDetailAccounts.Builder()
      .accountid("testString")
      .build();
    assertEquals(visibilityDetailAccountsModel.accountid(), "testString");

    VisibilityDetail visibilityDetailModel = new VisibilityDetail.Builder()
      .accounts(visibilityDetailAccountsModel)
      .build();
    assertEquals(visibilityDetailModel.accounts(), visibilityDetailAccountsModel);

    Visibility visibilityModel = new Visibility.Builder()
      .include(visibilityDetailModel)
      .exclude(visibilityDetailModel)
      .build();
    assertEquals(visibilityModel.include(), visibilityDetailModel);
    assertEquals(visibilityModel.exclude(), visibilityDetailModel);

    String json = TestUtilities.serialize(visibilityModel);

    Visibility visibilityModelNew = TestUtilities.deserialize(json, Visibility.class);
    assertTrue(visibilityModelNew instanceof Visibility);
    assertEquals(visibilityModelNew.include().toString(), visibilityDetailModel.toString());
    assertEquals(visibilityModelNew.exclude().toString(), visibilityDetailModel.toString());
  }
}