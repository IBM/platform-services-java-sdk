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
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//
// This file provides an example of how to use the IBM Cloud Shell service.
//
// The following configuration properties are assumed to be defined:
// IBM_CLOUD_SHELL_URL=<service base url>
// IBM_CLOUD_SHELL_AUTH_TYPE=iam
// IBM_CLOUD_SHELL_APIKEY=<IAM apikey>
// IBM_CLOUD_SHELL_AUTH_URL=<IAM token service base URL - omit this if using the production environment>
// IBM_CLOUD_SHELL_ACCOUNT_ID=<IBM Cloud account ID>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
public class IbmCloudShellExamples {
  private static final Logger logger = LoggerFactory.getLogger(IbmCloudShellExamples.class);
  protected IbmCloudShellExamples() { }

  private static String accountId;

  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    IbmCloudShell ibmCloudShellService = IbmCloudShell.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(IbmCloudShell.DEFAULT_SERVICE_NAME);

    accountId = config.get("accountId");

    try {
      System.out.println("getAccountSettings() result:");
      // begin-get_account_settings
      GetAccountSettingsOptions getAccountSettingsOptions = new GetAccountSettingsOptions.Builder()
        .accountId(accountId)
        .build();

      Response<AccountSettings> response = ibmCloudShellService.getAccountSettings(getAccountSettingsOptions).execute();
      AccountSettings accountSettings = response.getResult();

      System.out.println(accountSettings);
      // end-get_account_settings
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("updateAccountSettings() result:");
      // begin-update_account_settings
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
      .accountId(accountId)
      .rev(String.format("130-%s", accountId))
      .defaultEnableNewFeatures(false)
      .defaultEnableNewRegions(true)
      .enabled(true)
      .features(new java.util.ArrayList<Feature>(java.util.Arrays.asList(fileManagerFeatureModel, webPreviewFeatureModel)))
      .regions(new java.util.ArrayList<RegionSetting>(java.util.Arrays.asList(euRegionSettingModel, jpRegionSettingModel, usRegionSettingModel)))
      .build();

      Response<AccountSettings> response = ibmCloudShellService.updateAccountSettings(updateAccountSettingsOptions).execute();
      AccountSettings accountSettings = response.getResult();

      System.out.println(accountSettings);
      // end-update_account_settings
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

  }
}
