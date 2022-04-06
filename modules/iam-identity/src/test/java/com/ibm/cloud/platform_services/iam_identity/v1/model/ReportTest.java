/*
 * (C) Copyright IBM Corp. 2022.
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

import com.ibm.cloud.platform_services.iam_identity.v1.model.EntityActivity;
import com.ibm.cloud.platform_services.iam_identity.v1.model.Report;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UserActivity;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Report model.
 */
public class ReportTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReport() throws Throwable {
    Report reportModel = new Report();
    assertNull(reportModel.getCreatedBy());
    assertNull(reportModel.getReference());
    assertNull(reportModel.getReportDuration());
    assertNull(reportModel.getReportStartTime());
    assertNull(reportModel.getReportEndTime());
    assertNull(reportModel.getUsers());
    assertNull(reportModel.getApikeys());
    assertNull(reportModel.getServiceids());
    assertNull(reportModel.getProfiles());
  }
}