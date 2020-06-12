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

import com.ibm.cloud.platform_services.catalog_management.v1.model.HelmRepoListChart;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Maintainers;
import com.ibm.cloud.platform_services.catalog_management.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the HelmRepoListChart model.
 */
public class HelmRepoListChartTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testHelmRepoListChart() throws Throwable {
    HelmRepoListChart helmRepoListChartModel = new HelmRepoListChart();
    assertNull(helmRepoListChartModel.getApiVersion());
    assertNull(helmRepoListChartModel.getCreated());
    assertNull(helmRepoListChartModel.getDescription());
    assertNull(helmRepoListChartModel.isDeprecated());
    assertNull(helmRepoListChartModel.getDigest());
    assertNull(helmRepoListChartModel.getHome());
    assertNull(helmRepoListChartModel.getIcon());
    assertNull(helmRepoListChartModel.getKeywords());
    assertNull(helmRepoListChartModel.getMaintainers());
    assertNull(helmRepoListChartModel.getName());
    assertNull(helmRepoListChartModel.getTillerVersion());
    assertNull(helmRepoListChartModel.getUrls());
    assertNull(helmRepoListChartModel.getSources());
    assertNull(helmRepoListChartModel.getVersion());
    assertNull(helmRepoListChartModel.getAppVersion());
  }
}