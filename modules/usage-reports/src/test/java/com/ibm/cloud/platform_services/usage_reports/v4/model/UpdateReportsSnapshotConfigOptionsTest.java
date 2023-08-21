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

import com.ibm.cloud.platform_services.usage_reports.v4.model.UpdateReportsSnapshotConfigOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the UpdateReportsSnapshotConfigOptions model.
 */
public class UpdateReportsSnapshotConfigOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdateReportsSnapshotConfigOptions() throws Throwable {
    UpdateReportsSnapshotConfigOptions updateReportsSnapshotConfigOptionsModel = new UpdateReportsSnapshotConfigOptions.Builder()
      .accountId("abc")
      .interval("daily")
      .cosBucket("bucket_name")
      .cosLocation("us-south")
      .cosReportsFolder("IBMCloud-Billing-Reports")
      .reportTypes(java.util.Arrays.asList("account_summary", "enterprise_summary", "account_resource_instance_usage"))
      .versioning("new")
      .build();
    assertEquals(updateReportsSnapshotConfigOptionsModel.accountId(), "abc");
    assertEquals(updateReportsSnapshotConfigOptionsModel.interval(), "daily");
    assertEquals(updateReportsSnapshotConfigOptionsModel.cosBucket(), "bucket_name");
    assertEquals(updateReportsSnapshotConfigOptionsModel.cosLocation(), "us-south");
    assertEquals(updateReportsSnapshotConfigOptionsModel.cosReportsFolder(), "IBMCloud-Billing-Reports");
    assertEquals(updateReportsSnapshotConfigOptionsModel.reportTypes(), java.util.Arrays.asList("account_summary", "enterprise_summary", "account_resource_instance_usage"));
    assertEquals(updateReportsSnapshotConfigOptionsModel.versioning(), "new");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateReportsSnapshotConfigOptionsError() throws Throwable {
    new UpdateReportsSnapshotConfigOptions.Builder().build();
  }

}