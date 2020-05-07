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

package com.ibm.cloud.platform_services.global_catalog.v1.model;

import com.ibm.cloud.platform_services.global_catalog.v1.model.Amount;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Price;
import com.ibm.cloud.platform_services.global_catalog.v1.model.PricingSet;
import com.ibm.cloud.platform_services.global_catalog.v1.model.StartingPrice;
import com.ibm.cloud.platform_services.global_catalog.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PricingSet model.
 */
public class PricingSetTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPricingSet() throws Throwable {
    Price priceModel = new Price.Builder()
      .quantityTier(Long.valueOf("26"))
      .price(Double.valueOf("72.5"))
      .build();
    assertEquals(priceModel.quantityTier(), Long.valueOf("26"));
    assertEquals(priceModel.price(), Double.valueOf("72.5"));

    Amount amountModel = new Amount.Builder()
      .country("testString")
      .currency("testString")
      .prices(new ArrayList<Price>(Arrays.asList(priceModel)))
      .build();
    assertEquals(amountModel.country(), "testString");
    assertEquals(amountModel.currency(), "testString");
    assertEquals(amountModel.prices(), new ArrayList<Price>(Arrays.asList(priceModel)));

    StartingPrice startingPriceModel = new StartingPrice.Builder()
      .planId("testString")
      .deploymentId("testString")
      .unit("testString")
      .amount(new ArrayList<Amount>(Arrays.asList(amountModel)))
      .build();
    assertEquals(startingPriceModel.planId(), "testString");
    assertEquals(startingPriceModel.deploymentId(), "testString");
    assertEquals(startingPriceModel.unit(), "testString");
    assertEquals(startingPriceModel.amount(), new ArrayList<Amount>(Arrays.asList(amountModel)));

    PricingSet pricingSetModel = new PricingSet.Builder()
      .type("testString")
      .origin("testString")
      .startingPrice(startingPriceModel)
      .build();
    assertEquals(pricingSetModel.type(), "testString");
    assertEquals(pricingSetModel.origin(), "testString");
    assertEquals(pricingSetModel.startingPrice(), startingPriceModel);

    String json = TestUtilities.serialize(pricingSetModel);

    PricingSet pricingSetModelNew = TestUtilities.deserialize(json, PricingSet.class);
    assertTrue(pricingSetModelNew instanceof PricingSet);
    assertEquals(pricingSetModelNew.type(), "testString");
    assertEquals(pricingSetModelNew.origin(), "testString");
    assertEquals(pricingSetModelNew.startingPrice().toString(), startingPriceModel.toString());
  }
}