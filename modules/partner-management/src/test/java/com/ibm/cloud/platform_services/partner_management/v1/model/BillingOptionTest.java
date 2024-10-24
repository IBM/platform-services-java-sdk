/*
 * (C) Copyright IBM Corp. 2024.
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

package com.ibm.cloud.platform_services.partner_management.v1.model;

import com.ibm.cloud.platform_services.partner_management.v1.model.BillingOption;
import com.ibm.cloud.platform_services.partner_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the BillingOption model.
 */
public class BillingOptionTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testBillingOption() throws Throwable {
    BillingOption billingOptionModel = new BillingOption();
    assertNull(billingOptionModel.getId());
    assertNull(billingOptionModel.getBillingUnitId());
    assertNull(billingOptionModel.getCustomerId());
    assertNull(billingOptionModel.getCustomerType());
    assertNull(billingOptionModel.getCustomerName());
    assertNull(billingOptionModel.getResellerId());
    assertNull(billingOptionModel.getResellerName());
    assertNull(billingOptionModel.getMonth());
    assertNull(billingOptionModel.getErrors());
    assertNull(billingOptionModel.getType());
    assertNull(billingOptionModel.getStartDate());
    assertNull(billingOptionModel.getEndDate());
    assertNull(billingOptionModel.getState());
    assertNull(billingOptionModel.getCategory());
    assertNull(billingOptionModel.getPaymentInstrument());
    assertNull(billingOptionModel.getPartNumber());
    assertNull(billingOptionModel.getCatalogId());
    assertNull(billingOptionModel.getOrderId());
    assertNull(billingOptionModel.getPoNumber());
    assertNull(billingOptionModel.getSubscriptionModel());
    assertNull(billingOptionModel.getDurationInMonths());
    assertNull(billingOptionModel.getMonthlyAmount());
    assertNull(billingOptionModel.getBillingSystem());
    assertNull(billingOptionModel.getCountryCode());
    assertNull(billingOptionModel.getCurrencyCode());
  }
}