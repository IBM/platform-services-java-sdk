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

package com.ibm.cloud.platform_services.context_based_restrictions.v1.model;

import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.EnterpriseResource;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.EnterpriseResourceID;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.EnterpriseTarget;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.Error;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ErrorContainer;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ErrorTarget;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ZoneAssignment;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ZoneAssignmentResource;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ZoneAssignmentTarget;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ZoneAssignmentZone;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ZoneAssignment model.
 */
public class ZoneAssignmentTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testZoneAssignment() throws Throwable {
    ZoneAssignment zoneAssignmentModel = new ZoneAssignment();
    assertNull(zoneAssignmentModel.getId());
    assertNull(zoneAssignmentModel.getCrn());
    assertNull(zoneAssignmentModel.getAccountId());
    assertNull(zoneAssignmentModel.getTarget());
    assertNull(zoneAssignmentModel.getZone());
    assertNull(zoneAssignmentModel.getStatus());
    assertNull(zoneAssignmentModel.getResources());
    assertNull(zoneAssignmentModel.getHref());
    assertNull(zoneAssignmentModel.getCreatedAt());
    assertNull(zoneAssignmentModel.getCreatedById());
    assertNull(zoneAssignmentModel.getLastModifiedAt());
    assertNull(zoneAssignmentModel.getLastModifiedById());
  }
}