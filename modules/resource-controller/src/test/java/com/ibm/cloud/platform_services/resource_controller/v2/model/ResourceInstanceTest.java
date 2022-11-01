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

package com.ibm.cloud.platform_services.resource_controller.v2.model;

import com.ibm.cloud.platform_services.resource_controller.v2.model.PlanHistoryItem;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceInstance;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceInstanceLastOperation;
import com.ibm.cloud.platform_services.resource_controller.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ResourceInstance model.
 */
public class ResourceInstanceTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testResourceInstance() throws Throwable {
    ResourceInstance resourceInstanceModel = new ResourceInstance();
    assertNull(resourceInstanceModel.getId());
    assertNull(resourceInstanceModel.getGuid());
    assertNull(resourceInstanceModel.getUrl());
    assertNull(resourceInstanceModel.getCreatedAt());
    assertNull(resourceInstanceModel.getUpdatedAt());
    assertNull(resourceInstanceModel.getDeletedAt());
    assertNull(resourceInstanceModel.getCreatedBy());
    assertNull(resourceInstanceModel.getUpdatedBy());
    assertNull(resourceInstanceModel.getDeletedBy());
    assertNull(resourceInstanceModel.getScheduledReclaimAt());
    assertNull(resourceInstanceModel.getRestoredAt());
    assertNull(resourceInstanceModel.getRestoredBy());
    assertNull(resourceInstanceModel.getScheduledReclaimBy());
    assertNull(resourceInstanceModel.getName());
    assertNull(resourceInstanceModel.getRegionId());
    assertNull(resourceInstanceModel.getAccountId());
    assertNull(resourceInstanceModel.getResellerChannelId());
    assertNull(resourceInstanceModel.getResourcePlanId());
    assertNull(resourceInstanceModel.getResourceGroupId());
    assertNull(resourceInstanceModel.getResourceGroupCrn());
    assertNull(resourceInstanceModel.getTargetCrn());
    assertNull(resourceInstanceModel.getParameters());
    assertNull(resourceInstanceModel.isAllowCleanup());
    assertNull(resourceInstanceModel.getCrn());
    assertNull(resourceInstanceModel.getState());
    assertNull(resourceInstanceModel.getType());
    assertNull(resourceInstanceModel.getSubType());
    assertNull(resourceInstanceModel.getResourceId());
    assertNull(resourceInstanceModel.getDashboardUrl());
    assertNull(resourceInstanceModel.getLastOperation());
    assertNull(resourceInstanceModel.getResourceAliasesUrl());
    assertNull(resourceInstanceModel.getResourceBindingsUrl());
    assertNull(resourceInstanceModel.getResourceKeysUrl());
    assertNull(resourceInstanceModel.getPlanHistory());
    assertNull(resourceInstanceModel.isMigrated());
    assertNull(resourceInstanceModel.getExtensions());
    assertNull(resourceInstanceModel.getControlledBy());
    assertNull(resourceInstanceModel.isLocked());
  }
}