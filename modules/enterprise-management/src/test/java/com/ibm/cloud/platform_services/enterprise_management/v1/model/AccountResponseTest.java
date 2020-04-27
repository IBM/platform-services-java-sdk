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

import com.ibm.cloud.platform_services.enterprise_management.v1.model.AccountResponse;
import com.ibm.cloud.platform_services.enterprise_management.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the AccountResponse model.
 */
public class AccountResponseTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAccountResponse() throws Throwable {
    AccountResponse accountResponseModel = new AccountResponse();
    assertNull(accountResponseModel.getUrl());
    assertNull(accountResponseModel.getId());
    assertNull(accountResponseModel.getCrn());
    assertNull(accountResponseModel.getParent());
    assertNull(accountResponseModel.getEnterpriseAccountId());
    assertNull(accountResponseModel.getEnterpriseId());
    assertNull(accountResponseModel.getEnterprisePath());
    assertNull(accountResponseModel.getName());
    assertNull(accountResponseModel.getState());
    assertNull(accountResponseModel.getOwnerIamId());
    assertNull(accountResponseModel.isPaid());
    assertNull(accountResponseModel.getOwnerEmail());
    assertNull(accountResponseModel.isIsEnterpriseAccount());
    assertNull(accountResponseModel.getCreatedAt());
    assertNull(accountResponseModel.getCreatedBy());
    assertNull(accountResponseModel.getUpdatedAt());
    assertNull(accountResponseModel.getUpdatedBy());
  }
}