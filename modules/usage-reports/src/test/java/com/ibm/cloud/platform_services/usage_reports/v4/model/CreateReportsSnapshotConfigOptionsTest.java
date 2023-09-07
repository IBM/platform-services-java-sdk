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

package com.ibm.cloud.platform_services.usage_reports.v4.model;

import com.ibm.cloud.platform_services.usage_reports.v4.model.CreateReportsSnapshotConfigOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateReportsSnapshotConfigOptions model.
 */
public class CreateReportsSnapshotConfigOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateReportsSnapshotConfigOptions() throws Throwable {
    CreateReportsSnapshotConfigOptions createReportsSnapshotConfigOptionsModel = new CreateReportsSnapshotConfigOptions.Builder()
      .accountId("abc")
      .interval("daily")
      .cosBucket("bucket_name")
      .cosLocation("us-south")
      .cosReportsFolder("IBMCloud-Billing-Reports")
      .reportTypes(java.util.Arrays.asList("account_summary", "enterprise_summary", "account_resource_instance_usage"))
      .versioning("new")
      .build();
    assertEquals(createReportsSnapshotConfigOptionsModel.accountId(), "abc");
    assertEquals(createReportsSnapshotConfigOptionsModel.interval(), "daily");
    assertEquals(createReportsSnapshotConfigOptionsModel.cosBucket(), "bucket_name");
    assertEquals(createReportsSnapshotConfigOptionsModel.cosLocation(), "us-south");
    assertEquals(createReportsSnapshotConfigOptionsModel.cosReportsFolder(), "IBMCloud-Billing-Reports");
    assertEquals(createReportsSnapshotConfigOptionsModel.reportTypes(), java.util.Arrays.asList("account_summary", "enterprise_summary", "account_resource_instance_usage"));
    assertEquals(createReportsSnapshotConfigOptionsModel.versioning(), "new");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateReportsSnapshotConfigOptionsError() throws Throwable {
    new CreateReportsSnapshotConfigOptions.Builder().build();
  }

}