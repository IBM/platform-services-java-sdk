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

package com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model;

import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.Link;
import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.MetricUsage;
import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.PlanUsage;
import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.Reports;
import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.ResourceUsage;
import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.ResourceUsageReport;
import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Reports model.
 */
public class ReportsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReports() throws Throwable {
    Reports reportsModel = new Reports();
    assertNull(reportsModel.getLimit());
    assertNull(reportsModel.getFirst());
    assertNull(reportsModel.getNext());
    assertNull(reportsModel.getReports());
  }
}