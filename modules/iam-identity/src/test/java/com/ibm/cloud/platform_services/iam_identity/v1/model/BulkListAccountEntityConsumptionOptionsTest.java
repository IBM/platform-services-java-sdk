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

import com.ibm.cloud.platform_services.iam_identity.v1.model.BulkListAccountEntityConsumptionOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the BulkListAccountEntityConsumptionOptions model.
 */
public class BulkListAccountEntityConsumptionOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testBulkListAccountEntityConsumptionOptions() throws Throwable {
    BulkListAccountEntityConsumptionOptions bulkListAccountEntityConsumptionOptionsModel = new BulkListAccountEntityConsumptionOptions.Builder()
      .accountId("testString")
      .serviceidGroups(true)
      .serviceidsPerGroup(java.util.Arrays.asList("testString"))
      .profiles(true)
      .apikeysPerIdentity(java.util.Arrays.asList("testString"))
      .templates(true)
      .templateVersionsPerTemplate(java.util.Arrays.asList("testString"))
      .idps(true)
      .claimRulesPerGroup(java.util.Arrays.asList("testString"))
      .claimRulesPerProfile(java.util.Arrays.asList("testString"))
      .crLinks(true)
      .crLinksPerProfile(java.util.Arrays.asList("testString"))
      .crRules(true)
      .crRulesPerProfile(java.util.Arrays.asList("testString"))
      .build();
    assertEquals(bulkListAccountEntityConsumptionOptionsModel.accountId(), "testString");
    assertEquals(bulkListAccountEntityConsumptionOptionsModel.serviceidGroups(), Boolean.valueOf(true));
    assertEquals(bulkListAccountEntityConsumptionOptionsModel.serviceidsPerGroup(), java.util.Arrays.asList("testString"));
    assertEquals(bulkListAccountEntityConsumptionOptionsModel.profiles(), Boolean.valueOf(true));
    assertEquals(bulkListAccountEntityConsumptionOptionsModel.apikeysPerIdentity(), java.util.Arrays.asList("testString"));
    assertEquals(bulkListAccountEntityConsumptionOptionsModel.templates(), Boolean.valueOf(true));
    assertEquals(bulkListAccountEntityConsumptionOptionsModel.templateVersionsPerTemplate(), java.util.Arrays.asList("testString"));
    assertEquals(bulkListAccountEntityConsumptionOptionsModel.idps(), Boolean.valueOf(true));
    assertEquals(bulkListAccountEntityConsumptionOptionsModel.claimRulesPerGroup(), java.util.Arrays.asList("testString"));
    assertEquals(bulkListAccountEntityConsumptionOptionsModel.claimRulesPerProfile(), java.util.Arrays.asList("testString"));
    assertEquals(bulkListAccountEntityConsumptionOptionsModel.crLinks(), Boolean.valueOf(true));
    assertEquals(bulkListAccountEntityConsumptionOptionsModel.crLinksPerProfile(), java.util.Arrays.asList("testString"));
    assertEquals(bulkListAccountEntityConsumptionOptionsModel.crRules(), Boolean.valueOf(true));
    assertEquals(bulkListAccountEntityConsumptionOptionsModel.crRulesPerProfile(), java.util.Arrays.asList("testString"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testBulkListAccountEntityConsumptionOptionsError() throws Throwable {
    new BulkListAccountEntityConsumptionOptions.Builder().build();
  }

}