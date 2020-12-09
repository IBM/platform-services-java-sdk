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

package com.ibm.cloud.platform_services.global_search.v2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.cloud.platform_services.global_search.v2.model.GetSupportedTypesOptions;
import com.ibm.cloud.platform_services.global_search.v2.model.ScanResult;
import com.ibm.cloud.platform_services.global_search.v2.model.SearchOptions;
import com.ibm.cloud.platform_services.global_search.v2.model.SupportedTypesList;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;

// This file provides an example of how to use the Global Search service.
//
// The following configuration properties are assumed to be defined in the external configuration file:
// GLOBAL_SEARCH_URL=<service url>
// GLOBAL_SEARCH_AUTHTYPE=iam
// GLOBAL_SEARCH_APIKEY=<IAM api key>
// GLOBAL_SEARCH_AUTH_URL=<IAM token service URL - omit this if using the production environment>

public class GlobalSearchExamples {
  private static final Logger logger = LoggerFactory.getLogger(GlobalSearchExamples.class);
  protected GlobalSearchExamples() { }

  static {
      System.setProperty("IBM_CREDENTIALS_FILE", "../../global_search.env");
  }

  public static void main(String[] args) throws Exception {
    GlobalSearch service = GlobalSearch.newInstance();

    try {
      String searchCursor = null;

      // begin-search
      SearchOptions searchOptions = new SearchOptions.Builder()
        .query("GST-sdk-*")
        .fields(new java.util.ArrayList<String>(java.util.Arrays.asList("*")))
        .searchCursor(searchCursor)
        .build();

      Response<ScanResult> response = service.search(searchOptions).execute();
      ScanResult scanResult = response.getResult();

      System.out.println(scanResult);
      // end-search
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_supported_types
      GetSupportedTypesOptions getSupportedTypesOptions = new GetSupportedTypesOptions();

      Response<SupportedTypesList> response = service.getSupportedTypes(getSupportedTypesOptions).execute();
      SupportedTypesList supportedTypesList = response.getResult();

      System.out.println(supportedTypesList);
      // end-get_supported_types
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

  }
}
