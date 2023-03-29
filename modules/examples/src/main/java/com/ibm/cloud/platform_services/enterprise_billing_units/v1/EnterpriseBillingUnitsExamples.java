/*
 * (C) Copyright IBM Corp. 2023.
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

package com.ibm.cloud.platform_services.enterprise_billing_units.v1;

import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.BillingOption;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.BillingOptionsPager;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.BillingUnit;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.BillingUnitsPager;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.CreditPoolsList;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.GetBillingUnitOptions;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.GetCreditPoolsOptions;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.ListBillingOptionsOptions;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.ListBillingUnitsOptions;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//
// This file provides an example of how to use the Enterprise Billing Units service.
//
// The following configuration properties are assumed to be defined:
//
// ENTERPRISE_BILLING_UNITS_URL=<service url>
// ENTERPRISE_BILLING_UNITS_AUTHTYPE=iam
// ENTERPRISE_BILLING_UNITS_APIKEY=<your iam apikey>
// ENTERPRISE_BILLING_UNITS_AUTH_URL=<IAM token service URL - omit this if using the production environment>
// ENTERPRISE_BILLING_UNITS_ENTERPRISE_ID=<id of enterprise to use for examples>
// ENTERPRISE_BILLING_UNITS_BILLING_UNIT_ID=<id of billing unit to use for examples>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
public class EnterpriseBillingUnitsExamples {
  private static final Logger logger = LoggerFactory.getLogger(EnterpriseBillingUnitsExamples.class);
  protected EnterpriseBillingUnitsExamples() { }

  private static String enterpriseId;
  private static String billingUnitId;

  static {
    System.setProperty("IBM_CREDENTIALS_FILE", "../../enterprise_billing_units.env");
  }

  /**
   * The main() function invokes operations of the Enterprise Billing Units service.
   * @param args command-line arguments
   * @throws Exception an error occurred
   */
  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    EnterpriseBillingUnits enterpriseBillingUnitsService = EnterpriseBillingUnits.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(EnterpriseBillingUnits.DEFAULT_SERVICE_NAME);
    enterpriseId = config.get("ENTERPRISE_ID");
    billingUnitId = config.get("BILLING_UNIT_ID");

    try {
      System.out.println("getBillingUnit() result:");
      // begin-get_billing_unit
      GetBillingUnitOptions getBillingUnitOptions = new GetBillingUnitOptions.Builder()
        .billingUnitId(billingUnitId)
        .build();

      Response<BillingUnit> response = enterpriseBillingUnitsService.getBillingUnit(getBillingUnitOptions).execute();
      BillingUnit billingUnit = response.getResult();

      System.out.println(billingUnit);
      // end-get_billing_unit
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listBillingUnits() result:");
      // begin-list_billing_units
      ListBillingUnitsOptions listBillingUnitsOptions = new ListBillingUnitsOptions.Builder()
        .enterpriseId(enterpriseId)
        .limit(Long.valueOf("10"))
        .build();

      BillingUnitsPager pager = new BillingUnitsPager(enterpriseBillingUnitsService, listBillingUnitsOptions);
      List<BillingUnit> allResults = new ArrayList<>();
      while (pager.hasNext()) {
        List<BillingUnit> nextPage = pager.getNext();
        allResults.addAll(nextPage);
      }

      System.out.println(GsonSingleton.getGson().toJson(allResults));
      // end-list_billing_units
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listBillingOptions() result:");
      // begin-list_billing_options
      ListBillingOptionsOptions listBillingOptionsOptions = new ListBillingOptionsOptions.Builder()
        .billingUnitId(billingUnitId)
        .limit(Long.valueOf("10"))
        .build();

      BillingOptionsPager pager = new BillingOptionsPager(enterpriseBillingUnitsService, listBillingOptionsOptions);
      List<BillingOption> allResults = new ArrayList<>();
      while (pager.hasNext()) {
        List<BillingOption> nextPage = pager.getNext();
        allResults.addAll(nextPage);
      }

      System.out.println(GsonSingleton.getGson().toJson(allResults));
      // end-list_billing_options
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getCreditPools() result:");

      // begin-get_credit_pools

      GetCreditPoolsOptions getCreditPoolsOptions = new GetCreditPoolsOptions.Builder()
        .billingUnitId(billingUnitId)
        .build();

      Response<CreditPoolsList> response = enterpriseBillingUnitsService.getCreditPools(getCreditPoolsOptions).execute();
      CreditPoolsList creditPoolsList = response.getResult();

      System.out.println(creditPoolsList);

      // end-get_credit_pools

    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

  }
}
