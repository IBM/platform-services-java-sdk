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

import com.ibm.cloud.platform_services.global_catalog.v1.model.UpdateVisibilityOptions;
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
 * Unit test class for the UpdateVisibilityOptions model.
 */
public class UpdateVisibilityOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdateVisibilityOptions() throws Throwable {
    VisibilityDetailAccounts visibilityDetailAccountsModel = new VisibilityDetailAccounts.Builder()
      .accountid("testString")
      .build();
    assertEquals(visibilityDetailAccountsModel.accountid(), "testString");

    VisibilityDetail visibilityDetailModel = new VisibilityDetail.Builder()
      .accounts(visibilityDetailAccountsModel)
      .build();
    assertEquals(visibilityDetailModel.accounts(), visibilityDetailAccountsModel);

    UpdateVisibilityOptions updateVisibilityOptionsModel = new UpdateVisibilityOptions.Builder()
      .id("testString")
      .extendable(true)
      .include(visibilityDetailModel)
      .exclude(visibilityDetailModel)
      .account("testString")
      .build();
    assertEquals(updateVisibilityOptionsModel.id(), "testString");
    assertEquals(updateVisibilityOptionsModel.extendable(), Boolean.valueOf(true));
    assertEquals(updateVisibilityOptionsModel.include(), visibilityDetailModel);
    assertEquals(updateVisibilityOptionsModel.exclude(), visibilityDetailModel);
    assertEquals(updateVisibilityOptionsModel.account(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateVisibilityOptionsError() throws Throwable {
    new UpdateVisibilityOptions.Builder().build();
  }

}