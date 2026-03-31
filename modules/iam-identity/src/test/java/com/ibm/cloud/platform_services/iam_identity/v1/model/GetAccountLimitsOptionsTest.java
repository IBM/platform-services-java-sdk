/*
 * (C) Copyright IBM Corp. 2026.
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

package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.ibm.cloud.platform_services.iam_identity.v1.model.GetAccountLimitsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetAccountLimitsOptions model.
 */
public class GetAccountLimitsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetAccountLimitsOptions() throws Throwable {
    GetAccountLimitsOptions getAccountLimitsOptionsModel = new GetAccountLimitsOptions.Builder()
      .accountId("testString")
      .serviceidGroups(true)
      .serviceidsPerGroup("testString")
      .profiles("testString")
      .apikeysPerIdentity("testString")
      .templates("testString")
      .templateVersionsPerTemplate("testString")
      .idps("testString")
      .claimRulesPerGroup("testString")
      .claimRulesPerProfile("testString")
      .crLinks("testString")
      .crLinksPerProfile("testString")
      .crRules("testString")
      .crRulesPerProfile("testString")
      .build();
    assertEquals(getAccountLimitsOptionsModel.accountId(), "testString");
    assertEquals(getAccountLimitsOptionsModel.serviceidGroups(), Boolean.valueOf(true));
    assertEquals(getAccountLimitsOptionsModel.serviceidsPerGroup(), "testString");
    assertEquals(getAccountLimitsOptionsModel.profiles(), "testString");
    assertEquals(getAccountLimitsOptionsModel.apikeysPerIdentity(), "testString");
    assertEquals(getAccountLimitsOptionsModel.templates(), "testString");
    assertEquals(getAccountLimitsOptionsModel.templateVersionsPerTemplate(), "testString");
    assertEquals(getAccountLimitsOptionsModel.idps(), "testString");
    assertEquals(getAccountLimitsOptionsModel.claimRulesPerGroup(), "testString");
    assertEquals(getAccountLimitsOptionsModel.claimRulesPerProfile(), "testString");
    assertEquals(getAccountLimitsOptionsModel.crLinks(), "testString");
    assertEquals(getAccountLimitsOptionsModel.crLinksPerProfile(), "testString");
    assertEquals(getAccountLimitsOptionsModel.crRules(), "testString");
    assertEquals(getAccountLimitsOptionsModel.crRulesPerProfile(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAccountLimitsOptionsError() throws Throwable {
    new GetAccountLimitsOptions.Builder().build();
  }

}