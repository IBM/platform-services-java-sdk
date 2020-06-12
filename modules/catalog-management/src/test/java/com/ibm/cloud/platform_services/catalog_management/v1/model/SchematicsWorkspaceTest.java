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

package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.ibm.cloud.platform_services.catalog_management.v1.model.SchematicsWorkspace;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SchematicsWorkspaceCatalogRef;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SchematicsWorkspaceRuntimeData;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SchematicsWorkspaceTemplateRepo;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SchematicsWorkspaceWorkspaceStatus;
import com.ibm.cloud.platform_services.catalog_management.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the SchematicsWorkspace model.
 */
public class SchematicsWorkspaceTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSchematicsWorkspace() throws Throwable {
    SchematicsWorkspace schematicsWorkspaceModel = new SchematicsWorkspace();
    assertNull(schematicsWorkspaceModel.getId());
    assertNull(schematicsWorkspaceModel.getName());
    assertNull(schematicsWorkspaceModel.getType());
    assertNull(schematicsWorkspaceModel.getDescription());
    assertNull(schematicsWorkspaceModel.getTags());
    assertNull(schematicsWorkspaceModel.getCreatedAt());
    assertNull(schematicsWorkspaceModel.getCreatedBy());
    assertNull(schematicsWorkspaceModel.getStatus());
    assertNull(schematicsWorkspaceModel.getWorkspaceStatus());
    assertNull(schematicsWorkspaceModel.getTemplateRef());
    assertNull(schematicsWorkspaceModel.getTemplateRepo());
    assertNull(schematicsWorkspaceModel.getTemplateData());
    assertNull(schematicsWorkspaceModel.getRuntimeData());
    assertNull(schematicsWorkspaceModel.getSharedData());
    assertNull(schematicsWorkspaceModel.getCatalogRef());
  }
}