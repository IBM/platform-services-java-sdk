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

import com.ibm.cloud.platform_services.usage_reports.v4.model.Discount;
import com.ibm.cloud.platform_services.usage_reports.v4.model.Metric;
import com.ibm.cloud.platform_services.usage_reports.v4.model.Plan;
import com.ibm.cloud.platform_services.usage_reports.v4.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Plan model.
 */
public class PlanTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPlan() throws Throwable {
    Plan planModel = new Plan();
    assertNull(planModel.getPlanId());
    assertNull(planModel.getPlanName());
    assertNull(planModel.getPricingRegion());
    assertNull(planModel.isBillable());
    assertNull(planModel.getCost());
    assertNull(planModel.getRatedCost());
    assertNull(planModel.getUsage());
    assertNull(planModel.getDiscounts());
    assertNull(planModel.isPending());
  }
}