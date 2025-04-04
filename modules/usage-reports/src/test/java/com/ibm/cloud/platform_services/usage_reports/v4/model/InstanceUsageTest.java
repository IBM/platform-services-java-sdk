/*
 * (C) Copyright IBM Corp. 2025.
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
import com.ibm.cloud.platform_services.usage_reports.v4.model.InstanceUsage;
import com.ibm.cloud.platform_services.usage_reports.v4.model.Metric;
import com.ibm.cloud.platform_services.usage_reports.v4.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the InstanceUsage model.
 */
public class InstanceUsageTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testInstanceUsage() throws Throwable {
    InstanceUsage instanceUsageModel = new InstanceUsage();
    assertNull(instanceUsageModel.getAccountId());
    assertNull(instanceUsageModel.getResourceInstanceId());
    assertNull(instanceUsageModel.getResourceInstanceName());
    assertNull(instanceUsageModel.getResourceId());
    assertNull(instanceUsageModel.getCatalogId());
    assertNull(instanceUsageModel.getResourceName());
    assertNull(instanceUsageModel.getResourceGroupId());
    assertNull(instanceUsageModel.getResourceGroupName());
    assertNull(instanceUsageModel.getOrganizationId());
    assertNull(instanceUsageModel.getOrganizationName());
    assertNull(instanceUsageModel.getSpaceId());
    assertNull(instanceUsageModel.getSpaceName());
    assertNull(instanceUsageModel.getConsumerId());
    assertNull(instanceUsageModel.getRegion());
    assertNull(instanceUsageModel.getPricingRegion());
    assertNull(instanceUsageModel.getPricingCountry());
    assertNull(instanceUsageModel.getCurrencyCode());
    assertNull(instanceUsageModel.isBillable());
    assertNull(instanceUsageModel.getParentResourceInstanceId());
    assertNull(instanceUsageModel.getPlanId());
    assertNull(instanceUsageModel.getPlanName());
    assertNull(instanceUsageModel.getPricingPlanId());
    assertNull(instanceUsageModel.getSubscriptionId());
    assertNull(instanceUsageModel.getCreatedAt());
    assertNull(instanceUsageModel.getDeletedAt());
    assertNull(instanceUsageModel.getMonth());
    assertNull(instanceUsageModel.getUsage());
    assertNull(instanceUsageModel.isPending());
    assertNull(instanceUsageModel.getCurrencyRate());
    assertNull(instanceUsageModel.getTags());
    assertNull(instanceUsageModel.getServiceTags());
  }
}