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

import com.ibm.cloud.platform_services.resource_controller.v2.model.Credentials;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceKey;
import com.ibm.cloud.platform_services.resource_controller.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ResourceKey model.
 */
public class ResourceKeyTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testResourceKey() throws Throwable {
    ResourceKey resourceKeyModel = new ResourceKey();
    assertNull(resourceKeyModel.getId());
    assertNull(resourceKeyModel.getGuid());
    assertNull(resourceKeyModel.getCrn());
    assertNull(resourceKeyModel.getUrl());
    assertNull(resourceKeyModel.getName());
    assertNull(resourceKeyModel.getAccountId());
    assertNull(resourceKeyModel.getResourceGroupId());
    assertNull(resourceKeyModel.getSourceCrn());
    assertNull(resourceKeyModel.getRole());
    assertNull(resourceKeyModel.getState());
    assertNull(resourceKeyModel.getCredentials());
    assertNull(resourceKeyModel.isIamCompatible());
    assertNull(resourceKeyModel.getResourceInstanceUrl());
    assertNull(resourceKeyModel.getCreatedAt());
    assertNull(resourceKeyModel.getUpdatedAt());
    assertNull(resourceKeyModel.getDeletedAt());
    assertNull(resourceKeyModel.getCreatedBy());
    assertNull(resourceKeyModel.getUpdatedBy());
    assertNull(resourceKeyModel.getDeletedBy());
  }
}