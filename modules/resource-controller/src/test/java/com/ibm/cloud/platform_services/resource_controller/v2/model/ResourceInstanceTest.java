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

package com.ibm.cloud.platform_services.resource_controller.v2.model;

import com.ibm.cloud.platform_services.resource_controller.v2.model.PlanHistoryItem;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceInstance;
import com.ibm.cloud.platform_services.resource_controller.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
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
    assertNull(resourceInstanceModel.getCrn());
    assertNull(resourceInstanceModel.getUrl());
    assertNull(resourceInstanceModel.getName());
    assertNull(resourceInstanceModel.getAccountId());
    assertNull(resourceInstanceModel.getResourceGroupId());
    assertNull(resourceInstanceModel.getResourceGroupCrn());
    assertNull(resourceInstanceModel.getResourceId());
    assertNull(resourceInstanceModel.getResourcePlanId());
    assertNull(resourceInstanceModel.getTargetCrn());
    assertNull(resourceInstanceModel.getParameters());
    assertNull(resourceInstanceModel.getState());
    assertNull(resourceInstanceModel.getType());
    assertNull(resourceInstanceModel.getSubType());
    assertNull(resourceInstanceModel.isAllowCleanup());
    assertNull(resourceInstanceModel.isLocked());
    assertNull(resourceInstanceModel.getLastOperation());
    assertNull(resourceInstanceModel.getDashboardUrl());
    assertNull(resourceInstanceModel.getPlanHistory());
    assertNull(resourceInstanceModel.getResourceAliasesUrl());
    assertNull(resourceInstanceModel.getResourceBindingsUrl());
    assertNull(resourceInstanceModel.getResourceKeysUrl());
    assertNull(resourceInstanceModel.getCreatedAt());
    assertNull(resourceInstanceModel.getCreatedBy());
    assertNull(resourceInstanceModel.getUpdatedAt());
    assertNull(resourceInstanceModel.getUpdatedBy());
    assertNull(resourceInstanceModel.getDeletedAt());
    assertNull(resourceInstanceModel.getDeletedBy());
    assertNull(resourceInstanceModel.getScheduledReclaimAt());
    assertNull(resourceInstanceModel.getScheduledReclaimBy());
    assertNull(resourceInstanceModel.getRestoredAt());
    assertNull(resourceInstanceModel.getRestoredBy());
  }
}