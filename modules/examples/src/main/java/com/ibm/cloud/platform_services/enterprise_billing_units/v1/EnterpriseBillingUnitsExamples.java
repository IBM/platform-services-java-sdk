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

package com.ibm.cloud.platform_services.enterprise_billing_units.v1;

import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.BillingOptionsList;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.BillingUnit;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.BillingUnitsList;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.CreditPoolsList;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.GetBillingUnitOptions;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.GetCreditPoolsOptions;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.ListBillingOptionsOptions;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.ListBillingUnitsOptions;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnterpriseBillingUnitsExamples {
  private static final Logger logger = LoggerFactory.getLogger(EnterpriseBillingUnitsExamples.class);
  protected EnterpriseBillingUnitsExamples() { }

  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    EnterpriseBillingUnits service = EnterpriseBillingUnits.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(EnterpriseBillingUnits.DEFAULT_SERVICE_NAME);

    try {
      // begin-get_billing_unit
      GetBillingUnitOptions getBillingUnitOptions = new GetBillingUnitOptions.Builder()
        .billingUnitId("testString")
        .build();

      Response<BillingUnit> response = service.getBillingUnit(getBillingUnitOptions).execute();
      BillingUnit billingUnit = response.getResult();

      System.out.println(billingUnit);
      // end-get_billing_unit
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-list_billing_units
      ListBillingUnitsOptions listBillingUnitsOptions = new ListBillingUnitsOptions.Builder()
        .build();

      Response<BillingUnitsList> response = service.listBillingUnits(listBillingUnitsOptions).execute();
      BillingUnitsList billingUnitsList = response.getResult();

      System.out.println(billingUnitsList);
      // end-list_billing_units
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-list_billing_options
      ListBillingOptionsOptions listBillingOptionsOptions = new ListBillingOptionsOptions.Builder()
        .billingUnitId("testString")
        .build();

      Response<BillingOptionsList> response = service.listBillingOptions(listBillingOptionsOptions).execute();
      BillingOptionsList billingOptionsList = response.getResult();

      System.out.println(billingOptionsList);
      // end-list_billing_options
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_credit_pools
      GetCreditPoolsOptions getCreditPoolsOptions = new GetCreditPoolsOptions.Builder()
        .billingUnitId("testString")
        .build();

      Response<CreditPoolsList> response = service.getCreditPools(getCreditPoolsOptions).execute();
      CreditPoolsList creditPoolsList = response.getResult();

      System.out.println(creditPoolsList);
      // end-get_credit_pools
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

  }
}
