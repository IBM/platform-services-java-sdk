/*
 * (C) Copyright IBM Corp. 2021.
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

package com.ibm.cloud.platform_services.ibm_cloud_shell.v1;

import com.ibm.cloud.platform_services.ibm_cloud_shell.v1.model.AccountSettings;
import com.ibm.cloud.platform_services.ibm_cloud_shell.v1.model.Feature;
import com.ibm.cloud.platform_services.ibm_cloud_shell.v1.model.GetAccountSettingsOptions;
import com.ibm.cloud.platform_services.ibm_cloud_shell.v1.model.RegionSetting;
import com.ibm.cloud.platform_services.ibm_cloud_shell.v1.model.UpdateAccountSettingsOptions;
import com.ibm.cloud.platform_services.ibm_cloud_shell.v1.utils.TestUtilities;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Integration test class for the IbmCloudShell service.
 */
public class IbmCloudShellIT extends SdkIntegrationTestBase {
  public IbmCloudShell service = null;
  public static Map<String, String> config = null;
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  private static String ACCOUNT_ID;
  /**
   * This method provides our config filename to the base class.
   */

  public String getConfigFilename() {
    return "../../ibm_cloud_shell_v1.env";
  }

  @BeforeClass
  public void constructService() {
    // Ask super if we should skip the tests.
    if (skipTests()) {
      return;
    }

    service = IbmCloudShell.newInstance();
    assertNotNull(service);
    assertNotNull(service.getServiceUrl());

    // Load up our test-specific config properties.
    config = CredentialUtils.getServiceProperties(IbmCloudShell.DEFAULT_SERVICE_NAME);
    assertNotNull(config);
    assertFalse(config.isEmpty());
    assertEquals(service.getServiceUrl(), config.get("URL"));

    ACCOUNT_ID = config.get("ACCOUNT_ID");
    assertNotNull(ACCOUNT_ID);

    System.out.println("Setup complete.");
  }

  @Test
  public void testGetAccountSettings() throws Exception {
    try {
      GetAccountSettingsOptions getAccountSettingsOptions = new GetAccountSettingsOptions.Builder()
      .accountId(ACCOUNT_ID)
      .build();

      // Invoke operation
      Response<AccountSettings> response = service.getAccountSettings(getAccountSettingsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AccountSettings accountSettingsResult = response.getResult();

      assertNotNull(accountSettingsResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testUpdateAccountSettings() throws Exception {
    try {
      GetAccountSettingsOptions getAccountSettingsOptions = new GetAccountSettingsOptions.Builder()
      .accountId(ACCOUNT_ID)
      .build();
      Response<AccountSettings> getResponse = service.getAccountSettings(getAccountSettingsOptions).execute();
      assertEquals(getResponse.getStatusCode(), 200);
      AccountSettings existingAccountSettingsResult = getResponse.getResult();

      Feature fileManagerFeatureModel = new Feature.Builder()
      .enabled(false)
      .key("server.file_manager")
      .build();
      Feature webPreviewFeatureModel = new Feature.Builder()
      .enabled(true)
      .key("server.web_preview")
      .build();

      RegionSetting euRegionSettingModel = new RegionSetting.Builder()
      .enabled(true)
      .key("eu-de")
      .build();
      RegionSetting jpRegionSettingModel = new RegionSetting.Builder()
      .enabled(false)
      .key("jp-tok")
      .build();
      RegionSetting usRegionSettingModel = new RegionSetting.Builder()
      .enabled(false)
      .key("us-south")
      .build();

      UpdateAccountSettingsOptions updateAccountSettingsOptions = new UpdateAccountSettingsOptions.Builder()
      .accountId(ACCOUNT_ID)
      .rev(existingAccountSettingsResult.rev())
      .defaultEnableNewFeatures(false)
      .defaultEnableNewRegions(true)
      .enabled(true)
      .features(new java.util.ArrayList<Feature>(java.util.Arrays.asList(fileManagerFeatureModel, webPreviewFeatureModel)))
      .regions(new java.util.ArrayList<RegionSetting>(java.util.Arrays.asList(euRegionSettingModel, jpRegionSettingModel, usRegionSettingModel)))
      .build();

      // Invoke operation
      Response<AccountSettings> response = service.updateAccountSettings(updateAccountSettingsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AccountSettings accountSettingsResult = response.getResult();
      assertNotNull(accountSettingsResult);
      assertEquals(accountSettingsResult.defaultEnableNewFeatures().booleanValue(), false);
      assertEquals(accountSettingsResult.defaultEnableNewRegions().booleanValue(), true);
      assertEquals(accountSettingsResult.enabled().booleanValue(), true);
      assertEquals(accountSettingsResult.features(), new java.util.ArrayList<Feature>(java.util.Arrays.asList(fileManagerFeatureModel, webPreviewFeatureModel)));
      assertEquals(accountSettingsResult.regions(), new java.util.ArrayList<RegionSetting>(java.util.Arrays.asList(euRegionSettingModel, jpRegionSettingModel, usRegionSettingModel)));
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @AfterClass
  public void tearDown() {
    // Add any clean up logic here
    System.out.println("Clean up complete.");
  }
 }
