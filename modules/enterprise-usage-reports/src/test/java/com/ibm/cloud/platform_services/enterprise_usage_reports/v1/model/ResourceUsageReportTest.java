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

package com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model;

import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.MetricUsage;
import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.PlanUsage;
import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.ResourceUsage;
import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.ResourceUsageReport;
import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ResourceUsageReport model.
 */
public class ResourceUsageReportTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testResourceUsageReport() throws Throwable {
    ResourceUsageReport resourceUsageReportModel = new ResourceUsageReport();
    assertNull(resourceUsageReportModel.getEntityId());
    assertNull(resourceUsageReportModel.getEntityType());
    assertNull(resourceUsageReportModel.getEntityCrn());
    assertNull(resourceUsageReportModel.getEntityName());
    assertNull(resourceUsageReportModel.getBillingUnitId());
    assertNull(resourceUsageReportModel.getBillingUnitCrn());
    assertNull(resourceUsageReportModel.getBillingUnitName());
    assertNull(resourceUsageReportModel.getCountryCode());
    assertNull(resourceUsageReportModel.getCurrencyCode());
    assertNull(resourceUsageReportModel.getMonth());
    assertNull(resourceUsageReportModel.getBillableCost());
    assertNull(resourceUsageReportModel.getNonBillableCost());
    assertNull(resourceUsageReportModel.getBillableRatedCost());
    assertNull(resourceUsageReportModel.getNonBillableRatedCost());
    assertNull(resourceUsageReportModel.getResources());
  }
}