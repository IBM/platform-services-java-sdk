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

package com.ibm.cloud.platform_services.enterprise_management.v1.model;

import com.ibm.cloud.platform_services.enterprise_management.v1.model.ImportAccountToEnterpriseOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ImportAccountToEnterpriseOptions model.
 */
public class ImportAccountToEnterpriseOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testImportAccountToEnterpriseOptions() throws Throwable {
    ImportAccountToEnterpriseOptions importAccountToEnterpriseOptionsModel = new ImportAccountToEnterpriseOptions.Builder()
      .enterpriseId("testString")
      .accountId("testString")
      .parent("testString")
      .billingUnitId("testString")
      .build();
    assertEquals(importAccountToEnterpriseOptionsModel.enterpriseId(), "testString");
    assertEquals(importAccountToEnterpriseOptionsModel.accountId(), "testString");
    assertEquals(importAccountToEnterpriseOptionsModel.parent(), "testString");
    assertEquals(importAccountToEnterpriseOptionsModel.billingUnitId(), "testString");
  }
  
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testImportAccountToEnterpriseOptionsError() throws Throwable {
    new ImportAccountToEnterpriseOptions.Builder().build();
  }

}